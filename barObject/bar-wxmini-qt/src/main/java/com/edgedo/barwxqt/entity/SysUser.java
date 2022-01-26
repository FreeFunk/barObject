package com.edgedo.barwxqt.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName("sys_user")
public class SysUser implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;

	/**
	 * 属性描述:用户账号
	 */
	@TableField(value="USER_ACCOUNT",exist=true)
	String userAccount;

	/**
	 * 属性描述:密码
	 */
	@TableField(value="USER_PASSWORD",exist=true)
	String userPassword;

	/**
	 * 属性描述:真实姓名
	 */
	@TableField(value="USER_NAME",exist=true)
	String userName;

	/**
	 * 属性描述:手机号
	 */
	@TableField(value="USER_TEL",exist=true)
	String userTel;

	/**
	 * 属性描述:年龄
	 */
	@TableField(value="USER_AGE",exist=true)
	String userAge;

	/**
	 * 属性描述:性别
	 */
	@TableField(value="USER_SEX",exist=true)
	String userSex;

	/**
	 * 属性描述:头像
	 */
	@TableField(value="USER_HEAD",exist=true)
	String userHead;

	/**
	 * 属性描述:角色ID
	 */
	@TableField(value="USER_ROLE_ID",exist=true)
	String userRoleId;

	/**
	 * 属性描述:角色名
	 */
	@TableField(value="USER_ROLE_NAME",exist=true)
	String userRoleName;

	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	Date createTime;

	/**
	 * 属性描述:创建人ID
	 */
	@TableField(value="CREATE_USER_ID",exist=true)
	String createUserId;

	/**
	 * 属性描述:创建人名
	 */
	@TableField(value="CREATE_USER_NAME",exist=true)
	String createUserName;

	/**
	 * 属性描述:数据状态
	 */
	@TableField(value="DATA_STATE",exist=true)
	String dataState;

	/**
	 * 属性描述:微信用户openId
	 */
	@TableField(value = "OPEN_ID",exist = true)
	String openId;

	/**
	 * 属性描述:微信用户城市
	 */
	@TableField(value = "CITY",exist = true)
	String city;

	/**
	 * 属性描述:微信用户省份
	 */
	@TableField(value = "PROVINCE",exist = true)
	String province;

	/**
	 * 属性描述:微信用户省份
	 */
	@TableField(value = "COUNTRY",exist = true)
	String country;

	/**
	 * 属性描述:微信用户语言
	 */
	@TableField(value = "LANGUAGE",exist = true)
	String language;

	/**
	 * 属性描述:微信用户上次登陆时间
	 */
	@TableField(value = "LAST_LOGIN_TIME",exist = true)
	Date lastLoginTime;

	/**
	 * 属性描述:微信用户session值
	 */
	@TableField(value = "LAST_SESSION_KEY",exist = true)
	String lastSessionKey;

	/**
	 * 属性描述:是否授权
	 */
	@TableField(value="IS_POWER",exist=true)
	String isPower;

	public String getIsPower() {
		return isPower;
	}

	public void setIsPower(String isPower) {
		this.isPower = isPower;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastSessionKey() {
		return lastSessionKey;
	}

	public void setLastSessionKey(String lastSessionKey) {
		this.lastSessionKey = lastSessionKey;
	}

	public String getId(){
		return this.id;
	}

	public void setId(String id){
		this.id=id;
	}


	public String getUserAccount(){
		return this.userAccount;
	}

	public void setUserAccount(String userAccount){
		this.userAccount=userAccount;
	}


	public String getUserPassword(){
		return this.userPassword;
	}

	public void setUserPassword(String userPassword){
		this.userPassword=userPassword;
	}


	public String getUserName(){
		return this.userName;
	}

	public void setUserName(String userName){
		this.userName=userName;
	}


	public String getUserTel(){
		return this.userTel;
	}

	public void setUserTel(String userTel){
		this.userTel=userTel;
	}


	public String getUserAge(){
		return this.userAge;
	}

	public void setUserAge(String userAge){
		this.userAge=userAge;
	}


	public String getUserSex(){
		return this.userSex;
	}

	public void setUserSex(String userSex){
		this.userSex=userSex;
	}


	public String getUserHead(){
		return this.userHead;
	}

	public void setUserHead(String userHead){
		this.userHead=userHead;
	}


	public String getUserRoleId(){
		return this.userRoleId;
	}

	public void setUserRoleId(String userRoleId){
		this.userRoleId=userRoleId;
	}


	public String getUserRoleName(){
		return this.userRoleName;
	}

	public void setUserRoleName(String userRoleName){
		this.userRoleName=userRoleName;
	}


	public Date getCreateTime(){
		return this.createTime;
	}

	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}


	public String getCreateUserId(){
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId){
		this.createUserId=createUserId;
	}


	public String getCreateUserName(){
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName){
		this.createUserName=createUserName;
	}


	public String getDataState(){
		return this.dataState;
	}

	public void setDataState(String dataState){
		this.dataState=dataState;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", userAccount=").append(userAccount);			
			sb.append(", userPassword=").append(userPassword);			
			sb.append(", userName=").append(userName);			
			sb.append(", userTel=").append(userTel);			
			sb.append(", userAge=").append(userAge);			
			sb.append(", userSex=").append(userSex);			
			sb.append(", userHead=").append(userHead);			
			sb.append(", userRoleId=").append(userRoleId);			
			sb.append(", userRoleName=").append(userRoleName);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", createUserId=").append(createUserId);			
			sb.append(", createUserName=").append(createUserName);			
			sb.append(", dataState=").append(dataState);			
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
        SysUser other = (SysUser) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getUserAccount() == null ? other.getId() == null : this.getUserAccount().equals(other.getUserAccount()))		
				        		&&(this.getUserPassword() == null ? other.getId() == null : this.getUserPassword().equals(other.getUserPassword()))		
				        		&&(this.getUserName() == null ? other.getId() == null : this.getUserName().equals(other.getUserName()))		
				        		&&(this.getUserTel() == null ? other.getId() == null : this.getUserTel().equals(other.getUserTel()))		
				        		&&(this.getUserAge() == null ? other.getId() == null : this.getUserAge().equals(other.getUserAge()))		
				        		&&(this.getUserSex() == null ? other.getId() == null : this.getUserSex().equals(other.getUserSex()))		
				        		&&(this.getUserHead() == null ? other.getId() == null : this.getUserHead().equals(other.getUserHead()))		
				        		&&(this.getUserRoleId() == null ? other.getId() == null : this.getUserRoleId().equals(other.getUserRoleId()))		
				        		&&(this.getUserRoleName() == null ? other.getId() == null : this.getUserRoleName().equals(other.getUserRoleName()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getCreateUserId() == null ? other.getId() == null : this.getCreateUserId().equals(other.getCreateUserId()))		
				        		&&(this.getCreateUserName() == null ? other.getId() == null : this.getCreateUserName().equals(other.getCreateUserName()))		
				        		&&(this.getDataState() == null ? other.getId() == null : this.getDataState().equals(other.getDataState()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getUserAccount() == null) ? 0 : getUserAccount().hashCode());		
		        result = prime * result + ((getUserPassword() == null) ? 0 : getUserPassword().hashCode());		
		        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());		
		        result = prime * result + ((getUserTel() == null) ? 0 : getUserTel().hashCode());		
		        result = prime * result + ((getUserAge() == null) ? 0 : getUserAge().hashCode());		
		        result = prime * result + ((getUserSex() == null) ? 0 : getUserSex().hashCode());		
		        result = prime * result + ((getUserHead() == null) ? 0 : getUserHead().hashCode());		
		        result = prime * result + ((getUserRoleId() == null) ? 0 : getUserRoleId().hashCode());		
		        result = prime * result + ((getUserRoleName() == null) ? 0 : getUserRoleName().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());		
		        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());		
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());		
		;
        return result;
    }

}
