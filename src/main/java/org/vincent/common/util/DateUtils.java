package org.vincent.common.util;

import org.omg.CORBA.SystemException;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * Created by PengRong on 2018/12/14.
 */
public class DateUtils {


    public static String DATE_FORMAT = "yyyy-MM-dd";

    public static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String DATE_FORMAT_CHINESE = "yyyy年M月d日";

    /**
     * 獲取日期格式為 yyyy-MM-dd 的日期Date
     *
     * @return
     */
    public static Date getFormatDate() {
        try {
            SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_FORMAT);
            String d = df.format(new Date());
            Date date = df.parse(d);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    /**
     * 获取当前日期, 字符串格式 ：yyyy-MM-dd 返回
     *
     * @return
     */
    public static String getCurrentDate() {
        String datestr = null;
        SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_FORMAT);
        datestr = df.format(new Date());
        return datestr;
    }

    /**
     * 获取当前日期时间
     *
     * @return
     */
    public static String getCurrentDateTime() {
        String datestr = null;
        SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_TIME_FORMAT);
        datestr = df.format(new Date());
        return datestr;
    }

    public static String dateToDateTime(Date date) {
        if (date == null) return null;
        String datestr = null;
        SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_TIME_FORMAT);
        datestr = df.format(date);
        return datestr;
    }

    /**
     * 将字符串日期转换为日期格式
     *
     * @param datestr
     * @return
     */
    public static Date stringToDate(String datestr) {
        if (isBlank(datestr)) return null;
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_FORMAT);
        try {
            date = df.parse(datestr);
        } catch (ParseException e) {
            date = DateUtils.stringToDate(datestr, "yyyyMMdd");
        }
        return date;
    }

    /**
     * 将字符串日期转换为日期格式 自定義格式
     *
     * @param datestr
     * @return
     */
    public static Date stringToDate(String datestr, String dateformat) {
        if (isBlank(datestr)) return null;
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat(dateformat);
        try {
            /** 严格匹配 */
            df.setLenient(false);
            date = df.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return date;
    }

    /**
     * 将日期格式日期转换为字符串格式
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        if (date == null) return null;
        String datestr = null;
        SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_FORMAT);
        datestr = df.format(date);
        return datestr;
    }

    /**
     * 将日期格式日期转换为字符串格式 自定義格式
     *
     * @param date
     * @param dateformat
     * @return
     */
    public static String dateToString(Date date, String dateformat) {
        if (date == null) return null;
        String datestr = null;
        SimpleDateFormat df = new SimpleDateFormat(dateformat);
        datestr = df.format(date);
        return datestr;
    }

    /**
     * 获取日期的DAY值
     *
     * @param date 输入日期
     * @return
     */
    public static int getDayOfDate(Date date) {
        int d = 0;
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        d = cd.get(Calendar.DAY_OF_MONTH);
        return d;
    }

    /**
     * 获取日期的当年的DAY值
     *
     * @param date 输入日期
     * @return
     */
    public static int getDayOfYear(Date date) {
        int d = 0;
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        d = cd.get(Calendar.DAY_OF_YEAR);
        return d;
    }

    /**
     * 获取日期的MONTH值
     *
     * @param date 输入日期
     * @return
     */
    public static int getMonthOfDate(Date date) {
        int m = 0;
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        m = cd.get(Calendar.MONTH) + 1;
        return m;
    }

    /**
     * 获取日期的YEAR值
     *
     * @param date 输入日期
     * @return
     */
    public static int getYearOfDate(Date date) {
        int y = 0;
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        y = cd.get(Calendar.YEAR);
        return y;
    }

    /**
     * 获取星期几
     *
     * @param date 输入日期
     * @return
     */
    public static int getWeekOfDate(Date date) {
        int wd = 0;
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        wd = cd.get(Calendar.DAY_OF_WEEK) - 1;
        return wd;
    }

    /**
     * 获取输入日期的当月第一天
     *
     * @param date 输入日期
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.set(Calendar.DAY_OF_MONTH, 1);
        return cd.getTime();
    }

    /**
     * 获得输入日期的当月最后一天
     *
     * @param date
     */
    public static Date getLastDayOfMonth(Date date) {
        return DateUtils
                .addDay(DateUtils.getFirstDayOfMonth(DateUtils.addMonth(date,
                        1)), -1);
    }


    /**
     * 判断是否是最后一天
     *
     * @param date
     * @return
     */
    public static boolean isLastDayOfMonth(Date date) {
        boolean flag = false;

        Date temp = DateUtils.getLastDayOfMonth(date);

        try {
            if (DateUtils.compare(temp, date) == 0) {
                flag = true;
            }
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }


    /**
     * 判断是否是闰年
     *
     * @param date 输入日期
     * @return 是true 否false
     */
    public static boolean isLeapYEAR(Date date) {

        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        int year = cd.get(Calendar.YEAR);

        if (year % 4 == 0 && year % 100 != 0 | year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否为指定format 日期格式字符串
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static boolean isDateFormat(String dateStr, String format) {
        boolean result = true;
        try {
            DateFormat df = new SimpleDateFormat(format);
            df.setLenient(false);
            df.parse(dateStr);
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    /**
     * 根据整型数表示的年月日，生成日期类型格式
     *
     * @param year  年
     * @param month 月
     * @param day   日
     * @return
     */
    public static Date getDateByYMD(int year, int month, int day) {
        Calendar cd = Calendar.getInstance();
        cd.set(year, month - 1, day);
        return cd.getTime();
    }

    /**
     * 获取年周期对应日
     *
     * @param date  输入日期
     * @param iyear 年数 負數表示之前
     * @return
     */
    public static Date getYearCycleOfDate(Date date, int iyear) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);

        cd.add(Calendar.YEAR, iyear);

        return cd.getTime();
    }

    /**
     * 获取月周期对应日
     *
     * @param date 输入日期
     * @param i
     * @return
     */
    public static Date getMonthCycleOfDate(Date date, int i) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);

        cd.add(Calendar.MONTH, i);

        return cd.getTime();
    }

    /**
     * 计算 fromDate 到 toDate 相差多少年
     *
     * @param fromDate
     * @param toDate
     * @return 年数
     */
    public static int getYearByMinusDate(Date fromDate, Date toDate) {
        Calendar df = Calendar.getInstance();
        df.setTime(fromDate);

        Calendar dt = Calendar.getInstance();
        dt.setTime(toDate);

        return dt.get(Calendar.YEAR) - df.get(Calendar.YEAR);
    }

    /**
     * 计算 fromDate 到 toDate 相差多少个月
     *
     * @param fromDate
     * @param toDate
     * @return 月数
     */
    public static int getMonthByMinusDate(Date fromDate, Date toDate) {
        Calendar df = Calendar.getInstance();
        df.setTime(fromDate);

        Calendar dt = Calendar.getInstance();
        dt.setTime(toDate);

        return dt.get(Calendar.YEAR) * 12 + dt.get(Calendar.MONTH)
                - (df.get(Calendar.YEAR) * 12 + df.get(Calendar.MONTH));
    }

    /**
     * 计算 fromDate 到 toDate 相差多少天
     *
     * @param fromDate
     * @param toDate
     * @return 天数
     */
    public static long getDayByMinusDate(Object fromDate, Object toDate) {

        Date f = DateUtils.chgObject(fromDate);

        Date t = DateUtils.chgObject(toDate);

        long fd = f.getTime();
        long td = t.getTime();

        return (td - fd) / (24L * 60L * 60L * 1000L);
    }

    /**
     * 计算年龄
     *
     * @param birthday 生日日期
     * @param calcDate 要计算的日期点
     * @return
     */
    public static int calcAge(Date birthday, Date calcDate) {

        int cYear = DateUtils.getYearOfDate(calcDate);
        int cMonth = DateUtils.getMonthOfDate(calcDate);
        int cDay = DateUtils.getDayOfDate(calcDate);
        int bYear = DateUtils.getYearOfDate(birthday);
        int bMonth = DateUtils.getMonthOfDate(birthday);
        int bDay = DateUtils.getDayOfDate(birthday);

        if (cMonth > bMonth || (cMonth == bMonth && cDay > bDay)) {
            return cYear - bYear;
        } else {
            return cYear - 1 - bYear;
        }
    }

    /**
     * 从身份证中获取出生日期
     *
     * @param idno 身份证号码
     * @return
     */
    public static String getBirthDayFromIDCard(String idno) {
        Calendar cd = Calendar.getInstance();
        if (idno.length() == 15) {
            cd.set(Calendar.YEAR, Integer.valueOf("19" + idno.substring(6, 8))
                    .intValue());
            cd.set(Calendar.MONTH, Integer.valueOf(idno.substring(8, 10))
                    .intValue() - 1);
            cd.set(Calendar.DAY_OF_MONTH,
                    Integer.valueOf(idno.substring(10, 12)).intValue());
        } else if (idno.length() == 18) {
            cd.set(Calendar.YEAR, Integer.valueOf(idno.substring(6, 10))
                    .intValue());
            cd.set(Calendar.MONTH, Integer.valueOf(idno.substring(10, 12))
                    .intValue() - 1);
            cd.set(Calendar.DAY_OF_MONTH,
                    Integer.valueOf(idno.substring(12, 14)).intValue());
        }
        return DateUtils.dateToString(cd.getTime());
    }

    /**
     * 在输入日期上增加（+）或减去（-）天数
     *
     * @param date 输入日期
     * @param iday 要增加或减少的天数
     */
    public static Date addDay(Date date, int iday) {
        Calendar cd = Calendar.getInstance();

        cd.setTime(date);

        cd.add(Calendar.DAY_OF_MONTH, iday);

        return cd.getTime();
    }

    /**
     * 在输入日期上增加（+）或减去（-）月份
     *
     * @param date   输入日期
     * @param imonth 要增加或减少的月分数
     */
    public static Date addMonth(Date date, int imonth) {
        Calendar cd = Calendar.getInstance();

        cd.setTime(date);

        cd.add(Calendar.MONTH, imonth);

        return cd.getTime();
    }

    /**
     * 在输入日期上增加（+）或减去（-）年份
     *
     * @param date  输入日期
     * @param iyear 要增加或减少的年数
     */
    public static Date addYear(Date date, int iyear) {
        Calendar cd = Calendar.getInstance();

        cd.setTime(date);

        cd.add(Calendar.YEAR, iyear);

        return cd.getTime();
    }

    /**
     * 將OBJECT類型轉換為Date
     *
     * @param date
     * @return
     */
    public static Date chgObject(Object date) {

        if (date != null && date instanceof Date) {
            return (Date) date;
        }

        if (date != null && date instanceof String) {
            return DateUtils.stringToDate((String) date);
        }

        return null;

    }

    public static long getAgeByBirthday(String date) {

        Date birthday = stringToDate(date, "yyyy-MM-dd");
        long sec = new Date().getTime() - birthday.getTime();

        long age = sec / (1000 * 60 * 60 * 24) / 365;

        return age;
    }

    /**
     * 0 : equals<br>
     * -1 : less<br>
     * 1 : greater<br>
     *
     * @param date1
     * @param date2
     * @return
     * @throws Exception
     */
    public static int compare(Date date1, Date date2) throws Exception {
        if (date1 == null || date2 == null) {
            throw new Exception(date1 + "," + date2, null);
        }
        return date1.compareTo(date2);
    }

    public static int compare2(Date date1, Date date2) throws Exception {
        if (date1 == null && date2 == null) {
            return 0;
        }
        if (date1 == null || date2 == null) {
            return -1;
        }
        return date1.compareTo(date2);
    }

    /**
     * 用于佣金计算：計算在職月數,不足月按足月計算
     *
     * @param enter 入职日期
     * @param calc  计算日期
     * @return
     * @throws Exception
     */
    public static int CalcEnterMon(Date enter, Date calc) throws Exception {
        int mon1, mon2;
        int year1, year2;
        int diffmons = 0;

        // 獲得第一個日期的月份
        mon1 = DateUtils.GetMonthByDay(enter);
        year1 = DateUtils.getYearOfDate(enter);

        // 獲得第二個日期的月份
        mon2 = DateUtils.GetMonthByDay(calc);
        year2 = DateUtils.getYearOfDate(calc);

        // 取得兩個月份數的差值
        diffmons = (year2 - year1) * 12 + mon2 - mon1 + 1;

        return diffmons;
    }


    /**
     * 用于佣金计算：根据当年天数计算月份
     *
     * @param calc
     * @return
     */
    public static int GetMonthByDay(Date calc) {

        long day = DateUtils.getDayOfYear(calc);

        boolean leap = DateUtils.isLeapYEAR(calc);

        assert (day < (leap ? 366 : 365));
        long monthtable[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        monthtable[1] = leap ? 29 : 28;

        int month = 0;
        long count = 0;
        long n = day;

        do {
            if (month > 11) break;
            n = day - count;
            count += monthtable[month++];
        } while (day >= count);
        day = n;

        return month;
    }

    /**
     * 當月: yyyy年M月d日 至 yyyy年M月d日
     *
     * @param dateStr format : yyyy-MM-dd
     * @return
     */
    public static String getDurationMonth(String dateStr) {
        if (isBlank(dateStr)) {
            return dateStr;
        }
        Date fromDate = stringToDate(dateStr);
        Date toDate = getLastDayOfMonth(fromDate);
        String result = dateToString(fromDate, DATE_FORMAT_CHINESE) + " 至 " + dateToString(toDate, DATE_FORMAT_CHINESE);
        return result;
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    public static Timestamp getOracleTimestamp(Object value) {
        try {
            Class clz = value.getClass();
            Method method = clz.getMethod("timestampValue", null);
            //method =clz.getMethod("timeValue", null); 时间类型
            //method =clz.getMethod("dateValue", null); 日期类型
            return (Timestamp) method.invoke(value, null);
        } catch (Exception e) {
            return null;
        }
    }

    public static java.sql.Date utilDateToSqlDate(java.util.Date utilDate) {
        if (utilDate == null) return null;
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }

    public static java.util.Date sqlDateToUtilDate(java.sql.Date sqlDate) {
        if (sqlDate == null) return null;
        java.util.Date utilDate = new java.sql.Date(sqlDate.getTime());
        return utilDate;
    }

    /**
     * 比較兩個日期是否相等
     *
     * @param d1
     * @param d2
     * @return
     */
    public static boolean equals(Date d1, Date d2) {
        if (d1 == null && d2 == null) return true;
        if (d1 == null && d2 != null) return false;
        if (d1 != null && d2 == null) return false;
        return d1.equals(d2);
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // String temp = DateUtil.dateToString(getLastDayOfMonth(new Date()),
        // / DateUtil.DATE_FORMAT_CHINESE);
        // String s=DateUtil.dateToString(DateUtil.addDay(DateUtil.addYear(new
        // Date(),1),-1));

        // long s=DateUtils.getDayByMinusDate("2012-01-01", "2012-12-31");
        // System.err.println(s);
//		System.out.println(DateUtils.getDayOfDate(DateUtils.getLastDayOfMonth(new Date())));
//		String str1 = "1989-11-19";
//		String str2 = "1990-06-19";
//		str2 = "1989-12-19";
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		Date date1 = df.parse(str1);
//		Date date2 = df.parse(str2);
        System.out.println(DateUtils.getYearOfDate(new Date()));
//
//
//		System.out.println(DateUtils.addYear(new Date(), -1));
//
//		System.out.println(DateUtils.getDateByYMD(DateUtils.getYearOfDate(new Date())-1, 12, 1));
//		String statdate = "";
//		statdate = "2013-0"+1;
//		Date date = DateUtils.stringToDate(statdate, "yyyy-MM");
//		int monthSize = DateUtils.getDayOfDate(DateUtils.getLastDayOfMonth(date));
//		System.out.println(DateUtils.dateToString(DateUtils.getYearCycleOfDate(DateUtils.stringToDate("2016-2-29"), 1)));
    }


}
