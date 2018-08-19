package org.storage.demo.controller;

import org.storage.demo.constant.request.SetRequest;

/**
 * Description:
 *
 * @author: ouzo
 * @date: 2018/8/15.
 */
public interface StorageController {

    /**
     * 存储web服务——get
     *
     * @param key 键 String
     * @exception Exception 键异常
     * @return value
     */
    Object get(String key) throws Exception;

    /**
     * 存储web服务——set
     *
     * @param setRequest 添加操作请求 key value expireTime
     * @exception Exception 键异常
     * @return isSet
     */
    boolean set(SetRequest setRequest) throws Exception;

    /**
     * 存储web服务——exists
     *
     * @param key 键 String
     * @exception Exception 键异常
     * @return exist
     */
    boolean exists(String key) throws Exception;

    /**
     * 存储web服务——remove
     *
     * @param key 键 String
     * @exception Exception 键异常
     */
    void remove(String key) throws Exception;
}
