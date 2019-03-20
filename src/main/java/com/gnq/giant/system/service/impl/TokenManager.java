package com.gnq.giant.system.service.impl;

import com.gnq.giant.system.entities.TokenModel;
import com.gnq.giant.system.entities.User;
import com.gnq.giant.system.service.TokenManagerInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TokenManager implements TokenManagerInterface {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final int REDIS_EXPIRE_TIME = 1;

//    @Autowired
//    private RedisTemplate redisTemplate;

    public TokenModel createToken(User user) {
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        TokenModel tokenModel = new TokenModel(user, token);
        logger.info(user.getUsername()+"token:"+token);
//        redisTemplate.boundValueOps(tokenModel.getToken()).expire(REDIS_EXPIRE_TIME, TimeUnit.SECONDS);
        return tokenModel;
    }

    public Map<String, Object> checkToken(TokenModel tokenModel) {
//        redisTemplate.boundValueOps(tokenModel.getToken()).get();
        return null;
    }
}
