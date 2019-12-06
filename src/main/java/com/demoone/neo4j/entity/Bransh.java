package com.demoone.neo4j.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/07/11 15:56
 */
@RelationshipEntity(type = "Branch")
@Data
@NoArgsConstructor
public class Bransh {

	@GraphId
	private Long id;

	@StartNode
	private Company startNode;

	@EndNode
	private Company endNode;
}
