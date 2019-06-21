package com.demoone.common.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.demoone.common.entity.CommonArea;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 省市区编码表 Mapper 接口
 * </p>
 */
public interface CommonAreaDao extends BaseMapper<CommonArea> {

	Long queryIdByArea(@Param("name") String name);

	List<String> getNameById(@Param("list") List<String> list);

	@Select("SELECT * FROM common_area WHERE name LIKE '${name}%' limit 1")
	CommonArea getOne(@Param("name")String name);

	@Select("SELECT * FROM common_area WHERE id = #{id} limit 1")
	CommonArea getOneById(@Param("id") String id);
}
