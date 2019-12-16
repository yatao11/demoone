package com.demoone.bussiness.xly.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@ApiModel("学员查询条件")
public class StudentSelect {


    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别 1男 2女")
    private Integer gender;

    @TableField("id_no")
    @ApiModelProperty("身份证")
    private String idNo;

    @ApiModelProperty("所属基地")
    private String base;

    @ApiModelProperty("加入时间")
    @TableField("join_time")
    private Date joinTime;

    @ApiModelProperty("离营时间")
    @TableField("leave_time")
    private Date leaveTime;

    @ApiModelProperty("销售（谁招收的学员）")
    private String sales;

    @ApiModelProperty("房间编号")
    @TableField("room_no")
    private String roomNo;

    @ApiModelProperty("所属教练")
    @TableField("coach_id")
    private String coachId;

    @ApiModelProperty("学员状态")
    private Integer state;

}
