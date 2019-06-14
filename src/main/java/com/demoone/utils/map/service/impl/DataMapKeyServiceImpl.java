package com.demoone.utils.map.service.impl;

import com.demoone.utils.DateUtils;
import com.demoone.utils.map.entity.DataMapKey;
import com.demoone.utils.map.mapper.DataMapKeyDao;
import com.demoone.utils.map.service.IDataMapKeyService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.demoone.utils.string.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 地图key 服务实现类
 * </p>
 *
 * @author yatao.zhang
 * @since 2019-03-26
 */
@Service
public class DataMapKeyServiceImpl extends ServiceImpl<DataMapKeyDao, DataMapKey> implements IDataMapKeyService {

	@Override
	public String getKey(String type) {
		String key = "";
		DataMapKey dataMapKey = baseMapper.getKey(type,DateUtils.getDate());
		if (dataMapKey!=null){
			key = dataMapKey.getKey();
			dataMapKey.setUseTime(new Date());
			dataMapKey.setModifyTime(new Date());
			updateById(dataMapKey);
		}
		return key;
	}

	@Override
	public int insertKey(String key, String type) {
		int count=0;
		String [] keys=  key.split(",");
		for (String key1 : keys){
			DataMapKey dataMapKey = new DataMapKey();
			dataMapKey.setKey(key1);
			dataMapKey.setType(type);
			dataMapKey.setModifyTime(new Date());
			dataMapKey.setCreateTime(new Date());
			if (!StringUtils.isBlank(key1)){
				insert(dataMapKey);
				++count;
			}
		}
		return count;
	}
}
