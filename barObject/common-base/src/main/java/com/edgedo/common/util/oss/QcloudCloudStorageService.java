package com.edgedo.common.util.oss;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.common.base.BusinessException;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.request.UploadFileRequest;
import com.qcloud.cos.sign.Credentials;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

public class QcloudCloudStorageService extends CloudStorageService {
   private COSClient client;

   public QcloudCloudStorageService(CloudStorageConfig config) {
      this.config = config;
      this.init();
   }

   private void init() {
      Credentials credentials = new Credentials((long)this.config.getQcloudAppId(), this.config.getQcloudSecretId(), this.config.getQcloudSecretKey());
      ClientConfig clientConfig = new ClientConfig();
      clientConfig.setRegion(this.config.getQcloudRegion());
      this.client = new COSClient(clientConfig, credentials);
   }

   public String upload(byte[] data, String path) {
      if (!path.startsWith("/")) {
         path = "/" + path;
      }

      UploadFileRequest request = new UploadFileRequest(this.config.getQcloudBucketName(), path, data);
      String response = this.client.uploadFile(request);
      JSONObject jsonObject = JSONObject.parseObject(response);
      if (jsonObject.getInteger("code") != 0) {
         throw new BusinessException("文件上传失败，" + jsonObject.getString("message"));
      } else {
         return this.config.getQcloudDomain() + path;
      }
   }

   public String upload(InputStream inputStream, String path) {
      try {
         byte[] data = IOUtils.toByteArray(inputStream);
         return this.upload(data, path);
      } catch (IOException var4) {
         throw new BusinessException("上传文件失败", var4);
      }
   }

   public String uploadSuffix(byte[] data, String suffix) {
      return this.upload(data, this.getPath(this.config.getQcloudPrefix(), suffix));
   }

   public String uploadSuffix(InputStream inputStream, String suffix) {
      return this.upload(inputStream, this.getPath(this.config.getQcloudPrefix(), suffix));
   }
}
