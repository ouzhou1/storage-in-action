package org.storage.demo.constant.request;

import javax.validation.constraints.NotNull;

/**
 * Description:
 *
 * @author: peter
 * @date: 2018/8/16.
 */
public class SetRequest {

    @NotNull
    private String key;

    private Object value;

    private Long expireTime;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }
}
