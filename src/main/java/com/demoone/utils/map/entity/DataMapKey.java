package com.demoone.utils.map.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 地图key
 * </p>
 *
 * @author yatao.zhang
 * @since 2019-03-26
 */
@TableName("data_map_key")
public class DataMapKey extends Model<DataMapKey> {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * gaode代表高德 baidu代表百度
     */
    private String type;

    private String key;

    /**
     * 最近一次调用时间
     */
    @TableField("use_time")
    private Date useTime;

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

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "DataMapKey{" +
        "id=" + id +
        ", type=" + type +
        ", key=" + key +
        ", useTime=" + useTime +
        ", createTime=" + createTime +
        "}";
    }
}
