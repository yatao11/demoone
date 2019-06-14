package com.demoone.utils.map.web;


import com.demoone.support.sys.OptResult;
import com.demoone.utils.map.service.IDataMapKeyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 地图key 前端控制器
 * </p>
 *
 * @author yatao.zhang
 * @since 2019-03-26
 */
@RestController
@RequestMapping("/api/util/dataMapKey/")
@Api(value = "DataMapKeyController", description = "地图通用接口")
public class DataMapKeyController {

	@Autowired
	private IDataMapKeyService iDataMapKeyService;

	@ApiOperation(value = "地图key添加", notes = "地图key添加")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "key"  ,value = "地图key，多个,隔开", paramType = "query",required = true),
			@ApiImplicitParam(name = "type"  ,value = "类型  gaode  baidu", paramType = "query",required = true)
	})
	@GetMapping("insertKey")
	@ResponseBody
	public OptResult insertKey(String key,String type){
		OptResult result = OptResult.success();
		result.setData(iDataMapKeyService.insertKey(key,type));
		return result;
	}
}
