package com.edgedo.common.util;

import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.apache.commons.io.IOUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class FileUtil {
   public static final String photoNameExt = "jpg,gif,png,jpeg";

   public static String saveFile(MultipartFile file, String fileForder, boolean webPathFlag) throws Exception {
      String uuid = Guid.guid();
      String oraName = file.getOriginalFilename();
      String fileExt = oraName.substring(oraName.lastIndexOf(".") + 1).toLowerCase();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy" + File.separator + "MM" + File.separator + "dd" + File.separator + "HH");
      String relativePath = File.separator + sdf.format(new Date());
      String fileName = fileForder + relativePath + File.separator + uuid + "." + fileExt;
      File targetFile = new File(fileName);
      if (!targetFile.getParentFile().exists()) {
         targetFile.getParentFile().mkdirs();
      }

      InputStream fis = null;
      FileOutputStream fos = null;

      try {
         fis = file.getInputStream();
         fos = new FileOutputStream(targetFile);
         IOUtils.copyLarge(fis, fos);
      } catch (Exception var16) {
         throw var16;
      } finally {
         fis.close();
         fos.close();
      }

      return webPathFlag ? changeFilePathToWebPath(relativePath) + "/" + uuid + "." + fileExt : relativePath + File.separator + uuid + "." + fileExt;
   }

   public static String saveFile(byte[] fileByte, String fileForder, boolean webPathFlag, String fileExt) throws Exception {
      String uuid = Guid.guid();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy" + File.separator + "MM" + File.separator + "dd" + File.separator + "HH");
      String relativePath = File.separator + sdf.format(new Date());
      String fileName = fileForder + relativePath + File.separator + uuid + "." + fileExt;
      File targetFile = new File(fileName);
      if (!targetFile.getParentFile().exists()) {
         targetFile.getParentFile().mkdirs();
      }

      InputStream fis = null;
      FileOutputStream fos = null;

      try {
         fis = new ByteArrayInputStream(fileByte);
         fos = new FileOutputStream(targetFile);
         IOUtils.copyLarge(fis, fos);
      } catch (Exception var15) {
         throw var15;
      } finally {
         fis.close();
         fos.close();
      }

      return webPathFlag ? changeFilePathToWebPath(relativePath) + "/" + uuid + "." + fileExt : relativePath + File.separator + uuid + "." + fileExt;
   }

   public static void saveFile(byte[] fileByte, String fileName) throws Exception {
      File targetFile = new File(fileName);
      if (!targetFile.getParentFile().exists()) {
         targetFile.getParentFile().mkdirs();
      }

      InputStream fis = null;
      FileOutputStream fos = null;

      try {
         fis = new ByteArrayInputStream(fileByte);
         fos = new FileOutputStream(targetFile);
         IOUtils.copyLarge(fis, fos);
      } catch (Exception var9) {
         throw var9;
      } finally {
         fis.close();
         fos.close();
      }

   }

   public static String saveFile(File file, String fileForder, boolean webPathFlag) throws Exception {
      String uuid = Guid.guid();
      String oraName = file.getName();
      String fileExt = oraName.substring(oraName.lastIndexOf(".") + 1).toLowerCase();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy" + File.separator + "MM" + File.separator + "dd" + File.separator + "HH");
      String relativePath = File.separator + sdf.format(new Date());
      String fileName = fileForder + relativePath + File.separator + uuid + "." + fileExt;
      File targetFile = new File(fileName);
      if (!targetFile.getParentFile().exists()) {
         targetFile.getParentFile().mkdirs();
      }

      InputStream fis = null;
      FileOutputStream fos = null;

      try {
         fis = new FileInputStream(file);
         fos = new FileOutputStream(targetFile);
         IOUtils.copyLarge(fis, fos);
      } catch (Exception var16) {
         throw var16;
      } finally {
         fis.close();
         fos.close();
      }

      return webPathFlag ? changeFilePathToWebPath(relativePath) + "/" + uuid + "." + fileExt : relativePath + File.separator + uuid + "." + fileExt;
   }

   public static String saveFile(byte[] fileArr, String fileForder, String oraName, boolean webPathFlag) throws Exception {
      String uuid = Guid.guid();
      String fileExt = oraName.substring(oraName.lastIndexOf(".") + 1).toLowerCase();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy" + File.separator + "MM" + File.separator + "dd" + File.separator + "HH");
      String relativePath = File.separator + sdf.format(new Date());
      String fileName = fileForder + relativePath + File.separator + uuid + "." + fileExt;
      File targetFile = new File(fileName);
      if (!targetFile.getParentFile().exists()) {
         targetFile.getParentFile().mkdirs();
      }

      InputStream fis = null;
      FileOutputStream fos = null;

      try {
         fis = new ByteArrayInputStream(fileArr);
         fos = new FileOutputStream(targetFile);
         IOUtils.copyLarge(fis, fos);
      } catch (Exception var16) {
         throw var16;
      } finally {
         fis.close();
         fos.close();
      }

      return webPathFlag ? changeFilePathToWebPath(relativePath) + "/" + uuid + "." + fileExt : relativePath + File.separator + uuid + "." + fileExt;
   }

   public static String saveBase64Img(String base64imgStr, String fileForder, boolean webPathFlag) throws Exception {
      return saveBase64Img(base64imgStr, fileForder, "jpg", webPathFlag);
   }

   public static String saveBase64Img(String base64imgStr, String fileForder, String fileExt, boolean webPathFlag) throws Exception {
      String base64Prix = "data:image/jpeg;base64,";
      if (base64imgStr.indexOf(base64Prix) >= 0) {
         base64imgStr = base64imgStr.substring(base64Prix.length());
      }

      String uuid = Guid.guid();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy" + File.separator + "MM" + File.separator + "dd" + File.separator + "HH");
      String relativePath = File.separator + sdf.format(new Date());
      String fileName = fileForder + relativePath + File.separator + uuid + "." + fileExt;
      byte[] buffer = generateImageFromBase64Str(base64imgStr);
      File targetFile = new File(fileName);
      if (!targetFile.getParentFile().exists()) {
         targetFile.getParentFile().mkdirs();
      }

      InputStream fis = null;
      FileOutputStream fos = null;

      try {
         fis = new ByteArrayInputStream(buffer);
         fos = new FileOutputStream(targetFile);
         IOUtils.copyLarge(fis, fos);
      } catch (Exception var17) {
         throw var17;
      } finally {
         fis.close();
         fos.close();
      }

      return webPathFlag ? changeFilePathToWebPath(relativePath) + "/" + uuid + "." + fileExt : relativePath + File.separator + uuid + "." + fileExt;
   }

   public static void saveCopyFile(MultipartFile file, String realPath) throws Exception {
      String oraName = file.getOriginalFilename();
      File targetFile = new File(realPath);
      if (!targetFile.getParentFile().exists()) {
         targetFile.getParentFile().mkdirs();
      }

      InputStream fis = null;
      FileOutputStream fos = null;

      try {
         fis = file.getInputStream();
         fos = new FileOutputStream(targetFile);
         IOUtils.copyLarge(fis, fos);
      } catch (Exception var10) {
         throw var10;
      } finally {
         fis.close();
         fos.close();
      }

   }

   public static boolean isImage(MultipartFile file) {
      String extend = getFileExtend(file);
      return "jpg,gif,png,jpeg".indexOf(extend) >= 0;
   }

   public static String getFileExtend(MultipartFile file) {
      String oraName = file.getOriginalFilename();
      String fileExt = oraName.substring(oraName.lastIndexOf(".") + 1).toLowerCase();
      return fileExt;
   }

   public static String getFileExtend(String filePath) {
      String fileExt = filePath.substring(filePath.lastIndexOf(".") + 1).toLowerCase();
      return fileExt;
   }

   public static int getPhotoWidth(MultipartFile photo) throws Exception {
      BufferedImage sourceImg = null;
      InputStream is = null;

      int var3;
      try {
         is = photo.getInputStream();
         sourceImg = ImageIO.read(is);
         var3 = sourceImg.getWidth();
      } catch (IOException var12) {
         throw new Exception("文件读取错误");
      } finally {
         if (is != null) {
            try {
               is.close();
            } catch (IOException var11) {
               var11.printStackTrace();
            }
         }

      }

      return var3;
   }

   public static int getPhotoWidth(File photo) throws Exception {
      BufferedImage sourceImg = null;
      FileInputStream is = null;

      int var3;
      try {
         is = new FileInputStream(photo);
         sourceImg = ImageIO.read(is);
         var3 = sourceImg.getWidth();
      } catch (IOException var12) {
         throw new Exception("文件读取错误");
      } finally {
         if (is != null) {
            try {
               is.close();
            } catch (IOException var11) {
               var11.printStackTrace();
            }
         }

      }

      return var3;
   }

   public static int getPhotoHeight(MultipartFile photo) throws Exception {
      BufferedImage sourceImg = null;
      InputStream is = null;

      int var3;
      try {
         is = photo.getInputStream();
         sourceImg = ImageIO.read(is);
         var3 = sourceImg.getHeight();
      } catch (IOException var12) {
         throw new Exception("文件读取错误");
      } finally {
         if (is != null) {
            try {
               is.close();
            } catch (IOException var11) {
               var11.printStackTrace();
            }
         }

      }

      return var3;
   }

   public static int getPhotoHeight(File photo) throws Exception {
      BufferedImage sourceImg = null;
      FileInputStream is = null;

      int var3;
      try {
         is = new FileInputStream(photo);
         sourceImg = ImageIO.read(is);
         var3 = sourceImg.getHeight();
      } catch (IOException var12) {
         throw new Exception("文件读取错误");
      } finally {
         if (is != null) {
            try {
               is.close();
            } catch (IOException var11) {
               var11.printStackTrace();
            }
         }

      }

      return var3;
   }

   public static double getPhotoWidthDeiveHeight(MultipartFile photo) throws Exception {
      BufferedImage sourceImg = null;
      InputStream is = null;

      double var5;
      try {
         is = photo.getInputStream();
         sourceImg = ImageIO.read(is);
         int width = sourceImg.getWidth();
         int height = sourceImg.getHeight();
         var5 = (double)width * 1.0D / ((double)height * 1.0D);
      } catch (IOException var15) {
         throw new Exception("文件读取错误");
      } finally {
         if (is != null) {
            try {
               is.close();
            } catch (IOException var14) {
               var14.printStackTrace();
            }
         }

      }

      return var5;
   }

   public static void deleteFile(final String path) {
      Thread t = new Thread(new Runnable() {
         public void run() {
            try {
               String rootpath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
               String filePath = rootpath + File.separator + path.replace("/", File.separator);
               String fileForder = filePath.substring(0, filePath.lastIndexOf(File.separator));
               String fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
               File forder = new File(fileForder);
               File file = new File(forder, fileName);
               if (file.exists()) {
                  file.delete();
               }
            } catch (Exception var7) {
               var7.printStackTrace();
            }

         }
      });
      t.start();
   }

   public static void deleteFileByRealPath(final String filePath) {
      Thread t = new Thread(new Runnable() {
         public void run() {
            try {
               File file = new File(filePath);
               if (file.exists()) {
                  file.delete();
               }
            } catch (Exception var2) {
               var2.printStackTrace();
            }

         }
      });
      t.start();
   }

   public static String changeWebPathToFilePath(String path) {
      String filePath = "";
      String[] strArr = path.split("/");

      for(int i = 0; i < strArr.length; ++i) {
         if (i == strArr.length - 1) {
            filePath = filePath + strArr[i];
         } else {
            filePath = filePath + strArr[i] + File.separator;
         }
      }

      return filePath;
   }

   public static String changeFilePathToWebPath(String filepath) {
      String webpath = filepath.replaceAll("\\\\", "\\/");
      return webpath;
   }

   public static String getImgFileBase64String(String tdp_upfile_forder, String webPath) {
      String filePath = changeWebPathToFilePath(webPath);
      String targetFile = tdp_upfile_forder + filePath;
      System.out.println("转图片的路径;" + targetFile);
      File file = new File(targetFile);
      return file.exists() ? getImageBase64Str(file) : "";
   }

   public static String getImageBase64Str(File target) {
      InputStream in = null;
      byte[] data = null;

      try {
         in = new FileInputStream(target);
         data = new byte[in.available()];
         in.read(data);
         in.close();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

      BASE64Encoder encoder = new BASE64Encoder();
      return encoder.encode(data);
   }

   public static String getStrOfFile(File target) {
      InputStream in = null;
      byte[] data = null;

      try {
         in = new FileInputStream(target);
         data = new byte[in.available()];
         in.read(data);
      } catch (IOException var12) {
         var12.printStackTrace();
      } finally {
         try {
            in.close();
         } catch (IOException var11) {
            var11.printStackTrace();
         }

      }

      return new String(data);
   }

   public static String getImageBase64Str(byte[] buffer) {
      BASE64Encoder encoder = new BASE64Encoder();
      return encoder.encode(buffer);
   }

   public static boolean generateImageFromBase64Str(String base64Str, String targetFileName) {
      if (base64Str == null) {
         return false;
      } else {
         BASE64Decoder decoder = new BASE64Decoder();
         FileOutputStream out = null;

         boolean var5;
         try {
            byte[] b = decoder.decodeBuffer(base64Str);

            for(int i = 0; i < b.length; ++i) {
               if (b[i] < 0) {
                  b[i] = (byte)(b[i] + 256);
               }
            }

            File targetFile = new File(targetFileName);
            File forder = targetFile.getParentFile();
            if (!forder.exists()) {
               forder.mkdirs();
            }

            if (!targetFile.exists()) {
               forder.createNewFile();
            }

            out = new FileOutputStream(targetFile);
            out.write(b);
            out.flush();
            boolean var7 = true;
            return var7;
         } catch (Exception var17) {
            var5 = false;
         } finally {
            if (out != null) {
               try {
                  out.close();
               } catch (IOException var16) {
                  var16.printStackTrace();
               }
            }

         }

         return var5;
      }
   }

   public static byte[] generateImageFromBase64Str(String base64Str) {
      String base64Prix = "data:image/jpeg;base64,";
      if (base64Str.indexOf(base64Prix) >= 0) {
         base64Str = base64Str.substring(base64Prix.length());
      }

      if (base64Str == null) {
         return new byte[0];
      } else {
         BASE64Decoder decoder = new BASE64Decoder();
         Object out = null;

         try {
            byte[] b = decoder.decodeBuffer(base64Str);

            for(int i = 0; i < b.length; ++i) {
               if (b[i] < 0) {
                  b[i] = (byte)(b[i] + 256);
               }
            }

            byte[] var17 = b;
            return var17;
         } catch (Exception var15) {
            var15.printStackTrace();
         } finally {
            if (out != null) {
               try {
                  ((OutputStream)out).close();
               } catch (IOException var14) {
                  var14.printStackTrace();
               }
            }

         }

         return new byte[0];
      }
   }

   public static boolean deleteDir(File dir) {
      if (dir.isDirectory()) {
         String[] children = dir.list();

         for(int i = 0; i < children.length; ++i) {
            boolean success = deleteDir(new File(dir, children[i]));
            if (!success) {
               return false;
            }
         }
      }

      return dir.delete();
   }

   public static byte[] getFileByteArr(File file) throws Exception {
      InputStream is = new FileInputStream(file);
      int length = is.available();
      byte[] byteArr = new byte[length];
      is.read(byteArr);
      return byteArr;
   }

   public static File multipartFileToFile(MultipartFile file) throws Exception {
      File toFile = null;
      if (!file.equals("") && file.getSize() > 0L) {
         InputStream ins = null;
         ins = file.getInputStream();
         toFile = new File(file.getOriginalFilename());
         inputStreamToFile(ins, toFile);
         ins.close();
      } else {
         file = null;
      }

      return toFile;
   }

   private static void inputStreamToFile(InputStream ins, File file) {
      try {
         OutputStream os = new FileOutputStream(file);
         byte[] buffer = new byte[8192];

         int bytesRead;
         while((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
            os.write(buffer, 0, bytesRead);
         }

         os.close();
         ins.close();
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }

   public static byte[] compressImg(InputStream is, int minWidth) throws Exception {
      BufferedImage src = null;

      byte[] var11;
      try {
         src = ImageIO.read(is);
         int width = src.getWidth();
         int height = src.getHeight();
         double rate = 1.0D;
         if (minWidth < width) {
            rate = (double)minWidth * 1.0D / (double)width;
         }

         int destWidth = (int)((double)width * rate);
         int destHeight = (int)((double)height * rate);
         BufferedImage tag = new BufferedImage(destWidth, destHeight, 1);
         tag.getGraphics().drawImage(src.getScaledInstance(destWidth, destHeight, 4), 0, 0, (ImageObserver)null);
         ByteArrayOutputStream out = new ByteArrayOutputStream();
         ImageIO.write(tag, "jpg", out);
         var11 = out.toByteArray();
      } catch (IOException var20) {
         throw new Exception("文件读取错误");
      } finally {
         if (is != null) {
            try {
               is.close();
            } catch (IOException var19) {
               var19.printStackTrace();
            }
         }

      }

      return var11;
   }

   public static byte[] compressImg(byte[] arr, int minWidth) throws Exception {
      InputStream is = new ByteArrayInputStream(arr);
      return compressImg((InputStream)is, minWidth);
   }

   public static String compressImg(String base64Img, int maxWidth) throws Exception {
      byte[] arr = generateImageFromBase64Str(base64Img);
      byte[] result = compressImg(arr, maxWidth);
      String base64Result = getImageBase64Str(result);
      return base64Result;
   }

   public static byte[] compressImgToByte(String base64Img, int maxWidth) throws Exception {
      byte[] arr = generateImageFromBase64Str(base64Img);
      byte[] result = compressImg(arr, maxWidth);
      return result;
   }

   public static byte[] compressImgToByte(MultipartFile photo, int maxWidth) throws Exception {
      byte[] result = compressImg(photo.getInputStream(), maxWidth);
      return result;
   }

   public static String compressImg(MultipartFile photo, int maxWidth) throws Exception {
      byte[] result = compressImg(photo.getInputStream(), maxWidth);
      String base64Result = getImageBase64Str(result);
      return base64Result;
   }
}
