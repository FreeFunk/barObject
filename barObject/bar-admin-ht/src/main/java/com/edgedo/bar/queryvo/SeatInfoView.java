package com.edgedo.bar.queryvo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.edgedo.bar.entity.SeatInfo;

import java.math.BigDecimal;

public class SeatInfoView extends SeatInfo {

    /**
     * 属性描述:套餐名
     */
    java.lang.String setMealName;



    /**
     * 属性描述:套餐价格
     */
    java.math.BigDecimal setMealPrice;


    public String getSetMealName() {
        return setMealName;
    }

    public void setSetMealName(String setMealName) {
        this.setMealName = setMealName;
    }
    public BigDecimal getSetMealPrice() {
        return setMealPrice;
    }

    public void setSetMealPrice(BigDecimal setMealPrice) {
        this.setMealPrice = setMealPrice;
    }
}
