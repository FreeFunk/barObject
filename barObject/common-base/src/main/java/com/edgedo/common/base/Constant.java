package com.edgedo.common.base;

import java.util.HashSet;
import java.util.Set;

public class Constant {
   public static final int BYTE_BUFFER = 1024;
   public static Set<String> METHOD_URL_SET = new HashSet();
   public static Set<String> METHOD_URL_SET_REAL_NAME = new HashSet();
   public static final int DEFAULT_REGISTER_ROLE = 5;
   public static final int BUFFER_MULTIPLE = 10;
   public static final Long PASS_TIME = 3000000000L;
   public static final String ROOT_MENU = "0";
   public static final int TYPE_MENU = 1;
   public static final int TYPE_BUTTON = 2;
   public static boolean isPass = false;
   public static final int ENABLE = 1;
   public static final int DISABLE = 0;

   public class RoleType {
      public static final String SYS_ASMIN_ROLE = "sysadmin";
      public static final String ADMIN = "admin";
      public static final String USER = "user";
   }

   public class FileType {
      public static final int FILE_IMG = 1;
      public static final int FILE_ZIP = 2;
      public static final int FILE_VEDIO = 3;
      public static final int FILE_APK = 4;
      public static final int FIVE_OFFICE = 5;
      public static final String FILE_IMG_DIR = "/img/";
      public static final String FILE_ZIP_DIR = "/zip/";
      public static final String FILE_VEDIO_DIR = "/video/";
      public static final String FILE_APK_DIR = "/apk/";
      public static final String FIVE_OFFICE_DIR = "/office/";
   }

   public static class FilePostFix {
      public static final String ZIP_FILE = ".zip";
      public static final String[] IMAGES = new String[]{"jpg", "jpeg", "JPG", "JPEG", "gif", "GIF", "bmp", "BMP", "png"};
      public static final String[] ZIP = new String[]{"ZIP", "zip", "rar", "RAR"};
      public static final String[] VIDEO = new String[]{"mp4", "MP4", "mpg", "mpe", "mpa", "m15", "m1v", "mp2", "rmvb"};
      public static final String[] APK = new String[]{"apk", "exe"};
      public static final String[] OFFICE = new String[]{"xls", "xlsx", "docx", "doc", "ppt", "pptx"};
   }
}
