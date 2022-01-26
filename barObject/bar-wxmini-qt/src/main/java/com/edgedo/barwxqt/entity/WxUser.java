package com.edgedo.barwxqt.entity;

public class WxUser {
   private String openId;
   private String nickName;
   private String gender;
   private String city;
   private String province;
   private String country;
   private String avatarUrl;
   private String unionId;
   private String phoneNum;
   private String oraId;
   private String sessionKey;

   public String getSessionKey() {
      return this.sessionKey;
   }

   public void setSessionKey(String sessionKey) {
      this.sessionKey = sessionKey;
   }

   public String getOraId() {
      return this.oraId;
   }

   public void setOraId(String oraId) {
      this.oraId = oraId;
   }

   public String getPhoneNum() {
      return this.phoneNum;
   }

   public void setPhoneNum(String phoneNum) {
      this.phoneNum = phoneNum;
   }

   public String getOpenId() {
      return this.openId;
   }

   public void setOpenId(String openId) {
      this.openId = openId;
   }

   public String getNickName() {
      return this.nickName;
   }

   public void setNickName(String nickName) {
      this.nickName = nickName;
   }

   public String getGender() {
      return this.gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public String getCity() {
      return this.city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getProvince() {
      return this.province;
   }

   public void setProvince(String province) {
      this.province = province;
   }

   public String getCountry() {
      return this.country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public String getAvatarUrl() {
      return this.avatarUrl;
   }

   public void setAvatarUrl(String avatarUrl) {
      this.avatarUrl = avatarUrl;
   }

   public String getUnionId() {
      return this.unionId;
   }

   public void setUnionId(String unionId) {
      this.unionId = unionId;
   }

   public String toString() {
      return "WxUser{openId='" + this.openId + '\'' + ", nickName='" + this.nickName + '\'' + ", gender='" + this.gender + '\'' + ", city='" + this.city + '\'' + ", province='" + this.province + '\'' + ", country='" + this.country + '\'' + ", avatarUrl='" + this.avatarUrl + '\'' + ", unionId='" + this.unionId + '\'' + '}';
   }
}
