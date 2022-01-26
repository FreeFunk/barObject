package com.edgedo.barwxqt.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.barwxqt.entity.UserMoney;
import com.edgedo.barwxqt.queryvo.UserMoneyQuery;
import com.edgedo.barwxqt.queryvo.UserMoneyView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMoneyMapper  extends BaseMapper<UserMoney>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<UserMoneyView> listPage(UserMoneyQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<UserMoneyView> listByObj(UserMoneyQuery query);


    UserMoney selectByUserId(@Param("userId") String userId);
}