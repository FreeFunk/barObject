package com.edgedo.bar.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.bar.queryvo.ConsEasyInfo;
import com.edgedo.common.base.BaseController;
import com.edgedo.bar.entity.ConsInfo;
import com.edgedo.bar.queryvo.ConsInfoQuery;
import com.edgedo.bar.service.ConsInfoService;
import com.edgedo.common.shiro.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "ConsInfo")
@Controller
@RequestMapping("/ConsInfo")
public class ConsInfoController extends BaseController{
	
	@Autowired
	private ConsInfoService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询ConsInfo", notes = "分页查询ConsInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute ConsInfoQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	/**
	 * 查询套餐
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/setMealListpage",method = RequestMethod.POST)
	public ModelAndView setMealListpage(){
		//1.新建model对象
		ModelAndView modelAndView = new ModelAndView();
		//2.查询所有套餐
		List<ConsInfo> setMealList = service.selectSetMeal();
		List<ConsEasyInfo> ConsEasyInfoList = new ArrayList<>(0);
		//3.遍历套餐对象挨个赋值
		setMealList.forEach(setMeal ->{
			ConsEasyInfo consEasyInfo = new ConsEasyInfo();
			consEasyInfo.setName(setMeal.getSetMealName());
			consEasyInfo.setValue(setMeal.getId());
			ConsEasyInfoList.add(consEasyInfo);
		});
		//返回前端
		return buildResponse(modelAndView,ConsEasyInfoList);
	}
	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改ConsInfo", notes = "新增修改ConsInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(ConsInfo voObj){
		//1.创建ModelAndView对象，方便返回前台展示
		ModelAndView modelAndView = new ModelAndView();
		//2.创建errMsg字符串，记录错误正确信息
		String errMsg = "";
		//3.获取前台传入对象id
		String id = voObj.getId();
		//4.判断前台传入id是否存在
		if(id==null || id.trim().equals("")){
			//5.如果不存在，则新增
			//获取当前登录人信息
			User currUser = getLoginUser();
			//存储登录人id，登录人名，创建时间，数据状态
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
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@ApiOperation(value = "根据ID批量删除ConsInfo", notes = "根据ID批量删除ConsInfo")
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
	 * 批量逻辑删除
	 * @param ids
	 * @return
	 */
	@ApiOperation(value = "根据ID批量删除ConsInfo", notes = "根据ID批量删除ConsInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/logicDeleteByIds",method = RequestMethod.POST)
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
	@ApiOperation(value = "根据ID加载ConsInfo", notes = "根据ID加载ConsInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}
	
	
}
