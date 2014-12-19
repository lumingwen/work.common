/**
 * 
 */
package com.hlvtech.ubing.common.sms;


import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;


/**
 * 短信发送工具类
 * 
 * @author zhangxujun
 * 
 * 
 */
public class SmsSendUtils {

    private static final Logger log = Logger.getLogger(SmsSendUtils.class);

    
    /**
     * 加载配置文件
     */
    private static final Properties pro = new Properties();
    static {
	try {
	    pro.load(SmsSendUtils.class
		    .getResourceAsStream("sms_config.properties"));
	} catch (IOException e) {
	    log.error(e.getMessage(), e);
	}
    }
    
    
    
    //Inner class for UTF-8 support  
      public static class UTF8PostMethod extends PostMethod{  
          public UTF8PostMethod(String url){  
              super(url);  
          }  
          @Override  
          public String getRequestCharSet() {  
              //return super.getRequestCharSet();  
              return "utf-8";  
          }  
      }  

  	/**
  	 * 发送短信
  	 * 
  	 * @param mobile
  	 *            手机号码
  	 * @param content
  	 *            发送内容
  	 * @return 发送状态
  	 * @throws IOException
  	 * @throws HttpException
  	 * @throws URISyntaxException 
  	 */
  	@SuppressWarnings("deprecation")
    public static SmsSendStatus sendSms(String mobile, String content) {

	SmsSendStatus st = new SmsSendStatus();
	try {

	    String url = pro.getProperty("sms_url");
	    URI uri = new URI(url);
	    // post请求 222.76.210.200
	    HttpClient client = new HttpClient();

	    client.getHostConfiguration().setHost(uri.getHost(), uri.getPort(),
		    "http");
	    HttpMethod method = getPostMethod(mobile, content, uri.getPath());
	    client.executeMethod(method);
	    // 打印服务器返回状态
	    //System.out.println(method.getStatusLine());
	    // 打印结果页面
	    String response = new String(method.getResponseBodyAsString()
		    .getBytes("utf-8"));
	    //System.out.println(response);
	    method.releaseConnection();
	    client.endSession();
	    return (xmlElements(response));
	} catch (Exception e) {
	    st.setSuccess(false);
	    st.setMessage("异常:"+e.getMessage());
	    log.error(e.getMessage(), e);
	}
	return st;

    }

  	/**
  	 * 使用 POST 方式提交数据
  	 * 
  	 * @return
  	 * @throws IOException
  	 */
  	private static HttpMethod getPostMethod(String mobile, String content,
  			String s) throws IOException {
  	    UTF8PostMethod post = new UTF8PostMethod(s);
  		// 填入各个表单域的值
  		NameValuePair action = new NameValuePair("action", "send");
  		NameValuePair userid = new NameValuePair("userid",
  			pro.getProperty("sms_userid"));
  		NameValuePair account = new NameValuePair("account",
  			pro.getProperty("sms_account"));
  		NameValuePair password = new NameValuePair("password",
  			pro.getProperty("sms_password"));
  		NameValuePair mobiles = new NameValuePair("mobile", mobile);
  		NameValuePair contents = new NameValuePair("content", content);
  		NameValuePair[] data = { action, userid, account, password, mobiles,
  				contents };
  		post.setRequestBody(data);
  		return post;
  	}

  	/**
  	 * 解析返回的结果
  	 * 
  	 * @param args
  	 * @throws HttpException
  	 * @throws IOException
  	 */
  	public static SmsSendStatus xmlElements(String xmlDoc) {
  		// 创建一个新的字符串
  		StringReader read = new StringReader(xmlDoc);
  		// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
  		InputSource source = new InputSource(read);
  		// 创建一个新的SAXBuilder
  		SAXBuilder sb = new SAXBuilder();
  		SmsSendStatus smsSendStatus=new SmsSendStatus();
  		try {
  			// 通过输入源构造一个Document
  			Document doc = sb.build(source);
  			// 取的根元素
  			Element root = doc.getRootElement();
  			if(root.getChild("returnstatus").getText().equals("Faild"))
  			{
  				smsSendStatus.setSuccess(false);
  			}else
  			{ 
  				smsSendStatus.setSuccess(true);
  			}
  			smsSendStatus.setMessage(root.getChild("message").getText());;

  		} catch (JDOMException e) {
  		  log.error(e.getMessage(), e);
  		} catch (IOException e) {
  		  log.error(e.getMessage(), e);
  		}
   
  		return smsSendStatus;
  	}
  	
  	/**
  	  * 创建指定数量的随机字符串
  	  * @param numberFlag 是否是数字
  	  * @param length
  	  * @return
  	  */
  	 public static String createRandom(boolean numberFlag, int length){
  	  String retStr = "";
  	  String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
  	  int len = strTable.length();
  	  boolean bDone = true;
  	  do {
  	   retStr = "";
  	   int count = 0;
  	   for (int i = 0; i < length; i++) {
  	    double dblR = Math.random() * len;
  	    int intR = (int) Math.floor(dblR);
  	    char c = strTable.charAt(intR);
  	    if (('0' <= c) && (c <= '9')) {
  	     count++;
  	    }
  	    retStr += strTable.charAt(intR);
  	   }
  	   if (count >= 2) {
  	    bDone = false;
  	   }
  	  } while (bDone);
  	 
  	  return retStr;
  	 }


}
