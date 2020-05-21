package com.example.demo.result;

public class ResultData<T> {
    private int code;
    private String msg;
    private T  data;

    /**
     * 成功时调用
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultData<T> success(T data){
        return new ResultData<T>(data);
    }
    /**
     * 失败时调用
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultData<T> error(T data){
        return new ResultData<T>(data);
    }
    public ResultData(T data){
        this.data = data;
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
