package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CmStoreCouponExtendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CmStoreCouponExtendExample() {
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

        public Criteria andCardItemIdIsNull() {
            addCriterion("card_item_id is null");
            return (Criteria) this;
        }

        public Criteria andCardItemIdIsNotNull() {
            addCriterion("card_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardItemIdEqualTo(Long value) {
            addCriterion("card_item_id =", value, "cardItemId");
            return (Criteria) this;
        }

        public Criteria andCardItemIdNotEqualTo(Long value) {
            addCriterion("card_item_id <>", value, "cardItemId");
            return (Criteria) this;
        }

        public Criteria andCardItemIdGreaterThan(Long value) {
            addCriterion("card_item_id >", value, "cardItemId");
            return (Criteria) this;
        }

        public Criteria andCardItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("card_item_id >=", value, "cardItemId");
            return (Criteria) this;
        }

        public Criteria andCardItemIdLessThan(Long value) {
            addCriterion("card_item_id <", value, "cardItemId");
            return (Criteria) this;
        }

        public Criteria andCardItemIdLessThanOrEqualTo(Long value) {
            addCriterion("card_item_id <=", value, "cardItemId");
            return (Criteria) this;
        }

        public Criteria andCardItemIdIn(List<Long> values) {
            addCriterion("card_item_id in", values, "cardItemId");
            return (Criteria) this;
        }

        public Criteria andCardItemIdNotIn(List<Long> values) {
            addCriterion("card_item_id not in", values, "cardItemId");
            return (Criteria) this;
        }

        public Criteria andCardItemIdBetween(Long value1, Long value2) {
            addCriterion("card_item_id between", value1, value2, "cardItemId");
            return (Criteria) this;
        }

        public Criteria andCardItemIdNotBetween(Long value1, Long value2) {
            addCriterion("card_item_id not between", value1, value2, "cardItemId");
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

        public Criteria andMerchantIdIsNull() {
            addCriterion("merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNotNull() {
            addCriterion("merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdEqualTo(Long value) {
            addCriterion("merchant_id =", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotEqualTo(Long value) {
            addCriterion("merchant_id <>", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThan(Long value) {
            addCriterion("merchant_id >", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("merchant_id >=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThan(Long value) {
            addCriterion("merchant_id <", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThanOrEqualTo(Long value) {
            addCriterion("merchant_id <=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIn(List<Long> values) {
            addCriterion("merchant_id in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotIn(List<Long> values) {
            addCriterion("merchant_id not in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdBetween(Long value1, Long value2) {
            addCriterion("merchant_id between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotBetween(Long value1, Long value2) {
            addCriterion("merchant_id not between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyIsNull() {
            addCriterion("limit_money is null");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyIsNotNull() {
            addCriterion("limit_money is not null");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyEqualTo(BigDecimal value) {
            addCriterion("limit_money =", value, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyNotEqualTo(BigDecimal value) {
            addCriterion("limit_money <>", value, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyGreaterThan(BigDecimal value) {
            addCriterion("limit_money >", value, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("limit_money >=", value, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyLessThan(BigDecimal value) {
            addCriterion("limit_money <", value, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("limit_money <=", value, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyIn(List<BigDecimal> values) {
            addCriterion("limit_money in", values, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyNotIn(List<BigDecimal> values) {
            addCriterion("limit_money not in", values, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("limit_money between", value1, value2, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("limit_money not between", value1, value2, "limitMoney");
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