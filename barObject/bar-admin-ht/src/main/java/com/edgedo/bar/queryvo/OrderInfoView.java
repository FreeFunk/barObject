package com.edgedo.bar.queryvo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.edgedo.bar.entity.OrderInfo;

import java.math.BigDecimal;

public class OrderInfoView extends OrderInfo {
    /**
     * 属性描述:用户姓名
     */
    java.lang.String userName;

    /**
     * 属性描述:用户手机号
     */
    java.lang.String userTel;
    /**
     * 属性描述:座位号
     */
    java.lang.String seatNo;
    /**
     * 属性描述:共计消费
     */
    java.math.BigDecimal totalConsume;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public BigDecimal getTotalConsume() {
        return totalConsume;
    }

    public void setTotalConsume(BigDecimal totalConsume) {
        this.totalConsume = totalConsume;
    }




}
