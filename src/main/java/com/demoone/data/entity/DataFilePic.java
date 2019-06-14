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
 * 事件图片表
 * </p>
 *
 * @author hq
 * @since 2019-06-14
 */
@TableName("data_file_pic")
public class DataFilePic extends Model<DataFilePic> {

    private static final long serialVersionUID = 1L;

    /**
     * 图片id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 图片标题
     */
    private String title;

    private String url;

    @TableField("event_id")
    private Integer eventId;

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
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
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
        return "DataFilePic{" +
        "id=" + id +
        ", title=" + title +
        ", url=" + url +
        ", eventId=" + eventId +
        ", crateTime=" + crateTime +
        "}";
    }
}
