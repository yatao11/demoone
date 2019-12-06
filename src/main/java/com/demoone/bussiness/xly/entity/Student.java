package com.demoone.bussiness.xly.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
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
@TableName("student")
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学员编号
     */
    private String sid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别 1男 2女
     */
    private Integer gender;

    /**
     * 身份证
     */
    @TableField("id_no")
    private String idNo;

    /**
     * 所属基地
     */
    private String base;

    /**
     * 加入时间
     */
    @TableField("join_time")
    private Date joinTime;

    /**
     * 离营时间
     */
    @TableField("leave_time")
    private Date leaveTime;

    /**
     * 销售（谁招收的学员）
     */
    private String sales;

    /**
     * 总天数
     */
    @TableField("total_day")
    private Integer totalDay;

    /**
     * 剩余天数
     */
    @TableField("surplus_day")
    private Integer surplusDay;

    /**
     * 房间id room表id
     */
    @TableField("room_id")
    private Integer roomId;

    /**
     * 房间编号
     */
    @TableField("room_no")
    private String roomNo;

    /**
     * 所属教练
     */
    @TableField("coach_id")
    private String coachId;

    /**
     * 所交费用
     */
    private BigDecimal cost;

    /**
     * 入营体重
     */
    @TableField("join_weight")
    private Double joinWeight;

    /**
     * 离营体重
     */
    @TableField("leave_weight")
    private Double leaveWeight;

    /**
     * 学员状态
     */
    private Integer state;

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
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }
    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }
    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }
    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }
    public Integer getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(Integer totalDay) {
        this.totalDay = totalDay;
    }
    public Integer getSurplusDay() {
        return surplusDay;
    }

    public void setSurplusDay(Integer surplusDay) {
        this.surplusDay = surplusDay;
    }
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }
    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
    public Double getJoinWeight() {
        return joinWeight;
    }

    public void setJoinWeight(Double joinWeight) {
        this.joinWeight = joinWeight;
    }
    public Double getLeaveWeight() {
        return leaveWeight;
    }

    public void setLeaveWeight(Double leaveWeight) {
        this.leaveWeight = leaveWeight;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
        return "Student{" +
        "id=" + id +
        ", sid=" + sid +
        ", name=" + name +
        ", gender=" + gender +
        ", idNo=" + idNo +
        ", base=" + base +
        ", joinTime=" + joinTime +
        ", leaveTime=" + leaveTime +
        ", sales=" + sales +
        ", totalDay=" + totalDay +
        ", surplusDay=" + surplusDay +
        ", roomId=" + roomId +
        ", roomNo=" + roomNo +
        ", coachId=" + coachId +
        ", cost=" + cost +
        ", joinWeight=" + joinWeight +
        ", leaveWeight=" + leaveWeight +
        ", state=" + state +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
