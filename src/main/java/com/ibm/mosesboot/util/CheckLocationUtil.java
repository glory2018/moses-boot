/**
 * <p>
 * <br>项目:CodeStyle
 * <br>文件名:CheckLocationUtil.java
 * <br>包名:com.steve.util
 * <br>创建日期:2016年1月18日上午9:54:54
 * <br>网址：http://www.founderinternational.com/
 * <br>方正国际软件有限公司 Founder International Co.,Ltd. All rights reserved
 * <br>版权所有
 * </p>
 */
package com.ibm.mosesboot.util;

import java.math.BigDecimal;

/**
 * <p>
 * <br>
 * 标题： <br>
 * 描述： <br>
 * 作者： 范少荣 <br>
 * 修改日期：2016年1月18日上午9:54:54 <br>
 * 修改历史： <br>
 * 版本：1.0
 * </p>
 */
public class CheckLocationUtil {
    public static boolean check(double x, double y, String point) {
        boolean is = false;
        String arr[] = point.split(",");
        for (int i = 0; i < arr.length - 4; i += 4) {
            Double x1 = Double.valueOf(Double.parseDouble(arr[i]));
            Double y1 = Double.valueOf(Double.parseDouble(arr[i + 1]));
            Double x2 = Double.valueOf(Double.parseDouble(arr[i + 2]));
            Double y2 = Double.valueOf(Double.parseDouble(arr[i + 3]));
            if (isEqual(x1, x2) && isBetween(y1, y, y2) && isOffsetX(x1, x)
                    || isEqual(y1, y2) && isBetween(x1, x, x2)
                    && isOffsetY(y1, y))
                is = true;
        }
        return is;
    }

    public static String distanceGeo(double x, double y, String point) {
        String is = "";
        String arr[] = point.split(",");
        for (int i = 0; i < arr.length - 4; i += 4) {
            Double x1 = Double.valueOf(Double.parseDouble(arr[i]));
            Double y1 = Double.valueOf(Double.parseDouble(arr[i + 1]));
            Double x2 = Double.valueOf(Double.parseDouble(arr[i + 2]));
            Double y2 = Double.valueOf(Double.parseDouble(arr[i + 3]));
            if ((isOffsetX(x1, x) || isOffsetX(x2, x))
                    && (isOffsetY(y1, y) || isOffsetY(y2, y)))
                is = (new StringBuilder()).append(x1).append(",").append(y1)
                        .toString();
        }
        return is;
    }

    private static boolean isOffsetX(Double d1, double d2) {
        boolean isOffset = false;
        Double off = Double.valueOf(d1.doubleValue() - d2);
        if (CEPY * -1D < off.doubleValue() && off.doubleValue() < CEPY)
            isOffset = true;
        return isOffset;
    }

    private static boolean isOffsetY(Double d1, double d2) {
        boolean isOffset = false;
        Double off = Double.valueOf(d1.doubleValue() - d2);
        if (CEPY * -1D < off.doubleValue() && off.doubleValue() < CEPY)
            isOffset = true;
        return isOffset;
    }

    private static boolean isBetween(Double d1, double d, Double d2) {
        BigDecimal data1 = new BigDecimal(d1.doubleValue());
        BigDecimal data = new BigDecimal(d);
        BigDecimal data2 = new BigDecimal(d2.doubleValue());
        boolean desc = false;
        if (data1.compareTo(data) == 0 || data2.compareTo(data) == 0
                || data1.compareTo(data) == 1 && data2.compareTo(data) == -1
                || data1.compareTo(data) == -1 && data2.compareTo(data) == 1)
            desc = true;
        return desc;
    }

    public static boolean isEqual(Double d1, Double d2) {
        BigDecimal data1 = new BigDecimal(d1.doubleValue());
        BigDecimal data2 = new BigDecimal(d2.doubleValue());
        boolean equal = false;
        if (data1.compareTo(data2) == 0)
            equal = true;
        return equal;
    }

    public static boolean isGt(Double d1, Double d2) {
        BigDecimal data1 = new BigDecimal(d1.doubleValue());
        BigDecimal data2 = new BigDecimal(d2.doubleValue());
        boolean d1Big = false;
        if (data1.compareTo(data2) == 1)
            d1Big = true;
        return d1Big;
    }

    private static double CEPX = 0.00029999999999999997D;
    private static double CEPY = 3.0000000000000001E-005D;
}
