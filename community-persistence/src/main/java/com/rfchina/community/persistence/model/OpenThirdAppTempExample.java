package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenThirdAppTempExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenThirdAppTempExample() {
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

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(Long value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(Long value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(Long value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(Long value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(Long value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(Long value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<Long> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<Long> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(Long value1, Long value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(Long value1, Long value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
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

        public Criteria andAuditCommentIsNull() {
            addCriterion("audit_comment is null");
            return (Criteria) this;
        }

        public Criteria andAuditCommentIsNotNull() {
            addCriterion("audit_comment is not null");
            return (Criteria) this;
        }

        public Criteria andAuditCommentEqualTo(String value) {
            addCriterion("audit_comment =", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentNotEqualTo(String value) {
            addCriterion("audit_comment <>", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentGreaterThan(String value) {
            addCriterion("audit_comment >", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentGreaterThanOrEqualTo(String value) {
            addCriterion("audit_comment >=", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentLessThan(String value) {
            addCriterion("audit_comment <", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentLessThanOrEqualTo(String value) {
            addCriterion("audit_comment <=", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentLike(String value) {
            addCriterion("audit_comment like", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentNotLike(String value) {
            addCriterion("audit_comment not like", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentIn(List<String> values) {
            addCriterion("audit_comment in", values, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentNotIn(List<String> values) {
            addCriterion("audit_comment not in", values, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentBetween(String value1, String value2) {
            addCriterion("audit_comment between", value1, value2, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentNotBetween(String value1, String value2) {
            addCriterion("audit_comment not between", value1, value2, "auditComment");
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

        public Criteria andAuditTimeIsNull() {
            addCriterion("audit_time is null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNotNull() {
            addCriterion("audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeEqualTo(Date value) {
            addCriterion("audit_time =", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotEqualTo(Date value) {
            addCriterion("audit_time <>", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThan(Date value) {
            addCriterion("audit_time >", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_time >=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThan(Date value) {
            addCriterion("audit_time <", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("audit_time <=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIn(List<Date> values) {
            addCriterion("audit_time in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotIn(List<Date> values) {
            addCriterion("audit_time not in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeBetween(Date value1, Date value2) {
            addCriterion("audit_time between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("audit_time not between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Long value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Long value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Long value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Long value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Long> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Long> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Long value1, Long value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andIsNeedHardwareIsNull() {
            addCriterion("is_need_hardware is null");
            return (Criteria) this;
        }

        public Criteria andIsNeedHardwareIsNotNull() {
            addCriterion("is_need_hardware is not null");
            return (Criteria) this;
        }

        public Criteria andIsNeedHardwareEqualTo(Integer value) {
            addCriterion("is_need_hardware =", value, "isNeedHardware");
            return (Criteria) this;
        }

        public Criteria andIsNeedHardwareNotEqualTo(Integer value) {
            addCriterion("is_need_hardware <>", value, "isNeedHardware");
            return (Criteria) this;
        }

        public Criteria andIsNeedHardwareGreaterThan(Integer value) {
            addCriterion("is_need_hardware >", value, "isNeedHardware");
            return (Criteria) this;
        }

        public Criteria andIsNeedHardwareGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_need_hardware >=", value, "isNeedHardware");
            return (Criteria) this;
        }

        public Criteria andIsNeedHardwareLessThan(Integer value) {
            addCriterion("is_need_hardware <", value, "isNeedHardware");
            return (Criteria) this;
        }

        public Criteria andIsNeedHardwareLessThanOrEqualTo(Integer value) {
            addCriterion("is_need_hardware <=", value, "isNeedHardware");
            return (Criteria) this;
        }

        public Criteria andIsNeedHardwareIn(List<Integer> values) {
            addCriterion("is_need_hardware in", values, "isNeedHardware");
            return (Criteria) this;
        }

        public Criteria andIsNeedHardwareNotIn(List<Integer> values) {
            addCriterion("is_need_hardware not in", values, "isNeedHardware");
            return (Criteria) this;
        }

        public Criteria andIsNeedHardwareBetween(Integer value1, Integer value2) {
            addCriterion("is_need_hardware between", value1, value2, "isNeedHardware");
            return (Criteria) this;
        }

        public Criteria andIsNeedHardwareNotBetween(Integer value1, Integer value2) {
            addCriterion("is_need_hardware not between", value1, value2, "isNeedHardware");
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

        public Criteria andTargetMonthTurnoverEqualTo(BigDecimal value) {
            addCriterion("target_month_turnover =", value, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverNotEqualTo(BigDecimal value) {
            addCriterion("target_month_turnover <>", value, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverGreaterThan(BigDecimal value) {
            addCriterion("target_month_turnover >", value, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("target_month_turnover >=", value, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverLessThan(BigDecimal value) {
            addCriterion("target_month_turnover <", value, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverLessThanOrEqualTo(BigDecimal value) {
            addCriterion("target_month_turnover <=", value, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverIn(List<BigDecimal> values) {
            addCriterion("target_month_turnover in", values, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverNotIn(List<BigDecimal> values) {
            addCriterion("target_month_turnover not in", values, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("target_month_turnover between", value1, value2, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andTargetMonthTurnoverNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("target_month_turnover not between", value1, value2, "targetMonthTurnover");
            return (Criteria) this;
        }

        public Criteria andPaidCautionMoneyIsNull() {
            addCriterion("paid_caution_money is null");
            return (Criteria) this;
        }

        public Criteria andPaidCautionMoneyIsNotNull() {
            addCriterion("paid_caution_money is not null");
            return (Criteria) this;
        }

        public Criteria andPaidCautionMoneyEqualTo(BigDecimal value) {
            addCriterion("paid_caution_money =", value, "paidCautionMoney");
            return (Criteria) this;
        }

        public Criteria andPaidCautionMoneyNotEqualTo(BigDecimal value) {
            addCriterion("paid_caution_money <>", value, "paidCautionMoney");
            return (Criteria) this;
        }

        public Criteria andPaidCautionMoneyGreaterThan(BigDecimal value) {
            addCriterion("paid_caution_money >", value, "paidCautionMoney");
            return (Criteria) this;
        }

        public Criteria andPaidCautionMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("paid_caution_money >=", value, "paidCautionMoney");
            return (Criteria) this;
        }

        public Criteria andPaidCautionMoneyLessThan(BigDecimal value) {
            addCriterion("paid_caution_money <", value, "paidCautionMoney");
            return (Criteria) this;
        }

        public Criteria andPaidCautionMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("paid_caution_money <=", value, "paidCautionMoney");
            return (Criteria) this;
        }

        public Criteria andPaidCautionMoneyIn(List<BigDecimal> values) {
            addCriterion("paid_caution_money in", values, "paidCautionMoney");
            return (Criteria) this;
        }

        public Criteria andPaidCautionMoneyNotIn(List<BigDecimal> values) {
            addCriterion("paid_caution_money not in", values, "paidCautionMoney");
            return (Criteria) this;
        }

        public Criteria andPaidCautionMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paid_caution_money between", value1, value2, "paidCautionMoney");
            return (Criteria) this;
        }

        public Criteria andPaidCautionMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paid_caution_money not between", value1, value2, "paidCautionMoney");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyStatusIsNull() {
            addCriterion("caution_money_status is null");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyStatusIsNotNull() {
            addCriterion("caution_money_status is not null");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyStatusEqualTo(Integer value) {
            addCriterion("caution_money_status =", value, "cautionMoneyStatus");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyStatusNotEqualTo(Integer value) {
            addCriterion("caution_money_status <>", value, "cautionMoneyStatus");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyStatusGreaterThan(Integer value) {
            addCriterion("caution_money_status >", value, "cautionMoneyStatus");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("caution_money_status >=", value, "cautionMoneyStatus");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyStatusLessThan(Integer value) {
            addCriterion("caution_money_status <", value, "cautionMoneyStatus");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyStatusLessThanOrEqualTo(Integer value) {
            addCriterion("caution_money_status <=", value, "cautionMoneyStatus");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyStatusIn(List<Integer> values) {
            addCriterion("caution_money_status in", values, "cautionMoneyStatus");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyStatusNotIn(List<Integer> values) {
            addCriterion("caution_money_status not in", values, "cautionMoneyStatus");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyStatusBetween(Integer value1, Integer value2) {
            addCriterion("caution_money_status between", value1, value2, "cautionMoneyStatus");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("caution_money_status not between", value1, value2, "cautionMoneyStatus");
            return (Criteria) this;
        }

        public Criteria andGroundModeIsNull() {
            addCriterion("ground_mode is null");
            return (Criteria) this;
        }

        public Criteria andGroundModeIsNotNull() {
            addCriterion("ground_mode is not null");
            return (Criteria) this;
        }

        public Criteria andGroundModeEqualTo(Integer value) {
            addCriterion("ground_mode =", value, "groundMode");
            return (Criteria) this;
        }

        public Criteria andGroundModeNotEqualTo(Integer value) {
            addCriterion("ground_mode <>", value, "groundMode");
            return (Criteria) this;
        }

        public Criteria andGroundModeGreaterThan(Integer value) {
            addCriterion("ground_mode >", value, "groundMode");
            return (Criteria) this;
        }

        public Criteria andGroundModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ground_mode >=", value, "groundMode");
            return (Criteria) this;
        }

        public Criteria andGroundModeLessThan(Integer value) {
            addCriterion("ground_mode <", value, "groundMode");
            return (Criteria) this;
        }

        public Criteria andGroundModeLessThanOrEqualTo(Integer value) {
            addCriterion("ground_mode <=", value, "groundMode");
            return (Criteria) this;
        }

        public Criteria andGroundModeIn(List<Integer> values) {
            addCriterion("ground_mode in", values, "groundMode");
            return (Criteria) this;
        }

        public Criteria andGroundModeNotIn(List<Integer> values) {
            addCriterion("ground_mode not in", values, "groundMode");
            return (Criteria) this;
        }

        public Criteria andGroundModeBetween(Integer value1, Integer value2) {
            addCriterion("ground_mode between", value1, value2, "groundMode");
            return (Criteria) this;
        }

        public Criteria andGroundModeNotBetween(Integer value1, Integer value2) {
            addCriterion("ground_mode not between", value1, value2, "groundMode");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNull() {
            addCriterion("merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNotNull() {
            addCriterion("merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdEqualTo(Long value) {
            addCriterion("merchant_id =", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotEqualTo(Long value) {
            addCriterion("merchant_id <>", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThan(Long value) {
            addCriterion("merchant_id >", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("merchant_id >=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThan(Long value) {
            addCriterion("merchant_id <", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThanOrEqualTo(Long value) {
            addCriterion("merchant_id <=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIn(List<Long> values) {
            addCriterion("merchant_id in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotIn(List<Long> values) {
            addCriterion("merchant_id not in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdBetween(Long value1, Long value2) {
            addCriterion("merchant_id between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotBetween(Long value1, Long value2) {
            addCriterion("merchant_id not between", value1, value2, "merchantId");
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

        public Criteria andAccountIdEqualTo(String value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(String value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(String value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(String value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(String value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLike(String value) {
            addCriterion("account_id like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotLike(String value) {
            addCriterion("account_id not like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<String> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<String> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(String value1, String value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(String value1, String value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andSubmitAuditTimeIsNull() {
            addCriterion("submit_audit_time is null");
            return (Criteria) this;
        }

        public Criteria andSubmitAuditTimeIsNotNull() {
            addCriterion("submit_audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitAuditTimeEqualTo(Date value) {
            addCriterion("submit_audit_time =", value, "submitAuditTime");
            return (Criteria) this;
        }

        public Criteria andSubmitAuditTimeNotEqualTo(Date value) {
            addCriterion("submit_audit_time <>", value, "submitAuditTime");
            return (Criteria) this;
        }

        public Criteria andSubmitAuditTimeGreaterThan(Date value) {
            addCriterion("submit_audit_time >", value, "submitAuditTime");
            return (Criteria) this;
        }

        public Criteria andSubmitAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("submit_audit_time >=", value, "submitAuditTime");
            return (Criteria) this;
        }

        public Criteria andSubmitAuditTimeLessThan(Date value) {
            addCriterion("submit_audit_time <", value, "submitAuditTime");
            return (Criteria) this;
        }

        public Criteria andSubmitAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("submit_audit_time <=", value, "submitAuditTime");
            return (Criteria) this;
        }

        public Criteria andSubmitAuditTimeIn(List<Date> values) {
            addCriterion("submit_audit_time in", values, "submitAuditTime");
            return (Criteria) this;
        }

        public Criteria andSubmitAuditTimeNotIn(List<Date> values) {
            addCriterion("submit_audit_time not in", values, "submitAuditTime");
            return (Criteria) this;
        }

        public Criteria andSubmitAuditTimeBetween(Date value1, Date value2) {
            addCriterion("submit_audit_time between", value1, value2, "submitAuditTime");
            return (Criteria) this;
        }

        public Criteria andSubmitAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("submit_audit_time not between", value1, value2, "submitAuditTime");
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