package com.edgedo.eunm;

public enum OrderEunm {
    /**
     * 全部订单
     */
    allOder(""),
    /**
     * 未完成订单
     */
    notOrder("0"),
    /**
     * 已完成订单
     */
    complete("1"),
    /**
     * 失败订单
     */
    fail("-1");

    private final String type;

    OrderEunm(String type) {

        this.type = type;
    }
    public String getType() {
        return type;
    }

}


