package com.edgedo.sys.queryvo;

import com.edgedo.sys.entity.SysUser;

import java.math.BigDecimal;

public class SysUserView extends SysUser {
    java.math.BigDecimal userMoney;
    String userCurrViewType;

    public String getUserCurrViewType() {
        return userCurrViewType;
    }

    public void setUserCurrViewType(String userCurrViewType) {
        this.userCurrViewType = userCurrViewType;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }
}
