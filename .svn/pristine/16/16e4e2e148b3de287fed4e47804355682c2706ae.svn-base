package com.edgedo.barwxqt.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.barwxqt.queryvo.SeatInfoView;
import com.edgedo.barwxqt.service.TodaySeatDetailsInfoService;
import com.edgedo.common.base.BaseController;
import com.edgedo.barwxqt.entity.SeatInfo;
import com.edgedo.barwxqt.queryvo.SeatInfoQuery;
import com.edgedo.barwxqt.service.SeatInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "SeatInfo")
@Controller
@RequestMapping("/seatInfo")
public class SeatInfoController extends BaseController{
	
	@Autowired
	private SeatInfoService service;

	@Autowired
	private TodaySeatDetailsInfoService todaySeatDetailsInfoService;


	/**
	 * @author:Qiutianzhu
	 * @Description: 查询所有的座位信息
	 * @Date: 2021/5/5 21:53
	 * @return: org.springframework.web.servlet.ModelAndView
	 **/
	@RequestMapping(value = "/selectByAllSeat",method = RequestMethod.POST)
	public ModelAndView selectByAllSeat(){
		ModelAndView modelAndView = new ModelAndView();
		//1.获取总共多少行
		int yIndexNum = service.selectByYIndex();
		//2.创建座位集合Map
		List<List<SeatInfoView>> seatInfoList = new ArrayList<>(0);
		//3.获取当前时间
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		int dateInt = Integer.parseInt(simpleDateFormat.format(new Date()));
		for (int i = 1;i<=yIndexNum;i++){
			List<SeatInfoView> seatInfoXIndex = service.selectByYIndexNumForList(i);
			if (i == 1){
				seatInfoXIndex.get(2).setFloorFlag(true);
			}
			if (null != seatInfoXIndex && seatInfoXIndex.size() > 0){
				seatInfoXIndex.forEach(seatInfoView -> {
					if(!seatInfoView.isFloorFlag()){
						String seatState = todaySeatDetailsInfoService.selectBySeatIdAndDateInt(seatInfoView.getId(),dateInt);
						if (null != seatState && !(seatState.equals(""))){
							seatInfoView.setIsChooseSeat(seatState);
						}else {
							seatInfoView.setIsChooseSeat("0");
						}
					}
				});
				seatInfoList.add(seatInfoXIndex);
			}
		}
		return buildResponse(modelAndView,seatInfoList);
	}
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询SeatInfo", notes = "分页查询SeatInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute SeatInfoQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}
	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改SeatInfo", notes = "新增修改SeatInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(SeatInfo voObj){
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
	@ApiOperation(value = "根据ID批量删除SeatInfo", notes = "根据ID批量删除SeatInfo")
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
	@ApiOperation(value = "根据ID加载SeatInfo", notes = "根据ID加载SeatInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}
	
	
}
