/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.documents.util.DateUtil
 * @version V1.0
 */
package com.ibm.mosesboot.documents.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Moses
 * @date 2019/12/2
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
}
