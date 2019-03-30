package com.gnq.giant.neo4j.system.service.impl;

import com.gnq.giant.neo4j.system.dao.UserRepository;
import com.gnq.giant.neo4j.system.node.UserGraph;
import com.gnq.giant.neo4j.system.service.UserGraphService;
import com.gnq.giant.system.dao.UserDao;
import com.gnq.giant.system.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class UserGraphServiceImpl implements UserGraphService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private UserDao userDao;

    public boolean addUser(UserGraph userGraph) {
        userRepository.addUserNode(userGraph.getUserName(), userGraph.getUuid());
        return true;
    }

    @Transactional(readOnly = true)
    public UserGraph getUserGraphByUserName(String userName) {
        UserGraph userGraph = userRepository.findByUserName(userName);
//        List<User> users = userDao.findUserByName(userGraph.getUserName());
        return userGraph;
    }

    public Collection<UserGraph> createFamily(String startId, String endId) {
        return userRepository.createFamilyRelation(startId, endId);
    }
}
