package com.edgedo.sys.queryvo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.edgedo.sys.entity.UserMoney;

public class UserMoneyView extends UserMoney {

    /**
     * 属性描述:真实姓名
     */
    java.lang.String userName;

    /**
     * 属性描述:性别
     */
    java.lang.String userSex;

    /**
     * 属性描述:年龄
     */
    java.lang.String userAge;

    /**
     * 属性描述:手机号
     */
    java.lang.String userTel;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }
}
