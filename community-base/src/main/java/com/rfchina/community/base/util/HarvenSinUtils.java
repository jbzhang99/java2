package com.rfchina.community.base.util;

import javafx.util.Pair;

/**
 * @ClassName HarvenSinUtils
 * @Description 计算两点之间距离
 * @Author wlrllr
 * @Date 2019/4/22 11:07
 * @Version 1.0
 **/
public class HarvenSinUtils {

    static final double EARTH_RADIUS = 6371393;//m

    public static double distance(Pair<Double,Double> from, Pair<Double,Double> to)
    {
        return distance(from.getKey(),from.getValue(),to.getKey(),to.getValue());
    }

    public static double distance(String lat1,String lon1, String lat2,String lon2)
    {
        return distance(Double.valueOf(lat1),Double.valueOf(lon1),Double.valueOf(lat2),Double.valueOf(lon2));
    }

    public static double distance(double lat1,double lon1, double lat2,double lon2)
    {
        //用haversine公式计算球面两点间的距离。
        //经纬度转换成弧度
        lat1 = degreesToRadians(lat1);
        lon1 = degreesToRadians(lon1);
        lat2 = degreesToRadians(lat2);
        lon2 = degreesToRadians(lon2);
        double vLon = Math.abs(lon1 - lon2);
        double vLat = Math.abs(lat1 - lat2);

        double h = harvenSin(vLat) + Math.cos(lat1) * Math.cos(lat2) * harvenSin(vLon);

        double distance = 2 * EARTH_RADIUS * Math.asin(Math.sqrt(h));
        return distance;
    }

    /**
     * @Author wlrllr
     * @Description //角度转换成弧度
     * @Date 2019/4/22
     * @Param [degree]
     * @return java.lang.Double
     **/
    public static Double degreesToRadians(Double degree){
        return degree *Math.PI / 180;
    }

    public static double radiansToDegrees(Double radian)
    {
        return radian * 180.0 / Math.PI;
    }

    public static double harvenSin(double theta)
    {
        double v = Math.sin(theta / 2);
        return v * v;
    }
}
