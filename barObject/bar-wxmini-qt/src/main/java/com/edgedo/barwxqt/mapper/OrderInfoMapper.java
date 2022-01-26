package com.edgedo.barwxqt.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.barwxqt.entity.OrderInfo;
import com.edgedo.barwxqt.queryvo.OrderInfoQuery;
import com.edgedo.barwxqt.queryvo.OrderInfoView;
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


    List<OrderInfoView> selectByUserIdAndOrderState(@Param("userId") String userId,@Param("checkStats") String checkStats);
}