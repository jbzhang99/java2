package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WaterOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WaterOrderExample() {
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

        public Criteria andSerialNoIsNull() {
            addCriterion("serial_no is null");
            return (Criteria) this;
        }

        public Criteria andSerialNoIsNotNull() {
            addCriterion("serial_no is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNoEqualTo(String value) {
            addCriterion("serial_no =", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotEqualTo(String value) {
            addCriterion("serial_no <>", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoGreaterThan(String value) {
            addCriterion("serial_no >", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoGreaterThanOrEqualTo(String value) {
            addCriterion("serial_no >=", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLessThan(String value) {
            addCriterion("serial_no <", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLessThanOrEqualTo(String value) {
            addCriterion("serial_no <=", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLike(String value) {
            addCriterion("serial_no like", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotLike(String value) {
            addCriterion("serial_no not like", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoIn(List<String> values) {
            addCriterion("serial_no in", values, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotIn(List<String> values) {
            addCriterion("serial_no not in", values, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoBetween(String value1, String value2) {
            addCriterion("serial_no between", value1, value2, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotBetween(String value1, String value2) {
            addCriterion("serial_no not between", value1, value2, "serialNo");
            return (Criteria) this;
        }

        public Criteria andWaterBrandIdIsNull() {
            addCriterion("water_brand_id is null");
            return (Criteria) this;
        }

        public Criteria andWaterBrandIdIsNotNull() {
            addCriterion("water_brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andWaterBrandIdEqualTo(Long value) {
            addCriterion("water_brand_id =", value, "waterBrandId");
            return (Criteria) this;
        }

        public Criteria andWaterBrandIdNotEqualTo(Long value) {
            addCriterion("water_brand_id <>", value, "waterBrandId");
            return (Criteria) this;
        }

        public Criteria andWaterBrandIdGreaterThan(Long value) {
            addCriterion("water_brand_id >", value, "waterBrandId");
            return (Criteria) this;
        }

        public Criteria andWaterBrandIdGreaterThanOrEqualTo(Long value) {
            addCriterion("water_brand_id >=", value, "waterBrandId");
            return (Criteria) this;
        }

        public Criteria andWaterBrandIdLessThan(Long value) {
            addCriterion("water_brand_id <", value, "waterBrandId");
            return (Criteria) this;
        }

        public Criteria andWaterBrandIdLessThanOrEqualTo(Long value) {
            addCriterion("water_brand_id <=", value, "waterBrandId");
            return (Criteria) this;
        }

        public Criteria andWaterBrandIdIn(List<Long> values) {
            addCriterion("water_brand_id in", values, "waterBrandId");
            return (Criteria) this;
        }

        public Criteria andWaterBrandIdNotIn(List<Long> values) {
            addCriterion("water_brand_id not in", values, "waterBrandId");
            return (Criteria) this;
        }

        public Criteria andWaterBrandIdBetween(Long value1, Long value2) {
            addCriterion("water_brand_id between", value1, value2, "waterBrandId");
            return (Criteria) this;
        }

        public Criteria andWaterBrandIdNotBetween(Long value1, Long value2) {
            addCriterion("water_brand_id not between", value1, value2, "waterBrandId");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Long value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Long value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Long value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Long value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Long value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Long value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Long> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Long> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Long value1, Long value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Long value1, Long value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomOwnerIsNull() {
            addCriterion("room_owner is null");
            return (Criteria) this;
        }

        public Criteria andRoomOwnerIsNotNull() {
            addCriterion("room_owner is not null");
            return (Criteria) this;
        }

        public Criteria andRoomOwnerEqualTo(String value) {
            addCriterion("room_owner =", value, "roomOwner");
            return (Criteria) this;
        }

        public Criteria andRoomOwnerNotEqualTo(String value) {
            addCriterion("room_owner <>", value, "roomOwner");
            return (Criteria) this;
        }

        public Criteria andRoomOwnerGreaterThan(String value) {
            addCriterion("room_owner >", value, "roomOwner");
            return (Criteria) this;
        }

        public Criteria andRoomOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("room_owner >=", value, "roomOwner");
            return (Criteria) this;
        }

        public Criteria andRoomOwnerLessThan(String value) {
            addCriterion("room_owner <", value, "roomOwner");
            return (Criteria) this;
        }

        public Criteria andRoomOwnerLessThanOrEqualTo(String value) {
            addCriterion("room_owner <=", value, "roomOwner");
            return (Criteria) this;
        }

        public Criteria andRoomOwnerLike(String value) {
            addCriterion("room_owner like", value, "roomOwner");
            return (Criteria) this;
        }

        public Criteria andRoomOwnerNotLike(String value) {
            addCriterion("room_owner not like", value, "roomOwner");
            return (Criteria) this;
        }

        public Criteria andRoomOwnerIn(List<String> values) {
            addCriterion("room_owner in", values, "roomOwner");
            return (Criteria) this;
        }

        public Criteria andRoomOwnerNotIn(List<String> values) {
            addCriterion("room_owner not in", values, "roomOwner");
            return (Criteria) this;
        }

        public Criteria andRoomOwnerBetween(String value1, String value2) {
            addCriterion("room_owner between", value1, value2, "roomOwner");
            return (Criteria) this;
        }

        public Criteria andRoomOwnerNotBetween(String value1, String value2) {
            addCriterion("room_owner not between", value1, value2, "roomOwner");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdIsNull() {
            addCriterion("master_child_id is null");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdIsNotNull() {
            addCriterion("master_child_id is not null");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdEqualTo(Long value) {
            addCriterion("master_child_id =", value, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdNotEqualTo(Long value) {
            addCriterion("master_child_id <>", value, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdGreaterThan(Long value) {
            addCriterion("master_child_id >", value, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdGreaterThanOrEqualTo(Long value) {
            addCriterion("master_child_id >=", value, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdLessThan(Long value) {
            addCriterion("master_child_id <", value, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdLessThanOrEqualTo(Long value) {
            addCriterion("master_child_id <=", value, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdIn(List<Long> values) {
            addCriterion("master_child_id in", values, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdNotIn(List<Long> values) {
            addCriterion("master_child_id not in", values, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdBetween(Long value1, Long value2) {
            addCriterion("master_child_id between", value1, value2, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdNotBetween(Long value1, Long value2) {
            addCriterion("master_child_id not between", value1, value2, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Integer value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Integer> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Integer> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderSrcIsNull() {
            addCriterion("order_src is null");
            return (Criteria) this;
        }

        public Criteria andOrderSrcIsNotNull() {
            addCriterion("order_src is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSrcEqualTo(Integer value) {
            addCriterion("order_src =", value, "orderSrc");
            return (Criteria) this;
        }

        public Criteria andOrderSrcNotEqualTo(Integer value) {
            addCriterion("order_src <>", value, "orderSrc");
            return (Criteria) this;
        }

        public Criteria andOrderSrcGreaterThan(Integer value) {
            addCriterion("order_src >", value, "orderSrc");
            return (Criteria) this;
        }

        public Criteria andOrderSrcGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_src >=", value, "orderSrc");
            return (Criteria) this;
        }

        public Criteria andOrderSrcLessThan(Integer value) {
            addCriterion("order_src <", value, "orderSrc");
            return (Criteria) this;
        }

        public Criteria andOrderSrcLessThanOrEqualTo(Integer value) {
            addCriterion("order_src <=", value, "orderSrc");
            return (Criteria) this;
        }

        public Criteria andOrderSrcIn(List<Integer> values) {
            addCriterion("order_src in", values, "orderSrc");
            return (Criteria) this;
        }

        public Criteria andOrderSrcNotIn(List<Integer> values) {
            addCriterion("order_src not in", values, "orderSrc");
            return (Criteria) this;
        }

        public Criteria andOrderSrcBetween(Integer value1, Integer value2) {
            addCriterion("order_src between", value1, value2, "orderSrc");
            return (Criteria) this;
        }

        public Criteria andOrderSrcNotBetween(Integer value1, Integer value2) {
            addCriterion("order_src not between", value1, value2, "orderSrc");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Date value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Date value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Date value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Date> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Integer value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Integer value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Integer value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Integer value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Integer> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Integer> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayBodyIsNull() {
            addCriterion("pay_body is null");
            return (Criteria) this;
        }

        public Criteria andPayBodyIsNotNull() {
            addCriterion("pay_body is not null");
            return (Criteria) this;
        }

        public Criteria andPayBodyEqualTo(String value) {
            addCriterion("pay_body =", value, "payBody");
            return (Criteria) this;
        }

        public Criteria andPayBodyNotEqualTo(String value) {
            addCriterion("pay_body <>", value, "payBody");
            return (Criteria) this;
        }

        public Criteria andPayBodyGreaterThan(String value) {
            addCriterion("pay_body >", value, "payBody");
            return (Criteria) this;
        }

        public Criteria andPayBodyGreaterThanOrEqualTo(String value) {
            addCriterion("pay_body >=", value, "payBody");
            return (Criteria) this;
        }

        public Criteria andPayBodyLessThan(String value) {
            addCriterion("pay_body <", value, "payBody");
            return (Criteria) this;
        }

        public Criteria andPayBodyLessThanOrEqualTo(String value) {
            addCriterion("pay_body <=", value, "payBody");
            return (Criteria) this;
        }

        public Criteria andPayBodyLike(String value) {
            addCriterion("pay_body like", value, "payBody");
            return (Criteria) this;
        }

        public Criteria andPayBodyNotLike(String value) {
            addCriterion("pay_body not like", value, "payBody");
            return (Criteria) this;
        }

        public Criteria andPayBodyIn(List<String> values) {
            addCriterion("pay_body in", values, "payBody");
            return (Criteria) this;
        }

        public Criteria andPayBodyNotIn(List<String> values) {
            addCriterion("pay_body not in", values, "payBody");
            return (Criteria) this;
        }

        public Criteria andPayBodyBetween(String value1, String value2) {
            addCriterion("pay_body between", value1, value2, "payBody");
            return (Criteria) this;
        }

        public Criteria andPayBodyNotBetween(String value1, String value2) {
            addCriterion("pay_body not between", value1, value2, "payBody");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNull() {
            addCriterion("bill_id is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(String value) {
            addCriterion("bill_id =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(String value) {
            addCriterion("bill_id <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(String value) {
            addCriterion("bill_id >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("bill_id >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(String value) {
            addCriterion("bill_id <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(String value) {
            addCriterion("bill_id <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLike(String value) {
            addCriterion("bill_id like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotLike(String value) {
            addCriterion("bill_id not like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<String> values) {
            addCriterion("bill_id in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<String> values) {
            addCriterion("bill_id not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(String value1, String value2) {
            addCriterion("bill_id between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(String value1, String value2) {
            addCriterion("bill_id not between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillCloseTimeIsNull() {
            addCriterion("bill_close_time is null");
            return (Criteria) this;
        }

        public Criteria andBillCloseTimeIsNotNull() {
            addCriterion("bill_close_time is not null");
            return (Criteria) this;
        }

        public Criteria andBillCloseTimeEqualTo(Date value) {
            addCriterion("bill_close_time =", value, "billCloseTime");
            return (Criteria) this;
        }

        public Criteria andBillCloseTimeNotEqualTo(Date value) {
            addCriterion("bill_close_time <>", value, "billCloseTime");
            return (Criteria) this;
        }

        public Criteria andBillCloseTimeGreaterThan(Date value) {
            addCriterion("bill_close_time >", value, "billCloseTime");
            return (Criteria) this;
        }

        public Criteria andBillCloseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bill_close_time >=", value, "billCloseTime");
            return (Criteria) this;
        }

        public Criteria andBillCloseTimeLessThan(Date value) {
            addCriterion("bill_close_time <", value, "billCloseTime");
            return (Criteria) this;
        }

        public Criteria andBillCloseTimeLessThanOrEqualTo(Date value) {
            addCriterion("bill_close_time <=", value, "billCloseTime");
            return (Criteria) this;
        }

        public Criteria andBillCloseTimeIn(List<Date> values) {
            addCriterion("bill_close_time in", values, "billCloseTime");
            return (Criteria) this;
        }

        public Criteria andBillCloseTimeNotIn(List<Date> values) {
            addCriterion("bill_close_time not in", values, "billCloseTime");
            return (Criteria) this;
        }

        public Criteria andBillCloseTimeBetween(Date value1, Date value2) {
            addCriterion("bill_close_time between", value1, value2, "billCloseTime");
            return (Criteria) this;
        }

        public Criteria andBillCloseTimeNotBetween(Date value1, Date value2) {
            addCriterion("bill_close_time not between", value1, value2, "billCloseTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeIsNull() {
            addCriterion("bill_create_time is null");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeIsNotNull() {
            addCriterion("bill_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeEqualTo(Date value) {
            addCriterion("bill_create_time =", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeNotEqualTo(Date value) {
            addCriterion("bill_create_time <>", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeGreaterThan(Date value) {
            addCriterion("bill_create_time >", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bill_create_time >=", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeLessThan(Date value) {
            addCriterion("bill_create_time <", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("bill_create_time <=", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeIn(List<Date> values) {
            addCriterion("bill_create_time in", values, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeNotIn(List<Date> values) {
            addCriterion("bill_create_time not in", values, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeBetween(Date value1, Date value2) {
            addCriterion("bill_create_time between", value1, value2, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("bill_create_time not between", value1, value2, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andNotifyIdIsNull() {
            addCriterion("notify_id is null");
            return (Criteria) this;
        }

        public Criteria andNotifyIdIsNotNull() {
            addCriterion("notify_id is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyIdEqualTo(String value) {
            addCriterion("notify_id =", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdNotEqualTo(String value) {
            addCriterion("notify_id <>", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdGreaterThan(String value) {
            addCriterion("notify_id >", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdGreaterThanOrEqualTo(String value) {
            addCriterion("notify_id >=", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdLessThan(String value) {
            addCriterion("notify_id <", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdLessThanOrEqualTo(String value) {
            addCriterion("notify_id <=", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdLike(String value) {
            addCriterion("notify_id like", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdNotLike(String value) {
            addCriterion("notify_id not like", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdIn(List<String> values) {
            addCriterion("notify_id in", values, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdNotIn(List<String> values) {
            addCriterion("notify_id not in", values, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdBetween(String value1, String value2) {
            addCriterion("notify_id between", value1, value2, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdNotBetween(String value1, String value2) {
            addCriterion("notify_id not between", value1, value2, "notifyId");
            return (Criteria) this;
        }

        public Criteria andWechatTradeNoIsNull() {
            addCriterion("wechat_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andWechatTradeNoIsNotNull() {
            addCriterion("wechat_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andWechatTradeNoEqualTo(String value) {
            addCriterion("wechat_trade_no =", value, "wechatTradeNo");
            return (Criteria) this;
        }

        public Criteria andWechatTradeNoNotEqualTo(String value) {
            addCriterion("wechat_trade_no <>", value, "wechatTradeNo");
            return (Criteria) this;
        }

        public Criteria andWechatTradeNoGreaterThan(String value) {
            addCriterion("wechat_trade_no >", value, "wechatTradeNo");
            return (Criteria) this;
        }

        public Criteria andWechatTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_trade_no >=", value, "wechatTradeNo");
            return (Criteria) this;
        }

        public Criteria andWechatTradeNoLessThan(String value) {
            addCriterion("wechat_trade_no <", value, "wechatTradeNo");
            return (Criteria) this;
        }

        public Criteria andWechatTradeNoLessThanOrEqualTo(String value) {
            addCriterion("wechat_trade_no <=", value, "wechatTradeNo");
            return (Criteria) this;
        }

        public Criteria andWechatTradeNoLike(String value) {
            addCriterion("wechat_trade_no like", value, "wechatTradeNo");
            return (Criteria) this;
        }

        public Criteria andWechatTradeNoNotLike(String value) {
            addCriterion("wechat_trade_no not like", value, "wechatTradeNo");
            return (Criteria) this;
        }

        public Criteria andWechatTradeNoIn(List<String> values) {
            addCriterion("wechat_trade_no in", values, "wechatTradeNo");
            return (Criteria) this;
        }

        public Criteria andWechatTradeNoNotIn(List<String> values) {
            addCriterion("wechat_trade_no not in", values, "wechatTradeNo");
            return (Criteria) this;
        }

        public Criteria andWechatTradeNoBetween(String value1, String value2) {
            addCriterion("wechat_trade_no between", value1, value2, "wechatTradeNo");
            return (Criteria) this;
        }

        public Criteria andWechatTradeNoNotBetween(String value1, String value2) {
            addCriterion("wechat_trade_no not between", value1, value2, "wechatTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoIsNull() {
            addCriterion("alipay_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoIsNotNull() {
            addCriterion("alipay_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoEqualTo(String value) {
            addCriterion("alipay_trade_no =", value, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoNotEqualTo(String value) {
            addCriterion("alipay_trade_no <>", value, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoGreaterThan(String value) {
            addCriterion("alipay_trade_no >", value, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_trade_no >=", value, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoLessThan(String value) {
            addCriterion("alipay_trade_no <", value, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoLessThanOrEqualTo(String value) {
            addCriterion("alipay_trade_no <=", value, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoLike(String value) {
            addCriterion("alipay_trade_no like", value, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoNotLike(String value) {
            addCriterion("alipay_trade_no not like", value, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoIn(List<String> values) {
            addCriterion("alipay_trade_no in", values, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoNotIn(List<String> values) {
            addCriterion("alipay_trade_no not in", values, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoBetween(String value1, String value2) {
            addCriterion("alipay_trade_no between", value1, value2, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoNotBetween(String value1, String value2) {
            addCriterion("alipay_trade_no not between", value1, value2, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("total_fee is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("total_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(BigDecimal value) {
            addCriterion("total_fee =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(BigDecimal value) {
            addCriterion("total_fee <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(BigDecimal value) {
            addCriterion("total_fee >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_fee >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(BigDecimal value) {
            addCriterion("total_fee <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_fee <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<BigDecimal> values) {
            addCriterion("total_fee in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<BigDecimal> values) {
            addCriterion("total_fee not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_fee between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_fee not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTakeWaterIsNull() {
            addCriterion("take_water is null");
            return (Criteria) this;
        }

        public Criteria andTakeWaterIsNotNull() {
            addCriterion("take_water is not null");
            return (Criteria) this;
        }

        public Criteria andTakeWaterEqualTo(Integer value) {
            addCriterion("take_water =", value, "takeWater");
            return (Criteria) this;
        }

        public Criteria andTakeWaterNotEqualTo(Integer value) {
            addCriterion("take_water <>", value, "takeWater");
            return (Criteria) this;
        }

        public Criteria andTakeWaterGreaterThan(Integer value) {
            addCriterion("take_water >", value, "takeWater");
            return (Criteria) this;
        }

        public Criteria andTakeWaterGreaterThanOrEqualTo(Integer value) {
            addCriterion("take_water >=", value, "takeWater");
            return (Criteria) this;
        }

        public Criteria andTakeWaterLessThan(Integer value) {
            addCriterion("take_water <", value, "takeWater");
            return (Criteria) this;
        }

        public Criteria andTakeWaterLessThanOrEqualTo(Integer value) {
            addCriterion("take_water <=", value, "takeWater");
            return (Criteria) this;
        }

        public Criteria andTakeWaterIn(List<Integer> values) {
            addCriterion("take_water in", values, "takeWater");
            return (Criteria) this;
        }

        public Criteria andTakeWaterNotIn(List<Integer> values) {
            addCriterion("take_water not in", values, "takeWater");
            return (Criteria) this;
        }

        public Criteria andTakeWaterBetween(Integer value1, Integer value2) {
            addCriterion("take_water between", value1, value2, "takeWater");
            return (Criteria) this;
        }

        public Criteria andTakeWaterNotBetween(Integer value1, Integer value2) {
            addCriterion("take_water not between", value1, value2, "takeWater");
            return (Criteria) this;
        }

        public Criteria andTakeWaterTimeIsNull() {
            addCriterion("take_water_time is null");
            return (Criteria) this;
        }

        public Criteria andTakeWaterTimeIsNotNull() {
            addCriterion("take_water_time is not null");
            return (Criteria) this;
        }

        public Criteria andTakeWaterTimeEqualTo(Date value) {
            addCriterion("take_water_time =", value, "takeWaterTime");
            return (Criteria) this;
        }

        public Criteria andTakeWaterTimeNotEqualTo(Date value) {
            addCriterion("take_water_time <>", value, "takeWaterTime");
            return (Criteria) this;
        }

        public Criteria andTakeWaterTimeGreaterThan(Date value) {
            addCriterion("take_water_time >", value, "takeWaterTime");
            return (Criteria) this;
        }

        public Criteria andTakeWaterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("take_water_time >=", value, "takeWaterTime");
            return (Criteria) this;
        }

        public Criteria andTakeWaterTimeLessThan(Date value) {
            addCriterion("take_water_time <", value, "takeWaterTime");
            return (Criteria) this;
        }

        public Criteria andTakeWaterTimeLessThanOrEqualTo(Date value) {
            addCriterion("take_water_time <=", value, "takeWaterTime");
            return (Criteria) this;
        }

        public Criteria andTakeWaterTimeIn(List<Date> values) {
            addCriterion("take_water_time in", values, "takeWaterTime");
            return (Criteria) this;
        }

        public Criteria andTakeWaterTimeNotIn(List<Date> values) {
            addCriterion("take_water_time not in", values, "takeWaterTime");
            return (Criteria) this;
        }

        public Criteria andTakeWaterTimeBetween(Date value1, Date value2) {
            addCriterion("take_water_time between", value1, value2, "takeWaterTime");
            return (Criteria) this;
        }

        public Criteria andTakeWaterTimeNotBetween(Date value1, Date value2) {
            addCriterion("take_water_time not between", value1, value2, "takeWaterTime");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketIsNull() {
            addCriterion("receipt_ticket is null");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketIsNotNull() {
            addCriterion("receipt_ticket is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketEqualTo(Integer value) {
            addCriterion("receipt_ticket =", value, "receiptTicket");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketNotEqualTo(Integer value) {
            addCriterion("receipt_ticket <>", value, "receiptTicket");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketGreaterThan(Integer value) {
            addCriterion("receipt_ticket >", value, "receiptTicket");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketGreaterThanOrEqualTo(Integer value) {
            addCriterion("receipt_ticket >=", value, "receiptTicket");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketLessThan(Integer value) {
            addCriterion("receipt_ticket <", value, "receiptTicket");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketLessThanOrEqualTo(Integer value) {
            addCriterion("receipt_ticket <=", value, "receiptTicket");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketIn(List<Integer> values) {
            addCriterion("receipt_ticket in", values, "receiptTicket");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketNotIn(List<Integer> values) {
            addCriterion("receipt_ticket not in", values, "receiptTicket");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketBetween(Integer value1, Integer value2) {
            addCriterion("receipt_ticket between", value1, value2, "receiptTicket");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketNotBetween(Integer value1, Integer value2) {
            addCriterion("receipt_ticket not between", value1, value2, "receiptTicket");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketTimeIsNull() {
            addCriterion("receipt_ticket_time is null");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketTimeIsNotNull() {
            addCriterion("receipt_ticket_time is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketTimeEqualTo(Date value) {
            addCriterion("receipt_ticket_time =", value, "receiptTicketTime");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketTimeNotEqualTo(Date value) {
            addCriterion("receipt_ticket_time <>", value, "receiptTicketTime");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketTimeGreaterThan(Date value) {
            addCriterion("receipt_ticket_time >", value, "receiptTicketTime");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("receipt_ticket_time >=", value, "receiptTicketTime");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketTimeLessThan(Date value) {
            addCriterion("receipt_ticket_time <", value, "receiptTicketTime");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketTimeLessThanOrEqualTo(Date value) {
            addCriterion("receipt_ticket_time <=", value, "receiptTicketTime");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketTimeIn(List<Date> values) {
            addCriterion("receipt_ticket_time in", values, "receiptTicketTime");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketTimeNotIn(List<Date> values) {
            addCriterion("receipt_ticket_time not in", values, "receiptTicketTime");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketTimeBetween(Date value1, Date value2) {
            addCriterion("receipt_ticket_time between", value1, value2, "receiptTicketTime");
            return (Criteria) this;
        }

        public Criteria andReceiptTicketTimeNotBetween(Date value1, Date value2) {
            addCriterion("receipt_ticket_time not between", value1, value2, "receiptTicketTime");
            return (Criteria) this;
        }

        public Criteria andIssueTicketIsNull() {
            addCriterion("issue_ticket is null");
            return (Criteria) this;
        }

        public Criteria andIssueTicketIsNotNull() {
            addCriterion("issue_ticket is not null");
            return (Criteria) this;
        }

        public Criteria andIssueTicketEqualTo(Integer value) {
            addCriterion("issue_ticket =", value, "issueTicket");
            return (Criteria) this;
        }

        public Criteria andIssueTicketNotEqualTo(Integer value) {
            addCriterion("issue_ticket <>", value, "issueTicket");
            return (Criteria) this;
        }

        public Criteria andIssueTicketGreaterThan(Integer value) {
            addCriterion("issue_ticket >", value, "issueTicket");
            return (Criteria) this;
        }

        public Criteria andIssueTicketGreaterThanOrEqualTo(Integer value) {
            addCriterion("issue_ticket >=", value, "issueTicket");
            return (Criteria) this;
        }

        public Criteria andIssueTicketLessThan(Integer value) {
            addCriterion("issue_ticket <", value, "issueTicket");
            return (Criteria) this;
        }

        public Criteria andIssueTicketLessThanOrEqualTo(Integer value) {
            addCriterion("issue_ticket <=", value, "issueTicket");
            return (Criteria) this;
        }

        public Criteria andIssueTicketIn(List<Integer> values) {
            addCriterion("issue_ticket in", values, "issueTicket");
            return (Criteria) this;
        }

        public Criteria andIssueTicketNotIn(List<Integer> values) {
            addCriterion("issue_ticket not in", values, "issueTicket");
            return (Criteria) this;
        }

        public Criteria andIssueTicketBetween(Integer value1, Integer value2) {
            addCriterion("issue_ticket between", value1, value2, "issueTicket");
            return (Criteria) this;
        }

        public Criteria andIssueTicketNotBetween(Integer value1, Integer value2) {
            addCriterion("issue_ticket not between", value1, value2, "issueTicket");
            return (Criteria) this;
        }

        public Criteria andIssueTicketTimeIsNull() {
            addCriterion("issue_ticket_time is null");
            return (Criteria) this;
        }

        public Criteria andIssueTicketTimeIsNotNull() {
            addCriterion("issue_ticket_time is not null");
            return (Criteria) this;
        }

        public Criteria andIssueTicketTimeEqualTo(Date value) {
            addCriterion("issue_ticket_time =", value, "issueTicketTime");
            return (Criteria) this;
        }

        public Criteria andIssueTicketTimeNotEqualTo(Date value) {
            addCriterion("issue_ticket_time <>", value, "issueTicketTime");
            return (Criteria) this;
        }

        public Criteria andIssueTicketTimeGreaterThan(Date value) {
            addCriterion("issue_ticket_time >", value, "issueTicketTime");
            return (Criteria) this;
        }

        public Criteria andIssueTicketTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("issue_ticket_time >=", value, "issueTicketTime");
            return (Criteria) this;
        }

        public Criteria andIssueTicketTimeLessThan(Date value) {
            addCriterion("issue_ticket_time <", value, "issueTicketTime");
            return (Criteria) this;
        }

        public Criteria andIssueTicketTimeLessThanOrEqualTo(Date value) {
            addCriterion("issue_ticket_time <=", value, "issueTicketTime");
            return (Criteria) this;
        }

        public Criteria andIssueTicketTimeIn(List<Date> values) {
            addCriterion("issue_ticket_time in", values, "issueTicketTime");
            return (Criteria) this;
        }

        public Criteria andIssueTicketTimeNotIn(List<Date> values) {
            addCriterion("issue_ticket_time not in", values, "issueTicketTime");
            return (Criteria) this;
        }

        public Criteria andIssueTicketTimeBetween(Date value1, Date value2) {
            addCriterion("issue_ticket_time between", value1, value2, "issueTicketTime");
            return (Criteria) this;
        }

        public Criteria andIssueTicketTimeNotBetween(Date value1, Date value2) {
            addCriterion("issue_ticket_time not between", value1, value2, "issueTicketTime");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNull() {
            addCriterion("staff_name is null");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNotNull() {
            addCriterion("staff_name is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNameEqualTo(String value) {
            addCriterion("staff_name =", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotEqualTo(String value) {
            addCriterion("staff_name <>", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThan(String value) {
            addCriterion("staff_name >", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("staff_name >=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThan(String value) {
            addCriterion("staff_name <", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThanOrEqualTo(String value) {
            addCriterion("staff_name <=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLike(String value) {
            addCriterion("staff_name like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotLike(String value) {
            addCriterion("staff_name not like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameIn(List<String> values) {
            addCriterion("staff_name in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotIn(List<String> values) {
            addCriterion("staff_name not in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameBetween(String value1, String value2) {
            addCriterion("staff_name between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotBetween(String value1, String value2) {
            addCriterion("staff_name not between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneIsNull() {
            addCriterion("staff_phone is null");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneIsNotNull() {
            addCriterion("staff_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneEqualTo(String value) {
            addCriterion("staff_phone =", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotEqualTo(String value) {
            addCriterion("staff_phone <>", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneGreaterThan(String value) {
            addCriterion("staff_phone >", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("staff_phone >=", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneLessThan(String value) {
            addCriterion("staff_phone <", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneLessThanOrEqualTo(String value) {
            addCriterion("staff_phone <=", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneLike(String value) {
            addCriterion("staff_phone like", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotLike(String value) {
            addCriterion("staff_phone not like", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneIn(List<String> values) {
            addCriterion("staff_phone in", values, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotIn(List<String> values) {
            addCriterion("staff_phone not in", values, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneBetween(String value1, String value2) {
            addCriterion("staff_phone between", value1, value2, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotBetween(String value1, String value2) {
            addCriterion("staff_phone not between", value1, value2, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andOrderWaterIsNull() {
            addCriterion("order_water is null");
            return (Criteria) this;
        }

        public Criteria andOrderWaterIsNotNull() {
            addCriterion("order_water is not null");
            return (Criteria) this;
        }

        public Criteria andOrderWaterEqualTo(Integer value) {
            addCriterion("order_water =", value, "orderWater");
            return (Criteria) this;
        }

        public Criteria andOrderWaterNotEqualTo(Integer value) {
            addCriterion("order_water <>", value, "orderWater");
            return (Criteria) this;
        }

        public Criteria andOrderWaterGreaterThan(Integer value) {
            addCriterion("order_water >", value, "orderWater");
            return (Criteria) this;
        }

        public Criteria andOrderWaterGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_water >=", value, "orderWater");
            return (Criteria) this;
        }

        public Criteria andOrderWaterLessThan(Integer value) {
            addCriterion("order_water <", value, "orderWater");
            return (Criteria) this;
        }

        public Criteria andOrderWaterLessThanOrEqualTo(Integer value) {
            addCriterion("order_water <=", value, "orderWater");
            return (Criteria) this;
        }

        public Criteria andOrderWaterIn(List<Integer> values) {
            addCriterion("order_water in", values, "orderWater");
            return (Criteria) this;
        }

        public Criteria andOrderWaterNotIn(List<Integer> values) {
            addCriterion("order_water not in", values, "orderWater");
            return (Criteria) this;
        }

        public Criteria andOrderWaterBetween(Integer value1, Integer value2) {
            addCriterion("order_water between", value1, value2, "orderWater");
            return (Criteria) this;
        }

        public Criteria andOrderWaterNotBetween(Integer value1, Integer value2) {
            addCriterion("order_water not between", value1, value2, "orderWater");
            return (Criteria) this;
        }

        public Criteria andOrderWaterNumIsNull() {
            addCriterion("order_water_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderWaterNumIsNotNull() {
            addCriterion("order_water_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderWaterNumEqualTo(Integer value) {
            addCriterion("order_water_num =", value, "orderWaterNum");
            return (Criteria) this;
        }

        public Criteria andOrderWaterNumNotEqualTo(Integer value) {
            addCriterion("order_water_num <>", value, "orderWaterNum");
            return (Criteria) this;
        }

        public Criteria andOrderWaterNumGreaterThan(Integer value) {
            addCriterion("order_water_num >", value, "orderWaterNum");
            return (Criteria) this;
        }

        public Criteria andOrderWaterNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_water_num >=", value, "orderWaterNum");
            return (Criteria) this;
        }

        public Criteria andOrderWaterNumLessThan(Integer value) {
            addCriterion("order_water_num <", value, "orderWaterNum");
            return (Criteria) this;
        }

        public Criteria andOrderWaterNumLessThanOrEqualTo(Integer value) {
            addCriterion("order_water_num <=", value, "orderWaterNum");
            return (Criteria) this;
        }

        public Criteria andOrderWaterNumIn(List<Integer> values) {
            addCriterion("order_water_num in", values, "orderWaterNum");
            return (Criteria) this;
        }

        public Criteria andOrderWaterNumNotIn(List<Integer> values) {
            addCriterion("order_water_num not in", values, "orderWaterNum");
            return (Criteria) this;
        }

        public Criteria andOrderWaterNumBetween(Integer value1, Integer value2) {
            addCriterion("order_water_num between", value1, value2, "orderWaterNum");
            return (Criteria) this;
        }

        public Criteria andOrderWaterNumNotBetween(Integer value1, Integer value2) {
            addCriterion("order_water_num not between", value1, value2, "orderWaterNum");
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

        public Criteria andRfpayAccountIsNull() {
            addCriterion("rfpay_account is null");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountIsNotNull() {
            addCriterion("rfpay_account is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountEqualTo(String value) {
            addCriterion("rfpay_account =", value, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountNotEqualTo(String value) {
            addCriterion("rfpay_account <>", value, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountGreaterThan(String value) {
            addCriterion("rfpay_account >", value, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountGreaterThanOrEqualTo(String value) {
            addCriterion("rfpay_account >=", value, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountLessThan(String value) {
            addCriterion("rfpay_account <", value, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountLessThanOrEqualTo(String value) {
            addCriterion("rfpay_account <=", value, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountLike(String value) {
            addCriterion("rfpay_account like", value, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountNotLike(String value) {
            addCriterion("rfpay_account not like", value, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountIn(List<String> values) {
            addCriterion("rfpay_account in", values, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountNotIn(List<String> values) {
            addCriterion("rfpay_account not in", values, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountBetween(String value1, String value2) {
            addCriterion("rfpay_account between", value1, value2, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayAccountNotBetween(String value1, String value2) {
            addCriterion("rfpay_account not between", value1, value2, "rfpayAccount");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateIsNull() {
            addCriterion("rfpay_fee_rate is null");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateIsNotNull() {
            addCriterion("rfpay_fee_rate is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateEqualTo(BigDecimal value) {
            addCriterion("rfpay_fee_rate =", value, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateNotEqualTo(BigDecimal value) {
            addCriterion("rfpay_fee_rate <>", value, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateGreaterThan(BigDecimal value) {
            addCriterion("rfpay_fee_rate >", value, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rfpay_fee_rate >=", value, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateLessThan(BigDecimal value) {
            addCriterion("rfpay_fee_rate <", value, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rfpay_fee_rate <=", value, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateIn(List<BigDecimal> values) {
            addCriterion("rfpay_fee_rate in", values, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateNotIn(List<BigDecimal> values) {
            addCriterion("rfpay_fee_rate not in", values, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rfpay_fee_rate between", value1, value2, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayFeeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rfpay_fee_rate not between", value1, value2, "rfpayFeeRate");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeIsNull() {
            addCriterion("rfpay_clearing_fee is null");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeIsNotNull() {
            addCriterion("rfpay_clearing_fee is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeEqualTo(BigDecimal value) {
            addCriterion("rfpay_clearing_fee =", value, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeNotEqualTo(BigDecimal value) {
            addCriterion("rfpay_clearing_fee <>", value, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeGreaterThan(BigDecimal value) {
            addCriterion("rfpay_clearing_fee >", value, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rfpay_clearing_fee >=", value, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeLessThan(BigDecimal value) {
            addCriterion("rfpay_clearing_fee <", value, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rfpay_clearing_fee <=", value, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeIn(List<BigDecimal> values) {
            addCriterion("rfpay_clearing_fee in", values, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeNotIn(List<BigDecimal> values) {
            addCriterion("rfpay_clearing_fee not in", values, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rfpay_clearing_fee between", value1, value2, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayClearingFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rfpay_clearing_fee not between", value1, value2, "rfpayClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeIsNull() {
            addCriterion("rfpay_actual_clearing_fee is null");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeIsNotNull() {
            addCriterion("rfpay_actual_clearing_fee is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeEqualTo(Long value) {
            addCriterion("rfpay_actual_clearing_fee =", value, "rfpayActualClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeNotEqualTo(Long value) {
            addCriterion("rfpay_actual_clearing_fee <>", value, "rfpayActualClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeGreaterThan(Long value) {
            addCriterion("rfpay_actual_clearing_fee >", value, "rfpayActualClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("rfpay_actual_clearing_fee >=", value, "rfpayActualClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeLessThan(Long value) {
            addCriterion("rfpay_actual_clearing_fee <", value, "rfpayActualClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeLessThanOrEqualTo(Long value) {
            addCriterion("rfpay_actual_clearing_fee <=", value, "rfpayActualClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeIn(List<Long> values) {
            addCriterion("rfpay_actual_clearing_fee in", values, "rfpayActualClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeNotIn(List<Long> values) {
            addCriterion("rfpay_actual_clearing_fee not in", values, "rfpayActualClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeBetween(Long value1, Long value2) {
            addCriterion("rfpay_actual_clearing_fee between", value1, value2, "rfpayActualClearingFee");
            return (Criteria) this;
        }

        public Criteria andRfpayActualClearingFeeNotBetween(Long value1, Long value2) {
            addCriterion("rfpay_actual_clearing_fee not between", value1, value2, "rfpayActualClearingFee");
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

        public Criteria andDeleteStatusIsNull() {
            addCriterion("delete_status is null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIsNotNull() {
            addCriterion("delete_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusEqualTo(Integer value) {
            addCriterion("delete_status =", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotEqualTo(Integer value) {
            addCriterion("delete_status <>", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThan(Integer value) {
            addCriterion("delete_status >", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_status >=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThan(Integer value) {
            addCriterion("delete_status <", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThanOrEqualTo(Integer value) {
            addCriterion("delete_status <=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIn(List<Integer> values) {
            addCriterion("delete_status in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotIn(List<Integer> values) {
            addCriterion("delete_status not in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusBetween(Integer value1, Integer value2) {
            addCriterion("delete_status between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_status not between", value1, value2, "deleteStatus");
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