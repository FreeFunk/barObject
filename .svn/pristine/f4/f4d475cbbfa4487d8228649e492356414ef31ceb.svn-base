package com.edgedo.common.util;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.common.base.BusinessException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class ObjectUtil {
   private static final String JAVAP = "java.";
   private static final String JAVADATESTR = "java.util.Date";

   public static void copyBeanChange(Object target, Object after) {
      try {
         Class cls = target.getClass();
         Method[] methods = cls.getMethods();
         Map<String, Method> methodMap = new HashMap();
         Method[] var5 = methods;
         int var6 = methods.length;

         int var7;
         for(var7 = 0; var7 < var6; ++var7) {
            Method method = var5[var7];
            String methodName = method.getName();
            methodMap.put(methodName, method);
         }

         Field[] fields = cls.getDeclaredFields();
         Field[] var19 = fields;
         var7 = fields.length;

         for(int var20 = 0; var20 < var7; ++var20) {
            Field field = var19[var20];
            String fieldName = field.getName();
            String temStr = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
            String setMethodStr = "set" + temStr;
            String getMethodStr = "get" + temStr;
            Method setMethod = (Method)methodMap.get(setMethodStr);
            Method getMethod = (Method)methodMap.get(getMethodStr);
            if (setMethod != null && getMethod != null) {
               Object obj = getMethod.invoke(after);
               if (obj != null) {
                  setMethod.invoke(target, obj);
               }
            }
         }
      } catch (Exception var17) {
         var17.printStackTrace();
      }

   }

   public static void copyBeanChange(Object target, Object after, String property) {
      try {
         Class cls = target.getClass();
         Method[] methods = cls.getMethods();
         Map<String, Method> methodMap = new HashMap();
         Method[] var6 = methods;
         int var7 = methods.length;

         int var8;
         String fieldName;
         for(var8 = 0; var8 < var7; ++var8) {
            Method method = var6[var8];
            fieldName = method.getName();
            methodMap.put(fieldName, method);
         }

         String[] targetArr = property.split(",");
         String[] var19 = targetArr;
         var8 = targetArr.length;

         for(int var20 = 0; var20 < var8; ++var20) {
            fieldName = var19[var20];
            String temStr = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
            String setMethodStr = "set" + temStr;
            String getMethodStr = "get" + temStr;
            Method setMethod = (Method)methodMap.get(setMethodStr);
            Method getMethod = (Method)methodMap.get(getMethodStr);
            if (setMethod != null && getMethod != null) {
               Object obj = getMethod.invoke(after);
               if (obj != null) {
                  setMethod.invoke(target, obj);
               }
            }
         }
      } catch (Exception var17) {
         var17.printStackTrace();
      }

   }

   public static void copyBeanChange(Object target, String targetProperty, Map<String, Object> after, String afterProperty) {
      try {
         Class targetCls = target.getClass();
         Method[] targetMethods = targetCls.getMethods();
         Map<String, Method> targetMethodMap = new HashMap();
         Method[] var7 = targetMethods;
         int var8 = targetMethods.length;

         int i;
         String afterField;
         for(i = 0; i < var8; ++i) {
            Method method = var7[i];
            afterField = method.getName();
            targetMethodMap.put(afterField, method);
         }

         String[] targetArr = targetProperty.split(",");
         String[] afterArr = afterProperty.split(",");

         for(i = 0; i < targetArr.length && i < afterArr.length; ++i) {
            String targetField = targetArr[i];
            afterField = afterArr[i];
            String temTargetFieldStr = targetField.substring(0, 1).toUpperCase() + targetField.substring(1, targetField.length());
            String setMethodStr = "set" + temTargetFieldStr;
            String getMethodStr = "get" + temTargetFieldStr;
            Method setMethod = (Method)targetMethodMap.get(setMethodStr);
            Method getMethod = (Method)targetMethodMap.get(getMethodStr);
            if (setMethod != null && setMethod != null) {
               Class type = getMethod.getReturnType();
               Object getValue = after.get(afterField);
               if (getValue != null && getValue.toString().length() > 0) {
                  if (type == String.class) {
                     try {
                        setMethod.invoke(target, getValue.toString());
                     } catch (Exception var27) {
                        var27.printStackTrace();
                     }
                  } else if (type != Integer.class && type != Integer.TYPE) {
                     if (type == BigDecimal.class) {
                        try {
                           setMethod.invoke(target, new BigDecimal(getValue.toString()));
                        } catch (Exception var25) {
                           var25.printStackTrace();
                        }
                     } else if (type != Double.class && type != Double.TYPE) {
                        if (type != Float.class && type != Float.TYPE) {
                           if (type == Date.class) {
                              try {
                                 String value = getValue.toString();
                                 if (value.length() == 10) {
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    Date d = sdf.parse(getValue.toString());
                                    setMethod.invoke(target, d);
                                 } else {
                                    String temValue;
                                    SimpleDateFormat sdf;
                                    Date d;
                                    if (value.length() > 10 && value.length() < 19) {
                                       temValue = value.substring(0, 10);
                                       sdf = new SimpleDateFormat("yyyy-MM-dd");
                                       d = sdf.parse(temValue);
                                       setMethod.invoke(target, d);
                                    } else if (value.length() >= 19) {
                                       temValue = value.substring(0, 19);
                                       sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                       d = sdf.parse(temValue);
                                       setMethod.invoke(target, d);
                                    }
                                 }
                              } catch (Exception var28) {
                                 var28.printStackTrace();
                              }
                           }
                        } else {
                           try {
                              setMethod.invoke(target, new Float(getValue.toString()));
                           } catch (Exception var23) {
                              var23.printStackTrace();
                           }
                        }
                     } else {
                        try {
                           setMethod.invoke(target, new Double(getValue.toString()));
                        } catch (Exception var24) {
                           var24.printStackTrace();
                        }
                     }
                  } else {
                     try {
                        setMethod.invoke(target, new Integer(getValue.toString()));
                     } catch (Exception var26) {
                        var26.printStackTrace();
                     }
                  }
               }
            }
         }
      } catch (Exception var29) {
         var29.printStackTrace();
      }

   }

   public static void mapToBean(Map<String, String> map, Object afterObj) {
      Class cls = afterObj.getClass();
      Method[] methods = cls.getMethods();
      Map<String, Method> methodMap = new HashMap();
      Method[] var5 = methods;
      int var6 = methods.length;

      String value;
      for(int var7 = 0; var7 < var6; ++var7) {
         Method method = var5[var7];
         value = method.getName();
         methodMap.put(value, method);
      }

      Iterator var25 = map.entrySet().iterator();

      while(true) {
         while(true) {
            Method setMetnod;
            Class type;
            String key;
            do {
               String setMethodStr;
               Method getMetnod;
               do {
                  if (!var25.hasNext()) {
                     return;
                  }

                  Entry<String, String> entry = (Entry)var25.next();
                  key = (String)entry.getKey();
                  String obj = (String)entry.getValue();
                  value = obj + "";
                  setMethodStr = "set" + key.substring(0, 1).toUpperCase() + key.substring(1, key.length());
                  String getMethodStr = "get" + key.substring(0, 1).toUpperCase() + key.substring(1, key.length());
                  getMetnod = (Method)methodMap.get(getMethodStr);
               } while(getMetnod == null);

               setMetnod = (Method)methodMap.get(setMethodStr);
               type = getMetnod.getReturnType();
            } while(setMetnod == null);

            if (type == String.class) {
               try {
                  setMetnod.invoke(afterObj, value);
               } catch (Exception var18) {
                  System.out.println(key + "====================:" + value);
                  var18.printStackTrace();
               }
            } else if (type != Integer.class && type != Integer.TYPE) {
               if (type == BigDecimal.class) {
                  try {
                     if (value.length() == 0) {
                        value = "0";
                     }

                     setMetnod.invoke(afterObj, new BigDecimal(value));
                  } catch (Exception var22) {
                     System.out.println(key + "====================:" + value);
                     var22.printStackTrace();
                  }
               } else if (type == Long.class) {
                  try {
                     if (value.length() == 0) {
                        value = "0";
                     }

                     setMetnod.invoke(afterObj, new Long(value));
                  } catch (Exception var21) {
                     System.out.println(key + "====================:" + value);
                     var21.printStackTrace();
                  }
               } else if (type != Double.class && type != Double.TYPE) {
                  if (type != Float.class && type != Float.TYPE) {
                     if (type == Date.class) {
                        try {
                           if (value != null) {
                              if (value.length() == 10) {
                                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                 Date d = sdf.parse(value.toString());
                                 setMetnod.invoke(afterObj, d);
                              } else {
                                 String temValue;
                                 SimpleDateFormat sdf;
                                 Date d;
                                 if (value.length() > 10 && value.length() < 19) {
                                    temValue = value.substring(0, 10);
                                    sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    d = sdf.parse(temValue);
                                    setMetnod.invoke(afterObj, d);
                                 } else if (value.length() >= 19) {
                                    temValue = value.substring(0, 19);
                                    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    d = sdf.parse(temValue);
                                    setMetnod.invoke(afterObj, d);
                                 }
                              }
                           }
                        } catch (Exception var24) {
                           System.out.println(key + "====================:" + value);
                           var24.printStackTrace();
                        }
                     }
                  } else {
                     try {
                        if (value.length() == 0) {
                           value = "0";
                        }

                        setMetnod.invoke(afterObj, new Float(value));
                     } catch (Exception var19) {
                        System.out.println(key + "====================:" + value);
                        var19.printStackTrace();
                     }
                  }
               } else {
                  try {
                     if (value.length() == 0) {
                        value = "0";
                     }

                     setMetnod.invoke(afterObj, new Double(value));
                  } catch (Exception var20) {
                     System.out.println(key + "====================:" + value);
                     var20.printStackTrace();
                  }
               }
            } else {
               try {
                  if (value.length() == 0) {
                     value = "0";
                  } else {
                     value = value.split("\\.")[0];
                     value = value.replaceAll("\\D", "");
                  }

                  setMetnod.invoke(afterObj, new Integer(value));
               } catch (Exception var23) {
                  System.out.println(key + "====================:" + value);
                  var23.printStackTrace();
               }
            }
         }
      }
   }

   public static <T> T mapToBean(Map<String, String> map, Class<T> cls) {
      Object t = null;

      try {
         t = cls.newInstance();
      } catch (InstantiationException var4) {
         var4.printStackTrace();
      } catch (IllegalAccessException var5) {
         var5.printStackTrace();
      }

      mapToBean(map, t);
      return (T) t;
   }

   public static Map<String, Object> beanToMap(Object target) {
      HashMap result = new HashMap();

      try {
         Class cls = target.getClass();
         Method[] methods = cls.getMethods();
         Map<String, Method> methodMap = new HashMap();
         Method[] var5 = methods;
         int var6 = methods.length;

         int var7;
         for(var7 = 0; var7 < var6; ++var7) {
            Method method = var5[var7];
            String methodName = method.getName();
            methodMap.put(methodName, method);
         }

         Field[] fields = cls.getDeclaredFields();
         Field[] pfeilds = fields;
         var7 = fields.length;

         String fieldName;
         String temStr;
         int var20;
         for(var20 = 0; var20 < var7; ++var20) {
            Field field = pfeilds[var20];
            fieldName = field.getName();
            fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
            temStr = "get" + fieldName;
            Method getMethod = (Method)methodMap.get(temStr);
            if (getMethod != null) {
               Object obj = getMethod.invoke(target);
               result.put(fieldName, obj);
            }
         }

         pfeilds = cls.getSuperclass().getDeclaredFields();
         Field[] var19 = pfeilds;
         var20 = pfeilds.length;

         for(int var22 = 0; var22 < var20; ++var22) {
            Field field = var19[var22];
            fieldName = field.getName();
            temStr = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
            String getMethodStr = "get" + temStr;
            Method getMethod = (Method)methodMap.get(getMethodStr);
            if (getMethod != null) {
               Object obj = getMethod.invoke(target);
               result.put(fieldName, obj);
            }
         }
      } catch (Exception var16) {
         var16.printStackTrace();
      }

      return result;
   }

   public static HashMap<String, String> jsonToMap(String json) {
      HashMap<String, String> data = new HashMap();
      JSONObject jsonObject = JSONObject.parseObject(json);
      Set<Entry<String, Object>> entrySet = jsonObject.entrySet();
      Iterator var4 = entrySet.iterator();

      while(var4.hasNext()) {
         Entry<String, Object> entry = (Entry)var4.next();
         String key = (String)entry.getKey();
         jsonObject.get(key);
         String value = entry.getValue().toString();
         data.put(key, value);
      }

      return data;
   }

   public static boolean isEmpty(Object aObj) {
      if (aObj instanceof String) {
         return isEmpty((String)aObj);
      } else if (aObj instanceof Long) {
         return isEmpty((Long)aObj);
      } else if (aObj instanceof Date) {
         return isEmpty((Date)aObj);
      } else if (aObj instanceof Collection) {
         return isEmpty((Collection)aObj);
      } else if (aObj instanceof Map) {
         return isEmpty((Map)aObj);
      } else {
         return aObj != null && aObj.getClass().isArray() ? isEmptyArray(aObj) : isNull(aObj);
      }
   }

   private static boolean isEmptyArray(Object array) {
      int length;
      if (array instanceof int[]) {
         length = ((int[])((int[])array)).length;
      } else if (array instanceof byte[]) {
         length = ((byte[])((byte[])array)).length;
      } else if (array instanceof short[]) {
         length = ((short[])((short[])array)).length;
      } else if (array instanceof char[]) {
         length = ((char[])((char[])array)).length;
      } else if (array instanceof float[]) {
         length = ((float[])((float[])array)).length;
      } else if (array instanceof double[]) {
         length = ((double[])((double[])array)).length;
      } else if (array instanceof long[]) {
         length = ((long[])((long[])array)).length;
      } else if (array instanceof boolean[]) {
         length = ((boolean[])((boolean[])array)).length;
      } else {
         length = ((Object[])((Object[])array)).length;
      }

      return length == 0;
   }

   public static boolean isEmpty(Date aDate) {
      return aDate == null;
   }

   public static boolean isEmpty(Long aLong) {
      return aLong == null;
   }

   public static boolean isEmpty(Map m) {
      return m == null || m.size() == 0;
   }

   public static boolean isEmpty(Collection c) {
      return c == null || c.size() == 0;
   }

   public static boolean isEmpty(String aStr) {
      if (aStr == null || aStr.trim().isEmpty()){
         return true;
      }
      return false;
   }

   public static String trim(String aStr) {
      return aStr == null ? "" : aStr.trim();
   }

   public static boolean isNull(Object oStr) {
      return oStr == null;
   }

   public static boolean equals(String str1, String str2) {
      return str1 != null ? str1.equals(str2) : str2 == null;
   }

   public static boolean equals(Long L1, Long L2) {
      return L1 != null ? L1.equals(L2) : L2 == null;
   }

   public static boolean equals(Object obj1, Object obj2) {
      boolean result;
      if (obj1 != null) {
         result = obj1.equals(obj2);
      } else {
         result = obj2 == null;
      }

      return result;
   }

   public static boolean equalsIgnoreCase(String str1, String str2) {
      return str1 != null ? str1.equalsIgnoreCase(str2) : str2 == null;
   }

   public static Map<String, String> objectToMapString(Object obj, String... excludeFields) {
      try {
         Map<String, String> map = new HashMap();
         if (excludeFields.length != 0) {
            List<String> list = Arrays.asList(excludeFields);
            objectTransfer(obj, map, list);
         } else {
            objectTransfer(obj, map, (List)null);
         }

         return map;
      } catch (Exception var4) {
         var4.printStackTrace();
         throw new BusinessException("参数转换失败");
      }
   }

   private static Map<String, String> objectTransfer(Object obj, Map<String, String> map, List<String> excludeFields) throws IllegalAccessException {
      boolean isExclude = false;
      String timeFormatStr = "YYYY-MM-dd HH:mm:ss";
      if (excludeFields != null) {
         isExclude = true;
      }

      Class<?> clazz = obj.getClass();

      ArrayList fieldList;
      for(fieldList = new ArrayList(); clazz != null; clazz = clazz.getSuperclass()) {
         fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
      }

      Iterator var7 = fieldList.iterator();

      while(true) {
         while(true) {
            String fieldName;
            Object value;
            do {
               Field field;
               do {
                  if (!var7.hasNext()) {
                     return map;
                  }

                  field = (Field)var7.next();
                  fieldName = field.getName();
               } while(isExclude && excludeFields.contains(fieldName));

               field.setAccessible(true);
               value = field.get(obj);
            } while(value == null);

            Class<?> valueClass = value.getClass();
            if (valueClass.isPrimitive()) {
               map.put(fieldName, value.toString());
            } else if (valueClass.getName().contains("java.")) {
               if (valueClass.getName().equals("java.util.Date")) {
                  SimpleDateFormat sdf = new SimpleDateFormat(timeFormatStr);
                  Date date = (Date)value;
                  String dataStr = sdf.format(date);
                  map.put(fieldName, dataStr);
               } else if (value instanceof Map) {
                  Map<String, Object> temMap = (Map)value;
                  Set<String> keys = temMap.keySet();
                  Iterator var14 = keys.iterator();

                  while(var14.hasNext()) {
                     String key = (String)var14.next();
                     Object temMapValue = temMap.get(key);
                     if (temMapValue != null) {
                        map.put(fieldName + "." + key, temMapValue.toString());
                     }
                  }
               } else {
                  map.put(fieldName, value.toString());
               }
            } else {
               objectTransfer(value, map, excludeFields);
            }
         }
      }
   }
}
