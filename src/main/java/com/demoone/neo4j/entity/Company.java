package com.demoone.neo4j.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.annotation.Id;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/07/11 15:00
 */
@NodeEntity
@Data
@NoArgsConstructor
public class Company {

	@Id
	private Long id;
	private String address;
	private String industry;
	private String legalPerson;
	private String mail;
	private String name;
	private String regdate;
	private String status;
	private String tel;
}
