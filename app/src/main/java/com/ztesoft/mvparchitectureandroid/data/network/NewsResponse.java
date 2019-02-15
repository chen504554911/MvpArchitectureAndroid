package com.ztesoft.mvparchitectureandroid.data.network;

import java.io.Serializable;

/**
 * @author chenyx
 * @date create 2017/7/24
 * @description
 */
public class NewsResponse<T> implements Serializable {


    public int error_code;
    public String reason;
    public T result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "NewsResponse{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}
