package com.demoone.utils.map.service;

import com.demoone.utils.map.entity.DataMapKey;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 地图key 服务类
 * </p>
 *
 * @author yatao.zhang
 * @since 2019-03-26
 */
public interface IDataMapKeyService extends IService<DataMapKey> {

	String getKey(String type);

	int insertKey(String key, String type);
}
