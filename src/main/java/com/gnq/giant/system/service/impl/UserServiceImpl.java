package com.gnq.giant.system.service.impl;

import com.gnq.giant.system.dao.UserDao;
import com.gnq.giant.system.entities.User;
import com.gnq.giant.system.service.UserService;
import com.gnq.giant.util.MD5;
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
    @Autowired
    private UserDao userDao;

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
            resultMap.put("msg", "登录成功");
            resultMap.put("success", true);
            return resultMap;
        }
        resultMap.put("msg", "登录失败");
        resultMap.put("success", false);
        return resultMap;
    }
}
