package com.demoone.neo4j.web;

import com.demoone.neo4j.service.BranshService;
import com.demoone.neo4j.service.CompanyService;
import com.demoone.support.sys.OptResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/07/11 15:11
 */
@RestController
@RequestMapping("/CompanyController")
@Api(value = "CompanyController", description = "neo4j测试")
public class CompanyController {

	@Autowired
	private CompanyService companyRepository;

	@Autowired
	private BranshService branshService;

	@ApiOperation(value = "测试点", notes = "测试点")
	@GetMapping("queryCompInfoByCondition")
	public OptResult queryCompInfoByCondition() {
		OptResult result = OptResult.success();
		result.setData(companyRepository.findAll());
		return result;
	}


	@ApiOperation(value = "测试关系", notes = "测试关系")
	@GetMapping("findall")
	public OptResult findall() {
		OptResult result = OptResult.success();
		result.setData(branshService.findAll());
		return result;
	}


	@ApiOperation(value = "测试关系", notes = "测试关系")
	@GetMapping("getOne")
	public OptResult getOne(String name) {
		OptResult result = OptResult.success();
		result.setData(companyRepository.getOneByName(name));
		return result;
	}
}
