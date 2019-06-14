package com.demoone.data.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 历史上的今天数据
 * </p>
 *
 * @author hq
 * @since 2019-06-14
 */
@TableName("data_history_today")
public class DataHistoryToday extends Model<DataHistoryToday> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 时间年份
     */
    private Integer year;

    /**
     * 月
     */
    private Integer month;

    /**
     * 日
     */
    private Integer day;

    /**
     * 事件标题
     */
    private String title;

    /**
     * 中文年份
     */
    @TableField("china_data")
    private String chinaData;

    /**
     * 图片数量
     */
    private Integer picno;

    /**
     * 事件内容
     */
    private String content;

    /**
     * 创建时间
     */
    @TableField("crate_time")
    private Date crateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getChinaData() {
        return chinaData;
    }

    public void setChinaData(String chinaData) {
        this.chinaData = chinaData;
    }
    public Integer getPicno() {
        return picno;
    }

    public void setPicno(Integer picno) {
        this.picno = picno;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "DataHistoryToday{" +
        "id=" + id +
        ", year=" + year +
        ", month=" + month +
        ", day=" + day +
        ", title=" + title +
        ", chinaData=" + chinaData +
        ", picno=" + picno +
        ", content=" + content +
        ", crateTime=" + crateTime +
        "}";
    }
}
