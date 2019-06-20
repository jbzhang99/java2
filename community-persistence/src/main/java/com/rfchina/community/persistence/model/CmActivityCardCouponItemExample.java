package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CmActivityCardCouponItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CmActivityCardCouponItemExample() {
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

        public Criteria andCouponNameIsNull() {
            addCriterion("coupon_name is null");
            return (Criteria) this;
        }

        public Criteria andCouponNameIsNotNull() {
            addCriterion("coupon_name is not null");
            return (Criteria) this;
        }

        public Criteria andCouponNameEqualTo(String value) {
            addCriterion("coupon_name =", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotEqualTo(String value) {
            addCriterion("coupon_name <>", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameGreaterThan(String value) {
            addCriterion("coupon_name >", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_name >=", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameLessThan(String value) {
            addCriterion("coupon_name <", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameLessThanOrEqualTo(String value) {
            addCriterion("coupon_name <=", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameLike(String value) {
            addCriterion("coupon_name like", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotLike(String value) {
            addCriterion("coupon_name not like", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameIn(List<String> values) {
            addCriterion("coupon_name in", values, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotIn(List<String> values) {
            addCriterion("coupon_name not in", values, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameBetween(String value1, String value2) {
            addCriterion("coupon_name between", value1, value2, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotBetween(String value1, String value2) {
            addCriterion("coupon_name not between", value1, value2, "couponName");
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

        public Criteria andCouponNumIsNull() {
            addCriterion("coupon_num is null");
            return (Criteria) this;
        }

        public Criteria andCouponNumIsNotNull() {
            addCriterion("coupon_num is not null");
            return (Criteria) this;
        }

        public Criteria andCouponNumEqualTo(Integer value) {
            addCriterion("coupon_num =", value, "couponNum");
            return (Criteria) this;
        }

        public Criteria andCouponNumNotEqualTo(Integer value) {
            addCriterion("coupon_num <>", value, "couponNum");
            return (Criteria) this;
        }

        public Criteria andCouponNumGreaterThan(Integer value) {
            addCriterion("coupon_num >", value, "couponNum");
            return (Criteria) this;
        }

        public Criteria andCouponNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_num >=", value, "couponNum");
            return (Criteria) this;
        }

        public Criteria andCouponNumLessThan(Integer value) {
            addCriterion("coupon_num <", value, "couponNum");
            return (Criteria) this;
        }

        public Criteria andCouponNumLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_num <=", value, "couponNum");
            return (Criteria) this;
        }

        public Criteria andCouponNumIn(List<Integer> values) {
            addCriterion("coupon_num in", values, "couponNum");
            return (Criteria) this;
        }

        public Criteria andCouponNumNotIn(List<Integer> values) {
            addCriterion("coupon_num not in", values, "couponNum");
            return (Criteria) this;
        }

        public Criteria andCouponNumBetween(Integer value1, Integer value2) {
            addCriterion("coupon_num between", value1, value2, "couponNum");
            return (Criteria) this;
        }

        public Criteria andCouponNumNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_num not between", value1, value2, "couponNum");
            return (Criteria) this;
        }

        public Criteria andStockNumIsNull() {
            addCriterion("stock_num is null");
            return (Criteria) this;
        }

        public Criteria andStockNumIsNotNull() {
            addCriterion("stock_num is not null");
            return (Criteria) this;
        }

        public Criteria andStockNumEqualTo(Integer value) {
            addCriterion("stock_num =", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumNotEqualTo(Integer value) {
            addCriterion("stock_num <>", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumGreaterThan(Integer value) {
            addCriterion("stock_num >", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_num >=", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumLessThan(Integer value) {
            addCriterion("stock_num <", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumLessThanOrEqualTo(Integer value) {
            addCriterion("stock_num <=", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumIn(List<Integer> values) {
            addCriterion("stock_num in", values, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumNotIn(List<Integer> values) {
            addCriterion("stock_num not in", values, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumBetween(Integer value1, Integer value2) {
            addCriterion("stock_num between", value1, value2, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_num not between", value1, value2, "stockNum");
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

        public Criteria andAllowFromDateIsNull() {
            addCriterion("allow_from_date is null");
            return (Criteria) this;
        }

        public Criteria andAllowFromDateIsNotNull() {
            addCriterion("allow_from_date is not null");
            return (Criteria) this;
        }

        public Criteria andAllowFromDateEqualTo(Date value) {
            addCriterion("allow_from_date =", value, "allowFromDate");
            return (Criteria) this;
        }

        public Criteria andAllowFromDateNotEqualTo(Date value) {
            addCriterion("allow_from_date <>", value, "allowFromDate");
            return (Criteria) this;
        }

        public Criteria andAllowFromDateGreaterThan(Date value) {
            addCriterion("allow_from_date >", value, "allowFromDate");
            return (Criteria) this;
        }

        public Criteria andAllowFromDateGreaterThanOrEqualTo(Date value) {
            addCriterion("allow_from_date >=", value, "allowFromDate");
            return (Criteria) this;
        }

        public Criteria andAllowFromDateLessThan(Date value) {
            addCriterion("allow_from_date <", value, "allowFromDate");
            return (Criteria) this;
        }

        public Criteria andAllowFromDateLessThanOrEqualTo(Date value) {
            addCriterion("allow_from_date <=", value, "allowFromDate");
            return (Criteria) this;
        }

        public Criteria andAllowFromDateIn(List<Date> values) {
            addCriterion("allow_from_date in", values, "allowFromDate");
            return (Criteria) this;
        }

        public Criteria andAllowFromDateNotIn(List<Date> values) {
            addCriterion("allow_from_date not in", values, "allowFromDate");
            return (Criteria) this;
        }

        public Criteria andAllowFromDateBetween(Date value1, Date value2) {
            addCriterion("allow_from_date between", value1, value2, "allowFromDate");
            return (Criteria) this;
        }

        public Criteria andAllowFromDateNotBetween(Date value1, Date value2) {
            addCriterion("allow_from_date not between", value1, value2, "allowFromDate");
            return (Criteria) this;
        }

        public Criteria andAllowToDateIsNull() {
            addCriterion("allow_to_date is null");
            return (Criteria) this;
        }

        public Criteria andAllowToDateIsNotNull() {
            addCriterion("allow_to_date is not null");
            return (Criteria) this;
        }

        public Criteria andAllowToDateEqualTo(Date value) {
            addCriterion("allow_to_date =", value, "allowToDate");
            return (Criteria) this;
        }

        public Criteria andAllowToDateNotEqualTo(Date value) {
            addCriterion("allow_to_date <>", value, "allowToDate");
            return (Criteria) this;
        }

        public Criteria andAllowToDateGreaterThan(Date value) {
            addCriterion("allow_to_date >", value, "allowToDate");
            return (Criteria) this;
        }

        public Criteria andAllowToDateGreaterThanOrEqualTo(Date value) {
            addCriterion("allow_to_date >=", value, "allowToDate");
            return (Criteria) this;
        }

        public Criteria andAllowToDateLessThan(Date value) {
            addCriterion("allow_to_date <", value, "allowToDate");
            return (Criteria) this;
        }

        public Criteria andAllowToDateLessThanOrEqualTo(Date value) {
            addCriterion("allow_to_date <=", value, "allowToDate");
            return (Criteria) this;
        }

        public Criteria andAllowToDateIn(List<Date> values) {
            addCriterion("allow_to_date in", values, "allowToDate");
            return (Criteria) this;
        }

        public Criteria andAllowToDateNotIn(List<Date> values) {
            addCriterion("allow_to_date not in", values, "allowToDate");
            return (Criteria) this;
        }

        public Criteria andAllowToDateBetween(Date value1, Date value2) {
            addCriterion("allow_to_date between", value1, value2, "allowToDate");
            return (Criteria) this;
        }

        public Criteria andAllowToDateNotBetween(Date value1, Date value2) {
            addCriterion("allow_to_date not between", value1, value2, "allowToDate");
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

        public Criteria andUseRuleIsNull() {
            addCriterion("use_rule is null");
            return (Criteria) this;
        }

        public Criteria andUseRuleIsNotNull() {
            addCriterion("use_rule is not null");
            return (Criteria) this;
        }

        public Criteria andUseRuleEqualTo(String value) {
            addCriterion("use_rule =", value, "useRule");
            return (Criteria) this;
        }

        public Criteria andUseRuleNotEqualTo(String value) {
            addCriterion("use_rule <>", value, "useRule");
            return (Criteria) this;
        }

        public Criteria andUseRuleGreaterThan(String value) {
            addCriterion("use_rule >", value, "useRule");
            return (Criteria) this;
        }

        public Criteria andUseRuleGreaterThanOrEqualTo(String value) {
            addCriterion("use_rule >=", value, "useRule");
            return (Criteria) this;
        }

        public Criteria andUseRuleLessThan(String value) {
            addCriterion("use_rule <", value, "useRule");
            return (Criteria) this;
        }

        public Criteria andUseRuleLessThanOrEqualTo(String value) {
            addCriterion("use_rule <=", value, "useRule");
            return (Criteria) this;
        }

        public Criteria andUseRuleLike(String value) {
            addCriterion("use_rule like", value, "useRule");
            return (Criteria) this;
        }

        public Criteria andUseRuleNotLike(String value) {
            addCriterion("use_rule not like", value, "useRule");
            return (Criteria) this;
        }

        public Criteria andUseRuleIn(List<String> values) {
            addCriterion("use_rule in", values, "useRule");
            return (Criteria) this;
        }

        public Criteria andUseRuleNotIn(List<String> values) {
            addCriterion("use_rule not in", values, "useRule");
            return (Criteria) this;
        }

        public Criteria andUseRuleBetween(String value1, String value2) {
            addCriterion("use_rule between", value1, value2, "useRule");
            return (Criteria) this;
        }

        public Criteria andUseRuleNotBetween(String value1, String value2) {
            addCriterion("use_rule not between", value1, value2, "useRule");
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

        public Criteria andCouponAmountIsNull() {
            addCriterion("coupon_amount is null");
            return (Criteria) this;
        }

        public Criteria andCouponAmountIsNotNull() {
            addCriterion("coupon_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCouponAmountEqualTo(BigDecimal value) {
            addCriterion("coupon_amount =", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountNotEqualTo(BigDecimal value) {
            addCriterion("coupon_amount <>", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountGreaterThan(BigDecimal value) {
            addCriterion("coupon_amount >", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("coupon_amount >=", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountLessThan(BigDecimal value) {
            addCriterion("coupon_amount <", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("coupon_amount <=", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountIn(List<BigDecimal> values) {
            addCriterion("coupon_amount in", values, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountNotIn(List<BigDecimal> values) {
            addCriterion("coupon_amount not in", values, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupon_amount between", value1, value2, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupon_amount not between", value1, value2, "couponAmount");
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

        public Criteria andOpenStatusIsNull() {
            addCriterion("open_status is null");
            return (Criteria) this;
        }

        public Criteria andOpenStatusIsNotNull() {
            addCriterion("open_status is not null");
            return (Criteria) this;
        }

        public Criteria andOpenStatusEqualTo(Integer value) {
            addCriterion("open_status =", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusNotEqualTo(Integer value) {
            addCriterion("open_status <>", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusGreaterThan(Integer value) {
            addCriterion("open_status >", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_status >=", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusLessThan(Integer value) {
            addCriterion("open_status <", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusLessThanOrEqualTo(Integer value) {
            addCriterion("open_status <=", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusIn(List<Integer> values) {
            addCriterion("open_status in", values, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusNotIn(List<Integer> values) {
            addCriterion("open_status not in", values, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusBetween(Integer value1, Integer value2) {
            addCriterion("open_status between", value1, value2, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("open_status not between", value1, value2, "openStatus");
            return (Criteria) this;
        }

        public Criteria andDeliverNumIsNull() {
            addCriterion("deliver_num is null");
            return (Criteria) this;
        }

        public Criteria andDeliverNumIsNotNull() {
            addCriterion("deliver_num is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverNumEqualTo(Integer value) {
            addCriterion("deliver_num =", value, "deliverNum");
            return (Criteria) this;
        }

        public Criteria andDeliverNumNotEqualTo(Integer value) {
            addCriterion("deliver_num <>", value, "deliverNum");
            return (Criteria) this;
        }

        public Criteria andDeliverNumGreaterThan(Integer value) {
            addCriterion("deliver_num >", value, "deliverNum");
            return (Criteria) this;
        }

        public Criteria andDeliverNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("deliver_num >=", value, "deliverNum");
            return (Criteria) this;
        }

        public Criteria andDeliverNumLessThan(Integer value) {
            addCriterion("deliver_num <", value, "deliverNum");
            return (Criteria) this;
        }

        public Criteria andDeliverNumLessThanOrEqualTo(Integer value) {
            addCriterion("deliver_num <=", value, "deliverNum");
            return (Criteria) this;
        }

        public Criteria andDeliverNumIn(List<Integer> values) {
            addCriterion("deliver_num in", values, "deliverNum");
            return (Criteria) this;
        }

        public Criteria andDeliverNumNotIn(List<Integer> values) {
            addCriterion("deliver_num not in", values, "deliverNum");
            return (Criteria) this;
        }

        public Criteria andDeliverNumBetween(Integer value1, Integer value2) {
            addCriterion("deliver_num between", value1, value2, "deliverNum");
            return (Criteria) this;
        }

        public Criteria andDeliverNumNotBetween(Integer value1, Integer value2) {
            addCriterion("deliver_num not between", value1, value2, "deliverNum");
            return (Criteria) this;
        }

        public Criteria andUserLimitIsNull() {
            addCriterion("user_limit is null");
            return (Criteria) this;
        }

        public Criteria andUserLimitIsNotNull() {
            addCriterion("user_limit is not null");
            return (Criteria) this;
        }

        public Criteria andUserLimitEqualTo(Integer value) {
            addCriterion("user_limit =", value, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitNotEqualTo(Integer value) {
            addCriterion("user_limit <>", value, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitGreaterThan(Integer value) {
            addCriterion("user_limit >", value, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_limit >=", value, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitLessThan(Integer value) {
            addCriterion("user_limit <", value, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitLessThanOrEqualTo(Integer value) {
            addCriterion("user_limit <=", value, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitIn(List<Integer> values) {
            addCriterion("user_limit in", values, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitNotIn(List<Integer> values) {
            addCriterion("user_limit not in", values, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitBetween(Integer value1, Integer value2) {
            addCriterion("user_limit between", value1, value2, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("user_limit not between", value1, value2, "userLimit");
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