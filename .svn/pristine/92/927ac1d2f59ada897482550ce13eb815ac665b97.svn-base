package com.edgedo.bar.service;
		
import java.math.BigDecimal;
import java.util.List;

import com.edgedo.bar.entity.OrderDetailsInfo;
import com.edgedo.bar.entity.SeatInfo;
import com.edgedo.bar.queryvo.OrderInfoView;
import com.edgedo.common.util.Guid;
import com.edgedo.bar.entity.ConsInfo;
import com.edgedo.bar.mapper.ConsInfoMapper;
import com.edgedo.bar.queryvo.ConsInfoQuery;
import com.edgedo.bar.queryvo.ConsInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class ConsInfoService {
	
	
	@Autowired
	private ConsInfoMapper ConsInfoMapper;

	@Autowired
	private SeatInfoService seatInfoService;

	public List<ConsInfoView> listPage(ConsInfoQuery ConsInfoQuery){
		List list = ConsInfoMapper.listPage(ConsInfoQuery);
		ConsInfoQuery.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(ConsInfo ConsInfo) {
		ConsInfo.setId(Guid.guid());
		ConsInfoMapper.insert(ConsInfo);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(ConsInfo ConsInfo) {
		ConsInfoMapper.updateById(ConsInfo);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(ConsInfo ConsInfo) {
		ConsInfoMapper.updateAllColumnById(ConsInfo);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return ConsInfoMapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteByIds(List<String> ids) {
		
		return ConsInfoMapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public ConsInfo loadById(String id) {
		return ConsInfoMapper.selectById(id);
	}


    public List<ConsInfo> selectSetMeal() {
		return ConsInfoMapper.selectSetMeal();
	}

	public ConsInfoView queryMealNameAndPrice(String setMealId) {
		return ConsInfoMapper.queryMealNameAndPrice(setMealId);
	}

    public int logicDeleteByIds(List<String> ids) {
		return ConsInfoMapper.logicDeleteByIds(ids);
    }
}
