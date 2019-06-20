package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommunityServiceRelaTempExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommunityServiceRelaTempExample() {
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

        public Criteria andServiceIdIsNull() {
            addCriterion("service_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("service_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(Integer value) {
            addCriterion("service_id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(Integer value) {
            addCriterion("service_id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(Integer value) {
            addCriterion("service_id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(Integer value) {
            addCriterion("service_id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(Integer value) {
            addCriterion("service_id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<Integer> values) {
            addCriterion("service_id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<Integer> values) {
            addCriterion("service_id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(Integer value1, Integer value2) {
            addCriterion("service_id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("service_id not between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andReorderIsNull() {
            addCriterion("reorder is null");
            return (Criteria) this;
        }

        public Criteria andReorderIsNotNull() {
            addCriterion("reorder is not null");
            return (Criteria) this;
        }

        public Criteria andReorderEqualTo(Integer value) {
            addCriterion("reorder =", value, "reorder");
            return (Criteria) this;
        }

        public Criteria andReorderNotEqualTo(Integer value) {
            addCriterion("reorder <>", value, "reorder");
            return (Criteria) this;
        }

        public Criteria andReorderGreaterThan(Integer value) {
            addCriterion("reorder >", value, "reorder");
            return (Criteria) this;
        }

        public Criteria andReorderGreaterThanOrEqualTo(Integer value) {
            addCriterion("reorder >=", value, "reorder");
            return (Criteria) this;
        }

        public Criteria andReorderLessThan(Integer value) {
            addCriterion("reorder <", value, "reorder");
            return (Criteria) this;
        }

        public Criteria andReorderLessThanOrEqualTo(Integer value) {
            addCriterion("reorder <=", value, "reorder");
            return (Criteria) this;
        }

        public Criteria andReorderIn(List<Integer> values) {
            addCriterion("reorder in", values, "reorder");
            return (Criteria) this;
        }

        public Criteria andReorderNotIn(List<Integer> values) {
            addCriterion("reorder not in", values, "reorder");
            return (Criteria) this;
        }

        public Criteria andReorderBetween(Integer value1, Integer value2) {
            addCriterion("reorder between", value1, value2, "reorder");
            return (Criteria) this;
        }

        public Criteria andReorderNotBetween(Integer value1, Integer value2) {
            addCriterion("reorder not between", value1, value2, "reorder");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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

        public Criteria andGroundTimeIsNull() {
            addCriterion("ground_time is null");
            return (Criteria) this;
        }

        public Criteria andGroundTimeIsNotNull() {
            addCriterion("ground_time is not null");
            return (Criteria) this;
        }

        public Criteria andGroundTimeEqualTo(Date value) {
            addCriterion("ground_time =", value, "groundTime");
            return (Criteria) this;
        }

        public Criteria andGroundTimeNotEqualTo(Date value) {
            addCriterion("ground_time <>", value, "groundTime");
            return (Criteria) this;
        }

        public Criteria andGroundTimeGreaterThan(Date value) {
            addCriterion("ground_time >", value, "groundTime");
            return (Criteria) this;
        }

        public Criteria andGroundTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ground_time >=", value, "groundTime");
            return (Criteria) this;
        }

        public Criteria andGroundTimeLessThan(Date value) {
            addCriterion("ground_time <", value, "groundTime");
            return (Criteria) this;
        }

        public Criteria andGroundTimeLessThanOrEqualTo(Date value) {
            addCriterion("ground_time <=", value, "groundTime");
            return (Criteria) this;
        }

        public Criteria andGroundTimeIn(List<Date> values) {
            addCriterion("ground_time in", values, "groundTime");
            return (Criteria) this;
        }

        public Criteria andGroundTimeNotIn(List<Date> values) {
            addCriterion("ground_time not in", values, "groundTime");
            return (Criteria) this;
        }

        public Criteria andGroundTimeBetween(Date value1, Date value2) {
            addCriterion("ground_time between", value1, value2, "groundTime");
            return (Criteria) this;
        }

        public Criteria andGroundTimeNotBetween(Date value1, Date value2) {
            addCriterion("ground_time not between", value1, value2, "groundTime");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(Integer value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(Integer value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(Integer value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(Integer value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(Integer value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<Integer> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<Integer> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(Integer value1, Integer value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
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

        public Criteria andServiceContactsNameIsNull() {
            addCriterion("service_contacts_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceContactsNameIsNotNull() {
            addCriterion("service_contacts_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceContactsNameEqualTo(String value) {
            addCriterion("service_contacts_name =", value, "serviceContactsName");
            return (Criteria) this;
        }

        public Criteria andServiceContactsNameNotEqualTo(String value) {
            addCriterion("service_contacts_name <>", value, "serviceContactsName");
            return (Criteria) this;
        }

        public Criteria andServiceContactsNameGreaterThan(String value) {
            addCriterion("service_contacts_name >", value, "serviceContactsName");
            return (Criteria) this;
        }

        public Criteria andServiceContactsNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_contacts_name >=", value, "serviceContactsName");
            return (Criteria) this;
        }

        public Criteria andServiceContactsNameLessThan(String value) {
            addCriterion("service_contacts_name <", value, "serviceContactsName");
            return (Criteria) this;
        }

        public Criteria andServiceContactsNameLessThanOrEqualTo(String value) {
            addCriterion("service_contacts_name <=", value, "serviceContactsName");
            return (Criteria) this;
        }

        public Criteria andServiceContactsNameLike(String value) {
            addCriterion("service_contacts_name like", value, "serviceContactsName");
            return (Criteria) this;
        }

        public Criteria andServiceContactsNameNotLike(String value) {
            addCriterion("service_contacts_name not like", value, "serviceContactsName");
            return (Criteria) this;
        }

        public Criteria andServiceContactsNameIn(List<String> values) {
            addCriterion("service_contacts_name in", values, "serviceContactsName");
            return (Criteria) this;
        }

        public Criteria andServiceContactsNameNotIn(List<String> values) {
            addCriterion("service_contacts_name not in", values, "serviceContactsName");
            return (Criteria) this;
        }

        public Criteria andServiceContactsNameBetween(String value1, String value2) {
            addCriterion("service_contacts_name between", value1, value2, "serviceContactsName");
            return (Criteria) this;
        }

        public Criteria andServiceContactsNameNotBetween(String value1, String value2) {
            addCriterion("service_contacts_name not between", value1, value2, "serviceContactsName");
            return (Criteria) this;
        }

        public Criteria andServiceContactsPhoneIsNull() {
            addCriterion("service_contacts_phone is null");
            return (Criteria) this;
        }

        public Criteria andServiceContactsPhoneIsNotNull() {
            addCriterion("service_contacts_phone is not null");
            return (Criteria) this;
        }

        public Criteria andServiceContactsPhoneEqualTo(String value) {
            addCriterion("service_contacts_phone =", value, "serviceContactsPhone");
            return (Criteria) this;
        }

        public Criteria andServiceContactsPhoneNotEqualTo(String value) {
            addCriterion("service_contacts_phone <>", value, "serviceContactsPhone");
            return (Criteria) this;
        }

        public Criteria andServiceContactsPhoneGreaterThan(String value) {
            addCriterion("service_contacts_phone >", value, "serviceContactsPhone");
            return (Criteria) this;
        }

        public Criteria andServiceContactsPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("service_contacts_phone >=", value, "serviceContactsPhone");
            return (Criteria) this;
        }

        public Criteria andServiceContactsPhoneLessThan(String value) {
            addCriterion("service_contacts_phone <", value, "serviceContactsPhone");
            return (Criteria) this;
        }

        public Criteria andServiceContactsPhoneLessThanOrEqualTo(String value) {
            addCriterion("service_contacts_phone <=", value, "serviceContactsPhone");
            return (Criteria) this;
        }

        public Criteria andServiceContactsPhoneLike(String value) {
            addCriterion("service_contacts_phone like", value, "serviceContactsPhone");
            return (Criteria) this;
        }

        public Criteria andServiceContactsPhoneNotLike(String value) {
            addCriterion("service_contacts_phone not like", value, "serviceContactsPhone");
            return (Criteria) this;
        }

        public Criteria andServiceContactsPhoneIn(List<String> values) {
            addCriterion("service_contacts_phone in", values, "serviceContactsPhone");
            return (Criteria) this;
        }

        public Criteria andServiceContactsPhoneNotIn(List<String> values) {
            addCriterion("service_contacts_phone not in", values, "serviceContactsPhone");
            return (Criteria) this;
        }

        public Criteria andServiceContactsPhoneBetween(String value1, String value2) {
            addCriterion("service_contacts_phone between", value1, value2, "serviceContactsPhone");
            return (Criteria) this;
        }

        public Criteria andServiceContactsPhoneNotBetween(String value1, String value2) {
            addCriterion("service_contacts_phone not between", value1, value2, "serviceContactsPhone");
            return (Criteria) this;
        }

        public Criteria andServiceContactsEmailIsNull() {
            addCriterion("service_contacts_email is null");
            return (Criteria) this;
        }

        public Criteria andServiceContactsEmailIsNotNull() {
            addCriterion("service_contacts_email is not null");
            return (Criteria) this;
        }

        public Criteria andServiceContactsEmailEqualTo(String value) {
            addCriterion("service_contacts_email =", value, "serviceContactsEmail");
            return (Criteria) this;
        }

        public Criteria andServiceContactsEmailNotEqualTo(String value) {
            addCriterion("service_contacts_email <>", value, "serviceContactsEmail");
            return (Criteria) this;
        }

        public Criteria andServiceContactsEmailGreaterThan(String value) {
            addCriterion("service_contacts_email >", value, "serviceContactsEmail");
            return (Criteria) this;
        }

        public Criteria andServiceContactsEmailGreaterThanOrEqualTo(String value) {
            addCriterion("service_contacts_email >=", value, "serviceContactsEmail");
            return (Criteria) this;
        }

        public Criteria andServiceContactsEmailLessThan(String value) {
            addCriterion("service_contacts_email <", value, "serviceContactsEmail");
            return (Criteria) this;
        }

        public Criteria andServiceContactsEmailLessThanOrEqualTo(String value) {
            addCriterion("service_contacts_email <=", value, "serviceContactsEmail");
            return (Criteria) this;
        }

        public Criteria andServiceContactsEmailLike(String value) {
            addCriterion("service_contacts_email like", value, "serviceContactsEmail");
            return (Criteria) this;
        }

        public Criteria andServiceContactsEmailNotLike(String value) {
            addCriterion("service_contacts_email not like", value, "serviceContactsEmail");
            return (Criteria) this;
        }

        public Criteria andServiceContactsEmailIn(List<String> values) {
            addCriterion("service_contacts_email in", values, "serviceContactsEmail");
            return (Criteria) this;
        }

        public Criteria andServiceContactsEmailNotIn(List<String> values) {
            addCriterion("service_contacts_email not in", values, "serviceContactsEmail");
            return (Criteria) this;
        }

        public Criteria andServiceContactsEmailBetween(String value1, String value2) {
            addCriterion("service_contacts_email between", value1, value2, "serviceContactsEmail");
            return (Criteria) this;
        }

        public Criteria andServiceContactsEmailNotBetween(String value1, String value2) {
            addCriterion("service_contacts_email not between", value1, value2, "serviceContactsEmail");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsNameIsNull() {
            addCriterion("community_contacts_name is null");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsNameIsNotNull() {
            addCriterion("community_contacts_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsNameEqualTo(String value) {
            addCriterion("community_contacts_name =", value, "communityContactsName");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsNameNotEqualTo(String value) {
            addCriterion("community_contacts_name <>", value, "communityContactsName");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsNameGreaterThan(String value) {
            addCriterion("community_contacts_name >", value, "communityContactsName");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsNameGreaterThanOrEqualTo(String value) {
            addCriterion("community_contacts_name >=", value, "communityContactsName");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsNameLessThan(String value) {
            addCriterion("community_contacts_name <", value, "communityContactsName");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsNameLessThanOrEqualTo(String value) {
            addCriterion("community_contacts_name <=", value, "communityContactsName");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsNameLike(String value) {
            addCriterion("community_contacts_name like", value, "communityContactsName");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsNameNotLike(String value) {
            addCriterion("community_contacts_name not like", value, "communityContactsName");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsNameIn(List<String> values) {
            addCriterion("community_contacts_name in", values, "communityContactsName");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsNameNotIn(List<String> values) {
            addCriterion("community_contacts_name not in", values, "communityContactsName");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsNameBetween(String value1, String value2) {
            addCriterion("community_contacts_name between", value1, value2, "communityContactsName");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsNameNotBetween(String value1, String value2) {
            addCriterion("community_contacts_name not between", value1, value2, "communityContactsName");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsPhoneIsNull() {
            addCriterion("community_contacts_phone is null");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsPhoneIsNotNull() {
            addCriterion("community_contacts_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsPhoneEqualTo(String value) {
            addCriterion("community_contacts_phone =", value, "communityContactsPhone");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsPhoneNotEqualTo(String value) {
            addCriterion("community_contacts_phone <>", value, "communityContactsPhone");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsPhoneGreaterThan(String value) {
            addCriterion("community_contacts_phone >", value, "communityContactsPhone");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("community_contacts_phone >=", value, "communityContactsPhone");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsPhoneLessThan(String value) {
            addCriterion("community_contacts_phone <", value, "communityContactsPhone");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsPhoneLessThanOrEqualTo(String value) {
            addCriterion("community_contacts_phone <=", value, "communityContactsPhone");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsPhoneLike(String value) {
            addCriterion("community_contacts_phone like", value, "communityContactsPhone");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsPhoneNotLike(String value) {
            addCriterion("community_contacts_phone not like", value, "communityContactsPhone");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsPhoneIn(List<String> values) {
            addCriterion("community_contacts_phone in", values, "communityContactsPhone");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsPhoneNotIn(List<String> values) {
            addCriterion("community_contacts_phone not in", values, "communityContactsPhone");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsPhoneBetween(String value1, String value2) {
            addCriterion("community_contacts_phone between", value1, value2, "communityContactsPhone");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsPhoneNotBetween(String value1, String value2) {
            addCriterion("community_contacts_phone not between", value1, value2, "communityContactsPhone");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsEmailIsNull() {
            addCriterion("community_contacts_email is null");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsEmailIsNotNull() {
            addCriterion("community_contacts_email is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsEmailEqualTo(String value) {
            addCriterion("community_contacts_email =", value, "communityContactsEmail");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsEmailNotEqualTo(String value) {
            addCriterion("community_contacts_email <>", value, "communityContactsEmail");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsEmailGreaterThan(String value) {
            addCriterion("community_contacts_email >", value, "communityContactsEmail");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsEmailGreaterThanOrEqualTo(String value) {
            addCriterion("community_contacts_email >=", value, "communityContactsEmail");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsEmailLessThan(String value) {
            addCriterion("community_contacts_email <", value, "communityContactsEmail");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsEmailLessThanOrEqualTo(String value) {
            addCriterion("community_contacts_email <=", value, "communityContactsEmail");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsEmailLike(String value) {
            addCriterion("community_contacts_email like", value, "communityContactsEmail");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsEmailNotLike(String value) {
            addCriterion("community_contacts_email not like", value, "communityContactsEmail");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsEmailIn(List<String> values) {
            addCriterion("community_contacts_email in", values, "communityContactsEmail");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsEmailNotIn(List<String> values) {
            addCriterion("community_contacts_email not in", values, "communityContactsEmail");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsEmailBetween(String value1, String value2) {
            addCriterion("community_contacts_email between", value1, value2, "communityContactsEmail");
            return (Criteria) this;
        }

        public Criteria andCommunityContactsEmailNotBetween(String value1, String value2) {
            addCriterion("community_contacts_email not between", value1, value2, "communityContactsEmail");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeIsNull() {
            addCriterion("interview_time is null");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeIsNotNull() {
            addCriterion("interview_time is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeEqualTo(Date value) {
            addCriterion("interview_time =", value, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeNotEqualTo(Date value) {
            addCriterion("interview_time <>", value, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeGreaterThan(Date value) {
            addCriterion("interview_time >", value, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("interview_time >=", value, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeLessThan(Date value) {
            addCriterion("interview_time <", value, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeLessThanOrEqualTo(Date value) {
            addCriterion("interview_time <=", value, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeIn(List<Date> values) {
            addCriterion("interview_time in", values, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeNotIn(List<Date> values) {
            addCriterion("interview_time not in", values, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeBetween(Date value1, Date value2) {
            addCriterion("interview_time between", value1, value2, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeNotBetween(Date value1, Date value2) {
            addCriterion("interview_time not between", value1, value2, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressIsNull() {
            addCriterion("interview_address is null");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressIsNotNull() {
            addCriterion("interview_address is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressEqualTo(String value) {
            addCriterion("interview_address =", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressNotEqualTo(String value) {
            addCriterion("interview_address <>", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressGreaterThan(String value) {
            addCriterion("interview_address >", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressGreaterThanOrEqualTo(String value) {
            addCriterion("interview_address >=", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressLessThan(String value) {
            addCriterion("interview_address <", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressLessThanOrEqualTo(String value) {
            addCriterion("interview_address <=", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressLike(String value) {
            addCriterion("interview_address like", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressNotLike(String value) {
            addCriterion("interview_address not like", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressIn(List<String> values) {
            addCriterion("interview_address in", values, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressNotIn(List<String> values) {
            addCriterion("interview_address not in", values, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressBetween(String value1, String value2) {
            addCriterion("interview_address between", value1, value2, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressNotBetween(String value1, String value2) {
            addCriterion("interview_address not between", value1, value2, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andSelectStatusIsNull() {
            addCriterion("select_status is null");
            return (Criteria) this;
        }

        public Criteria andSelectStatusIsNotNull() {
            addCriterion("select_status is not null");
            return (Criteria) this;
        }

        public Criteria andSelectStatusEqualTo(Integer value) {
            addCriterion("select_status =", value, "selectStatus");
            return (Criteria) this;
        }

        public Criteria andSelectStatusNotEqualTo(Integer value) {
            addCriterion("select_status <>", value, "selectStatus");
            return (Criteria) this;
        }

        public Criteria andSelectStatusGreaterThan(Integer value) {
            addCriterion("select_status >", value, "selectStatus");
            return (Criteria) this;
        }

        public Criteria andSelectStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("select_status >=", value, "selectStatus");
            return (Criteria) this;
        }

        public Criteria andSelectStatusLessThan(Integer value) {
            addCriterion("select_status <", value, "selectStatus");
            return (Criteria) this;
        }

        public Criteria andSelectStatusLessThanOrEqualTo(Integer value) {
            addCriterion("select_status <=", value, "selectStatus");
            return (Criteria) this;
        }

        public Criteria andSelectStatusIn(List<Integer> values) {
            addCriterion("select_status in", values, "selectStatus");
            return (Criteria) this;
        }

        public Criteria andSelectStatusNotIn(List<Integer> values) {
            addCriterion("select_status not in", values, "selectStatus");
            return (Criteria) this;
        }

        public Criteria andSelectStatusBetween(Integer value1, Integer value2) {
            addCriterion("select_status between", value1, value2, "selectStatus");
            return (Criteria) this;
        }

        public Criteria andSelectStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("select_status not between", value1, value2, "selectStatus");
            return (Criteria) this;
        }

        public Criteria andAuditCommentIsNull() {
            addCriterion("audit_comment is null");
            return (Criteria) this;
        }

        public Criteria andAuditCommentIsNotNull() {
            addCriterion("audit_comment is not null");
            return (Criteria) this;
        }

        public Criteria andAuditCommentEqualTo(String value) {
            addCriterion("audit_comment =", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentNotEqualTo(String value) {
            addCriterion("audit_comment <>", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentGreaterThan(String value) {
            addCriterion("audit_comment >", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentGreaterThanOrEqualTo(String value) {
            addCriterion("audit_comment >=", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentLessThan(String value) {
            addCriterion("audit_comment <", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentLessThanOrEqualTo(String value) {
            addCriterion("audit_comment <=", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentLike(String value) {
            addCriterion("audit_comment like", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentNotLike(String value) {
            addCriterion("audit_comment not like", value, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentIn(List<String> values) {
            addCriterion("audit_comment in", values, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentNotIn(List<String> values) {
            addCriterion("audit_comment not in", values, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentBetween(String value1, String value2) {
            addCriterion("audit_comment between", value1, value2, "auditComment");
            return (Criteria) this;
        }

        public Criteria andAuditCommentNotBetween(String value1, String value2) {
            addCriterion("audit_comment not between", value1, value2, "auditComment");
            return (Criteria) this;
        }

        public Criteria andIsMenuShowIsNull() {
            addCriterion("is_menu_show is null");
            return (Criteria) this;
        }

        public Criteria andIsMenuShowIsNotNull() {
            addCriterion("is_menu_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsMenuShowEqualTo(Integer value) {
            addCriterion("is_menu_show =", value, "isMenuShow");
            return (Criteria) this;
        }

        public Criteria andIsMenuShowNotEqualTo(Integer value) {
            addCriterion("is_menu_show <>", value, "isMenuShow");
            return (Criteria) this;
        }

        public Criteria andIsMenuShowGreaterThan(Integer value) {
            addCriterion("is_menu_show >", value, "isMenuShow");
            return (Criteria) this;
        }

        public Criteria andIsMenuShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_menu_show >=", value, "isMenuShow");
            return (Criteria) this;
        }

        public Criteria andIsMenuShowLessThan(Integer value) {
            addCriterion("is_menu_show <", value, "isMenuShow");
            return (Criteria) this;
        }

        public Criteria andIsMenuShowLessThanOrEqualTo(Integer value) {
            addCriterion("is_menu_show <=", value, "isMenuShow");
            return (Criteria) this;
        }

        public Criteria andIsMenuShowIn(List<Integer> values) {
            addCriterion("is_menu_show in", values, "isMenuShow");
            return (Criteria) this;
        }

        public Criteria andIsMenuShowNotIn(List<Integer> values) {
            addCriterion("is_menu_show not in", values, "isMenuShow");
            return (Criteria) this;
        }

        public Criteria andIsMenuShowBetween(Integer value1, Integer value2) {
            addCriterion("is_menu_show between", value1, value2, "isMenuShow");
            return (Criteria) this;
        }

        public Criteria andIsMenuShowNotBetween(Integer value1, Integer value2) {
            addCriterion("is_menu_show not between", value1, value2, "isMenuShow");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeIsNull() {
            addCriterion("notify_time is null");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeIsNotNull() {
            addCriterion("notify_time is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeEqualTo(Date value) {
            addCriterion("notify_time =", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeNotEqualTo(Date value) {
            addCriterion("notify_time <>", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeGreaterThan(Date value) {
            addCriterion("notify_time >", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("notify_time >=", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeLessThan(Date value) {
            addCriterion("notify_time <", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("notify_time <=", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeIn(List<Date> values) {
            addCriterion("notify_time in", values, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeNotIn(List<Date> values) {
            addCriterion("notify_time not in", values, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeBetween(Date value1, Date value2) {
            addCriterion("notify_time between", value1, value2, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("notify_time not between", value1, value2, "notifyTime");
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