package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.List;

public class VisitCommunityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VisitCommunityExample() {
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

        public Criteria andFollowMaxIsNull() {
            addCriterion("follow_max is null");
            return (Criteria) this;
        }

        public Criteria andFollowMaxIsNotNull() {
            addCriterion("follow_max is not null");
            return (Criteria) this;
        }

        public Criteria andFollowMaxEqualTo(Integer value) {
            addCriterion("follow_max =", value, "followMax");
            return (Criteria) this;
        }

        public Criteria andFollowMaxNotEqualTo(Integer value) {
            addCriterion("follow_max <>", value, "followMax");
            return (Criteria) this;
        }

        public Criteria andFollowMaxGreaterThan(Integer value) {
            addCriterion("follow_max >", value, "followMax");
            return (Criteria) this;
        }

        public Criteria andFollowMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("follow_max >=", value, "followMax");
            return (Criteria) this;
        }

        public Criteria andFollowMaxLessThan(Integer value) {
            addCriterion("follow_max <", value, "followMax");
            return (Criteria) this;
        }

        public Criteria andFollowMaxLessThanOrEqualTo(Integer value) {
            addCriterion("follow_max <=", value, "followMax");
            return (Criteria) this;
        }

        public Criteria andFollowMaxIn(List<Integer> values) {
            addCriterion("follow_max in", values, "followMax");
            return (Criteria) this;
        }

        public Criteria andFollowMaxNotIn(List<Integer> values) {
            addCriterion("follow_max not in", values, "followMax");
            return (Criteria) this;
        }

        public Criteria andFollowMaxBetween(Integer value1, Integer value2) {
            addCriterion("follow_max between", value1, value2, "followMax");
            return (Criteria) this;
        }

        public Criteria andFollowMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("follow_max not between", value1, value2, "followMax");
            return (Criteria) this;
        }

        public Criteria andFollowMustIsNull() {
            addCriterion("follow_must is null");
            return (Criteria) this;
        }

        public Criteria andFollowMustIsNotNull() {
            addCriterion("follow_must is not null");
            return (Criteria) this;
        }

        public Criteria andFollowMustEqualTo(Integer value) {
            addCriterion("follow_must =", value, "followMust");
            return (Criteria) this;
        }

        public Criteria andFollowMustNotEqualTo(Integer value) {
            addCriterion("follow_must <>", value, "followMust");
            return (Criteria) this;
        }

        public Criteria andFollowMustGreaterThan(Integer value) {
            addCriterion("follow_must >", value, "followMust");
            return (Criteria) this;
        }

        public Criteria andFollowMustGreaterThanOrEqualTo(Integer value) {
            addCriterion("follow_must >=", value, "followMust");
            return (Criteria) this;
        }

        public Criteria andFollowMustLessThan(Integer value) {
            addCriterion("follow_must <", value, "followMust");
            return (Criteria) this;
        }

        public Criteria andFollowMustLessThanOrEqualTo(Integer value) {
            addCriterion("follow_must <=", value, "followMust");
            return (Criteria) this;
        }

        public Criteria andFollowMustIn(List<Integer> values) {
            addCriterion("follow_must in", values, "followMust");
            return (Criteria) this;
        }

        public Criteria andFollowMustNotIn(List<Integer> values) {
            addCriterion("follow_must not in", values, "followMust");
            return (Criteria) this;
        }

        public Criteria andFollowMustBetween(Integer value1, Integer value2) {
            addCriterion("follow_must between", value1, value2, "followMust");
            return (Criteria) this;
        }

        public Criteria andFollowMustNotBetween(Integer value1, Integer value2) {
            addCriterion("follow_must not between", value1, value2, "followMust");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNull() {
            addCriterion("open_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNotNull() {
            addCriterion("open_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeEqualTo(String value) {
            addCriterion("open_time =", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotEqualTo(String value) {
            addCriterion("open_time <>", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThan(String value) {
            addCriterion("open_time >", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThanOrEqualTo(String value) {
            addCriterion("open_time >=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThan(String value) {
            addCriterion("open_time <", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThanOrEqualTo(String value) {
            addCriterion("open_time <=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLike(String value) {
            addCriterion("open_time like", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotLike(String value) {
            addCriterion("open_time not like", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIn(List<String> values) {
            addCriterion("open_time in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotIn(List<String> values) {
            addCriterion("open_time not in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeBetween(String value1, String value2) {
            addCriterion("open_time between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotBetween(String value1, String value2) {
            addCriterion("open_time not between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andClosingTimeIsNull() {
            addCriterion("closing_time is null");
            return (Criteria) this;
        }

        public Criteria andClosingTimeIsNotNull() {
            addCriterion("closing_time is not null");
            return (Criteria) this;
        }

        public Criteria andClosingTimeEqualTo(String value) {
            addCriterion("closing_time =", value, "closingTime");
            return (Criteria) this;
        }

        public Criteria andClosingTimeNotEqualTo(String value) {
            addCriterion("closing_time <>", value, "closingTime");
            return (Criteria) this;
        }

        public Criteria andClosingTimeGreaterThan(String value) {
            addCriterion("closing_time >", value, "closingTime");
            return (Criteria) this;
        }

        public Criteria andClosingTimeGreaterThanOrEqualTo(String value) {
            addCriterion("closing_time >=", value, "closingTime");
            return (Criteria) this;
        }

        public Criteria andClosingTimeLessThan(String value) {
            addCriterion("closing_time <", value, "closingTime");
            return (Criteria) this;
        }

        public Criteria andClosingTimeLessThanOrEqualTo(String value) {
            addCriterion("closing_time <=", value, "closingTime");
            return (Criteria) this;
        }

        public Criteria andClosingTimeLike(String value) {
            addCriterion("closing_time like", value, "closingTime");
            return (Criteria) this;
        }

        public Criteria andClosingTimeNotLike(String value) {
            addCriterion("closing_time not like", value, "closingTime");
            return (Criteria) this;
        }

        public Criteria andClosingTimeIn(List<String> values) {
            addCriterion("closing_time in", values, "closingTime");
            return (Criteria) this;
        }

        public Criteria andClosingTimeNotIn(List<String> values) {
            addCriterion("closing_time not in", values, "closingTime");
            return (Criteria) this;
        }

        public Criteria andClosingTimeBetween(String value1, String value2) {
            addCriterion("closing_time between", value1, value2, "closingTime");
            return (Criteria) this;
        }

        public Criteria andClosingTimeNotBetween(String value1, String value2) {
            addCriterion("closing_time not between", value1, value2, "closingTime");
            return (Criteria) this;
        }

        public Criteria andIsEntranceGuardIsNull() {
            addCriterion("is_entrance_guard is null");
            return (Criteria) this;
        }

        public Criteria andIsEntranceGuardIsNotNull() {
            addCriterion("is_entrance_guard is not null");
            return (Criteria) this;
        }

        public Criteria andIsEntranceGuardEqualTo(Integer value) {
            addCriterion("is_entrance_guard =", value, "isEntranceGuard");
            return (Criteria) this;
        }

        public Criteria andIsEntranceGuardNotEqualTo(Integer value) {
            addCriterion("is_entrance_guard <>", value, "isEntranceGuard");
            return (Criteria) this;
        }

        public Criteria andIsEntranceGuardGreaterThan(Integer value) {
            addCriterion("is_entrance_guard >", value, "isEntranceGuard");
            return (Criteria) this;
        }

        public Criteria andIsEntranceGuardGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_entrance_guard >=", value, "isEntranceGuard");
            return (Criteria) this;
        }

        public Criteria andIsEntranceGuardLessThan(Integer value) {
            addCriterion("is_entrance_guard <", value, "isEntranceGuard");
            return (Criteria) this;
        }

        public Criteria andIsEntranceGuardLessThanOrEqualTo(Integer value) {
            addCriterion("is_entrance_guard <=", value, "isEntranceGuard");
            return (Criteria) this;
        }

        public Criteria andIsEntranceGuardIn(List<Integer> values) {
            addCriterion("is_entrance_guard in", values, "isEntranceGuard");
            return (Criteria) this;
        }

        public Criteria andIsEntranceGuardNotIn(List<Integer> values) {
            addCriterion("is_entrance_guard not in", values, "isEntranceGuard");
            return (Criteria) this;
        }

        public Criteria andIsEntranceGuardBetween(Integer value1, Integer value2) {
            addCriterion("is_entrance_guard between", value1, value2, "isEntranceGuard");
            return (Criteria) this;
        }

        public Criteria andIsEntranceGuardNotBetween(Integer value1, Integer value2) {
            addCriterion("is_entrance_guard not between", value1, value2, "isEntranceGuard");
            return (Criteria) this;
        }

        public Criteria andEntranceGuardTypeIsNull() {
            addCriterion("entrance_guard_type is null");
            return (Criteria) this;
        }

        public Criteria andEntranceGuardTypeIsNotNull() {
            addCriterion("entrance_guard_type is not null");
            return (Criteria) this;
        }

        public Criteria andEntranceGuardTypeEqualTo(Integer value) {
            addCriterion("entrance_guard_type =", value, "entranceGuardType");
            return (Criteria) this;
        }

        public Criteria andEntranceGuardTypeNotEqualTo(Integer value) {
            addCriterion("entrance_guard_type <>", value, "entranceGuardType");
            return (Criteria) this;
        }

        public Criteria andEntranceGuardTypeGreaterThan(Integer value) {
            addCriterion("entrance_guard_type >", value, "entranceGuardType");
            return (Criteria) this;
        }

        public Criteria andEntranceGuardTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("entrance_guard_type >=", value, "entranceGuardType");
            return (Criteria) this;
        }

        public Criteria andEntranceGuardTypeLessThan(Integer value) {
            addCriterion("entrance_guard_type <", value, "entranceGuardType");
            return (Criteria) this;
        }

        public Criteria andEntranceGuardTypeLessThanOrEqualTo(Integer value) {
            addCriterion("entrance_guard_type <=", value, "entranceGuardType");
            return (Criteria) this;
        }

        public Criteria andEntranceGuardTypeIn(List<Integer> values) {
            addCriterion("entrance_guard_type in", values, "entranceGuardType");
            return (Criteria) this;
        }

        public Criteria andEntranceGuardTypeNotIn(List<Integer> values) {
            addCriterion("entrance_guard_type not in", values, "entranceGuardType");
            return (Criteria) this;
        }

        public Criteria andEntranceGuardTypeBetween(Integer value1, Integer value2) {
            addCriterion("entrance_guard_type between", value1, value2, "entranceGuardType");
            return (Criteria) this;
        }

        public Criteria andEntranceGuardTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("entrance_guard_type not between", value1, value2, "entranceGuardType");
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