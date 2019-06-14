package com.demoone.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 省市区编码表
 * </p>
 */
@TableName("common_area")
public class CommonArea extends Model<CommonArea> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    @ApiModelProperty("ID")
    private Long id;

    /**
     * 省市区名称
     */
    @ApiModelProperty("行政区名称")
    private String name;

    /**
     * 省市区名称拼音
     */
    @ApiModelProperty("拼音")
    private String namepinyin;

    /**
     * 省市编码
     */
    @ApiModelProperty("父Id")
    private Long pid;

    /**
     * 排序代码
     */
    @ApiModelProperty("排序")
    private Integer disorder;

    /**
     * 省区域代码
     */
    @ApiModelProperty("区域代码")
    private String procode;

    @ApiModelProperty("精度")
    public Double lng;
    @ApiModelProperty("纬度")
    public Double lat;

    @ApiModelProperty("下级")
    @TableField(exist = false)
    List<CommonArea> child;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
    public Integer getDisorder() {
        return disorder;
    }

    public void setDisorder(Integer disorder) {
        this.disorder = disorder;
    }
    public String getProcode() {
        return procode;
    }

    public void setProcode(String procode) {
        this.procode = procode;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getNamepinyin() {
        return namepinyin;
    }

    public void setNamepinyin(String namepinyin) {
        this.namepinyin = namepinyin;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CommonArea{" +
        "id=" + id +
        ", name=" + name +
        ", pid=" + pid +
        ", disorder=" + disorder +
        ", procode=" + procode +
        "}";
    }

    public List<CommonArea> getChild() {
        return child;
    }

    public void setChild(List<CommonArea> child) {
        this.child = child;
    }
}
