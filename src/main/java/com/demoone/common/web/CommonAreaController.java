package com.demoone.common.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.demoone.common.entity.CommonArea;
import com.demoone.common.service.ICommonAreaService;
import com.demoone.support.sys.OptResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 省市区编码表 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/api/common")
public class CommonAreaController {

    @Autowired
    ICommonAreaService iCommonAreaService;

    @ApiOperation(value = "城市地区", notes = "获取省份", response = CommonArea.class)
    @GetMapping("province")
    public OptResult province() {
        OptResult result = OptResult.success();
        CommonArea commonArea = new CommonArea();
        commonArea.setPid(100000L);
        Wrapper<CommonArea> ew = new EntityWrapper<>(commonArea);
        result.setData(iCommonAreaService.selectList(ew));
        return result;
    }

    @ApiOperation(value = "全部城市地区", notes = "全部城市地区", response = CommonArea.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "level", value = "3", paramType = "query", required = false,defaultValue = "3")
    })
    @GetMapping("getall")
    public OptResult getall(@RequestParam(defaultValue = "3") Integer level) {
        OptResult result = OptResult.success();
        result.setData(iCommonAreaService.getall(level));
        return result;
    }

    @ApiOperation(value = "城市地区", notes = "获取地区/城市", response = CommonArea.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentid", value = "110000", paramType = "query", required = true)
    })
    @GetMapping("areabyparentid")
    public OptResult areabyprovince(@RequestParam Long parentid) {
        OptResult result = OptResult.success();
        CommonArea commonArea = new CommonArea();
        commonArea.setPid(parentid);
        Wrapper<CommonArea> ew = new EntityWrapper<>(commonArea);
        result.setData(iCommonAreaService.selectList(ew));
        return result;
    }

    @ApiOperation(value = "根据高德接口更新信息", notes = "根据高德接口更新信息", response = CommonArea.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "province", value = "江苏", paramType = "query", required = false,defaultValue="")
    })
    @GetMapping("updateinfo")
    public OptResult updateinfo(@RequestParam(required=false,defaultValue="") String province) {
        OptResult result = OptResult.success();
        result.setData(iCommonAreaService.updateInfo(province));
        return result;
    }

}
