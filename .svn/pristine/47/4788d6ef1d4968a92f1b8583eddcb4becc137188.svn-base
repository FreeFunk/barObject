package com.edgedo.bar.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.bar.entity.*;
import com.edgedo.bar.queryvo.OrderInfoView;
import com.edgedo.bar.service.*;
import com.edgedo.common.base.BaseController;
import com.edgedo.bar.queryvo.OrderInfoQuery;
import com.edgedo.common.shiro.User;
import com.edgedo.sys.entity.SysUser;
import com.edgedo.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.joda.time.DateTime;
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
	private SeatInfoService seatInfoService;
	@Autowired
	private OrderDetailsInfoService orderDetailsInfoService;
	@Autowired
	private ConsInfoService consInfoService;
	@Autowired
	private TodaySeatDetailsInfoService todaySeatDetailsInfoService;

	@Autowired
	private SysUserService sysUserService;

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
		service.listPageForUserNameAndTel(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}


	@RequestMapping(value = "/orderInfoInTrue",method = RequestMethod.POST)
	public ModelAndView orderInfoInTrue(OrderInfo orderInfo){
		//获取当前用户人
		User currUser = getLoginUser();
		ModelAndView modelAndView = new ModelAndView();
		//座位ID
		String seatId = orderInfo.getSeatId();
		//使用时间
		Date orderTime = orderInfo.getOrderTime();
		//使用用户ID
		String userId = orderInfo.getUserId();
		//1.判断不能选择往期时间
		if(orderTime.getTime() < System.currentTimeMillis()){
			modelAndView.addObject("success" ,false );
			modelAndView.addObject("errMsg" , "不能选择往期时间!" );
			modelAndView.addObject("code","0");
			return modelAndView;
		}
		//2.获取用户对象
		SysUser sysUser = sysUserService.loadById(userId);
		//3.获取座位对象
		SeatInfo seatInfo = seatInfoService.loadById(seatId);
		//4.获取座位消费详情对象
		ConsInfo consInfo = consInfoService.loadById(seatInfo.getSetMealId());
		//5.新增订单简要信息
		OrderInfo orderInfoNewObj = new OrderInfo();
		orderInfoNewObj.setSeatId(seatId);
		orderInfoNewObj.setCreatTime(new Date());
		orderInfoNewObj.setCreatUserId(currUser.getUserId());
		orderInfoNewObj.setCreatUserName(currUser.getUserName());
		orderInfoNewObj.setOrderTime(orderTime);
		orderInfoNewObj.setUserId(userId);
		orderInfoNewObj.setDataState("1");
		orderInfoNewObj.setChargeback("0");
		service.insert(orderInfoNewObj);
		//6.新增订单详细信息
		OrderDetailsInfo orderDetailsInfo = new OrderDetailsInfo();
		orderDetailsInfo.setUserId(userId);
		orderDetailsInfo.setUserName(sysUser.getUserName());
		orderDetailsInfo.setUserTel(sysUser.getUserTel());
		orderDetailsInfo.setOrderId(orderInfo.getId());
		orderDetailsInfo.setSeatNo(seatInfo.getSeatNo());
		orderDetailsInfo.setSetMealDesc(consInfo.getSetMealDesc());
		orderDetailsInfo.setTotalConsume(consInfo.getSetMealPrice());
		orderDetailsInfo.setCreateTime(new Date());
		orderDetailsInfo.setCreateUserId(currUser.getUserId());
		orderDetailsInfo.setCreateUserName(currUser.getUserName());
		orderDetailsInfo.setDataState("1");
		orderDetailsInfoService.insert(orderDetailsInfo);
		//7.修改下单的座位的选中状态
		TodaySeatDetailsInfo todaySeatDetailsInfo = new TodaySeatDetailsInfo();
		todaySeatDetailsInfo.setSeatId(seatId);
		todaySeatDetailsInfo.setCreateUserId(currUser.getUserId());
		todaySeatDetailsInfo.setCreateUserName(currUser.getUserName());
		todaySeatDetailsInfo.setDataState("1");
		todaySeatDetailsInfo.setSeatState("1");
		todaySeatDetailsInfo.setCreateTime(orderTime);
		SimpleDateFormat createFlag = new SimpleDateFormat("yyyyMMdd");
		todaySeatDetailsInfo.setCreateTimeFlag(Integer.parseInt(createFlag.format(orderTime)));
		todaySeatDetailsInfoService.insert(todaySeatDetailsInfo);
		return buildResponse(modelAndView);
	}


	/**
	 * @author:Baishuangyi
	 * @Description: 新增修改对象
	 * @Date: 2021/4/11 11:07
	 * @param voObj: 订单对象
	 * @return: ModelAndView
	 **/
	@ApiOperation(value = "新增修改OrderInfo", notes = "新增修改OrderInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(OrderInfo voObj){
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
			voObj.setCreatTime(new Date());
			voObj.setCreatUserId(currUser.getUserId());
			voObj.setCreatUserName(currUser.getUserName());
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
	 * 批量逻辑删除
	 * @param ids
	 * @return
	 */
	@ApiOperation(value = "根据ID批量删除OrderInfo", notes = "根据ID批量删除OrderInfo")
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
	@ApiOperation(value = "根据ID加载OrderInfo", notes = "根据ID加载OrderInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}
	
	
}
