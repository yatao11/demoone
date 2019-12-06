package com.demoone.data.web;

import com.demoone.common.entity.CommonArea;
import com.demoone.common.service.ICommonAreaService;
import com.demoone.data.entity.PhoneModel;
import com.demoone.support.sys.OptResult;
import com.demoone.utils.PhoneUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demoone.data.dto.DtoPhoneAddress;
/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/06/14 13:58
 */

@RestController
@RequestMapping("/SmallTool")
@Api(value = "SmallToolController", description = "小工具大全")
public class SmallToolController {

	@Autowired
	private ICommonAreaService iCommonAreaService;

	@ApiOperation(value = "查询手机号归属地", notes = "查询手机号归属地",response = DtoPhoneAddress.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "phoneNum"  ,value = "手机号", paramType = "query")
	})
	@GetMapping("queryCompInfoByCondition")
	public OptResult queryCompInfoByCondition(String phoneNum) {
		OptResult result = null;
		PhoneModel phoneModel = PhoneUtil.getPhoneModel(phoneNum);
		if(phoneModel != null && phoneModel.getCityName()!=null){
			CommonArea commonArea = iCommonAreaService.getOne(phoneModel.getCityName());
			DtoPhoneAddress dtoPhoneAddress = new DtoPhoneAddress();
			dtoPhoneAddress.setProvince(phoneModel.getProvinceName());
			dtoPhoneAddress.setCity(phoneModel.getCityName());
			dtoPhoneAddress.setCarrier(phoneModel.getCarrier());
			dtoPhoneAddress.setAreacode(commonArea.getProcode().toString());
			dtoPhoneAddress.setZip(commonArea.getId().toString());
			result=OptResult.success(dtoPhoneAddress);
		}else{
			result = OptResult.fail();
			result.setMsg("手机号无效");
		}
		return result;
	}



//	@Autowired
//	private IIdcardInfoExtractorService iIdcardInfoExtractorService;
//	@ApiOperation(value = "根据身份证号查询详细信息", notes = "根据身份证号查询详细信息",response = IdcardInfoExtractor.class)
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "code"  ,value = "身份证号", paramType = "query")
//	})
//	@GetMapping("queryIdcardInfoExtractor")
//	public OptResult queryIdcardInfoExtractor(String code) {
//		OptResult result = OptResult.success();
//		result.setData(iIdcardInfoExtractorService.getIdcardInfoExtractor(code));
//		return result;
//	}
}
