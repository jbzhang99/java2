package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.List;

public class VenuePriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VenuePriceExample() {
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

        public Criteria andVenueIdIsNull() {
            addCriterion("venue_id is null");
            return (Criteria) this;
        }

        public Criteria andVenueIdIsNotNull() {
            addCriterion("venue_id is not null");
            return (Criteria) this;
        }

        public Criteria andVenueIdEqualTo(Long value) {
            addCriterion("venue_id =", value, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdNotEqualTo(Long value) {
            addCriterion("venue_id <>", value, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdGreaterThan(Long value) {
            addCriterion("venue_id >", value, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdGreaterThanOrEqualTo(Long value) {
            addCriterion("venue_id >=", value, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdLessThan(Long value) {
            addCriterion("venue_id <", value, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdLessThanOrEqualTo(Long value) {
            addCriterion("venue_id <=", value, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdIn(List<Long> values) {
            addCriterion("venue_id in", values, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdNotIn(List<Long> values) {
            addCriterion("venue_id not in", values, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdBetween(Long value1, Long value2) {
            addCriterion("venue_id between", value1, value2, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdNotBetween(Long value1, Long value2) {
            addCriterion("venue_id not between", value1, value2, "venueId");
            return (Criteria) this;
        }

        public Criteria andWeekIsNull() {
            addCriterion("week is null");
            return (Criteria) this;
        }

        public Criteria andWeekIsNotNull() {
            addCriterion("week is not null");
            return (Criteria) this;
        }

        public Criteria andWeekEqualTo(Integer value) {
            addCriterion("week =", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotEqualTo(Integer value) {
            addCriterion("week <>", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThan(Integer value) {
            addCriterion("week >", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThanOrEqualTo(Integer value) {
            addCriterion("week >=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThan(Integer value) {
            addCriterion("week <", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThanOrEqualTo(Integer value) {
            addCriterion("week <=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekIn(List<Integer> values) {
            addCriterion("week in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotIn(List<Integer> values) {
            addCriterion("week not in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekBetween(Integer value1, Integer value2) {
            addCriterion("week between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotBetween(Integer value1, Integer value2) {
            addCriterion("week not between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andTimeSliceIsNull() {
            addCriterion("time_slice is null");
            return (Criteria) this;
        }

        public Criteria andTimeSliceIsNotNull() {
            addCriterion("time_slice is not null");
            return (Criteria) this;
        }

        public Criteria andTimeSliceEqualTo(String value) {
            addCriterion("time_slice =", value, "timeSlice");
            return (Criteria) this;
        }

        public Criteria andTimeSliceNotEqualTo(String value) {
            addCriterion("time_slice <>", value, "timeSlice");
            return (Criteria) this;
        }

        public Criteria andTimeSliceGreaterThan(String value) {
            addCriterion("time_slice >", value, "timeSlice");
            return (Criteria) this;
        }

        public Criteria andTimeSliceGreaterThanOrEqualTo(String value) {
            addCriterion("time_slice >=", value, "timeSlice");
            return (Criteria) this;
        }

        public Criteria andTimeSliceLessThan(String value) {
            addCriterion("time_slice <", value, "timeSlice");
            return (Criteria) this;
        }

        public Criteria andTimeSliceLessThanOrEqualTo(String value) {
            addCriterion("time_slice <=", value, "timeSlice");
            return (Criteria) this;
        }

        public Criteria andTimeSliceLike(String value) {
            addCriterion("time_slice like", value, "timeSlice");
            return (Criteria) this;
        }

        public Criteria andTimeSliceNotLike(String value) {
            addCriterion("time_slice not like", value, "timeSlice");
            return (Criteria) this;
        }

        public Criteria andTimeSliceIn(List<String> values) {
            addCriterion("time_slice in", values, "timeSlice");
            return (Criteria) this;
        }

        public Criteria andTimeSliceNotIn(List<String> values) {
            addCriterion("time_slice not in", values, "timeSlice");
            return (Criteria) this;
        }

        public Criteria andTimeSliceBetween(String value1, String value2) {
            addCriterion("time_slice between", value1, value2, "timeSlice");
            return (Criteria) this;
        }

        public Criteria andTimeSliceNotBetween(String value1, String value2) {
            addCriterion("time_slice not between", value1, value2, "timeSlice");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
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