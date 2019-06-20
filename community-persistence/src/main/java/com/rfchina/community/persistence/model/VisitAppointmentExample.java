package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VisitAppointmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VisitAppointmentExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andMasterIdIsNull() {
            addCriterion("master_id is null");
            return (Criteria) this;
        }

        public Criteria andMasterIdIsNotNull() {
            addCriterion("master_id is not null");
            return (Criteria) this;
        }

        public Criteria andMasterIdEqualTo(Long value) {
            addCriterion("master_id =", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotEqualTo(Long value) {
            addCriterion("master_id <>", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdGreaterThan(Long value) {
            addCriterion("master_id >", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("master_id >=", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLessThan(Long value) {
            addCriterion("master_id <", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLessThanOrEqualTo(Long value) {
            addCriterion("master_id <=", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdIn(List<Long> values) {
            addCriterion("master_id in", values, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotIn(List<Long> values) {
            addCriterion("master_id not in", values, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdBetween(Long value1, Long value2) {
            addCriterion("master_id between", value1, value2, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotBetween(Long value1, Long value2) {
            addCriterion("master_id not between", value1, value2, "masterId");
            return (Criteria) this;
        }

        public Criteria andVisitorIsNull() {
            addCriterion("visitor is null");
            return (Criteria) this;
        }

        public Criteria andVisitorIsNotNull() {
            addCriterion("visitor is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorEqualTo(String value) {
            addCriterion("visitor =", value, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorNotEqualTo(String value) {
            addCriterion("visitor <>", value, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorGreaterThan(String value) {
            addCriterion("visitor >", value, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorGreaterThanOrEqualTo(String value) {
            addCriterion("visitor >=", value, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorLessThan(String value) {
            addCriterion("visitor <", value, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorLessThanOrEqualTo(String value) {
            addCriterion("visitor <=", value, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorLike(String value) {
            addCriterion("visitor like", value, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorNotLike(String value) {
            addCriterion("visitor not like", value, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorIn(List<String> values) {
            addCriterion("visitor in", values, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorNotIn(List<String> values) {
            addCriterion("visitor not in", values, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorBetween(String value1, String value2) {
            addCriterion("visitor between", value1, value2, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorNotBetween(String value1, String value2) {
            addCriterion("visitor not between", value1, value2, "visitor");
            return (Criteria) this;
        }

        public Criteria andVisitorPhoneIsNull() {
            addCriterion("visitor_phone is null");
            return (Criteria) this;
        }

        public Criteria andVisitorPhoneIsNotNull() {
            addCriterion("visitor_phone is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorPhoneEqualTo(String value) {
            addCriterion("visitor_phone =", value, "visitorPhone");
            return (Criteria) this;
        }

        public Criteria andVisitorPhoneNotEqualTo(String value) {
            addCriterion("visitor_phone <>", value, "visitorPhone");
            return (Criteria) this;
        }

        public Criteria andVisitorPhoneGreaterThan(String value) {
            addCriterion("visitor_phone >", value, "visitorPhone");
            return (Criteria) this;
        }

        public Criteria andVisitorPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("visitor_phone >=", value, "visitorPhone");
            return (Criteria) this;
        }

        public Criteria andVisitorPhoneLessThan(String value) {
            addCriterion("visitor_phone <", value, "visitorPhone");
            return (Criteria) this;
        }

        public Criteria andVisitorPhoneLessThanOrEqualTo(String value) {
            addCriterion("visitor_phone <=", value, "visitorPhone");
            return (Criteria) this;
        }

        public Criteria andVisitorPhoneLike(String value) {
            addCriterion("visitor_phone like", value, "visitorPhone");
            return (Criteria) this;
        }

        public Criteria andVisitorPhoneNotLike(String value) {
            addCriterion("visitor_phone not like", value, "visitorPhone");
            return (Criteria) this;
        }

        public Criteria andVisitorPhoneIn(List<String> values) {
            addCriterion("visitor_phone in", values, "visitorPhone");
            return (Criteria) this;
        }

        public Criteria andVisitorPhoneNotIn(List<String> values) {
            addCriterion("visitor_phone not in", values, "visitorPhone");
            return (Criteria) this;
        }

        public Criteria andVisitorPhoneBetween(String value1, String value2) {
            addCriterion("visitor_phone between", value1, value2, "visitorPhone");
            return (Criteria) this;
        }

        public Criteria andVisitorPhoneNotBetween(String value1, String value2) {
            addCriterion("visitor_phone not between", value1, value2, "visitorPhone");
            return (Criteria) this;
        }

        public Criteria andVisitorUidIsNull() {
            addCriterion("visitor_uid is null");
            return (Criteria) this;
        }

        public Criteria andVisitorUidIsNotNull() {
            addCriterion("visitor_uid is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorUidEqualTo(Long value) {
            addCriterion("visitor_uid =", value, "visitorUid");
            return (Criteria) this;
        }

        public Criteria andVisitorUidNotEqualTo(Long value) {
            addCriterion("visitor_uid <>", value, "visitorUid");
            return (Criteria) this;
        }

        public Criteria andVisitorUidGreaterThan(Long value) {
            addCriterion("visitor_uid >", value, "visitorUid");
            return (Criteria) this;
        }

        public Criteria andVisitorUidGreaterThanOrEqualTo(Long value) {
            addCriterion("visitor_uid >=", value, "visitorUid");
            return (Criteria) this;
        }

        public Criteria andVisitorUidLessThan(Long value) {
            addCriterion("visitor_uid <", value, "visitorUid");
            return (Criteria) this;
        }

        public Criteria andVisitorUidLessThanOrEqualTo(Long value) {
            addCriterion("visitor_uid <=", value, "visitorUid");
            return (Criteria) this;
        }

        public Criteria andVisitorUidIn(List<Long> values) {
            addCriterion("visitor_uid in", values, "visitorUid");
            return (Criteria) this;
        }

        public Criteria andVisitorUidNotIn(List<Long> values) {
            addCriterion("visitor_uid not in", values, "visitorUid");
            return (Criteria) this;
        }

        public Criteria andVisitorUidBetween(Long value1, Long value2) {
            addCriterion("visitor_uid between", value1, value2, "visitorUid");
            return (Criteria) this;
        }

        public Criteria andVisitorUidNotBetween(Long value1, Long value2) {
            addCriterion("visitor_uid not between", value1, value2, "visitorUid");
            return (Criteria) this;
        }

        public Criteria andVisitorReadStatusIsNull() {
            addCriterion("visitor_read_status is null");
            return (Criteria) this;
        }

        public Criteria andVisitorReadStatusIsNotNull() {
            addCriterion("visitor_read_status is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorReadStatusEqualTo(Integer value) {
            addCriterion("visitor_read_status =", value, "visitorReadStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorReadStatusNotEqualTo(Integer value) {
            addCriterion("visitor_read_status <>", value, "visitorReadStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorReadStatusGreaterThan(Integer value) {
            addCriterion("visitor_read_status >", value, "visitorReadStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorReadStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("visitor_read_status >=", value, "visitorReadStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorReadStatusLessThan(Integer value) {
            addCriterion("visitor_read_status <", value, "visitorReadStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorReadStatusLessThanOrEqualTo(Integer value) {
            addCriterion("visitor_read_status <=", value, "visitorReadStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorReadStatusIn(List<Integer> values) {
            addCriterion("visitor_read_status in", values, "visitorReadStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorReadStatusNotIn(List<Integer> values) {
            addCriterion("visitor_read_status not in", values, "visitorReadStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorReadStatusBetween(Integer value1, Integer value2) {
            addCriterion("visitor_read_status between", value1, value2, "visitorReadStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorReadStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("visitor_read_status not between", value1, value2, "visitorReadStatus");
            return (Criteria) this;
        }

        public Criteria andFollowQtyIsNull() {
            addCriterion("follow_qty is null");
            return (Criteria) this;
        }

        public Criteria andFollowQtyIsNotNull() {
            addCriterion("follow_qty is not null");
            return (Criteria) this;
        }

        public Criteria andFollowQtyEqualTo(Integer value) {
            addCriterion("follow_qty =", value, "followQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyNotEqualTo(Integer value) {
            addCriterion("follow_qty <>", value, "followQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyGreaterThan(Integer value) {
            addCriterion("follow_qty >", value, "followQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("follow_qty >=", value, "followQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyLessThan(Integer value) {
            addCriterion("follow_qty <", value, "followQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyLessThanOrEqualTo(Integer value) {
            addCriterion("follow_qty <=", value, "followQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyIn(List<Integer> values) {
            addCriterion("follow_qty in", values, "followQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyNotIn(List<Integer> values) {
            addCriterion("follow_qty not in", values, "followQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyBetween(Integer value1, Integer value2) {
            addCriterion("follow_qty between", value1, value2, "followQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("follow_qty not between", value1, value2, "followQty");
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

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Integer value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Integer value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Integer value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Integer value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Integer value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Integer> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Integer> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Integer value1, Integer value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andCreateUidIsNull() {
            addCriterion("create_uid is null");
            return (Criteria) this;
        }

        public Criteria andCreateUidIsNotNull() {
            addCriterion("create_uid is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUidEqualTo(Long value) {
            addCriterion("create_uid =", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidNotEqualTo(Long value) {
            addCriterion("create_uid <>", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidGreaterThan(Long value) {
            addCriterion("create_uid >", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidGreaterThanOrEqualTo(Long value) {
            addCriterion("create_uid >=", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidLessThan(Long value) {
            addCriterion("create_uid <", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidLessThanOrEqualTo(Long value) {
            addCriterion("create_uid <=", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidIn(List<Long> values) {
            addCriterion("create_uid in", values, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidNotIn(List<Long> values) {
            addCriterion("create_uid not in", values, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidBetween(Long value1, Long value2) {
            addCriterion("create_uid between", value1, value2, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidNotBetween(Long value1, Long value2) {
            addCriterion("create_uid not between", value1, value2, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateIsNull() {
            addCriterion("appointment_date is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateIsNotNull() {
            addCriterion("appointment_date is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateEqualTo(Date value) {
            addCriterionForJDBCDate("appointment_date =", value, "appointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("appointment_date <>", value, "appointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateGreaterThan(Date value) {
            addCriterionForJDBCDate("appointment_date >", value, "appointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("appointment_date >=", value, "appointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateLessThan(Date value) {
            addCriterionForJDBCDate("appointment_date <", value, "appointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("appointment_date <=", value, "appointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateIn(List<Date> values) {
            addCriterionForJDBCDate("appointment_date in", values, "appointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("appointment_date not in", values, "appointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("appointment_date between", value1, value2, "appointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("appointment_date not between", value1, value2, "appointmentDate");
            return (Criteria) this;
        }

        public Criteria andMasterAuditStatusIsNull() {
            addCriterion("master_audit_status is null");
            return (Criteria) this;
        }

        public Criteria andMasterAuditStatusIsNotNull() {
            addCriterion("master_audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andMasterAuditStatusEqualTo(Integer value) {
            addCriterion("master_audit_status =", value, "masterAuditStatus");
            return (Criteria) this;
        }

        public Criteria andMasterAuditStatusNotEqualTo(Integer value) {
            addCriterion("master_audit_status <>", value, "masterAuditStatus");
            return (Criteria) this;
        }

        public Criteria andMasterAuditStatusGreaterThan(Integer value) {
            addCriterion("master_audit_status >", value, "masterAuditStatus");
            return (Criteria) this;
        }

        public Criteria andMasterAuditStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("master_audit_status >=", value, "masterAuditStatus");
            return (Criteria) this;
        }

        public Criteria andMasterAuditStatusLessThan(Integer value) {
            addCriterion("master_audit_status <", value, "masterAuditStatus");
            return (Criteria) this;
        }

        public Criteria andMasterAuditStatusLessThanOrEqualTo(Integer value) {
            addCriterion("master_audit_status <=", value, "masterAuditStatus");
            return (Criteria) this;
        }

        public Criteria andMasterAuditStatusIn(List<Integer> values) {
            addCriterion("master_audit_status in", values, "masterAuditStatus");
            return (Criteria) this;
        }

        public Criteria andMasterAuditStatusNotIn(List<Integer> values) {
            addCriterion("master_audit_status not in", values, "masterAuditStatus");
            return (Criteria) this;
        }

        public Criteria andMasterAuditStatusBetween(Integer value1, Integer value2) {
            addCriterion("master_audit_status between", value1, value2, "masterAuditStatus");
            return (Criteria) this;
        }

        public Criteria andMasterAuditStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("master_audit_status not between", value1, value2, "masterAuditStatus");
            return (Criteria) this;
        }

        public Criteria andMasterAuditTimeIsNull() {
            addCriterion("master_audit_time is null");
            return (Criteria) this;
        }

        public Criteria andMasterAuditTimeIsNotNull() {
            addCriterion("master_audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andMasterAuditTimeEqualTo(Date value) {
            addCriterion("master_audit_time =", value, "masterAuditTime");
            return (Criteria) this;
        }

        public Criteria andMasterAuditTimeNotEqualTo(Date value) {
            addCriterion("master_audit_time <>", value, "masterAuditTime");
            return (Criteria) this;
        }

        public Criteria andMasterAuditTimeGreaterThan(Date value) {
            addCriterion("master_audit_time >", value, "masterAuditTime");
            return (Criteria) this;
        }

        public Criteria andMasterAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("master_audit_time >=", value, "masterAuditTime");
            return (Criteria) this;
        }

        public Criteria andMasterAuditTimeLessThan(Date value) {
            addCriterion("master_audit_time <", value, "masterAuditTime");
            return (Criteria) this;
        }

        public Criteria andMasterAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("master_audit_time <=", value, "masterAuditTime");
            return (Criteria) this;
        }

        public Criteria andMasterAuditTimeIn(List<Date> values) {
            addCriterion("master_audit_time in", values, "masterAuditTime");
            return (Criteria) this;
        }

        public Criteria andMasterAuditTimeNotIn(List<Date> values) {
            addCriterion("master_audit_time not in", values, "masterAuditTime");
            return (Criteria) this;
        }

        public Criteria andMasterAuditTimeBetween(Date value1, Date value2) {
            addCriterion("master_audit_time between", value1, value2, "masterAuditTime");
            return (Criteria) this;
        }

        public Criteria andMasterAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("master_audit_time not between", value1, value2, "masterAuditTime");
            return (Criteria) this;
        }

        public Criteria andMasterAuditUidIsNull() {
            addCriterion("master_audit_uid is null");
            return (Criteria) this;
        }

        public Criteria andMasterAuditUidIsNotNull() {
            addCriterion("master_audit_uid is not null");
            return (Criteria) this;
        }

        public Criteria andMasterAuditUidEqualTo(Long value) {
            addCriterion("master_audit_uid =", value, "masterAuditUid");
            return (Criteria) this;
        }

        public Criteria andMasterAuditUidNotEqualTo(Long value) {
            addCriterion("master_audit_uid <>", value, "masterAuditUid");
            return (Criteria) this;
        }

        public Criteria andMasterAuditUidGreaterThan(Long value) {
            addCriterion("master_audit_uid >", value, "masterAuditUid");
            return (Criteria) this;
        }

        public Criteria andMasterAuditUidGreaterThanOrEqualTo(Long value) {
            addCriterion("master_audit_uid >=", value, "masterAuditUid");
            return (Criteria) this;
        }

        public Criteria andMasterAuditUidLessThan(Long value) {
            addCriterion("master_audit_uid <", value, "masterAuditUid");
            return (Criteria) this;
        }

        public Criteria andMasterAuditUidLessThanOrEqualTo(Long value) {
            addCriterion("master_audit_uid <=", value, "masterAuditUid");
            return (Criteria) this;
        }

        public Criteria andMasterAuditUidIn(List<Long> values) {
            addCriterion("master_audit_uid in", values, "masterAuditUid");
            return (Criteria) this;
        }

        public Criteria andMasterAuditUidNotIn(List<Long> values) {
            addCriterion("master_audit_uid not in", values, "masterAuditUid");
            return (Criteria) this;
        }

        public Criteria andMasterAuditUidBetween(Long value1, Long value2) {
            addCriterion("master_audit_uid between", value1, value2, "masterAuditUid");
            return (Criteria) this;
        }

        public Criteria andMasterAuditUidNotBetween(Long value1, Long value2) {
            addCriterion("master_audit_uid not between", value1, value2, "masterAuditUid");
            return (Criteria) this;
        }

        public Criteria andMasterAuditPhoneIsNull() {
            addCriterion("master_audit_phone is null");
            return (Criteria) this;
        }

        public Criteria andMasterAuditPhoneIsNotNull() {
            addCriterion("master_audit_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMasterAuditPhoneEqualTo(String value) {
            addCriterion("master_audit_phone =", value, "masterAuditPhone");
            return (Criteria) this;
        }

        public Criteria andMasterAuditPhoneNotEqualTo(String value) {
            addCriterion("master_audit_phone <>", value, "masterAuditPhone");
            return (Criteria) this;
        }

        public Criteria andMasterAuditPhoneGreaterThan(String value) {
            addCriterion("master_audit_phone >", value, "masterAuditPhone");
            return (Criteria) this;
        }

        public Criteria andMasterAuditPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("master_audit_phone >=", value, "masterAuditPhone");
            return (Criteria) this;
        }

        public Criteria andMasterAuditPhoneLessThan(String value) {
            addCriterion("master_audit_phone <", value, "masterAuditPhone");
            return (Criteria) this;
        }

        public Criteria andMasterAuditPhoneLessThanOrEqualTo(String value) {
            addCriterion("master_audit_phone <=", value, "masterAuditPhone");
            return (Criteria) this;
        }

        public Criteria andMasterAuditPhoneLike(String value) {
            addCriterion("master_audit_phone like", value, "masterAuditPhone");
            return (Criteria) this;
        }

        public Criteria andMasterAuditPhoneNotLike(String value) {
            addCriterion("master_audit_phone not like", value, "masterAuditPhone");
            return (Criteria) this;
        }

        public Criteria andMasterAuditPhoneIn(List<String> values) {
            addCriterion("master_audit_phone in", values, "masterAuditPhone");
            return (Criteria) this;
        }

        public Criteria andMasterAuditPhoneNotIn(List<String> values) {
            addCriterion("master_audit_phone not in", values, "masterAuditPhone");
            return (Criteria) this;
        }

        public Criteria andMasterAuditPhoneBetween(String value1, String value2) {
            addCriterion("master_audit_phone between", value1, value2, "masterAuditPhone");
            return (Criteria) this;
        }

        public Criteria andMasterAuditPhoneNotBetween(String value1, String value2) {
            addCriterion("master_audit_phone not between", value1, value2, "masterAuditPhone");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditTimeIsNull() {
            addCriterion("community_audit_time is null");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditTimeIsNotNull() {
            addCriterion("community_audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditTimeEqualTo(Date value) {
            addCriterion("community_audit_time =", value, "communityAuditTime");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditTimeNotEqualTo(Date value) {
            addCriterion("community_audit_time <>", value, "communityAuditTime");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditTimeGreaterThan(Date value) {
            addCriterion("community_audit_time >", value, "communityAuditTime");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("community_audit_time >=", value, "communityAuditTime");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditTimeLessThan(Date value) {
            addCriterion("community_audit_time <", value, "communityAuditTime");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("community_audit_time <=", value, "communityAuditTime");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditTimeIn(List<Date> values) {
            addCriterion("community_audit_time in", values, "communityAuditTime");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditTimeNotIn(List<Date> values) {
            addCriterion("community_audit_time not in", values, "communityAuditTime");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditTimeBetween(Date value1, Date value2) {
            addCriterion("community_audit_time between", value1, value2, "communityAuditTime");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("community_audit_time not between", value1, value2, "communityAuditTime");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditUidIsNull() {
            addCriterion("community_audit_uid is null");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditUidIsNotNull() {
            addCriterion("community_audit_uid is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditUidEqualTo(Long value) {
            addCriterion("community_audit_uid =", value, "communityAuditUid");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditUidNotEqualTo(Long value) {
            addCriterion("community_audit_uid <>", value, "communityAuditUid");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditUidGreaterThan(Long value) {
            addCriterion("community_audit_uid >", value, "communityAuditUid");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditUidGreaterThanOrEqualTo(Long value) {
            addCriterion("community_audit_uid >=", value, "communityAuditUid");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditUidLessThan(Long value) {
            addCriterion("community_audit_uid <", value, "communityAuditUid");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditUidLessThanOrEqualTo(Long value) {
            addCriterion("community_audit_uid <=", value, "communityAuditUid");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditUidIn(List<Long> values) {
            addCriterion("community_audit_uid in", values, "communityAuditUid");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditUidNotIn(List<Long> values) {
            addCriterion("community_audit_uid not in", values, "communityAuditUid");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditUidBetween(Long value1, Long value2) {
            addCriterion("community_audit_uid between", value1, value2, "communityAuditUid");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditUidNotBetween(Long value1, Long value2) {
            addCriterion("community_audit_uid not between", value1, value2, "communityAuditUid");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditStatusIsNull() {
            addCriterion("community_audit_status is null");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditStatusIsNotNull() {
            addCriterion("community_audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditStatusEqualTo(Integer value) {
            addCriterion("community_audit_status =", value, "communityAuditStatus");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditStatusNotEqualTo(Integer value) {
            addCriterion("community_audit_status <>", value, "communityAuditStatus");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditStatusGreaterThan(Integer value) {
            addCriterion("community_audit_status >", value, "communityAuditStatus");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("community_audit_status >=", value, "communityAuditStatus");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditStatusLessThan(Integer value) {
            addCriterion("community_audit_status <", value, "communityAuditStatus");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditStatusLessThanOrEqualTo(Integer value) {
            addCriterion("community_audit_status <=", value, "communityAuditStatus");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditStatusIn(List<Integer> values) {
            addCriterion("community_audit_status in", values, "communityAuditStatus");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditStatusNotIn(List<Integer> values) {
            addCriterion("community_audit_status not in", values, "communityAuditStatus");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditStatusBetween(Integer value1, Integer value2) {
            addCriterion("community_audit_status between", value1, value2, "communityAuditStatus");
            return (Criteria) this;
        }

        public Criteria andCommunityAuditStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("community_audit_status not between", value1, value2, "communityAuditStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditTimeIsNull() {
            addCriterion("visitor_audit_time is null");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditTimeIsNotNull() {
            addCriterion("visitor_audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditTimeEqualTo(Date value) {
            addCriterion("visitor_audit_time =", value, "visitorAuditTime");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditTimeNotEqualTo(Date value) {
            addCriterion("visitor_audit_time <>", value, "visitorAuditTime");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditTimeGreaterThan(Date value) {
            addCriterion("visitor_audit_time >", value, "visitorAuditTime");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("visitor_audit_time >=", value, "visitorAuditTime");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditTimeLessThan(Date value) {
            addCriterion("visitor_audit_time <", value, "visitorAuditTime");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("visitor_audit_time <=", value, "visitorAuditTime");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditTimeIn(List<Date> values) {
            addCriterion("visitor_audit_time in", values, "visitorAuditTime");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditTimeNotIn(List<Date> values) {
            addCriterion("visitor_audit_time not in", values, "visitorAuditTime");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditTimeBetween(Date value1, Date value2) {
            addCriterion("visitor_audit_time between", value1, value2, "visitorAuditTime");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("visitor_audit_time not between", value1, value2, "visitorAuditTime");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditUidIsNull() {
            addCriterion("visitor_audit_uid is null");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditUidIsNotNull() {
            addCriterion("visitor_audit_uid is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditUidEqualTo(Long value) {
            addCriterion("visitor_audit_uid =", value, "visitorAuditUid");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditUidNotEqualTo(Long value) {
            addCriterion("visitor_audit_uid <>", value, "visitorAuditUid");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditUidGreaterThan(Long value) {
            addCriterion("visitor_audit_uid >", value, "visitorAuditUid");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditUidGreaterThanOrEqualTo(Long value) {
            addCriterion("visitor_audit_uid >=", value, "visitorAuditUid");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditUidLessThan(Long value) {
            addCriterion("visitor_audit_uid <", value, "visitorAuditUid");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditUidLessThanOrEqualTo(Long value) {
            addCriterion("visitor_audit_uid <=", value, "visitorAuditUid");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditUidIn(List<Long> values) {
            addCriterion("visitor_audit_uid in", values, "visitorAuditUid");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditUidNotIn(List<Long> values) {
            addCriterion("visitor_audit_uid not in", values, "visitorAuditUid");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditUidBetween(Long value1, Long value2) {
            addCriterion("visitor_audit_uid between", value1, value2, "visitorAuditUid");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditUidNotBetween(Long value1, Long value2) {
            addCriterion("visitor_audit_uid not between", value1, value2, "visitorAuditUid");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditStatusIsNull() {
            addCriterion("visitor_audit_status is null");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditStatusIsNotNull() {
            addCriterion("visitor_audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditStatusEqualTo(Integer value) {
            addCriterion("visitor_audit_status =", value, "visitorAuditStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditStatusNotEqualTo(Integer value) {
            addCriterion("visitor_audit_status <>", value, "visitorAuditStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditStatusGreaterThan(Integer value) {
            addCriterion("visitor_audit_status >", value, "visitorAuditStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("visitor_audit_status >=", value, "visitorAuditStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditStatusLessThan(Integer value) {
            addCriterion("visitor_audit_status <", value, "visitorAuditStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditStatusLessThanOrEqualTo(Integer value) {
            addCriterion("visitor_audit_status <=", value, "visitorAuditStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditStatusIn(List<Integer> values) {
            addCriterion("visitor_audit_status in", values, "visitorAuditStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditStatusNotIn(List<Integer> values) {
            addCriterion("visitor_audit_status not in", values, "visitorAuditStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditStatusBetween(Integer value1, Integer value2) {
            addCriterion("visitor_audit_status between", value1, value2, "visitorAuditStatus");
            return (Criteria) this;
        }

        public Criteria andVisitorAuditStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("visitor_audit_status not between", value1, value2, "visitorAuditStatus");
            return (Criteria) this;
        }

        public Criteria andRenewAuditTimeIsNull() {
            addCriterion("renew_audit_time is null");
            return (Criteria) this;
        }

        public Criteria andRenewAuditTimeIsNotNull() {
            addCriterion("renew_audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andRenewAuditTimeEqualTo(Date value) {
            addCriterion("renew_audit_time =", value, "renewAuditTime");
            return (Criteria) this;
        }

        public Criteria andRenewAuditTimeNotEqualTo(Date value) {
            addCriterion("renew_audit_time <>", value, "renewAuditTime");
            return (Criteria) this;
        }

        public Criteria andRenewAuditTimeGreaterThan(Date value) {
            addCriterion("renew_audit_time >", value, "renewAuditTime");
            return (Criteria) this;
        }

        public Criteria andRenewAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("renew_audit_time >=", value, "renewAuditTime");
            return (Criteria) this;
        }

        public Criteria andRenewAuditTimeLessThan(Date value) {
            addCriterion("renew_audit_time <", value, "renewAuditTime");
            return (Criteria) this;
        }

        public Criteria andRenewAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("renew_audit_time <=", value, "renewAuditTime");
            return (Criteria) this;
        }

        public Criteria andRenewAuditTimeIn(List<Date> values) {
            addCriterion("renew_audit_time in", values, "renewAuditTime");
            return (Criteria) this;
        }

        public Criteria andRenewAuditTimeNotIn(List<Date> values) {
            addCriterion("renew_audit_time not in", values, "renewAuditTime");
            return (Criteria) this;
        }

        public Criteria andRenewAuditTimeBetween(Date value1, Date value2) {
            addCriterion("renew_audit_time between", value1, value2, "renewAuditTime");
            return (Criteria) this;
        }

        public Criteria andRenewAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("renew_audit_time not between", value1, value2, "renewAuditTime");
            return (Criteria) this;
        }

        public Criteria andRenewAuditUidIsNull() {
            addCriterion("renew_audit_uid is null");
            return (Criteria) this;
        }

        public Criteria andRenewAuditUidIsNotNull() {
            addCriterion("renew_audit_uid is not null");
            return (Criteria) this;
        }

        public Criteria andRenewAuditUidEqualTo(Long value) {
            addCriterion("renew_audit_uid =", value, "renewAuditUid");
            return (Criteria) this;
        }

        public Criteria andRenewAuditUidNotEqualTo(Long value) {
            addCriterion("renew_audit_uid <>", value, "renewAuditUid");
            return (Criteria) this;
        }

        public Criteria andRenewAuditUidGreaterThan(Long value) {
            addCriterion("renew_audit_uid >", value, "renewAuditUid");
            return (Criteria) this;
        }

        public Criteria andRenewAuditUidGreaterThanOrEqualTo(Long value) {
            addCriterion("renew_audit_uid >=", value, "renewAuditUid");
            return (Criteria) this;
        }

        public Criteria andRenewAuditUidLessThan(Long value) {
            addCriterion("renew_audit_uid <", value, "renewAuditUid");
            return (Criteria) this;
        }

        public Criteria andRenewAuditUidLessThanOrEqualTo(Long value) {
            addCriterion("renew_audit_uid <=", value, "renewAuditUid");
            return (Criteria) this;
        }

        public Criteria andRenewAuditUidIn(List<Long> values) {
            addCriterion("renew_audit_uid in", values, "renewAuditUid");
            return (Criteria) this;
        }

        public Criteria andRenewAuditUidNotIn(List<Long> values) {
            addCriterion("renew_audit_uid not in", values, "renewAuditUid");
            return (Criteria) this;
        }

        public Criteria andRenewAuditUidBetween(Long value1, Long value2) {
            addCriterion("renew_audit_uid between", value1, value2, "renewAuditUid");
            return (Criteria) this;
        }

        public Criteria andRenewAuditUidNotBetween(Long value1, Long value2) {
            addCriterion("renew_audit_uid not between", value1, value2, "renewAuditUid");
            return (Criteria) this;
        }

        public Criteria andRenewAuditStatusIsNull() {
            addCriterion("renew_audit_status is null");
            return (Criteria) this;
        }

        public Criteria andRenewAuditStatusIsNotNull() {
            addCriterion("renew_audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andRenewAuditStatusEqualTo(Integer value) {
            addCriterion("renew_audit_status =", value, "renewAuditStatus");
            return (Criteria) this;
        }

        public Criteria andRenewAuditStatusNotEqualTo(Integer value) {
            addCriterion("renew_audit_status <>", value, "renewAuditStatus");
            return (Criteria) this;
        }

        public Criteria andRenewAuditStatusGreaterThan(Integer value) {
            addCriterion("renew_audit_status >", value, "renewAuditStatus");
            return (Criteria) this;
        }

        public Criteria andRenewAuditStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("renew_audit_status >=", value, "renewAuditStatus");
            return (Criteria) this;
        }

        public Criteria andRenewAuditStatusLessThan(Integer value) {
            addCriterion("renew_audit_status <", value, "renewAuditStatus");
            return (Criteria) this;
        }

        public Criteria andRenewAuditStatusLessThanOrEqualTo(Integer value) {
            addCriterion("renew_audit_status <=", value, "renewAuditStatus");
            return (Criteria) this;
        }

        public Criteria andRenewAuditStatusIn(List<Integer> values) {
            addCriterion("renew_audit_status in", values, "renewAuditStatus");
            return (Criteria) this;
        }

        public Criteria andRenewAuditStatusNotIn(List<Integer> values) {
            addCriterion("renew_audit_status not in", values, "renewAuditStatus");
            return (Criteria) this;
        }

        public Criteria andRenewAuditStatusBetween(Integer value1, Integer value2) {
            addCriterion("renew_audit_status between", value1, value2, "renewAuditStatus");
            return (Criteria) this;
        }

        public Criteria andRenewAuditStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("renew_audit_status not between", value1, value2, "renewAuditStatus");
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

        public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("token like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("token not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("token not between", value1, value2, "token");
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