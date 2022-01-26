package com.edgedo.barwxqt.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.barwxqt.entity.TodaySeatDetailsInfo;
import com.edgedo.barwxqt.mapper.TodaySeatDetailsInfoMapper;
import com.edgedo.barwxqt.queryvo.TodaySeatDetailsInfoQuery;
import com.edgedo.barwxqt.queryvo.TodaySeatDetailsInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class TodaySeatDetailsInfoService {
	
	
	@Autowired
	private TodaySeatDetailsInfoMapper todaySeatDetailsInfoMapper;

	public List<TodaySeatDetailsInfoView> listPage(TodaySeatDetailsInfoQuery todaySeatDetailsInfoQuery){
		List list = todaySeatDetailsInfoMapper.listPage(todaySeatDetailsInfoQuery);
		todaySeatDetailsInfoQuery.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(TodaySeatDetailsInfo todaySeatDetailsInfo) {
		todaySeatDetailsInfo.setId(Guid.guid());
		todaySeatDetailsInfoMapper.insert(todaySeatDetailsInfo);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(TodaySeatDetailsInfo todaySeatDetailsInfo) {
		todaySeatDetailsInfoMapper.updateById(todaySeatDetailsInfo);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(TodaySeatDetailsInfo todaySeatDetailsInfo) {
		todaySeatDetailsInfoMapper.updateAllColumnById(todaySeatDetailsInfo);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return todaySeatDetailsInfoMapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteByIds(List<String> ids) {
		
		return todaySeatDetailsInfoMapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public TodaySeatDetailsInfo loadById(String id) {
		return todaySeatDetailsInfoMapper.selectById(id);
	}


	public String selectBySeatIdAndDateInt(String seatId, int dateInt) {
		return todaySeatDetailsInfoMapper.selectBySeatIdAndDateInt(seatId,dateInt);
	}

	public List<TodaySeatDetailsInfoView> selectBySeatId(String seatId,int dateInt) {
		return todaySeatDetailsInfoMapper.selectBySeatId(seatId,dateInt);
	}
}
