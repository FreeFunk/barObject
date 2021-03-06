package com.edgedo.barwxqt.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.barwxqt.entity.OrderDetailsInfo;
import com.edgedo.barwxqt.mapper.OrderDetailsInfoMapper;
import com.edgedo.barwxqt.queryvo.OrderDetailsInfoQuery;
import com.edgedo.barwxqt.queryvo.OrderDetailsInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class OrderDetailsInfoService {
	
	
	@Autowired
	private OrderDetailsInfoMapper orderDetailsInfoMapper;

	public List<OrderDetailsInfoView> listPage(OrderDetailsInfoQuery orderDetailsInfoQuery){
		List list = orderDetailsInfoMapper.listPage(orderDetailsInfoQuery);
		orderDetailsInfoQuery.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(OrderDetailsInfo orderDetailsInfo) {
		orderDetailsInfo.setId(Guid.guid());
		orderDetailsInfoMapper.insert(orderDetailsInfo);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(OrderDetailsInfo orderDetailsInfo) {
		orderDetailsInfoMapper.updateById(orderDetailsInfo);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(OrderDetailsInfo orderDetailsInfo) {
		orderDetailsInfoMapper.updateAllColumnById(orderDetailsInfo);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return orderDetailsInfoMapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteByIds(List<String> ids) {
		
		return orderDetailsInfoMapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public OrderDetailsInfo loadById(String id) {
		return orderDetailsInfoMapper.selectById(id);
	}


	public List<OrderDetailsInfoView> selectByOrderIdList(List<String> orderIdList) {
		return orderDetailsInfoMapper.selectByOrderIdList(orderIdList);
	}

	public OrderDetailsInfo selectByOrderId(String orderId) {
		return orderDetailsInfoMapper.selectByOrderId(orderId);
	}

	public List<OrderDetailsInfoView> selectByUserIdAndOrderState(String userId, String checkStats) {
		return orderDetailsInfoMapper.selectByUserIdAndOrderState(userId,checkStats);
	}
}
