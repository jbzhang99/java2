package com.rfchina.community.base.util;

public class RadomPhoneNumberUtils {

    /**
     * 返回手机号码
     */
    private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
    public static String getRamNum() {
        int index=getNum(0,telFirst.length-1);
        StringBuilder ramNum= new StringBuilder(telFirst[index]);
        ramNum.append("****");
        ramNum.append(getNum(1,910)+1000).substring(1);
        return ramNum.toString();
    }


    private static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }

}
