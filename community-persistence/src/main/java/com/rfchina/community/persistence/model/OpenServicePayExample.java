package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OpenServicePayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenServicePayExample() {
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

        public Criteria andPlatformFeeIsNull() {
            addCriterion("platform_fee is null");
            return (Criteria) this;
        }

        public Criteria andPlatformFeeIsNotNull() {
            addCriterion("platform_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformFeeEqualTo(BigDecimal value) {
            addCriterion("platform_fee =", value, "platformFee");
            return (Criteria) this;
        }

        public Criteria andPlatformFeeNotEqualTo(BigDecimal value) {
            addCriterion("platform_fee <>", value, "platformFee");
            return (Criteria) this;
        }

        public Criteria andPlatformFeeGreaterThan(BigDecimal value) {
            addCriterion("platform_fee >", value, "platformFee");
            return (Criteria) this;
        }

        public Criteria andPlatformFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_fee >=", value, "platformFee");
            return (Criteria) this;
        }

        public Criteria andPlatformFeeLessThan(BigDecimal value) {
            addCriterion("platform_fee <", value, "platformFee");
            return (Criteria) this;
        }

        public Criteria andPlatformFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_fee <=", value, "platformFee");
            return (Criteria) this;
        }

        public Criteria andPlatformFeeIn(List<BigDecimal> values) {
            addCriterion("platform_fee in", values, "platformFee");
            return (Criteria) this;
        }

        public Criteria andPlatformFeeNotIn(List<BigDecimal> values) {
            addCriterion("platform_fee not in", values, "platformFee");
            return (Criteria) this;
        }

        public Criteria andPlatformFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_fee between", value1, value2, "platformFee");
            return (Criteria) this;
        }

        public Criteria andPlatformFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_fee not between", value1, value2, "platformFee");
            return (Criteria) this;
        }

        public Criteria andThinkRateIsNull() {
            addCriterion("think_rate is null");
            return (Criteria) this;
        }

        public Criteria andThinkRateIsNotNull() {
            addCriterion("think_rate is not null");
            return (Criteria) this;
        }

        public Criteria andThinkRateEqualTo(BigDecimal value) {
            addCriterion("think_rate =", value, "thinkRate");
            return (Criteria) this;
        }

        public Criteria andThinkRateNotEqualTo(BigDecimal value) {
            addCriterion("think_rate <>", value, "thinkRate");
            return (Criteria) this;
        }

        public Criteria andThinkRateGreaterThan(BigDecimal value) {
            addCriterion("think_rate >", value, "thinkRate");
            return (Criteria) this;
        }

        public Criteria andThinkRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("think_rate >=", value, "thinkRate");
            return (Criteria) this;
        }

        public Criteria andThinkRateLessThan(BigDecimal value) {
            addCriterion("think_rate <", value, "thinkRate");
            return (Criteria) this;
        }

        public Criteria andThinkRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("think_rate <=", value, "thinkRate");
            return (Criteria) this;
        }

        public Criteria andThinkRateIn(List<BigDecimal> values) {
            addCriterion("think_rate in", values, "thinkRate");
            return (Criteria) this;
        }

        public Criteria andThinkRateNotIn(List<BigDecimal> values) {
            addCriterion("think_rate not in", values, "thinkRate");
            return (Criteria) this;
        }

        public Criteria andThinkRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("think_rate between", value1, value2, "thinkRate");
            return (Criteria) this;
        }

        public Criteria andThinkRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("think_rate not between", value1, value2, "thinkRate");
            return (Criteria) this;
        }

        public Criteria andCommunityRateIsNull() {
            addCriterion("community_rate is null");
            return (Criteria) this;
        }

        public Criteria andCommunityRateIsNotNull() {
            addCriterion("community_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityRateEqualTo(BigDecimal value) {
            addCriterion("community_rate =", value, "communityRate");
            return (Criteria) this;
        }

        public Criteria andCommunityRateNotEqualTo(BigDecimal value) {
            addCriterion("community_rate <>", value, "communityRate");
            return (Criteria) this;
        }

        public Criteria andCommunityRateGreaterThan(BigDecimal value) {
            addCriterion("community_rate >", value, "communityRate");
            return (Criteria) this;
        }

        public Criteria andCommunityRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("community_rate >=", value, "communityRate");
            return (Criteria) this;
        }

        public Criteria andCommunityRateLessThan(BigDecimal value) {
            addCriterion("community_rate <", value, "communityRate");
            return (Criteria) this;
        }

        public Criteria andCommunityRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("community_rate <=", value, "communityRate");
            return (Criteria) this;
        }

        public Criteria andCommunityRateIn(List<BigDecimal> values) {
            addCriterion("community_rate in", values, "communityRate");
            return (Criteria) this;
        }

        public Criteria andCommunityRateNotIn(List<BigDecimal> values) {
            addCriterion("community_rate not in", values, "communityRate");
            return (Criteria) this;
        }

        public Criteria andCommunityRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("community_rate between", value1, value2, "communityRate");
            return (Criteria) this;
        }

        public Criteria andCommunityRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("community_rate not between", value1, value2, "communityRate");
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