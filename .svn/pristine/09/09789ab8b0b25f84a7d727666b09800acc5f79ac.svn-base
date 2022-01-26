package com.edgedo.common.util;

import com.edgedo.common.base.BusinessException;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.conn.DefaultHttpResponseParserFactory;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicLineParser;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;

public class HttpRequestUtil {
   public static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36";

   public static Map<String, String> sendPostRequestHeader(String url, Map<String, String> params, Map<String, String> header) {
      HashMap result = new HashMap();

      try {
         URL postUrl = new URL(url);
         HttpURLConnection connection = (HttpURLConnection)postUrl.openConnection();
         connection.setRequestProperty("Content-type", "text/html");
         connection.setRequestProperty("Accept-Charset", "utf-8");
         connection.setRequestProperty("contentType", "utf-8");
         Set<String> keySet = header.keySet();
         Iterator var7 = keySet.iterator();

         String content;
         while(var7.hasNext()) {
            content = (String)var7.next();
            connection.setRequestProperty(content, (String)header.get(content));
         }

         connection.setDoOutput(true);
         connection.setDoInput(true);
         connection.setRequestMethod("POST");
         connection.setUseCaches(false);
         connection.setInstanceFollowRedirects(true);
         connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         connection.connect();
         DataOutputStream out = new DataOutputStream(connection.getOutputStream());
         content = "";
         Iterator var9 = params.entrySet().iterator();

         String line;
         while(var9.hasNext()) {
            Entry<String, String> entry = (Entry)var9.next();
            String key = (String)entry.getKey();
            line = (String)entry.getValue();
            if (content.length() == 0) {
               content = content + key + "=" + URLEncoder.encode(line, "UTF-8");
            } else {
               content = content + "&" + key + "=" + URLEncoder.encode(line, "UTF-8");
            }
         }

         out.writeBytes(content);
         out.flush();
         out.close();
         int code = connection.getResponseCode();
         if (code == 200) {
            String cookieskey = "Set-Cookie";
            Map<String, List<String>> maps = connection.getHeaderFields();
            List<String> coolist = (List)maps.get(cookieskey);
            if (coolist != null) {
               Iterator<String> it = coolist.iterator();
               StringBuffer sbu = new StringBuffer();

               while(it.hasNext()) {
                  sbu.append((String)it.next());
                  result.put("cookies", sbu.toString().replaceAll(" path=/; HttpOnly", "") + " admin=QHD");
               }
            }
         }

         InputStream inputStream = connection.getInputStream();
         BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
         StringBuilder sb = new StringBuilder("");

         while((line = reader.readLine()) != null) {
            sb.append(line);
         }

         inputStream.close();
         reader.close();
         connection.disconnect();
         result.put("msg", sb.toString());
         return result;
      } catch (Exception var15) {
         var15.printStackTrace();
         throw new BusinessException("请求失败post fail");
      }
   }

   public static String sendGetRequestHeader(String url, String param, Map<String, String> header) throws UnsupportedEncodingException, IOException {
      String result = "";
      BufferedReader in = null;
      String urlNameString = url + "?" + param;
      URL realUrl = new URL(urlNameString);
      URLConnection connection = realUrl.openConnection();
      connection.setConnectTimeout(50000);
      if (header != null) {
         Iterator it = header.entrySet().iterator();

         while(it.hasNext()) {
            Entry<String, String> entry = (Entry)it.next();
            System.out.println((String)entry.getKey() + ":" + (String)entry.getValue());
            connection.setRequestProperty((String)entry.getKey(), (String)entry.getValue());
         }
      }

      connection.setRequestProperty("accept", "*/*");
      connection.setRequestProperty("connection", "Keep-Alive");
      connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
      connection.connect();

      String line;
      for(in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8")); (line = in.readLine()) != null; result = result + line) {
      }

      if (in != null) {
         in.close();
      }

      return result;
   }

