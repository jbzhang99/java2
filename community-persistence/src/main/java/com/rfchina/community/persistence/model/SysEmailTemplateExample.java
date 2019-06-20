package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.List;

public class SysEmailTemplateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysEmailTemplateExample() {
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

        public Criteria andEmailTypeIsNull() {
            addCriterion("email_type is null");
            return (Criteria) this;
        }

        public Criteria andEmailTypeIsNotNull() {
            addCriterion("email_type is not null");
            return (Criteria) this;
        }

        public Criteria andEmailTypeEqualTo(String value) {
            addCriterion("email_type =", value, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeNotEqualTo(String value) {
            addCriterion("email_type <>", value, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeGreaterThan(String value) {
            addCriterion("email_type >", value, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeGreaterThanOrEqualTo(String value) {
            addCriterion("email_type >=", value, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeLessThan(String value) {
            addCriterion("email_type <", value, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeLessThanOrEqualTo(String value) {
            addCriterion("email_type <=", value, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeLike(String value) {
            addCriterion("email_type like", value, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeNotLike(String value) {
            addCriterion("email_type not like", value, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeIn(List<String> values) {
            addCriterion("email_type in", values, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeNotIn(List<String> values) {
            addCriterion("email_type not in", values, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeBetween(String value1, String value2) {
            addCriterion("email_type between", value1, value2, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeNotBetween(String value1, String value2) {
            addCriterion("email_type not between", value1, value2, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectIsNull() {
            addCriterion("email_subject is null");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectIsNotNull() {
            addCriterion("email_subject is not null");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectEqualTo(String value) {
            addCriterion("email_subject =", value, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectNotEqualTo(String value) {
            addCriterion("email_subject <>", value, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectGreaterThan(String value) {
            addCriterion("email_subject >", value, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("email_subject >=", value, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectLessThan(String value) {
            addCriterion("email_subject <", value, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectLessThanOrEqualTo(String value) {
            addCriterion("email_subject <=", value, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectLike(String value) {
            addCriterion("email_subject like", value, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectNotLike(String value) {
            addCriterion("email_subject not like", value, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectIn(List<String> values) {
            addCriterion("email_subject in", values, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectNotIn(List<String> values) {
            addCriterion("email_subject not in", values, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectBetween(String value1, String value2) {
            addCriterion("email_subject between", value1, value2, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectNotBetween(String value1, String value2) {
            addCriterion("email_subject not between", value1, value2, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailTemplateIsNull() {
            addCriterion("email_template is null");
            return (Criteria) this;
        }

        public Criteria andEmailTemplateIsNotNull() {
            addCriterion("email_template is not null");
            return (Criteria) this;
        }

        public Criteria andEmailTemplateEqualTo(String value) {
            addCriterion("email_template =", value, "emailTemplate");
            return (Criteria) this;
        }

        public Criteria andEmailTemplateNotEqualTo(String value) {
            addCriterion("email_template <>", value, "emailTemplate");
            return (Criteria) this;
        }

        public Criteria andEmailTemplateGreaterThan(String value) {
            addCriterion("email_template >", value, "emailTemplate");
            return (Criteria) this;
        }

        public Criteria andEmailTemplateGreaterThanOrEqualTo(String value) {
            addCriterion("email_template >=", value, "emailTemplate");
            return (Criteria) this;
        }

        public Criteria andEmailTemplateLessThan(String value) {
            addCriterion("email_template <", value, "emailTemplate");
            return (Criteria) this;
        }

        public Criteria andEmailTemplateLessThanOrEqualTo(String value) {
            addCriterion("email_template <=", value, "emailTemplate");
            return (Criteria) this;
        }

        public Criteria andEmailTemplateLike(String value) {
            addCriterion("email_template like", value, "emailTemplate");
            return (Criteria) this;
        }

        public Criteria andEmailTemplateNotLike(String value) {
            addCriterion("email_template not like", value, "emailTemplate");
            return (Criteria) this;
        }

        public Criteria andEmailTemplateIn(List<String> values) {
            addCriterion("email_template in", values, "emailTemplate");
            return (Criteria) this;
        }

        public Criteria andEmailTemplateNotIn(List<String> values) {
            addCriterion("email_template not in", values, "emailTemplate");
            return (Criteria) this;
        }

        public Criteria andEmailTemplateBetween(String value1, String value2) {
            addCriterion("email_template between", value1, value2, "emailTemplate");
            return (Criteria) this;
        }

        public Criteria andEmailTemplateNotBetween(String value1, String value2) {
            addCriterion("email_template not between", value1, value2, "emailTemplate");
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