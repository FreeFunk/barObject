package com.edgedo.bar.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bar.entity.SeatInfo;
import com.edgedo.bar.queryvo.SeatInfoQuery;
import com.edgedo.bar.queryvo.SeatInfoView;
import org.apache.ibatis.annotations.Mapper;



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


    int logicDeleteByIds(List<String> ids);

    List<SeatInfo> selectBySeatAllInfo();
}