package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VisitCommunityQrcodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VisitCommunityQrcodeExample() {
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

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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

        public Criteria andExpTimeIsNull() {
            addCriterion("exp_time is null");
            return (Criteria) this;
        }

        public Criteria andExpTimeIsNotNull() {
            addCriterion("exp_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpTimeEqualTo(Date value) {
            addCriterion("exp_time =", value, "expTime");
            return (Criteria) this;
        }

        public Criteria andExpTimeNotEqualTo(Date value) {
            addCriterion("exp_time <>", value, "expTime");
            return (Criteria) this;
        }

        public Criteria andExpTimeGreaterThan(Date value) {
            addCriterion("exp_time >", value, "expTime");
            return (Criteria) this;
        }

        public Criteria andExpTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("exp_time >=", value, "expTime");
            return (Criteria) this;
        }

        public Criteria andExpTimeLessThan(Date value) {
            addCriterion("exp_time <", value, "expTime");
            return (Criteria) this;
        }

        public Criteria andExpTimeLessThanOrEqualTo(Date value) {
            addCriterion("exp_time <=", value, "expTime");
            return (Criteria) this;
        }

        public Criteria andExpTimeIn(List<Date> values) {
            addCriterion("exp_time in", values, "expTime");
            return (Criteria) this;
        }

        public Criteria andExpTimeNotIn(List<Date> values) {
            addCriterion("exp_time not in", values, "expTime");
            return (Criteria) this;
        }

        public Criteria andExpTimeBetween(Date value1, Date value2) {
            addCriterion("exp_time between", value1, value2, "expTime");
            return (Criteria) this;
        }

        public Criteria andExpTimeNotBetween(Date value1, Date value2) {
            addCriterion("exp_time not between", value1, value2, "expTime");
            return (Criteria) this;
        }

        public Criteria andValidDateIsNull() {
            addCriterion("valid_date is null");
            return (Criteria) this;
        }

        public Criteria andValidDateIsNotNull() {
            addCriterion("valid_date is not null");
            return (Criteria) this;
        }

        public Criteria andValidDateEqualTo(Date value) {
            addCriterionForJDBCDate("valid_date =", value, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("valid_date <>", value, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateGreaterThan(Date value) {
            addCriterionForJDBCDate("valid_date >", value, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("valid_date >=", value, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateLessThan(Date value) {
            addCriterionForJDBCDate("valid_date <", value, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("valid_date <=", value, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateIn(List<Date> values) {
            addCriterionForJDBCDate("valid_date in", values, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("valid_date not in", values, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("valid_date between", value1, value2, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("valid_date not between", value1, value2, "validDate");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Long value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Long value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Long value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Long value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Long value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Long> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Long> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Long value1, Long value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Long value1, Long value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andUseInCountIsNull() {
            addCriterion("use_in_count is null");
            return (Criteria) this;
        }

        public Criteria andUseInCountIsNotNull() {
            addCriterion("use_in_count is not null");
            return (Criteria) this;
        }

        public Criteria andUseInCountEqualTo(Integer value) {
            addCriterion("use_in_count =", value, "useInCount");
            return (Criteria) this;
        }

        public Criteria andUseInCountNotEqualTo(Integer value) {
            addCriterion("use_in_count <>", value, "useInCount");
            return (Criteria) this;
        }

        public Criteria andUseInCountGreaterThan(Integer value) {
            addCriterion("use_in_count >", value, "useInCount");
            return (Criteria) this;
        }

        public Criteria andUseInCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_in_count >=", value, "useInCount");
            return (Criteria) this;
        }

        public Criteria andUseInCountLessThan(Integer value) {
            addCriterion("use_in_count <", value, "useInCount");
            return (Criteria) this;
        }

        public Criteria andUseInCountLessThanOrEqualTo(Integer value) {
            addCriterion("use_in_count <=", value, "useInCount");
            return (Criteria) this;
        }

        public Criteria andUseInCountIn(List<Integer> values) {
            addCriterion("use_in_count in", values, "useInCount");
            return (Criteria) this;
        }

        public Criteria andUseInCountNotIn(List<Integer> values) {
            addCriterion("use_in_count not in", values, "useInCount");
            return (Criteria) this;
        }

        public Criteria andUseInCountBetween(Integer value1, Integer value2) {
            addCriterion("use_in_count between", value1, value2, "useInCount");
            return (Criteria) this;
        }

        public Criteria andUseInCountNotBetween(Integer value1, Integer value2) {
            addCriterion("use_in_count not between", value1, value2, "useInCount");
            return (Criteria) this;
        }

        public Criteria andUseInTimeIsNull() {
            addCriterion("use_in_time is null");
            return (Criteria) this;
        }

        public Criteria andUseInTimeIsNotNull() {
            addCriterion("use_in_time is not null");
            return (Criteria) this;
        }

        public Criteria andUseInTimeEqualTo(Date value) {
            addCriterion("use_in_time =", value, "useInTime");
            return (Criteria) this;
        }

        public Criteria andUseInTimeNotEqualTo(Date value) {
            addCriterion("use_in_time <>", value, "useInTime");
            return (Criteria) this;
        }

        public Criteria andUseInTimeGreaterThan(Date value) {
            addCriterion("use_in_time >", value, "useInTime");
            return (Criteria) this;
        }

        public Criteria andUseInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("use_in_time >=", value, "useInTime");
            return (Criteria) this;
        }

        public Criteria andUseInTimeLessThan(Date value) {
            addCriterion("use_in_time <", value, "useInTime");
            return (Criteria) this;
        }

        public Criteria andUseInTimeLessThanOrEqualTo(Date value) {
            addCriterion("use_in_time <=", value, "useInTime");
            return (Criteria) this;
        }

        public Criteria andUseInTimeIn(List<Date> values) {
            addCriterion("use_in_time in", values, "useInTime");
            return (Criteria) this;
        }

        public Criteria andUseInTimeNotIn(List<Date> values) {
            addCriterion("use_in_time not in", values, "useInTime");
            return (Criteria) this;
        }

        public Criteria andUseInTimeBetween(Date value1, Date value2) {
            addCriterion("use_in_time between", value1, value2, "useInTime");
            return (Criteria) this;
        }

        public Criteria andUseInTimeNotBetween(Date value1, Date value2) {
            addCriterion("use_in_time not between", value1, value2, "useInTime");
            return (Criteria) this;
        }

        public Criteria andUseOutCountIsNull() {
            addCriterion("use_out_count is null");
            return (Criteria) this;
        }

        public Criteria andUseOutCountIsNotNull() {
            addCriterion("use_out_count is not null");
            return (Criteria) this;
        }

        public Criteria andUseOutCountEqualTo(Integer value) {
            addCriterion("use_out_count =", value, "useOutCount");
            return (Criteria) this;
        }

        public Criteria andUseOutCountNotEqualTo(Integer value) {
            addCriterion("use_out_count <>", value, "useOutCount");
            return (Criteria) this;
        }

        public Criteria andUseOutCountGreaterThan(Integer value) {
            addCriterion("use_out_count >", value, "useOutCount");
            return (Criteria) this;
        }

        public Criteria andUseOutCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_out_count >=", value, "useOutCount");
            return (Criteria) this;
        }

        public Criteria andUseOutCountLessThan(Integer value) {
            addCriterion("use_out_count <", value, "useOutCount");
            return (Criteria) this;
        }

        public Criteria andUseOutCountLessThanOrEqualTo(Integer value) {
            addCriterion("use_out_count <=", value, "useOutCount");
            return (Criteria) this;
        }

        public Criteria andUseOutCountIn(List<Integer> values) {
            addCriterion("use_out_count in", values, "useOutCount");
            return (Criteria) this;
        }

        public Criteria andUseOutCountNotIn(List<Integer> values) {
            addCriterion("use_out_count not in", values, "useOutCount");
            return (Criteria) this;
        }

        public Criteria andUseOutCountBetween(Integer value1, Integer value2) {
            addCriterion("use_out_count between", value1, value2, "useOutCount");
            return (Criteria) this;
        }

        public Criteria andUseOutCountNotBetween(Integer value1, Integer value2) {
            addCriterion("use_out_count not between", value1, value2, "useOutCount");
            return (Criteria) this;
        }

        public Criteria andUseOutTimeIsNull() {
            addCriterion("use_out_time is null");
            return (Criteria) this;
        }

        public Criteria andUseOutTimeIsNotNull() {
            addCriterion("use_out_time is not null");
            return (Criteria) this;
        }

        public Criteria andUseOutTimeEqualTo(Date value) {
            addCriterion("use_out_time =", value, "useOutTime");
            return (Criteria) this;
        }

        public Criteria andUseOutTimeNotEqualTo(Date value) {
            addCriterion("use_out_time <>", value, "useOutTime");
            return (Criteria) this;
        }

        public Criteria andUseOutTimeGreaterThan(Date value) {
            addCriterion("use_out_time >", value, "useOutTime");
            return (Criteria) this;
        }

        public Criteria andUseOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("use_out_time >=", value, "useOutTime");
            return (Criteria) this;
        }

        public Criteria andUseOutTimeLessThan(Date value) {
            addCriterion("use_out_time <", value, "useOutTime");
            return (Criteria) this;
        }

        public Criteria andUseOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("use_out_time <=", value, "useOutTime");
            return (Criteria) this;
        }

        public Criteria andUseOutTimeIn(List<Date> values) {
            addCriterion("use_out_time in", values, "useOutTime");
            return (Criteria) this;
        }

        public Criteria andUseOutTimeNotIn(List<Date> values) {
            addCriterion("use_out_time not in", values, "useOutTime");
            return (Criteria) this;
        }

        public Criteria andUseOutTimeBetween(Date value1, Date value2) {
            addCriterion("use_out_time between", value1, value2, "useOutTime");
            return (Criteria) this;
        }

        public Criteria andUseOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("use_out_time not between", value1, value2, "useOutTime");
            return (Criteria) this;
        }

        public Criteria andCreateIpIsNull() {
            addCriterion("create_ip is null");
            return (Criteria) this;
        }

        public Criteria andCreateIpIsNotNull() {
            addCriterion("create_ip is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIpEqualTo(String value) {
            addCriterion("create_ip =", value, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpNotEqualTo(String value) {
            addCriterion("create_ip <>", value, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpGreaterThan(String value) {
            addCriterion("create_ip >", value, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpGreaterThanOrEqualTo(String value) {
            addCriterion("create_ip >=", value, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpLessThan(String value) {
            addCriterion("create_ip <", value, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpLessThanOrEqualTo(String value) {
            addCriterion("create_ip <=", value, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpLike(String value) {
            addCriterion("create_ip like", value, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpNotLike(String value) {
            addCriterion("create_ip not like", value, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpIn(List<String> values) {
            addCriterion("create_ip in", values, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpNotIn(List<String> values) {
            addCriterion("create_ip not in", values, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpBetween(String value1, String value2) {
            addCriterion("create_ip between", value1, value2, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpNotBetween(String value1, String value2) {
            addCriterion("create_ip not between", value1, value2, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreatePhoneIsNull() {
            addCriterion("create_phone is null");
            return (Criteria) this;
        }

        public Criteria andCreatePhoneIsNotNull() {
            addCriterion("create_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCreatePhoneEqualTo(String value) {
            addCriterion("create_phone =", value, "createPhone");
            return (Criteria) this;
        }

        public Criteria andCreatePhoneNotEqualTo(String value) {
            addCriterion("create_phone <>", value, "createPhone");
            return (Criteria) this;
        }

        public Criteria andCreatePhoneGreaterThan(String value) {
            addCriterion("create_phone >", value, "createPhone");
            return (Criteria) this;
        }

        public Criteria andCreatePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("create_phone >=", value, "createPhone");
            return (Criteria) this;
        }

        public Criteria andCreatePhoneLessThan(String value) {
            addCriterion("create_phone <", value, "createPhone");
            return (Criteria) this;
        }

        public Criteria andCreatePhoneLessThanOrEqualTo(String value) {
            addCriterion("create_phone <=", value, "createPhone");
            return (Criteria) this;
        }

        public Criteria andCreatePhoneLike(String value) {
            addCriterion("create_phone like", value, "createPhone");
            return (Criteria) this;
        }

        public Criteria andCreatePhoneNotLike(String value) {
            addCriterion("create_phone not like", value, "createPhone");
            return (Criteria) this;
        }

        public Criteria andCreatePhoneIn(List<String> values) {
            addCriterion("create_phone in", values, "createPhone");
            return (Criteria) this;
        }

        public Criteria andCreatePhoneNotIn(List<String> values) {
            addCriterion("create_phone not in", values, "createPhone");
            return (Criteria) this;
        }

        public Criteria andCreatePhoneBetween(String value1, String value2) {
            addCriterion("create_phone between", value1, value2, "createPhone");
            return (Criteria) this;
        }

        public Criteria andCreatePhoneNotBetween(String value1, String value2) {
            addCriterion("create_phone not between", value1, value2, "createPhone");
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

        public Criteria andIsPrintIsNull() {
            addCriterion("is_print is null");
            return (Criteria) this;
        }

        public Criteria andIsPrintIsNotNull() {
            addCriterion("is_print is not null");
            return (Criteria) this;
        }

        public Criteria andIsPrintEqualTo(Integer value) {
            addCriterion("is_print =", value, "isPrint");
            return (Criteria) this;
        }

        public Criteria andIsPrintNotEqualTo(Integer value) {
            addCriterion("is_print <>", value, "isPrint");
            return (Criteria) this;
        }

        public Criteria andIsPrintGreaterThan(Integer value) {
            addCriterion("is_print >", value, "isPrint");
            return (Criteria) this;
        }

        public Criteria andIsPrintGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_print >=", value, "isPrint");
            return (Criteria) this;
        }

        public Criteria andIsPrintLessThan(Integer value) {
            addCriterion("is_print <", value, "isPrint");
            return (Criteria) this;
        }

        public Criteria andIsPrintLessThanOrEqualTo(Integer value) {
            addCriterion("is_print <=", value, "isPrint");
            return (Criteria) this;
        }

        public Criteria andIsPrintIn(List<Integer> values) {
            addCriterion("is_print in", values, "isPrint");
            return (Criteria) this;
        }

        public Criteria andIsPrintNotIn(List<Integer> values) {
            addCriterion("is_print not in", values, "isPrint");
            return (Criteria) this;
        }

        public Criteria andIsPrintBetween(Integer value1, Integer value2) {
            addCriterion("is_print between", value1, value2, "isPrint");
            return (Criteria) this;
        }

        public Criteria andIsPrintNotBetween(Integer value1, Integer value2) {
            addCriterion("is_print not between", value1, value2, "isPrint");
            return (Criteria) this;
        }

        public Criteria andPrintTimeIsNull() {
            addCriterion("print_time is null");
            return (Criteria) this;
        }

        public Criteria andPrintTimeIsNotNull() {
            addCriterion("print_time is not null");
            return (Criteria) this;
        }

        public Criteria andPrintTimeEqualTo(Date value) {
            addCriterion("print_time =", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeNotEqualTo(Date value) {
            addCriterion("print_time <>", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeGreaterThan(Date value) {
            addCriterion("print_time >", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("print_time >=", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeLessThan(Date value) {
            addCriterion("print_time <", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeLessThanOrEqualTo(Date value) {
            addCriterion("print_time <=", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeIn(List<Date> values) {
            addCriterion("print_time in", values, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeNotIn(List<Date> values) {
            addCriterion("print_time not in", values, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeBetween(Date value1, Date value2) {
            addCriterion("print_time between", value1, value2, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeNotBetween(Date value1, Date value2) {
            addCriterion("print_time not between", value1, value2, "printTime");
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