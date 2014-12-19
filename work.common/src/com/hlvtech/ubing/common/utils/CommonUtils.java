/**
 * 
 */
package com.hlvtech.ubing.common.utils;

import java.text.DecimalFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


/**
 * 工具类
 * 
 * @author zhangxujun
 * 
 * 
 */
public class CommonUtils {
 
    private static final  Logger log = Logger.getLogger(CommonUtils.class);
    
    
    /**
     * 将换行符替换为br标签
     * 
     */
    public static String replaceWrapToBr(String str){
	if (str!=null && str.length()>0){
	    return "<br/>"+str.replaceAll("\r\n", "<br/>");
	}
	return str;
    }
    
    
    /**
     * 隐藏电话号码：13888888888转换为138****8888
     * @param inValue
     * @return
     */
    public static String hideTel(String inValue){
        if(!StringUtils.isBlank(inValue)&&inValue.length()>7){
            String hide="";
            String str = inValue.substring(3,inValue.length()-4);
            for(int i=0;i<str.length();i++){
                hide = hide+"*";
            }
            return inValue.substring(0, 3) + hide + inValue.substring(inValue.length()-4, inValue.length());
        }else{
            return inValue;
        }
    }

    /**
     * 比较是否相等
     * @param source
     * @param target
     * @return
     */
    public static boolean isEqual(Integer source,Integer target){
	return source!=null && source!=null && source.equals(target);
    }
    
    /**
     * 比较是否相等
     * @param source
     * @param target
     * @return
     */
    public static boolean isEqual(Long source,Long target){
	return source!=null && source!=null && source.equals(target);
    }
    

    /**
     * 计算增长/减少百分比，比如:10%
     * 
     * @param source
     * @param target
     * @return
     */
    public static String getPercent(Integer source, Integer target) {
        double d = (target - source) / (source * 1.0);
        DecimalFormat df = new DecimalFormat("##.00%");
        return df.format(d);
    }

    /**
     * 判断字符串是否正整数
     * 
     * @param s
     * @return
     */
    public static boolean isLong(String s) {
        return s != null && s.matches("^\\d+$");
    }

    /**
     * 字符串解析为long
     * 
     * @param s
     * @return
     */
    public static Long parseLong(String s) {
        return isLong(s) ? Long.parseLong(s) : null;
    }

    /**
     * 字符串解析为long
     * 
     * @param s
     * @return
     */
    public static Integer parseInteger(String s) {
        return isLong(s) ? Integer.parseInt(s) : null;
    }
    /**
     * 将字符串yyyy-mm-dd hh:MM:ss或者yyyy-mm-dd转化为时间格式
     * 
     * @author 邱全松 2014-6-26 上午10:40:12
     * @param s
     * @return
     */
    public static Date parseDate(String s) {
        Date date = null;
        if(s!=null){
            try {
        	s = s.trim();
        	if (s.matches("\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}:\\d{2}")){
            	    java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    date = sf.parse(s);
                }else
                    if (s.matches("\\d{4}-\\d{2}-\\d{2}")){
                	java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                        date = sf.parse(s);
                    }
            } catch (Exception ex) {
        	log.error(ex.getMessage(), ex);
           
            }
        }
        return date;
    }
    /**
     * 将日期转换为字符串
     * 
     * @author 邱全松 2014-8-13 下午8:09:28
     * @param s
     * @return
     */
    public static String parseDateToString(Date s) {
        String re = null;    
        try {
                java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                re = sf.format(s);
            } catch (Exception ex) {
        	log.error(ex.getMessage(), ex);
               return null;
            }
            return re;
    }
    /**
     * 将字符串转化为Double型
     * 
     * @author 邱全松 2014-6-26 上午11:14:58
     * @param s
     * @return
     */
            
    public static Double parseDouble(String s) {
        Double result = null;
        if(s!=null&&!"".equals(s)){
            try{
                result = Double.valueOf(s);
            }catch(Exception e){
        	log.error(e.getMessage(), e);
                return result;
            }
            return result;
        }else{
            return result;
        }
    }
    
    /**
     * 取得非空字符串
     * @param str
     * @return
     */
    public static String getNotNullStr(String str){
	return str==null?"":str.trim();
    }
}
