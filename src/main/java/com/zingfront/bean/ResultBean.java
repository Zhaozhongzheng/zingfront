package com.zingfront.bean;

public class ResultBean {

    public static final int SUCCESS = 0;
    public static final int FAIL = 1;
    public static final int ERROR = 9;

    private String msg;
    private int status;
    private Object data;

    public ResultBean(){};
    public ResultBean(Object data){
        this.status = SUCCESS;
        this.data = data;
    }
    public ResultBean(int status,String msg,Object data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
