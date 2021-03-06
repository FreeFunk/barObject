package com.edgedo.sys.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.SysMeun;
import com.edgedo.sys.queryvo.SysMeunQuery;
import com.edgedo.sys.queryvo.SysMeunView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface SysMeunMapper  extends BaseMapper<SysMeun>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysMeunView> listPage(SysMeunQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysMeunView> listByObj(SysMeunQuery query);

    List<SysMeun> selectByMeunAllInfo();

    int logicDeleteByIds(List<String> ids);
}