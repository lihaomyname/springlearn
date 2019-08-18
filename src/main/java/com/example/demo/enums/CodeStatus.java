package com.example.demo.enums;

/**
 * @Author: smart lihao
 * @Date: 2019/4/3 10:38
 */
public enum CodeStatus {
    /***/
    CODE_SUCCESS(200,"操作成功"),
    CODE_NO_LOGIN(201,"用户未登陆"),
    CODE_NOT_NOW_TYPE(205,"本活动只支持新用户"),
    CODE_NOT_SUPPORT_TYPE(206,"不支持的用户类型"),
    CODE_NLP_SET_DUPLICATE(207,"设置重复"),
    CODE_LOGIN_OUT_ERROR(208,"登出失败"),
    CODE_INT_ERROR(202,"网络不好，提交失败，请您稍后再试。");
    CodeStatus(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }


    private Integer code;

    private String msg;

    public Integer getState() {
        return code;
    }

    public void setState(Integer state) {
        this.code = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