   public static String sendPostRequest(String url, Map<String, String> params, String accessToken) throws IOException {
      URL postUrl = new URL(url);
      HttpURLConnection connection = (HttpURLConnection)postUrl.openConnection();
      connection.setRequestProperty("Content-type", "text/html");
      connection.setRequestProperty("Accept-Charset", "utf-8");
      connection.setRequestProperty("contentType", "utf-8");
      connection.setRequestProperty("access-token", accessToken);
      connection.setDoOutput(true);
      connection.setDoInput(true);
      connection.setRequestMethod("POST");
      connection.setUseCaches(false);
      connection.setInstanceFollowRedirects(true);
      connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      connection.connect();
      DataOutputStream out = new DataOutputStream(connection.getOutputStream());
      String content = "";
      Iterator var7 = params.entrySet().iterator();

      String line;
      while(var7.hasNext()) {
         Entry<String, String> entry = (Entry)var7.next();
         line = (String)entry.getKey();
         String value = (String)entry.getValue();
         if (content.length() == 0) {
            content = content + line + "=" + URLEncoder.encode(value, "UTF-8");
         } else {
            content = content + "&" + line + "=" + URLEncoder.encode(value, "UTF-8");
         }
      }

      out.writeBytes(content);
      out.flush();
      out.close();
      InputStream inputStream = connection.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      StringBuilder sb = new StringBuilder("");

      while((line = reader.readLine()) != null) {
         sb.append(line);
      }

      inputStream.close();
      reader.close();
      connection.disconnect();
      return sb.toString();
   }

   public static Map<String, String> sendPostRequestStream1(String url, OutputStream temOs) throws Exception {
      Map<String, String> result = new HashMap();
      URL postUrl = new URL(url);
      HttpURLConnection connection = (HttpURLConnection)postUrl.openConnection();
      connection.setRequestProperty("Content-type", "text/html");
      connection.setRequestProperty("Accept-Charset", "utf-8");
      connection.setDoOutput(true);
      connection.setRequestMethod("POST");
      connection.setUseCaches(false);
      connection.setInstanceFollowRedirects(true);
      connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      connection.connect();
      if (temOs != null) {
         InputStream inputStream = connection.getInputStream();
         byte[] btImg = readInputStream(inputStream);
         OutputStream toClient = new BufferedOutputStream(temOs);
         toClient.write(btImg);
         toClient.flush();
         toClient.close();
      }

      int code = connection.getResponseCode();
      if (code == 200) {
         String cookieskey = "Set-Cookie";
         Map<String, List<String>> maps = connection.getHeaderFields();
         List<String> coolist = (List)maps.get(cookieskey);
         if (coolist != null) {
            Iterator<String> it = coolist.iterator();
            StringBuffer sbu = new StringBuffer();

            while(it.hasNext()) {
               sbu.append((String)it.next());
               result.put("cookies", sbu.toString().replaceAll(" path=/; HttpOnly", "") + " admin=QHD");
            }
         }
      }

      connection.disconnect();
      return result;
   }

