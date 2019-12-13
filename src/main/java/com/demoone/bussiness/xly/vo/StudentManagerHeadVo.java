package com.demoone.bussiness.xly.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel("学员管理头部")
public class StudentManagerHeadVo {

    @ApiModelProperty("今天出营人数")
    private String jinchuying;


    @ApiModelProperty("今天入营人数")
    private String jinruying;

    @ApiModelProperty("今天在营人数")
    private String zongzaiying;

}
