package com.yeelee.TD.utils;

/**
 * @ Author     ：liye
 * @ Date       ：Created in 14:25 2019/8/10
 * @ Description：返回的对象封装类
 * @ Modified By：liye
 * @Version: V1.0
 */
public class ResponseObj<T> {
    private static final int SUCCESS = 200;
    private static final int FAIL = 400;
    private static final int UNAUTHORIZED = 401;
    private static final int NOTFOUND = 404;
    private static final int SERVERERROR = 500;


    private int code;
    private String msg;
    private T data;

    public ResponseObj(){

    }

    public ResponseObj(int code){
        this.code = code;
    }

    public ResponseObj(int code, T data){
        this.code = code;
        this.data = data;
    }

    public ResponseObj(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResponseObj(int code, String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseObj ok(){
        return new ResponseObj(SUCCESS);
    }

    public static ResponseObj ok(String msg){
        return new ResponseObj(SUCCESS,msg);
    }

    public static ResponseObj ok(Object data){
        return new ResponseObj(SUCCESS,data);
    }

    public static ResponseObj ok(String msg,Object data){
        return new ResponseObj(SUCCESS,msg,data);
    }

    public static ResponseObj fail(){
        return new ResponseObj(FAIL);
    }

    public static ResponseObj fail(Object data){
        return new ResponseObj(FAIL,data);
    }

    public static ResponseObj fail(String msg){
        return new ResponseObj(FAIL,msg);
    }

    public static ResponseObj fail(String msg,Object data){
        return new ResponseObj(FAIL,msg,data);
    }

    // 未授权
    public static ResponseObj unauthorized(){
        return new ResponseObj(UNAUTHORIZED);
    }

    public static ResponseObj unauthorized(String msg){
        return new ResponseObj(UNAUTHORIZED,msg);
    }

    // 资源不存在
    public static ResponseObj notfound(){
        return new ResponseObj(NOTFOUND);
    }

    // 服务异常
    public static ResponseObj servererror(){
        return new ResponseObj(SERVERERROR);
    }

    public static ResponseObj servererror(String msg){
        return new ResponseObj(SERVERERROR,msg);
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
