package com.edgedo.bar.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bar.entity.ConsInfo;
import com.edgedo.bar.queryvo.ConsInfoQuery;
import com.edgedo.bar.queryvo.ConsInfoView;
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


    List<ConsInfo> selectSetMeal();

	ConsInfoView queryMealNameAndPrice(String setMealId);

    int logicDeleteByIds(List<String> ids);
}