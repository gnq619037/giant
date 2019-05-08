package com.gnq.giant.system.controller;

import com.gnq.giant.system.dto.UserDTO;
import com.gnq.giant.system.entities.User;
import com.gnq.giant.system.service.TokenManagerInterface;
import com.gnq.giant.system.service.UserService;

import com.gnq.giant.util.GiantResponse;
import io.swagger.annotations.*;
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
@Api(tags = "1.0", description = "用户管理", value = "用户管理")
@RestController
@RequestMapping(value = "/giant")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private TokenManagerInterface tokenManagerInterface;

    @ApiOperation(value = "通过用户名或者昵称查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名或昵称")
    })
    @RequestMapping(value="/user/get/{name}", method = RequestMethod.GET)
    public Object getUserByNickName(@PathVariable("name") String name){
        List<User> users = userService.getUserByName(name);
        System.out.println(users);
        return users;
    }

    @RequestMapping(value = "/user/get", method = RequestMethod.POST)
    public Object getUserByLoginName(@RequestBody User user){
        return userService.getUserByLoginName(user);
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
        Map<String, Object> resultMap = userService.checkSession(token);
        return resultMap;
    }

    @RequestMapping(value = "/user/logout", method = RequestMethod.POST)
    public Object userLogout(HttpServletRequest request, @RequestBody UserDTO userDTO){
        String token = userDTO.getToken();
        Map<String, Object> resultMap = userService.userLogout(token);
        return resultMap;
    }

    @RequestMapping(value = "/user/get/all", method = RequestMethod.POST)
    public Object getAllUser(@RequestBody UserDTO userDTO){
//        int currentNum = params.get("currentNum") == null?0:Integer.parseInt(params.get("currentNum").toString());
//        int pageSize = params.get("pageSize") == null?0:Integer.parseInt(params.get("pageSize").toString());

        Map<String, Object> resultMap = userService.getAllUser(userDTO.getPage(), userDTO.getPageSize());
        return resultMap;
    }

    @RequestMapping(value = "/users/update", method = RequestMethod.POST)
    public Object getAllUser(@RequestBody List<User> users){
        Map<String, Object> resultMap = userService.batchModify(users);
        return resultMap;
    }

    @RequestMapping(value = "/user/isLogin", method = RequestMethod.POST)
    public Object checkIsLogin(@RequestBody UserDTO userDTO){
        Map<String, Object> resultMap = userService.checkIsLogin(userDTO);
        return resultMap;
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    public Object deleteUser(@RequestBody UserDTO userDTO){
        Map<String, Object> resultMap = userService.deleteUser(userDTO);
        return resultMap;
    }
}
