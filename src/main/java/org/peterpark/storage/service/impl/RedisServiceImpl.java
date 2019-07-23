package org.peterpark.storage.service.impl;

import io.swagger.annotations.*;
import org.peterpark.storage.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author: ouzo
 * @date: 2018/8/15.
 */

@Api(value = "镜像管理接口类", description = "用户请求镜像信息")
@Service
public class RedisServiceImpl implements RedisService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisServiceImpl.class);

    private final RedisTemplate redisTemplate;

    @Autowired
    public RedisServiceImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * @param key 键
     * @return value
     */

    @POST
    @Path("/createWithList")
    @ApiOperation(value = "docker pull请求拦截接口", notes = "根据nginx转发请求，并记录", produces = "application/json")
    @ApiImplicitParam(name = "imei", value = "IMEI码", required = true, dataType = "String", paramType = "query", defaultValue = "1234555SHA")
    @Override
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * set value
     *
     * @param key   键
     * @param value 值
     * @return 是否成功
     */

    @ApiOperation(value = "docker record", notes = "查询docker拉取记录", produces = "application/json")
    @ApiImplicitParam(name = "id", value = "docker id", required = true, dataType = "String", paramType = "Long", defaultValue = "1")
    @Override
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            LOGGER.error("set error: key {}, value {}", key, value, e);
        }
        return result;
    }

    /**
     * set value with expireTime
     *
     * @param key        键
     * @param value      值
     * @param expireTime 过期时间
     * @return 是否成功
     */
    @Override
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            LOGGER.error("set error: key {}, value {},expireTime {}", key, value, expireTime, e);
        }
        return result;
    }

    /**
     * @param key 键
     * @return 是否存在键
     */
    @Override
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * remove single key
     *
     * @param key 键
     */
    @Override
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * batch delete
     *
     * @param keys 多个键
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * batch delete with pattern
     *
     * @param pattern 模式
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0) {
            redisTemplate.delete(keys);
        }
    }

    /**
     * hash set
     *
     * @param key 键
     * @param hashKey 哈希键
     * @param value 值
     */
    public void hashSet(String key, Object hashKey, Object value) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key, hashKey, value);
    }

    /**
     * hash get
     *
     * @param key 键
     * @param hashKey 哈希键
     * @return hashKey
     */
    public Object hashGet(String key, Object hashKey) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    /**
     * list push
     *
     * @param k
     * @param v
     */
    public void push(String k, Object v) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k, v);
    }

    /**
     * list range
     *
     * @param k
     * @param l
     * @param l1
     * @return
     */
    public List<Object> range(String k, long l, long l1) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k, l, l1);
    }

    /**
     * set add
     *
     * @param key
     * @param value
     */
    public void setAdd(String key, Object value) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key, value);
    }

    /**
     * set get
     *
     * @param key
     * @return
     */
    public Set<Object> setMembers(String key) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    /**
     * ordered set add
     *
     * @param key
     * @param value
     * @param scoure
     */
    public void zAdd(String key, Object value, double scoure) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add(key, value, scoure);
    }

    /**
     * rangeByScore
     *
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    public Set<Object> rangeByScore(String key, double scoure, double scoure1) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }

}
