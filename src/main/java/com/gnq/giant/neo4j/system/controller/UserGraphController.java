package com.gnq.giant.neo4j.system.controller;

import com.gnq.giant.neo4j.system.node.UserGraph;
import com.gnq.giant.neo4j.system.relation.FamilyRelation;
import com.gnq.giant.neo4j.system.service.UserGraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/giant/graph")
public class UserGraphController {

    @Autowired
    private UserGraphService userGraphService;

    @RequestMapping(value="/user/add", method = RequestMethod.POST)
    public Object register(@RequestBody UserGraph user){
//        user.setUuid(UUID.randomUUID().toString());
        userGraphService.addUser(user);
        return null;
    }

    @RequestMapping(value = "/user/get", method = RequestMethod.POST)
    public Object getUserByName(@RequestBody UserGraph userGraph){
        UserGraph user = userGraphService.getUserGraphByUserName(userGraph.getUserName());
        System.out.println(user);
        return user;
    }

    @RequestMapping(value = "/user/relation/family", method = RequestMethod.POST)
    public Object createFamily(@RequestBody FamilyRelation familyRelation){
        return userGraphService.createFamily(familyRelation);
    }

    @RequestMapping(value = "/user/relation/users", method = RequestMethod.POST)
    public Object getRelationUser(@RequestBody UserGraph userGraph){
        return userGraphService.getRelationUser(userGraph.getUserName());
    }
}
