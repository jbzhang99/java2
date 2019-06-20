package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CardReportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CardReportExample() {
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

        public Criteria andCardIdIsNull() {
            addCriterion("card_id is null");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNotNull() {
            addCriterion("card_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardIdEqualTo(Long value) {
            addCriterion("card_id =", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotEqualTo(Long value) {
            addCriterion("card_id <>", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThan(Long value) {
            addCriterion("card_id >", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThanOrEqualTo(Long value) {
            addCriterion("card_id >=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThan(Long value) {
            addCriterion("card_id <", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThanOrEqualTo(Long value) {
            addCriterion("card_id <=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdIn(List<Long> values) {
            addCriterion("card_id in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotIn(List<Long> values) {
            addCriterion("card_id not in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdBetween(Long value1, Long value2) {
            addCriterion("card_id between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotBetween(Long value1, Long value2) {
            addCriterion("card_id not between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
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

        public Criteria andRuidIsNull() {
            addCriterion("ruid is null");
            return (Criteria) this;
        }

        public Criteria andRuidIsNotNull() {
            addCriterion("ruid is not null");
            return (Criteria) this;
        }

        public Criteria andRuidEqualTo(Long value) {
            addCriterion("ruid =", value, "ruid");
            return (Criteria) this;
        }

        public Criteria andRuidNotEqualTo(Long value) {
            addCriterion("ruid <>", value, "ruid");
            return (Criteria) this;
        }

        public Criteria andRuidGreaterThan(Long value) {
            addCriterion("ruid >", value, "ruid");
            return (Criteria) this;
        }

        public Criteria andRuidGreaterThanOrEqualTo(Long value) {
            addCriterion("ruid >=", value, "ruid");
            return (Criteria) this;
        }

        public Criteria andRuidLessThan(Long value) {
            addCriterion("ruid <", value, "ruid");
            return (Criteria) this;
        }

        public Criteria andRuidLessThanOrEqualTo(Long value) {
            addCriterion("ruid <=", value, "ruid");
            return (Criteria) this;
        }

        public Criteria andRuidIn(List<Long> values) {
            addCriterion("ruid in", values, "ruid");
            return (Criteria) this;
        }

        public Criteria andRuidNotIn(List<Long> values) {
            addCriterion("ruid not in", values, "ruid");
            return (Criteria) this;
        }

        public Criteria andRuidBetween(Long value1, Long value2) {
            addCriterion("ruid between", value1, value2, "ruid");
            return (Criteria) this;
        }

        public Criteria andRuidNotBetween(Long value1, Long value2) {
            addCriterion("ruid not between", value1, value2, "ruid");
            return (Criteria) this;
        }

        public Criteria andRfullnameIsNull() {
            addCriterion("rfullname is null");
            return (Criteria) this;
        }

        public Criteria andRfullnameIsNotNull() {
            addCriterion("rfullname is not null");
            return (Criteria) this;
        }

        public Criteria andRfullnameEqualTo(String value) {
            addCriterion("rfullname =", value, "rfullname");
            return (Criteria) this;
        }

        public Criteria andRfullnameNotEqualTo(String value) {
            addCriterion("rfullname <>", value, "rfullname");
            return (Criteria) this;
        }

        public Criteria andRfullnameGreaterThan(String value) {
            addCriterion("rfullname >", value, "rfullname");
            return (Criteria) this;
        }

        public Criteria andRfullnameGreaterThanOrEqualTo(String value) {
            addCriterion("rfullname >=", value, "rfullname");
            return (Criteria) this;
        }

        public Criteria andRfullnameLessThan(String value) {
            addCriterion("rfullname <", value, "rfullname");
            return (Criteria) this;
        }

        public Criteria andRfullnameLessThanOrEqualTo(String value) {
            addCriterion("rfullname <=", value, "rfullname");
            return (Criteria) this;
        }

        public Criteria andRfullnameLike(String value) {
            addCriterion("rfullname like", value, "rfullname");
            return (Criteria) this;
        }

        public Criteria andRfullnameNotLike(String value) {
            addCriterion("rfullname not like", value, "rfullname");
            return (Criteria) this;
        }

        public Criteria andRfullnameIn(List<String> values) {
            addCriterion("rfullname in", values, "rfullname");
            return (Criteria) this;
        }

        public Criteria andRfullnameNotIn(List<String> values) {
            addCriterion("rfullname not in", values, "rfullname");
            return (Criteria) this;
        }

        public Criteria andRfullnameBetween(String value1, String value2) {
            addCriterion("rfullname between", value1, value2, "rfullname");
            return (Criteria) this;
        }

        public Criteria andRfullnameNotBetween(String value1, String value2) {
            addCriterion("rfullname not between", value1, value2, "rfullname");
            return (Criteria) this;
        }

        public Criteria andRphoneIsNull() {
            addCriterion("rphone is null");
            return (Criteria) this;
        }

        public Criteria andRphoneIsNotNull() {
            addCriterion("rphone is not null");
            return (Criteria) this;
        }

        public Criteria andRphoneEqualTo(String value) {
            addCriterion("rphone =", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneNotEqualTo(String value) {
            addCriterion("rphone <>", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneGreaterThan(String value) {
            addCriterion("rphone >", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneGreaterThanOrEqualTo(String value) {
            addCriterion("rphone >=", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneLessThan(String value) {
            addCriterion("rphone <", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneLessThanOrEqualTo(String value) {
            addCriterion("rphone <=", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneLike(String value) {
            addCriterion("rphone like", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneNotLike(String value) {
            addCriterion("rphone not like", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneIn(List<String> values) {
            addCriterion("rphone in", values, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneNotIn(List<String> values) {
            addCriterion("rphone not in", values, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneBetween(String value1, String value2) {
            addCriterion("rphone between", value1, value2, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneNotBetween(String value1, String value2) {
            addCriterion("rphone not between", value1, value2, "rphone");
            return (Criteria) this;
        }

        public Criteria andSuidIsNull() {
            addCriterion("suid is null");
            return (Criteria) this;
        }

        public Criteria andSuidIsNotNull() {
            addCriterion("suid is not null");
            return (Criteria) this;
        }

        public Criteria andSuidEqualTo(Long value) {
            addCriterion("suid =", value, "suid");
            return (Criteria) this;
        }

        public Criteria andSuidNotEqualTo(Long value) {
            addCriterion("suid <>", value, "suid");
            return (Criteria) this;
        }

        public Criteria andSuidGreaterThan(Long value) {
            addCriterion("suid >", value, "suid");
            return (Criteria) this;
        }

        public Criteria andSuidGreaterThanOrEqualTo(Long value) {
            addCriterion("suid >=", value, "suid");
            return (Criteria) this;
        }

        public Criteria andSuidLessThan(Long value) {
            addCriterion("suid <", value, "suid");
            return (Criteria) this;
        }

        public Criteria andSuidLessThanOrEqualTo(Long value) {
            addCriterion("suid <=", value, "suid");
            return (Criteria) this;
        }

        public Criteria andSuidIn(List<Long> values) {
            addCriterion("suid in", values, "suid");
            return (Criteria) this;
        }

        public Criteria andSuidNotIn(List<Long> values) {
            addCriterion("suid not in", values, "suid");
            return (Criteria) this;
        }

        public Criteria andSuidBetween(Long value1, Long value2) {
            addCriterion("suid between", value1, value2, "suid");
            return (Criteria) this;
        }

        public Criteria andSuidNotBetween(Long value1, Long value2) {
            addCriterion("suid not between", value1, value2, "suid");
            return (Criteria) this;
        }

        public Criteria andStypeIsNull() {
            addCriterion("stype is null");
            return (Criteria) this;
        }

        public Criteria andStypeIsNotNull() {
            addCriterion("stype is not null");
            return (Criteria) this;
        }

        public Criteria andStypeEqualTo(Integer value) {
            addCriterion("stype =", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeNotEqualTo(Integer value) {
            addCriterion("stype <>", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeGreaterThan(Integer value) {
            addCriterion("stype >", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("stype >=", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeLessThan(Integer value) {
            addCriterion("stype <", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeLessThanOrEqualTo(Integer value) {
            addCriterion("stype <=", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeIn(List<Integer> values) {
            addCriterion("stype in", values, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeNotIn(List<Integer> values) {
            addCriterion("stype not in", values, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeBetween(Integer value1, Integer value2) {
            addCriterion("stype between", value1, value2, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeNotBetween(Integer value1, Integer value2) {
            addCriterion("stype not between", value1, value2, "stype");
            return (Criteria) this;
        }

        public Criteria andSfullnameIsNull() {
            addCriterion("sfullname is null");
            return (Criteria) this;
        }

        public Criteria andSfullnameIsNotNull() {
            addCriterion("sfullname is not null");
            return (Criteria) this;
        }

        public Criteria andSfullnameEqualTo(String value) {
            addCriterion("sfullname =", value, "sfullname");
            return (Criteria) this;
        }

        public Criteria andSfullnameNotEqualTo(String value) {
            addCriterion("sfullname <>", value, "sfullname");
            return (Criteria) this;
        }

        public Criteria andSfullnameGreaterThan(String value) {
            addCriterion("sfullname >", value, "sfullname");
            return (Criteria) this;
        }

        public Criteria andSfullnameGreaterThanOrEqualTo(String value) {
            addCriterion("sfullname >=", value, "sfullname");
            return (Criteria) this;
        }

        public Criteria andSfullnameLessThan(String value) {
            addCriterion("sfullname <", value, "sfullname");
            return (Criteria) this;
        }

        public Criteria andSfullnameLessThanOrEqualTo(String value) {
            addCriterion("sfullname <=", value, "sfullname");
            return (Criteria) this;
        }

        public Criteria andSfullnameLike(String value) {
            addCriterion("sfullname like", value, "sfullname");
            return (Criteria) this;
        }

        public Criteria andSfullnameNotLike(String value) {
            addCriterion("sfullname not like", value, "sfullname");
            return (Criteria) this;
        }

        public Criteria andSfullnameIn(List<String> values) {
            addCriterion("sfullname in", values, "sfullname");
            return (Criteria) this;
        }

        public Criteria andSfullnameNotIn(List<String> values) {
            addCriterion("sfullname not in", values, "sfullname");
            return (Criteria) this;
        }

        public Criteria andSfullnameBetween(String value1, String value2) {
            addCriterion("sfullname between", value1, value2, "sfullname");
            return (Criteria) this;
        }

        public Criteria andSfullnameNotBetween(String value1, String value2) {
            addCriterion("sfullname not between", value1, value2, "sfullname");
            return (Criteria) this;
        }

        public Criteria andSphoneIsNull() {
            addCriterion("sphone is null");
            return (Criteria) this;
        }

        public Criteria andSphoneIsNotNull() {
            addCriterion("sphone is not null");
            return (Criteria) this;
        }

        public Criteria andSphoneEqualTo(String value) {
            addCriterion("sphone =", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneNotEqualTo(String value) {
            addCriterion("sphone <>", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneGreaterThan(String value) {
            addCriterion("sphone >", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneGreaterThanOrEqualTo(String value) {
            addCriterion("sphone >=", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneLessThan(String value) {
            addCriterion("sphone <", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneLessThanOrEqualTo(String value) {
            addCriterion("sphone <=", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneLike(String value) {
            addCriterion("sphone like", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneNotLike(String value) {
            addCriterion("sphone not like", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneIn(List<String> values) {
            addCriterion("sphone in", values, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneNotIn(List<String> values) {
            addCriterion("sphone not in", values, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneBetween(String value1, String value2) {
            addCriterion("sphone between", value1, value2, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneNotBetween(String value1, String value2) {
            addCriterion("sphone not between", value1, value2, "sphone");
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

        public Criteria andCardContentIsNull() {
            addCriterion("card_content is null");
            return (Criteria) this;
        }

        public Criteria andCardContentIsNotNull() {
            addCriterion("card_content is not null");
            return (Criteria) this;
        }

        public Criteria andCardContentEqualTo(String value) {
            addCriterion("card_content =", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentNotEqualTo(String value) {
            addCriterion("card_content <>", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentGreaterThan(String value) {
            addCriterion("card_content >", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentGreaterThanOrEqualTo(String value) {
            addCriterion("card_content >=", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentLessThan(String value) {
            addCriterion("card_content <", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentLessThanOrEqualTo(String value) {
            addCriterion("card_content <=", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentLike(String value) {
            addCriterion("card_content like", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentNotLike(String value) {
            addCriterion("card_content not like", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentIn(List<String> values) {
            addCriterion("card_content in", values, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentNotIn(List<String> values) {
            addCriterion("card_content not in", values, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentBetween(String value1, String value2) {
            addCriterion("card_content between", value1, value2, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentNotBetween(String value1, String value2) {
            addCriterion("card_content not between", value1, value2, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardAttachmentIsNull() {
            addCriterion("card_attachment is null");
            return (Criteria) this;
        }

        public Criteria andCardAttachmentIsNotNull() {
            addCriterion("card_attachment is not null");
            return (Criteria) this;
        }

        public Criteria andCardAttachmentEqualTo(String value) {
            addCriterion("card_attachment =", value, "cardAttachment");
            return (Criteria) this;
        }

        public Criteria andCardAttachmentNotEqualTo(String value) {
            addCriterion("card_attachment <>", value, "cardAttachment");
            return (Criteria) this;
        }

        public Criteria andCardAttachmentGreaterThan(String value) {
            addCriterion("card_attachment >", value, "cardAttachment");
            return (Criteria) this;
        }

        public Criteria andCardAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("card_attachment >=", value, "cardAttachment");
            return (Criteria) this;
        }

        public Criteria andCardAttachmentLessThan(String value) {
            addCriterion("card_attachment <", value, "cardAttachment");
            return (Criteria) this;
        }

        public Criteria andCardAttachmentLessThanOrEqualTo(String value) {
            addCriterion("card_attachment <=", value, "cardAttachment");
            return (Criteria) this;
        }

        public Criteria andCardAttachmentLike(String value) {
            addCriterion("card_attachment like", value, "cardAttachment");
            return (Criteria) this;
        }

        public Criteria andCardAttachmentNotLike(String value) {
            addCriterion("card_attachment not like", value, "cardAttachment");
            return (Criteria) this;
        }

        public Criteria andCardAttachmentIn(List<String> values) {
            addCriterion("card_attachment in", values, "cardAttachment");
            return (Criteria) this;
        }

        public Criteria andCardAttachmentNotIn(List<String> values) {
            addCriterion("card_attachment not in", values, "cardAttachment");
            return (Criteria) this;
        }

        public Criteria andCardAttachmentBetween(String value1, String value2) {
            addCriterion("card_attachment between", value1, value2, "cardAttachment");
            return (Criteria) this;
        }

        public Criteria andCardAttachmentNotBetween(String value1, String value2) {
            addCriterion("card_attachment not between", value1, value2, "cardAttachment");
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