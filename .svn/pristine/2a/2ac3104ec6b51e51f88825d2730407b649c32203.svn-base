package com.edgedo.common.util.oss;

import com.edgedo.common.util.IocUtil;
import org.springframework.stereotype.Component;

@Component
public final class OSSFactory {
   public static CloudStorageService build() {
      CloudStorageConfig config = (CloudStorageConfig)IocUtil.getBean(CloudStorageConfig.class);
      return new AliyunCloudStorageService(config);
   }
}
