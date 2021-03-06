package com.edgedo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class PropertySourcesPlaceholderConfiguration {
   @Bean
   public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
      PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
      c.setIgnoreUnresolvablePlaceholders(true);
      return c;
   }
}
