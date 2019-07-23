package org.peterpark.storage.controller;

import org.peterpark.storage.exception.ExceptionCode;
import org.peterpark.storage.exception.RedisException;
import org.peterpark.storage.service.MongoService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.peterpark.storage.constant.request.SetRequest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description:
 *
 * @author: peter
 * @date: 2018/8/16.
 */

@RestController("mongo")
@RequestMapping(value = "/storage/mongo")
public class MongoController implements StorageController {

    private final MongoService mongoService;

    @Autowired
    public MongoController(MongoService mongoService) {
        this.mongoService = mongoService;
    }

    /**
     * 存储web服务——get
     *
     * @param key 键 String
     * @return value
     * @throws Exception 键异常
     */
    @GetMapping(value = "/get")
    @Override
    public Object get(@Param(value = "key") String key) throws Exception {
        if (key == null) {
            throw new RedisException(ExceptionCode.EMPTY_KEY);
        }
        return mongoService.get(key);
    }

    /**
     * 存储web服务——set
     *
     * @param setRequest 添加操作请求 key value expireTime
     * @return isSet
     * @throws Exception 键异常
     */
    @PostMapping(value = "/set")
    @Override
    public boolean set(@ModelAttribute SetRequest setRequest) throws Exception {
        String key = setRequest.getKey();
        Object value = setRequest.getValue();
        return mongoService.set(key, value);
    }

    /**
     * 存储web服务——exists
     *
     * @param key 键 String
     * @return exist
     * @throws Exception 键异常
     */
    @GetMapping(value = "/exist")
    @Override
    public boolean exists(@Param(value = "key") String key) throws Exception {
        if (key == null) {
            throw new RedisException(ExceptionCode.KEY_ERROR);
        }
        return mongoService.exists(key);
    }

    /**
     * 存储web服务——remove
     *
     * @param key 键 String
     * @throws Exception 键异常
     */
    @DeleteMapping(value = "/remove")
    @Override
    public void remove(@Param(value = "key") String key) throws Exception {
        mongoService.remove(key);
    }

}
