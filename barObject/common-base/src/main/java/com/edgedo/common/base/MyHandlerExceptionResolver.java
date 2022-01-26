package com.edgedo.common.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
   public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
      String errMsg = null;
      String errCode = null;
      if (ex instanceof BusinessException) {
         BusinessException be = (BusinessException)ex;
         errMsg = ex.getMessage();
         errCode = be.getErrCode();
      } else {
         errMsg = "后台异常!";
         ex.printStackTrace();
      }

      ModelAndView modelAndView = new ModelAndView();
      modelAndView.addObject("success", false);
      modelAndView.addObject("errMsg", errMsg);
      modelAndView.addObject("code", "-1");
      modelAndView.addObject("errCode", errCode);
      modelAndView.addObject("errType", errCode);
      return modelAndView;
   }
}
