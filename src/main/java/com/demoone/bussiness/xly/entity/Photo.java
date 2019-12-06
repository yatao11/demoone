package com.demoone.bussiness.xly.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
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
public class Photo extends Model<Photo> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 照片名称
     */
    private String name;

    /**
     * 大小（k）
     */
    private Double size;

    /**
     * 照片类型 例.png
     */
    private String suffix;

    /**
     * 照片路径
     */
    private String path;

    /**
     * 关联教练，人员，房间id
     */
    @TableField("relationship_id")
    private String relationshipId;

    /**
     * 照片类型 1学院入营照片 2学员离营照片 3学员合同照片 4教练照片
     */
    private Integer type;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("modify_time")
    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(String relationshipId) {
        this.relationshipId = relationshipId;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Photo{" +
        "id=" + id +
        ", name=" + name +
        ", size=" + size +
        ", suffix=" + suffix +
        ", path=" + path +
        ", relationshipId=" + relationshipId +
        ", type=" + type +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
