package com.demoone.data.service;

import com.demoone.data.entity.DataHistoryToday;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 历史上的今天数据 服务类
 * </p>
 *
 * @author hq
 * @since 2019-06-14
 */
public interface IDataHistoryTodayService extends IService<DataHistoryToday> {

	String GradeHistoryTodayDate();
}
