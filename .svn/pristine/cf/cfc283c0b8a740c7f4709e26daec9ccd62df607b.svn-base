package com.edgedo.config;

import com.edgedo.common.shiro.ShiroFilter;
import com.edgedo.common.util.ObjectUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WxMiniProgramLoginFilter extends ShiroFilter {
   private static final String third_party_token_prefix = "tpt_";
   int tokenTimeOutSec = 1800;

   public WxMiniProgramLoginFilter(int tokenTimeOutSec) {
   }

   @Override
   protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
      if (isLoginAttempt(request, response)){
         return false;
      }
      return true;
   }

   @Override
   protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
      HttpServletRequest httpServletRequest = (HttpServletRequest)request;
      HttpServletResponse httpServletResponse = (HttpServletResponse)response;
      httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
      httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
      httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
      httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
      if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
         httpServletResponse.setStatus(HttpStatus.OK.value());
         return false;
      } else {
         String requestUri = httpServletRequest.getRequestURI();
         if (!requestUri.endsWith(".jsn") && !requestUri.endsWith(".do") && !requestUri.endsWith(".action")) {
            return false;
         } else {
            String accessToken = getAccessToken(request);
            if (this.verificationPassAnnotation(request, response, httpServletRequest, accessToken)) {
               return true;
            } else if (ObjectUtil.isEmpty(accessToken)) {
               this.responseError(request, response);
               return false;
            } else {
               request.setAttribute("wx_mini_login_open_id", accessToken);
               return true;
            }
         }
      }
   }
}
