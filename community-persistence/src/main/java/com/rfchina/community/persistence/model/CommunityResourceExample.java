package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommunityResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommunityResourceExample() {
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

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Integer value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Integer> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
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

        public Criteria andResourceTypeIdIsNull() {
            addCriterion("resource_type_id is null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIdIsNotNull() {
            addCriterion("resource_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIdEqualTo(Integer value) {
            addCriterion("resource_type_id =", value, "resourceTypeId");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIdNotEqualTo(Integer value) {
            addCriterion("resource_type_id <>", value, "resourceTypeId");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIdGreaterThan(Integer value) {
            addCriterion("resource_type_id >", value, "resourceTypeId");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_type_id >=", value, "resourceTypeId");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIdLessThan(Integer value) {
            addCriterion("resource_type_id <", value, "resourceTypeId");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("resource_type_id <=", value, "resourceTypeId");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIdIn(List<Integer> values) {
            addCriterion("resource_type_id in", values, "resourceTypeId");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIdNotIn(List<Integer> values) {
            addCriterion("resource_type_id not in", values, "resourceTypeId");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("resource_type_id between", value1, value2, "resourceTypeId");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_type_id not between", value1, value2, "resourceTypeId");
            return (Criteria) this;
        }

        public Criteria andAddrDetailIsNull() {
            addCriterion("addr_detail is null");
            return (Criteria) this;
        }

        public Criteria andAddrDetailIsNotNull() {
            addCriterion("addr_detail is not null");
            return (Criteria) this;
        }

        public Criteria andAddrDetailEqualTo(String value) {
            addCriterion("addr_detail =", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailNotEqualTo(String value) {
            addCriterion("addr_detail <>", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailGreaterThan(String value) {
            addCriterion("addr_detail >", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailGreaterThanOrEqualTo(String value) {
            addCriterion("addr_detail >=", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailLessThan(String value) {
            addCriterion("addr_detail <", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailLessThanOrEqualTo(String value) {
            addCriterion("addr_detail <=", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailLike(String value) {
            addCriterion("addr_detail like", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailNotLike(String value) {
            addCriterion("addr_detail not like", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailIn(List<String> values) {
            addCriterion("addr_detail in", values, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailNotIn(List<String> values) {
            addCriterion("addr_detail not in", values, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailBetween(String value1, String value2) {
            addCriterion("addr_detail between", value1, value2, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailNotBetween(String value1, String value2) {
            addCriterion("addr_detail not between", value1, value2, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andResourceDescIsNull() {
            addCriterion("resource_desc is null");
            return (Criteria) this;
        }

        public Criteria andResourceDescIsNotNull() {
            addCriterion("resource_desc is not null");
            return (Criteria) this;
        }

        public Criteria andResourceDescEqualTo(String value) {
            addCriterion("resource_desc =", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescNotEqualTo(String value) {
            addCriterion("resource_desc <>", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescGreaterThan(String value) {
            addCriterion("resource_desc >", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescGreaterThanOrEqualTo(String value) {
            addCriterion("resource_desc >=", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescLessThan(String value) {
            addCriterion("resource_desc <", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescLessThanOrEqualTo(String value) {
            addCriterion("resource_desc <=", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescLike(String value) {
            addCriterion("resource_desc like", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescNotLike(String value) {
            addCriterion("resource_desc not like", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescIn(List<String> values) {
            addCriterion("resource_desc in", values, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescNotIn(List<String> values) {
            addCriterion("resource_desc not in", values, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescBetween(String value1, String value2) {
            addCriterion("resource_desc between", value1, value2, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescNotBetween(String value1, String value2) {
            addCriterion("resource_desc not between", value1, value2, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceTotalIsNull() {
            addCriterion("resource_total is null");
            return (Criteria) this;
        }

        public Criteria andResourceTotalIsNotNull() {
            addCriterion("resource_total is not null");
            return (Criteria) this;
        }

        public Criteria andResourceTotalEqualTo(Integer value) {
            addCriterion("resource_total =", value, "resourceTotal");
            return (Criteria) this;
        }

        public Criteria andResourceTotalNotEqualTo(Integer value) {
            addCriterion("resource_total <>", value, "resourceTotal");
            return (Criteria) this;
        }

        public Criteria andResourceTotalGreaterThan(Integer value) {
            addCriterion("resource_total >", value, "resourceTotal");
            return (Criteria) this;
        }

        public Criteria andResourceTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_total >=", value, "resourceTotal");
            return (Criteria) this;
        }

        public Criteria andResourceTotalLessThan(Integer value) {
            addCriterion("resource_total <", value, "resourceTotal");
            return (Criteria) this;
        }

        public Criteria andResourceTotalLessThanOrEqualTo(Integer value) {
            addCriterion("resource_total <=", value, "resourceTotal");
            return (Criteria) this;
        }

        public Criteria andResourceTotalIn(List<Integer> values) {
            addCriterion("resource_total in", values, "resourceTotal");
            return (Criteria) this;
        }

        public Criteria andResourceTotalNotIn(List<Integer> values) {
            addCriterion("resource_total not in", values, "resourceTotal");
            return (Criteria) this;
        }

        public Criteria andResourceTotalBetween(Integer value1, Integer value2) {
            addCriterion("resource_total between", value1, value2, "resourceTotal");
            return (Criteria) this;
        }

        public Criteria andResourceTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_total not between", value1, value2, "resourceTotal");
            return (Criteria) this;
        }

        public Criteria andResourceUsedIsNull() {
            addCriterion("resource_used is null");
            return (Criteria) this;
        }

        public Criteria andResourceUsedIsNotNull() {
            addCriterion("resource_used is not null");
            return (Criteria) this;
        }

        public Criteria andResourceUsedEqualTo(Integer value) {
            addCriterion("resource_used =", value, "resourceUsed");
            return (Criteria) this;
        }

        public Criteria andResourceUsedNotEqualTo(Integer value) {
            addCriterion("resource_used <>", value, "resourceUsed");
            return (Criteria) this;
        }

        public Criteria andResourceUsedGreaterThan(Integer value) {
            addCriterion("resource_used >", value, "resourceUsed");
            return (Criteria) this;
        }

        public Criteria andResourceUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_used >=", value, "resourceUsed");
            return (Criteria) this;
        }

        public Criteria andResourceUsedLessThan(Integer value) {
            addCriterion("resource_used <", value, "resourceUsed");
            return (Criteria) this;
        }

        public Criteria andResourceUsedLessThanOrEqualTo(Integer value) {
            addCriterion("resource_used <=", value, "resourceUsed");
            return (Criteria) this;
        }

        public Criteria andResourceUsedIn(List<Integer> values) {
            addCriterion("resource_used in", values, "resourceUsed");
            return (Criteria) this;
        }

        public Criteria andResourceUsedNotIn(List<Integer> values) {
            addCriterion("resource_used not in", values, "resourceUsed");
            return (Criteria) this;
        }

        public Criteria andResourceUsedBetween(Integer value1, Integer value2) {
            addCriterion("resource_used between", value1, value2, "resourceUsed");
            return (Criteria) this;
        }

        public Criteria andResourceUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_used not between", value1, value2, "resourceUsed");
            return (Criteria) this;
        }

        public Criteria andResourceFeeIsNull() {
            addCriterion("resource_fee is null");
            return (Criteria) this;
        }

        public Criteria andResourceFeeIsNotNull() {
            addCriterion("resource_fee is not null");
            return (Criteria) this;
        }

        public Criteria andResourceFeeEqualTo(BigDecimal value) {
            addCriterion("resource_fee =", value, "resourceFee");
            return (Criteria) this;
        }

        public Criteria andResourceFeeNotEqualTo(BigDecimal value) {
            addCriterion("resource_fee <>", value, "resourceFee");
            return (Criteria) this;
        }

        public Criteria andResourceFeeGreaterThan(BigDecimal value) {
            addCriterion("resource_fee >", value, "resourceFee");
            return (Criteria) this;
        }

        public Criteria andResourceFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("resource_fee >=", value, "resourceFee");
            return (Criteria) this;
        }

        public Criteria andResourceFeeLessThan(BigDecimal value) {
            addCriterion("resource_fee <", value, "resourceFee");
            return (Criteria) this;
        }

        public Criteria andResourceFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("resource_fee <=", value, "resourceFee");
            return (Criteria) this;
        }

        public Criteria andResourceFeeIn(List<BigDecimal> values) {
            addCriterion("resource_fee in", values, "resourceFee");
            return (Criteria) this;
        }

        public Criteria andResourceFeeNotIn(List<BigDecimal> values) {
            addCriterion("resource_fee not in", values, "resourceFee");
            return (Criteria) this;
        }

        public Criteria andResourceFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("resource_fee between", value1, value2, "resourceFee");
            return (Criteria) this;
        }

        public Criteria andResourceFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("resource_fee not between", value1, value2, "resourceFee");
            return (Criteria) this;
        }

        public Criteria andImgsIsNull() {
            addCriterion("imgs is null");
            return (Criteria) this;
        }

        public Criteria andImgsIsNotNull() {
            addCriterion("imgs is not null");
            return (Criteria) this;
        }

        public Criteria andImgsEqualTo(String value) {
            addCriterion("imgs =", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotEqualTo(String value) {
            addCriterion("imgs <>", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsGreaterThan(String value) {
            addCriterion("imgs >", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsGreaterThanOrEqualTo(String value) {
            addCriterion("imgs >=", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsLessThan(String value) {
            addCriterion("imgs <", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsLessThanOrEqualTo(String value) {
            addCriterion("imgs <=", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsLike(String value) {
            addCriterion("imgs like", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotLike(String value) {
            addCriterion("imgs not like", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsIn(List<String> values) {
            addCriterion("imgs in", values, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotIn(List<String> values) {
            addCriterion("imgs not in", values, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsBetween(String value1, String value2) {
            addCriterion("imgs between", value1, value2, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotBetween(String value1, String value2) {
            addCriterion("imgs not between", value1, value2, "imgs");
            return (Criteria) this;
        }

        public Criteria andResourceStatusIsNull() {
            addCriterion("resource_status is null");
            return (Criteria) this;
        }

        public Criteria andResourceStatusIsNotNull() {
            addCriterion("resource_status is not null");
            return (Criteria) this;
        }

        public Criteria andResourceStatusEqualTo(Byte value) {
            addCriterion("resource_status =", value, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusNotEqualTo(Byte value) {
            addCriterion("resource_status <>", value, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusGreaterThan(Byte value) {
            addCriterion("resource_status >", value, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("resource_status >=", value, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusLessThan(Byte value) {
            addCriterion("resource_status <", value, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusLessThanOrEqualTo(Byte value) {
            addCriterion("resource_status <=", value, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusIn(List<Byte> values) {
            addCriterion("resource_status in", values, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusNotIn(List<Byte> values) {
            addCriterion("resource_status not in", values, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusBetween(Byte value1, Byte value2) {
            addCriterion("resource_status between", value1, value2, "resourceStatus");
            return (Criteria) this;
        }

        public Criteria andResourceStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("resource_status not between", value1, value2, "resourceStatus");
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

        public Criteria andCreaterIdIsNull() {
            addCriterion("creater_id is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIdIsNotNull() {
            addCriterion("creater_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterIdEqualTo(Integer value) {
            addCriterion("creater_id =", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotEqualTo(Integer value) {
            addCriterion("creater_id <>", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdGreaterThan(Integer value) {
            addCriterion("creater_id >", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("creater_id >=", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdLessThan(Integer value) {
            addCriterion("creater_id <", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdLessThanOrEqualTo(Integer value) {
            addCriterion("creater_id <=", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdIn(List<Integer> values) {
            addCriterion("creater_id in", values, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotIn(List<Integer> values) {
            addCriterion("creater_id not in", values, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdBetween(Integer value1, Integer value2) {
            addCriterion("creater_id between", value1, value2, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("creater_id not between", value1, value2, "createrId");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifierIdIsNull() {
            addCriterion("modifier_id is null");
            return (Criteria) this;
        }

        public Criteria andModifierIdIsNotNull() {
            addCriterion("modifier_id is not null");
            return (Criteria) this;
        }

        public Criteria andModifierIdEqualTo(Integer value) {
            addCriterion("modifier_id =", value, "modifierId");
            return (Criteria) this;
        }

        public Criteria andModifierIdNotEqualTo(Integer value) {
            addCriterion("modifier_id <>", value, "modifierId");
            return (Criteria) this;
        }

        public Criteria andModifierIdGreaterThan(Integer value) {
            addCriterion("modifier_id >", value, "modifierId");
            return (Criteria) this;
        }

        public Criteria andModifierIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("modifier_id >=", value, "modifierId");
            return (Criteria) this;
        }

        public Criteria andModifierIdLessThan(Integer value) {
            addCriterion("modifier_id <", value, "modifierId");
            return (Criteria) this;
        }

        public Criteria andModifierIdLessThanOrEqualTo(Integer value) {
            addCriterion("modifier_id <=", value, "modifierId");
            return (Criteria) this;
        }

        public Criteria andModifierIdIn(List<Integer> values) {
            addCriterion("modifier_id in", values, "modifierId");
            return (Criteria) this;
        }

        public Criteria andModifierIdNotIn(List<Integer> values) {
            addCriterion("modifier_id not in", values, "modifierId");
            return (Criteria) this;
        }

        public Criteria andModifierIdBetween(Integer value1, Integer value2) {
            addCriterion("modifier_id between", value1, value2, "modifierId");
            return (Criteria) this;
        }

        public Criteria andModifierIdNotBetween(Integer value1, Integer value2) {
            addCriterion("modifier_id not between", value1, value2, "modifierId");
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