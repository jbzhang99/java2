package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.List;

public class ResourcePatrolResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourcePatrolResultExample() {
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

        public Criteria andPatrolIdIsNull() {
            addCriterion("patrol_id is null");
            return (Criteria) this;
        }

        public Criteria andPatrolIdIsNotNull() {
            addCriterion("patrol_id is not null");
            return (Criteria) this;
        }

        public Criteria andPatrolIdEqualTo(Long value) {
            addCriterion("patrol_id =", value, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolIdNotEqualTo(Long value) {
            addCriterion("patrol_id <>", value, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolIdGreaterThan(Long value) {
            addCriterion("patrol_id >", value, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolIdGreaterThanOrEqualTo(Long value) {
            addCriterion("patrol_id >=", value, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolIdLessThan(Long value) {
            addCriterion("patrol_id <", value, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolIdLessThanOrEqualTo(Long value) {
            addCriterion("patrol_id <=", value, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolIdIn(List<Long> values) {
            addCriterion("patrol_id in", values, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolIdNotIn(List<Long> values) {
            addCriterion("patrol_id not in", values, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolIdBetween(Long value1, Long value2) {
            addCriterion("patrol_id between", value1, value2, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolIdNotBetween(Long value1, Long value2) {
            addCriterion("patrol_id not between", value1, value2, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolTypeIsNull() {
            addCriterion("patrol_type is null");
            return (Criteria) this;
        }

        public Criteria andPatrolTypeIsNotNull() {
            addCriterion("patrol_type is not null");
            return (Criteria) this;
        }

        public Criteria andPatrolTypeEqualTo(Integer value) {
            addCriterion("patrol_type =", value, "patrolType");
            return (Criteria) this;
        }

        public Criteria andPatrolTypeNotEqualTo(Integer value) {
            addCriterion("patrol_type <>", value, "patrolType");
            return (Criteria) this;
        }

        public Criteria andPatrolTypeGreaterThan(Integer value) {
            addCriterion("patrol_type >", value, "patrolType");
            return (Criteria) this;
        }

        public Criteria andPatrolTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("patrol_type >=", value, "patrolType");
            return (Criteria) this;
        }

        public Criteria andPatrolTypeLessThan(Integer value) {
            addCriterion("patrol_type <", value, "patrolType");
            return (Criteria) this;
        }

        public Criteria andPatrolTypeLessThanOrEqualTo(Integer value) {
            addCriterion("patrol_type <=", value, "patrolType");
            return (Criteria) this;
        }

        public Criteria andPatrolTypeIn(List<Integer> values) {
            addCriterion("patrol_type in", values, "patrolType");
            return (Criteria) this;
        }

        public Criteria andPatrolTypeNotIn(List<Integer> values) {
            addCriterion("patrol_type not in", values, "patrolType");
            return (Criteria) this;
        }

        public Criteria andPatrolTypeBetween(Integer value1, Integer value2) {
            addCriterion("patrol_type between", value1, value2, "patrolType");
            return (Criteria) this;
        }

        public Criteria andPatrolTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("patrol_type not between", value1, value2, "patrolType");
            return (Criteria) this;
        }

        public Criteria andPatrolResultIsNull() {
            addCriterion("patrol_result is null");
            return (Criteria) this;
        }

        public Criteria andPatrolResultIsNotNull() {
            addCriterion("patrol_result is not null");
            return (Criteria) this;
        }

        public Criteria andPatrolResultEqualTo(String value) {
            addCriterion("patrol_result =", value, "patrolResult");
            return (Criteria) this;
        }

        public Criteria andPatrolResultNotEqualTo(String value) {
            addCriterion("patrol_result <>", value, "patrolResult");
            return (Criteria) this;
        }

        public Criteria andPatrolResultGreaterThan(String value) {
            addCriterion("patrol_result >", value, "patrolResult");
            return (Criteria) this;
        }

        public Criteria andPatrolResultGreaterThanOrEqualTo(String value) {
            addCriterion("patrol_result >=", value, "patrolResult");
            return (Criteria) this;
        }

        public Criteria andPatrolResultLessThan(String value) {
            addCriterion("patrol_result <", value, "patrolResult");
            return (Criteria) this;
        }

        public Criteria andPatrolResultLessThanOrEqualTo(String value) {
            addCriterion("patrol_result <=", value, "patrolResult");
            return (Criteria) this;
        }

        public Criteria andPatrolResultLike(String value) {
            addCriterion("patrol_result like", value, "patrolResult");
            return (Criteria) this;
        }

        public Criteria andPatrolResultNotLike(String value) {
            addCriterion("patrol_result not like", value, "patrolResult");
            return (Criteria) this;
        }

        public Criteria andPatrolResultIn(List<String> values) {
            addCriterion("patrol_result in", values, "patrolResult");
            return (Criteria) this;
        }

        public Criteria andPatrolResultNotIn(List<String> values) {
            addCriterion("patrol_result not in", values, "patrolResult");
            return (Criteria) this;
        }

        public Criteria andPatrolResultBetween(String value1, String value2) {
            addCriterion("patrol_result between", value1, value2, "patrolResult");
            return (Criteria) this;
        }

        public Criteria andPatrolResultNotBetween(String value1, String value2) {
            addCriterion("patrol_result not between", value1, value2, "patrolResult");
            return (Criteria) this;
        }

        public Criteria andPatrolImgIsNull() {
            addCriterion("patrol_img is null");
            return (Criteria) this;
        }

        public Criteria andPatrolImgIsNotNull() {
            addCriterion("patrol_img is not null");
            return (Criteria) this;
        }

        public Criteria andPatrolImgEqualTo(String value) {
            addCriterion("patrol_img =", value, "patrolImg");
            return (Criteria) this;
        }

        public Criteria andPatrolImgNotEqualTo(String value) {
            addCriterion("patrol_img <>", value, "patrolImg");
            return (Criteria) this;
        }

        public Criteria andPatrolImgGreaterThan(String value) {
            addCriterion("patrol_img >", value, "patrolImg");
            return (Criteria) this;
        }

        public Criteria andPatrolImgGreaterThanOrEqualTo(String value) {
            addCriterion("patrol_img >=", value, "patrolImg");
            return (Criteria) this;
        }

        public Criteria andPatrolImgLessThan(String value) {
            addCriterion("patrol_img <", value, "patrolImg");
            return (Criteria) this;
        }

        public Criteria andPatrolImgLessThanOrEqualTo(String value) {
            addCriterion("patrol_img <=", value, "patrolImg");
            return (Criteria) this;
        }

        public Criteria andPatrolImgLike(String value) {
            addCriterion("patrol_img like", value, "patrolImg");
            return (Criteria) this;
        }

        public Criteria andPatrolImgNotLike(String value) {
            addCriterion("patrol_img not like", value, "patrolImg");
            return (Criteria) this;
        }

        public Criteria andPatrolImgIn(List<String> values) {
            addCriterion("patrol_img in", values, "patrolImg");
            return (Criteria) this;
        }

        public Criteria andPatrolImgNotIn(List<String> values) {
            addCriterion("patrol_img not in", values, "patrolImg");
            return (Criteria) this;
        }

        public Criteria andPatrolImgBetween(String value1, String value2) {
            addCriterion("patrol_img between", value1, value2, "patrolImg");
            return (Criteria) this;
        }

        public Criteria andPatrolImgNotBetween(String value1, String value2) {
            addCriterion("patrol_img not between", value1, value2, "patrolImg");
            return (Criteria) this;
        }

        public Criteria andPatrolDetailIsNull() {
            addCriterion("patrol_detail is null");
            return (Criteria) this;
        }

        public Criteria andPatrolDetailIsNotNull() {
            addCriterion("patrol_detail is not null");
            return (Criteria) this;
        }

        public Criteria andPatrolDetailEqualTo(String value) {
            addCriterion("patrol_detail =", value, "patrolDetail");
            return (Criteria) this;
        }

        public Criteria andPatrolDetailNotEqualTo(String value) {
            addCriterion("patrol_detail <>", value, "patrolDetail");
            return (Criteria) this;
        }

        public Criteria andPatrolDetailGreaterThan(String value) {
            addCriterion("patrol_detail >", value, "patrolDetail");
            return (Criteria) this;
        }

        public Criteria andPatrolDetailGreaterThanOrEqualTo(String value) {
            addCriterion("patrol_detail >=", value, "patrolDetail");
            return (Criteria) this;
        }

        public Criteria andPatrolDetailLessThan(String value) {
            addCriterion("patrol_detail <", value, "patrolDetail");
            return (Criteria) this;
        }

        public Criteria andPatrolDetailLessThanOrEqualTo(String value) {
            addCriterion("patrol_detail <=", value, "patrolDetail");
            return (Criteria) this;
        }

        public Criteria andPatrolDetailLike(String value) {
            addCriterion("patrol_detail like", value, "patrolDetail");
            return (Criteria) this;
        }

        public Criteria andPatrolDetailNotLike(String value) {
            addCriterion("patrol_detail not like", value, "patrolDetail");
            return (Criteria) this;
        }

        public Criteria andPatrolDetailIn(List<String> values) {
            addCriterion("patrol_detail in", values, "patrolDetail");
            return (Criteria) this;
        }

        public Criteria andPatrolDetailNotIn(List<String> values) {
            addCriterion("patrol_detail not in", values, "patrolDetail");
            return (Criteria) this;
        }

        public Criteria andPatrolDetailBetween(String value1, String value2) {
            addCriterion("patrol_detail between", value1, value2, "patrolDetail");
            return (Criteria) this;
        }

        public Criteria andPatrolDetailNotBetween(String value1, String value2) {
            addCriterion("patrol_detail not between", value1, value2, "patrolDetail");
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