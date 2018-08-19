package org.storage.demo.exception;

import org.storage.demo.constant.Catalog;

/**
 * Description:
 *
 * @author: peter
 * @date: 2018/8/16.
 */
public class StorageException extends Exception {

    private static final long serialVersionUID = -6090556264930206833L;

    public static final int DEFAULT_APP_CODE = 10001;

    public static final String DEFAULT_APP_MESSAGE = "当前网络不可用，请稍后重试";

    private final int code;

    private final int catalog;

    private final int appCode;

    private final String appMessage;

    private final String internalMessage;

    /**
     * @param code 服务端内部异常码
     * @param catalog 存储服务类目
     * @param message 服务端内部消息
     * @param appCode 给app端的异常码
     * @param appMessage 给app端展示的消息文案
     */
    public StorageException(int code, Catalog catalog, String message, int appCode, String appMessage) {
        super(message);
        this.code = code;
        this.catalog = (catalog != null ? catalog.getValue() : Catalog.DEFAULT.getValue());
        this.appCode = appCode;
        this.appMessage = appMessage;
        this.internalMessage = message;
    }

    /**
     * @param code 服务端异常码
     * @param catalog 存储服务类目
     * @param exception 异常
     * @param appCode 给app端的异常码
     * @param appMessage 给app端展示的消息文案
     */
    public StorageException(int code, Catalog catalog, Throwable exception, int appCode, String appMessage) {
        super(exception);
        this.code = code;
        this.catalog = (catalog != null ? catalog.getValue() : Catalog.DEFAULT.getValue());
        this.appCode = appCode;
        this.appMessage = appMessage;
        this.internalMessage = exception.getMessage();

    }

    public StorageException(int code, String message, Catalog catalog, Throwable exception, int appCode, String appMessage) {
        super(message, exception);
        this.code = code;
        this.catalog = (catalog != null ? catalog.getValue() : Catalog.DEFAULT.getValue());
        this.appCode = appCode;
        this.appMessage = appMessage;
        this.internalMessage = message;
    }

    public int getCode() {
        return code;
    }

    public int getCatalog() {
        return catalog;
    }

    public int getAppCode() {
        return appCode;
    }

    public String getAppMessage() {
        return appMessage;
    }

    public String getInternalMessage() {
        return internalMessage;
    }
}
