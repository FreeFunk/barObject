package com.edgedo.common.util;

import java.util.Collection;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class IocUtil implements ApplicationContextAware {
   private static ApplicationContext applicationContext;

   public static Object getBean(String id) {
      return applicationContext.getBean(id);
   }

   public static <T> T getBean(Class<T> t) {
      return applicationContext.getBean(t);
   }

   public static <T> Collection<T> getBeansOfType(Class<T> t) {
      Map<String, T> map = applicationContext.getBeansOfType(t);
      return map.values();
   }

   public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      IocUtil.applicationContext = applicationContext;
   }
}
