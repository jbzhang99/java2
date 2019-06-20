package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OpenStatsMerchantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenStatsMerchantExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andStatDateIsNull() {
            addCriterion("stat_date is null");
            return (Criteria) this;
        }

        public Criteria andStatDateIsNotNull() {
            addCriterion("stat_date is not null");
            return (Criteria) this;
        }

        public Criteria andStatDateEqualTo(Date value) {
            addCriterionForJDBCDate("stat_date =", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("stat_date <>", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateGreaterThan(Date value) {
            addCriterionForJDBCDate("stat_date >", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stat_date >=", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateLessThan(Date value) {
            addCriterionForJDBCDate("stat_date <", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stat_date <=", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateIn(List<Date> values) {
            addCriterionForJDBCDate("stat_date in", values, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("stat_date not in", values, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stat_date between", value1, value2, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stat_date not between", value1, value2, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatWreekIsNull() {
            addCriterion("stat_wreek is null");
            return (Criteria) this;
        }

        public Criteria andStatWreekIsNotNull() {
            addCriterion("stat_wreek is not null");
            return (Criteria) this;
        }

        public Criteria andStatWreekEqualTo(Integer value) {
            addCriterion("stat_wreek =", value, "statWreek");
            return (Criteria) this;
        }

        public Criteria andStatWreekNotEqualTo(Integer value) {
            addCriterion("stat_wreek <>", value, "statWreek");
            return (Criteria) this;
        }

        public Criteria andStatWreekGreaterThan(Integer value) {
            addCriterion("stat_wreek >", value, "statWreek");
            return (Criteria) this;
        }

        public Criteria andStatWreekGreaterThanOrEqualTo(Integer value) {
            addCriterion("stat_wreek >=", value, "statWreek");
            return (Criteria) this;
        }

        public Criteria andStatWreekLessThan(Integer value) {
            addCriterion("stat_wreek <", value, "statWreek");
            return (Criteria) this;
        }

        public Criteria andStatWreekLessThanOrEqualTo(Integer value) {
            addCriterion("stat_wreek <=", value, "statWreek");
            return (Criteria) this;
        }

        public Criteria andStatWreekIn(List<Integer> values) {
            addCriterion("stat_wreek in", values, "statWreek");
            return (Criteria) this;
        }

        public Criteria andStatWreekNotIn(List<Integer> values) {
            addCriterion("stat_wreek not in", values, "statWreek");
            return (Criteria) this;
        }

        public Criteria andStatWreekBetween(Integer value1, Integer value2) {
            addCriterion("stat_wreek between", value1, value2, "statWreek");
            return (Criteria) this;
        }

        public Criteria andStatWreekNotBetween(Integer value1, Integer value2) {
            addCriterion("stat_wreek not between", value1, value2, "statWreek");
            return (Criteria) this;
        }

        public Criteria andStatMonthIsNull() {
            addCriterion("stat_month is null");
            return (Criteria) this;
        }

        public Criteria andStatMonthIsNotNull() {
            addCriterion("stat_month is not null");
            return (Criteria) this;
        }

        public Criteria andStatMonthEqualTo(Integer value) {
            addCriterion("stat_month =", value, "statMonth");
            return (Criteria) this;
        }

        public Criteria andStatMonthNotEqualTo(Integer value) {
            addCriterion("stat_month <>", value, "statMonth");
            return (Criteria) this;
        }

        public Criteria andStatMonthGreaterThan(Integer value) {
            addCriterion("stat_month >", value, "statMonth");
            return (Criteria) this;
        }

        public Criteria andStatMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("stat_month >=", value, "statMonth");
            return (Criteria) this;
        }

        public Criteria andStatMonthLessThan(Integer value) {
            addCriterion("stat_month <", value, "statMonth");
            return (Criteria) this;
        }

        public Criteria andStatMonthLessThanOrEqualTo(Integer value) {
            addCriterion("stat_month <=", value, "statMonth");
            return (Criteria) this;
        }

        public Criteria andStatMonthIn(List<Integer> values) {
            addCriterion("stat_month in", values, "statMonth");
            return (Criteria) this;
        }

        public Criteria andStatMonthNotIn(List<Integer> values) {
            addCriterion("stat_month not in", values, "statMonth");
            return (Criteria) this;
        }

        public Criteria andStatMonthBetween(Integer value1, Integer value2) {
            addCriterion("stat_month between", value1, value2, "statMonth");
            return (Criteria) this;
        }

        public Criteria andStatMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("stat_month not between", value1, value2, "statMonth");
            return (Criteria) this;
        }

        public Criteria andMerchantCountIsNull() {
            addCriterion("merchant_count is null");
            return (Criteria) this;
        }

        public Criteria andMerchantCountIsNotNull() {
            addCriterion("merchant_count is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantCountEqualTo(Integer value) {
            addCriterion("merchant_count =", value, "merchantCount");
            return (Criteria) this;
        }

        public Criteria andMerchantCountNotEqualTo(Integer value) {
            addCriterion("merchant_count <>", value, "merchantCount");
            return (Criteria) this;
        }

        public Criteria andMerchantCountGreaterThan(Integer value) {
            addCriterion("merchant_count >", value, "merchantCount");
            return (Criteria) this;
        }

        public Criteria andMerchantCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("merchant_count >=", value, "merchantCount");
            return (Criteria) this;
        }

        public Criteria andMerchantCountLessThan(Integer value) {
            addCriterion("merchant_count <", value, "merchantCount");
            return (Criteria) this;
        }

        public Criteria andMerchantCountLessThanOrEqualTo(Integer value) {
            addCriterion("merchant_count <=", value, "merchantCount");
            return (Criteria) this;
        }

        public Criteria andMerchantCountIn(List<Integer> values) {
            addCriterion("merchant_count in", values, "merchantCount");
            return (Criteria) this;
        }

        public Criteria andMerchantCountNotIn(List<Integer> values) {
            addCriterion("merchant_count not in", values, "merchantCount");
            return (Criteria) this;
        }

        public Criteria andMerchantCountBetween(Integer value1, Integer value2) {
            addCriterion("merchant_count between", value1, value2, "merchantCount");
            return (Criteria) this;
        }

        public Criteria andMerchantCountNotBetween(Integer value1, Integer value2) {
            addCriterion("merchant_count not between", value1, value2, "merchantCount");
            return (Criteria) this;
        }

        public Criteria andShelvesCountIsNull() {
            addCriterion("shelves_count is null");
            return (Criteria) this;
        }

        public Criteria andShelvesCountIsNotNull() {
            addCriterion("shelves_count is not null");
            return (Criteria) this;
        }

        public Criteria andShelvesCountEqualTo(Integer value) {
            addCriterion("shelves_count =", value, "shelvesCount");
            return (Criteria) this;
        }

        public Criteria andShelvesCountNotEqualTo(Integer value) {
            addCriterion("shelves_count <>", value, "shelvesCount");
            return (Criteria) this;
        }

        public Criteria andShelvesCountGreaterThan(Integer value) {
            addCriterion("shelves_count >", value, "shelvesCount");
            return (Criteria) this;
        }

        public Criteria andShelvesCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("shelves_count >=", value, "shelvesCount");
            return (Criteria) this;
        }

        public Criteria andShelvesCountLessThan(Integer value) {
            addCriterion("shelves_count <", value, "shelvesCount");
            return (Criteria) this;
        }

        public Criteria andShelvesCountLessThanOrEqualTo(Integer value) {
            addCriterion("shelves_count <=", value, "shelvesCount");
            return (Criteria) this;
        }

        public Criteria andShelvesCountIn(List<Integer> values) {
            addCriterion("shelves_count in", values, "shelvesCount");
            return (Criteria) this;
        }

        public Criteria andShelvesCountNotIn(List<Integer> values) {
            addCriterion("shelves_count not in", values, "shelvesCount");
            return (Criteria) this;
        }

        public Criteria andShelvesCountBetween(Integer value1, Integer value2) {
            addCriterion("shelves_count between", value1, value2, "shelvesCount");
            return (Criteria) this;
        }

        public Criteria andShelvesCountNotBetween(Integer value1, Integer value2) {
            addCriterion("shelves_count not between", value1, value2, "shelvesCount");
            return (Criteria) this;
        }

        public Criteria andMerchantTotalIsNull() {
            addCriterion("merchant_total is null");
            return (Criteria) this;
        }

        public Criteria andMerchantTotalIsNotNull() {
            addCriterion("merchant_total is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantTotalEqualTo(Integer value) {
            addCriterion("merchant_total =", value, "merchantTotal");
            return (Criteria) this;
        }

        public Criteria andMerchantTotalNotEqualTo(Integer value) {
            addCriterion("merchant_total <>", value, "merchantTotal");
            return (Criteria) this;
        }

        public Criteria andMerchantTotalGreaterThan(Integer value) {
            addCriterion("merchant_total >", value, "merchantTotal");
            return (Criteria) this;
        }

        public Criteria andMerchantTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("merchant_total >=", value, "merchantTotal");
            return (Criteria) this;
        }

        public Criteria andMerchantTotalLessThan(Integer value) {
            addCriterion("merchant_total <", value, "merchantTotal");
            return (Criteria) this;
        }

        public Criteria andMerchantTotalLessThanOrEqualTo(Integer value) {
            addCriterion("merchant_total <=", value, "merchantTotal");
            return (Criteria) this;
        }

        public Criteria andMerchantTotalIn(List<Integer> values) {
            addCriterion("merchant_total in", values, "merchantTotal");
            return (Criteria) this;
        }

        public Criteria andMerchantTotalNotIn(List<Integer> values) {
            addCriterion("merchant_total not in", values, "merchantTotal");
            return (Criteria) this;
        }

        public Criteria andMerchantTotalBetween(Integer value1, Integer value2) {
            addCriterion("merchant_total between", value1, value2, "merchantTotal");
            return (Criteria) this;
        }

        public Criteria andMerchantTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("merchant_total not between", value1, value2, "merchantTotal");
            return (Criteria) this;
        }

        public Criteria andShelvesTotalIsNull() {
            addCriterion("shelves_total is null");
            return (Criteria) this;
        }

        public Criteria andShelvesTotalIsNotNull() {
            addCriterion("shelves_total is not null");
            return (Criteria) this;
        }

        public Criteria andShelvesTotalEqualTo(Integer value) {
            addCriterion("shelves_total =", value, "shelvesTotal");
            return (Criteria) this;
        }

        public Criteria andShelvesTotalNotEqualTo(Integer value) {
            addCriterion("shelves_total <>", value, "shelvesTotal");
            return (Criteria) this;
        }

        public Criteria andShelvesTotalGreaterThan(Integer value) {
            addCriterion("shelves_total >", value, "shelvesTotal");
            return (Criteria) this;
        }

        public Criteria andShelvesTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("shelves_total >=", value, "shelvesTotal");
            return (Criteria) this;
        }

        public Criteria andShelvesTotalLessThan(Integer value) {
            addCriterion("shelves_total <", value, "shelvesTotal");
            return (Criteria) this;
        }

        public Criteria andShelvesTotalLessThanOrEqualTo(Integer value) {
            addCriterion("shelves_total <=", value, "shelvesTotal");
            return (Criteria) this;
        }

        public Criteria andShelvesTotalIn(List<Integer> values) {
            addCriterion("shelves_total in", values, "shelvesTotal");
            return (Criteria) this;
        }

        public Criteria andShelvesTotalNotIn(List<Integer> values) {
            addCriterion("shelves_total not in", values, "shelvesTotal");
            return (Criteria) this;
        }

        public Criteria andShelvesTotalBetween(Integer value1, Integer value2) {
            addCriterion("shelves_total between", value1, value2, "shelvesTotal");
            return (Criteria) this;
        }

        public Criteria andShelvesTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("shelves_total not between", value1, value2, "shelvesTotal");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}