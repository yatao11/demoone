package com.demoone.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.otter.node.extend.processor.AbstractEventProcessor;
import com.alibaba.otter.shared.etl.model.EventColumn;
import com.alibaba.otter.shared.etl.model.EventData;
import org.apache.commons.lang.time.DateFormatUtils;

import java.sql.Types;
import java.util.Date;
import java.util.List;

public class TestEventProcessor1 extends AbstractEventProcessor {
	public boolean process(EventData eventData) {
		boolean b = false;
		System.out.println(JSON.toJSONString(eventData).toString());
		if(eventData.getTableName().equals("start") && eventData.getColumns()!=null && eventData.getColumns().size()>0){
			EventColumn eventColumn = getColumn(eventData , "name");
			if("2".equals(eventColumn.getColumnValue())){
				b =  true;
				List<EventColumn> columnList = eventData.getColumns();
				EventColumn credate = new EventColumn();
				credate.setColumnType(Types.DATE);
				credate.setColumnName("credate");
				credate.setColumnValue(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
				columnList.add(credate);
				eventData.setColumns(columnList);
				System.out.println("进来了 b====="+b);
			}else {
				System.out.println("没有进来 b====="+b);
			}
		}
		return b;
	}
}