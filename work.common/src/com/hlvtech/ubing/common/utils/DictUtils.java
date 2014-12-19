/**
 * 
 */
package com.hlvtech.ubing.common.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import com.hlvtech.ubing.common.constant.Constants;

/**
 * 字典工具类
 * @author zhangxujun
 * 
 *
 */
public class DictUtils {
    
    /**
     * 取得所有的字典类型
     * 
     */
    public static final Map<String, String> getAllDictTypeMap(){
	Map<String, String> dictMap = new LinkedHashMap<String, String>();
	
	
	dictMap.put(Constants.DICT_JLXL, "境内线路");
	dictMap.put(Constants.DICT_JWXL, "境外线路");
	dictMap.put(Constants.DICT_GLXZQH, "国内行政区划");
	dictMap.put(Constants.DICT_GJXZQH, "国际行政区划");
	dictMap.put(Constants.DICT_JPXZQU_GL, "机票出发/到达地区(国内)");
	dictMap.put(Constants.DICT_JPXZQU_GJ, "机票出发/到达地区(国际)");
	dictMap.put(Constants.DICT_JDXJ, "酒店星级");
	dictMap.put(Constants.DICT_JDJG, "酒店价格");
	dictMap.put(Constants.DICT_JPCW, "机票舱位");
	
	dictMap.put(Constants.DICT_PERSIONAL_VISIT_SERVICE, "自由行包含服务");
	dictMap.put(Constants.DICT_VISIT_LOCATION_TYPE, "自由行/跟团行目的地类别");
	dictMap.put(Constants.DICT_VISIT_GO_TRAFFIC_TYPE, "自由行/跟团行出发交通方式");
	dictMap.put(Constants.DICT_VISIT_BACK_TRAFFIC_TYPE, "自由行/跟团行返回交通方式");
	
	dictMap.put(Constants.DICT_HOTEL_LOCATION_GL_TYPE, "酒店目的地(国内)");
	dictMap.put(Constants.DICT_HOTEL_LOCATION_GJ_TYPE, "酒店目的地(国际)");
	
	
	dictMap.put(Constants.DICT_COMMON_CONTACTS_CREDENTIALS_TYPE, "常用联系人证件类型");
	dictMap.put(Constants.DICT_REQUIREMENT_PERSONAL_VISIT_TRAFFIC_TYPE, "需求-自由行-交通方式");
	
	dictMap.put(Constants.DICT_REQUIREMENT_TICKET_LEAVE_TIME_TYPE, "需求-机票-机票出发时间");
	
	dictMap.put(Constants.DICT_PUB_PLAN_HOTEL_SERVICES, "发布方案-酒店-提供服务");

	
	return dictMap;
    }

}
