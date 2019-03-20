package com.gnq.giant.system.controller;

import com.gnq.giant.system.entities.User;
import com.gnq.giant.system.service.TokenManagerInterface;
import com.gnq.giant.system.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by NightGuo on 2019/3/15.
 *
 * @Author: NightGuo
 * @Description:
 * @Date: 13:45 2019/3/15
 */
@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private TokenManagerInterface tokenManagerInterface;

    @RequestMapping(value="/user/get/{name}", method = RequestMethod.GET)
    public Object getUserByNickName(@PathVariable("name") String name){
        List<User> users = userService.getUserByName(name);
        System.out.println(users);
        return users;
    }

    @RequestMapping(value="/user/add", method = RequestMethod.POST)
    public Object register(@RequestBody User user){
        Map<String, Object> map = userService.registerUser(user);
        return map;
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public Object login(@RequestBody Map<String,Object> params){
        String name = params.get("name").toString();
        String password = params.get("password").toString();
        Map<String, Object> map = userService.userLogin(name, password);
        return map;
    }

    @RequestMapping(value = "/checkSession", method = RequestMethod.GET)
    public Object checkSession(HttpServletRequest request){
        String token = request.getHeader("Token");
        return null;
    }
}
