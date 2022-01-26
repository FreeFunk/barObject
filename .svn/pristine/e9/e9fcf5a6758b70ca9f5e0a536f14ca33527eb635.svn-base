package com.edgedo.barwxqt.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.barwxqt.entity.SeatInfo;
import com.edgedo.barwxqt.queryvo.SeatInfoQuery;
import com.edgedo.barwxqt.queryvo.SeatInfoView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface SeatInfoMapper  extends BaseMapper<SeatInfo>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SeatInfoView> listPage(SeatInfoQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SeatInfoView> listByObj(SeatInfoQuery query);


    int selectByYIndex();

	List<SeatInfoView> selectByYIndexNumForList(@Param("yIndexNum") int yIndexNum);
}