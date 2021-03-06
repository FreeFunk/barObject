package com.edgedo.bar.service;
		
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.edgedo.bar.entity.OrderDetailsInfo;
import com.edgedo.bar.mapper.OrderDetailsInfoMapper;
import com.edgedo.common.util.Guid;
import com.edgedo.bar.entity.OrderInfo;
import com.edgedo.bar.mapper.OrderInfoMapper;
import com.edgedo.bar.queryvo.OrderInfoQuery;
import com.edgedo.bar.queryvo.OrderInfoView;
import com.edgedo.sys.queryvo.UserMoneyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class OrderInfoService {
	
	
	@Autowired
	private OrderInfoMapper orderInfoMapper;

	@Autowired
	private OrderDetailsInfoService orderDetailsInfoService;

	//根据用户姓名和手机号查询
	public List<OrderInfoView> listPageForUserNameAndTel(OrderInfoQuery orderInfoQuery) {
		//1.分页查询所有记录的订单信息
		List<OrderInfoView> orderInfoList = orderInfoMapper.listPageForUserNameAndTel(orderInfoQuery);
		//2.遍历订单集合
		orderInfoList.forEach(orderInfoView -> {
			//获取订单ID(主键)
			String orderId = orderInfoView.getId();
			//根据订单ID查询订单详细信息
			OrderDetailsInfo orderDetailsInfo = orderDetailsInfoService.seletByOrderId(orderId.trim());
			if (null != orderDetailsInfo){
				orderInfoView.setUserName(orderDetailsInfo.getUserName());
				orderInfoView.setUserTel(orderDetailsInfo.getUserTel());
				orderInfoView.setSeatNo(orderDetailsInfo.getSeatNo());
				orderInfoView.setTotalConsume(orderDetailsInfo.getTotalConsume());

			}else {
				orderInfoView.setUserName("");
				orderInfoView.setUserTel("");
				orderInfoView.setSeatNo("");
				orderInfoView.setTotalConsume(new BigDecimal(0));
			}

		});

		//重新将集合set回query分页对象中
		orderInfoQuery.setList(orderInfoList);
		return orderInfoList;
	}
	public List<OrderInfoView> listPage(OrderInfoQuery orderInfoQuery){
		//1.分页查询所有记录的订单信息
		List<OrderInfoView> orderInfoList = orderInfoMapper.listPage(orderInfoQuery);
		//2.遍历订单集合
		orderInfoList.forEach(orderInfoView -> {
			//获取订单ID(主键)
			String orderId = orderInfoView.getId();
			//根据订单ID查询订单详细信息
			OrderDetailsInfo orderDetailsInfo = orderDetailsInfoService.loadById(orderId.trim());
			if (null != orderDetailsInfo){
				orderInfoView.setUserName(orderDetailsInfo.getUserName());
				orderInfoView.setUserTel(orderDetailsInfo.getUserTel());
				orderInfoView.setSeatNo(orderDetailsInfo.getSeatNo());
				orderInfoView.setTotalConsume(orderDetailsInfo.getTotalConsume());

			}else {
				orderInfoView.setUserName("");
				orderInfoView.setUserTel("");
				orderInfoView.setSeatNo("");
				orderInfoView.setTotalConsume(new BigDecimal(0));
			}

		});

		//重新将集合set回query分页对象中
		orderInfoQuery.setList(orderInfoList);
		return orderInfoList;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(OrderInfo orderInfo) {
		//1.存入对象id
		orderInfo.setId(Guid.guid());
		//2.提交数据库
		orderInfoMapper.insert(orderInfo);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(OrderInfo orderInfo) {
		orderInfoMapper.updateById(orderInfo);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(OrderInfo orderInfo) {
		orderInfoMapper.updateAllColumnById(orderInfo);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return orderInfoMapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteByIds(List<String> ids) {
		
		return orderInfoMapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public OrderInfo loadById(String id) {
		return orderInfoMapper.selectById(id);
	}


    public int logicDeleteByIds(List<String> ids) {
		return orderInfoMapper.logicDeleteByIds(ids);
    }

	public List<OrderInfoView> selectAll(Date yesTodayZero,Date yesTodayTwentyThree) {
		return orderInfoMapper.selectAll(yesTodayZero,yesTodayTwentyThree);
	}

	public void updateList(List<OrderInfoView> list) {
		orderInfoMapper.updateList(list);
	}
}
