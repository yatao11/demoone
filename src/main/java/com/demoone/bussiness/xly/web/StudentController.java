package com.demoone.bussiness.xly.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.demoone.bussiness.xly.entity.Student;
import com.demoone.bussiness.xly.service.IStudentService;
import com.demoone.common.entity.CommonArea;
import com.demoone.data.dto.DtoPhoneAddress;
import com.demoone.support.exception.SellException;
import com.demoone.support.sys.ErrCode;
import com.demoone.support.sys.OptResult;
import com.demoone.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

	@ApiOperation(value = "批量增加学员信息", notes = "批量增加学员信息")
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

	@ApiOperation(value = "删除学员信息", notes = "删除学员信息")
	@GetMapping("delete")
	@ResponseBody
	public OptResult delete(int id) {
		OptResult result = null;
		if (iStudentService.deleteById(id)){
			result= OptResult.success();
			result.setMsg("删除成功！");
		}else {
			throw new SellException(ErrCode.FAIL,"删除学员失败！");
		}
		return result;
	}
	@ApiOperation(value = "先获取学员信息", notes = "先获取学员信息")
	@GetMapping("updateid")
	@ResponseBody
	public OptResult updateId(int id) {
		OptResult result =OptResult.success();
		Student student=new Student();
		student.setId(id);
		Wrapper<Student> ew = new EntityWrapper<>(student);
		result.setData(iStudentService.selectList(ew));
		return result;
	}


	@ApiOperation(value = "停止学员周期", notes = "停止学员周期")
	@GetMapping("tingzhouqi")
	@ResponseBody
	public OptResult tingZhouQi(int id) {
		OptResult result = null;
		if (iStudentService.tingZhouQi(id)){
			result= OptResult.success();
			result.setMsg("停止学员周期成功！");
		}else {
			throw new SellException(ErrCode.FAIL,"停止学员周期失败！");
		}
		return result;
	}


	@ApiOperation(value = "减学员天数", notes = "减学员天数")
	@GetMapping("jiantianshu")
	@ResponseBody
	public OptResult jianTianShu(int id) {
		OptResult result = null;
		if (iStudentService.jianTianShu(id)){
			result= OptResult.success();
			result.setMsg("减学员天数成功！");
		}else {
			throw new SellException(ErrCode.FAIL,"减学员天数失败！");
		}
		return result;
	}

	@ApiOperation(value = "获取今日在营人数", notes = "获取今日在营人数")
	@GetMapping("zongzaiying")
	@ResponseBody
	public OptResult zongZaiYing() {
		OptResult result =OptResult.success();
		result.setData(iStudentService.zongZaiYing());
		return result;
	}

	@ApiOperation(value = "今日出营人数", notes = "今日出营人数")
	@GetMapping("jinchuying")
	@ResponseBody
	public OptResult jinChuYing() {
		OptResult result =OptResult.success();
		result.setData(iStudentService.jinChuYing(DateUtils.getDate()));
		return result;
	}

	@ApiOperation(value = "今日入营人数", notes = "今日入营人数")
	@GetMapping("jinruying")
	@ResponseBody
	public OptResult jinRuYing() {
		OptResult result =OptResult.success();
		result.setData(iStudentService.jinRuYing(DateUtils.getDate()));
		return result;
	}
}
