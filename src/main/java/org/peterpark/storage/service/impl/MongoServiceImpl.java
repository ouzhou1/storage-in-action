package org.peterpark.storage.service.impl;

import org.peterpark.storage.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author: peter
 * @date: 2018/8/16.
 */
@Service
public class MongoServiceImpl implements MongoService {

    private static final String COLLECTION_NAME = "test";

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * @param key 键
     * @return value
     */
    @Override
    public Object get(String key) {
        return mongoTemplate.findOne(new Query(Criteria.where("key").is(key)), Object.class, COLLECTION_NAME);
    }

    /**
     * set value
     *
     * @param key   键
     * @param value 值
     * @return 是否成功
     */
    @Override
    public boolean set(String key, Object value) {
        try {
            if (get(key) != null) {
                mongoTemplate.save(value, COLLECTION_NAME);
            } else {
                mongoTemplate.insert(value, COLLECTION_NAME);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * @param key 键
     * @return 是否存在键
     */
    @Override
    public boolean exists(String key) {
        return get(key) != null;
    }

    /**
     * remove single key
     *
     * @param key 键
     */
    @Override
    public void remove(String key) {
        mongoTemplate.remove(get(key));
    }
}
