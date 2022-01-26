package com.edgedo.config;

import com.edgedo.common.base.json.BaseObjectMapper;
import com.edgedo.common.base.json.MappingJackson2JsonView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

@ConditionalOnProperty(
   value = {"app.springmvc.enable"},
   havingValue = "true",
   matchIfMissing = false
)
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
   public void configurePathMatch(PathMatchConfigurer configurer) {
      configurer.setUseRegisteredSuffixPatternMatch(true);
   }

   public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler(new String[]{"/index.html", "/login.html", "/views/**.html", "/layuiadmin/**.html", "/**.css", "/**.js", "/**.png", "/**.gif", "/**.ico", "/**.jpeg", "/**.jpg", "/**.json", "/**.txt", "/**.htm"}).addResourceLocations(new String[]{"classpath:/static/", "classpath:/public/"});
   }

   @Bean
   public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
      ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
      resolver.setContentNegotiationManager(this.contentNegotiationManagerFactoryBean().getObject());
      ArrayList<View> viewList = new ArrayList();
      MappingJackson2JsonView jackson2JsonView = new MappingJackson2JsonView();
      BaseObjectMapper bom = new BaseObjectMapper();
      bom.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
      jackson2JsonView.setObjectMapper(bom);
      viewList.add(jackson2JsonView);
      resolver.setDefaultViews(viewList);
      return resolver;
   }

   @Bean
   public ContentNegotiationManagerFactoryBean contentNegotiationManagerFactoryBean() {
      ContentNegotiationManagerFactoryBean bean = new ContentNegotiationManagerFactoryBean();
      bean.setIgnoreAcceptHeader(true);
      bean.setFavorPathExtension(true);
      bean.setFavorParameter(false);
      bean.setDefaultContentType(MediaType.TEXT_HTML);
      Map<String, MediaType> map = new HashMap();
      map.put("html", MediaType.TEXT_HTML);
      map.put("jsn", MediaType.APPLICATION_JSON);
      bean.addMediaTypes(map);
      return bean;
   }
}
