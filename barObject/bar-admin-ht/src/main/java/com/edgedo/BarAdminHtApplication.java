package com.edgedo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@ComponentScan("com.edgedo")
@EnableScheduling
@EnableCaching
public class BarAdminHtApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarAdminHtApplication.class, args);
	}

/*	@Bean
	public RestTemplate restTemplate(){
		return  new RestTemplate();
	}*/


}
