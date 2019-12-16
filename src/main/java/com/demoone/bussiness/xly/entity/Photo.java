package com.demoone.bussiness.xly.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("photo")
@ApiModel("照片类")
@Data
@ToString
public class Photo extends Model<Photo> {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("自增主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("照片名称")
    private String name;

    @ApiModelProperty("大小（k）")
    private Double size;

    @ApiModelProperty("照片类型 例.png")
    private String suffix;

    @ApiModelProperty("照片路径")
    private String path;

    @ApiModelProperty("关联教练，人员，房间id")
    @TableField("relationship_id")
    private String relationshipId;

    @ApiModelProperty("照片类型 1学院入营照片 2学员离营照片 3学员合同照片 4教练照片")
    private Integer type;

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
