package com.gnq.giant.neo4j.system.node;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NodeEntity
public class UserGraph {
    @Id
    @GeneratedValue
    private Long id;
    private String uuid;
    private String userName;
}
