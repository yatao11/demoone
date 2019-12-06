package com.demoone.bussiness.xly.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
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
@TableName("room")
public class Room extends Model<Room> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 房间号
     */
    private String no;

    /**
     * 房间状态
     */
    private String state;

    /**
     * 满员人数
     */
    @TableField("full_num")
    private Integer fullNum;

    /**
     * 已经入住人数
     */
    @TableField("existing_num")
    private Integer existingNum;

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
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public Integer getFullNum() {
        return fullNum;
    }

    public void setFullNum(Integer fullNum) {
        this.fullNum = fullNum;
    }
    public Integer getExistingNum() {
        return existingNum;
    }

    public void setExistingNum(Integer existingNum) {
        this.existingNum = existingNum;
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
        return "Room{" +
        "id=" + id +
        ", no=" + no +
        ", state=" + state +
        ", fullNum=" + fullNum +
        ", existingNum=" + existingNum +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
