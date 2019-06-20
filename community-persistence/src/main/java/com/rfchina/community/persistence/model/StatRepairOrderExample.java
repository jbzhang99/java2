package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatRepairOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatRepairOrderExample() {
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

        public Criteria andRepairUserCountIsNull() {
            addCriterion("repair_user_count is null");
            return (Criteria) this;
        }

        public Criteria andRepairUserCountIsNotNull() {
            addCriterion("repair_user_count is not null");
            return (Criteria) this;
        }

        public Criteria andRepairUserCountEqualTo(Integer value) {
            addCriterion("repair_user_count =", value, "repairUserCount");
            return (Criteria) this;
        }

        public Criteria andRepairUserCountNotEqualTo(Integer value) {
            addCriterion("repair_user_count <>", value, "repairUserCount");
            return (Criteria) this;
        }

        public Criteria andRepairUserCountGreaterThan(Integer value) {
            addCriterion("repair_user_count >", value, "repairUserCount");
            return (Criteria) this;
        }

        public Criteria andRepairUserCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("repair_user_count >=", value, "repairUserCount");
            return (Criteria) this;
        }

        public Criteria andRepairUserCountLessThan(Integer value) {
            addCriterion("repair_user_count <", value, "repairUserCount");
            return (Criteria) this;
        }

        public Criteria andRepairUserCountLessThanOrEqualTo(Integer value) {
            addCriterion("repair_user_count <=", value, "repairUserCount");
            return (Criteria) this;
        }

        public Criteria andRepairUserCountIn(List<Integer> values) {
            addCriterion("repair_user_count in", values, "repairUserCount");
            return (Criteria) this;
        }

        public Criteria andRepairUserCountNotIn(List<Integer> values) {
            addCriterion("repair_user_count not in", values, "repairUserCount");
            return (Criteria) this;
        }

        public Criteria andRepairUserCountBetween(Integer value1, Integer value2) {
            addCriterion("repair_user_count between", value1, value2, "repairUserCount");
            return (Criteria) this;
        }

        public Criteria andRepairUserCountNotBetween(Integer value1, Integer value2) {
            addCriterion("repair_user_count not between", value1, value2, "repairUserCount");
            return (Criteria) this;
        }

        public Criteria andRepairRoomCountIsNull() {
            addCriterion("repair_room_count is null");
            return (Criteria) this;
        }

        public Criteria andRepairRoomCountIsNotNull() {
            addCriterion("repair_room_count is not null");
            return (Criteria) this;
        }

        public Criteria andRepairRoomCountEqualTo(Integer value) {
            addCriterion("repair_room_count =", value, "repairRoomCount");
            return (Criteria) this;
        }

        public Criteria andRepairRoomCountNotEqualTo(Integer value) {
            addCriterion("repair_room_count <>", value, "repairRoomCount");
            return (Criteria) this;
        }

        public Criteria andRepairRoomCountGreaterThan(Integer value) {
            addCriterion("repair_room_count >", value, "repairRoomCount");
            return (Criteria) this;
        }

        public Criteria andRepairRoomCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("repair_room_count >=", value, "repairRoomCount");
            return (Criteria) this;
        }

        public Criteria andRepairRoomCountLessThan(Integer value) {
            addCriterion("repair_room_count <", value, "repairRoomCount");
            return (Criteria) this;
        }

        public Criteria andRepairRoomCountLessThanOrEqualTo(Integer value) {
            addCriterion("repair_room_count <=", value, "repairRoomCount");
            return (Criteria) this;
        }

        public Criteria andRepairRoomCountIn(List<Integer> values) {
            addCriterion("repair_room_count in", values, "repairRoomCount");
            return (Criteria) this;
        }

        public Criteria andRepairRoomCountNotIn(List<Integer> values) {
            addCriterion("repair_room_count not in", values, "repairRoomCount");
            return (Criteria) this;
        }

        public Criteria andRepairRoomCountBetween(Integer value1, Integer value2) {
            addCriterion("repair_room_count between", value1, value2, "repairRoomCount");
            return (Criteria) this;
        }

        public Criteria andRepairRoomCountNotBetween(Integer value1, Integer value2) {
            addCriterion("repair_room_count not between", value1, value2, "repairRoomCount");
            return (Criteria) this;
        }

        public Criteria andRepairOrderCountIsNull() {
            addCriterion("repair_order_count is null");
            return (Criteria) this;
        }

        public Criteria andRepairOrderCountIsNotNull() {
            addCriterion("repair_order_count is not null");
            return (Criteria) this;
        }

        public Criteria andRepairOrderCountEqualTo(Integer value) {
            addCriterion("repair_order_count =", value, "repairOrderCount");
            return (Criteria) this;
        }

        public Criteria andRepairOrderCountNotEqualTo(Integer value) {
            addCriterion("repair_order_count <>", value, "repairOrderCount");
            return (Criteria) this;
        }

        public Criteria andRepairOrderCountGreaterThan(Integer value) {
            addCriterion("repair_order_count >", value, "repairOrderCount");
            return (Criteria) this;
        }

        public Criteria andRepairOrderCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("repair_order_count >=", value, "repairOrderCount");
            return (Criteria) this;
        }

        public Criteria andRepairOrderCountLessThan(Integer value) {
            addCriterion("repair_order_count <", value, "repairOrderCount");
            return (Criteria) this;
        }

        public Criteria andRepairOrderCountLessThanOrEqualTo(Integer value) {
            addCriterion("repair_order_count <=", value, "repairOrderCount");
            return (Criteria) this;
        }

        public Criteria andRepairOrderCountIn(List<Integer> values) {
            addCriterion("repair_order_count in", values, "repairOrderCount");
            return (Criteria) this;
        }

        public Criteria andRepairOrderCountNotIn(List<Integer> values) {
            addCriterion("repair_order_count not in", values, "repairOrderCount");
            return (Criteria) this;
        }

        public Criteria andRepairOrderCountBetween(Integer value1, Integer value2) {
            addCriterion("repair_order_count between", value1, value2, "repairOrderCount");
            return (Criteria) this;
        }

        public Criteria andRepairOrderCountNotBetween(Integer value1, Integer value2) {
            addCriterion("repair_order_count not between", value1, value2, "repairOrderCount");
            return (Criteria) this;
        }

        public Criteria andIssueUserCountIsNull() {
            addCriterion("issue_user_count is null");
            return (Criteria) this;
        }

        public Criteria andIssueUserCountIsNotNull() {
            addCriterion("issue_user_count is not null");
            return (Criteria) this;
        }

        public Criteria andIssueUserCountEqualTo(Integer value) {
            addCriterion("issue_user_count =", value, "issueUserCount");
            return (Criteria) this;
        }

        public Criteria andIssueUserCountNotEqualTo(Integer value) {
            addCriterion("issue_user_count <>", value, "issueUserCount");
            return (Criteria) this;
        }

        public Criteria andIssueUserCountGreaterThan(Integer value) {
            addCriterion("issue_user_count >", value, "issueUserCount");
            return (Criteria) this;
        }

        public Criteria andIssueUserCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("issue_user_count >=", value, "issueUserCount");
            return (Criteria) this;
        }

        public Criteria andIssueUserCountLessThan(Integer value) {
            addCriterion("issue_user_count <", value, "issueUserCount");
            return (Criteria) this;
        }

        public Criteria andIssueUserCountLessThanOrEqualTo(Integer value) {
            addCriterion("issue_user_count <=", value, "issueUserCount");
            return (Criteria) this;
        }

        public Criteria andIssueUserCountIn(List<Integer> values) {
            addCriterion("issue_user_count in", values, "issueUserCount");
            return (Criteria) this;
        }

        public Criteria andIssueUserCountNotIn(List<Integer> values) {
            addCriterion("issue_user_count not in", values, "issueUserCount");
            return (Criteria) this;
        }

        public Criteria andIssueUserCountBetween(Integer value1, Integer value2) {
            addCriterion("issue_user_count between", value1, value2, "issueUserCount");
            return (Criteria) this;
        }

        public Criteria andIssueUserCountNotBetween(Integer value1, Integer value2) {
            addCriterion("issue_user_count not between", value1, value2, "issueUserCount");
            return (Criteria) this;
        }

        public Criteria andIssueRoomCountIsNull() {
            addCriterion("issue_room_count is null");
            return (Criteria) this;
        }

        public Criteria andIssueRoomCountIsNotNull() {
            addCriterion("issue_room_count is not null");
            return (Criteria) this;
        }

        public Criteria andIssueRoomCountEqualTo(Integer value) {
            addCriterion("issue_room_count =", value, "issueRoomCount");
            return (Criteria) this;
        }

        public Criteria andIssueRoomCountNotEqualTo(Integer value) {
            addCriterion("issue_room_count <>", value, "issueRoomCount");
            return (Criteria) this;
        }

        public Criteria andIssueRoomCountGreaterThan(Integer value) {
            addCriterion("issue_room_count >", value, "issueRoomCount");
            return (Criteria) this;
        }

        public Criteria andIssueRoomCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("issue_room_count >=", value, "issueRoomCount");
            return (Criteria) this;
        }

        public Criteria andIssueRoomCountLessThan(Integer value) {
            addCriterion("issue_room_count <", value, "issueRoomCount");
            return (Criteria) this;
        }

        public Criteria andIssueRoomCountLessThanOrEqualTo(Integer value) {
            addCriterion("issue_room_count <=", value, "issueRoomCount");
            return (Criteria) this;
        }

        public Criteria andIssueRoomCountIn(List<Integer> values) {
            addCriterion("issue_room_count in", values, "issueRoomCount");
            return (Criteria) this;
        }

        public Criteria andIssueRoomCountNotIn(List<Integer> values) {
            addCriterion("issue_room_count not in", values, "issueRoomCount");
            return (Criteria) this;
        }

        public Criteria andIssueRoomCountBetween(Integer value1, Integer value2) {
            addCriterion("issue_room_count between", value1, value2, "issueRoomCount");
            return (Criteria) this;
        }

        public Criteria andIssueRoomCountNotBetween(Integer value1, Integer value2) {
            addCriterion("issue_room_count not between", value1, value2, "issueRoomCount");
            return (Criteria) this;
        }

        public Criteria andIssueOrderCountIsNull() {
            addCriterion("issue_order_count is null");
            return (Criteria) this;
        }

        public Criteria andIssueOrderCountIsNotNull() {
            addCriterion("issue_order_count is not null");
            return (Criteria) this;
        }

        public Criteria andIssueOrderCountEqualTo(Integer value) {
            addCriterion("issue_order_count =", value, "issueOrderCount");
            return (Criteria) this;
        }

        public Criteria andIssueOrderCountNotEqualTo(Integer value) {
            addCriterion("issue_order_count <>", value, "issueOrderCount");
            return (Criteria) this;
        }

        public Criteria andIssueOrderCountGreaterThan(Integer value) {
            addCriterion("issue_order_count >", value, "issueOrderCount");
            return (Criteria) this;
        }

        public Criteria andIssueOrderCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("issue_order_count >=", value, "issueOrderCount");
            return (Criteria) this;
        }

        public Criteria andIssueOrderCountLessThan(Integer value) {
            addCriterion("issue_order_count <", value, "issueOrderCount");
            return (Criteria) this;
        }

        public Criteria andIssueOrderCountLessThanOrEqualTo(Integer value) {
            addCriterion("issue_order_count <=", value, "issueOrderCount");
            return (Criteria) this;
        }

        public Criteria andIssueOrderCountIn(List<Integer> values) {
            addCriterion("issue_order_count in", values, "issueOrderCount");
            return (Criteria) this;
        }

        public Criteria andIssueOrderCountNotIn(List<Integer> values) {
            addCriterion("issue_order_count not in", values, "issueOrderCount");
            return (Criteria) this;
        }

        public Criteria andIssueOrderCountBetween(Integer value1, Integer value2) {
            addCriterion("issue_order_count between", value1, value2, "issueOrderCount");
            return (Criteria) this;
        }

        public Criteria andIssueOrderCountNotBetween(Integer value1, Integer value2) {
            addCriterion("issue_order_count not between", value1, value2, "issueOrderCount");
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