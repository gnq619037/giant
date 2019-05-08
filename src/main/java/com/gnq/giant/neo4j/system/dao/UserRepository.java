package com.gnq.giant.neo4j.system.dao;

import com.gnq.giant.neo4j.system.node.UserGraph;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface UserRepository extends Neo4jRepository<UserGraph, Long> {
    @Query("create (n:UserGraph{userName:{userName}}) return n ")
    UserGraph addUserNode(@Param("userName") String userName);

    UserGraph findByUserName(@Param("userName") String userName);

    @Query("Match (a:UserGraph),(b:UserGraph) where a.userName = {startUserName} and b.userName = {endUserName} Merge (a)-[r:family]-(b)")
    Collection<UserGraph> createFamilyRelation(@Param("startUserName") String startUserName, @Param("endUserName") String endUserName);

    @Query("Match (a:UserGraph)-[r]-(b:UserGraph) where a.userName = {username} return a,b,r")
    Collection<UserGraph> getMyRelationUser(@Param("username") String username);
}
