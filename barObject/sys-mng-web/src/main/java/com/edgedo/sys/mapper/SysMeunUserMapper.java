package com.edgedo.sys.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.SysMeun;
import com.edgedo.sys.entity.SysMeunUser;
import com.edgedo.sys.queryvo.SysMeunUserQuery;
import com.edgedo.sys.queryvo.SysMeunUserView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface SysMeunUserMapper  extends BaseMapper<SysMeunUser>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysMeunUserView> listPage(SysMeunUserQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysMeunUserView> listByObj(SysMeunUserQuery query);


	List<SysMeunUser> selectByUserId(String userId);

	Integer deleteByUserId(String userId);


    List<String> selectByUserIdInMeunList(String userId);
}