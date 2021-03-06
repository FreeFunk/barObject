package com.edgedo.sys.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.common.sequrity.CheckPermission;
import com.edgedo.common.shiro.JwtRsaSecKey;
import com.edgedo.common.shiro.User;
import com.edgedo.common.util.CallBackInterface;
import com.edgedo.common.util.JWTUtil;
import com.edgedo.common.util.MD5;
import com.edgedo.common.util.RSAUtil;
import com.edgedo.sys.entity.*;
import com.edgedo.sys.queryvo.*;
import com.edgedo.sys.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/sysUser")
public class SysUserController extends BaseController {
	@Autowired
		JwtRsaSecKey secKey;
	@Autowired
	private SysUserService service;
	@Autowired
	private SysMeunService sysMeunService;
	@Autowired
	private SysMeunUserService sysMeunUserService;

	/**
	 * 根据登录用户初始化主页
	 *
	 * @return
	 */
	@RequestMapping("/loadCurrUser")
	public ModelAndView loadCurrUser(HttpServletRequest request){

		ModelAndView modelAndView = new ModelAndView();
		try {
			User shiroUser = getLoginUser();
			return buildResponse(modelAndView,shiroUser);
		} catch (Exception e) {
			return buildErrorResponse(modelAndView,"获取用户信息错误");
		}
	}

