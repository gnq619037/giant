package com.gnq.giant.system.service.impl;

import com.github.pagehelper.PageInfo;
import com.gnq.giant.system.dao.UserDao;
import com.gnq.giant.system.entities.TokenModel;
import com.gnq.giant.system.entities.User;
import com.gnq.giant.system.service.TokenManagerInterface;
import com.gnq.giant.system.service.UserService;
import com.gnq.giant.util.MD5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by NightGuo on 2019/3/15.
 *
 * @Author: NightGuo
 * @Description:
 * @Date: 13:44 2019/3/15
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    @Autowired
    private TokenManagerInterface tokenManagerInterface;

    public List<User> getUserByName(String name) {
        return userDao.findUserByName(name);
    }

    public Map<String, Object> registerUser(User user) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<User> exitsUser = userDao.findUserDuplicated(user.getUsername(), user.getNickName());
        if(exitsUser.size() > 0){
            resultMap.put("msg", "用户名或者昵称存在重复");
            resultMap.put("success", false);
            return resultMap;
        }
        String passwordMD5 = MD5.md5(user.getPassword());
        user.setPassword(passwordMD5);
        userDao.addUser(user);
        resultMap.put("msg", "注册成功");
        resultMap.put("success", true);
        return resultMap;
    }

    public Map<String, Object> userLogin(String name, String password) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<User> users = userDao.findUserByName(name);
        if(users.size() == 0){
            resultMap.put("msg", "用户名不存在");
            resultMap.put("success", false);
            return resultMap;
        }
        String passwordMD5 = MD5.md5(password);
        User user = userDao.findUserByNamePassword(name, passwordMD5);
        if(user != null){
            TokenModel tokenModel = tokenManagerInterface.createToken(user);
            resultMap.put("msg", "登录成功");
            resultMap.put("token", tokenModel.getToken());
            resultMap.put("success", true);
            return resultMap;
        }
        resultMap.put("msg", "登录密码错误");
        resultMap.put("success", false);
        return resultMap;
    }

    public Map<String, Object> checkSession(String token) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        boolean tokenExits = tokenManagerInterface.checkToken(token);
        resultMap.put("success", tokenExits);
        if(tokenExits){
            resultMap.put("msg", "token延时");
            return resultMap;
        }
        resultMap.put("msg", "token失效");
        return resultMap;
    }

    public Map<String, Object> userLogout(String token) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        boolean isDelete = tokenManagerInterface.deleteToken(token);
        resultMap.put("success", isDelete);
        if(isDelete){
            resultMap.put("msg", "用户登出");
            return resultMap;
        }
        resultMap.put("msg", "用户登出失败");
        return resultMap;
    }

    public Map<String, Object> getAllUser(int currentNum, int pageSize) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<User> users = userDao.findAllUser(currentNum, pageSize);
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        resultMap.put("count", pageInfo.getTotal());
        resultMap.put("data", pageInfo.getList());
        resultMap.put("success", true);
        return resultMap;
    }
}
