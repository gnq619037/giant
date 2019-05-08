package com.gnq.giant.neo4j.system.service;

import com.gnq.giant.neo4j.system.node.UserGraph;
import com.gnq.giant.neo4j.system.relation.FamilyRelation;
import com.gnq.giant.system.entities.User;

import java.util.Collection;
import java.util.Map;

public interface UserGraphService {
    public boolean addUser(UserGraph userGraph);

    public UserGraph getUserGraphByUserName(String userName);

    public Collection<UserGraph> createFamily(FamilyRelation familyRelation);

    public Map<String, Object> getRelationUser(String username);
}
