package com.rfchina.community.openstore.task;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author:fukangwen
 * @Description: 
 */
public class NoticeExecutor {

    private static final Executor executor = Executors.newFixedThreadPool(20);

    private NoticeExecutor(){

    }

    public static Executor getExecutor(){
        return executor;
    }
}
