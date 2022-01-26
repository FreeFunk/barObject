package com.edgedo.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class MD5Util {
   private static final String[] hexDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

   private static String byteArrayToHexString(byte[] b) {
      StringBuffer resultSb = new StringBuffer();

      for(int i = 0; i < b.length; ++i) {
         resultSb.append(byteToHexString(b[i]));
      }

      return resultSb.toString();
   }

   private static String byteToHexString(byte b) {
      int n = b;
      if (b < 0) {
         n = b + 256;
      }

      int d1 = n / 16;
      int d2 = n % 16;
      return hexDigits[d1] + hexDigits[d2];
   }

   public static String MD5Encode(String origin, String charsetname) {
      String resultString = null;

      try {
         resultString = new String(origin);
         MessageDigest md = MessageDigest.getInstance("MD5");
         if (charsetname != null && !"".equals(charsetname)) {
            resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
         } else {
            resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
         }
      } catch (Exception var4) {
      }

      return resultString;
   }

   public static final String md5DigestForBaidu(String res) {
      if (res != null && !"".equals(res)) {
         char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

         byte[] strTemp;
         try {
            strTemp = res.getBytes("gbk");
         } catch (UnsupportedEncodingException var10) {
            return null;
         }

         try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;

            for(int i = 0; i < j; ++i) {
               byte byte0 = md[i];
               str[k++] = hexDigits[byte0 >>> 4 & 15];
               str[k++] = hexDigits[byte0 & 15];
            }

            String dd = new String(str);
            return dd;
         } catch (Exception var11) {
            return null;
         }
      } else {
         return null;
      }
   }
}
