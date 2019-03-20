package com.gnq.giant.system.service;

import com.gnq.giant.system.entities.User;

import java.util.List;
import java.util.Map;

/**
 * Created by NightGuo on 2019/3/15.
 *
 * @Author: NightGuo
 * @Description:
 * @Date: 10:55 2019/3/15
 */
public interface UserService {

    public List<User> getUserByName(String name);

    public Map<String, Object> registerUser(User user);

    public Map<String, Object> userLogin(String name, String password);
}
