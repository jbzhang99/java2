package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenOrderTotalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenOrderTotalExample() {
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

        public Criteria andCommunityIdIsNull() {
            addCriterion("community_id is null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIsNotNull() {
            addCriterion("community_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdEqualTo(Long value) {
            addCriterion("community_id =", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotEqualTo(Long value) {
            addCriterion("community_id <>", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThan(Long value) {
            addCriterion("community_id >", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("community_id >=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThan(Long value) {
            addCriterion("community_id <", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThanOrEqualTo(Long value) {
            addCriterion("community_id <=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIn(List<Long> values) {
            addCriterion("community_id in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotIn(List<Long> values) {
            addCriterion("community_id not in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdBetween(Long value1, Long value2) {
            addCriterion("community_id between", value1, value2, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotBetween(Long value1, Long value2) {
            addCriterion("community_id not between", value1, value2, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityAccountIdIsNull() {
            addCriterion("community_account_id is null");
            return (Criteria) this;
        }

        public Criteria andCommunityAccountIdIsNotNull() {
            addCriterion("community_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityAccountIdEqualTo(String value) {
            addCriterion("community_account_id =", value, "communityAccountId");
            return (Criteria) this;
        }

        public Criteria andCommunityAccountIdNotEqualTo(String value) {
            addCriterion("community_account_id <>", value, "communityAccountId");
            return (Criteria) this;
        }

        public Criteria andCommunityAccountIdGreaterThan(String value) {
            addCriterion("community_account_id >", value, "communityAccountId");
            return (Criteria) this;
        }

        public Criteria andCommunityAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("community_account_id >=", value, "communityAccountId");
            return (Criteria) this;
        }

        public Criteria andCommunityAccountIdLessThan(String value) {
            addCriterion("community_account_id <", value, "communityAccountId");
            return (Criteria) this;
        }

        public Criteria andCommunityAccountIdLessThanOrEqualTo(String value) {
            addCriterion("community_account_id <=", value, "communityAccountId");
            return (Criteria) this;
        }

        public Criteria andCommunityAccountIdLike(String value) {
            addCriterion("community_account_id like", value, "communityAccountId");
            return (Criteria) this;
        }

        public Criteria andCommunityAccountIdNotLike(String value) {
            addCriterion("community_account_id not like", value, "communityAccountId");
            return (Criteria) this;
        }

        public Criteria andCommunityAccountIdIn(List<String> values) {
            addCriterion("community_account_id in", values, "communityAccountId");
            return (Criteria) this;
        }

        public Criteria andCommunityAccountIdNotIn(List<String> values) {
            addCriterion("community_account_id not in", values, "communityAccountId");
            return (Criteria) this;
        }

        public Criteria andCommunityAccountIdBetween(String value1, String value2) {
            addCriterion("community_account_id between", value1, value2, "communityAccountId");
            return (Criteria) this;
        }

        public Criteria andCommunityAccountIdNotBetween(String value1, String value2) {
            addCriterion("community_account_id not between", value1, value2, "communityAccountId");
            return (Criteria) this;
        }

        public Criteria andThinkAccountIdIsNull() {
            addCriterion("think_account_id is null");
            return (Criteria) this;
        }

        public Criteria andThinkAccountIdIsNotNull() {
            addCriterion("think_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andThinkAccountIdEqualTo(String value) {
            addCriterion("think_account_id =", value, "thinkAccountId");
            return (Criteria) this;
        }

        public Criteria andThinkAccountIdNotEqualTo(String value) {
            addCriterion("think_account_id <>", value, "thinkAccountId");
            return (Criteria) this;
        }

        public Criteria andThinkAccountIdGreaterThan(String value) {
            addCriterion("think_account_id >", value, "thinkAccountId");
            return (Criteria) this;
        }

        public Criteria andThinkAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("think_account_id >=", value, "thinkAccountId");
            return (Criteria) this;
        }

        public Criteria andThinkAccountIdLessThan(String value) {
            addCriterion("think_account_id <", value, "thinkAccountId");
            return (Criteria) this;
        }

        public Criteria andThinkAccountIdLessThanOrEqualTo(String value) {
            addCriterion("think_account_id <=", value, "thinkAccountId");
            return (Criteria) this;
        }

        public Criteria andThinkAccountIdLike(String value) {
            addCriterion("think_account_id like", value, "thinkAccountId");
            return (Criteria) this;
        }

        public Criteria andThinkAccountIdNotLike(String value) {
            addCriterion("think_account_id not like", value, "thinkAccountId");
            return (Criteria) this;
        }

        public Criteria andThinkAccountIdIn(List<String> values) {
            addCriterion("think_account_id in", values, "thinkAccountId");
            return (Criteria) this;
        }

        public Criteria andThinkAccountIdNotIn(List<String> values) {
            addCriterion("think_account_id not in", values, "thinkAccountId");
            return (Criteria) this;
        }

        public Criteria andThinkAccountIdBetween(String value1, String value2) {
            addCriterion("think_account_id between", value1, value2, "thinkAccountId");
            return (Criteria) this;
        }

        public Criteria andThinkAccountIdNotBetween(String value1, String value2) {
            addCriterion("think_account_id not between", value1, value2, "thinkAccountId");
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

        public Criteria andExpireTimeIsNull() {
            addCriterion("expire_time is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(Date value) {
            addCriterion("expire_time =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Date value) {
            addCriterion("expire_time <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Date value) {
            addCriterion("expire_time >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expire_time >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Date value) {
            addCriterion("expire_time <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Date value) {
            addCriterion("expire_time <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Date> values) {
            addCriterion("expire_time in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Date> values) {
            addCriterion("expire_time not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Date value1, Date value2) {
            addCriterion("expire_time between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Date value1, Date value2) {
            addCriterion("expire_time not between", value1, value2, "expireTime");
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

        public Criteria andBillStatusIsNull() {
            addCriterion("bill_status is null");
            return (Criteria) this;
        }

        public Criteria andBillStatusIsNotNull() {
            addCriterion("bill_status is not null");
            return (Criteria) this;
        }

        public Criteria andBillStatusEqualTo(Integer value) {
            addCriterion("bill_status =", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotEqualTo(Integer value) {
            addCriterion("bill_status <>", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThan(Integer value) {
            addCriterion("bill_status >", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("bill_status >=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThan(Integer value) {
            addCriterion("bill_status <", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThanOrEqualTo(Integer value) {
            addCriterion("bill_status <=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusIn(List<Integer> values) {
            addCriterion("bill_status in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotIn(List<Integer> values) {
            addCriterion("bill_status not in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusBetween(Integer value1, Integer value2) {
            addCriterion("bill_status between", value1, value2, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("bill_status not between", value1, value2, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillFinishedTimeIsNull() {
            addCriterion("bill_finished_time is null");
            return (Criteria) this;
        }

        public Criteria andBillFinishedTimeIsNotNull() {
            addCriterion("bill_finished_time is not null");
            return (Criteria) this;
        }

        public Criteria andBillFinishedTimeEqualTo(Date value) {
            addCriterion("bill_finished_time =", value, "billFinishedTime");
            return (Criteria) this;
        }

        public Criteria andBillFinishedTimeNotEqualTo(Date value) {
            addCriterion("bill_finished_time <>", value, "billFinishedTime");
            return (Criteria) this;
        }

        public Criteria andBillFinishedTimeGreaterThan(Date value) {
            addCriterion("bill_finished_time >", value, "billFinishedTime");
            return (Criteria) this;
        }

        public Criteria andBillFinishedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bill_finished_time >=", value, "billFinishedTime");
            return (Criteria) this;
        }

        public Criteria andBillFinishedTimeLessThan(Date value) {
            addCriterion("bill_finished_time <", value, "billFinishedTime");
            return (Criteria) this;
        }

        public Criteria andBillFinishedTimeLessThanOrEqualTo(Date value) {
            addCriterion("bill_finished_time <=", value, "billFinishedTime");
            return (Criteria) this;
        }

        public Criteria andBillFinishedTimeIn(List<Date> values) {
            addCriterion("bill_finished_time in", values, "billFinishedTime");
            return (Criteria) this;
        }

        public Criteria andBillFinishedTimeNotIn(List<Date> values) {
            addCriterion("bill_finished_time not in", values, "billFinishedTime");
            return (Criteria) this;
        }

        public Criteria andBillFinishedTimeBetween(Date value1, Date value2) {
            addCriterion("bill_finished_time between", value1, value2, "billFinishedTime");
            return (Criteria) this;
        }

        public Criteria andBillFinishedTimeNotBetween(Date value1, Date value2) {
            addCriterion("bill_finished_time not between", value1, value2, "billFinishedTime");
            return (Criteria) this;
        }

        public Criteria andCommunityTradeNoIsNull() {
            addCriterion("community_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andCommunityTradeNoIsNotNull() {
            addCriterion("community_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityTradeNoEqualTo(String value) {
            addCriterion("community_trade_no =", value, "communityTradeNo");
            return (Criteria) this;
        }

        public Criteria andCommunityTradeNoNotEqualTo(String value) {
            addCriterion("community_trade_no <>", value, "communityTradeNo");
            return (Criteria) this;
        }

        public Criteria andCommunityTradeNoGreaterThan(String value) {
            addCriterion("community_trade_no >", value, "communityTradeNo");
            return (Criteria) this;
        }

        public Criteria andCommunityTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("community_trade_no >=", value, "communityTradeNo");
            return (Criteria) this;
        }

        public Criteria andCommunityTradeNoLessThan(String value) {
            addCriterion("community_trade_no <", value, "communityTradeNo");
            return (Criteria) this;
        }

        public Criteria andCommunityTradeNoLessThanOrEqualTo(String value) {
            addCriterion("community_trade_no <=", value, "communityTradeNo");
            return (Criteria) this;
        }

        public Criteria andCommunityTradeNoLike(String value) {
            addCriterion("community_trade_no like", value, "communityTradeNo");
            return (Criteria) this;
        }

        public Criteria andCommunityTradeNoNotLike(String value) {
            addCriterion("community_trade_no not like", value, "communityTradeNo");
            return (Criteria) this;
        }

        public Criteria andCommunityTradeNoIn(List<String> values) {
            addCriterion("community_trade_no in", values, "communityTradeNo");
            return (Criteria) this;
        }

        public Criteria andCommunityTradeNoNotIn(List<String> values) {
            addCriterion("community_trade_no not in", values, "communityTradeNo");
            return (Criteria) this;
        }

        public Criteria andCommunityTradeNoBetween(String value1, String value2) {
            addCriterion("community_trade_no between", value1, value2, "communityTradeNo");
            return (Criteria) this;
        }

        public Criteria andCommunityTradeNoNotBetween(String value1, String value2) {
            addCriterion("community_trade_no not between", value1, value2, "communityTradeNo");
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

        public Criteria andTotalPlatformChargeIsNull() {
            addCriterion("total_platform_charge is null");
            return (Criteria) this;
        }

        public Criteria andTotalPlatformChargeIsNotNull() {
            addCriterion("total_platform_charge is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPlatformChargeEqualTo(BigDecimal value) {
            addCriterion("total_platform_charge =", value, "totalPlatformCharge");
            return (Criteria) this;
        }

        public Criteria andTotalPlatformChargeNotEqualTo(BigDecimal value) {
            addCriterion("total_platform_charge <>", value, "totalPlatformCharge");
            return (Criteria) this;
        }

        public Criteria andTotalPlatformChargeGreaterThan(BigDecimal value) {
            addCriterion("total_platform_charge >", value, "totalPlatformCharge");
            return (Criteria) this;
        }

        public Criteria andTotalPlatformChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_platform_charge >=", value, "totalPlatformCharge");
            return (Criteria) this;
        }

        public Criteria andTotalPlatformChargeLessThan(BigDecimal value) {
            addCriterion("total_platform_charge <", value, "totalPlatformCharge");
            return (Criteria) this;
        }

        public Criteria andTotalPlatformChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_platform_charge <=", value, "totalPlatformCharge");
            return (Criteria) this;
        }

        public Criteria andTotalPlatformChargeIn(List<BigDecimal> values) {
            addCriterion("total_platform_charge in", values, "totalPlatformCharge");
            return (Criteria) this;
        }

        public Criteria andTotalPlatformChargeNotIn(List<BigDecimal> values) {
            addCriterion("total_platform_charge not in", values, "totalPlatformCharge");
            return (Criteria) this;
        }

        public Criteria andTotalPlatformChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_platform_charge between", value1, value2, "totalPlatformCharge");
            return (Criteria) this;
        }

        public Criteria andTotalPlatformChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_platform_charge not between", value1, value2, "totalPlatformCharge");
            return (Criteria) this;
        }

        public Criteria andTotalToServiceChargeIsNull() {
            addCriterion("total_to_service_charge is null");
            return (Criteria) this;
        }

        public Criteria andTotalToServiceChargeIsNotNull() {
            addCriterion("total_to_service_charge is not null");
            return (Criteria) this;
        }

        public Criteria andTotalToServiceChargeEqualTo(BigDecimal value) {
            addCriterion("total_to_service_charge =", value, "totalToServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalToServiceChargeNotEqualTo(BigDecimal value) {
            addCriterion("total_to_service_charge <>", value, "totalToServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalToServiceChargeGreaterThan(BigDecimal value) {
            addCriterion("total_to_service_charge >", value, "totalToServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalToServiceChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_to_service_charge >=", value, "totalToServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalToServiceChargeLessThan(BigDecimal value) {
            addCriterion("total_to_service_charge <", value, "totalToServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalToServiceChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_to_service_charge <=", value, "totalToServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalToServiceChargeIn(List<BigDecimal> values) {
            addCriterion("total_to_service_charge in", values, "totalToServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalToServiceChargeNotIn(List<BigDecimal> values) {
            addCriterion("total_to_service_charge not in", values, "totalToServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalToServiceChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_to_service_charge between", value1, value2, "totalToServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalToServiceChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_to_service_charge not between", value1, value2, "totalToServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalServiceChargeIsNull() {
            addCriterion("total_service_charge is null");
            return (Criteria) this;
        }

        public Criteria andTotalServiceChargeIsNotNull() {
            addCriterion("total_service_charge is not null");
            return (Criteria) this;
        }

        public Criteria andTotalServiceChargeEqualTo(BigDecimal value) {
            addCriterion("total_service_charge =", value, "totalServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalServiceChargeNotEqualTo(BigDecimal value) {
            addCriterion("total_service_charge <>", value, "totalServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalServiceChargeGreaterThan(BigDecimal value) {
            addCriterion("total_service_charge >", value, "totalServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalServiceChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_service_charge >=", value, "totalServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalServiceChargeLessThan(BigDecimal value) {
            addCriterion("total_service_charge <", value, "totalServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalServiceChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_service_charge <=", value, "totalServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalServiceChargeIn(List<BigDecimal> values) {
            addCriterion("total_service_charge in", values, "totalServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalServiceChargeNotIn(List<BigDecimal> values) {
            addCriterion("total_service_charge not in", values, "totalServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalServiceChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_service_charge between", value1, value2, "totalServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalServiceChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_service_charge not between", value1, value2, "totalServiceCharge");
            return (Criteria) this;
        }

        public Criteria andTotalToReceiptAmountIsNull() {
            addCriterion("total_to_receipt_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalToReceiptAmountIsNotNull() {
            addCriterion("total_to_receipt_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalToReceiptAmountEqualTo(BigDecimal value) {
            addCriterion("total_to_receipt_amount =", value, "totalToReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalToReceiptAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_to_receipt_amount <>", value, "totalToReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalToReceiptAmountGreaterThan(BigDecimal value) {
            addCriterion("total_to_receipt_amount >", value, "totalToReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalToReceiptAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_to_receipt_amount >=", value, "totalToReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalToReceiptAmountLessThan(BigDecimal value) {
            addCriterion("total_to_receipt_amount <", value, "totalToReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalToReceiptAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_to_receipt_amount <=", value, "totalToReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalToReceiptAmountIn(List<BigDecimal> values) {
            addCriterion("total_to_receipt_amount in", values, "totalToReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalToReceiptAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_to_receipt_amount not in", values, "totalToReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalToReceiptAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_to_receipt_amount between", value1, value2, "totalToReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalToReceiptAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_to_receipt_amount not between", value1, value2, "totalToReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReceiptAmountIsNull() {
            addCriterion("total_receipt_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalReceiptAmountIsNotNull() {
            addCriterion("total_receipt_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalReceiptAmountEqualTo(BigDecimal value) {
            addCriterion("total_receipt_amount =", value, "totalReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReceiptAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_receipt_amount <>", value, "totalReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReceiptAmountGreaterThan(BigDecimal value) {
            addCriterion("total_receipt_amount >", value, "totalReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReceiptAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_receipt_amount >=", value, "totalReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReceiptAmountLessThan(BigDecimal value) {
            addCriterion("total_receipt_amount <", value, "totalReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReceiptAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_receipt_amount <=", value, "totalReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReceiptAmountIn(List<BigDecimal> values) {
            addCriterion("total_receipt_amount in", values, "totalReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReceiptAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_receipt_amount not in", values, "totalReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReceiptAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_receipt_amount between", value1, value2, "totalReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalReceiptAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_receipt_amount not between", value1, value2, "totalReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkToAmountIsNull() {
            addCriterion("total_think_to_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalThinkToAmountIsNotNull() {
            addCriterion("total_think_to_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalThinkToAmountEqualTo(BigDecimal value) {
            addCriterion("total_think_to_amount =", value, "totalThinkToAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkToAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_think_to_amount <>", value, "totalThinkToAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkToAmountGreaterThan(BigDecimal value) {
            addCriterion("total_think_to_amount >", value, "totalThinkToAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkToAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_think_to_amount >=", value, "totalThinkToAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkToAmountLessThan(BigDecimal value) {
            addCriterion("total_think_to_amount <", value, "totalThinkToAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkToAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_think_to_amount <=", value, "totalThinkToAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkToAmountIn(List<BigDecimal> values) {
            addCriterion("total_think_to_amount in", values, "totalThinkToAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkToAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_think_to_amount not in", values, "totalThinkToAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkToAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_think_to_amount between", value1, value2, "totalThinkToAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkToAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_think_to_amount not between", value1, value2, "totalThinkToAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkAmountIsNull() {
            addCriterion("total_think_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalThinkAmountIsNotNull() {
            addCriterion("total_think_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalThinkAmountEqualTo(BigDecimal value) {
            addCriterion("total_think_amount =", value, "totalThinkAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_think_amount <>", value, "totalThinkAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkAmountGreaterThan(BigDecimal value) {
            addCriterion("total_think_amount >", value, "totalThinkAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_think_amount >=", value, "totalThinkAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkAmountLessThan(BigDecimal value) {
            addCriterion("total_think_amount <", value, "totalThinkAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_think_amount <=", value, "totalThinkAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkAmountIn(List<BigDecimal> values) {
            addCriterion("total_think_amount in", values, "totalThinkAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_think_amount not in", values, "totalThinkAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_think_amount between", value1, value2, "totalThinkAmount");
            return (Criteria) this;
        }

        public Criteria andTotalThinkAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_think_amount not between", value1, value2, "totalThinkAmount");
            return (Criteria) this;
        }

        public Criteria andTotalRefundMoneyIsNull() {
            addCriterion("total_refund_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalRefundMoneyIsNotNull() {
            addCriterion("total_refund_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalRefundMoneyEqualTo(BigDecimal value) {
            addCriterion("total_refund_money =", value, "totalRefundMoney");
            return (Criteria) this;
        }

        public Criteria andTotalRefundMoneyNotEqualTo(BigDecimal value) {
            addCriterion("total_refund_money <>", value, "totalRefundMoney");
            return (Criteria) this;
        }

        public Criteria andTotalRefundMoneyGreaterThan(BigDecimal value) {
            addCriterion("total_refund_money >", value, "totalRefundMoney");
            return (Criteria) this;
        }

        public Criteria andTotalRefundMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_refund_money >=", value, "totalRefundMoney");
            return (Criteria) this;
        }

        public Criteria andTotalRefundMoneyLessThan(BigDecimal value) {
            addCriterion("total_refund_money <", value, "totalRefundMoney");
            return (Criteria) this;
        }

        public Criteria andTotalRefundMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_refund_money <=", value, "totalRefundMoney");
            return (Criteria) this;
        }

        public Criteria andTotalRefundMoneyIn(List<BigDecimal> values) {
            addCriterion("total_refund_money in", values, "totalRefundMoney");
            return (Criteria) this;
        }

        public Criteria andTotalRefundMoneyNotIn(List<BigDecimal> values) {
            addCriterion("total_refund_money not in", values, "totalRefundMoney");
            return (Criteria) this;
        }

        public Criteria andTotalRefundMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_refund_money between", value1, value2, "totalRefundMoney");
            return (Criteria) this;
        }

        public Criteria andTotalRefundMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_refund_money not between", value1, value2, "totalRefundMoney");
            return (Criteria) this;
        }

        public Criteria andRefundCountIsNull() {
            addCriterion("refund_count is null");
            return (Criteria) this;
        }

        public Criteria andRefundCountIsNotNull() {
            addCriterion("refund_count is not null");
            return (Criteria) this;
        }

        public Criteria andRefundCountEqualTo(Integer value) {
            addCriterion("refund_count =", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountNotEqualTo(Integer value) {
            addCriterion("refund_count <>", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountGreaterThan(Integer value) {
            addCriterion("refund_count >", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_count >=", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountLessThan(Integer value) {
            addCriterion("refund_count <", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountLessThanOrEqualTo(Integer value) {
            addCriterion("refund_count <=", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountIn(List<Integer> values) {
            addCriterion("refund_count in", values, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountNotIn(List<Integer> values) {
            addCriterion("refund_count not in", values, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountBetween(Integer value1, Integer value2) {
            addCriterion("refund_count between", value1, value2, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_count not between", value1, value2, "refundCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountIsNull() {
            addCriterion("store_count is null");
            return (Criteria) this;
        }

        public Criteria andStoreCountIsNotNull() {
            addCriterion("store_count is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCountEqualTo(Integer value) {
            addCriterion("store_count =", value, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountNotEqualTo(Integer value) {
            addCriterion("store_count <>", value, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountGreaterThan(Integer value) {
            addCriterion("store_count >", value, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_count >=", value, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountLessThan(Integer value) {
            addCriterion("store_count <", value, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountLessThanOrEqualTo(Integer value) {
            addCriterion("store_count <=", value, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountIn(List<Integer> values) {
            addCriterion("store_count in", values, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountNotIn(List<Integer> values) {
            addCriterion("store_count not in", values, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountBetween(Integer value1, Integer value2) {
            addCriterion("store_count between", value1, value2, "storeCount");
            return (Criteria) this;
        }

        public Criteria andStoreCountNotBetween(Integer value1, Integer value2) {
            addCriterion("store_count not between", value1, value2, "storeCount");
            return (Criteria) this;
        }

        public Criteria andBillSplitStatusIsNull() {
            addCriterion("bill_split_status is null");
            return (Criteria) this;
        }

        public Criteria andBillSplitStatusIsNotNull() {
            addCriterion("bill_split_status is not null");
            return (Criteria) this;
        }

        public Criteria andBillSplitStatusEqualTo(Integer value) {
            addCriterion("bill_split_status =", value, "billSplitStatus");
            return (Criteria) this;
        }

        public Criteria andBillSplitStatusNotEqualTo(Integer value) {
            addCriterion("bill_split_status <>", value, "billSplitStatus");
            return (Criteria) this;
        }

        public Criteria andBillSplitStatusGreaterThan(Integer value) {
            addCriterion("bill_split_status >", value, "billSplitStatus");
            return (Criteria) this;
        }

        public Criteria andBillSplitStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("bill_split_status >=", value, "billSplitStatus");
            return (Criteria) this;
        }

        public Criteria andBillSplitStatusLessThan(Integer value) {
            addCriterion("bill_split_status <", value, "billSplitStatus");
            return (Criteria) this;
        }

        public Criteria andBillSplitStatusLessThanOrEqualTo(Integer value) {
            addCriterion("bill_split_status <=", value, "billSplitStatus");
            return (Criteria) this;
        }

        public Criteria andBillSplitStatusIn(List<Integer> values) {
            addCriterion("bill_split_status in", values, "billSplitStatus");
            return (Criteria) this;
        }

        public Criteria andBillSplitStatusNotIn(List<Integer> values) {
            addCriterion("bill_split_status not in", values, "billSplitStatus");
            return (Criteria) this;
        }

        public Criteria andBillSplitStatusBetween(Integer value1, Integer value2) {
            addCriterion("bill_split_status between", value1, value2, "billSplitStatus");
            return (Criteria) this;
        }

        public Criteria andBillSplitStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("bill_split_status not between", value1, value2, "billSplitStatus");
            return (Criteria) this;
        }

        public Criteria andBillSplitTimeIsNull() {
            addCriterion("bill_split_time is null");
            return (Criteria) this;
        }

        public Criteria andBillSplitTimeIsNotNull() {
            addCriterion("bill_split_time is not null");
            return (Criteria) this;
        }

        public Criteria andBillSplitTimeEqualTo(Date value) {
            addCriterion("bill_split_time =", value, "billSplitTime");
            return (Criteria) this;
        }

        public Criteria andBillSplitTimeNotEqualTo(Date value) {
            addCriterion("bill_split_time <>", value, "billSplitTime");
            return (Criteria) this;
        }

        public Criteria andBillSplitTimeGreaterThan(Date value) {
            addCriterion("bill_split_time >", value, "billSplitTime");
            return (Criteria) this;
        }

        public Criteria andBillSplitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bill_split_time >=", value, "billSplitTime");
            return (Criteria) this;
        }

        public Criteria andBillSplitTimeLessThan(Date value) {
            addCriterion("bill_split_time <", value, "billSplitTime");
            return (Criteria) this;
        }

        public Criteria andBillSplitTimeLessThanOrEqualTo(Date value) {
            addCriterion("bill_split_time <=", value, "billSplitTime");
            return (Criteria) this;
        }

        public Criteria andBillSplitTimeIn(List<Date> values) {
            addCriterion("bill_split_time in", values, "billSplitTime");
            return (Criteria) this;
        }

        public Criteria andBillSplitTimeNotIn(List<Date> values) {
            addCriterion("bill_split_time not in", values, "billSplitTime");
            return (Criteria) this;
        }

        public Criteria andBillSplitTimeBetween(Date value1, Date value2) {
            addCriterion("bill_split_time between", value1, value2, "billSplitTime");
            return (Criteria) this;
        }

        public Criteria andBillSplitTimeNotBetween(Date value1, Date value2) {
            addCriterion("bill_split_time not between", value1, value2, "billSplitTime");
            return (Criteria) this;
        }

        public Criteria andSplitAmountIsNull() {
            addCriterion("split_amount is null");
            return (Criteria) this;
        }

        public Criteria andSplitAmountIsNotNull() {
            addCriterion("split_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSplitAmountEqualTo(BigDecimal value) {
            addCriterion("split_amount =", value, "splitAmount");
            return (Criteria) this;
        }

        public Criteria andSplitAmountNotEqualTo(BigDecimal value) {
            addCriterion("split_amount <>", value, "splitAmount");
            return (Criteria) this;
        }

        public Criteria andSplitAmountGreaterThan(BigDecimal value) {
            addCriterion("split_amount >", value, "splitAmount");
            return (Criteria) this;
        }

        public Criteria andSplitAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("split_amount >=", value, "splitAmount");
            return (Criteria) this;
        }

        public Criteria andSplitAmountLessThan(BigDecimal value) {
            addCriterion("split_amount <", value, "splitAmount");
            return (Criteria) this;
        }

        public Criteria andSplitAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("split_amount <=", value, "splitAmount");
            return (Criteria) this;
        }

        public Criteria andSplitAmountIn(List<BigDecimal> values) {
            addCriterion("split_amount in", values, "splitAmount");
            return (Criteria) this;
        }

        public Criteria andSplitAmountNotIn(List<BigDecimal> values) {
            addCriterion("split_amount not in", values, "splitAmount");
            return (Criteria) this;
        }

        public Criteria andSplitAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("split_amount between", value1, value2, "splitAmount");
            return (Criteria) this;
        }

        public Criteria andSplitAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("split_amount not between", value1, value2, "splitAmount");
            return (Criteria) this;
        }

        public Criteria andPfBalanceStatusIsNull() {
            addCriterion("pf_balance_status is null");
            return (Criteria) this;
        }

        public Criteria andPfBalanceStatusIsNotNull() {
            addCriterion("pf_balance_status is not null");
            return (Criteria) this;
        }

        public Criteria andPfBalanceStatusEqualTo(Integer value) {
            addCriterion("pf_balance_status =", value, "pfBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBalanceStatusNotEqualTo(Integer value) {
            addCriterion("pf_balance_status <>", value, "pfBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBalanceStatusGreaterThan(Integer value) {
            addCriterion("pf_balance_status >", value, "pfBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBalanceStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pf_balance_status >=", value, "pfBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBalanceStatusLessThan(Integer value) {
            addCriterion("pf_balance_status <", value, "pfBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBalanceStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pf_balance_status <=", value, "pfBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBalanceStatusIn(List<Integer> values) {
            addCriterion("pf_balance_status in", values, "pfBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBalanceStatusNotIn(List<Integer> values) {
            addCriterion("pf_balance_status not in", values, "pfBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBalanceStatusBetween(Integer value1, Integer value2) {
            addCriterion("pf_balance_status between", value1, value2, "pfBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBalanceStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pf_balance_status not between", value1, value2, "pfBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBussinessBalanceStatusIsNull() {
            addCriterion("pf_bussiness_balance_status is null");
            return (Criteria) this;
        }

        public Criteria andPfBussinessBalanceStatusIsNotNull() {
            addCriterion("pf_bussiness_balance_status is not null");
            return (Criteria) this;
        }

        public Criteria andPfBussinessBalanceStatusEqualTo(Integer value) {
            addCriterion("pf_bussiness_balance_status =", value, "pfBussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBussinessBalanceStatusNotEqualTo(Integer value) {
            addCriterion("pf_bussiness_balance_status <>", value, "pfBussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBussinessBalanceStatusGreaterThan(Integer value) {
            addCriterion("pf_bussiness_balance_status >", value, "pfBussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBussinessBalanceStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pf_bussiness_balance_status >=", value, "pfBussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBussinessBalanceStatusLessThan(Integer value) {
            addCriterion("pf_bussiness_balance_status <", value, "pfBussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBussinessBalanceStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pf_bussiness_balance_status <=", value, "pfBussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBussinessBalanceStatusIn(List<Integer> values) {
            addCriterion("pf_bussiness_balance_status in", values, "pfBussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBussinessBalanceStatusNotIn(List<Integer> values) {
            addCriterion("pf_bussiness_balance_status not in", values, "pfBussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBussinessBalanceStatusBetween(Integer value1, Integer value2) {
            addCriterion("pf_bussiness_balance_status between", value1, value2, "pfBussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfBussinessBalanceStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pf_bussiness_balance_status not between", value1, value2, "pfBussinessBalanceStatus");
            return (Criteria) this;
        }

        public Criteria andPfPayStatusIsNull() {
            addCriterion("pf_pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPfPayStatusIsNotNull() {
            addCriterion("pf_pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPfPayStatusEqualTo(Integer value) {
            addCriterion("pf_pay_status =", value, "pfPayStatus");
            return (Criteria) this;
        }

        public Criteria andPfPayStatusNotEqualTo(Integer value) {
            addCriterion("pf_pay_status <>", value, "pfPayStatus");
            return (Criteria) this;
        }

        public Criteria andPfPayStatusGreaterThan(Integer value) {
            addCriterion("pf_pay_status >", value, "pfPayStatus");
            return (Criteria) this;
        }

        public Criteria andPfPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pf_pay_status >=", value, "pfPayStatus");
            return (Criteria) this;
        }

        public Criteria andPfPayStatusLessThan(Integer value) {
            addCriterion("pf_pay_status <", value, "pfPayStatus");
            return (Criteria) this;
        }

        public Criteria andPfPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pf_pay_status <=", value, "pfPayStatus");
            return (Criteria) this;
        }

        public Criteria andPfPayStatusIn(List<Integer> values) {
            addCriterion("pf_pay_status in", values, "pfPayStatus");
            return (Criteria) this;
        }

        public Criteria andPfPayStatusNotIn(List<Integer> values) {
            addCriterion("pf_pay_status not in", values, "pfPayStatus");
            return (Criteria) this;
        }

        public Criteria andPfPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("pf_pay_status between", value1, value2, "pfPayStatus");
            return (Criteria) this;
        }

        public Criteria andPfPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pf_pay_status not between", value1, value2, "pfPayStatus");
            return (Criteria) this;
        }

        public Criteria andPfRefundStatusIsNull() {
            addCriterion("pf_refund_status is null");
            return (Criteria) this;
        }

        public Criteria andPfRefundStatusIsNotNull() {
            addCriterion("pf_refund_status is not null");
            return (Criteria) this;
        }

        public Criteria andPfRefundStatusEqualTo(Integer value) {
            addCriterion("pf_refund_status =", value, "pfRefundStatus");
            return (Criteria) this;
        }

        public Criteria andPfRefundStatusNotEqualTo(Integer value) {
            addCriterion("pf_refund_status <>", value, "pfRefundStatus");
            return (Criteria) this;
        }

        public Criteria andPfRefundStatusGreaterThan(Integer value) {
            addCriterion("pf_refund_status >", value, "pfRefundStatus");
            return (Criteria) this;
        }

        public Criteria andPfRefundStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pf_refund_status >=", value, "pfRefundStatus");
            return (Criteria) this;
        }

        public Criteria andPfRefundStatusLessThan(Integer value) {
            addCriterion("pf_refund_status <", value, "pfRefundStatus");
            return (Criteria) this;
        }

        public Criteria andPfRefundStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pf_refund_status <=", value, "pfRefundStatus");
            return (Criteria) this;
        }

        public Criteria andPfRefundStatusIn(List<Integer> values) {
            addCriterion("pf_refund_status in", values, "pfRefundStatus");
            return (Criteria) this;
        }

        public Criteria andPfRefundStatusNotIn(List<Integer> values) {
            addCriterion("pf_refund_status not in", values, "pfRefundStatus");
            return (Criteria) this;
        }

        public Criteria andPfRefundStatusBetween(Integer value1, Integer value2) {
            addCriterion("pf_refund_status between", value1, value2, "pfRefundStatus");
            return (Criteria) this;
        }

        public Criteria andPfRefundStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pf_refund_status not between", value1, value2, "pfRefundStatus");
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