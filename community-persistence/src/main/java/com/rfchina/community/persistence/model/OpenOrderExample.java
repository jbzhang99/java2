package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenOrderExample() {
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

        public Criteria andTotalIdIsNull() {
            addCriterion("total_id is null");
            return (Criteria) this;
        }

        public Criteria andTotalIdIsNotNull() {
            addCriterion("total_id is not null");
            return (Criteria) this;
        }

        public Criteria andTotalIdEqualTo(Long value) {
            addCriterion("total_id =", value, "totalId");
            return (Criteria) this;
        }

        public Criteria andTotalIdNotEqualTo(Long value) {
            addCriterion("total_id <>", value, "totalId");
            return (Criteria) this;
        }

        public Criteria andTotalIdGreaterThan(Long value) {
            addCriterion("total_id >", value, "totalId");
            return (Criteria) this;
        }

        public Criteria andTotalIdGreaterThanOrEqualTo(Long value) {
            addCriterion("total_id >=", value, "totalId");
            return (Criteria) this;
        }

        public Criteria andTotalIdLessThan(Long value) {
            addCriterion("total_id <", value, "totalId");
            return (Criteria) this;
        }

        public Criteria andTotalIdLessThanOrEqualTo(Long value) {
            addCriterion("total_id <=", value, "totalId");
            return (Criteria) this;
        }

        public Criteria andTotalIdIn(List<Long> values) {
            addCriterion("total_id in", values, "totalId");
            return (Criteria) this;
        }

        public Criteria andTotalIdNotIn(List<Long> values) {
            addCriterion("total_id not in", values, "totalId");
            return (Criteria) this;
        }

        public Criteria andTotalIdBetween(Long value1, Long value2) {
            addCriterion("total_id between", value1, value2, "totalId");
            return (Criteria) this;
        }

        public Criteria andTotalIdNotBetween(Long value1, Long value2) {
            addCriterion("total_id not between", value1, value2, "totalId");
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

        public Criteria andCautionIdIsNull() {
            addCriterion("caution_id is null");
            return (Criteria) this;
        }

        public Criteria andCautionIdIsNotNull() {
            addCriterion("caution_id is not null");
            return (Criteria) this;
        }

        public Criteria andCautionIdEqualTo(Long value) {
            addCriterion("caution_id =", value, "cautionId");
            return (Criteria) this;
        }

        public Criteria andCautionIdNotEqualTo(Long value) {
            addCriterion("caution_id <>", value, "cautionId");
            return (Criteria) this;
        }

        public Criteria andCautionIdGreaterThan(Long value) {
            addCriterion("caution_id >", value, "cautionId");
            return (Criteria) this;
        }

        public Criteria andCautionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("caution_id >=", value, "cautionId");
            return (Criteria) this;
        }

        public Criteria andCautionIdLessThan(Long value) {
            addCriterion("caution_id <", value, "cautionId");
            return (Criteria) this;
        }

        public Criteria andCautionIdLessThanOrEqualTo(Long value) {
            addCriterion("caution_id <=", value, "cautionId");
            return (Criteria) this;
        }

        public Criteria andCautionIdIn(List<Long> values) {
            addCriterion("caution_id in", values, "cautionId");
            return (Criteria) this;
        }

        public Criteria andCautionIdNotIn(List<Long> values) {
            addCriterion("caution_id not in", values, "cautionId");
            return (Criteria) this;
        }

        public Criteria andCautionIdBetween(Long value1, Long value2) {
            addCriterion("caution_id between", value1, value2, "cautionId");
            return (Criteria) this;
        }

        public Criteria andCautionIdNotBetween(Long value1, Long value2) {
            addCriterion("caution_id not between", value1, value2, "cautionId");
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

        public Criteria andClientIpIsNull() {
            addCriterion("client_ip is null");
            return (Criteria) this;
        }

        public Criteria andClientIpIsNotNull() {
            addCriterion("client_ip is not null");
            return (Criteria) this;
        }

        public Criteria andClientIpEqualTo(String value) {
            addCriterion("client_ip =", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotEqualTo(String value) {
            addCriterion("client_ip <>", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpGreaterThan(String value) {
            addCriterion("client_ip >", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpGreaterThanOrEqualTo(String value) {
            addCriterion("client_ip >=", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLessThan(String value) {
            addCriterion("client_ip <", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLessThanOrEqualTo(String value) {
            addCriterion("client_ip <=", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLike(String value) {
            addCriterion("client_ip like", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotLike(String value) {
            addCriterion("client_ip not like", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpIn(List<String> values) {
            addCriterion("client_ip in", values, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotIn(List<String> values) {
            addCriterion("client_ip not in", values, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpBetween(String value1, String value2) {
            addCriterion("client_ip between", value1, value2, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotBetween(String value1, String value2) {
            addCriterion("client_ip not between", value1, value2, "clientIp");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNull() {
            addCriterion("project_type is null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNotNull() {
            addCriterion("project_type is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeEqualTo(String value) {
            addCriterion("project_type =", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotEqualTo(String value) {
            addCriterion("project_type <>", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThan(String value) {
            addCriterion("project_type >", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("project_type >=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThan(String value) {
            addCriterion("project_type <", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThanOrEqualTo(String value) {
            addCriterion("project_type <=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLike(String value) {
            addCriterion("project_type like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotLike(String value) {
            addCriterion("project_type not like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIn(List<String> values) {
            addCriterion("project_type in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotIn(List<String> values) {
            addCriterion("project_type not in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeBetween(String value1, String value2) {
            addCriterion("project_type between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotBetween(String value1, String value2) {
            addCriterion("project_type not between", value1, value2, "projectType");
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

        public Criteria andWeixinOpenIdIsNull() {
            addCriterion("weixin_open_id is null");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdIsNotNull() {
            addCriterion("weixin_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdEqualTo(String value) {
            addCriterion("weixin_open_id =", value, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdNotEqualTo(String value) {
            addCriterion("weixin_open_id <>", value, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdGreaterThan(String value) {
            addCriterion("weixin_open_id >", value, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("weixin_open_id >=", value, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdLessThan(String value) {
            addCriterion("weixin_open_id <", value, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdLessThanOrEqualTo(String value) {
            addCriterion("weixin_open_id <=", value, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdLike(String value) {
            addCriterion("weixin_open_id like", value, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdNotLike(String value) {
            addCriterion("weixin_open_id not like", value, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdIn(List<String> values) {
            addCriterion("weixin_open_id in", values, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdNotIn(List<String> values) {
            addCriterion("weixin_open_id not in", values, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdBetween(String value1, String value2) {
            addCriterion("weixin_open_id between", value1, value2, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdNotBetween(String value1, String value2) {
            addCriterion("weixin_open_id not between", value1, value2, "weixinOpenId");
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

        public Criteria andBussinessTypeIsNull() {
            addCriterion("bussiness_type is null");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeIsNotNull() {
            addCriterion("bussiness_type is not null");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeEqualTo(Integer value) {
            addCriterion("bussiness_type =", value, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeNotEqualTo(Integer value) {
            addCriterion("bussiness_type <>", value, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeGreaterThan(Integer value) {
            addCriterion("bussiness_type >", value, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("bussiness_type >=", value, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeLessThan(Integer value) {
            addCriterion("bussiness_type <", value, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeLessThanOrEqualTo(Integer value) {
            addCriterion("bussiness_type <=", value, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeIn(List<Integer> values) {
            addCriterion("bussiness_type in", values, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeNotIn(List<Integer> values) {
            addCriterion("bussiness_type not in", values, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeBetween(Integer value1, Integer value2) {
            addCriterion("bussiness_type between", value1, value2, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("bussiness_type not between", value1, value2, "bussinessType");
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

        public Criteria andReceiptAmountIsNull() {
            addCriterion("receipt_amount is null");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountIsNotNull() {
            addCriterion("receipt_amount is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountEqualTo(BigDecimal value) {
            addCriterion("receipt_amount =", value, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountNotEqualTo(BigDecimal value) {
            addCriterion("receipt_amount <>", value, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountGreaterThan(BigDecimal value) {
            addCriterion("receipt_amount >", value, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("receipt_amount >=", value, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountLessThan(BigDecimal value) {
            addCriterion("receipt_amount <", value, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("receipt_amount <=", value, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountIn(List<BigDecimal> values) {
            addCriterion("receipt_amount in", values, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountNotIn(List<BigDecimal> values) {
            addCriterion("receipt_amount not in", values, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receipt_amount between", value1, value2, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andReceiptAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receipt_amount not between", value1, value2, "receiptAmount");
            return (Criteria) this;
        }

        public Criteria andThinkChargeRateIsNull() {
            addCriterion("think_charge_rate is null");
            return (Criteria) this;
        }

        public Criteria andThinkChargeRateIsNotNull() {
            addCriterion("think_charge_rate is not null");
            return (Criteria) this;
        }

        public Criteria andThinkChargeRateEqualTo(BigDecimal value) {
            addCriterion("think_charge_rate =", value, "thinkChargeRate");
            return (Criteria) this;
        }

        public Criteria andThinkChargeRateNotEqualTo(BigDecimal value) {
            addCriterion("think_charge_rate <>", value, "thinkChargeRate");
            return (Criteria) this;
        }

        public Criteria andThinkChargeRateGreaterThan(BigDecimal value) {
            addCriterion("think_charge_rate >", value, "thinkChargeRate");
            return (Criteria) this;
        }

        public Criteria andThinkChargeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("think_charge_rate >=", value, "thinkChargeRate");
            return (Criteria) this;
        }

        public Criteria andThinkChargeRateLessThan(BigDecimal value) {
            addCriterion("think_charge_rate <", value, "thinkChargeRate");
            return (Criteria) this;
        }

        public Criteria andThinkChargeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("think_charge_rate <=", value, "thinkChargeRate");
            return (Criteria) this;
        }

        public Criteria andThinkChargeRateIn(List<BigDecimal> values) {
            addCriterion("think_charge_rate in", values, "thinkChargeRate");
            return (Criteria) this;
        }

        public Criteria andThinkChargeRateNotIn(List<BigDecimal> values) {
            addCriterion("think_charge_rate not in", values, "thinkChargeRate");
            return (Criteria) this;
        }

        public Criteria andThinkChargeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("think_charge_rate between", value1, value2, "thinkChargeRate");
            return (Criteria) this;
        }

        public Criteria andThinkChargeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("think_charge_rate not between", value1, value2, "thinkChargeRate");
            return (Criteria) this;
        }

        public Criteria andThinkChargeIsNull() {
            addCriterion("think_charge is null");
            return (Criteria) this;
        }

        public Criteria andThinkChargeIsNotNull() {
            addCriterion("think_charge is not null");
            return (Criteria) this;
        }

        public Criteria andThinkChargeEqualTo(BigDecimal value) {
            addCriterion("think_charge =", value, "thinkCharge");
            return (Criteria) this;
        }

        public Criteria andThinkChargeNotEqualTo(BigDecimal value) {
            addCriterion("think_charge <>", value, "thinkCharge");
            return (Criteria) this;
        }

        public Criteria andThinkChargeGreaterThan(BigDecimal value) {
            addCriterion("think_charge >", value, "thinkCharge");
            return (Criteria) this;
        }

        public Criteria andThinkChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("think_charge >=", value, "thinkCharge");
            return (Criteria) this;
        }

        public Criteria andThinkChargeLessThan(BigDecimal value) {
            addCriterion("think_charge <", value, "thinkCharge");
            return (Criteria) this;
        }

        public Criteria andThinkChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("think_charge <=", value, "thinkCharge");
            return (Criteria) this;
        }

        public Criteria andThinkChargeIn(List<BigDecimal> values) {
            addCriterion("think_charge in", values, "thinkCharge");
            return (Criteria) this;
        }

        public Criteria andThinkChargeNotIn(List<BigDecimal> values) {
            addCriterion("think_charge not in", values, "thinkCharge");
            return (Criteria) this;
        }

        public Criteria andThinkChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("think_charge between", value1, value2, "thinkCharge");
            return (Criteria) this;
        }

        public Criteria andThinkChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("think_charge not between", value1, value2, "thinkCharge");
            return (Criteria) this;
        }

        public Criteria andTixianThridIsNull() {
            addCriterion("tixian_thrid is null");
            return (Criteria) this;
        }

        public Criteria andTixianThridIsNotNull() {
            addCriterion("tixian_thrid is not null");
            return (Criteria) this;
        }

        public Criteria andTixianThridEqualTo(String value) {
            addCriterion("tixian_thrid =", value, "tixianThrid");
            return (Criteria) this;
        }

        public Criteria andTixianThridNotEqualTo(String value) {
            addCriterion("tixian_thrid <>", value, "tixianThrid");
            return (Criteria) this;
        }

        public Criteria andTixianThridGreaterThan(String value) {
            addCriterion("tixian_thrid >", value, "tixianThrid");
            return (Criteria) this;
        }

        public Criteria andTixianThridGreaterThanOrEqualTo(String value) {
            addCriterion("tixian_thrid >=", value, "tixianThrid");
            return (Criteria) this;
        }

        public Criteria andTixianThridLessThan(String value) {
            addCriterion("tixian_thrid <", value, "tixianThrid");
            return (Criteria) this;
        }

        public Criteria andTixianThridLessThanOrEqualTo(String value) {
            addCriterion("tixian_thrid <=", value, "tixianThrid");
            return (Criteria) this;
        }

        public Criteria andTixianThridLike(String value) {
            addCriterion("tixian_thrid like", value, "tixianThrid");
            return (Criteria) this;
        }

        public Criteria andTixianThridNotLike(String value) {
            addCriterion("tixian_thrid not like", value, "tixianThrid");
            return (Criteria) this;
        }

        public Criteria andTixianThridIn(List<String> values) {
            addCriterion("tixian_thrid in", values, "tixianThrid");
            return (Criteria) this;
        }

        public Criteria andTixianThridNotIn(List<String> values) {
            addCriterion("tixian_thrid not in", values, "tixianThrid");
            return (Criteria) this;
        }

        public Criteria andTixianThridBetween(String value1, String value2) {
            addCriterion("tixian_thrid between", value1, value2, "tixianThrid");
            return (Criteria) this;
        }

        public Criteria andTixianThridNotBetween(String value1, String value2) {
            addCriterion("tixian_thrid not between", value1, value2, "tixianThrid");
            return (Criteria) this;
        }

        public Criteria andTixianCommunityIsNull() {
            addCriterion("tixian_community is null");
            return (Criteria) this;
        }

        public Criteria andTixianCommunityIsNotNull() {
            addCriterion("tixian_community is not null");
            return (Criteria) this;
        }

        public Criteria andTixianCommunityEqualTo(String value) {
            addCriterion("tixian_community =", value, "tixianCommunity");
            return (Criteria) this;
        }

        public Criteria andTixianCommunityNotEqualTo(String value) {
            addCriterion("tixian_community <>", value, "tixianCommunity");
            return (Criteria) this;
        }

        public Criteria andTixianCommunityGreaterThan(String value) {
            addCriterion("tixian_community >", value, "tixianCommunity");
            return (Criteria) this;
        }

        public Criteria andTixianCommunityGreaterThanOrEqualTo(String value) {
            addCriterion("tixian_community >=", value, "tixianCommunity");
            return (Criteria) this;
        }

        public Criteria andTixianCommunityLessThan(String value) {
            addCriterion("tixian_community <", value, "tixianCommunity");
            return (Criteria) this;
        }

        public Criteria andTixianCommunityLessThanOrEqualTo(String value) {
            addCriterion("tixian_community <=", value, "tixianCommunity");
            return (Criteria) this;
        }

        public Criteria andTixianCommunityLike(String value) {
            addCriterion("tixian_community like", value, "tixianCommunity");
            return (Criteria) this;
        }

        public Criteria andTixianCommunityNotLike(String value) {
            addCriterion("tixian_community not like", value, "tixianCommunity");
            return (Criteria) this;
        }

        public Criteria andTixianCommunityIn(List<String> values) {
            addCriterion("tixian_community in", values, "tixianCommunity");
            return (Criteria) this;
        }

        public Criteria andTixianCommunityNotIn(List<String> values) {
            addCriterion("tixian_community not in", values, "tixianCommunity");
            return (Criteria) this;
        }

        public Criteria andTixianCommunityBetween(String value1, String value2) {
            addCriterion("tixian_community between", value1, value2, "tixianCommunity");
            return (Criteria) this;
        }

        public Criteria andTixianCommunityNotBetween(String value1, String value2) {
            addCriterion("tixian_community not between", value1, value2, "tixianCommunity");
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

        public Criteria andRefundReasonIsNull() {
            addCriterion("refund_reason is null");
            return (Criteria) this;
        }

        public Criteria andRefundReasonIsNotNull() {
            addCriterion("refund_reason is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReasonEqualTo(String value) {
            addCriterion("refund_reason =", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonNotEqualTo(String value) {
            addCriterion("refund_reason <>", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonGreaterThan(String value) {
            addCriterion("refund_reason >", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonGreaterThanOrEqualTo(String value) {
            addCriterion("refund_reason >=", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonLessThan(String value) {
            addCriterion("refund_reason <", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonLessThanOrEqualTo(String value) {
            addCriterion("refund_reason <=", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonLike(String value) {
            addCriterion("refund_reason like", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonNotLike(String value) {
            addCriterion("refund_reason not like", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonIn(List<String> values) {
            addCriterion("refund_reason in", values, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonNotIn(List<String> values) {
            addCriterion("refund_reason not in", values, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonBetween(String value1, String value2) {
            addCriterion("refund_reason between", value1, value2, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonNotBetween(String value1, String value2) {
            addCriterion("refund_reason not between", value1, value2, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundIdIsNull() {
            addCriterion("refund_id is null");
            return (Criteria) this;
        }

        public Criteria andRefundIdIsNotNull() {
            addCriterion("refund_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefundIdEqualTo(String value) {
            addCriterion("refund_id =", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotEqualTo(String value) {
            addCriterion("refund_id <>", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdGreaterThan(String value) {
            addCriterion("refund_id >", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdGreaterThanOrEqualTo(String value) {
            addCriterion("refund_id >=", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLessThan(String value) {
            addCriterion("refund_id <", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLessThanOrEqualTo(String value) {
            addCriterion("refund_id <=", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLike(String value) {
            addCriterion("refund_id like", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotLike(String value) {
            addCriterion("refund_id not like", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdIn(List<String> values) {
            addCriterion("refund_id in", values, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotIn(List<String> values) {
            addCriterion("refund_id not in", values, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdBetween(String value1, String value2) {
            addCriterion("refund_id between", value1, value2, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotBetween(String value1, String value2) {
            addCriterion("refund_id not between", value1, value2, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkIsNull() {
            addCriterion("refund_remark is null");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkIsNotNull() {
            addCriterion("refund_remark is not null");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkEqualTo(String value) {
            addCriterion("refund_remark =", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkNotEqualTo(String value) {
            addCriterion("refund_remark <>", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkGreaterThan(String value) {
            addCriterion("refund_remark >", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("refund_remark >=", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkLessThan(String value) {
            addCriterion("refund_remark <", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkLessThanOrEqualTo(String value) {
            addCriterion("refund_remark <=", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkLike(String value) {
            addCriterion("refund_remark like", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkNotLike(String value) {
            addCriterion("refund_remark not like", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkIn(List<String> values) {
            addCriterion("refund_remark in", values, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkNotIn(List<String> values) {
            addCriterion("refund_remark not in", values, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkBetween(String value1, String value2) {
            addCriterion("refund_remark between", value1, value2, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkNotBetween(String value1, String value2) {
            addCriterion("refund_remark not between", value1, value2, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeIsNull() {
            addCriterion("refund_create_time is null");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeIsNotNull() {
            addCriterion("refund_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeEqualTo(Date value) {
            addCriterion("refund_create_time =", value, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeNotEqualTo(Date value) {
            addCriterion("refund_create_time <>", value, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeGreaterThan(Date value) {
            addCriterion("refund_create_time >", value, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("refund_create_time >=", value, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeLessThan(Date value) {
            addCriterion("refund_create_time <", value, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("refund_create_time <=", value, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeIn(List<Date> values) {
            addCriterion("refund_create_time in", values, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeNotIn(List<Date> values) {
            addCriterion("refund_create_time not in", values, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeBetween(Date value1, Date value2) {
            addCriterion("refund_create_time between", value1, value2, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("refund_create_time not between", value1, value2, "refundCreateTime");
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

        public Criteria andRefundBillIdIsNull() {
            addCriterion("refund_bill_id is null");
            return (Criteria) this;
        }

        public Criteria andRefundBillIdIsNotNull() {
            addCriterion("refund_bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefundBillIdEqualTo(String value) {
            addCriterion("refund_bill_id =", value, "refundBillId");
            return (Criteria) this;
        }

        public Criteria andRefundBillIdNotEqualTo(String value) {
            addCriterion("refund_bill_id <>", value, "refundBillId");
            return (Criteria) this;
        }

        public Criteria andRefundBillIdGreaterThan(String value) {
            addCriterion("refund_bill_id >", value, "refundBillId");
            return (Criteria) this;
        }

        public Criteria andRefundBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("refund_bill_id >=", value, "refundBillId");
            return (Criteria) this;
        }

        public Criteria andRefundBillIdLessThan(String value) {
            addCriterion("refund_bill_id <", value, "refundBillId");
            return (Criteria) this;
        }

        public Criteria andRefundBillIdLessThanOrEqualTo(String value) {
            addCriterion("refund_bill_id <=", value, "refundBillId");
            return (Criteria) this;
        }

        public Criteria andRefundBillIdLike(String value) {
            addCriterion("refund_bill_id like", value, "refundBillId");
            return (Criteria) this;
        }

        public Criteria andRefundBillIdNotLike(String value) {
            addCriterion("refund_bill_id not like", value, "refundBillId");
            return (Criteria) this;
        }

        public Criteria andRefundBillIdIn(List<String> values) {
            addCriterion("refund_bill_id in", values, "refundBillId");
            return (Criteria) this;
        }

        public Criteria andRefundBillIdNotIn(List<String> values) {
            addCriterion("refund_bill_id not in", values, "refundBillId");
            return (Criteria) this;
        }

        public Criteria andRefundBillIdBetween(String value1, String value2) {
            addCriterion("refund_bill_id between", value1, value2, "refundBillId");
            return (Criteria) this;
        }

        public Criteria andRefundBillIdNotBetween(String value1, String value2) {
            addCriterion("refund_bill_id not between", value1, value2, "refundBillId");
            return (Criteria) this;
        }

        public Criteria andRefundSubBillIdIsNull() {
            addCriterion("refund_sub_bill_id is null");
            return (Criteria) this;
        }

        public Criteria andRefundSubBillIdIsNotNull() {
            addCriterion("refund_sub_bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefundSubBillIdEqualTo(String value) {
            addCriterion("refund_sub_bill_id =", value, "refundSubBillId");
            return (Criteria) this;
        }

        public Criteria andRefundSubBillIdNotEqualTo(String value) {
            addCriterion("refund_sub_bill_id <>", value, "refundSubBillId");
            return (Criteria) this;
        }

        public Criteria andRefundSubBillIdGreaterThan(String value) {
            addCriterion("refund_sub_bill_id >", value, "refundSubBillId");
            return (Criteria) this;
        }

        public Criteria andRefundSubBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("refund_sub_bill_id >=", value, "refundSubBillId");
            return (Criteria) this;
        }

        public Criteria andRefundSubBillIdLessThan(String value) {
            addCriterion("refund_sub_bill_id <", value, "refundSubBillId");
            return (Criteria) this;
        }

        public Criteria andRefundSubBillIdLessThanOrEqualTo(String value) {
            addCriterion("refund_sub_bill_id <=", value, "refundSubBillId");
            return (Criteria) this;
        }

        public Criteria andRefundSubBillIdLike(String value) {
            addCriterion("refund_sub_bill_id like", value, "refundSubBillId");
            return (Criteria) this;
        }

        public Criteria andRefundSubBillIdNotLike(String value) {
            addCriterion("refund_sub_bill_id not like", value, "refundSubBillId");
            return (Criteria) this;
        }

        public Criteria andRefundSubBillIdIn(List<String> values) {
            addCriterion("refund_sub_bill_id in", values, "refundSubBillId");
            return (Criteria) this;
        }

        public Criteria andRefundSubBillIdNotIn(List<String> values) {
            addCriterion("refund_sub_bill_id not in", values, "refundSubBillId");
            return (Criteria) this;
        }

        public Criteria andRefundSubBillIdBetween(String value1, String value2) {
            addCriterion("refund_sub_bill_id between", value1, value2, "refundSubBillId");
            return (Criteria) this;
        }

        public Criteria andRefundSubBillIdNotBetween(String value1, String value2) {
            addCriterion("refund_sub_bill_id not between", value1, value2, "refundSubBillId");
            return (Criteria) this;
        }

        public Criteria andRefundAccountIdIsNull() {
            addCriterion("refund_account_id is null");
            return (Criteria) this;
        }

        public Criteria andRefundAccountIdIsNotNull() {
            addCriterion("refund_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefundAccountIdEqualTo(String value) {
            addCriterion("refund_account_id =", value, "refundAccountId");
            return (Criteria) this;
        }

        public Criteria andRefundAccountIdNotEqualTo(String value) {
            addCriterion("refund_account_id <>", value, "refundAccountId");
            return (Criteria) this;
        }

        public Criteria andRefundAccountIdGreaterThan(String value) {
            addCriterion("refund_account_id >", value, "refundAccountId");
            return (Criteria) this;
        }

        public Criteria andRefundAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("refund_account_id >=", value, "refundAccountId");
            return (Criteria) this;
        }

        public Criteria andRefundAccountIdLessThan(String value) {
            addCriterion("refund_account_id <", value, "refundAccountId");
            return (Criteria) this;
        }

        public Criteria andRefundAccountIdLessThanOrEqualTo(String value) {
            addCriterion("refund_account_id <=", value, "refundAccountId");
            return (Criteria) this;
        }

        public Criteria andRefundAccountIdLike(String value) {
            addCriterion("refund_account_id like", value, "refundAccountId");
            return (Criteria) this;
        }

        public Criteria andRefundAccountIdNotLike(String value) {
            addCriterion("refund_account_id not like", value, "refundAccountId");
            return (Criteria) this;
        }

        public Criteria andRefundAccountIdIn(List<String> values) {
            addCriterion("refund_account_id in", values, "refundAccountId");
            return (Criteria) this;
        }

        public Criteria andRefundAccountIdNotIn(List<String> values) {
            addCriterion("refund_account_id not in", values, "refundAccountId");
            return (Criteria) this;
        }

        public Criteria andRefundAccountIdBetween(String value1, String value2) {
            addCriterion("refund_account_id between", value1, value2, "refundAccountId");
            return (Criteria) this;
        }

        public Criteria andRefundAccountIdNotBetween(String value1, String value2) {
            addCriterion("refund_account_id not between", value1, value2, "refundAccountId");
            return (Criteria) this;
        }

        public Criteria andSameWayIsNull() {
            addCriterion("same_way is null");
            return (Criteria) this;
        }

        public Criteria andSameWayIsNotNull() {
            addCriterion("same_way is not null");
            return (Criteria) this;
        }

        public Criteria andSameWayEqualTo(Integer value) {
            addCriterion("same_way =", value, "sameWay");
            return (Criteria) this;
        }

        public Criteria andSameWayNotEqualTo(Integer value) {
            addCriterion("same_way <>", value, "sameWay");
            return (Criteria) this;
        }

        public Criteria andSameWayGreaterThan(Integer value) {
            addCriterion("same_way >", value, "sameWay");
            return (Criteria) this;
        }

        public Criteria andSameWayGreaterThanOrEqualTo(Integer value) {
            addCriterion("same_way >=", value, "sameWay");
            return (Criteria) this;
        }

        public Criteria andSameWayLessThan(Integer value) {
            addCriterion("same_way <", value, "sameWay");
            return (Criteria) this;
        }

        public Criteria andSameWayLessThanOrEqualTo(Integer value) {
            addCriterion("same_way <=", value, "sameWay");
            return (Criteria) this;
        }

        public Criteria andSameWayIn(List<Integer> values) {
            addCriterion("same_way in", values, "sameWay");
            return (Criteria) this;
        }

        public Criteria andSameWayNotIn(List<Integer> values) {
            addCriterion("same_way not in", values, "sameWay");
            return (Criteria) this;
        }

        public Criteria andSameWayBetween(Integer value1, Integer value2) {
            addCriterion("same_way between", value1, value2, "sameWay");
            return (Criteria) this;
        }

        public Criteria andSameWayNotBetween(Integer value1, Integer value2) {
            addCriterion("same_way not between", value1, value2, "sameWay");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusIsNull() {
            addCriterion("withdraw_status is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusIsNotNull() {
            addCriterion("withdraw_status is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusEqualTo(Integer value) {
            addCriterion("withdraw_status =", value, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusNotEqualTo(Integer value) {
            addCriterion("withdraw_status <>", value, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusGreaterThan(Integer value) {
            addCriterion("withdraw_status >", value, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("withdraw_status >=", value, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusLessThan(Integer value) {
            addCriterion("withdraw_status <", value, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusLessThanOrEqualTo(Integer value) {
            addCriterion("withdraw_status <=", value, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusIn(List<Integer> values) {
            addCriterion("withdraw_status in", values, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusNotIn(List<Integer> values) {
            addCriterion("withdraw_status not in", values, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusBetween(Integer value1, Integer value2) {
            addCriterion("withdraw_status between", value1, value2, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("withdraw_status not between", value1, value2, "withdrawStatus");
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

        public Criteria andServiceChargeStatusIsNull() {
            addCriterion("service_charge_status is null");
            return (Criteria) this;
        }

        public Criteria andServiceChargeStatusIsNotNull() {
            addCriterion("service_charge_status is not null");
            return (Criteria) this;
        }

        public Criteria andServiceChargeStatusEqualTo(Integer value) {
            addCriterion("service_charge_status =", value, "serviceChargeStatus");
            return (Criteria) this;
        }

        public Criteria andServiceChargeStatusNotEqualTo(Integer value) {
            addCriterion("service_charge_status <>", value, "serviceChargeStatus");
            return (Criteria) this;
        }

        public Criteria andServiceChargeStatusGreaterThan(Integer value) {
            addCriterion("service_charge_status >", value, "serviceChargeStatus");
            return (Criteria) this;
        }

        public Criteria andServiceChargeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_charge_status >=", value, "serviceChargeStatus");
            return (Criteria) this;
        }

        public Criteria andServiceChargeStatusLessThan(Integer value) {
            addCriterion("service_charge_status <", value, "serviceChargeStatus");
            return (Criteria) this;
        }

        public Criteria andServiceChargeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("service_charge_status <=", value, "serviceChargeStatus");
            return (Criteria) this;
        }

        public Criteria andServiceChargeStatusIn(List<Integer> values) {
            addCriterion("service_charge_status in", values, "serviceChargeStatus");
            return (Criteria) this;
        }

        public Criteria andServiceChargeStatusNotIn(List<Integer> values) {
            addCriterion("service_charge_status not in", values, "serviceChargeStatus");
            return (Criteria) this;
        }

        public Criteria andServiceChargeStatusBetween(Integer value1, Integer value2) {
            addCriterion("service_charge_status between", value1, value2, "serviceChargeStatus");
            return (Criteria) this;
        }

        public Criteria andServiceChargeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("service_charge_status not between", value1, value2, "serviceChargeStatus");
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

        public Criteria andServiceChargeBillIdIsNull() {
            addCriterion("service_charge_bill_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceChargeBillIdIsNotNull() {
            addCriterion("service_charge_bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceChargeBillIdEqualTo(String value) {
            addCriterion("service_charge_bill_id =", value, "serviceChargeBillId");
            return (Criteria) this;
        }

        public Criteria andServiceChargeBillIdNotEqualTo(String value) {
            addCriterion("service_charge_bill_id <>", value, "serviceChargeBillId");
            return (Criteria) this;
        }

        public Criteria andServiceChargeBillIdGreaterThan(String value) {
            addCriterion("service_charge_bill_id >", value, "serviceChargeBillId");
            return (Criteria) this;
        }

        public Criteria andServiceChargeBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("service_charge_bill_id >=", value, "serviceChargeBillId");
            return (Criteria) this;
        }

        public Criteria andServiceChargeBillIdLessThan(String value) {
            addCriterion("service_charge_bill_id <", value, "serviceChargeBillId");
            return (Criteria) this;
        }

        public Criteria andServiceChargeBillIdLessThanOrEqualTo(String value) {
            addCriterion("service_charge_bill_id <=", value, "serviceChargeBillId");
            return (Criteria) this;
        }

        public Criteria andServiceChargeBillIdLike(String value) {
            addCriterion("service_charge_bill_id like", value, "serviceChargeBillId");
            return (Criteria) this;
        }

        public Criteria andServiceChargeBillIdNotLike(String value) {
            addCriterion("service_charge_bill_id not like", value, "serviceChargeBillId");
            return (Criteria) this;
        }

        public Criteria andServiceChargeBillIdIn(List<String> values) {
            addCriterion("service_charge_bill_id in", values, "serviceChargeBillId");
            return (Criteria) this;
        }

        public Criteria andServiceChargeBillIdNotIn(List<String> values) {
            addCriterion("service_charge_bill_id not in", values, "serviceChargeBillId");
            return (Criteria) this;
        }

        public Criteria andServiceChargeBillIdBetween(String value1, String value2) {
            addCriterion("service_charge_bill_id between", value1, value2, "serviceChargeBillId");
            return (Criteria) this;
        }

        public Criteria andServiceChargeBillIdNotBetween(String value1, String value2) {
            addCriterion("service_charge_bill_id not between", value1, value2, "serviceChargeBillId");
            return (Criteria) this;
        }

        public Criteria andServiceAccountIsNull() {
            addCriterion("service_account is null");
            return (Criteria) this;
        }

        public Criteria andServiceAccountIsNotNull() {
            addCriterion("service_account is not null");
            return (Criteria) this;
        }

        public Criteria andServiceAccountEqualTo(String value) {
            addCriterion("service_account =", value, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountNotEqualTo(String value) {
            addCriterion("service_account <>", value, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountGreaterThan(String value) {
            addCriterion("service_account >", value, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountGreaterThanOrEqualTo(String value) {
            addCriterion("service_account >=", value, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountLessThan(String value) {
            addCriterion("service_account <", value, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountLessThanOrEqualTo(String value) {
            addCriterion("service_account <=", value, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountLike(String value) {
            addCriterion("service_account like", value, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountNotLike(String value) {
            addCriterion("service_account not like", value, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountIn(List<String> values) {
            addCriterion("service_account in", values, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountNotIn(List<String> values) {
            addCriterion("service_account not in", values, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountBetween(String value1, String value2) {
            addCriterion("service_account between", value1, value2, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountNotBetween(String value1, String value2) {
            addCriterion("service_account not between", value1, value2, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountMchidIsNull() {
            addCriterion("service_account_mchid is null");
            return (Criteria) this;
        }

        public Criteria andServiceAccountMchidIsNotNull() {
            addCriterion("service_account_mchid is not null");
            return (Criteria) this;
        }

        public Criteria andServiceAccountMchidEqualTo(String value) {
            addCriterion("service_account_mchid =", value, "serviceAccountMchid");
            return (Criteria) this;
        }

        public Criteria andServiceAccountMchidNotEqualTo(String value) {
            addCriterion("service_account_mchid <>", value, "serviceAccountMchid");
            return (Criteria) this;
        }

        public Criteria andServiceAccountMchidGreaterThan(String value) {
            addCriterion("service_account_mchid >", value, "serviceAccountMchid");
            return (Criteria) this;
        }

        public Criteria andServiceAccountMchidGreaterThanOrEqualTo(String value) {
            addCriterion("service_account_mchid >=", value, "serviceAccountMchid");
            return (Criteria) this;
        }

        public Criteria andServiceAccountMchidLessThan(String value) {
            addCriterion("service_account_mchid <", value, "serviceAccountMchid");
            return (Criteria) this;
        }

        public Criteria andServiceAccountMchidLessThanOrEqualTo(String value) {
            addCriterion("service_account_mchid <=", value, "serviceAccountMchid");
            return (Criteria) this;
        }

        public Criteria andServiceAccountMchidLike(String value) {
            addCriterion("service_account_mchid like", value, "serviceAccountMchid");
            return (Criteria) this;
        }

        public Criteria andServiceAccountMchidNotLike(String value) {
            addCriterion("service_account_mchid not like", value, "serviceAccountMchid");
            return (Criteria) this;
        }

        public Criteria andServiceAccountMchidIn(List<String> values) {
            addCriterion("service_account_mchid in", values, "serviceAccountMchid");
            return (Criteria) this;
        }

        public Criteria andServiceAccountMchidNotIn(List<String> values) {
            addCriterion("service_account_mchid not in", values, "serviceAccountMchid");
            return (Criteria) this;
        }

        public Criteria andServiceAccountMchidBetween(String value1, String value2) {
            addCriterion("service_account_mchid between", value1, value2, "serviceAccountMchid");
            return (Criteria) this;
        }

        public Criteria andServiceAccountMchidNotBetween(String value1, String value2) {
            addCriterion("service_account_mchid not between", value1, value2, "serviceAccountMchid");
            return (Criteria) this;
        }

        public Criteria andMerchantBillIdIsNull() {
            addCriterion("merchant_bill_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchantBillIdIsNotNull() {
            addCriterion("merchant_bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantBillIdEqualTo(String value) {
            addCriterion("merchant_bill_id =", value, "merchantBillId");
            return (Criteria) this;
        }

        public Criteria andMerchantBillIdNotEqualTo(String value) {
            addCriterion("merchant_bill_id <>", value, "merchantBillId");
            return (Criteria) this;
        }

        public Criteria andMerchantBillIdGreaterThan(String value) {
            addCriterion("merchant_bill_id >", value, "merchantBillId");
            return (Criteria) this;
        }

        public Criteria andMerchantBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_bill_id >=", value, "merchantBillId");
            return (Criteria) this;
        }

        public Criteria andMerchantBillIdLessThan(String value) {
            addCriterion("merchant_bill_id <", value, "merchantBillId");
            return (Criteria) this;
        }

        public Criteria andMerchantBillIdLessThanOrEqualTo(String value) {
            addCriterion("merchant_bill_id <=", value, "merchantBillId");
            return (Criteria) this;
        }

        public Criteria andMerchantBillIdLike(String value) {
            addCriterion("merchant_bill_id like", value, "merchantBillId");
            return (Criteria) this;
        }

        public Criteria andMerchantBillIdNotLike(String value) {
            addCriterion("merchant_bill_id not like", value, "merchantBillId");
            return (Criteria) this;
        }

        public Criteria andMerchantBillIdIn(List<String> values) {
            addCriterion("merchant_bill_id in", values, "merchantBillId");
            return (Criteria) this;
        }

        public Criteria andMerchantBillIdNotIn(List<String> values) {
            addCriterion("merchant_bill_id not in", values, "merchantBillId");
            return (Criteria) this;
        }

        public Criteria andMerchantBillIdBetween(String value1, String value2) {
            addCriterion("merchant_bill_id between", value1, value2, "merchantBillId");
            return (Criteria) this;
        }

        public Criteria andMerchantBillIdNotBetween(String value1, String value2) {
            addCriterion("merchant_bill_id not between", value1, value2, "merchantBillId");
            return (Criteria) this;
        }

        public Criteria andThinkBillIdIsNull() {
            addCriterion("think_bill_id is null");
            return (Criteria) this;
        }

        public Criteria andThinkBillIdIsNotNull() {
            addCriterion("think_bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andThinkBillIdEqualTo(String value) {
            addCriterion("think_bill_id =", value, "thinkBillId");
            return (Criteria) this;
        }

        public Criteria andThinkBillIdNotEqualTo(String value) {
            addCriterion("think_bill_id <>", value, "thinkBillId");
            return (Criteria) this;
        }

        public Criteria andThinkBillIdGreaterThan(String value) {
            addCriterion("think_bill_id >", value, "thinkBillId");
            return (Criteria) this;
        }

        public Criteria andThinkBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("think_bill_id >=", value, "thinkBillId");
            return (Criteria) this;
        }

        public Criteria andThinkBillIdLessThan(String value) {
            addCriterion("think_bill_id <", value, "thinkBillId");
            return (Criteria) this;
        }

        public Criteria andThinkBillIdLessThanOrEqualTo(String value) {
            addCriterion("think_bill_id <=", value, "thinkBillId");
            return (Criteria) this;
        }

        public Criteria andThinkBillIdLike(String value) {
            addCriterion("think_bill_id like", value, "thinkBillId");
            return (Criteria) this;
        }

        public Criteria andThinkBillIdNotLike(String value) {
            addCriterion("think_bill_id not like", value, "thinkBillId");
            return (Criteria) this;
        }

        public Criteria andThinkBillIdIn(List<String> values) {
            addCriterion("think_bill_id in", values, "thinkBillId");
            return (Criteria) this;
        }

        public Criteria andThinkBillIdNotIn(List<String> values) {
            addCriterion("think_bill_id not in", values, "thinkBillId");
            return (Criteria) this;
        }

        public Criteria andThinkBillIdBetween(String value1, String value2) {
            addCriterion("think_bill_id between", value1, value2, "thinkBillId");
            return (Criteria) this;
        }

        public Criteria andThinkBillIdNotBetween(String value1, String value2) {
            addCriterion("think_bill_id not between", value1, value2, "thinkBillId");
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

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOutStatusIsNull() {
            addCriterion("out_status is null");
            return (Criteria) this;
        }

        public Criteria andOutStatusIsNotNull() {
            addCriterion("out_status is not null");
            return (Criteria) this;
        }

        public Criteria andOutStatusEqualTo(Integer value) {
            addCriterion("out_status =", value, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusNotEqualTo(Integer value) {
            addCriterion("out_status <>", value, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusGreaterThan(Integer value) {
            addCriterion("out_status >", value, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_status >=", value, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusLessThan(Integer value) {
            addCriterion("out_status <", value, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusLessThanOrEqualTo(Integer value) {
            addCriterion("out_status <=", value, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusIn(List<Integer> values) {
            addCriterion("out_status in", values, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusNotIn(List<Integer> values) {
            addCriterion("out_status not in", values, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusBetween(Integer value1, Integer value2) {
            addCriterion("out_status between", value1, value2, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("out_status not between", value1, value2, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusContentIsNull() {
            addCriterion("out_status_content is null");
            return (Criteria) this;
        }

        public Criteria andOutStatusContentIsNotNull() {
            addCriterion("out_status_content is not null");
            return (Criteria) this;
        }

        public Criteria andOutStatusContentEqualTo(String value) {
            addCriterion("out_status_content =", value, "outStatusContent");
            return (Criteria) this;
        }

        public Criteria andOutStatusContentNotEqualTo(String value) {
            addCriterion("out_status_content <>", value, "outStatusContent");
            return (Criteria) this;
        }

        public Criteria andOutStatusContentGreaterThan(String value) {
            addCriterion("out_status_content >", value, "outStatusContent");
            return (Criteria) this;
        }

        public Criteria andOutStatusContentGreaterThanOrEqualTo(String value) {
            addCriterion("out_status_content >=", value, "outStatusContent");
            return (Criteria) this;
        }

        public Criteria andOutStatusContentLessThan(String value) {
            addCriterion("out_status_content <", value, "outStatusContent");
            return (Criteria) this;
        }

        public Criteria andOutStatusContentLessThanOrEqualTo(String value) {
            addCriterion("out_status_content <=", value, "outStatusContent");
            return (Criteria) this;
        }

        public Criteria andOutStatusContentLike(String value) {
            addCriterion("out_status_content like", value, "outStatusContent");
            return (Criteria) this;
        }

        public Criteria andOutStatusContentNotLike(String value) {
            addCriterion("out_status_content not like", value, "outStatusContent");
            return (Criteria) this;
        }

        public Criteria andOutStatusContentIn(List<String> values) {
            addCriterion("out_status_content in", values, "outStatusContent");
            return (Criteria) this;
        }

        public Criteria andOutStatusContentNotIn(List<String> values) {
            addCriterion("out_status_content not in", values, "outStatusContent");
            return (Criteria) this;
        }

        public Criteria andOutStatusContentBetween(String value1, String value2) {
            addCriterion("out_status_content between", value1, value2, "outStatusContent");
            return (Criteria) this;
        }

        public Criteria andOutStatusContentNotBetween(String value1, String value2) {
            addCriterion("out_status_content not between", value1, value2, "outStatusContent");
            return (Criteria) this;
        }

        public Criteria andSettleIdIsNull() {
            addCriterion("settle_id is null");
            return (Criteria) this;
        }

        public Criteria andSettleIdIsNotNull() {
            addCriterion("settle_id is not null");
            return (Criteria) this;
        }

        public Criteria andSettleIdEqualTo(String value) {
            addCriterion("settle_id =", value, "settleId");
            return (Criteria) this;
        }

        public Criteria andSettleIdNotEqualTo(String value) {
            addCriterion("settle_id <>", value, "settleId");
            return (Criteria) this;
        }

        public Criteria andSettleIdGreaterThan(String value) {
            addCriterion("settle_id >", value, "settleId");
            return (Criteria) this;
        }

        public Criteria andSettleIdGreaterThanOrEqualTo(String value) {
            addCriterion("settle_id >=", value, "settleId");
            return (Criteria) this;
        }

        public Criteria andSettleIdLessThan(String value) {
            addCriterion("settle_id <", value, "settleId");
            return (Criteria) this;
        }

        public Criteria andSettleIdLessThanOrEqualTo(String value) {
            addCriterion("settle_id <=", value, "settleId");
            return (Criteria) this;
        }

        public Criteria andSettleIdLike(String value) {
            addCriterion("settle_id like", value, "settleId");
            return (Criteria) this;
        }

        public Criteria andSettleIdNotLike(String value) {
            addCriterion("settle_id not like", value, "settleId");
            return (Criteria) this;
        }

        public Criteria andSettleIdIn(List<String> values) {
            addCriterion("settle_id in", values, "settleId");
            return (Criteria) this;
        }

        public Criteria andSettleIdNotIn(List<String> values) {
            addCriterion("settle_id not in", values, "settleId");
            return (Criteria) this;
        }

        public Criteria andSettleIdBetween(String value1, String value2) {
            addCriterion("settle_id between", value1, value2, "settleId");
            return (Criteria) this;
        }

        public Criteria andSettleIdNotBetween(String value1, String value2) {
            addCriterion("settle_id not between", value1, value2, "settleId");
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

        public Criteria andPfRefundTimeIsNull() {
            addCriterion("pf_refund_time is null");
            return (Criteria) this;
        }

        public Criteria andPfRefundTimeIsNotNull() {
            addCriterion("pf_refund_time is not null");
            return (Criteria) this;
        }

        public Criteria andPfRefundTimeEqualTo(Date value) {
            addCriterion("pf_refund_time =", value, "pfRefundTime");
            return (Criteria) this;
        }

        public Criteria andPfRefundTimeNotEqualTo(Date value) {
            addCriterion("pf_refund_time <>", value, "pfRefundTime");
            return (Criteria) this;
        }

        public Criteria andPfRefundTimeGreaterThan(Date value) {
            addCriterion("pf_refund_time >", value, "pfRefundTime");
            return (Criteria) this;
        }

        public Criteria andPfRefundTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pf_refund_time >=", value, "pfRefundTime");
            return (Criteria) this;
        }

        public Criteria andPfRefundTimeLessThan(Date value) {
            addCriterion("pf_refund_time <", value, "pfRefundTime");
            return (Criteria) this;
        }

        public Criteria andPfRefundTimeLessThanOrEqualTo(Date value) {
            addCriterion("pf_refund_time <=", value, "pfRefundTime");
            return (Criteria) this;
        }

        public Criteria andPfRefundTimeIn(List<Date> values) {
            addCriterion("pf_refund_time in", values, "pfRefundTime");
            return (Criteria) this;
        }

        public Criteria andPfRefundTimeNotIn(List<Date> values) {
            addCriterion("pf_refund_time not in", values, "pfRefundTime");
            return (Criteria) this;
        }

        public Criteria andPfRefundTimeBetween(Date value1, Date value2) {
            addCriterion("pf_refund_time between", value1, value2, "pfRefundTime");
            return (Criteria) this;
        }

        public Criteria andPfRefundTimeNotBetween(Date value1, Date value2) {
            addCriterion("pf_refund_time not between", value1, value2, "pfRefundTime");
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

        public Criteria andBodyIsNull() {
            addCriterion("body is null");
            return (Criteria) this;
        }

        public Criteria andBodyIsNotNull() {
            addCriterion("body is not null");
            return (Criteria) this;
        }

        public Criteria andBodyEqualTo(String value) {
            addCriterion("body =", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotEqualTo(String value) {
            addCriterion("body <>", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThan(String value) {
            addCriterion("body >", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThanOrEqualTo(String value) {
            addCriterion("body >=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThan(String value) {
            addCriterion("body <", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThanOrEqualTo(String value) {
            addCriterion("body <=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLike(String value) {
            addCriterion("body like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotLike(String value) {
            addCriterion("body not like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyIn(List<String> values) {
            addCriterion("body in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotIn(List<String> values) {
            addCriterion("body not in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyBetween(String value1, String value2) {
            addCriterion("body between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotBetween(String value1, String value2) {
            addCriterion("body not between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Long value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Long value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Long value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Long value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Long> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Long> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Long value1, Long value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andEmpGuidIsNull() {
            addCriterion("emp_guid is null");
            return (Criteria) this;
        }

        public Criteria andEmpGuidIsNotNull() {
            addCriterion("emp_guid is not null");
            return (Criteria) this;
        }

        public Criteria andEmpGuidEqualTo(String value) {
            addCriterion("emp_guid =", value, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidNotEqualTo(String value) {
            addCriterion("emp_guid <>", value, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidGreaterThan(String value) {
            addCriterion("emp_guid >", value, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidGreaterThanOrEqualTo(String value) {
            addCriterion("emp_guid >=", value, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidLessThan(String value) {
            addCriterion("emp_guid <", value, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidLessThanOrEqualTo(String value) {
            addCriterion("emp_guid <=", value, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidLike(String value) {
            addCriterion("emp_guid like", value, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidNotLike(String value) {
            addCriterion("emp_guid not like", value, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidIn(List<String> values) {
            addCriterion("emp_guid in", values, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidNotIn(List<String> values) {
            addCriterion("emp_guid not in", values, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidBetween(String value1, String value2) {
            addCriterion("emp_guid between", value1, value2, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidNotBetween(String value1, String value2) {
            addCriterion("emp_guid not between", value1, value2, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneIsNull() {
            addCriterion("emp_phone is null");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneIsNotNull() {
            addCriterion("emp_phone is not null");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneEqualTo(String value) {
            addCriterion("emp_phone =", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotEqualTo(String value) {
            addCriterion("emp_phone <>", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneGreaterThan(String value) {
            addCriterion("emp_phone >", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("emp_phone >=", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneLessThan(String value) {
            addCriterion("emp_phone <", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneLessThanOrEqualTo(String value) {
            addCriterion("emp_phone <=", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneLike(String value) {
            addCriterion("emp_phone like", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotLike(String value) {
            addCriterion("emp_phone not like", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneIn(List<String> values) {
            addCriterion("emp_phone in", values, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotIn(List<String> values) {
            addCriterion("emp_phone not in", values, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneBetween(String value1, String value2) {
            addCriterion("emp_phone between", value1, value2, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotBetween(String value1, String value2) {
            addCriterion("emp_phone not between", value1, value2, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpNameIsNull() {
            addCriterion("emp_name is null");
            return (Criteria) this;
        }

        public Criteria andEmpNameIsNotNull() {
            addCriterion("emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNameEqualTo(String value) {
            addCriterion("emp_name =", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotEqualTo(String value) {
            addCriterion("emp_name <>", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameGreaterThan(String value) {
            addCriterion("emp_name >", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("emp_name >=", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLessThan(String value) {
            addCriterion("emp_name <", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLessThanOrEqualTo(String value) {
            addCriterion("emp_name <=", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLike(String value) {
            addCriterion("emp_name like", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotLike(String value) {
            addCriterion("emp_name not like", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameIn(List<String> values) {
            addCriterion("emp_name in", values, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotIn(List<String> values) {
            addCriterion("emp_name not in", values, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameBetween(String value1, String value2) {
            addCriterion("emp_name between", value1, value2, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotBetween(String value1, String value2) {
            addCriterion("emp_name not between", value1, value2, "empName");
            return (Criteria) this;
        }

        public Criteria andTaskRelIdIsNull() {
            addCriterion("task_rel_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskRelIdIsNotNull() {
            addCriterion("task_rel_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskRelIdEqualTo(Long value) {
            addCriterion("task_rel_id =", value, "taskRelId");
            return (Criteria) this;
        }

        public Criteria andTaskRelIdNotEqualTo(Long value) {
            addCriterion("task_rel_id <>", value, "taskRelId");
            return (Criteria) this;
        }

        public Criteria andTaskRelIdGreaterThan(Long value) {
            addCriterion("task_rel_id >", value, "taskRelId");
            return (Criteria) this;
        }

        public Criteria andTaskRelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_rel_id >=", value, "taskRelId");
            return (Criteria) this;
        }

        public Criteria andTaskRelIdLessThan(Long value) {
            addCriterion("task_rel_id <", value, "taskRelId");
            return (Criteria) this;
        }

        public Criteria andTaskRelIdLessThanOrEqualTo(Long value) {
            addCriterion("task_rel_id <=", value, "taskRelId");
            return (Criteria) this;
        }

        public Criteria andTaskRelIdIn(List<Long> values) {
            addCriterion("task_rel_id in", values, "taskRelId");
            return (Criteria) this;
        }

        public Criteria andTaskRelIdNotIn(List<Long> values) {
            addCriterion("task_rel_id not in", values, "taskRelId");
            return (Criteria) this;
        }

        public Criteria andTaskRelIdBetween(Long value1, Long value2) {
            addCriterion("task_rel_id between", value1, value2, "taskRelId");
            return (Criteria) this;
        }

        public Criteria andTaskRelIdNotBetween(Long value1, Long value2) {
            addCriterion("task_rel_id not between", value1, value2, "taskRelId");
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