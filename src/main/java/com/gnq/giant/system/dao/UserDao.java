package com.gnq.giant.system.dao;

import com.gnq.giant.system.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by NightGuo on 2019/3/15.
 *
 * @Author: NightGuo
 * @Description:
 * @Date: 13:41 2019/3/15
 */
@Mapper
public interface UserDao {
    public List<User> findUserByName(@Param("name") String name);

    public List<User> findUserDuplicated(@Param("username") String username, @Param("nickName") String nickName);

    public User findUserByNamePassword(@Param("name") String name, @Param("password") String password);

    public boolean addUser(User user);

    public List<User> findAllUser(@Param("currentNum") int currentNum, @Param("pageSize") int pageSize);

    int updateUsers(List<User> users);
}
