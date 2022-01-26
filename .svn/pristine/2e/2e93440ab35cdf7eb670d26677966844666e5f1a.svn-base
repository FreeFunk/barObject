package com.edgedo.sys.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.common.base.BaseController;
import com.edgedo.sys.entity.SysMeunUser;
import com.edgedo.sys.queryvo.SysMeunUserQuery;
import com.edgedo.sys.queryvo.SysMeunUserView;
import com.edgedo.sys.service.SysMeunUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "SysMeunUser")
@Controller
@RequestMapping("/sysMeunUser")
public class SysMeunUserController extends BaseController{
	
	@Autowired
	private SysMeunUserService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询SysMeunUser", notes = "分页查询SysMeunUser")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute SysMeunUserQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	/**
	 * @author:Qiutianzhu
	 * @Description: 根据用户id查询所有的菜单
	 * @Date: 2021/4/22 20:56
	 * @param userId:  用户ID
	 * @return: org.springframework.web.servlet.ModelAndView
	 **/
	@RequestMapping(value = "/selectByUserIdInMeunList",method = RequestMethod.POST)
	public ModelAndView selectByUserIdInMeunList(String userId){
		ModelAndView modelAndView = new ModelAndView();
		//1.根据用户Id查询菜单集合
		List<String> meunIdList = service.selectByUserIdInMeunList(userId);
		return buildResponse(modelAndView,meunIdList);
	}

	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改SysMeunUser", notes = "新增修改SysMeunUser")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(SysMeunUserView voObj){
		//1.创建ModelAndView对象，方便返回前台展示
		ModelAndView modelAndView = new ModelAndView();
		//2.创建errMsg字符串，记录错误正确信息
		String errMsg = "";
		//3.获取前台传入的用户id
		String userId = voObj.getUserId();
		//4.去数据库中查询前台传入的用户id是否存在
		List<SysMeunUser> result = service.selectByUserId(userId);
		//5.判断是否存在
		if(result.size()==0){
			//如果不存在，说明是新的用户，则插入
			//存储登录人id，登录人名，创建时间
			voObj.setCreateTime(new Date());
			voObj.setCreateUserId(getLoginUser().getUserId());
			voObj.setCreateUserName(getLoginUser().getUserName());
			errMsg = service.insertFromList(voObj);
		}else{
			//如果存在，说明是修改已存在的(这里的处理方式是，把原来的查出来删掉，再重新插入)
			//根据用户ID删除
			service.deleteByUserId(userId);
			voObj.setCreateTime(new Date());
			voObj.setCreateUserId(getLoginUser().getUserId());
			voObj.setCreateUserName(getLoginUser().getUserName());
			errMsg = service.insertFromList(voObj);
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
	@ApiOperation(value = "根据ID批量删除SysMeunUser", notes = "根据ID批量删除SysMeunUser")
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
	@ApiOperation(value = "根据ID加载SysMeunUser", notes = "根据ID加载SysMeunUser")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}


	
	
}
