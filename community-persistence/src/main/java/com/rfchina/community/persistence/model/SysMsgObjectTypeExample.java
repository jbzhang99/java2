package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.List;

public class SysMsgObjectTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysMsgObjectTypeExample() {
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

        public Criteria andOtObjectTypeIsNull() {
            addCriterion("ot_object_type is null");
            return (Criteria) this;
        }

        public Criteria andOtObjectTypeIsNotNull() {
            addCriterion("ot_object_type is not null");
            return (Criteria) this;
        }

        public Criteria andOtObjectTypeEqualTo(String value) {
            addCriterion("ot_object_type =", value, "otObjectType");
            return (Criteria) this;
        }

        public Criteria andOtObjectTypeNotEqualTo(String value) {
            addCriterion("ot_object_type <>", value, "otObjectType");
            return (Criteria) this;
        }

        public Criteria andOtObjectTypeGreaterThan(String value) {
            addCriterion("ot_object_type >", value, "otObjectType");
            return (Criteria) this;
        }

        public Criteria andOtObjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ot_object_type >=", value, "otObjectType");
            return (Criteria) this;
        }

        public Criteria andOtObjectTypeLessThan(String value) {
            addCriterion("ot_object_type <", value, "otObjectType");
            return (Criteria) this;
        }

        public Criteria andOtObjectTypeLessThanOrEqualTo(String value) {
            addCriterion("ot_object_type <=", value, "otObjectType");
            return (Criteria) this;
        }

        public Criteria andOtObjectTypeLike(String value) {
            addCriterion("ot_object_type like", value, "otObjectType");
            return (Criteria) this;
        }

        public Criteria andOtObjectTypeNotLike(String value) {
            addCriterion("ot_object_type not like", value, "otObjectType");
            return (Criteria) this;
        }

        public Criteria andOtObjectTypeIn(List<String> values) {
            addCriterion("ot_object_type in", values, "otObjectType");
            return (Criteria) this;
        }

        public Criteria andOtObjectTypeNotIn(List<String> values) {
            addCriterion("ot_object_type not in", values, "otObjectType");
            return (Criteria) this;
        }

        public Criteria andOtObjectTypeBetween(String value1, String value2) {
            addCriterion("ot_object_type between", value1, value2, "otObjectType");
            return (Criteria) this;
        }

        public Criteria andOtObjectTypeNotBetween(String value1, String value2) {
            addCriterion("ot_object_type not between", value1, value2, "otObjectType");
            return (Criteria) this;
        }

        public Criteria andOtTitleIsNull() {
            addCriterion("ot_title is null");
            return (Criteria) this;
        }

        public Criteria andOtTitleIsNotNull() {
            addCriterion("ot_title is not null");
            return (Criteria) this;
        }

        public Criteria andOtTitleEqualTo(String value) {
            addCriterion("ot_title =", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleNotEqualTo(String value) {
            addCriterion("ot_title <>", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleGreaterThan(String value) {
            addCriterion("ot_title >", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleGreaterThanOrEqualTo(String value) {
            addCriterion("ot_title >=", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleLessThan(String value) {
            addCriterion("ot_title <", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleLessThanOrEqualTo(String value) {
            addCriterion("ot_title <=", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleLike(String value) {
            addCriterion("ot_title like", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleNotLike(String value) {
            addCriterion("ot_title not like", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleIn(List<String> values) {
            addCriterion("ot_title in", values, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleNotIn(List<String> values) {
            addCriterion("ot_title not in", values, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleBetween(String value1, String value2) {
            addCriterion("ot_title between", value1, value2, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleNotBetween(String value1, String value2) {
            addCriterion("ot_title not between", value1, value2, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTargetPfIsNull() {
            addCriterion("ot_target_pf is null");
            return (Criteria) this;
        }

        public Criteria andOtTargetPfIsNotNull() {
            addCriterion("ot_target_pf is not null");
            return (Criteria) this;
        }

        public Criteria andOtTargetPfEqualTo(String value) {
            addCriterion("ot_target_pf =", value, "otTargetPf");
            return (Criteria) this;
        }

        public Criteria andOtTargetPfNotEqualTo(String value) {
            addCriterion("ot_target_pf <>", value, "otTargetPf");
            return (Criteria) this;
        }

        public Criteria andOtTargetPfGreaterThan(String value) {
            addCriterion("ot_target_pf >", value, "otTargetPf");
            return (Criteria) this;
        }

        public Criteria andOtTargetPfGreaterThanOrEqualTo(String value) {
            addCriterion("ot_target_pf >=", value, "otTargetPf");
            return (Criteria) this;
        }

        public Criteria andOtTargetPfLessThan(String value) {
            addCriterion("ot_target_pf <", value, "otTargetPf");
            return (Criteria) this;
        }

        public Criteria andOtTargetPfLessThanOrEqualTo(String value) {
            addCriterion("ot_target_pf <=", value, "otTargetPf");
            return (Criteria) this;
        }

        public Criteria andOtTargetPfLike(String value) {
            addCriterion("ot_target_pf like", value, "otTargetPf");
            return (Criteria) this;
        }

        public Criteria andOtTargetPfNotLike(String value) {
            addCriterion("ot_target_pf not like", value, "otTargetPf");
            return (Criteria) this;
        }

        public Criteria andOtTargetPfIn(List<String> values) {
            addCriterion("ot_target_pf in", values, "otTargetPf");
            return (Criteria) this;
        }

        public Criteria andOtTargetPfNotIn(List<String> values) {
            addCriterion("ot_target_pf not in", values, "otTargetPf");
            return (Criteria) this;
        }

        public Criteria andOtTargetPfBetween(String value1, String value2) {
            addCriterion("ot_target_pf between", value1, value2, "otTargetPf");
            return (Criteria) this;
        }

        public Criteria andOtTargetPfNotBetween(String value1, String value2) {
            addCriterion("ot_target_pf not between", value1, value2, "otTargetPf");
            return (Criteria) this;
        }

        public Criteria andOtOpenTypeIsNull() {
            addCriterion("ot_open_type is null");
            return (Criteria) this;
        }

        public Criteria andOtOpenTypeIsNotNull() {
            addCriterion("ot_open_type is not null");
            return (Criteria) this;
        }

        public Criteria andOtOpenTypeEqualTo(String value) {
            addCriterion("ot_open_type =", value, "otOpenType");
            return (Criteria) this;
        }

        public Criteria andOtOpenTypeNotEqualTo(String value) {
            addCriterion("ot_open_type <>", value, "otOpenType");
            return (Criteria) this;
        }

        public Criteria andOtOpenTypeGreaterThan(String value) {
            addCriterion("ot_open_type >", value, "otOpenType");
            return (Criteria) this;
        }

        public Criteria andOtOpenTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ot_open_type >=", value, "otOpenType");
            return (Criteria) this;
        }

        public Criteria andOtOpenTypeLessThan(String value) {
            addCriterion("ot_open_type <", value, "otOpenType");
            return (Criteria) this;
        }

        public Criteria andOtOpenTypeLessThanOrEqualTo(String value) {
            addCriterion("ot_open_type <=", value, "otOpenType");
            return (Criteria) this;
        }

        public Criteria andOtOpenTypeLike(String value) {
            addCriterion("ot_open_type like", value, "otOpenType");
            return (Criteria) this;
        }

        public Criteria andOtOpenTypeNotLike(String value) {
            addCriterion("ot_open_type not like", value, "otOpenType");
            return (Criteria) this;
        }

        public Criteria andOtOpenTypeIn(List<String> values) {
            addCriterion("ot_open_type in", values, "otOpenType");
            return (Criteria) this;
        }

        public Criteria andOtOpenTypeNotIn(List<String> values) {
            addCriterion("ot_open_type not in", values, "otOpenType");
            return (Criteria) this;
        }

        public Criteria andOtOpenTypeBetween(String value1, String value2) {
            addCriterion("ot_open_type between", value1, value2, "otOpenType");
            return (Criteria) this;
        }

        public Criteria andOtOpenTypeNotBetween(String value1, String value2) {
            addCriterion("ot_open_type not between", value1, value2, "otOpenType");
            return (Criteria) this;
        }

        public Criteria andOtContentIsNull() {
            addCriterion("ot_content is null");
            return (Criteria) this;
        }

        public Criteria andOtContentIsNotNull() {
            addCriterion("ot_content is not null");
            return (Criteria) this;
        }

        public Criteria andOtContentEqualTo(String value) {
            addCriterion("ot_content =", value, "otContent");
            return (Criteria) this;
        }

        public Criteria andOtContentNotEqualTo(String value) {
            addCriterion("ot_content <>", value, "otContent");
            return (Criteria) this;
        }

        public Criteria andOtContentGreaterThan(String value) {
            addCriterion("ot_content >", value, "otContent");
            return (Criteria) this;
        }

        public Criteria andOtContentGreaterThanOrEqualTo(String value) {
            addCriterion("ot_content >=", value, "otContent");
            return (Criteria) this;
        }

        public Criteria andOtContentLessThan(String value) {
            addCriterion("ot_content <", value, "otContent");
            return (Criteria) this;
        }

        public Criteria andOtContentLessThanOrEqualTo(String value) {
            addCriterion("ot_content <=", value, "otContent");
            return (Criteria) this;
        }

        public Criteria andOtContentLike(String value) {
            addCriterion("ot_content like", value, "otContent");
            return (Criteria) this;
        }

        public Criteria andOtContentNotLike(String value) {
            addCriterion("ot_content not like", value, "otContent");
            return (Criteria) this;
        }

        public Criteria andOtContentIn(List<String> values) {
            addCriterion("ot_content in", values, "otContent");
            return (Criteria) this;
        }

        public Criteria andOtContentNotIn(List<String> values) {
            addCriterion("ot_content not in", values, "otContent");
            return (Criteria) this;
        }

        public Criteria andOtContentBetween(String value1, String value2) {
            addCriterion("ot_content between", value1, value2, "otContent");
            return (Criteria) this;
        }

        public Criteria andOtContentNotBetween(String value1, String value2) {
            addCriterion("ot_content not between", value1, value2, "otContent");
            return (Criteria) this;
        }

        public Criteria andOtResourceIsNull() {
            addCriterion("ot_resource is null");
            return (Criteria) this;
        }

        public Criteria andOtResourceIsNotNull() {
            addCriterion("ot_resource is not null");
            return (Criteria) this;
        }

        public Criteria andOtResourceEqualTo(Integer value) {
            addCriterion("ot_resource =", value, "otResource");
            return (Criteria) this;
        }

        public Criteria andOtResourceNotEqualTo(Integer value) {
            addCriterion("ot_resource <>", value, "otResource");
            return (Criteria) this;
        }

        public Criteria andOtResourceGreaterThan(Integer value) {
            addCriterion("ot_resource >", value, "otResource");
            return (Criteria) this;
        }

        public Criteria andOtResourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("ot_resource >=", value, "otResource");
            return (Criteria) this;
        }

        public Criteria andOtResourceLessThan(Integer value) {
            addCriterion("ot_resource <", value, "otResource");
            return (Criteria) this;
        }

        public Criteria andOtResourceLessThanOrEqualTo(Integer value) {
            addCriterion("ot_resource <=", value, "otResource");
            return (Criteria) this;
        }

        public Criteria andOtResourceIn(List<Integer> values) {
            addCriterion("ot_resource in", values, "otResource");
            return (Criteria) this;
        }

        public Criteria andOtResourceNotIn(List<Integer> values) {
            addCriterion("ot_resource not in", values, "otResource");
            return (Criteria) this;
        }

        public Criteria andOtResourceBetween(Integer value1, Integer value2) {
            addCriterion("ot_resource between", value1, value2, "otResource");
            return (Criteria) this;
        }

        public Criteria andOtResourceNotBetween(Integer value1, Integer value2) {
            addCriterion("ot_resource not between", value1, value2, "otResource");
            return (Criteria) this;
        }

        public Criteria andOtSourcePfIsNull() {
            addCriterion("ot_source_pf is null");
            return (Criteria) this;
        }

        public Criteria andOtSourcePfIsNotNull() {
            addCriterion("ot_source_pf is not null");
            return (Criteria) this;
        }

        public Criteria andOtSourcePfEqualTo(String value) {
            addCriterion("ot_source_pf =", value, "otSourcePf");
            return (Criteria) this;
        }

        public Criteria andOtSourcePfNotEqualTo(String value) {
            addCriterion("ot_source_pf <>", value, "otSourcePf");
            return (Criteria) this;
        }

        public Criteria andOtSourcePfGreaterThan(String value) {
            addCriterion("ot_source_pf >", value, "otSourcePf");
            return (Criteria) this;
        }

        public Criteria andOtSourcePfGreaterThanOrEqualTo(String value) {
            addCriterion("ot_source_pf >=", value, "otSourcePf");
            return (Criteria) this;
        }

        public Criteria andOtSourcePfLessThan(String value) {
            addCriterion("ot_source_pf <", value, "otSourcePf");
            return (Criteria) this;
        }

        public Criteria andOtSourcePfLessThanOrEqualTo(String value) {
            addCriterion("ot_source_pf <=", value, "otSourcePf");
            return (Criteria) this;
        }

        public Criteria andOtSourcePfLike(String value) {
            addCriterion("ot_source_pf like", value, "otSourcePf");
            return (Criteria) this;
        }

        public Criteria andOtSourcePfNotLike(String value) {
            addCriterion("ot_source_pf not like", value, "otSourcePf");
            return (Criteria) this;
        }

        public Criteria andOtSourcePfIn(List<String> values) {
            addCriterion("ot_source_pf in", values, "otSourcePf");
            return (Criteria) this;
        }

        public Criteria andOtSourcePfNotIn(List<String> values) {
            addCriterion("ot_source_pf not in", values, "otSourcePf");
            return (Criteria) this;
        }

        public Criteria andOtSourcePfBetween(String value1, String value2) {
            addCriterion("ot_source_pf between", value1, value2, "otSourcePf");
            return (Criteria) this;
        }

        public Criteria andOtSourcePfNotBetween(String value1, String value2) {
            addCriterion("ot_source_pf not between", value1, value2, "otSourcePf");
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