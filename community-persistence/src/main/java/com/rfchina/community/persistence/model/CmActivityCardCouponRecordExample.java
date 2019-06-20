package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CmActivityCardCouponRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CmActivityCardCouponRecordExample() {
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

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Long value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Long value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Long value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Long value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Long value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Long> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Long> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Long value1, Long value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Long value1, Long value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdIsNull() {
            addCriterion("card_coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdIsNotNull() {
            addCriterion("card_coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdEqualTo(Long value) {
            addCriterion("card_coupon_id =", value, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdNotEqualTo(Long value) {
            addCriterion("card_coupon_id <>", value, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdGreaterThan(Long value) {
            addCriterion("card_coupon_id >", value, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdGreaterThanOrEqualTo(Long value) {
            addCriterion("card_coupon_id >=", value, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdLessThan(Long value) {
            addCriterion("card_coupon_id <", value, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdLessThanOrEqualTo(Long value) {
            addCriterion("card_coupon_id <=", value, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdIn(List<Long> values) {
            addCriterion("card_coupon_id in", values, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdNotIn(List<Long> values) {
            addCriterion("card_coupon_id not in", values, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdBetween(Long value1, Long value2) {
            addCriterion("card_coupon_id between", value1, value2, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdNotBetween(Long value1, Long value2) {
            addCriterion("card_coupon_id not between", value1, value2, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNull() {
            addCriterion("coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNotNull() {
            addCriterion("coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponIdEqualTo(Long value) {
            addCriterion("coupon_id =", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotEqualTo(Long value) {
            addCriterion("coupon_id <>", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThan(Long value) {
            addCriterion("coupon_id >", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThanOrEqualTo(Long value) {
            addCriterion("coupon_id >=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThan(Long value) {
            addCriterion("coupon_id <", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThanOrEqualTo(Long value) {
            addCriterion("coupon_id <=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdIn(List<Long> values) {
            addCriterion("coupon_id in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotIn(List<Long> values) {
            addCriterion("coupon_id not in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdBetween(Long value1, Long value2) {
            addCriterion("coupon_id between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotBetween(Long value1, Long value2) {
            addCriterion("coupon_id not between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponSnIsNull() {
            addCriterion("coupon_sn is null");
            return (Criteria) this;
        }

        public Criteria andCouponSnIsNotNull() {
            addCriterion("coupon_sn is not null");
            return (Criteria) this;
        }

        public Criteria andCouponSnEqualTo(String value) {
            addCriterion("coupon_sn =", value, "couponSn");
            return (Criteria) this;
        }

        public Criteria andCouponSnNotEqualTo(String value) {
            addCriterion("coupon_sn <>", value, "couponSn");
            return (Criteria) this;
        }

        public Criteria andCouponSnGreaterThan(String value) {
            addCriterion("coupon_sn >", value, "couponSn");
            return (Criteria) this;
        }

        public Criteria andCouponSnGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_sn >=", value, "couponSn");
            return (Criteria) this;
        }

        public Criteria andCouponSnLessThan(String value) {
            addCriterion("coupon_sn <", value, "couponSn");
            return (Criteria) this;
        }

        public Criteria andCouponSnLessThanOrEqualTo(String value) {
            addCriterion("coupon_sn <=", value, "couponSn");
            return (Criteria) this;
        }

        public Criteria andCouponSnLike(String value) {
            addCriterion("coupon_sn like", value, "couponSn");
            return (Criteria) this;
        }

        public Criteria andCouponSnNotLike(String value) {
            addCriterion("coupon_sn not like", value, "couponSn");
            return (Criteria) this;
        }

        public Criteria andCouponSnIn(List<String> values) {
            addCriterion("coupon_sn in", values, "couponSn");
            return (Criteria) this;
        }

        public Criteria andCouponSnNotIn(List<String> values) {
            addCriterion("coupon_sn not in", values, "couponSn");
            return (Criteria) this;
        }

        public Criteria andCouponSnBetween(String value1, String value2) {
            addCriterion("coupon_sn between", value1, value2, "couponSn");
            return (Criteria) this;
        }

        public Criteria andCouponSnNotBetween(String value1, String value2) {
            addCriterion("coupon_sn not between", value1, value2, "couponSn");
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

        public Criteria andValidFromDateIsNull() {
            addCriterion("valid_from_date is null");
            return (Criteria) this;
        }

        public Criteria andValidFromDateIsNotNull() {
            addCriterion("valid_from_date is not null");
            return (Criteria) this;
        }

        public Criteria andValidFromDateEqualTo(Date value) {
            addCriterion("valid_from_date =", value, "validFromDate");
            return (Criteria) this;
        }

        public Criteria andValidFromDateNotEqualTo(Date value) {
            addCriterion("valid_from_date <>", value, "validFromDate");
            return (Criteria) this;
        }

        public Criteria andValidFromDateGreaterThan(Date value) {
            addCriterion("valid_from_date >", value, "validFromDate");
            return (Criteria) this;
        }

        public Criteria andValidFromDateGreaterThanOrEqualTo(Date value) {
            addCriterion("valid_from_date >=", value, "validFromDate");
            return (Criteria) this;
        }

        public Criteria andValidFromDateLessThan(Date value) {
            addCriterion("valid_from_date <", value, "validFromDate");
            return (Criteria) this;
        }

        public Criteria andValidFromDateLessThanOrEqualTo(Date value) {
            addCriterion("valid_from_date <=", value, "validFromDate");
            return (Criteria) this;
        }

        public Criteria andValidFromDateIn(List<Date> values) {
            addCriterion("valid_from_date in", values, "validFromDate");
            return (Criteria) this;
        }

        public Criteria andValidFromDateNotIn(List<Date> values) {
            addCriterion("valid_from_date not in", values, "validFromDate");
            return (Criteria) this;
        }

        public Criteria andValidFromDateBetween(Date value1, Date value2) {
            addCriterion("valid_from_date between", value1, value2, "validFromDate");
            return (Criteria) this;
        }

        public Criteria andValidFromDateNotBetween(Date value1, Date value2) {
            addCriterion("valid_from_date not between", value1, value2, "validFromDate");
            return (Criteria) this;
        }

        public Criteria andValidToDateIsNull() {
            addCriterion("valid_to_date is null");
            return (Criteria) this;
        }

        public Criteria andValidToDateIsNotNull() {
            addCriterion("valid_to_date is not null");
            return (Criteria) this;
        }

        public Criteria andValidToDateEqualTo(Date value) {
            addCriterion("valid_to_date =", value, "validToDate");
            return (Criteria) this;
        }

        public Criteria andValidToDateNotEqualTo(Date value) {
            addCriterion("valid_to_date <>", value, "validToDate");
            return (Criteria) this;
        }

        public Criteria andValidToDateGreaterThan(Date value) {
            addCriterion("valid_to_date >", value, "validToDate");
            return (Criteria) this;
        }

        public Criteria andValidToDateGreaterThanOrEqualTo(Date value) {
            addCriterion("valid_to_date >=", value, "validToDate");
            return (Criteria) this;
        }

        public Criteria andValidToDateLessThan(Date value) {
            addCriterion("valid_to_date <", value, "validToDate");
            return (Criteria) this;
        }

        public Criteria andValidToDateLessThanOrEqualTo(Date value) {
            addCriterion("valid_to_date <=", value, "validToDate");
            return (Criteria) this;
        }

        public Criteria andValidToDateIn(List<Date> values) {
            addCriterion("valid_to_date in", values, "validToDate");
            return (Criteria) this;
        }

        public Criteria andValidToDateNotIn(List<Date> values) {
            addCriterion("valid_to_date not in", values, "validToDate");
            return (Criteria) this;
        }

        public Criteria andValidToDateBetween(Date value1, Date value2) {
            addCriterion("valid_to_date between", value1, value2, "validToDate");
            return (Criteria) this;
        }

        public Criteria andValidToDateNotBetween(Date value1, Date value2) {
            addCriterion("valid_to_date not between", value1, value2, "validToDate");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIsNull() {
            addCriterion("coupon_type is null");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIsNotNull() {
            addCriterion("coupon_type is not null");
            return (Criteria) this;
        }

        public Criteria andCouponTypeEqualTo(Integer value) {
            addCriterion("coupon_type =", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotEqualTo(Integer value) {
            addCriterion("coupon_type <>", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeGreaterThan(Integer value) {
            addCriterion("coupon_type >", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_type >=", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLessThan(Integer value) {
            addCriterion("coupon_type <", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_type <=", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIn(List<Integer> values) {
            addCriterion("coupon_type in", values, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotIn(List<Integer> values) {
            addCriterion("coupon_type not in", values, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeBetween(Integer value1, Integer value2) {
            addCriterion("coupon_type between", value1, value2, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_type not between", value1, value2, "couponType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNull() {
            addCriterion("item_type is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNotNull() {
            addCriterion("item_type is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeEqualTo(Integer value) {
            addCriterion("item_type =", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotEqualTo(Integer value) {
            addCriterion("item_type <>", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThan(Integer value) {
            addCriterion("item_type >", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_type >=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThan(Integer value) {
            addCriterion("item_type <", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThanOrEqualTo(Integer value) {
            addCriterion("item_type <=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIn(List<Integer> values) {
            addCriterion("item_type in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotIn(List<Integer> values) {
            addCriterion("item_type not in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeBetween(Integer value1, Integer value2) {
            addCriterion("item_type between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("item_type not between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andUseChannelIsNull() {
            addCriterion("use_channel is null");
            return (Criteria) this;
        }

        public Criteria andUseChannelIsNotNull() {
            addCriterion("use_channel is not null");
            return (Criteria) this;
        }

        public Criteria andUseChannelEqualTo(Integer value) {
            addCriterion("use_channel =", value, "useChannel");
            return (Criteria) this;
        }

        public Criteria andUseChannelNotEqualTo(Integer value) {
            addCriterion("use_channel <>", value, "useChannel");
            return (Criteria) this;
        }

        public Criteria andUseChannelGreaterThan(Integer value) {
            addCriterion("use_channel >", value, "useChannel");
            return (Criteria) this;
        }

        public Criteria andUseChannelGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_channel >=", value, "useChannel");
            return (Criteria) this;
        }

        public Criteria andUseChannelLessThan(Integer value) {
            addCriterion("use_channel <", value, "useChannel");
            return (Criteria) this;
        }

        public Criteria andUseChannelLessThanOrEqualTo(Integer value) {
            addCriterion("use_channel <=", value, "useChannel");
            return (Criteria) this;
        }

        public Criteria andUseChannelIn(List<Integer> values) {
            addCriterion("use_channel in", values, "useChannel");
            return (Criteria) this;
        }

        public Criteria andUseChannelNotIn(List<Integer> values) {
            addCriterion("use_channel not in", values, "useChannel");
            return (Criteria) this;
        }

        public Criteria andUseChannelBetween(Integer value1, Integer value2) {
            addCriterion("use_channel between", value1, value2, "useChannel");
            return (Criteria) this;
        }

        public Criteria andUseChannelNotBetween(Integer value1, Integer value2) {
            addCriterion("use_channel not between", value1, value2, "useChannel");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(Integer value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(Integer value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(Integer value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(Integer value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(Integer value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<Integer> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<Integer> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(Integer value1, Integer value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusIsNull() {
            addCriterion("confirm_status is null");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusIsNotNull() {
            addCriterion("confirm_status is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusEqualTo(Integer value) {
            addCriterion("confirm_status =", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotEqualTo(Integer value) {
            addCriterion("confirm_status <>", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusGreaterThan(Integer value) {
            addCriterion("confirm_status >", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("confirm_status >=", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusLessThan(Integer value) {
            addCriterion("confirm_status <", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusLessThanOrEqualTo(Integer value) {
            addCriterion("confirm_status <=", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusIn(List<Integer> values) {
            addCriterion("confirm_status in", values, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotIn(List<Integer> values) {
            addCriterion("confirm_status not in", values, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusBetween(Integer value1, Integer value2) {
            addCriterion("confirm_status between", value1, value2, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("confirm_status not between", value1, value2, "confirmStatus");
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

        public Criteria andConfirmCodeIsNull() {
            addCriterion("confirm_code is null");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeIsNotNull() {
            addCriterion("confirm_code is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeEqualTo(String value) {
            addCriterion("confirm_code =", value, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeNotEqualTo(String value) {
            addCriterion("confirm_code <>", value, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeGreaterThan(String value) {
            addCriterion("confirm_code >", value, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeGreaterThanOrEqualTo(String value) {
            addCriterion("confirm_code >=", value, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeLessThan(String value) {
            addCriterion("confirm_code <", value, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeLessThanOrEqualTo(String value) {
            addCriterion("confirm_code <=", value, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeLike(String value) {
            addCriterion("confirm_code like", value, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeNotLike(String value) {
            addCriterion("confirm_code not like", value, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeIn(List<String> values) {
            addCriterion("confirm_code in", values, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeNotIn(List<String> values) {
            addCriterion("confirm_code not in", values, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeBetween(String value1, String value2) {
            addCriterion("confirm_code between", value1, value2, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeNotBetween(String value1, String value2) {
            addCriterion("confirm_code not between", value1, value2, "confirmCode");
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

        public Criteria andConfirmUidIsNull() {
            addCriterion("confirm_uid is null");
            return (Criteria) this;
        }

        public Criteria andConfirmUidIsNotNull() {
            addCriterion("confirm_uid is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmUidEqualTo(Long value) {
            addCriterion("confirm_uid =", value, "confirmUid");
            return (Criteria) this;
        }

        public Criteria andConfirmUidNotEqualTo(Long value) {
            addCriterion("confirm_uid <>", value, "confirmUid");
            return (Criteria) this;
        }

        public Criteria andConfirmUidGreaterThan(Long value) {
            addCriterion("confirm_uid >", value, "confirmUid");
            return (Criteria) this;
        }

        public Criteria andConfirmUidGreaterThanOrEqualTo(Long value) {
            addCriterion("confirm_uid >=", value, "confirmUid");
            return (Criteria) this;
        }

        public Criteria andConfirmUidLessThan(Long value) {
            addCriterion("confirm_uid <", value, "confirmUid");
            return (Criteria) this;
        }

        public Criteria andConfirmUidLessThanOrEqualTo(Long value) {
            addCriterion("confirm_uid <=", value, "confirmUid");
            return (Criteria) this;
        }

        public Criteria andConfirmUidIn(List<Long> values) {
            addCriterion("confirm_uid in", values, "confirmUid");
            return (Criteria) this;
        }

        public Criteria andConfirmUidNotIn(List<Long> values) {
            addCriterion("confirm_uid not in", values, "confirmUid");
            return (Criteria) this;
        }

        public Criteria andConfirmUidBetween(Long value1, Long value2) {
            addCriterion("confirm_uid between", value1, value2, "confirmUid");
            return (Criteria) this;
        }

        public Criteria andConfirmUidNotBetween(Long value1, Long value2) {
            addCriterion("confirm_uid not between", value1, value2, "confirmUid");
            return (Criteria) this;
        }

        public Criteria andIdcardNoIsNull() {
            addCriterion("idcard_no is null");
            return (Criteria) this;
        }

        public Criteria andIdcardNoIsNotNull() {
            addCriterion("idcard_no is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardNoEqualTo(String value) {
            addCriterion("idcard_no =", value, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoNotEqualTo(String value) {
            addCriterion("idcard_no <>", value, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoGreaterThan(String value) {
            addCriterion("idcard_no >", value, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_no >=", value, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoLessThan(String value) {
            addCriterion("idcard_no <", value, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoLessThanOrEqualTo(String value) {
            addCriterion("idcard_no <=", value, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoLike(String value) {
            addCriterion("idcard_no like", value, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoNotLike(String value) {
            addCriterion("idcard_no not like", value, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoIn(List<String> values) {
            addCriterion("idcard_no in", values, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoNotIn(List<String> values) {
            addCriterion("idcard_no not in", values, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoBetween(String value1, String value2) {
            addCriterion("idcard_no between", value1, value2, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoNotBetween(String value1, String value2) {
            addCriterion("idcard_no not between", value1, value2, "idcardNo");
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

        public Criteria andOperatorNameIsNull() {
            addCriterion("operator_name is null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNotNull() {
            addCriterion("operator_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameEqualTo(String value) {
            addCriterion("operator_name =", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotEqualTo(String value) {
            addCriterion("operator_name <>", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThan(String value) {
            addCriterion("operator_name >", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("operator_name >=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThan(String value) {
            addCriterion("operator_name <", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThanOrEqualTo(String value) {
            addCriterion("operator_name <=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLike(String value) {
            addCriterion("operator_name like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotLike(String value) {
            addCriterion("operator_name not like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIn(List<String> values) {
            addCriterion("operator_name in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotIn(List<String> values) {
            addCriterion("operator_name not in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameBetween(String value1, String value2) {
            addCriterion("operator_name between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotBetween(String value1, String value2) {
            addCriterion("operator_name not between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneIsNull() {
            addCriterion("operator_phone is null");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneIsNotNull() {
            addCriterion("operator_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneEqualTo(String value) {
            addCriterion("operator_phone =", value, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneNotEqualTo(String value) {
            addCriterion("operator_phone <>", value, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneGreaterThan(String value) {
            addCriterion("operator_phone >", value, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("operator_phone >=", value, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneLessThan(String value) {
            addCriterion("operator_phone <", value, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneLessThanOrEqualTo(String value) {
            addCriterion("operator_phone <=", value, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneLike(String value) {
            addCriterion("operator_phone like", value, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneNotLike(String value) {
            addCriterion("operator_phone not like", value, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneIn(List<String> values) {
            addCriterion("operator_phone in", values, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneNotIn(List<String> values) {
            addCriterion("operator_phone not in", values, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneBetween(String value1, String value2) {
            addCriterion("operator_phone between", value1, value2, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneNotBetween(String value1, String value2) {
            addCriterion("operator_phone not between", value1, value2, "operatorPhone");
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