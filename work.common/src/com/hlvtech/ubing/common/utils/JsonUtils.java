/**
 * 
 */
package com.hlvtech.ubing.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * json处理工具类
 * @author zhangxujun
 * 
 *
 */
public class JsonUtils {
  
    /**
     * 对象转json字符串
     * @param o 对象
     * @return 字符串
     */
    public static String toJson(Object o){
	return toJsonWithDateFormat(o, "yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * 转json
     * @param o
     * @param dateFormat
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static String toJsonWithDateFormat(Object o,final String dateFormat){
	//开始
	if (o!=null){
	    
	    //自定义日期格式转换器
	    JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
		   SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		   @Override
		   public Object processObjectValue(String propertyName, Object date,JsonConfig config) {
		      return date==null?null:simpleDateFormat.format(date);
		   }

		   @Override
		   public Object processArrayValue(Object date, JsonConfig config) {
		      return date==null?null:simpleDateFormat.format(date);
		   }
		});
	    
	    //开始转换
	    if (o instanceof List){
		List list = (List) o;
		if (list.isEmpty()){
		    return "[]";
		}
		JSONArray json = JSONArray.fromObject(o,config);
		String s = json.toString();
		return s;
	    }else{
		JSONObject json = JSONObject.fromObject(o,config);
		String s = json.toString();
		return s;
	    }
	}
	return null;
    }
    
    
}
