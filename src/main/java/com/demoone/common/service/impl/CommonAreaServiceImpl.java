package com.demoone.common.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.demoone.common.entity.CommonArea;
import com.demoone.common.mapper.CommonAreaDao;
import com.demoone.common.service.ICommonAreaService;
import com.demoone.utils.Pinyin4jUtil;
import com.demoone.utils.map.District;
import com.demoone.utils.map.MapUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 省市区编码表 服务实现类
 * </p>
 */
@Service
@Slf4j
public class CommonAreaServiceImpl extends ServiceImpl<CommonAreaDao, CommonArea> implements ICommonAreaService {
    @Autowired
    MapUtil mapUtil;

    int nums = 0;

    public boolean updateInfo(Long pid,District district ) {

        //删除下级
        CommonArea commonArea = new CommonArea();
        commonArea.setPid(Long.parseLong(district.getAdcode()));
        Wrapper<CommonArea> ew = new EntityWrapper<>(commonArea);
        commonArea.delete(ew);

        //更新下级
        for (District one:district.getDistricts()) {
            updateInfo(Long.parseLong(district.getAdcode()),one);
        }

        //更新自己
        double lng = 0;
        double lat = 0;
        String[] sa=district.getCenter().split(",");
        if   (sa.length > 1) {
            lng = Double.valueOf(sa[0]); // 经度
            lat = Double.valueOf(sa[1]); // 纬度
        }

        commonArea = new CommonArea();
        commonArea.setName(district.getName());
        commonArea.setId(Long.parseLong(district.getAdcode()));
        ew = new EntityWrapper<>(commonArea);
        CommonArea record = commonArea.selectOne(ew);
        if (record ==null){
            commonArea.setPid(pid);
            commonArea.setProcode(district.getCitycode());
            commonArea.setLng(lng);
            commonArea.setLat(lat);
            commonArea.setNamepinyin(Pinyin4jUtil.getHeadStr(district.getName()));
            try {
                commonArea.insert();
            }catch (Exception e){
                log.info(e.toString());
            }
        }else{
            record.setProcode(district.getCitycode());
            record.setPid(pid);
            record.setLng(lng);
            record.setLat(lat);
            record.setNamepinyin(Pinyin4jUtil.getHeadStr(district.getName()));
            record.updateById();
        }
        nums ++;
        return  true;
    }

    @Override
    public String updateInfo(String province) {
        District district = mapUtil.getdistrict(province);
        if (district != null){
            updateInfo(100000L,district);
        }
        return "Ok nums="+ nums;
    }


    public void getChild(Integer nowLevel, Integer level, CommonArea area) {
            List<CommonArea> list = getRecordsByByPid(area.getId());
            area.setChild(list);
            nowLevel ++ ;
            if (nowLevel <= level) {
                if (list != null && list.size() > 0) {
                    for (CommonArea record : list) {
                        getChild(nowLevel, level, record);
                    }
                }
            }
    }
    @Override
    public CommonArea getall(Integer level) {
        CommonArea area  = selectById(100000L);
        Integer nowLevel = 0;
        getChild(nowLevel,level,area);
        return area;
    }

	@Override
	public List<String> getNameById(List<String> list) {
    	if (list==null || list.size()<1){
			return null;
		}
		return baseMapper.getNameById(list);
	}

	@Override
	public CommonArea getOne(String name) {
		return baseMapper.getOne(name);
	}

	public List<CommonArea> getRecordsByByPid(Long pid) {
        CommonArea commonArea = new CommonArea();
        commonArea.setPid(pid);
        Wrapper<CommonArea> ew = new EntityWrapper<>(commonArea);
        ew.orderBy("namepinyin");
        return selectList(ew);
    }

}
