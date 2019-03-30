package com.gnq.giant.neo4j.system.dao;

import com.gnq.giant.neo4j.system.node.UserGraph;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface UserRepository extends Neo4jRepository<UserGraph, Long> {
//    @Query("MATCH (n:UserGraph) RETURN n ")
//    List<UserGraph> getUserNodeList();
//
//    @Query("create (n:UserGraph{age:{age},name:{name}}) RETURN n ")
//    List<UserGraph> addUserNodeList(@Param("name") String name, @Param("age")int age);

    @Query("create (n:UserGraph{uuid:{uuid},userName:{userName}}) return n ")
    UserGraph addUserNode(@Param("userName") String userName, @Param("uuid") String uuid);

    UserGraph findByUserName(@Param("userName") String userName);

    @Query("Match (a:UserGraph),(b:UserGraph) where a.uuid = {startId} and b.uuid = {endId} Merge (a)-[r:family]-(b)")
    Collection<UserGraph> createFamilyRelation(@Param("startId") String startId, @Param("endId") String endId);
}
