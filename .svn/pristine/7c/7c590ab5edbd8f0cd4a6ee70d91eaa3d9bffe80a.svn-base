package com.edgedo.config;

import com.edgedo.common.base.BusinessException;
import com.edgedo.common.shiro.ShiroFilter;
import com.edgedo.common.shiro.ShiroFilterWrap;
import com.edgedo.common.util.IocUtil;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.Filter;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty(
   value = {"app.shiro.enable"},
   havingValue = "true",
   matchIfMissing = false
)
@Configuration
public class ShiroConfig {
   @Autowired
   IocUtil iocUtil;
   @Value("${app.shiro.loginFilter}")
   String loginFilter;

   @Bean
   public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
      return new LifecycleBeanPostProcessor();
   }

   @Bean
   public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
      DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
      defaultAdvisorAutoProxyCreator.setUsePrefix(true);
      return defaultAdvisorAutoProxyCreator;
   }

   @Bean({"securityManager"})
   public DefaultWebSecurityManager getManager() {
      DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
      manager.setRealm(new SimpleAccountRealm());
      DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
      DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
      defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
      subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
      manager.setSubjectDAO(subjectDAO);
      return manager;
   }

   @Bean({"shiroFilter"})
   public ShiroFilterFactoryBean factory(DefaultWebSecurityManager securityManager) {
      ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
      Map<String, String> filterRuleMap = new LinkedHashMap(2);
      filterRuleMap.put("/login.html", "anon");
      filterRuleMap.put("/index.html", "anon");
      filterRuleMap.put("/index.html", "anon");
      filterRuleMap.put("/favicon.ico", "anon");
      filterRuleMap.put("/layuiadmin/**", "anon");
      filterRuleMap.put("/views/**", "anon");
      filterRuleMap.put("/swagger-ui.html", "anon");
      filterRuleMap.put("/swagger-resources", "anon");
      filterRuleMap.put("/v2/api-docs", "anon");
      filterRuleMap.put("/webjars/springfox-swagger-ui/**", "anon");
      filterRuleMap.put("/swagger-resources/**", "anon");
      Map<String, Filter> filterMap = new HashMap();
      IocUtil var10000 = this.iocUtil;
      Collection<ShiroFilterWrap> filterWrapCol = IocUtil.getBeansOfType(ShiroFilterWrap.class);
      List<ShiroFilterWrap> filterWrapList = new ArrayList();
      filterWrapCol.forEach((filterWrap) -> {
         filterWrapList.add(filterWrap);
      });
      Collections.sort(filterWrapList, (o1, o2) -> {
         int od1 = o1.getOrder();
         int od2 = o2.getOrder();
         return od1 - od2;
      });
      Set<String> filterClsNameSet = new HashSet();
      filterWrapList.forEach((filterWrap) -> {
         ShiroFilter filterObj = filterWrap.getShiroFilter();
         String clsName = filterObj.getClass().getName();
         filterClsNameSet.add(clsName);
         String clsNameTemp = filterObj.getClass().getSimpleName();
         filterMap.put(clsNameTemp, filterObj);
         filterRuleMap.put("/**", clsNameTemp);
      });
      if ((this.loginFilter != null || this.loginFilter.length() > 0) && !this.loginFilter.equals("${app.shiro.loginFilter}")) {
         String[] filters = this.loginFilter.split(",");
         String[] var9 = filters;
         int var10 = filters.length;

         for(int var11 = 0; var11 < var10; ++var11) {
            String filterClass = var9[var11];

            try {
               if (!filterClsNameSet.contains(filterClass)) {
                  Class clazz = Class.forName(filterClass);
                  String clsNameTemp = clazz.getSimpleName();
                  Constructor con = clazz.getDeclaredConstructor();
                  ShiroFilter filterObj = (ShiroFilter)con.newInstance();
                  filterMap.put(clsNameTemp, filterObj);
                  filterRuleMap.put("/**", clsNameTemp);
               }
            } catch (Exception var17) {
               throw new BusinessException(var17);
            }
         }
      }

      factoryBean.setFilters(filterMap);
      factoryBean.setSecurityManager(securityManager);
      factoryBean.setFilterChainDefinitionMap(filterRuleMap);
      return factoryBean;
   }

   @Bean
   public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
      AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
      advisor.setSecurityManager(securityManager);
      return advisor;
   }
}
