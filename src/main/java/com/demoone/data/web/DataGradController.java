package com.demoone.data.web;


import com.demoone.data.service.IDataHistoryTodayService;
import com.demoone.support.sys.OptResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 事件图片表 前端控制器
 * </p>
 *
 * @author hq
 * @since 2019-06-14
 */
@RestController
@RequestMapping("/DataGradController")
@Api(value = "DataGradController", description = "数据抓取")
public class DataGradController {

	@Autowired
	private IDataHistoryTodayService iDataHistoryTodayService;


	@ApiOperation(value = "抓取历史上今天的数据（更新）", notes = "抓取历史上今天的数据（更新）")
	@GetMapping()
	public OptResult queryCompInfoByCondition() {
		OptResult result = OptResult.success();
		result.setData(iDataHistoryTodayService.GradeHistoryTodayDate());
		return result;
	}
}
