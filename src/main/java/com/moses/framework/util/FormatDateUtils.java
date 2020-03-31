package com.moses.framework.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <b style='color:red'>日期格式工具</b>
 * <ul>
 * <li>小时转化为时 分 秒格式
 * <li>日期转化为月 日 时：分格式
 * <li>日期去掉0
 * <li>日期加秒返回新的日期
 * </ul>
 * <p>
 * 标签定义段落
 * <p>
 * Aug 22, 2012
 *
 * @version 2.0
 * @since 1.0
 */
public class FormatDateUtils {
    /**
     * 小时转化为时、分、秒格式
     *
     * @param hour 小时
     * @return s 小时 分 秒
     * @since 1.0
     */
    public static String hour2hms(double hour) {
        int h = (int) hour;
        double d_mi = new BigDecimal(Double.toString(hour))
                .subtract(new BigDecimal(Double.toString(h)))
                .multiply(new BigDecimal(Double.toString(60))).doubleValue();
        // System.out.println(d_mi);
        int mi = (int) d_mi;
        double d_sec = new BigDecimal(Double.toString(d_mi))
                .subtract(new BigDecimal(Double.toString(mi)))
                .multiply(new BigDecimal(Double.toString(60))).doubleValue();
        // (d_mi-mi)*60;
        int sec = (int) (d_sec + 0.5);
        StringBuffer s = new StringBuffer();
        if (h != 0) {
            s.append(h).append("小时");
        }
        if (mi != 0) {
            s.append(mi).append("分");
        }
        if (sec != 0) {
            s.append(sec).append("秒");
        }
        if (h == 0 && mi == 0 && sec == 0) {
            s.append("0");
        }
        return s.toString();
    }

    /**
     * 日期转化为月 日 时：分格式
     *
     * @param dtTemp 日期
     * @return 月 日 时：分
     * @since 1.0
     */
    public static String getDate(Date dtTemp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String[] arr = sdf.format(dtTemp).split("-");
        // return replaceZero(arr[1]) + "月" + replaceZero(arr[2]) + "日"
        // + replaceZero(arr[3]) + ":" + replaceZero(arr[4]);
        return replaceZero(arr[1]) + "/" + replaceZero(arr[2]) + " "
                + replaceZero(arr[3]) + ":" + replaceZero(arr[4]);
    }

    /**
     * 日期去掉0
     *
     * @param str 0月 0日
     * @return 月 日
     * @since 1.0
     */
    public static String replaceZero(String str) {
        if (str.startsWith("0"))
            return str.substring(1);
        return str;
    }

    /**
     * 日期加秒返回新的日期
     *
     * @param dtTemp 日期
     * @param time   秒
     * @return 日期
     * @since 1.0
     */
    public static Date dtPlus(Date dtTemp, long time) {
        // 得到秒数，Date类型的getTime()返回毫秒数
        long lSysTime1 = dtTemp.getTime() / 1000;
        Date dtNew = new Date((lSysTime1 + time) * 1000);
        return dtNew;
    }

    /**
     * 获取指定日期的格式化字符串
     *
     * @param format 格式
     * @return 日期的格式化字符串
     * @since 1.0
     */
    public static String formatDate(Date dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if ("yyyy".equals(format))
            sdf = new SimpleDateFormat("yyyy-MM");
        if ("MM".equals(format))
            sdf = new SimpleDateFormat("yyyy-MM");
        if ("dd".equals(format))
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        if ("hh".equals(format))
            sdf = new SimpleDateFormat("yyyy-MM-dd hh");
        if ("HH".equals(format))
            sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        if ("mm".equals(format))
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if ("ss".equals(format))
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(dateStr);
    }

