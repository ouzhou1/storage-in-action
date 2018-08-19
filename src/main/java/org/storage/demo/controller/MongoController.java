package org.storage.demo.controller;

import org.storage.demo.constant.request.SetRequest;
import org.storage.demo.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @Override
    public Object get(String key) throws Exception {
        return mongoService.get(key);
    }

    /**
     * 存储web服务——set
     *
     * @param setRequest 添加操作请求 key value expireTime
     * @return isSet
     * @throws Exception 键异常
     */
    @Override
    public boolean set(SetRequest setRequest) throws Exception {
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
    @Override
    public boolean exists(String key) throws Exception {
        return mongoService.exists(key);
    }

    /**
     * 存储web服务——remove
     *
     * @param key 键 String
     * @throws Exception 键异常
     */
    @Override
    public void remove(String key) throws Exception {
        mongoService.remove(key);
    }

}
