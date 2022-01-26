package com.edgedo.common.shiro;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.common.base.Constant;
import com.edgedo.common.base.SuccessObj;
import java.io.PrintWriter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edgedo.common.util.JWTUtil;
import com.edgedo.common.util.ObjectUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

public class ShiroFilter extends BasicHttpAuthenticationFilter {
   @Override
   protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
      String authorization = getAccessToken(request);
      return authorization == null;
   }

   public static String getAccessToken(ServletRequest request) {
      HttpServletRequest req = (HttpServletRequest)request;
      String authorization = req.getHeader("access-token");
      if (authorization == null) {
         Cookie[] cookies = req.getCookies();
         if (cookies != null) {
            Cookie[] var4 = cookies;
            int var5 = cookies.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               Cookie cookie = var4[var6];
               String name = cookie.getName();
               if (name.equals("access-token")) {
                  authorization = cookie.getValue();
               }
            }
         }
      }

      if (authorization == null) {
         authorization = request.getParameter("access-token");
      }

      return authorization;
   }

   public boolean isWx(ServletRequest request) {
      HttpServletRequest req = (HttpServletRequest)request;
      String userAgent = req.getHeader("user-agent").toLowerCase();
      boolean flag = false;
      if (userAgent.indexOf("micromessenger") > -1) {
         flag = true;
         request.setAttribute("isWx", "1");
      } else {
         request.setAttribute("isWx", "0");
      }

      return flag;
   }

   @Override
   protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
      return true;
   }

   public boolean verificationPassAnnotation(ServletRequest request, ServletResponse response, HttpServletRequest httpServletRequest, String authorization) throws Exception {
      String requestUri = httpServletRequest.getRequestURI();
      String[] uriArr = requestUri.split("\\.");
      String realUri = uriArr[0];
      realUri = realUri.replaceAll("//", "/");
      if (Constant.METHOD_URL_SET.contains(realUri)){
         return true;
      }
      return false;
   }

   public boolean verificationPassRealNameAnnotation(ServletRequest request, ServletResponse response, HttpServletRequest httpServletRequest, String authorization) throws Exception {
      String requestUri = httpServletRequest.getRequestURI();
      String[] uriArr = requestUri.split("\\.");
      String realUri = uriArr[0];
      realUri = realUri.replaceAll("//", "/");
      return Constant.METHOD_URL_SET.contains(realUri) || Constant.METHOD_URL_SET_REAL_NAME.contains(realUri);
   }

   protected boolean isSameUrl(String localUrl, String requestUrl) {
      String[] tempLocalUrls = localUrl.split("/");
      String[] tempRequestUrls = requestUrl.split("/");
      if (tempLocalUrls.length != tempRequestUrls.length) {
         return false;
      } else {
         StringBuilder sbLocalUrl = new StringBuilder();
         StringBuilder sbRequestUrl = new StringBuilder();

         for(int i = 0; i < tempLocalUrls.length; ++i) {
            if (StringUtils.countMatches(tempLocalUrls[i], "{") > 0) {
               tempLocalUrls[i] = "*";
               tempRequestUrls[i] = "*";
            }

            sbLocalUrl.append(tempLocalUrls[i] + "/");
            sbRequestUrl.append(tempRequestUrls[i] + "/");
         }

         return sbLocalUrl.toString().trim().equals(sbRequestUrl.toString().trim());
      }
   }

   protected void responseError(ServletRequest request, ServletResponse response) {
      PrintWriter out = null;

      try {
         Cookie cookie = new Cookie("access-token", "");
         cookie.setMaxAge(0);
         HttpServletResponse rep = (HttpServletResponse)response;
         rep.addCookie(cookie);
         response.setCharacterEncoding("utf-8");
         out = response.getWriter();
         response.setContentType("application/json; charset=utf-8");
         SuccessObj notLoginResponse = new SuccessObj();
         notLoginResponse.setSuccess(false);
         notLoginResponse.setErrMsg("用户未登录");
         notLoginResponse.setErrType("not_login");
         notLoginResponse.setCode(1001);
         out.print(JSONObject.toJSONString(notLoginResponse));
         out.flush();
      } catch (Exception var10) {
         var10.printStackTrace();
      } finally {
         if (out != null) {
            out.close();
         }

      }

   }

   @Override
   protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
      HttpServletRequest httpServletRequest = (HttpServletRequest) request;
      HttpServletResponse httpServletResponse = (HttpServletResponse) response;
      httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
      httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
      httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
      httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
      // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
      if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
         httpServletResponse.setStatus(HttpStatus.OK.value());
         return false;
      }
      String requestUri = httpServletRequest.getRequestURI();
      //如果请求的数据没有扩展名那么就返回index
      if(!(requestUri.endsWith(".jsn") || requestUri.endsWith(".do")|| requestUri.endsWith(".action"))){
         ((HttpServletResponse) response).sendRedirect("/login.html");
         return false;
      }
      String authorization = httpServletRequest.getHeader("access-token");
      if (verificationPassAnnotation(request, response, httpServletRequest, authorization)){
         return true;
      }
      if(ObjectUtil.isEmpty(authorization)){
         responseError(request, response);
         return false;
      }
      //看看是否能解析出来合法的用户
      boolean flag = JWTUtil.verify(httpServletRequest);
      if(flag){
         super.preHandle(request, response);
         return true;
      }else{
         responseError(request, response);
         return false;
      }
   }

   protected void responseRealNameError(ServletRequest request, ServletResponse response) {
      PrintWriter out = null;

      try {
         Cookie cookie = new Cookie("access-token", "");
         cookie.setMaxAge(0);
         HttpServletResponse rep = (HttpServletResponse)response;
         rep.addCookie(cookie);
         response.setCharacterEncoding("utf-8");
         out = response.getWriter();
         response.setContentType("application/json; charset=utf-8");
         SuccessObj notLoginResponse = new SuccessObj();
         notLoginResponse.setSuccess(false);
         notLoginResponse.setErrMsg("用户未实名认证");
         notLoginResponse.setErrType("not_realname");
         notLoginResponse.setCode(1002);
         out.print(JSONObject.toJSONString(notLoginResponse));
         out.flush();
      } catch (Exception var10) {
         var10.printStackTrace();
      } finally {
         if (out != null) {
            out.close();
         }

      }

   }
}
