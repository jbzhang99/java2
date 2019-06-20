package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenXFSJBusinessInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenXFSJBusinessInfoExample() {
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

        public Criteria andServiceFeeIsNull() {
            addCriterion("service_fee is null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIsNotNull() {
            addCriterion("service_fee is not null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeEqualTo(BigDecimal value) {
            addCriterion("service_fee =", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotEqualTo(BigDecimal value) {
            addCriterion("service_fee <>", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThan(BigDecimal value) {
            addCriterion("service_fee >", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("service_fee >=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThan(BigDecimal value) {
            addCriterion("service_fee <", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("service_fee <=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIn(List<BigDecimal> values) {
            addCriterion("service_fee in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotIn(List<BigDecimal> values) {
            addCriterion("service_fee not in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_fee between", value1, value2, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_fee not between", value1, value2, "serviceFee");
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

        public Criteria andContactPhoneIsNull() {
            addCriterion("contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("contact_phone =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("contact_phone <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("contact_phone >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_phone >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("contact_phone <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("contact_phone <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("contact_phone like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("contact_phone not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("contact_phone in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("contact_phone not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("contact_phone between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("contact_phone not between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andSignUpEndTimeIsNull() {
            addCriterion("sign_up_end_time is null");
            return (Criteria) this;
        }

        public Criteria andSignUpEndTimeIsNotNull() {
            addCriterion("sign_up_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andSignUpEndTimeEqualTo(Date value) {
            addCriterion("sign_up_end_time =", value, "signUpEndTime");
            return (Criteria) this;
        }

        public Criteria andSignUpEndTimeNotEqualTo(Date value) {
            addCriterion("sign_up_end_time <>", value, "signUpEndTime");
            return (Criteria) this;
        }

        public Criteria andSignUpEndTimeGreaterThan(Date value) {
            addCriterion("sign_up_end_time >", value, "signUpEndTime");
            return (Criteria) this;
        }

        public Criteria andSignUpEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sign_up_end_time >=", value, "signUpEndTime");
            return (Criteria) this;
        }

        public Criteria andSignUpEndTimeLessThan(Date value) {
            addCriterion("sign_up_end_time <", value, "signUpEndTime");
            return (Criteria) this;
        }

        public Criteria andSignUpEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("sign_up_end_time <=", value, "signUpEndTime");
            return (Criteria) this;
        }

        public Criteria andSignUpEndTimeIn(List<Date> values) {
            addCriterion("sign_up_end_time in", values, "signUpEndTime");
            return (Criteria) this;
        }

        public Criteria andSignUpEndTimeNotIn(List<Date> values) {
            addCriterion("sign_up_end_time not in", values, "signUpEndTime");
            return (Criteria) this;
        }

        public Criteria andSignUpEndTimeBetween(Date value1, Date value2) {
            addCriterion("sign_up_end_time between", value1, value2, "signUpEndTime");
            return (Criteria) this;
        }

        public Criteria andSignUpEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("sign_up_end_time not between", value1, value2, "signUpEndTime");
            return (Criteria) this;
        }

        public Criteria andSignUpStatusIsNull() {
            addCriterion("sign_up_status is null");
            return (Criteria) this;
        }

        public Criteria andSignUpStatusIsNotNull() {
            addCriterion("sign_up_status is not null");
            return (Criteria) this;
        }

        public Criteria andSignUpStatusEqualTo(Integer value) {
            addCriterion("sign_up_status =", value, "signUpStatus");
            return (Criteria) this;
        }

        public Criteria andSignUpStatusNotEqualTo(Integer value) {
            addCriterion("sign_up_status <>", value, "signUpStatus");
            return (Criteria) this;
        }

        public Criteria andSignUpStatusGreaterThan(Integer value) {
            addCriterion("sign_up_status >", value, "signUpStatus");
            return (Criteria) this;
        }

        public Criteria andSignUpStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign_up_status >=", value, "signUpStatus");
            return (Criteria) this;
        }

        public Criteria andSignUpStatusLessThan(Integer value) {
            addCriterion("sign_up_status <", value, "signUpStatus");
            return (Criteria) this;
        }

        public Criteria andSignUpStatusLessThanOrEqualTo(Integer value) {
            addCriterion("sign_up_status <=", value, "signUpStatus");
            return (Criteria) this;
        }

        public Criteria andSignUpStatusIn(List<Integer> values) {
            addCriterion("sign_up_status in", values, "signUpStatus");
            return (Criteria) this;
        }

        public Criteria andSignUpStatusNotIn(List<Integer> values) {
            addCriterion("sign_up_status not in", values, "signUpStatus");
            return (Criteria) this;
        }

        public Criteria andSignUpStatusBetween(Integer value1, Integer value2) {
            addCriterion("sign_up_status between", value1, value2, "signUpStatus");
            return (Criteria) this;
        }

        public Criteria andSignUpStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("sign_up_status not between", value1, value2, "signUpStatus");
            return (Criteria) this;
        }

        public Criteria andLocaleDetailIsNull() {
            addCriterion("locale_detail is null");
            return (Criteria) this;
        }

        public Criteria andLocaleDetailIsNotNull() {
            addCriterion("locale_detail is not null");
            return (Criteria) this;
        }

        public Criteria andLocaleDetailEqualTo(String value) {
            addCriterion("locale_detail =", value, "localeDetail");
            return (Criteria) this;
        }

        public Criteria andLocaleDetailNotEqualTo(String value) {
            addCriterion("locale_detail <>", value, "localeDetail");
            return (Criteria) this;
        }

        public Criteria andLocaleDetailGreaterThan(String value) {
            addCriterion("locale_detail >", value, "localeDetail");
            return (Criteria) this;
        }

        public Criteria andLocaleDetailGreaterThanOrEqualTo(String value) {
            addCriterion("locale_detail >=", value, "localeDetail");
            return (Criteria) this;
        }

        public Criteria andLocaleDetailLessThan(String value) {
            addCriterion("locale_detail <", value, "localeDetail");
            return (Criteria) this;
        }

        public Criteria andLocaleDetailLessThanOrEqualTo(String value) {
            addCriterion("locale_detail <=", value, "localeDetail");
            return (Criteria) this;
        }

        public Criteria andLocaleDetailLike(String value) {
            addCriterion("locale_detail like", value, "localeDetail");
            return (Criteria) this;
        }

        public Criteria andLocaleDetailNotLike(String value) {
            addCriterion("locale_detail not like", value, "localeDetail");
            return (Criteria) this;
        }

        public Criteria andLocaleDetailIn(List<String> values) {
            addCriterion("locale_detail in", values, "localeDetail");
            return (Criteria) this;
        }

        public Criteria andLocaleDetailNotIn(List<String> values) {
            addCriterion("locale_detail not in", values, "localeDetail");
            return (Criteria) this;
        }

        public Criteria andLocaleDetailBetween(String value1, String value2) {
            addCriterion("locale_detail between", value1, value2, "localeDetail");
            return (Criteria) this;
        }

        public Criteria andLocaleDetailNotBetween(String value1, String value2) {
            addCriterion("locale_detail not between", value1, value2, "localeDetail");
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