package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenMerchantInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenMerchantInfoExample() {
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

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
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

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleSimpleIsNull() {
            addCriterion("title_simple is null");
            return (Criteria) this;
        }

        public Criteria andTitleSimpleIsNotNull() {
            addCriterion("title_simple is not null");
            return (Criteria) this;
        }

        public Criteria andTitleSimpleEqualTo(String value) {
            addCriterion("title_simple =", value, "titleSimple");
            return (Criteria) this;
        }

        public Criteria andTitleSimpleNotEqualTo(String value) {
            addCriterion("title_simple <>", value, "titleSimple");
            return (Criteria) this;
        }

        public Criteria andTitleSimpleGreaterThan(String value) {
            addCriterion("title_simple >", value, "titleSimple");
            return (Criteria) this;
        }

        public Criteria andTitleSimpleGreaterThanOrEqualTo(String value) {
            addCriterion("title_simple >=", value, "titleSimple");
            return (Criteria) this;
        }

        public Criteria andTitleSimpleLessThan(String value) {
            addCriterion("title_simple <", value, "titleSimple");
            return (Criteria) this;
        }

        public Criteria andTitleSimpleLessThanOrEqualTo(String value) {
            addCriterion("title_simple <=", value, "titleSimple");
            return (Criteria) this;
        }

        public Criteria andTitleSimpleLike(String value) {
            addCriterion("title_simple like", value, "titleSimple");
            return (Criteria) this;
        }

        public Criteria andTitleSimpleNotLike(String value) {
            addCriterion("title_simple not like", value, "titleSimple");
            return (Criteria) this;
        }

        public Criteria andTitleSimpleIn(List<String> values) {
            addCriterion("title_simple in", values, "titleSimple");
            return (Criteria) this;
        }

        public Criteria andTitleSimpleNotIn(List<String> values) {
            addCriterion("title_simple not in", values, "titleSimple");
            return (Criteria) this;
        }

        public Criteria andTitleSimpleBetween(String value1, String value2) {
            addCriterion("title_simple between", value1, value2, "titleSimple");
            return (Criteria) this;
        }

        public Criteria andTitleSimpleNotBetween(String value1, String value2) {
            addCriterion("title_simple not between", value1, value2, "titleSimple");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNull() {
            addCriterion("business_scope is null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNotNull() {
            addCriterion("business_scope is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeEqualTo(String value) {
            addCriterion("business_scope =", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotEqualTo(String value) {
            addCriterion("business_scope <>", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThan(String value) {
            addCriterion("business_scope >", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThanOrEqualTo(String value) {
            addCriterion("business_scope >=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThan(String value) {
            addCriterion("business_scope <", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThanOrEqualTo(String value) {
            addCriterion("business_scope <=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLike(String value) {
            addCriterion("business_scope like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotLike(String value) {
            addCriterion("business_scope not like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIn(List<String> values) {
            addCriterion("business_scope in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotIn(List<String> values) {
            addCriterion("business_scope not in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeBetween(String value1, String value2) {
            addCriterion("business_scope between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotBetween(String value1, String value2) {
            addCriterion("business_scope not between", value1, value2, "businessScope");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberIsNull() {
            addCriterion("registration_number is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberIsNotNull() {
            addCriterion("registration_number is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberEqualTo(String value) {
            addCriterion("registration_number =", value, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberNotEqualTo(String value) {
            addCriterion("registration_number <>", value, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberGreaterThan(String value) {
            addCriterion("registration_number >", value, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberGreaterThanOrEqualTo(String value) {
            addCriterion("registration_number >=", value, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberLessThan(String value) {
            addCriterion("registration_number <", value, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberLessThanOrEqualTo(String value) {
            addCriterion("registration_number <=", value, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberLike(String value) {
            addCriterion("registration_number like", value, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberNotLike(String value) {
            addCriterion("registration_number not like", value, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberIn(List<String> values) {
            addCriterion("registration_number in", values, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberNotIn(List<String> values) {
            addCriterion("registration_number not in", values, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberBetween(String value1, String value2) {
            addCriterion("registration_number between", value1, value2, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberNotBetween(String value1, String value2) {
            addCriterion("registration_number not between", value1, value2, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeIsNull() {
            addCriterion("organization_code is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeIsNotNull() {
            addCriterion("organization_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeEqualTo(String value) {
            addCriterion("organization_code =", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotEqualTo(String value) {
            addCriterion("organization_code <>", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeGreaterThan(String value) {
            addCriterion("organization_code >", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("organization_code >=", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeLessThan(String value) {
            addCriterion("organization_code <", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeLessThanOrEqualTo(String value) {
            addCriterion("organization_code <=", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeLike(String value) {
            addCriterion("organization_code like", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotLike(String value) {
            addCriterion("organization_code not like", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeIn(List<String> values) {
            addCriterion("organization_code in", values, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotIn(List<String> values) {
            addCriterion("organization_code not in", values, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeBetween(String value1, String value2) {
            addCriterion("organization_code between", value1, value2, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotBetween(String value1, String value2) {
            addCriterion("organization_code not between", value1, value2, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andTexRegistrationNoIsNull() {
            addCriterion("tex_registration_no is null");
            return (Criteria) this;
        }

        public Criteria andTexRegistrationNoIsNotNull() {
            addCriterion("tex_registration_no is not null");
            return (Criteria) this;
        }

        public Criteria andTexRegistrationNoEqualTo(String value) {
            addCriterion("tex_registration_no =", value, "texRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTexRegistrationNoNotEqualTo(String value) {
            addCriterion("tex_registration_no <>", value, "texRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTexRegistrationNoGreaterThan(String value) {
            addCriterion("tex_registration_no >", value, "texRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTexRegistrationNoGreaterThanOrEqualTo(String value) {
            addCriterion("tex_registration_no >=", value, "texRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTexRegistrationNoLessThan(String value) {
            addCriterion("tex_registration_no <", value, "texRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTexRegistrationNoLessThanOrEqualTo(String value) {
            addCriterion("tex_registration_no <=", value, "texRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTexRegistrationNoLike(String value) {
            addCriterion("tex_registration_no like", value, "texRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTexRegistrationNoNotLike(String value) {
            addCriterion("tex_registration_no not like", value, "texRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTexRegistrationNoIn(List<String> values) {
            addCriterion("tex_registration_no in", values, "texRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTexRegistrationNoNotIn(List<String> values) {
            addCriterion("tex_registration_no not in", values, "texRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTexRegistrationNoBetween(String value1, String value2) {
            addCriterion("tex_registration_no between", value1, value2, "texRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andTexRegistrationNoNotBetween(String value1, String value2) {
            addCriterion("tex_registration_no not between", value1, value2, "texRegistrationNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNull() {
            addCriterion("business_license is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNotNull() {
            addCriterion("business_license is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseEqualTo(String value) {
            addCriterion("business_license =", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotEqualTo(String value) {
            addCriterion("business_license <>", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThan(String value) {
            addCriterion("business_license >", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("business_license >=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThan(String value) {
            addCriterion("business_license <", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("business_license <=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLike(String value) {
            addCriterion("business_license like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotLike(String value) {
            addCriterion("business_license not like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIn(List<String> values) {
            addCriterion("business_license in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotIn(List<String> values) {
            addCriterion("business_license not in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBetween(String value1, String value2) {
            addCriterion("business_license between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("business_license not between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andIsOtherLicenseIsNull() {
            addCriterion("is_other_license is null");
            return (Criteria) this;
        }

        public Criteria andIsOtherLicenseIsNotNull() {
            addCriterion("is_other_license is not null");
            return (Criteria) this;
        }

        public Criteria andIsOtherLicenseEqualTo(Integer value) {
            addCriterion("is_other_license =", value, "isOtherLicense");
            return (Criteria) this;
        }

        public Criteria andIsOtherLicenseNotEqualTo(Integer value) {
            addCriterion("is_other_license <>", value, "isOtherLicense");
            return (Criteria) this;
        }

        public Criteria andIsOtherLicenseGreaterThan(Integer value) {
            addCriterion("is_other_license >", value, "isOtherLicense");
            return (Criteria) this;
        }

        public Criteria andIsOtherLicenseGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_other_license >=", value, "isOtherLicense");
            return (Criteria) this;
        }

        public Criteria andIsOtherLicenseLessThan(Integer value) {
            addCriterion("is_other_license <", value, "isOtherLicense");
            return (Criteria) this;
        }

        public Criteria andIsOtherLicenseLessThanOrEqualTo(Integer value) {
            addCriterion("is_other_license <=", value, "isOtherLicense");
            return (Criteria) this;
        }

        public Criteria andIsOtherLicenseIn(List<Integer> values) {
            addCriterion("is_other_license in", values, "isOtherLicense");
            return (Criteria) this;
        }

        public Criteria andIsOtherLicenseNotIn(List<Integer> values) {
            addCriterion("is_other_license not in", values, "isOtherLicense");
            return (Criteria) this;
        }

        public Criteria andIsOtherLicenseBetween(Integer value1, Integer value2) {
            addCriterion("is_other_license between", value1, value2, "isOtherLicense");
            return (Criteria) this;
        }

        public Criteria andIsOtherLicenseNotBetween(Integer value1, Integer value2) {
            addCriterion("is_other_license not between", value1, value2, "isOtherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseIsNull() {
            addCriterion("other_license is null");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseIsNotNull() {
            addCriterion("other_license is not null");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseEqualTo(String value) {
            addCriterion("other_license =", value, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseNotEqualTo(String value) {
            addCriterion("other_license <>", value, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseGreaterThan(String value) {
            addCriterion("other_license >", value, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("other_license >=", value, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseLessThan(String value) {
            addCriterion("other_license <", value, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseLessThanOrEqualTo(String value) {
            addCriterion("other_license <=", value, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseLike(String value) {
            addCriterion("other_license like", value, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseNotLike(String value) {
            addCriterion("other_license not like", value, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseIn(List<String> values) {
            addCriterion("other_license in", values, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseNotIn(List<String> values) {
            addCriterion("other_license not in", values, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseBetween(String value1, String value2) {
            addCriterion("other_license between", value1, value2, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseNotBetween(String value1, String value2) {
            addCriterion("other_license not between", value1, value2, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverIsNull() {
            addCriterion("target_month_turnover is null");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverIsNotNull() {
            addCriterion("target_month_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverEqualTo(Long value) {
            addCriterion("target_month_turnover =", value, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverNotEqualTo(Long value) {
            addCriterion("target_month_turnover <>", value, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverGreaterThan(Long value) {
            addCriterion("target_month_turnover >", value, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverGreaterThanOrEqualTo(Long value) {
            addCriterion("target_month_turnover >=", value, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverLessThan(Long value) {
            addCriterion("target_month_turnover <", value, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverLessThanOrEqualTo(Long value) {
            addCriterion("target_month_turnover <=", value, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverIn(List<Long> values) {
            addCriterion("target_month_turnover in", values, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverNotIn(List<Long> values) {
            addCriterion("target_month_turnover not in", values, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverBetween(Long value1, Long value2) {
            addCriterion("target_month_turnover between", value1, value2, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverNotBetween(Long value1, Long value2) {
            addCriterion("target_month_turnover not between", value1, value2, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andContactPersonIsNull() {
            addCriterion("contact_person is null");
            return (Criteria) this;
        }

        public Criteria andContactPersonIsNotNull() {
            addCriterion("contact_person is not null");
            return (Criteria) this;
        }

        public Criteria andContactPersonEqualTo(String value) {
            addCriterion("contact_person =", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotEqualTo(String value) {
            addCriterion("contact_person <>", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonGreaterThan(String value) {
            addCriterion("contact_person >", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonGreaterThanOrEqualTo(String value) {
            addCriterion("contact_person >=", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonLessThan(String value) {
            addCriterion("contact_person <", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonLessThanOrEqualTo(String value) {
            addCriterion("contact_person <=", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonLike(String value) {
            addCriterion("contact_person like", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotLike(String value) {
            addCriterion("contact_person not like", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonIn(List<String> values) {
            addCriterion("contact_person in", values, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotIn(List<String> values) {
            addCriterion("contact_person not in", values, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonBetween(String value1, String value2) {
            addCriterion("contact_person between", value1, value2, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotBetween(String value1, String value2) {
            addCriterion("contact_person not between", value1, value2, "contactPerson");
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

        public Criteria andProvinceAreaIdIsNull() {
            addCriterion("province_area_id is null");
            return (Criteria) this;
        }

        public Criteria andProvinceAreaIdIsNotNull() {
            addCriterion("province_area_id is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceAreaIdEqualTo(Integer value) {
            addCriterion("province_area_id =", value, "provinceAreaId");
            return (Criteria) this;
        }

        public Criteria andProvinceAreaIdNotEqualTo(Integer value) {
            addCriterion("province_area_id <>", value, "provinceAreaId");
            return (Criteria) this;
        }

        public Criteria andProvinceAreaIdGreaterThan(Integer value) {
            addCriterion("province_area_id >", value, "provinceAreaId");
            return (Criteria) this;
        }

        public Criteria andProvinceAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("province_area_id >=", value, "provinceAreaId");
            return (Criteria) this;
        }

        public Criteria andProvinceAreaIdLessThan(Integer value) {
            addCriterion("province_area_id <", value, "provinceAreaId");
            return (Criteria) this;
        }

        public Criteria andProvinceAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("province_area_id <=", value, "provinceAreaId");
            return (Criteria) this;
        }

        public Criteria andProvinceAreaIdIn(List<Integer> values) {
            addCriterion("province_area_id in", values, "provinceAreaId");
            return (Criteria) this;
        }

        public Criteria andProvinceAreaIdNotIn(List<Integer> values) {
            addCriterion("province_area_id not in", values, "provinceAreaId");
            return (Criteria) this;
        }

        public Criteria andProvinceAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("province_area_id between", value1, value2, "provinceAreaId");
            return (Criteria) this;
        }

        public Criteria andProvinceAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("province_area_id not between", value1, value2, "provinceAreaId");
            return (Criteria) this;
        }

        public Criteria andCityAreaIdIsNull() {
            addCriterion("city_area_id is null");
            return (Criteria) this;
        }

        public Criteria andCityAreaIdIsNotNull() {
            addCriterion("city_area_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityAreaIdEqualTo(Integer value) {
            addCriterion("city_area_id =", value, "cityAreaId");
            return (Criteria) this;
        }

        public Criteria andCityAreaIdNotEqualTo(Integer value) {
            addCriterion("city_area_id <>", value, "cityAreaId");
            return (Criteria) this;
        }

        public Criteria andCityAreaIdGreaterThan(Integer value) {
            addCriterion("city_area_id >", value, "cityAreaId");
            return (Criteria) this;
        }

        public Criteria andCityAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_area_id >=", value, "cityAreaId");
            return (Criteria) this;
        }

        public Criteria andCityAreaIdLessThan(Integer value) {
            addCriterion("city_area_id <", value, "cityAreaId");
            return (Criteria) this;
        }

        public Criteria andCityAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_area_id <=", value, "cityAreaId");
            return (Criteria) this;
        }

        public Criteria andCityAreaIdIn(List<Integer> values) {
            addCriterion("city_area_id in", values, "cityAreaId");
            return (Criteria) this;
        }

        public Criteria andCityAreaIdNotIn(List<Integer> values) {
            addCriterion("city_area_id not in", values, "cityAreaId");
            return (Criteria) this;
        }

        public Criteria andCityAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("city_area_id between", value1, value2, "cityAreaId");
            return (Criteria) this;
        }

        public Criteria andCityAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_area_id not between", value1, value2, "cityAreaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaInfoIsNull() {
            addCriterion("area_info is null");
            return (Criteria) this;
        }

        public Criteria andAreaInfoIsNotNull() {
            addCriterion("area_info is not null");
            return (Criteria) this;
        }

        public Criteria andAreaInfoEqualTo(String value) {
            addCriterion("area_info =", value, "areaInfo");
            return (Criteria) this;
        }

        public Criteria andAreaInfoNotEqualTo(String value) {
            addCriterion("area_info <>", value, "areaInfo");
            return (Criteria) this;
        }

        public Criteria andAreaInfoGreaterThan(String value) {
            addCriterion("area_info >", value, "areaInfo");
            return (Criteria) this;
        }

        public Criteria andAreaInfoGreaterThanOrEqualTo(String value) {
            addCriterion("area_info >=", value, "areaInfo");
            return (Criteria) this;
        }

        public Criteria andAreaInfoLessThan(String value) {
            addCriterion("area_info <", value, "areaInfo");
            return (Criteria) this;
        }

        public Criteria andAreaInfoLessThanOrEqualTo(String value) {
            addCriterion("area_info <=", value, "areaInfo");
            return (Criteria) this;
        }

        public Criteria andAreaInfoLike(String value) {
            addCriterion("area_info like", value, "areaInfo");
            return (Criteria) this;
        }

        public Criteria andAreaInfoNotLike(String value) {
            addCriterion("area_info not like", value, "areaInfo");
            return (Criteria) this;
        }

        public Criteria andAreaInfoIn(List<String> values) {
            addCriterion("area_info in", values, "areaInfo");
            return (Criteria) this;
        }

        public Criteria andAreaInfoNotIn(List<String> values) {
            addCriterion("area_info not in", values, "areaInfo");
            return (Criteria) this;
        }

        public Criteria andAreaInfoBetween(String value1, String value2) {
            addCriterion("area_info between", value1, value2, "areaInfo");
            return (Criteria) this;
        }

        public Criteria andAreaInfoNotBetween(String value1, String value2) {
            addCriterion("area_info not between", value1, value2, "areaInfo");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusContentIsNull() {
            addCriterion("status_content is null");
            return (Criteria) this;
        }

        public Criteria andStatusContentIsNotNull() {
            addCriterion("status_content is not null");
            return (Criteria) this;
        }

        public Criteria andStatusContentEqualTo(String value) {
            addCriterion("status_content =", value, "statusContent");
            return (Criteria) this;
        }

        public Criteria andStatusContentNotEqualTo(String value) {
            addCriterion("status_content <>", value, "statusContent");
            return (Criteria) this;
        }

        public Criteria andStatusContentGreaterThan(String value) {
            addCriterion("status_content >", value, "statusContent");
            return (Criteria) this;
        }

        public Criteria andStatusContentGreaterThanOrEqualTo(String value) {
            addCriterion("status_content >=", value, "statusContent");
            return (Criteria) this;
        }

        public Criteria andStatusContentLessThan(String value) {
            addCriterion("status_content <", value, "statusContent");
            return (Criteria) this;
        }

        public Criteria andStatusContentLessThanOrEqualTo(String value) {
            addCriterion("status_content <=", value, "statusContent");
            return (Criteria) this;
        }

        public Criteria andStatusContentLike(String value) {
            addCriterion("status_content like", value, "statusContent");
            return (Criteria) this;
        }

        public Criteria andStatusContentNotLike(String value) {
            addCriterion("status_content not like", value, "statusContent");
            return (Criteria) this;
        }

        public Criteria andStatusContentIn(List<String> values) {
            addCriterion("status_content in", values, "statusContent");
            return (Criteria) this;
        }

        public Criteria andStatusContentNotIn(List<String> values) {
            addCriterion("status_content not in", values, "statusContent");
            return (Criteria) this;
        }

        public Criteria andStatusContentBetween(String value1, String value2) {
            addCriterion("status_content between", value1, value2, "statusContent");
            return (Criteria) this;
        }

        public Criteria andStatusContentNotBetween(String value1, String value2) {
            addCriterion("status_content not between", value1, value2, "statusContent");
            return (Criteria) this;
        }

        public Criteria andBankTitleIsNull() {
            addCriterion("bank_title is null");
            return (Criteria) this;
        }

        public Criteria andBankTitleIsNotNull() {
            addCriterion("bank_title is not null");
            return (Criteria) this;
        }

        public Criteria andBankTitleEqualTo(String value) {
            addCriterion("bank_title =", value, "bankTitle");
            return (Criteria) this;
        }

        public Criteria andBankTitleNotEqualTo(String value) {
            addCriterion("bank_title <>", value, "bankTitle");
            return (Criteria) this;
        }

        public Criteria andBankTitleGreaterThan(String value) {
            addCriterion("bank_title >", value, "bankTitle");
            return (Criteria) this;
        }

        public Criteria andBankTitleGreaterThanOrEqualTo(String value) {
            addCriterion("bank_title >=", value, "bankTitle");
            return (Criteria) this;
        }

        public Criteria andBankTitleLessThan(String value) {
            addCriterion("bank_title <", value, "bankTitle");
            return (Criteria) this;
        }

        public Criteria andBankTitleLessThanOrEqualTo(String value) {
            addCriterion("bank_title <=", value, "bankTitle");
            return (Criteria) this;
        }

        public Criteria andBankTitleLike(String value) {
            addCriterion("bank_title like", value, "bankTitle");
            return (Criteria) this;
        }

        public Criteria andBankTitleNotLike(String value) {
            addCriterion("bank_title not like", value, "bankTitle");
            return (Criteria) this;
        }

        public Criteria andBankTitleIn(List<String> values) {
            addCriterion("bank_title in", values, "bankTitle");
            return (Criteria) this;
        }

        public Criteria andBankTitleNotIn(List<String> values) {
            addCriterion("bank_title not in", values, "bankTitle");
            return (Criteria) this;
        }

        public Criteria andBankTitleBetween(String value1, String value2) {
            addCriterion("bank_title between", value1, value2, "bankTitle");
            return (Criteria) this;
        }

        public Criteria andBankTitleNotBetween(String value1, String value2) {
            addCriterion("bank_title not between", value1, value2, "bankTitle");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameIsNull() {
            addCriterion("bank_account_name is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameIsNotNull() {
            addCriterion("bank_account_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameEqualTo(String value) {
            addCriterion("bank_account_name =", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotEqualTo(String value) {
            addCriterion("bank_account_name <>", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameGreaterThan(String value) {
            addCriterion("bank_account_name >", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account_name >=", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameLessThan(String value) {
            addCriterion("bank_account_name <", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameLessThanOrEqualTo(String value) {
            addCriterion("bank_account_name <=", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameLike(String value) {
            addCriterion("bank_account_name like", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotLike(String value) {
            addCriterion("bank_account_name not like", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameIn(List<String> values) {
            addCriterion("bank_account_name in", values, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotIn(List<String> values) {
            addCriterion("bank_account_name not in", values, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameBetween(String value1, String value2) {
            addCriterion("bank_account_name between", value1, value2, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotBetween(String value1, String value2) {
            addCriterion("bank_account_name not between", value1, value2, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("bank_account is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("bank_account =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("bank_account <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("bank_account >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("bank_account <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_account <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("bank_account like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("bank_account not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("bank_account in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("bank_account not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("bank_account between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("bank_account not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNull() {
            addCriterion("id_number is null");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNotNull() {
            addCriterion("id_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumberEqualTo(String value) {
            addCriterion("id_number =", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotEqualTo(String value) {
            addCriterion("id_number <>", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThan(String value) {
            addCriterion("id_number >", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("id_number >=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThan(String value) {
            addCriterion("id_number <", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThanOrEqualTo(String value) {
            addCriterion("id_number <=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLike(String value) {
            addCriterion("id_number like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotLike(String value) {
            addCriterion("id_number not like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberIn(List<String> values) {
            addCriterion("id_number in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotIn(List<String> values) {
            addCriterion("id_number not in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberBetween(String value1, String value2) {
            addCriterion("id_number between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotBetween(String value1, String value2) {
            addCriterion("id_number not between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdPositiveIsNull() {
            addCriterion("id_positive is null");
            return (Criteria) this;
        }

        public Criteria andIdPositiveIsNotNull() {
            addCriterion("id_positive is not null");
            return (Criteria) this;
        }

        public Criteria andIdPositiveEqualTo(String value) {
            addCriterion("id_positive =", value, "idPositive");
            return (Criteria) this;
        }

        public Criteria andIdPositiveNotEqualTo(String value) {
            addCriterion("id_positive <>", value, "idPositive");
            return (Criteria) this;
        }

        public Criteria andIdPositiveGreaterThan(String value) {
            addCriterion("id_positive >", value, "idPositive");
            return (Criteria) this;
        }

        public Criteria andIdPositiveGreaterThanOrEqualTo(String value) {
            addCriterion("id_positive >=", value, "idPositive");
            return (Criteria) this;
        }

        public Criteria andIdPositiveLessThan(String value) {
            addCriterion("id_positive <", value, "idPositive");
            return (Criteria) this;
        }

        public Criteria andIdPositiveLessThanOrEqualTo(String value) {
            addCriterion("id_positive <=", value, "idPositive");
            return (Criteria) this;
        }

        public Criteria andIdPositiveLike(String value) {
            addCriterion("id_positive like", value, "idPositive");
            return (Criteria) this;
        }

        public Criteria andIdPositiveNotLike(String value) {
            addCriterion("id_positive not like", value, "idPositive");
            return (Criteria) this;
        }

        public Criteria andIdPositiveIn(List<String> values) {
            addCriterion("id_positive in", values, "idPositive");
            return (Criteria) this;
        }

        public Criteria andIdPositiveNotIn(List<String> values) {
            addCriterion("id_positive not in", values, "idPositive");
            return (Criteria) this;
        }

        public Criteria andIdPositiveBetween(String value1, String value2) {
            addCriterion("id_positive between", value1, value2, "idPositive");
            return (Criteria) this;
        }

        public Criteria andIdPositiveNotBetween(String value1, String value2) {
            addCriterion("id_positive not between", value1, value2, "idPositive");
            return (Criteria) this;
        }

        public Criteria andIdObverseIsNull() {
            addCriterion("id_obverse is null");
            return (Criteria) this;
        }

        public Criteria andIdObverseIsNotNull() {
            addCriterion("id_obverse is not null");
            return (Criteria) this;
        }

        public Criteria andIdObverseEqualTo(String value) {
            addCriterion("id_obverse =", value, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseNotEqualTo(String value) {
            addCriterion("id_obverse <>", value, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseGreaterThan(String value) {
            addCriterion("id_obverse >", value, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseGreaterThanOrEqualTo(String value) {
            addCriterion("id_obverse >=", value, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseLessThan(String value) {
            addCriterion("id_obverse <", value, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseLessThanOrEqualTo(String value) {
            addCriterion("id_obverse <=", value, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseLike(String value) {
            addCriterion("id_obverse like", value, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseNotLike(String value) {
            addCriterion("id_obverse not like", value, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseIn(List<String> values) {
            addCriterion("id_obverse in", values, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseNotIn(List<String> values) {
            addCriterion("id_obverse not in", values, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseBetween(String value1, String value2) {
            addCriterion("id_obverse between", value1, value2, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseNotBetween(String value1, String value2) {
            addCriterion("id_obverse not between", value1, value2, "idObverse");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNull() {
            addCriterion("mch_id is null");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNotNull() {
            addCriterion("mch_id is not null");
            return (Criteria) this;
        }

        public Criteria andMchIdEqualTo(String value) {
            addCriterion("mch_id =", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotEqualTo(String value) {
            addCriterion("mch_id <>", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThan(String value) {
            addCriterion("mch_id >", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("mch_id >=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThan(String value) {
            addCriterion("mch_id <", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThanOrEqualTo(String value) {
            addCriterion("mch_id <=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLike(String value) {
            addCriterion("mch_id like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotLike(String value) {
            addCriterion("mch_id not like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdIn(List<String> values) {
            addCriterion("mch_id in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotIn(List<String> values) {
            addCriterion("mch_id not in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdBetween(String value1, String value2) {
            addCriterion("mch_id between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotBetween(String value1, String value2) {
            addCriterion("mch_id not between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Long value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Long value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Long value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Long value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Long value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Long> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Long> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Long value1, Long value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Long value1, Long value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andXfsjStatusIsNull() {
            addCriterion("xfsj_status is null");
            return (Criteria) this;
        }

        public Criteria andXfsjStatusIsNotNull() {
            addCriterion("xfsj_status is not null");
            return (Criteria) this;
        }

        public Criteria andXfsjStatusEqualTo(Integer value) {
            addCriterion("xfsj_status =", value, "xfsjStatus");
            return (Criteria) this;
        }

        public Criteria andXfsjStatusNotEqualTo(Integer value) {
            addCriterion("xfsj_status <>", value, "xfsjStatus");
            return (Criteria) this;
        }

        public Criteria andXfsjStatusGreaterThan(Integer value) {
            addCriterion("xfsj_status >", value, "xfsjStatus");
            return (Criteria) this;
        }

        public Criteria andXfsjStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("xfsj_status >=", value, "xfsjStatus");
            return (Criteria) this;
        }

        public Criteria andXfsjStatusLessThan(Integer value) {
            addCriterion("xfsj_status <", value, "xfsjStatus");
            return (Criteria) this;
        }

        public Criteria andXfsjStatusLessThanOrEqualTo(Integer value) {
            addCriterion("xfsj_status <=", value, "xfsjStatus");
            return (Criteria) this;
        }

        public Criteria andXfsjStatusIn(List<Integer> values) {
            addCriterion("xfsj_status in", values, "xfsjStatus");
            return (Criteria) this;
        }

        public Criteria andXfsjStatusNotIn(List<Integer> values) {
            addCriterion("xfsj_status not in", values, "xfsjStatus");
            return (Criteria) this;
        }

        public Criteria andXfsjStatusBetween(Integer value1, Integer value2) {
            addCriterion("xfsj_status between", value1, value2, "xfsjStatus");
            return (Criteria) this;
        }

        public Criteria andXfsjStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("xfsj_status not between", value1, value2, "xfsjStatus");
            return (Criteria) this;
        }

        public Criteria andLegalNameIsNull() {
            addCriterion("legal_name is null");
            return (Criteria) this;
        }

        public Criteria andLegalNameIsNotNull() {
            addCriterion("legal_name is not null");
            return (Criteria) this;
        }

        public Criteria andLegalNameEqualTo(String value) {
            addCriterion("legal_name =", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotEqualTo(String value) {
            addCriterion("legal_name <>", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameGreaterThan(String value) {
            addCriterion("legal_name >", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameGreaterThanOrEqualTo(String value) {
            addCriterion("legal_name >=", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLessThan(String value) {
            addCriterion("legal_name <", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLessThanOrEqualTo(String value) {
            addCriterion("legal_name <=", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLike(String value) {
            addCriterion("legal_name like", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotLike(String value) {
            addCriterion("legal_name not like", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameIn(List<String> values) {
            addCriterion("legal_name in", values, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotIn(List<String> values) {
            addCriterion("legal_name not in", values, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameBetween(String value1, String value2) {
            addCriterion("legal_name between", value1, value2, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotBetween(String value1, String value2) {
            addCriterion("legal_name not between", value1, value2, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardIsNull() {
            addCriterion("legal_id_card is null");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardIsNotNull() {
            addCriterion("legal_id_card is not null");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardEqualTo(String value) {
            addCriterion("legal_id_card =", value, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardNotEqualTo(String value) {
            addCriterion("legal_id_card <>", value, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardGreaterThan(String value) {
            addCriterion("legal_id_card >", value, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("legal_id_card >=", value, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardLessThan(String value) {
            addCriterion("legal_id_card <", value, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardLessThanOrEqualTo(String value) {
            addCriterion("legal_id_card <=", value, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardLike(String value) {
            addCriterion("legal_id_card like", value, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardNotLike(String value) {
            addCriterion("legal_id_card not like", value, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardIn(List<String> values) {
            addCriterion("legal_id_card in", values, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardNotIn(List<String> values) {
            addCriterion("legal_id_card not in", values, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardBetween(String value1, String value2) {
            addCriterion("legal_id_card between", value1, value2, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardNotBetween(String value1, String value2) {
            addCriterion("legal_id_card not between", value1, value2, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdPositiveIsNull() {
            addCriterion("legal_id_positive is null");
            return (Criteria) this;
        }

        public Criteria andLegalIdPositiveIsNotNull() {
            addCriterion("legal_id_positive is not null");
            return (Criteria) this;
        }

        public Criteria andLegalIdPositiveEqualTo(String value) {
            addCriterion("legal_id_positive =", value, "legalIdPositive");
            return (Criteria) this;
        }

        public Criteria andLegalIdPositiveNotEqualTo(String value) {
            addCriterion("legal_id_positive <>", value, "legalIdPositive");
            return (Criteria) this;
        }

        public Criteria andLegalIdPositiveGreaterThan(String value) {
            addCriterion("legal_id_positive >", value, "legalIdPositive");
            return (Criteria) this;
        }

        public Criteria andLegalIdPositiveGreaterThanOrEqualTo(String value) {
            addCriterion("legal_id_positive >=", value, "legalIdPositive");
            return (Criteria) this;
        }

        public Criteria andLegalIdPositiveLessThan(String value) {
            addCriterion("legal_id_positive <", value, "legalIdPositive");
            return (Criteria) this;
        }

        public Criteria andLegalIdPositiveLessThanOrEqualTo(String value) {
            addCriterion("legal_id_positive <=", value, "legalIdPositive");
            return (Criteria) this;
        }

        public Criteria andLegalIdPositiveLike(String value) {
            addCriterion("legal_id_positive like", value, "legalIdPositive");
            return (Criteria) this;
        }

        public Criteria andLegalIdPositiveNotLike(String value) {
            addCriterion("legal_id_positive not like", value, "legalIdPositive");
            return (Criteria) this;
        }

        public Criteria andLegalIdPositiveIn(List<String> values) {
            addCriterion("legal_id_positive in", values, "legalIdPositive");
            return (Criteria) this;
        }

        public Criteria andLegalIdPositiveNotIn(List<String> values) {
            addCriterion("legal_id_positive not in", values, "legalIdPositive");
            return (Criteria) this;
        }

        public Criteria andLegalIdPositiveBetween(String value1, String value2) {
            addCriterion("legal_id_positive between", value1, value2, "legalIdPositive");
            return (Criteria) this;
        }

        public Criteria andLegalIdPositiveNotBetween(String value1, String value2) {
            addCriterion("legal_id_positive not between", value1, value2, "legalIdPositive");
            return (Criteria) this;
        }

        public Criteria andLegalIdBackIsNull() {
            addCriterion("legal_id_back is null");
            return (Criteria) this;
        }

        public Criteria andLegalIdBackIsNotNull() {
            addCriterion("legal_id_back is not null");
            return (Criteria) this;
        }

        public Criteria andLegalIdBackEqualTo(String value) {
            addCriterion("legal_id_back =", value, "legalIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalIdBackNotEqualTo(String value) {
            addCriterion("legal_id_back <>", value, "legalIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalIdBackGreaterThan(String value) {
            addCriterion("legal_id_back >", value, "legalIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalIdBackGreaterThanOrEqualTo(String value) {
            addCriterion("legal_id_back >=", value, "legalIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalIdBackLessThan(String value) {
            addCriterion("legal_id_back <", value, "legalIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalIdBackLessThanOrEqualTo(String value) {
            addCriterion("legal_id_back <=", value, "legalIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalIdBackLike(String value) {
            addCriterion("legal_id_back like", value, "legalIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalIdBackNotLike(String value) {
            addCriterion("legal_id_back not like", value, "legalIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalIdBackIn(List<String> values) {
            addCriterion("legal_id_back in", values, "legalIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalIdBackNotIn(List<String> values) {
            addCriterion("legal_id_back not in", values, "legalIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalIdBackBetween(String value1, String value2) {
            addCriterion("legal_id_back between", value1, value2, "legalIdBack");
            return (Criteria) this;
        }

        public Criteria andLegalIdBackNotBetween(String value1, String value2) {
            addCriterion("legal_id_back not between", value1, value2, "legalIdBack");
            return (Criteria) this;
        }

        public Criteria andSrcBusinessIsNull() {
            addCriterion("src_business is null");
            return (Criteria) this;
        }

        public Criteria andSrcBusinessIsNotNull() {
            addCriterion("src_business is not null");
            return (Criteria) this;
        }

        public Criteria andSrcBusinessEqualTo(String value) {
            addCriterion("src_business =", value, "srcBusiness");
            return (Criteria) this;
        }

        public Criteria andSrcBusinessNotEqualTo(String value) {
            addCriterion("src_business <>", value, "srcBusiness");
            return (Criteria) this;
        }

        public Criteria andSrcBusinessGreaterThan(String value) {
            addCriterion("src_business >", value, "srcBusiness");
            return (Criteria) this;
        }

        public Criteria andSrcBusinessGreaterThanOrEqualTo(String value) {
            addCriterion("src_business >=", value, "srcBusiness");
            return (Criteria) this;
        }

        public Criteria andSrcBusinessLessThan(String value) {
            addCriterion("src_business <", value, "srcBusiness");
            return (Criteria) this;
        }

        public Criteria andSrcBusinessLessThanOrEqualTo(String value) {
            addCriterion("src_business <=", value, "srcBusiness");
            return (Criteria) this;
        }

        public Criteria andSrcBusinessLike(String value) {
            addCriterion("src_business like", value, "srcBusiness");
            return (Criteria) this;
        }

        public Criteria andSrcBusinessNotLike(String value) {
            addCriterion("src_business not like", value, "srcBusiness");
            return (Criteria) this;
        }

        public Criteria andSrcBusinessIn(List<String> values) {
            addCriterion("src_business in", values, "srcBusiness");
            return (Criteria) this;
        }

        public Criteria andSrcBusinessNotIn(List<String> values) {
            addCriterion("src_business not in", values, "srcBusiness");
            return (Criteria) this;
        }

        public Criteria andSrcBusinessBetween(String value1, String value2) {
            addCriterion("src_business between", value1, value2, "srcBusiness");
            return (Criteria) this;
        }

        public Criteria andSrcBusinessNotBetween(String value1, String value2) {
            addCriterion("src_business not between", value1, value2, "srcBusiness");
            return (Criteria) this;
        }

        public Criteria andSrcCityIsNull() {
            addCriterion("src_city is null");
            return (Criteria) this;
        }

        public Criteria andSrcCityIsNotNull() {
            addCriterion("src_city is not null");
            return (Criteria) this;
        }

        public Criteria andSrcCityEqualTo(Integer value) {
            addCriterion("src_city =", value, "srcCity");
            return (Criteria) this;
        }

        public Criteria andSrcCityNotEqualTo(Integer value) {
            addCriterion("src_city <>", value, "srcCity");
            return (Criteria) this;
        }

        public Criteria andSrcCityGreaterThan(Integer value) {
            addCriterion("src_city >", value, "srcCity");
            return (Criteria) this;
        }

        public Criteria andSrcCityGreaterThanOrEqualTo(Integer value) {
            addCriterion("src_city >=", value, "srcCity");
            return (Criteria) this;
        }

        public Criteria andSrcCityLessThan(Integer value) {
            addCriterion("src_city <", value, "srcCity");
            return (Criteria) this;
        }

        public Criteria andSrcCityLessThanOrEqualTo(Integer value) {
            addCriterion("src_city <=", value, "srcCity");
            return (Criteria) this;
        }

        public Criteria andSrcCityIn(List<Integer> values) {
            addCriterion("src_city in", values, "srcCity");
            return (Criteria) this;
        }

        public Criteria andSrcCityNotIn(List<Integer> values) {
            addCriterion("src_city not in", values, "srcCity");
            return (Criteria) this;
        }

        public Criteria andSrcCityBetween(Integer value1, Integer value2) {
            addCriterion("src_city between", value1, value2, "srcCity");
            return (Criteria) this;
        }

        public Criteria andSrcCityNotBetween(Integer value1, Integer value2) {
            addCriterion("src_city not between", value1, value2, "srcCity");
            return (Criteria) this;
        }

        public Criteria andIsMandataryIsNull() {
            addCriterion("is_mandatary is null");
            return (Criteria) this;
        }

        public Criteria andIsMandataryIsNotNull() {
            addCriterion("is_mandatary is not null");
            return (Criteria) this;
        }

        public Criteria andIsMandataryEqualTo(Integer value) {
            addCriterion("is_mandatary =", value, "isMandatary");
            return (Criteria) this;
        }

        public Criteria andIsMandataryNotEqualTo(Integer value) {
            addCriterion("is_mandatary <>", value, "isMandatary");
            return (Criteria) this;
        }

        public Criteria andIsMandataryGreaterThan(Integer value) {
            addCriterion("is_mandatary >", value, "isMandatary");
            return (Criteria) this;
        }

        public Criteria andIsMandataryGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_mandatary >=", value, "isMandatary");
            return (Criteria) this;
        }

        public Criteria andIsMandataryLessThan(Integer value) {
            addCriterion("is_mandatary <", value, "isMandatary");
            return (Criteria) this;
        }

        public Criteria andIsMandataryLessThanOrEqualTo(Integer value) {
            addCriterion("is_mandatary <=", value, "isMandatary");
            return (Criteria) this;
        }

        public Criteria andIsMandataryIn(List<Integer> values) {
            addCriterion("is_mandatary in", values, "isMandatary");
            return (Criteria) this;
        }

        public Criteria andIsMandataryNotIn(List<Integer> values) {
            addCriterion("is_mandatary not in", values, "isMandatary");
            return (Criteria) this;
        }

        public Criteria andIsMandataryBetween(Integer value1, Integer value2) {
            addCriterion("is_mandatary between", value1, value2, "isMandatary");
            return (Criteria) this;
        }

        public Criteria andIsMandataryNotBetween(Integer value1, Integer value2) {
            addCriterion("is_mandatary not between", value1, value2, "isMandatary");
            return (Criteria) this;
        }

        public Criteria andMandataryNameIsNull() {
            addCriterion("mandatary_name is null");
            return (Criteria) this;
        }

        public Criteria andMandataryNameIsNotNull() {
            addCriterion("mandatary_name is not null");
            return (Criteria) this;
        }

        public Criteria andMandataryNameEqualTo(String value) {
            addCriterion("mandatary_name =", value, "mandataryName");
            return (Criteria) this;
        }

        public Criteria andMandataryNameNotEqualTo(String value) {
            addCriterion("mandatary_name <>", value, "mandataryName");
            return (Criteria) this;
        }

        public Criteria andMandataryNameGreaterThan(String value) {
            addCriterion("mandatary_name >", value, "mandataryName");
            return (Criteria) this;
        }

        public Criteria andMandataryNameGreaterThanOrEqualTo(String value) {
            addCriterion("mandatary_name >=", value, "mandataryName");
            return (Criteria) this;
        }

        public Criteria andMandataryNameLessThan(String value) {
            addCriterion("mandatary_name <", value, "mandataryName");
            return (Criteria) this;
        }

        public Criteria andMandataryNameLessThanOrEqualTo(String value) {
            addCriterion("mandatary_name <=", value, "mandataryName");
            return (Criteria) this;
        }

        public Criteria andMandataryNameLike(String value) {
            addCriterion("mandatary_name like", value, "mandataryName");
            return (Criteria) this;
        }

        public Criteria andMandataryNameNotLike(String value) {
            addCriterion("mandatary_name not like", value, "mandataryName");
            return (Criteria) this;
        }

        public Criteria andMandataryNameIn(List<String> values) {
            addCriterion("mandatary_name in", values, "mandataryName");
            return (Criteria) this;
        }

        public Criteria andMandataryNameNotIn(List<String> values) {
            addCriterion("mandatary_name not in", values, "mandataryName");
            return (Criteria) this;
        }

        public Criteria andMandataryNameBetween(String value1, String value2) {
            addCriterion("mandatary_name between", value1, value2, "mandataryName");
            return (Criteria) this;
        }

        public Criteria andMandataryNameNotBetween(String value1, String value2) {
            addCriterion("mandatary_name not between", value1, value2, "mandataryName");
            return (Criteria) this;
        }

        public Criteria andMandataryIdCardIsNull() {
            addCriterion("mandatary_id_card is null");
            return (Criteria) this;
        }

        public Criteria andMandataryIdCardIsNotNull() {
            addCriterion("mandatary_id_card is not null");
            return (Criteria) this;
        }

        public Criteria andMandataryIdCardEqualTo(String value) {
            addCriterion("mandatary_id_card =", value, "mandataryIdCard");
            return (Criteria) this;
        }

        public Criteria andMandataryIdCardNotEqualTo(String value) {
            addCriterion("mandatary_id_card <>", value, "mandataryIdCard");
            return (Criteria) this;
        }

        public Criteria andMandataryIdCardGreaterThan(String value) {
            addCriterion("mandatary_id_card >", value, "mandataryIdCard");
            return (Criteria) this;
        }

        public Criteria andMandataryIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("mandatary_id_card >=", value, "mandataryIdCard");
            return (Criteria) this;
        }

        public Criteria andMandataryIdCardLessThan(String value) {
            addCriterion("mandatary_id_card <", value, "mandataryIdCard");
            return (Criteria) this;
        }

        public Criteria andMandataryIdCardLessThanOrEqualTo(String value) {
            addCriterion("mandatary_id_card <=", value, "mandataryIdCard");
            return (Criteria) this;
        }

        public Criteria andMandataryIdCardLike(String value) {
            addCriterion("mandatary_id_card like", value, "mandataryIdCard");
            return (Criteria) this;
        }

        public Criteria andMandataryIdCardNotLike(String value) {
            addCriterion("mandatary_id_card not like", value, "mandataryIdCard");
            return (Criteria) this;
        }

        public Criteria andMandataryIdCardIn(List<String> values) {
            addCriterion("mandatary_id_card in", values, "mandataryIdCard");
            return (Criteria) this;
        }

        public Criteria andMandataryIdCardNotIn(List<String> values) {
            addCriterion("mandatary_id_card not in", values, "mandataryIdCard");
            return (Criteria) this;
        }

        public Criteria andMandataryIdCardBetween(String value1, String value2) {
            addCriterion("mandatary_id_card between", value1, value2, "mandataryIdCard");
            return (Criteria) this;
        }

        public Criteria andMandataryIdCardNotBetween(String value1, String value2) {
            addCriterion("mandatary_id_card not between", value1, value2, "mandataryIdCard");
            return (Criteria) this;
        }

        public Criteria andMandataryIdPositiveIsNull() {
            addCriterion("mandatary_id_positive is null");
            return (Criteria) this;
        }

        public Criteria andMandataryIdPositiveIsNotNull() {
            addCriterion("mandatary_id_positive is not null");
            return (Criteria) this;
        }

        public Criteria andMandataryIdPositiveEqualTo(String value) {
            addCriterion("mandatary_id_positive =", value, "mandataryIdPositive");
            return (Criteria) this;
        }

        public Criteria andMandataryIdPositiveNotEqualTo(String value) {
            addCriterion("mandatary_id_positive <>", value, "mandataryIdPositive");
            return (Criteria) this;
        }

        public Criteria andMandataryIdPositiveGreaterThan(String value) {
            addCriterion("mandatary_id_positive >", value, "mandataryIdPositive");
            return (Criteria) this;
        }

        public Criteria andMandataryIdPositiveGreaterThanOrEqualTo(String value) {
            addCriterion("mandatary_id_positive >=", value, "mandataryIdPositive");
            return (Criteria) this;
        }

        public Criteria andMandataryIdPositiveLessThan(String value) {
            addCriterion("mandatary_id_positive <", value, "mandataryIdPositive");
            return (Criteria) this;
        }

        public Criteria andMandataryIdPositiveLessThanOrEqualTo(String value) {
            addCriterion("mandatary_id_positive <=", value, "mandataryIdPositive");
            return (Criteria) this;
        }

        public Criteria andMandataryIdPositiveLike(String value) {
            addCriterion("mandatary_id_positive like", value, "mandataryIdPositive");
            return (Criteria) this;
        }

        public Criteria andMandataryIdPositiveNotLike(String value) {
            addCriterion("mandatary_id_positive not like", value, "mandataryIdPositive");
            return (Criteria) this;
        }

        public Criteria andMandataryIdPositiveIn(List<String> values) {
            addCriterion("mandatary_id_positive in", values, "mandataryIdPositive");
            return (Criteria) this;
        }

        public Criteria andMandataryIdPositiveNotIn(List<String> values) {
            addCriterion("mandatary_id_positive not in", values, "mandataryIdPositive");
            return (Criteria) this;
        }

        public Criteria andMandataryIdPositiveBetween(String value1, String value2) {
            addCriterion("mandatary_id_positive between", value1, value2, "mandataryIdPositive");
            return (Criteria) this;
        }

        public Criteria andMandataryIdPositiveNotBetween(String value1, String value2) {
            addCriterion("mandatary_id_positive not between", value1, value2, "mandataryIdPositive");
            return (Criteria) this;
        }

        public Criteria andMandataryIdBackIsNull() {
            addCriterion("mandatary_id_back is null");
            return (Criteria) this;
        }

        public Criteria andMandataryIdBackIsNotNull() {
            addCriterion("mandatary_id_back is not null");
            return (Criteria) this;
        }

        public Criteria andMandataryIdBackEqualTo(String value) {
            addCriterion("mandatary_id_back =", value, "mandataryIdBack");
            return (Criteria) this;
        }

        public Criteria andMandataryIdBackNotEqualTo(String value) {
            addCriterion("mandatary_id_back <>", value, "mandataryIdBack");
            return (Criteria) this;
        }

        public Criteria andMandataryIdBackGreaterThan(String value) {
            addCriterion("mandatary_id_back >", value, "mandataryIdBack");
            return (Criteria) this;
        }

        public Criteria andMandataryIdBackGreaterThanOrEqualTo(String value) {
            addCriterion("mandatary_id_back >=", value, "mandataryIdBack");
            return (Criteria) this;
        }

        public Criteria andMandataryIdBackLessThan(String value) {
            addCriterion("mandatary_id_back <", value, "mandataryIdBack");
            return (Criteria) this;
        }

        public Criteria andMandataryIdBackLessThanOrEqualTo(String value) {
            addCriterion("mandatary_id_back <=", value, "mandataryIdBack");
            return (Criteria) this;
        }

        public Criteria andMandataryIdBackLike(String value) {
            addCriterion("mandatary_id_back like", value, "mandataryIdBack");
            return (Criteria) this;
        }

        public Criteria andMandataryIdBackNotLike(String value) {
            addCriterion("mandatary_id_back not like", value, "mandataryIdBack");
            return (Criteria) this;
        }

        public Criteria andMandataryIdBackIn(List<String> values) {
            addCriterion("mandatary_id_back in", values, "mandataryIdBack");
            return (Criteria) this;
        }

        public Criteria andMandataryIdBackNotIn(List<String> values) {
            addCriterion("mandatary_id_back not in", values, "mandataryIdBack");
            return (Criteria) this;
        }

        public Criteria andMandataryIdBackBetween(String value1, String value2) {
            addCriterion("mandatary_id_back between", value1, value2, "mandataryIdBack");
            return (Criteria) this;
        }

        public Criteria andMandataryIdBackNotBetween(String value1, String value2) {
            addCriterion("mandatary_id_back not between", value1, value2, "mandataryIdBack");
            return (Criteria) this;
        }

        public Criteria andMandataryOtherIsNull() {
            addCriterion("mandatary_other is null");
            return (Criteria) this;
        }

        public Criteria andMandataryOtherIsNotNull() {
            addCriterion("mandatary_other is not null");
            return (Criteria) this;
        }

        public Criteria andMandataryOtherEqualTo(String value) {
            addCriterion("mandatary_other =", value, "mandataryOther");
            return (Criteria) this;
        }

        public Criteria andMandataryOtherNotEqualTo(String value) {
            addCriterion("mandatary_other <>", value, "mandataryOther");
            return (Criteria) this;
        }

        public Criteria andMandataryOtherGreaterThan(String value) {
            addCriterion("mandatary_other >", value, "mandataryOther");
            return (Criteria) this;
        }

        public Criteria andMandataryOtherGreaterThanOrEqualTo(String value) {
            addCriterion("mandatary_other >=", value, "mandataryOther");
            return (Criteria) this;
        }

        public Criteria andMandataryOtherLessThan(String value) {
            addCriterion("mandatary_other <", value, "mandataryOther");
            return (Criteria) this;
        }

        public Criteria andMandataryOtherLessThanOrEqualTo(String value) {
            addCriterion("mandatary_other <=", value, "mandataryOther");
            return (Criteria) this;
        }

        public Criteria andMandataryOtherLike(String value) {
            addCriterion("mandatary_other like", value, "mandataryOther");
            return (Criteria) this;
        }

        public Criteria andMandataryOtherNotLike(String value) {
            addCriterion("mandatary_other not like", value, "mandataryOther");
            return (Criteria) this;
        }

        public Criteria andMandataryOtherIn(List<String> values) {
            addCriterion("mandatary_other in", values, "mandataryOther");
            return (Criteria) this;
        }

        public Criteria andMandataryOtherNotIn(List<String> values) {
            addCriterion("mandatary_other not in", values, "mandataryOther");
            return (Criteria) this;
        }

        public Criteria andMandataryOtherBetween(String value1, String value2) {
            addCriterion("mandatary_other between", value1, value2, "mandataryOther");
            return (Criteria) this;
        }

        public Criteria andMandataryOtherNotBetween(String value1, String value2) {
            addCriterion("mandatary_other not between", value1, value2, "mandataryOther");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(String value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(String value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(String value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(String value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(String value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(String value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLike(String value) {
            addCriterion("audit_status like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotLike(String value) {
            addCriterion("audit_status not like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<String> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<String> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(String value1, String value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(String value1, String value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
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