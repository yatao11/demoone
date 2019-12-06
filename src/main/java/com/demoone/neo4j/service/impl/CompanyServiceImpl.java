package com.demoone.neo4j.service.impl;

import com.demoone.neo4j.dao.CompanyDao;
import com.demoone.neo4j.entity.Company;
import com.demoone.neo4j.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/07/12 09:59
 */
@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyDao companyDao;

	@Override
	public Company getOneByName(String name) {
		return companyDao.getOneByName(name);
	}

	@Override
	public Iterable<Company> findAll() {
		return companyDao.findAll();
	}


}
