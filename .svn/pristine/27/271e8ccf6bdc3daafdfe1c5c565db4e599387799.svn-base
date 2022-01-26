package com.edgedo.barwxqt.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.barwxqt.entity.ConsInfo;
import com.edgedo.barwxqt.mapper.ConsInfoMapper;
import com.edgedo.barwxqt.queryvo.ConsInfoQuery;
import com.edgedo.barwxqt.queryvo.ConsInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class ConsInfoService {
	
	
	@Autowired
	private ConsInfoMapper consInfoMapper;

	public List<ConsInfoView> listPage(ConsInfoQuery consInfoQuery){
		List list = consInfoMapper.listPage(consInfoQuery);
		consInfoQuery.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(ConsInfo consInfo) {
		consInfo.setId(Guid.guid());
		consInfoMapper.insert(consInfo);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(ConsInfo consInfo) {
		consInfoMapper.updateById(consInfo);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(ConsInfo consInfo) {
		consInfoMapper.updateAllColumnById(consInfo);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return consInfoMapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteByIds(List<String> ids) {
		
		return consInfoMapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public ConsInfo loadById(String id) {
		return consInfoMapper.selectById(id);
	}
	

}
