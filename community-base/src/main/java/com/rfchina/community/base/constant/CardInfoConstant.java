package com.rfchina.community.base.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */
public class CardInfoConstant {

    private CardInfoConstant() {
    }

    public interface CardReport {

        interface Category {

            /**
             * 垃圾营销
             */
            int GARBAGE_MARKETING = 1;
            /**
             * 欺诈信息
             */
            int FRAUD_INFO = 2;
            /**
             * 有害信息
             */
            int HARMFUL_INFO = 3;
            /**
             * 违法信息
             */
            int ILLEGAL_INFO = 4;
            /**
             * 色情淫秽
             */
            int PORNOGRAPHY = 5;
            /**
             * 人身攻击
             */
            int PERSONAL_ATTACK = 6;
            /**
             * 其它
             */
            int OTHER = 7;
        }

        interface Status {

            /**
             * 未审核
             */
            Integer UNAUDIT = 0;
            /**
             * 删除卡片
             */
            Integer DELETE_CARD_INFO = 1;
            /**
             * 忽略本次举报
             */
            Integer IGNORE_CARD_REPORT = 2;
        }
    }

    public interface CardInfo {

        interface Location {
            /**
             * 广场页
             */
            Integer HOME = 1;
            /**
             * 社区也
             */
            Integer COMMUNITY = 2;

        }

        /*
        卡片来源
         */
        interface Source {

            String ZIZAI = "zizai";

            String OPEN = "open";

        }

        interface Status {

            /**
             * 正常
             */
            Integer NORMAL = 1;
            /**
             * 隐藏
             */
            Integer HIDDEN = 2;
            /**
             * 删除
             */
            Integer DELETED = 3;
        }

        interface AuditStatus {

            /**
             * 待审核
             */
            Integer UNAUDIT = 1;
            /**
             * 审核通过
             */
            Integer AUDIT_PASS = 2;
            /**
             * 审核不通过
             */
            Integer AUDIT_NOTPASS = 3;
            /**
             * 上架
             */
            Integer PUBLISH = 4;
            /**
             * 下架
             */
            Integer REPEAL = 5;
            /**
             * 审核中
             */
            Integer AUDITING = 6;

            public static String translate(int code) {
                Map<Integer, String> map = new HashMap<>();
                map.put(UNAUDIT, "待审核");
                map.put(AUDIT_PASS, "审核通过");
                map.put(AUDIT_NOTPASS, "审核不通过");
                map.put(PUBLISH, "上架");
                map.put(REPEAL, "下架");
                map.put(AUDITING, "审核中");
                return map.getOrDefault(code, "");
            }
        }

        interface SquareAuditStatus {

            /**
             * 待审核
             */
            Integer UNAUDIT = 1;
            /**
             * 审核通过
             */
            Integer AUDIT_PASS = 2;
            /**
             * 审核不通过
             */
            Integer AUDIT_NOTPASS = 3;
            /**
             * 上架
             */
            Integer PUBLISH = 4;
            /**
             * 下架
             */
            Integer REPEAL = 5;
            /**
             * 审核中
             */
            Integer AUDITING = 6;

            public static String translate(int code) {
                Map<Integer, String> map = new HashMap<>();
                map.put(UNAUDIT, "待审核");
                map.put(AUDIT_PASS, "审核通过");
                map.put(AUDIT_NOTPASS, "审核不通过");
                map.put(PUBLISH, "上架");
                map.put(REPEAL, "下架");
                map.put(AUDITING, "审核中");
                return map.getOrDefault(code, "");
            }
        }
    }

    public interface CardComment {

        interface Status {

            Integer NORMAL = 1;

            Integer DELETED_BY_USER = 2;

            Integer DELETED_BY_AUDIT = 3;
        }
    }

    public interface CardSubject {

        interface Type {

            /**
             * 普通用户
             */
            Integer NORMAL_USER = 1;
            /**
             * 社区运营者
             */
            Integer COMMUNITY_ADMIN = 2;
            /**
             * 商家开放平台
             */
            Integer OPEN_WEB = 3;
        }
    }

    public interface CardTemplate {

        //社区卡片
        public static final int BASE_TEMPLTE_ID = 1;
        //商家图文
        public static final int BUSINESS_COMMON_TEMPLTE_ID = 2;
        //商家商品
        public static final int BUSINESS_GOODS_TEMPLTE_ID = 3;
    }

    public interface CardCategory {

        /**
         * 最新
         */
        public static final int FIXED_LATEST_CATEGORY_ID = 1;
        /**
         * 公告
         */
        public static final int FIXED_NOTICE_CATEGORY_ID = 2;
        /**
         * 活动
         */
        public static final int FIXED_EVENT_CATEGORY_ID = 3;

        interface Type {

            /**
             * 固定的公告
             */
            Integer FIXED_NOTICE_CATEGORY = 1;
            /**
             * 固定分类
             */
            Integer FIXED_EVENT_CATEGORY = 2;
            Integer FIXED_CATEGORY = 2;
            /**
             * 自定义分类
             */
            Integer CUSTOM_CATEGORY = 3;
        }

        interface Name {

            String FIXED_ALL_CATEGORY_CODE = "all";

            String FIXED_NOTICE_CATEGORY = "公告";
            String FIXED_NOTICE_CATEGORY_CODE = "notice";

            String FIXED_EVENT_CATEGORY = "活动";
            String FIXED_EVENT_CATEGORY_CODE = "event";

            String FIXED_SHOPPING_CATEGORY = "购物";
            String FIXED_SHOPPING_CATEGORY_CODE = "shopping";

            String CUSTOM_INFO_CATEGORY = "社区资讯";

            public static String translateToCode(String code) {
                Map<String, String> map = new HashMap<>();
                map.put(FIXED_NOTICE_CATEGORY, FIXED_NOTICE_CATEGORY_CODE);
                map.put(FIXED_EVENT_CATEGORY, FIXED_EVENT_CATEGORY_CODE);
                map.put(FIXED_SHOPPING_CATEGORY, FIXED_SHOPPING_CATEGORY_CODE);
                return map.getOrDefault(code, "");
            }

            public static String translateCodeToName(String code) {
                Map<String, String> map = new HashMap<>();
                map.put(FIXED_NOTICE_CATEGORY_CODE, FIXED_NOTICE_CATEGORY);
                map.put(FIXED_EVENT_CATEGORY_CODE, FIXED_EVENT_CATEGORY);
                map.put(FIXED_SHOPPING_CATEGORY_CODE, FIXED_SHOPPING_CATEGORY);
                return map.getOrDefault(code, "");
            }

            public static List<String> getFixedCategoryCodeList() {
                List<String> fixedCategoryCodeList = new ArrayList<String>();
                fixedCategoryCodeList.add(FIXED_NOTICE_CATEGORY);
                fixedCategoryCodeList.add(FIXED_EVENT_CATEGORY);
                fixedCategoryCodeList.add(FIXED_SHOPPING_CATEGORY);
                return fixedCategoryCodeList;
            }
        }

        interface Status {

            /**
             * 已启用
             */
            Integer ENABLE = 1;
            /**
             * 禁用
             */
            Integer DISABLE = 2;

            public static String translate(int code) {
                Map<Integer, String> map = new HashMap<>();
                // map.put(UNPAID, "待付款");
                map.put(ENABLE, "启用");
                map.put(DISABLE, "禁用");
                return map.getOrDefault(code, "");
            }
        }
    }
}
