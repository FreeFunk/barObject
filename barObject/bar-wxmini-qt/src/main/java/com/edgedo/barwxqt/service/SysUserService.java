package com.edgedo.barwxqt.service;

import com.edgedo.barwxqt.entity.SysUser;
import com.edgedo.barwxqt.entity.SysWxUser;
import com.edgedo.barwxqt.entity.WxUser;
import com.edgedo.barwxqt.mapper.SysUserMapper;
import com.edgedo.barwxqt.queryvo.SysUserQuery;
import com.edgedo.barwxqt.queryvo.SysUserView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class SysUserService {
	
	
	@Autowired
	private SysUserMapper sysUserMapper;

	public List<SysUserView> listPage(SysUserQuery sysUserQuery){
		List list = sysUserMapper.listPage(sysUserQuery);
		sysUserQuery.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(SysUser sysUser) {
		//自动生成ID
		sysUser.setId(Guid.guid());
		//存储到数据库中
		sysUserMapper.insert(sysUser);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(SysUser sysUser) {
		sysUserMapper.updateById(sysUser);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(SysUser sysUser) {
		sysUserMapper.updateAllColumnById(sysUser);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return sysUserMapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteByIds(List<String> ids) {
		
		return sysUserMapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public SysUser loadById(String id) {
		return sysUserMapper.selectById(id);
	}

	/**
	 * 根据账号查询用户
	 * @param userCode
	 * @return
	 */
	public SysUserView getAdminUserByCode(String userCode) {
		return sysUserMapper.getAdminUserByCode(userCode);
	}

	/**
	 * @author:Qiutianzhu
	 * @Description: 根据openId查询用户
	 * @Date: 2021/4/10 11:02
	 * @param openId:  用户openId
	 * @return: com.edgedo.sys.queryvo.SysUserView
	 **/
	public SysUserView loadByMiniOpenId(String openId) {
		return sysUserMapper.loadByMiniOpenId(openId);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public SysUserView saveOrUpdate(SysUser sysWxUser) {
		//根据miniOpenId查询用户是否存在
		SysUserView sysUserView = sysUserMapper.loadByMiniOpenId(sysWxUser.getOpenId());
		if(sysUserView == null){
			sysUserView = new SysUserView();
			sysUserView.setId(Guid.guid());
			sysUserView.setCreateTime(new Date());
			sysUserView.setCreateUserId(sysUserView.getId());
			sysUserView.setCreateUserName(sysUserView.getUserAccount());
			sysUserView.setLanguage(sysWxUser.getLanguage());
			sysUserView.setCity(sysWxUser.getCity());
			sysUserView.setProvince(sysWxUser.getProvince());
			sysUserView.setCountry(sysWxUser.getCountry());
			sysUserView.setLastLoginTime(new Date());
			sysUserView.setLastSessionKey(sysWxUser.getLastSessionKey());
			sysUserView.setUserTel(sysWxUser.getUserTel());
			sysUserView.setUserAccount(sysWxUser.getUserAccount());
			sysUserView.setUserHead(sysWxUser.getUserHead());
			sysUserView.setOpenId(sysWxUser.getOpenId());
			sysUserView.setUserRoleId("BAR_USER");
			sysUserView.setUserRoleName("普通用户");
			sysUserView.setIsPower("1");
			sysUserView.setDataState("1");
			sysUserMapper.insert(sysUserView);
		}else {
			sysUserView.setIsPower("1");
			sysUserView.setUserTel(sysWxUser.getUserTel());
			sysUserView.setUserAccount(sysWxUser.getUserAccount());
			sysUserView.setUserHead(sysWxUser.getUserHead());
			sysUserView.setLastLoginTime(new Date());
			sysUserView.setLastSessionKey(sysWxUser.getLastSessionKey());
			sysUserMapper.updateById(sysUserView);
		}
		return  sysUserView;
	}
}