   public static String sendPostRequestBody(String urlStr, String json) {
      StringBuffer buffer = new StringBuffer();
      OutputStream outputStream = null;
      InputStream inputStream = null;
      InputStreamReader inputStreamReader = null;
      BufferedReader bufferedReader = null;
      HttpURLConnection httpUrlConn = null;

      try {
         URL url = new URL(urlStr);
         httpUrlConn = (HttpURLConnection)url.openConnection();
         httpUrlConn.setDoOutput(true);
         httpUrlConn.setDoInput(true);
         httpUrlConn.setUseCaches(false);
         httpUrlConn.setRequestMethod("POST");
         outputStream = httpUrlConn.getOutputStream();
         outputStream.write(json.getBytes("UTF-8"));
         outputStream.flush();
         outputStream.close();
         inputStream = httpUrlConn.getInputStream();
         inputStreamReader = new InputStreamReader(inputStream, "utf-8");
         bufferedReader = new BufferedReader(inputStreamReader);
         String str = null;

         while((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
         }

         inputStream.close();
         inputStreamReader.close();
         bufferedReader.close();
         httpUrlConn.disconnect();
      } catch (Exception var30) {
         var30.printStackTrace();
      } finally {
         if (outputStream != null) {
            try {
               outputStream.close();
            } catch (IOException var29) {
               var29.printStackTrace();
            }
         }

         if (inputStream != null) {
            try {
               inputStream.close();
            } catch (IOException var28) {
               var28.printStackTrace();
            }
         }

         if (inputStreamReader != null) {
            try {
               inputStreamReader.close();
            } catch (IOException var27) {
               var27.printStackTrace();
            }
         }

         if (bufferedReader != null) {
            try {
               bufferedReader.close();
            } catch (IOException var26) {
               var26.printStackTrace();
            }
         }

         if (httpUrlConn != null) {
            httpUrlConn.disconnect();
         }

      }

      return buffer.toString();
   }

   public static byte[] readInputStream(InputStream inStream) throws Exception {
      ByteArrayOutputStream outStream = new ByteArrayOutputStream();
      byte[] buffer = new byte[10240];
      boolean var3 = false;

      int len;
      while((len = inStream.read(buffer)) != -1) {
         outStream.write(buffer, 0, len);
      }

      inStream.close();
      return outStream.toByteArray();
   }

   public static String sendGetRequest(String url) throws IOException {
      URL postUrl = new URL(url);
      HttpURLConnection connection = (HttpURLConnection)postUrl.openConnection();
      connection.setRequestProperty("Content-type", "text/html");
      connection.setRequestProperty("Accept-Charset", "utf-8");
      connection.setRequestProperty("contentType", "utf-8");
      connection.setDoOutput(true);
      connection.setDoInput(true);
      connection.setRequestMethod("GET");
      connection.setUseCaches(false);
      connection.setInstanceFollowRedirects(true);
      connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      connection.connect();
      DataOutputStream out = new DataOutputStream(connection.getOutputStream());
      out.writeBytes("");
      out.flush();
      out.close();
      InputStream inputStream = connection.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      StringBuilder sb = new StringBuilder("");

      String line;
      while((line = reader.readLine()) != null) {
         sb.append(line);
      }

      inputStream.close();
      reader.close();
      connection.disconnect();
      return sb.toString();
   }

   public static String sendPostRequest(String url, Map<String, String> params, Map<String, String> header) throws IOException {
      URL postUrl = new URL(url);
      HttpURLConnection connection = (HttpURLConnection)postUrl.openConnection();
      connection.setRequestProperty("Content-type", "text/html");
      connection.setRequestProperty("Accept-Charset", "utf-8");
      connection.setRequestProperty("contentType", "utf-8");
      Set<String> keySet = header.keySet();
      Iterator var6 = keySet.iterator();

      String content;
      while(var6.hasNext()) {
         content = (String)var6.next();
         connection.setRequestProperty(content, (String)header.get(content));
      }

      connection.setDoOutput(true);
      connection.setDoInput(true);
      connection.setRequestMethod("POST");
      connection.setUseCaches(false);
      connection.setInstanceFollowRedirects(true);
      connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      connection.connect();
      DataOutputStream out = new DataOutputStream(connection.getOutputStream());
      content = "";
      Iterator var8 = params.entrySet().iterator();

      String line;
      while(var8.hasNext()) {
         Entry<String, String> entry = (Entry)var8.next();
         line = (String)entry.getKey();
         String value = (String)entry.getValue();
         if (content.length() == 0) {
            content = content + line + "=" + URLEncoder.encode(value, "UTF-8");
         } else {
            content = content + "&" + line + "=" + URLEncoder.encode(value, "UTF-8");
         }
      }

      out.writeBytes(content);
      out.flush();
      out.close();
      InputStream inputStream = connection.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      StringBuilder sb = new StringBuilder("");

      while((line = reader.readLine()) != null) {
         sb.append(line);
      }

      inputStream.close();
      reader.close();
      connection.disconnect();
      return sb.toString();
   }

   public static Map<String, String> sendPostRequestStream(String url, Map<String, String> params, Map<String, String> header, OutputStream temOs) throws IOException {
      Map<String, String> result = new HashMap();
      URL postUrl = new URL(url);
      HttpURLConnection connection = (HttpURLConnection)postUrl.openConnection();
      connection.setRequestProperty("Content-type", "text/html");
      connection.setRequestProperty("Accept-Charset", "utf-8");
      connection.setRequestProperty("contentType", "utf-8");
      Set<String> keySet = header.keySet();
      Iterator var8 = keySet.iterator();

      String content;
      while(var8.hasNext()) {
         content = (String)var8.next();
         connection.setRequestProperty(content, (String)header.get(content));
      }

      connection.setDoOutput(true);
      connection.setRequestMethod("POST");
      connection.setUseCaches(false);
      connection.setInstanceFollowRedirects(true);
      connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      connection.connect();
      DataOutputStream out = new DataOutputStream(connection.getOutputStream());
      content = "";
      Iterator var10 = params.entrySet().iterator();

      while(var10.hasNext()) {
         Entry<String, String> entry = (Entry)var10.next();
         String key = (String)entry.getKey();
         String value = (String)entry.getValue();
         if (content.length() == 0) {
            content = content + key + "=" + URLEncoder.encode(value, "UTF-8");
         } else {
            content = content + "&" + key + "=" + URLEncoder.encode(value, "UTF-8");
         }
      }

      out.writeBytes(content);
      out.flush();
      out.close();
      if (temOs != null) {
         InputStream inputStream = connection.getInputStream();
         byte[] buf = new byte[4096];
         boolean var21 = false;

         int length;
         while((length = inputStream.read(buf)) > 0) {
            temOs.write(buf, 0, length);
         }

         temOs.close();
         inputStream.close();
      }

      int code = connection.getResponseCode();
      if (code == 200) {
         String cookieskey = "Set-Cookie";
         Map<String, List<String>> maps = connection.getHeaderFields();
         List<String> coolist = (List)maps.get(cookieskey);
         if (coolist != null) {
            Iterator<String> it = coolist.iterator();
            StringBuffer sbu = new StringBuffer();

            while(it.hasNext()) {
               sbu.append((String)it.next());
               result.put("cookies", sbu.toString().replaceAll(" path=/; HttpOnly", "") + " admin=QHD");
            }
         }
      }

      connection.disconnect();
      return result;
   }

   public static String sendPostRequest(String url, Map<String, String> params) {
      try {
         URL postUrl = new URL(url);
         HttpURLConnection connection = (HttpURLConnection)postUrl.openConnection();
         connection.setRequestProperty("Content-type", "text/html");
         connection.setRequestProperty("Accept-Charset", "utf-8");
         connection.setRequestProperty("contentType", "utf-8");
         connection.setDoOutput(true);
         connection.setDoInput(true);
         connection.setRequestMethod("POST");
         connection.setUseCaches(false);
         connection.setInstanceFollowRedirects(true);
         connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         connection.connect();
         DataOutputStream out = new DataOutputStream(connection.getOutputStream());
         String content = "";
         Iterator var6 = params.entrySet().iterator();

         String line;
         while(var6.hasNext()) {
            Entry<String, String> entry = (Entry)var6.next();
            line = (String)entry.getKey();
            String value = (String)entry.getValue();
            if (content.length() == 0) {
               content = content + line + "=" + URLEncoder.encode(value, "UTF-8");
            } else {
               content = content + "&" + line + "=" + URLEncoder.encode(value, "UTF-8");
            }
         }

         out.writeBytes(content);
         out.flush();
         out.close();
         InputStream inputStream = connection.getInputStream();
         BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
         StringBuilder sb = new StringBuilder("");

         while((line = reader.readLine()) != null) {
            sb.append(line);
         }

         inputStream.close();
         reader.close();
         connection.disconnect();
         return sb.toString();
      } catch (Exception var10) {
         var10.printStackTrace();
         throw new BusinessException("请求失败post fail");
      }
   }

   public static HttpRequestUtil.HttpResuestResponseStreamWrap postRequestByte(String urlStr, Map<String, Object> param) {
      String paramStr = formatParam(param);
      OutputStream outputStream = null;
      InputStream inputStream = null;
      HttpURLConnection httpUrlConn = null;

      try {
         URL url = new URL(urlStr);
         httpUrlConn = (HttpURLConnection)url.openConnection();
         httpUrlConn.setDoOutput(true);
         httpUrlConn.setDoInput(true);
         httpUrlConn.setUseCaches(false);
         httpUrlConn.setRequestMethod("POST");
         outputStream = httpUrlConn.getOutputStream();
         outputStream.write(paramStr.getBytes("utf-8"));
         outputStream.flush();
         outputStream.close();
         inputStream = httpUrlConn.getInputStream();
         return new HttpRequestUtil.HttpResuestResponseStreamWrap(inputStream, httpUrlConn, outputStream);
      } catch (Exception var10) {
         var10.printStackTrace();
         if (inputStream != null) {
            try {
               inputStream.close();
            } catch (IOException var9) {
               var9.printStackTrace();
            }
         }

         if (outputStream != null) {
            try {
               outputStream.close();
            } catch (IOException var8) {
               var8.printStackTrace();
            }
         }

         if (httpUrlConn != null) {
            httpUrlConn.disconnect();
         }

         return null;
      }
   }

   public static String postRequest(String urlStr, Map<String, Object> param) {
      String paramStr = formatParam(param);
      StringBuffer buffer = new StringBuffer();
      OutputStream outputStream = null;
      InputStream inputStream = null;
      InputStreamReader inputStreamReader = null;
      BufferedReader bufferedReader = null;
      HttpURLConnection httpUrlConn = null;

      try {
         URL url = new URL(urlStr);
         httpUrlConn = (HttpURLConnection)url.openConnection();
         httpUrlConn.setDoOutput(true);
         httpUrlConn.setDoInput(true);
         httpUrlConn.setUseCaches(false);
         httpUrlConn.setRequestMethod("POST");
         outputStream = httpUrlConn.getOutputStream();
         outputStream.write(paramStr.getBytes("utf-8"));
         outputStream.flush();
         outputStream.close();
         inputStream = httpUrlConn.getInputStream();
         inputStreamReader = new InputStreamReader(inputStream, "utf-8");
         bufferedReader = new BufferedReader(inputStreamReader);
         String str = null;

         while((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
         }

         inputStream.close();
         inputStreamReader.close();
         bufferedReader.close();
         httpUrlConn.disconnect();
      } catch (Exception var31) {
         var31.printStackTrace();
      } finally {
         if (outputStream != null) {
            try {
               outputStream.close();
            } catch (IOException var30) {
               var30.printStackTrace();
            }
         }

         if (inputStream != null) {
            try {
               inputStream.close();
            } catch (IOException var29) {
               var29.printStackTrace();
            }
         }

         if (inputStreamReader != null) {
            try {
               inputStreamReader.close();
            } catch (IOException var28) {
               var28.printStackTrace();
            }
         }

         if (bufferedReader != null) {
            try {
               bufferedReader.close();
            } catch (IOException var27) {
               var27.printStackTrace();
            }
         }

         if (httpUrlConn != null) {
            httpUrlConn.disconnect();
         }

      }

      return buffer.toString();
   }

   public static String formatParam(Map<String, Object> param) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      StringBuilder sb = new StringBuilder();
      Iterator var3 = param.entrySet().iterator();

      while(var3.hasNext()) {
         Entry<String, Object> entry = (Entry)var3.next();
         String key = (String)entry.getKey();
         Object value = entry.getValue();
         if (value != null) {
            if (value instanceof Date) {
               Date temDate = (Date)value;
               String valueStr = sdf.format(temDate);

               try {
                  sb.append((sb.length() > 0 ? "&" : "") + key + "=").append(URLEncoder.encode(valueStr, "UTF-8"));
               } catch (UnsupportedEncodingException var10) {
                  var10.printStackTrace();
               }
            } else {
               try {
                  sb.append((sb.length() > 0 ? "&" : "") + key + "=").append(URLEncoder.encode(value.toString(), "UTF-8"));
               } catch (UnsupportedEncodingException var11) {
                  var11.printStackTrace();
               }
            }
         }
      }

      return sb.toString();
   }

   public static String sendPostGbk(String urlStr, Map<String, String> params, Map<String, String> header) {
      int i = 0;
      StringBuffer sb = new StringBuffer("");

      try {
         URL url = new URL(urlStr);
         HttpURLConnection connection = (HttpURLConnection)url.openConnection();
         connection.setRequestProperty("Content-type", "text/html");
         connection.setRequestProperty("Accept-Charset", "utf-8");
         connection.setRequestProperty("contentType", "utf-8");
         if (header != null) {
            Set<String> keySet = header.keySet();
            Iterator var8 = keySet.iterator();

            while(var8.hasNext()) {
               String key = (String)var8.next();
               connection.setRequestProperty(key, (String)header.get(key));
            }
         }

         connection.setRequestMethod("POST");
         connection.setDoOutput(true);
         connection.connect();
         DataOutputStream out = new DataOutputStream(connection.getOutputStream());
         String content = "";
         Iterator var16 = params.entrySet().iterator();

         while(var16.hasNext()) {
            Entry<String, String> entry = (Entry)var16.next();
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            if (content.length() == 0) {
               content = content + key + "=" + URLEncoder.encode(value, "UTF-8");
            } else {
               content = content + "&" + key + "=" + URLEncoder.encode(value, "UTF-8");
            }
         }

         out.writeBytes(content);
         out.flush();
         out.close();
         BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "gbk"));
         String s = "";

         while((s = br.readLine()) != null) {
            ++i;
            sb.append(s + "\r\n");
         }
      } catch (Exception var13) {
         var13.printStackTrace();
      }

