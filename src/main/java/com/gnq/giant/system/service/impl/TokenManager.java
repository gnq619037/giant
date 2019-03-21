package com.gnq.giant.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gnq.giant.system.entities.TokenModel;
import com.gnq.giant.system.entities.User;
import com.gnq.giant.system.service.TokenManagerInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by NightGuo on 2019/3/20.
 *
 * @Author: NightGuo
 * @Description:
 * @Date: 9:46 2019/3/20
 */
@Component
@CacheConfig(cacheNames = "token")
public class TokenManager implements TokenManagerInterface {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final int REDIS_EXPIRE_TIME = 60;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public TokenModel createToken(User user) {
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        TokenModel tokenModel = new TokenModel(user, token);
        logger.info(user.getUsername()+"token:"+token);
        redisTemplate.boundValueOps(tokenModel.getToken()).set(tokenModel, REDIS_EXPIRE_TIME, TimeUnit.MINUTES);
        return tokenModel;
    }

    public boolean checkToken(String token) {
        TokenModel tokenModel = (TokenModel) redisTemplate.boundValueOps(token).get();
        if(tokenModel != null){
            redisTemplate.boundValueOps(tokenModel.getToken()).expire(REDIS_EXPIRE_TIME, TimeUnit.SECONDS);
            return true;
        }
        return false;
    }

    public boolean deleteToken(String token) {
        TokenModel tokenModel = (TokenModel) redisTemplate.boundValueOps(token).get();
        if(tokenModel != null){
            return redisTemplate.delete(token);
        }
        return true;
    }
}
