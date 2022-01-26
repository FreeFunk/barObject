package com.edgedo.common.util.oss;

import com.edgedo.common.util.oss.group.AliyunGroup;
import com.edgedo.common.util.oss.group.QcloudGroup;
import com.edgedo.common.util.oss.group.QiniuGroup;
import com.edgedo.common.util.oss.group.TcloudGroup;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(
   prefix = "cloud-storage-config"
)
public class CloudStorageConfig implements Serializable {
   private static final long serialVersionUID = 1L;
   @Range(
      min = 1L,
      max = 4L,
      message = "类型错误"
   )
   private Integer type;
   @NotBlank(
      message = "七牛绑定的域名不能为空",
      groups = {QiniuGroup.class}
   )
   @URL(
      message = "七牛绑定的域名格式不正确",
      groups = {QiniuGroup.class}
   )
   private String qiniuDomain;
   private String qiniuPrefix;
   @NotBlank(
      message = "七牛AccessKey不能为空",
      groups = {QiniuGroup.class}
   )
   private String qiniuAccessKey;
   @NotBlank(
      message = "七牛SecretKey不能为空",
      groups = {QiniuGroup.class}
   )
   private String qiniuSecretKey;
   @NotBlank(
      message = "七牛空间名不能为空",
      groups = {QiniuGroup.class}
   )
   private String qiniuBucketName;
   @NotBlank(
      message = "阿里云绑定的域名不能为空",
      groups = {AliyunGroup.class}
   )
   @URL(
      message = "阿里云绑定的域名格式不正确",
      groups = {AliyunGroup.class}
   )
   private String aliyunDomain;
   private String aliyunPrefix;
   @NotBlank(
      message = "阿里云EndPoint不能为空",
      groups = {AliyunGroup.class}
   )
   private String aliyunEndPoint;
   @NotBlank(
      message = "阿里云AccessKeyId不能为空",
      groups = {AliyunGroup.class}
   )
   private String aliyunAccessKeyId;
   @NotBlank(
      message = "阿里云AccessKeySecret不能为空",
      groups = {AliyunGroup.class}
   )
   private String aliyunAccessKeySecret;
   @NotBlank(
      message = "阿里云BucketName不能为空",
      groups = {AliyunGroup.class}
   )
   private String aliyunBucketName;
   @NotBlank(
      message = "腾讯云绑定的域名不能为空",
      groups = {QcloudGroup.class}
   )
   @URL(
      message = "腾讯云绑定的域名格式不正确",
      groups = {QcloudGroup.class}
   )
   private String qcloudDomain;
   private String qcloudPrefix;
   @NotNull(
      message = "腾讯云AppId不能为空",
      groups = {QcloudGroup.class}
   )
   private Integer qcloudAppId;
   @NotBlank(
      message = "腾讯云SecretId不能为空",
      groups = {QcloudGroup.class}
   )
   private String qcloudSecretId;
   @NotBlank(
      message = "腾讯云SecretKey不能为空",
      groups = {QcloudGroup.class}
   )
   private String qcloudSecretKey;
   @NotBlank(
      message = "腾讯云BucketName不能为空",
      groups = {QcloudGroup.class}
   )
   private String qcloudBucketName;
   @NotBlank(
      message = "所属地区不能为空",
      groups = {QcloudGroup.class}
   )
   private String qcloudRegion;
   private String tcloudDomain;
   private String tCloudPrefix;
   @NotBlank(
      message = "天翼云EndPoint不能为空",
      groups = {TcloudGroup.class}
   )
   private String tyiYunEndPoint;
   @NotBlank(
      message = "天翼云AccessKeyId不能为空",
      groups = {TcloudGroup.class}
   )
   private String tyiYunAccessKeyId;
   @NotBlank(
      message = "天翼云AccessKeySecret不能为空",
      groups = {TcloudGroup.class}
   )
   private String tyiYunAccessKeySecret;
   @NotBlank(
      message = "天翼云BucketName不能为空",
      groups = {TcloudGroup.class}
   )
   private String tcloudBucketName;
   @NotBlank(
      message = "所属地区不能为空",
      groups = {TcloudGroup.class}
   )
   private String tcloudRegion;

   public static long getSerialVersionUID() {
      return 1L;
   }

   public Integer getType() {
      return this.type;
   }

   public void setType(Integer type) {
      this.type = type;
   }

   public String getQiniuDomain() {
      return this.qiniuDomain;
   }

   public void setQiniuDomain(String qiniuDomain) {
      this.qiniuDomain = qiniuDomain;
   }

   public String getQiniuPrefix() {
      return this.qiniuPrefix;
   }

   public void setQiniuPrefix(String qiniuPrefix) {
      this.qiniuPrefix = qiniuPrefix;
   }

   public String getQiniuAccessKey() {
      return this.qiniuAccessKey;
   }

