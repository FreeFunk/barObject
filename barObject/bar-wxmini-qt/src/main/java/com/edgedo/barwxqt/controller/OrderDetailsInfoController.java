package com.edgedo.barwxqt.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.edgedo.barwxqt.common.BaseController;
import com.edgedo.barwxqt.entity.OrderDetailsInfo;
import com.edgedo.barwxqt.entity.OrderInfo;
import com.edgedo.barwxqt.queryvo.OrderDetailsInfoQuery;
import com.edgedo.barwxqt.queryvo.OrderDetailsInfoView;
import com.edgedo.barwxqt.queryvo.OrderInfoView;
import com.edgedo.barwxqt.queryvo.SysUserView;
import com.edgedo.barwxqt.service.OrderDetailsInfoService;
import com.edgedo.barwxqt.service.OrderInfoService;
import com.edgedo.barwxqt.service.SysUserService;
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

import static java.util.Comparator.comparing;


@Api(tags = "OrderDetailsInfo")
@Controller
@RequestMapping("/orderDetailsInfo")
public class OrderDetailsInfoController extends BaseController{
	
	@Autowired
	private OrderDetailsInfoService service;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private OrderInfoService orderInfoService;
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询OrderDetailsInfo", notes = "分页查询OrderDetailsInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute OrderDetailsInfoQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	/**
	 * @author:Qiutianzhu
	 * @Description: 根据订单状态查询订单信息
	 * @Date: 2021/4/17 11:15
	 * @param orderState:
	 * @return: org.springframework.web.servlet.ModelAndView
	 **/
	@RequestMapping(value = "/selectByOrderStatus",method = RequestMethod.POST)
	public ModelAndView selectByOrderStatus(String orderState){
		ModelAndView modelAndView = new ModelAndView();
		//1.获取当前用户人openId
		String openId = getLoginWxUser();
		SysUserView sysUserView = sysUserService.loadByMiniOpenId(openId);
		//2.获取用户Id
		String userId = sysUserView.getId();
		//3.获取查询状态
		String checkStats = OrderEunm.valueOf(orderState).getType();
		//6.查询详细信息
		List<OrderDetailsInfoView> orderDetailsInfoList = service.selectByUserIdAndOrderState(userId,checkStats);
		//7.遍历赋值订单状态
		orderDetailsInfoList.forEach(order->{
			order.setOrderState(orderInfoService.loadById(order.getOrderId()).getChargeback());
		});
		return buildResponse(modelAndView,orderDetailsInfoList);
	}

	@RequestMapping(value = "/updateByOrderId",method = RequestMethod.POST)
	public ModelAndView updateByOrderId(String orderId,String err){
		ModelAndView modelAndView = new ModelAndView();
		//1.修改详情信息
		OrderDetailsInfo orderDetailsInfo = service.selectByOrderId(orderId);
		if (orderDetailsInfo != null){
			//修改详情
			orderDetailsInfo.setReason(err);
			orderDetailsInfo.setChargebackTime(new Date());
			orderDetailsInfo.setRefundAmount(orderDetailsInfo.getTotalConsume());
			service.update(orderDetailsInfo);
			//修改主表订单
			OrderInfo orderInfo = orderInfoService.loadById(orderId);
			orderInfo.setChargeback("-1");
			orderInfoService.update(orderInfo);
			return buildResponse(modelAndView,"退单成功");
		}else {
			return buildErrorResponse(modelAndView,"退单失败");
		}
	}

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改OrderDetailsInfo", notes = "新增修改OrderDetailsInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(OrderDetailsInfo voObj){
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
	@ApiOperation(value = "根据ID批量删除OrderDetailsInfo", notes = "根据ID批量删除OrderDetailsInfo")
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
	@ApiOperation(value = "根据ID加载OrderDetailsInfo", notes = "根据ID加载OrderDetailsInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}
	
	
}
