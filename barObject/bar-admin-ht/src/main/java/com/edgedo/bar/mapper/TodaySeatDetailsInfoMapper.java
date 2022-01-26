package com.edgedo.bar.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bar.entity.TodaySeatDetailsInfo;
import com.edgedo.bar.queryvo.TodaySeatDetailsInfoQuery;
import com.edgedo.bar.queryvo.TodaySeatDetailsInfoView;
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


    int selectInDetermineForTime(@Param("dateTimeInteger") Integer dateTimeInteger, @Param("seatId") String seatId);
}