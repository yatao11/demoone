package com.demoone.neo4j.dao;

import com.demoone.neo4j.entity.Company;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/07/12 09:26
 */
public interface CompanyDao extends GraphRepository<Company>{

	@Query("match p=(c:Company) where c.name={name} return p")
	Company getOneByName(@Param("name") String name);

}
