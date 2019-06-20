package com.rfchina.community.base;


/**
 * @Author wlrllr
 * @Description //订单支付相关的状态
 * @Date 2019/1/3
 * @Param
 * @return
 **/
public final class SysConstant {

    public static final String REDIS_EXPRESS_COMPANY_KEY = "LIFE:EXPRESS_COMPANY";
    public static final String REDIS_COMMENT_ORDER_KEY = "LIFE:AUTO_COMMENT_ORDER_";
    public static final String REDIS_COMMENT_ORDER_DEFAULT_VALUE = "DEALING";

    /**
     * 公共状态 1正常 0隐藏 -1 失效/无效/删除
     **/
    public static final String COMMON_STATUS_NORMAL = "1";
    public static final String COMMON_STATUS_HIDE = "0";
    public static final String COMMON_STATUS_DISABLE = "-1";

    /**
     * 快递状态 0 无物流信息 1发货中在途，2已签收完成
     **/
    public static final Integer EXPRESS_STATUS_NO = 0;
    public static final Integer EXPRESS_STATUS_PROCESS = 1;
    public static final Integer EXPRESS_STATUS_FINISH = 2;

    /**
     * 评论对象类型
     **/
    public static final String COMMENT_TARGET_TYPE_MERCHANT = "M";
    public static final String COMMENT_TARGET_TYPE_GOODS = "G";
    public static final String COMMENT_TARGET_TYPE_POI = "P";


    /**
     * 评分 5
     **/
    public static final Integer COMMENT_GRADE_5 = 5;

    public static final Integer PAGE_SIZE = 20;
    public static final Integer BATCH_INSERT = 100;

    /**
     * @Author wlrllr
     * @Description 地图类型
     **/
    public static final Integer MAP_TYPE_BAIDU = 1;
    public static final Integer MAP_TYPE_GAODE = 2;

    /** 已经上传的图片*/
    public static final Integer POI_PIC_STATUS_1 = 1;
    /** 需要上传到服务的图片*/
    public static final Integer POI_PIC_STATUS_2 = 2;
}
