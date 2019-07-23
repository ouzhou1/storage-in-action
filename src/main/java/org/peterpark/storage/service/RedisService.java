package org.peterpark.storage.service;

import io.swagger.annotations.*;

/**
 * Description:
 *
 * @author: ouzo
 * @date: 2018/8/15.
 */

@Api(value = "redis", description = "redis增删查改")
public interface RedisService extends StorageService {
    /**
     * set value with expireTime
     *
     * @param key        键
     * @param value      值
     * @param expireTime 过期时间
     * @return 是否成功
     */
    //option的value的内容是这个method的描述，notes是详细描述，response是最终返回的json model。其他可以忽略
    @ApiOperation(value = "Add a new pet to the store", notes = "", response = Void.class, authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write:pets", description = "modify pets in your account"),
                    @AuthorizationScope(scope = "read:pets", description = "read your pets")
            })
    }, tags={ "pet", })

    //这里是显示你可能返回的http状态，以及原因。比如404 not found, 303 see other
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input", response = Void.class)})
    boolean set(final String key, Object value, Long expireTime);
}
