/**
 * 
 */
package com.hlvtech.ubing.common.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 线程池
 * @author zhangxujun
 * 
 *
 */
public class ScheduledExecutorServiceFactory {
    
    private static ScheduledExecutorService service = null;
    public static final synchronized ScheduledExecutorService buildScheduledExecutorService(){
	if (service==null){
	    service = Executors.newScheduledThreadPool(5);
	}
	return service;
    }

}
