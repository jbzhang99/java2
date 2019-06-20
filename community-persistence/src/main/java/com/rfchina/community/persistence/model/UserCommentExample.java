package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserCommentExample() {
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

        public Criteria andCommentTargetTypeIsNull() {
            addCriterion("comment_target_type is null");
            return (Criteria) this;
        }

        public Criteria andCommentTargetTypeIsNotNull() {
            addCriterion("comment_target_type is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTargetTypeEqualTo(String value) {
            addCriterion("comment_target_type =", value, "commentTargetType");
            return (Criteria) this;
        }

        public Criteria andCommentTargetTypeNotEqualTo(String value) {
            addCriterion("comment_target_type <>", value, "commentTargetType");
            return (Criteria) this;
        }

        public Criteria andCommentTargetTypeGreaterThan(String value) {
            addCriterion("comment_target_type >", value, "commentTargetType");
            return (Criteria) this;
        }

        public Criteria andCommentTargetTypeGreaterThanOrEqualTo(String value) {
            addCriterion("comment_target_type >=", value, "commentTargetType");
            return (Criteria) this;
        }

        public Criteria andCommentTargetTypeLessThan(String value) {
            addCriterion("comment_target_type <", value, "commentTargetType");
            return (Criteria) this;
        }

        public Criteria andCommentTargetTypeLessThanOrEqualTo(String value) {
            addCriterion("comment_target_type <=", value, "commentTargetType");
            return (Criteria) this;
        }

        public Criteria andCommentTargetTypeLike(String value) {
            addCriterion("comment_target_type like", value, "commentTargetType");
            return (Criteria) this;
        }

        public Criteria andCommentTargetTypeNotLike(String value) {
            addCriterion("comment_target_type not like", value, "commentTargetType");
            return (Criteria) this;
        }

        public Criteria andCommentTargetTypeIn(List<String> values) {
            addCriterion("comment_target_type in", values, "commentTargetType");
            return (Criteria) this;
        }

        public Criteria andCommentTargetTypeNotIn(List<String> values) {
            addCriterion("comment_target_type not in", values, "commentTargetType");
            return (Criteria) this;
        }

        public Criteria andCommentTargetTypeBetween(String value1, String value2) {
            addCriterion("comment_target_type between", value1, value2, "commentTargetType");
            return (Criteria) this;
        }

        public Criteria andCommentTargetTypeNotBetween(String value1, String value2) {
            addCriterion("comment_target_type not between", value1, value2, "commentTargetType");
            return (Criteria) this;
        }

        public Criteria andCommentTargetIsNull() {
            addCriterion("comment_target is null");
            return (Criteria) this;
        }

        public Criteria andCommentTargetIsNotNull() {
            addCriterion("comment_target is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTargetEqualTo(Long value) {
            addCriterion("comment_target =", value, "commentTarget");
            return (Criteria) this;
        }

        public Criteria andCommentTargetNotEqualTo(Long value) {
            addCriterion("comment_target <>", value, "commentTarget");
            return (Criteria) this;
        }

        public Criteria andCommentTargetGreaterThan(Long value) {
            addCriterion("comment_target >", value, "commentTarget");
            return (Criteria) this;
        }

        public Criteria andCommentTargetGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_target >=", value, "commentTarget");
            return (Criteria) this;
        }

        public Criteria andCommentTargetLessThan(Long value) {
            addCriterion("comment_target <", value, "commentTarget");
            return (Criteria) this;
        }

        public Criteria andCommentTargetLessThanOrEqualTo(Long value) {
            addCriterion("comment_target <=", value, "commentTarget");
            return (Criteria) this;
        }

        public Criteria andCommentTargetIn(List<Long> values) {
            addCriterion("comment_target in", values, "commentTarget");
            return (Criteria) this;
        }

        public Criteria andCommentTargetNotIn(List<Long> values) {
            addCriterion("comment_target not in", values, "commentTarget");
            return (Criteria) this;
        }

        public Criteria andCommentTargetBetween(Long value1, Long value2) {
            addCriterion("comment_target between", value1, value2, "commentTarget");
            return (Criteria) this;
        }

        public Criteria andCommentTargetNotBetween(Long value1, Long value2) {
            addCriterion("comment_target not between", value1, value2, "commentTarget");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNull() {
            addCriterion("out_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNotNull() {
            addCriterion("out_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoEqualTo(String value) {
            addCriterion("out_trade_no =", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotEqualTo(String value) {
            addCriterion("out_trade_no <>", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThan(String value) {
            addCriterion("out_trade_no >", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_trade_no >=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThan(String value) {
            addCriterion("out_trade_no <", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThanOrEqualTo(String value) {
            addCriterion("out_trade_no <=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLike(String value) {
            addCriterion("out_trade_no like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotLike(String value) {
            addCriterion("out_trade_no not like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIn(List<String> values) {
            addCriterion("out_trade_no in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotIn(List<String> values) {
            addCriterion("out_trade_no not in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoBetween(String value1, String value2) {
            addCriterion("out_trade_no between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotBetween(String value1, String value2) {
            addCriterion("out_trade_no not between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNull() {
            addCriterion("pic_url is null");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNotNull() {
            addCriterion("pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andPicUrlEqualTo(String value) {
            addCriterion("pic_url =", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotEqualTo(String value) {
            addCriterion("pic_url <>", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThan(String value) {
            addCriterion("pic_url >", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pic_url >=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThan(String value) {
            addCriterion("pic_url <", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThanOrEqualTo(String value) {
            addCriterion("pic_url <=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLike(String value) {
            addCriterion("pic_url like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotLike(String value) {
            addCriterion("pic_url not like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlIn(List<String> values) {
            addCriterion("pic_url in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotIn(List<String> values) {
            addCriterion("pic_url not in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlBetween(String value1, String value2) {
            addCriterion("pic_url between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotBetween(String value1, String value2) {
            addCriterion("pic_url not between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andLogisticsGradeIsNull() {
            addCriterion("logistics_grade is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsGradeIsNotNull() {
            addCriterion("logistics_grade is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsGradeEqualTo(Integer value) {
            addCriterion("logistics_grade =", value, "logisticsGrade");
            return (Criteria) this;
        }

        public Criteria andLogisticsGradeNotEqualTo(Integer value) {
            addCriterion("logistics_grade <>", value, "logisticsGrade");
            return (Criteria) this;
        }

        public Criteria andLogisticsGradeGreaterThan(Integer value) {
            addCriterion("logistics_grade >", value, "logisticsGrade");
            return (Criteria) this;
        }

        public Criteria andLogisticsGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("logistics_grade >=", value, "logisticsGrade");
            return (Criteria) this;
        }

        public Criteria andLogisticsGradeLessThan(Integer value) {
            addCriterion("logistics_grade <", value, "logisticsGrade");
            return (Criteria) this;
        }

        public Criteria andLogisticsGradeLessThanOrEqualTo(Integer value) {
            addCriterion("logistics_grade <=", value, "logisticsGrade");
            return (Criteria) this;
        }

        public Criteria andLogisticsGradeIn(List<Integer> values) {
            addCriterion("logistics_grade in", values, "logisticsGrade");
            return (Criteria) this;
        }

        public Criteria andLogisticsGradeNotIn(List<Integer> values) {
            addCriterion("logistics_grade not in", values, "logisticsGrade");
            return (Criteria) this;
        }

        public Criteria andLogisticsGradeBetween(Integer value1, Integer value2) {
            addCriterion("logistics_grade between", value1, value2, "logisticsGrade");
            return (Criteria) this;
        }

        public Criteria andLogisticsGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("logistics_grade not between", value1, value2, "logisticsGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeIsNull() {
            addCriterion("service_grade is null");
            return (Criteria) this;
        }

        public Criteria andServiceGradeIsNotNull() {
            addCriterion("service_grade is not null");
            return (Criteria) this;
        }

        public Criteria andServiceGradeEqualTo(Integer value) {
            addCriterion("service_grade =", value, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNotEqualTo(Integer value) {
            addCriterion("service_grade <>", value, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeGreaterThan(Integer value) {
            addCriterion("service_grade >", value, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_grade >=", value, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeLessThan(Integer value) {
            addCriterion("service_grade <", value, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeLessThanOrEqualTo(Integer value) {
            addCriterion("service_grade <=", value, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeIn(List<Integer> values) {
            addCriterion("service_grade in", values, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNotIn(List<Integer> values) {
            addCriterion("service_grade not in", values, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeBetween(Integer value1, Integer value2) {
            addCriterion("service_grade between", value1, value2, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("service_grade not between", value1, value2, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeIsNull() {
            addCriterion("goods_grade is null");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeIsNotNull() {
            addCriterion("goods_grade is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeEqualTo(Integer value) {
            addCriterion("goods_grade =", value, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeNotEqualTo(Integer value) {
            addCriterion("goods_grade <>", value, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeGreaterThan(Integer value) {
            addCriterion("goods_grade >", value, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_grade >=", value, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeLessThan(Integer value) {
            addCriterion("goods_grade <", value, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeLessThanOrEqualTo(Integer value) {
            addCriterion("goods_grade <=", value, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeIn(List<Integer> values) {
            addCriterion("goods_grade in", values, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeNotIn(List<Integer> values) {
            addCriterion("goods_grade not in", values, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeBetween(Integer value1, Integer value2) {
            addCriterion("goods_grade between", value1, value2, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andGoodsGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_grade not between", value1, value2, "goodsGrade");
            return (Criteria) this;
        }

        public Criteria andCommentatorIsNull() {
            addCriterion("commentator is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorIsNotNull() {
            addCriterion("commentator is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorEqualTo(Long value) {
            addCriterion("commentator =", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorNotEqualTo(Long value) {
            addCriterion("commentator <>", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorGreaterThan(Long value) {
            addCriterion("commentator >", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorGreaterThanOrEqualTo(Long value) {
            addCriterion("commentator >=", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorLessThan(Long value) {
            addCriterion("commentator <", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorLessThanOrEqualTo(Long value) {
            addCriterion("commentator <=", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorIn(List<Long> values) {
            addCriterion("commentator in", values, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorNotIn(List<Long> values) {
            addCriterion("commentator not in", values, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorBetween(Long value1, Long value2) {
            addCriterion("commentator between", value1, value2, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorNotBetween(Long value1, Long value2) {
            addCriterion("commentator not between", value1, value2, "commentator");
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

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andReplyStatusIsNull() {
            addCriterion("reply_status is null");
            return (Criteria) this;
        }

        public Criteria andReplyStatusIsNotNull() {
            addCriterion("reply_status is not null");
            return (Criteria) this;
        }

        public Criteria andReplyStatusEqualTo(String value) {
            addCriterion("reply_status =", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotEqualTo(String value) {
            addCriterion("reply_status <>", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusGreaterThan(String value) {
            addCriterion("reply_status >", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("reply_status >=", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusLessThan(String value) {
            addCriterion("reply_status <", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusLessThanOrEqualTo(String value) {
            addCriterion("reply_status <=", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusLike(String value) {
            addCriterion("reply_status like", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotLike(String value) {
            addCriterion("reply_status not like", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusIn(List<String> values) {
            addCriterion("reply_status in", values, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotIn(List<String> values) {
            addCriterion("reply_status not in", values, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusBetween(String value1, String value2) {
            addCriterion("reply_status between", value1, value2, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotBetween(String value1, String value2) {
            addCriterion("reply_status not between", value1, value2, "replyStatus");
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