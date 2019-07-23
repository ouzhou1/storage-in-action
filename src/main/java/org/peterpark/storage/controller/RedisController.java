package org.peterpark.storage.controller;

import org.peterpark.storage.exception.ExceptionCode;
import org.peterpark.storage.exception.RedisException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.peterpark.storage.constant.request.SetRequest;
import org.peterpark.storage.service.RedisService;

/**
 * Description: Redis Web Service
 *
 * @author: ouzo
 * @date: 2018/8/15.
 */
@RestController("redis")
@RequestMapping(value = "/storage/redis")
public class RedisController implements StorageController {

    private final RedisService redisService;

    @Autowired
    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping(value = "/get")
    @Override
    public Object get(@RequestHeader(name="key", defaultValue = "test")  @Param("key") String key) throws RedisException {
        if (key == null) {
            throw new RedisException(ExceptionCode.EMPTY_KEY);
        }
        return redisService.get(key);
    }

    /**
     * 存储web服务——set
     *
     * @param setRequest 添加操作请求 key value expireTime
     * @return isSet
     */
    @PostMapping(value = "/set")
    @Override
    public boolean set(@RequestBody SetRequest setRequest) throws RedisException {
        Long expireTime = setRequest.getExpireTime();
        String key = setRequest.getKey();
        if (key == null) {
            throw new RedisException(ExceptionCode.KEY_ERROR);
        }
        Object value = setRequest.getValue();
        return (expireTime == null || expireTime == 0) ? redisService.set(key, value) : redisService.set(key, value, expireTime);
    }

    /**
     * 存储web服务——exists
     *
     * @param key 键 String
     * @return exist
     */
    @GetMapping(value = "/exist")
    @Override
    public boolean exists(@Param("key") String key) throws RedisException {
        if (key == null) {
            throw new RedisException(ExceptionCode.KEY_ERROR);
        }
        return redisService.exists(key);
    }

    /**
     * 存储web服务——remove
     *
     * @param key 键 String
     */
    @DeleteMapping(value = "/remove")
    @Override
    public void remove(@Param("key") String key) throws RedisException {
        if (key == null) {
            throw new RedisException(ExceptionCode.KEY_ERROR);
        }
        redisService.remove(key);
    }

}
