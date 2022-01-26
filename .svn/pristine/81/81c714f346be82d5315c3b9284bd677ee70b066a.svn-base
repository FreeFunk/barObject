package com.edgedo.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(
   value = {"app.threadpool.threadNum"},
   matchIfMissing = false
)
class ThreadTaskConfiguration {
   @Value("${app.threadpool.threadNum}")
   private int threadNum;

   @Bean
   public ThreadTaskUtil theadTaskUtilBean() {
      ThreadTaskUtil task = new ThreadTaskUtil(this.threadNum);
      return task;
   }
}
