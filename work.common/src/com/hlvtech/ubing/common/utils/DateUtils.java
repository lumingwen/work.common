/**
 * 
 */
package com.hlvtech.ubing.common.utils;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 日期处理工具类
 * @author zhangxujun
 * 
 *
 */
public class DateUtils {
    
    private static final Logger log = Logger.getLogger(DateUtils.class);

    /**
     * 
     * 日期转字符串,格式yyyy-MM-dd
     */
    public static String parseDateToString(Date s) {
	return parseDateToString(s, "yyyy-MM-dd");
    }
    
    /**
     * 
     * 日期转字符串
     */
    public static String parseDateToString(Date s,String format) {
        String re = null;    
        if (s!=null && format!=null){
            try {
                java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat(format);
                re = sf.format(s);
            } catch (Exception ex) {
        	log.error(ex.getMessage(), ex);
            }
        }
        return re;
    }
    
    
    /**
     * 获得当月起止日期
     * 
     */
    public static Date[] getCurrentMonthBeginAndEnd(){
	Calendar c1 = Calendar.getInstance();
	c1.setTime(new Date());
	c1.set(Calendar.DAY_OF_MONTH, c1.getActualMinimum(Calendar.DAY_OF_MONTH));
	Calendar c2 = Calendar.getInstance();
	c2.setTime(new Date());
	c2.set(Calendar.DAY_OF_MONTH, c2.getActualMaximum(Calendar.DAY_OF_MONTH));
	return new Date[]{c1.getTime(),c2.getTime()};
    }
    
    /**
     * 获得上月起止日期
     * 
     */
    public static Date[] getLastMonthBeginAndEnd(){
	Calendar c1 = Calendar.getInstance();
	c1.setTime(new Date());
	c1.add(Calendar.MONTH, -1);
	c1.set(Calendar.DAY_OF_MONTH, c1.getActualMinimum(Calendar.DAY_OF_MONTH));
	Calendar c2 = Calendar.getInstance();
	c2.setTime(new Date());
	c2.add(Calendar.MONTH, -1);
	c2.set(Calendar.DAY_OF_MONTH, c2.getActualMaximum(Calendar.DAY_OF_MONTH));
	return new Date[]{c1.getTime(),c2.getTime()};
    }
    
    /**
     * 获得历史起止日期(开始为空,结束为上上月最后一天)
     * 
     */
    public static Date[] getHistoryMonthBeginAndEnd(){
	Calendar c1 = Calendar.getInstance();
	c1.setTime(new Date());
	c1.add(Calendar.MONTH, -2);
	c1.set(Calendar.DAY_OF_MONTH, c1.getActualMaximum(Calendar.DAY_OF_MONTH));
	return new Date[]{null,c1.getTime()};
    }

}
