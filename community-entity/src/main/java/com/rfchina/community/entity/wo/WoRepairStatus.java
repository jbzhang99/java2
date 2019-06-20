package com.rfchina.community.entity.wo;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class WoRepairStatus {
    /** 待派单 */
    public static final Integer UN_DISPATCH = 1;
    /** 待接单 */
    public static final Integer UN_RECEIVE = 2;
    /** 作业中 */
    public static final Integer OPERATING = 3;
    /** 待料中 */
    public static final Integer SUPPLING = 4;
    /** 已完成 */
    public static final Integer COMPLETE = 5;
    /** 已取消 */
    public static final Integer CANCEL = 6;
    /** 已销单 */
    public static final Integer VERIFY = 7;
    /** 已拒单(虚拟的，工单那边是1(带派单(已拒绝)), 爆粗一下：操 */
    public static final Integer REFUSE = 8;

    private static final Map<Integer, Integer> REPAIR_CLIENT_STATUS_MAP = new HashMap<>();
    //状态, 1:未派单, 2:待接单, 3:作业中, 4:已拒单, 5:已取消, 6:已确认取消, 7:已完成, 8:待评价, 9:已评价
    static {
        REPAIR_CLIENT_STATUS_MAP.put(UN_DISPATCH, 1);
        REPAIR_CLIENT_STATUS_MAP.put(UN_RECEIVE, 2);
        REPAIR_CLIENT_STATUS_MAP.put(OPERATING, 3);
        REPAIR_CLIENT_STATUS_MAP.put(SUPPLING, 3);
        REPAIR_CLIENT_STATUS_MAP.put(COMPLETE, 7);
        REPAIR_CLIENT_STATUS_MAP.put(CANCEL, 6);
        REPAIR_CLIENT_STATUS_MAP.put(VERIFY, 9);
        REPAIR_CLIENT_STATUS_MAP.put(REFUSE, 4);
    }

    private static final Map<Integer, Integer[]> REPAIR_WORK_ORDER_STATUS_MAP = new HashMap<>();
    //状态, 1:未派单, 2:待接单, 3:作业中, 4:已拒单, 5:已取消, 6:已确认取消, 7:已完成, 8:待评价, 9:已评价
    static {
        REPAIR_WORK_ORDER_STATUS_MAP.put(1, new Integer[]{UN_DISPATCH});
        REPAIR_WORK_ORDER_STATUS_MAP.put(2, new Integer[]{UN_RECEIVE});
        REPAIR_WORK_ORDER_STATUS_MAP.put(3, new Integer[]{OPERATING, SUPPLING});
        REPAIR_WORK_ORDER_STATUS_MAP.put(7, new Integer[]{COMPLETE});
        REPAIR_WORK_ORDER_STATUS_MAP.put(6, new Integer[]{CANCEL});
        REPAIR_WORK_ORDER_STATUS_MAP.put(9, new Integer[]{VERIFY});
        REPAIR_WORK_ORDER_STATUS_MAP.put(4, new Integer[]{REFUSE});
    }

    public static final Integer toAppClientStatus(Integer woRepairStatus, String reason) {
        Integer newState = transRefuseStatus(woRepairStatus, reason);
        return REPAIR_CLIENT_STATUS_MAP.get(newState);
    }

    public static final Integer[] toWorkOrderStatus(Integer appStatus) {
        return REPAIR_WORK_ORDER_STATUS_MAP.get(appStatus);
    }

    //Say FUCK!
    public static final Integer transRefuseStatus(Integer status, String reason) {
        if(null!=status && status == 1
            && null!= reason && reason.indexOf("已拒单") != -1) {
            return REFUSE;
        }
        return status;
    }

    /** 待派单 */
    public static final Integer CUS_UN_DISPATCH = 10;
    /** 待接单 */
    public static final Integer CUS_UN_RECEIVE = 11;
    /** 作业中 */
    public static final Integer CUS_OPERATING = 12;
    /** 待料中 */
    public static final Integer CUS_UN_VERIFY = 13;
    /** 已取消 */
    public static final Integer CUS_CANCEL = 15;
    /** 已取消（已确认) */
    public static final Integer CUS_CONFIRM_CANCEL = 16;
    /** 已销单 */
    public static final Integer CUS_VERIFY = 17;
}
