package com.gnq.giant.neo4j.system.service.impl;

import com.gnq.giant.neo4j.system.dao.UserRepository;
import com.gnq.giant.neo4j.system.node.UserGraph;
import com.gnq.giant.neo4j.system.relation.FamilyRelation;
import com.gnq.giant.neo4j.system.service.UserGraphService;
import com.gnq.giant.system.dao.UserDao;
import com.gnq.giant.system.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserGraphServiceImpl implements UserGraphService {
    @Autowired
    private UserRepository userRepository;

    public boolean addUser(UserGraph userGraph) {
        UserGraph graph = userRepository.findByUserName(userGraph.getUserName());
        if(graph != null){

        }
//        userRepository.addUserNode(userGraph.getUserName(), userGraph.getUuid());
        return true;
    }

    @Transactional(readOnly = true)
    public UserGraph getUserGraphByUserName(String userName) {
        UserGraph userGraph = userRepository.findByUserName(userName);
        return userGraph;
    }

    public Collection<UserGraph> createFamily(FamilyRelation familyRelation) {
        userRepository.addUserNode(familyRelation.getStartUserGraph().getUserName());
        userRepository.addUserNode(familyRelation.getEndUserGraph().getUserName());
        return userRepository.createFamilyRelation(familyRelation.getStartUserGraph().getUserName(), familyRelation.getEndUserGraph().getUserName());
    }

    public Map<String, Object> getRelationUser(String username) {
        Collection<UserGraph> graphs = userRepository.getMyRelationUser(username);
        System.out.println(graphs);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("success", true);
        resultMap.put("result", graphs);
        return resultMap;
    }
}
