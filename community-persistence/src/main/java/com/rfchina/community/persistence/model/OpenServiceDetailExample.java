package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.List;

public class OpenServiceDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenServiceDetailExample() {
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

        public Criteria andServiceIdIsNull() {
            addCriterion("service_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("service_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(Integer value) {
            addCriterion("service_id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(Integer value) {
            addCriterion("service_id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(Integer value) {
            addCriterion("service_id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(Integer value) {
            addCriterion("service_id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(Integer value) {
            addCriterion("service_id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<Integer> values) {
            addCriterion("service_id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<Integer> values) {
            addCriterion("service_id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(Integer value1, Integer value2) {
            addCriterion("service_id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("service_id not between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andDevelopTypeIsNull() {
            addCriterion("develop_type is null");
            return (Criteria) this;
        }

        public Criteria andDevelopTypeIsNotNull() {
            addCriterion("develop_type is not null");
            return (Criteria) this;
        }

        public Criteria andDevelopTypeEqualTo(String value) {
            addCriterion("develop_type =", value, "developType");
            return (Criteria) this;
        }

        public Criteria andDevelopTypeNotEqualTo(String value) {
            addCriterion("develop_type <>", value, "developType");
            return (Criteria) this;
        }

        public Criteria andDevelopTypeGreaterThan(String value) {
            addCriterion("develop_type >", value, "developType");
            return (Criteria) this;
        }

        public Criteria andDevelopTypeGreaterThanOrEqualTo(String value) {
            addCriterion("develop_type >=", value, "developType");
            return (Criteria) this;
        }

        public Criteria andDevelopTypeLessThan(String value) {
            addCriterion("develop_type <", value, "developType");
            return (Criteria) this;
        }

        public Criteria andDevelopTypeLessThanOrEqualTo(String value) {
            addCriterion("develop_type <=", value, "developType");
            return (Criteria) this;
        }

        public Criteria andDevelopTypeLike(String value) {
            addCriterion("develop_type like", value, "developType");
            return (Criteria) this;
        }

        public Criteria andDevelopTypeNotLike(String value) {
            addCriterion("develop_type not like", value, "developType");
            return (Criteria) this;
        }

        public Criteria andDevelopTypeIn(List<String> values) {
            addCriterion("develop_type in", values, "developType");
            return (Criteria) this;
        }

        public Criteria andDevelopTypeNotIn(List<String> values) {
            addCriterion("develop_type not in", values, "developType");
            return (Criteria) this;
        }

        public Criteria andDevelopTypeBetween(String value1, String value2) {
            addCriterion("develop_type between", value1, value2, "developType");
            return (Criteria) this;
        }

        public Criteria andDevelopTypeNotBetween(String value1, String value2) {
            addCriterion("develop_type not between", value1, value2, "developType");
            return (Criteria) this;
        }

        public Criteria andTempleteNameIsNull() {
            addCriterion("templete_name is null");
            return (Criteria) this;
        }

        public Criteria andTempleteNameIsNotNull() {
            addCriterion("templete_name is not null");
            return (Criteria) this;
        }

        public Criteria andTempleteNameEqualTo(String value) {
            addCriterion("templete_name =", value, "templeteName");
            return (Criteria) this;
        }

        public Criteria andTempleteNameNotEqualTo(String value) {
            addCriterion("templete_name <>", value, "templeteName");
            return (Criteria) this;
        }

        public Criteria andTempleteNameGreaterThan(String value) {
            addCriterion("templete_name >", value, "templeteName");
            return (Criteria) this;
        }

        public Criteria andTempleteNameGreaterThanOrEqualTo(String value) {
            addCriterion("templete_name >=", value, "templeteName");
            return (Criteria) this;
        }

        public Criteria andTempleteNameLessThan(String value) {
            addCriterion("templete_name <", value, "templeteName");
            return (Criteria) this;
        }

        public Criteria andTempleteNameLessThanOrEqualTo(String value) {
            addCriterion("templete_name <=", value, "templeteName");
            return (Criteria) this;
        }

        public Criteria andTempleteNameLike(String value) {
            addCriterion("templete_name like", value, "templeteName");
            return (Criteria) this;
        }

        public Criteria andTempleteNameNotLike(String value) {
            addCriterion("templete_name not like", value, "templeteName");
            return (Criteria) this;
        }

        public Criteria andTempleteNameIn(List<String> values) {
            addCriterion("templete_name in", values, "templeteName");
            return (Criteria) this;
        }

        public Criteria andTempleteNameNotIn(List<String> values) {
            addCriterion("templete_name not in", values, "templeteName");
            return (Criteria) this;
        }

        public Criteria andTempleteNameBetween(String value1, String value2) {
            addCriterion("templete_name between", value1, value2, "templeteName");
            return (Criteria) this;
        }

        public Criteria andTempleteNameNotBetween(String value1, String value2) {
            addCriterion("templete_name not between", value1, value2, "templeteName");
            return (Criteria) this;
        }

        public Criteria andTempleteStatusIsNull() {
            addCriterion("templete_status is null");
            return (Criteria) this;
        }

        public Criteria andTempleteStatusIsNotNull() {
            addCriterion("templete_status is not null");
            return (Criteria) this;
        }

        public Criteria andTempleteStatusEqualTo(Integer value) {
            addCriterion("templete_status =", value, "templeteStatus");
            return (Criteria) this;
        }

        public Criteria andTempleteStatusNotEqualTo(Integer value) {
            addCriterion("templete_status <>", value, "templeteStatus");
            return (Criteria) this;
        }

        public Criteria andTempleteStatusGreaterThan(Integer value) {
            addCriterion("templete_status >", value, "templeteStatus");
            return (Criteria) this;
        }

        public Criteria andTempleteStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("templete_status >=", value, "templeteStatus");
            return (Criteria) this;
        }

        public Criteria andTempleteStatusLessThan(Integer value) {
            addCriterion("templete_status <", value, "templeteStatus");
            return (Criteria) this;
        }

        public Criteria andTempleteStatusLessThanOrEqualTo(Integer value) {
            addCriterion("templete_status <=", value, "templeteStatus");
            return (Criteria) this;
        }

        public Criteria andTempleteStatusIn(List<Integer> values) {
            addCriterion("templete_status in", values, "templeteStatus");
            return (Criteria) this;
        }

        public Criteria andTempleteStatusNotIn(List<Integer> values) {
            addCriterion("templete_status not in", values, "templeteStatus");
            return (Criteria) this;
        }

        public Criteria andTempleteStatusBetween(Integer value1, Integer value2) {
            addCriterion("templete_status between", value1, value2, "templeteStatus");
            return (Criteria) this;
        }

        public Criteria andTempleteStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("templete_status not between", value1, value2, "templeteStatus");
            return (Criteria) this;
        }

        public Criteria andAppIndexSortIsNull() {
            addCriterion("app_index_sort is null");
            return (Criteria) this;
        }

        public Criteria andAppIndexSortIsNotNull() {
            addCriterion("app_index_sort is not null");
            return (Criteria) this;
        }

        public Criteria andAppIndexSortEqualTo(Integer value) {
            addCriterion("app_index_sort =", value, "appIndexSort");
            return (Criteria) this;
        }

        public Criteria andAppIndexSortNotEqualTo(Integer value) {
            addCriterion("app_index_sort <>", value, "appIndexSort");
            return (Criteria) this;
        }

        public Criteria andAppIndexSortGreaterThan(Integer value) {
            addCriterion("app_index_sort >", value, "appIndexSort");
            return (Criteria) this;
        }

        public Criteria andAppIndexSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_index_sort >=", value, "appIndexSort");
            return (Criteria) this;
        }

        public Criteria andAppIndexSortLessThan(Integer value) {
            addCriterion("app_index_sort <", value, "appIndexSort");
            return (Criteria) this;
        }

        public Criteria andAppIndexSortLessThanOrEqualTo(Integer value) {
            addCriterion("app_index_sort <=", value, "appIndexSort");
            return (Criteria) this;
        }

        public Criteria andAppIndexSortIn(List<Integer> values) {
            addCriterion("app_index_sort in", values, "appIndexSort");
            return (Criteria) this;
        }

        public Criteria andAppIndexSortNotIn(List<Integer> values) {
            addCriterion("app_index_sort not in", values, "appIndexSort");
            return (Criteria) this;
        }

        public Criteria andAppIndexSortBetween(Integer value1, Integer value2) {
            addCriterion("app_index_sort between", value1, value2, "appIndexSort");
            return (Criteria) this;
        }

        public Criteria andAppIndexSortNotBetween(Integer value1, Integer value2) {
            addCriterion("app_index_sort not between", value1, value2, "appIndexSort");
            return (Criteria) this;
        }

        public Criteria andAppCatSortIsNull() {
            addCriterion("app_cat_sort is null");
            return (Criteria) this;
        }

        public Criteria andAppCatSortIsNotNull() {
            addCriterion("app_cat_sort is not null");
            return (Criteria) this;
        }

        public Criteria andAppCatSortEqualTo(Integer value) {
            addCriterion("app_cat_sort =", value, "appCatSort");
            return (Criteria) this;
        }

        public Criteria andAppCatSortNotEqualTo(Integer value) {
            addCriterion("app_cat_sort <>", value, "appCatSort");
            return (Criteria) this;
        }

        public Criteria andAppCatSortGreaterThan(Integer value) {
            addCriterion("app_cat_sort >", value, "appCatSort");
            return (Criteria) this;
        }

        public Criteria andAppCatSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_cat_sort >=", value, "appCatSort");
            return (Criteria) this;
        }

        public Criteria andAppCatSortLessThan(Integer value) {
            addCriterion("app_cat_sort <", value, "appCatSort");
            return (Criteria) this;
        }

        public Criteria andAppCatSortLessThanOrEqualTo(Integer value) {
            addCriterion("app_cat_sort <=", value, "appCatSort");
            return (Criteria) this;
        }

        public Criteria andAppCatSortIn(List<Integer> values) {
            addCriterion("app_cat_sort in", values, "appCatSort");
            return (Criteria) this;
        }

        public Criteria andAppCatSortNotIn(List<Integer> values) {
            addCriterion("app_cat_sort not in", values, "appCatSort");
            return (Criteria) this;
        }

        public Criteria andAppCatSortBetween(Integer value1, Integer value2) {
            addCriterion("app_cat_sort between", value1, value2, "appCatSort");
            return (Criteria) this;
        }

        public Criteria andAppCatSortNotBetween(Integer value1, Integer value2) {
            addCriterion("app_cat_sort not between", value1, value2, "appCatSort");
            return (Criteria) this;
        }

        public Criteria andRfchinaCodeIsNull() {
            addCriterion("rfchina_code is null");
            return (Criteria) this;
        }

        public Criteria andRfchinaCodeIsNotNull() {
            addCriterion("rfchina_code is not null");
            return (Criteria) this;
        }

        public Criteria andRfchinaCodeEqualTo(Integer value) {
            addCriterion("rfchina_code =", value, "rfchinaCode");
            return (Criteria) this;
        }

        public Criteria andRfchinaCodeNotEqualTo(Integer value) {
            addCriterion("rfchina_code <>", value, "rfchinaCode");
            return (Criteria) this;
        }

        public Criteria andRfchinaCodeGreaterThan(Integer value) {
            addCriterion("rfchina_code >", value, "rfchinaCode");
            return (Criteria) this;
        }

        public Criteria andRfchinaCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("rfchina_code >=", value, "rfchinaCode");
            return (Criteria) this;
        }

        public Criteria andRfchinaCodeLessThan(Integer value) {
            addCriterion("rfchina_code <", value, "rfchinaCode");
            return (Criteria) this;
        }

        public Criteria andRfchinaCodeLessThanOrEqualTo(Integer value) {
            addCriterion("rfchina_code <=", value, "rfchinaCode");
            return (Criteria) this;
        }

        public Criteria andRfchinaCodeIn(List<Integer> values) {
            addCriterion("rfchina_code in", values, "rfchinaCode");
            return (Criteria) this;
        }

        public Criteria andRfchinaCodeNotIn(List<Integer> values) {
            addCriterion("rfchina_code not in", values, "rfchinaCode");
            return (Criteria) this;
        }

        public Criteria andRfchinaCodeBetween(Integer value1, Integer value2) {
            addCriterion("rfchina_code between", value1, value2, "rfchinaCode");
            return (Criteria) this;
        }

        public Criteria andRfchinaCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("rfchina_code not between", value1, value2, "rfchinaCode");
            return (Criteria) this;
        }

        public Criteria andCautionRefundStatusIsNull() {
            addCriterion("caution_refund_status is null");
            return (Criteria) this;
        }

        public Criteria andCautionRefundStatusIsNotNull() {
            addCriterion("caution_refund_status is not null");
            return (Criteria) this;
        }

        public Criteria andCautionRefundStatusEqualTo(Integer value) {
            addCriterion("caution_refund_status =", value, "cautionRefundStatus");
            return (Criteria) this;
        }

        public Criteria andCautionRefundStatusNotEqualTo(Integer value) {
            addCriterion("caution_refund_status <>", value, "cautionRefundStatus");
            return (Criteria) this;
        }

        public Criteria andCautionRefundStatusGreaterThan(Integer value) {
            addCriterion("caution_refund_status >", value, "cautionRefundStatus");
            return (Criteria) this;
        }

        public Criteria andCautionRefundStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("caution_refund_status >=", value, "cautionRefundStatus");
            return (Criteria) this;
        }

        public Criteria andCautionRefundStatusLessThan(Integer value) {
            addCriterion("caution_refund_status <", value, "cautionRefundStatus");
            return (Criteria) this;
        }

        public Criteria andCautionRefundStatusLessThanOrEqualTo(Integer value) {
            addCriterion("caution_refund_status <=", value, "cautionRefundStatus");
            return (Criteria) this;
        }

        public Criteria andCautionRefundStatusIn(List<Integer> values) {
            addCriterion("caution_refund_status in", values, "cautionRefundStatus");
            return (Criteria) this;
        }

        public Criteria andCautionRefundStatusNotIn(List<Integer> values) {
            addCriterion("caution_refund_status not in", values, "cautionRefundStatus");
            return (Criteria) this;
        }

        public Criteria andCautionRefundStatusBetween(Integer value1, Integer value2) {
            addCriterion("caution_refund_status between", value1, value2, "cautionRefundStatus");
            return (Criteria) this;
        }

        public Criteria andCautionRefundStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("caution_refund_status not between", value1, value2, "cautionRefundStatus");
            return (Criteria) this;
        }

        public Criteria andCautionRefundReasonIsNull() {
            addCriterion("caution_refund_reason is null");
            return (Criteria) this;
        }

        public Criteria andCautionRefundReasonIsNotNull() {
            addCriterion("caution_refund_reason is not null");
            return (Criteria) this;
        }

        public Criteria andCautionRefundReasonEqualTo(String value) {
            addCriterion("caution_refund_reason =", value, "cautionRefundReason");
            return (Criteria) this;
        }

        public Criteria andCautionRefundReasonNotEqualTo(String value) {
            addCriterion("caution_refund_reason <>", value, "cautionRefundReason");
            return (Criteria) this;
        }

        public Criteria andCautionRefundReasonGreaterThan(String value) {
            addCriterion("caution_refund_reason >", value, "cautionRefundReason");
            return (Criteria) this;
        }

        public Criteria andCautionRefundReasonGreaterThanOrEqualTo(String value) {
            addCriterion("caution_refund_reason >=", value, "cautionRefundReason");
            return (Criteria) this;
        }

        public Criteria andCautionRefundReasonLessThan(String value) {
            addCriterion("caution_refund_reason <", value, "cautionRefundReason");
            return (Criteria) this;
        }

        public Criteria andCautionRefundReasonLessThanOrEqualTo(String value) {
            addCriterion("caution_refund_reason <=", value, "cautionRefundReason");
            return (Criteria) this;
        }

        public Criteria andCautionRefundReasonLike(String value) {
            addCriterion("caution_refund_reason like", value, "cautionRefundReason");
            return (Criteria) this;
        }

        public Criteria andCautionRefundReasonNotLike(String value) {
            addCriterion("caution_refund_reason not like", value, "cautionRefundReason");
            return (Criteria) this;
        }

        public Criteria andCautionRefundReasonIn(List<String> values) {
            addCriterion("caution_refund_reason in", values, "cautionRefundReason");
            return (Criteria) this;
        }

        public Criteria andCautionRefundReasonNotIn(List<String> values) {
            addCriterion("caution_refund_reason not in", values, "cautionRefundReason");
            return (Criteria) this;
        }

        public Criteria andCautionRefundReasonBetween(String value1, String value2) {
            addCriterion("caution_refund_reason between", value1, value2, "cautionRefundReason");
            return (Criteria) this;
        }

        public Criteria andCautionRefundReasonNotBetween(String value1, String value2) {
            addCriterion("caution_refund_reason not between", value1, value2, "cautionRefundReason");
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

        public Criteria andCategorySecondTypeIsNull() {
            addCriterion("category_second_type is null");
            return (Criteria) this;
        }

        public Criteria andCategorySecondTypeIsNotNull() {
            addCriterion("category_second_type is not null");
            return (Criteria) this;
        }

        public Criteria andCategorySecondTypeEqualTo(Integer value) {
            addCriterion("category_second_type =", value, "categorySecondType");
            return (Criteria) this;
        }

        public Criteria andCategorySecondTypeNotEqualTo(Integer value) {
            addCriterion("category_second_type <>", value, "categorySecondType");
            return (Criteria) this;
        }

        public Criteria andCategorySecondTypeGreaterThan(Integer value) {
            addCriterion("category_second_type >", value, "categorySecondType");
            return (Criteria) this;
        }

        public Criteria andCategorySecondTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_second_type >=", value, "categorySecondType");
            return (Criteria) this;
        }

        public Criteria andCategorySecondTypeLessThan(Integer value) {
            addCriterion("category_second_type <", value, "categorySecondType");
            return (Criteria) this;
        }

        public Criteria andCategorySecondTypeLessThanOrEqualTo(Integer value) {
            addCriterion("category_second_type <=", value, "categorySecondType");
            return (Criteria) this;
        }

        public Criteria andCategorySecondTypeIn(List<Integer> values) {
            addCriterion("category_second_type in", values, "categorySecondType");
            return (Criteria) this;
        }

        public Criteria andCategorySecondTypeNotIn(List<Integer> values) {
            addCriterion("category_second_type not in", values, "categorySecondType");
            return (Criteria) this;
        }

        public Criteria andCategorySecondTypeBetween(Integer value1, Integer value2) {
            addCriterion("category_second_type between", value1, value2, "categorySecondType");
            return (Criteria) this;
        }

        public Criteria andCategorySecondTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("category_second_type not between", value1, value2, "categorySecondType");
            return (Criteria) this;
        }

        public Criteria andProtocolUrlIsNull() {
            addCriterion("protocol_url is null");
            return (Criteria) this;
        }

        public Criteria andProtocolUrlIsNotNull() {
            addCriterion("protocol_url is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolUrlEqualTo(String value) {
            addCriterion("protocol_url =", value, "protocolUrl");
            return (Criteria) this;
        }

        public Criteria andProtocolUrlNotEqualTo(String value) {
            addCriterion("protocol_url <>", value, "protocolUrl");
            return (Criteria) this;
        }

        public Criteria andProtocolUrlGreaterThan(String value) {
            addCriterion("protocol_url >", value, "protocolUrl");
            return (Criteria) this;
        }

        public Criteria andProtocolUrlGreaterThanOrEqualTo(String value) {
            addCriterion("protocol_url >=", value, "protocolUrl");
            return (Criteria) this;
        }

        public Criteria andProtocolUrlLessThan(String value) {
            addCriterion("protocol_url <", value, "protocolUrl");
            return (Criteria) this;
        }

        public Criteria andProtocolUrlLessThanOrEqualTo(String value) {
            addCriterion("protocol_url <=", value, "protocolUrl");
            return (Criteria) this;
        }

        public Criteria andProtocolUrlLike(String value) {
            addCriterion("protocol_url like", value, "protocolUrl");
            return (Criteria) this;
        }

        public Criteria andProtocolUrlNotLike(String value) {
            addCriterion("protocol_url not like", value, "protocolUrl");
            return (Criteria) this;
        }

        public Criteria andProtocolUrlIn(List<String> values) {
            addCriterion("protocol_url in", values, "protocolUrl");
            return (Criteria) this;
        }

        public Criteria andProtocolUrlNotIn(List<String> values) {
            addCriterion("protocol_url not in", values, "protocolUrl");
            return (Criteria) this;
        }

        public Criteria andProtocolUrlBetween(String value1, String value2) {
            addCriterion("protocol_url between", value1, value2, "protocolUrl");
            return (Criteria) this;
        }

        public Criteria andProtocolUrlNotBetween(String value1, String value2) {
            addCriterion("protocol_url not between", value1, value2, "protocolUrl");
            return (Criteria) this;
        }

        public Criteria andVerifyRoleIsNull() {
            addCriterion("verify_role is null");
            return (Criteria) this;
        }

        public Criteria andVerifyRoleIsNotNull() {
            addCriterion("verify_role is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyRoleEqualTo(String value) {
            addCriterion("verify_role =", value, "verifyRole");
            return (Criteria) this;
        }

        public Criteria andVerifyRoleNotEqualTo(String value) {
            addCriterion("verify_role <>", value, "verifyRole");
            return (Criteria) this;
        }

        public Criteria andVerifyRoleGreaterThan(String value) {
            addCriterion("verify_role >", value, "verifyRole");
            return (Criteria) this;
        }

        public Criteria andVerifyRoleGreaterThanOrEqualTo(String value) {
            addCriterion("verify_role >=", value, "verifyRole");
            return (Criteria) this;
        }

        public Criteria andVerifyRoleLessThan(String value) {
            addCriterion("verify_role <", value, "verifyRole");
            return (Criteria) this;
        }

        public Criteria andVerifyRoleLessThanOrEqualTo(String value) {
            addCriterion("verify_role <=", value, "verifyRole");
            return (Criteria) this;
        }

        public Criteria andVerifyRoleLike(String value) {
            addCriterion("verify_role like", value, "verifyRole");
            return (Criteria) this;
        }

        public Criteria andVerifyRoleNotLike(String value) {
            addCriterion("verify_role not like", value, "verifyRole");
            return (Criteria) this;
        }

        public Criteria andVerifyRoleIn(List<String> values) {
            addCriterion("verify_role in", values, "verifyRole");
            return (Criteria) this;
        }

        public Criteria andVerifyRoleNotIn(List<String> values) {
            addCriterion("verify_role not in", values, "verifyRole");
            return (Criteria) this;
        }

        public Criteria andVerifyRoleBetween(String value1, String value2) {
            addCriterion("verify_role between", value1, value2, "verifyRole");
            return (Criteria) this;
        }

        public Criteria andVerifyRoleNotBetween(String value1, String value2) {
            addCriterion("verify_role not between", value1, value2, "verifyRole");
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