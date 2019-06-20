package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaySettlementInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaySettlementInfoExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMyIdIsNull() {
            addCriterion("my_id is null");
            return (Criteria) this;
        }

        public Criteria andMyIdIsNotNull() {
            addCriterion("my_id is not null");
            return (Criteria) this;
        }

        public Criteria andMyIdEqualTo(String value) {
            addCriterion("my_id =", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdNotEqualTo(String value) {
            addCriterion("my_id <>", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdGreaterThan(String value) {
            addCriterion("my_id >", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdGreaterThanOrEqualTo(String value) {
            addCriterion("my_id >=", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdLessThan(String value) {
            addCriterion("my_id <", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdLessThanOrEqualTo(String value) {
            addCriterion("my_id <=", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdLike(String value) {
            addCriterion("my_id like", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdNotLike(String value) {
            addCriterion("my_id not like", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdIn(List<String> values) {
            addCriterion("my_id in", values, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdNotIn(List<String> values) {
            addCriterion("my_id not in", values, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdBetween(String value1, String value2) {
            addCriterion("my_id between", value1, value2, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdNotBetween(String value1, String value2) {
            addCriterion("my_id not between", value1, value2, "myId");
            return (Criteria) this;
        }

        public Criteria andMyTypeIsNull() {
            addCriterion("my_type is null");
            return (Criteria) this;
        }

        public Criteria andMyTypeIsNotNull() {
            addCriterion("my_type is not null");
            return (Criteria) this;
        }

        public Criteria andMyTypeEqualTo(String value) {
            addCriterion("my_type =", value, "myType");
            return (Criteria) this;
        }

        public Criteria andMyTypeNotEqualTo(String value) {
            addCriterion("my_type <>", value, "myType");
            return (Criteria) this;
        }

        public Criteria andMyTypeGreaterThan(String value) {
            addCriterion("my_type >", value, "myType");
            return (Criteria) this;
        }

        public Criteria andMyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("my_type >=", value, "myType");
            return (Criteria) this;
        }

        public Criteria andMyTypeLessThan(String value) {
            addCriterion("my_type <", value, "myType");
            return (Criteria) this;
        }

        public Criteria andMyTypeLessThanOrEqualTo(String value) {
            addCriterion("my_type <=", value, "myType");
            return (Criteria) this;
        }

        public Criteria andMyTypeLike(String value) {
            addCriterion("my_type like", value, "myType");
            return (Criteria) this;
        }

        public Criteria andMyTypeNotLike(String value) {
            addCriterion("my_type not like", value, "myType");
            return (Criteria) this;
        }

        public Criteria andMyTypeIn(List<String> values) {
            addCriterion("my_type in", values, "myType");
            return (Criteria) this;
        }

        public Criteria andMyTypeNotIn(List<String> values) {
            addCriterion("my_type not in", values, "myType");
            return (Criteria) this;
        }

        public Criteria andMyTypeBetween(String value1, String value2) {
            addCriterion("my_type between", value1, value2, "myType");
            return (Criteria) this;
        }

        public Criteria andMyTypeNotBetween(String value1, String value2) {
            addCriterion("my_type not between", value1, value2, "myType");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeIsNull() {
            addCriterion("my_create_time is null");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeIsNotNull() {
            addCriterion("my_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeEqualTo(Date value) {
            addCriterion("my_create_time =", value, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeNotEqualTo(Date value) {
            addCriterion("my_create_time <>", value, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeGreaterThan(Date value) {
            addCriterion("my_create_time >", value, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("my_create_time >=", value, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeLessThan(Date value) {
            addCriterion("my_create_time <", value, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("my_create_time <=", value, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeIn(List<Date> values) {
            addCriterion("my_create_time in", values, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeNotIn(List<Date> values) {
            addCriterion("my_create_time not in", values, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeBetween(Date value1, Date value2) {
            addCriterion("my_create_time between", value1, value2, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("my_create_time not between", value1, value2, "myCreateTime");
            return (Criteria) this;
        }

        public Criteria andMyStatusIsNull() {
            addCriterion("my_status is null");
            return (Criteria) this;
        }

        public Criteria andMyStatusIsNotNull() {
            addCriterion("my_status is not null");
            return (Criteria) this;
        }

        public Criteria andMyStatusEqualTo(Integer value) {
            addCriterion("my_status =", value, "myStatus");
            return (Criteria) this;
        }

        public Criteria andMyStatusNotEqualTo(Integer value) {
            addCriterion("my_status <>", value, "myStatus");
            return (Criteria) this;
        }

        public Criteria andMyStatusGreaterThan(Integer value) {
            addCriterion("my_status >", value, "myStatus");
            return (Criteria) this;
        }

        public Criteria andMyStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("my_status >=", value, "myStatus");
            return (Criteria) this;
        }

        public Criteria andMyStatusLessThan(Integer value) {
            addCriterion("my_status <", value, "myStatus");
            return (Criteria) this;
        }

        public Criteria andMyStatusLessThanOrEqualTo(Integer value) {
            addCriterion("my_status <=", value, "myStatus");
            return (Criteria) this;
        }

        public Criteria andMyStatusIn(List<Integer> values) {
            addCriterion("my_status in", values, "myStatus");
            return (Criteria) this;
        }

        public Criteria andMyStatusNotIn(List<Integer> values) {
            addCriterion("my_status not in", values, "myStatus");
            return (Criteria) this;
        }

        public Criteria andMyStatusBetween(Integer value1, Integer value2) {
            addCriterion("my_status between", value1, value2, "myStatus");
            return (Criteria) this;
        }

        public Criteria andMyStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("my_status not between", value1, value2, "myStatus");
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

        public Criteria andMchNameIsNull() {
            addCriterion("mch_name is null");
            return (Criteria) this;
        }

        public Criteria andMchNameIsNotNull() {
            addCriterion("mch_name is not null");
            return (Criteria) this;
        }

        public Criteria andMchNameEqualTo(String value) {
            addCriterion("mch_name =", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameNotEqualTo(String value) {
            addCriterion("mch_name <>", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameGreaterThan(String value) {
            addCriterion("mch_name >", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameGreaterThanOrEqualTo(String value) {
            addCriterion("mch_name >=", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameLessThan(String value) {
            addCriterion("mch_name <", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameLessThanOrEqualTo(String value) {
            addCriterion("mch_name <=", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameLike(String value) {
            addCriterion("mch_name like", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameNotLike(String value) {
            addCriterion("mch_name not like", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameIn(List<String> values) {
            addCriterion("mch_name in", values, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameNotIn(List<String> values) {
            addCriterion("mch_name not in", values, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameBetween(String value1, String value2) {
            addCriterion("mch_name between", value1, value2, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameNotBetween(String value1, String value2) {
            addCriterion("mch_name not between", value1, value2, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchAccountIdIsNull() {
            addCriterion("mch_account_id is null");
            return (Criteria) this;
        }

        public Criteria andMchAccountIdIsNotNull() {
            addCriterion("mch_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andMchAccountIdEqualTo(String value) {
            addCriterion("mch_account_id =", value, "mchAccountId");
            return (Criteria) this;
        }

        public Criteria andMchAccountIdNotEqualTo(String value) {
            addCriterion("mch_account_id <>", value, "mchAccountId");
            return (Criteria) this;
        }

        public Criteria andMchAccountIdGreaterThan(String value) {
            addCriterion("mch_account_id >", value, "mchAccountId");
            return (Criteria) this;
        }

        public Criteria andMchAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("mch_account_id >=", value, "mchAccountId");
            return (Criteria) this;
        }

        public Criteria andMchAccountIdLessThan(String value) {
            addCriterion("mch_account_id <", value, "mchAccountId");
            return (Criteria) this;
        }

        public Criteria andMchAccountIdLessThanOrEqualTo(String value) {
            addCriterion("mch_account_id <=", value, "mchAccountId");
            return (Criteria) this;
        }

        public Criteria andMchAccountIdLike(String value) {
            addCriterion("mch_account_id like", value, "mchAccountId");
            return (Criteria) this;
        }

        public Criteria andMchAccountIdNotLike(String value) {
            addCriterion("mch_account_id not like", value, "mchAccountId");
            return (Criteria) this;
        }

        public Criteria andMchAccountIdIn(List<String> values) {
            addCriterion("mch_account_id in", values, "mchAccountId");
            return (Criteria) this;
        }

        public Criteria andMchAccountIdNotIn(List<String> values) {
            addCriterion("mch_account_id not in", values, "mchAccountId");
            return (Criteria) this;
        }

        public Criteria andMchAccountIdBetween(String value1, String value2) {
            addCriterion("mch_account_id between", value1, value2, "mchAccountId");
            return (Criteria) this;
        }

        public Criteria andMchAccountIdNotBetween(String value1, String value2) {
            addCriterion("mch_account_id not between", value1, value2, "mchAccountId");
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

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNull() {
            addCriterion("app_name is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("app_name in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("app_name not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "appName");
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

        public Criteria andConfirmTimeIsNull() {
            addCriterion("confirm_time is null");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIsNotNull() {
            addCriterion("confirm_time is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeEqualTo(Date value) {
            addCriterion("confirm_time =", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotEqualTo(Date value) {
            addCriterion("confirm_time <>", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeGreaterThan(Date value) {
            addCriterion("confirm_time >", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("confirm_time >=", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeLessThan(Date value) {
            addCriterion("confirm_time <", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeLessThanOrEqualTo(Date value) {
            addCriterion("confirm_time <=", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIn(List<Date> values) {
            addCriterion("confirm_time in", values, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotIn(List<Date> values) {
            addCriterion("confirm_time not in", values, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeBetween(Date value1, Date value2) {
            addCriterion("confirm_time between", value1, value2, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotBetween(Date value1, Date value2) {
            addCriterion("confirm_time not between", value1, value2, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andRevokeTimeIsNull() {
            addCriterion("revoke_time is null");
            return (Criteria) this;
        }

        public Criteria andRevokeTimeIsNotNull() {
            addCriterion("revoke_time is not null");
            return (Criteria) this;
        }

        public Criteria andRevokeTimeEqualTo(Date value) {
            addCriterion("revoke_time =", value, "revokeTime");
            return (Criteria) this;
        }

        public Criteria andRevokeTimeNotEqualTo(Date value) {
            addCriterion("revoke_time <>", value, "revokeTime");
            return (Criteria) this;
        }

        public Criteria andRevokeTimeGreaterThan(Date value) {
            addCriterion("revoke_time >", value, "revokeTime");
            return (Criteria) this;
        }

        public Criteria andRevokeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("revoke_time >=", value, "revokeTime");
            return (Criteria) this;
        }

        public Criteria andRevokeTimeLessThan(Date value) {
            addCriterion("revoke_time <", value, "revokeTime");
            return (Criteria) this;
        }

        public Criteria andRevokeTimeLessThanOrEqualTo(Date value) {
            addCriterion("revoke_time <=", value, "revokeTime");
            return (Criteria) this;
        }

        public Criteria andRevokeTimeIn(List<Date> values) {
            addCriterion("revoke_time in", values, "revokeTime");
            return (Criteria) this;
        }

        public Criteria andRevokeTimeNotIn(List<Date> values) {
            addCriterion("revoke_time not in", values, "revokeTime");
            return (Criteria) this;
        }

        public Criteria andRevokeTimeBetween(Date value1, Date value2) {
            addCriterion("revoke_time between", value1, value2, "revokeTime");
            return (Criteria) this;
        }

        public Criteria andRevokeTimeNotBetween(Date value1, Date value2) {
            addCriterion("revoke_time not between", value1, value2, "revokeTime");
            return (Criteria) this;
        }

        public Criteria andFromBillDateIsNull() {
            addCriterion("from_bill_date is null");
            return (Criteria) this;
        }

        public Criteria andFromBillDateIsNotNull() {
            addCriterion("from_bill_date is not null");
            return (Criteria) this;
        }

        public Criteria andFromBillDateEqualTo(String value) {
            addCriterion("from_bill_date =", value, "fromBillDate");
            return (Criteria) this;
        }

        public Criteria andFromBillDateNotEqualTo(String value) {
            addCriterion("from_bill_date <>", value, "fromBillDate");
            return (Criteria) this;
        }

        public Criteria andFromBillDateGreaterThan(String value) {
            addCriterion("from_bill_date >", value, "fromBillDate");
            return (Criteria) this;
        }

        public Criteria andFromBillDateGreaterThanOrEqualTo(String value) {
            addCriterion("from_bill_date >=", value, "fromBillDate");
            return (Criteria) this;
        }

        public Criteria andFromBillDateLessThan(String value) {
            addCriterion("from_bill_date <", value, "fromBillDate");
            return (Criteria) this;
        }

        public Criteria andFromBillDateLessThanOrEqualTo(String value) {
            addCriterion("from_bill_date <=", value, "fromBillDate");
            return (Criteria) this;
        }

        public Criteria andFromBillDateLike(String value) {
            addCriterion("from_bill_date like", value, "fromBillDate");
            return (Criteria) this;
        }

        public Criteria andFromBillDateNotLike(String value) {
            addCriterion("from_bill_date not like", value, "fromBillDate");
            return (Criteria) this;
        }

        public Criteria andFromBillDateIn(List<String> values) {
            addCriterion("from_bill_date in", values, "fromBillDate");
            return (Criteria) this;
        }

        public Criteria andFromBillDateNotIn(List<String> values) {
            addCriterion("from_bill_date not in", values, "fromBillDate");
            return (Criteria) this;
        }

        public Criteria andFromBillDateBetween(String value1, String value2) {
            addCriterion("from_bill_date between", value1, value2, "fromBillDate");
            return (Criteria) this;
        }

        public Criteria andFromBillDateNotBetween(String value1, String value2) {
            addCriterion("from_bill_date not between", value1, value2, "fromBillDate");
            return (Criteria) this;
        }

        public Criteria andToBillDateIsNull() {
            addCriterion("to_bill_date is null");
            return (Criteria) this;
        }

        public Criteria andToBillDateIsNotNull() {
            addCriterion("to_bill_date is not null");
            return (Criteria) this;
        }

        public Criteria andToBillDateEqualTo(String value) {
            addCriterion("to_bill_date =", value, "toBillDate");
            return (Criteria) this;
        }

        public Criteria andToBillDateNotEqualTo(String value) {
            addCriterion("to_bill_date <>", value, "toBillDate");
            return (Criteria) this;
        }

        public Criteria andToBillDateGreaterThan(String value) {
            addCriterion("to_bill_date >", value, "toBillDate");
            return (Criteria) this;
        }

        public Criteria andToBillDateGreaterThanOrEqualTo(String value) {
            addCriterion("to_bill_date >=", value, "toBillDate");
            return (Criteria) this;
        }

        public Criteria andToBillDateLessThan(String value) {
            addCriterion("to_bill_date <", value, "toBillDate");
            return (Criteria) this;
        }

        public Criteria andToBillDateLessThanOrEqualTo(String value) {
            addCriterion("to_bill_date <=", value, "toBillDate");
            return (Criteria) this;
        }

        public Criteria andToBillDateLike(String value) {
            addCriterion("to_bill_date like", value, "toBillDate");
            return (Criteria) this;
        }

        public Criteria andToBillDateNotLike(String value) {
            addCriterion("to_bill_date not like", value, "toBillDate");
            return (Criteria) this;
        }

        public Criteria andToBillDateIn(List<String> values) {
            addCriterion("to_bill_date in", values, "toBillDate");
            return (Criteria) this;
        }

        public Criteria andToBillDateNotIn(List<String> values) {
            addCriterion("to_bill_date not in", values, "toBillDate");
            return (Criteria) this;
        }

        public Criteria andToBillDateBetween(String value1, String value2) {
            addCriterion("to_bill_date between", value1, value2, "toBillDate");
            return (Criteria) this;
        }

        public Criteria andToBillDateNotBetween(String value1, String value2) {
            addCriterion("to_bill_date not between", value1, value2, "toBillDate");
            return (Criteria) this;
        }

        public Criteria andConfirmCommentIsNull() {
            addCriterion("confirm_comment is null");
            return (Criteria) this;
        }

        public Criteria andConfirmCommentIsNotNull() {
            addCriterion("confirm_comment is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmCommentEqualTo(String value) {
            addCriterion("confirm_comment =", value, "confirmComment");
            return (Criteria) this;
        }

        public Criteria andConfirmCommentNotEqualTo(String value) {
            addCriterion("confirm_comment <>", value, "confirmComment");
            return (Criteria) this;
        }

        public Criteria andConfirmCommentGreaterThan(String value) {
            addCriterion("confirm_comment >", value, "confirmComment");
            return (Criteria) this;
        }

        public Criteria andConfirmCommentGreaterThanOrEqualTo(String value) {
            addCriterion("confirm_comment >=", value, "confirmComment");
            return (Criteria) this;
        }

        public Criteria andConfirmCommentLessThan(String value) {
            addCriterion("confirm_comment <", value, "confirmComment");
            return (Criteria) this;
        }

        public Criteria andConfirmCommentLessThanOrEqualTo(String value) {
            addCriterion("confirm_comment <=", value, "confirmComment");
            return (Criteria) this;
        }

        public Criteria andConfirmCommentLike(String value) {
            addCriterion("confirm_comment like", value, "confirmComment");
            return (Criteria) this;
        }

        public Criteria andConfirmCommentNotLike(String value) {
            addCriterion("confirm_comment not like", value, "confirmComment");
            return (Criteria) this;
        }

        public Criteria andConfirmCommentIn(List<String> values) {
            addCriterion("confirm_comment in", values, "confirmComment");
            return (Criteria) this;
        }

        public Criteria andConfirmCommentNotIn(List<String> values) {
            addCriterion("confirm_comment not in", values, "confirmComment");
            return (Criteria) this;
        }

        public Criteria andConfirmCommentBetween(String value1, String value2) {
            addCriterion("confirm_comment between", value1, value2, "confirmComment");
            return (Criteria) this;
        }

        public Criteria andConfirmCommentNotBetween(String value1, String value2) {
            addCriterion("confirm_comment not between", value1, value2, "confirmComment");
            return (Criteria) this;
        }

        public Criteria andRevokeCommentIsNull() {
            addCriterion("revoke_comment is null");
            return (Criteria) this;
        }

        public Criteria andRevokeCommentIsNotNull() {
            addCriterion("revoke_comment is not null");
            return (Criteria) this;
        }

        public Criteria andRevokeCommentEqualTo(String value) {
            addCriterion("revoke_comment =", value, "revokeComment");
            return (Criteria) this;
        }

        public Criteria andRevokeCommentNotEqualTo(String value) {
            addCriterion("revoke_comment <>", value, "revokeComment");
            return (Criteria) this;
        }

        public Criteria andRevokeCommentGreaterThan(String value) {
            addCriterion("revoke_comment >", value, "revokeComment");
            return (Criteria) this;
        }

        public Criteria andRevokeCommentGreaterThanOrEqualTo(String value) {
            addCriterion("revoke_comment >=", value, "revokeComment");
            return (Criteria) this;
        }

        public Criteria andRevokeCommentLessThan(String value) {
            addCriterion("revoke_comment <", value, "revokeComment");
            return (Criteria) this;
        }

        public Criteria andRevokeCommentLessThanOrEqualTo(String value) {
            addCriterion("revoke_comment <=", value, "revokeComment");
            return (Criteria) this;
        }

        public Criteria andRevokeCommentLike(String value) {
            addCriterion("revoke_comment like", value, "revokeComment");
            return (Criteria) this;
        }

        public Criteria andRevokeCommentNotLike(String value) {
            addCriterion("revoke_comment not like", value, "revokeComment");
            return (Criteria) this;
        }

        public Criteria andRevokeCommentIn(List<String> values) {
            addCriterion("revoke_comment in", values, "revokeComment");
            return (Criteria) this;
        }

        public Criteria andRevokeCommentNotIn(List<String> values) {
            addCriterion("revoke_comment not in", values, "revokeComment");
            return (Criteria) this;
        }

        public Criteria andRevokeCommentBetween(String value1, String value2) {
            addCriterion("revoke_comment between", value1, value2, "revokeComment");
            return (Criteria) this;
        }

        public Criteria andRevokeCommentNotBetween(String value1, String value2) {
            addCriterion("revoke_comment not between", value1, value2, "revokeComment");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusIsNull() {
            addCriterion("confirm_status is null");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusIsNotNull() {
            addCriterion("confirm_status is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusEqualTo(Integer value) {
            addCriterion("confirm_status =", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotEqualTo(Integer value) {
            addCriterion("confirm_status <>", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusGreaterThan(Integer value) {
            addCriterion("confirm_status >", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("confirm_status >=", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusLessThan(Integer value) {
            addCriterion("confirm_status <", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusLessThanOrEqualTo(Integer value) {
            addCriterion("confirm_status <=", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusIn(List<Integer> values) {
            addCriterion("confirm_status in", values, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotIn(List<Integer> values) {
            addCriterion("confirm_status not in", values, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusBetween(Integer value1, Integer value2) {
            addCriterion("confirm_status between", value1, value2, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("confirm_status not between", value1, value2, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("end_time like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("end_time not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andErrorMsgIsNull() {
            addCriterion("error_msg is null");
            return (Criteria) this;
        }

        public Criteria andErrorMsgIsNotNull() {
            addCriterion("error_msg is not null");
            return (Criteria) this;
        }

        public Criteria andErrorMsgEqualTo(String value) {
            addCriterion("error_msg =", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgNotEqualTo(String value) {
            addCriterion("error_msg <>", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgGreaterThan(String value) {
            addCriterion("error_msg >", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgGreaterThanOrEqualTo(String value) {
            addCriterion("error_msg >=", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgLessThan(String value) {
            addCriterion("error_msg <", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgLessThanOrEqualTo(String value) {
            addCriterion("error_msg <=", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgLike(String value) {
            addCriterion("error_msg like", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgNotLike(String value) {
            addCriterion("error_msg not like", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgIn(List<String> values) {
            addCriterion("error_msg in", values, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgNotIn(List<String> values) {
            addCriterion("error_msg not in", values, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgBetween(String value1, String value2) {
            addCriterion("error_msg between", value1, value2, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgNotBetween(String value1, String value2) {
            addCriterion("error_msg not between", value1, value2, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andTradeTotalIsNull() {
            addCriterion("trade_total is null");
            return (Criteria) this;
        }

        public Criteria andTradeTotalIsNotNull() {
            addCriterion("trade_total is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTotalEqualTo(Integer value) {
            addCriterion("trade_total =", value, "tradeTotal");
            return (Criteria) this;
        }

        public Criteria andTradeTotalNotEqualTo(Integer value) {
            addCriterion("trade_total <>", value, "tradeTotal");
            return (Criteria) this;
        }

        public Criteria andTradeTotalGreaterThan(Integer value) {
            addCriterion("trade_total >", value, "tradeTotal");
            return (Criteria) this;
        }

        public Criteria andTradeTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("trade_total >=", value, "tradeTotal");
            return (Criteria) this;
        }

        public Criteria andTradeTotalLessThan(Integer value) {
            addCriterion("trade_total <", value, "tradeTotal");
            return (Criteria) this;
        }

        public Criteria andTradeTotalLessThanOrEqualTo(Integer value) {
            addCriterion("trade_total <=", value, "tradeTotal");
            return (Criteria) this;
        }

        public Criteria andTradeTotalIn(List<Integer> values) {
            addCriterion("trade_total in", values, "tradeTotal");
            return (Criteria) this;
        }

        public Criteria andTradeTotalNotIn(List<Integer> values) {
            addCriterion("trade_total not in", values, "tradeTotal");
            return (Criteria) this;
        }

        public Criteria andTradeTotalBetween(Integer value1, Integer value2) {
            addCriterion("trade_total between", value1, value2, "tradeTotal");
            return (Criteria) this;
        }

        public Criteria andTradeTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("trade_total not between", value1, value2, "tradeTotal");
            return (Criteria) this;
        }

        public Criteria andTradeTotalAmountIsNull() {
            addCriterion("trade_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTradeTotalAmountIsNotNull() {
            addCriterion("trade_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTotalAmountEqualTo(Long value) {
            addCriterion("trade_total_amount =", value, "tradeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andTradeTotalAmountNotEqualTo(Long value) {
            addCriterion("trade_total_amount <>", value, "tradeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andTradeTotalAmountGreaterThan(Long value) {
            addCriterion("trade_total_amount >", value, "tradeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andTradeTotalAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("trade_total_amount >=", value, "tradeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andTradeTotalAmountLessThan(Long value) {
            addCriterion("trade_total_amount <", value, "tradeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andTradeTotalAmountLessThanOrEqualTo(Long value) {
            addCriterion("trade_total_amount <=", value, "tradeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andTradeTotalAmountIn(List<Long> values) {
            addCriterion("trade_total_amount in", values, "tradeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andTradeTotalAmountNotIn(List<Long> values) {
            addCriterion("trade_total_amount not in", values, "tradeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andTradeTotalAmountBetween(Long value1, Long value2) {
            addCriterion("trade_total_amount between", value1, value2, "tradeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andTradeTotalAmountNotBetween(Long value1, Long value2) {
            addCriterion("trade_total_amount not between", value1, value2, "tradeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andTradeReceiptAmountIsNull() {
            addCriterion("trade_receipt_amount is null");
            return (Criteria) this;
        }

        public Criteria andTradeReceiptAmountIsNotNull() {
            addCriterion("trade_receipt_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTradeReceiptAmountEqualTo(Long value) {
            addCriterion("trade_receipt_amount =", value, "tradeReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeReceiptAmountNotEqualTo(Long value) {
            addCriterion("trade_receipt_amount <>", value, "tradeReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeReceiptAmountGreaterThan(Long value) {
            addCriterion("trade_receipt_amount >", value, "tradeReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeReceiptAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("trade_receipt_amount >=", value, "tradeReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeReceiptAmountLessThan(Long value) {
            addCriterion("trade_receipt_amount <", value, "tradeReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeReceiptAmountLessThanOrEqualTo(Long value) {
            addCriterion("trade_receipt_amount <=", value, "tradeReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeReceiptAmountIn(List<Long> values) {
            addCriterion("trade_receipt_amount in", values, "tradeReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeReceiptAmountNotIn(List<Long> values) {
            addCriterion("trade_receipt_amount not in", values, "tradeReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeReceiptAmountBetween(Long value1, Long value2) {
            addCriterion("trade_receipt_amount between", value1, value2, "tradeReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeReceiptAmountNotBetween(Long value1, Long value2) {
            addCriterion("trade_receipt_amount not between", value1, value2, "tradeReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeBussinessReceiptAmountIsNull() {
            addCriterion("trade_bussiness_receipt_amount is null");
            return (Criteria) this;
        }

        public Criteria andTradeBussinessReceiptAmountIsNotNull() {
            addCriterion("trade_bussiness_receipt_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTradeBussinessReceiptAmountEqualTo(Long value) {
            addCriterion("trade_bussiness_receipt_amount =", value, "tradeBussinessReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeBussinessReceiptAmountNotEqualTo(Long value) {
            addCriterion("trade_bussiness_receipt_amount <>", value, "tradeBussinessReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeBussinessReceiptAmountGreaterThan(Long value) {
            addCriterion("trade_bussiness_receipt_amount >", value, "tradeBussinessReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeBussinessReceiptAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("trade_bussiness_receipt_amount >=", value, "tradeBussinessReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeBussinessReceiptAmountLessThan(Long value) {
            addCriterion("trade_bussiness_receipt_amount <", value, "tradeBussinessReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeBussinessReceiptAmountLessThanOrEqualTo(Long value) {
            addCriterion("trade_bussiness_receipt_amount <=", value, "tradeBussinessReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeBussinessReceiptAmountIn(List<Long> values) {
            addCriterion("trade_bussiness_receipt_amount in", values, "tradeBussinessReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeBussinessReceiptAmountNotIn(List<Long> values) {
            addCriterion("trade_bussiness_receipt_amount not in", values, "tradeBussinessReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeBussinessReceiptAmountBetween(Long value1, Long value2) {
            addCriterion("trade_bussiness_receipt_amount between", value1, value2, "tradeBussinessReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeBussinessReceiptAmountNotBetween(Long value1, Long value2) {
            addCriterion("trade_bussiness_receipt_amount not between", value1, value2, "tradeBussinessReceiptAmount");
            return (Criteria) this;
        }

        public Criteria andTradeFeeAmountIsNull() {
            addCriterion("trade_fee_amount is null");
            return (Criteria) this;
        }

        public Criteria andTradeFeeAmountIsNotNull() {
            addCriterion("trade_fee_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTradeFeeAmountEqualTo(Long value) {
            addCriterion("trade_fee_amount =", value, "tradeFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeFeeAmountNotEqualTo(Long value) {
            addCriterion("trade_fee_amount <>", value, "tradeFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeFeeAmountGreaterThan(Long value) {
            addCriterion("trade_fee_amount >", value, "tradeFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeFeeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("trade_fee_amount >=", value, "tradeFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeFeeAmountLessThan(Long value) {
            addCriterion("trade_fee_amount <", value, "tradeFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeFeeAmountLessThanOrEqualTo(Long value) {
            addCriterion("trade_fee_amount <=", value, "tradeFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeFeeAmountIn(List<Long> values) {
            addCriterion("trade_fee_amount in", values, "tradeFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeFeeAmountNotIn(List<Long> values) {
            addCriterion("trade_fee_amount not in", values, "tradeFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeFeeAmountBetween(Long value1, Long value2) {
            addCriterion("trade_fee_amount between", value1, value2, "tradeFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeFeeAmountNotBetween(Long value1, Long value2) {
            addCriterion("trade_fee_amount not between", value1, value2, "tradeFeeAmount");
            return (Criteria) this;
        }

        public Criteria andDepositNameIsNull() {
            addCriterion("deposit_name is null");
            return (Criteria) this;
        }

        public Criteria andDepositNameIsNotNull() {
            addCriterion("deposit_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepositNameEqualTo(String value) {
            addCriterion("deposit_name =", value, "depositName");
            return (Criteria) this;
        }

        public Criteria andDepositNameNotEqualTo(String value) {
            addCriterion("deposit_name <>", value, "depositName");
            return (Criteria) this;
        }

        public Criteria andDepositNameGreaterThan(String value) {
            addCriterion("deposit_name >", value, "depositName");
            return (Criteria) this;
        }

        public Criteria andDepositNameGreaterThanOrEqualTo(String value) {
            addCriterion("deposit_name >=", value, "depositName");
            return (Criteria) this;
        }

        public Criteria andDepositNameLessThan(String value) {
            addCriterion("deposit_name <", value, "depositName");
            return (Criteria) this;
        }

        public Criteria andDepositNameLessThanOrEqualTo(String value) {
            addCriterion("deposit_name <=", value, "depositName");
            return (Criteria) this;
        }

        public Criteria andDepositNameLike(String value) {
            addCriterion("deposit_name like", value, "depositName");
            return (Criteria) this;
        }

        public Criteria andDepositNameNotLike(String value) {
            addCriterion("deposit_name not like", value, "depositName");
            return (Criteria) this;
        }

        public Criteria andDepositNameIn(List<String> values) {
            addCriterion("deposit_name in", values, "depositName");
            return (Criteria) this;
        }

        public Criteria andDepositNameNotIn(List<String> values) {
            addCriterion("deposit_name not in", values, "depositName");
            return (Criteria) this;
        }

        public Criteria andDepositNameBetween(String value1, String value2) {
            addCriterion("deposit_name between", value1, value2, "depositName");
            return (Criteria) this;
        }

        public Criteria andDepositNameNotBetween(String value1, String value2) {
            addCriterion("deposit_name not between", value1, value2, "depositName");
            return (Criteria) this;
        }

        public Criteria andDepositBankIsNull() {
            addCriterion("deposit_bank is null");
            return (Criteria) this;
        }

        public Criteria andDepositBankIsNotNull() {
            addCriterion("deposit_bank is not null");
            return (Criteria) this;
        }

        public Criteria andDepositBankEqualTo(String value) {
            addCriterion("deposit_bank =", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotEqualTo(String value) {
            addCriterion("deposit_bank <>", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankGreaterThan(String value) {
            addCriterion("deposit_bank >", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankGreaterThanOrEqualTo(String value) {
            addCriterion("deposit_bank >=", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankLessThan(String value) {
            addCriterion("deposit_bank <", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankLessThanOrEqualTo(String value) {
            addCriterion("deposit_bank <=", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankLike(String value) {
            addCriterion("deposit_bank like", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotLike(String value) {
            addCriterion("deposit_bank not like", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankIn(List<String> values) {
            addCriterion("deposit_bank in", values, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotIn(List<String> values) {
            addCriterion("deposit_bank not in", values, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankBetween(String value1, String value2) {
            addCriterion("deposit_bank between", value1, value2, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotBetween(String value1, String value2) {
            addCriterion("deposit_bank not between", value1, value2, "depositBank");
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

        public Criteria andTradeRefundTotalIsNull() {
            addCriterion("trade_refund_total is null");
            return (Criteria) this;
        }

        public Criteria andTradeRefundTotalIsNotNull() {
            addCriterion("trade_refund_total is not null");
            return (Criteria) this;
        }

        public Criteria andTradeRefundTotalEqualTo(Long value) {
            addCriterion("trade_refund_total =", value, "tradeRefundTotal");
            return (Criteria) this;
        }

        public Criteria andTradeRefundTotalNotEqualTo(Long value) {
            addCriterion("trade_refund_total <>", value, "tradeRefundTotal");
            return (Criteria) this;
        }

        public Criteria andTradeRefundTotalGreaterThan(Long value) {
            addCriterion("trade_refund_total >", value, "tradeRefundTotal");
            return (Criteria) this;
        }

        public Criteria andTradeRefundTotalGreaterThanOrEqualTo(Long value) {
            addCriterion("trade_refund_total >=", value, "tradeRefundTotal");
            return (Criteria) this;
        }

        public Criteria andTradeRefundTotalLessThan(Long value) {
            addCriterion("trade_refund_total <", value, "tradeRefundTotal");
            return (Criteria) this;
        }

        public Criteria andTradeRefundTotalLessThanOrEqualTo(Long value) {
            addCriterion("trade_refund_total <=", value, "tradeRefundTotal");
            return (Criteria) this;
        }

        public Criteria andTradeRefundTotalIn(List<Long> values) {
            addCriterion("trade_refund_total in", values, "tradeRefundTotal");
            return (Criteria) this;
        }

        public Criteria andTradeRefundTotalNotIn(List<Long> values) {
            addCriterion("trade_refund_total not in", values, "tradeRefundTotal");
            return (Criteria) this;
        }

        public Criteria andTradeRefundTotalBetween(Long value1, Long value2) {
            addCriterion("trade_refund_total between", value1, value2, "tradeRefundTotal");
            return (Criteria) this;
        }

        public Criteria andTradeRefundTotalNotBetween(Long value1, Long value2) {
            addCriterion("trade_refund_total not between", value1, value2, "tradeRefundTotal");
            return (Criteria) this;
        }

        public Criteria andTradeRefundFeeIsNull() {
            addCriterion("trade_refund_fee is null");
            return (Criteria) this;
        }

        public Criteria andTradeRefundFeeIsNotNull() {
            addCriterion("trade_refund_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTradeRefundFeeEqualTo(Long value) {
            addCriterion("trade_refund_fee =", value, "tradeRefundFee");
            return (Criteria) this;
        }

        public Criteria andTradeRefundFeeNotEqualTo(Long value) {
            addCriterion("trade_refund_fee <>", value, "tradeRefundFee");
            return (Criteria) this;
        }

        public Criteria andTradeRefundFeeGreaterThan(Long value) {
            addCriterion("trade_refund_fee >", value, "tradeRefundFee");
            return (Criteria) this;
        }

        public Criteria andTradeRefundFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("trade_refund_fee >=", value, "tradeRefundFee");
            return (Criteria) this;
        }

        public Criteria andTradeRefundFeeLessThan(Long value) {
            addCriterion("trade_refund_fee <", value, "tradeRefundFee");
            return (Criteria) this;
        }

        public Criteria andTradeRefundFeeLessThanOrEqualTo(Long value) {
            addCriterion("trade_refund_fee <=", value, "tradeRefundFee");
            return (Criteria) this;
        }

        public Criteria andTradeRefundFeeIn(List<Long> values) {
            addCriterion("trade_refund_fee in", values, "tradeRefundFee");
            return (Criteria) this;
        }

        public Criteria andTradeRefundFeeNotIn(List<Long> values) {
            addCriterion("trade_refund_fee not in", values, "tradeRefundFee");
            return (Criteria) this;
        }

        public Criteria andTradeRefundFeeBetween(Long value1, Long value2) {
            addCriterion("trade_refund_fee between", value1, value2, "tradeRefundFee");
            return (Criteria) this;
        }

        public Criteria andTradeRefundFeeNotBetween(Long value1, Long value2) {
            addCriterion("trade_refund_fee not between", value1, value2, "tradeRefundFee");
            return (Criteria) this;
        }

        public Criteria andBussinessSettleAmountIsNull() {
            addCriterion("bussiness_settle_amount is null");
            return (Criteria) this;
        }

        public Criteria andBussinessSettleAmountIsNotNull() {
            addCriterion("bussiness_settle_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBussinessSettleAmountEqualTo(Long value) {
            addCriterion("bussiness_settle_amount =", value, "bussinessSettleAmount");
            return (Criteria) this;
        }

        public Criteria andBussinessSettleAmountNotEqualTo(Long value) {
            addCriterion("bussiness_settle_amount <>", value, "bussinessSettleAmount");
            return (Criteria) this;
        }

        public Criteria andBussinessSettleAmountGreaterThan(Long value) {
            addCriterion("bussiness_settle_amount >", value, "bussinessSettleAmount");
            return (Criteria) this;
        }

        public Criteria andBussinessSettleAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("bussiness_settle_amount >=", value, "bussinessSettleAmount");
            return (Criteria) this;
        }

        public Criteria andBussinessSettleAmountLessThan(Long value) {
            addCriterion("bussiness_settle_amount <", value, "bussinessSettleAmount");
            return (Criteria) this;
        }

        public Criteria andBussinessSettleAmountLessThanOrEqualTo(Long value) {
            addCriterion("bussiness_settle_amount <=", value, "bussinessSettleAmount");
            return (Criteria) this;
        }

        public Criteria andBussinessSettleAmountIn(List<Long> values) {
            addCriterion("bussiness_settle_amount in", values, "bussinessSettleAmount");
            return (Criteria) this;
        }

        public Criteria andBussinessSettleAmountNotIn(List<Long> values) {
            addCriterion("bussiness_settle_amount not in", values, "bussinessSettleAmount");
            return (Criteria) this;
        }

        public Criteria andBussinessSettleAmountBetween(Long value1, Long value2) {
            addCriterion("bussiness_settle_amount between", value1, value2, "bussinessSettleAmount");
            return (Criteria) this;
        }

        public Criteria andBussinessSettleAmountNotBetween(Long value1, Long value2) {
            addCriterion("bussiness_settle_amount not between", value1, value2, "bussinessSettleAmount");
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