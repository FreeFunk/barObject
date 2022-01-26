package com.edgedo.common.util.oss;

import com.aliyun.oss.OSSClient;
import com.edgedo.common.base.BusinessException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AliyunCloudStorageService extends CloudStorageService {
   private OSSClient client;

   public AliyunCloudStorageService(CloudStorageConfig config) {
      this.config = config;
      this.init();
   }

   private void init() {
      this.client = new OSSClient(this.config.getAliyunEndPoint(), this.config.getAliyunAccessKeyId(), this.config.getAliyunAccessKeySecret());
   }

   public String upload(byte[] data, String path) {
      return this.upload((InputStream)(new ByteArrayInputStream(data)), path);
   }

   public String upload(InputStream inputStream, String path) {
      try {
         this.client.putObject(this.config.getAliyunBucketName(), path, inputStream);
      } catch (Exception var4) {
         throw new BusinessException("上传文件失败，请检查配置信息", var4);
      }

      return this.config.getAliyunDomain() + "/" + path;
   }

   public String uploadSuffix(byte[] data, String suffix) {
      return this.upload(data, this.getPath(this.config.getAliyunPrefix(), suffix));
   }

   public String uploadSuffix(InputStream inputStream, String suffix) {
      return this.upload(inputStream, this.getPath(this.config.getAliyunPrefix(), suffix));
   }
}
