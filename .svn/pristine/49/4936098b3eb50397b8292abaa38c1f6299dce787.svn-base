package com.edgedo.bar.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bar.entity.OrderDetailsInfo;
import com.edgedo.bar.queryvo.OrderDetailsInfoQuery;
import com.edgedo.bar.queryvo.OrderDetailsInfoView;
import org.apache.ibatis.annotations.Mapper;



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


    OrderDetailsInfo seletByOrderId(String orderId);
}