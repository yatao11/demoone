package com.demoone.utils.map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.demoone.utils.map.service.IDataMapKeyService;
import com.demoone.utils.string.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GaoDeMapUtil  extends MapUtil{

	@Autowired
	private IDataMapKeyService iDataMapKeyService;

    // 高德应用的地址
    private static String gaodeAppID = "########";
    // 地理编码地址
    public GaoDeMapUtil(String ak) {
        super(ak);
        if (ak == null){
            this.AK = "336a69fd7fe1ad3a2637ea70e909c7f3";
        }
    }

    /**
     * 输入地址返回识别后的信息
     *
     * @param
     * @return 返回的类gaodelocation，详见类
     */
    /*
    public GaodeLocation getLocatoin(String address) {
        GaodeLocation location = null;
        if (address != null) {
            try {
                location = new GaodeLocation();
                String url = map_codeurl.replace("parameters", "");
                String params = "key=" + gaodeAppID + "&address=" + address;

				logger.info("高德地图params:" + params);
				String result = OKHttpUtil.httpPost(url, params);

				logger.info("高德地图返回结果:" + result);
				JSONObject jsonObject = JSONObject.parseObject(result);


                // 解析json
                location.setStatus(jsonObject.getString("status"));
                location.setInfo(jsonObject.getString("info"));
                location.setCount(jsonObject.getString("count"));
                List<Geocodes> geocodes = new ArrayList<>();
                JSONArray jsonArray = jsonObject.getJSONArray("geocodes");
                // 遍历解析出来的结果
                if ((jsonArray != null) && (jsonArray.size() > 0)) {
                    JSONObject jo = (JSONObject) jsonArray.get(0);
                    Geocodes go = new Geocodes();
                    go.setFormatted_address(jo.getString("formatted_address"));
                    go.setProvince(jo.getString("province"));
                    go.setCitycode(jo.getString("citycode"));
                    go.setCity(jo.getString("city"));
                    go.setDistrict(jo.getString("district"));
                    // 地址所在的乡镇
                    JSONArray ts = jo.getJSONArray("township");
                    if (ts != null && ts.size() > 0) {
                        go.setTownship(ts.getString(0));
                    }
                    // 地址编号
                    go.setAdcode(jo.getString("adcode"));
                    // 街道
                    JSONArray jd = jo.getJSONArray("street");
                    if (jd != null && jd.size() > 0) {
                        go.setStreet(jd.getString(0));
                    }
                    // 号码
                    JSONArray hm = jo.getJSONArray("number");
                    if (hm != null && hm.size() > 0) {
                        go.setStreet(hm.getString(0));
                    }
                    go.setLocation(jo.getString("location"));
                    go.setLevel(jo.getString("level"));
                    geocodes.add(go);
                }
                location.setGeocodes(geocodes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return location;
    }
    */
    public  boolean getdistrict(Point2d point) {
        String location = point.getLng() + "," + point.getLat();
        String url = "https://restapi.amap.com/v3/geocode/regeo?location=" + location + "&output=JSON&key=" + this.AK + "&poitype=&radius=1&extensions=base&batch=false&roadlevel=0";
        String json = loadJSON(url);
        if (json != null && !"".equals(json)) {
            JSONObject jsonObject = JSONObject.parseObject(json);
            String status = jsonObject.getString("status");
            String info = jsonObject.getString("info");
            jsonObject = jsonObject.getJSONObject("regeocode");
            if ((status != null) && ("1".equals(status))){
                jsonObject = jsonObject.getJSONObject("addressComponent");
                if (jsonObject != null) {
                    String city = jsonObject.getString("city");
                    String district = jsonObject.getString("district");
                    if (city != null){
                        point.setCity(city);
                    }
                    if (district != null){
                        point.setDistrict(district);
                    }
                }
            }else{
                log.info("获取错误 info= "+ info);
            }
        }else{
            log.info("loadJSON 错误！");
        }
        return false;
    }


    public  int getCoordinate(String address,Point2d point,String city) {
        if (address != null && !"".equals(address)) {
            address = address.replaceAll("\\s*", "").replace("#", "栋");
            String url = null;
            if (StringUtils.isBlank(city)) {
                url = "https://restapi.amap.com/v3/geocode/geo?address=" + address + "&output=JSON&key=" + this.AK;
            }else{
               // if (address.indexOf(city) == -1){
               //     address = city + address;
               // }
                url = "https://restapi.amap.com/v3/geocode/geo?address=" + address + "&output=JSON&key=" + this.AK + "&city=" + city;
            }
            String json = loadJSON(url);
			System.out.println(json);
			if (json != null && !"".equals(json)) {
                JSONObject jsonObject = JSONObject.parseObject(json);
                if ("DAILY_QUERY_OVER_LIMIT".equals(jsonObject.getString("info")) || "INVALID_USER_KEY".equals(jsonObject.getString("info"))
						|| "USERKEY_PLAT_NOMATCH".equals(jsonObject.getString("info")) || "USER_KEY_RECYCLED".equals(jsonObject.getString("info"))){
					String key = iDataMapKeyService.getKey("gaode");
					if ("".equals(key)){
						return -1;
					}
					setAk(key);
					json = loadJSON(url);
					if (json != null && !"".equals(json)) {
						jsonObject = JSONObject.parseObject(json);
					}else{
						log.info("loadJSON 错误！");
						return -1;
					}
				}
				if ("OK".equals(jsonObject.getString("info"))){
					GaodeLocation location = new GaodeLocation();
					// 解析json
					location.setStatus(jsonObject.getString("status"));
					location.setInfo(jsonObject.getString("info"));
					location.setCount(jsonObject.getString("count"));
					List<Geocodes> geocodes = new ArrayList<>();
					JSONArray jsonArray = jsonObject.getJSONArray("geocodes");
					// 遍历解析出来的结果
					if ((jsonArray != null) && (jsonArray.size() > 0)) {
						JSONObject jo = (JSONObject) jsonArray.get(0);
						Geocodes go = new Geocodes();
						go.setFormatted_address(jo.getString("formatted_address"));
						go.setProvince(jo.getString("province"));
						go.setCitycode(jo.getString("citycode"));
						go.setCity(jo.getString("city"));
						go.setDistrict(jo.getString("district"));
						// 地址所在的乡镇
						JSONArray ts = jo.getJSONArray("township");
						if (ts != null && ts.size() > 0) {
							go.setTownship(ts.getString(0));
						}
						// 地址编号
						go.setAdcode(jo.getString("adcode"));
                    /*
                    // 街道
                    JSONArray jd = jo.getJSONArray("street");
                    if (jd != null && jd.size() > 0) {
                        go.setStreet(jd.getString(0));
                    }
                    // 号码
                    JSONArray hm = jo.getJSONArray("number");
                    if (hm != null && hm.size() > 0) {
                        go.setStreet(hm.getString(0));
                    }
                    */
						go.setLocation(jo.getString("location"));
						go.setLevel(jo.getString("level"));
						geocodes.add(go);
					}
					location.setGeocodes(geocodes);

					if ("1".equals(location.getStatus())) {
						if ((location.getGeocodes() != null) && (location.getGeocodes().size() > 0)) {
							String[] sa=location.getGeocodes().get(0).getLocation().split(",");
							if   (sa.length > 1) {
								double lng = Double.valueOf(sa[0]); // 经度
								double lat = Double.valueOf(sa[1]); // 纬度
								point.setLng(lng);
								point.setLat(lat);
								point.setCity(location.getGeocodes().get(0).getCity());
								point.setProvince(location.getGeocodes().get(0).getProvince());
								String district = location.getGeocodes().get(0).getDistrict();
								if (StringUtils.isNotBlank(district)) {
									if (!("[]".equals(district))) {
										point.setDistrict(location.getGeocodes().get(0).getDistrict());
									}
								}
								return 1;
							}
						}
					}else{
						log.info("获取经纬度 错误！"+ location.getInfo());
						if ("DAILY_QUERY_OVER_LIMIT".equals(location.getInfo())) {
							return -1;
						}
					}
				}else {
					log.info("获取数据错误！");
					return -1;
				}

            }else{
                log.info("loadJSON 错误！");
                return -1;
            }
        }
        return 0;
    }

    public  District getdistrict(String province) {
        String url ;
        if (StringUtils.isBlank(province)){
            url = "https://restapi.amap.com/v3/config/district?keywords=" + province + "&output=JSON&key=" + this.AK + "&subdistrict=3&extensions=base";
        }else{
            url = "https://restapi.amap.com/v3/config/district?keywords=" + province + "&output=JSON&key=" + this.AK + "&subdistrict=2&extensions=base";
        }
        String json = loadJSON(url);
        if (json != null && !"".equals(json)) {
            JSONObject jsonObject = JSONObject.parseObject(json);
            String status = jsonObject.getString("status");
            String info = jsonObject.getString("info");
            if ((status != null) && ("1".equals(status))){
                JSONArray jsonArray = jsonObject.getJSONArray("districts");
                int len = jsonArray.size();
                if ((jsonArray != null) && (len > 0)) {
                    for (int i=0;i<len;i++) {
                        JSONObject jo = (JSONObject) jsonArray.get(i);
                        District district = JSON.parseObject(jo.toJSONString(), new TypeReference<District>() {
                        });
                        /*
                        if (district.getLevel().equals("province")) {
                            return district;
                        }
                        */
                        return district;
                    }
                }
            }else{
                log.info("获取区 错误 info= "+ info);
            }
        }else{
            log.info("loadJSON 错误！");
        }
        return null;
    }


    public static void main(String[] args) {
        GaoDeMapUtil gdm = new GaoDeMapUtil("8cd58e801a96c0749a22f27f4dcd35c8");
       // Point2d point = new Point2d(118.285198,33.963232);
       // gdm.getdistrict(point);
        //System.out.println(JSON.toJSONString(result));
        gdm.getdistrict("江苏");
    }
}

