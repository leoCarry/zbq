package com.zbq.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class DateUtil
{
	private final static ThreadLocal<DateFormat> threadLocalCompactDateFormat = new ThreadLocal<DateFormat>()
    {
        @Override
        protected DateFormat initialValue()
        {
            return new SimpleDateFormat("yyyyMMddHHmmss");
        };
    };

    private final static ThreadLocal<DateFormat> threadLocalBeautyDateFormat = new ThreadLocal<DateFormat>()
    {
        @Override
        protected DateFormat initialValue()
        {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        };
    };

    private final static ThreadLocal<DateFormat> threadLocalShortDateFormat = new ThreadLocal<DateFormat>()
    {
        @Override
        protected DateFormat initialValue()
        {
            return new SimpleDateFormat("yyyyMMdd");
        };
    };

    public static DateFormat getCompactDateFormat()
    {
        return threadLocalCompactDateFormat.get();
    }

    public static DateFormat getBeautyDateFormat()
    {
        return threadLocalBeautyDateFormat.get();
    }

    public static DateFormat getShortDateFormat()
    {
        return threadLocalShortDateFormat.get();
    }
    
    public static Date getCurDate()
    {
        return new Date();
    }

    /**
     * 转换为简短的日期格式yyyyMMdd的字符串
     * 
     * @param date
     * 				
     * @return
     */
    public static String dateShortFormatStr(Date date)
    {
    	if(null == date)
    		return null;
        return getShortDateFormat().format(date);
    }
    
    /**
     * 转换为简短的日期格式yyyyMMddHHmmss的字符串
     * 
     * @param date
     * 				
     * @return
     */
    public static String dateCompactFormatStr(Date date)
    {
    	if(null == date)
    		return null;
        return getCompactDateFormat().format(date);
    }
    
    /**
     * 转换为格式型的日期格式yyyyMMddHHmmss的字符串
     * 
     * @param date
     * 				
     * @return
     */
    public static String dateBeautyFormatStr(Date date)
    {
        return getBeautyDateFormat().format(date);
    }
    
    /**
     * 紧凑型日期格式yyyyMMddHHmmss转换为日期
     * 
     * @param dateStr
     * 				
     * @return
     */
    public static Date str2DateCompactFmt(String dateStr)
    {
        try {
			return getCompactDateFormat().parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }

    /**
     * 格式型日期格式yyyyMMddHHmmss转换为日期
     * 
     * @param dateStr
     * 				
     * @return
     */
    public static Date str2DateBeautyFmt(String dateStr)
    {
        try {
			return getBeautyDateFormat().parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }

    /**
     * 获取指定时间的前、后几天
     * 
     * @param date
     * 				变动的日期
     * @param change
     * 				变动的天数，正数表示date后change天，负数表示date前change天
     * @return
     */
	public static Date getDateBeforeAndLater(Date date, int change) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, change);
		return c.getTime();
	}

    /**
     * 获取指定时间的前、后几消失
     * 
     * @param date
     * 				变动的日期
     * @param change
     * 				变动的小时数，正数表示date后change小时，负数表示date后change小时
     * @return
     */
	public static Date getHourBeforeAndLater(Date date, int change) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR, change);
		return c.getTime();
	}
	
    /**
     * 获取Unix时间戳
     * 
     * @param date
     * 				日期
     * @return
     */
	public static Integer getUnixTimeStamp(Date date) {
		long lTimeStamp = date.getTime();
		return (int)(lTimeStamp/1000);
	}
	


    /**
     * 获取指定时间的前、后几分钟
     * 
     * @param date
     * 				变动的日期
     * @param change
     * 				变动的小时数，正数表示date后change分钟，负数表示date后change分钟
     * @return
     */
	public static Date getMinuteBeforeAndLater(Date date, int change) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE, change);
		return c.getTime();
	}
	
    /**
     * 获取下一个运营日
     * 
     * @param date
     * 				日期
     * @return
     */
	public static Date getNextBusDay() {
		Date curDate = getCurDate();
		Calendar c = Calendar.getInstance();
		c.setTime(curDate);
		c.set(Calendar.HOUR_OF_DAY, 4);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Date curBusBegin = c.getTime();
		if(curDate.before(curBusBegin))
			return curBusBegin;
		else
			return getDateBeforeAndLater(curBusBegin, 1);
	}
	
    /**
     * 获取当前一个运营日
     * 
     * @param date
     * 				日期
     * @return
     */
	public static Date getCurBusDay() {
		Date curDate = getCurDate();
		Calendar c = Calendar.getInstance();
		c.setTime(curDate);
		c.set(Calendar.HOUR_OF_DAY, 4);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Date curBusBegin = c.getTime();
		if(curDate.before(curBusBegin))
			return getDateBeforeAndLater(curBusBegin, -1);
		else
			return curBusBegin;
	}
	
	
    /**
     * 获取相隔的时间
     * 
     * @param date
     * 				日期
     * @return
     */
	public static Integer getSubMin(Date little, Date large) {
		Long millsecond = large.getTime() - little.getTime();
		return (int)(millsecond/(1000*60));
	}

    /**
     * 判断是否属于相同运营日
     * 
     * @param date
     * 				日期
     * @return
     */
	public static boolean isSameBusDay(Date date1, Date date2) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		date1 = getHourBeforeAndLater(date1, -4);
		date2 = getHourBeforeAndLater(date2, -4);
		c1.setTime(date1);		
		c2.setTime(date2);
		return DateUtils.isSameDay(c1, c2);
	}
	
	
	
	
	
	
}
