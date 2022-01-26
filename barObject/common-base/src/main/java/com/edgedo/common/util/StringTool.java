package com.edgedo.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTool {
   private static char[] starArr = new char[]{'*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'};

   public static final boolean testPhone(String phone) {
      Pattern p = Pattern.compile("^1\\d{10}$");
      return p.matcher(phone).matches();
   }

   public static final boolean testEmail(String email) {
      Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
      return p.matcher(email).matches();
   }

   public static final boolean testUserCode(String userCode) {
      Pattern p = Pattern.compile("^[a-zA-Z]\\w{5,23}");
      return p.matcher(userCode).matches();
   }

   public static final String getEncodePhoneNum(String phoneNum) {
      return phoneNum.substring(0, 3) + "****" + phoneNum.substring(7);
   }

   public static final String encodeImportentNum(String num) {
      if (num != null && num.length() >= 6) {
         String num1 = num.substring(0, 3);
         String num2 = num.substring(num.length() - 3, num.length());
         int s = num.length() - 6;
         String str = "";

         for(int i = 0; i < s; ++i) {
            str = str + "*";
         }

         num = num1 + str + num2;
         return num;
      } else {
         return num;
      }
   }

   public static final String encodeImportentNum(String str, int start, int length) {
      if (str != null) {
         char[] chars = str.toCharArray();
         if (start > chars.length) {
            return str;
         } else {
            int len1 = chars.length - start;
            int len = len1 > length ? length : len1;
            System.arraycopy(starArr, 0, chars, start, len);
            return new String(chars);
         }
      } else {
         return str;
      }
   }

   public static final String encodeImportentNum1(String num) {
      if (num != null && num.length() >= 4) {
         num = num.substring(0, num.length() - 4) + "****";
         return num;
      } else {
         return num;
      }
   }

   public static final boolean testUrl(String target) {
      Pattern pattern = Pattern.compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$");
      return pattern.matcher(target).matches();
   }

   public static boolean isChineseStr(String str) {
      Pattern pattern = Pattern.compile("[一-龥]");
      if (str != null && !str.equals("")) {
         char[] c = str.toCharArray();

         for(int i = 0; i < c.length; ++i) {
            Matcher matcher = pattern.matcher(String.valueOf(c[i]));
            if (!matcher.matches()) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public static String subString(String str, String strStart, String strEnd) {
      int strStartIndex = str.indexOf(strStart);
      int strEndIndex = str.indexOf(strEnd);
      String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
      return result;
   }
}
