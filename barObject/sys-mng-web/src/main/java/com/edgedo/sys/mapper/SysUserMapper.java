package com.edgedo.sys.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.SysUser;
import com.edgedo.sys.queryvo.SysUserQuery;
import com.edgedo.sys.queryvo.SysUserView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface SysUserMapper  extends BaseMapper<SysUser>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysUserView> listPage(SysUserQuery query);

	public List<SysUserView> listPageUserInfoAndMoneyInfo(SysUserQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysUserView> listByObj(SysUserQuery query);

	/**
	 * 根据账号查询用户
	 * @param userCode
	 * @return
	 */
	public SysUserView getAdminUserByCode(String userCode);

    SysUserView loadByMiniOpenId(String openId);

	List<SysUserView> queryAdminUsers(SysUserQuery sysUserQuery);

    int logicDeleteByIds(List<String> ids);

    List<SysUser> selectByUserAllInfo();
}