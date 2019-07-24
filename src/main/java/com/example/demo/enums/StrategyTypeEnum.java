package com.example.demo.enums;

/**
 * @Author: smart lihao
 * @Date: 2019/6/12 15:38
 */
public enum  StrategyTypeEnum {

    INSTANT(1, "即时订单"),
    BOOKING(2, "预约订单"),
    CARPOOL(3, "拼车订单");

    private int code;
    private String desc;

    StrategyTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 根据value返回枚举类型,主要在switch中使用
     */
    public static StrategyTypeEnum getByCode(int code) {
        for (StrategyTypeEnum strategyTypeEnum : values()) {
            if (strategyTypeEnum.getCode() == code) {
                return strategyTypeEnum;
            }
        }
        return null;
    }
}