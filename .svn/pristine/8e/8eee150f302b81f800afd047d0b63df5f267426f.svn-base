package com.edgedo.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdCardUtil {
   protected static String[][] codeAndCity = new String[][]{{"11", "北京"}, {"12", "天津"}, {"13", "河北"}, {"14", "山西"}, {"15", "内蒙古"}, {"21", "辽宁"}, {"22", "吉林"}, {"23", "黑龙江"}, {"31", "上海"}, {"32", "江苏"}, {"33", "浙江"}, {"34", "安徽"}, {"35", "福建"}, {"36", "江西"}, {"37", "山东"}, {"41", "河南"}, {"42", "湖北"}, {"43", "湖南"}, {"44", "广东"}, {"45", "广西"}, {"46", "海南"}, {"50", "重庆"}, {"51", "四川"}, {"52", "贵州"}, {"53", "云南"}, {"54", "西藏"}, {"61", "陕西"}, {"62", "甘肃"}, {"63", "青海"}, {"64", "宁夏"}, {"65", "新疆"}, {"71", "台湾"}, {"81", "香港"}, {"82", "澳门"}, {"91", "国外"}};
   private static String[] cityCode = new String[]{"11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35", "36", "37", "41", "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65", "71", "81", "82", "91"};
   private static int[] power = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
   private static String[] verifyCode = new String[]{"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};

   public static String IdCard15to18(String idCard) {
      idCard = idCard.trim();
      StringBuffer idCard18 = new StringBuffer(idCard);
      char[] checkBit = new char[]{'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
      int sum = 0;
      if (idCard != null && idCard.length() == 15) {
         idCard18.insert(6, "19");

         int indexOfCheckBit;
         for(indexOfCheckBit = 0; indexOfCheckBit < idCard18.length(); ++indexOfCheckBit) {
            char c = idCard18.charAt(indexOfCheckBit);
            int ai = Integer.parseInt((new Character(c)).toString());
            int Wi = (int)Math.pow(2.0D, (double)(idCard18.length() - indexOfCheckBit)) % 11;
            sum += ai * Wi;
         }

         indexOfCheckBit = sum % 11;
         idCard18.append(checkBit[indexOfCheckBit]);
      }

      return idCard18.toString();
   }

   public static String IdCard18to15(String idCard) {
      idCard = idCard.trim();
      StringBuffer idCard15 = new StringBuffer(idCard);
      if (idCard != null && idCard.length() == 18) {
         idCard15.delete(17, 18);
         idCard15.delete(6, 8);
      }

      return idCard15.toString();
   }

   public static boolean checkIDCard(String idCard) {
      boolean isIDCard = false;
      Pattern pattern = Pattern.compile("\\d{15}|\\d{17}[x,X,0-9]");
      Matcher matcher = pattern.matcher(idCard);
      if (matcher.matches()) {
         isIDCard = true;
         if (idCard.length() == 18) {
            String IdCard15 = IdCard18to15(idCard);
            String IdCard18 = IdCard15to18(IdCard15);
            if (!idCard.equals(IdCard18)) {
               isIDCard = false;
            }
         } else if (idCard.length() == 15) {
            isIDCard = true;
         } else {
            isIDCard = false;
         }
      }

      return isIDCard;
   }

   public static boolean isValidatedAllIdcard(String idcard) {
      if (idcard.length() == 15) {
         idcard = convertIdcarBy15bit(idcard);
      }

      return isValidate18Idcard(idcard);
   }

   public static boolean isValidate18Idcard(String idcard) {
      if (idcard.length() != 18) {
         return false;
      } else {
         String idcard17 = idcard.substring(0, 17);
         String idcard18Code = idcard.substring(17, 18);
         char[] c = null;
         String checkCode = "";
         if (isDigital(idcard17)) {
            c = idcard17.toCharArray();
            if (null != c) {
               int[] bit = new int[idcard17.length()];
               bit = converCharToInt(c);
               int sum17 = getPowerSum(bit);
               checkCode = getCheckCodeBySum(sum17);
               if (null == checkCode) {
                  return false;
               }

               if (!idcard18Code.equalsIgnoreCase(checkCode)) {
                  return false;
               }
            }

            return true;
         } else {
            return false;
         }
      }
   }

   public boolean isValidate15Idcard(String idcard) {
      if (idcard.length() != 15) {
         return false;
      } else if (!isDigital(idcard)) {
         return false;
      } else {
         String provinceid = idcard.substring(0, 2);
         String birthday = idcard.substring(6, 12);
         int year = Integer.parseInt(idcard.substring(6, 8));
         int month = Integer.parseInt(idcard.substring(8, 10));
         int day = Integer.parseInt(idcard.substring(10, 12));
         boolean flag = false;
         String[] var8 = cityCode;
         int var9 = var8.length;

         int curYear;
         for(curYear = 0; curYear < var9; ++curYear) {
            String id = var8[curYear];
            if (id.equals(provinceid)) {
               flag = true;
               break;
            }
         }

         if (!flag) {
            return false;
         } else {
            Date birthdate = null;

            try {
               birthdate = (new SimpleDateFormat("yyMMdd")).parse(birthday);
            } catch (ParseException var13) {
               var13.printStackTrace();
            }

            if (birthdate != null && !(new Date()).before(birthdate)) {
               GregorianCalendar curDay = new GregorianCalendar();
               curYear = curDay.get(1);
               int year2bit = Integer.parseInt(String.valueOf(curYear).substring(2));
               if (year < 50 && year > year2bit) {
                  return false;
               } else if (month >= 1 && month <= 12) {
                  boolean mflag = false;
                  curDay.setTime(birthdate);
                  switch(month) {
                  case 1:
                  case 3:
                  case 5:
                  case 7:
                  case 8:
                  case 10:
                  case 12:
                     mflag = day >= 1 && day <= 31;
                     break;
                  case 2:
                     if (curDay.isLeapYear(curDay.get(1))) {
                        mflag = day >= 1 && day <= 29;
                     } else {
                        mflag = day >= 1 && day <= 28;
                     }
                     break;
                  case 4:
                  case 6:
                  case 9:
                  case 11:
                     mflag = day >= 1 && day <= 30;
                  }

                  return mflag;
               } else {
                  return false;
               }
            } else {
               return false;
            }
         }
      }
   }

   public static String convertIdcarBy15bit(String idcard) {
      String idcard17 = null;
      if (idcard.length() != 15) {
         return null;
      } else if (isDigital(idcard)) {
         String birthday = idcard.substring(6, 12);
         Date birthdate = null;

         try {
            birthdate = (new SimpleDateFormat("yyMMdd")).parse(birthday);
         } catch (ParseException var10) {
            var10.printStackTrace();
         }

         Calendar cday = Calendar.getInstance();
         cday.setTime(birthdate);
         String year = String.valueOf(cday.get(1));
         idcard17 = idcard.substring(0, 6) + year + idcard.substring(8);
         char[] c = idcard17.toCharArray();
         String checkCode = "";
         if (null != c) {
            int[] bit = new int[idcard17.length()];
            bit = converCharToInt(c);
            int sum17 = getPowerSum(bit);
            checkCode = getCheckCodeBySum(sum17);
            if (null == checkCode) {
               return null;
            }

            idcard17 = idcard17 + checkCode;
         }

         return idcard17;
      } else {
         return null;
      }
   }

   public boolean isIdcard(String idcard) {
      return idcard != null && !"".equals(idcard) ? Pattern.matches("(^\\d{15}$)|(\\d{17}(?:\\d|x|X)$)", idcard) : false;
   }

   public boolean is15Idcard(String idcard) {
      return idcard != null && !"".equals(idcard) ? Pattern.matches("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$", idcard) : false;
   }

   public boolean is18Idcard(String idcard) {
      return Pattern.matches("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([\\d|x|X]{1})$", idcard);
   }

   public static boolean isDigital(String str) {
      return str != null && !"".equals(str) ? str.matches("^[0-9]*$") : false;
   }

   public static int getPowerSum(int[] bit) {
      int sum = 0;
      if (power.length != bit.length) {
         return sum;
      } else {
         for(int i = 0; i < bit.length; ++i) {
            for(int j = 0; j < power.length; ++j) {
               if (i == j) {
                  sum += bit[i] * power[j];
               }
            }
         }

         return sum;
      }
   }

   public static String getCheckCodeBySum(int sum17) {
      String checkCode = null;
      switch(sum17 % 11) {
      case 0:
         checkCode = "1";
         break;
      case 1:
         checkCode = "0";
         break;
      case 2:
         checkCode = "x";
         break;
      case 3:
         checkCode = "9";
         break;
      case 4:
         checkCode = "8";
         break;
      case 5:
         checkCode = "7";
         break;
      case 6:
         checkCode = "6";
         break;
      case 7:
         checkCode = "5";
         break;
      case 8:
         checkCode = "4";
         break;
      case 9:
         checkCode = "3";
         break;
      case 10:
         checkCode = "2";
      }

      return checkCode;
   }

   public static int[] converCharToInt(char[] c) throws NumberFormatException {
      int[] a = new int[c.length];
      int k = 0;
      char[] var3 = c;
      int var4 = c.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         char temp = var3[var5];
         a[k++] = Integer.parseInt(String.valueOf(temp));
      }

      return a;
   }

   public static int getAgeByIdCard(String idCard) {
      Calendar cal = Calendar.getInstance();
      String year = idCard.substring(6, 10);
      int iCurrYear = cal.get(1);
      int iAge = iCurrYear - Integer.valueOf(year);
      return iAge;
   }

   public static String getBirthByIdCard(String idCard) {
      return idCard.substring(6, 14);
   }

   public static String getGenderByIdCard(String idCard) {
      String sGender = "未知";
      String sCardNum = idCard.substring(16, 17);
      if (Integer.parseInt(sCardNum) % 2 != 0) {
         sGender = "男";
      } else {
         sGender = "女";
      }

      return sGender;
   }
}
