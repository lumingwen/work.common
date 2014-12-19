/**
 * 
 */
package com.hlvtech.ubing.common.utils;

import com.hlvtech.ubing.common.constant.Constants;

/**
 * 消息工具类
 * @author zhangxujun
 * 
 *
 */
public class MessageUtils {
    
    /**
     * 取得发送者真正的id
     * @param messagetType
     * @param fromUserId
     * @return
     */
    public static Long getRealFromUserId(Integer messagetType, Long fromUserId){
	if (Constants.MESSAGE_TYPE_SYSTEM.equals(messagetType)){
	    return Constants.MESSAGE_TYPE_SYSTEM * -1L;
	}else
	    if (Constants.MESSAGE_TYPE_ORDER.equals(messagetType)){
		return Constants.MESSAGE_TYPE_ORDER * -1L;
	    }else
		if (Constants.MESSAGE_TYPE_PRICE.equals(messagetType)){
		    return Constants.MESSAGE_TYPE_PRICE * -1L;
	    }
	return fromUserId;
    }

}
