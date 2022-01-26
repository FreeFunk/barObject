package com.edgedo.common.util;

public class MapPointInfo {
   String formatted_address;
   String province;
   String city;
   String district;
   String sematic_description;
   String country;

   public String getFormatted_address() {
      return this.formatted_address;
   }

   public void setFormatted_address(String formatted_address) {
      this.formatted_address = formatted_address;
   }

   public String getProvince() {
      return this.province;
   }

   public void setProvince(String province) {
      this.province = province;
   }

   public String getCity() {
      return this.city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getDistrict() {
      return this.district;
   }

   public void setDistrict(String district) {
      this.district = district;
   }

   public String getSematic_description() {
      return this.sematic_description;
   }

   public void setSematic_description(String sematic_description) {
      this.sematic_description = sematic_description;
   }

   public String getCountry() {
      return this.country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public String toString() {
      return "BaiDuMapPointInfo{formatted_address='" + this.formatted_address + '\'' + ", province='" + this.province + '\'' + ", city='" + this.city + '\'' + ", district='" + this.district + '\'' + ", sematic_description='" + this.sematic_description + '\'' + ", country='" + this.country + '\'' + '}';
   }
}
