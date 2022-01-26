package com.edgedo.common.util;

import com.alibaba.fastjson.JSONObject;
import java.awt.geom.Point2D.Double;
import java.io.IOException;
import java.util.List;

public class BaiDuMapApiUtil {
   String geocoderAk = "zQTyHWw2m3T2pGVUylSprh13n5680CYf";
   private static final String BAIDU_Geocoder_URL = "http://api.map.baidu.com/geocoder/v2/?location=经纬度&output=json&pois=0&latest_admin=1&ak=反查秘钥";
   private static double EARTH_RADIUS = 6378.137D;

   public BaiDuMapApiUtil(String geocoderAk) {
      this.geocoderAk = geocoderAk;
   }

   public BaiDuMapApiUtil() {
   }

   public MapPointInfo latLongSearch(String latLong) throws IOException {
      return latLongSearch(latLong, this.geocoderAk);
   }

   public static MapPointInfo latLongSearch(String latLong, String ak) throws IOException {
      String url = "http://api.map.baidu.com/geocoder/v2/?location=经纬度&output=json&pois=0&latest_admin=1&ak=反查秘钥".replaceAll("经纬度", latLong);
      url = url.replaceAll("反查秘钥", ak);
      String res = HttpRequestUtil.sendGetRequest(url);
      JSONObject obj = JSONObject.parseObject(res);
      String status = obj.get("status") + "";
      if (status != null && status.equals("0")) {
         JSONObject resultObj = (JSONObject)obj.get("result");
         JSONObject addressComponentObj = (JSONObject)resultObj.get("addressComponent");
         String formatted_address = resultObj.get("formatted_address") + "";
         String country = addressComponentObj.get("country") + "";
         String province = addressComponentObj.get("province") + "";
         String city = addressComponentObj.get("city") + "";
         String district = addressComponentObj.get("district") + "";
         String sematic_description = resultObj.get("sematic_description") + "";
         MapPointInfo pointInfo = new MapPointInfo();
         pointInfo.setFormatted_address(formatted_address);
         pointInfo.setCountry(country);
         pointInfo.setProvince(province);
         pointInfo.setCity(city);
         pointInfo.setDistrict(district);
         pointInfo.setSematic_description(sematic_description);
         return pointInfo;
      } else {
         return null;
      }
   }

   public static String roadSearch(String lat, String ln) {
      String url = "http://g.gpsoo.net/o.jsp?i=" + ln + "," + lat + ",0&map=baidu";

      try {
         String res = HttpRequestUtil.sendGetRequest(url);
         return res;
      } catch (IOException var4) {
         var4.printStackTrace();
         return null;
      }
   }

   public String getGeocoderAk() {
      return this.geocoderAk;
   }

   public void setGeocoderAk(String geocoderAk) {
      this.geocoderAk = geocoderAk;
   }

   private static double rad(double d) {
      return d * 3.141592653589793D / 180.0D;
   }

