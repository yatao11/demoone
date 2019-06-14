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

public class MapUtil {

    protected String AK = "GUkgzM3wawFkQK69KYUUTqW7NgnNhDn5"; // 地图密钥

    public MapUtil(String ak){
        this.AK = ak;
    }


    public  void setAk(String ak) {
        this.AK = ak;
    }

    public  String getCoordinate(String address) {
        return "";
    }

    public  int getCoordinate(String address,Point2d point,String city) {
        return 0;
    }

    public  boolean getdistrict(Point2d point) {
        return false;
    }

    /**
     * 根据省份返回市县两级
     * @param province
     * @return
     */
    public  District getdistrict(String province) {
        return null;
    }

    public  String loadJSON(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {} catch (IOException e) {}
        return json.toString();
    }


    /**
     * 判断点是否在多边形内
     * @param point 检测点
     * @param pts   多边形的顶点
     * @return      点在多边形内返回true,否则返回false
     */
    public static boolean IsPtInPoly(Point2d point, List<Point2d> pts){

        if (pts == null) return false;

        int N = pts.size();
        if (N == 0) return false;
        boolean boundOrVertex = true; //如果点位于多边形的顶点或边上，也算做点在多边形内，直接返回true
        int intersectCount = 0;//cross points count of x
        double precision = 2e-10; //浮点类型计算时候与0比较时候的容差
        Point2d p1, p2;//neighbour bound vertices
        Point2d p = point; //当前点

        p1 = pts.get(0);//left vertex
        for(int i = 1; i <= N; ++i){//check all rays
            if(p.equals(p1)){
                return boundOrVertex;//p is an vertex
            }

            p2 = pts.get(i % N);//right vertex
            if(p.lng < Math.min(p1.lng, p2.lng) || p.lng > Math.max(p1.lng, p2.lng)){//ray is outside of our interests
                p1 = p2;
                continue;//next ray left point
            }

            if(p.lng > Math.min(p1.lng, p2.lng) && p.lng < Math.max(p1.lng, p2.lng)){//ray is crossing over by the algorithm (common part of)
                if(p.lat <= Math.max(p1.lat, p2.lat)){//x is before of ray
                    if(p1.lng == p2.lng && p.lat >= Math.min(p1.lat, p2.lat)){//overlies on a horizontal ray
                        return boundOrVertex;
                    }

                    if(p1.lat == p2.lat){//ray is vertical
                        if(p1.lat == p.lat){//overlies on a vertical ray
                            return boundOrVertex;
                        }else{//before ray
                            ++intersectCount;
                        }
                    }else{//cross point on the left side
                        double xinters = (p.lng - p1.lng) * (p2.lat - p1.lat) / (p2.lng - p1.lng) + p1.lat;//cross point of y
                        if(Math.abs(p.lat - xinters) < precision){//overlies on a ray
                            return boundOrVertex;
                        }

                        if(p.lat < xinters){//before ray
                            ++intersectCount;
                        }
                    }
                }
            }else{//special case when ray is crossing through the vertex
                if(p.lng == p2.lng && p.lat <= p2.lat){//p crossing over p2
                    Point2d p3 = pts.get((i+1) % N); //next vertex
                    if(p.lng >= Math.min(p1.lng, p3.lng) && p.lng <= Math.max(p1.lng, p3.lng)){//p.lng lies between p1.lng & p3.lng
                        ++intersectCount;
                    }else{
                        intersectCount += 2;
                    }
                }
            }
            p1 = p2;//next ray left point
        }

        if(intersectCount % 2 == 0){//偶数在多边形外
            return false;
        } else { //奇数在多边形内
            return true;
        }

    }

}
