/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights
 * reserved.
 */
package com.ibm.mosesboot.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 *
 * @author ThinkGem
 * @version 2014-4-15
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    private static String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd HH:mm", "yyyy-MM", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
            "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if ((pattern != null) && (pattern.length > 0)) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    public static String getLastYear() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR) - 1;
        return year + "";
    }

    public static Date getDateFromStr(String dateStr, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 几个月前的第一天
     *
     * @param num
     * @return
     * @Title: getLastMonth
     * @author fuchangmin@fang.com
     * @Description: TODO(功能)
     */
    public static String getLastMonth(int num) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1 - num);
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM");
        String lastMonth = dft.format(cal.getTime());
        return lastMonth + "-01";
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy.MM.dd",
     * "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取过去的小时
     *
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    /**
     * 获取过去的分钟
     *
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 1000);
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）
     *
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = ((timeMillis / (60 * 60 * 1000)) - (day * 24));
        long min = ((timeMillis / (60 * 1000)) - (day * 24 * 60) - (hour * 60));
        long s = ((timeMillis / 1000) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (min * 60));
        long sss = (timeMillis - (day * 24 * 60 * 60 * 1000) - (hour * 60 * 60 * 1000)
                - (min * 60 * 1000) - (s * 1000));
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }

    static GregorianCalendar gc = new GregorianCalendar();

    /**
     * 年加减
     *
     * @param date
     * @param i
     * @return
     */
    public static String getYears(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, i);
        return formatDate(calendar.getTime());
    }

    /**
     * 月加减
     *
     * @param date
     * @param i
     * @return
     */
    public static String getMonth(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, i);
        return formatDate(calendar.getTime());
    }

    /**
     * 得到月份第一天
     *
     * @param date
     * @return
     */
    public static String getMonthFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return formatDate(calendar.getTime());
    }

    /**
     * 得到月份最后一天
     *
     * @return
     */
    public static String getMonthLastDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return formatDate(calendar.getTime());
    }

    /**
     * 根据开始时间和结束时间返回时间段内的时间集合
     *
     * @param beginDate
     * @param endDate
     * @return List
     */
    public static List<Date> getDatesBetweenTwoDate(Date beginDate, Date endDate) {
        List<Date> lDate = new ArrayList<Date>();
        lDate.add(beginDate);// 把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        while (bContinue) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                lDate.add(cal.getTime());
            } else {
                break;
            }
        }
        lDate.add(endDate);// 把结束时间加入集合
        return lDate;
    }

    public static List<Date> getYearsBetweenTwoDate(Date beginDate, Date endDate) {
        List<Date> lDate = new ArrayList<Date>();
        lDate.add(beginDate);// 把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        while (bContinue) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.YEAR, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                lDate.add(cal.getTime());
            } else {
                break;
            }
        }
        lDate.add(endDate);// 把结束时间加入集合
        return lDate;
    }

    public static Date getFirstDayOfMonthAfterOneMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        return null;
    }

    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws Exception {
        String start = "2016-09-01";
        String end = "2017-10-30";
        Date dBegin = parseDate(start);
        Date dEnd = parseDate(end);
        List<Date> listDate = getDatesBetweenTwoDate(dBegin, dEnd);
        for (int i = 0; i < listDate.size() - 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.println("当前日期" + DateUtils.formatDate(listDate.get(i + j), "yyyy-MM"));
            }
            System.out.println("赋值日期" + DateUtils.formatDate(listDate.get(i + 5), "yyyy-MM"));
        }
    }
}
