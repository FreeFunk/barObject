package com.edgedo.sys.mapper;

import java.math.BigDecimal;
import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.UserMoney;
import com.edgedo.sys.queryvo.UserMoneyQuery;
import com.edgedo.sys.queryvo.UserMoneyView;
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
	 * 根据用户姓名和手机号查询
	 * @param query
	 * @return
	 */
	List<UserMoneyView> listPageForUserNameAndTel(UserMoneyQuery query);

	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<UserMoneyView> listByObj(UserMoneyQuery query);


    int logicDeleteByIds(List<String> ids);

    BigDecimal selectByUserId(@Param("userId") String userId);
}