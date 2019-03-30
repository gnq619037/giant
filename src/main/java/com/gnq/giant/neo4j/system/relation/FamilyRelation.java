package com.gnq.giant.neo4j.system.relation;

import com.gnq.giant.neo4j.system.node.UserGraph;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

@Data
@RelationshipEntity(type = "famliy")
public class FamilyRelation {
    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private UserGraph startUserGraph;

    @EndNode
    private UserGraph endUserGraph;
}
