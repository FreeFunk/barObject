package com.edgedo.bar.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.common.base.BaseController;
import com.edgedo.bar.entity.TodaySeatDetailsInfo;
import com.edgedo.bar.queryvo.TodaySeatDetailsInfoQuery;
import com.edgedo.bar.service.TodaySeatDetailsInfoService;
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


	/**
	 * @author:Qiutianzhu
	 * @Description: 根据客服确定用户使用订座时间，进行判断
	 * @Date: 2021/5/26 22:12
	 * @param dateTimeStr: 确定时间
	 * @param seatId:  座位id
	 * @return: org.springframework.web.servlet.ModelAndView
	 **/
	@RequestMapping(value = "/selectInDetermineForTime",method = RequestMethod.POST)
	public ModelAndView selectInDetermineForTime(String dateTimeStr,String seatId){
		ModelAndView modelAndView = new ModelAndView();
		SimpleDateFormat simpleDateFormatToday = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateTime = null;
		try {
			dateTime = simpleDateFormatToday.parse(dateTimeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(dateTime.getTime() < System.currentTimeMillis()){
			modelAndView.addObject("success" ,false );
			modelAndView.addObject("errMsg" , "不能选择往期时间!" );
			modelAndView.addObject("code","0");
			return modelAndView;
		}else {
			//格式化时间
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			Integer dateTimeInteger = Integer.valueOf(simpleDateFormat.format(dateTime)).intValue();
			int isFlag = service.selectInDetermineForTime(dateTimeInteger,seatId);
			if(isFlag != 0){
				modelAndView.addObject("success" ,false );
				modelAndView.addObject("errMsg" , "该日期已经有用户预定请重新选择!" );
				modelAndView.addObject("code","0");
				return modelAndView;
			}else {
				return buildResponse(modelAndView);
			}
		}
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
