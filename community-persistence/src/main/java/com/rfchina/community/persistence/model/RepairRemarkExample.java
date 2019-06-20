package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepairRemarkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepairRemarkExample() {
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

        public Criteria andRepairRecordIdIsNull() {
            addCriterion("repair_record_id is null");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdIsNotNull() {
            addCriterion("repair_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdEqualTo(Long value) {
            addCriterion("repair_record_id =", value, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdNotEqualTo(Long value) {
            addCriterion("repair_record_id <>", value, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdGreaterThan(Long value) {
            addCriterion("repair_record_id >", value, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("repair_record_id >=", value, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdLessThan(Long value) {
            addCriterion("repair_record_id <", value, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("repair_record_id <=", value, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdIn(List<Long> values) {
            addCriterion("repair_record_id in", values, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdNotIn(List<Long> values) {
            addCriterion("repair_record_id not in", values, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdBetween(Long value1, Long value2) {
            addCriterion("repair_record_id between", value1, value2, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("repair_record_id not between", value1, value2, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreContentIsNull() {
            addCriterion("score_content is null");
            return (Criteria) this;
        }

        public Criteria andScoreContentIsNotNull() {
            addCriterion("score_content is not null");
            return (Criteria) this;
        }

        public Criteria andScoreContentEqualTo(String value) {
            addCriterion("score_content =", value, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentNotEqualTo(String value) {
            addCriterion("score_content <>", value, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentGreaterThan(String value) {
            addCriterion("score_content >", value, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentGreaterThanOrEqualTo(String value) {
            addCriterion("score_content >=", value, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentLessThan(String value) {
            addCriterion("score_content <", value, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentLessThanOrEqualTo(String value) {
            addCriterion("score_content <=", value, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentLike(String value) {
            addCriterion("score_content like", value, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentNotLike(String value) {
            addCriterion("score_content not like", value, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentIn(List<String> values) {
            addCriterion("score_content in", values, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentNotIn(List<String> values) {
            addCriterion("score_content not in", values, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentBetween(String value1, String value2) {
            addCriterion("score_content between", value1, value2, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentNotBetween(String value1, String value2) {
            addCriterion("score_content not between", value1, value2, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreMediaIsNull() {
            addCriterion("score_media is null");
            return (Criteria) this;
        }

        public Criteria andScoreMediaIsNotNull() {
            addCriterion("score_media is not null");
            return (Criteria) this;
        }

        public Criteria andScoreMediaEqualTo(String value) {
            addCriterion("score_media =", value, "scoreMedia");
            return (Criteria) this;
        }

        public Criteria andScoreMediaNotEqualTo(String value) {
            addCriterion("score_media <>", value, "scoreMedia");
            return (Criteria) this;
        }

        public Criteria andScoreMediaGreaterThan(String value) {
            addCriterion("score_media >", value, "scoreMedia");
            return (Criteria) this;
        }

        public Criteria andScoreMediaGreaterThanOrEqualTo(String value) {
            addCriterion("score_media >=", value, "scoreMedia");
            return (Criteria) this;
        }

        public Criteria andScoreMediaLessThan(String value) {
            addCriterion("score_media <", value, "scoreMedia");
            return (Criteria) this;
        }

        public Criteria andScoreMediaLessThanOrEqualTo(String value) {
            addCriterion("score_media <=", value, "scoreMedia");
            return (Criteria) this;
        }

        public Criteria andScoreMediaLike(String value) {
            addCriterion("score_media like", value, "scoreMedia");
            return (Criteria) this;
        }

        public Criteria andScoreMediaNotLike(String value) {
            addCriterion("score_media not like", value, "scoreMedia");
            return (Criteria) this;
        }

        public Criteria andScoreMediaIn(List<String> values) {
            addCriterion("score_media in", values, "scoreMedia");
            return (Criteria) this;
        }

        public Criteria andScoreMediaNotIn(List<String> values) {
            addCriterion("score_media not in", values, "scoreMedia");
            return (Criteria) this;
        }

        public Criteria andScoreMediaBetween(String value1, String value2) {
            addCriterion("score_media between", value1, value2, "scoreMedia");
            return (Criteria) this;
        }

        public Criteria andScoreMediaNotBetween(String value1, String value2) {
            addCriterion("score_media not between", value1, value2, "scoreMedia");
            return (Criteria) this;
        }

        public Criteria andScoreTimeIsNull() {
            addCriterion("score_time is null");
            return (Criteria) this;
        }

        public Criteria andScoreTimeIsNotNull() {
            addCriterion("score_time is not null");
            return (Criteria) this;
        }

        public Criteria andScoreTimeEqualTo(Date value) {
            addCriterion("score_time =", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeNotEqualTo(Date value) {
            addCriterion("score_time <>", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeGreaterThan(Date value) {
            addCriterion("score_time >", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("score_time >=", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeLessThan(Date value) {
            addCriterion("score_time <", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeLessThanOrEqualTo(Date value) {
            addCriterion("score_time <=", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeIn(List<Date> values) {
            addCriterion("score_time in", values, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeNotIn(List<Date> values) {
            addCriterion("score_time not in", values, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeBetween(Date value1, Date value2) {
            addCriterion("score_time between", value1, value2, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeNotBetween(Date value1, Date value2) {
            addCriterion("score_time not between", value1, value2, "scoreTime");
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