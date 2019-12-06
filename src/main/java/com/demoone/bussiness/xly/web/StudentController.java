package com.demoone.bussiness.xly.web;


import com.demoone.bussiness.xly.entity.Student;
import com.demoone.bussiness.xly.service.IStudentService;
import com.demoone.data.dto.DtoPhoneAddress;
import com.demoone.support.exception.SellException;
import com.demoone.support.sys.ErrCode;
import com.demoone.support.sys.OptResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 华强
 * @since 2019-12-06
 */
@Controller
@RequestMapping("/xly/base/student")
@Api(value = "StudentController", description = "学员信息")
public class StudentController {


	@Autowired
	private IStudentService iStudentService;

	@ApiOperation(value = "批量增加学员信息", notes = "批量增加学员信息",response = DtoPhoneAddress.class)
	@PostMapping("addList")
	@ResponseBody
	public OptResult queryCompInfoByCondition(@RequestBody List<Student> student) {
		OptResult result = null;
		if (iStudentService.insertBatch(student)){
			result= OptResult.success();
			result.setMsg("添加成功！");
		}else {
			throw new SellException(ErrCode.FAIL,"添加失败！");
		}
		return result;
	}

}
