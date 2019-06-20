package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenStoreOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenStoreOrderExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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

        public Criteria andAddrInfoIdIsNull() {
            addCriterion("addr_info_id is null");
            return (Criteria) this;
        }

        public Criteria andAddrInfoIdIsNotNull() {
            addCriterion("addr_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddrInfoIdEqualTo(Integer value) {
            addCriterion("addr_info_id =", value, "addrInfoId");
            return (Criteria) this;
        }

        public Criteria andAddrInfoIdNotEqualTo(Integer value) {
            addCriterion("addr_info_id <>", value, "addrInfoId");
            return (Criteria) this;
        }

        public Criteria andAddrInfoIdGreaterThan(Integer value) {
            addCriterion("addr_info_id >", value, "addrInfoId");
            return (Criteria) this;
        }

        public Criteria andAddrInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("addr_info_id >=", value, "addrInfoId");
            return (Criteria) this;
        }

        public Criteria andAddrInfoIdLessThan(Integer value) {
            addCriterion("addr_info_id <", value, "addrInfoId");
            return (Criteria) this;
        }

        public Criteria andAddrInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("addr_info_id <=", value, "addrInfoId");
            return (Criteria) this;
        }

        public Criteria andAddrInfoIdIn(List<Integer> values) {
            addCriterion("addr_info_id in", values, "addrInfoId");
            return (Criteria) this;
        }

        public Criteria andAddrInfoIdNotIn(List<Integer> values) {
            addCriterion("addr_info_id not in", values, "addrInfoId");
            return (Criteria) this;
        }

        public Criteria andAddrInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("addr_info_id between", value1, value2, "addrInfoId");
            return (Criteria) this;
        }

        public Criteria andAddrInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("addr_info_id not between", value1, value2, "addrInfoId");
            return (Criteria) this;
        }

        public Criteria andAddrInfoIsNull() {
            addCriterion("addr_info is null");
            return (Criteria) this;
        }

        public Criteria andAddrInfoIsNotNull() {
            addCriterion("addr_info is not null");
            return (Criteria) this;
        }

        public Criteria andAddrInfoEqualTo(String value) {
            addCriterion("addr_info =", value, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoNotEqualTo(String value) {
            addCriterion("addr_info <>", value, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoGreaterThan(String value) {
            addCriterion("addr_info >", value, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoGreaterThanOrEqualTo(String value) {
            addCriterion("addr_info >=", value, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoLessThan(String value) {
            addCriterion("addr_info <", value, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoLessThanOrEqualTo(String value) {
            addCriterion("addr_info <=", value, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoLike(String value) {
            addCriterion("addr_info like", value, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoNotLike(String value) {
            addCriterion("addr_info not like", value, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoIn(List<String> values) {
            addCriterion("addr_info in", values, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoNotIn(List<String> values) {
            addCriterion("addr_info not in", values, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoBetween(String value1, String value2) {
            addCriterion("addr_info between", value1, value2, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrInfoNotBetween(String value1, String value2) {
            addCriterion("addr_info not between", value1, value2, "addrInfo");
            return (Criteria) this;
        }

        public Criteria andAddrDetailIsNull() {
            addCriterion("addr_detail is null");
            return (Criteria) this;
        }

        public Criteria andAddrDetailIsNotNull() {
            addCriterion("addr_detail is not null");
            return (Criteria) this;
        }

        public Criteria andAddrDetailEqualTo(String value) {
            addCriterion("addr_detail =", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailNotEqualTo(String value) {
            addCriterion("addr_detail <>", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailGreaterThan(String value) {
            addCriterion("addr_detail >", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailGreaterThanOrEqualTo(String value) {
            addCriterion("addr_detail >=", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailLessThan(String value) {
            addCriterion("addr_detail <", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailLessThanOrEqualTo(String value) {
            addCriterion("addr_detail <=", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailLike(String value) {
            addCriterion("addr_detail like", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailNotLike(String value) {
            addCriterion("addr_detail not like", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailIn(List<String> values) {
            addCriterion("addr_detail in", values, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailNotIn(List<String> values) {
            addCriterion("addr_detail not in", values, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailBetween(String value1, String value2) {
            addCriterion("addr_detail between", value1, value2, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailNotBetween(String value1, String value2) {
            addCriterion("addr_detail not between", value1, value2, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIsNull() {
            addCriterion("order_code is null");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIsNotNull() {
            addCriterion("order_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCodeEqualTo(String value) {
            addCriterion("order_code =", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotEqualTo(String value) {
            addCriterion("order_code <>", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeGreaterThan(String value) {
            addCriterion("order_code >", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("order_code >=", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLessThan(String value) {
            addCriterion("order_code <", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLessThanOrEqualTo(String value) {
            addCriterion("order_code <=", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLike(String value) {
            addCriterion("order_code like", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotLike(String value) {
            addCriterion("order_code not like", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIn(List<String> values) {
            addCriterion("order_code in", values, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotIn(List<String> values) {
            addCriterion("order_code not in", values, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeBetween(String value1, String value2) {
            addCriterion("order_code between", value1, value2, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotBetween(String value1, String value2) {
            addCriterion("order_code not between", value1, value2, "orderCode");
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

        public Criteria andExpressMoneyIsNull() {
            addCriterion("express_money is null");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyIsNotNull() {
            addCriterion("express_money is not null");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyEqualTo(BigDecimal value) {
            addCriterion("express_money =", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyNotEqualTo(BigDecimal value) {
            addCriterion("express_money <>", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyGreaterThan(BigDecimal value) {
            addCriterion("express_money >", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("express_money >=", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyLessThan(BigDecimal value) {
            addCriterion("express_money <", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("express_money <=", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyIn(List<BigDecimal> values) {
            addCriterion("express_money in", values, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyNotIn(List<BigDecimal> values) {
            addCriterion("express_money not in", values, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("express_money between", value1, value2, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("express_money not between", value1, value2, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalIsNull() {
            addCriterion("goods_total is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalIsNotNull() {
            addCriterion("goods_total is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalEqualTo(BigDecimal value) {
            addCriterion("goods_total =", value, "goodsTotal");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalNotEqualTo(BigDecimal value) {
            addCriterion("goods_total <>", value, "goodsTotal");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalGreaterThan(BigDecimal value) {
            addCriterion("goods_total >", value, "goodsTotal");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_total >=", value, "goodsTotal");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalLessThan(BigDecimal value) {
            addCriterion("goods_total <", value, "goodsTotal");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_total <=", value, "goodsTotal");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalIn(List<BigDecimal> values) {
            addCriterion("goods_total in", values, "goodsTotal");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalNotIn(List<BigDecimal> values) {
            addCriterion("goods_total not in", values, "goodsTotal");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_total between", value1, value2, "goodsTotal");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_total not between", value1, value2, "goodsTotal");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNull() {
            addCriterion("original_price is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNotNull() {
            addCriterion("original_price is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceEqualTo(BigDecimal value) {
            addCriterion("original_price =", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotEqualTo(BigDecimal value) {
            addCriterion("original_price <>", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThan(BigDecimal value) {
            addCriterion("original_price >", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("original_price >=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThan(BigDecimal value) {
            addCriterion("original_price <", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("original_price <=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIn(List<BigDecimal> values) {
            addCriterion("original_price in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotIn(List<BigDecimal> values) {
            addCriterion("original_price not in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("original_price between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("original_price not between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNull() {
            addCriterion("discount_price is null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNotNull() {
            addCriterion("discount_price is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceEqualTo(BigDecimal value) {
            addCriterion("discount_price =", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotEqualTo(BigDecimal value) {
            addCriterion("discount_price <>", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThan(BigDecimal value) {
            addCriterion("discount_price >", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_price >=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThan(BigDecimal value) {
            addCriterion("discount_price <", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_price <=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIn(List<BigDecimal> values) {
            addCriterion("discount_price in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotIn(List<BigDecimal> values) {
            addCriterion("discount_price not in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_price between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_price not between", value1, value2, "discountPrice");
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

        public Criteria andCouponPriceIsNull() {
            addCriterion("coupon_price is null");
            return (Criteria) this;
        }

        public Criteria andCouponPriceIsNotNull() {
            addCriterion("coupon_price is not null");
            return (Criteria) this;
        }

        public Criteria andCouponPriceEqualTo(BigDecimal value) {
            addCriterion("coupon_price =", value, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceNotEqualTo(BigDecimal value) {
            addCriterion("coupon_price <>", value, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceGreaterThan(BigDecimal value) {
            addCriterion("coupon_price >", value, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("coupon_price >=", value, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceLessThan(BigDecimal value) {
            addCriterion("coupon_price <", value, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("coupon_price <=", value, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceIn(List<BigDecimal> values) {
            addCriterion("coupon_price in", values, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceNotIn(List<BigDecimal> values) {
            addCriterion("coupon_price not in", values, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupon_price between", value1, value2, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupon_price not between", value1, value2, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusIsNull() {
            addCriterion("verify_status is null");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusIsNotNull() {
            addCriterion("verify_status is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusEqualTo(String value) {
            addCriterion("verify_status =", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotEqualTo(String value) {
            addCriterion("verify_status <>", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusGreaterThan(String value) {
            addCriterion("verify_status >", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("verify_status >=", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusLessThan(String value) {
            addCriterion("verify_status <", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusLessThanOrEqualTo(String value) {
            addCriterion("verify_status <=", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusLike(String value) {
            addCriterion("verify_status like", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotLike(String value) {
            addCriterion("verify_status not like", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusIn(List<String> values) {
            addCriterion("verify_status in", values, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotIn(List<String> values) {
            addCriterion("verify_status not in", values, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusBetween(String value1, String value2) {
            addCriterion("verify_status between", value1, value2, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotBetween(String value1, String value2) {
            addCriterion("verify_status not between", value1, value2, "verifyStatus");
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

        public Criteria andExpressTypeIsNull() {
            addCriterion("express_type is null");
            return (Criteria) this;
        }

        public Criteria andExpressTypeIsNotNull() {
            addCriterion("express_type is not null");
            return (Criteria) this;
        }

        public Criteria andExpressTypeEqualTo(String value) {
            addCriterion("express_type =", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeNotEqualTo(String value) {
            addCriterion("express_type <>", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeGreaterThan(String value) {
            addCriterion("express_type >", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeGreaterThanOrEqualTo(String value) {
            addCriterion("express_type >=", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeLessThan(String value) {
            addCriterion("express_type <", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeLessThanOrEqualTo(String value) {
            addCriterion("express_type <=", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeLike(String value) {
            addCriterion("express_type like", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeNotLike(String value) {
            addCriterion("express_type not like", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeIn(List<String> values) {
            addCriterion("express_type in", values, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeNotIn(List<String> values) {
            addCriterion("express_type not in", values, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeBetween(String value1, String value2) {
            addCriterion("express_type between", value1, value2, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeNotBetween(String value1, String value2) {
            addCriterion("express_type not between", value1, value2, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressNameIsNull() {
            addCriterion("express_name is null");
            return (Criteria) this;
        }

        public Criteria andExpressNameIsNotNull() {
            addCriterion("express_name is not null");
            return (Criteria) this;
        }

        public Criteria andExpressNameEqualTo(String value) {
            addCriterion("express_name =", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotEqualTo(String value) {
            addCriterion("express_name <>", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameGreaterThan(String value) {
            addCriterion("express_name >", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameGreaterThanOrEqualTo(String value) {
            addCriterion("express_name >=", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLessThan(String value) {
            addCriterion("express_name <", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLessThanOrEqualTo(String value) {
            addCriterion("express_name <=", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLike(String value) {
            addCriterion("express_name like", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotLike(String value) {
            addCriterion("express_name not like", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameIn(List<String> values) {
            addCriterion("express_name in", values, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotIn(List<String> values) {
            addCriterion("express_name not in", values, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameBetween(String value1, String value2) {
            addCriterion("express_name between", value1, value2, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotBetween(String value1, String value2) {
            addCriterion("express_name not between", value1, value2, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyCodeIsNull() {
            addCriterion("express_company_code is null");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyCodeIsNotNull() {
            addCriterion("express_company_code is not null");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyCodeEqualTo(String value) {
            addCriterion("express_company_code =", value, "expressCompanyCode");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyCodeNotEqualTo(String value) {
            addCriterion("express_company_code <>", value, "expressCompanyCode");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyCodeGreaterThan(String value) {
            addCriterion("express_company_code >", value, "expressCompanyCode");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("express_company_code >=", value, "expressCompanyCode");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyCodeLessThan(String value) {
            addCriterion("express_company_code <", value, "expressCompanyCode");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("express_company_code <=", value, "expressCompanyCode");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyCodeLike(String value) {
            addCriterion("express_company_code like", value, "expressCompanyCode");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyCodeNotLike(String value) {
            addCriterion("express_company_code not like", value, "expressCompanyCode");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyCodeIn(List<String> values) {
            addCriterion("express_company_code in", values, "expressCompanyCode");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyCodeNotIn(List<String> values) {
            addCriterion("express_company_code not in", values, "expressCompanyCode");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyCodeBetween(String value1, String value2) {
            addCriterion("express_company_code between", value1, value2, "expressCompanyCode");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("express_company_code not between", value1, value2, "expressCompanyCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeIsNull() {
            addCriterion("express_code is null");
            return (Criteria) this;
        }

        public Criteria andExpressCodeIsNotNull() {
            addCriterion("express_code is not null");
            return (Criteria) this;
        }

        public Criteria andExpressCodeEqualTo(String value) {
            addCriterion("express_code =", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotEqualTo(String value) {
            addCriterion("express_code <>", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeGreaterThan(String value) {
            addCriterion("express_code >", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeGreaterThanOrEqualTo(String value) {
            addCriterion("express_code >=", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeLessThan(String value) {
            addCriterion("express_code <", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeLessThanOrEqualTo(String value) {
            addCriterion("express_code <=", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeLike(String value) {
            addCriterion("express_code like", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotLike(String value) {
            addCriterion("express_code not like", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeIn(List<String> values) {
            addCriterion("express_code in", values, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotIn(List<String> values) {
            addCriterion("express_code not in", values, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeBetween(String value1, String value2) {
            addCriterion("express_code between", value1, value2, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotBetween(String value1, String value2) {
            addCriterion("express_code not between", value1, value2, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressStatusIsNull() {
            addCriterion("express_status is null");
            return (Criteria) this;
        }

        public Criteria andExpressStatusIsNotNull() {
            addCriterion("express_status is not null");
            return (Criteria) this;
        }

        public Criteria andExpressStatusEqualTo(Integer value) {
            addCriterion("express_status =", value, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusNotEqualTo(Integer value) {
            addCriterion("express_status <>", value, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusGreaterThan(Integer value) {
            addCriterion("express_status >", value, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("express_status >=", value, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusLessThan(Integer value) {
            addCriterion("express_status <", value, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusLessThanOrEqualTo(Integer value) {
            addCriterion("express_status <=", value, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusIn(List<Integer> values) {
            addCriterion("express_status in", values, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusNotIn(List<Integer> values) {
            addCriterion("express_status not in", values, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusBetween(Integer value1, Integer value2) {
            addCriterion("express_status between", value1, value2, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("express_status not between", value1, value2, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andSignForTimeIsNull() {
            addCriterion("sign_for_time is null");
            return (Criteria) this;
        }

        public Criteria andSignForTimeIsNotNull() {
            addCriterion("sign_for_time is not null");
            return (Criteria) this;
        }

        public Criteria andSignForTimeEqualTo(Date value) {
            addCriterion("sign_for_time =", value, "signForTime");
            return (Criteria) this;
        }

        public Criteria andSignForTimeNotEqualTo(Date value) {
            addCriterion("sign_for_time <>", value, "signForTime");
            return (Criteria) this;
        }

        public Criteria andSignForTimeGreaterThan(Date value) {
            addCriterion("sign_for_time >", value, "signForTime");
            return (Criteria) this;
        }

        public Criteria andSignForTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sign_for_time >=", value, "signForTime");
            return (Criteria) this;
        }

        public Criteria andSignForTimeLessThan(Date value) {
            addCriterion("sign_for_time <", value, "signForTime");
            return (Criteria) this;
        }

        public Criteria andSignForTimeLessThanOrEqualTo(Date value) {
            addCriterion("sign_for_time <=", value, "signForTime");
            return (Criteria) this;
        }

        public Criteria andSignForTimeIn(List<Date> values) {
            addCriterion("sign_for_time in", values, "signForTime");
            return (Criteria) this;
        }

        public Criteria andSignForTimeNotIn(List<Date> values) {
            addCriterion("sign_for_time not in", values, "signForTime");
            return (Criteria) this;
        }

        public Criteria andSignForTimeBetween(Date value1, Date value2) {
            addCriterion("sign_for_time between", value1, value2, "signForTime");
            return (Criteria) this;
        }

        public Criteria andSignForTimeNotBetween(Date value1, Date value2) {
            addCriterion("sign_for_time not between", value1, value2, "signForTime");
            return (Criteria) this;
        }

        public Criteria andExpressTimeIsNull() {
            addCriterion("express_time is null");
            return (Criteria) this;
        }

        public Criteria andExpressTimeIsNotNull() {
            addCriterion("express_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpressTimeEqualTo(String value) {
            addCriterion("express_time =", value, "expressTime");
            return (Criteria) this;
        }

        public Criteria andExpressTimeNotEqualTo(String value) {
            addCriterion("express_time <>", value, "expressTime");
            return (Criteria) this;
        }

        public Criteria andExpressTimeGreaterThan(String value) {
            addCriterion("express_time >", value, "expressTime");
            return (Criteria) this;
        }

        public Criteria andExpressTimeGreaterThanOrEqualTo(String value) {
            addCriterion("express_time >=", value, "expressTime");
            return (Criteria) this;
        }

        public Criteria andExpressTimeLessThan(String value) {
            addCriterion("express_time <", value, "expressTime");
            return (Criteria) this;
        }

        public Criteria andExpressTimeLessThanOrEqualTo(String value) {
            addCriterion("express_time <=", value, "expressTime");
            return (Criteria) this;
        }

        public Criteria andExpressTimeLike(String value) {
            addCriterion("express_time like", value, "expressTime");
            return (Criteria) this;
        }

        public Criteria andExpressTimeNotLike(String value) {
            addCriterion("express_time not like", value, "expressTime");
            return (Criteria) this;
        }

        public Criteria andExpressTimeIn(List<String> values) {
            addCriterion("express_time in", values, "expressTime");
            return (Criteria) this;
        }

        public Criteria andExpressTimeNotIn(List<String> values) {
            addCriterion("express_time not in", values, "expressTime");
            return (Criteria) this;
        }

        public Criteria andExpressTimeBetween(String value1, String value2) {
            addCriterion("express_time between", value1, value2, "expressTime");
            return (Criteria) this;
        }

        public Criteria andExpressTimeNotBetween(String value1, String value2) {
            addCriterion("express_time not between", value1, value2, "expressTime");
            return (Criteria) this;
        }

        public Criteria andExpressAreaIsNull() {
            addCriterion("express_area is null");
            return (Criteria) this;
        }

        public Criteria andExpressAreaIsNotNull() {
            addCriterion("express_area is not null");
            return (Criteria) this;
        }

        public Criteria andExpressAreaEqualTo(String value) {
            addCriterion("express_area =", value, "expressArea");
            return (Criteria) this;
        }

        public Criteria andExpressAreaNotEqualTo(String value) {
            addCriterion("express_area <>", value, "expressArea");
            return (Criteria) this;
        }

        public Criteria andExpressAreaGreaterThan(String value) {
            addCriterion("express_area >", value, "expressArea");
            return (Criteria) this;
        }

        public Criteria andExpressAreaGreaterThanOrEqualTo(String value) {
            addCriterion("express_area >=", value, "expressArea");
            return (Criteria) this;
        }

        public Criteria andExpressAreaLessThan(String value) {
            addCriterion("express_area <", value, "expressArea");
            return (Criteria) this;
        }

        public Criteria andExpressAreaLessThanOrEqualTo(String value) {
            addCriterion("express_area <=", value, "expressArea");
            return (Criteria) this;
        }

        public Criteria andExpressAreaLike(String value) {
            addCriterion("express_area like", value, "expressArea");
            return (Criteria) this;
        }

        public Criteria andExpressAreaNotLike(String value) {
            addCriterion("express_area not like", value, "expressArea");
            return (Criteria) this;
        }

        public Criteria andExpressAreaIn(List<String> values) {
            addCriterion("express_area in", values, "expressArea");
            return (Criteria) this;
        }

        public Criteria andExpressAreaNotIn(List<String> values) {
            addCriterion("express_area not in", values, "expressArea");
            return (Criteria) this;
        }

        public Criteria andExpressAreaBetween(String value1, String value2) {
            addCriterion("express_area between", value1, value2, "expressArea");
            return (Criteria) this;
        }

        public Criteria andExpressAreaNotBetween(String value1, String value2) {
            addCriterion("express_area not between", value1, value2, "expressArea");
            return (Criteria) this;
        }

        public Criteria andExpressPhoneIsNull() {
            addCriterion("express_phone is null");
            return (Criteria) this;
        }

        public Criteria andExpressPhoneIsNotNull() {
            addCriterion("express_phone is not null");
            return (Criteria) this;
        }

        public Criteria andExpressPhoneEqualTo(String value) {
            addCriterion("express_phone =", value, "expressPhone");
            return (Criteria) this;
        }

        public Criteria andExpressPhoneNotEqualTo(String value) {
            addCriterion("express_phone <>", value, "expressPhone");
            return (Criteria) this;
        }

        public Criteria andExpressPhoneGreaterThan(String value) {
            addCriterion("express_phone >", value, "expressPhone");
            return (Criteria) this;
        }

        public Criteria andExpressPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("express_phone >=", value, "expressPhone");
            return (Criteria) this;
        }

        public Criteria andExpressPhoneLessThan(String value) {
            addCriterion("express_phone <", value, "expressPhone");
            return (Criteria) this;
        }

        public Criteria andExpressPhoneLessThanOrEqualTo(String value) {
            addCriterion("express_phone <=", value, "expressPhone");
            return (Criteria) this;
        }

        public Criteria andExpressPhoneLike(String value) {
            addCriterion("express_phone like", value, "expressPhone");
            return (Criteria) this;
        }

        public Criteria andExpressPhoneNotLike(String value) {
            addCriterion("express_phone not like", value, "expressPhone");
            return (Criteria) this;
        }

        public Criteria andExpressPhoneIn(List<String> values) {
            addCriterion("express_phone in", values, "expressPhone");
            return (Criteria) this;
        }

        public Criteria andExpressPhoneNotIn(List<String> values) {
            addCriterion("express_phone not in", values, "expressPhone");
            return (Criteria) this;
        }

        public Criteria andExpressPhoneBetween(String value1, String value2) {
            addCriterion("express_phone between", value1, value2, "expressPhone");
            return (Criteria) this;
        }

        public Criteria andExpressPhoneNotBetween(String value1, String value2) {
            addCriterion("express_phone not between", value1, value2, "expressPhone");
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

        public Criteria andSendStatusIsNull() {
            addCriterion("send_status is null");
            return (Criteria) this;
        }

        public Criteria andSendStatusIsNotNull() {
            addCriterion("send_status is not null");
            return (Criteria) this;
        }

        public Criteria andSendStatusEqualTo(Integer value) {
            addCriterion("send_status =", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotEqualTo(Integer value) {
            addCriterion("send_status <>", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusGreaterThan(Integer value) {
            addCriterion("send_status >", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_status >=", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusLessThan(Integer value) {
            addCriterion("send_status <", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusLessThanOrEqualTo(Integer value) {
            addCriterion("send_status <=", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusIn(List<Integer> values) {
            addCriterion("send_status in", values, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotIn(List<Integer> values) {
            addCriterion("send_status not in", values, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusBetween(Integer value1, Integer value2) {
            addCriterion("send_status between", value1, value2, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("send_status not between", value1, value2, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNull() {
            addCriterion("refund_time is null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNotNull() {
            addCriterion("refund_time is not null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeEqualTo(Date value) {
            addCriterion("refund_time =", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotEqualTo(Date value) {
            addCriterion("refund_time <>", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThan(Date value) {
            addCriterion("refund_time >", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("refund_time >=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThan(Date value) {
            addCriterion("refund_time <", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThanOrEqualTo(Date value) {
            addCriterion("refund_time <=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIn(List<Date> values) {
            addCriterion("refund_time in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotIn(List<Date> values) {
            addCriterion("refund_time not in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeBetween(Date value1, Date value2) {
            addCriterion("refund_time between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotBetween(Date value1, Date value2) {
            addCriterion("refund_time not between", value1, value2, "refundTime");
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

        public Criteria andRefundApprovalIsNull() {
            addCriterion("refund_approval is null");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalIsNotNull() {
            addCriterion("refund_approval is not null");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalEqualTo(String value) {
            addCriterion("refund_approval =", value, "refundApproval");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalNotEqualTo(String value) {
            addCriterion("refund_approval <>", value, "refundApproval");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalGreaterThan(String value) {
            addCriterion("refund_approval >", value, "refundApproval");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalGreaterThanOrEqualTo(String value) {
            addCriterion("refund_approval >=", value, "refundApproval");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalLessThan(String value) {
            addCriterion("refund_approval <", value, "refundApproval");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalLessThanOrEqualTo(String value) {
            addCriterion("refund_approval <=", value, "refundApproval");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalLike(String value) {
            addCriterion("refund_approval like", value, "refundApproval");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalNotLike(String value) {
            addCriterion("refund_approval not like", value, "refundApproval");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalIn(List<String> values) {
            addCriterion("refund_approval in", values, "refundApproval");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalNotIn(List<String> values) {
            addCriterion("refund_approval not in", values, "refundApproval");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalBetween(String value1, String value2) {
            addCriterion("refund_approval between", value1, value2, "refundApproval");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalNotBetween(String value1, String value2) {
            addCriterion("refund_approval not between", value1, value2, "refundApproval");
            return (Criteria) this;
        }

        public Criteria andRefundCommentIsNull() {
            addCriterion("refund_comment is null");
            return (Criteria) this;
        }

        public Criteria andRefundCommentIsNotNull() {
            addCriterion("refund_comment is not null");
            return (Criteria) this;
        }

        public Criteria andRefundCommentEqualTo(String value) {
            addCriterion("refund_comment =", value, "refundComment");
            return (Criteria) this;
        }

        public Criteria andRefundCommentNotEqualTo(String value) {
            addCriterion("refund_comment <>", value, "refundComment");
            return (Criteria) this;
        }

        public Criteria andRefundCommentGreaterThan(String value) {
            addCriterion("refund_comment >", value, "refundComment");
            return (Criteria) this;
        }

        public Criteria andRefundCommentGreaterThanOrEqualTo(String value) {
            addCriterion("refund_comment >=", value, "refundComment");
            return (Criteria) this;
        }

        public Criteria andRefundCommentLessThan(String value) {
            addCriterion("refund_comment <", value, "refundComment");
            return (Criteria) this;
        }

        public Criteria andRefundCommentLessThanOrEqualTo(String value) {
            addCriterion("refund_comment <=", value, "refundComment");
            return (Criteria) this;
        }

        public Criteria andRefundCommentLike(String value) {
            addCriterion("refund_comment like", value, "refundComment");
            return (Criteria) this;
        }

        public Criteria andRefundCommentNotLike(String value) {
            addCriterion("refund_comment not like", value, "refundComment");
            return (Criteria) this;
        }

        public Criteria andRefundCommentIn(List<String> values) {
            addCriterion("refund_comment in", values, "refundComment");
            return (Criteria) this;
        }

        public Criteria andRefundCommentNotIn(List<String> values) {
            addCriterion("refund_comment not in", values, "refundComment");
            return (Criteria) this;
        }

        public Criteria andRefundCommentBetween(String value1, String value2) {
            addCriterion("refund_comment between", value1, value2, "refundComment");
            return (Criteria) this;
        }

        public Criteria andRefundCommentNotBetween(String value1, String value2) {
            addCriterion("refund_comment not between", value1, value2, "refundComment");
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

        public Criteria andResultStatusIsNull() {
            addCriterion("result_status is null");
            return (Criteria) this;
        }

        public Criteria andResultStatusIsNotNull() {
            addCriterion("result_status is not null");
            return (Criteria) this;
        }

        public Criteria andResultStatusEqualTo(Integer value) {
            addCriterion("result_status =", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusNotEqualTo(Integer value) {
            addCriterion("result_status <>", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusGreaterThan(Integer value) {
            addCriterion("result_status >", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("result_status >=", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusLessThan(Integer value) {
            addCriterion("result_status <", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusLessThanOrEqualTo(Integer value) {
            addCriterion("result_status <=", value, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusIn(List<Integer> values) {
            addCriterion("result_status in", values, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusNotIn(List<Integer> values) {
            addCriterion("result_status not in", values, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusBetween(Integer value1, Integer value2) {
            addCriterion("result_status between", value1, value2, "resultStatus");
            return (Criteria) this;
        }

        public Criteria andResultStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("result_status not between", value1, value2, "resultStatus");
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

        public Criteria andOpenRefundIdIsNull() {
            addCriterion("open_refund_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenRefundIdIsNotNull() {
            addCriterion("open_refund_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenRefundIdEqualTo(Long value) {
            addCriterion("open_refund_id =", value, "openRefundId");
            return (Criteria) this;
        }

        public Criteria andOpenRefundIdNotEqualTo(Long value) {
            addCriterion("open_refund_id <>", value, "openRefundId");
            return (Criteria) this;
        }

        public Criteria andOpenRefundIdGreaterThan(Long value) {
            addCriterion("open_refund_id >", value, "openRefundId");
            return (Criteria) this;
        }

        public Criteria andOpenRefundIdGreaterThanOrEqualTo(Long value) {
            addCriterion("open_refund_id >=", value, "openRefundId");
            return (Criteria) this;
        }

        public Criteria andOpenRefundIdLessThan(Long value) {
            addCriterion("open_refund_id <", value, "openRefundId");
            return (Criteria) this;
        }

        public Criteria andOpenRefundIdLessThanOrEqualTo(Long value) {
            addCriterion("open_refund_id <=", value, "openRefundId");
            return (Criteria) this;
        }

        public Criteria andOpenRefundIdIn(List<Long> values) {
            addCriterion("open_refund_id in", values, "openRefundId");
            return (Criteria) this;
        }

        public Criteria andOpenRefundIdNotIn(List<Long> values) {
            addCriterion("open_refund_id not in", values, "openRefundId");
            return (Criteria) this;
        }

        public Criteria andOpenRefundIdBetween(Long value1, Long value2) {
            addCriterion("open_refund_id between", value1, value2, "openRefundId");
            return (Criteria) this;
        }

        public Criteria andOpenRefundIdNotBetween(Long value1, Long value2) {
            addCriterion("open_refund_id not between", value1, value2, "openRefundId");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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

        public Criteria andInvalidTimeIsNull() {
            addCriterion("invalid_time is null");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeIsNotNull() {
            addCriterion("invalid_time is not null");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeEqualTo(Date value) {
            addCriterion("invalid_time =", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeNotEqualTo(Date value) {
            addCriterion("invalid_time <>", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeGreaterThan(Date value) {
            addCriterion("invalid_time >", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("invalid_time >=", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeLessThan(Date value) {
            addCriterion("invalid_time <", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeLessThanOrEqualTo(Date value) {
            addCriterion("invalid_time <=", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeIn(List<Date> values) {
            addCriterion("invalid_time in", values, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeNotIn(List<Date> values) {
            addCriterion("invalid_time not in", values, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeBetween(Date value1, Date value2) {
            addCriterion("invalid_time between", value1, value2, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeNotBetween(Date value1, Date value2) {
            addCriterion("invalid_time not between", value1, value2, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIsNull() {
            addCriterion("confirm_time is null");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIsNotNull() {
            addCriterion("confirm_time is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeEqualTo(Date value) {
            addCriterion("confirm_time =", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotEqualTo(Date value) {
            addCriterion("confirm_time <>", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeGreaterThan(Date value) {
            addCriterion("confirm_time >", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("confirm_time >=", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeLessThan(Date value) {
            addCriterion("confirm_time <", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeLessThanOrEqualTo(Date value) {
            addCriterion("confirm_time <=", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIn(List<Date> values) {
            addCriterion("confirm_time in", values, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotIn(List<Date> values) {
            addCriterion("confirm_time not in", values, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeBetween(Date value1, Date value2) {
            addCriterion("confirm_time between", value1, value2, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotBetween(Date value1, Date value2) {
            addCriterion("confirm_time not between", value1, value2, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIsNull() {
            addCriterion("resource_type is null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIsNotNull() {
            addCriterion("resource_type is not null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeEqualTo(Integer value) {
            addCriterion("resource_type =", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotEqualTo(Integer value) {
            addCriterion("resource_type <>", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeGreaterThan(Integer value) {
            addCriterion("resource_type >", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_type >=", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLessThan(Integer value) {
            addCriterion("resource_type <", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("resource_type <=", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIn(List<Integer> values) {
            addCriterion("resource_type in", values, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotIn(List<Integer> values) {
            addCriterion("resource_type not in", values, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeBetween(Integer value1, Integer value2) {
            addCriterion("resource_type between", value1, value2, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_type not between", value1, value2, "resourceType");
            return (Criteria) this;
        }

        public Criteria andCouponRecordIdIsNull() {
            addCriterion("coupon_record_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponRecordIdIsNotNull() {
            addCriterion("coupon_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponRecordIdEqualTo(Long value) {
            addCriterion("coupon_record_id =", value, "couponRecordId");
            return (Criteria) this;
        }

        public Criteria andCouponRecordIdNotEqualTo(Long value) {
            addCriterion("coupon_record_id <>", value, "couponRecordId");
            return (Criteria) this;
        }

        public Criteria andCouponRecordIdGreaterThan(Long value) {
            addCriterion("coupon_record_id >", value, "couponRecordId");
            return (Criteria) this;
        }

        public Criteria andCouponRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("coupon_record_id >=", value, "couponRecordId");
            return (Criteria) this;
        }

        public Criteria andCouponRecordIdLessThan(Long value) {
            addCriterion("coupon_record_id <", value, "couponRecordId");
            return (Criteria) this;
        }

        public Criteria andCouponRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("coupon_record_id <=", value, "couponRecordId");
            return (Criteria) this;
        }

        public Criteria andCouponRecordIdIn(List<Long> values) {
            addCriterion("coupon_record_id in", values, "couponRecordId");
            return (Criteria) this;
        }

        public Criteria andCouponRecordIdNotIn(List<Long> values) {
            addCriterion("coupon_record_id not in", values, "couponRecordId");
            return (Criteria) this;
        }

        public Criteria andCouponRecordIdBetween(Long value1, Long value2) {
            addCriterion("coupon_record_id between", value1, value2, "couponRecordId");
            return (Criteria) this;
        }

        public Criteria andCouponRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("coupon_record_id not between", value1, value2, "couponRecordId");
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

        public Criteria andXfsjIdIsNull() {
            addCriterion("xfsj_id is null");
            return (Criteria) this;
        }

        public Criteria andXfsjIdIsNotNull() {
            addCriterion("xfsj_id is not null");
            return (Criteria) this;
        }

        public Criteria andXfsjIdEqualTo(Long value) {
            addCriterion("xfsj_id =", value, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdNotEqualTo(Long value) {
            addCriterion("xfsj_id <>", value, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdGreaterThan(Long value) {
            addCriterion("xfsj_id >", value, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdGreaterThanOrEqualTo(Long value) {
            addCriterion("xfsj_id >=", value, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdLessThan(Long value) {
            addCriterion("xfsj_id <", value, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdLessThanOrEqualTo(Long value) {
            addCriterion("xfsj_id <=", value, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdIn(List<Long> values) {
            addCriterion("xfsj_id in", values, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdNotIn(List<Long> values) {
            addCriterion("xfsj_id not in", values, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdBetween(Long value1, Long value2) {
            addCriterion("xfsj_id between", value1, value2, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdNotBetween(Long value1, Long value2) {
            addCriterion("xfsj_id not between", value1, value2, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNull() {
            addCriterion("comment_status is null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNotNull() {
            addCriterion("comment_status is not null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusEqualTo(String value) {
            addCriterion("comment_status =", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotEqualTo(String value) {
            addCriterion("comment_status <>", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThan(String value) {
            addCriterion("comment_status >", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThanOrEqualTo(String value) {
            addCriterion("comment_status >=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThan(String value) {
            addCriterion("comment_status <", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThanOrEqualTo(String value) {
            addCriterion("comment_status <=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLike(String value) {
            addCriterion("comment_status like", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotLike(String value) {
            addCriterion("comment_status not like", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIn(List<String> values) {
            addCriterion("comment_status in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotIn(List<String> values) {
            addCriterion("comment_status not in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusBetween(String value1, String value2) {
            addCriterion("comment_status between", value1, value2, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotBetween(String value1, String value2) {
            addCriterion("comment_status not between", value1, value2, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusIsNull() {
            addCriterion("group_status is null");
            return (Criteria) this;
        }

        public Criteria andGroupStatusIsNotNull() {
            addCriterion("group_status is not null");
            return (Criteria) this;
        }

        public Criteria andGroupStatusEqualTo(Integer value) {
            addCriterion("group_status =", value, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusNotEqualTo(Integer value) {
            addCriterion("group_status <>", value, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusGreaterThan(Integer value) {
            addCriterion("group_status >", value, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_status >=", value, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusLessThan(Integer value) {
            addCriterion("group_status <", value, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusLessThanOrEqualTo(Integer value) {
            addCriterion("group_status <=", value, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusIn(List<Integer> values) {
            addCriterion("group_status in", values, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusNotIn(List<Integer> values) {
            addCriterion("group_status not in", values, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusBetween(Integer value1, Integer value2) {
            addCriterion("group_status between", value1, value2, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("group_status not between", value1, value2, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupInfoIdIsNull() {
            addCriterion("group_info_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupInfoIdIsNotNull() {
            addCriterion("group_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupInfoIdEqualTo(Long value) {
            addCriterion("group_info_id =", value, "groupInfoId");
            return (Criteria) this;
        }

        public Criteria andGroupInfoIdNotEqualTo(Long value) {
            addCriterion("group_info_id <>", value, "groupInfoId");
            return (Criteria) this;
        }

        public Criteria andGroupInfoIdGreaterThan(Long value) {
            addCriterion("group_info_id >", value, "groupInfoId");
            return (Criteria) this;
        }

        public Criteria andGroupInfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("group_info_id >=", value, "groupInfoId");
            return (Criteria) this;
        }

        public Criteria andGroupInfoIdLessThan(Long value) {
            addCriterion("group_info_id <", value, "groupInfoId");
            return (Criteria) this;
        }

        public Criteria andGroupInfoIdLessThanOrEqualTo(Long value) {
            addCriterion("group_info_id <=", value, "groupInfoId");
            return (Criteria) this;
        }

        public Criteria andGroupInfoIdIn(List<Long> values) {
            addCriterion("group_info_id in", values, "groupInfoId");
            return (Criteria) this;
        }

        public Criteria andGroupInfoIdNotIn(List<Long> values) {
            addCriterion("group_info_id not in", values, "groupInfoId");
            return (Criteria) this;
        }

        public Criteria andGroupInfoIdBetween(Long value1, Long value2) {
            addCriterion("group_info_id between", value1, value2, "groupInfoId");
            return (Criteria) this;
        }

        public Criteria andGroupInfoIdNotBetween(Long value1, Long value2) {
            addCriterion("group_info_id not between", value1, value2, "groupInfoId");
            return (Criteria) this;
        }

        public Criteria andGroupDataIdIsNull() {
            addCriterion("group_data_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupDataIdIsNotNull() {
            addCriterion("group_data_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupDataIdEqualTo(Long value) {
            addCriterion("group_data_id =", value, "groupDataId");
            return (Criteria) this;
        }

        public Criteria andGroupDataIdNotEqualTo(Long value) {
            addCriterion("group_data_id <>", value, "groupDataId");
            return (Criteria) this;
        }

        public Criteria andGroupDataIdGreaterThan(Long value) {
            addCriterion("group_data_id >", value, "groupDataId");
            return (Criteria) this;
        }

        public Criteria andGroupDataIdGreaterThanOrEqualTo(Long value) {
            addCriterion("group_data_id >=", value, "groupDataId");
            return (Criteria) this;
        }

        public Criteria andGroupDataIdLessThan(Long value) {
            addCriterion("group_data_id <", value, "groupDataId");
            return (Criteria) this;
        }

        public Criteria andGroupDataIdLessThanOrEqualTo(Long value) {
            addCriterion("group_data_id <=", value, "groupDataId");
            return (Criteria) this;
        }

        public Criteria andGroupDataIdIn(List<Long> values) {
            addCriterion("group_data_id in", values, "groupDataId");
            return (Criteria) this;
        }

        public Criteria andGroupDataIdNotIn(List<Long> values) {
            addCriterion("group_data_id not in", values, "groupDataId");
            return (Criteria) this;
        }

        public Criteria andGroupDataIdBetween(Long value1, Long value2) {
            addCriterion("group_data_id between", value1, value2, "groupDataId");
            return (Criteria) this;
        }

        public Criteria andGroupDataIdNotBetween(Long value1, Long value2) {
            addCriterion("group_data_id not between", value1, value2, "groupDataId");
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