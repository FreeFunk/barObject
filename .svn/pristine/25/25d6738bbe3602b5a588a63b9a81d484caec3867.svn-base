package com.edgedo.barwxqt.service;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.barwxqt.entity.WxUser;
import com.edgedo.common.util.AesDecryptUtil;
import com.edgedo.common.util.HttpRequestUtil;
import com.edgedo.common.util.SysStringEncryptor;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

@ConditionalOnProperty(
   value = {"app.wx_minprogram.oraId"},
   matchIfMissing = false
)
@Service
public class WxMiniProgramServiceImpl implements IWxMiniProgramService {
   @Value("${app.wx_minprogram.oraId}")
   private String wx_minprogram_oraId;
   @Value("${app.wx.appid}")
   private String appId;
   @Value("${app.wx.appScre}")
   private String appSecret;
   private static final String miniProgramLogin = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
   StringEncryptor enc = new SysStringEncryptor();

   @Override
   public WxUser wxMiniProgramLogin(String code, String encryptedData, String iv) {
//      String appScreDecode = this.enc.decrypt(this.appSecret);
      String url = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code".replace("APPID", this.appId).replace("SECRET", appSecret).replace("JSCODE", code);
      String response = HttpRequestUtil.postRequest(url, new HashMap());
      JSONObject sessionKeyObj = JSONObject.parseObject(response);
      String openId = (String)sessionKeyObj.get("openid");
      String session_key = (String)sessionKeyObj.get("session_key");
      AesDecryptUtil decryptUtil = new AesDecryptUtil();
      byte[] data = decryptUtil.decrypt(encryptedData, session_key, iv);

      try {
         String json = new String(data, "UTF-8");
         JSONObject jsonObject = JSONObject.parseObject(json);
         if (openId == null) {
            return null;
         } else {
            String nickName = (String)jsonObject.get("nickName") + "";
            String gender = jsonObject.get("gender") + "";
            String city = (String)jsonObject.get("city");
            String province = (String)jsonObject.get("province");
            String country = (String)jsonObject.get("country");
            String avatarUrl = (String)jsonObject.get("avatarUrl");
            String unionId = (String)jsonObject.get("unionId");
            WxUser wxUser = new WxUser();
            wxUser.setSessionKey(session_key);
            wxUser.setCity(city);
            wxUser.setProvince(province);
            wxUser.setCountry(country);
            wxUser.setGender(gender);
            wxUser.setAvatarUrl(avatarUrl);
            wxUser.setNickName(nickName);
            wxUser.setOpenId(openId);
            wxUser.setUnionId(unionId);
            wxUser.setOraId(this.wx_minprogram_oraId);
            return wxUser;
         }
      } catch (UnsupportedEncodingException var23) {
         var23.printStackTrace();
         return null;
      }
   }
}
