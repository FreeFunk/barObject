package com.edgedo.barwxqt.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.barwxqt.entity.OrderInfo;
import com.edgedo.barwxqt.mapper.OrderInfoMapper;
import com.edgedo.barwxqt.queryvo.OrderInfoQuery;
import com.edgedo.barwxqt.queryvo.OrderInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class OrderInfoService {
	
	
	@Autowired
	private OrderInfoMapper orderInfoMapper;

	public List<OrderInfoView> listPage(OrderInfoQuery orderInfoQuery){
		List list = orderInfoMapper.listPage(orderInfoQuery);
		orderInfoQuery.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(OrderInfo orderInfo) {
		orderInfo.setId(Guid.guid());
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


	public List<OrderInfoView> selectByUserIdAndOrderState(String userId, String checkStats) {
		return orderInfoMapper.selectByUserIdAndOrderState(userId,checkStats);
	}
}
