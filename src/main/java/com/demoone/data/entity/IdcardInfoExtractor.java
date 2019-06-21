package com.demoone.data.entity;

import com.demoone.common.entity.CommonArea;
import com.demoone.common.service.ICommonAreaService;
import com.demoone.utils.DateUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/06/20 10:30
 */
@Data
@ToString
public class IdcardInfoExtractor {

	@ApiModelProperty("省份")
	private String province;
	@ApiModelProperty("城市")
	private String city;
	@ApiModelProperty("区县")
	private String region;
	@ApiModelProperty("性别")
	private String gender;
	@ApiModelProperty("出生日期")
	private String birthday;
	@ApiModelProperty("区号")
	private String procode;
	@ApiModelProperty("年龄")
	private int age;
	@ApiModelProperty("经度")
	private Double lng;
	@ApiModelProperty("纬度")
	private Double lat;
	@ApiModelProperty("身份证号")
	private String code;
}
