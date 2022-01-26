package com.edgedo.bar.mapper;

import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bar.entity.OrderInfo;
import com.edgedo.bar.queryvo.OrderInfoQuery;
import com.edgedo.bar.queryvo.OrderInfoView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface OrderInfoMapper  extends BaseMapper<OrderInfo>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<OrderInfoView> listPage(OrderInfoQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<OrderInfoView> listByObj(OrderInfoQuery query);

	/**
	 * 根据用户姓名和手机号查询
	 * @param query
	 * @return
	 */
    List<OrderInfoView> listPageForUserNameAndTel(OrderInfoQuery query);

    int logicDeleteByIds(List<String> ids);

    List<OrderInfoView> selectAll(@Param("yesTodayZero") Date yesTodayZero,@Param("yesTodayTwentyThree") Date yesTodayTwentyThree);

	void updateList(@Param("list") List<OrderInfoView> list);
}