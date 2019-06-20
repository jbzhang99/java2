package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.List;

public class VisitCommunityMasterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VisitCommunityMasterExample() {
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

        public Criteria andMasterIdIsNull() {
            addCriterion("master_id is null");
            return (Criteria) this;
        }

        public Criteria andMasterIdIsNotNull() {
            addCriterion("master_id is not null");
            return (Criteria) this;
        }

        public Criteria andMasterIdEqualTo(Long value) {
            addCriterion("master_id =", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotEqualTo(Long value) {
            addCriterion("master_id <>", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdGreaterThan(Long value) {
            addCriterion("master_id >", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("master_id >=", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLessThan(Long value) {
            addCriterion("master_id <", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLessThanOrEqualTo(Long value) {
            addCriterion("master_id <=", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdIn(List<Long> values) {
            addCriterion("master_id in", values, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotIn(List<Long> values) {
            addCriterion("master_id not in", values, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdBetween(Long value1, Long value2) {
            addCriterion("master_id between", value1, value2, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotBetween(Long value1, Long value2) {
            addCriterion("master_id not between", value1, value2, "masterId");
            return (Criteria) this;
        }

        public Criteria andRoleCountIsNull() {
            addCriterion("role_count is null");
            return (Criteria) this;
        }

        public Criteria andRoleCountIsNotNull() {
            addCriterion("role_count is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCountEqualTo(Integer value) {
            addCriterion("role_count =", value, "roleCount");
            return (Criteria) this;
        }

        public Criteria andRoleCountNotEqualTo(Integer value) {
            addCriterion("role_count <>", value, "roleCount");
            return (Criteria) this;
        }

        public Criteria andRoleCountGreaterThan(Integer value) {
            addCriterion("role_count >", value, "roleCount");
            return (Criteria) this;
        }

        public Criteria andRoleCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_count >=", value, "roleCount");
            return (Criteria) this;
        }

        public Criteria andRoleCountLessThan(Integer value) {
            addCriterion("role_count <", value, "roleCount");
            return (Criteria) this;
        }

        public Criteria andRoleCountLessThanOrEqualTo(Integer value) {
            addCriterion("role_count <=", value, "roleCount");
            return (Criteria) this;
        }

        public Criteria andRoleCountIn(List<Integer> values) {
            addCriterion("role_count in", values, "roleCount");
            return (Criteria) this;
        }

        public Criteria andRoleCountNotIn(List<Integer> values) {
            addCriterion("role_count not in", values, "roleCount");
            return (Criteria) this;
        }

        public Criteria andRoleCountBetween(Integer value1, Integer value2) {
            addCriterion("role_count between", value1, value2, "roleCount");
            return (Criteria) this;
        }

        public Criteria andRoleCountNotBetween(Integer value1, Integer value2) {
            addCriterion("role_count not between", value1, value2, "roleCount");
            return (Criteria) this;
        }

        public Criteria andCanVisitIsNull() {
            addCriterion("can_visit is null");
            return (Criteria) this;
        }

        public Criteria andCanVisitIsNotNull() {
            addCriterion("can_visit is not null");
            return (Criteria) this;
        }

        public Criteria andCanVisitEqualTo(Integer value) {
            addCriterion("can_visit =", value, "canVisit");
            return (Criteria) this;
        }

        public Criteria andCanVisitNotEqualTo(Integer value) {
            addCriterion("can_visit <>", value, "canVisit");
            return (Criteria) this;
        }

        public Criteria andCanVisitGreaterThan(Integer value) {
            addCriterion("can_visit >", value, "canVisit");
            return (Criteria) this;
        }

        public Criteria andCanVisitGreaterThanOrEqualTo(Integer value) {
            addCriterion("can_visit >=", value, "canVisit");
            return (Criteria) this;
        }

        public Criteria andCanVisitLessThan(Integer value) {
            addCriterion("can_visit <", value, "canVisit");
            return (Criteria) this;
        }

        public Criteria andCanVisitLessThanOrEqualTo(Integer value) {
            addCriterion("can_visit <=", value, "canVisit");
            return (Criteria) this;
        }

        public Criteria andCanVisitIn(List<Integer> values) {
            addCriterion("can_visit in", values, "canVisit");
            return (Criteria) this;
        }

        public Criteria andCanVisitNotIn(List<Integer> values) {
            addCriterion("can_visit not in", values, "canVisit");
            return (Criteria) this;
        }

        public Criteria andCanVisitBetween(Integer value1, Integer value2) {
            addCriterion("can_visit between", value1, value2, "canVisit");
            return (Criteria) this;
        }

        public Criteria andCanVisitNotBetween(Integer value1, Integer value2) {
            addCriterion("can_visit not between", value1, value2, "canVisit");
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