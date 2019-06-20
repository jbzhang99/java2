package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenSettlementApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenSettlementApplyExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andSettlementIdIsNull() {
            addCriterion("settlement_id is null");
            return (Criteria) this;
        }

        public Criteria andSettlementIdIsNotNull() {
            addCriterion("settlement_id is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementIdEqualTo(String value) {
            addCriterion("settlement_id =", value, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdNotEqualTo(String value) {
            addCriterion("settlement_id <>", value, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdGreaterThan(String value) {
            addCriterion("settlement_id >", value, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_id >=", value, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdLessThan(String value) {
            addCriterion("settlement_id <", value, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdLessThanOrEqualTo(String value) {
            addCriterion("settlement_id <=", value, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdLike(String value) {
            addCriterion("settlement_id like", value, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdNotLike(String value) {
            addCriterion("settlement_id not like", value, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdIn(List<String> values) {
            addCriterion("settlement_id in", values, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdNotIn(List<String> values) {
            addCriterion("settlement_id not in", values, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdBetween(String value1, String value2) {
            addCriterion("settlement_id between", value1, value2, "settlementId");
            return (Criteria) this;
        }

        public Criteria andSettlementIdNotBetween(String value1, String value2) {
            addCriterion("settlement_id not between", value1, value2, "settlementId");
            return (Criteria) this;
        }

        public Criteria andOrderAmountCountIsNull() {
            addCriterion("order_amount_count is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountCountIsNotNull() {
            addCriterion("order_amount_count is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountCountEqualTo(BigDecimal value) {
            addCriterion("order_amount_count =", value, "orderAmountCount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountCountNotEqualTo(BigDecimal value) {
            addCriterion("order_amount_count <>", value, "orderAmountCount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountCountGreaterThan(BigDecimal value) {
            addCriterion("order_amount_count >", value, "orderAmountCount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount_count >=", value, "orderAmountCount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountCountLessThan(BigDecimal value) {
            addCriterion("order_amount_count <", value, "orderAmountCount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount_count <=", value, "orderAmountCount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountCountIn(List<BigDecimal> values) {
            addCriterion("order_amount_count in", values, "orderAmountCount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountCountNotIn(List<BigDecimal> values) {
            addCriterion("order_amount_count not in", values, "orderAmountCount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount_count between", value1, value2, "orderAmountCount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount_count not between", value1, value2, "orderAmountCount");
            return (Criteria) this;
        }

        public Criteria andPlatformPoundageAmountIsNull() {
            addCriterion("platform_poundage_amount is null");
            return (Criteria) this;
        }

        public Criteria andPlatformPoundageAmountIsNotNull() {
            addCriterion("platform_poundage_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformPoundageAmountEqualTo(BigDecimal value) {
            addCriterion("platform_poundage_amount =", value, "platformPoundageAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformPoundageAmountNotEqualTo(BigDecimal value) {
            addCriterion("platform_poundage_amount <>", value, "platformPoundageAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformPoundageAmountGreaterThan(BigDecimal value) {
            addCriterion("platform_poundage_amount >", value, "platformPoundageAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformPoundageAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_poundage_amount >=", value, "platformPoundageAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformPoundageAmountLessThan(BigDecimal value) {
            addCriterion("platform_poundage_amount <", value, "platformPoundageAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformPoundageAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_poundage_amount <=", value, "platformPoundageAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformPoundageAmountIn(List<BigDecimal> values) {
            addCriterion("platform_poundage_amount in", values, "platformPoundageAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformPoundageAmountNotIn(List<BigDecimal> values) {
            addCriterion("platform_poundage_amount not in", values, "platformPoundageAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformPoundageAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_poundage_amount between", value1, value2, "platformPoundageAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformPoundageAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_poundage_amount not between", value1, value2, "platformPoundageAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountIsNull() {
            addCriterion("platform_commission_amount is null");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountIsNotNull() {
            addCriterion("platform_commission_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountEqualTo(BigDecimal value) {
            addCriterion("platform_commission_amount =", value, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountNotEqualTo(BigDecimal value) {
            addCriterion("platform_commission_amount <>", value, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountGreaterThan(BigDecimal value) {
            addCriterion("platform_commission_amount >", value, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_commission_amount >=", value, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountLessThan(BigDecimal value) {
            addCriterion("platform_commission_amount <", value, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_commission_amount <=", value, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountIn(List<BigDecimal> values) {
            addCriterion("platform_commission_amount in", values, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountNotIn(List<BigDecimal> values) {
            addCriterion("platform_commission_amount not in", values, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_commission_amount between", value1, value2, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_commission_amount not between", value1, value2, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformThinkAmountIsNull() {
            addCriterion("platform_think_amount is null");
            return (Criteria) this;
        }

        public Criteria andPlatformThinkAmountIsNotNull() {
            addCriterion("platform_think_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformThinkAmountEqualTo(BigDecimal value) {
            addCriterion("platform_think_amount =", value, "platformThinkAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformThinkAmountNotEqualTo(BigDecimal value) {
            addCriterion("platform_think_amount <>", value, "platformThinkAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformThinkAmountGreaterThan(BigDecimal value) {
            addCriterion("platform_think_amount >", value, "platformThinkAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformThinkAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_think_amount >=", value, "platformThinkAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformThinkAmountLessThan(BigDecimal value) {
            addCriterion("platform_think_amount <", value, "platformThinkAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformThinkAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_think_amount <=", value, "platformThinkAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformThinkAmountIn(List<BigDecimal> values) {
            addCriterion("platform_think_amount in", values, "platformThinkAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformThinkAmountNotIn(List<BigDecimal> values) {
            addCriterion("platform_think_amount not in", values, "platformThinkAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformThinkAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_think_amount between", value1, value2, "platformThinkAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformThinkAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_think_amount not between", value1, value2, "platformThinkAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountCountIsNull() {
            addCriterion("settlement_amount_count is null");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountCountIsNotNull() {
            addCriterion("settlement_amount_count is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountCountEqualTo(BigDecimal value) {
            addCriterion("settlement_amount_count =", value, "settlementAmountCount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountCountNotEqualTo(BigDecimal value) {
            addCriterion("settlement_amount_count <>", value, "settlementAmountCount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountCountGreaterThan(BigDecimal value) {
            addCriterion("settlement_amount_count >", value, "settlementAmountCount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("settlement_amount_count >=", value, "settlementAmountCount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountCountLessThan(BigDecimal value) {
            addCriterion("settlement_amount_count <", value, "settlementAmountCount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("settlement_amount_count <=", value, "settlementAmountCount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountCountIn(List<BigDecimal> values) {
            addCriterion("settlement_amount_count in", values, "settlementAmountCount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountCountNotIn(List<BigDecimal> values) {
            addCriterion("settlement_amount_count not in", values, "settlementAmountCount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settlement_amount_count between", value1, value2, "settlementAmountCount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settlement_amount_count not between", value1, value2, "settlementAmountCount");
            return (Criteria) this;
        }

        public Criteria andPaidSettlementAmountIsNull() {
            addCriterion("paid_settlement_amount is null");
            return (Criteria) this;
        }

        public Criteria andPaidSettlementAmountIsNotNull() {
            addCriterion("paid_settlement_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPaidSettlementAmountEqualTo(BigDecimal value) {
            addCriterion("paid_settlement_amount =", value, "paidSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andPaidSettlementAmountNotEqualTo(BigDecimal value) {
            addCriterion("paid_settlement_amount <>", value, "paidSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andPaidSettlementAmountGreaterThan(BigDecimal value) {
            addCriterion("paid_settlement_amount >", value, "paidSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andPaidSettlementAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("paid_settlement_amount >=", value, "paidSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andPaidSettlementAmountLessThan(BigDecimal value) {
            addCriterion("paid_settlement_amount <", value, "paidSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andPaidSettlementAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("paid_settlement_amount <=", value, "paidSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andPaidSettlementAmountIn(List<BigDecimal> values) {
            addCriterion("paid_settlement_amount in", values, "paidSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andPaidSettlementAmountNotIn(List<BigDecimal> values) {
            addCriterion("paid_settlement_amount not in", values, "paidSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andPaidSettlementAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paid_settlement_amount between", value1, value2, "paidSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andPaidSettlementAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paid_settlement_amount not between", value1, value2, "paidSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyIsNull() {
            addCriterion("refund_money is null");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyIsNotNull() {
            addCriterion("refund_money is not null");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyEqualTo(BigDecimal value) {
            addCriterion("refund_money =", value, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyNotEqualTo(BigDecimal value) {
            addCriterion("refund_money <>", value, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyGreaterThan(BigDecimal value) {
            addCriterion("refund_money >", value, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_money >=", value, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyLessThan(BigDecimal value) {
            addCriterion("refund_money <", value, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_money <=", value, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyIn(List<BigDecimal> values) {
            addCriterion("refund_money in", values, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyNotIn(List<BigDecimal> values) {
            addCriterion("refund_money not in", values, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_money between", value1, value2, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_money not between", value1, value2, "refundMoney");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andAuditTimeIsNull() {
            addCriterion("audit_time is null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNotNull() {
            addCriterion("audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeEqualTo(Date value) {
            addCriterion("audit_time =", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotEqualTo(Date value) {
            addCriterion("audit_time <>", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThan(Date value) {
            addCriterion("audit_time >", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_time >=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThan(Date value) {
            addCriterion("audit_time <", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("audit_time <=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIn(List<Date> values) {
            addCriterion("audit_time in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotIn(List<Date> values) {
            addCriterion("audit_time not in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeBetween(Date value1, Date value2) {
            addCriterion("audit_time between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("audit_time not between", value1, value2, "auditTime");
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

        public Criteria andInvoiceTitleIsNull() {
            addCriterion("invoice_title is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIsNotNull() {
            addCriterion("invoice_title is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleEqualTo(String value) {
            addCriterion("invoice_title =", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotEqualTo(String value) {
            addCriterion("invoice_title <>", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleGreaterThan(String value) {
            addCriterion("invoice_title >", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_title >=", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLessThan(String value) {
            addCriterion("invoice_title <", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLessThanOrEqualTo(String value) {
            addCriterion("invoice_title <=", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLike(String value) {
            addCriterion("invoice_title like", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotLike(String value) {
            addCriterion("invoice_title not like", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIn(List<String> values) {
            addCriterion("invoice_title in", values, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotIn(List<String> values) {
            addCriterion("invoice_title not in", values, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleBetween(String value1, String value2) {
            addCriterion("invoice_title between", value1, value2, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotBetween(String value1, String value2) {
            addCriterion("invoice_title not between", value1, value2, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andContactsNameIsNull() {
            addCriterion("contacts_name is null");
            return (Criteria) this;
        }

        public Criteria andContactsNameIsNotNull() {
            addCriterion("contacts_name is not null");
            return (Criteria) this;
        }

        public Criteria andContactsNameEqualTo(String value) {
            addCriterion("contacts_name =", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameNotEqualTo(String value) {
            addCriterion("contacts_name <>", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameGreaterThan(String value) {
            addCriterion("contacts_name >", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameGreaterThanOrEqualTo(String value) {
            addCriterion("contacts_name >=", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameLessThan(String value) {
            addCriterion("contacts_name <", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameLessThanOrEqualTo(String value) {
            addCriterion("contacts_name <=", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameLike(String value) {
            addCriterion("contacts_name like", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameNotLike(String value) {
            addCriterion("contacts_name not like", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameIn(List<String> values) {
            addCriterion("contacts_name in", values, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameNotIn(List<String> values) {
            addCriterion("contacts_name not in", values, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameBetween(String value1, String value2) {
            addCriterion("contacts_name between", value1, value2, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameNotBetween(String value1, String value2) {
            addCriterion("contacts_name not between", value1, value2, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneIsNull() {
            addCriterion("contacts_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneIsNotNull() {
            addCriterion("contacts_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneEqualTo(String value) {
            addCriterion("contacts_phone =", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneNotEqualTo(String value) {
            addCriterion("contacts_phone <>", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneGreaterThan(String value) {
            addCriterion("contacts_phone >", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contacts_phone >=", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneLessThan(String value) {
            addCriterion("contacts_phone <", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneLessThanOrEqualTo(String value) {
            addCriterion("contacts_phone <=", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneLike(String value) {
            addCriterion("contacts_phone like", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneNotLike(String value) {
            addCriterion("contacts_phone not like", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneIn(List<String> values) {
            addCriterion("contacts_phone in", values, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneNotIn(List<String> values) {
            addCriterion("contacts_phone not in", values, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneBetween(String value1, String value2) {
            addCriterion("contacts_phone between", value1, value2, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneNotBetween(String value1, String value2) {
            addCriterion("contacts_phone not between", value1, value2, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andMailingAddressIsNull() {
            addCriterion("mailing_address is null");
            return (Criteria) this;
        }

        public Criteria andMailingAddressIsNotNull() {
            addCriterion("mailing_address is not null");
            return (Criteria) this;
        }

        public Criteria andMailingAddressEqualTo(String value) {
            addCriterion("mailing_address =", value, "mailingAddress");
            return (Criteria) this;
        }

        public Criteria andMailingAddressNotEqualTo(String value) {
            addCriterion("mailing_address <>", value, "mailingAddress");
            return (Criteria) this;
        }

        public Criteria andMailingAddressGreaterThan(String value) {
            addCriterion("mailing_address >", value, "mailingAddress");
            return (Criteria) this;
        }

        public Criteria andMailingAddressGreaterThanOrEqualTo(String value) {
            addCriterion("mailing_address >=", value, "mailingAddress");
            return (Criteria) this;
        }

        public Criteria andMailingAddressLessThan(String value) {
            addCriterion("mailing_address <", value, "mailingAddress");
            return (Criteria) this;
        }

        public Criteria andMailingAddressLessThanOrEqualTo(String value) {
            addCriterion("mailing_address <=", value, "mailingAddress");
            return (Criteria) this;
        }

        public Criteria andMailingAddressLike(String value) {
            addCriterion("mailing_address like", value, "mailingAddress");
            return (Criteria) this;
        }

        public Criteria andMailingAddressNotLike(String value) {
            addCriterion("mailing_address not like", value, "mailingAddress");
            return (Criteria) this;
        }

        public Criteria andMailingAddressIn(List<String> values) {
            addCriterion("mailing_address in", values, "mailingAddress");
            return (Criteria) this;
        }

        public Criteria andMailingAddressNotIn(List<String> values) {
            addCriterion("mailing_address not in", values, "mailingAddress");
            return (Criteria) this;
        }

        public Criteria andMailingAddressBetween(String value1, String value2) {
            addCriterion("mailing_address between", value1, value2, "mailingAddress");
            return (Criteria) this;
        }

        public Criteria andMailingAddressNotBetween(String value1, String value2) {
            addCriterion("mailing_address not between", value1, value2, "mailingAddress");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusIsNull() {
            addCriterion("invoice_status is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusIsNotNull() {
            addCriterion("invoice_status is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusEqualTo(Integer value) {
            addCriterion("invoice_status =", value, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusNotEqualTo(Integer value) {
            addCriterion("invoice_status <>", value, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusGreaterThan(Integer value) {
            addCriterion("invoice_status >", value, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("invoice_status >=", value, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusLessThan(Integer value) {
            addCriterion("invoice_status <", value, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusLessThanOrEqualTo(Integer value) {
            addCriterion("invoice_status <=", value, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusIn(List<Integer> values) {
            addCriterion("invoice_status in", values, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusNotIn(List<Integer> values) {
            addCriterion("invoice_status not in", values, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusBetween(Integer value1, Integer value2) {
            addCriterion("invoice_status between", value1, value2, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("invoice_status not between", value1, value2, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStartTimeIsNull() {
            addCriterion("settlement_start_time is null");
            return (Criteria) this;
        }

        public Criteria andSettlementStartTimeIsNotNull() {
            addCriterion("settlement_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementStartTimeEqualTo(Date value) {
            addCriterion("settlement_start_time =", value, "settlementStartTime");
            return (Criteria) this;
        }

        public Criteria andSettlementStartTimeNotEqualTo(Date value) {
            addCriterion("settlement_start_time <>", value, "settlementStartTime");
            return (Criteria) this;
        }

        public Criteria andSettlementStartTimeGreaterThan(Date value) {
            addCriterion("settlement_start_time >", value, "settlementStartTime");
            return (Criteria) this;
        }

        public Criteria andSettlementStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("settlement_start_time >=", value, "settlementStartTime");
            return (Criteria) this;
        }

        public Criteria andSettlementStartTimeLessThan(Date value) {
            addCriterion("settlement_start_time <", value, "settlementStartTime");
            return (Criteria) this;
        }

        public Criteria andSettlementStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("settlement_start_time <=", value, "settlementStartTime");
            return (Criteria) this;
        }

        public Criteria andSettlementStartTimeIn(List<Date> values) {
            addCriterion("settlement_start_time in", values, "settlementStartTime");
            return (Criteria) this;
        }

        public Criteria andSettlementStartTimeNotIn(List<Date> values) {
            addCriterion("settlement_start_time not in", values, "settlementStartTime");
            return (Criteria) this;
        }

        public Criteria andSettlementStartTimeBetween(Date value1, Date value2) {
            addCriterion("settlement_start_time between", value1, value2, "settlementStartTime");
            return (Criteria) this;
        }

        public Criteria andSettlementStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("settlement_start_time not between", value1, value2, "settlementStartTime");
            return (Criteria) this;
        }

        public Criteria andSettlementEndTimeIsNull() {
            addCriterion("settlement_end_time is null");
            return (Criteria) this;
        }

        public Criteria andSettlementEndTimeIsNotNull() {
            addCriterion("settlement_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementEndTimeEqualTo(Date value) {
            addCriterion("settlement_end_time =", value, "settlementEndTime");
            return (Criteria) this;
        }

        public Criteria andSettlementEndTimeNotEqualTo(Date value) {
            addCriterion("settlement_end_time <>", value, "settlementEndTime");
            return (Criteria) this;
        }

        public Criteria andSettlementEndTimeGreaterThan(Date value) {
            addCriterion("settlement_end_time >", value, "settlementEndTime");
            return (Criteria) this;
        }

        public Criteria andSettlementEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("settlement_end_time >=", value, "settlementEndTime");
            return (Criteria) this;
        }

        public Criteria andSettlementEndTimeLessThan(Date value) {
            addCriterion("settlement_end_time <", value, "settlementEndTime");
            return (Criteria) this;
        }

        public Criteria andSettlementEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("settlement_end_time <=", value, "settlementEndTime");
            return (Criteria) this;
        }

        public Criteria andSettlementEndTimeIn(List<Date> values) {
            addCriterion("settlement_end_time in", values, "settlementEndTime");
            return (Criteria) this;
        }

        public Criteria andSettlementEndTimeNotIn(List<Date> values) {
            addCriterion("settlement_end_time not in", values, "settlementEndTime");
            return (Criteria) this;
        }

        public Criteria andSettlementEndTimeBetween(Date value1, Date value2) {
            addCriterion("settlement_end_time between", value1, value2, "settlementEndTime");
            return (Criteria) this;
        }

        public Criteria andSettlementEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("settlement_end_time not between", value1, value2, "settlementEndTime");
            return (Criteria) this;
        }

        public Criteria andAuditCommentIsNull() {
            addCriterion("audit_comment is null");
            return (Criteria) this;
        }

        public Criteria andAuditCommentIsNotNull() {
            addCriterion("audit_comment is not null");
            return (Criteria) this;
        }

        public Criteria andAuditCommentEqualTo(String value) {
            addCriterion("audit_comment =", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentNotEqualTo(String value) {
            addCriterion("audit_comment <>", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentGreaterThan(String value) {
            addCriterion("audit_comment >", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentGreaterThanOrEqualTo(String value) {
            addCriterion("audit_comment >=", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentLessThan(String value) {
            addCriterion("audit_comment <", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentLessThanOrEqualTo(String value) {
            addCriterion("audit_comment <=", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentLike(String value) {
            addCriterion("audit_comment like", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentNotLike(String value) {
            addCriterion("audit_comment not like", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentIn(List<String> values) {
            addCriterion("audit_comment in", values, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentNotIn(List<String> values) {
            addCriterion("audit_comment not in", values, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentBetween(String value1, String value2) {
            addCriterion("audit_comment between", value1, value2, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentNotBetween(String value1, String value2) {
            addCriterion("audit_comment not between", value1, value2, "auditComment");
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

        public Criteria andInvoiceTypeIsNull() {
            addCriterion("invoice_type is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNotNull() {
            addCriterion("invoice_type is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeEqualTo(Integer value) {
            addCriterion("invoice_type =", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotEqualTo(Integer value) {
            addCriterion("invoice_type <>", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThan(Integer value) {
            addCriterion("invoice_type >", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("invoice_type >=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThan(Integer value) {
            addCriterion("invoice_type <", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("invoice_type <=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIn(List<Integer> values) {
            addCriterion("invoice_type in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotIn(List<Integer> values) {
            addCriterion("invoice_type not in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeBetween(Integer value1, Integer value2) {
            addCriterion("invoice_type between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("invoice_type not between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andTaxpayerCodeIsNull() {
            addCriterion("taxpayer_code is null");
            return (Criteria) this;
        }

        public Criteria andTaxpayerCodeIsNotNull() {
            addCriterion("taxpayer_code is not null");
            return (Criteria) this;
        }

        public Criteria andTaxpayerCodeEqualTo(String value) {
            addCriterion("taxpayer_code =", value, "taxpayerCode");
            return (Criteria) this;
        }

        public Criteria andTaxpayerCodeNotEqualTo(String value) {
            addCriterion("taxpayer_code <>", value, "taxpayerCode");
            return (Criteria) this;
        }

        public Criteria andTaxpayerCodeGreaterThan(String value) {
            addCriterion("taxpayer_code >", value, "taxpayerCode");
            return (Criteria) this;
        }

        public Criteria andTaxpayerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("taxpayer_code >=", value, "taxpayerCode");
            return (Criteria) this;
        }

        public Criteria andTaxpayerCodeLessThan(String value) {
            addCriterion("taxpayer_code <", value, "taxpayerCode");
            return (Criteria) this;
        }

        public Criteria andTaxpayerCodeLessThanOrEqualTo(String value) {
            addCriterion("taxpayer_code <=", value, "taxpayerCode");
            return (Criteria) this;
        }

        public Criteria andTaxpayerCodeLike(String value) {
            addCriterion("taxpayer_code like", value, "taxpayerCode");
            return (Criteria) this;
        }

        public Criteria andTaxpayerCodeNotLike(String value) {
            addCriterion("taxpayer_code not like", value, "taxpayerCode");
            return (Criteria) this;
        }

        public Criteria andTaxpayerCodeIn(List<String> values) {
            addCriterion("taxpayer_code in", values, "taxpayerCode");
            return (Criteria) this;
        }

        public Criteria andTaxpayerCodeNotIn(List<String> values) {
            addCriterion("taxpayer_code not in", values, "taxpayerCode");
            return (Criteria) this;
        }

        public Criteria andTaxpayerCodeBetween(String value1, String value2) {
            addCriterion("taxpayer_code between", value1, value2, "taxpayerCode");
            return (Criteria) this;
        }

        public Criteria andTaxpayerCodeNotBetween(String value1, String value2) {
            addCriterion("taxpayer_code not between", value1, value2, "taxpayerCode");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNull() {
            addCriterion("company_address is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNotNull() {
            addCriterion("company_address is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressEqualTo(String value) {
            addCriterion("company_address =", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotEqualTo(String value) {
            addCriterion("company_address <>", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThan(String value) {
            addCriterion("company_address >", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("company_address >=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThan(String value) {
            addCriterion("company_address <", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThanOrEqualTo(String value) {
            addCriterion("company_address <=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLike(String value) {
            addCriterion("company_address like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotLike(String value) {
            addCriterion("company_address not like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIn(List<String> values) {
            addCriterion("company_address in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotIn(List<String> values) {
            addCriterion("company_address not in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressBetween(String value1, String value2) {
            addCriterion("company_address between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotBetween(String value1, String value2) {
            addCriterion("company_address not between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneIsNull() {
            addCriterion("company_phone is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneIsNotNull() {
            addCriterion("company_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneEqualTo(String value) {
            addCriterion("company_phone =", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNotEqualTo(String value) {
            addCriterion("company_phone <>", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneGreaterThan(String value) {
            addCriterion("company_phone >", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("company_phone >=", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneLessThan(String value) {
            addCriterion("company_phone <", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneLessThanOrEqualTo(String value) {
            addCriterion("company_phone <=", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneLike(String value) {
            addCriterion("company_phone like", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNotLike(String value) {
            addCriterion("company_phone not like", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneIn(List<String> values) {
            addCriterion("company_phone in", values, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNotIn(List<String> values) {
            addCriterion("company_phone not in", values, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneBetween(String value1, String value2) {
            addCriterion("company_phone between", value1, value2, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNotBetween(String value1, String value2) {
            addCriterion("company_phone not between", value1, value2, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("bank_account is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("bank_account =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("bank_account <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("bank_account >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("bank_account <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_account <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("bank_account like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("bank_account not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("bank_account in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("bank_account not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("bank_account between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("bank_account not between", value1, value2, "bankAccount");
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

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andPlatformSettlementIdIsNull() {
            addCriterion("platform_settlement_id is null");
            return (Criteria) this;
        }

        public Criteria andPlatformSettlementIdIsNotNull() {
            addCriterion("platform_settlement_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformSettlementIdEqualTo(String value) {
            addCriterion("platform_settlement_id =", value, "platformSettlementId");
            return (Criteria) this;
        }

        public Criteria andPlatformSettlementIdNotEqualTo(String value) {
            addCriterion("platform_settlement_id <>", value, "platformSettlementId");
            return (Criteria) this;
        }

        public Criteria andPlatformSettlementIdGreaterThan(String value) {
            addCriterion("platform_settlement_id >", value, "platformSettlementId");
            return (Criteria) this;
        }

        public Criteria andPlatformSettlementIdGreaterThanOrEqualTo(String value) {
            addCriterion("platform_settlement_id >=", value, "platformSettlementId");
            return (Criteria) this;
        }

        public Criteria andPlatformSettlementIdLessThan(String value) {
            addCriterion("platform_settlement_id <", value, "platformSettlementId");
            return (Criteria) this;
        }

        public Criteria andPlatformSettlementIdLessThanOrEqualTo(String value) {
            addCriterion("platform_settlement_id <=", value, "platformSettlementId");
            return (Criteria) this;
        }

        public Criteria andPlatformSettlementIdLike(String value) {
            addCriterion("platform_settlement_id like", value, "platformSettlementId");
            return (Criteria) this;
        }

        public Criteria andPlatformSettlementIdNotLike(String value) {
            addCriterion("platform_settlement_id not like", value, "platformSettlementId");
            return (Criteria) this;
        }

        public Criteria andPlatformSettlementIdIn(List<String> values) {
            addCriterion("platform_settlement_id in", values, "platformSettlementId");
            return (Criteria) this;
        }

        public Criteria andPlatformSettlementIdNotIn(List<String> values) {
            addCriterion("platform_settlement_id not in", values, "platformSettlementId");
            return (Criteria) this;
        }

        public Criteria andPlatformSettlementIdBetween(String value1, String value2) {
            addCriterion("platform_settlement_id between", value1, value2, "platformSettlementId");
            return (Criteria) this;
        }

        public Criteria andPlatformSettlementIdNotBetween(String value1, String value2) {
            addCriterion("platform_settlement_id not between", value1, value2, "platformSettlementId");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNull() {
            addCriterion("mch_id is null");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNotNull() {
            addCriterion("mch_id is not null");
            return (Criteria) this;
        }

        public Criteria andMchIdEqualTo(String value) {
            addCriterion("mch_id =", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotEqualTo(String value) {
            addCriterion("mch_id <>", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThan(String value) {
            addCriterion("mch_id >", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("mch_id >=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThan(String value) {
            addCriterion("mch_id <", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThanOrEqualTo(String value) {
            addCriterion("mch_id <=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLike(String value) {
            addCriterion("mch_id like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotLike(String value) {
            addCriterion("mch_id not like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdIn(List<String> values) {
            addCriterion("mch_id in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotIn(List<String> values) {
            addCriterion("mch_id not in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdBetween(String value1, String value2) {
            addCriterion("mch_id between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotBetween(String value1, String value2) {
            addCriterion("mch_id not between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(String value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(String value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(String value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(String value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(String value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLike(String value) {
            addCriterion("account_id like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotLike(String value) {
            addCriterion("account_id not like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<String> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<String> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(String value1, String value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(String value1, String value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andPfStatusIsNull() {
            addCriterion("pf_status is null");
            return (Criteria) this;
        }

        public Criteria andPfStatusIsNotNull() {
            addCriterion("pf_status is not null");
            return (Criteria) this;
        }

        public Criteria andPfStatusEqualTo(Integer value) {
            addCriterion("pf_status =", value, "pfStatus");
            return (Criteria) this;
        }

        public Criteria andPfStatusNotEqualTo(Integer value) {
            addCriterion("pf_status <>", value, "pfStatus");
            return (Criteria) this;
        }

        public Criteria andPfStatusGreaterThan(Integer value) {
            addCriterion("pf_status >", value, "pfStatus");
            return (Criteria) this;
        }

        public Criteria andPfStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pf_status >=", value, "pfStatus");
            return (Criteria) this;
        }

        public Criteria andPfStatusLessThan(Integer value) {
            addCriterion("pf_status <", value, "pfStatus");
            return (Criteria) this;
        }

        public Criteria andPfStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pf_status <=", value, "pfStatus");
            return (Criteria) this;
        }

        public Criteria andPfStatusIn(List<Integer> values) {
            addCriterion("pf_status in", values, "pfStatus");
            return (Criteria) this;
        }

        public Criteria andPfStatusNotIn(List<Integer> values) {
            addCriterion("pf_status not in", values, "pfStatus");
            return (Criteria) this;
        }

        public Criteria andPfStatusBetween(Integer value1, Integer value2) {
            addCriterion("pf_status between", value1, value2, "pfStatus");
            return (Criteria) this;
        }

        public Criteria andPfStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pf_status not between", value1, value2, "pfStatus");
            return (Criteria) this;
        }

        public Criteria andAuditPhoneIsNull() {
            addCriterion("audit_phone is null");
            return (Criteria) this;
        }

        public Criteria andAuditPhoneIsNotNull() {
            addCriterion("audit_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAuditPhoneEqualTo(String value) {
            addCriterion("audit_phone =", value, "auditPhone");
            return (Criteria) this;
        }

        public Criteria andAuditPhoneNotEqualTo(String value) {
            addCriterion("audit_phone <>", value, "auditPhone");
            return (Criteria) this;
        }

        public Criteria andAuditPhoneGreaterThan(String value) {
            addCriterion("audit_phone >", value, "auditPhone");
            return (Criteria) this;
        }

        public Criteria andAuditPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("audit_phone >=", value, "auditPhone");
            return (Criteria) this;
        }

        public Criteria andAuditPhoneLessThan(String value) {
            addCriterion("audit_phone <", value, "auditPhone");
            return (Criteria) this;
        }

        public Criteria andAuditPhoneLessThanOrEqualTo(String value) {
            addCriterion("audit_phone <=", value, "auditPhone");
            return (Criteria) this;
        }

        public Criteria andAuditPhoneLike(String value) {
            addCriterion("audit_phone like", value, "auditPhone");
            return (Criteria) this;
        }

        public Criteria andAuditPhoneNotLike(String value) {
            addCriterion("audit_phone not like", value, "auditPhone");
            return (Criteria) this;
        }

        public Criteria andAuditPhoneIn(List<String> values) {
            addCriterion("audit_phone in", values, "auditPhone");
            return (Criteria) this;
        }

        public Criteria andAuditPhoneNotIn(List<String> values) {
            addCriterion("audit_phone not in", values, "auditPhone");
            return (Criteria) this;
        }

        public Criteria andAuditPhoneBetween(String value1, String value2) {
            addCriterion("audit_phone between", value1, value2, "auditPhone");
            return (Criteria) this;
        }

        public Criteria andAuditPhoneNotBetween(String value1, String value2) {
            addCriterion("audit_phone not between", value1, value2, "auditPhone");
            return (Criteria) this;
        }

        public Criteria andAuditNameIsNull() {
            addCriterion("audit_name is null");
            return (Criteria) this;
        }

        public Criteria andAuditNameIsNotNull() {
            addCriterion("audit_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuditNameEqualTo(String value) {
            addCriterion("audit_name =", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameNotEqualTo(String value) {
            addCriterion("audit_name <>", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameGreaterThan(String value) {
            addCriterion("audit_name >", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameGreaterThanOrEqualTo(String value) {
            addCriterion("audit_name >=", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameLessThan(String value) {
            addCriterion("audit_name <", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameLessThanOrEqualTo(String value) {
            addCriterion("audit_name <=", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameLike(String value) {
            addCriterion("audit_name like", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameNotLike(String value) {
            addCriterion("audit_name not like", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameIn(List<String> values) {
            addCriterion("audit_name in", values, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameNotIn(List<String> values) {
            addCriterion("audit_name not in", values, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameBetween(String value1, String value2) {
            addCriterion("audit_name between", value1, value2, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameNotBetween(String value1, String value2) {
            addCriterion("audit_name not between", value1, value2, "auditName");
            return (Criteria) this;
        }

        public Criteria andSettleSuccessTimeIsNull() {
            addCriterion("settle_success_time is null");
            return (Criteria) this;
        }

        public Criteria andSettleSuccessTimeIsNotNull() {
            addCriterion("settle_success_time is not null");
            return (Criteria) this;
        }

        public Criteria andSettleSuccessTimeEqualTo(Date value) {
            addCriterion("settle_success_time =", value, "settleSuccessTime");
            return (Criteria) this;
        }

        public Criteria andSettleSuccessTimeNotEqualTo(Date value) {
            addCriterion("settle_success_time <>", value, "settleSuccessTime");
            return (Criteria) this;
        }

        public Criteria andSettleSuccessTimeGreaterThan(Date value) {
            addCriterion("settle_success_time >", value, "settleSuccessTime");
            return (Criteria) this;
        }

        public Criteria andSettleSuccessTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("settle_success_time >=", value, "settleSuccessTime");
            return (Criteria) this;
        }

        public Criteria andSettleSuccessTimeLessThan(Date value) {
            addCriterion("settle_success_time <", value, "settleSuccessTime");
            return (Criteria) this;
        }

        public Criteria andSettleSuccessTimeLessThanOrEqualTo(Date value) {
            addCriterion("settle_success_time <=", value, "settleSuccessTime");
            return (Criteria) this;
        }

        public Criteria andSettleSuccessTimeIn(List<Date> values) {
            addCriterion("settle_success_time in", values, "settleSuccessTime");
            return (Criteria) this;
        }

        public Criteria andSettleSuccessTimeNotIn(List<Date> values) {
            addCriterion("settle_success_time not in", values, "settleSuccessTime");
            return (Criteria) this;
        }

        public Criteria andSettleSuccessTimeBetween(Date value1, Date value2) {
            addCriterion("settle_success_time between", value1, value2, "settleSuccessTime");
            return (Criteria) this;
        }

        public Criteria andSettleSuccessTimeNotBetween(Date value1, Date value2) {
            addCriterion("settle_success_time not between", value1, value2, "settleSuccessTime");
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