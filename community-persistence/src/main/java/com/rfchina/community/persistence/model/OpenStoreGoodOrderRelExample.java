package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenStoreGoodOrderRelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenStoreGoodOrderRelExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andGoodIdIsNull() {
            addCriterion("good_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodIdIsNotNull() {
            addCriterion("good_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodIdEqualTo(Integer value) {
            addCriterion("good_id =", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotEqualTo(Integer value) {
            addCriterion("good_id <>", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdGreaterThan(Integer value) {
            addCriterion("good_id >", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("good_id >=", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLessThan(Integer value) {
            addCriterion("good_id <", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLessThanOrEqualTo(Integer value) {
            addCriterion("good_id <=", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdIn(List<Integer> values) {
            addCriterion("good_id in", values, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotIn(List<Integer> values) {
            addCriterion("good_id not in", values, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdBetween(Integer value1, Integer value2) {
            addCriterion("good_id between", value1, value2, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotBetween(Integer value1, Integer value2) {
            addCriterion("good_id not between", value1, value2, "goodId");
            return (Criteria) this;
        }

        public Criteria andCurrentSinglePriceIsNull() {
            addCriterion("current_single_price is null");
            return (Criteria) this;
        }

        public Criteria andCurrentSinglePriceIsNotNull() {
            addCriterion("current_single_price is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentSinglePriceEqualTo(BigDecimal value) {
            addCriterion("current_single_price =", value, "currentSinglePrice");
            return (Criteria) this;
        }

        public Criteria andCurrentSinglePriceNotEqualTo(BigDecimal value) {
            addCriterion("current_single_price <>", value, "currentSinglePrice");
            return (Criteria) this;
        }

        public Criteria andCurrentSinglePriceGreaterThan(BigDecimal value) {
            addCriterion("current_single_price >", value, "currentSinglePrice");
            return (Criteria) this;
        }

        public Criteria andCurrentSinglePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("current_single_price >=", value, "currentSinglePrice");
            return (Criteria) this;
        }

        public Criteria andCurrentSinglePriceLessThan(BigDecimal value) {
            addCriterion("current_single_price <", value, "currentSinglePrice");
            return (Criteria) this;
        }

        public Criteria andCurrentSinglePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("current_single_price <=", value, "currentSinglePrice");
            return (Criteria) this;
        }

        public Criteria andCurrentSinglePriceIn(List<BigDecimal> values) {
            addCriterion("current_single_price in", values, "currentSinglePrice");
            return (Criteria) this;
        }

        public Criteria andCurrentSinglePriceNotIn(List<BigDecimal> values) {
            addCriterion("current_single_price not in", values, "currentSinglePrice");
            return (Criteria) this;
        }

        public Criteria andCurrentSinglePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_single_price between", value1, value2, "currentSinglePrice");
            return (Criteria) this;
        }

        public Criteria andCurrentSinglePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_single_price not between", value1, value2, "currentSinglePrice");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andGoodNameIsNull() {
            addCriterion("good_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodNameIsNotNull() {
            addCriterion("good_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodNameEqualTo(String value) {
            addCriterion("good_name =", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotEqualTo(String value) {
            addCriterion("good_name <>", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameGreaterThan(String value) {
            addCriterion("good_name >", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameGreaterThanOrEqualTo(String value) {
            addCriterion("good_name >=", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLessThan(String value) {
            addCriterion("good_name <", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLessThanOrEqualTo(String value) {
            addCriterion("good_name <=", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLike(String value) {
            addCriterion("good_name like", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotLike(String value) {
            addCriterion("good_name not like", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameIn(List<String> values) {
            addCriterion("good_name in", values, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotIn(List<String> values) {
            addCriterion("good_name not in", values, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameBetween(String value1, String value2) {
            addCriterion("good_name between", value1, value2, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotBetween(String value1, String value2) {
            addCriterion("good_name not between", value1, value2, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodCodeIsNull() {
            addCriterion("good_code is null");
            return (Criteria) this;
        }

        public Criteria andGoodCodeIsNotNull() {
            addCriterion("good_code is not null");
            return (Criteria) this;
        }

        public Criteria andGoodCodeEqualTo(String value) {
            addCriterion("good_code =", value, "goodCode");
            return (Criteria) this;
        }

        public Criteria andGoodCodeNotEqualTo(String value) {
            addCriterion("good_code <>", value, "goodCode");
            return (Criteria) this;
        }

        public Criteria andGoodCodeGreaterThan(String value) {
            addCriterion("good_code >", value, "goodCode");
            return (Criteria) this;
        }

        public Criteria andGoodCodeGreaterThanOrEqualTo(String value) {
            addCriterion("good_code >=", value, "goodCode");
            return (Criteria) this;
        }

        public Criteria andGoodCodeLessThan(String value) {
            addCriterion("good_code <", value, "goodCode");
            return (Criteria) this;
        }

        public Criteria andGoodCodeLessThanOrEqualTo(String value) {
            addCriterion("good_code <=", value, "goodCode");
            return (Criteria) this;
        }

        public Criteria andGoodCodeLike(String value) {
            addCriterion("good_code like", value, "goodCode");
            return (Criteria) this;
        }

        public Criteria andGoodCodeNotLike(String value) {
            addCriterion("good_code not like", value, "goodCode");
            return (Criteria) this;
        }

        public Criteria andGoodCodeIn(List<String> values) {
            addCriterion("good_code in", values, "goodCode");
            return (Criteria) this;
        }

        public Criteria andGoodCodeNotIn(List<String> values) {
            addCriterion("good_code not in", values, "goodCode");
            return (Criteria) this;
        }

        public Criteria andGoodCodeBetween(String value1, String value2) {
            addCriterion("good_code between", value1, value2, "goodCode");
            return (Criteria) this;
        }

        public Criteria andGoodCodeNotBetween(String value1, String value2) {
            addCriterion("good_code not between", value1, value2, "goodCode");
            return (Criteria) this;
        }

        public Criteria andGoodImgUrlIsNull() {
            addCriterion("good_img_url is null");
            return (Criteria) this;
        }

        public Criteria andGoodImgUrlIsNotNull() {
            addCriterion("good_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andGoodImgUrlEqualTo(String value) {
            addCriterion("good_img_url =", value, "goodImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodImgUrlNotEqualTo(String value) {
            addCriterion("good_img_url <>", value, "goodImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodImgUrlGreaterThan(String value) {
            addCriterion("good_img_url >", value, "goodImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("good_img_url >=", value, "goodImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodImgUrlLessThan(String value) {
            addCriterion("good_img_url <", value, "goodImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodImgUrlLessThanOrEqualTo(String value) {
            addCriterion("good_img_url <=", value, "goodImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodImgUrlLike(String value) {
            addCriterion("good_img_url like", value, "goodImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodImgUrlNotLike(String value) {
            addCriterion("good_img_url not like", value, "goodImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodImgUrlIn(List<String> values) {
            addCriterion("good_img_url in", values, "goodImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodImgUrlNotIn(List<String> values) {
            addCriterion("good_img_url not in", values, "goodImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodImgUrlBetween(String value1, String value2) {
            addCriterion("good_img_url between", value1, value2, "goodImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodImgUrlNotBetween(String value1, String value2) {
            addCriterion("good_img_url not between", value1, value2, "goodImgUrl");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesIsNull() {
            addCriterion("verify_times is null");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesIsNotNull() {
            addCriterion("verify_times is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesEqualTo(Integer value) {
            addCriterion("verify_times =", value, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesNotEqualTo(Integer value) {
            addCriterion("verify_times <>", value, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesGreaterThan(Integer value) {
            addCriterion("verify_times >", value, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("verify_times >=", value, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesLessThan(Integer value) {
            addCriterion("verify_times <", value, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesLessThanOrEqualTo(Integer value) {
            addCriterion("verify_times <=", value, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesIn(List<Integer> values) {
            addCriterion("verify_times in", values, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesNotIn(List<Integer> values) {
            addCriterion("verify_times not in", values, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesBetween(Integer value1, Integer value2) {
            addCriterion("verify_times between", value1, value2, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("verify_times not between", value1, value2, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeIsNull() {
            addCriterion("verify_start_time is null");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeIsNotNull() {
            addCriterion("verify_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeEqualTo(Date value) {
            addCriterion("verify_start_time =", value, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeNotEqualTo(Date value) {
            addCriterion("verify_start_time <>", value, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeGreaterThan(Date value) {
            addCriterion("verify_start_time >", value, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("verify_start_time >=", value, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeLessThan(Date value) {
            addCriterion("verify_start_time <", value, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("verify_start_time <=", value, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeIn(List<Date> values) {
            addCriterion("verify_start_time in", values, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeNotIn(List<Date> values) {
            addCriterion("verify_start_time not in", values, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeBetween(Date value1, Date value2) {
            addCriterion("verify_start_time between", value1, value2, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("verify_start_time not between", value1, value2, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeIsNull() {
            addCriterion("verify_end_time is null");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeIsNotNull() {
            addCriterion("verify_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeEqualTo(Date value) {
            addCriterion("verify_end_time =", value, "verifyEndTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeNotEqualTo(Date value) {
            addCriterion("verify_end_time <>", value, "verifyEndTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeGreaterThan(Date value) {
            addCriterion("verify_end_time >", value, "verifyEndTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("verify_end_time >=", value, "verifyEndTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeLessThan(Date value) {
            addCriterion("verify_end_time <", value, "verifyEndTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("verify_end_time <=", value, "verifyEndTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeIn(List<Date> values) {
            addCriterion("verify_end_time in", values, "verifyEndTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeNotIn(List<Date> values) {
            addCriterion("verify_end_time not in", values, "verifyEndTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeBetween(Date value1, Date value2) {
            addCriterion("verify_end_time between", value1, value2, "verifyEndTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("verify_end_time not between", value1, value2, "verifyEndTime");
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