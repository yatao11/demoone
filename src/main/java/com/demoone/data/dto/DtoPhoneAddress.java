package com.demoone.data.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/06/14 14:10
 */
@Data
@ApiModel("手机号归属地返回实体类")
public class DtoPhoneAddress {

	@ApiModelProperty("省份")
	private String province;

	@ApiModelProperty("市")
	private String city;

	@ApiModelProperty("运营商")
	private String carrier;

	@ApiModelProperty("区号")
	private String areacode;

	@ApiModelProperty("邮编")
	private String zip;
}
