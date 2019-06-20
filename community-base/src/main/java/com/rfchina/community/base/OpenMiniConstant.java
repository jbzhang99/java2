package com.rfchina.community.base;

import java.util.ArrayList;
import java.util.List;

public class OpenMiniConstant {
    //店铺
    public enum ShowStyle {
        SINGLE("SINGLE", "单图", 1),
        ONE_ROW_DOUBLE("ONE_ROW_DOUBLE", "一行两列", 2),
        ONE_ROW_FOUR("ONE_ROW_FOUR", "一行四列", 4),
        ONE_ROW_THREE("ONE_ROW_THREE", "一行三图", 3),
        TWO_ROW_TWO("TWO_ROW_TWO", "两行两列", 4),
        TWO_ROW_THREE("TWO_ROW_THREE", "两行三图", 3),
        TWO_ROW_FOUR("TWO_ROW_FOUR", "两行四列", 8);

        private String code;
        private String label;
        private int amount;

        ShowStyle(String code, String label, int amount) {
            this.code = code;
            this.label = label;
            this.amount = amount;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public static Boolean isExist(String code) {
            for (ShowStyle record : ShowStyle.values()) {
                if (record.getCode().equals(code))
                    return true;
            }
            return false;
        }

        public static int getAmountByCode(String code){
            for (ShowStyle record : ShowStyle.values()) {
                if(record.getCode().equals(code)){
                    return record.getAmount();
                }
            }
            return 0;
        }

        public static List<KeyValueDomain> getList() {
            List<KeyValueDomain> list = new ArrayList<>();
            for (ShowStyle record : ShowStyle.values()) {
                KeyValueDomain domain = new KeyValueDomain(record.getCode(), record.getLabel());
                list.add(domain);
            }
            return list;
        }

    }


    //内容类型
    public enum Type {
        GOOD("GOOD", "商品"),
        SERVICE("SERVICE", "店铺"),
        ACTIVITY("ACTIVITY", "活动")
        ;

        private String code;
        private String label;

        Type(String code, String label) {
            this.code = code;
            this.label = label;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public static Boolean isExist(String code) {
            for (Type record : Type.values()) {
                if (record.getCode().equals(code))
                    return true;
            }
            return false;
        }


    }
}
