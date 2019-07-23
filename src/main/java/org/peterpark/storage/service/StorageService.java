package org.peterpark.storage.service;

/**
 * Description:
 *
 * @author: ouzo
 * @date: 2018/8/15.
 */
public interface StorageService {

    /**
     * @param key 键
     * @return value
     */
    Object get(final String key);

    /**
     * set value
     *
     * @param key   键
     * @param value 值
     * @return 是否成功
     */
    boolean set(final String key, Object value);

    /**
     * @param key 键
     * @return 是否存在键
     */
    boolean exists(final String key);

    /**
     * remove single key
     *
     * @param key 键
     */
    void remove(final String key);
}
