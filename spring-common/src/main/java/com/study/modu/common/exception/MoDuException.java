package com.study.modu.common.exception;

/**
 * <p>
 * Explain:工程中的异常类
 * </p >
 *
 * @author wangjunming
 * @since 2019-12-30 15:25
 */
public class MoDuException extends RuntimeException {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private MoDuException() {
        super();
    }

    private MoDuException(String message) {
        super(message);
        this.msg = message;
    }

    public static void build(String msg){
        throw new MoDuException(msg);
    }

}
