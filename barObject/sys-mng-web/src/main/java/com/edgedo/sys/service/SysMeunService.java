package com.edgedo.sys.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.SysMeun;
import com.edgedo.sys.mapper.SysMeunMapper;
import com.edgedo.sys.queryvo.SysMeunQuery;
import com.edgedo.sys.queryvo.SysMeunView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class SysMeunService {
	
	
	@Autowired
	private SysMeunMapper sysMeunMapper;

	public List<SysMeunView> listPage(SysMeunQuery sysMeunQuery){
		List list = sysMeunMapper.listPage(sysMeunQuery);
		sysMeunQuery.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(SysMeun sysMeun) {
		sysMeun.setId(Guid.guid());
		sysMeunMapper.insert(sysMeun);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(SysMeun sysMeun) {
		sysMeunMapper.updateById(sysMeun);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(SysMeun sysMeun) {
		sysMeunMapper.updateAllColumnById(sysMeun);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return sysMeunMapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteByIds(List<String> ids) {
		
		return sysMeunMapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public SysMeun loadById(String id) {
		return sysMeunMapper.selectById(id);
	}

	/**
	 * 查询菜单所有信息
	 * @return
	 */
	public List<SysMeun> selectByMeunAllInfo() {
		return sysMeunMapper.selectByMeunAllInfo();
	}

    public int logicDeleteByIds(List<String> ids) {
		return sysMeunMapper.logicDeleteByIds(ids);
    }
}
