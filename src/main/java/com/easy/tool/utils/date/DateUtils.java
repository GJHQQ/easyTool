package com.easy.tool.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 高俊
 * @create 2021-08-2021/8/27-9:58
 */
public class DateUtils {

    /**
     * 格式化时间
     * @param date  需要格式化的时间
     * @param format    格式类型。例如：YYYY-MM-dd HH:mm:ss
     * @return String类型time
     */
    public static String dateFormat(Date date , String format){
        SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
        return simpleFormat.format(date);
    }

    /**
     * 字符串格式转时间对象
     * @param timeStr   字符串时间
     * @param format    格式
     * @return  时间对象
     */
    public static Date stringTimeToDate(String timeStr, String format){
        SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = simpleFormat.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取当前月份第一天/最后一天
     * @param type 0：第一天；1：最后一天
     * @return
     */
    public static Date getFirstDayOfMonth(Integer type){
        if (type == null){
            return null;
        }
        Calendar instance = Calendar.getInstance();
        if (type == 0){
            instance.set(Calendar.DAY_OF_MONTH,1);
        }else if (type == 1){
            int lastday = instance.getMaximum(Calendar.DAY_OF_MONTH);
            instance.set(Calendar.DATE,lastday);
        }
        return instance.getTime();
    }

    /**
     * 比较时间大小
     * @param date1 时间1
     * @param date2 时间2
     * @return  -1：date1<date2；1：date1 > date2
     */
    public static int dateCompare(Date date1,Date date2){
        long time = date1.getTime();
        long time1 = date2.getTime();
        if (time<time1){
            return -1;
        }
        return 1;
    }

    /**
     * 时间差
     * @param date1
     * @param date2
     * @return 毫秒值
     */
    public static Long differTime(Date date1,Date date2){
        long time = date1.getTime();
        long time1 = date2.getTime();
        if (time<time1){
            return time1-time;
        }
        return time-time1;
    }

    /**
     * 获取指定月份第一天/最后一天
     * @param month 指定月份 1~12
     * @param type  0：第一天；1：最后一天
     * @return Date类型时间
     */
    public static Date appointDayOfMonth(int month,Integer type){
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.MONTH,month-1);
        if (type == 0){
            instance.set(Calendar.DAY_OF_MONTH, 1);
        }else if (type == 1){
            int lastday = instance.getMaximum(Calendar.DAY_OF_MONTH);
            instance.set(Calendar.DATE,lastday);
        }
        return instance.getTime();
    }
}
