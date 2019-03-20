package com.gnq.giant.system.service;

import com.gnq.giant.system.entities.TokenModel;
import com.gnq.giant.system.entities.User;

import java.util.Map;

/**
 * Created by NightGuo on 2019/3/20.
 *
 * @Author: NightGuo
 * @Description:
 * @Date: 9:44 2019/3/20
 */
public interface TokenManagerInterface {
    /**
     * 生成token
     * @param user
     * @return
     */
    public TokenModel createToken(User user);

    public Map<String, Object> checkToken(TokenModel token);
}