   public void setQiniuAccessKey(String qiniuAccessKey) {
      this.qiniuAccessKey = qiniuAccessKey;
   }

   public String getQiniuSecretKey() {
      return this.qiniuSecretKey;
   }

   public void setQiniuSecretKey(String qiniuSecretKey) {
      this.qiniuSecretKey = qiniuSecretKey;
   }

   public String getQiniuBucketName() {
      return this.qiniuBucketName;
   }

   public void setQiniuBucketName(String qiniuBucketName) {
      this.qiniuBucketName = qiniuBucketName;
   }

   public String getAliyunDomain() {
      return this.aliyunDomain;
   }

   public void setAliyunDomain(String aliyunDomain) {
      this.aliyunDomain = aliyunDomain;
   }

   public String getAliyunPrefix() {
      return this.aliyunPrefix;
   }

   public void setAliyunPrefix(String aliyunPrefix) {
      this.aliyunPrefix = aliyunPrefix;
   }

   public String getAliyunEndPoint() {
      return this.aliyunEndPoint;
   }

   public void setAliyunEndPoint(String aliyunEndPoint) {
      this.aliyunEndPoint = aliyunEndPoint;
   }

   public String getAliyunAccessKeyId() {
      return this.aliyunAccessKeyId;
   }

   public void setAliyunAccessKeyId(String aliyunAccessKeyId) {
      this.aliyunAccessKeyId = aliyunAccessKeyId;
   }

   public String getAliyunAccessKeySecret() {
      return this.aliyunAccessKeySecret;
   }

   public void setAliyunAccessKeySecret(String aliyunAccessKeySecret) {
      this.aliyunAccessKeySecret = aliyunAccessKeySecret;
   }

   public String getAliyunBucketName() {
      return this.aliyunBucketName;
   }

   public void setAliyunBucketName(String aliyunBucketName) {
      this.aliyunBucketName = aliyunBucketName;
   }

   public String getQcloudDomain() {
      return this.qcloudDomain;
   }

   public void setQcloudDomain(String qcloudDomain) {
      this.qcloudDomain = qcloudDomain;
   }

   public String getQcloudPrefix() {
      return this.qcloudPrefix;
   }

   public void setQcloudPrefix(String qcloudPrefix) {
      this.qcloudPrefix = qcloudPrefix;
   }

   public Integer getQcloudAppId() {
      return this.qcloudAppId;
   }

   public void setQcloudAppId(Integer qcloudAppId) {
      this.qcloudAppId = qcloudAppId;
   }

   public String getQcloudSecretId() {
      return this.qcloudSecretId;
   }

   public void setQcloudSecretId(String qcloudSecretId) {
      this.qcloudSecretId = qcloudSecretId;
   }

   public String getQcloudSecretKey() {
      return this.qcloudSecretKey;
   }

   public void setQcloudSecretKey(String qcloudSecretKey) {
      this.qcloudSecretKey = qcloudSecretKey;
   }

   public String getQcloudBucketName() {
      return this.qcloudBucketName;
   }

   public void setQcloudBucketName(String qcloudBucketName) {
      this.qcloudBucketName = qcloudBucketName;
   }

   public String getQcloudRegion() {
      return this.qcloudRegion;
   }

   public void setQcloudRegion(String qcloudRegion) {
      this.qcloudRegion = qcloudRegion;
   }

   public String getTcloudDomain() {
      return this.tcloudDomain;
   }

   public void setTcloudDomain(String tcloudDomain) {
      this.tcloudDomain = tcloudDomain;
   }

   public String getTyiYunAccessKeyId() {
      return this.tyiYunAccessKeyId;
   }

   public void setTyiYunAccessKeyId(String tyiYunAccessKeyId) {
      this.tyiYunAccessKeyId = tyiYunAccessKeyId;
   }

   public String getTyiYunAccessKeySecret() {
      return this.tyiYunAccessKeySecret;
   }

   public void setTyiYunAccessKeySecret(String tyiYunAccessKeySecret) {
      this.tyiYunAccessKeySecret = tyiYunAccessKeySecret;
   }

   public String getTcloudBucketName() {
      return this.tcloudBucketName;
   }

   public void setTcloudBucketName(String tcloudBucketName) {
      this.tcloudBucketName = tcloudBucketName;
   }

   public String getTcloudRegion() {
      return this.tcloudRegion;
   }

   public void setTcloudRegion(String tcloudRegion) {
      this.tcloudRegion = tcloudRegion;
   }

   public String getTyiYunEndPoint() {
      return this.tyiYunEndPoint;
   }

   public void setTyiYunEndPoint(String tyiYunEndPoint) {
      this.tyiYunEndPoint = tyiYunEndPoint;
   }

   public String gettCloudPrefix() {
      return this.tCloudPrefix;
   }

   public void settCloudPrefix(String tCloudPrefix) {
      this.tCloudPrefix = tCloudPrefix;
   }
}
