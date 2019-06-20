package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResourcePatrolInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourcePatrolInfoExample() {
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

        public Criteria andPatrolIdIsNull() {
            addCriterion("patrol_id is null");
            return (Criteria) this;
        }

        public Criteria andPatrolIdIsNotNull() {
            addCriterion("patrol_id is not null");
            return (Criteria) this;
        }

        public Criteria andPatrolIdEqualTo(Long value) {
            addCriterion("patrol_id =", value, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolIdNotEqualTo(Long value) {
            addCriterion("patrol_id <>", value, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolIdGreaterThan(Long value) {
            addCriterion("patrol_id >", value, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolIdGreaterThanOrEqualTo(Long value) {
            addCriterion("patrol_id >=", value, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolIdLessThan(Long value) {
            addCriterion("patrol_id <", value, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolIdLessThanOrEqualTo(Long value) {
            addCriterion("patrol_id <=", value, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolIdIn(List<Long> values) {
            addCriterion("patrol_id in", values, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolIdNotIn(List<Long> values) {
            addCriterion("patrol_id not in", values, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolIdBetween(Long value1, Long value2) {
            addCriterion("patrol_id between", value1, value2, "patrolId");
            return (Criteria) this;
        }

        public Criteria andPatrolIdNotBetween(Long value1, Long value2) {
            addCriterion("patrol_id not between", value1, value2, "patrolId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdIsNull() {
            addCriterion("xfsj_id is null");
            return (Criteria) this;
        }

        public Criteria andXfsjIdIsNotNull() {
            addCriterion("xfsj_id is not null");
            return (Criteria) this;
        }

        public Criteria andXfsjIdEqualTo(Long value) {
            addCriterion("xfsj_id =", value, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdNotEqualTo(Long value) {
            addCriterion("xfsj_id <>", value, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdGreaterThan(Long value) {
            addCriterion("xfsj_id >", value, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdGreaterThanOrEqualTo(Long value) {
            addCriterion("xfsj_id >=", value, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdLessThan(Long value) {
            addCriterion("xfsj_id <", value, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdLessThanOrEqualTo(Long value) {
            addCriterion("xfsj_id <=", value, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdIn(List<Long> values) {
            addCriterion("xfsj_id in", values, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdNotIn(List<Long> values) {
            addCriterion("xfsj_id not in", values, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdBetween(Long value1, Long value2) {
            addCriterion("xfsj_id between", value1, value2, "xfsjId");
            return (Criteria) this;
        }

        public Criteria andXfsjIdNotBetween(Long value1, Long value2) {
            addCriterion("xfsj_id not between", value1, value2, "xfsjId");
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

        public Criteria andEmpGuidIsNull() {
            addCriterion("emp_guid is null");
            return (Criteria) this;
        }

        public Criteria andEmpGuidIsNotNull() {
            addCriterion("emp_guid is not null");
            return (Criteria) this;
        }

        public Criteria andEmpGuidEqualTo(String value) {
            addCriterion("emp_guid =", value, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidNotEqualTo(String value) {
            addCriterion("emp_guid <>", value, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidGreaterThan(String value) {
            addCriterion("emp_guid >", value, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidGreaterThanOrEqualTo(String value) {
            addCriterion("emp_guid >=", value, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidLessThan(String value) {
            addCriterion("emp_guid <", value, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidLessThanOrEqualTo(String value) {
            addCriterion("emp_guid <=", value, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidLike(String value) {
            addCriterion("emp_guid like", value, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidNotLike(String value) {
            addCriterion("emp_guid not like", value, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidIn(List<String> values) {
            addCriterion("emp_guid in", values, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidNotIn(List<String> values) {
            addCriterion("emp_guid not in", values, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidBetween(String value1, String value2) {
            addCriterion("emp_guid between", value1, value2, "empGuid");
            return (Criteria) this;
        }

        public Criteria andEmpGuidNotBetween(String value1, String value2) {
            addCriterion("emp_guid not between", value1, value2, "empGuid");
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

        public Criteria andPatrolStatusIsNull() {
            addCriterion("patrol_status is null");
            return (Criteria) this;
        }

        public Criteria andPatrolStatusIsNotNull() {
            addCriterion("patrol_status is not null");
            return (Criteria) this;
        }

        public Criteria andPatrolStatusEqualTo(Integer value) {
            addCriterion("patrol_status =", value, "patrolStatus");
            return (Criteria) this;
        }

        public Criteria andPatrolStatusNotEqualTo(Integer value) {
            addCriterion("patrol_status <>", value, "patrolStatus");
            return (Criteria) this;
        }

        public Criteria andPatrolStatusGreaterThan(Integer value) {
            addCriterion("patrol_status >", value, "patrolStatus");
            return (Criteria) this;
        }

        public Criteria andPatrolStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("patrol_status >=", value, "patrolStatus");
            return (Criteria) this;
        }

        public Criteria andPatrolStatusLessThan(Integer value) {
            addCriterion("patrol_status <", value, "patrolStatus");
            return (Criteria) this;
        }

        public Criteria andPatrolStatusLessThanOrEqualTo(Integer value) {
            addCriterion("patrol_status <=", value, "patrolStatus");
            return (Criteria) this;
        }

        public Criteria andPatrolStatusIn(List<Integer> values) {
            addCriterion("patrol_status in", values, "patrolStatus");
            return (Criteria) this;
        }

        public Criteria andPatrolStatusNotIn(List<Integer> values) {
            addCriterion("patrol_status not in", values, "patrolStatus");
            return (Criteria) this;
        }

        public Criteria andPatrolStatusBetween(Integer value1, Integer value2) {
            addCriterion("patrol_status between", value1, value2, "patrolStatus");
            return (Criteria) this;
        }

        public Criteria andPatrolStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("patrol_status not between", value1, value2, "patrolStatus");
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