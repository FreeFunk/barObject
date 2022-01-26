package com.edgedo.barwxqt.controller;


import java.text.SimpleDateFormat;
import java.util.*;

import com.edgedo.barwxqt.entity.ConsInfo;
import com.edgedo.barwxqt.queryvo.TodaySeatDetailsInfoView;
import com.edgedo.barwxqt.service.ConsInfoService;
import com.edgedo.common.base.BaseController;
import com.edgedo.barwxqt.entity.TodaySeatDetailsInfo;
import com.edgedo.barwxqt.queryvo.TodaySeatDetailsInfoQuery;
import com.edgedo.barwxqt.service.TodaySeatDetailsInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "TodaySeatDetailsInfo")
@Controller
@RequestMapping("/todaySeatDetailsInfo")
public class TodaySeatDetailsInfoController extends BaseController{
	
	@Autowired
	private TodaySeatDetailsInfoService service;

	@Autowired
	private ConsInfoService consInfoService;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询TodaySeatDetailsInfo", notes = "分页查询TodaySeatDetailsInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute TodaySeatDetailsInfoQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}


	@RequestMapping(value = "/selectBySeatId",method = RequestMethod.POST)
	public ModelAndView selectBySeatId(String seatId,String setMealId){
		ModelAndView modelAndView = new ModelAndView();
		//1.获取当前时间
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		int dateInt = Integer.parseInt(simpleDateFormat.format(new Date()));
		List<TodaySeatDetailsInfoView> list = service.selectBySeatId(seatId,dateInt);
		ConsInfo consInfo = consInfoService.loadById(setMealId);
		Map<String,Object> map = new HashMap<>();
		map.put("list",list);
		map.put("consInfo",consInfo);
		return buildResponse(modelAndView,map);
	}


	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改TodaySeatDetailsInfo", notes = "新增修改TodaySeatDetailsInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(TodaySeatDetailsInfo voObj){
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
	@ApiOperation(value = "根据ID批量删除TodaySeatDetailsInfo", notes = "根据ID批量删除TodaySeatDetailsInfo")
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
	@ApiOperation(value = "根据ID加载TodaySeatDetailsInfo", notes = "根据ID加载TodaySeatDetailsInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}
	
	
}
