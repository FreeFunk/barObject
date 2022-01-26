package com.edgedo.barwxqt.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.barwxqt.entity.SysUser;
import com.edgedo.barwxqt.queryvo.SysUserQuery;
import com.edgedo.barwxqt.queryvo.SysUserView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SysUserMapper extends BaseMapper<SysUser>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysUserView> listPage(SysUserQuery query);
	
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
}