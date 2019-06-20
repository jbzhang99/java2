package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepairRecordStateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepairRecordStateExample() {
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

        public Criteria andTskCodeIsNull() {
            addCriterion("tsk_code is null");
            return (Criteria) this;
        }

        public Criteria andTskCodeIsNotNull() {
            addCriterion("tsk_code is not null");
            return (Criteria) this;
        }

        public Criteria andTskCodeEqualTo(String value) {
            addCriterion("tsk_code =", value, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeNotEqualTo(String value) {
            addCriterion("tsk_code <>", value, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeGreaterThan(String value) {
            addCriterion("tsk_code >", value, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tsk_code >=", value, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeLessThan(String value) {
            addCriterion("tsk_code <", value, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeLessThanOrEqualTo(String value) {
            addCriterion("tsk_code <=", value, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeLike(String value) {
            addCriterion("tsk_code like", value, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeNotLike(String value) {
            addCriterion("tsk_code not like", value, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeIn(List<String> values) {
            addCriterion("tsk_code in", values, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeNotIn(List<String> values) {
            addCriterion("tsk_code not in", values, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeBetween(String value1, String value2) {
            addCriterion("tsk_code between", value1, value2, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskCodeNotBetween(String value1, String value2) {
            addCriterion("tsk_code not between", value1, value2, "tskCode");
            return (Criteria) this;
        }

        public Criteria andTskStateIsNull() {
            addCriterion("tsk_state is null");
            return (Criteria) this;
        }

        public Criteria andTskStateIsNotNull() {
            addCriterion("tsk_state is not null");
            return (Criteria) this;
        }

        public Criteria andTskStateEqualTo(String value) {
            addCriterion("tsk_state =", value, "tskState");
            return (Criteria) this;
        }

        public Criteria andTskStateNotEqualTo(String value) {
            addCriterion("tsk_state <>", value, "tskState");
            return (Criteria) this;
        }

        public Criteria andTskStateGreaterThan(String value) {
            addCriterion("tsk_state >", value, "tskState");
            return (Criteria) this;
        }

        public Criteria andTskStateGreaterThanOrEqualTo(String value) {
            addCriterion("tsk_state >=", value, "tskState");
            return (Criteria) this;
        }

        public Criteria andTskStateLessThan(String value) {
            addCriterion("tsk_state <", value, "tskState");
            return (Criteria) this;
        }

        public Criteria andTskStateLessThanOrEqualTo(String value) {
            addCriterion("tsk_state <=", value, "tskState");
            return (Criteria) this;
        }

        public Criteria andTskStateLike(String value) {
            addCriterion("tsk_state like", value, "tskState");
            return (Criteria) this;
        }

        public Criteria andTskStateNotLike(String value) {
            addCriterion("tsk_state not like", value, "tskState");
            return (Criteria) this;
        }

        public Criteria andTskStateIn(List<String> values) {
            addCriterion("tsk_state in", values, "tskState");
            return (Criteria) this;
        }

        public Criteria andTskStateNotIn(List<String> values) {
            addCriterion("tsk_state not in", values, "tskState");
            return (Criteria) this;
        }

        public Criteria andTskStateBetween(String value1, String value2) {
            addCriterion("tsk_state between", value1, value2, "tskState");
            return (Criteria) this;
        }

        public Criteria andTskStateNotBetween(String value1, String value2) {
            addCriterion("tsk_state not between", value1, value2, "tskState");
            return (Criteria) this;
        }

        public Criteria andTskIstateIsNull() {
            addCriterion("tsk_istate is null");
            return (Criteria) this;
        }

        public Criteria andTskIstateIsNotNull() {
            addCriterion("tsk_istate is not null");
            return (Criteria) this;
        }

        public Criteria andTskIstateEqualTo(Integer value) {
            addCriterion("tsk_istate =", value, "tskIstate");
            return (Criteria) this;
        }

        public Criteria andTskIstateNotEqualTo(Integer value) {
            addCriterion("tsk_istate <>", value, "tskIstate");
            return (Criteria) this;
        }

        public Criteria andTskIstateGreaterThan(Integer value) {
            addCriterion("tsk_istate >", value, "tskIstate");
            return (Criteria) this;
        }

        public Criteria andTskIstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("tsk_istate >=", value, "tskIstate");
            return (Criteria) this;
        }

        public Criteria andTskIstateLessThan(Integer value) {
            addCriterion("tsk_istate <", value, "tskIstate");
            return (Criteria) this;
        }

        public Criteria andTskIstateLessThanOrEqualTo(Integer value) {
            addCriterion("tsk_istate <=", value, "tskIstate");
            return (Criteria) this;
        }

        public Criteria andTskIstateIn(List<Integer> values) {
            addCriterion("tsk_istate in", values, "tskIstate");
            return (Criteria) this;
        }

        public Criteria andTskIstateNotIn(List<Integer> values) {
            addCriterion("tsk_istate not in", values, "tskIstate");
            return (Criteria) this;
        }

        public Criteria andTskIstateBetween(Integer value1, Integer value2) {
            addCriterion("tsk_istate between", value1, value2, "tskIstate");
            return (Criteria) this;
        }

        public Criteria andTskIstateNotBetween(Integer value1, Integer value2) {
            addCriterion("tsk_istate not between", value1, value2, "tskIstate");
            return (Criteria) this;
        }

        public Criteria andTskCompleteIsNull() {
            addCriterion("tsk_complete is null");
            return (Criteria) this;
        }

        public Criteria andTskCompleteIsNotNull() {
            addCriterion("tsk_complete is not null");
            return (Criteria) this;
        }

        public Criteria andTskCompleteEqualTo(Integer value) {
            addCriterion("tsk_complete =", value, "tskComplete");
            return (Criteria) this;
        }

        public Criteria andTskCompleteNotEqualTo(Integer value) {
            addCriterion("tsk_complete <>", value, "tskComplete");
            return (Criteria) this;
        }

        public Criteria andTskCompleteGreaterThan(Integer value) {
            addCriterion("tsk_complete >", value, "tskComplete");
            return (Criteria) this;
        }

        public Criteria andTskCompleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("tsk_complete >=", value, "tskComplete");
            return (Criteria) this;
        }

        public Criteria andTskCompleteLessThan(Integer value) {
            addCriterion("tsk_complete <", value, "tskComplete");
            return (Criteria) this;
        }

        public Criteria andTskCompleteLessThanOrEqualTo(Integer value) {
            addCriterion("tsk_complete <=", value, "tskComplete");
            return (Criteria) this;
        }

        public Criteria andTskCompleteIn(List<Integer> values) {
            addCriterion("tsk_complete in", values, "tskComplete");
            return (Criteria) this;
        }

        public Criteria andTskCompleteNotIn(List<Integer> values) {
            addCriterion("tsk_complete not in", values, "tskComplete");
            return (Criteria) this;
        }

        public Criteria andTskCompleteBetween(Integer value1, Integer value2) {
            addCriterion("tsk_complete between", value1, value2, "tskComplete");
            return (Criteria) this;
        }

        public Criteria andTskCompleteNotBetween(Integer value1, Integer value2) {
            addCriterion("tsk_complete not between", value1, value2, "tskComplete");
            return (Criteria) this;
        }

        public Criteria andTskDescIsNull() {
            addCriterion("tsk_desc is null");
            return (Criteria) this;
        }

        public Criteria andTskDescIsNotNull() {
            addCriterion("tsk_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTskDescEqualTo(String value) {
            addCriterion("tsk_desc =", value, "tskDesc");
            return (Criteria) this;
        }

        public Criteria andTskDescNotEqualTo(String value) {
            addCriterion("tsk_desc <>", value, "tskDesc");
            return (Criteria) this;
        }

        public Criteria andTskDescGreaterThan(String value) {
            addCriterion("tsk_desc >", value, "tskDesc");
            return (Criteria) this;
        }

        public Criteria andTskDescGreaterThanOrEqualTo(String value) {
            addCriterion("tsk_desc >=", value, "tskDesc");
            return (Criteria) this;
        }

        public Criteria andTskDescLessThan(String value) {
            addCriterion("tsk_desc <", value, "tskDesc");
            return (Criteria) this;
        }

        public Criteria andTskDescLessThanOrEqualTo(String value) {
            addCriterion("tsk_desc <=", value, "tskDesc");
            return (Criteria) this;
        }

        public Criteria andTskDescLike(String value) {
            addCriterion("tsk_desc like", value, "tskDesc");
            return (Criteria) this;
        }

        public Criteria andTskDescNotLike(String value) {
            addCriterion("tsk_desc not like", value, "tskDesc");
            return (Criteria) this;
        }

        public Criteria andTskDescIn(List<String> values) {
            addCriterion("tsk_desc in", values, "tskDesc");
            return (Criteria) this;
        }

        public Criteria andTskDescNotIn(List<String> values) {
            addCriterion("tsk_desc not in", values, "tskDesc");
            return (Criteria) this;
        }

        public Criteria andTskDescBetween(String value1, String value2) {
            addCriterion("tsk_desc between", value1, value2, "tskDesc");
            return (Criteria) this;
        }

        public Criteria andTskDescNotBetween(String value1, String value2) {
            addCriterion("tsk_desc not between", value1, value2, "tskDesc");
            return (Criteria) this;
        }

        public Criteria andTskCompleteTimeIsNull() {
            addCriterion("tsk_complete_time is null");
            return (Criteria) this;
        }

        public Criteria andTskCompleteTimeIsNotNull() {
            addCriterion("tsk_complete_time is not null");
            return (Criteria) this;
        }

        public Criteria andTskCompleteTimeEqualTo(Date value) {
            addCriterion("tsk_complete_time =", value, "tskCompleteTime");
            return (Criteria) this;
        }

        public Criteria andTskCompleteTimeNotEqualTo(Date value) {
            addCriterion("tsk_complete_time <>", value, "tskCompleteTime");
            return (Criteria) this;
        }

        public Criteria andTskCompleteTimeGreaterThan(Date value) {
            addCriterion("tsk_complete_time >", value, "tskCompleteTime");
            return (Criteria) this;
        }

        public Criteria andTskCompleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("tsk_complete_time >=", value, "tskCompleteTime");
            return (Criteria) this;
        }

        public Criteria andTskCompleteTimeLessThan(Date value) {
            addCriterion("tsk_complete_time <", value, "tskCompleteTime");
            return (Criteria) this;
        }

        public Criteria andTskCompleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("tsk_complete_time <=", value, "tskCompleteTime");
            return (Criteria) this;
        }

        public Criteria andTskCompleteTimeIn(List<Date> values) {
            addCriterion("tsk_complete_time in", values, "tskCompleteTime");
            return (Criteria) this;
        }

        public Criteria andTskCompleteTimeNotIn(List<Date> values) {
            addCriterion("tsk_complete_time not in", values, "tskCompleteTime");
            return (Criteria) this;
        }

        public Criteria andTskCompleteTimeBetween(Date value1, Date value2) {
            addCriterion("tsk_complete_time between", value1, value2, "tskCompleteTime");
            return (Criteria) this;
        }

        public Criteria andTskCompleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("tsk_complete_time not between", value1, value2, "tskCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFormTypeIsNull() {
            addCriterion("form_type is null");
            return (Criteria) this;
        }

        public Criteria andFormTypeIsNotNull() {
            addCriterion("form_type is not null");
            return (Criteria) this;
        }

        public Criteria andFormTypeEqualTo(Integer value) {
            addCriterion("form_type =", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeNotEqualTo(Integer value) {
            addCriterion("form_type <>", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeGreaterThan(Integer value) {
            addCriterion("form_type >", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("form_type >=", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeLessThan(Integer value) {
            addCriterion("form_type <", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeLessThanOrEqualTo(Integer value) {
            addCriterion("form_type <=", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeIn(List<Integer> values) {
            addCriterion("form_type in", values, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeNotIn(List<Integer> values) {
            addCriterion("form_type not in", values, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeBetween(Integer value1, Integer value2) {
            addCriterion("form_type between", value1, value2, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("form_type not between", value1, value2, "formType");
            return (Criteria) this;
        }

        public Criteria andOutReasonIsNull() {
            addCriterion("out_reason is null");
            return (Criteria) this;
        }

        public Criteria andOutReasonIsNotNull() {
            addCriterion("out_reason is not null");
            return (Criteria) this;
        }

        public Criteria andOutReasonEqualTo(String value) {
            addCriterion("out_reason =", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonNotEqualTo(String value) {
            addCriterion("out_reason <>", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonGreaterThan(String value) {
            addCriterion("out_reason >", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonGreaterThanOrEqualTo(String value) {
            addCriterion("out_reason >=", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonLessThan(String value) {
            addCriterion("out_reason <", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonLessThanOrEqualTo(String value) {
            addCriterion("out_reason <=", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonLike(String value) {
            addCriterion("out_reason like", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonNotLike(String value) {
            addCriterion("out_reason not like", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonIn(List<String> values) {
            addCriterion("out_reason in", values, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonNotIn(List<String> values) {
            addCriterion("out_reason not in", values, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonBetween(String value1, String value2) {
            addCriterion("out_reason between", value1, value2, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonNotBetween(String value1, String value2) {
            addCriterion("out_reason not between", value1, value2, "outReason");
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