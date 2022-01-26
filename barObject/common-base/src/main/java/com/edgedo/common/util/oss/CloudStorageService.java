package com.edgedo.common.util.oss;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public abstract class CloudStorageService {
   CloudStorageConfig config;

   public String getPath(String prefix, String suffix) {
      String uuid = UUID.randomUUID().toString().replaceAll("-", "");
      SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
      SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
      SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
      String dateYear = sdfYear.format(new Date());
      String dateMonth = sdfMonth.format(new Date());
      String dateDay = sdfDay.format(new Date());
      String path = dateYear + "/" + dateMonth + "/" + dateDay + "/" + uuid;
      if (prefix != null && prefix.length() > 0) {
         path = prefix + "/" + path;
      }

      return path + suffix;
   }

   public abstract String upload(byte[] data, String path);

   public abstract String uploadSuffix(byte[] data, String suffix);

   public abstract String upload(InputStream inputStream, String path);

   public abstract String uploadSuffix(InputStream inputStream, String suffix);
}
