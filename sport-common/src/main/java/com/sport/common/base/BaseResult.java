package com.sport.common.base;

/**
 * Created by wzm on 2016/7/20.
 */
public class BaseResult<T> {
    private int code;
    private String msg;
    private T data;

    public BaseResult successCode(T data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
        return this;
    }

    public BaseResult dataErrorCode() {
        this.code = 501;
        this.msg = "data error";
        return this;
    }

    public BaseResult serverErrorCode() {
        this.code = 500;
        this.msg = "server error";
        return this;
    }

    public BaseResult clientErrorCode() {
        this.code = 400;
        this.msg = "client error";
        return this;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
