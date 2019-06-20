package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BizApplyOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BizApplyOrderExample() {
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

        public Criteria andTradeNoIsNull() {
            addCriterion("trade_no is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("trade_no =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("trade_no <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("trade_no >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_no >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("trade_no <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("trade_no <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("trade_no like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("trade_no not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("trade_no in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("trade_no not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("trade_no between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("trade_no not between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTskCodeIsNull() {
            addCriterion("tsk_code is null");
            return (Criteria) this;
        }

        public Criteria andTskCodeIsNotNull() {
            addCriterion("tsk_code is not null");
            return (Criteria) this;
        }

        public Criteria andTskCodeEqualTo(String value) {
            addCriterion("tsk_code =", value, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeNotEqualTo(String value) {
            addCriterion("tsk_code <>", value, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeGreaterThan(String value) {
            addCriterion("tsk_code >", value, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tsk_code >=", value, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeLessThan(String value) {
            addCriterion("tsk_code <", value, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeLessThanOrEqualTo(String value) {
            addCriterion("tsk_code <=", value, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeLike(String value) {
            addCriterion("tsk_code like", value, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeNotLike(String value) {
            addCriterion("tsk_code not like", value, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeIn(List<String> values) {
            addCriterion("tsk_code in", values, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeNotIn(List<String> values) {
            addCriterion("tsk_code not in", values, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeBetween(String value1, String value2) {
            addCriterion("tsk_code between", value1, value2, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeNotBetween(String value1, String value2) {
            addCriterion("tsk_code not between", value1, value2, "tskCode");
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

        public Criteria andMasterIdIsNull() {
            addCriterion("master_id is null");
            return (Criteria) this;
        }

        public Criteria andMasterIdIsNotNull() {
            addCriterion("master_id is not null");
            return (Criteria) this;
        }

        public Criteria andMasterIdEqualTo(Long value) {
            addCriterion("master_id =", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotEqualTo(Long value) {
            addCriterion("master_id <>", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdGreaterThan(Long value) {
            addCriterion("master_id >", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("master_id >=", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLessThan(Long value) {
            addCriterion("master_id <", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLessThanOrEqualTo(Long value) {
            addCriterion("master_id <=", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdIn(List<Long> values) {
            addCriterion("master_id in", values, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotIn(List<Long> values) {
            addCriterion("master_id not in", values, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdBetween(Long value1, Long value2) {
            addCriterion("master_id between", value1, value2, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotBetween(Long value1, Long value2) {
            addCriterion("master_id not between", value1, value2, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdIsNull() {
            addCriterion("master_child_id is null");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdIsNotNull() {
            addCriterion("master_child_id is not null");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdEqualTo(Long value) {
            addCriterion("master_child_id =", value, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdNotEqualTo(Long value) {
            addCriterion("master_child_id <>", value, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdGreaterThan(Long value) {
            addCriterion("master_child_id >", value, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdGreaterThanOrEqualTo(Long value) {
            addCriterion("master_child_id >=", value, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdLessThan(Long value) {
            addCriterion("master_child_id <", value, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdLessThanOrEqualTo(Long value) {
            addCriterion("master_child_id <=", value, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdIn(List<Long> values) {
            addCriterion("master_child_id in", values, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdNotIn(List<Long> values) {
            addCriterion("master_child_id not in", values, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdBetween(Long value1, Long value2) {
            addCriterion("master_child_id between", value1, value2, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdNotBetween(Long value1, Long value2) {
            addCriterion("master_child_id not between", value1, value2, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Integer value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Integer> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Integer> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
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

        public Criteria andPayStatusEqualTo(Integer value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Integer value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Integer value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Integer value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Integer> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Integer> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayPriceIsNull() {
            addCriterion("pay_price is null");
            return (Criteria) this;
        }

        public Criteria andPayPriceIsNotNull() {
            addCriterion("pay_price is not null");
            return (Criteria) this;
        }

        public Criteria andPayPriceEqualTo(BigDecimal value) {
            addCriterion("pay_price =", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceNotEqualTo(BigDecimal value) {
            addCriterion("pay_price <>", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceGreaterThan(BigDecimal value) {
            addCriterion("pay_price >", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_price >=", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceLessThan(BigDecimal value) {
            addCriterion("pay_price <", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_price <=", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceIn(List<BigDecimal> values) {
            addCriterion("pay_price in", values, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceNotIn(List<BigDecimal> values) {
            addCriterion("pay_price not in", values, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_price between", value1, value2, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_price not between", value1, value2, "payPrice");
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

        public Criteria andAttachmentIsNull() {
            addCriterion("attachment is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNotNull() {
            addCriterion("attachment is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentEqualTo(String value) {
            addCriterion("attachment =", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotEqualTo(String value) {
            addCriterion("attachment <>", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThan(String value) {
            addCriterion("attachment >", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("attachment >=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThan(String value) {
            addCriterion("attachment <", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThanOrEqualTo(String value) {
            addCriterion("attachment <=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLike(String value) {
            addCriterion("attachment like", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotLike(String value) {
            addCriterion("attachment not like", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentIn(List<String> values) {
            addCriterion("attachment in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotIn(List<String> values) {
            addCriterion("attachment not in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentBetween(String value1, String value2) {
            addCriterion("attachment between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotBetween(String value1, String value2) {
            addCriterion("attachment not between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNull() {
            addCriterion("apply_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("apply_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(Date value) {
            addCriterion("apply_time =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Date value) {
            addCriterion("apply_time <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Date value) {
            addCriterion("apply_time >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_time >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Date value) {
            addCriterion("apply_time <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_time <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(List<Date> values) {
            addCriterion("apply_time in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(List<Date> values) {
            addCriterion("apply_time not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Date value1, Date value2) {
            addCriterion("apply_time between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_time not between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyNumIsNull() {
            addCriterion("apply_num is null");
            return (Criteria) this;
        }

        public Criteria andApplyNumIsNotNull() {
            addCriterion("apply_num is not null");
            return (Criteria) this;
        }

        public Criteria andApplyNumEqualTo(Integer value) {
            addCriterion("apply_num =", value, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumNotEqualTo(Integer value) {
            addCriterion("apply_num <>", value, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumGreaterThan(Integer value) {
            addCriterion("apply_num >", value, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_num >=", value, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumLessThan(Integer value) {
            addCriterion("apply_num <", value, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumLessThanOrEqualTo(Integer value) {
            addCriterion("apply_num <=", value, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumIn(List<Integer> values) {
            addCriterion("apply_num in", values, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumNotIn(List<Integer> values) {
            addCriterion("apply_num not in", values, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumBetween(Integer value1, Integer value2) {
            addCriterion("apply_num between", value1, value2, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_num not between", value1, value2, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyAddressIsNull() {
            addCriterion("apply_address is null");
            return (Criteria) this;
        }

        public Criteria andApplyAddressIsNotNull() {
            addCriterion("apply_address is not null");
            return (Criteria) this;
        }

        public Criteria andApplyAddressEqualTo(String value) {
            addCriterion("apply_address =", value, "applyAddress");
            return (Criteria) this;
        }

        public Criteria andApplyAddressNotEqualTo(String value) {
            addCriterion("apply_address <>", value, "applyAddress");
            return (Criteria) this;
        }

        public Criteria andApplyAddressGreaterThan(String value) {
            addCriterion("apply_address >", value, "applyAddress");
            return (Criteria) this;
        }

        public Criteria andApplyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("apply_address >=", value, "applyAddress");
            return (Criteria) this;
        }

        public Criteria andApplyAddressLessThan(String value) {
            addCriterion("apply_address <", value, "applyAddress");
            return (Criteria) this;
        }

        public Criteria andApplyAddressLessThanOrEqualTo(String value) {
            addCriterion("apply_address <=", value, "applyAddress");
            return (Criteria) this;
        }

        public Criteria andApplyAddressLike(String value) {
            addCriterion("apply_address like", value, "applyAddress");
            return (Criteria) this;
        }

        public Criteria andApplyAddressNotLike(String value) {
            addCriterion("apply_address not like", value, "applyAddress");
            return (Criteria) this;
        }

        public Criteria andApplyAddressIn(List<String> values) {
            addCriterion("apply_address in", values, "applyAddress");
            return (Criteria) this;
        }

        public Criteria andApplyAddressNotIn(List<String> values) {
            addCriterion("apply_address not in", values, "applyAddress");
            return (Criteria) this;
        }

        public Criteria andApplyAddressBetween(String value1, String value2) {
            addCriterion("apply_address between", value1, value2, "applyAddress");
            return (Criteria) this;
        }

        public Criteria andApplyAddressNotBetween(String value1, String value2) {
            addCriterion("apply_address not between", value1, value2, "applyAddress");
            return (Criteria) this;
        }

        public Criteria andObtainAddressIsNull() {
            addCriterion("obtain_address is null");
            return (Criteria) this;
        }

        public Criteria andObtainAddressIsNotNull() {
            addCriterion("obtain_address is not null");
            return (Criteria) this;
        }

        public Criteria andObtainAddressEqualTo(String value) {
            addCriterion("obtain_address =", value, "obtainAddress");
            return (Criteria) this;
        }

        public Criteria andObtainAddressNotEqualTo(String value) {
            addCriterion("obtain_address <>", value, "obtainAddress");
            return (Criteria) this;
        }

        public Criteria andObtainAddressGreaterThan(String value) {
            addCriterion("obtain_address >", value, "obtainAddress");
            return (Criteria) this;
        }

        public Criteria andObtainAddressGreaterThanOrEqualTo(String value) {
            addCriterion("obtain_address >=", value, "obtainAddress");
            return (Criteria) this;
        }

        public Criteria andObtainAddressLessThan(String value) {
            addCriterion("obtain_address <", value, "obtainAddress");
            return (Criteria) this;
        }

        public Criteria andObtainAddressLessThanOrEqualTo(String value) {
            addCriterion("obtain_address <=", value, "obtainAddress");
            return (Criteria) this;
        }

        public Criteria andObtainAddressLike(String value) {
            addCriterion("obtain_address like", value, "obtainAddress");
            return (Criteria) this;
        }

        public Criteria andObtainAddressNotLike(String value) {
            addCriterion("obtain_address not like", value, "obtainAddress");
            return (Criteria) this;
        }

        public Criteria andObtainAddressIn(List<String> values) {
            addCriterion("obtain_address in", values, "obtainAddress");
            return (Criteria) this;
        }

        public Criteria andObtainAddressNotIn(List<String> values) {
            addCriterion("obtain_address not in", values, "obtainAddress");
            return (Criteria) this;
        }

        public Criteria andObtainAddressBetween(String value1, String value2) {
            addCriterion("obtain_address between", value1, value2, "obtainAddress");
            return (Criteria) this;
        }

        public Criteria andObtainAddressNotBetween(String value1, String value2) {
            addCriterion("obtain_address not between", value1, value2, "obtainAddress");
            return (Criteria) this;
        }

        public Criteria andObtainTimeIsNull() {
            addCriterion("obtain_time is null");
            return (Criteria) this;
        }

        public Criteria andObtainTimeIsNotNull() {
            addCriterion("obtain_time is not null");
            return (Criteria) this;
        }

        public Criteria andObtainTimeEqualTo(Date value) {
            addCriterion("obtain_time =", value, "obtainTime");
            return (Criteria) this;
        }

        public Criteria andObtainTimeNotEqualTo(Date value) {
            addCriterion("obtain_time <>", value, "obtainTime");
            return (Criteria) this;
        }

        public Criteria andObtainTimeGreaterThan(Date value) {
            addCriterion("obtain_time >", value, "obtainTime");
            return (Criteria) this;
        }

        public Criteria andObtainTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("obtain_time >=", value, "obtainTime");
            return (Criteria) this;
        }

        public Criteria andObtainTimeLessThan(Date value) {
            addCriterion("obtain_time <", value, "obtainTime");
            return (Criteria) this;
        }

        public Criteria andObtainTimeLessThanOrEqualTo(Date value) {
            addCriterion("obtain_time <=", value, "obtainTime");
            return (Criteria) this;
        }

        public Criteria andObtainTimeIn(List<Date> values) {
            addCriterion("obtain_time in", values, "obtainTime");
            return (Criteria) this;
        }

        public Criteria andObtainTimeNotIn(List<Date> values) {
            addCriterion("obtain_time not in", values, "obtainTime");
            return (Criteria) this;
        }

        public Criteria andObtainTimeBetween(Date value1, Date value2) {
            addCriterion("obtain_time between", value1, value2, "obtainTime");
            return (Criteria) this;
        }

        public Criteria andObtainTimeNotBetween(Date value1, Date value2) {
            addCriterion("obtain_time not between", value1, value2, "obtainTime");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(Integer value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(Integer value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(Integer value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(Integer value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(Integer value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<Integer> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<Integer> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(Integer value1, Integer value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditReasonIsNull() {
            addCriterion("audit_reason is null");
            return (Criteria) this;
        }

        public Criteria andAuditReasonIsNotNull() {
            addCriterion("audit_reason is not null");
            return (Criteria) this;
        }

        public Criteria andAuditReasonEqualTo(String value) {
            addCriterion("audit_reason =", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonNotEqualTo(String value) {
            addCriterion("audit_reason <>", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonGreaterThan(String value) {
            addCriterion("audit_reason >", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonGreaterThanOrEqualTo(String value) {
            addCriterion("audit_reason >=", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonLessThan(String value) {
            addCriterion("audit_reason <", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonLessThanOrEqualTo(String value) {
            addCriterion("audit_reason <=", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonLike(String value) {
            addCriterion("audit_reason like", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonNotLike(String value) {
            addCriterion("audit_reason not like", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonIn(List<String> values) {
            addCriterion("audit_reason in", values, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonNotIn(List<String> values) {
            addCriterion("audit_reason not in", values, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonBetween(String value1, String value2) {
            addCriterion("audit_reason between", value1, value2, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonNotBetween(String value1, String value2) {
            addCriterion("audit_reason not between", value1, value2, "auditReason");
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

        public Criteria andValidationCodeIsNull() {
            addCriterion("validation_code is null");
            return (Criteria) this;
        }

        public Criteria andValidationCodeIsNotNull() {
            addCriterion("validation_code is not null");
            return (Criteria) this;
        }

        public Criteria andValidationCodeEqualTo(String value) {
            addCriterion("validation_code =", value, "validationCode");
            return (Criteria) this;
        }

        public Criteria andValidationCodeNotEqualTo(String value) {
            addCriterion("validation_code <>", value, "validationCode");
            return (Criteria) this;
        }

        public Criteria andValidationCodeGreaterThan(String value) {
            addCriterion("validation_code >", value, "validationCode");
            return (Criteria) this;
        }

        public Criteria andValidationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("validation_code >=", value, "validationCode");
            return (Criteria) this;
        }

        public Criteria andValidationCodeLessThan(String value) {
            addCriterion("validation_code <", value, "validationCode");
            return (Criteria) this;
        }

        public Criteria andValidationCodeLessThanOrEqualTo(String value) {
            addCriterion("validation_code <=", value, "validationCode");
            return (Criteria) this;
        }

        public Criteria andValidationCodeLike(String value) {
            addCriterion("validation_code like", value, "validationCode");
            return (Criteria) this;
        }

        public Criteria andValidationCodeNotLike(String value) {
            addCriterion("validation_code not like", value, "validationCode");
            return (Criteria) this;
        }

        public Criteria andValidationCodeIn(List<String> values) {
            addCriterion("validation_code in", values, "validationCode");
            return (Criteria) this;
        }

        public Criteria andValidationCodeNotIn(List<String> values) {
            addCriterion("validation_code not in", values, "validationCode");
            return (Criteria) this;
        }

        public Criteria andValidationCodeBetween(String value1, String value2) {
            addCriterion("validation_code between", value1, value2, "validationCode");
            return (Criteria) this;
        }

        public Criteria andValidationCodeNotBetween(String value1, String value2) {
            addCriterion("validation_code not between", value1, value2, "validationCode");
            return (Criteria) this;
        }

        public Criteria andIssueTskCodeIsNull() {
            addCriterion("issue_tsk_code is null");
            return (Criteria) this;
        }

        public Criteria andIssueTskCodeIsNotNull() {
            addCriterion("issue_tsk_code is not null");
            return (Criteria) this;
        }

        public Criteria andIssueTskCodeEqualTo(String value) {
            addCriterion("issue_tsk_code =", value, "issueTskCode");
            return (Criteria) this;
        }

        public Criteria andIssueTskCodeNotEqualTo(String value) {
            addCriterion("issue_tsk_code <>", value, "issueTskCode");
            return (Criteria) this;
        }

        public Criteria andIssueTskCodeGreaterThan(String value) {
            addCriterion("issue_tsk_code >", value, "issueTskCode");
            return (Criteria) this;
        }

        public Criteria andIssueTskCodeGreaterThanOrEqualTo(String value) {
            addCriterion("issue_tsk_code >=", value, "issueTskCode");
            return (Criteria) this;
        }

        public Criteria andIssueTskCodeLessThan(String value) {
            addCriterion("issue_tsk_code <", value, "issueTskCode");
            return (Criteria) this;
        }

        public Criteria andIssueTskCodeLessThanOrEqualTo(String value) {
            addCriterion("issue_tsk_code <=", value, "issueTskCode");
            return (Criteria) this;
        }

        public Criteria andIssueTskCodeLike(String value) {
            addCriterion("issue_tsk_code like", value, "issueTskCode");
            return (Criteria) this;
        }

        public Criteria andIssueTskCodeNotLike(String value) {
            addCriterion("issue_tsk_code not like", value, "issueTskCode");
            return (Criteria) this;
        }

        public Criteria andIssueTskCodeIn(List<String> values) {
            addCriterion("issue_tsk_code in", values, "issueTskCode");
            return (Criteria) this;
        }

        public Criteria andIssueTskCodeNotIn(List<String> values) {
            addCriterion("issue_tsk_code not in", values, "issueTskCode");
            return (Criteria) this;
        }

        public Criteria andIssueTskCodeBetween(String value1, String value2) {
            addCriterion("issue_tsk_code between", value1, value2, "issueTskCode");
            return (Criteria) this;
        }

        public Criteria andIssueTskCodeNotBetween(String value1, String value2) {
            addCriterion("issue_tsk_code not between", value1, value2, "issueTskCode");
            return (Criteria) this;
        }

        public Criteria andIssueBodyIsNull() {
            addCriterion("issue_body is null");
            return (Criteria) this;
        }

        public Criteria andIssueBodyIsNotNull() {
            addCriterion("issue_body is not null");
            return (Criteria) this;
        }

        public Criteria andIssueBodyEqualTo(String value) {
            addCriterion("issue_body =", value, "issueBody");
            return (Criteria) this;
        }

        public Criteria andIssueBodyNotEqualTo(String value) {
            addCriterion("issue_body <>", value, "issueBody");
            return (Criteria) this;
        }

        public Criteria andIssueBodyGreaterThan(String value) {
            addCriterion("issue_body >", value, "issueBody");
            return (Criteria) this;
        }

        public Criteria andIssueBodyGreaterThanOrEqualTo(String value) {
            addCriterion("issue_body >=", value, "issueBody");
            return (Criteria) this;
        }

        public Criteria andIssueBodyLessThan(String value) {
            addCriterion("issue_body <", value, "issueBody");
            return (Criteria) this;
        }

        public Criteria andIssueBodyLessThanOrEqualTo(String value) {
            addCriterion("issue_body <=", value, "issueBody");
            return (Criteria) this;
        }

        public Criteria andIssueBodyLike(String value) {
            addCriterion("issue_body like", value, "issueBody");
            return (Criteria) this;
        }

        public Criteria andIssueBodyNotLike(String value) {
            addCriterion("issue_body not like", value, "issueBody");
            return (Criteria) this;
        }

        public Criteria andIssueBodyIn(List<String> values) {
            addCriterion("issue_body in", values, "issueBody");
            return (Criteria) this;
        }

        public Criteria andIssueBodyNotIn(List<String> values) {
            addCriterion("issue_body not in", values, "issueBody");
            return (Criteria) this;
        }

        public Criteria andIssueBodyBetween(String value1, String value2) {
            addCriterion("issue_body between", value1, value2, "issueBody");
            return (Criteria) this;
        }

        public Criteria andIssueBodyNotBetween(String value1, String value2) {
            addCriterion("issue_body not between", value1, value2, "issueBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdIsNull() {
            addCriterion("rfpay_bill_id is null");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdIsNotNull() {
            addCriterion("rfpay_bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdEqualTo(String value) {
            addCriterion("rfpay_bill_id =", value, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdNotEqualTo(String value) {
            addCriterion("rfpay_bill_id <>", value, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdGreaterThan(String value) {
            addCriterion("rfpay_bill_id >", value, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("rfpay_bill_id >=", value, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdLessThan(String value) {
            addCriterion("rfpay_bill_id <", value, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdLessThanOrEqualTo(String value) {
            addCriterion("rfpay_bill_id <=", value, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdLike(String value) {
            addCriterion("rfpay_bill_id like", value, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdNotLike(String value) {
            addCriterion("rfpay_bill_id not like", value, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdIn(List<String> values) {
            addCriterion("rfpay_bill_id in", values, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdNotIn(List<String> values) {
            addCriterion("rfpay_bill_id not in", values, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdBetween(String value1, String value2) {
            addCriterion("rfpay_bill_id between", value1, value2, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdNotBetween(String value1, String value2) {
            addCriterion("rfpay_bill_id not between", value1, value2, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoIsNull() {
            addCriterion("rfpay_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoIsNotNull() {
            addCriterion("rfpay_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoEqualTo(String value) {
            addCriterion("rfpay_trade_no =", value, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoNotEqualTo(String value) {
            addCriterion("rfpay_trade_no <>", value, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoGreaterThan(String value) {
            addCriterion("rfpay_trade_no >", value, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("rfpay_trade_no >=", value, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoLessThan(String value) {
            addCriterion("rfpay_trade_no <", value, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoLessThanOrEqualTo(String value) {
            addCriterion("rfpay_trade_no <=", value, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoLike(String value) {
            addCriterion("rfpay_trade_no like", value, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoNotLike(String value) {
            addCriterion("rfpay_trade_no not like", value, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoIn(List<String> values) {
            addCriterion("rfpay_trade_no in", values, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoNotIn(List<String> values) {
            addCriterion("rfpay_trade_no not in", values, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoBetween(String value1, String value2) {
            addCriterion("rfpay_trade_no between", value1, value2, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoNotBetween(String value1, String value2) {
            addCriterion("rfpay_trade_no not between", value1, value2, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyIsNull() {
            addCriterion("rfpay_body is null");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyIsNotNull() {
            addCriterion("rfpay_body is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyEqualTo(String value) {
            addCriterion("rfpay_body =", value, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyNotEqualTo(String value) {
            addCriterion("rfpay_body <>", value, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyGreaterThan(String value) {
            addCriterion("rfpay_body >", value, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyGreaterThanOrEqualTo(String value) {
            addCriterion("rfpay_body >=", value, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyLessThan(String value) {
            addCriterion("rfpay_body <", value, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyLessThanOrEqualTo(String value) {
            addCriterion("rfpay_body <=", value, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyLike(String value) {
            addCriterion("rfpay_body like", value, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyNotLike(String value) {
            addCriterion("rfpay_body not like", value, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyIn(List<String> values) {
            addCriterion("rfpay_body in", values, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyNotIn(List<String> values) {
            addCriterion("rfpay_body not in", values, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyBetween(String value1, String value2) {
            addCriterion("rfpay_body between", value1, value2, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyNotBetween(String value1, String value2) {
            addCriterion("rfpay_body not between", value1, value2, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeIsNull() {
            addCriterion("rfpay_type is null");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeIsNotNull() {
            addCriterion("rfpay_type is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeEqualTo(String value) {
            addCriterion("rfpay_type =", value, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeNotEqualTo(String value) {
            addCriterion("rfpay_type <>", value, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeGreaterThan(String value) {
            addCriterion("rfpay_type >", value, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("rfpay_type >=", value, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeLessThan(String value) {
            addCriterion("rfpay_type <", value, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeLessThanOrEqualTo(String value) {
            addCriterion("rfpay_type <=", value, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeLike(String value) {
            addCriterion("rfpay_type like", value, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeNotLike(String value) {
            addCriterion("rfpay_type not like", value, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeIn(List<String> values) {
            addCriterion("rfpay_type in", values, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeNotIn(List<String> values) {
            addCriterion("rfpay_type not in", values, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeBetween(String value1, String value2) {
            addCriterion("rfpay_type between", value1, value2, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeNotBetween(String value1, String value2) {
            addCriterion("rfpay_type not between", value1, value2, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeIsNull() {
            addCriterion("rfpay_create_time is null");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeIsNotNull() {
            addCriterion("rfpay_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeEqualTo(Date value) {
            addCriterion("rfpay_create_time =", value, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeNotEqualTo(Date value) {
            addCriterion("rfpay_create_time <>", value, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeGreaterThan(Date value) {
            addCriterion("rfpay_create_time >", value, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rfpay_create_time >=", value, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeLessThan(Date value) {
            addCriterion("rfpay_create_time <", value, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("rfpay_create_time <=", value, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeIn(List<Date> values) {
            addCriterion("rfpay_create_time in", values, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeNotIn(List<Date> values) {
            addCriterion("rfpay_create_time not in", values, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeBetween(Date value1, Date value2) {
            addCriterion("rfpay_create_time between", value1, value2, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("rfpay_create_time not between", value1, value2, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeIsNull() {
            addCriterion("rfpay_close_time is null");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeIsNotNull() {
            addCriterion("rfpay_close_time is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeEqualTo(Date value) {
            addCriterion("rfpay_close_time =", value, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeNotEqualTo(Date value) {
            addCriterion("rfpay_close_time <>", value, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeGreaterThan(Date value) {
            addCriterion("rfpay_close_time >", value, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rfpay_close_time >=", value, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeLessThan(Date value) {
            addCriterion("rfpay_close_time <", value, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeLessThanOrEqualTo(Date value) {
            addCriterion("rfpay_close_time <=", value, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeIn(List<Date> values) {
            addCriterion("rfpay_close_time in", values, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeNotIn(List<Date> values) {
            addCriterion("rfpay_close_time not in", values, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeBetween(Date value1, Date value2) {
            addCriterion("rfpay_close_time between", value1, value2, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeNotBetween(Date value1, Date value2) {
            addCriterion("rfpay_close_time not between", value1, value2, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountIsNull() {
            addCriterion("rfpay_account is null");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountIsNotNull() {
            addCriterion("rfpay_account is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountEqualTo(String value) {
            addCriterion("rfpay_account =", value, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountNotEqualTo(String value) {
            addCriterion("rfpay_account <>", value, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountGreaterThan(String value) {
            addCriterion("rfpay_account >", value, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountGreaterThanOrEqualTo(String value) {
            addCriterion("rfpay_account >=", value, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountLessThan(String value) {
            addCriterion("rfpay_account <", value, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountLessThanOrEqualTo(String value) {
            addCriterion("rfpay_account <=", value, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountLike(String value) {
            addCriterion("rfpay_account like", value, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountNotLike(String value) {
            addCriterion("rfpay_account not like", value, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountIn(List<String> values) {
            addCriterion("rfpay_account in", values, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountNotIn(List<String> values) {
            addCriterion("rfpay_account not in", values, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountBetween(String value1, String value2) {
            addCriterion("rfpay_account between", value1, value2, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountNotBetween(String value1, String value2) {
            addCriterion("rfpay_account not between", value1, value2, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateIsNull() {
            addCriterion("rfpay_fee_rate is null");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateIsNotNull() {
            addCriterion("rfpay_fee_rate is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateEqualTo(BigDecimal value) {
            addCriterion("rfpay_fee_rate =", value, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateNotEqualTo(BigDecimal value) {
            addCriterion("rfpay_fee_rate <>", value, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateGreaterThan(BigDecimal value) {
            addCriterion("rfpay_fee_rate >", value, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rfpay_fee_rate >=", value, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateLessThan(BigDecimal value) {
            addCriterion("rfpay_fee_rate <", value, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rfpay_fee_rate <=", value, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateIn(List<BigDecimal> values) {
            addCriterion("rfpay_fee_rate in", values, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateNotIn(List<BigDecimal> values) {
            addCriterion("rfpay_fee_rate not in", values, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rfpay_fee_rate between", value1, value2, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rfpay_fee_rate not between", value1, value2, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeIsNull() {
            addCriterion("rfpay_clearing_fee is null");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeIsNotNull() {
            addCriterion("rfpay_clearing_fee is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeEqualTo(BigDecimal value) {
            addCriterion("rfpay_clearing_fee =", value, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeNotEqualTo(BigDecimal value) {
            addCriterion("rfpay_clearing_fee <>", value, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeGreaterThan(BigDecimal value) {
            addCriterion("rfpay_clearing_fee >", value, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rfpay_clearing_fee >=", value, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeLessThan(BigDecimal value) {
            addCriterion("rfpay_clearing_fee <", value, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rfpay_clearing_fee <=", value, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeIn(List<BigDecimal> values) {
            addCriterion("rfpay_clearing_fee in", values, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeNotIn(List<BigDecimal> values) {
            addCriterion("rfpay_clearing_fee not in", values, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rfpay_clearing_fee between", value1, value2, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rfpay_clearing_fee not between", value1, value2, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeIsNull() {
            addCriterion("rfpay_actual_clearing_fee is null");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeIsNotNull() {
            addCriterion("rfpay_actual_clearing_fee is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeEqualTo(Long value) {
            addCriterion("rfpay_actual_clearing_fee =", value, "rfpayActualClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeNotEqualTo(Long value) {
            addCriterion("rfpay_actual_clearing_fee <>", value, "rfpayActualClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeGreaterThan(Long value) {
            addCriterion("rfpay_actual_clearing_fee >", value, "rfpayActualClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("rfpay_actual_clearing_fee >=", value, "rfpayActualClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeLessThan(Long value) {
            addCriterion("rfpay_actual_clearing_fee <", value, "rfpayActualClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeLessThanOrEqualTo(Long value) {
            addCriterion("rfpay_actual_clearing_fee <=", value, "rfpayActualClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeIn(List<Long> values) {
            addCriterion("rfpay_actual_clearing_fee in", values, "rfpayActualClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeNotIn(List<Long> values) {
            addCriterion("rfpay_actual_clearing_fee not in", values, "rfpayActualClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeBetween(Long value1, Long value2) {
            addCriterion("rfpay_actual_clearing_fee between", value1, value2, "rfpayActualClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeNotBetween(Long value1, Long value2) {
            addCriterion("rfpay_actual_clearing_fee not between", value1, value2, "rfpayActualClearingFee");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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