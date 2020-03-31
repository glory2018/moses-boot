/**
 * <p>
 * <br>项目:CodeStyle
 * <br>文件名:DigitalProcess.java
 * <br>包名:com.steve.util
 * <br>创建日期:2016年1月18日上午9:56:34
 * <br>网址：http://www.founderinternational.com/
 * <br>方正国际软件有限公司 Founder International Co.,Ltd. All rights reserved
 * <br>版权所有
 * </p>
 */
package com.moses.framework.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * <p>
 * <br>
 * 标题： <br>
 * 描述： <br>
 * 作者： 范少荣 <br>
 * 修改日期：2016年1月18日上午9:56:34 <br>
 * 修改历史： <br>
 * 版本：1.0
 * </p>
 */
public class DigitalProcess {
    public static boolean isNull(String str) {
        return str == null || str.isEmpty();
    }

    public static int parseInt(Object param) {
        int value = 0;
        if (param instanceof Integer)
            value = ((Integer) param).intValue();
        else if (param instanceof String) {
            String str = (String) param;
            if (!isNull(str))
                value = Integer.parseInt(str);
        } else if (param instanceof BigDecimal)
            value = ((BigDecimal) param).intValue();
        return value;
    }

    public static String parseString(Object param) {
        String value = "";
        if (param instanceof String)
            value = (String) param;
        else if (param instanceof BigDecimal) {
            BigDecimal bd = (BigDecimal) param;
            value = bd.toString();
        } else if (param instanceof Timestamp) {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            value = sdf.format(param);
        }
        return value;
    }

    public static Double parseDouble(Object param) {
        double value = 0.0D;
        if (param instanceof Double)
            value = ((Double) param).doubleValue();
        else if (param instanceof String) {
            String str = (String) param;
            if (!isNull(str))
                value = Double.parseDouble(str);
        } else if (param instanceof BigDecimal)
            value = ((BigDecimal) param).doubleValue();
        return Double.valueOf(value);
    }
}
