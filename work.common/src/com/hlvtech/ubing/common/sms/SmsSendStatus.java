/**
 * 
 */
package com.hlvtech.ubing.common.sms;

/**
 * 短信发送状态
 * 
 * @author zhangxujun
 * 
 *
 */
public class SmsSendStatus {

    
    /**
     * 是否成功
     */
    private boolean success;
    
    
    /**
     * 提示信息
     */
    private String message;


    public boolean isSuccess() {
        return success;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
    
}
