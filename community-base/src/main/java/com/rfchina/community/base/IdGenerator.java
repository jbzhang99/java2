package com.rfchina.community.base;

import sun.management.VMManagement;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class IdGenerator {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
    private static Integer pid = 0;

    private  static volatile long lastTime;
    private  static volatile long sequence = 0L;
    static{
        pid = getPid();
    }

    public static String generate(){
        Date now = new Date();
        if(now.getTime()/1000 == lastTime/1000){
            sequence++;
        }else{
            sequence = 0L;
            lastTime = now.getTime();
        }
        String date = sdf.format(now);
        return date+pid+sequence;
    }

    private static Integer getPid(){
        try {
            RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
            Field jvm = runtime.getClass().getDeclaredField("jvm");
            jvm.setAccessible(true);
            VMManagement mgmt = (VMManagement) jvm.get(runtime);
            Method pidMethod = mgmt.getClass().getDeclaredMethod("getProcessId");
            pidMethod.setAccessible(true);
            return (Integer) pidMethod.invoke(mgmt);
        }catch (Exception e){

        }
        return null;
    }
}
