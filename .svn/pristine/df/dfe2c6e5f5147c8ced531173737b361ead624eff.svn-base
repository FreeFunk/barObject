package com.edgedo.sys.service;
		
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.SysMeun;
import com.edgedo.sys.entity.SysMeunUser;
import com.edgedo.sys.mapper.SysMeunUserMapper;
import com.edgedo.sys.queryvo.SysMeunUserQuery;
import com.edgedo.sys.queryvo.SysMeunUserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class SysMeunUserService {
	
	
	@Autowired
	private SysMeunUserMapper sysMeunUserMapper;

	public List<SysMeunUserView> listPage(SysMeunUserQuery sysMeunUserQuery){
		List list = sysMeunUserMapper.listPage(sysMeunUserQuery);
		sysMeunUserQuery.setList(list);
		return list;
	}


	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(SysMeunUser sysMeunUser) {
		sysMeunUser.setId(Guid.guid());
		sysMeunUserMapper.insert(sysMeunUser);
		return "";
	}

	/**
	 * 将数组属性的值取出，再插入
	 * @param sysMeunUserView
	 * @return
	 */
	public String insertFromList(SysMeunUserView sysMeunUserView) {
		SysMeunUser sysMeunUser = new SysMeunUser();
		List<String> meunIdList = Arrays.asList(sysMeunUserView.getMeunIdArr());
		meunIdList.forEach(meunId ->{
			//给属性赋值
			sysMeunUser.setCreateTime(sysMeunUserView.getCreateTime());
			sysMeunUser.setCreateUserId(sysMeunUserView.getCreateUserId());
			sysMeunUser.setCreateUserName(sysMeunUserView.getCreateUserName());
			sysMeunUser.setDataState("1");
			sysMeunUser.setId(Guid.guid());
			sysMeunUser.setMeunId(meunId);
			sysMeunUser.setUserId(sysMeunUserView.getUserId());
			sysMeunUserMapper.insert(sysMeunUser);
		});
		return "";

	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(SysMeunUser sysMeunUser) {
		sysMeunUserMapper.updateById(sysMeunUser);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(SysMeunUser sysMeunUser) {
		sysMeunUserMapper.updateAllColumnById(sysMeunUser);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return sysMeunUserMapper.deleteById(id);
	}

	/**
	 * 根据用户id删除
	 * @param userId
	 */
	public int deleteByUserId(String userId) {

		return sysMeunUserMapper.deleteByUserId(userId);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteByIds(List<String> ids) {
		
		return sysMeunUserMapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public SysMeunUser loadById(String id) {
		return sysMeunUserMapper.selectById(id);
	}


	public List<SysMeunUser> selectByUserId(String userId) {
		return sysMeunUserMapper.selectByUserId(userId);
	}


	public List<String> selectByUserIdInMeunList(String userId) {
		return sysMeunUserMapper.selectByUserIdInMeunList(userId);
	}
}
