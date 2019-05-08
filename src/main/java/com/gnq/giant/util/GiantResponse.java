package com.gnq.giant.util;

import java.io.Serializable;

/**
 * @author: guonanqing
 * @desc:
 * @date:
 */
public class GiantResponse<T> implements Serializable{
    private Integer code;
    private String msg;
    private T result;
    private Boolean success;

    public GiantResponse(){

    }

    public GiantResponse<T> result(T result){
        this.result = result;
        return this;
    }

    public GiantResponse<T> msg(String msg ){
        this.msg = msg;
        return this;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
