package com.demoone.data.dto;

import com.demoone.data.entity.DataFilePic;
import com.demoone.data.entity.DataHistoryToday;
import lombok.Data;

import java.util.List;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/06/14 10:45
 */
@Data
public class DtoHistoryToday {

	List<DataHistoryToday> dataHistoryTodayList;

	List<DataFilePic> dataFilePicList;
}
