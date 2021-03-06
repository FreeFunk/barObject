package com.edgedo.sys.service;
		
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.common.util.MD5;
import com.edgedo.sys.entity.SysUser;
import com.edgedo.sys.entity.SysWxUser;
import com.edgedo.sys.mapper.SysUserMapper;
import com.edgedo.sys.queryvo.SysUserQuery;
import com.edgedo.sys.queryvo.SysUserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class SysUserService {
	
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private UserMoneyService userMoneyService;

	public List<SysUserView> listPage(SysUserQuery sysUserQuery){
		List list = sysUserMapper.listPage(sysUserQuery);
		sysUserQuery.setList(list);
		return list;
	}


	public List<SysUserView> listUserInfoAndMoneyInfo(SysUserQuery sysUserQuery){
		List<SysUserView> list = sysUserMapper.listPageUserInfoAndMoneyInfo(sysUserQuery);
		list.forEach(user->{
			BigDecimal userMoney = userMoneyService.selectByUserId(user.getId());
			if (null == userMoney){
				user.setUserMoney(new BigDecimal(0));
			}else {
				user.setUserMoney(userMoney);
			}
			user.setUserCurrViewType(sysUserQuery.getUserCurrQueryType());
		});
		sysUserQuery.setList(list);
		return list;
	}

	/**
	 * 查询非普通用户
	 * @param sysUserQuery
	 * @return
	 */
	public List<SysUserView> queryAdminUsers(SysUserQuery sysUserQuery) {
		List list = sysUserMapper.queryAdminUsers(sysUserQuery);
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

		//密码加密存储
		String pwd = MD5.encode(MD5.encode(sysUser.getUserPassword())+sysUser.getId());
		sysUser.setUserPassword(pwd);


		//根据角色名添加角色ID
		switch (sysUser.getUserRoleId()){
			case "BAR_ADMIN" :
				sysUser.setUserRoleName("酒吧管理员");
				break;
			case "BAR_USER" :
				sysUser.setUserRoleName("普通用户");
				break;
		}

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
	public SysUserView saveOrUpdate(SysWxUser sysWxUser) {
		//根据miniOpenId查询用户是否存在
		SysUserView sysUserView = sysUserMapper.loadByMiniOpenId(sysWxUser.getOpenId());
		if(sysUserView == null){
			sysUserView = new SysUserView();
			sysUserView.setId(Guid.guid());
			sysUserView.setCreateTime(new Date());
			sysUserView.setUserTel(sysWxUser.getPhoneNum());
			sysUserView.setUserAccount(sysWxUser.getNickName());
			sysUserView.setUserHead(sysWxUser.getHeadPhoto());
			sysUserView.setOpenId(sysWxUser.getOpenId());
			sysUserView.setIsPower("0");
			sysUserView.setDataState("1");
			sysUserMapper.insert(sysUserView);
		}else {
			sysUserView.setUserTel(sysWxUser.getPhoneNum());
			sysUserView.setUserAccount(sysWxUser.getNickName());
			sysUserView.setUserHead(sysWxUser.getHeadPhoto());
			sysUserMapper.updateById(sysUserView);
		}
		return  sysUserView;
	}

	public String updatePassword(SysUser sysUser) {
		String pwd = MD5.encode(MD5.encode(sysUser.getUserPassword())+sysUser.getId());
		sysUser.setUserPassword(pwd);
		sysUserMapper.updateById(sysUser);
		return "";
	}


	public int logicDeleteByIds(List<String> list) {
		return sysUserMapper.logicDeleteByIds(list);
	}

    public List<SysUser> selectByUserAllInfo() {
		return sysUserMapper.selectByUserAllInfo();
    }
}
