package com.edgedo.common.util;

import com.alibaba.fastjson.JSONObject;
import java.io.IOException;

public class GaoDeMapApiUtil {
   String geocoderAk = "56945b4f11d5fcb5701e03f775c5c8c0";
   private static final String GAODE_Geocoder_URL = "https://restapi.amap.com/v3/geocode/regeo?location=经纬度&poitype=JSON&pois=TYPECODE&extensions=all&key=反查秘钥";

   public GaoDeMapApiUtil(String geocoderAk) {
      this.geocoderAk = geocoderAk;
   }

   public GaoDeMapApiUtil() {
   }

   public MapPointInfo latLongSearch(String latLong) throws IOException {
      return latLongSearch(latLong, this.geocoderAk);
   }

   public static MapPointInfo latLongSearch(String latLong, String ak) throws IOException {
      String url = "https://restapi.amap.com/v3/geocode/regeo?location=经纬度&poitype=JSON&pois=TYPECODE&extensions=all&key=反查秘钥".replaceAll("经纬度", latLong);
      url = url.replaceAll("反查秘钥", ak);
      String res = HttpRequestUtil.sendGetRequest(url);
      JSONObject obj = JSONObject.parseObject(res);
      String status = obj.get("status") + "";
      System.out.println(res);
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

   public String getGeocoderAk() {
      return this.geocoderAk;
   }

   public void setGeocoderAk(String geocoderAk) {
      this.geocoderAk = geocoderAk;
   }
}
