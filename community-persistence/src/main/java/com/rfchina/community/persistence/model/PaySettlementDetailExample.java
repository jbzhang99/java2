package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaySettlementDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaySettlementDetailExample() {
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

        public Criteria andMyIdIsNull() {
            addCriterion("my_id is null");
            return (Criteria) this;
        }

        public Criteria andMyIdIsNotNull() {
            addCriterion("my_id is not null");
            return (Criteria) this;
        }

        public Criteria andMyIdEqualTo(Long value) {
            addCriterion("my_id =", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdNotEqualTo(Long value) {
            addCriterion("my_id <>", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdGreaterThan(Long value) {
            addCriterion("my_id >", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("my_id >=", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdLessThan(Long value) {
            addCriterion("my_id <", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdLessThanOrEqualTo(Long value) {
            addCriterion("my_id <=", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdIn(List<Long> values) {
            addCriterion("my_id in", values, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdNotIn(List<Long> values) {
            addCriterion("my_id not in", values, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdBetween(Long value1, Long value2) {
            addCriterion("my_id between", value1, value2, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdNotBetween(Long value1, Long value2) {
            addCriterion("my_id not between", value1, value2, "myId");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeIsNull() {
            addCriterion("my_create_time is null");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeIsNotNull() {
            addCriterion("my_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeEqualTo(Date value) {
            addCriterion("my_create_time =", value, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeNotEqualTo(Date value) {
            addCriterion("my_create_time <>", value, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeGreaterThan(Date value) {
            addCriterion("my_create_time >", value, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("my_create_time >=", value, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeLessThan(Date value) {
            addCriterion("my_create_time <", value, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("my_create_time <=", value, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeIn(List<Date> values) {
            addCriterion("my_create_time in", values, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeNotIn(List<Date> values) {
            addCriterion("my_create_time not in", values, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeBetween(Date value1, Date value2) {
            addCriterion("my_create_time between", value1, value2, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("my_create_time not between", value1, value2, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCompareIsNull() {
            addCriterion("my_compare is null");
            return (Criteria) this;
        }

        public Criteria andMyCompareIsNotNull() {
            addCriterion("my_compare is not null");
            return (Criteria) this;
        }

        public Criteria andMyCompareEqualTo(Integer value) {
            addCriterion("my_compare =", value, "myCompare");
            return (Criteria) this;
        }

        public Criteria andMyCompareNotEqualTo(Integer value) {
            addCriterion("my_compare <>", value, "myCompare");
            return (Criteria) this;
        }

        public Criteria andMyCompareGreaterThan(Integer value) {
            addCriterion("my_compare >", value, "myCompare");
            return (Criteria) this;
        }

        public Criteria andMyCompareGreaterThanOrEqualTo(Integer value) {
            addCriterion("my_compare >=", value, "myCompare");
            return (Criteria) this;
        }

        public Criteria andMyCompareLessThan(Integer value) {
            addCriterion("my_compare <", value, "myCompare");
            return (Criteria) this;
        }

        public Criteria andMyCompareLessThanOrEqualTo(Integer value) {
            addCriterion("my_compare <=", value, "myCompare");
            return (Criteria) this;
        }

        public Criteria andMyCompareIn(List<Integer> values) {
            addCriterion("my_compare in", values, "myCompare");
            return (Criteria) this;
        }

        public Criteria andMyCompareNotIn(List<Integer> values) {
            addCriterion("my_compare not in", values, "myCompare");
            return (Criteria) this;
        }

        public Criteria andMyCompareBetween(Integer value1, Integer value2) {
            addCriterion("my_compare between", value1, value2, "myCompare");
            return (Criteria) this;
        }

        public Criteria andMyCompareNotBetween(Integer value1, Integer value2) {
            addCriterion("my_compare not between", value1, value2, "myCompare");
            return (Criteria) this;
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

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(String value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(String value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(String value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(String value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(String value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(String value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLike(String value) {
            addCriterion("sid like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotLike(String value) {
            addCriterion("sid not like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<String> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<String> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(String value1, String value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(String value1, String value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNull() {
            addCriterion("bill_id is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(String value) {
            addCriterion("bill_id =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(String value) {
            addCriterion("bill_id <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(String value) {
            addCriterion("bill_id >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("bill_id >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(String value) {
            addCriterion("bill_id <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(String value) {
            addCriterion("bill_id <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLike(String value) {
            addCriterion("bill_id like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotLike(String value) {
            addCriterion("bill_id not like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<String> values) {
            addCriterion("bill_id in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<String> values) {
            addCriterion("bill_id not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(String value1, String value2) {
            addCriterion("bill_id between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(String value1, String value2) {
            addCriterion("bill_id not between", value1, value2, "billId");
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

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(Long value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(Long value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(Long value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(Long value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(Long value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(Long value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<Long> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<Long> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(Long value1, Long value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(Long value1, Long value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNull() {
            addCriterion("out_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNotNull() {
            addCriterion("out_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoEqualTo(String value) {
            addCriterion("out_trade_no =", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotEqualTo(String value) {
            addCriterion("out_trade_no <>", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThan(String value) {
            addCriterion("out_trade_no >", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_trade_no >=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThan(String value) {
            addCriterion("out_trade_no <", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThanOrEqualTo(String value) {
            addCriterion("out_trade_no <=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLike(String value) {
            addCriterion("out_trade_no like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotLike(String value) {
            addCriterion("out_trade_no not like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIn(List<String> values) {
            addCriterion("out_trade_no in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotIn(List<String> values) {
            addCriterion("out_trade_no not in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoBetween(String value1, String value2) {
            addCriterion("out_trade_no between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotBetween(String value1, String value2) {
            addCriterion("out_trade_no not between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andCmpOutTradeNoIsNull() {
            addCriterion("cmp_out_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andCmpOutTradeNoIsNotNull() {
            addCriterion("cmp_out_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andCmpOutTradeNoEqualTo(String value) {
            addCriterion("cmp_out_trade_no =", value, "cmpOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andCmpOutTradeNoNotEqualTo(String value) {
            addCriterion("cmp_out_trade_no <>", value, "cmpOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andCmpOutTradeNoGreaterThan(String value) {
            addCriterion("cmp_out_trade_no >", value, "cmpOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andCmpOutTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("cmp_out_trade_no >=", value, "cmpOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andCmpOutTradeNoLessThan(String value) {
            addCriterion("cmp_out_trade_no <", value, "cmpOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andCmpOutTradeNoLessThanOrEqualTo(String value) {
            addCriterion("cmp_out_trade_no <=", value, "cmpOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andCmpOutTradeNoLike(String value) {
            addCriterion("cmp_out_trade_no like", value, "cmpOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andCmpOutTradeNoNotLike(String value) {
            addCriterion("cmp_out_trade_no not like", value, "cmpOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andCmpOutTradeNoIn(List<String> values) {
            addCriterion("cmp_out_trade_no in", values, "cmpOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andCmpOutTradeNoNotIn(List<String> values) {
            addCriterion("cmp_out_trade_no not in", values, "cmpOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andCmpOutTradeNoBetween(String value1, String value2) {
            addCriterion("cmp_out_trade_no between", value1, value2, "cmpOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andCmpOutTradeNoNotBetween(String value1, String value2) {
            addCriterion("cmp_out_trade_no not between", value1, value2, "cmpOutTradeNo");
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

        public Criteria andTotalAmountEqualTo(Long value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(Long value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(Long value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(Long value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(Long value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<Long> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<Long> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(Long value1, Long value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(Long value1, Long value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountIsNull() {
            addCriterion("receipt_amount is null");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountIsNotNull() {
            addCriterion("receipt_amount is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountEqualTo(Long value) {
            addCriterion("receipt_amount =", value, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountNotEqualTo(Long value) {
            addCriterion("receipt_amount <>", value, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountGreaterThan(Long value) {
            addCriterion("receipt_amount >", value, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("receipt_amount >=", value, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountLessThan(Long value) {
            addCriterion("receipt_amount <", value, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountLessThanOrEqualTo(Long value) {
            addCriterion("receipt_amount <=", value, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountIn(List<Long> values) {
            addCriterion("receipt_amount in", values, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountNotIn(List<Long> values) {
            addCriterion("receipt_amount not in", values, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountBetween(Long value1, Long value2) {
            addCriterion("receipt_amount between", value1, value2, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountNotBetween(Long value1, Long value2) {
            addCriterion("receipt_amount not between", value1, value2, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountIsNull() {
            addCriterion("fee_amount is null");
            return (Criteria) this;
        }

        public Criteria andFeeAmountIsNotNull() {
            addCriterion("fee_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFeeAmountEqualTo(Long value) {
            addCriterion("fee_amount =", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountNotEqualTo(Long value) {
            addCriterion("fee_amount <>", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountGreaterThan(Long value) {
            addCriterion("fee_amount >", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("fee_amount >=", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountLessThan(Long value) {
            addCriterion("fee_amount <", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountLessThanOrEqualTo(Long value) {
            addCriterion("fee_amount <=", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountIn(List<Long> values) {
            addCriterion("fee_amount in", values, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountNotIn(List<Long> values) {
            addCriterion("fee_amount not in", values, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountBetween(Long value1, Long value2) {
            addCriterion("fee_amount between", value1, value2, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountNotBetween(Long value1, Long value2) {
            addCriterion("fee_amount not between", value1, value2, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andCmpTotalAmountIsNull() {
            addCriterion("cmp_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andCmpTotalAmountIsNotNull() {
            addCriterion("cmp_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCmpTotalAmountEqualTo(Long value) {
            addCriterion("cmp_total_amount =", value, "cmpTotalAmount");
            return (Criteria) this;
        }

        public Criteria andCmpTotalAmountNotEqualTo(Long value) {
            addCriterion("cmp_total_amount <>", value, "cmpTotalAmount");
            return (Criteria) this;
        }

        public Criteria andCmpTotalAmountGreaterThan(Long value) {
            addCriterion("cmp_total_amount >", value, "cmpTotalAmount");
            return (Criteria) this;
        }

        public Criteria andCmpTotalAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("cmp_total_amount >=", value, "cmpTotalAmount");
            return (Criteria) this;
        }

        public Criteria andCmpTotalAmountLessThan(Long value) {
            addCriterion("cmp_total_amount <", value, "cmpTotalAmount");
            return (Criteria) this;
        }

        public Criteria andCmpTotalAmountLessThanOrEqualTo(Long value) {
            addCriterion("cmp_total_amount <=", value, "cmpTotalAmount");
            return (Criteria) this;
        }

        public Criteria andCmpTotalAmountIn(List<Long> values) {
            addCriterion("cmp_total_amount in", values, "cmpTotalAmount");
            return (Criteria) this;
        }

        public Criteria andCmpTotalAmountNotIn(List<Long> values) {
            addCriterion("cmp_total_amount not in", values, "cmpTotalAmount");
            return (Criteria) this;
        }

        public Criteria andCmpTotalAmountBetween(Long value1, Long value2) {
            addCriterion("cmp_total_amount between", value1, value2, "cmpTotalAmount");
            return (Criteria) this;
        }

        public Criteria andCmpTotalAmountNotBetween(Long value1, Long value2) {
            addCriterion("cmp_total_amount not between", value1, value2, "cmpTotalAmount");
            return (Criteria) this;
        }

        public Criteria andCmpReceiptAmountIsNull() {
            addCriterion("cmp_receipt_amount is null");
            return (Criteria) this;
        }

        public Criteria andCmpReceiptAmountIsNotNull() {
            addCriterion("cmp_receipt_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCmpReceiptAmountEqualTo(Long value) {
            addCriterion("cmp_receipt_amount =", value, "cmpReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andCmpReceiptAmountNotEqualTo(Long value) {
            addCriterion("cmp_receipt_amount <>", value, "cmpReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andCmpReceiptAmountGreaterThan(Long value) {
            addCriterion("cmp_receipt_amount >", value, "cmpReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andCmpReceiptAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("cmp_receipt_amount >=", value, "cmpReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andCmpReceiptAmountLessThan(Long value) {
            addCriterion("cmp_receipt_amount <", value, "cmpReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andCmpReceiptAmountLessThanOrEqualTo(Long value) {
            addCriterion("cmp_receipt_amount <=", value, "cmpReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andCmpReceiptAmountIn(List<Long> values) {
            addCriterion("cmp_receipt_amount in", values, "cmpReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andCmpReceiptAmountNotIn(List<Long> values) {
            addCriterion("cmp_receipt_amount not in", values, "cmpReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andCmpReceiptAmountBetween(Long value1, Long value2) {
            addCriterion("cmp_receipt_amount between", value1, value2, "cmpReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andCmpReceiptAmountNotBetween(Long value1, Long value2) {
            addCriterion("cmp_receipt_amount not between", value1, value2, "cmpReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andCmpFeeAmountIsNull() {
            addCriterion("cmp_fee_amount is null");
            return (Criteria) this;
        }

        public Criteria andCmpFeeAmountIsNotNull() {
            addCriterion("cmp_fee_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCmpFeeAmountEqualTo(Long value) {
            addCriterion("cmp_fee_amount =", value, "cmpFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCmpFeeAmountNotEqualTo(Long value) {
            addCriterion("cmp_fee_amount <>", value, "cmpFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCmpFeeAmountGreaterThan(Long value) {
            addCriterion("cmp_fee_amount >", value, "cmpFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCmpFeeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("cmp_fee_amount >=", value, "cmpFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCmpFeeAmountLessThan(Long value) {
            addCriterion("cmp_fee_amount <", value, "cmpFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCmpFeeAmountLessThanOrEqualTo(Long value) {
            addCriterion("cmp_fee_amount <=", value, "cmpFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCmpFeeAmountIn(List<Long> values) {
            addCriterion("cmp_fee_amount in", values, "cmpFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCmpFeeAmountNotIn(List<Long> values) {
            addCriterion("cmp_fee_amount not in", values, "cmpFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCmpFeeAmountBetween(Long value1, Long value2) {
            addCriterion("cmp_fee_amount between", value1, value2, "cmpFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCmpFeeAmountNotBetween(Long value1, Long value2) {
            addCriterion("cmp_fee_amount not between", value1, value2, "cmpFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCmpRefundFeeIsNull() {
            addCriterion("cmp_refund_fee is null");
            return (Criteria) this;
        }

        public Criteria andCmpRefundFeeIsNotNull() {
            addCriterion("cmp_refund_fee is not null");
            return (Criteria) this;
        }

        public Criteria andCmpRefundFeeEqualTo(Long value) {
            addCriterion("cmp_refund_fee =", value, "cmpRefundFee");
            return (Criteria) this;
        }

        public Criteria andCmpRefundFeeNotEqualTo(Long value) {
            addCriterion("cmp_refund_fee <>", value, "cmpRefundFee");
            return (Criteria) this;
        }

        public Criteria andCmpRefundFeeGreaterThan(Long value) {
            addCriterion("cmp_refund_fee >", value, "cmpRefundFee");
            return (Criteria) this;
        }

        public Criteria andCmpRefundFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("cmp_refund_fee >=", value, "cmpRefundFee");
            return (Criteria) this;
        }

        public Criteria andCmpRefundFeeLessThan(Long value) {
            addCriterion("cmp_refund_fee <", value, "cmpRefundFee");
            return (Criteria) this;
        }

        public Criteria andCmpRefundFeeLessThanOrEqualTo(Long value) {
            addCriterion("cmp_refund_fee <=", value, "cmpRefundFee");
            return (Criteria) this;
        }

        public Criteria andCmpRefundFeeIn(List<Long> values) {
            addCriterion("cmp_refund_fee in", values, "cmpRefundFee");
            return (Criteria) this;
        }

        public Criteria andCmpRefundFeeNotIn(List<Long> values) {
            addCriterion("cmp_refund_fee not in", values, "cmpRefundFee");
            return (Criteria) this;
        }

        public Criteria andCmpRefundFeeBetween(Long value1, Long value2) {
            addCriterion("cmp_refund_fee between", value1, value2, "cmpRefundFee");
            return (Criteria) this;
        }

        public Criteria andCmpRefundFeeNotBetween(Long value1, Long value2) {
            addCriterion("cmp_refund_fee not between", value1, value2, "cmpRefundFee");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeIsNull() {
            addCriterion("bill_create_time is null");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeIsNotNull() {
            addCriterion("bill_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeEqualTo(Date value) {
            addCriterion("bill_create_time =", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeNotEqualTo(Date value) {
            addCriterion("bill_create_time <>", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeGreaterThan(Date value) {
            addCriterion("bill_create_time >", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bill_create_time >=", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeLessThan(Date value) {
            addCriterion("bill_create_time <", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("bill_create_time <=", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeIn(List<Date> values) {
            addCriterion("bill_create_time in", values, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeNotIn(List<Date> values) {
            addCriterion("bill_create_time not in", values, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeBetween(Date value1, Date value2) {
            addCriterion("bill_create_time between", value1, value2, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("bill_create_time not between", value1, value2, "billCreateTime");
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

        public Criteria andPayChannelIdIsNull() {
            addCriterion("pay_channel_id is null");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdIsNotNull() {
            addCriterion("pay_channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdEqualTo(Integer value) {
            addCriterion("pay_channel_id =", value, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdNotEqualTo(Integer value) {
            addCriterion("pay_channel_id <>", value, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdGreaterThan(Integer value) {
            addCriterion("pay_channel_id >", value, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_channel_id >=", value, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdLessThan(Integer value) {
            addCriterion("pay_channel_id <", value, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdLessThanOrEqualTo(Integer value) {
            addCriterion("pay_channel_id <=", value, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdIn(List<Integer> values) {
            addCriterion("pay_channel_id in", values, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdNotIn(List<Integer> values) {
            addCriterion("pay_channel_id not in", values, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdBetween(Integer value1, Integer value2) {
            addCriterion("pay_channel_id between", value1, value2, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_channel_id not between", value1, value2, "payChannelId");
            return (Criteria) this;
        }

        public Criteria andPayChannelIsNull() {
            addCriterion("pay_channel is null");
            return (Criteria) this;
        }

        public Criteria andPayChannelIsNotNull() {
            addCriterion("pay_channel is not null");
            return (Criteria) this;
        }

        public Criteria andPayChannelEqualTo(String value) {
            addCriterion("pay_channel =", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotEqualTo(String value) {
            addCriterion("pay_channel <>", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelGreaterThan(String value) {
            addCriterion("pay_channel >", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelGreaterThanOrEqualTo(String value) {
            addCriterion("pay_channel >=", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelLessThan(String value) {
            addCriterion("pay_channel <", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelLessThanOrEqualTo(String value) {
            addCriterion("pay_channel <=", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelLike(String value) {
            addCriterion("pay_channel like", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotLike(String value) {
            addCriterion("pay_channel not like", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelIn(List<String> values) {
            addCriterion("pay_channel in", values, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotIn(List<String> values) {
            addCriterion("pay_channel not in", values, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelBetween(String value1, String value2) {
            addCriterion("pay_channel between", value1, value2, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotBetween(String value1, String value2) {
            addCriterion("pay_channel not between", value1, value2, "payChannel");
            return (Criteria) this;
        }

        public Criteria andBalanceStatusIsNull() {
            addCriterion("balance_status is null");
            return (Criteria) this;
        }

        public Criteria andBalanceStatusIsNotNull() {
            addCriterion("balance_status is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceStatusEqualTo(Integer value) {
            addCriterion("balance_status =", value, "balanceStatus");
            return (Criteria) this;
        }

        public Criteria andBalanceStatusNotEqualTo(Integer value) {
            addCriterion("balance_status <>", value, "balanceStatus");
            return (Criteria) this;
        }

        public Criteria andBalanceStatusGreaterThan(Integer value) {
            addCriterion("balance_status >", value, "balanceStatus");
            return (Criteria) this;
        }

        public Criteria andBalanceStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("balance_status >=", value, "balanceStatus");
            return (Criteria) this;
        }

        public Criteria andBalanceStatusLessThan(Integer value) {
            addCriterion("balance_status <", value, "balanceStatus");
            return (Criteria) this;
        }

        public Criteria andBalanceStatusLessThanOrEqualTo(Integer value) {
            addCriterion("balance_status <=", value, "balanceStatus");
            return (Criteria) this;
        }

        public Criteria andBalanceStatusIn(List<Integer> values) {
            addCriterion("balance_status in", values, "balanceStatus");
            return (Criteria) this;
        }

        public Criteria andBalanceStatusNotIn(List<Integer> values) {
            addCriterion("balance_status not in", values, "balanceStatus");
            return (Criteria) this;
        }

        public Criteria andBalanceStatusBetween(Integer value1, Integer value2) {
            addCriterion("balance_status between", value1, value2, "balanceStatus");
            return (Criteria) this;
        }

        public Criteria andBalanceStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("balance_status not between", value1, value2, "balanceStatus");
            return (Criteria) this;
        }

        public Criteria andBussinessBalanceStatusIsNull() {
            addCriterion("bussiness_balance_status is null");
            return (Criteria) this;
        }

        public Criteria andBussinessBalanceStatusIsNotNull() {
            addCriterion("bussiness_balance_status is not null");
            return (Criteria) this;
        }

        public Criteria andBussinessBalanceStatusEqualTo(Integer value) {
            addCriterion("bussiness_balance_status =", value, "bussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andBussinessBalanceStatusNotEqualTo(Integer value) {
            addCriterion("bussiness_balance_status <>", value, "bussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andBussinessBalanceStatusGreaterThan(Integer value) {
            addCriterion("bussiness_balance_status >", value, "bussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andBussinessBalanceStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("bussiness_balance_status >=", value, "bussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andBussinessBalanceStatusLessThan(Integer value) {
            addCriterion("bussiness_balance_status <", value, "bussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andBussinessBalanceStatusLessThanOrEqualTo(Integer value) {
            addCriterion("bussiness_balance_status <=", value, "bussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andBussinessBalanceStatusIn(List<Integer> values) {
            addCriterion("bussiness_balance_status in", values, "bussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andBussinessBalanceStatusNotIn(List<Integer> values) {
            addCriterion("bussiness_balance_status not in", values, "bussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andBussinessBalanceStatusBetween(Integer value1, Integer value2) {
            addCriterion("bussiness_balance_status between", value1, value2, "bussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andBussinessBalanceStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("bussiness_balance_status not between", value1, value2, "bussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNull() {
            addCriterion("trade_type is null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNotNull() {
            addCriterion("trade_type is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeEqualTo(String value) {
            addCriterion("trade_type =", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotEqualTo(String value) {
            addCriterion("trade_type <>", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThan(String value) {
            addCriterion("trade_type >", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trade_type >=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThan(String value) {
            addCriterion("trade_type <", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThanOrEqualTo(String value) {
            addCriterion("trade_type <=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLike(String value) {
            addCriterion("trade_type like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotLike(String value) {
            addCriterion("trade_type not like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIn(List<String> values) {
            addCriterion("trade_type in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotIn(List<String> values) {
            addCriterion("trade_type not in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeBetween(String value1, String value2) {
            addCriterion("trade_type between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotBetween(String value1, String value2) {
            addCriterion("trade_type not between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIsNull() {
            addCriterion("refund_status is null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIsNotNull() {
            addCriterion("refund_status is not null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusEqualTo(Integer value) {
            addCriterion("refund_status =", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotEqualTo(Integer value) {
            addCriterion("refund_status <>", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusGreaterThan(Integer value) {
            addCriterion("refund_status >", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_status >=", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLessThan(Integer value) {
            addCriterion("refund_status <", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLessThanOrEqualTo(Integer value) {
            addCriterion("refund_status <=", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIn(List<Integer> values) {
            addCriterion("refund_status in", values, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotIn(List<Integer> values) {
            addCriterion("refund_status not in", values, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusBetween(Integer value1, Integer value2) {
            addCriterion("refund_status between", value1, value2, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_status not between", value1, value2, "refundStatus");
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