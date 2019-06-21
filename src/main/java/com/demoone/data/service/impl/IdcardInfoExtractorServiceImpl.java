package com.demoone.data.service.impl;

import com.demoone.common.entity.CommonArea;
import com.demoone.common.service.ICommonAreaService;
import com.demoone.data.entity.IdcardInfoExtractor;
import com.demoone.data.service.IIdcardInfoExtractorService;
import com.demoone.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/06/20 11:20
 */
@Service
public class IdcardInfoExtractorServiceImpl implements IIdcardInfoExtractorService {

	@Autowired
	private ICommonAreaService iCommonAreaService;

	@Override
	public IdcardInfoExtractor getIdcardInfoExtractor(String code) {
		IdcardInfoExtractor idcardInfoExtractor = new IdcardInfoExtractor();
		idcardInfoExtractor.setCode(code);
		if (code.length()==18){
			CommonArea area = iCommonAreaService.getOneById(code.substring(0,2)+"0000");
			if (area!=null){
				idcardInfoExtractor.setProvince(area.getName());
			}
			area = iCommonAreaService.getOneById(code.substring(0,4)+"00");
			if (area!=null){
				idcardInfoExtractor.setCity(area.getName());
			}
			area = iCommonAreaService.getOneById(code.substring(0,6));
			if (area!=null){
				idcardInfoExtractor.setRegion(area.getName());
				idcardInfoExtractor.setProcode(area.getProcode());
				idcardInfoExtractor.setLng(area.getLng());
				idcardInfoExtractor.setLat(area.getLat());
			}
			Date data = DateUtils.getDateFromString1(code.substring(6,14),"yyyyMMdd");
			idcardInfoExtractor.setAge((int)DateUtils.pastDays(data)/365);
			idcardInfoExtractor.setBirthday(DateUtils.formatDate(data,"yyyy年MM月dd日"));
			String lastOne = code.substring(16,17);
			if (Integer.parseInt(lastOne)%2>0){
				idcardInfoExtractor.setGender("男");
			}else {
				idcardInfoExtractor.setGender("女");
			}
		}
		return idcardInfoExtractor;
	}
}
