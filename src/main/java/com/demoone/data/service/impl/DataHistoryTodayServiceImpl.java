package com.demoone.data.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.demoone.data.dto.DtoHistoryToday;
import com.demoone.data.entity.DataHistoryToday;
import com.demoone.data.mapper.DataHistoryTodayDao;
import com.demoone.data.service.IDataFilePicService;
import com.demoone.data.service.IDataHistoryTodayService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.demoone.utils.http.HttpRequest;
import com.demoone.utils.string.StringUtils;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 历史上的今天数据 服务实现类
 * </p>
 *
 * @author hq
 * @since 2019-06-14
 */
@Service
public class DataHistoryTodayServiceImpl extends ServiceImpl<DataHistoryTodayDao, DataHistoryToday> implements IDataHistoryTodayService {

	@Autowired
	private IDataFilePicService iDataFilePicService;

	@Override
	public String GradeHistoryTodayDate() {
		return null;
	}


	DtoHistoryToday getDate(Integer month, Integer day){
		//删除所有旧数据
		delete(new EntityWrapper<>());
		iDataFilePicService.delete(new EntityWrapper<>());
		String str = "";
		Map map = new HashMap();
		map.put("key","8c8bca8cb5bf6eb31f871cb1b6f1993a");
		map.put("date",month+"/"+day);
		try {
			str = HttpRequest.net("http://v.juhe.cn/todayOnhistory/queryEvent.php",map,"GET");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!StringUtils.isBlank(str)){
			JSONObject res = JSON.parseObject(str);
			if (res.getInteger("error_code")==0){
				JSONArray result= res.getJSONArray("result");
				if (result!=null && result.size()>0){
					for (Object item : result) {
						JSONObject ite = (JSONObject) item;
						String data = ite.getString("date");
						DataHistoryToday dataHistoryToday = new DataHistoryToday();
						dataHistoryToday.setId(Integer.parseInt(ite.getString("e_id")));
						dataHistoryToday.setTitle(ite.getString("title"));
						dataHistoryToday.setChinaData(data);
						dataHistoryToday.setMonth(month);
						dataHistoryToday.setDay(day);
						data = data.replace("年"+month+"月"+day+"日","");
						if(data.indexOf("前")>-1){
							data = data.replace("前","");
							dataHistoryToday.setYear(-Integer.parseInt(data.trim()));
						}else {
							dataHistoryToday.setYear(Integer.parseInt(data.trim()));
						}
						map.put("e_id",ite.getString("e_id"));
						try {
							str = HttpRequest.net("http://v.juhe.cn/todayOnhistory/queryDetail.php",map,"GET");
						} catch (IOException e) {
							e.printStackTrace();
						}
						if (!StringUtils.isBlank(str)){
							JSONObject detail = JSON.parseObject(str);
							if (detail.getInteger("error_code")==0){
								dataHistoryToday.setContent(detail.getString(""));
							}
						}
					}
				}
			}
		}
		return null;
	}
}
