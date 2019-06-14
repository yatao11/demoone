package com.demoone.utils.map;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.List;

public class BaiduMapUtil extends MapUtil {

    public BaiduMapUtil(String ak) {
        super(ak);
        if (ak == null){
            this.AK = "GUkgzM3wawFkQK69KYUUTqW7NgnNhDn5";
        }
    }

    // 调用百度地图API根据地址，获取坐标
    public  String getCoordinate(String address) {
        if (address != null && !"".equals(address)) {
            address = address.replaceAll("\\s*", "").replace("#", "栋");
            String url = "http://api.map.baidu.com/geocoder/v2/?address=" + address + "&output=json&ak=" + AK;
            String json = loadJSON(url);
            if (json != null && !"".equals(json)) {
                JSONObject obj = JSONObject.parseObject(json);
                if ("0".equals(obj.getString("status"))) {
                    double lng = obj.getJSONObject("result").getJSONObject("location").getDouble("lng"); // 经度
                    double lat = obj.getJSONObject("result").getJSONObject("location").getDouble("lat"); // 纬度
                    DecimalFormat df = new DecimalFormat("#.######");
                    return df.format(lng) + "," + df.format(lat);
                }
            }
        }
        return null;
    }

    // 调用百度地图API根据地址，获取坐标
    public int getCoordinate(String address,Point2d point,String city) {
        if (address != null && !"".equals(address)) {
            address = address.replaceAll("\\s*", "").replace("#", "栋");
            String url = null;
            url = "http://api.map.baidu.com/geocoder/v2/?address=" + address + "&output=json&ak=" + AK;  //百度
            String json = loadJSON(url);
            if (json != null && !"".equals(json)) {
                JSONObject obj = JSONObject.parseObject(json);
                if ("0".equals(obj.getString("status"))) {
                    double lng = obj.getJSONObject("result").getJSONObject("location").getDouble("lng"); // 经度
                    double lat = obj.getJSONObject("result").getJSONObject("location").getDouble("lat"); // 纬度
                    point.setLng(lng);
                    point.setLat(lat);
                    return 1;
                }
            }
        }
        return 0;
    }
}
