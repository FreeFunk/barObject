package com.edgedo.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.jasypt.commons.CommonUtils;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class SysStringEncryptor implements StringEncryptor {
   private StandardPBEStringEncryptor pbeEncryptor = new StandardPBEStringEncryptor();

   public SysStringEncryptor(String pwd) {
      this.pbeEncryptor.setPassword(pwd);
   }

   public SysStringEncryptor() {
      this.pbeEncryptor.setPassword("chuheridangwuhandihexiatu");
   }

   public String decrypt(String string) {
      String retStr = this.swapChar("1F8B" + string, 20);
      byte[] strBytes = CommonUtils.fromHexadecimal(retStr);

      try {
         ByteArrayInputStream bis = new ByteArrayInputStream(strBytes);
         ByteArrayOutputStream bos = new ByteArrayOutputStream();
         GZIPInputStream is = new GZIPInputStream(bis);
         byte[] buffer = new byte[500];
         boolean var8 = false;

         while(true) {
            int c;
            if ((c = is.read(buffer)) == -1) {
               byte[] retBytes = bos.toByteArray();
               is.close();
               retStr = new String(retBytes, "UTF-8");
               break;
            }

            bos.write(buffer, 0, c);
         }
      } catch (IOException var10) {
         var10.printStackTrace();
         throw new RuntimeException(var10);
      }

      retStr = this.swapChar(retStr, 0);
      return this.pbeEncryptor.decrypt(retStr);
   }

   public String encrypt(String string) {
      String retStr = this.pbeEncryptor.encrypt(string);
      retStr = this.swapChar(retStr, 0);
      ByteArrayOutputStream bos = new ByteArrayOutputStream();

      byte[] retBytes;
      try {
         GZIPOutputStream os = new GZIPOutputStream(bos);
         os.write(retStr.getBytes("UTF-8"));
         os.close();
         retBytes = bos.toByteArray();
      } catch (IOException var6) {
         var6.printStackTrace();
         throw new RuntimeException(var6);
      }

      retStr = CommonUtils.toHexadecimal(retBytes);
      retStr = this.swapChar(retStr, 20);
      return retStr.substring(4);
   }

   public String swapChar(String string, int start) {
      StringBuilder retStr = new StringBuilder();
      int strLength = string.length();

      for(int i = 0; i < strLength; ++i) {
         char ch = string.charAt(i);
         if (i >= start) {
            ++i;
            if (i < strLength) {
               retStr.append(string.charAt(i));
            }
         }

         retStr.append(ch);
      }

      return retStr.toString();
   }
}
