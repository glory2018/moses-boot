package com.ibm.mosesboot.util;

/**
 * @author yuxuewei@fang.com
 * <p>
 * 2017-12-15
 */
public class POIDistanceUtil {
    private static final double EARTH_RADIUS = 6378137;//赤道半径

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 获取两个经维度坐标之间的距离，单位米   ***** 注意是 纬度在前！！！！
     *
     * @param lon1 //纬度1
     * @param lat1 //经度1
     * @param lon2 //纬度2
     * @param lat2 //经度2
     * @return
     */
    public static double getDistance(double lon1, double lat1, double lon2, double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        return s;//单位米
    }
}
