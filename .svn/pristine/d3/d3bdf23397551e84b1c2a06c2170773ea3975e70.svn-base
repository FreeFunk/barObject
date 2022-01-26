package com.edgedo.bar.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("today_seat_details_info")
public class TodaySeatDetailsInfo implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	java.lang.String id;
	
	/**
	 * 属性描述:座位ID
	 */
	@TableField(value="SEAT_ID",exist=true)
	java.lang.String seatId;
	
	/**
	 * 属性描述:座位状态
	 */
	@TableField(value="SEAT_STATE",exist=true)
	java.lang.String seatState;
	
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
	 * 属性描述:当日订座时间
	 */
	@TableField(value="CREATE_TIME_FLAG",exist=true)
	java.lang.Integer createTimeFlag;
	
	
	
	
	
	
	public java.lang.String getId(){
		return this.id;
	}
	
	public void setId(java.lang.String id){
		this.id=id;
	}
	
	
	public java.lang.String getSeatId(){
		return this.seatId;
	}
	
	public void setSeatId(java.lang.String seatId){
		this.seatId=seatId;
	}
	
	
	public java.lang.String getSeatState(){
		return this.seatState;
	}
	
	public void setSeatState(java.lang.String seatState){
		this.seatState=seatState;
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
	
	
	public java.lang.Integer getCreateTimeFlag(){
		return this.createTimeFlag;
	}
	
	public void setCreateTimeFlag(java.lang.Integer createTimeFlag){
		this.createTimeFlag=createTimeFlag;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", seatId=").append(seatId);			
			sb.append(", seatState=").append(seatState);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", createUserId=").append(createUserId);			
			sb.append(", createUserName=").append(createUserName);			
			sb.append(", dataState=").append(dataState);			
			sb.append(", createTimeFlag=").append(createTimeFlag);			
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
        TodaySeatDetailsInfo other = (TodaySeatDetailsInfo) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getSeatId() == null ? other.getId() == null : this.getSeatId().equals(other.getSeatId()))		
				        		&&(this.getSeatState() == null ? other.getId() == null : this.getSeatState().equals(other.getSeatState()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getCreateUserId() == null ? other.getId() == null : this.getCreateUserId().equals(other.getCreateUserId()))		
				        		&&(this.getCreateUserName() == null ? other.getId() == null : this.getCreateUserName().equals(other.getCreateUserName()))		
				        		&&(this.getDataState() == null ? other.getId() == null : this.getDataState().equals(other.getDataState()))		
				        		&&(this.getCreateTimeFlag() == null ? other.getId() == null : this.getCreateTimeFlag().equals(other.getCreateTimeFlag()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getSeatId() == null) ? 0 : getSeatId().hashCode());		
		        result = prime * result + ((getSeatState() == null) ? 0 : getSeatState().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());		
		        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());		
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());		
		        result = prime * result + ((getCreateTimeFlag() == null) ? 0 : getCreateTimeFlag().hashCode());		
		;
        return result;
    }

}
