package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenFeeOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenFeeOrderExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andVerifyNoIsNull() {
            addCriterion("verify_no is null");
            return (Criteria) this;
        }

        public Criteria andVerifyNoIsNotNull() {
            addCriterion("verify_no is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyNoEqualTo(String value) {
            addCriterion("verify_no =", value, "verifyNo");
            return (Criteria) this;
        }

        public Criteria andVerifyNoNotEqualTo(String value) {
            addCriterion("verify_no <>", value, "verifyNo");
            return (Criteria) this;
        }

        public Criteria andVerifyNoGreaterThan(String value) {
            addCriterion("verify_no >", value, "verifyNo");
            return (Criteria) this;
        }

        public Criteria andVerifyNoGreaterThanOrEqualTo(String value) {
            addCriterion("verify_no >=", value, "verifyNo");
            return (Criteria) this;
        }

        public Criteria andVerifyNoLessThan(String value) {
            addCriterion("verify_no <", value, "verifyNo");
            return (Criteria) this;
        }

        public Criteria andVerifyNoLessThanOrEqualTo(String value) {
            addCriterion("verify_no <=", value, "verifyNo");
            return (Criteria) this;
        }

        public Criteria andVerifyNoLike(String value) {
            addCriterion("verify_no like", value, "verifyNo");
            return (Criteria) this;
        }

        public Criteria andVerifyNoNotLike(String value) {
            addCriterion("verify_no not like", value, "verifyNo");
            return (Criteria) this;
        }

        public Criteria andVerifyNoIn(List<String> values) {
            addCriterion("verify_no in", values, "verifyNo");
            return (Criteria) this;
        }

        public Criteria andVerifyNoNotIn(List<String> values) {
            addCriterion("verify_no not in", values, "verifyNo");
            return (Criteria) this;
        }

        public Criteria andVerifyNoBetween(String value1, String value2) {
            addCriterion("verify_no between", value1, value2, "verifyNo");
            return (Criteria) this;
        }

        public Criteria andVerifyNoNotBetween(String value1, String value2) {
            addCriterion("verify_no not between", value1, value2, "verifyNo");
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdIsNull() {
            addCriterion("store_order_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdIsNotNull() {
            addCriterion("store_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdEqualTo(Integer value) {
            addCriterion("store_order_id =", value, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdNotEqualTo(Integer value) {
            addCriterion("store_order_id <>", value, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdGreaterThan(Integer value) {
            addCriterion("store_order_id >", value, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_order_id >=", value, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdLessThan(Integer value) {
            addCriterion("store_order_id <", value, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_order_id <=", value, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdIn(List<Integer> values) {
            addCriterion("store_order_id in", values, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdNotIn(List<Integer> values) {
            addCriterion("store_order_id not in", values, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("store_order_id between", value1, value2, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_order_id not between", value1, value2, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNull() {
            addCriterion("trade_amount is null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNotNull() {
            addCriterion("trade_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountEqualTo(BigDecimal value) {
            addCriterion("trade_amount =", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotEqualTo(BigDecimal value) {
            addCriterion("trade_amount <>", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThan(BigDecimal value) {
            addCriterion("trade_amount >", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("trade_amount >=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThan(BigDecimal value) {
            addCriterion("trade_amount <", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("trade_amount <=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIn(List<BigDecimal> values) {
            addCriterion("trade_amount in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotIn(List<BigDecimal> values) {
            addCriterion("trade_amount not in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("trade_amount between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("trade_amount not between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeIsNull() {
            addCriterion("platform_charge is null");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeIsNotNull() {
            addCriterion("platform_charge is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeEqualTo(BigDecimal value) {
            addCriterion("platform_charge =", value, "platformCharge");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeNotEqualTo(BigDecimal value) {
            addCriterion("platform_charge <>", value, "platformCharge");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeGreaterThan(BigDecimal value) {
            addCriterion("platform_charge >", value, "platformCharge");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_charge >=", value, "platformCharge");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeLessThan(BigDecimal value) {
            addCriterion("platform_charge <", value, "platformCharge");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_charge <=", value, "platformCharge");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeIn(List<BigDecimal> values) {
            addCriterion("platform_charge in", values, "platformCharge");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeNotIn(List<BigDecimal> values) {
            addCriterion("platform_charge not in", values, "platformCharge");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_charge between", value1, value2, "platformCharge");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_charge not between", value1, value2, "platformCharge");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeRateIsNull() {
            addCriterion("platform_charge_rate is null");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeRateIsNotNull() {
            addCriterion("platform_charge_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeRateEqualTo(BigDecimal value) {
            addCriterion("platform_charge_rate =", value, "platformChargeRate");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeRateNotEqualTo(BigDecimal value) {
            addCriterion("platform_charge_rate <>", value, "platformChargeRate");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeRateGreaterThan(BigDecimal value) {
            addCriterion("platform_charge_rate >", value, "platformChargeRate");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_charge_rate >=", value, "platformChargeRate");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeRateLessThan(BigDecimal value) {
            addCriterion("platform_charge_rate <", value, "platformChargeRate");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_charge_rate <=", value, "platformChargeRate");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeRateIn(List<BigDecimal> values) {
            addCriterion("platform_charge_rate in", values, "platformChargeRate");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeRateNotIn(List<BigDecimal> values) {
            addCriterion("platform_charge_rate not in", values, "platformChargeRate");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_charge_rate between", value1, value2, "platformChargeRate");
            return (Criteria) this;
        }

        public Criteria andPlatformChargeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_charge_rate not between", value1, value2, "platformChargeRate");
            return (Criteria) this;
        }

        public Criteria andServiceChargeIsNull() {
            addCriterion("service_charge is null");
            return (Criteria) this;
        }

        public Criteria andServiceChargeIsNotNull() {
            addCriterion("service_charge is not null");
            return (Criteria) this;
        }

        public Criteria andServiceChargeEqualTo(BigDecimal value) {
            addCriterion("service_charge =", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeNotEqualTo(BigDecimal value) {
            addCriterion("service_charge <>", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeGreaterThan(BigDecimal value) {
            addCriterion("service_charge >", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("service_charge >=", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeLessThan(BigDecimal value) {
            addCriterion("service_charge <", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("service_charge <=", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeIn(List<BigDecimal> values) {
            addCriterion("service_charge in", values, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeNotIn(List<BigDecimal> values) {
            addCriterion("service_charge not in", values, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_charge between", value1, value2, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_charge not between", value1, value2, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeRateIsNull() {
            addCriterion("service_charge_rate is null");
            return (Criteria) this;
        }

        public Criteria andServiceChargeRateIsNotNull() {
            addCriterion("service_charge_rate is not null");
            return (Criteria) this;
        }

        public Criteria andServiceChargeRateEqualTo(BigDecimal value) {
            addCriterion("service_charge_rate =", value, "serviceChargeRate");
            return (Criteria) this;
        }

        public Criteria andServiceChargeRateNotEqualTo(BigDecimal value) {
            addCriterion("service_charge_rate <>", value, "serviceChargeRate");
            return (Criteria) this;
        }

        public Criteria andServiceChargeRateGreaterThan(BigDecimal value) {
            addCriterion("service_charge_rate >", value, "serviceChargeRate");
            return (Criteria) this;
        }

        public Criteria andServiceChargeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("service_charge_rate >=", value, "serviceChargeRate");
            return (Criteria) this;
        }

        public Criteria andServiceChargeRateLessThan(BigDecimal value) {
            addCriterion("service_charge_rate <", value, "serviceChargeRate");
            return (Criteria) this;
        }

        public Criteria andServiceChargeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("service_charge_rate <=", value, "serviceChargeRate");
            return (Criteria) this;
        }

        public Criteria andServiceChargeRateIn(List<BigDecimal> values) {
            addCriterion("service_charge_rate in", values, "serviceChargeRate");
            return (Criteria) this;
        }

        public Criteria andServiceChargeRateNotIn(List<BigDecimal> values) {
            addCriterion("service_charge_rate not in", values, "serviceChargeRate");
            return (Criteria) this;
        }

        public Criteria andServiceChargeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_charge_rate between", value1, value2, "serviceChargeRate");
            return (Criteria) this;
        }

        public Criteria andServiceChargeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_charge_rate not between", value1, value2, "serviceChargeRate");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNull() {
            addCriterion("pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNotNull() {
            addCriterion("pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmountEqualTo(BigDecimal value) {
            addCriterion("pay_amount =", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotEqualTo(BigDecimal value) {
            addCriterion("pay_amount <>", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThan(BigDecimal value) {
            addCriterion("pay_amount >", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_amount >=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThan(BigDecimal value) {
            addCriterion("pay_amount <", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_amount <=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountIn(List<BigDecimal> values) {
            addCriterion("pay_amount in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotIn(List<BigDecimal> values) {
            addCriterion("pay_amount not in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_amount between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_amount not between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayIdIsNull() {
            addCriterion("pay_id is null");
            return (Criteria) this;
        }

        public Criteria andPayIdIsNotNull() {
            addCriterion("pay_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayIdEqualTo(Long value) {
            addCriterion("pay_id =", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotEqualTo(Long value) {
            addCriterion("pay_id <>", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThan(Long value) {
            addCriterion("pay_id >", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_id >=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThan(Long value) {
            addCriterion("pay_id <", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThanOrEqualTo(Long value) {
            addCriterion("pay_id <=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdIn(List<Long> values) {
            addCriterion("pay_id in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotIn(List<Long> values) {
            addCriterion("pay_id not in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdBetween(Long value1, Long value2) {
            addCriterion("pay_id between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotBetween(Long value1, Long value2) {
            addCriterion("pay_id not between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(String value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(String value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(String value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(String value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(String value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLike(String value) {
            addCriterion("pay_status like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotLike(String value) {
            addCriterion("pay_status not like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<String> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<String> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(String value1, String value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(String value1, String value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andOrderExplainIsNull() {
            addCriterion("order_explain is null");
            return (Criteria) this;
        }

        public Criteria andOrderExplainIsNotNull() {
            addCriterion("order_explain is not null");
            return (Criteria) this;
        }

        public Criteria andOrderExplainEqualTo(String value) {
            addCriterion("order_explain =", value, "orderExplain");
            return (Criteria) this;
        }

        public Criteria andOrderExplainNotEqualTo(String value) {
            addCriterion("order_explain <>", value, "orderExplain");
            return (Criteria) this;
        }

        public Criteria andOrderExplainGreaterThan(String value) {
            addCriterion("order_explain >", value, "orderExplain");
            return (Criteria) this;
        }

        public Criteria andOrderExplainGreaterThanOrEqualTo(String value) {
            addCriterion("order_explain >=", value, "orderExplain");
            return (Criteria) this;
        }

        public Criteria andOrderExplainLessThan(String value) {
            addCriterion("order_explain <", value, "orderExplain");
            return (Criteria) this;
        }

        public Criteria andOrderExplainLessThanOrEqualTo(String value) {
            addCriterion("order_explain <=", value, "orderExplain");
            return (Criteria) this;
        }

        public Criteria andOrderExplainLike(String value) {
            addCriterion("order_explain like", value, "orderExplain");
            return (Criteria) this;
        }

        public Criteria andOrderExplainNotLike(String value) {
            addCriterion("order_explain not like", value, "orderExplain");
            return (Criteria) this;
        }

        public Criteria andOrderExplainIn(List<String> values) {
            addCriterion("order_explain in", values, "orderExplain");
            return (Criteria) this;
        }

        public Criteria andOrderExplainNotIn(List<String> values) {
            addCriterion("order_explain not in", values, "orderExplain");
            return (Criteria) this;
        }

        public Criteria andOrderExplainBetween(String value1, String value2) {
            addCriterion("order_explain between", value1, value2, "orderExplain");
            return (Criteria) this;
        }

        public Criteria andOrderExplainNotBetween(String value1, String value2) {
            addCriterion("order_explain not between", value1, value2, "orderExplain");
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