package com.edgedo.barwxqt.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.barwxqt.entity.OrderDetailsInfo;
import com.edgedo.barwxqt.queryvo.OrderDetailsInfoQuery;
import com.edgedo.barwxqt.queryvo.OrderDetailsInfoView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface OrderDetailsInfoMapper  extends BaseMapper<OrderDetailsInfo>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<OrderDetailsInfoView> listPage(OrderDetailsInfoQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<OrderDetailsInfoView> listByObj(OrderDetailsInfoQuery query);


    List<OrderDetailsInfoView> selectByOrderIdList(List<String> orderIdList);

    OrderDetailsInfo selectByOrderId(String orderId);

	List<OrderDetailsInfoView> selectByUserIdAndOrderState(@Param("userId") String userId, @Param("checkStats") String checkStats);
}