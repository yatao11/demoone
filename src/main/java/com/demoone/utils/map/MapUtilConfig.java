package com.demoone.utils.map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapUtilConfig {

    @Value("${demoone.map.type}")
    private String type;

    @Value("${demoone.map.key}")
    private String key;

    @Bean
    public MapUtil mapUtil() {
        MapUtil mapUtil = null;
        if ("baidu".equals(type)){
            mapUtil = new BaiduMapUtil(key);
        }else if ("gaode".equals(type)){
            mapUtil = new GaoDeMapUtil(key);
        }else{
            mapUtil = new GaoDeMapUtil(key);
        }
        return mapUtil;
    }

}
