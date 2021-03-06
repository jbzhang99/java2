package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatMasterInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatMasterInfoExample() {
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

        public Criteria andUserCountIsNull() {
            addCriterion("user_count is null");
            return (Criteria) this;
        }

        public Criteria andUserCountIsNotNull() {
            addCriterion("user_count is not null");
            return (Criteria) this;
        }

        public Criteria andUserCountEqualTo(Integer value) {
            addCriterion("user_count =", value, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountNotEqualTo(Integer value) {
            addCriterion("user_count <>", value, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountGreaterThan(Integer value) {
            addCriterion("user_count >", value, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_count >=", value, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountLessThan(Integer value) {
            addCriterion("user_count <", value, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountLessThanOrEqualTo(Integer value) {
            addCriterion("user_count <=", value, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountIn(List<Integer> values) {
            addCriterion("user_count in", values, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountNotIn(List<Integer> values) {
            addCriterion("user_count not in", values, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountBetween(Integer value1, Integer value2) {
            addCriterion("user_count between", value1, value2, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountNotBetween(Integer value1, Integer value2) {
            addCriterion("user_count not between", value1, value2, "userCount");
            return (Criteria) this;
        }

        public Criteria andMasterCountIsNull() {
            addCriterion("master_count is null");
            return (Criteria) this;
        }

        public Criteria andMasterCountIsNotNull() {
            addCriterion("master_count is not null");
            return (Criteria) this;
        }

        public Criteria andMasterCountEqualTo(Integer value) {
            addCriterion("master_count =", value, "masterCount");
            return (Criteria) this;
        }

        public Criteria andMasterCountNotEqualTo(Integer value) {
            addCriterion("master_count <>", value, "masterCount");
            return (Criteria) this;
        }

        public Criteria andMasterCountGreaterThan(Integer value) {
            addCriterion("master_count >", value, "masterCount");
            return (Criteria) this;
        }

        public Criteria andMasterCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("master_count >=", value, "masterCount");
            return (Criteria) this;
        }

        public Criteria andMasterCountLessThan(Integer value) {
            addCriterion("master_count <", value, "masterCount");
            return (Criteria) this;
        }

        public Criteria andMasterCountLessThanOrEqualTo(Integer value) {
            addCriterion("master_count <=", value, "masterCount");
            return (Criteria) this;
        }

        public Criteria andMasterCountIn(List<Integer> values) {
            addCriterion("master_count in", values, "masterCount");
            return (Criteria) this;
        }

        public Criteria andMasterCountNotIn(List<Integer> values) {
            addCriterion("master_count not in", values, "masterCount");
            return (Criteria) this;
        }

        public Criteria andMasterCountBetween(Integer value1, Integer value2) {
            addCriterion("master_count between", value1, value2, "masterCount");
            return (Criteria) this;
        }

        public Criteria andMasterCountNotBetween(Integer value1, Integer value2) {
            addCriterion("master_count not between", value1, value2, "masterCount");
            return (Criteria) this;
        }

        public Criteria andRoomCountIsNull() {
            addCriterion("room_count is null");
            return (Criteria) this;
        }

        public Criteria andRoomCountIsNotNull() {
            addCriterion("room_count is not null");
            return (Criteria) this;
        }

        public Criteria andRoomCountEqualTo(Integer value) {
            addCriterion("room_count =", value, "roomCount");
            return (Criteria) this;
        }

        public Criteria andRoomCountNotEqualTo(Integer value) {
            addCriterion("room_count <>", value, "roomCount");
            return (Criteria) this;
        }

        public Criteria andRoomCountGreaterThan(Integer value) {
            addCriterion("room_count >", value, "roomCount");
            return (Criteria) this;
        }

        public Criteria andRoomCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_count >=", value, "roomCount");
            return (Criteria) this;
        }

        public Criteria andRoomCountLessThan(Integer value) {
            addCriterion("room_count <", value, "roomCount");
            return (Criteria) this;
        }

        public Criteria andRoomCountLessThanOrEqualTo(Integer value) {
            addCriterion("room_count <=", value, "roomCount");
            return (Criteria) this;
        }

        public Criteria andRoomCountIn(List<Integer> values) {
            addCriterion("room_count in", values, "roomCount");
            return (Criteria) this;
        }

        public Criteria andRoomCountNotIn(List<Integer> values) {
            addCriterion("room_count not in", values, "roomCount");
            return (Criteria) this;
        }

        public Criteria andRoomCountBetween(Integer value1, Integer value2) {
            addCriterion("room_count between", value1, value2, "roomCount");
            return (Criteria) this;
        }

        public Criteria andRoomCountNotBetween(Integer value1, Integer value2) {
            addCriterion("room_count not between", value1, value2, "roomCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountIsNull() {
            addCriterion("parking_count is null");
            return (Criteria) this;
        }

        public Criteria andParkingCountIsNotNull() {
            addCriterion("parking_count is not null");
            return (Criteria) this;
        }

        public Criteria andParkingCountEqualTo(Integer value) {
            addCriterion("parking_count =", value, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountNotEqualTo(Integer value) {
            addCriterion("parking_count <>", value, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountGreaterThan(Integer value) {
            addCriterion("parking_count >", value, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("parking_count >=", value, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountLessThan(Integer value) {
            addCriterion("parking_count <", value, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountLessThanOrEqualTo(Integer value) {
            addCriterion("parking_count <=", value, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountIn(List<Integer> values) {
            addCriterion("parking_count in", values, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountNotIn(List<Integer> values) {
            addCriterion("parking_count not in", values, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountBetween(Integer value1, Integer value2) {
            addCriterion("parking_count between", value1, value2, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andParkingCountNotBetween(Integer value1, Integer value2) {
            addCriterion("parking_count not between", value1, value2, "parkingCount");
            return (Criteria) this;
        }

        public Criteria andMasterChildCountIsNull() {
            addCriterion("master_child_count is null");
            return (Criteria) this;
        }

        public Criteria andMasterChildCountIsNotNull() {
            addCriterion("master_child_count is not null");
            return (Criteria) this;
        }

        public Criteria andMasterChildCountEqualTo(Integer value) {
            addCriterion("master_child_count =", value, "masterChildCount");
            return (Criteria) this;
        }

        public Criteria andMasterChildCountNotEqualTo(Integer value) {
            addCriterion("master_child_count <>", value, "masterChildCount");
            return (Criteria) this;
        }

        public Criteria andMasterChildCountGreaterThan(Integer value) {
            addCriterion("master_child_count >", value, "masterChildCount");
            return (Criteria) this;
        }

        public Criteria andMasterChildCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("master_child_count >=", value, "masterChildCount");
            return (Criteria) this;
        }

        public Criteria andMasterChildCountLessThan(Integer value) {
            addCriterion("master_child_count <", value, "masterChildCount");
            return (Criteria) this;
        }

        public Criteria andMasterChildCountLessThanOrEqualTo(Integer value) {
            addCriterion("master_child_count <=", value, "masterChildCount");
            return (Criteria) this;
        }

        public Criteria andMasterChildCountIn(List<Integer> values) {
            addCriterion("master_child_count in", values, "masterChildCount");
            return (Criteria) this;
        }

        public Criteria andMasterChildCountNotIn(List<Integer> values) {
            addCriterion("master_child_count not in", values, "masterChildCount");
            return (Criteria) this;
        }

        public Criteria andMasterChildCountBetween(Integer value1, Integer value2) {
            addCriterion("master_child_count between", value1, value2, "masterChildCount");
            return (Criteria) this;
        }

        public Criteria andMasterChildCountNotBetween(Integer value1, Integer value2) {
            addCriterion("master_child_count not between", value1, value2, "masterChildCount");
            return (Criteria) this;
        }

        public Criteria andOwnerCountIsNull() {
            addCriterion("owner_count is null");
            return (Criteria) this;
        }

        public Criteria andOwnerCountIsNotNull() {
            addCriterion("owner_count is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerCountEqualTo(Integer value) {
            addCriterion("owner_count =", value, "ownerCount");
            return (Criteria) this;
        }

        public Criteria andOwnerCountNotEqualTo(Integer value) {
            addCriterion("owner_count <>", value, "ownerCount");
            return (Criteria) this;
        }

        public Criteria andOwnerCountGreaterThan(Integer value) {
            addCriterion("owner_count >", value, "ownerCount");
            return (Criteria) this;
        }

        public Criteria andOwnerCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("owner_count >=", value, "ownerCount");
            return (Criteria) this;
        }

        public Criteria andOwnerCountLessThan(Integer value) {
            addCriterion("owner_count <", value, "ownerCount");
            return (Criteria) this;
        }

        public Criteria andOwnerCountLessThanOrEqualTo(Integer value) {
            addCriterion("owner_count <=", value, "ownerCount");
            return (Criteria) this;
        }

        public Criteria andOwnerCountIn(List<Integer> values) {
            addCriterion("owner_count in", values, "ownerCount");
            return (Criteria) this;
        }

        public Criteria andOwnerCountNotIn(List<Integer> values) {
            addCriterion("owner_count not in", values, "ownerCount");
            return (Criteria) this;
        }

        public Criteria andOwnerCountBetween(Integer value1, Integer value2) {
            addCriterion("owner_count between", value1, value2, "ownerCount");
            return (Criteria) this;
        }

        public Criteria andOwnerCountNotBetween(Integer value1, Integer value2) {
            addCriterion("owner_count not between", value1, value2, "ownerCount");
            return (Criteria) this;
        }

        public Criteria andBizOwnerCountIsNull() {
            addCriterion("biz_owner_count is null");
            return (Criteria) this;
        }

        public Criteria andBizOwnerCountIsNotNull() {
            addCriterion("biz_owner_count is not null");
            return (Criteria) this;
        }

        public Criteria andBizOwnerCountEqualTo(Integer value) {
            addCriterion("biz_owner_count =", value, "bizOwnerCount");
            return (Criteria) this;
        }

        public Criteria andBizOwnerCountNotEqualTo(Integer value) {
            addCriterion("biz_owner_count <>", value, "bizOwnerCount");
            return (Criteria) this;
        }

        public Criteria andBizOwnerCountGreaterThan(Integer value) {
            addCriterion("biz_owner_count >", value, "bizOwnerCount");
            return (Criteria) this;
        }

        public Criteria andBizOwnerCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("biz_owner_count >=", value, "bizOwnerCount");
            return (Criteria) this;
        }

        public Criteria andBizOwnerCountLessThan(Integer value) {
            addCriterion("biz_owner_count <", value, "bizOwnerCount");
            return (Criteria) this;
        }

        public Criteria andBizOwnerCountLessThanOrEqualTo(Integer value) {
            addCriterion("biz_owner_count <=", value, "bizOwnerCount");
            return (Criteria) this;
        }

        public Criteria andBizOwnerCountIn(List<Integer> values) {
            addCriterion("biz_owner_count in", values, "bizOwnerCount");
            return (Criteria) this;
        }

        public Criteria andBizOwnerCountNotIn(List<Integer> values) {
            addCriterion("biz_owner_count not in", values, "bizOwnerCount");
            return (Criteria) this;
        }

        public Criteria andBizOwnerCountBetween(Integer value1, Integer value2) {
            addCriterion("biz_owner_count between", value1, value2, "bizOwnerCount");
            return (Criteria) this;
        }

        public Criteria andBizOwnerCountNotBetween(Integer value1, Integer value2) {
            addCriterion("biz_owner_count not between", value1, value2, "bizOwnerCount");
            return (Criteria) this;
        }

        public Criteria andTenantCountIsNull() {
            addCriterion("tenant_count is null");
            return (Criteria) this;
        }

        public Criteria andTenantCountIsNotNull() {
            addCriterion("tenant_count is not null");
            return (Criteria) this;
        }

        public Criteria andTenantCountEqualTo(Integer value) {
            addCriterion("tenant_count =", value, "tenantCount");
            return (Criteria) this;
        }

        public Criteria andTenantCountNotEqualTo(Integer value) {
            addCriterion("tenant_count <>", value, "tenantCount");
            return (Criteria) this;
        }

        public Criteria andTenantCountGreaterThan(Integer value) {
            addCriterion("tenant_count >", value, "tenantCount");
            return (Criteria) this;
        }

        public Criteria andTenantCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("tenant_count >=", value, "tenantCount");
            return (Criteria) this;
        }

        public Criteria andTenantCountLessThan(Integer value) {
            addCriterion("tenant_count <", value, "tenantCount");
            return (Criteria) this;
        }

        public Criteria andTenantCountLessThanOrEqualTo(Integer value) {
            addCriterion("tenant_count <=", value, "tenantCount");
            return (Criteria) this;
        }

        public Criteria andTenantCountIn(List<Integer> values) {
            addCriterion("tenant_count in", values, "tenantCount");
            return (Criteria) this;
        }

        public Criteria andTenantCountNotIn(List<Integer> values) {
            addCriterion("tenant_count not in", values, "tenantCount");
            return (Criteria) this;
        }

        public Criteria andTenantCountBetween(Integer value1, Integer value2) {
            addCriterion("tenant_count between", value1, value2, "tenantCount");
            return (Criteria) this;
        }

        public Criteria andTenantCountNotBetween(Integer value1, Integer value2) {
            addCriterion("tenant_count not between", value1, value2, "tenantCount");
            return (Criteria) this;
        }

        public Criteria andFamilyCountIsNull() {
            addCriterion("family_count is null");
            return (Criteria) this;
        }

        public Criteria andFamilyCountIsNotNull() {
            addCriterion("family_count is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyCountEqualTo(Integer value) {
            addCriterion("family_count =", value, "familyCount");
            return (Criteria) this;
        }

        public Criteria andFamilyCountNotEqualTo(Integer value) {
            addCriterion("family_count <>", value, "familyCount");
            return (Criteria) this;
        }

        public Criteria andFamilyCountGreaterThan(Integer value) {
            addCriterion("family_count >", value, "familyCount");
            return (Criteria) this;
        }

        public Criteria andFamilyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("family_count >=", value, "familyCount");
            return (Criteria) this;
        }

        public Criteria andFamilyCountLessThan(Integer value) {
            addCriterion("family_count <", value, "familyCount");
            return (Criteria) this;
        }

        public Criteria andFamilyCountLessThanOrEqualTo(Integer value) {
            addCriterion("family_count <=", value, "familyCount");
            return (Criteria) this;
        }

        public Criteria andFamilyCountIn(List<Integer> values) {
            addCriterion("family_count in", values, "familyCount");
            return (Criteria) this;
        }

        public Criteria andFamilyCountNotIn(List<Integer> values) {
            addCriterion("family_count not in", values, "familyCount");
            return (Criteria) this;
        }

        public Criteria andFamilyCountBetween(Integer value1, Integer value2) {
            addCriterion("family_count between", value1, value2, "familyCount");
            return (Criteria) this;
        }

        public Criteria andFamilyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("family_count not between", value1, value2, "familyCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountIsNull() {
            addCriterion("staff_count is null");
            return (Criteria) this;
        }

        public Criteria andStaffCountIsNotNull() {
            addCriterion("staff_count is not null");
            return (Criteria) this;
        }

        public Criteria andStaffCountEqualTo(Integer value) {
            addCriterion("staff_count =", value, "staffCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountNotEqualTo(Integer value) {
            addCriterion("staff_count <>", value, "staffCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountGreaterThan(Integer value) {
            addCriterion("staff_count >", value, "staffCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("staff_count >=", value, "staffCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountLessThan(Integer value) {
            addCriterion("staff_count <", value, "staffCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountLessThanOrEqualTo(Integer value) {
            addCriterion("staff_count <=", value, "staffCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountIn(List<Integer> values) {
            addCriterion("staff_count in", values, "staffCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountNotIn(List<Integer> values) {
            addCriterion("staff_count not in", values, "staffCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountBetween(Integer value1, Integer value2) {
            addCriterion("staff_count between", value1, value2, "staffCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountNotBetween(Integer value1, Integer value2) {
            addCriterion("staff_count not between", value1, value2, "staffCount");
            return (Criteria) this;
        }

        public Criteria andSiteStaffCountIsNull() {
            addCriterion("site_staff_count is null");
            return (Criteria) this;
        }

        public Criteria andSiteStaffCountIsNotNull() {
            addCriterion("site_staff_count is not null");
            return (Criteria) this;
        }

        public Criteria andSiteStaffCountEqualTo(Integer value) {
            addCriterion("site_staff_count =", value, "siteStaffCount");
            return (Criteria) this;
        }

        public Criteria andSiteStaffCountNotEqualTo(Integer value) {
            addCriterion("site_staff_count <>", value, "siteStaffCount");
            return (Criteria) this;
        }

        public Criteria andSiteStaffCountGreaterThan(Integer value) {
            addCriterion("site_staff_count >", value, "siteStaffCount");
            return (Criteria) this;
        }

        public Criteria andSiteStaffCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("site_staff_count >=", value, "siteStaffCount");
            return (Criteria) this;
        }

        public Criteria andSiteStaffCountLessThan(Integer value) {
            addCriterion("site_staff_count <", value, "siteStaffCount");
            return (Criteria) this;
        }

        public Criteria andSiteStaffCountLessThanOrEqualTo(Integer value) {
            addCriterion("site_staff_count <=", value, "siteStaffCount");
            return (Criteria) this;
        }

        public Criteria andSiteStaffCountIn(List<Integer> values) {
            addCriterion("site_staff_count in", values, "siteStaffCount");
            return (Criteria) this;
        }

        public Criteria andSiteStaffCountNotIn(List<Integer> values) {
            addCriterion("site_staff_count not in", values, "siteStaffCount");
            return (Criteria) this;
        }

        public Criteria andSiteStaffCountBetween(Integer value1, Integer value2) {
            addCriterion("site_staff_count between", value1, value2, "siteStaffCount");
            return (Criteria) this;
        }

        public Criteria andSiteStaffCountNotBetween(Integer value1, Integer value2) {
            addCriterion("site_staff_count not between", value1, value2, "siteStaffCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountIsNull() {
            addCriterion("other_count is null");
            return (Criteria) this;
        }

        public Criteria andOtherCountIsNotNull() {
            addCriterion("other_count is not null");
            return (Criteria) this;
        }

        public Criteria andOtherCountEqualTo(Integer value) {
            addCriterion("other_count =", value, "otherCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountNotEqualTo(Integer value) {
            addCriterion("other_count <>", value, "otherCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountGreaterThan(Integer value) {
            addCriterion("other_count >", value, "otherCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("other_count >=", value, "otherCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountLessThan(Integer value) {
            addCriterion("other_count <", value, "otherCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountLessThanOrEqualTo(Integer value) {
            addCriterion("other_count <=", value, "otherCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountIn(List<Integer> values) {
            addCriterion("other_count in", values, "otherCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountNotIn(List<Integer> values) {
            addCriterion("other_count not in", values, "otherCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountBetween(Integer value1, Integer value2) {
            addCriterion("other_count between", value1, value2, "otherCount");
            return (Criteria) this;
        }

        public Criteria andOtherCountNotBetween(Integer value1, Integer value2) {
            addCriterion("other_count not between", value1, value2, "otherCount");
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

        public Criteria andPropTypeIsNull() {
            addCriterion("prop_type is null");
            return (Criteria) this;
        }

        public Criteria andPropTypeIsNotNull() {
            addCriterion("prop_type is not null");
            return (Criteria) this;
        }

        public Criteria andPropTypeEqualTo(Integer value) {
            addCriterion("prop_type =", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeNotEqualTo(Integer value) {
            addCriterion("prop_type <>", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeGreaterThan(Integer value) {
            addCriterion("prop_type >", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("prop_type >=", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeLessThan(Integer value) {
            addCriterion("prop_type <", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeLessThanOrEqualTo(Integer value) {
            addCriterion("prop_type <=", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeIn(List<Integer> values) {
            addCriterion("prop_type in", values, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeNotIn(List<Integer> values) {
            addCriterion("prop_type not in", values, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeBetween(Integer value1, Integer value2) {
            addCriterion("prop_type between", value1, value2, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("prop_type not between", value1, value2, "propType");
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