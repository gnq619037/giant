package com.gnq.giant.system.service;

import com.gnq.giant.system.dto.UserDTO;
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

    public Map<String, Object> checkSession(String token);

    public Map<String, Object> userLogout(String token);

    public Map<String, Object> getAllUser(int currentNum, int pageSize);

    Map<String, Object> batchModify(List<User> users);

    Map<String, Object> getUserByLoginName(User user);

    Map<String, Object> checkIsLogin(UserDTO userDTO);

    Map<String, Object> deleteUser(UserDTO userDTO);
}
