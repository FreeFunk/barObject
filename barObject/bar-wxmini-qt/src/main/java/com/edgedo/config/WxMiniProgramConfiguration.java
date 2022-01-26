package com.edgedo.config;

import com.edgedo.common.shiro.ShiroFilterWrap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class WxMiniProgramConfiguration {
   private Integer tokenTimeOutSec = 10;

   @Bean
   public ShiroFilterWrap wxShiroLoginFilterWrap() {
      ShiroFilterWrap wrap = new ShiroFilterWrap(new WxMiniProgramLoginFilter(this.tokenTimeOutSec));
      return wrap;
   }
}
