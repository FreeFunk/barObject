package com.edgedo.barwxqt.controller;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.barwxqt.entity.SysUser;
import com.edgedo.barwxqt.entity.SysWxUser;
import com.edgedo.barwxqt.entity.WxUser;
import com.edgedo.barwxqt.queryvo.SysUserView;
import com.edgedo.barwxqt.service.IWxMiniProgramService;
import com.edgedo.barwxqt.service.SysUserService;
import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.common.util.AesDecryptUtil;
import com.edgedo.common.util.Guid;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:Qiutianzhu
 * @date 2021-04-08 21:12
 * @description:
 */
@Controller
@RequestMapping("/wxMin")
public class SysUserWxController extends BaseController {

    @Value("${app.wx.appid}")
    private String appId;

    @Value("${app.wx.appScre}")
    private String appSecret;

    @Autowired
    IWxMiniProgramService wxMiniProgramService;
    @Autowired
    private SysUserService sysUserService;

    @Pass
    @RequestMapping("/login")
    public ModelAndView login(String code, String encryptedData, String iv) {
        ModelAndView mav = new ModelAndView();
        WxUser wxUser = this.wxMiniProgramService.wxMiniProgramLogin(code, encryptedData, iv);
        SysUserView loginSysWxinUser = this.changeMiniUserToSysWxUser(wxUser);
        loginSysWxinUser.setLastSessionKey(wxUser.getSessionKey());
        Map<String, Object> result = new HashMap();

        SysUserView sysUserView = sysUserService.saveOrUpdate(loginSysWxinUser);
        loginSysWxinUser.setId(sysUserView.getId());
        result.put("accessToken", sysUserView.getOpenId());
        result.put("wxUser", loginSysWxinUser);
        return this.buildResponse(mav, result);
    }

    private SysUserView changeMiniUserToSysWxUser(WxUser wxUser) {
        String openId = wxUser.getOpenId();
        SysUserView sysWxUser = new SysUserView();
        sysWxUser.setOpenId(openId);
        String nickName = wxUser.getNickName();
        sysWxUser.setUserAccount(nickName);
        sysWxUser.setCity(wxUser.getCity());
        sysWxUser.setCountry(wxUser.getCountry());
        sysWxUser.setCreateTime(new Date());
        sysWxUser.setUserHead(wxUser.getAvatarUrl());
        String phoneNum = wxUser.getPhoneNum();
        if (phoneNum != null && phoneNum.length() > 0) {
            sysWxUser.setUserTel(phoneNum);
        }

        sysWxUser.setProvince(wxUser.getProvince());
        sysWxUser.setLastSessionKey(wxUser.getSessionKey());
        return sysWxUser;
    }

    /**
     * @author:Qiutianzhu
     * @Description: 获取手机号
     * @Date: 2021/4/10 11:07
     * @param encryptedData:
     * @param iv:
     * @return: org.springframework.web.servlet.ModelAndView
     **/
    @Pass
    @RequestMapping({"/getPhoneNumber"})
    public ModelAndView getPhoneNumber(String encryptedData, String iv,String sessionKey,String userId) {
        ModelAndView mav = new ModelAndView();
        SysUser sysUserView = sysUserService.loadById(userId);
        if (sysUserView != null){
            sessionKey = sysUserView.getLastSessionKey();
        }
        AesDecryptUtil decryptUtil = new AesDecryptUtil();
        byte[] data = decryptUtil.decrypt(encryptedData, sessionKey, iv);

        try {
            String json = new String(data, "UTF-8");
            JSONObject jsonObject = JSONObject.parseObject(json);
            Object purePhoneNumberObj = jsonObject.get("purePhoneNumber");
            String purePhoneNum = null;
            if (purePhoneNumberObj != null) {
                purePhoneNum = purePhoneNumberObj.toString();
            }

            if (purePhoneNum == null || purePhoneNum.length() == 0) {
                return this.buildErrorResponse(mav, "未获得您的手机号");
            }

            if (sysUserView != null){
                String oraPhoneNum = sysUserView.getUserTel();
                if (oraPhoneNum != null && oraPhoneNum.equals(purePhoneNum)) {
                    return this.buildResponse(mav, sysUserView);
                }
            }else {
                sysUserView = new SysUser();
                sysUserView.setUserTel(purePhoneNum);
            }
        } catch (Exception var17) {
            return this.buildErrorResponse(mav, "未获得您的手机号");
        }
        sysUserView.setIsPower("1");
        sysUserService.saveOrUpdate(sysUserView);
        return this.buildResponse(mav, sysUserView);
    }

}
