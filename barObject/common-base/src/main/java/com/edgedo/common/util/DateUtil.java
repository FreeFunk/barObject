package com.edgedo.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
   public static String getStrDateByFormat(Date date, String format) {
      SimpleDateFormat sdf = new SimpleDateFormat(format);
      return sdf.format(date);
   }
}
