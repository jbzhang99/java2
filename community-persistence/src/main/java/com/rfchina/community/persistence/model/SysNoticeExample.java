package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysNoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysNoticeExample() {
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

        public Criteria andCreateCommIsNull() {
            addCriterion("create_comm is null");
            return (Criteria) this;
        }

        public Criteria andCreateCommIsNotNull() {
            addCriterion("create_comm is not null");
            return (Criteria) this;
        }

        public Criteria andCreateCommEqualTo(Integer value) {
            addCriterion("create_comm =", value, "createComm");
            return (Criteria) this;
        }

        public Criteria andCreateCommNotEqualTo(Integer value) {
            addCriterion("create_comm <>", value, "createComm");
            return (Criteria) this;
        }

        public Criteria andCreateCommGreaterThan(Integer value) {
            addCriterion("create_comm >", value, "createComm");
            return (Criteria) this;
        }

        public Criteria andCreateCommGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_comm >=", value, "createComm");
            return (Criteria) this;
        }

        public Criteria andCreateCommLessThan(Integer value) {
            addCriterion("create_comm <", value, "createComm");
            return (Criteria) this;
        }

        public Criteria andCreateCommLessThanOrEqualTo(Integer value) {
            addCriterion("create_comm <=", value, "createComm");
            return (Criteria) this;
        }

        public Criteria andCreateCommIn(List<Integer> values) {
            addCriterion("create_comm in", values, "createComm");
            return (Criteria) this;
        }

        public Criteria andCreateCommNotIn(List<Integer> values) {
            addCriterion("create_comm not in", values, "createComm");
            return (Criteria) this;
        }

        public Criteria andCreateCommBetween(Integer value1, Integer value2) {
            addCriterion("create_comm between", value1, value2, "createComm");
            return (Criteria) this;
        }

        public Criteria andCreateCommNotBetween(Integer value1, Integer value2) {
            addCriterion("create_comm not between", value1, value2, "createComm");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNull() {
            addCriterion("create_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("create_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(Long value) {
            addCriterion("create_id =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(Long value) {
            addCriterion("create_id <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(Long value) {
            addCriterion("create_id >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("create_id >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(Long value) {
            addCriterion("create_id <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(Long value) {
            addCriterion("create_id <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<Long> values) {
            addCriterion("create_id in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<Long> values) {
            addCriterion("create_id not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(Long value1, Long value2) {
            addCriterion("create_id between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(Long value1, Long value2) {
            addCriterion("create_id not between", value1, value2, "createId");
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andPlatformUidIsNull() {
            addCriterion("platform_uid is null");
            return (Criteria) this;
        }

        public Criteria andPlatformUidIsNotNull() {
            addCriterion("platform_uid is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformUidEqualTo(Long value) {
            addCriterion("platform_uid =", value, "platformUid");
            return (Criteria) this;
        }

        public Criteria andPlatformUidNotEqualTo(Long value) {
            addCriterion("platform_uid <>", value, "platformUid");
            return (Criteria) this;
        }

        public Criteria andPlatformUidGreaterThan(Long value) {
            addCriterion("platform_uid >", value, "platformUid");
            return (Criteria) this;
        }

        public Criteria andPlatformUidGreaterThanOrEqualTo(Long value) {
            addCriterion("platform_uid >=", value, "platformUid");
            return (Criteria) this;
        }

        public Criteria andPlatformUidLessThan(Long value) {
            addCriterion("platform_uid <", value, "platformUid");
            return (Criteria) this;
        }

        public Criteria andPlatformUidLessThanOrEqualTo(Long value) {
            addCriterion("platform_uid <=", value, "platformUid");
            return (Criteria) this;
        }

        public Criteria andPlatformUidIn(List<Long> values) {
            addCriterion("platform_uid in", values, "platformUid");
            return (Criteria) this;
        }

        public Criteria andPlatformUidNotIn(List<Long> values) {
            addCriterion("platform_uid not in", values, "platformUid");
            return (Criteria) this;
        }

        public Criteria andPlatformUidBetween(Long value1, Long value2) {
            addCriterion("platform_uid between", value1, value2, "platformUid");
            return (Criteria) this;
        }

        public Criteria andPlatformUidNotBetween(Long value1, Long value2) {
            addCriterion("platform_uid not between", value1, value2, "platformUid");
            return (Criteria) this;
        }

        public Criteria andCommUidIsNull() {
            addCriterion("comm_uid is null");
            return (Criteria) this;
        }

        public Criteria andCommUidIsNotNull() {
            addCriterion("comm_uid is not null");
            return (Criteria) this;
        }

        public Criteria andCommUidEqualTo(Long value) {
            addCriterion("comm_uid =", value, "commUid");
            return (Criteria) this;
        }

        public Criteria andCommUidNotEqualTo(Long value) {
            addCriterion("comm_uid <>", value, "commUid");
            return (Criteria) this;
        }

        public Criteria andCommUidGreaterThan(Long value) {
            addCriterion("comm_uid >", value, "commUid");
            return (Criteria) this;
        }

        public Criteria andCommUidGreaterThanOrEqualTo(Long value) {
            addCriterion("comm_uid >=", value, "commUid");
            return (Criteria) this;
        }

        public Criteria andCommUidLessThan(Long value) {
            addCriterion("comm_uid <", value, "commUid");
            return (Criteria) this;
        }

        public Criteria andCommUidLessThanOrEqualTo(Long value) {
            addCriterion("comm_uid <=", value, "commUid");
            return (Criteria) this;
        }

        public Criteria andCommUidIn(List<Long> values) {
            addCriterion("comm_uid in", values, "commUid");
            return (Criteria) this;
        }

        public Criteria andCommUidNotIn(List<Long> values) {
            addCriterion("comm_uid not in", values, "commUid");
            return (Criteria) this;
        }

        public Criteria andCommUidBetween(Long value1, Long value2) {
            addCriterion("comm_uid between", value1, value2, "commUid");
            return (Criteria) this;
        }

        public Criteria andCommUidNotBetween(Long value1, Long value2) {
            addCriterion("comm_uid not between", value1, value2, "commUid");
            return (Criteria) this;
        }

        public Criteria andMasterUidIsNull() {
            addCriterion("master_uid is null");
            return (Criteria) this;
        }

        public Criteria andMasterUidIsNotNull() {
            addCriterion("master_uid is not null");
            return (Criteria) this;
        }

        public Criteria andMasterUidEqualTo(Long value) {
            addCriterion("master_uid =", value, "masterUid");
            return (Criteria) this;
        }

        public Criteria andMasterUidNotEqualTo(Long value) {
            addCriterion("master_uid <>", value, "masterUid");
            return (Criteria) this;
        }

        public Criteria andMasterUidGreaterThan(Long value) {
            addCriterion("master_uid >", value, "masterUid");
            return (Criteria) this;
        }

        public Criteria andMasterUidGreaterThanOrEqualTo(Long value) {
            addCriterion("master_uid >=", value, "masterUid");
            return (Criteria) this;
        }

        public Criteria andMasterUidLessThan(Long value) {
            addCriterion("master_uid <", value, "masterUid");
            return (Criteria) this;
        }

        public Criteria andMasterUidLessThanOrEqualTo(Long value) {
            addCriterion("master_uid <=", value, "masterUid");
            return (Criteria) this;
        }

        public Criteria andMasterUidIn(List<Long> values) {
            addCriterion("master_uid in", values, "masterUid");
            return (Criteria) this;
        }

        public Criteria andMasterUidNotIn(List<Long> values) {
            addCriterion("master_uid not in", values, "masterUid");
            return (Criteria) this;
        }

        public Criteria andMasterUidBetween(Long value1, Long value2) {
            addCriterion("master_uid between", value1, value2, "masterUid");
            return (Criteria) this;
        }

        public Criteria andMasterUidNotBetween(Long value1, Long value2) {
            addCriterion("master_uid not between", value1, value2, "masterUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidIsNull() {
            addCriterion("seller_uid is null");
            return (Criteria) this;
        }

        public Criteria andSellerUidIsNotNull() {
            addCriterion("seller_uid is not null");
            return (Criteria) this;
        }

        public Criteria andSellerUidEqualTo(Long value) {
            addCriterion("seller_uid =", value, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidNotEqualTo(Long value) {
            addCriterion("seller_uid <>", value, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidGreaterThan(Long value) {
            addCriterion("seller_uid >", value, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidGreaterThanOrEqualTo(Long value) {
            addCriterion("seller_uid >=", value, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidLessThan(Long value) {
            addCriterion("seller_uid <", value, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidLessThanOrEqualTo(Long value) {
            addCriterion("seller_uid <=", value, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidIn(List<Long> values) {
            addCriterion("seller_uid in", values, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidNotIn(List<Long> values) {
            addCriterion("seller_uid not in", values, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidBetween(Long value1, Long value2) {
            addCriterion("seller_uid between", value1, value2, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidNotBetween(Long value1, Long value2) {
            addCriterion("seller_uid not between", value1, value2, "sellerUid");
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