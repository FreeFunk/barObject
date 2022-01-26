package com.edgedo.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HtmlToPdfUtil {
   String toPdfTool = "/server/wkhtmltopdf/bin/wkhtmltopdf";

   public HtmlToPdfUtil(String toPdfTool) {
      this.toPdfTool = toPdfTool;
   }

   public HtmlToPdfUtil() {
   }

   public void convert(String srcPath, String destPath, HtmlToPdfUtil.ExportSuccessInterface callBack) {
      try {
         File file = new File(destPath);
         File parent = file.getParentFile();
         if (!parent.exists()) {
            parent.mkdirs();
         }

         StringBuilder cmd = new StringBuilder();
         cmd.append(this.toPdfTool);
         cmd.append(" ");
         cmd.append("  --header-line");
         cmd.append("  --header-center 这里是页眉这里是页眉这里是页眉这里是页眉 ");
         cmd.append(" --header-spacing 10 ");
         cmd.append(srcPath);
         cmd.append(" ");
         cmd.append(destPath);
         Process proc = Runtime.getRuntime().exec(cmd.toString());
         HtmlToPdfUtil.HtmlToPdfInterceptor error = new HtmlToPdfUtil.HtmlToPdfInterceptor(proc.getErrorStream(), callBack);
         error.start();
         proc.waitFor();
      } catch (Exception var9) {
         var9.printStackTrace();
      }

   }

   public String getToPdfTool() {
      return this.toPdfTool;
   }

   public void setToPdfTool(String toPdfTool) {
      this.toPdfTool = toPdfTool;
   }

   public interface ExportSuccessInterface {
      void callback(String state);
   }

   public static class HtmlToPdfInterceptor extends Thread {
      private InputStream is;
      HtmlToPdfUtil.ExportSuccessInterface callBack;
      String descPath;

      public HtmlToPdfInterceptor(InputStream is, HtmlToPdfUtil.ExportSuccessInterface callBack) {
         this.is = is;
         this.descPath = this.descPath;
         this.callBack = callBack;
      }

      public void run() {
         try {
            InputStreamReader isr = new InputStreamReader(this.is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            boolean flag = false;

            while((line = br.readLine()) != null) {
               if (line.toString().toLowerCase().contains("done")) {
                  flag = true;
                  break;
               }
            }

            if (flag) {
               this.callBack.callback("success");
            } else {
               this.callBack.callback("fail");
            }
         } catch (IOException var5) {
            var5.printStackTrace();
         }

      }
   }
}
