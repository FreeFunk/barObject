package com.edgedo.barwxqt.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.barwxqt.entity.TodaySeatDetailsInfo;
import com.edgedo.barwxqt.queryvo.TodaySeatDetailsInfoQuery;
import com.edgedo.barwxqt.queryvo.TodaySeatDetailsInfoView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface TodaySeatDetailsInfoMapper  extends BaseMapper<TodaySeatDetailsInfo>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<TodaySeatDetailsInfoView> listPage(TodaySeatDetailsInfoQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<TodaySeatDetailsInfoView> listByObj(TodaySeatDetailsInfoQuery query);


    String selectBySeatIdAndDateInt(@Param("seatId") String seatId, @Param("dateInt")int dateInt);

	List<TodaySeatDetailsInfoView> selectBySeatId(@Param("seatId") String seatId, @Param("dateInt")int dateInt);
}