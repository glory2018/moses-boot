/**
 * <p>
 * <br>项目:CodeStyle
 * <br>文件名:DateUtil.java
 * <br>包名:com.steve.util
 * <br>创建日期:2016年1月18日上午9:55:40
 * <br>网址：http://www.founderinternational.com/
 * <br>方正国际软件有限公司 Founder International Co.,Ltd. All rights reserved
 * <br>版权所有
 * </p>
 */
package com.ibm.mosesboot.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <p>
 * <br>
 * 标题： <br>
 * 描述： <br>
 * 作者： 范少荣 <br>
 * 修改日期：2016年1月18日上午9:55:40 <br>
 * 修改历史： <br>
 * 版本：1.0
 * </p>
 */
public class DateUtil {
    public static final String DATE_FULL = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_YEAR = "yyyy";
    public static final String DATE_MONTH = "yyyy-MM";
    public static final String DATE_DAY = "yyyy-MM-dd";

    public static Date addDate(Date d, int dayOffset) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(d);
        gc.add(5, dayOffset);
        return gc.getTime();
    }

    public static String getDate(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    public static String getDate(String format) {
        return getDate(new Date(), format);
    }

    public static String getDate() {
        SimpleDateFormat df = new SimpleDateFormat(DATE_DAY);
        return df.format(new Date());
    }

    public static String getYear() {
        return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    }

    private static String valueOfString(String str, int len) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len - str.length(); i++)
            sb.append("0");
        return sb.length() != 0 ? (new StringBuilder(String.valueOf(sb
                .toString()))).append(str).toString() : str;
    }

    public static String getDateFormat() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    public static String getDayFormat() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }

    public static Date getDateFormat(String time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return df.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getTimeString(Calendar calendar) {
        StringBuffer sb = new StringBuffer();
        sb.append(String.valueOf(calendar.get(1)))
                .append(valueOfString(String.valueOf(calendar.get(2) + 1), 2))
                .append(valueOfString(String.valueOf(calendar.get(5)), 2))
                .append(valueOfString(String.valueOf(calendar.get(11)), 2))
                .append(valueOfString(String.valueOf(calendar.get(12)), 2))
                .append(valueOfString(String.valueOf(calendar.get(13)), 2))
                .append(valueOfString(String.valueOf(calendar.get(14)), 3));
        return sb.toString();
    }

    public static String getTimeString(String time) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(getDateFormat(time));
        return getTimeString(calendar);
    }

    public static String getTimeString() {
        Calendar calendar = new GregorianCalendar();
        return getTimeString(calendar);
    }
}
