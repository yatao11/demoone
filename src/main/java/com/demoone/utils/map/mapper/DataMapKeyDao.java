package com.demoone.utils.map.mapper;

import com.demoone.utils.map.entity.DataMapKey;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 地图key Mapper 接口
 * </p>
 *
 * @author yatao.zhang
 * @since 2019-03-26
 */
public interface DataMapKeyDao extends BaseMapper<DataMapKey> {

	DataMapKey getKey(@Param("type") String type, @Param("date") String date);
}
