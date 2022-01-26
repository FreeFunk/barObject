package com.edgedo.barwxqt.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.edgedo.barwxqt.common.BaseController;
import com.edgedo.barwxqt.queryvo.OrderDetailsInfoView;
import com.edgedo.barwxqt.queryvo.OrderInfoView;
import com.edgedo.barwxqt.queryvo.SysUserView;
import com.edgedo.barwxqt.entity.UserMoney;
import com.edgedo.barwxqt.queryvo.UserMoneyQuery;
import com.edgedo.barwxqt.service.SysUserService;
import com.edgedo.barwxqt.service.UserMoneyService;
import com.edgedo.eunm.OrderEunm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "UserMoney")
@Controller
@RequestMapping("/userMoney")
public class UserMoneyController extends BaseController{
	
	@Autowired
	private UserMoneyService service;
	@Autowired
	private SysUserService sysUserService;
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询UserMoney", notes = "分页查询UserMoney")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute UserMoneyQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}


	@RequestMapping(value = "/selectByUserIdForMoney",method = RequestMethod.POST)
	public ModelAndView selectByUserIdForMoney(String orderState){
		ModelAndView modelAndView = new ModelAndView();
		//1.获取当前用户人openId
		String openId = getLoginWxUser();
		SysUserView sysUserView = sysUserService.loadByMiniOpenId(openId);
		//2.获取用户Id
		String userId = sysUserView.getId();
		//3.查询用户钱包表
		UserMoney userMoney = service.selectByUserId(userId);
		if (userMoney == null){
			return buildErrorResponse(modelAndView,"无具体用户钱包信息");
		}
		return buildResponse(modelAndView,userMoney);
	}


	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改UserMoney", notes = "新增修改UserMoney")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(UserMoney voObj){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		String id = voObj.getId();
		if(id==null || id.trim().equals("")){
			errMsg = service.insert(voObj);
		}else{
			errMsg = service.update(voObj);
		}
		if(errMsg!=null && !errMsg.equals("")){
			buildErrorResponse(modelAndView, errMsg);
		}else{
			buildResponse(modelAndView);
		}
		return modelAndView;
	}
	
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@ApiOperation(value = "根据ID批量删除UserMoney", notes = "根据ID批量删除UserMoney")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/deleteByIds",method = RequestMethod.POST)
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
	 * 根据主键加载
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据ID加载UserMoney", notes = "根据ID加载UserMoney")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}
	
	
}
