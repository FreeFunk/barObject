package com.edgedo.barwxqt.queryvo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.edgedo.barwxqt.entity.OrderDetailsInfo;

public class OrderDetailsInfoView extends OrderDetailsInfo {

    /**
     * 属性描述:是否退单
     */
    java.lang.String orderState;


    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }
}
