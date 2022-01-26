package com.edgedo.barwxqt.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.barwxqt.entity.ConsInfo;
import com.edgedo.barwxqt.queryvo.ConsInfoQuery;
import com.edgedo.barwxqt.queryvo.ConsInfoView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ConsInfoMapper  extends BaseMapper<ConsInfo>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ConsInfoView> listPage(ConsInfoQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ConsInfoView> listByObj(ConsInfoQuery query);
	
	

}