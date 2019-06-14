package com.demoone.utils.map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="经纬度实体类")
public class Point2d {
	@ApiModelProperty("经度 ")
    public double lng;
	@ApiModelProperty("经度 ")
    public double lat;
    public String  city;
    public String  district;
	public String province;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Point2d() {}
    public Point2d(double lng, double lat) { super(); this.lng = lng; this.lat = lat; }

    public Double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
