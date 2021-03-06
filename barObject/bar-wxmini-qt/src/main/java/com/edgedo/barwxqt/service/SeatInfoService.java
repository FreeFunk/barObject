package com.edgedo.barwxqt.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.barwxqt.entity.SeatInfo;
import com.edgedo.barwxqt.mapper.SeatInfoMapper;
import com.edgedo.barwxqt.queryvo.SeatInfoQuery;
import com.edgedo.barwxqt.queryvo.SeatInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class SeatInfoService {
	
	
	@Autowired
	private SeatInfoMapper seatInfoMapper;

	public List<SeatInfoView> listPage(SeatInfoQuery seatInfoQuery){
		List list = seatInfoMapper.listPage(seatInfoQuery);
		seatInfoQuery.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(SeatInfo seatInfo) {
		seatInfo.setId(Guid.guid());
		seatInfoMapper.insert(seatInfo);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(SeatInfo seatInfo) {
		seatInfoMapper.updateById(seatInfo);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(SeatInfo seatInfo) {
		seatInfoMapper.updateAllColumnById(seatInfo);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return seatInfoMapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteByIds(List<String> ids) {
		
		return seatInfoMapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public SeatInfo loadById(String id) {
		return seatInfoMapper.selectById(id);
	}


	public int selectByYIndex() {
		return seatInfoMapper.selectByYIndex();
	}

	public List<SeatInfoView> selectByYIndexNumForList(int yIndexNum) {
		return seatInfoMapper.selectByYIndexNumForList(yIndexNum);
	}
}
