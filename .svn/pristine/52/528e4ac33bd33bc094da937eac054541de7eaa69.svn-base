package com.edgedo.bar.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("order_info")
public class OrderInfo implements Serializable{
	
		
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
	 * 属性描述:出单时间
	 */
	@TableField(value="ORDER_TIME",exist=true)
	java.util.Date orderTime;
	
	/**
	 * 属性描述:是否退单
	 */
	@TableField(value="CHARGEBACK",exist=true)
	java.lang.String chargeback;
	
	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREAT_TIME",exist=true)
	java.util.Date creatTime;
	
	/**
	 * 属性描述:创建人ID
	 */
	@TableField(value="CREAT_USER_ID",exist=true)
	java.lang.String creatUserId;
	
	/**
	 * 属性描述:创建人名
	 */
	@TableField(value="CREAT_USER_NAME",exist=true)
	java.lang.String creatUserName;
	
	/**
	 * 属性描述:数据状态
	 */
	@TableField(value="DATA_STATE",exist=true)
	java.lang.String dataState;



	/**
	 * 属性描述:用户ID
	 */
	@TableField(value="USER_ID",exist=true)
	java.lang.String userId;
	
	
	
	
	
	
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
	
	
	public java.util.Date getOrderTime(){
		return this.orderTime;
	}
	
	public void setOrderTime(java.util.Date orderTime){
		this.orderTime=orderTime;
	}
	
	
	public java.lang.String getChargeback(){
		return this.chargeback;
	}
	
	public void setChargeback(java.lang.String chargeback){
		this.chargeback=chargeback;
	}
	
	
	public java.util.Date getCreatTime(){
		return this.creatTime;
	}
	
	public void setCreatTime(java.util.Date creatTime){
		this.creatTime=creatTime;
	}
	
	
	public java.lang.String getCreatUserId(){
		return this.creatUserId;
	}
	
	public void setCreatUserId(java.lang.String creatUserId){
		this.creatUserId=creatUserId;
	}
	
	
	public java.lang.String getCreatUserName(){
		return this.creatUserName;
	}
	
	public void setCreatUserName(java.lang.String creatUserName){
		this.creatUserName=creatUserName;
	}
	
	
	public java.lang.String getDataState(){
		return this.dataState;
	}
	
	public void setDataState(java.lang.String dataState){
		this.dataState=dataState;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", seatId=").append(seatId);			
			sb.append(", orderTime=").append(orderTime);			
			sb.append(", chargeback=").append(chargeback);			
			sb.append(", creatTime=").append(creatTime);			
			sb.append(", creatUserId=").append(creatUserId);			
			sb.append(", creatUserName=").append(creatUserName);			
			sb.append(", dataState=").append(dataState);
			sb.append(", userId=").append(userId);
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
        OrderInfo other = (OrderInfo) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getSeatId() == null ? other.getId() == null : this.getSeatId().equals(other.getSeatId()))		
				        		&&(this.getOrderTime() == null ? other.getId() == null : this.getOrderTime().equals(other.getOrderTime()))		
				        		&&(this.getChargeback() == null ? other.getId() == null : this.getChargeback().equals(other.getChargeback()))		
				        		&&(this.getCreatTime() == null ? other.getId() == null : this.getCreatTime().equals(other.getCreatTime()))		
				        		&&(this.getCreatUserId() == null ? other.getId() == null : this.getCreatUserId().equals(other.getCreatUserId()))		
				        		&&(this.getCreatUserName() == null ? other.getId() == null : this.getCreatUserName().equals(other.getCreatUserName()))		
				        		&&(this.getDataState() == null ? other.getId() == null : this.getDataState().equals(other.getDataState()))
								&&(this.getUserId() == null ? other.getId() == null : this.getUserId().equals(other.getUserId()))
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getSeatId() == null) ? 0 : getSeatId().hashCode());		
		        result = prime * result + ((getOrderTime() == null) ? 0 : getOrderTime().hashCode());		
		        result = prime * result + ((getChargeback() == null) ? 0 : getChargeback().hashCode());		
		        result = prime * result + ((getCreatTime() == null) ? 0 : getCreatTime().hashCode());		
		        result = prime * result + ((getCreatUserId() == null) ? 0 : getCreatUserId().hashCode());		
		        result = prime * result + ((getCreatUserName() == null) ? 0 : getCreatUserName().hashCode());		
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());
				result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
		;
        return result;
    }

}
