package org.storage.demo.exception;

import org.storage.demo.constant.Catalog;

/**
 * Description:
 *
 * @author: peter
 * @date: 2018/8/16.
 */
public class RedisException extends StorageException {
    private static final long serialVersionUID = -6175667331760278157L;

    /**
     * @param code       服务端内部异常码
     * @param catalog    存储服务类目
     * @param message    服务端内部消息
     * @param appCode    给app端的异常码
     * @param appMessage 给app端展示的消息文案
     */
    public RedisException(int code, Catalog catalog, String message, int appCode, String appMessage) {
        super(code, catalog, message, appCode, appMessage);
    }

    /**
     * @param code       服务端异常码
     * @param catalog    存储服务类目
     * @param exception  异常
     * @param appCode    给app端的异常码
     * @param appMessage 给app端展示的消息文案
     */
    public RedisException(int code, Catalog catalog, Throwable exception, int appCode, String appMessage) {
        super(code, catalog, exception, appCode, appMessage);
    }

    public RedisException(int code, String message, Catalog catalog, Throwable exception, int appCode, String appMessage) {
        super(code, message, catalog, exception, appCode, appMessage);
    }

    public RedisException(String message) {
        this(ExceptionCode.COMMON_ERROR_CODE, message, DEFAULT_APP_CODE, DEFAULT_APP_MESSAGE);
    }

    public RedisException(int code, String message) {
        this(code, message, DEFAULT_APP_CODE, DEFAULT_APP_MESSAGE);
    }

    public RedisException(int code, String message, int appCode, String appMessage) {
        super(code == 0 ? 1 : code, Catalog.REDIS, message, appCode, appMessage);
    }

    public RedisException(ExceptionCode code) {
        this(code.getCode(), code.getMsg(), code.getAppCode(), code.getAppMessage());
    }

    public RedisException(int code, String message, int appCode, String appMessage, Throwable cause) {
        super(code == 0 ? 1 : code, Catalog.REDIS, new Exception(message, cause), appCode, appMessage);
    }

    public RedisException(ExceptionCode code, Throwable cause) {
        this(code.getCode(), code.getMsg(), code.getAppCode(), code.getAppMessage(), cause);
    }

    public RedisException(ExceptionCode code, String message) {
        this(code.getCode(), code.getMsg(), code.getAppCode(), message);
    }
}
