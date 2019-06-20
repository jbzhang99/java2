package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("img_url is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("img_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("img_url =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("img_url <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("img_url >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_url >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("img_url <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("img_url <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("img_url like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("img_url not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("img_url in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("img_url not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("img_url between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("img_url not between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andLinkIsNull() {
            addCriterion("link is null");
            return (Criteria) this;
        }

        public Criteria andLinkIsNotNull() {
            addCriterion("link is not null");
            return (Criteria) this;
        }

        public Criteria andLinkEqualTo(String value) {
            addCriterion("link =", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotEqualTo(String value) {
            addCriterion("link <>", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThan(String value) {
            addCriterion("link >", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThanOrEqualTo(String value) {
            addCriterion("link >=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThan(String value) {
            addCriterion("link <", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThanOrEqualTo(String value) {
            addCriterion("link <=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLike(String value) {
            addCriterion("link like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotLike(String value) {
            addCriterion("link not like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkIn(List<String> values) {
            addCriterion("link in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotIn(List<String> values) {
            addCriterion("link not in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkBetween(String value1, String value2) {
            addCriterion("link between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotBetween(String value1, String value2) {
            addCriterion("link not between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andSortingIsNull() {
            addCriterion("sorting is null");
            return (Criteria) this;
        }

        public Criteria andSortingIsNotNull() {
            addCriterion("sorting is not null");
            return (Criteria) this;
        }

        public Criteria andSortingEqualTo(Integer value) {
            addCriterion("sorting =", value, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingNotEqualTo(Integer value) {
            addCriterion("sorting <>", value, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingGreaterThan(Integer value) {
            addCriterion("sorting >", value, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingGreaterThanOrEqualTo(Integer value) {
            addCriterion("sorting >=", value, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingLessThan(Integer value) {
            addCriterion("sorting <", value, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingLessThanOrEqualTo(Integer value) {
            addCriterion("sorting <=", value, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingIn(List<Integer> values) {
            addCriterion("sorting in", values, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingNotIn(List<Integer> values) {
            addCriterion("sorting not in", values, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingBetween(Integer value1, Integer value2) {
            addCriterion("sorting between", value1, value2, "sorting");
            return (Criteria) this;
        }

        public Criteria andSortingNotBetween(Integer value1, Integer value2) {
            addCriterion("sorting not between", value1, value2, "sorting");
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

        public Criteria andSrcTypeIsNull() {
            addCriterion("src_type is null");
            return (Criteria) this;
        }

        public Criteria andSrcTypeIsNotNull() {
            addCriterion("src_type is not null");
            return (Criteria) this;
        }

        public Criteria andSrcTypeEqualTo(Integer value) {
            addCriterion("src_type =", value, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeNotEqualTo(Integer value) {
            addCriterion("src_type <>", value, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeGreaterThan(Integer value) {
            addCriterion("src_type >", value, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("src_type >=", value, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeLessThan(Integer value) {
            addCriterion("src_type <", value, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeLessThanOrEqualTo(Integer value) {
            addCriterion("src_type <=", value, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeIn(List<Integer> values) {
            addCriterion("src_type in", values, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeNotIn(List<Integer> values) {
            addCriterion("src_type not in", values, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeBetween(Integer value1, Integer value2) {
            addCriterion("src_type between", value1, value2, "srcType");
            return (Criteria) this;
        }

        public Criteria andSrcTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("src_type not between", value1, value2, "srcType");
            return (Criteria) this;
        }

        public Criteria andClickCountIsNull() {
            addCriterion("click_count is null");
            return (Criteria) this;
        }

        public Criteria andClickCountIsNotNull() {
            addCriterion("click_count is not null");
            return (Criteria) this;
        }

        public Criteria andClickCountEqualTo(Integer value) {
            addCriterion("click_count =", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotEqualTo(Integer value) {
            addCriterion("click_count <>", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThan(Integer value) {
            addCriterion("click_count >", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("click_count >=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThan(Integer value) {
            addCriterion("click_count <", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThanOrEqualTo(Integer value) {
            addCriterion("click_count <=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountIn(List<Integer> values) {
            addCriterion("click_count in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotIn(List<Integer> values) {
            addCriterion("click_count not in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountBetween(Integer value1, Integer value2) {
            addCriterion("click_count between", value1, value2, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotBetween(Integer value1, Integer value2) {
            addCriterion("click_count not between", value1, value2, "clickCount");
            return (Criteria) this;
        }

        public Criteria andIntroIsNull() {
            addCriterion("intro is null");
            return (Criteria) this;
        }

        public Criteria andIntroIsNotNull() {
            addCriterion("intro is not null");
            return (Criteria) this;
        }

        public Criteria andIntroEqualTo(String value) {
            addCriterion("intro =", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotEqualTo(String value) {
            addCriterion("intro <>", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThan(String value) {
            addCriterion("intro >", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThanOrEqualTo(String value) {
            addCriterion("intro >=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThan(String value) {
            addCriterion("intro <", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThanOrEqualTo(String value) {
            addCriterion("intro <=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLike(String value) {
            addCriterion("intro like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotLike(String value) {
            addCriterion("intro not like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroIn(List<String> values) {
            addCriterion("intro in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotIn(List<String> values) {
            addCriterion("intro not in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroBetween(String value1, String value2) {
            addCriterion("intro between", value1, value2, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotBetween(String value1, String value2) {
            addCriterion("intro not between", value1, value2, "intro");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andPlatformReasonIsNull() {
            addCriterion("platform_reason is null");
            return (Criteria) this;
        }

        public Criteria andPlatformReasonIsNotNull() {
            addCriterion("platform_reason is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformReasonEqualTo(String value) {
            addCriterion("platform_reason =", value, "platformReason");
            return (Criteria) this;
        }

        public Criteria andPlatformReasonNotEqualTo(String value) {
            addCriterion("platform_reason <>", value, "platformReason");
            return (Criteria) this;
        }

        public Criteria andPlatformReasonGreaterThan(String value) {
            addCriterion("platform_reason >", value, "platformReason");
            return (Criteria) this;
        }

        public Criteria andPlatformReasonGreaterThanOrEqualTo(String value) {
            addCriterion("platform_reason >=", value, "platformReason");
            return (Criteria) this;
        }

        public Criteria andPlatformReasonLessThan(String value) {
            addCriterion("platform_reason <", value, "platformReason");
            return (Criteria) this;
        }

        public Criteria andPlatformReasonLessThanOrEqualTo(String value) {
            addCriterion("platform_reason <=", value, "platformReason");
            return (Criteria) this;
        }

        public Criteria andPlatformReasonLike(String value) {
            addCriterion("platform_reason like", value, "platformReason");
            return (Criteria) this;
        }

        public Criteria andPlatformReasonNotLike(String value) {
            addCriterion("platform_reason not like", value, "platformReason");
            return (Criteria) this;
        }

        public Criteria andPlatformReasonIn(List<String> values) {
            addCriterion("platform_reason in", values, "platformReason");
            return (Criteria) this;
        }

        public Criteria andPlatformReasonNotIn(List<String> values) {
            addCriterion("platform_reason not in", values, "platformReason");
            return (Criteria) this;
        }

        public Criteria andPlatformReasonBetween(String value1, String value2) {
            addCriterion("platform_reason between", value1, value2, "platformReason");
            return (Criteria) this;
        }

        public Criteria andPlatformReasonNotBetween(String value1, String value2) {
            addCriterion("platform_reason not between", value1, value2, "platformReason");
            return (Criteria) this;
        }

        public Criteria andLeaderReasonIsNull() {
            addCriterion("leader_reason is null");
            return (Criteria) this;
        }

        public Criteria andLeaderReasonIsNotNull() {
            addCriterion("leader_reason is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderReasonEqualTo(String value) {
            addCriterion("leader_reason =", value, "leaderReason");
            return (Criteria) this;
        }

        public Criteria andLeaderReasonNotEqualTo(String value) {
            addCriterion("leader_reason <>", value, "leaderReason");
            return (Criteria) this;
        }

        public Criteria andLeaderReasonGreaterThan(String value) {
            addCriterion("leader_reason >", value, "leaderReason");
            return (Criteria) this;
        }

        public Criteria andLeaderReasonGreaterThanOrEqualTo(String value) {
            addCriterion("leader_reason >=", value, "leaderReason");
            return (Criteria) this;
        }

        public Criteria andLeaderReasonLessThan(String value) {
            addCriterion("leader_reason <", value, "leaderReason");
            return (Criteria) this;
        }

        public Criteria andLeaderReasonLessThanOrEqualTo(String value) {
            addCriterion("leader_reason <=", value, "leaderReason");
            return (Criteria) this;
        }

        public Criteria andLeaderReasonLike(String value) {
            addCriterion("leader_reason like", value, "leaderReason");
            return (Criteria) this;
        }

        public Criteria andLeaderReasonNotLike(String value) {
            addCriterion("leader_reason not like", value, "leaderReason");
            return (Criteria) this;
        }

        public Criteria andLeaderReasonIn(List<String> values) {
            addCriterion("leader_reason in", values, "leaderReason");
            return (Criteria) this;
        }

        public Criteria andLeaderReasonNotIn(List<String> values) {
            addCriterion("leader_reason not in", values, "leaderReason");
            return (Criteria) this;
        }

        public Criteria andLeaderReasonBetween(String value1, String value2) {
            addCriterion("leader_reason between", value1, value2, "leaderReason");
            return (Criteria) this;
        }

        public Criteria andLeaderReasonNotBetween(String value1, String value2) {
            addCriterion("leader_reason not between", value1, value2, "leaderReason");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andAuditTimeIsNull() {
            addCriterion("audit_time is null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNotNull() {
            addCriterion("audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeEqualTo(Date value) {
            addCriterion("audit_time =", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotEqualTo(Date value) {
            addCriterion("audit_time <>", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThan(Date value) {
            addCriterion("audit_time >", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_time >=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThan(Date value) {
            addCriterion("audit_time <", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("audit_time <=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIn(List<Date> values) {
            addCriterion("audit_time in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotIn(List<Date> values) {
            addCriterion("audit_time not in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeBetween(Date value1, Date value2) {
            addCriterion("audit_time between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("audit_time not between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andLeaderAuditTimeIsNull() {
            addCriterion("leader_audit_time is null");
            return (Criteria) this;
        }

        public Criteria andLeaderAuditTimeIsNotNull() {
            addCriterion("leader_audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderAuditTimeEqualTo(Date value) {
            addCriterion("leader_audit_time =", value, "leaderAuditTime");
            return (Criteria) this;
        }

        public Criteria andLeaderAuditTimeNotEqualTo(Date value) {
            addCriterion("leader_audit_time <>", value, "leaderAuditTime");
            return (Criteria) this;
        }

        public Criteria andLeaderAuditTimeGreaterThan(Date value) {
            addCriterion("leader_audit_time >", value, "leaderAuditTime");
            return (Criteria) this;
        }

        public Criteria andLeaderAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("leader_audit_time >=", value, "leaderAuditTime");
            return (Criteria) this;
        }

        public Criteria andLeaderAuditTimeLessThan(Date value) {
            addCriterion("leader_audit_time <", value, "leaderAuditTime");
            return (Criteria) this;
        }

        public Criteria andLeaderAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("leader_audit_time <=", value, "leaderAuditTime");
            return (Criteria) this;
        }

        public Criteria andLeaderAuditTimeIn(List<Date> values) {
            addCriterion("leader_audit_time in", values, "leaderAuditTime");
            return (Criteria) this;
        }

        public Criteria andLeaderAuditTimeNotIn(List<Date> values) {
            addCriterion("leader_audit_time not in", values, "leaderAuditTime");
            return (Criteria) this;
        }

        public Criteria andLeaderAuditTimeBetween(Date value1, Date value2) {
            addCriterion("leader_audit_time between", value1, value2, "leaderAuditTime");
            return (Criteria) this;
        }

        public Criteria andLeaderAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("leader_audit_time not between", value1, value2, "leaderAuditTime");
            return (Criteria) this;
        }

        public Criteria andPlatformAuditTimeIsNull() {
            addCriterion("platform_audit_time is null");
            return (Criteria) this;
        }

        public Criteria andPlatformAuditTimeIsNotNull() {
            addCriterion("platform_audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformAuditTimeEqualTo(Date value) {
            addCriterion("platform_audit_time =", value, "platformAuditTime");
            return (Criteria) this;
        }

        public Criteria andPlatformAuditTimeNotEqualTo(Date value) {
            addCriterion("platform_audit_time <>", value, "platformAuditTime");
            return (Criteria) this;
        }

        public Criteria andPlatformAuditTimeGreaterThan(Date value) {
            addCriterion("platform_audit_time >", value, "platformAuditTime");
            return (Criteria) this;
        }

        public Criteria andPlatformAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("platform_audit_time >=", value, "platformAuditTime");
            return (Criteria) this;
        }

        public Criteria andPlatformAuditTimeLessThan(Date value) {
            addCriterion("platform_audit_time <", value, "platformAuditTime");
            return (Criteria) this;
        }

        public Criteria andPlatformAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("platform_audit_time <=", value, "platformAuditTime");
            return (Criteria) this;
        }

        public Criteria andPlatformAuditTimeIn(List<Date> values) {
            addCriterion("platform_audit_time in", values, "platformAuditTime");
            return (Criteria) this;
        }

        public Criteria andPlatformAuditTimeNotIn(List<Date> values) {
            addCriterion("platform_audit_time not in", values, "platformAuditTime");
            return (Criteria) this;
        }

        public Criteria andPlatformAuditTimeBetween(Date value1, Date value2) {
            addCriterion("platform_audit_time between", value1, value2, "platformAuditTime");
            return (Criteria) this;
        }

        public Criteria andPlatformAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("platform_audit_time not between", value1, value2, "platformAuditTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andAutoPublishIsNull() {
            addCriterion("auto_publish is null");
            return (Criteria) this;
        }

        public Criteria andAutoPublishIsNotNull() {
            addCriterion("auto_publish is not null");
            return (Criteria) this;
        }

        public Criteria andAutoPublishEqualTo(Integer value) {
            addCriterion("auto_publish =", value, "autoPublish");
            return (Criteria) this;
        }

        public Criteria andAutoPublishNotEqualTo(Integer value) {
            addCriterion("auto_publish <>", value, "autoPublish");
            return (Criteria) this;
        }

        public Criteria andAutoPublishGreaterThan(Integer value) {
            addCriterion("auto_publish >", value, "autoPublish");
            return (Criteria) this;
        }

        public Criteria andAutoPublishGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_publish >=", value, "autoPublish");
            return (Criteria) this;
        }

        public Criteria andAutoPublishLessThan(Integer value) {
            addCriterion("auto_publish <", value, "autoPublish");
            return (Criteria) this;
        }

        public Criteria andAutoPublishLessThanOrEqualTo(Integer value) {
            addCriterion("auto_publish <=", value, "autoPublish");
            return (Criteria) this;
        }

        public Criteria andAutoPublishIn(List<Integer> values) {
            addCriterion("auto_publish in", values, "autoPublish");
            return (Criteria) this;
        }

        public Criteria andAutoPublishNotIn(List<Integer> values) {
            addCriterion("auto_publish not in", values, "autoPublish");
            return (Criteria) this;
        }

        public Criteria andAutoPublishBetween(Integer value1, Integer value2) {
            addCriterion("auto_publish between", value1, value2, "autoPublish");
            return (Criteria) this;
        }

        public Criteria andAutoPublishNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_publish not between", value1, value2, "autoPublish");
            return (Criteria) this;
        }

        public Criteria andAutoPublishTimeIsNull() {
            addCriterion("auto_publish_time is null");
            return (Criteria) this;
        }

        public Criteria andAutoPublishTimeIsNotNull() {
            addCriterion("auto_publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andAutoPublishTimeEqualTo(Date value) {
            addCriterion("auto_publish_time =", value, "autoPublishTime");
            return (Criteria) this;
        }

        public Criteria andAutoPublishTimeNotEqualTo(Date value) {
            addCriterion("auto_publish_time <>", value, "autoPublishTime");
            return (Criteria) this;
        }

        public Criteria andAutoPublishTimeGreaterThan(Date value) {
            addCriterion("auto_publish_time >", value, "autoPublishTime");
            return (Criteria) this;
        }

        public Criteria andAutoPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("auto_publish_time >=", value, "autoPublishTime");
            return (Criteria) this;
        }

        public Criteria andAutoPublishTimeLessThan(Date value) {
            addCriterion("auto_publish_time <", value, "autoPublishTime");
            return (Criteria) this;
        }

        public Criteria andAutoPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("auto_publish_time <=", value, "autoPublishTime");
            return (Criteria) this;
        }

        public Criteria andAutoPublishTimeIn(List<Date> values) {
            addCriterion("auto_publish_time in", values, "autoPublishTime");
            return (Criteria) this;
        }

        public Criteria andAutoPublishTimeNotIn(List<Date> values) {
            addCriterion("auto_publish_time not in", values, "autoPublishTime");
            return (Criteria) this;
        }

        public Criteria andAutoPublishTimeBetween(Date value1, Date value2) {
            addCriterion("auto_publish_time between", value1, value2, "autoPublishTime");
            return (Criteria) this;
        }

        public Criteria andAutoPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("auto_publish_time not between", value1, value2, "autoPublishTime");
            return (Criteria) this;
        }

        public Criteria andAutoRepealIsNull() {
            addCriterion("auto_repeal is null");
            return (Criteria) this;
        }

        public Criteria andAutoRepealIsNotNull() {
            addCriterion("auto_repeal is not null");
            return (Criteria) this;
        }

        public Criteria andAutoRepealEqualTo(Integer value) {
            addCriterion("auto_repeal =", value, "autoRepeal");
            return (Criteria) this;
        }

        public Criteria andAutoRepealNotEqualTo(Integer value) {
            addCriterion("auto_repeal <>", value, "autoRepeal");
            return (Criteria) this;
        }

        public Criteria andAutoRepealGreaterThan(Integer value) {
            addCriterion("auto_repeal >", value, "autoRepeal");
            return (Criteria) this;
        }

        public Criteria andAutoRepealGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_repeal >=", value, "autoRepeal");
            return (Criteria) this;
        }

        public Criteria andAutoRepealLessThan(Integer value) {
            addCriterion("auto_repeal <", value, "autoRepeal");
            return (Criteria) this;
        }

        public Criteria andAutoRepealLessThanOrEqualTo(Integer value) {
            addCriterion("auto_repeal <=", value, "autoRepeal");
            return (Criteria) this;
        }

        public Criteria andAutoRepealIn(List<Integer> values) {
            addCriterion("auto_repeal in", values, "autoRepeal");
            return (Criteria) this;
        }

        public Criteria andAutoRepealNotIn(List<Integer> values) {
            addCriterion("auto_repeal not in", values, "autoRepeal");
            return (Criteria) this;
        }

        public Criteria andAutoRepealBetween(Integer value1, Integer value2) {
            addCriterion("auto_repeal between", value1, value2, "autoRepeal");
            return (Criteria) this;
        }

        public Criteria andAutoRepealNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_repeal not between", value1, value2, "autoRepeal");
            return (Criteria) this;
        }

        public Criteria andAutoRepealTimeIsNull() {
            addCriterion("auto_repeal_time is null");
            return (Criteria) this;
        }

        public Criteria andAutoRepealTimeIsNotNull() {
            addCriterion("auto_repeal_time is not null");
            return (Criteria) this;
        }

        public Criteria andAutoRepealTimeEqualTo(Date value) {
            addCriterion("auto_repeal_time =", value, "autoRepealTime");
            return (Criteria) this;
        }

        public Criteria andAutoRepealTimeNotEqualTo(Date value) {
            addCriterion("auto_repeal_time <>", value, "autoRepealTime");
            return (Criteria) this;
        }

        public Criteria andAutoRepealTimeGreaterThan(Date value) {
            addCriterion("auto_repeal_time >", value, "autoRepealTime");
            return (Criteria) this;
        }

        public Criteria andAutoRepealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("auto_repeal_time >=", value, "autoRepealTime");
            return (Criteria) this;
        }

        public Criteria andAutoRepealTimeLessThan(Date value) {
            addCriterion("auto_repeal_time <", value, "autoRepealTime");
            return (Criteria) this;
        }

        public Criteria andAutoRepealTimeLessThanOrEqualTo(Date value) {
            addCriterion("auto_repeal_time <=", value, "autoRepealTime");
            return (Criteria) this;
        }

        public Criteria andAutoRepealTimeIn(List<Date> values) {
            addCriterion("auto_repeal_time in", values, "autoRepealTime");
            return (Criteria) this;
        }

        public Criteria andAutoRepealTimeNotIn(List<Date> values) {
            addCriterion("auto_repeal_time not in", values, "autoRepealTime");
            return (Criteria) this;
        }

        public Criteria andAutoRepealTimeBetween(Date value1, Date value2) {
            addCriterion("auto_repeal_time between", value1, value2, "autoRepealTime");
            return (Criteria) this;
        }

        public Criteria andAutoRepealTimeNotBetween(Date value1, Date value2) {
            addCriterion("auto_repeal_time not between", value1, value2, "autoRepealTime");
            return (Criteria) this;
        }

        public Criteria andApplyAdminIdIsNull() {
            addCriterion("apply_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyAdminIdIsNotNull() {
            addCriterion("apply_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyAdminIdEqualTo(Long value) {
            addCriterion("apply_admin_id =", value, "applyAdminId");
            return (Criteria) this;
        }

        public Criteria andApplyAdminIdNotEqualTo(Long value) {
            addCriterion("apply_admin_id <>", value, "applyAdminId");
            return (Criteria) this;
        }

        public Criteria andApplyAdminIdGreaterThan(Long value) {
            addCriterion("apply_admin_id >", value, "applyAdminId");
            return (Criteria) this;
        }

        public Criteria andApplyAdminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("apply_admin_id >=", value, "applyAdminId");
            return (Criteria) this;
        }

        public Criteria andApplyAdminIdLessThan(Long value) {
            addCriterion("apply_admin_id <", value, "applyAdminId");
            return (Criteria) this;
        }

        public Criteria andApplyAdminIdLessThanOrEqualTo(Long value) {
            addCriterion("apply_admin_id <=", value, "applyAdminId");
            return (Criteria) this;
        }

        public Criteria andApplyAdminIdIn(List<Long> values) {
            addCriterion("apply_admin_id in", values, "applyAdminId");
            return (Criteria) this;
        }

        public Criteria andApplyAdminIdNotIn(List<Long> values) {
            addCriterion("apply_admin_id not in", values, "applyAdminId");
            return (Criteria) this;
        }

        public Criteria andApplyAdminIdBetween(Long value1, Long value2) {
            addCriterion("apply_admin_id between", value1, value2, "applyAdminId");
            return (Criteria) this;
        }

        public Criteria andApplyAdminIdNotBetween(Long value1, Long value2) {
            addCriterion("apply_admin_id not between", value1, value2, "applyAdminId");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNull() {
            addCriterion("apply_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("apply_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(Date value) {
            addCriterion("apply_time =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Date value) {
            addCriterion("apply_time <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Date value) {
            addCriterion("apply_time >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_time >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Date value) {
            addCriterion("apply_time <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_time <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(List<Date> values) {
            addCriterion("apply_time in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(List<Date> values) {
            addCriterion("apply_time not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Date value1, Date value2) {
            addCriterion("apply_time between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_time not between", value1, value2, "applyTime");
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