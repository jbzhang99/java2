package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParkingOrderExample() {
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

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
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

        public Criteria andCarPlateNoIsNull() {
            addCriterion("car_plate_no is null");
            return (Criteria) this;
        }

        public Criteria andCarPlateNoIsNotNull() {
            addCriterion("car_plate_no is not null");
            return (Criteria) this;
        }

        public Criteria andCarPlateNoEqualTo(String value) {
            addCriterion("car_plate_no =", value, "carPlateNo");
            return (Criteria) this;
        }

        public Criteria andCarPlateNoNotEqualTo(String value) {
            addCriterion("car_plate_no <>", value, "carPlateNo");
            return (Criteria) this;
        }

        public Criteria andCarPlateNoGreaterThan(String value) {
            addCriterion("car_plate_no >", value, "carPlateNo");
            return (Criteria) this;
        }

        public Criteria andCarPlateNoGreaterThanOrEqualTo(String value) {
            addCriterion("car_plate_no >=", value, "carPlateNo");
            return (Criteria) this;
        }

        public Criteria andCarPlateNoLessThan(String value) {
            addCriterion("car_plate_no <", value, "carPlateNo");
            return (Criteria) this;
        }

        public Criteria andCarPlateNoLessThanOrEqualTo(String value) {
            addCriterion("car_plate_no <=", value, "carPlateNo");
            return (Criteria) this;
        }

        public Criteria andCarPlateNoLike(String value) {
            addCriterion("car_plate_no like", value, "carPlateNo");
            return (Criteria) this;
        }

        public Criteria andCarPlateNoNotLike(String value) {
            addCriterion("car_plate_no not like", value, "carPlateNo");
            return (Criteria) this;
        }

        public Criteria andCarPlateNoIn(List<String> values) {
            addCriterion("car_plate_no in", values, "carPlateNo");
            return (Criteria) this;
        }

        public Criteria andCarPlateNoNotIn(List<String> values) {
            addCriterion("car_plate_no not in", values, "carPlateNo");
            return (Criteria) this;
        }

        public Criteria andCarPlateNoBetween(String value1, String value2) {
            addCriterion("car_plate_no between", value1, value2, "carPlateNo");
            return (Criteria) this;
        }

        public Criteria andCarPlateNoNotBetween(String value1, String value2) {
            addCriterion("car_plate_no not between", value1, value2, "carPlateNo");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNull() {
            addCriterion("card_no is null");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNotNull() {
            addCriterion("card_no is not null");
            return (Criteria) this;
        }

        public Criteria andCardNoEqualTo(String value) {
            addCriterion("card_no =", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotEqualTo(String value) {
            addCriterion("card_no <>", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThan(String value) {
            addCriterion("card_no >", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("card_no >=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThan(String value) {
            addCriterion("card_no <", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThanOrEqualTo(String value) {
            addCriterion("card_no <=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLike(String value) {
            addCriterion("card_no like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotLike(String value) {
            addCriterion("card_no not like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoIn(List<String> values) {
            addCriterion("card_no in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotIn(List<String> values) {
            addCriterion("card_no not in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoBetween(String value1, String value2) {
            addCriterion("card_no between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotBetween(String value1, String value2) {
            addCriterion("card_no not between", value1, value2, "cardNo");
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

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
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

        public Criteria andPayAmountIsNull() {
            addCriterion("pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNotNull() {
            addCriterion("pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmountEqualTo(BigDecimal value) {
            addCriterion("pay_amount =", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotEqualTo(BigDecimal value) {
            addCriterion("pay_amount <>", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThan(BigDecimal value) {
            addCriterion("pay_amount >", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_amount >=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThan(BigDecimal value) {
            addCriterion("pay_amount <", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_amount <=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountIn(List<BigDecimal> values) {
            addCriterion("pay_amount in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotIn(List<BigDecimal> values) {
            addCriterion("pay_amount not in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_amount between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_amount not between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayPriceIsNull() {
            addCriterion("pay_price is null");
            return (Criteria) this;
        }

        public Criteria andPayPriceIsNotNull() {
            addCriterion("pay_price is not null");
            return (Criteria) this;
        }

        public Criteria andPayPriceEqualTo(String value) {
            addCriterion("pay_price =", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceNotEqualTo(String value) {
            addCriterion("pay_price <>", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceGreaterThan(String value) {
            addCriterion("pay_price >", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceGreaterThanOrEqualTo(String value) {
            addCriterion("pay_price >=", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceLessThan(String value) {
            addCriterion("pay_price <", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceLessThanOrEqualTo(String value) {
            addCriterion("pay_price <=", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceLike(String value) {
            addCriterion("pay_price like", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceNotLike(String value) {
            addCriterion("pay_price not like", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceIn(List<String> values) {
            addCriterion("pay_price in", values, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceNotIn(List<String> values) {
            addCriterion("pay_price not in", values, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceBetween(String value1, String value2) {
            addCriterion("pay_price between", value1, value2, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceNotBetween(String value1, String value2) {
            addCriterion("pay_price not between", value1, value2, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPaySrcIsNull() {
            addCriterion("pay_src is null");
            return (Criteria) this;
        }

        public Criteria andPaySrcIsNotNull() {
            addCriterion("pay_src is not null");
            return (Criteria) this;
        }

        public Criteria andPaySrcEqualTo(Integer value) {
            addCriterion("pay_src =", value, "paySrc");
            return (Criteria) this;
        }

        public Criteria andPaySrcNotEqualTo(Integer value) {
            addCriterion("pay_src <>", value, "paySrc");
            return (Criteria) this;
        }

        public Criteria andPaySrcGreaterThan(Integer value) {
            addCriterion("pay_src >", value, "paySrc");
            return (Criteria) this;
        }

        public Criteria andPaySrcGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_src >=", value, "paySrc");
            return (Criteria) this;
        }

        public Criteria andPaySrcLessThan(Integer value) {
            addCriterion("pay_src <", value, "paySrc");
            return (Criteria) this;
        }

        public Criteria andPaySrcLessThanOrEqualTo(Integer value) {
            addCriterion("pay_src <=", value, "paySrc");
            return (Criteria) this;
        }

        public Criteria andPaySrcIn(List<Integer> values) {
            addCriterion("pay_src in", values, "paySrc");
            return (Criteria) this;
        }

        public Criteria andPaySrcNotIn(List<Integer> values) {
            addCriterion("pay_src not in", values, "paySrc");
            return (Criteria) this;
        }

        public Criteria andPaySrcBetween(Integer value1, Integer value2) {
            addCriterion("pay_src between", value1, value2, "paySrc");
            return (Criteria) this;
        }

        public Criteria andPaySrcNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_src not between", value1, value2, "paySrc");
            return (Criteria) this;
        }

        public Criteria andWxOpenidIsNull() {
            addCriterion("wx_openid is null");
            return (Criteria) this;
        }

        public Criteria andWxOpenidIsNotNull() {
            addCriterion("wx_openid is not null");
            return (Criteria) this;
        }

        public Criteria andWxOpenidEqualTo(String value) {
            addCriterion("wx_openid =", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotEqualTo(String value) {
            addCriterion("wx_openid <>", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidGreaterThan(String value) {
            addCriterion("wx_openid >", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("wx_openid >=", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidLessThan(String value) {
            addCriterion("wx_openid <", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidLessThanOrEqualTo(String value) {
            addCriterion("wx_openid <=", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidLike(String value) {
            addCriterion("wx_openid like", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotLike(String value) {
            addCriterion("wx_openid not like", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidIn(List<String> values) {
            addCriterion("wx_openid in", values, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotIn(List<String> values) {
            addCriterion("wx_openid not in", values, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBetween(String value1, String value2) {
            addCriterion("wx_openid between", value1, value2, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotBetween(String value1, String value2) {
            addCriterion("wx_openid not between", value1, value2, "wxOpenid");
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

        public Criteria andDurationEqualTo(String value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(String value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(String value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(String value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(String value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(String value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLike(String value) {
            addCriterion("duration like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotLike(String value) {
            addCriterion("duration not like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<String> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<String> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(String value1, String value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(String value1, String value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andFreeDurationIsNull() {
            addCriterion("free_duration is null");
            return (Criteria) this;
        }

        public Criteria andFreeDurationIsNotNull() {
            addCriterion("free_duration is not null");
            return (Criteria) this;
        }

        public Criteria andFreeDurationEqualTo(String value) {
            addCriterion("free_duration =", value, "freeDuration");
            return (Criteria) this;
        }

        public Criteria andFreeDurationNotEqualTo(String value) {
            addCriterion("free_duration <>", value, "freeDuration");
            return (Criteria) this;
        }

        public Criteria andFreeDurationGreaterThan(String value) {
            addCriterion("free_duration >", value, "freeDuration");
            return (Criteria) this;
        }

        public Criteria andFreeDurationGreaterThanOrEqualTo(String value) {
            addCriterion("free_duration >=", value, "freeDuration");
            return (Criteria) this;
        }

        public Criteria andFreeDurationLessThan(String value) {
            addCriterion("free_duration <", value, "freeDuration");
            return (Criteria) this;
        }

        public Criteria andFreeDurationLessThanOrEqualTo(String value) {
            addCriterion("free_duration <=", value, "freeDuration");
            return (Criteria) this;
        }

        public Criteria andFreeDurationLike(String value) {
            addCriterion("free_duration like", value, "freeDuration");
            return (Criteria) this;
        }

        public Criteria andFreeDurationNotLike(String value) {
            addCriterion("free_duration not like", value, "freeDuration");
            return (Criteria) this;
        }

        public Criteria andFreeDurationIn(List<String> values) {
            addCriterion("free_duration in", values, "freeDuration");
            return (Criteria) this;
        }

        public Criteria andFreeDurationNotIn(List<String> values) {
            addCriterion("free_duration not in", values, "freeDuration");
            return (Criteria) this;
        }

        public Criteria andFreeDurationBetween(String value1, String value2) {
            addCriterion("free_duration between", value1, value2, "freeDuration");
            return (Criteria) this;
        }

        public Criteria andFreeDurationNotBetween(String value1, String value2) {
            addCriterion("free_duration not between", value1, value2, "freeDuration");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andEnterTimeIsNull() {
            addCriterion("enter_time is null");
            return (Criteria) this;
        }

        public Criteria andEnterTimeIsNotNull() {
            addCriterion("enter_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnterTimeEqualTo(Date value) {
            addCriterion("enter_time =", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeNotEqualTo(Date value) {
            addCriterion("enter_time <>", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeGreaterThan(Date value) {
            addCriterion("enter_time >", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("enter_time >=", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeLessThan(Date value) {
            addCriterion("enter_time <", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeLessThanOrEqualTo(Date value) {
            addCriterion("enter_time <=", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeIn(List<Date> values) {
            addCriterion("enter_time in", values, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeNotIn(List<Date> values) {
            addCriterion("enter_time not in", values, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeBetween(Date value1, Date value2) {
            addCriterion("enter_time between", value1, value2, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeNotBetween(Date value1, Date value2) {
            addCriterion("enter_time not between", value1, value2, "enterTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIsNull() {
            addCriterion("cancel_time is null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIsNotNull() {
            addCriterion("cancel_time is not null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeEqualTo(Date value) {
            addCriterion("cancel_time =", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotEqualTo(Date value) {
            addCriterion("cancel_time <>", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThan(Date value) {
            addCriterion("cancel_time >", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cancel_time >=", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThan(Date value) {
            addCriterion("cancel_time <", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThanOrEqualTo(Date value) {
            addCriterion("cancel_time <=", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIn(List<Date> values) {
            addCriterion("cancel_time in", values, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotIn(List<Date> values) {
            addCriterion("cancel_time not in", values, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeBetween(Date value1, Date value2) {
            addCriterion("cancel_time between", value1, value2, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotBetween(Date value1, Date value2) {
            addCriterion("cancel_time not between", value1, value2, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayNumIsNull() {
            addCriterion("monthly_pay_num is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayNumIsNotNull() {
            addCriterion("monthly_pay_num is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayNumEqualTo(Integer value) {
            addCriterion("monthly_pay_num =", value, "monthlyPayNum");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayNumNotEqualTo(Integer value) {
            addCriterion("monthly_pay_num <>", value, "monthlyPayNum");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayNumGreaterThan(Integer value) {
            addCriterion("monthly_pay_num >", value, "monthlyPayNum");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("monthly_pay_num >=", value, "monthlyPayNum");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayNumLessThan(Integer value) {
            addCriterion("monthly_pay_num <", value, "monthlyPayNum");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayNumLessThanOrEqualTo(Integer value) {
            addCriterion("monthly_pay_num <=", value, "monthlyPayNum");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayNumIn(List<Integer> values) {
            addCriterion("monthly_pay_num in", values, "monthlyPayNum");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayNumNotIn(List<Integer> values) {
            addCriterion("monthly_pay_num not in", values, "monthlyPayNum");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayNumBetween(Integer value1, Integer value2) {
            addCriterion("monthly_pay_num between", value1, value2, "monthlyPayNum");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayNumNotBetween(Integer value1, Integer value2) {
            addCriterion("monthly_pay_num not between", value1, value2, "monthlyPayNum");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayStartTimeIsNull() {
            addCriterion("monthly_pay_start_time is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayStartTimeIsNotNull() {
            addCriterion("monthly_pay_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayStartTimeEqualTo(String value) {
            addCriterion("monthly_pay_start_time =", value, "monthlyPayStartTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayStartTimeNotEqualTo(String value) {
            addCriterion("monthly_pay_start_time <>", value, "monthlyPayStartTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayStartTimeGreaterThan(String value) {
            addCriterion("monthly_pay_start_time >", value, "monthlyPayStartTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("monthly_pay_start_time >=", value, "monthlyPayStartTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayStartTimeLessThan(String value) {
            addCriterion("monthly_pay_start_time <", value, "monthlyPayStartTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayStartTimeLessThanOrEqualTo(String value) {
            addCriterion("monthly_pay_start_time <=", value, "monthlyPayStartTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayStartTimeLike(String value) {
            addCriterion("monthly_pay_start_time like", value, "monthlyPayStartTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayStartTimeNotLike(String value) {
            addCriterion("monthly_pay_start_time not like", value, "monthlyPayStartTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayStartTimeIn(List<String> values) {
            addCriterion("monthly_pay_start_time in", values, "monthlyPayStartTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayStartTimeNotIn(List<String> values) {
            addCriterion("monthly_pay_start_time not in", values, "monthlyPayStartTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayStartTimeBetween(String value1, String value2) {
            addCriterion("monthly_pay_start_time between", value1, value2, "monthlyPayStartTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayStartTimeNotBetween(String value1, String value2) {
            addCriterion("monthly_pay_start_time not between", value1, value2, "monthlyPayStartTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayEndTimeIsNull() {
            addCriterion("monthly_pay_end_time is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayEndTimeIsNotNull() {
            addCriterion("monthly_pay_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayEndTimeEqualTo(String value) {
            addCriterion("monthly_pay_end_time =", value, "monthlyPayEndTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayEndTimeNotEqualTo(String value) {
            addCriterion("monthly_pay_end_time <>", value, "monthlyPayEndTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayEndTimeGreaterThan(String value) {
            addCriterion("monthly_pay_end_time >", value, "monthlyPayEndTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("monthly_pay_end_time >=", value, "monthlyPayEndTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayEndTimeLessThan(String value) {
            addCriterion("monthly_pay_end_time <", value, "monthlyPayEndTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayEndTimeLessThanOrEqualTo(String value) {
            addCriterion("monthly_pay_end_time <=", value, "monthlyPayEndTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayEndTimeLike(String value) {
            addCriterion("monthly_pay_end_time like", value, "monthlyPayEndTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayEndTimeNotLike(String value) {
            addCriterion("monthly_pay_end_time not like", value, "monthlyPayEndTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayEndTimeIn(List<String> values) {
            addCriterion("monthly_pay_end_time in", values, "monthlyPayEndTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayEndTimeNotIn(List<String> values) {
            addCriterion("monthly_pay_end_time not in", values, "monthlyPayEndTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayEndTimeBetween(String value1, String value2) {
            addCriterion("monthly_pay_end_time between", value1, value2, "monthlyPayEndTime");
            return (Criteria) this;
        }

        public Criteria andMonthlyPayEndTimeNotBetween(String value1, String value2) {
            addCriterion("monthly_pay_end_time not between", value1, value2, "monthlyPayEndTime");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdIsNull() {
            addCriterion("rfpay_bill_id is null");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdIsNotNull() {
            addCriterion("rfpay_bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdEqualTo(String value) {
            addCriterion("rfpay_bill_id =", value, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdNotEqualTo(String value) {
            addCriterion("rfpay_bill_id <>", value, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdGreaterThan(String value) {
            addCriterion("rfpay_bill_id >", value, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("rfpay_bill_id >=", value, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdLessThan(String value) {
            addCriterion("rfpay_bill_id <", value, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdLessThanOrEqualTo(String value) {
            addCriterion("rfpay_bill_id <=", value, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdLike(String value) {
            addCriterion("rfpay_bill_id like", value, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdNotLike(String value) {
            addCriterion("rfpay_bill_id not like", value, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdIn(List<String> values) {
            addCriterion("rfpay_bill_id in", values, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdNotIn(List<String> values) {
            addCriterion("rfpay_bill_id not in", values, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdBetween(String value1, String value2) {
            addCriterion("rfpay_bill_id between", value1, value2, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayBillIdNotBetween(String value1, String value2) {
            addCriterion("rfpay_bill_id not between", value1, value2, "rfpayBillId");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoIsNull() {
            addCriterion("rfpay_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoIsNotNull() {
            addCriterion("rfpay_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoEqualTo(String value) {
            addCriterion("rfpay_trade_no =", value, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoNotEqualTo(String value) {
            addCriterion("rfpay_trade_no <>", value, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoGreaterThan(String value) {
            addCriterion("rfpay_trade_no >", value, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("rfpay_trade_no >=", value, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoLessThan(String value) {
            addCriterion("rfpay_trade_no <", value, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoLessThanOrEqualTo(String value) {
            addCriterion("rfpay_trade_no <=", value, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoLike(String value) {
            addCriterion("rfpay_trade_no like", value, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoNotLike(String value) {
            addCriterion("rfpay_trade_no not like", value, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoIn(List<String> values) {
            addCriterion("rfpay_trade_no in", values, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoNotIn(List<String> values) {
            addCriterion("rfpay_trade_no not in", values, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoBetween(String value1, String value2) {
            addCriterion("rfpay_trade_no between", value1, value2, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayTradeNoNotBetween(String value1, String value2) {
            addCriterion("rfpay_trade_no not between", value1, value2, "rfpayTradeNo");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyIsNull() {
            addCriterion("rfpay_body is null");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyIsNotNull() {
            addCriterion("rfpay_body is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyEqualTo(String value) {
            addCriterion("rfpay_body =", value, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyNotEqualTo(String value) {
            addCriterion("rfpay_body <>", value, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyGreaterThan(String value) {
            addCriterion("rfpay_body >", value, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyGreaterThanOrEqualTo(String value) {
            addCriterion("rfpay_body >=", value, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyLessThan(String value) {
            addCriterion("rfpay_body <", value, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyLessThanOrEqualTo(String value) {
            addCriterion("rfpay_body <=", value, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyLike(String value) {
            addCriterion("rfpay_body like", value, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyNotLike(String value) {
            addCriterion("rfpay_body not like", value, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyIn(List<String> values) {
            addCriterion("rfpay_body in", values, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyNotIn(List<String> values) {
            addCriterion("rfpay_body not in", values, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyBetween(String value1, String value2) {
            addCriterion("rfpay_body between", value1, value2, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayBodyNotBetween(String value1, String value2) {
            addCriterion("rfpay_body not between", value1, value2, "rfpayBody");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeIsNull() {
            addCriterion("rfpay_type is null");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeIsNotNull() {
            addCriterion("rfpay_type is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeEqualTo(String value) {
            addCriterion("rfpay_type =", value, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeNotEqualTo(String value) {
            addCriterion("rfpay_type <>", value, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeGreaterThan(String value) {
            addCriterion("rfpay_type >", value, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("rfpay_type >=", value, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeLessThan(String value) {
            addCriterion("rfpay_type <", value, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeLessThanOrEqualTo(String value) {
            addCriterion("rfpay_type <=", value, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeLike(String value) {
            addCriterion("rfpay_type like", value, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeNotLike(String value) {
            addCriterion("rfpay_type not like", value, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeIn(List<String> values) {
            addCriterion("rfpay_type in", values, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeNotIn(List<String> values) {
            addCriterion("rfpay_type not in", values, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeBetween(String value1, String value2) {
            addCriterion("rfpay_type between", value1, value2, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayTypeNotBetween(String value1, String value2) {
            addCriterion("rfpay_type not between", value1, value2, "rfpayType");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeIsNull() {
            addCriterion("rfpay_create_time is null");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeIsNotNull() {
            addCriterion("rfpay_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeEqualTo(Date value) {
            addCriterion("rfpay_create_time =", value, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeNotEqualTo(Date value) {
            addCriterion("rfpay_create_time <>", value, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeGreaterThan(Date value) {
            addCriterion("rfpay_create_time >", value, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rfpay_create_time >=", value, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeLessThan(Date value) {
            addCriterion("rfpay_create_time <", value, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("rfpay_create_time <=", value, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeIn(List<Date> values) {
            addCriterion("rfpay_create_time in", values, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeNotIn(List<Date> values) {
            addCriterion("rfpay_create_time not in", values, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeBetween(Date value1, Date value2) {
            addCriterion("rfpay_create_time between", value1, value2, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("rfpay_create_time not between", value1, value2, "rfpayCreateTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeIsNull() {
            addCriterion("rfpay_close_time is null");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeIsNotNull() {
            addCriterion("rfpay_close_time is not null");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeEqualTo(Date value) {
            addCriterion("rfpay_close_time =", value, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeNotEqualTo(Date value) {
            addCriterion("rfpay_close_time <>", value, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeGreaterThan(Date value) {
            addCriterion("rfpay_close_time >", value, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rfpay_close_time >=", value, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeLessThan(Date value) {
            addCriterion("rfpay_close_time <", value, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeLessThanOrEqualTo(Date value) {
            addCriterion("rfpay_close_time <=", value, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeIn(List<Date> values) {
            addCriterion("rfpay_close_time in", values, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeNotIn(List<Date> values) {
            addCriterion("rfpay_close_time not in", values, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeBetween(Date value1, Date value2) {
            addCriterion("rfpay_close_time between", value1, value2, "rfpayCloseTime");
            return (Criteria) this;
        }

        public Criteria andRfpayCloseTimeNotBetween(Date value1, Date value2) {
            addCriterion("rfpay_close_time not between", value1, value2, "rfpayCloseTime");
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

        public Criteria andPrvUidIsNull() {
            addCriterion("prv_uid is null");
            return (Criteria) this;
        }

        public Criteria andPrvUidIsNotNull() {
            addCriterion("prv_uid is not null");
            return (Criteria) this;
        }

        public Criteria andPrvUidEqualTo(Long value) {
            addCriterion("prv_uid =", value, "prvUid");
            return (Criteria) this;
        }

        public Criteria andPrvUidNotEqualTo(Long value) {
            addCriterion("prv_uid <>", value, "prvUid");
            return (Criteria) this;
        }

        public Criteria andPrvUidGreaterThan(Long value) {
            addCriterion("prv_uid >", value, "prvUid");
            return (Criteria) this;
        }

        public Criteria andPrvUidGreaterThanOrEqualTo(Long value) {
            addCriterion("prv_uid >=", value, "prvUid");
            return (Criteria) this;
        }

        public Criteria andPrvUidLessThan(Long value) {
            addCriterion("prv_uid <", value, "prvUid");
            return (Criteria) this;
        }

        public Criteria andPrvUidLessThanOrEqualTo(Long value) {
            addCriterion("prv_uid <=", value, "prvUid");
            return (Criteria) this;
        }

        public Criteria andPrvUidIn(List<Long> values) {
            addCriterion("prv_uid in", values, "prvUid");
            return (Criteria) this;
        }

        public Criteria andPrvUidNotIn(List<Long> values) {
            addCriterion("prv_uid not in", values, "prvUid");
            return (Criteria) this;
        }

        public Criteria andPrvUidBetween(Long value1, Long value2) {
            addCriterion("prv_uid between", value1, value2, "prvUid");
            return (Criteria) this;
        }

        public Criteria andPrvUidNotBetween(Long value1, Long value2) {
            addCriterion("prv_uid not between", value1, value2, "prvUid");
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