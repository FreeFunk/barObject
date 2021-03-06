package com.edgedo.sys.service;
		
import java.math.BigDecimal;
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.SysUser;
import com.edgedo.sys.entity.UserMoney;
import com.edgedo.sys.mapper.UserMoneyMapper;
import com.edgedo.sys.queryvo.UserMoneyQuery;
import com.edgedo.sys.queryvo.UserMoneyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class UserMoneyService {
	
	
	@Autowired
	private UserMoneyMapper UserMoneyMapper;


	@Autowired
	private SysUserService sysUserService;


	/**
	 * 根据用户姓名和手机号查询
	 * @param UserMoneyQuery
	 * @return
	 */
	public List<UserMoneyView> listPageForUserNameAndTel(UserMoneyQuery UserMoneyQuery) {
		//1.分页查询所有记录的用户钱包信息
		List<UserMoneyView> userMoneyList = UserMoneyMapper.listPageForUserNameAndTel(UserMoneyQuery);
		//2.遍历钱包集合
		userMoneyList.forEach(userMoneyView -> {
			//获取用户ID
			String userId = userMoneyView.getUserId();
			//根据用户Id查询用户信息
			SysUser sysUser = sysUserService.loadById(userId.trim());
			//挨个赋值
			if (null != sysUser){
				userMoneyView.setUserName(sysUser.getUserName());
				userMoneyView.setUserAge(sysUser.getUserAge());
				userMoneyView.setUserSex(sysUser.getUserSex());
				userMoneyView.setUserTel(sysUser.getUserTel());
			}else {
				userMoneyView.setUserName("");
				userMoneyView.setUserAge("");
				userMoneyView.setUserSex("");
				userMoneyView.setUserTel("");
			}
		});
		UserMoneyQuery.setList(userMoneyList);
		return userMoneyList;
	}


	public List<UserMoneyView> listPage(UserMoneyQuery UserMoneyQuery){
		//1.分页查询所有记录的用户钱包信息
		List<UserMoneyView> userMoneyList = UserMoneyMapper.listPage(UserMoneyQuery);
		//2.遍历钱包集合
		userMoneyList.forEach(userMoneyView -> {
			//获取用户ID
			String userId = userMoneyView.getUserId();
			//根据用户Id查询用户信息
			SysUser sysUser = sysUserService.loadById(userId.trim());
			//挨个赋值
			if (null != sysUser){
				userMoneyView.setUserName(sysUser.getUserName());
				userMoneyView.setUserAge(sysUser.getUserAge());
				userMoneyView.setUserSex(sysUser.getUserSex());
				userMoneyView.setUserTel(sysUser.getUserTel());
			}else {
				userMoneyView.setUserName("");
				userMoneyView.setUserAge("");
				userMoneyView.setUserSex("");
				userMoneyView.setUserTel("");
			}
		});
		UserMoneyQuery.setList(userMoneyList);
		return userMoneyList;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(UserMoney UserMoney) {
		UserMoney.setId(Guid.guid());
		UserMoneyMapper.insert(UserMoney);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(UserMoney UserMoney) {
		UserMoneyMapper.updateById(UserMoney);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(UserMoney UserMoney) {
		UserMoneyMapper.updateAllColumnById(UserMoney);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return UserMoneyMapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteByIds(List<String> ids) {
		
		return UserMoneyMapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public UserMoney loadById(String id) {
		return UserMoneyMapper.selectById(id);
	}


    public int logicDeleteByIds(List<String> ids) {
		return UserMoneyMapper.logicDeleteByIds(ids);
    }

	public BigDecimal selectByUserId(String userId) {
		return UserMoneyMapper.selectByUserId(userId);
	}
}
