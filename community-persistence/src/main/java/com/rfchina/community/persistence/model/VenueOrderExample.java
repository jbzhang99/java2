package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VenueOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VenueOrderExample() {
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

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(String value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(String value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(String value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(String value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLike(String value) {
            addCriterion("order_number like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotLike(String value) {
            addCriterion("order_number not like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<String> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<String> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(String value1, String value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(String value1, String value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
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

        public Criteria andOrderNameIsNull() {
            addCriterion("order_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderNameIsNotNull() {
            addCriterion("order_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNameEqualTo(String value) {
            addCriterion("order_name =", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotEqualTo(String value) {
            addCriterion("order_name <>", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameGreaterThan(String value) {
            addCriterion("order_name >", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_name >=", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLessThan(String value) {
            addCriterion("order_name <", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLessThanOrEqualTo(String value) {
            addCriterion("order_name <=", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLike(String value) {
            addCriterion("order_name like", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotLike(String value) {
            addCriterion("order_name not like", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameIn(List<String> values) {
            addCriterion("order_name in", values, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotIn(List<String> values) {
            addCriterion("order_name not in", values, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameBetween(String value1, String value2) {
            addCriterion("order_name between", value1, value2, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotBetween(String value1, String value2) {
            addCriterion("order_name not between", value1, value2, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneIsNull() {
            addCriterion("order_phone is null");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneIsNotNull() {
            addCriterion("order_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneEqualTo(String value) {
            addCriterion("order_phone =", value, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneNotEqualTo(String value) {
            addCriterion("order_phone <>", value, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneGreaterThan(String value) {
            addCriterion("order_phone >", value, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("order_phone >=", value, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneLessThan(String value) {
            addCriterion("order_phone <", value, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneLessThanOrEqualTo(String value) {
            addCriterion("order_phone <=", value, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneLike(String value) {
            addCriterion("order_phone like", value, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneNotLike(String value) {
            addCriterion("order_phone not like", value, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneIn(List<String> values) {
            addCriterion("order_phone in", values, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneNotIn(List<String> values) {
            addCriterion("order_phone not in", values, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneBetween(String value1, String value2) {
            addCriterion("order_phone between", value1, value2, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneNotBetween(String value1, String value2) {
            addCriterion("order_phone not between", value1, value2, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andVenueIdIsNull() {
            addCriterion("venue_id is null");
            return (Criteria) this;
        }

        public Criteria andVenueIdIsNotNull() {
            addCriterion("venue_id is not null");
            return (Criteria) this;
        }

        public Criteria andVenueIdEqualTo(Long value) {
            addCriterion("venue_id =", value, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdNotEqualTo(Long value) {
            addCriterion("venue_id <>", value, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdGreaterThan(Long value) {
            addCriterion("venue_id >", value, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdGreaterThanOrEqualTo(Long value) {
            addCriterion("venue_id >=", value, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdLessThan(Long value) {
            addCriterion("venue_id <", value, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdLessThanOrEqualTo(Long value) {
            addCriterion("venue_id <=", value, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdIn(List<Long> values) {
            addCriterion("venue_id in", values, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdNotIn(List<Long> values) {
            addCriterion("venue_id not in", values, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdBetween(Long value1, Long value2) {
            addCriterion("venue_id between", value1, value2, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdNotBetween(Long value1, Long value2) {
            addCriterion("venue_id not between", value1, value2, "venueId");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(BigDecimal value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(BigDecimal value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<BigDecimal> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceIsNull() {
            addCriterion("real_price is null");
            return (Criteria) this;
        }

        public Criteria andRealPriceIsNotNull() {
            addCriterion("real_price is not null");
            return (Criteria) this;
        }

        public Criteria andRealPriceEqualTo(BigDecimal value) {
            addCriterion("real_price =", value, "realPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceNotEqualTo(BigDecimal value) {
            addCriterion("real_price <>", value, "realPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceGreaterThan(BigDecimal value) {
            addCriterion("real_price >", value, "realPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_price >=", value, "realPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceLessThan(BigDecimal value) {
            addCriterion("real_price <", value, "realPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_price <=", value, "realPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceIn(List<BigDecimal> values) {
            addCriterion("real_price in", values, "realPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceNotIn(List<BigDecimal> values) {
            addCriterion("real_price not in", values, "realPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_price between", value1, value2, "realPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_price not between", value1, value2, "realPrice");
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

        public Criteria andPlayDateIsNull() {
            addCriterion("play_date is null");
            return (Criteria) this;
        }

        public Criteria andPlayDateIsNotNull() {
            addCriterion("play_date is not null");
            return (Criteria) this;
        }

        public Criteria andPlayDateEqualTo(Date value) {
            addCriterionForJDBCDate("play_date =", value, "playDate");
            return (Criteria) this;
        }

        public Criteria andPlayDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("play_date <>", value, "playDate");
            return (Criteria) this;
        }

        public Criteria andPlayDateGreaterThan(Date value) {
            addCriterionForJDBCDate("play_date >", value, "playDate");
            return (Criteria) this;
        }

        public Criteria andPlayDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("play_date >=", value, "playDate");
            return (Criteria) this;
        }

        public Criteria andPlayDateLessThan(Date value) {
            addCriterionForJDBCDate("play_date <", value, "playDate");
            return (Criteria) this;
        }

        public Criteria andPlayDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("play_date <=", value, "playDate");
            return (Criteria) this;
        }

        public Criteria andPlayDateIn(List<Date> values) {
            addCriterionForJDBCDate("play_date in", values, "playDate");
            return (Criteria) this;
        }

        public Criteria andPlayDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("play_date not in", values, "playDate");
            return (Criteria) this;
        }

        public Criteria andPlayDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("play_date between", value1, value2, "playDate");
            return (Criteria) this;
        }

        public Criteria andPlayDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("play_date not between", value1, value2, "playDate");
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

        public Criteria andRefundTimeIsNull() {
            addCriterion("refund_time is null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNotNull() {
            addCriterion("refund_time is not null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeEqualTo(Date value) {
            addCriterion("refund_time =", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotEqualTo(Date value) {
            addCriterion("refund_time <>", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThan(Date value) {
            addCriterion("refund_time >", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("refund_time >=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThan(Date value) {
            addCriterion("refund_time <", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThanOrEqualTo(Date value) {
            addCriterion("refund_time <=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIn(List<Date> values) {
            addCriterion("refund_time in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotIn(List<Date> values) {
            addCriterion("refund_time not in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeBetween(Date value1, Date value2) {
            addCriterion("refund_time between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotBetween(Date value1, Date value2) {
            addCriterion("refund_time not between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIsNull() {
            addCriterion("charge_type is null");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIsNotNull() {
            addCriterion("charge_type is not null");
            return (Criteria) this;
        }

        public Criteria andChargeTypeEqualTo(Integer value) {
            addCriterion("charge_type =", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotEqualTo(Integer value) {
            addCriterion("charge_type <>", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeGreaterThan(Integer value) {
            addCriterion("charge_type >", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("charge_type >=", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLessThan(Integer value) {
            addCriterion("charge_type <", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("charge_type <=", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIn(List<Integer> values) {
            addCriterion("charge_type in", values, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotIn(List<Integer> values) {
            addCriterion("charge_type not in", values, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeBetween(Integer value1, Integer value2) {
            addCriterion("charge_type between", value1, value2, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("charge_type not between", value1, value2, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChildrenIsNull() {
            addCriterion("children is null");
            return (Criteria) this;
        }

        public Criteria andChildrenIsNotNull() {
            addCriterion("children is not null");
            return (Criteria) this;
        }

        public Criteria andChildrenEqualTo(Integer value) {
            addCriterion("children =", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenNotEqualTo(Integer value) {
            addCriterion("children <>", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenGreaterThan(Integer value) {
            addCriterion("children >", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenGreaterThanOrEqualTo(Integer value) {
            addCriterion("children >=", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenLessThan(Integer value) {
            addCriterion("children <", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenLessThanOrEqualTo(Integer value) {
            addCriterion("children <=", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenIn(List<Integer> values) {
            addCriterion("children in", values, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenNotIn(List<Integer> values) {
            addCriterion("children not in", values, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenBetween(Integer value1, Integer value2) {
            addCriterion("children between", value1, value2, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenNotBetween(Integer value1, Integer value2) {
            addCriterion("children not between", value1, value2, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenPriceIsNull() {
            addCriterion("children_price is null");
            return (Criteria) this;
        }

        public Criteria andChildrenPriceIsNotNull() {
            addCriterion("children_price is not null");
            return (Criteria) this;
        }

        public Criteria andChildrenPriceEqualTo(BigDecimal value) {
            addCriterion("children_price =", value, "childrenPrice");
            return (Criteria) this;
        }

        public Criteria andChildrenPriceNotEqualTo(BigDecimal value) {
            addCriterion("children_price <>", value, "childrenPrice");
            return (Criteria) this;
        }

        public Criteria andChildrenPriceGreaterThan(BigDecimal value) {
            addCriterion("children_price >", value, "childrenPrice");
            return (Criteria) this;
        }

        public Criteria andChildrenPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("children_price >=", value, "childrenPrice");
            return (Criteria) this;
        }

        public Criteria andChildrenPriceLessThan(BigDecimal value) {
            addCriterion("children_price <", value, "childrenPrice");
            return (Criteria) this;
        }

        public Criteria andChildrenPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("children_price <=", value, "childrenPrice");
            return (Criteria) this;
        }

        public Criteria andChildrenPriceIn(List<BigDecimal> values) {
            addCriterion("children_price in", values, "childrenPrice");
            return (Criteria) this;
        }

        public Criteria andChildrenPriceNotIn(List<BigDecimal> values) {
            addCriterion("children_price not in", values, "childrenPrice");
            return (Criteria) this;
        }

        public Criteria andChildrenPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("children_price between", value1, value2, "childrenPrice");
            return (Criteria) this;
        }

        public Criteria andChildrenPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("children_price not between", value1, value2, "childrenPrice");
            return (Criteria) this;
        }

        public Criteria andAdultIsNull() {
            addCriterion("adult is null");
            return (Criteria) this;
        }

        public Criteria andAdultIsNotNull() {
            addCriterion("adult is not null");
            return (Criteria) this;
        }

        public Criteria andAdultEqualTo(Integer value) {
            addCriterion("adult =", value, "adult");
            return (Criteria) this;
        }

        public Criteria andAdultNotEqualTo(Integer value) {
            addCriterion("adult <>", value, "adult");
            return (Criteria) this;
        }

        public Criteria andAdultGreaterThan(Integer value) {
            addCriterion("adult >", value, "adult");
            return (Criteria) this;
        }

        public Criteria andAdultGreaterThanOrEqualTo(Integer value) {
            addCriterion("adult >=", value, "adult");
            return (Criteria) this;
        }

        public Criteria andAdultLessThan(Integer value) {
            addCriterion("adult <", value, "adult");
            return (Criteria) this;
        }

        public Criteria andAdultLessThanOrEqualTo(Integer value) {
            addCriterion("adult <=", value, "adult");
            return (Criteria) this;
        }

        public Criteria andAdultIn(List<Integer> values) {
            addCriterion("adult in", values, "adult");
            return (Criteria) this;
        }

        public Criteria andAdultNotIn(List<Integer> values) {
            addCriterion("adult not in", values, "adult");
            return (Criteria) this;
        }

        public Criteria andAdultBetween(Integer value1, Integer value2) {
            addCriterion("adult between", value1, value2, "adult");
            return (Criteria) this;
        }

        public Criteria andAdultNotBetween(Integer value1, Integer value2) {
            addCriterion("adult not between", value1, value2, "adult");
            return (Criteria) this;
        }

        public Criteria andAdultPriceIsNull() {
            addCriterion("adult_price is null");
            return (Criteria) this;
        }

        public Criteria andAdultPriceIsNotNull() {
            addCriterion("adult_price is not null");
            return (Criteria) this;
        }

        public Criteria andAdultPriceEqualTo(BigDecimal value) {
            addCriterion("adult_price =", value, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceNotEqualTo(BigDecimal value) {
            addCriterion("adult_price <>", value, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceGreaterThan(BigDecimal value) {
            addCriterion("adult_price >", value, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("adult_price >=", value, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceLessThan(BigDecimal value) {
            addCriterion("adult_price <", value, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("adult_price <=", value, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceIn(List<BigDecimal> values) {
            addCriterion("adult_price in", values, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceNotIn(List<BigDecimal> values) {
            addCriterion("adult_price not in", values, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("adult_price between", value1, value2, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("adult_price not between", value1, value2, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdminUidIsNull() {
            addCriterion("admin_uid is null");
            return (Criteria) this;
        }

        public Criteria andAdminUidIsNotNull() {
            addCriterion("admin_uid is not null");
            return (Criteria) this;
        }

        public Criteria andAdminUidEqualTo(Long value) {
            addCriterion("admin_uid =", value, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidNotEqualTo(Long value) {
            addCriterion("admin_uid <>", value, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidGreaterThan(Long value) {
            addCriterion("admin_uid >", value, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidGreaterThanOrEqualTo(Long value) {
            addCriterion("admin_uid >=", value, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidLessThan(Long value) {
            addCriterion("admin_uid <", value, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidLessThanOrEqualTo(Long value) {
            addCriterion("admin_uid <=", value, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidIn(List<Long> values) {
            addCriterion("admin_uid in", values, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidNotIn(List<Long> values) {
            addCriterion("admin_uid not in", values, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidBetween(Long value1, Long value2) {
            addCriterion("admin_uid between", value1, value2, "adminUid");
            return (Criteria) this;
        }

        public Criteria andAdminUidNotBetween(Long value1, Long value2) {
            addCriterion("admin_uid not between", value1, value2, "adminUid");
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

        public Criteria andVerifyCodeIsNull() {
            addCriterion("verify_code is null");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeIsNotNull() {
            addCriterion("verify_code is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeEqualTo(String value) {
            addCriterion("verify_code =", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeNotEqualTo(String value) {
            addCriterion("verify_code <>", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeGreaterThan(String value) {
            addCriterion("verify_code >", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("verify_code >=", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeLessThan(String value) {
            addCriterion("verify_code <", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeLessThanOrEqualTo(String value) {
            addCriterion("verify_code <=", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeLike(String value) {
            addCriterion("verify_code like", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeNotLike(String value) {
            addCriterion("verify_code not like", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeIn(List<String> values) {
            addCriterion("verify_code in", values, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeNotIn(List<String> values) {
            addCriterion("verify_code not in", values, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeBetween(String value1, String value2) {
            addCriterion("verify_code between", value1, value2, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeNotBetween(String value1, String value2) {
            addCriterion("verify_code not between", value1, value2, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andUseTimeIsNull() {
            addCriterion("use_time is null");
            return (Criteria) this;
        }

        public Criteria andUseTimeIsNotNull() {
            addCriterion("use_time is not null");
            return (Criteria) this;
        }

        public Criteria andUseTimeEqualTo(Date value) {
            addCriterion("use_time =", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotEqualTo(Date value) {
            addCriterion("use_time <>", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThan(Date value) {
            addCriterion("use_time >", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("use_time >=", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThan(Date value) {
            addCriterion("use_time <", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThanOrEqualTo(Date value) {
            addCriterion("use_time <=", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeIn(List<Date> values) {
            addCriterion("use_time in", values, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotIn(List<Date> values) {
            addCriterion("use_time not in", values, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeBetween(Date value1, Date value2) {
            addCriterion("use_time between", value1, value2, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotBetween(Date value1, Date value2) {
            addCriterion("use_time not between", value1, value2, "useTime");
            return (Criteria) this;
        }

        public Criteria andReservationChannelsIsNull() {
            addCriterion("reservation_channels is null");
            return (Criteria) this;
        }

        public Criteria andReservationChannelsIsNotNull() {
            addCriterion("reservation_channels is not null");
            return (Criteria) this;
        }

        public Criteria andReservationChannelsEqualTo(Integer value) {
            addCriterion("reservation_channels =", value, "reservationChannels");
            return (Criteria) this;
        }

        public Criteria andReservationChannelsNotEqualTo(Integer value) {
            addCriterion("reservation_channels <>", value, "reservationChannels");
            return (Criteria) this;
        }

        public Criteria andReservationChannelsGreaterThan(Integer value) {
            addCriterion("reservation_channels >", value, "reservationChannels");
            return (Criteria) this;
        }

        public Criteria andReservationChannelsGreaterThanOrEqualTo(Integer value) {
            addCriterion("reservation_channels >=", value, "reservationChannels");
            return (Criteria) this;
        }

        public Criteria andReservationChannelsLessThan(Integer value) {
            addCriterion("reservation_channels <", value, "reservationChannels");
            return (Criteria) this;
        }

        public Criteria andReservationChannelsLessThanOrEqualTo(Integer value) {
            addCriterion("reservation_channels <=", value, "reservationChannels");
            return (Criteria) this;
        }

        public Criteria andReservationChannelsIn(List<Integer> values) {
            addCriterion("reservation_channels in", values, "reservationChannels");
            return (Criteria) this;
        }

        public Criteria andReservationChannelsNotIn(List<Integer> values) {
            addCriterion("reservation_channels not in", values, "reservationChannels");
            return (Criteria) this;
        }

        public Criteria andReservationChannelsBetween(Integer value1, Integer value2) {
            addCriterion("reservation_channels between", value1, value2, "reservationChannels");
            return (Criteria) this;
        }

        public Criteria andReservationChannelsNotBetween(Integer value1, Integer value2) {
            addCriterion("reservation_channels not between", value1, value2, "reservationChannels");
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