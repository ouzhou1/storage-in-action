package org.storage.demo.service;

/**
 * Description:
 *
 * @author: ouzo
 * @date: 2018/8/15.
 */
public interface RedisService extends StorageService {
    /**
     * set value with expireTime
     *
     * @param key        键
     * @param value      值
     * @param expireTime 过期时间
     * @return 是否成功
     */
    boolean set(final String key, Object value, Long expireTime);
}
