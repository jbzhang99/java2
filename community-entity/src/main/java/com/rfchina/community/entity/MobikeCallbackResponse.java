package com.rfchina.community.entity;

import java.io.Serializable;

/**
 */
public class MobikeCallbackResponse<T> implements Serializable {

    private Integer errno;

    private String msg;

    private T data;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
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
