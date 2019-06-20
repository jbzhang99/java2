package com.rfchina.community.open.bridge.controller.task;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author:fukangwen
 * @Description: 
 */
public class NoticeExecutor {

    private static volatile Executor executor = null;

    private NoticeExecutor(){

    }

    public static Executor getExecutor(){
        if(executor == null){
            synchronized (NoticeExecutor.class){
                if (executor == null){
                    executor = Executors.newFixedThreadPool(10);
                }
            }
        }
        return executor;
    }
}
