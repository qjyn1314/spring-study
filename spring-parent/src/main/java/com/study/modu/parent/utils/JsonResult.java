package com.study.modu.parent.utils;

/**
 * <p>
 * Explain:结果返回对象
 * </p >
 *
 * @author wangjunming
 * @since 2020-01-02 13:45
 */
public class JsonResult<T> {

    private String msg;

    private T obj;

    private boolean flag;

    public static <T> JsonResult<T> success(T obj) {
        return new JsonResult<T>(obj);
    }

    private JsonResult(T obj) {
        this.obj = obj;
    }

    private JsonResult() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
