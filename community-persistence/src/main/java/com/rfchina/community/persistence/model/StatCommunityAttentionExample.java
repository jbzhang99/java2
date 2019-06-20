package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatCommunityAttentionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatCommunityAttentionExample() {
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

        public Criteria andCommunityTypeIsNull() {
            addCriterion("community_type is null");
            return (Criteria) this;
        }

        public Criteria andCommunityTypeIsNotNull() {
            addCriterion("community_type is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityTypeEqualTo(Integer value) {
            addCriterion("community_type =", value, "communityType");
            return (Criteria) this;
        }

        public Criteria andCommunityTypeNotEqualTo(Integer value) {
            addCriterion("community_type <>", value, "communityType");
            return (Criteria) this;
        }

        public Criteria andCommunityTypeGreaterThan(Integer value) {
            addCriterion("community_type >", value, "communityType");
            return (Criteria) this;
        }

        public Criteria andCommunityTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("community_type >=", value, "communityType");
            return (Criteria) this;
        }

        public Criteria andCommunityTypeLessThan(Integer value) {
            addCriterion("community_type <", value, "communityType");
            return (Criteria) this;
        }

        public Criteria andCommunityTypeLessThanOrEqualTo(Integer value) {
            addCriterion("community_type <=", value, "communityType");
            return (Criteria) this;
        }

        public Criteria andCommunityTypeIn(List<Integer> values) {
            addCriterion("community_type in", values, "communityType");
            return (Criteria) this;
        }

        public Criteria andCommunityTypeNotIn(List<Integer> values) {
            addCriterion("community_type not in", values, "communityType");
            return (Criteria) this;
        }

        public Criteria andCommunityTypeBetween(Integer value1, Integer value2) {
            addCriterion("community_type between", value1, value2, "communityType");
            return (Criteria) this;
        }

        public Criteria andCommunityTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("community_type not between", value1, value2, "communityType");
            return (Criteria) this;
        }

        public Criteria andCurrentAppUserCountIsNull() {
            addCriterion("current_app_user_count is null");
            return (Criteria) this;
        }

        public Criteria andCurrentAppUserCountIsNotNull() {
            addCriterion("current_app_user_count is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentAppUserCountEqualTo(Long value) {
            addCriterion("current_app_user_count =", value, "currentAppUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentAppUserCountNotEqualTo(Long value) {
            addCriterion("current_app_user_count <>", value, "currentAppUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentAppUserCountGreaterThan(Long value) {
            addCriterion("current_app_user_count >", value, "currentAppUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentAppUserCountGreaterThanOrEqualTo(Long value) {
            addCriterion("current_app_user_count >=", value, "currentAppUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentAppUserCountLessThan(Long value) {
            addCriterion("current_app_user_count <", value, "currentAppUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentAppUserCountLessThanOrEqualTo(Long value) {
            addCriterion("current_app_user_count <=", value, "currentAppUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentAppUserCountIn(List<Long> values) {
            addCriterion("current_app_user_count in", values, "currentAppUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentAppUserCountNotIn(List<Long> values) {
            addCriterion("current_app_user_count not in", values, "currentAppUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentAppUserCountBetween(Long value1, Long value2) {
            addCriterion("current_app_user_count between", value1, value2, "currentAppUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentAppUserCountNotBetween(Long value1, Long value2) {
            addCriterion("current_app_user_count not between", value1, value2, "currentAppUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentServerUserCountIsNull() {
            addCriterion("current_server_user_count is null");
            return (Criteria) this;
        }

        public Criteria andCurrentServerUserCountIsNotNull() {
            addCriterion("current_server_user_count is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentServerUserCountEqualTo(Long value) {
            addCriterion("current_server_user_count =", value, "currentServerUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentServerUserCountNotEqualTo(Long value) {
            addCriterion("current_server_user_count <>", value, "currentServerUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentServerUserCountGreaterThan(Long value) {
            addCriterion("current_server_user_count >", value, "currentServerUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentServerUserCountGreaterThanOrEqualTo(Long value) {
            addCriterion("current_server_user_count >=", value, "currentServerUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentServerUserCountLessThan(Long value) {
            addCriterion("current_server_user_count <", value, "currentServerUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentServerUserCountLessThanOrEqualTo(Long value) {
            addCriterion("current_server_user_count <=", value, "currentServerUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentServerUserCountIn(List<Long> values) {
            addCriterion("current_server_user_count in", values, "currentServerUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentServerUserCountNotIn(List<Long> values) {
            addCriterion("current_server_user_count not in", values, "currentServerUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentServerUserCountBetween(Long value1, Long value2) {
            addCriterion("current_server_user_count between", value1, value2, "currentServerUserCount");
            return (Criteria) this;
        }

        public Criteria andCurrentServerUserCountNotBetween(Long value1, Long value2) {
            addCriterion("current_server_user_count not between", value1, value2, "currentServerUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrAppUserCountIsNull() {
            addCriterion("incr_app_user_count is null");
            return (Criteria) this;
        }

        public Criteria andIncrAppUserCountIsNotNull() {
            addCriterion("incr_app_user_count is not null");
            return (Criteria) this;
        }

        public Criteria andIncrAppUserCountEqualTo(Long value) {
            addCriterion("incr_app_user_count =", value, "incrAppUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrAppUserCountNotEqualTo(Long value) {
            addCriterion("incr_app_user_count <>", value, "incrAppUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrAppUserCountGreaterThan(Long value) {
            addCriterion("incr_app_user_count >", value, "incrAppUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrAppUserCountGreaterThanOrEqualTo(Long value) {
            addCriterion("incr_app_user_count >=", value, "incrAppUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrAppUserCountLessThan(Long value) {
            addCriterion("incr_app_user_count <", value, "incrAppUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrAppUserCountLessThanOrEqualTo(Long value) {
            addCriterion("incr_app_user_count <=", value, "incrAppUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrAppUserCountIn(List<Long> values) {
            addCriterion("incr_app_user_count in", values, "incrAppUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrAppUserCountNotIn(List<Long> values) {
            addCriterion("incr_app_user_count not in", values, "incrAppUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrAppUserCountBetween(Long value1, Long value2) {
            addCriterion("incr_app_user_count between", value1, value2, "incrAppUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrAppUserCountNotBetween(Long value1, Long value2) {
            addCriterion("incr_app_user_count not between", value1, value2, "incrAppUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrServerUserCountIsNull() {
            addCriterion("incr_server_user_count is null");
            return (Criteria) this;
        }

        public Criteria andIncrServerUserCountIsNotNull() {
            addCriterion("incr_server_user_count is not null");
            return (Criteria) this;
        }

        public Criteria andIncrServerUserCountEqualTo(Long value) {
            addCriterion("incr_server_user_count =", value, "incrServerUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrServerUserCountNotEqualTo(Long value) {
            addCriterion("incr_server_user_count <>", value, "incrServerUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrServerUserCountGreaterThan(Long value) {
            addCriterion("incr_server_user_count >", value, "incrServerUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrServerUserCountGreaterThanOrEqualTo(Long value) {
            addCriterion("incr_server_user_count >=", value, "incrServerUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrServerUserCountLessThan(Long value) {
            addCriterion("incr_server_user_count <", value, "incrServerUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrServerUserCountLessThanOrEqualTo(Long value) {
            addCriterion("incr_server_user_count <=", value, "incrServerUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrServerUserCountIn(List<Long> values) {
            addCriterion("incr_server_user_count in", values, "incrServerUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrServerUserCountNotIn(List<Long> values) {
            addCriterion("incr_server_user_count not in", values, "incrServerUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrServerUserCountBetween(Long value1, Long value2) {
            addCriterion("incr_server_user_count between", value1, value2, "incrServerUserCount");
            return (Criteria) this;
        }

        public Criteria andIncrServerUserCountNotBetween(Long value1, Long value2) {
            addCriterion("incr_server_user_count not between", value1, value2, "incrServerUserCount");
            return (Criteria) this;
        }

        public Criteria andDelAppUserCountIsNull() {
            addCriterion("del_app_user_count is null");
            return (Criteria) this;
        }

        public Criteria andDelAppUserCountIsNotNull() {
            addCriterion("del_app_user_count is not null");
            return (Criteria) this;
        }

        public Criteria andDelAppUserCountEqualTo(Long value) {
            addCriterion("del_app_user_count =", value, "delAppUserCount");
            return (Criteria) this;
        }

        public Criteria andDelAppUserCountNotEqualTo(Long value) {
            addCriterion("del_app_user_count <>", value, "delAppUserCount");
            return (Criteria) this;
        }

        public Criteria andDelAppUserCountGreaterThan(Long value) {
            addCriterion("del_app_user_count >", value, "delAppUserCount");
            return (Criteria) this;
        }

        public Criteria andDelAppUserCountGreaterThanOrEqualTo(Long value) {
            addCriterion("del_app_user_count >=", value, "delAppUserCount");
            return (Criteria) this;
        }

        public Criteria andDelAppUserCountLessThan(Long value) {
            addCriterion("del_app_user_count <", value, "delAppUserCount");
            return (Criteria) this;
        }

        public Criteria andDelAppUserCountLessThanOrEqualTo(Long value) {
            addCriterion("del_app_user_count <=", value, "delAppUserCount");
            return (Criteria) this;
        }

        public Criteria andDelAppUserCountIn(List<Long> values) {
            addCriterion("del_app_user_count in", values, "delAppUserCount");
            return (Criteria) this;
        }

        public Criteria andDelAppUserCountNotIn(List<Long> values) {
            addCriterion("del_app_user_count not in", values, "delAppUserCount");
            return (Criteria) this;
        }

        public Criteria andDelAppUserCountBetween(Long value1, Long value2) {
            addCriterion("del_app_user_count between", value1, value2, "delAppUserCount");
            return (Criteria) this;
        }

        public Criteria andDelAppUserCountNotBetween(Long value1, Long value2) {
            addCriterion("del_app_user_count not between", value1, value2, "delAppUserCount");
            return (Criteria) this;
        }

        public Criteria andDelServerUserCountIsNull() {
            addCriterion("del_server_user_count is null");
            return (Criteria) this;
        }

        public Criteria andDelServerUserCountIsNotNull() {
            addCriterion("del_server_user_count is not null");
            return (Criteria) this;
        }

        public Criteria andDelServerUserCountEqualTo(Long value) {
            addCriterion("del_server_user_count =", value, "delServerUserCount");
            return (Criteria) this;
        }

        public Criteria andDelServerUserCountNotEqualTo(Long value) {
            addCriterion("del_server_user_count <>", value, "delServerUserCount");
            return (Criteria) this;
        }

        public Criteria andDelServerUserCountGreaterThan(Long value) {
            addCriterion("del_server_user_count >", value, "delServerUserCount");
            return (Criteria) this;
        }

        public Criteria andDelServerUserCountGreaterThanOrEqualTo(Long value) {
            addCriterion("del_server_user_count >=", value, "delServerUserCount");
            return (Criteria) this;
        }

        public Criteria andDelServerUserCountLessThan(Long value) {
            addCriterion("del_server_user_count <", value, "delServerUserCount");
            return (Criteria) this;
        }

        public Criteria andDelServerUserCountLessThanOrEqualTo(Long value) {
            addCriterion("del_server_user_count <=", value, "delServerUserCount");
            return (Criteria) this;
        }

        public Criteria andDelServerUserCountIn(List<Long> values) {
            addCriterion("del_server_user_count in", values, "delServerUserCount");
            return (Criteria) this;
        }

        public Criteria andDelServerUserCountNotIn(List<Long> values) {
            addCriterion("del_server_user_count not in", values, "delServerUserCount");
            return (Criteria) this;
        }

        public Criteria andDelServerUserCountBetween(Long value1, Long value2) {
            addCriterion("del_server_user_count between", value1, value2, "delServerUserCount");
            return (Criteria) this;
        }

        public Criteria andDelServerUserCountNotBetween(Long value1, Long value2) {
            addCriterion("del_server_user_count not between", value1, value2, "delServerUserCount");
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

        public Criteria andStatTimeIsNull() {
            addCriterion("stat_time is null");
            return (Criteria) this;
        }

        public Criteria andStatTimeIsNotNull() {
            addCriterion("stat_time is not null");
            return (Criteria) this;
        }

        public Criteria andStatTimeEqualTo(Date value) {
            addCriterion("stat_time =", value, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeNotEqualTo(Date value) {
            addCriterion("stat_time <>", value, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeGreaterThan(Date value) {
            addCriterion("stat_time >", value, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stat_time >=", value, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeLessThan(Date value) {
            addCriterion("stat_time <", value, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeLessThanOrEqualTo(Date value) {
            addCriterion("stat_time <=", value, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeIn(List<Date> values) {
            addCriterion("stat_time in", values, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeNotIn(List<Date> values) {
            addCriterion("stat_time not in", values, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeBetween(Date value1, Date value2) {
            addCriterion("stat_time between", value1, value2, "statTime");
            return (Criteria) this;
        }

        public Criteria andStatTimeNotBetween(Date value1, Date value2) {
            addCriterion("stat_time not between", value1, value2, "statTime");
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