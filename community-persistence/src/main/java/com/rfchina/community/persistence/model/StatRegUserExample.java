package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatRegUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatRegUserExample() {
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

        public Criteria andStatTimeIsNull() {
            addCriterion("stat_time is null");
            return (Criteria) this;
        }

        public Criteria andStatTimeIsNotNull() {
            addCriterion("stat_time is not null");
            return (Criteria) this;
        }

        public Criteria andStatTimeEqualTo(Date value) {
            addCriterion("stat_time =", value, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeNotEqualTo(Date value) {
            addCriterion("stat_time <>", value, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeGreaterThan(Date value) {
            addCriterion("stat_time >", value, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stat_time >=", value, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeLessThan(Date value) {
            addCriterion("stat_time <", value, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeLessThanOrEqualTo(Date value) {
            addCriterion("stat_time <=", value, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeIn(List<Date> values) {
            addCriterion("stat_time in", values, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeNotIn(List<Date> values) {
            addCriterion("stat_time not in", values, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeBetween(Date value1, Date value2) {
            addCriterion("stat_time between", value1, value2, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeNotBetween(Date value1, Date value2) {
            addCriterion("stat_time not between", value1, value2, "statTime");
            return (Criteria) this;
        }

        public Criteria andAccCountIsNull() {
            addCriterion("acc_count is null");
            return (Criteria) this;
        }

        public Criteria andAccCountIsNotNull() {
            addCriterion("acc_count is not null");
            return (Criteria) this;
        }

        public Criteria andAccCountEqualTo(Integer value) {
            addCriterion("acc_count =", value, "accCount");
            return (Criteria) this;
        }

        public Criteria andAccCountNotEqualTo(Integer value) {
            addCriterion("acc_count <>", value, "accCount");
            return (Criteria) this;
        }

        public Criteria andAccCountGreaterThan(Integer value) {
            addCriterion("acc_count >", value, "accCount");
            return (Criteria) this;
        }

        public Criteria andAccCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("acc_count >=", value, "accCount");
            return (Criteria) this;
        }

        public Criteria andAccCountLessThan(Integer value) {
            addCriterion("acc_count <", value, "accCount");
            return (Criteria) this;
        }

        public Criteria andAccCountLessThanOrEqualTo(Integer value) {
            addCriterion("acc_count <=", value, "accCount");
            return (Criteria) this;
        }

        public Criteria andAccCountIn(List<Integer> values) {
            addCriterion("acc_count in", values, "accCount");
            return (Criteria) this;
        }

        public Criteria andAccCountNotIn(List<Integer> values) {
            addCriterion("acc_count not in", values, "accCount");
            return (Criteria) this;
        }

        public Criteria andAccCountBetween(Integer value1, Integer value2) {
            addCriterion("acc_count between", value1, value2, "accCount");
            return (Criteria) this;
        }

        public Criteria andAccCountNotBetween(Integer value1, Integer value2) {
            addCriterion("acc_count not between", value1, value2, "accCount");
            return (Criteria) this;
        }

        public Criteria andAppCountIsNull() {
            addCriterion("app_count is null");
            return (Criteria) this;
        }

        public Criteria andAppCountIsNotNull() {
            addCriterion("app_count is not null");
            return (Criteria) this;
        }

        public Criteria andAppCountEqualTo(Integer value) {
            addCriterion("app_count =", value, "appCount");
            return (Criteria) this;
        }

        public Criteria andAppCountNotEqualTo(Integer value) {
            addCriterion("app_count <>", value, "appCount");
            return (Criteria) this;
        }

        public Criteria andAppCountGreaterThan(Integer value) {
            addCriterion("app_count >", value, "appCount");
            return (Criteria) this;
        }

        public Criteria andAppCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_count >=", value, "appCount");
            return (Criteria) this;
        }

        public Criteria andAppCountLessThan(Integer value) {
            addCriterion("app_count <", value, "appCount");
            return (Criteria) this;
        }

        public Criteria andAppCountLessThanOrEqualTo(Integer value) {
            addCriterion("app_count <=", value, "appCount");
            return (Criteria) this;
        }

        public Criteria andAppCountIn(List<Integer> values) {
            addCriterion("app_count in", values, "appCount");
            return (Criteria) this;
        }

        public Criteria andAppCountNotIn(List<Integer> values) {
            addCriterion("app_count not in", values, "appCount");
            return (Criteria) this;
        }

        public Criteria andAppCountBetween(Integer value1, Integer value2) {
            addCriterion("app_count between", value1, value2, "appCount");
            return (Criteria) this;
        }

        public Criteria andAppCountNotBetween(Integer value1, Integer value2) {
            addCriterion("app_count not between", value1, value2, "appCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountIsNull() {
            addCriterion("other_count is null");
            return (Criteria) this;
        }

        public Criteria andOtherCountIsNotNull() {
            addCriterion("other_count is not null");
            return (Criteria) this;
        }

        public Criteria andOtherCountEqualTo(Integer value) {
            addCriterion("other_count =", value, "otherCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountNotEqualTo(Integer value) {
            addCriterion("other_count <>", value, "otherCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountGreaterThan(Integer value) {
            addCriterion("other_count >", value, "otherCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("other_count >=", value, "otherCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountLessThan(Integer value) {
            addCriterion("other_count <", value, "otherCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountLessThanOrEqualTo(Integer value) {
            addCriterion("other_count <=", value, "otherCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountIn(List<Integer> values) {
            addCriterion("other_count in", values, "otherCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountNotIn(List<Integer> values) {
            addCriterion("other_count not in", values, "otherCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountBetween(Integer value1, Integer value2) {
            addCriterion("other_count between", value1, value2, "otherCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountNotBetween(Integer value1, Integer value2) {
            addCriterion("other_count not between", value1, value2, "otherCount");
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