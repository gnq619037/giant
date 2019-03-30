package com.gnq.giant.neo4j.system.service;

import com.gnq.giant.neo4j.system.node.UserGraph;

import java.util.Collection;

public interface UserGraphService {
    public boolean addUser(UserGraph userGraph);

    public UserGraph getUserGraphByUserName(String userName);

    public Collection<UserGraph> createFamily(String startId, String endId);
}