      return sb.toString();
   }

   public static String postRequest(String urlStr, Map<String, Object> param, File file) {
      String fileName = file.getName();
      FileInputStream inputStream = null;

      try {
         inputStream = new FileInputStream(file);
         MultipartEntityBuilder builder = MultipartEntityBuilder.create();
         Iterator var6 = param.entrySet().iterator();

         while(var6.hasNext()) {
            Entry<String, Object> entry = (Entry)var6.next();
            String key = (String)entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
               if (key.equals("file")) {
                  builder.addBinaryBody(key, inputStream, ContentType.create("multipart/form-data"), fileName);
               } else {
                  StringBody body = new StringBody((String)value, ContentType.create("multipart/form-data", "utf-8"));
                  builder.addPart(key, body);
               }
            }
         }

         HttpEntity entity = builder.build();
         HttpPost httpPost = new HttpPost(urlStr);
         httpPost.setEntity(entity);
         HttpClient httpClient = buildHttpClient();
         HttpResponse response = httpClient.execute(httpPost);
         String result = "";
         Integer statusCode = response.getStatusLine().getStatusCode();
         if (statusCode != null && statusCode == 200) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
         } else {
            System.out.println("请求地址" + urlStr + "错误状态" + response.getStatusLine().getStatusCode());
            EntityUtils.consume(entity);
         }

         return result;
      } catch (IOException var12) {
         var12.printStackTrace();
         return "";
      }
   }

   public static HttpClient buildHttpClient() {
      HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory = new ManagedHttpClientConnectionFactory(new DefaultHttpRequestWriterFactory(), new DefaultHttpResponseParserFactory(new HttpRequestUtil.MyLineParser(), new DefaultHttpResponseFactory()));
      PoolingHttpClientConnectionManager pccm = new PoolingHttpClientConnectionManager(httpConnectionFactory);
      pccm.setDefaultMaxPerRoute(50);
      pccm.setMaxTotal(300);
      HttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(RequestConfig.custom().setConnectionRequestTimeout(15000).setSocketTimeout(60000).setConnectTimeout(40000).build()).setRedirectStrategy(new LaxRedirectStrategy()).setConnectionManager(pccm).setRetryHandler(new DefaultHttpRequestRetryHandler(1, true)).setUserAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36").build();
      return httpClient;
   }

   static {
      HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
         public boolean verify(String hostname, SSLSession sslSession) {
            return true;
         }
      });
   }

   private static class MyLineParser extends BasicLineParser {
      private MyLineParser() {
      }

      public Header parseHeader(CharArrayBuffer buffer) throws ParseException {
         try {
            return super.parseHeader(buffer);
         } catch (ParseException var3) {
            return new BasicHeader("Invalid", buffer.toString());
         }
      }

      // $FF: synthetic method
      MyLineParser(Object x0) {
         this();
      }
   }

   public static class HttpResuestResponseStreamWrap {
      private InputStream inputStream = null;
      private HttpURLConnection httpUrlConn = null;
      private OutputStream outputStream = null;

      public HttpResuestResponseStreamWrap(InputStream is, HttpURLConnection httpUrlConn, OutputStream os) {
         this.inputStream = is;
         this.httpUrlConn = httpUrlConn;
         this.outputStream = os;
      }

      public void close() {
         if (this.inputStream != null) {
            try {
               this.inputStream.close();
            } catch (IOException var3) {
               var3.printStackTrace();
            }
         }

         if (this.outputStream != null) {
            try {
               this.outputStream.close();
            } catch (IOException var2) {
               var2.printStackTrace();
            }
         }

         if (this.httpUrlConn != null) {
            this.httpUrlConn.disconnect();
         }

      }

      public InputStream getInputStream() {
         return this.inputStream;
      }

      public void setInputStream(InputStream inputStream) {
         this.inputStream = inputStream;
      }

      public HttpURLConnection getHttpUrlConn() {
         return this.httpUrlConn;
      }

      public void setHttpUrlConn(HttpURLConnection httpUrlConn) {
         this.httpUrlConn = httpUrlConn;
      }
   }
}
