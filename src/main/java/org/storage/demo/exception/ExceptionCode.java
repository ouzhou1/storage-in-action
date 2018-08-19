package org.storage.demo.exception;

/**
 * Description: 异常码定义类
 *
 * @author: peter
 * @date: 2018/8/16.
 */
public class ExceptionCode {

    public static final int COMMON_ERROR_CODE = 700;
    public static final ExceptionCode COMMON_EXCEPTION_ERROR = new ExceptionCode(701, "处理错误，请稍后再试", 81995, "处理错误，请稍后再试");
    public static final ExceptionCode SYSTEM_ERROR = new ExceptionCode(702, "系统错误", 81996, "处理错误，请稍后再试");
    public static final ExceptionCode ARGS_TYPE_MISMATCH = new ExceptionCode(703, "参数不正确", 61991, "输入有误，请检查格式");
    public static final ExceptionCode MQ_SEND_ERROR = new ExceptionCode(704, "MQ消息发送失败", 61990, "系统异常，请稍后再试");
    public static final ExceptionCode KEY_ERROR = new ExceptionCode(705, "键错误", 123, "输入有误，请检查格式");
    /**
     * 异常码
     */
    private final int code;

    /**
     * 异常信息
     */
    private final String msg;

    private final int appCode;

    private String appMessage;

    public ExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.appCode = StorageException.DEFAULT_APP_CODE;
        this.appMessage = StorageException.DEFAULT_APP_MESSAGE;
    }

    public ExceptionCode(int code, String msg, int appCode, String appMessage) {
        this.code = code;
        this.msg = msg;
        this.appCode = appCode;
        this.appMessage = appMessage;
    }

    public int getAppCode() {
        return appCode;
    }

    public String getAppMessage() {
        return appMessage;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setAppMsg(String message) {
        this.appMessage = message;
    }
}
