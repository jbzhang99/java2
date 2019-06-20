package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IfaceLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IfaceLogExample() {
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

        public Criteria andTargetUrlIsNull() {
            addCriterion("target_url is null");
            return (Criteria) this;
        }

        public Criteria andTargetUrlIsNotNull() {
            addCriterion("target_url is not null");
            return (Criteria) this;
        }

        public Criteria andTargetUrlEqualTo(String value) {
            addCriterion("target_url =", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlNotEqualTo(String value) {
            addCriterion("target_url <>", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlGreaterThan(String value) {
            addCriterion("target_url >", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlGreaterThanOrEqualTo(String value) {
            addCriterion("target_url >=", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlLessThan(String value) {
            addCriterion("target_url <", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlLessThanOrEqualTo(String value) {
            addCriterion("target_url <=", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlLike(String value) {
            addCriterion("target_url like", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlNotLike(String value) {
            addCriterion("target_url not like", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlIn(List<String> values) {
            addCriterion("target_url in", values, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlNotIn(List<String> values) {
            addCriterion("target_url not in", values, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlBetween(String value1, String value2) {
            addCriterion("target_url between", value1, value2, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlNotBetween(String value1, String value2) {
            addCriterion("target_url not between", value1, value2, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andReqBodyIsNull() {
            addCriterion("req_body is null");
            return (Criteria) this;
        }

        public Criteria andReqBodyIsNotNull() {
            addCriterion("req_body is not null");
            return (Criteria) this;
        }

        public Criteria andReqBodyEqualTo(String value) {
            addCriterion("req_body =", value, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyNotEqualTo(String value) {
            addCriterion("req_body <>", value, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyGreaterThan(String value) {
            addCriterion("req_body >", value, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyGreaterThanOrEqualTo(String value) {
            addCriterion("req_body >=", value, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyLessThan(String value) {
            addCriterion("req_body <", value, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyLessThanOrEqualTo(String value) {
            addCriterion("req_body <=", value, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyLike(String value) {
            addCriterion("req_body like", value, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyNotLike(String value) {
            addCriterion("req_body not like", value, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyIn(List<String> values) {
            addCriterion("req_body in", values, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyNotIn(List<String> values) {
            addCriterion("req_body not in", values, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyBetween(String value1, String value2) {
            addCriterion("req_body between", value1, value2, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyNotBetween(String value1, String value2) {
            addCriterion("req_body not between", value1, value2, "reqBody");
            return (Criteria) this;
        }

        public Criteria andRspBodyIsNull() {
            addCriterion("rsp_body is null");
            return (Criteria) this;
        }

        public Criteria andRspBodyIsNotNull() {
            addCriterion("rsp_body is not null");
            return (Criteria) this;
        }

        public Criteria andRspBodyEqualTo(String value) {
            addCriterion("rsp_body =", value, "rspBody");
            return (Criteria) this;
        }

        public Criteria andRspBodyNotEqualTo(String value) {
            addCriterion("rsp_body <>", value, "rspBody");
            return (Criteria) this;
        }

        public Criteria andRspBodyGreaterThan(String value) {
            addCriterion("rsp_body >", value, "rspBody");
            return (Criteria) this;
        }

        public Criteria andRspBodyGreaterThanOrEqualTo(String value) {
            addCriterion("rsp_body >=", value, "rspBody");
            return (Criteria) this;
        }

        public Criteria andRspBodyLessThan(String value) {
            addCriterion("rsp_body <", value, "rspBody");
            return (Criteria) this;
        }

        public Criteria andRspBodyLessThanOrEqualTo(String value) {
            addCriterion("rsp_body <=", value, "rspBody");
            return (Criteria) this;
        }

        public Criteria andRspBodyLike(String value) {
            addCriterion("rsp_body like", value, "rspBody");
            return (Criteria) this;
        }

        public Criteria andRspBodyNotLike(String value) {
            addCriterion("rsp_body not like", value, "rspBody");
            return (Criteria) this;
        }

        public Criteria andRspBodyIn(List<String> values) {
            addCriterion("rsp_body in", values, "rspBody");
            return (Criteria) this;
        }

        public Criteria andRspBodyNotIn(List<String> values) {
            addCriterion("rsp_body not in", values, "rspBody");
            return (Criteria) this;
        }

        public Criteria andRspBodyBetween(String value1, String value2) {
            addCriterion("rsp_body between", value1, value2, "rspBody");
            return (Criteria) this;
        }

        public Criteria andRspBodyNotBetween(String value1, String value2) {
            addCriterion("rsp_body not between", value1, value2, "rspBody");
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