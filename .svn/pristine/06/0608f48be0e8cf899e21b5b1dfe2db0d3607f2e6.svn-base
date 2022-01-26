package com.edgedo.bar.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("cons_info")
public class ConsInfo implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	java.lang.String id;
	
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
	 * 属性描述:套餐名
	 */
	@TableField(value="SET_MEAL_NAME",exist=true)
	java.lang.String setMealName;
	
	/**
	 * 属性描述:套餐详情
	 */
	@TableField(value="SET_MEAL_DESC",exist=true)
	java.lang.String setMealDesc;

	/**
	 * 属性描述:套餐价格
	 */
	@TableField(value="SET_MEAL_PRICE",exist=true)
	java.math.BigDecimal setMealPrice;

	/**
	 * 属性描述:数据状态
	 */
	@TableField(value="DATA_STATE",exist=true)
	java.lang.String dataState;
	
	
	
	
	
	
	public java.lang.String getId(){
		return this.id;
	}
	
	public void setId(java.lang.String id){
		this.id=id;
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

	public java.lang.String getSetMealName(){
		return this.setMealName;
	}
	
	public void setSetMealName(java.lang.String setMealName){
		this.setMealName=setMealName;
	}
	
	
	public java.lang.String getSetMealDesc(){
		return this.setMealDesc;
	}
	
	public void setSetMealDesc(java.lang.String setMealDesc){
		this.setMealDesc=setMealDesc;
	}
	
	
	public java.lang.String getDataState(){
		return this.dataState;
	}
	
	public void setDataState(java.lang.String dataState){
		this.dataState=dataState;
	}


	public BigDecimal getSetMealPrice() {
		return setMealPrice;
	}

	public void setSetMealPrice(BigDecimal setMealPrice) {
		this.setMealPrice = setMealPrice;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", createUserId=").append(createUserId);			
			sb.append(", createUserName=").append(createUserName);
			sb.append(", setMealName=").append(setMealName);			
			sb.append(", setMealDesc=").append(setMealDesc);			
			sb.append(", dataState=").append(dataState);
			sb.append(", setMealPrice=").append(setMealPrice);
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
        ConsInfo other = (ConsInfo) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getCreateUserId() == null ? other.getId() == null : this.getCreateUserId().equals(other.getCreateUserId()))		
				        		&&(this.getCreateUserName() == null ? other.getId() == null : this.getCreateUserName().equals(other.getCreateUserName()))
				        		&&(this.getSetMealName() == null ? other.getId() == null : this.getSetMealName().equals(other.getSetMealName()))		
				        		&&(this.getSetMealDesc() == null ? other.getId() == null : this.getSetMealDesc().equals(other.getSetMealDesc()))		
				        		&&(this.getDataState() == null ? other.getId() == null : this.getDataState().equals(other.getDataState()))
								&&(this.getSetMealPrice() == null ? other.getId() == null : this.getSetMealPrice().equals(other.getSetMealPrice()))

				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());		
		        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());
		        result = prime * result + ((getSetMealName() == null) ? 0 : getSetMealName().hashCode());		
		        result = prime * result + ((getSetMealDesc() == null) ? 0 : getSetMealDesc().hashCode());		
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());
		result = prime * result + ((getSetMealPrice() == null) ? 0 : getSetMealPrice().hashCode());
		;
        return result;
    }

}
