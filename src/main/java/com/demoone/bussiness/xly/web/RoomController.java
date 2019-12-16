package com.demoone.bussiness.xly.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.demoone.bussiness.xly.entity.Room;
import com.demoone.bussiness.xly.service.IRoomService;
import com.demoone.support.exception.SellException;
import com.demoone.support.sys.ErrCode;
import com.demoone.support.sys.OptResult;
import com.demoone.utils.string.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
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
@RestController
@RequestMapping("/room")
@Api(value = "RoomController", description = "房间信息")
public class RoomController {


    @Autowired
    private IRoomService iRoomService;

    @ApiOperation(value = "增加房间信息", notes = "增加房间信息")
    @PostMapping("addRoom")
    @ResponseBody
    public OptResult addRoom(@RequestBody Room room) {
        OptResult result = null;
        if (iRoomService.addRoom(room)){
            result= OptResult.success();
            result.setMsg("添加成功！");
        }else {
            result= OptResult.fail();
            result.setMsg("添加失败，请稍后再试!");
        }
        return result;
    }
    @ApiOperation(value = "删除房间信息", notes = "删除房间信息")
    @GetMapping("delete")
    @ResponseBody
    public OptResult queryCompInfoByCondition(int id) {
        OptResult result = null;
        if (iRoomService.deleteById(id)){
            result= OptResult.success();
            result.setMsg("删除成功！");
        }else {
            throw new SellException(ErrCode.FAIL,"删除房间失败！");
        }
        return result;
    }

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", paramType = "query", required = false,defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "每页条数", paramType = "query", required = false,defaultValue = "10")
    })
    @GetMapping("list")
    @ResponseBody
    public OptResult list( Integer page, Integer size,String roomNo) {
        OptResult result = null;
        if (page ==null){
            page=1;
        }
        if (size ==null){
            size=10;
        }
        EntityWrapper<Room> ew = new EntityWrapper();
        if (StringUtils.isNotBlank(roomNo)){
            ew.eq("room_id",roomNo);
        }
        Page<Room> pageRoom = new Page<>(page,size);

        result.setData(iRoomService.selectPage(pageRoom,ew));
        return result;
    }
}
