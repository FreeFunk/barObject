package com.edgedo.barwxqt.controller;

import com.edgedo.barwxqt.common.BaseController;
import com.edgedo.barwxqt.entity.SysUser;
import com.edgedo.barwxqt.entity.SysWxUser;
import com.edgedo.barwxqt.queryvo.SysUserView;
import com.edgedo.barwxqt.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author:Qiutianzhu
 * @date 2021-04-15 21:28
 * @description:
 */
@Controller
@RequestMapping("/wxMinInfo")
public class SysUserWxInfoController extends BaseController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/getLoginUser",method = RequestMethod.POST)
    public ModelAndView getLoginUser(){
        ModelAndView modelAndView = new ModelAndView();
        String openId = getLoginWxUser();
        SysUserView sysUserView = sysUserService.loadByMiniOpenId(openId);
        return buildResponse(modelAndView,sysUserView);
    }

    @RequestMapping("/saveOrUpdate")
    public ModelAndView saveOrUpdate() {
        ModelAndView mav = new ModelAndView();
        String openId = getLoginWxUser();
        SysUserView sysUserView = sysUserService.loadByMiniOpenId(openId);
        return this.buildResponse(mav, sysUserService.saveOrUpdate(sysUserView));
    }

    @RequestMapping("/updateByUserIdForTel")
    public ModelAndView updateByUserIdForTel(String userId,String userPhom,String userName) {
        ModelAndView mav = new ModelAndView();
        SysUser sysUser = sysUserService.loadById(userId);
        sysUser.setUserTel(userPhom);
        sysUser.setUserName(userName);
        sysUserService.update(sysUser);
        return this.buildResponse(mav, sysUser);
    }

    @RequestMapping("/updateByUserIdForSex")
    public ModelAndView updateByUserIdForSex(String userId,String userSex) {
        ModelAndView mav = new ModelAndView();
        SysUser sysUser = sysUserService.loadById(userId);
        sysUser.setUserSex(userSex);
        sysUserService.update(sysUser);
        return this.buildResponse(mav, sysUser);
    }

}