    /**
     * 字符串转换到时间格式
     *
     * @param dateStr   需要转换的字符串
     * @param formatStr 需要格式的目标字符串 举例 yyyy-MM-dd
     * @return Date 返回转换后的时间
     * @throws ParseException 转换异常
     * @since 1.0
     */
    public static Date StringToDate(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if ("yyyy".equals(format))
            sdf = new SimpleDateFormat("yyyy-MM");
        if ("MM".equals(format))
            sdf = new SimpleDateFormat("yyyy-MM");
        if ("dd".equals(format))
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        if ("hh".equals(format))
            sdf = new SimpleDateFormat("yyyy-MM-dd hh");
        if ("HH".equals(format))
            sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        if ("mm".equals(format))
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if ("ss".equals(format))
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期相减格式输出
     *
     * @param beginDate 开始日期
     * @param endDate   结束日期
     * @return 格式化String值
     * @since 1.0
     */
    public static String dateDifference(Date beginDate, Date endDate,
                                        String format) {
        long diff = (endDate.getTime() - beginDate.getTime()) / 1000;
        long day = diff / (24 * 3600);
        long hour = diff % (24 * 3600) / 3600;
        long minute = diff % 3600 / 60;
        long seconds = diff % 60;
        if ("zh-s".equals(format))
            return day + "天" + hour + "时" + minute + "分" + seconds + "秒";
        if ("day".equals(format))
            return day + "";
        return day + "";
    }

    /**
     * 获取当前月的第一天
     *
     * @return beginTime 当前月的第一天
     * @since 1.0
     */
    public static String getBeginTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
        // 当前月的第一天
        cal.set(GregorianCalendar.DAY_OF_MONTH, 1);
        Date beginDate = cal.getTime();
        // String beginTime = datef.format(beginDate) + " 00:00:00";
        return datef.format(beginDate);
    }

    /**
     * 获取当前月的最后一天
     *
     * @return endTime 当前月的最后一天
     * @since 1.0
     */
    public static String getEndTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
        // 当前月的最后一天
        cal.set(Calendar.DATE, 1);
        cal.roll(Calendar.DATE, -1);
        Date endDate = cal.getTime();
        // String endTime = datef.format(endDate) + " 23:59:59";
        return datef.format(endDate);
    }

    public static String print(Date d) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(d);
    }

    // 返回第几个月份，不是几月
    // 季度一年四季， 第一季度：2月-4月， 第二季度：5月-7月， 第三季度：8月-10月， 第四季度：11月-1月
    private static int getQuarterInMonth(int month, boolean isQuarterStart) {
        int months[] = {0, 3, 6, 9};
        if (!isQuarterStart) {
            months = new int[]{2, 5, 8, 11};
        }
        if (month >= 2 && month <= 4)
            return months[0];
        else if (month >= 5 && month <= 7)
            return months[1];
        else if (month >= 8 && month <= 10)
            return months[2];
        else
            return months[3];
    }

    public static Timestamp getCurrentTimestamp() {
        Date date = new Date();
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(date);// 将时间格式转换成符合Timestamp要求的格式.
        Timestamp goodsC_date = Timestamp.valueOf(nowTime);// 把时间转换
        return goodsC_date;
    }

    public static void main(String[] args) {
        Timestamp s = getCurrentTimestamp();
        System.out.println();
        try {
            // Calendar calendar = new GregorianCalendar();
            // // 1. 当前登陆日期的周一至周五的日期 比如 现在是2012-06-11 周一是2012-06-11 周五就是
            // 2012-06-15。
            // calendar.set(Calendar.DAY_OF_WEEK, 2);
            // System.out.println("登录日期的周一：" + print(calendar.getTime()));
            // // 2.星期五，第六天s
            // calendar.set(Calendar.DAY_OF_WEEK, 6);
            // System.out.println("登录日期的周五：" + print(calendar.getTime()));
            // // 3.当前月的第一天
            // calendar.set(Calendar.DAY_OF_MONTH, 1);
            // System.out.println("当前月的第一天：" + print(calendar.getTime()));
            // // 4.当前月的最后一天
            // calendar.add(Calendar.MONTH, 1);
            // calendar.set(Calendar.DAY_OF_MONTH, 0);
            // System.out.println("当前月的最后一天：" + print(calendar.getTime()));
            //
            // // 季度初
            // calendar.setTime(new Date());
            // int month = getQuarterInMonth(calendar.get(Calendar.MONTH),
            // true);
            // calendar.set(Calendar.MONTH, month);
            // calendar.set(Calendar.DAY_OF_MONTH, 1);
            // System.out.println("当季度的第一天：" + print(calendar.getTime()));
            // // 季度末
            // calendar.setTime(new Date());
            // month = getQuarterInMonth(calendar.get(Calendar.MONTH), false);
            // calendar.set(Calendar.MONTH, month + 1);
            // calendar.set(Calendar.DAY_OF_MONTH, 0);
            // System.out.println("当前时间的季度末：" + print(calendar.getTime()));
            // Date date=new Date();
            // System.out.println(date);
            Date date1 = StringToDate("2013-01-01 12:00", "yyyy-MM-dd");
            Date date2 = StringToDate("2013-01-02 10:01", "yyyy-MM-dd");
            System.out.println(dateDifference(date1, date2, "zh-s"));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