   public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
      double radLat1 = rad(lat1);
      double radLat2 = rad(lat2);
      double a = radLat1 - radLat2;
      double b = rad(lng1) - rad(lng2);
      double s = 2.0D * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2.0D), 2.0D) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2.0D), 2.0D)));
      s *= EARTH_RADIUS;
      s = (double)Math.round(s * 10000.0D) / 10000.0D;
      s *= 1000.0D;
      return s;
   }

   public static boolean isInCircle(double radius, double lat1, double lng1, double lat2, double lng2) {
      double radLat1 = rad(lat1);
      double radLat2 = rad(lat2);
      double a = radLat1 - radLat2;
      double b = rad(lng1) - rad(lng2);
      double s = 2.0D * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2.0D), 2.0D) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2.0D), 2.0D)));
      s *= EARTH_RADIUS;
      s = (double)(Math.round(s * 10000.0D) / 10000L);
      return !(s > radius);
   }

   public static boolean isInRectangleArea(double lat, double lng, double minLat, double maxLat, double minLng, double maxLng) {
      if (isInRange(lat, minLat, maxLat)) {
         if (minLng * maxLng > 0.0D) {
            return isInRange(lng, minLng, maxLng);
         } else if (Math.abs(minLng) + Math.abs(maxLng) < 180.0D) {
            return isInRange(lng, minLng, maxLng);
         } else {
            double left = Math.max(minLng, maxLng);
            double right = Math.min(minLng, maxLng);
            return isInRange(lng, left, 180.0D) || isInRange(lng, right, -180.0D);
         }
      } else {
         return false;
      }
   }

   public static boolean isInRange(double point, double left, double right) {
      return point >= Math.min(left, right) && point <= Math.max(left, right);
   }

   public static boolean isInPolygon(Double point, List<Double> pts) {
      int N = pts.size();
      boolean boundOrVertex = true;
      int intersectCount = 0;
      double precision = 2.0E-10D;
      Double p = point;
      Double p1 = (Double)pts.get(0);

      for(int i = 1; i <= N; ++i) {
         if (p.equals(p1)) {
            return boundOrVertex;
         }

         Double p2 = (Double)pts.get(i % N);
         if (!(p.x < Math.min(p1.x, p2.x)) && !(p.x > Math.max(p1.x, p2.x))) {
            if (p.x > Math.min(p1.x, p2.x) && p.x < Math.max(p1.x, p2.x)) {
               if (p.y <= Math.max(p1.y, p2.y)) {
                  if (p1.x == p2.x && p.y >= Math.min(p1.y, p2.y)) {
                     return boundOrVertex;
                  }

                  if (p1.y == p2.y) {
                     if (p1.y == p.y) {
                        return boundOrVertex;
                     }

                     ++intersectCount;
                  } else {
                     double xinters = (p.x - p1.x) * (p2.y - p1.y) / (p2.x - p1.x) + p1.y;
                     if (Math.abs(p.y - xinters) < precision) {
                        return boundOrVertex;
                     }

                     if (p.y < xinters) {
                        ++intersectCount;
                     }
                  }
               }
            } else if (p.x == p2.x && p.y <= p2.y) {
               Double p3 = (Double)pts.get((i + 1) % N);
               if (p.x >= Math.min(p1.x, p3.x) && p.x <= Math.max(p1.x, p3.x)) {
                  ++intersectCount;
               } else {
                  intersectCount += 2;
               }
            }

            p1 = p2;
         } else {
            p1 = p2;
         }
      }

      if (intersectCount % 2 == 0) {
         return false;
      } else {
         return true;
      }
   }

   public static double[] map_tx2bd(double lat, double lon) {
      double x_pi = 3.141592653589793D;
      double z = Math.sqrt(lon * lon + lat * lat) + 2.0E-5D * Math.sin(lat * x_pi);
      double theta = Math.atan2(lat, lon) + 3.0E-6D * Math.cos(lon * x_pi);
      double bd_lon = z * Math.cos(theta) + 0.0065D;
      double bd_lat = z * Math.sin(theta) + 0.006D;
      return new double[]{bd_lat, bd_lon};
   }

   public static String map_tx2bd(String latLn) {
      String[] latLnArr = latLn.split(",");
      double lat = new java.lang.Double(latLnArr[0]);
      double ln = new java.lang.Double(latLnArr[1]);
      double[] pointArr = map_tx2bd(lat, ln);
      String result = pointArr[0] + "," + pointArr[1];
      return result;
   }

   public static double[] map_bd2tx(double lat, double lon) {
      double x_pi = 3.141592653589793D;
      double x = lon - 0.0065D;
      double y = lat - 0.006D;
      double z = Math.sqrt(x * x + y * y) - 2.0E-5D * Math.sin(y * x_pi);
      double theta = Math.atan2(y, x) - 3.0E-6D * Math.cos(x * x_pi);
      double tx_lon = z * Math.cos(theta);
      double tx_lat = z * Math.sin(theta);
      return new double[]{tx_lat, tx_lon};
   }

   public static String map_bd2tx(String latLn) {
      String[] latLnArr = latLn.split(",");
      double lat = new java.lang.Double(latLnArr[0]);
      double ln = new java.lang.Double(latLnArr[1]);
      double[] pointArr = map_bd2tx(lat, ln);
      String result = pointArr[0] + "," + pointArr[1];
      return result;
   }

   public static class GpsToBaidu {
      static double pi = 3.141592653589793D;
      static double a = 6378245.0D;
      static double ee = 0.006693421622965943D;
      public static final double x_pi = 52.35987755982988D;

      public static double[] wgs2bd(double lat, double lon) {
         double[] wgs2gcj = wgs2gcj(lat, lon);
         double[] gcj2bd = gcj2bd(wgs2gcj[0], wgs2gcj[1]);
         return gcj2bd;
      }

      public static double[] gcj2bd(double lat, double lon) {
         double z = Math.sqrt(lon * lon + lat * lat) + 2.0E-5D * Math.sin(lat * 52.35987755982988D);
         double theta = Math.atan2(lat, lon) + 3.0E-6D * Math.cos(lon * 52.35987755982988D);
         double bd_lon = z * Math.cos(theta) + 0.0065D;
         double bd_lat = z * Math.sin(theta) + 0.006D;
         return new double[]{bd_lat, bd_lon};
      }

      public static double[] bd2gcj(double lat, double lon) {
         double x = lon - 0.0065D;
         double y = lat - 0.006D;
         double z = Math.sqrt(x * x + y * y) - 2.0E-5D * Math.sin(y * 52.35987755982988D);
         double theta = Math.atan2(y, x) - 3.0E-6D * Math.cos(x * 52.35987755982988D);
         double gg_lon = z * Math.cos(theta);
         double gg_lat = z * Math.sin(theta);
         return new double[]{gg_lat, gg_lon};
      }

      public static double[] wgs2gcj(double lat, double lon) {
         double dLat = transformLat(lon - 105.0D, lat - 35.0D);
         double dLon = transformLon(lon - 105.0D, lat - 35.0D);
         double radLat = lat / 180.0D * pi;
         double magic = Math.sin(radLat);
         magic = 1.0D - ee * magic * magic;
         double sqrtMagic = Math.sqrt(magic);
         dLat = dLat * 180.0D / (a * (1.0D - ee) / (magic * sqrtMagic) * pi);
         dLon = dLon * 180.0D / (a / sqrtMagic * Math.cos(radLat) * pi);
         double mgLat = lat + dLat;
         double mgLon = lon + dLon;
         double[] loc = new double[]{mgLat, mgLon};
         return loc;
      }

      private static double transformLat(double lat, double lon) {
         double ret = -100.0D + 2.0D * lat + 3.0D * lon + 0.2D * lon * lon + 0.1D * lat * lon + 0.2D * Math.sqrt(Math.abs(lat));
         ret += (20.0D * Math.sin(6.0D * lat * pi) + 20.0D * Math.sin(2.0D * lat * pi)) * 2.0D / 3.0D;
         ret += (20.0D * Math.sin(lon * pi) + 40.0D * Math.sin(lon / 3.0D * pi)) * 2.0D / 3.0D;
         ret += (160.0D * Math.sin(lon / 12.0D * pi) + 320.0D * Math.sin(lon * pi / 30.0D)) * 2.0D / 3.0D;
         return ret;
      }

      private static double transformLon(double lat, double lon) {
         double ret = 300.0D + lat + 2.0D * lon + 0.1D * lat * lat + 0.1D * lat * lon + 0.1D * Math.sqrt(Math.abs(lat));
         ret += (20.0D * Math.sin(6.0D * lat * pi) + 20.0D * Math.sin(2.0D * lat * pi)) * 2.0D / 3.0D;
         ret += (20.0D * Math.sin(lat * pi) + 40.0D * Math.sin(lat / 3.0D * pi)) * 2.0D / 3.0D;
         ret += (150.0D * Math.sin(lat / 12.0D * pi) + 300.0D * Math.sin(lat / 30.0D * pi)) * 2.0D / 3.0D;
         return ret;
      }
   }
}
