package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysDataUploadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysDataUploadExample() {
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

        public Criteria andSrcLinkIsNull() {
            addCriterion("src_link is null");
            return (Criteria) this;
        }

        public Criteria andSrcLinkIsNotNull() {
            addCriterion("src_link is not null");
            return (Criteria) this;
        }

        public Criteria andSrcLinkEqualTo(String value) {
            addCriterion("src_link =", value, "srcLink");
            return (Criteria) this;
        }

        public Criteria andSrcLinkNotEqualTo(String value) {
            addCriterion("src_link <>", value, "srcLink");
            return (Criteria) this;
        }

        public Criteria andSrcLinkGreaterThan(String value) {
            addCriterion("src_link >", value, "srcLink");
            return (Criteria) this;
        }

        public Criteria andSrcLinkGreaterThanOrEqualTo(String value) {
            addCriterion("src_link >=", value, "srcLink");
            return (Criteria) this;
        }

        public Criteria andSrcLinkLessThan(String value) {
            addCriterion("src_link <", value, "srcLink");
            return (Criteria) this;
        }

        public Criteria andSrcLinkLessThanOrEqualTo(String value) {
            addCriterion("src_link <=", value, "srcLink");
            return (Criteria) this;
        }

        public Criteria andSrcLinkLike(String value) {
            addCriterion("src_link like", value, "srcLink");
            return (Criteria) this;
        }

        public Criteria andSrcLinkNotLike(String value) {
            addCriterion("src_link not like", value, "srcLink");
            return (Criteria) this;
        }

        public Criteria andSrcLinkIn(List<String> values) {
            addCriterion("src_link in", values, "srcLink");
            return (Criteria) this;
        }

        public Criteria andSrcLinkNotIn(List<String> values) {
            addCriterion("src_link not in", values, "srcLink");
            return (Criteria) this;
        }

        public Criteria andSrcLinkBetween(String value1, String value2) {
            addCriterion("src_link between", value1, value2, "srcLink");
            return (Criteria) this;
        }

        public Criteria andSrcLinkNotBetween(String value1, String value2) {
            addCriterion("src_link not between", value1, value2, "srcLink");
            return (Criteria) this;
        }

        public Criteria andDownLinkIsNull() {
            addCriterion("down_link is null");
            return (Criteria) this;
        }

        public Criteria andDownLinkIsNotNull() {
            addCriterion("down_link is not null");
            return (Criteria) this;
        }

        public Criteria andDownLinkEqualTo(String value) {
            addCriterion("down_link =", value, "downLink");
            return (Criteria) this;
        }

        public Criteria andDownLinkNotEqualTo(String value) {
            addCriterion("down_link <>", value, "downLink");
            return (Criteria) this;
        }

        public Criteria andDownLinkGreaterThan(String value) {
            addCriterion("down_link >", value, "downLink");
            return (Criteria) this;
        }

        public Criteria andDownLinkGreaterThanOrEqualTo(String value) {
            addCriterion("down_link >=", value, "downLink");
            return (Criteria) this;
        }

        public Criteria andDownLinkLessThan(String value) {
            addCriterion("down_link <", value, "downLink");
            return (Criteria) this;
        }

        public Criteria andDownLinkLessThanOrEqualTo(String value) {
            addCriterion("down_link <=", value, "downLink");
            return (Criteria) this;
        }

        public Criteria andDownLinkLike(String value) {
            addCriterion("down_link like", value, "downLink");
            return (Criteria) this;
        }

        public Criteria andDownLinkNotLike(String value) {
            addCriterion("down_link not like", value, "downLink");
            return (Criteria) this;
        }

        public Criteria andDownLinkIn(List<String> values) {
            addCriterion("down_link in", values, "downLink");
            return (Criteria) this;
        }

        public Criteria andDownLinkNotIn(List<String> values) {
            addCriterion("down_link not in", values, "downLink");
            return (Criteria) this;
        }

        public Criteria andDownLinkBetween(String value1, String value2) {
            addCriterion("down_link between", value1, value2, "downLink");
            return (Criteria) this;
        }

        public Criteria andDownLinkNotBetween(String value1, String value2) {
            addCriterion("down_link not between", value1, value2, "downLink");
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

        public Criteria andMasterIdIsNull() {
            addCriterion("master_id is null");
            return (Criteria) this;
        }

        public Criteria andMasterIdIsNotNull() {
            addCriterion("master_id is not null");
            return (Criteria) this;
        }

        public Criteria andMasterIdEqualTo(Long value) {
            addCriterion("master_id =", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotEqualTo(Long value) {
            addCriterion("master_id <>", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdGreaterThan(Long value) {
            addCriterion("master_id >", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("master_id >=", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLessThan(Long value) {
            addCriterion("master_id <", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLessThanOrEqualTo(Long value) {
            addCriterion("master_id <=", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdIn(List<Long> values) {
            addCriterion("master_id in", values, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotIn(List<Long> values) {
            addCriterion("master_id not in", values, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdBetween(Long value1, Long value2) {
            addCriterion("master_id between", value1, value2, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotBetween(Long value1, Long value2) {
            addCriterion("master_id not between", value1, value2, "masterId");
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

        public Criteria andXlsxIndexIsNull() {
            addCriterion("xlsx_index is null");
            return (Criteria) this;
        }

        public Criteria andXlsxIndexIsNotNull() {
            addCriterion("xlsx_index is not null");
            return (Criteria) this;
        }

        public Criteria andXlsxIndexEqualTo(Integer value) {
            addCriterion("xlsx_index =", value, "xlsxIndex");
            return (Criteria) this;
        }

        public Criteria andXlsxIndexNotEqualTo(Integer value) {
            addCriterion("xlsx_index <>", value, "xlsxIndex");
            return (Criteria) this;
        }

        public Criteria andXlsxIndexGreaterThan(Integer value) {
            addCriterion("xlsx_index >", value, "xlsxIndex");
            return (Criteria) this;
        }

        public Criteria andXlsxIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("xlsx_index >=", value, "xlsxIndex");
            return (Criteria) this;
        }

        public Criteria andXlsxIndexLessThan(Integer value) {
            addCriterion("xlsx_index <", value, "xlsxIndex");
            return (Criteria) this;
        }

        public Criteria andXlsxIndexLessThanOrEqualTo(Integer value) {
            addCriterion("xlsx_index <=", value, "xlsxIndex");
            return (Criteria) this;
        }

        public Criteria andXlsxIndexIn(List<Integer> values) {
            addCriterion("xlsx_index in", values, "xlsxIndex");
            return (Criteria) this;
        }

        public Criteria andXlsxIndexNotIn(List<Integer> values) {
            addCriterion("xlsx_index not in", values, "xlsxIndex");
            return (Criteria) this;
        }

        public Criteria andXlsxIndexBetween(Integer value1, Integer value2) {
            addCriterion("xlsx_index between", value1, value2, "xlsxIndex");
            return (Criteria) this;
        }

        public Criteria andXlsxIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("xlsx_index not between", value1, value2, "xlsxIndex");
            return (Criteria) this;
        }

        public Criteria andUserPathIsNull() {
            addCriterion("user_path is null");
            return (Criteria) this;
        }

        public Criteria andUserPathIsNotNull() {
            addCriterion("user_path is not null");
            return (Criteria) this;
        }

        public Criteria andUserPathEqualTo(String value) {
            addCriterion("user_path =", value, "userPath");
            return (Criteria) this;
        }

        public Criteria andUserPathNotEqualTo(String value) {
            addCriterion("user_path <>", value, "userPath");
            return (Criteria) this;
        }

        public Criteria andUserPathGreaterThan(String value) {
            addCriterion("user_path >", value, "userPath");
            return (Criteria) this;
        }

        public Criteria andUserPathGreaterThanOrEqualTo(String value) {
            addCriterion("user_path >=", value, "userPath");
            return (Criteria) this;
        }

        public Criteria andUserPathLessThan(String value) {
            addCriterion("user_path <", value, "userPath");
            return (Criteria) this;
        }

        public Criteria andUserPathLessThanOrEqualTo(String value) {
            addCriterion("user_path <=", value, "userPath");
            return (Criteria) this;
        }

        public Criteria andUserPathLike(String value) {
            addCriterion("user_path like", value, "userPath");
            return (Criteria) this;
        }

        public Criteria andUserPathNotLike(String value) {
            addCriterion("user_path not like", value, "userPath");
            return (Criteria) this;
        }

        public Criteria andUserPathIn(List<String> values) {
            addCriterion("user_path in", values, "userPath");
            return (Criteria) this;
        }

        public Criteria andUserPathNotIn(List<String> values) {
            addCriterion("user_path not in", values, "userPath");
            return (Criteria) this;
        }

        public Criteria andUserPathBetween(String value1, String value2) {
            addCriterion("user_path between", value1, value2, "userPath");
            return (Criteria) this;
        }

        public Criteria andUserPathNotBetween(String value1, String value2) {
            addCriterion("user_path not between", value1, value2, "userPath");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andTestRunIsNull() {
            addCriterion("test_run is null");
            return (Criteria) this;
        }

        public Criteria andTestRunIsNotNull() {
            addCriterion("test_run is not null");
            return (Criteria) this;
        }

        public Criteria andTestRunEqualTo(Integer value) {
            addCriterion("test_run =", value, "testRun");
            return (Criteria) this;
        }

        public Criteria andTestRunNotEqualTo(Integer value) {
            addCriterion("test_run <>", value, "testRun");
            return (Criteria) this;
        }

        public Criteria andTestRunGreaterThan(Integer value) {
            addCriterion("test_run >", value, "testRun");
            return (Criteria) this;
        }

        public Criteria andTestRunGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_run >=", value, "testRun");
            return (Criteria) this;
        }

        public Criteria andTestRunLessThan(Integer value) {
            addCriterion("test_run <", value, "testRun");
            return (Criteria) this;
        }

        public Criteria andTestRunLessThanOrEqualTo(Integer value) {
            addCriterion("test_run <=", value, "testRun");
            return (Criteria) this;
        }

        public Criteria andTestRunIn(List<Integer> values) {
            addCriterion("test_run in", values, "testRun");
            return (Criteria) this;
        }

        public Criteria andTestRunNotIn(List<Integer> values) {
            addCriterion("test_run not in", values, "testRun");
            return (Criteria) this;
        }

        public Criteria andTestRunBetween(Integer value1, Integer value2) {
            addCriterion("test_run between", value1, value2, "testRun");
            return (Criteria) this;
        }

        public Criteria andTestRunNotBetween(Integer value1, Integer value2) {
            addCriterion("test_run not between", value1, value2, "testRun");
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