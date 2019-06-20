package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OpenStatsOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenStatsOrderExample() {
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

        public Criteria andCommunityIdIsNull() {
            addCriterion("community_id is null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIsNotNull() {
            addCriterion("community_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdEqualTo(Integer value) {
            addCriterion("community_id =", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotEqualTo(Integer value) {
            addCriterion("community_id <>", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThan(Integer value) {
            addCriterion("community_id >", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("community_id >=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThan(Integer value) {
            addCriterion("community_id <", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThanOrEqualTo(Integer value) {
            addCriterion("community_id <=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIn(List<Integer> values) {
            addCriterion("community_id in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotIn(List<Integer> values) {
            addCriterion("community_id not in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdBetween(Integer value1, Integer value2) {
            addCriterion("community_id between", value1, value2, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("community_id not between", value1, value2, "communityId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNull() {
            addCriterion("service_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("service_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(Integer value) {
            addCriterion("service_id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(Integer value) {
            addCriterion("service_id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(Integer value) {
            addCriterion("service_id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(Integer value) {
            addCriterion("service_id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(Integer value) {
            addCriterion("service_id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<Integer> values) {
            addCriterion("service_id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<Integer> values) {
            addCriterion("service_id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(Integer value1, Integer value2) {
            addCriterion("service_id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("service_id not between", value1, value2, "serviceId");
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

        public Criteria andOrderCountIsNull() {
            addCriterion("order_count is null");
            return (Criteria) this;
        }

        public Criteria andOrderCountIsNotNull() {
            addCriterion("order_count is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCountEqualTo(Integer value) {
            addCriterion("order_count =", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotEqualTo(Integer value) {
            addCriterion("order_count <>", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountGreaterThan(Integer value) {
            addCriterion("order_count >", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_count >=", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountLessThan(Integer value) {
            addCriterion("order_count <", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountLessThanOrEqualTo(Integer value) {
            addCriterion("order_count <=", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountIn(List<Integer> values) {
            addCriterion("order_count in", values, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotIn(List<Integer> values) {
            addCriterion("order_count not in", values, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountBetween(Integer value1, Integer value2) {
            addCriterion("order_count between", value1, value2, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_count not between", value1, value2, "orderCount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderCountTotalIsNull() {
            addCriterion("order_count_total is null");
            return (Criteria) this;
        }

        public Criteria andOrderCountTotalIsNotNull() {
            addCriterion("order_count_total is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCountTotalEqualTo(Integer value) {
            addCriterion("order_count_total =", value, "orderCountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderCountTotalNotEqualTo(Integer value) {
            addCriterion("order_count_total <>", value, "orderCountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderCountTotalGreaterThan(Integer value) {
            addCriterion("order_count_total >", value, "orderCountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderCountTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_count_total >=", value, "orderCountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderCountTotalLessThan(Integer value) {
            addCriterion("order_count_total <", value, "orderCountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderCountTotalLessThanOrEqualTo(Integer value) {
            addCriterion("order_count_total <=", value, "orderCountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderCountTotalIn(List<Integer> values) {
            addCriterion("order_count_total in", values, "orderCountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderCountTotalNotIn(List<Integer> values) {
            addCriterion("order_count_total not in", values, "orderCountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderCountTotalBetween(Integer value1, Integer value2) {
            addCriterion("order_count_total between", value1, value2, "orderCountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderCountTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("order_count_total not between", value1, value2, "orderCountTotal");
            return (Criteria) this;
        }

        public Criteria andTotalAmountTotalIsNull() {
            addCriterion("total_amount_total is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountTotalIsNotNull() {
            addCriterion("total_amount_total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountTotalEqualTo(BigDecimal value) {
            addCriterion("total_amount_total =", value, "totalAmountTotal");
            return (Criteria) this;
        }

        public Criteria andTotalAmountTotalNotEqualTo(BigDecimal value) {
            addCriterion("total_amount_total <>", value, "totalAmountTotal");
            return (Criteria) this;
        }

        public Criteria andTotalAmountTotalGreaterThan(BigDecimal value) {
            addCriterion("total_amount_total >", value, "totalAmountTotal");
            return (Criteria) this;
        }

        public Criteria andTotalAmountTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount_total >=", value, "totalAmountTotal");
            return (Criteria) this;
        }

        public Criteria andTotalAmountTotalLessThan(BigDecimal value) {
            addCriterion("total_amount_total <", value, "totalAmountTotal");
            return (Criteria) this;
        }

        public Criteria andTotalAmountTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount_total <=", value, "totalAmountTotal");
            return (Criteria) this;
        }

        public Criteria andTotalAmountTotalIn(List<BigDecimal> values) {
            addCriterion("total_amount_total in", values, "totalAmountTotal");
            return (Criteria) this;
        }

        public Criteria andTotalAmountTotalNotIn(List<BigDecimal> values) {
            addCriterion("total_amount_total not in", values, "totalAmountTotal");
            return (Criteria) this;
        }

        public Criteria andTotalAmountTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount_total between", value1, value2, "totalAmountTotal");
            return (Criteria) this;
        }

        public Criteria andTotalAmountTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount_total not between", value1, value2, "totalAmountTotal");
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