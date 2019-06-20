package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QrcodeBuildLogSyncExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QrcodeBuildLogSyncExample() {
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

        public Criteria andMyIdIsNull() {
            addCriterion("my_id is null");
            return (Criteria) this;
        }

        public Criteria andMyIdIsNotNull() {
            addCriterion("my_id is not null");
            return (Criteria) this;
        }

        public Criteria andMyIdEqualTo(Long value) {
            addCriterion("my_id =", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdNotEqualTo(Long value) {
            addCriterion("my_id <>", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdGreaterThan(Long value) {
            addCriterion("my_id >", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("my_id >=", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdLessThan(Long value) {
            addCriterion("my_id <", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdLessThanOrEqualTo(Long value) {
            addCriterion("my_id <=", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdIn(List<Long> values) {
            addCriterion("my_id in", values, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdNotIn(List<Long> values) {
            addCriterion("my_id not in", values, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdBetween(Long value1, Long value2) {
            addCriterion("my_id between", value1, value2, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdNotBetween(Long value1, Long value2) {
            addCriterion("my_id not between", value1, value2, "myId");
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

        public Criteria andMyCommunityIdIsNull() {
            addCriterion("my_community_id is null");
            return (Criteria) this;
        }

        public Criteria andMyCommunityIdIsNotNull() {
            addCriterion("my_community_id is not null");
            return (Criteria) this;
        }

        public Criteria andMyCommunityIdEqualTo(Integer value) {
            addCriterion("my_community_id =", value, "myCommunityId");
            return (Criteria) this;
        }

        public Criteria andMyCommunityIdNotEqualTo(Integer value) {
            addCriterion("my_community_id <>", value, "myCommunityId");
            return (Criteria) this;
        }

        public Criteria andMyCommunityIdGreaterThan(Integer value) {
            addCriterion("my_community_id >", value, "myCommunityId");
            return (Criteria) this;
        }

        public Criteria andMyCommunityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("my_community_id >=", value, "myCommunityId");
            return (Criteria) this;
        }

        public Criteria andMyCommunityIdLessThan(Integer value) {
            addCriterion("my_community_id <", value, "myCommunityId");
            return (Criteria) this;
        }

        public Criteria andMyCommunityIdLessThanOrEqualTo(Integer value) {
            addCriterion("my_community_id <=", value, "myCommunityId");
            return (Criteria) this;
        }

        public Criteria andMyCommunityIdIn(List<Integer> values) {
            addCriterion("my_community_id in", values, "myCommunityId");
            return (Criteria) this;
        }

        public Criteria andMyCommunityIdNotIn(List<Integer> values) {
            addCriterion("my_community_id not in", values, "myCommunityId");
            return (Criteria) this;
        }

        public Criteria andMyCommunityIdBetween(Integer value1, Integer value2) {
            addCriterion("my_community_id between", value1, value2, "myCommunityId");
            return (Criteria) this;
        }

        public Criteria andMyCommunityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("my_community_id not between", value1, value2, "myCommunityId");
            return (Criteria) this;
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

        public Criteria andQrcodeDecodingIsNull() {
            addCriterion("qrcode_decoding is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeDecodingIsNotNull() {
            addCriterion("qrcode_decoding is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeDecodingEqualTo(String value) {
            addCriterion("qrcode_decoding =", value, "qrcodeDecoding");
            return (Criteria) this;
        }

        public Criteria andQrcodeDecodingNotEqualTo(String value) {
            addCriterion("qrcode_decoding <>", value, "qrcodeDecoding");
            return (Criteria) this;
        }

        public Criteria andQrcodeDecodingGreaterThan(String value) {
            addCriterion("qrcode_decoding >", value, "qrcodeDecoding");
            return (Criteria) this;
        }

        public Criteria andQrcodeDecodingGreaterThanOrEqualTo(String value) {
            addCriterion("qrcode_decoding >=", value, "qrcodeDecoding");
            return (Criteria) this;
        }

        public Criteria andQrcodeDecodingLessThan(String value) {
            addCriterion("qrcode_decoding <", value, "qrcodeDecoding");
            return (Criteria) this;
        }

        public Criteria andQrcodeDecodingLessThanOrEqualTo(String value) {
            addCriterion("qrcode_decoding <=", value, "qrcodeDecoding");
            return (Criteria) this;
        }

        public Criteria andQrcodeDecodingLike(String value) {
            addCriterion("qrcode_decoding like", value, "qrcodeDecoding");
            return (Criteria) this;
        }

        public Criteria andQrcodeDecodingNotLike(String value) {
            addCriterion("qrcode_decoding not like", value, "qrcodeDecoding");
            return (Criteria) this;
        }

        public Criteria andQrcodeDecodingIn(List<String> values) {
            addCriterion("qrcode_decoding in", values, "qrcodeDecoding");
            return (Criteria) this;
        }

        public Criteria andQrcodeDecodingNotIn(List<String> values) {
            addCriterion("qrcode_decoding not in", values, "qrcodeDecoding");
            return (Criteria) this;
        }

        public Criteria andQrcodeDecodingBetween(String value1, String value2) {
            addCriterion("qrcode_decoding between", value1, value2, "qrcodeDecoding");
            return (Criteria) this;
        }

        public Criteria andQrcodeDecodingNotBetween(String value1, String value2) {
            addCriterion("qrcode_decoding not between", value1, value2, "qrcodeDecoding");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIsNull() {
            addCriterion("community_id is null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIsNotNull() {
            addCriterion("community_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdEqualTo(Integer value) {
            addCriterion("community_id =", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotEqualTo(Integer value) {
            addCriterion("community_id <>", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThan(Integer value) {
            addCriterion("community_id >", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("community_id >=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThan(Integer value) {
            addCriterion("community_id <", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThanOrEqualTo(Integer value) {
            addCriterion("community_id <=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIn(List<Integer> values) {
            addCriterion("community_id in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotIn(List<Integer> values) {
            addCriterion("community_id not in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdBetween(Integer value1, Integer value2) {
            addCriterion("community_id between", value1, value2, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("community_id not between", value1, value2, "communityId");
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

        public Criteria andCanPassCountIsNull() {
            addCriterion("can_pass_count is null");
            return (Criteria) this;
        }

        public Criteria andCanPassCountIsNotNull() {
            addCriterion("can_pass_count is not null");
            return (Criteria) this;
        }

        public Criteria andCanPassCountEqualTo(Integer value) {
            addCriterion("can_pass_count =", value, "canPassCount");
            return (Criteria) this;
        }

        public Criteria andCanPassCountNotEqualTo(Integer value) {
            addCriterion("can_pass_count <>", value, "canPassCount");
            return (Criteria) this;
        }

        public Criteria andCanPassCountGreaterThan(Integer value) {
            addCriterion("can_pass_count >", value, "canPassCount");
            return (Criteria) this;
        }

        public Criteria andCanPassCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("can_pass_count >=", value, "canPassCount");
            return (Criteria) this;
        }

        public Criteria andCanPassCountLessThan(Integer value) {
            addCriterion("can_pass_count <", value, "canPassCount");
            return (Criteria) this;
        }

        public Criteria andCanPassCountLessThanOrEqualTo(Integer value) {
            addCriterion("can_pass_count <=", value, "canPassCount");
            return (Criteria) this;
        }

        public Criteria andCanPassCountIn(List<Integer> values) {
            addCriterion("can_pass_count in", values, "canPassCount");
            return (Criteria) this;
        }

        public Criteria andCanPassCountNotIn(List<Integer> values) {
            addCriterion("can_pass_count not in", values, "canPassCount");
            return (Criteria) this;
        }

        public Criteria andCanPassCountBetween(Integer value1, Integer value2) {
            addCriterion("can_pass_count between", value1, value2, "canPassCount");
            return (Criteria) this;
        }

        public Criteria andCanPassCountNotBetween(Integer value1, Integer value2) {
            addCriterion("can_pass_count not between", value1, value2, "canPassCount");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
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

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeIdIsNull() {
            addCriterion("qrcode_id is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeIdIsNotNull() {
            addCriterion("qrcode_id is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeIdEqualTo(Long value) {
            addCriterion("qrcode_id =", value, "qrcodeId");
            return (Criteria) this;
        }

        public Criteria andQrcodeIdNotEqualTo(Long value) {
            addCriterion("qrcode_id <>", value, "qrcodeId");
            return (Criteria) this;
        }

        public Criteria andQrcodeIdGreaterThan(Long value) {
            addCriterion("qrcode_id >", value, "qrcodeId");
            return (Criteria) this;
        }

        public Criteria andQrcodeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("qrcode_id >=", value, "qrcodeId");
            return (Criteria) this;
        }

        public Criteria andQrcodeIdLessThan(Long value) {
            addCriterion("qrcode_id <", value, "qrcodeId");
            return (Criteria) this;
        }

        public Criteria andQrcodeIdLessThanOrEqualTo(Long value) {
            addCriterion("qrcode_id <=", value, "qrcodeId");
            return (Criteria) this;
        }

        public Criteria andQrcodeIdIn(List<Long> values) {
            addCriterion("qrcode_id in", values, "qrcodeId");
            return (Criteria) this;
        }

        public Criteria andQrcodeIdNotIn(List<Long> values) {
            addCriterion("qrcode_id not in", values, "qrcodeId");
            return (Criteria) this;
        }

        public Criteria andQrcodeIdBetween(Long value1, Long value2) {
            addCriterion("qrcode_id between", value1, value2, "qrcodeId");
            return (Criteria) this;
        }

        public Criteria andQrcodeIdNotBetween(Long value1, Long value2) {
            addCriterion("qrcode_id not between", value1, value2, "qrcodeId");
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

        public Criteria andSysGroupIsNull() {
            addCriterion("sys_group is null");
            return (Criteria) this;
        }

        public Criteria andSysGroupIsNotNull() {
            addCriterion("sys_group is not null");
            return (Criteria) this;
        }

        public Criteria andSysGroupEqualTo(Integer value) {
            addCriterion("sys_group =", value, "sysGroup");
            return (Criteria) this;
        }

        public Criteria andSysGroupNotEqualTo(Integer value) {
            addCriterion("sys_group <>", value, "sysGroup");
            return (Criteria) this;
        }

        public Criteria andSysGroupGreaterThan(Integer value) {
            addCriterion("sys_group >", value, "sysGroup");
            return (Criteria) this;
        }

        public Criteria andSysGroupGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_group >=", value, "sysGroup");
            return (Criteria) this;
        }

        public Criteria andSysGroupLessThan(Integer value) {
            addCriterion("sys_group <", value, "sysGroup");
            return (Criteria) this;
        }

        public Criteria andSysGroupLessThanOrEqualTo(Integer value) {
            addCriterion("sys_group <=", value, "sysGroup");
            return (Criteria) this;
        }

        public Criteria andSysGroupIn(List<Integer> values) {
            addCriterion("sys_group in", values, "sysGroup");
            return (Criteria) this;
        }

        public Criteria andSysGroupNotIn(List<Integer> values) {
            addCriterion("sys_group not in", values, "sysGroup");
            return (Criteria) this;
        }

        public Criteria andSysGroupBetween(Integer value1, Integer value2) {
            addCriterion("sys_group between", value1, value2, "sysGroup");
            return (Criteria) this;
        }

        public Criteria andSysGroupNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_group not between", value1, value2, "sysGroup");
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