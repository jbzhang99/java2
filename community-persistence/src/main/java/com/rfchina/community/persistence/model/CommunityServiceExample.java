package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommunityServiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommunityServiceExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andPngIsNull() {
            addCriterion("png is null");
            return (Criteria) this;
        }

        public Criteria andPngIsNotNull() {
            addCriterion("png is not null");
            return (Criteria) this;
        }

        public Criteria andPngEqualTo(String value) {
            addCriterion("png =", value, "png");
            return (Criteria) this;
        }

        public Criteria andPngNotEqualTo(String value) {
            addCriterion("png <>", value, "png");
            return (Criteria) this;
        }

        public Criteria andPngGreaterThan(String value) {
            addCriterion("png >", value, "png");
            return (Criteria) this;
        }

        public Criteria andPngGreaterThanOrEqualTo(String value) {
            addCriterion("png >=", value, "png");
            return (Criteria) this;
        }

        public Criteria andPngLessThan(String value) {
            addCriterion("png <", value, "png");
            return (Criteria) this;
        }

        public Criteria andPngLessThanOrEqualTo(String value) {
            addCriterion("png <=", value, "png");
            return (Criteria) this;
        }

        public Criteria andPngLike(String value) {
            addCriterion("png like", value, "png");
            return (Criteria) this;
        }

        public Criteria andPngNotLike(String value) {
            addCriterion("png not like", value, "png");
            return (Criteria) this;
        }

        public Criteria andPngIn(List<String> values) {
            addCriterion("png in", values, "png");
            return (Criteria) this;
        }

        public Criteria andPngNotIn(List<String> values) {
            addCriterion("png not in", values, "png");
            return (Criteria) this;
        }

        public Criteria andPngBetween(String value1, String value2) {
            addCriterion("png between", value1, value2, "png");
            return (Criteria) this;
        }

        public Criteria andPngNotBetween(String value1, String value2) {
            addCriterion("png not between", value1, value2, "png");
            return (Criteria) this;
        }

        public Criteria andDisablePngIsNull() {
            addCriterion("disable_png is null");
            return (Criteria) this;
        }

        public Criteria andDisablePngIsNotNull() {
            addCriterion("disable_png is not null");
            return (Criteria) this;
        }

        public Criteria andDisablePngEqualTo(String value) {
            addCriterion("disable_png =", value, "disablePng");
            return (Criteria) this;
        }

        public Criteria andDisablePngNotEqualTo(String value) {
            addCriterion("disable_png <>", value, "disablePng");
            return (Criteria) this;
        }

        public Criteria andDisablePngGreaterThan(String value) {
            addCriterion("disable_png >", value, "disablePng");
            return (Criteria) this;
        }

        public Criteria andDisablePngGreaterThanOrEqualTo(String value) {
            addCriterion("disable_png >=", value, "disablePng");
            return (Criteria) this;
        }

        public Criteria andDisablePngLessThan(String value) {
            addCriterion("disable_png <", value, "disablePng");
            return (Criteria) this;
        }

        public Criteria andDisablePngLessThanOrEqualTo(String value) {
            addCriterion("disable_png <=", value, "disablePng");
            return (Criteria) this;
        }

        public Criteria andDisablePngLike(String value) {
            addCriterion("disable_png like", value, "disablePng");
            return (Criteria) this;
        }

        public Criteria andDisablePngNotLike(String value) {
            addCriterion("disable_png not like", value, "disablePng");
            return (Criteria) this;
        }

        public Criteria andDisablePngIn(List<String> values) {
            addCriterion("disable_png in", values, "disablePng");
            return (Criteria) this;
        }

        public Criteria andDisablePngNotIn(List<String> values) {
            addCriterion("disable_png not in", values, "disablePng");
            return (Criteria) this;
        }

        public Criteria andDisablePngBetween(String value1, String value2) {
            addCriterion("disable_png between", value1, value2, "disablePng");
            return (Criteria) this;
        }

        public Criteria andDisablePngNotBetween(String value1, String value2) {
            addCriterion("disable_png not between", value1, value2, "disablePng");
            return (Criteria) this;
        }

        public Criteria andReorderIsNull() {
            addCriterion("reorder is null");
            return (Criteria) this;
        }

        public Criteria andReorderIsNotNull() {
            addCriterion("reorder is not null");
            return (Criteria) this;
        }

        public Criteria andReorderEqualTo(Integer value) {
            addCriterion("reorder =", value, "reorder");
            return (Criteria) this;
        }

        public Criteria andReorderNotEqualTo(Integer value) {
            addCriterion("reorder <>", value, "reorder");
            return (Criteria) this;
        }

        public Criteria andReorderGreaterThan(Integer value) {
            addCriterion("reorder >", value, "reorder");
            return (Criteria) this;
        }

        public Criteria andReorderGreaterThanOrEqualTo(Integer value) {
            addCriterion("reorder >=", value, "reorder");
            return (Criteria) this;
        }

        public Criteria andReorderLessThan(Integer value) {
            addCriterion("reorder <", value, "reorder");
            return (Criteria) this;
        }

        public Criteria andReorderLessThanOrEqualTo(Integer value) {
            addCriterion("reorder <=", value, "reorder");
            return (Criteria) this;
        }

        public Criteria andReorderIn(List<Integer> values) {
            addCriterion("reorder in", values, "reorder");
            return (Criteria) this;
        }

        public Criteria andReorderNotIn(List<Integer> values) {
            addCriterion("reorder not in", values, "reorder");
            return (Criteria) this;
        }

        public Criteria andReorderBetween(Integer value1, Integer value2) {
            addCriterion("reorder between", value1, value2, "reorder");
            return (Criteria) this;
        }

        public Criteria andReorderNotBetween(Integer value1, Integer value2) {
            addCriterion("reorder not between", value1, value2, "reorder");
            return (Criteria) this;
        }

        public Criteria andClauseIsNull() {
            addCriterion("clause is null");
            return (Criteria) this;
        }

        public Criteria andClauseIsNotNull() {
            addCriterion("clause is not null");
            return (Criteria) this;
        }

        public Criteria andClauseEqualTo(String value) {
            addCriterion("clause =", value, "clause");
            return (Criteria) this;
        }

        public Criteria andClauseNotEqualTo(String value) {
            addCriterion("clause <>", value, "clause");
            return (Criteria) this;
        }

        public Criteria andClauseGreaterThan(String value) {
            addCriterion("clause >", value, "clause");
            return (Criteria) this;
        }

        public Criteria andClauseGreaterThanOrEqualTo(String value) {
            addCriterion("clause >=", value, "clause");
            return (Criteria) this;
        }

        public Criteria andClauseLessThan(String value) {
            addCriterion("clause <", value, "clause");
            return (Criteria) this;
        }

        public Criteria andClauseLessThanOrEqualTo(String value) {
            addCriterion("clause <=", value, "clause");
            return (Criteria) this;
        }

        public Criteria andClauseLike(String value) {
            addCriterion("clause like", value, "clause");
            return (Criteria) this;
        }

        public Criteria andClauseNotLike(String value) {
            addCriterion("clause not like", value, "clause");
            return (Criteria) this;
        }

        public Criteria andClauseIn(List<String> values) {
            addCriterion("clause in", values, "clause");
            return (Criteria) this;
        }

        public Criteria andClauseNotIn(List<String> values) {
            addCriterion("clause not in", values, "clause");
            return (Criteria) this;
        }

        public Criteria andClauseBetween(String value1, String value2) {
            addCriterion("clause between", value1, value2, "clause");
            return (Criteria) this;
        }

        public Criteria andClauseNotBetween(String value1, String value2) {
            addCriterion("clause not between", value1, value2, "clause");
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

        public Criteria andIsAccountIsNull() {
            addCriterion("is_account is null");
            return (Criteria) this;
        }

        public Criteria andIsAccountIsNotNull() {
            addCriterion("is_account is not null");
            return (Criteria) this;
        }

        public Criteria andIsAccountEqualTo(Integer value) {
            addCriterion("is_account =", value, "isAccount");
            return (Criteria) this;
        }

        public Criteria andIsAccountNotEqualTo(Integer value) {
            addCriterion("is_account <>", value, "isAccount");
            return (Criteria) this;
        }

        public Criteria andIsAccountGreaterThan(Integer value) {
            addCriterion("is_account >", value, "isAccount");
            return (Criteria) this;
        }

        public Criteria andIsAccountGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_account >=", value, "isAccount");
            return (Criteria) this;
        }

        public Criteria andIsAccountLessThan(Integer value) {
            addCriterion("is_account <", value, "isAccount");
            return (Criteria) this;
        }

        public Criteria andIsAccountLessThanOrEqualTo(Integer value) {
            addCriterion("is_account <=", value, "isAccount");
            return (Criteria) this;
        }

        public Criteria andIsAccountIn(List<Integer> values) {
            addCriterion("is_account in", values, "isAccount");
            return (Criteria) this;
        }

        public Criteria andIsAccountNotIn(List<Integer> values) {
            addCriterion("is_account not in", values, "isAccount");
            return (Criteria) this;
        }

        public Criteria andIsAccountBetween(Integer value1, Integer value2) {
            addCriterion("is_account between", value1, value2, "isAccount");
            return (Criteria) this;
        }

        public Criteria andIsAccountNotBetween(Integer value1, Integer value2) {
            addCriterion("is_account not between", value1, value2, "isAccount");
            return (Criteria) this;
        }

        public Criteria andLinkIsNull() {
            addCriterion("link is null");
            return (Criteria) this;
        }

        public Criteria andLinkIsNotNull() {
            addCriterion("link is not null");
            return (Criteria) this;
        }

        public Criteria andLinkEqualTo(String value) {
            addCriterion("link =", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotEqualTo(String value) {
            addCriterion("link <>", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThan(String value) {
            addCriterion("link >", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThanOrEqualTo(String value) {
            addCriterion("link >=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThan(String value) {
            addCriterion("link <", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThanOrEqualTo(String value) {
            addCriterion("link <=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLike(String value) {
            addCriterion("link like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotLike(String value) {
            addCriterion("link not like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkIn(List<String> values) {
            addCriterion("link in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotIn(List<String> values) {
            addCriterion("link not in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkBetween(String value1, String value2) {
            addCriterion("link between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotBetween(String value1, String value2) {
            addCriterion("link not between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andProvideTypeIsNull() {
            addCriterion("provide_type is null");
            return (Criteria) this;
        }

        public Criteria andProvideTypeIsNotNull() {
            addCriterion("provide_type is not null");
            return (Criteria) this;
        }

        public Criteria andProvideTypeEqualTo(Integer value) {
            addCriterion("provide_type =", value, "provideType");
            return (Criteria) this;
        }

        public Criteria andProvideTypeNotEqualTo(Integer value) {
            addCriterion("provide_type <>", value, "provideType");
            return (Criteria) this;
        }

        public Criteria andProvideTypeGreaterThan(Integer value) {
            addCriterion("provide_type >", value, "provideType");
            return (Criteria) this;
        }

        public Criteria andProvideTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("provide_type >=", value, "provideType");
            return (Criteria) this;
        }

        public Criteria andProvideTypeLessThan(Integer value) {
            addCriterion("provide_type <", value, "provideType");
            return (Criteria) this;
        }

        public Criteria andProvideTypeLessThanOrEqualTo(Integer value) {
            addCriterion("provide_type <=", value, "provideType");
            return (Criteria) this;
        }

        public Criteria andProvideTypeIn(List<Integer> values) {
            addCriterion("provide_type in", values, "provideType");
            return (Criteria) this;
        }

        public Criteria andProvideTypeNotIn(List<Integer> values) {
            addCriterion("provide_type not in", values, "provideType");
            return (Criteria) this;
        }

        public Criteria andProvideTypeBetween(Integer value1, Integer value2) {
            addCriterion("provide_type between", value1, value2, "provideType");
            return (Criteria) this;
        }

        public Criteria andProvideTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("provide_type not between", value1, value2, "provideType");
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

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
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

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(Integer value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(Integer value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(Integer value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(Integer value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(Integer value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<Integer> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<Integer> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(Integer value1, Integer value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andClauseIdIsNull() {
            addCriterion("clause_id is null");
            return (Criteria) this;
        }

        public Criteria andClauseIdIsNotNull() {
            addCriterion("clause_id is not null");
            return (Criteria) this;
        }

        public Criteria andClauseIdEqualTo(Integer value) {
            addCriterion("clause_id =", value, "clauseId");
            return (Criteria) this;
        }

        public Criteria andClauseIdNotEqualTo(Integer value) {
            addCriterion("clause_id <>", value, "clauseId");
            return (Criteria) this;
        }

        public Criteria andClauseIdGreaterThan(Integer value) {
            addCriterion("clause_id >", value, "clauseId");
            return (Criteria) this;
        }

        public Criteria andClauseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("clause_id >=", value, "clauseId");
            return (Criteria) this;
        }

        public Criteria andClauseIdLessThan(Integer value) {
            addCriterion("clause_id <", value, "clauseId");
            return (Criteria) this;
        }

        public Criteria andClauseIdLessThanOrEqualTo(Integer value) {
            addCriterion("clause_id <=", value, "clauseId");
            return (Criteria) this;
        }

        public Criteria andClauseIdIn(List<Integer> values) {
            addCriterion("clause_id in", values, "clauseId");
            return (Criteria) this;
        }

        public Criteria andClauseIdNotIn(List<Integer> values) {
            addCriterion("clause_id not in", values, "clauseId");
            return (Criteria) this;
        }

        public Criteria andClauseIdBetween(Integer value1, Integer value2) {
            addCriterion("clause_id between", value1, value2, "clauseId");
            return (Criteria) this;
        }

        public Criteria andClauseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("clause_id not between", value1, value2, "clauseId");
            return (Criteria) this;
        }

        public Criteria andAppSecretIsNull() {
            addCriterion("app_secret is null");
            return (Criteria) this;
        }

        public Criteria andAppSecretIsNotNull() {
            addCriterion("app_secret is not null");
            return (Criteria) this;
        }

        public Criteria andAppSecretEqualTo(String value) {
            addCriterion("app_secret =", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotEqualTo(String value) {
            addCriterion("app_secret <>", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretGreaterThan(String value) {
            addCriterion("app_secret >", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretGreaterThanOrEqualTo(String value) {
            addCriterion("app_secret >=", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLessThan(String value) {
            addCriterion("app_secret <", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLessThanOrEqualTo(String value) {
            addCriterion("app_secret <=", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLike(String value) {
            addCriterion("app_secret like", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotLike(String value) {
            addCriterion("app_secret not like", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretIn(List<String> values) {
            addCriterion("app_secret in", values, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotIn(List<String> values) {
            addCriterion("app_secret not in", values, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretBetween(String value1, String value2) {
            addCriterion("app_secret between", value1, value2, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotBetween(String value1, String value2) {
            addCriterion("app_secret not between", value1, value2, "appSecret");
            return (Criteria) this;
        }

        public Criteria andReceivableCautionMoneyIsNull() {
            addCriterion("receivable_caution_money is null");
            return (Criteria) this;
        }

        public Criteria andReceivableCautionMoneyIsNotNull() {
            addCriterion("receivable_caution_money is not null");
            return (Criteria) this;
        }

        public Criteria andReceivableCautionMoneyEqualTo(BigDecimal value) {
            addCriterion("receivable_caution_money =", value, "receivableCautionMoney");
            return (Criteria) this;
        }

        public Criteria andReceivableCautionMoneyNotEqualTo(BigDecimal value) {
            addCriterion("receivable_caution_money <>", value, "receivableCautionMoney");
            return (Criteria) this;
        }

        public Criteria andReceivableCautionMoneyGreaterThan(BigDecimal value) {
            addCriterion("receivable_caution_money >", value, "receivableCautionMoney");
            return (Criteria) this;
        }

        public Criteria andReceivableCautionMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("receivable_caution_money >=", value, "receivableCautionMoney");
            return (Criteria) this;
        }

        public Criteria andReceivableCautionMoneyLessThan(BigDecimal value) {
            addCriterion("receivable_caution_money <", value, "receivableCautionMoney");
            return (Criteria) this;
        }

        public Criteria andReceivableCautionMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("receivable_caution_money <=", value, "receivableCautionMoney");
            return (Criteria) this;
        }

        public Criteria andReceivableCautionMoneyIn(List<BigDecimal> values) {
            addCriterion("receivable_caution_money in", values, "receivableCautionMoney");
            return (Criteria) this;
        }

        public Criteria andReceivableCautionMoneyNotIn(List<BigDecimal> values) {
            addCriterion("receivable_caution_money not in", values, "receivableCautionMoney");
            return (Criteria) this;
        }

        public Criteria andReceivableCautionMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receivable_caution_money between", value1, value2, "receivableCautionMoney");
            return (Criteria) this;
        }

        public Criteria andReceivableCautionMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receivable_caution_money not between", value1, value2, "receivableCautionMoney");
            return (Criteria) this;
        }

        public Criteria andRecommendLevelIsNull() {
            addCriterion("recommend_level is null");
            return (Criteria) this;
        }

        public Criteria andRecommendLevelIsNotNull() {
            addCriterion("recommend_level is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendLevelEqualTo(Double value) {
            addCriterion("recommend_level =", value, "recommendLevel");
            return (Criteria) this;
        }

        public Criteria andRecommendLevelNotEqualTo(Double value) {
            addCriterion("recommend_level <>", value, "recommendLevel");
            return (Criteria) this;
        }

        public Criteria andRecommendLevelGreaterThan(Double value) {
            addCriterion("recommend_level >", value, "recommendLevel");
            return (Criteria) this;
        }

        public Criteria andRecommendLevelGreaterThanOrEqualTo(Double value) {
            addCriterion("recommend_level >=", value, "recommendLevel");
            return (Criteria) this;
        }

        public Criteria andRecommendLevelLessThan(Double value) {
            addCriterion("recommend_level <", value, "recommendLevel");
            return (Criteria) this;
        }

        public Criteria andRecommendLevelLessThanOrEqualTo(Double value) {
            addCriterion("recommend_level <=", value, "recommendLevel");
            return (Criteria) this;
        }

        public Criteria andRecommendLevelIn(List<Double> values) {
            addCriterion("recommend_level in", values, "recommendLevel");
            return (Criteria) this;
        }

        public Criteria andRecommendLevelNotIn(List<Double> values) {
            addCriterion("recommend_level not in", values, "recommendLevel");
            return (Criteria) this;
        }

        public Criteria andRecommendLevelBetween(Double value1, Double value2) {
            addCriterion("recommend_level between", value1, value2, "recommendLevel");
            return (Criteria) this;
        }

        public Criteria andRecommendLevelNotBetween(Double value1, Double value2) {
            addCriterion("recommend_level not between", value1, value2, "recommendLevel");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyTypeIsNull() {
            addCriterion("caution_money_type is null");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyTypeIsNotNull() {
            addCriterion("caution_money_type is not null");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyTypeEqualTo(Integer value) {
            addCriterion("caution_money_type =", value, "cautionMoneyType");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyTypeNotEqualTo(Integer value) {
            addCriterion("caution_money_type <>", value, "cautionMoneyType");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyTypeGreaterThan(Integer value) {
            addCriterion("caution_money_type >", value, "cautionMoneyType");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("caution_money_type >=", value, "cautionMoneyType");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyTypeLessThan(Integer value) {
            addCriterion("caution_money_type <", value, "cautionMoneyType");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("caution_money_type <=", value, "cautionMoneyType");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyTypeIn(List<Integer> values) {
            addCriterion("caution_money_type in", values, "cautionMoneyType");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyTypeNotIn(List<Integer> values) {
            addCriterion("caution_money_type not in", values, "cautionMoneyType");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyTypeBetween(Integer value1, Integer value2) {
            addCriterion("caution_money_type between", value1, value2, "cautionMoneyType");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("caution_money_type not between", value1, value2, "cautionMoneyType");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyPicIsNull() {
            addCriterion("caution_money_pic is null");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyPicIsNotNull() {
            addCriterion("caution_money_pic is not null");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyPicEqualTo(String value) {
            addCriterion("caution_money_pic =", value, "cautionMoneyPic");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyPicNotEqualTo(String value) {
            addCriterion("caution_money_pic <>", value, "cautionMoneyPic");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyPicGreaterThan(String value) {
            addCriterion("caution_money_pic >", value, "cautionMoneyPic");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyPicGreaterThanOrEqualTo(String value) {
            addCriterion("caution_money_pic >=", value, "cautionMoneyPic");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyPicLessThan(String value) {
            addCriterion("caution_money_pic <", value, "cautionMoneyPic");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyPicLessThanOrEqualTo(String value) {
            addCriterion("caution_money_pic <=", value, "cautionMoneyPic");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyPicLike(String value) {
            addCriterion("caution_money_pic like", value, "cautionMoneyPic");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyPicNotLike(String value) {
            addCriterion("caution_money_pic not like", value, "cautionMoneyPic");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyPicIn(List<String> values) {
            addCriterion("caution_money_pic in", values, "cautionMoneyPic");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyPicNotIn(List<String> values) {
            addCriterion("caution_money_pic not in", values, "cautionMoneyPic");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyPicBetween(String value1, String value2) {
            addCriterion("caution_money_pic between", value1, value2, "cautionMoneyPic");
            return (Criteria) this;
        }

        public Criteria andCautionMoneyPicNotBetween(String value1, String value2) {
            addCriterion("caution_money_pic not between", value1, value2, "cautionMoneyPic");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCautionBillIdIsNull() {
            addCriterion("caution_bill_id is null");
            return (Criteria) this;
        }

        public Criteria andCautionBillIdIsNotNull() {
            addCriterion("caution_bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andCautionBillIdEqualTo(String value) {
            addCriterion("caution_bill_id =", value, "cautionBillId");
            return (Criteria) this;
        }

        public Criteria andCautionBillIdNotEqualTo(String value) {
            addCriterion("caution_bill_id <>", value, "cautionBillId");
            return (Criteria) this;
        }

        public Criteria andCautionBillIdGreaterThan(String value) {
            addCriterion("caution_bill_id >", value, "cautionBillId");
            return (Criteria) this;
        }

        public Criteria andCautionBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("caution_bill_id >=", value, "cautionBillId");
            return (Criteria) this;
        }

        public Criteria andCautionBillIdLessThan(String value) {
            addCriterion("caution_bill_id <", value, "cautionBillId");
            return (Criteria) this;
        }

        public Criteria andCautionBillIdLessThanOrEqualTo(String value) {
            addCriterion("caution_bill_id <=", value, "cautionBillId");
            return (Criteria) this;
        }

        public Criteria andCautionBillIdLike(String value) {
            addCriterion("caution_bill_id like", value, "cautionBillId");
            return (Criteria) this;
        }

        public Criteria andCautionBillIdNotLike(String value) {
            addCriterion("caution_bill_id not like", value, "cautionBillId");
            return (Criteria) this;
        }

        public Criteria andCautionBillIdIn(List<String> values) {
            addCriterion("caution_bill_id in", values, "cautionBillId");
            return (Criteria) this;
        }

        public Criteria andCautionBillIdNotIn(List<String> values) {
            addCriterion("caution_bill_id not in", values, "cautionBillId");
            return (Criteria) this;
        }

        public Criteria andCautionBillIdBetween(String value1, String value2) {
            addCriterion("caution_bill_id between", value1, value2, "cautionBillId");
            return (Criteria) this;
        }

        public Criteria andCautionBillIdNotBetween(String value1, String value2) {
            addCriterion("caution_bill_id not between", value1, value2, "cautionBillId");
            return (Criteria) this;
        }

        public Criteria andUserRangeIsNull() {
            addCriterion("user_range is null");
            return (Criteria) this;
        }

        public Criteria andUserRangeIsNotNull() {
            addCriterion("user_range is not null");
            return (Criteria) this;
        }

        public Criteria andUserRangeEqualTo(Integer value) {
            addCriterion("user_range =", value, "userRange");
            return (Criteria) this;
        }

        public Criteria andUserRangeNotEqualTo(Integer value) {
            addCriterion("user_range <>", value, "userRange");
            return (Criteria) this;
        }

        public Criteria andUserRangeGreaterThan(Integer value) {
            addCriterion("user_range >", value, "userRange");
            return (Criteria) this;
        }

        public Criteria andUserRangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_range >=", value, "userRange");
            return (Criteria) this;
        }

        public Criteria andUserRangeLessThan(Integer value) {
            addCriterion("user_range <", value, "userRange");
            return (Criteria) this;
        }

        public Criteria andUserRangeLessThanOrEqualTo(Integer value) {
            addCriterion("user_range <=", value, "userRange");
            return (Criteria) this;
        }

        public Criteria andUserRangeIn(List<Integer> values) {
            addCriterion("user_range in", values, "userRange");
            return (Criteria) this;
        }

        public Criteria andUserRangeNotIn(List<Integer> values) {
            addCriterion("user_range not in", values, "userRange");
            return (Criteria) this;
        }

        public Criteria andUserRangeBetween(Integer value1, Integer value2) {
            addCriterion("user_range between", value1, value2, "userRange");
            return (Criteria) this;
        }

        public Criteria andUserRangeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_range not between", value1, value2, "userRange");
            return (Criteria) this;
        }

        public Criteria andGroundAuditStatusIsNull() {
            addCriterion("ground_audit_status is null");
            return (Criteria) this;
        }

        public Criteria andGroundAuditStatusIsNotNull() {
            addCriterion("ground_audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andGroundAuditStatusEqualTo(Integer value) {
            addCriterion("ground_audit_status =", value, "groundAuditStatus");
            return (Criteria) this;
        }

        public Criteria andGroundAuditStatusNotEqualTo(Integer value) {
            addCriterion("ground_audit_status <>", value, "groundAuditStatus");
            return (Criteria) this;
        }

        public Criteria andGroundAuditStatusGreaterThan(Integer value) {
            addCriterion("ground_audit_status >", value, "groundAuditStatus");
            return (Criteria) this;
        }

        public Criteria andGroundAuditStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ground_audit_status >=", value, "groundAuditStatus");
            return (Criteria) this;
        }

        public Criteria andGroundAuditStatusLessThan(Integer value) {
            addCriterion("ground_audit_status <", value, "groundAuditStatus");
            return (Criteria) this;
        }

        public Criteria andGroundAuditStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ground_audit_status <=", value, "groundAuditStatus");
            return (Criteria) this;
        }

        public Criteria andGroundAuditStatusIn(List<Integer> values) {
            addCriterion("ground_audit_status in", values, "groundAuditStatus");
            return (Criteria) this;
        }

        public Criteria andGroundAuditStatusNotIn(List<Integer> values) {
            addCriterion("ground_audit_status not in", values, "groundAuditStatus");
            return (Criteria) this;
        }

        public Criteria andGroundAuditStatusBetween(Integer value1, Integer value2) {
            addCriterion("ground_audit_status between", value1, value2, "groundAuditStatus");
            return (Criteria) this;
        }

        public Criteria andGroundAuditStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ground_audit_status not between", value1, value2, "groundAuditStatus");
            return (Criteria) this;
        }

        public Criteria andShotIsNull() {
            addCriterion("shot is null");
            return (Criteria) this;
        }

        public Criteria andShotIsNotNull() {
            addCriterion("shot is not null");
            return (Criteria) this;
        }

        public Criteria andShotEqualTo(String value) {
            addCriterion("shot =", value, "shot");
            return (Criteria) this;
        }

        public Criteria andShotNotEqualTo(String value) {
            addCriterion("shot <>", value, "shot");
            return (Criteria) this;
        }

        public Criteria andShotGreaterThan(String value) {
            addCriterion("shot >", value, "shot");
            return (Criteria) this;
        }

        public Criteria andShotGreaterThanOrEqualTo(String value) {
            addCriterion("shot >=", value, "shot");
            return (Criteria) this;
        }

        public Criteria andShotLessThan(String value) {
            addCriterion("shot <", value, "shot");
            return (Criteria) this;
        }

        public Criteria andShotLessThanOrEqualTo(String value) {
            addCriterion("shot <=", value, "shot");
            return (Criteria) this;
        }

        public Criteria andShotLike(String value) {
            addCriterion("shot like", value, "shot");
            return (Criteria) this;
        }

        public Criteria andShotNotLike(String value) {
            addCriterion("shot not like", value, "shot");
            return (Criteria) this;
        }

        public Criteria andShotIn(List<String> values) {
            addCriterion("shot in", values, "shot");
            return (Criteria) this;
        }

        public Criteria andShotNotIn(List<String> values) {
            addCriterion("shot not in", values, "shot");
            return (Criteria) this;
        }

        public Criteria andShotBetween(String value1, String value2) {
            addCriterion("shot between", value1, value2, "shot");
            return (Criteria) this;
        }

        public Criteria andShotNotBetween(String value1, String value2) {
            addCriterion("shot not between", value1, value2, "shot");
            return (Criteria) this;
        }

        public Criteria andAccountReceivableProjectIsNull() {
            addCriterion("account_receivable_project is null");
            return (Criteria) this;
        }

        public Criteria andAccountReceivableProjectIsNotNull() {
            addCriterion("account_receivable_project is not null");
            return (Criteria) this;
        }

        public Criteria andAccountReceivableProjectEqualTo(String value) {
            addCriterion("account_receivable_project =", value, "accountReceivableProject");
            return (Criteria) this;
        }

        public Criteria andAccountReceivableProjectNotEqualTo(String value) {
            addCriterion("account_receivable_project <>", value, "accountReceivableProject");
            return (Criteria) this;
        }

        public Criteria andAccountReceivableProjectGreaterThan(String value) {
            addCriterion("account_receivable_project >", value, "accountReceivableProject");
            return (Criteria) this;
        }

        public Criteria andAccountReceivableProjectGreaterThanOrEqualTo(String value) {
            addCriterion("account_receivable_project >=", value, "accountReceivableProject");
            return (Criteria) this;
        }

        public Criteria andAccountReceivableProjectLessThan(String value) {
            addCriterion("account_receivable_project <", value, "accountReceivableProject");
            return (Criteria) this;
        }

        public Criteria andAccountReceivableProjectLessThanOrEqualTo(String value) {
            addCriterion("account_receivable_project <=", value, "accountReceivableProject");
            return (Criteria) this;
        }

        public Criteria andAccountReceivableProjectLike(String value) {
            addCriterion("account_receivable_project like", value, "accountReceivableProject");
            return (Criteria) this;
        }

        public Criteria andAccountReceivableProjectNotLike(String value) {
            addCriterion("account_receivable_project not like", value, "accountReceivableProject");
            return (Criteria) this;
        }

        public Criteria andAccountReceivableProjectIn(List<String> values) {
            addCriterion("account_receivable_project in", values, "accountReceivableProject");
            return (Criteria) this;
        }

        public Criteria andAccountReceivableProjectNotIn(List<String> values) {
            addCriterion("account_receivable_project not in", values, "accountReceivableProject");
            return (Criteria) this;
        }

        public Criteria andAccountReceivableProjectBetween(String value1, String value2) {
            addCriterion("account_receivable_project between", value1, value2, "accountReceivableProject");
            return (Criteria) this;
        }

        public Criteria andAccountReceivableProjectNotBetween(String value1, String value2) {
            addCriterion("account_receivable_project not between", value1, value2, "accountReceivableProject");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNull() {
            addCriterion("notify_url is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNotNull() {
            addCriterion("notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlEqualTo(String value) {
            addCriterion("notify_url =", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotEqualTo(String value) {
            addCriterion("notify_url <>", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThan(String value) {
            addCriterion("notify_url >", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("notify_url >=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThan(String value) {
            addCriterion("notify_url <", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("notify_url <=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLike(String value) {
            addCriterion("notify_url like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotLike(String value) {
            addCriterion("notify_url not like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIn(List<String> values) {
            addCriterion("notify_url in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotIn(List<String> values) {
            addCriterion("notify_url not in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlBetween(String value1, String value2) {
            addCriterion("notify_url between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("notify_url not between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andBalanceReceiveEmailIsNull() {
            addCriterion("balance_receive_email is null");
            return (Criteria) this;
        }

        public Criteria andBalanceReceiveEmailIsNotNull() {
            addCriterion("balance_receive_email is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceReceiveEmailEqualTo(String value) {
            addCriterion("balance_receive_email =", value, "balanceReceiveEmail");
            return (Criteria) this;
        }

        public Criteria andBalanceReceiveEmailNotEqualTo(String value) {
            addCriterion("balance_receive_email <>", value, "balanceReceiveEmail");
            return (Criteria) this;
        }

        public Criteria andBalanceReceiveEmailGreaterThan(String value) {
            addCriterion("balance_receive_email >", value, "balanceReceiveEmail");
            return (Criteria) this;
        }

        public Criteria andBalanceReceiveEmailGreaterThanOrEqualTo(String value) {
            addCriterion("balance_receive_email >=", value, "balanceReceiveEmail");
            return (Criteria) this;
        }

        public Criteria andBalanceReceiveEmailLessThan(String value) {
            addCriterion("balance_receive_email <", value, "balanceReceiveEmail");
            return (Criteria) this;
        }

        public Criteria andBalanceReceiveEmailLessThanOrEqualTo(String value) {
            addCriterion("balance_receive_email <=", value, "balanceReceiveEmail");
            return (Criteria) this;
        }

        public Criteria andBalanceReceiveEmailLike(String value) {
            addCriterion("balance_receive_email like", value, "balanceReceiveEmail");
            return (Criteria) this;
        }

        public Criteria andBalanceReceiveEmailNotLike(String value) {
            addCriterion("balance_receive_email not like", value, "balanceReceiveEmail");
            return (Criteria) this;
        }

        public Criteria andBalanceReceiveEmailIn(List<String> values) {
            addCriterion("balance_receive_email in", values, "balanceReceiveEmail");
            return (Criteria) this;
        }

        public Criteria andBalanceReceiveEmailNotIn(List<String> values) {
            addCriterion("balance_receive_email not in", values, "balanceReceiveEmail");
            return (Criteria) this;
        }

        public Criteria andBalanceReceiveEmailBetween(String value1, String value2) {
            addCriterion("balance_receive_email between", value1, value2, "balanceReceiveEmail");
            return (Criteria) this;
        }

        public Criteria andBalanceReceiveEmailNotBetween(String value1, String value2) {
            addCriterion("balance_receive_email not between", value1, value2, "balanceReceiveEmail");
            return (Criteria) this;
        }

        public Criteria andUnderReasonIsNull() {
            addCriterion("under_reason is null");
            return (Criteria) this;
        }

        public Criteria andUnderReasonIsNotNull() {
            addCriterion("under_reason is not null");
            return (Criteria) this;
        }

        public Criteria andUnderReasonEqualTo(String value) {
            addCriterion("under_reason =", value, "underReason");
            return (Criteria) this;
        }

        public Criteria andUnderReasonNotEqualTo(String value) {
            addCriterion("under_reason <>", value, "underReason");
            return (Criteria) this;
        }

        public Criteria andUnderReasonGreaterThan(String value) {
            addCriterion("under_reason >", value, "underReason");
            return (Criteria) this;
        }

        public Criteria andUnderReasonGreaterThanOrEqualTo(String value) {
            addCriterion("under_reason >=", value, "underReason");
            return (Criteria) this;
        }

        public Criteria andUnderReasonLessThan(String value) {
            addCriterion("under_reason <", value, "underReason");
            return (Criteria) this;
        }

        public Criteria andUnderReasonLessThanOrEqualTo(String value) {
            addCriterion("under_reason <=", value, "underReason");
            return (Criteria) this;
        }

        public Criteria andUnderReasonLike(String value) {
            addCriterion("under_reason like", value, "underReason");
            return (Criteria) this;
        }

        public Criteria andUnderReasonNotLike(String value) {
            addCriterion("under_reason not like", value, "underReason");
            return (Criteria) this;
        }

        public Criteria andUnderReasonIn(List<String> values) {
            addCriterion("under_reason in", values, "underReason");
            return (Criteria) this;
        }

        public Criteria andUnderReasonNotIn(List<String> values) {
            addCriterion("under_reason not in", values, "underReason");
            return (Criteria) this;
        }

        public Criteria andUnderReasonBetween(String value1, String value2) {
            addCriterion("under_reason between", value1, value2, "underReason");
            return (Criteria) this;
        }

        public Criteria andUnderReasonNotBetween(String value1, String value2) {
            addCriterion("under_reason not between", value1, value2, "underReason");
            return (Criteria) this;
        }

        public Criteria andGroundTimeIsNull() {
            addCriterion("ground_time is null");
            return (Criteria) this;
        }

        public Criteria andGroundTimeIsNotNull() {
            addCriterion("ground_time is not null");
            return (Criteria) this;
        }

        public Criteria andGroundTimeEqualTo(Date value) {
            addCriterion("ground_time =", value, "groundTime");
            return (Criteria) this;
        }

        public Criteria andGroundTimeNotEqualTo(Date value) {
            addCriterion("ground_time <>", value, "groundTime");
            return (Criteria) this;
        }

        public Criteria andGroundTimeGreaterThan(Date value) {
            addCriterion("ground_time >", value, "groundTime");
            return (Criteria) this;
        }

        public Criteria andGroundTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ground_time >=", value, "groundTime");
            return (Criteria) this;
        }

        public Criteria andGroundTimeLessThan(Date value) {
            addCriterion("ground_time <", value, "groundTime");
            return (Criteria) this;
        }

        public Criteria andGroundTimeLessThanOrEqualTo(Date value) {
            addCriterion("ground_time <=", value, "groundTime");
            return (Criteria) this;
        }

        public Criteria andGroundTimeIn(List<Date> values) {
            addCriterion("ground_time in", values, "groundTime");
            return (Criteria) this;
        }

        public Criteria andGroundTimeNotIn(List<Date> values) {
            addCriterion("ground_time not in", values, "groundTime");
            return (Criteria) this;
        }

        public Criteria andGroundTimeBetween(Date value1, Date value2) {
            addCriterion("ground_time between", value1, value2, "groundTime");
            return (Criteria) this;
        }

        public Criteria andGroundTimeNotBetween(Date value1, Date value2) {
            addCriterion("ground_time not between", value1, value2, "groundTime");
            return (Criteria) this;
        }

        public Criteria andMaxIosVersionIsNull() {
            addCriterion("max_ios_version is null");
            return (Criteria) this;
        }

        public Criteria andMaxIosVersionIsNotNull() {
            addCriterion("max_ios_version is not null");
            return (Criteria) this;
        }

        public Criteria andMaxIosVersionEqualTo(String value) {
            addCriterion("max_ios_version =", value, "maxIosVersion");
            return (Criteria) this;
        }

        public Criteria andMaxIosVersionNotEqualTo(String value) {
            addCriterion("max_ios_version <>", value, "maxIosVersion");
            return (Criteria) this;
        }

        public Criteria andMaxIosVersionGreaterThan(String value) {
            addCriterion("max_ios_version >", value, "maxIosVersion");
            return (Criteria) this;
        }

        public Criteria andMaxIosVersionGreaterThanOrEqualTo(String value) {
            addCriterion("max_ios_version >=", value, "maxIosVersion");
            return (Criteria) this;
        }

        public Criteria andMaxIosVersionLessThan(String value) {
            addCriterion("max_ios_version <", value, "maxIosVersion");
            return (Criteria) this;
        }

        public Criteria andMaxIosVersionLessThanOrEqualTo(String value) {
            addCriterion("max_ios_version <=", value, "maxIosVersion");
            return (Criteria) this;
        }

        public Criteria andMaxIosVersionLike(String value) {
            addCriterion("max_ios_version like", value, "maxIosVersion");
            return (Criteria) this;
        }

        public Criteria andMaxIosVersionNotLike(String value) {
            addCriterion("max_ios_version not like", value, "maxIosVersion");
            return (Criteria) this;
        }

        public Criteria andMaxIosVersionIn(List<String> values) {
            addCriterion("max_ios_version in", values, "maxIosVersion");
            return (Criteria) this;
        }

        public Criteria andMaxIosVersionNotIn(List<String> values) {
            addCriterion("max_ios_version not in", values, "maxIosVersion");
            return (Criteria) this;
        }

        public Criteria andMaxIosVersionBetween(String value1, String value2) {
            addCriterion("max_ios_version between", value1, value2, "maxIosVersion");
            return (Criteria) this;
        }

        public Criteria andMaxIosVersionNotBetween(String value1, String value2) {
            addCriterion("max_ios_version not between", value1, value2, "maxIosVersion");
            return (Criteria) this;
        }

        public Criteria andMinIosVersionIsNull() {
            addCriterion("min_ios_version is null");
            return (Criteria) this;
        }

        public Criteria andMinIosVersionIsNotNull() {
            addCriterion("min_ios_version is not null");
            return (Criteria) this;
        }

        public Criteria andMinIosVersionEqualTo(String value) {
            addCriterion("min_ios_version =", value, "minIosVersion");
            return (Criteria) this;
        }

        public Criteria andMinIosVersionNotEqualTo(String value) {
            addCriterion("min_ios_version <>", value, "minIosVersion");
            return (Criteria) this;
        }

        public Criteria andMinIosVersionGreaterThan(String value) {
            addCriterion("min_ios_version >", value, "minIosVersion");
            return (Criteria) this;
        }

        public Criteria andMinIosVersionGreaterThanOrEqualTo(String value) {
            addCriterion("min_ios_version >=", value, "minIosVersion");
            return (Criteria) this;
        }

        public Criteria andMinIosVersionLessThan(String value) {
            addCriterion("min_ios_version <", value, "minIosVersion");
            return (Criteria) this;
        }

        public Criteria andMinIosVersionLessThanOrEqualTo(String value) {
            addCriterion("min_ios_version <=", value, "minIosVersion");
            return (Criteria) this;
        }

        public Criteria andMinIosVersionLike(String value) {
            addCriterion("min_ios_version like", value, "minIosVersion");
            return (Criteria) this;
        }

        public Criteria andMinIosVersionNotLike(String value) {
            addCriterion("min_ios_version not like", value, "minIosVersion");
            return (Criteria) this;
        }

        public Criteria andMinIosVersionIn(List<String> values) {
            addCriterion("min_ios_version in", values, "minIosVersion");
            return (Criteria) this;
        }

        public Criteria andMinIosVersionNotIn(List<String> values) {
            addCriterion("min_ios_version not in", values, "minIosVersion");
            return (Criteria) this;
        }

        public Criteria andMinIosVersionBetween(String value1, String value2) {
            addCriterion("min_ios_version between", value1, value2, "minIosVersion");
            return (Criteria) this;
        }

        public Criteria andMinIosVersionNotBetween(String value1, String value2) {
            addCriterion("min_ios_version not between", value1, value2, "minIosVersion");
            return (Criteria) this;
        }

        public Criteria andMaxAndoirdVersionIsNull() {
            addCriterion("max_andoird_version is null");
            return (Criteria) this;
        }

        public Criteria andMaxAndoirdVersionIsNotNull() {
            addCriterion("max_andoird_version is not null");
            return (Criteria) this;
        }

        public Criteria andMaxAndoirdVersionEqualTo(String value) {
            addCriterion("max_andoird_version =", value, "maxAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMaxAndoirdVersionNotEqualTo(String value) {
            addCriterion("max_andoird_version <>", value, "maxAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMaxAndoirdVersionGreaterThan(String value) {
            addCriterion("max_andoird_version >", value, "maxAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMaxAndoirdVersionGreaterThanOrEqualTo(String value) {
            addCriterion("max_andoird_version >=", value, "maxAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMaxAndoirdVersionLessThan(String value) {
            addCriterion("max_andoird_version <", value, "maxAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMaxAndoirdVersionLessThanOrEqualTo(String value) {
            addCriterion("max_andoird_version <=", value, "maxAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMaxAndoirdVersionLike(String value) {
            addCriterion("max_andoird_version like", value, "maxAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMaxAndoirdVersionNotLike(String value) {
            addCriterion("max_andoird_version not like", value, "maxAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMaxAndoirdVersionIn(List<String> values) {
            addCriterion("max_andoird_version in", values, "maxAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMaxAndoirdVersionNotIn(List<String> values) {
            addCriterion("max_andoird_version not in", values, "maxAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMaxAndoirdVersionBetween(String value1, String value2) {
            addCriterion("max_andoird_version between", value1, value2, "maxAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMaxAndoirdVersionNotBetween(String value1, String value2) {
            addCriterion("max_andoird_version not between", value1, value2, "maxAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMinAndoirdVersionIsNull() {
            addCriterion("min_andoird_version is null");
            return (Criteria) this;
        }

        public Criteria andMinAndoirdVersionIsNotNull() {
            addCriterion("min_andoird_version is not null");
            return (Criteria) this;
        }

        public Criteria andMinAndoirdVersionEqualTo(String value) {
            addCriterion("min_andoird_version =", value, "minAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMinAndoirdVersionNotEqualTo(String value) {
            addCriterion("min_andoird_version <>", value, "minAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMinAndoirdVersionGreaterThan(String value) {
            addCriterion("min_andoird_version >", value, "minAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMinAndoirdVersionGreaterThanOrEqualTo(String value) {
            addCriterion("min_andoird_version >=", value, "minAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMinAndoirdVersionLessThan(String value) {
            addCriterion("min_andoird_version <", value, "minAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMinAndoirdVersionLessThanOrEqualTo(String value) {
            addCriterion("min_andoird_version <=", value, "minAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMinAndoirdVersionLike(String value) {
            addCriterion("min_andoird_version like", value, "minAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMinAndoirdVersionNotLike(String value) {
            addCriterion("min_andoird_version not like", value, "minAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMinAndoirdVersionIn(List<String> values) {
            addCriterion("min_andoird_version in", values, "minAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMinAndoirdVersionNotIn(List<String> values) {
            addCriterion("min_andoird_version not in", values, "minAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMinAndoirdVersionBetween(String value1, String value2) {
            addCriterion("min_andoird_version between", value1, value2, "minAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andMinAndoirdVersionNotBetween(String value1, String value2) {
            addCriterion("min_andoird_version not between", value1, value2, "minAndoirdVersion");
            return (Criteria) this;
        }

        public Criteria andServiceNeedIsNull() {
            addCriterion("service_need is null");
            return (Criteria) this;
        }

        public Criteria andServiceNeedIsNotNull() {
            addCriterion("service_need is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNeedEqualTo(String value) {
            addCriterion("service_need =", value, "serviceNeed");
            return (Criteria) this;
        }

        public Criteria andServiceNeedNotEqualTo(String value) {
            addCriterion("service_need <>", value, "serviceNeed");
            return (Criteria) this;
        }

        public Criteria andServiceNeedGreaterThan(String value) {
            addCriterion("service_need >", value, "serviceNeed");
            return (Criteria) this;
        }

        public Criteria andServiceNeedGreaterThanOrEqualTo(String value) {
            addCriterion("service_need >=", value, "serviceNeed");
            return (Criteria) this;
        }

        public Criteria andServiceNeedLessThan(String value) {
            addCriterion("service_need <", value, "serviceNeed");
            return (Criteria) this;
        }

        public Criteria andServiceNeedLessThanOrEqualTo(String value) {
            addCriterion("service_need <=", value, "serviceNeed");
            return (Criteria) this;
        }

        public Criteria andServiceNeedLike(String value) {
            addCriterion("service_need like", value, "serviceNeed");
            return (Criteria) this;
        }

        public Criteria andServiceNeedNotLike(String value) {
            addCriterion("service_need not like", value, "serviceNeed");
            return (Criteria) this;
        }

        public Criteria andServiceNeedIn(List<String> values) {
            addCriterion("service_need in", values, "serviceNeed");
            return (Criteria) this;
        }

        public Criteria andServiceNeedNotIn(List<String> values) {
            addCriterion("service_need not in", values, "serviceNeed");
            return (Criteria) this;
        }

        public Criteria andServiceNeedBetween(String value1, String value2) {
            addCriterion("service_need between", value1, value2, "serviceNeed");
            return (Criteria) this;
        }

        public Criteria andServiceNeedNotBetween(String value1, String value2) {
            addCriterion("service_need not between", value1, value2, "serviceNeed");
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