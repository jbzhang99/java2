package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BonusPointActionRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BonusPointActionRuleExample() {
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

        public Criteria andActionIsNull() {
            addCriterion("action is null");
            return (Criteria) this;
        }

        public Criteria andActionIsNotNull() {
            addCriterion("action is not null");
            return (Criteria) this;
        }

        public Criteria andActionEqualTo(String value) {
            addCriterion("action =", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotEqualTo(String value) {
            addCriterion("action <>", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThan(String value) {
            addCriterion("action >", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThanOrEqualTo(String value) {
            addCriterion("action >=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThan(String value) {
            addCriterion("action <", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThanOrEqualTo(String value) {
            addCriterion("action <=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLike(String value) {
            addCriterion("action like", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotLike(String value) {
            addCriterion("action not like", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionIn(List<String> values) {
            addCriterion("action in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotIn(List<String> values) {
            addCriterion("action not in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionBetween(String value1, String value2) {
            addCriterion("action between", value1, value2, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotBetween(String value1, String value2) {
            addCriterion("action not between", value1, value2, "action");
            return (Criteria) this;
        }

        public Criteria andBpRuleIsNull() {
            addCriterion("bp_rule is null");
            return (Criteria) this;
        }

        public Criteria andBpRuleIsNotNull() {
            addCriterion("bp_rule is not null");
            return (Criteria) this;
        }

        public Criteria andBpRuleEqualTo(String value) {
            addCriterion("bp_rule =", value, "bpRule");
            return (Criteria) this;
        }

        public Criteria andBpRuleNotEqualTo(String value) {
            addCriterion("bp_rule <>", value, "bpRule");
            return (Criteria) this;
        }

        public Criteria andBpRuleGreaterThan(String value) {
            addCriterion("bp_rule >", value, "bpRule");
            return (Criteria) this;
        }

        public Criteria andBpRuleGreaterThanOrEqualTo(String value) {
            addCriterion("bp_rule >=", value, "bpRule");
            return (Criteria) this;
        }

        public Criteria andBpRuleLessThan(String value) {
            addCriterion("bp_rule <", value, "bpRule");
            return (Criteria) this;
        }

        public Criteria andBpRuleLessThanOrEqualTo(String value) {
            addCriterion("bp_rule <=", value, "bpRule");
            return (Criteria) this;
        }

        public Criteria andBpRuleLike(String value) {
            addCriterion("bp_rule like", value, "bpRule");
            return (Criteria) this;
        }

        public Criteria andBpRuleNotLike(String value) {
            addCriterion("bp_rule not like", value, "bpRule");
            return (Criteria) this;
        }

        public Criteria andBpRuleIn(List<String> values) {
            addCriterion("bp_rule in", values, "bpRule");
            return (Criteria) this;
        }

        public Criteria andBpRuleNotIn(List<String> values) {
            addCriterion("bp_rule not in", values, "bpRule");
            return (Criteria) this;
        }

        public Criteria andBpRuleBetween(String value1, String value2) {
            addCriterion("bp_rule between", value1, value2, "bpRule");
            return (Criteria) this;
        }

        public Criteria andBpRuleNotBetween(String value1, String value2) {
            addCriterion("bp_rule not between", value1, value2, "bpRule");
            return (Criteria) this;
        }

        public Criteria andBpValueIsNull() {
            addCriterion("bp_value is null");
            return (Criteria) this;
        }

        public Criteria andBpValueIsNotNull() {
            addCriterion("bp_value is not null");
            return (Criteria) this;
        }

        public Criteria andBpValueEqualTo(Integer value) {
            addCriterion("bp_value =", value, "bpValue");
            return (Criteria) this;
        }

        public Criteria andBpValueNotEqualTo(Integer value) {
            addCriterion("bp_value <>", value, "bpValue");
            return (Criteria) this;
        }

        public Criteria andBpValueGreaterThan(Integer value) {
            addCriterion("bp_value >", value, "bpValue");
            return (Criteria) this;
        }

        public Criteria andBpValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("bp_value >=", value, "bpValue");
            return (Criteria) this;
        }

        public Criteria andBpValueLessThan(Integer value) {
            addCriterion("bp_value <", value, "bpValue");
            return (Criteria) this;
        }

        public Criteria andBpValueLessThanOrEqualTo(Integer value) {
            addCriterion("bp_value <=", value, "bpValue");
            return (Criteria) this;
        }

        public Criteria andBpValueIn(List<Integer> values) {
            addCriterion("bp_value in", values, "bpValue");
            return (Criteria) this;
        }

        public Criteria andBpValueNotIn(List<Integer> values) {
            addCriterion("bp_value not in", values, "bpValue");
            return (Criteria) this;
        }

        public Criteria andBpValueBetween(Integer value1, Integer value2) {
            addCriterion("bp_value between", value1, value2, "bpValue");
            return (Criteria) this;
        }

        public Criteria andBpValueNotBetween(Integer value1, Integer value2) {
            addCriterion("bp_value not between", value1, value2, "bpValue");
            return (Criteria) this;
        }

        public Criteria andBpRuleDescIsNull() {
            addCriterion("bp_rule_desc is null");
            return (Criteria) this;
        }

        public Criteria andBpRuleDescIsNotNull() {
            addCriterion("bp_rule_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBpRuleDescEqualTo(String value) {
            addCriterion("bp_rule_desc =", value, "bpRuleDesc");
            return (Criteria) this;
        }

        public Criteria andBpRuleDescNotEqualTo(String value) {
            addCriterion("bp_rule_desc <>", value, "bpRuleDesc");
            return (Criteria) this;
        }

        public Criteria andBpRuleDescGreaterThan(String value) {
            addCriterion("bp_rule_desc >", value, "bpRuleDesc");
            return (Criteria) this;
        }

        public Criteria andBpRuleDescGreaterThanOrEqualTo(String value) {
            addCriterion("bp_rule_desc >=", value, "bpRuleDesc");
            return (Criteria) this;
        }

        public Criteria andBpRuleDescLessThan(String value) {
            addCriterion("bp_rule_desc <", value, "bpRuleDesc");
            return (Criteria) this;
        }

        public Criteria andBpRuleDescLessThanOrEqualTo(String value) {
            addCriterion("bp_rule_desc <=", value, "bpRuleDesc");
            return (Criteria) this;
        }

        public Criteria andBpRuleDescLike(String value) {
            addCriterion("bp_rule_desc like", value, "bpRuleDesc");
            return (Criteria) this;
        }

        public Criteria andBpRuleDescNotLike(String value) {
            addCriterion("bp_rule_desc not like", value, "bpRuleDesc");
            return (Criteria) this;
        }

        public Criteria andBpRuleDescIn(List<String> values) {
            addCriterion("bp_rule_desc in", values, "bpRuleDesc");
            return (Criteria) this;
        }

        public Criteria andBpRuleDescNotIn(List<String> values) {
            addCriterion("bp_rule_desc not in", values, "bpRuleDesc");
            return (Criteria) this;
        }

        public Criteria andBpRuleDescBetween(String value1, String value2) {
            addCriterion("bp_rule_desc between", value1, value2, "bpRuleDesc");
            return (Criteria) this;
        }

        public Criteria andBpRuleDescNotBetween(String value1, String value2) {
            addCriterion("bp_rule_desc not between", value1, value2, "bpRuleDesc");
            return (Criteria) this;
        }

        public Criteria andRewardRuleIsNull() {
            addCriterion("reward_rule is null");
            return (Criteria) this;
        }

        public Criteria andRewardRuleIsNotNull() {
            addCriterion("reward_rule is not null");
            return (Criteria) this;
        }

        public Criteria andRewardRuleEqualTo(String value) {
            addCriterion("reward_rule =", value, "rewardRule");
            return (Criteria) this;
        }

        public Criteria andRewardRuleNotEqualTo(String value) {
            addCriterion("reward_rule <>", value, "rewardRule");
            return (Criteria) this;
        }

        public Criteria andRewardRuleGreaterThan(String value) {
            addCriterion("reward_rule >", value, "rewardRule");
            return (Criteria) this;
        }

        public Criteria andRewardRuleGreaterThanOrEqualTo(String value) {
            addCriterion("reward_rule >=", value, "rewardRule");
            return (Criteria) this;
        }

        public Criteria andRewardRuleLessThan(String value) {
            addCriterion("reward_rule <", value, "rewardRule");
            return (Criteria) this;
        }

        public Criteria andRewardRuleLessThanOrEqualTo(String value) {
            addCriterion("reward_rule <=", value, "rewardRule");
            return (Criteria) this;
        }

        public Criteria andRewardRuleLike(String value) {
            addCriterion("reward_rule like", value, "rewardRule");
            return (Criteria) this;
        }

        public Criteria andRewardRuleNotLike(String value) {
            addCriterion("reward_rule not like", value, "rewardRule");
            return (Criteria) this;
        }

        public Criteria andRewardRuleIn(List<String> values) {
            addCriterion("reward_rule in", values, "rewardRule");
            return (Criteria) this;
        }

        public Criteria andRewardRuleNotIn(List<String> values) {
            addCriterion("reward_rule not in", values, "rewardRule");
            return (Criteria) this;
        }

        public Criteria andRewardRuleBetween(String value1, String value2) {
            addCriterion("reward_rule between", value1, value2, "rewardRule");
            return (Criteria) this;
        }

        public Criteria andRewardRuleNotBetween(String value1, String value2) {
            addCriterion("reward_rule not between", value1, value2, "rewardRule");
            return (Criteria) this;
        }

        public Criteria andRewardValueIsNull() {
            addCriterion("reward_value is null");
            return (Criteria) this;
        }

        public Criteria andRewardValueIsNotNull() {
            addCriterion("reward_value is not null");
            return (Criteria) this;
        }

        public Criteria andRewardValueEqualTo(Integer value) {
            addCriterion("reward_value =", value, "rewardValue");
            return (Criteria) this;
        }

        public Criteria andRewardValueNotEqualTo(Integer value) {
            addCriterion("reward_value <>", value, "rewardValue");
            return (Criteria) this;
        }

        public Criteria andRewardValueGreaterThan(Integer value) {
            addCriterion("reward_value >", value, "rewardValue");
            return (Criteria) this;
        }

        public Criteria andRewardValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("reward_value >=", value, "rewardValue");
            return (Criteria) this;
        }

        public Criteria andRewardValueLessThan(Integer value) {
            addCriterion("reward_value <", value, "rewardValue");
            return (Criteria) this;
        }

        public Criteria andRewardValueLessThanOrEqualTo(Integer value) {
            addCriterion("reward_value <=", value, "rewardValue");
            return (Criteria) this;
        }

        public Criteria andRewardValueIn(List<Integer> values) {
            addCriterion("reward_value in", values, "rewardValue");
            return (Criteria) this;
        }

        public Criteria andRewardValueNotIn(List<Integer> values) {
            addCriterion("reward_value not in", values, "rewardValue");
            return (Criteria) this;
        }

        public Criteria andRewardValueBetween(Integer value1, Integer value2) {
            addCriterion("reward_value between", value1, value2, "rewardValue");
            return (Criteria) this;
        }

        public Criteria andRewardValueNotBetween(Integer value1, Integer value2) {
            addCriterion("reward_value not between", value1, value2, "rewardValue");
            return (Criteria) this;
        }

        public Criteria andStartActiveTimeIsNull() {
            addCriterion("start_active_time is null");
            return (Criteria) this;
        }

        public Criteria andStartActiveTimeIsNotNull() {
            addCriterion("start_active_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartActiveTimeEqualTo(Date value) {
            addCriterion("start_active_time =", value, "startActiveTime");
            return (Criteria) this;
        }

        public Criteria andStartActiveTimeNotEqualTo(Date value) {
            addCriterion("start_active_time <>", value, "startActiveTime");
            return (Criteria) this;
        }

        public Criteria andStartActiveTimeGreaterThan(Date value) {
            addCriterion("start_active_time >", value, "startActiveTime");
            return (Criteria) this;
        }

        public Criteria andStartActiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_active_time >=", value, "startActiveTime");
            return (Criteria) this;
        }

        public Criteria andStartActiveTimeLessThan(Date value) {
            addCriterion("start_active_time <", value, "startActiveTime");
            return (Criteria) this;
        }

        public Criteria andStartActiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_active_time <=", value, "startActiveTime");
            return (Criteria) this;
        }

        public Criteria andStartActiveTimeIn(List<Date> values) {
            addCriterion("start_active_time in", values, "startActiveTime");
            return (Criteria) this;
        }

        public Criteria andStartActiveTimeNotIn(List<Date> values) {
            addCriterion("start_active_time not in", values, "startActiveTime");
            return (Criteria) this;
        }

        public Criteria andStartActiveTimeBetween(Date value1, Date value2) {
            addCriterion("start_active_time between", value1, value2, "startActiveTime");
            return (Criteria) this;
        }

        public Criteria andStartActiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_active_time not between", value1, value2, "startActiveTime");
            return (Criteria) this;
        }

        public Criteria andEndActiveTimeIsNull() {
            addCriterion("end_active_time is null");
            return (Criteria) this;
        }

        public Criteria andEndActiveTimeIsNotNull() {
            addCriterion("end_active_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndActiveTimeEqualTo(Date value) {
            addCriterion("end_active_time =", value, "endActiveTime");
            return (Criteria) this;
        }

        public Criteria andEndActiveTimeNotEqualTo(Date value) {
            addCriterion("end_active_time <>", value, "endActiveTime");
            return (Criteria) this;
        }

        public Criteria andEndActiveTimeGreaterThan(Date value) {
            addCriterion("end_active_time >", value, "endActiveTime");
            return (Criteria) this;
        }

        public Criteria andEndActiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_active_time >=", value, "endActiveTime");
            return (Criteria) this;
        }

        public Criteria andEndActiveTimeLessThan(Date value) {
            addCriterion("end_active_time <", value, "endActiveTime");
            return (Criteria) this;
        }

        public Criteria andEndActiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_active_time <=", value, "endActiveTime");
            return (Criteria) this;
        }

        public Criteria andEndActiveTimeIn(List<Date> values) {
            addCriterion("end_active_time in", values, "endActiveTime");
            return (Criteria) this;
        }

        public Criteria andEndActiveTimeNotIn(List<Date> values) {
            addCriterion("end_active_time not in", values, "endActiveTime");
            return (Criteria) this;
        }

        public Criteria andEndActiveTimeBetween(Date value1, Date value2) {
            addCriterion("end_active_time between", value1, value2, "endActiveTime");
            return (Criteria) this;
        }

        public Criteria andEndActiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_active_time not between", value1, value2, "endActiveTime");
            return (Criteria) this;
        }

        public Criteria andActiveIsNull() {
            addCriterion("active is null");
            return (Criteria) this;
        }

        public Criteria andActiveIsNotNull() {
            addCriterion("active is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEqualTo(Boolean value) {
            addCriterion("active =", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotEqualTo(Boolean value) {
            addCriterion("active <>", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThan(Boolean value) {
            addCriterion("active >", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("active >=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThan(Boolean value) {
            addCriterion("active <", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThanOrEqualTo(Boolean value) {
            addCriterion("active <=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveIn(List<Boolean> values) {
            addCriterion("active in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotIn(List<Boolean> values) {
            addCriterion("active not in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveBetween(Boolean value1, Boolean value2) {
            addCriterion("active between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("active not between", value1, value2, "active");
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