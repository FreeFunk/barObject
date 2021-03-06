package com.edgedo.bar.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("seat_info")
public class SeatInfo implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	java.lang.String id;
	
	/**
	 * 属性描述:座位号
	 */
	@TableField(value="SEAT_NO",exist=true)
	java.lang.String seatNo;
	
	/**
	 * 属性描述:容纳人数
	 */
	@TableField(value="SEAT_CAPACITY",exist=true)
	java.lang.Integer seatCapacity;
	
	/**
	 * 属性描述:最低消费
	 */
	@TableField(value="SEAT_MIN_CONSUME",exist=true)
	java.math.BigDecimal seatMinConsume;
	
	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	java.util.Date createTime;
	
	/**
	 * 属性描述:创建人ID
	 */
	@TableField(value="CREATE_USER_ID",exist=true)
	java.lang.String createUserId;
	
	/**
	 * 属性描述:创建人名
	 */
	@TableField(value="CREATE_USER_NAME",exist=true)
	java.lang.String createUserName;
	
	/**
	 * 属性描述:数据状态
	 */
	@TableField(value="DATA_STATE",exist=true)
	java.lang.String dataState;

	/**
	 * 属性描述:x轴索引
	 */
	@TableField(value="X_INDEX",exist=true)
	java.lang.Integer xIndex;

	/**
	 * 属性描述:y轴索引
	 */
	@TableField(value="Y_INDEX",exist=true)
	java.lang.Integer yIndex;

	/**
	 * 属性描述:是否横放
	 */
	@TableField(value="IS_TRANS",exist=true)
	java.lang.String isTrans;

	/**
	 * 属性描述:分区
	 */
	@TableField(value="SEAT_PARTITION",exist=true)
	java.lang.String partition;

	/**
	 * 属性描述:套餐ID
	 */
	@TableField(value="SET_MEAL_ID",exist=true)
	java.lang.String setMealId;
	
	
	
	
	
	public java.lang.String getId(){
		return this.id;
	}
	
	public void setId(java.lang.String id){
		this.id=id;
	}
	
	
	public java.lang.String getSeatNo(){
		return this.seatNo;
	}
	
	public void setSeatNo(java.lang.String seatNo){
		this.seatNo=seatNo;
	}
	
	
	public java.lang.Integer getSeatCapacity(){
		return this.seatCapacity;
	}
	
	public void setSeatCapacity(java.lang.Integer seatCapacity){
		this.seatCapacity=seatCapacity;
	}
	
	
	public java.math.BigDecimal getSeatMinConsume(){
		return this.seatMinConsume;
	}
	
	public void setSeatMinConsume(java.math.BigDecimal seatMinConsume){
		this.seatMinConsume=seatMinConsume;
	}
	
	
	public java.util.Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}
	
	
	public java.lang.String getCreateUserId(){
		return this.createUserId;
	}
	
	public void setCreateUserId(java.lang.String createUserId){
		this.createUserId=createUserId;
	}
	
	
	public java.lang.String getCreateUserName(){
		return this.createUserName;
	}
	
	public void setCreateUserName(java.lang.String createUserName){
		this.createUserName=createUserName;
	}
	
	
	public java.lang.String getDataState(){
		return this.dataState;
	}
	
	public void setDataState(java.lang.String dataState){
		this.dataState=dataState;
	}

	public Integer getxIndex() {
		return xIndex;
	}

	public void setxIndex(Integer xIndex) {
		this.xIndex = xIndex;
	}

	public Integer getyIndex() {
		return yIndex;
	}

	public void setyIndex(Integer yIndex) {
		this.yIndex = yIndex;
	}

	public String getIsTrans() {
		return isTrans;
	}

	public void setIsTrans(String isTrans) {
		this.isTrans = isTrans;
	}

	public String getPartition() {
		return partition;
	}

	public void setPartition(String partition) {
		this.partition = partition;
	}

	public String getSetMealId() {
		return setMealId;
	}

	public void setSetMealId(String setMealId) {
		this.setMealId = setMealId;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", seatNo=").append(seatNo);			
			sb.append(", seatCapacity=").append(seatCapacity);			
			sb.append(", seatMinConsume=").append(seatMinConsume);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", createUserId=").append(createUserId);			
			sb.append(", createUserName=").append(createUserName);			
			sb.append(", dataState=").append(dataState);
			sb.append(", xIndex=").append(xIndex);
			sb.append(", yIndex=").append(yIndex);
			sb.append(", isTrans=").append(isTrans);
			sb.append(", partition=").append(partition);
			sb.append(", setMealId=").append(setMealId);
        sb.append("]");
        return sb.toString();
    }

   
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SeatInfo other = (SeatInfo) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getSeatNo() == null ? other.getId() == null : this.getSeatNo().equals(other.getSeatNo()))		
				        		&&(this.getSeatCapacity() == null ? other.getId() == null : this.getSeatCapacity().equals(other.getSeatCapacity()))		
				        		&&(this.getSeatMinConsume() == null ? other.getId() == null : this.getSeatMinConsume().equals(other.getSeatMinConsume()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getCreateUserId() == null ? other.getId() == null : this.getCreateUserId().equals(other.getCreateUserId()))		
				        		&&(this.getCreateUserName() == null ? other.getId() == null : this.getCreateUserName().equals(other.getCreateUserName()))		
				        		&&(this.getDataState() == null ? other.getId() == null : this.getDataState().equals(other.getDataState()))
								&&(this.getxIndex() == null ? other.getId() == null : this.getxIndex().equals(other.getxIndex()))
								&&(this.getyIndex() == null ? other.getId() == null : this.getyIndex().equals(other.getyIndex()))
								&&(this.getIsTrans() == null ? other.getId() == null : this.getIsTrans().equals(other.getIsTrans()))
								&&(this.getPartition() == null ? other.getId() == null : this.getPartition().equals(other.getPartition()))
								&&(this.getSetMealId() == null ? other.getId() == null : this.getSetMealId().equals(other.getSetMealId()))
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getSeatNo() == null) ? 0 : getSeatNo().hashCode());		
		        result = prime * result + ((getSeatCapacity() == null) ? 0 : getSeatCapacity().hashCode());		
		        result = prime * result + ((getSeatMinConsume() == null) ? 0 : getSeatMinConsume().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());		
		        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());		
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());
				result = prime * result + ((getxIndex() == null) ? 0 : getxIndex().hashCode());
				result = prime * result + ((getyIndex() == null) ? 0 : getyIndex().hashCode());
				result = prime * result + ((getIsTrans() == null) ? 0 : getIsTrans().hashCode());
				result = prime * result + ((getPartition() == null) ? 0 : getPartition().hashCode());
				result = prime * result + ((getSetMealId() == null) ? 0 : getSetMealId().hashCode());
				;
        return result;
    }

}
