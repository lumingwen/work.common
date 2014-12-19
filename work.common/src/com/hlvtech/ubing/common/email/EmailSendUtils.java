/**
 * 
 */
package com.hlvtech.ubing.common.email;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;

import com.hlvtech.ubing.common.sms.SmsSendStatus;

/**
 * @author zhangxujun
 * 
 *
 */
public class EmailSendUtils {
    
    private static final Logger log = Logger.getLogger(EmailSendUtils.class);
    
    /**
     * 加载配置文件
     */
    private static final Properties pro = new Properties();
    static {
	try {
	    pro.load(EmailSendUtils.class
		    .getResourceAsStream("email_config.properties"));
	} catch (IOException e) {
	    log.error(e.getMessage(), e);
	}
    }
    
    /**
     * 发送基本邮件
     * @param email 邮件地址
     * @param title 标题
     * @param content 内容
     * @return 发送状态
     */
    public static SmsSendStatus sendBasicEmail(String email,String title,String content){
	SmsSendStatus st = new SmsSendStatus();
	st.setSuccess(true);
	st.setMessage("发送成功");
	try{
        System.out.println("\n发送邮件到:"+email);
	    SimpleEmail send = new SimpleEmail();
	    send.setHostName(pro.getProperty("email_host"));  
	    send.setSmtpPort(Integer.parseInt(pro.getProperty("email_port")));
	    send.setAuthentication(pro.getProperty("email_username"), pro.getProperty("sms_password"));  
	    send.setCharset("utf-8");
	    send.setFrom(pro.getProperty("email_address"));  
	    send.setSubject(title);  
	    send.setMsg(content);    
	    send.addTo(email); 
	    send.send();
	}catch(Exception e){
	    st.setSuccess(false);
	    System.out.println(e.getMessage());
	    st.setMessage("发送失败:"+e.getMessage());
	    log.error(e.getMessage(), e);
	}
	return st;
    }
    
   public static void main(String[] args) {
       sendBasicEmail("337859518@qq.com", "aa", "cc");
}
}
