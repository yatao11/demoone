package com.demoone.common.service;

import com.baomidou.mybatisplus.service.IService;
import com.demoone.common.entity.CommonArea;

import java.util.List;

/**
 * <p>
 * 省市区编码表 服务类
 * </p>
 */
public interface ICommonAreaService extends IService<CommonArea> {
	String updateInfo(String province);
	CommonArea getall(Integer level);

    List<String> getNameById(List<String> list);

	CommonArea getOne(String name);

}