	/**
	 * @author:Qiutianzhu
	 * @Description: 根据用户信息查询钱包表
	 * @Date: 2021/5/8 11:11
	 * @param query:  分页对象
	 * @return: org.springframework.web.servlet.ModelAndView
	 **/
	@RequestMapping(value = "/listUserInfoAndMoneyInfo",method = RequestMethod.POST)
	public ModelAndView listUserInfoAndMoneyInfo(@ModelAttribute SysUserQuery query){
		ModelAndView modelAndView = new ModelAndView();
		//获取当前查看信息人用户类型
		User user = getLoginUser();
		query.setUserCurrQueryType(user.getUserType());
		service.listUserInfoAndMoneyInfo(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}
	/**
	 * @author:Qiutianzhu
	 * @Description: 查询所有的用户信息
	 * @Date: 2021/4/20 22:44
	 * @return: org.springframework.web.servlet.ModelAndView 返回model对象
	 **/
	@RequestMapping(value = "/selectByUserAllInfo",method = RequestMethod.POST)
	public ModelAndView selectByUserAllInfo(){
		//1.新建model对象
		ModelAndView modelAndView = new ModelAndView();
		//2.查询所有的菜单
		List<SysUser> sysUserList = service.selectByUserAllInfo();
		List<SysUserEasyInfo> sysUserEasyInfoList = new ArrayList<>(0);
		//3.遍历菜单对象去挨个赋值
		sysUserList.forEach(sysUser -> {
			SysUserEasyInfo sysUserEasyInfo = new SysUserEasyInfo();
			if(sysUser.getUserTel() != null && !("".equals(sysUser.getUserTel()))){
				//用户手机号
				sysUserEasyInfo.setName(sysUser.getUserTel());
				//用户ID
				sysUserEasyInfo.setValue(sysUser.getId());
				sysUserEasyInfoList.add(sysUserEasyInfo);
			}
		});
		//返回前端
		return buildResponse(modelAndView,sysUserEasyInfoList);
	}

	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping("/listpage")
	public ModelAndView listpage(@ModelAttribute SysUserQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	/**
	 * 查询出非普通用户的人
	 * @param query
	 * @return
	 */
	@RequestMapping("/queryAdminUsers")
	public ModelAndView queryAdminUsers(@ModelAttribute SysUserQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.queryAdminUsers(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}


	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public ModelAndView saveOrUpdate(SysUser voObj){
		//1.创建ModelAndView对象，方便返回前台展示
		ModelAndView modelAndView = new ModelAndView();
		//2.创建errMsg字符串，记录错误正确信息
		String errMsg = "";
		//3.获取前台传入对象id
		String id = voObj.getId();
		//4.判断前台传入id是否存在
		if(id==null || id.trim().equals("")){
			//5.如果不存在，则新增
			//获取当前登录人信息，工具类提供的方法
			User currUser = getLoginUser();
			//存储登录人id，登录人名，创建时间,数据状态
			voObj.setCreateTime(new Date());
			voObj.setCreateUserId(currUser.getUserId());
			voObj.setCreateUserName(currUser.getUserName());
			voObj.setDataState("1");

			//上升service层处理业务逻辑
			errMsg = service.insert(voObj);
		}else{
			//6.如果存在，则修改
			//上升service层处理业务逻辑
			errMsg = service.update(voObj);
		}
		//7.判断错误信息是否存在
		if(errMsg!=null && !errMsg.equals("")){
			//如果有则返回错误信息

			buildErrorResponse(modelAndView, errMsg);
		}else{
			//如果没有则返回model模型
			buildResponse(modelAndView);
		}
		return modelAndView;
	}
	/**
	 * 修改密码
	 * @param voObj
	 * @return
	 */
	@RequestMapping("/updatePassword")
	public ModelAndView updatePassword(SysUser voObj){
		//1.创建ModelAndView对象，方便返回前台展示
		ModelAndView modelAndView = new ModelAndView();
		//2.创建errMsg字符串，记录错误正确信息
		String errMsg = "";

		//上升service层处理业务逻辑
		errMsg = service.updatePassword(voObj);

		//7.判断错误信息是否存在
		if(errMsg!=null && !errMsg.equals("")){
			//如果有则返回错误信息

			buildErrorResponse(modelAndView, errMsg);
		}else{
			//如果没有则返回model模型
			buildResponse(modelAndView);
		}
		return modelAndView;
	}
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteByIds")
	public ModelAndView delete(String ids){
		ModelAndView modelAndView = new ModelAndView();
		String[] arr = ids.split(",");
		List<String> list = new ArrayList<String>();
		for(String str : arr){
			list.add(str);
		}
		service.deleteByIds(list);
		return buildResponse(modelAndView);
	}
	/**
	 * 批量逻辑删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/logicDeleteByIds")
	public ModelAndView logicDelete(String ids){
		ModelAndView modelAndView = new ModelAndView();
		String[] arr = ids.split(",");
		List<String> list = new ArrayList<String>();
		for(String str : arr){
			list.add(str);
		}
		service.logicDeleteByIds(list);
		return buildResponse(modelAndView);
	}


	/**
	 * 根据主键加载
	 * @param id
	 * @return
	 */
	@RequestMapping("/loadById")
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	/***
	 * 用户登录的方法
	 * @param userCode
	 * @param password
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	@Pass
	public ModelAndView login(@RequestParam(required=true) String userCode,@RequestParam(required=true) String password, final HttpSession session,HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		final SysUserView user = service.getAdminUserByCode(userCode);
		if(user==null){
			buildErrorResponse(modelAndView, "用户不存在！");
			return modelAndView;
		}
		String pwd = MD5.encode(MD5.encode(password)+user.getId());
		if(!pwd.equals(user.getUserPassword())){
			buildErrorResponse(modelAndView, "密码错误！");
			return modelAndView;
		}
		//修改用户登录态和本次登录时间
		final String[] token = new String[1];
		User shiroUser = new User();
		shiroUser.setUserId(user.getId());
		shiroUser.setUserName(user.getUserName());
		shiroUser.setDefaultRole(user.getUserRoleName());
		shiroUser.setUserType(user.getUserRoleId());
		String userInfo = JSON.toJSONString(shiroUser);
		//将字符串使用RSA加密
		try {
			String userInfoRsa = RSAUtil.encode(userInfo,secKey);
			token[0] = JWTUtil.sign(userInfoRsa,secKey.getJwtSecretkey());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//操作日志
		buildResponse(modelAndView,token[0]);
		return modelAndView;
	}


	/**
	 * 用户访问菜单数据
	 * @return
	 */
	@RequestMapping("/nav")
	public ModelAndView nav(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("tpl/blocks/nav");
		return modelAndView;
	}

	/**
	 * 退出
	 * @return
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public ModelAndView logout(HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		SysUser user = null;//AdminUserLoginIntercepter.getCurrentUser();

		return buildResponse(modelAndView);
	}


	@RequestMapping("/loadUserMenueAll")
	@ResponseBody
	public ModelAndView loadUserMenueAll(HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		//从数据库中读取用户菜单
		User user = User.getCurrentUser();
		//根据用户ID查询菜单表，把所有的菜单查出
		List<SysMeun> menueList = new ArrayList<>();
		List<SysMeunUser> sysMeunUserList = sysMeunUserService.selectByUserId(user.getUserId());
		//循环遍历
		sysMeunUserList.forEach(sysMeunUser -> {
			String menuId = sysMeunUser.getMeunId();
			menueList.add(sysMeunService.loadById(menuId));
		});
		//排序
		menueList.sort((a,b) -> a.getSortNum().compareTo(b.getSortNum()));
		buildResponse(modelAndView,menueList);
		return modelAndView;
	}

}
