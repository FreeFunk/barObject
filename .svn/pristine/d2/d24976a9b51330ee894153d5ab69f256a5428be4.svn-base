package com.edgedo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.baomidou.mybatisplus.spring.boot.starter.SpringBootVFS;
import com.edgedo.common.base.PagePlugin;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@ConditionalOnProperty(
   value = {"app.mybatis.enable"},
   havingValue = "true",
   matchIfMissing = false
)
@Configuration
@EnableConfigurationProperties({MybatisProperties.class})
public class MybatisPlusConfig {
   @Autowired
   private Environment environment;
   @Autowired
   private DataSource dataSource;
   @Autowired
   private MybatisProperties properties;
   @Autowired
   private ResourceLoader resourceLoader = new DefaultResourceLoader();
   @Autowired(
      required = false
   )
   private Interceptor[] interceptors;
   @Autowired(
      required = false
   )
   private DatabaseIdProvider databaseIdProvider;

   @Bean
   public PerformanceInterceptor performanceInterceptor() {
      PerformanceInterceptor pi = new PerformanceInterceptor();
      pi.setWriteInLog(true);
      return pi;
   }

   @Bean
   public DataSource druidDataSource() throws SQLException {
      System.out.println("====================注入druid!====================");
      DruidDataSource datasource = new DruidDataSource();
      datasource.setUrl(this.environment.getProperty("spring.datasource.url"));
      datasource.setDriverClassName(this.environment.getProperty("spring.datasource.driver-class-name"));
      datasource.setUsername(this.environment.getProperty("spring.datasource.username"));
      datasource.setPassword(this.environment.getProperty("spring.datasource.password"));

      try {
         datasource.setInitialSize(Integer.valueOf(this.environment.getProperty("spring.datasource.tomcat.initial-size")));
      } catch (Exception var8) {
      }

      try {
         datasource.setMinIdle(Integer.valueOf(this.environment.getProperty("spring.datasource.tomcat.min-idle")));
      } catch (Exception var7) {
      }

      try {
         datasource.setMaxWait(Long.valueOf(this.environment.getProperty("spring.datasource.tomcat.max-wait")));
      } catch (Exception var6) {
      }

      try {
         datasource.setMaxActive(Integer.valueOf(this.environment.getProperty("spring.datasource.tomcat.max-active")));
      } catch (Exception var5) {
      }

      try {
         datasource.setMinEvictableIdleTimeMillis(Long.valueOf(this.environment.getProperty("spring.datasource.tomcat.min-evictable-idle-time-millis")));
      } catch (Exception var4) {
      }

      try {
         datasource.setFilters(this.environment.getProperty("filters"));
      } catch (SQLException var3) {
         var3.printStackTrace();
      }

      return datasource;
   }

   @Bean
   public PagePlugin paginationInterceptor() {
      PagePlugin page = new PagePlugin();
      page.setDialect("mysql");
      page.setPageSqlId(".*istPage.*");
      return page;
   }

   @Bean
   public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean() {
      MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
      mybatisPlus.setDataSource(this.dataSource);
      mybatisPlus.setVfs(SpringBootVFS.class);
      if (StringUtils.hasText(this.properties.getConfigLocation())) {
         mybatisPlus.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
      }

      mybatisPlus.setConfiguration(this.properties.getConfiguration());
      if (!ObjectUtils.isEmpty(this.interceptors)) {
         mybatisPlus.setPlugins(this.interceptors);
      }

      GlobalConfiguration globalConfig = new GlobalConfiguration();
      globalConfig.setDbType(DBType.MYSQL.name());
      globalConfig.setIdType(2);
      mybatisPlus.setGlobalConfig(globalConfig);
      MybatisConfiguration mc = new MybatisConfiguration();
      mc.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
      mybatisPlus.setConfiguration(mc);
      if (this.databaseIdProvider != null) {
         mybatisPlus.setDatabaseIdProvider(this.databaseIdProvider);
      }

      if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
         mybatisPlus.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
      }

      if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
         mybatisPlus.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
      }

      if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
         mybatisPlus.setMapperLocations(this.properties.resolveMapperLocations());
      }

      return mybatisPlus;
   }

   @Bean
   public ServletRegistrationBean DruidStatViewServle() {
      ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), new String[]{"/druid/*"});
      servletRegistrationBean.addInitParameter("loginUsername", "root");
      servletRegistrationBean.addInitParameter("loginPassword", "root");
      servletRegistrationBean.addInitParameter("resetEnable", "false");
      return servletRegistrationBean;
   }

   @Bean
   public FilterRegistrationBean druidStatFilter() {
      FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter(), new ServletRegistrationBean[0]);
      filterRegistrationBean.addUrlPatterns(new String[]{"/*"});
      filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
      return filterRegistrationBean;
   }
}
