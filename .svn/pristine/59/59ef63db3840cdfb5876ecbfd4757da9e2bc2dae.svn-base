package com.edgedo.common.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

public class FreemarkerUtil {
   public static void framemarkerGen(String templateRealPath, String targetRealPath, Map<String, Object> data) {
      BufferedWriter out = null;

      try {
         int namSepratorLength = templateRealPath.lastIndexOf(File.separator);
         String templateForder = templateRealPath.substring(0, namSepratorLength);
         String ftllFileName = templateRealPath.substring(namSepratorLength);
         Configuration configuration = new Configuration();
         configuration.setDefaultEncoding("utf-8");
         configuration.setClassicCompatible(true);
         configuration.setDirectoryForTemplateLoading(new File(templateForder));
         Template temp = configuration.getTemplate(ftllFileName);
         File target = new File(targetRealPath);
         if (!target.getParentFile().exists()) {
            target.getParentFile().mkdirs();
         }

         out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target), "utf-8"));
         temp.process(data, out);
      } catch (Exception var18) {
         var18.printStackTrace();
      } finally {
         try {
            out.flush();
            out.close();
         } catch (IOException var17) {
            var17.printStackTrace();
         }

      }

   }

   public static void framemarkerGen(String templateRealPath, Map<String, Object> data, OutputStream outputStream) {
      BufferedWriter out = null;

      try {
         int namSepratorLength = templateRealPath.lastIndexOf(File.separator);
         String templateForder = templateRealPath.substring(0, namSepratorLength);
         String ftllFileName = templateRealPath.substring(namSepratorLength);
         Configuration configuration = new Configuration();
         configuration.setDefaultEncoding("utf-8");
         configuration.setClassicCompatible(true);
         configuration.setDirectoryForTemplateLoading(new File(templateForder));
         Template temp = configuration.getTemplate(ftllFileName);
         out = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"));
         temp.process(data, out);
      } catch (Exception var17) {
         var17.printStackTrace();
      } finally {
         try {
            out.flush();
            out.close();
         } catch (IOException var16) {
            var16.printStackTrace();
         }

      }

   }
}
