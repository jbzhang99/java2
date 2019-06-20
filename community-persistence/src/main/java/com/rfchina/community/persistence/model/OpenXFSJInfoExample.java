package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenXFSJInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenXFSJInfoExample() {
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andActTitileIsNull() {
            addCriterion("act_titile is null");
            return (Criteria) this;
        }

        public Criteria andActTitileIsNotNull() {
            addCriterion("act_titile is not null");
            return (Criteria) this;
        }

        public Criteria andActTitileEqualTo(String value) {
            addCriterion("act_titile =", value, "actTitile");
            return (Criteria) this;
        }

        public Criteria andActTitileNotEqualTo(String value) {
            addCriterion("act_titile <>", value, "actTitile");
            return (Criteria) this;
        }

        public Criteria andActTitileGreaterThan(String value) {
            addCriterion("act_titile >", value, "actTitile");
            return (Criteria) this;
        }

        public Criteria andActTitileGreaterThanOrEqualTo(String value) {
            addCriterion("act_titile >=", value, "actTitile");
            return (Criteria) this;
        }

        public Criteria andActTitileLessThan(String value) {
            addCriterion("act_titile <", value, "actTitile");
            return (Criteria) this;
        }

        public Criteria andActTitileLessThanOrEqualTo(String value) {
            addCriterion("act_titile <=", value, "actTitile");
            return (Criteria) this;
        }

        public Criteria andActTitileLike(String value) {
            addCriterion("act_titile like", value, "actTitile");
            return (Criteria) this;
        }

        public Criteria andActTitileNotLike(String value) {
            addCriterion("act_titile not like", value, "actTitile");
            return (Criteria) this;
        }

        public Criteria andActTitileIn(List<String> values) {
            addCriterion("act_titile in", values, "actTitile");
            return (Criteria) this;
        }

        public Criteria andActTitileNotIn(List<String> values) {
            addCriterion("act_titile not in", values, "actTitile");
            return (Criteria) this;
        }

        public Criteria andActTitileBetween(String value1, String value2) {
            addCriterion("act_titile between", value1, value2, "actTitile");
            return (Criteria) this;
        }

        public Criteria andActTitileNotBetween(String value1, String value2) {
            addCriterion("act_titile not between", value1, value2, "actTitile");
            return (Criteria) this;
        }

        public Criteria andActAddressIsNull() {
            addCriterion("act_address is null");
            return (Criteria) this;
        }

        public Criteria andActAddressIsNotNull() {
            addCriterion("act_address is not null");
            return (Criteria) this;
        }

        public Criteria andActAddressEqualTo(String value) {
            addCriterion("act_address =", value, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressNotEqualTo(String value) {
            addCriterion("act_address <>", value, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressGreaterThan(String value) {
            addCriterion("act_address >", value, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressGreaterThanOrEqualTo(String value) {
            addCriterion("act_address >=", value, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressLessThan(String value) {
            addCriterion("act_address <", value, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressLessThanOrEqualTo(String value) {
            addCriterion("act_address <=", value, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressLike(String value) {
            addCriterion("act_address like", value, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressNotLike(String value) {
            addCriterion("act_address not like", value, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressIn(List<String> values) {
            addCriterion("act_address in", values, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressNotIn(List<String> values) {
            addCriterion("act_address not in", values, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressBetween(String value1, String value2) {
            addCriterion("act_address between", value1, value2, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressNotBetween(String value1, String value2) {
            addCriterion("act_address not between", value1, value2, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActTimeIsNull() {
            addCriterion("act_time is null");
            return (Criteria) this;
        }

        public Criteria andActTimeIsNotNull() {
            addCriterion("act_time is not null");
            return (Criteria) this;
        }

        public Criteria andActTimeEqualTo(String value) {
            addCriterion("act_time =", value, "actTime");
            return (Criteria) this;
        }

        public Criteria andActTimeNotEqualTo(String value) {
            addCriterion("act_time <>", value, "actTime");
            return (Criteria) this;
        }

        public Criteria andActTimeGreaterThan(String value) {
            addCriterion("act_time >", value, "actTime");
            return (Criteria) this;
        }

        public Criteria andActTimeGreaterThanOrEqualTo(String value) {
            addCriterion("act_time >=", value, "actTime");
            return (Criteria) this;
        }

        public Criteria andActTimeLessThan(String value) {
            addCriterion("act_time <", value, "actTime");
            return (Criteria) this;
        }

        public Criteria andActTimeLessThanOrEqualTo(String value) {
            addCriterion("act_time <=", value, "actTime");
            return (Criteria) this;
        }

        public Criteria andActTimeLike(String value) {
            addCriterion("act_time like", value, "actTime");
            return (Criteria) this;
        }

        public Criteria andActTimeNotLike(String value) {
            addCriterion("act_time not like", value, "actTime");
            return (Criteria) this;
        }

        public Criteria andActTimeIn(List<String> values) {
            addCriterion("act_time in", values, "actTime");
            return (Criteria) this;
        }

        public Criteria andActTimeNotIn(List<String> values) {
            addCriterion("act_time not in", values, "actTime");
            return (Criteria) this;
        }

        public Criteria andActTimeBetween(String value1, String value2) {
            addCriterion("act_time between", value1, value2, "actTime");
            return (Criteria) this;
        }

        public Criteria andActTimeNotBetween(String value1, String value2) {
            addCriterion("act_time not between", value1, value2, "actTime");
            return (Criteria) this;
        }

        public Criteria andActImgIsNull() {
            addCriterion("act_img is null");
            return (Criteria) this;
        }

        public Criteria andActImgIsNotNull() {
            addCriterion("act_img is not null");
            return (Criteria) this;
        }

        public Criteria andActImgEqualTo(String value) {
            addCriterion("act_img =", value, "actImg");
            return (Criteria) this;
        }

        public Criteria andActImgNotEqualTo(String value) {
            addCriterion("act_img <>", value, "actImg");
            return (Criteria) this;
        }

        public Criteria andActImgGreaterThan(String value) {
            addCriterion("act_img >", value, "actImg");
            return (Criteria) this;
        }

        public Criteria andActImgGreaterThanOrEqualTo(String value) {
            addCriterion("act_img >=", value, "actImg");
            return (Criteria) this;
        }

        public Criteria andActImgLessThan(String value) {
            addCriterion("act_img <", value, "actImg");
            return (Criteria) this;
        }

        public Criteria andActImgLessThanOrEqualTo(String value) {
            addCriterion("act_img <=", value, "actImg");
            return (Criteria) this;
        }

        public Criteria andActImgLike(String value) {
            addCriterion("act_img like", value, "actImg");
            return (Criteria) this;
        }

        public Criteria andActImgNotLike(String value) {
            addCriterion("act_img not like", value, "actImg");
            return (Criteria) this;
        }

        public Criteria andActImgIn(List<String> values) {
            addCriterion("act_img in", values, "actImg");
            return (Criteria) this;
        }

        public Criteria andActImgNotIn(List<String> values) {
            addCriterion("act_img not in", values, "actImg");
            return (Criteria) this;
        }

        public Criteria andActImgBetween(String value1, String value2) {
            addCriterion("act_img between", value1, value2, "actImg");
            return (Criteria) this;
        }

        public Criteria andActImgNotBetween(String value1, String value2) {
            addCriterion("act_img not between", value1, value2, "actImg");
            return (Criteria) this;
        }

        public Criteria andActUrlIsNull() {
            addCriterion("act_url is null");
            return (Criteria) this;
        }

        public Criteria andActUrlIsNotNull() {
            addCriterion("act_url is not null");
            return (Criteria) this;
        }

        public Criteria andActUrlEqualTo(String value) {
            addCriterion("act_url =", value, "actUrl");
            return (Criteria) this;
        }

        public Criteria andActUrlNotEqualTo(String value) {
            addCriterion("act_url <>", value, "actUrl");
            return (Criteria) this;
        }

        public Criteria andActUrlGreaterThan(String value) {
            addCriterion("act_url >", value, "actUrl");
            return (Criteria) this;
        }

        public Criteria andActUrlGreaterThanOrEqualTo(String value) {
            addCriterion("act_url >=", value, "actUrl");
            return (Criteria) this;
        }

        public Criteria andActUrlLessThan(String value) {
            addCriterion("act_url <", value, "actUrl");
            return (Criteria) this;
        }

        public Criteria andActUrlLessThanOrEqualTo(String value) {
            addCriterion("act_url <=", value, "actUrl");
            return (Criteria) this;
        }

        public Criteria andActUrlLike(String value) {
            addCriterion("act_url like", value, "actUrl");
            return (Criteria) this;
        }

        public Criteria andActUrlNotLike(String value) {
            addCriterion("act_url not like", value, "actUrl");
            return (Criteria) this;
        }

        public Criteria andActUrlIn(List<String> values) {
            addCriterion("act_url in", values, "actUrl");
            return (Criteria) this;
        }

        public Criteria andActUrlNotIn(List<String> values) {
            addCriterion("act_url not in", values, "actUrl");
            return (Criteria) this;
        }

        public Criteria andActUrlBetween(String value1, String value2) {
            addCriterion("act_url between", value1, value2, "actUrl");
            return (Criteria) this;
        }

        public Criteria andActUrlNotBetween(String value1, String value2) {
            addCriterion("act_url not between", value1, value2, "actUrl");
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

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
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

        public Criteria andGroupConfigIdIsNull() {
            addCriterion("group_config_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupConfigIdIsNotNull() {
            addCriterion("group_config_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupConfigIdEqualTo(Long value) {
            addCriterion("group_config_id =", value, "groupConfigId");
            return (Criteria) this;
        }

        public Criteria andGroupConfigIdNotEqualTo(Long value) {
            addCriterion("group_config_id <>", value, "groupConfigId");
            return (Criteria) this;
        }

        public Criteria andGroupConfigIdGreaterThan(Long value) {
            addCriterion("group_config_id >", value, "groupConfigId");
            return (Criteria) this;
        }

        public Criteria andGroupConfigIdGreaterThanOrEqualTo(Long value) {
            addCriterion("group_config_id >=", value, "groupConfigId");
            return (Criteria) this;
        }

        public Criteria andGroupConfigIdLessThan(Long value) {
            addCriterion("group_config_id <", value, "groupConfigId");
            return (Criteria) this;
        }

        public Criteria andGroupConfigIdLessThanOrEqualTo(Long value) {
            addCriterion("group_config_id <=", value, "groupConfigId");
            return (Criteria) this;
        }

        public Criteria andGroupConfigIdIn(List<Long> values) {
            addCriterion("group_config_id in", values, "groupConfigId");
            return (Criteria) this;
        }

        public Criteria andGroupConfigIdNotIn(List<Long> values) {
            addCriterion("group_config_id not in", values, "groupConfigId");
            return (Criteria) this;
        }

        public Criteria andGroupConfigIdBetween(Long value1, Long value2) {
            addCriterion("group_config_id between", value1, value2, "groupConfigId");
            return (Criteria) this;
        }

        public Criteria andGroupConfigIdNotBetween(Long value1, Long value2) {
            addCriterion("group_config_id not between", value1, value2, "groupConfigId");
            return (Criteria) this;
        }

        public Criteria andAreaConfigIdIsNull() {
            addCriterion("area_config_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaConfigIdIsNotNull() {
            addCriterion("area_config_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaConfigIdEqualTo(Long value) {
            addCriterion("area_config_id =", value, "areaConfigId");
            return (Criteria) this;
        }

        public Criteria andAreaConfigIdNotEqualTo(Long value) {
            addCriterion("area_config_id <>", value, "areaConfigId");
            return (Criteria) this;
        }

        public Criteria andAreaConfigIdGreaterThan(Long value) {
            addCriterion("area_config_id >", value, "areaConfigId");
            return (Criteria) this;
        }

        public Criteria andAreaConfigIdGreaterThanOrEqualTo(Long value) {
            addCriterion("area_config_id >=", value, "areaConfigId");
            return (Criteria) this;
        }

        public Criteria andAreaConfigIdLessThan(Long value) {
            addCriterion("area_config_id <", value, "areaConfigId");
            return (Criteria) this;
        }

        public Criteria andAreaConfigIdLessThanOrEqualTo(Long value) {
            addCriterion("area_config_id <=", value, "areaConfigId");
            return (Criteria) this;
        }

        public Criteria andAreaConfigIdIn(List<Long> values) {
            addCriterion("area_config_id in", values, "areaConfigId");
            return (Criteria) this;
        }

        public Criteria andAreaConfigIdNotIn(List<Long> values) {
            addCriterion("area_config_id not in", values, "areaConfigId");
            return (Criteria) this;
        }

        public Criteria andAreaConfigIdBetween(Long value1, Long value2) {
            addCriterion("area_config_id between", value1, value2, "areaConfigId");
            return (Criteria) this;
        }

        public Criteria andAreaConfigIdNotBetween(Long value1, Long value2) {
            addCriterion("area_config_id not between", value1, value2, "areaConfigId");
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