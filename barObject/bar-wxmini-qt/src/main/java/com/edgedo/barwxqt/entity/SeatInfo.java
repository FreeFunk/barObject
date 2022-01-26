package com.edgedo.barwxqt.entity;

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
	 * 属性描述:套餐ID
	 */
	@TableField(value="SET_MEAL_ID",exist=true)
	java.lang.String setMealId;
	
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
	 * 属性描述:X轴索引
	 */
	@TableField(value="X_INDEX",exist=true)
	java.lang.Integer xindex;
	
	/**
	 * 属性描述:Y轴索引
	 */
	@TableField(value="Y_INDEX",exist=true)
	java.lang.Integer yindex;
	
	/**
	 * 属性描述:是否横放
	 */
	@TableField(value="IS_TRANS",exist=true)
	java.lang.String isTrans;
	
	/**
	 * 属性描述:分区
	 */
	@TableField(value="SEAT_PARTITION",exist=true)
	java.lang.String seatPartition;
	
	
	
	
	
	
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
	
	
	public java.lang.String getSetMealId(){
		return this.setMealId;
	}
	
	public void setSetMealId(java.lang.String setMealId){
		this.setMealId=setMealId;
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
	
	
	public java.lang.Integer getXindex(){
		return this.xindex;
	}
	
	public void setXindex(java.lang.Integer xindex){
		this.xindex=xindex;
	}
	
	
	public java.lang.Integer getYindex(){
		return this.yindex;
	}
	
	public void setYindex(java.lang.Integer yindex){
		this.yindex=yindex;
	}
	
	
	public java.lang.String getIsTrans(){
		return this.isTrans;
	}
	
	public void setIsTrans(java.lang.String isTrans){
		this.isTrans=isTrans;
	}
	
	
	public java.lang.String getSeatPartition(){
		return this.seatPartition;
	}
	
	public void setSeatPartition(java.lang.String seatPartition){
		this.seatPartition=seatPartition;
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
			sb.append(", setMealId=").append(setMealId);			
			sb.append(", seatMinConsume=").append(seatMinConsume);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", createUserId=").append(createUserId);			
			sb.append(", createUserName=").append(createUserName);			
			sb.append(", dataState=").append(dataState);			
			sb.append(", xindex=").append(xindex);			
			sb.append(", yindex=").append(yindex);			
			sb.append(", isTrans=").append(isTrans);			
			sb.append(", seatPartition=").append(seatPartition);			
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
				        		&&(this.getSetMealId() == null ? other.getId() == null : this.getSetMealId().equals(other.getSetMealId()))		
				        		&&(this.getSeatMinConsume() == null ? other.getId() == null : this.getSeatMinConsume().equals(other.getSeatMinConsume()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getCreateUserId() == null ? other.getId() == null : this.getCreateUserId().equals(other.getCreateUserId()))		
				        		&&(this.getCreateUserName() == null ? other.getId() == null : this.getCreateUserName().equals(other.getCreateUserName()))		
				        		&&(this.getDataState() == null ? other.getId() == null : this.getDataState().equals(other.getDataState()))		
				        		&&(this.getXindex() == null ? other.getId() == null : this.getXindex().equals(other.getXindex()))		
				        		&&(this.getYindex() == null ? other.getId() == null : this.getYindex().equals(other.getYindex()))		
				        		&&(this.getIsTrans() == null ? other.getId() == null : this.getIsTrans().equals(other.getIsTrans()))		
				        		&&(this.getSeatPartition() == null ? other.getId() == null : this.getSeatPartition().equals(other.getSeatPartition()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getSeatNo() == null) ? 0 : getSeatNo().hashCode());		
		        result = prime * result + ((getSeatCapacity() == null) ? 0 : getSeatCapacity().hashCode());		
		        result = prime * result + ((getSetMealId() == null) ? 0 : getSetMealId().hashCode());		
		        result = prime * result + ((getSeatMinConsume() == null) ? 0 : getSeatMinConsume().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());		
		        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());		
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());		
		        result = prime * result + ((getXindex() == null) ? 0 : getXindex().hashCode());		
		        result = prime * result + ((getYindex() == null) ? 0 : getYindex().hashCode());		
		        result = prime * result + ((getIsTrans() == null) ? 0 : getIsTrans().hashCode());		
		        result = prime * result + ((getSeatPartition() == null) ? 0 : getSeatPartition().hashCode());		
		;
        return result;
    }

}
