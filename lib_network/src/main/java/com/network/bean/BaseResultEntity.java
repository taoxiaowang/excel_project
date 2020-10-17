package com.network.bean;

import java.io.Serializable;

/**
 * author : taowang
 * date :2020/10/11
 * description:
 **/
public class BaseResultEntity<T> implements Serializable {

    public static final int STATE_SUCCESS = 200;
    public static final int STATE_FAILURE = 1;
    public static final int STATE_EXCEPTION = -1;

    //判断标示
    public int code;
    //提示信息
    public String msg;
    //显示数据（用户需要关心的数据）
    public T result;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
