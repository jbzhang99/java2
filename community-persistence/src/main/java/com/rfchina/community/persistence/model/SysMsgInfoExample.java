package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysMsgInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysMsgInfoExample() {
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

        public Criteria andObjectKeyIsNull() {
            addCriterion("object_key is null");
            return (Criteria) this;
        }

        public Criteria andObjectKeyIsNotNull() {
            addCriterion("object_key is not null");
            return (Criteria) this;
        }

        public Criteria andObjectKeyEqualTo(String value) {
            addCriterion("object_key =", value, "objectKey");
            return (Criteria) this;
        }

        public Criteria andObjectKeyNotEqualTo(String value) {
            addCriterion("object_key <>", value, "objectKey");
            return (Criteria) this;
        }

        public Criteria andObjectKeyGreaterThan(String value) {
            addCriterion("object_key >", value, "objectKey");
            return (Criteria) this;
        }

        public Criteria andObjectKeyGreaterThanOrEqualTo(String value) {
            addCriterion("object_key >=", value, "objectKey");
            return (Criteria) this;
        }

        public Criteria andObjectKeyLessThan(String value) {
            addCriterion("object_key <", value, "objectKey");
            return (Criteria) this;
        }

        public Criteria andObjectKeyLessThanOrEqualTo(String value) {
            addCriterion("object_key <=", value, "objectKey");
            return (Criteria) this;
        }

        public Criteria andObjectKeyLike(String value) {
            addCriterion("object_key like", value, "objectKey");
            return (Criteria) this;
        }

        public Criteria andObjectKeyNotLike(String value) {
            addCriterion("object_key not like", value, "objectKey");
            return (Criteria) this;
        }

        public Criteria andObjectKeyIn(List<String> values) {
            addCriterion("object_key in", values, "objectKey");
            return (Criteria) this;
        }

        public Criteria andObjectKeyNotIn(List<String> values) {
            addCriterion("object_key not in", values, "objectKey");
            return (Criteria) this;
        }

        public Criteria andObjectKeyBetween(String value1, String value2) {
            addCriterion("object_key between", value1, value2, "objectKey");
            return (Criteria) this;
        }

        public Criteria andObjectKeyNotBetween(String value1, String value2) {
            addCriterion("object_key not between", value1, value2, "objectKey");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIsNull() {
            addCriterion("object_type is null");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIsNotNull() {
            addCriterion("object_type is not null");
            return (Criteria) this;
        }

        public Criteria andObjectTypeEqualTo(String value) {
            addCriterion("object_type =", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotEqualTo(String value) {
            addCriterion("object_type <>", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeGreaterThan(String value) {
            addCriterion("object_type >", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("object_type >=", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLessThan(String value) {
            addCriterion("object_type <", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLessThanOrEqualTo(String value) {
            addCriterion("object_type <=", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLike(String value) {
            addCriterion("object_type like", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotLike(String value) {
            addCriterion("object_type not like", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIn(List<String> values) {
            addCriterion("object_type in", values, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotIn(List<String> values) {
            addCriterion("object_type not in", values, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeBetween(String value1, String value2) {
            addCriterion("object_type between", value1, value2, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotBetween(String value1, String value2) {
            addCriterion("object_type not between", value1, value2, "objectType");
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

        public Criteria andCreateCommunityIdIsNull() {
            addCriterion("create_community_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateCommunityIdIsNotNull() {
            addCriterion("create_community_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateCommunityIdEqualTo(Integer value) {
            addCriterion("create_community_id =", value, "createCommunityId");
            return (Criteria) this;
        }

        public Criteria andCreateCommunityIdNotEqualTo(Integer value) {
            addCriterion("create_community_id <>", value, "createCommunityId");
            return (Criteria) this;
        }

        public Criteria andCreateCommunityIdGreaterThan(Integer value) {
            addCriterion("create_community_id >", value, "createCommunityId");
            return (Criteria) this;
        }

        public Criteria andCreateCommunityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_community_id >=", value, "createCommunityId");
            return (Criteria) this;
        }

        public Criteria andCreateCommunityIdLessThan(Integer value) {
            addCriterion("create_community_id <", value, "createCommunityId");
            return (Criteria) this;
        }

        public Criteria andCreateCommunityIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_community_id <=", value, "createCommunityId");
            return (Criteria) this;
        }

        public Criteria andCreateCommunityIdIn(List<Integer> values) {
            addCriterion("create_community_id in", values, "createCommunityId");
            return (Criteria) this;
        }

        public Criteria andCreateCommunityIdNotIn(List<Integer> values) {
            addCriterion("create_community_id not in", values, "createCommunityId");
            return (Criteria) this;
        }

        public Criteria andCreateCommunityIdBetween(Integer value1, Integer value2) {
            addCriterion("create_community_id between", value1, value2, "createCommunityId");
            return (Criteria) this;
        }

        public Criteria andCreateCommunityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_community_id not between", value1, value2, "createCommunityId");
            return (Criteria) this;
        }

        public Criteria andMsgSourceTypeIsNull() {
            addCriterion("msg_source_type is null");
            return (Criteria) this;
        }

        public Criteria andMsgSourceTypeIsNotNull() {
            addCriterion("msg_source_type is not null");
            return (Criteria) this;
        }

        public Criteria andMsgSourceTypeEqualTo(String value) {
            addCriterion("msg_source_type =", value, "msgSourceType");
            return (Criteria) this;
        }

        public Criteria andMsgSourceTypeNotEqualTo(String value) {
            addCriterion("msg_source_type <>", value, "msgSourceType");
            return (Criteria) this;
        }

        public Criteria andMsgSourceTypeGreaterThan(String value) {
            addCriterion("msg_source_type >", value, "msgSourceType");
            return (Criteria) this;
        }

        public Criteria andMsgSourceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("msg_source_type >=", value, "msgSourceType");
            return (Criteria) this;
        }

        public Criteria andMsgSourceTypeLessThan(String value) {
            addCriterion("msg_source_type <", value, "msgSourceType");
            return (Criteria) this;
        }

        public Criteria andMsgSourceTypeLessThanOrEqualTo(String value) {
            addCriterion("msg_source_type <=", value, "msgSourceType");
            return (Criteria) this;
        }

        public Criteria andMsgSourceTypeLike(String value) {
            addCriterion("msg_source_type like", value, "msgSourceType");
            return (Criteria) this;
        }

        public Criteria andMsgSourceTypeNotLike(String value) {
            addCriterion("msg_source_type not like", value, "msgSourceType");
            return (Criteria) this;
        }

        public Criteria andMsgSourceTypeIn(List<String> values) {
            addCriterion("msg_source_type in", values, "msgSourceType");
            return (Criteria) this;
        }

        public Criteria andMsgSourceTypeNotIn(List<String> values) {
            addCriterion("msg_source_type not in", values, "msgSourceType");
            return (Criteria) this;
        }

        public Criteria andMsgSourceTypeBetween(String value1, String value2) {
            addCriterion("msg_source_type between", value1, value2, "msgSourceType");
            return (Criteria) this;
        }

        public Criteria andMsgSourceTypeNotBetween(String value1, String value2) {
            addCriterion("msg_source_type not between", value1, value2, "msgSourceType");
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