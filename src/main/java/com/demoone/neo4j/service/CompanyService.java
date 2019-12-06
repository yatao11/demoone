package com.demoone.neo4j.service;

import com.demoone.neo4j.entity.Company;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/07/11 15:08
 */
public interface CompanyService{

	Company getOneByName(String name);

	Iterable<Company> findAll();
}
