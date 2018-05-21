package com.tiye.IntelligentClass.common;

/**
 * 接口返回类
 */
public class APIResult<T> {
    private String msg;//消息描述
    private int code;//返回值
    private long count;//总数 分页用到
    protected T data;//数据

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public String getMsg() {
        return msg;
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }


    public void setCode(int code) {
        this.code = code;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public static <U> APIResult<U> result(int code, String message, int count, U data) {
        APIResult<U> apiResult = new APIResult<U>();
        apiResult.setCode(code);
        apiResult.setMsg(message);
        apiResult.setData(data);
        apiResult.setCount(count);
        return apiResult;
    }
    public static <U> APIResult<U> resultHtException() {
        APIResult<U> apiResult = new APIResult<U>();
        apiResult.setCode(1);
        apiResult.setMsg("后台异常");
        apiResult.setData(null);
        apiResult.setCount(0);
        return apiResult;
    }
}





