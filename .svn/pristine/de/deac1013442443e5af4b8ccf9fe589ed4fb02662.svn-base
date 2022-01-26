package com.edgedo.config;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.Constant;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.common.base.annotation.PassRealName;
import com.edgedo.common.util.IocUtil;
import com.edgedo.common.util.ObjectUtil;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
   @Autowired
   IocUtil iocUtil;
   @Value("${server.servlet.context-path}")
   String contextPath;

   public void run(String... args) throws Exception {
      if (this.contextPath == null || this.contextPath.equals("${server.servlet.context-path}")) {
         this.contextPath = "";
      }

      IocUtil var10000 = this.iocUtil;
      Collection<BaseController> controllers = IocUtil.getBeansOfType(BaseController.class);
      Set<String> urlAndMethodPassSet = new HashSet();
      Set<String> urlAndMethodPassRealNameSet = new HashSet();
      Iterator var5 = controllers.iterator();

      while(var5.hasNext()) {
         BaseController contrl = (BaseController)var5.next();
         Class<?> clazz = contrl.getClass();
         String baseUrl = "";
         String[] classUrl = new String[0];
         if (!ObjectUtil.isEmpty((Object)clazz.getAnnotation(RequestMapping.class))) {
            classUrl = ((RequestMapping)clazz.getAnnotation(RequestMapping.class)).value();
         }

         Method[] methods = clazz.getMethods();
         Method[] var11 = methods;
         int var12 = methods.length;

         for(int var13 = 0; var13 < var12; ++var13) {
            Method method = var11[var13];
            boolean passFlag = false;
            boolean passRealNameFalg = false;
            if ((passFlag = method.isAnnotationPresent(Pass.class)) || (passRealNameFalg = method.isAnnotationPresent(PassRealName.class))) {
               String[] methodUrl = null;
               StringBuilder sb = new StringBuilder();
               if (!ObjectUtil.isEmpty((Object)method.getAnnotation(PostMapping.class))) {
                  methodUrl = ((PostMapping)method.getAnnotation(PostMapping.class)).value();
                  if (ObjectUtil.isEmpty((Object)methodUrl)) {
                     methodUrl = ((PostMapping)method.getAnnotation(PostMapping.class)).path();
                  }

                  baseUrl = this.getRequestUrl(classUrl, methodUrl, sb, "POST");
               } else if (!ObjectUtil.isEmpty((Object)method.getAnnotation(GetMapping.class))) {
                  methodUrl = ((GetMapping)method.getAnnotation(GetMapping.class)).value();
                  if (ObjectUtil.isEmpty((Object)methodUrl)) {
                     methodUrl = ((GetMapping)method.getAnnotation(GetMapping.class)).path();
                  }

                  baseUrl = this.getRequestUrl(classUrl, methodUrl, sb, "GET");
               } else if (!ObjectUtil.isEmpty((Object)method.getAnnotation(DeleteMapping.class))) {
                  methodUrl = ((DeleteMapping)method.getAnnotation(DeleteMapping.class)).value();
                  if (ObjectUtil.isEmpty((Object)methodUrl)) {
                     methodUrl = ((DeleteMapping)method.getAnnotation(DeleteMapping.class)).path();
                  }

                  baseUrl = this.getRequestUrl(classUrl, methodUrl, sb, "DELETE");
               } else if (!ObjectUtil.isEmpty((Object)method.getAnnotation(PutMapping.class))) {
                  methodUrl = ((PutMapping)method.getAnnotation(PutMapping.class)).value();
                  if (ObjectUtil.isEmpty((Object)methodUrl)) {
                     methodUrl = ((PutMapping)method.getAnnotation(PutMapping.class)).path();
                  }

                  baseUrl = this.getRequestUrl(classUrl, methodUrl, sb, "PUT");
               } else {
                  methodUrl = ((RequestMapping)method.getAnnotation(RequestMapping.class)).value();
                  baseUrl = this.getRequestUrl(classUrl, methodUrl, sb, RequestMapping.class.getSimpleName());
               }

               if (!ObjectUtil.isEmpty(baseUrl)) {
                  baseUrl = this.contextPath + "/" + baseUrl;
                  baseUrl = baseUrl.replaceAll("/+", "/");
                  if (passFlag) {
                     urlAndMethodPassSet.add(baseUrl);
                  }

                  if (passRealNameFalg) {
                     urlAndMethodPassRealNameSet.add(baseUrl);
                  }
               }
            }
         }
      }

      Constant.METHOD_URL_SET = urlAndMethodPassSet;
      Constant.METHOD_URL_SET_REAL_NAME = urlAndMethodPassRealNameSet;
   }

   private String getRequestUrl(String[] classUrl, String[] methodUrl, StringBuilder sb, String requestName) {
      String[] var5;
      int var6;
      int var7;
      String url;
      if (!ObjectUtil.isEmpty((Object)classUrl)) {
         var5 = classUrl;
         var6 = classUrl.length;

         for(var7 = 0; var7 < var6; ++var7) {
            url = var5[var7];
            sb.append(url + "/");
         }
      }

      var5 = methodUrl;
      var6 = methodUrl.length;

      for(var7 = 0; var7 < var6; ++var7) {
         url = var5[var7];
         sb.append(url);
      }

      if (sb.toString().endsWith("/")) {
         sb.deleteCharAt(sb.length() - 1);
      }

      return sb.toString().replaceAll("/+", "/");
   }
}
