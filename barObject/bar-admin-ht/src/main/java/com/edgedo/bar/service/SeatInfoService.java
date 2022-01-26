package com.edgedo.bar.service;
		
import java.math.BigDecimal;
import java.util.List;

import com.edgedo.bar.queryvo.ConsInfoView;
import com.edgedo.common.util.Guid;
import com.edgedo.bar.entity.SeatInfo;
import com.edgedo.bar.mapper.SeatInfoMapper;
import com.edgedo.bar.queryvo.SeatInfoQuery;
import com.edgedo.bar.queryvo.SeatInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class SeatInfoService {
	
	
	@Autowired
	private SeatInfoMapper seatInfoMapper;

	@Autowired
	private ConsInfoService consInfoService;

	public List<SeatInfoView> listPage(SeatInfoQuery seatInfoQuery){
		List<SeatInfoView> seatInfoList = seatInfoMapper.listPage(seatInfoQuery);
		//根据查询出来的套餐ID去查询套餐名
		seatInfoList.forEach(seat -> {
			ConsInfoView consInfov = new ConsInfoView();
			consInfov = consInfoService.queryMealNameAndPrice(seat.getSetMealId());
			if (null != consInfov){
				seat.setSetMealName(consInfov.getSetMealName());
				seat.setSetMealPrice(consInfov.getSetMealPrice());
			}else {
				seat.setSetMealName("无");
				seat.setSetMealPrice(new BigDecimal(0.0));
			}
		});
		seatInfoQuery.setList(seatInfoList);
		return seatInfoList;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(SeatInfo seatInfo) {
		seatInfo.setId(Guid.guid());
		seatInfoMapper.insert(seatInfo);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(SeatInfo seatInfo) {
		seatInfoMapper.updateById(seatInfo);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(SeatInfo seatInfo) {
		seatInfoMapper.updateAllColumnById(seatInfo);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return seatInfoMapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteByIds(List<String> ids) {
		
		return seatInfoMapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public SeatInfo loadById(String id) {
		return seatInfoMapper.selectById(id);
	}

	/**
	 * 批量逻辑删除
	 * @param ids
	 * @return
	 */
	public int logicDeleteByIds(List<String> ids) {
		return seatInfoMapper.logicDeleteByIds(ids);
	}

    public List<SeatInfo> selectBySeatAllInfo() {
		return seatInfoMapper.selectBySeatAllInfo();
    }
}
