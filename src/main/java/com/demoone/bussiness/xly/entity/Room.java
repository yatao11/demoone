package com.demoone.bussiness.xly.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 华强
 * @since 2019-12-06
 */
@TableName("room")
@Data
@ToString
@ApiModel("房间类")
public class Room extends Model<Room> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("房间号")
    private String no;

    @ApiModelProperty("房间状态")
    private String state;

    @ApiModelProperty("满员人数")
    @TableField("full_num")
    private Integer fullNum;

    @ApiModelProperty("已经入住人数")
    @TableField("existing_num")
    private Integer existingNum;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty("修改时间")
    @TableField("modify_time")
    private Date modifyTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}
