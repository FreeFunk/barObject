package com.edgedo.barwxqt.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.barwxqt.entity.UserMoney;
import com.edgedo.barwxqt.mapper.UserMoneyMapper;
import com.edgedo.barwxqt.queryvo.UserMoneyQuery;
import com.edgedo.barwxqt.queryvo.UserMoneyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class UserMoneyService {
	
	
	@Autowired
	private UserMoneyMapper userMoneyMapper;

	public List<UserMoneyView> listPage(UserMoneyQuery userMoneyQuery){
		List list = userMoneyMapper.listPage(userMoneyQuery);
		userMoneyQuery.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(UserMoney userMoney) {
		userMoney.setId(Guid.guid());
		userMoneyMapper.insert(userMoney);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(UserMoney userMoney) {
		userMoneyMapper.updateById(userMoney);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(UserMoney userMoney) {
		userMoneyMapper.updateAllColumnById(userMoney);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return userMoneyMapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteByIds(List<String> ids) {
		
		return userMoneyMapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public UserMoney loadById(String id) {
		return userMoneyMapper.selectById(id);
	}


	public UserMoney selectByUserId(String userId) {
		return userMoneyMapper.selectByUserId(userId);
	}
}
