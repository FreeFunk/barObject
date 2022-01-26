package com.edgedo.common.util;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class AesDecryptUtil {
   final String KEY_ALGORITHM = "AES";
   final String algorithmStr = "AES/CBC/PKCS7Padding";
   private Key key;
   private Cipher cipher;

   public void init(byte[] keyBytes) {
      int base = 16;
      if (keyBytes.length % base != 0) {
         int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
         byte[] temp = new byte[groups * base];
         Arrays.fill(temp, (byte)0);
         System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
         keyBytes = temp;
      }

      Security.addProvider(new BouncyCastleProvider());
      this.key = new SecretKeySpec(keyBytes, "AES");

      try {
         this.cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
      } catch (NoSuchAlgorithmException var5) {
         var5.printStackTrace();
      } catch (NoSuchPaddingException var6) {
         var6.printStackTrace();
      }

   }

   public byte[] decrypt(String encryptedDataStr, String keyBytesStr, String ivStr) {
      byte[] encryptedText = null;
      byte[] encryptedData = null;
      byte[] sessionkey = null;
      Object var7 = null;

      try {
         sessionkey = Base64.decodeBase64(keyBytesStr);
         encryptedData = Base64.decodeBase64(encryptedDataStr);
         byte[] iv = Base64.decodeBase64(ivStr);
         this.init(sessionkey);
         this.cipher.init(2, this.key, new IvParameterSpec(iv));
         encryptedText = this.cipher.doFinal(encryptedData);
      } catch (Exception var9) {
         var9.printStackTrace();
      }

      return encryptedText;
   }
}
