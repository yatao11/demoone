package com.demoone.bussiness.xly.web;


import com.demoone.bussiness.xly.entity.Coach;
import com.demoone.bussiness.xly.entity.Room;
import com.demoone.bussiness.xly.service.ICoachService;
import com.demoone.bussiness.xly.service.IRoomService;
import com.demoone.support.exception.SellException;
import com.demoone.support.sys.ErrCode;
import com.demoone.support.sys.OptResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/coach")
@Api(value = "CoachController", description = "教练信息")
public class CoachController {



    @Autowired
    private ICoachService  iCoachService;

    @ApiOperation(value = "批量增加教练信息", notes = "批量增加教练信息")
    @PostMapping("addList")
    @ResponseBody
    public OptResult queryCompInfoByCondition(@RequestBody List<Coach> coach) {
        OptResult result = null;
        if (iCoachService.insertBatch(coach)){
            result= OptResult.success();
            result.setMsg("添加成功！");
        }else {
            throw new SellException(ErrCode.FAIL,"添加失败！");
        }
        return result;
    }
    @ApiOperation(value = "删除房间信息", notes = "删除房间信息")
    @GetMapping("delete")
    @ResponseBody
    public OptResult queryCompInfoByCondition(int id) {
        OptResult result = null;
        if (iCoachService.deleteById(id)){
            result= OptResult.success();
            result.setMsg("删除成功！");
        }else {
            throw new SellException(ErrCode.FAIL,"删除教练失败！");
        }
        return result;
    }


}
