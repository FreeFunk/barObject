package com.edgedo.barwxqt.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.barwxqt.entity.*;
import com.edgedo.barwxqt.service.*;
import com.edgedo.common.base.BaseController;
import com.edgedo.barwxqt.queryvo.OrderInfoQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "OrderInfo")
@Controller
@RequestMapping("/orderInfo")
public class OrderInfoController extends BaseController{
	
	@Autowired
	private OrderInfoService service;

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SeatInfoService seatInfoService;
	@Autowired
	private OrderDetailsInfoService orderDetailsInfoService;
	@Autowired
	private ConsInfoService consInfoService;
	@Autowired
	private TodaySeatDetailsInfoService todaySeatDetailsInfoService;

	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询OrderInfo", notes = "分页查询OrderInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute OrderInfoQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	@RequestMapping(value = "/submitOrderInfo",method = RequestMethod.POST)
	public ModelAndView submitOrderInfo(String userId,String userTel,String userName,String orderDate,String seatId){
		ModelAndView modelAndView = new ModelAndView();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date actualOrderUser = null;
		try {
			actualOrderUser = simpleDateFormat.parse(orderDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(actualOrderUser.getTime() < System.currentTimeMillis()){
			return buildErrorResponse(modelAndView,"不能选择往期时间");
		}
		SysUser sysUser = sysUserService.loadById(userId);
		if (null == sysUser){
			return buildErrorResponse(modelAndView,"请重新登录小程序");
		}
		SeatInfo seatInfo = seatInfoService.loadById(seatId);
		if (null == seatInfo){
			return buildErrorResponse(modelAndView,"请重新登录小程序");
		}
		ConsInfo consInfo = consInfoService.loadById(seatInfo.getSetMealId());
		//1.新增订单简要信息
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setSeatId(seatId);
		orderInfo.setCreatTime(new Date());
		orderInfo.setCreatUserId(userId);
		orderInfo.setCreatUserName(sysUser.getUserName());
		orderInfo.setOrderTime(actualOrderUser);
		orderInfo.setUserId(sysUser.getId());
		orderInfo.setDataState("1");
		orderInfo.setChargeback("0");
		service.insert(orderInfo);
		//2.新增订单详细信息
		OrderDetailsInfo orderDetailsInfo = new OrderDetailsInfo();
		orderDetailsInfo.setUserId(sysUser.getId());
		orderDetailsInfo.setUserName(userName);
		orderDetailsInfo.setUserTel(userTel);
		orderDetailsInfo.setOrderId(orderInfo.getId());
		orderDetailsInfo.setSeatNo(seatInfo.getSeatNo());
		orderDetailsInfo.setSetMealDesc(consInfo.getSetMealDesc());
		orderDetailsInfo.setTotalConsume(consInfo.getSetMealPrice());
		orderDetailsInfo.setCreateTime(new Date());
		orderDetailsInfo.setCreateUserId(sysUser.getId());
		orderDetailsInfo.setCreateUserName(sysUser.getUserName());
		orderDetailsInfo.setDataState("1");
		orderDetailsInfoService.insert(orderDetailsInfo);
		//3.修改下单的座位的选中状态
		TodaySeatDetailsInfo todaySeatDetailsInfo = new TodaySeatDetailsInfo();
		todaySeatDetailsInfo.setSeatId(seatId);
		todaySeatDetailsInfo.setCreateUserId(sysUser.getId());
		todaySeatDetailsInfo.setCreateUserName(sysUser.getUserName());
		todaySeatDetailsInfo.setDataState("1");
		todaySeatDetailsInfo.setSeatState("1");
		todaySeatDetailsInfo.setCreateTime(actualOrderUser);
		SimpleDateFormat createFlag = new SimpleDateFormat("yyyyMMdd");
		todaySeatDetailsInfo.setCreateTimeFlag(Integer.parseInt(createFlag.format(actualOrderUser)));
		todaySeatDetailsInfoService.insert(todaySeatDetailsInfo);
		return buildResponse(modelAndView);
	}
	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改OrderInfo", notes = "新增修改OrderInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(OrderInfo voObj){
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
	@ApiOperation(value = "根据ID批量删除OrderInfo", notes = "根据ID批量删除OrderInfo")
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
	@ApiOperation(value = "根据ID加载OrderInfo", notes = "根据ID加载OrderInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}
	
	
}
