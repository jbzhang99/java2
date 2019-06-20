package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReleaseApplyGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReleaseApplyGoodsExample() {
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

        public Criteria andApplicantNameIsNull() {
            addCriterion("applicant_name is null");
            return (Criteria) this;
        }

        public Criteria andApplicantNameIsNotNull() {
            addCriterion("applicant_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantNameEqualTo(String value) {
            addCriterion("applicant_name =", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotEqualTo(String value) {
            addCriterion("applicant_name <>", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameGreaterThan(String value) {
            addCriterion("applicant_name >", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_name >=", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameLessThan(String value) {
            addCriterion("applicant_name <", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameLessThanOrEqualTo(String value) {
            addCriterion("applicant_name <=", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameLike(String value) {
            addCriterion("applicant_name like", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotLike(String value) {
            addCriterion("applicant_name not like", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameIn(List<String> values) {
            addCriterion("applicant_name in", values, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotIn(List<String> values) {
            addCriterion("applicant_name not in", values, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameBetween(String value1, String value2) {
            addCriterion("applicant_name between", value1, value2, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotBetween(String value1, String value2) {
            addCriterion("applicant_name not between", value1, value2, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneIsNull() {
            addCriterion("applicant_phone is null");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneIsNotNull() {
            addCriterion("applicant_phone is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneEqualTo(String value) {
            addCriterion("applicant_phone =", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneNotEqualTo(String value) {
            addCriterion("applicant_phone <>", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneGreaterThan(String value) {
            addCriterion("applicant_phone >", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_phone >=", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneLessThan(String value) {
            addCriterion("applicant_phone <", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneLessThanOrEqualTo(String value) {
            addCriterion("applicant_phone <=", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneLike(String value) {
            addCriterion("applicant_phone like", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneNotLike(String value) {
            addCriterion("applicant_phone not like", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneIn(List<String> values) {
            addCriterion("applicant_phone in", values, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneNotIn(List<String> values) {
            addCriterion("applicant_phone not in", values, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneBetween(String value1, String value2) {
            addCriterion("applicant_phone between", value1, value2, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneNotBetween(String value1, String value2) {
            addCriterion("applicant_phone not between", value1, value2, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andCarrierNameIsNull() {
            addCriterion("carrier_name is null");
            return (Criteria) this;
        }

        public Criteria andCarrierNameIsNotNull() {
            addCriterion("carrier_name is not null");
            return (Criteria) this;
        }

        public Criteria andCarrierNameEqualTo(String value) {
            addCriterion("carrier_name =", value, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameNotEqualTo(String value) {
            addCriterion("carrier_name <>", value, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameGreaterThan(String value) {
            addCriterion("carrier_name >", value, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameGreaterThanOrEqualTo(String value) {
            addCriterion("carrier_name >=", value, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameLessThan(String value) {
            addCriterion("carrier_name <", value, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameLessThanOrEqualTo(String value) {
            addCriterion("carrier_name <=", value, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameLike(String value) {
            addCriterion("carrier_name like", value, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameNotLike(String value) {
            addCriterion("carrier_name not like", value, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameIn(List<String> values) {
            addCriterion("carrier_name in", values, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameNotIn(List<String> values) {
            addCriterion("carrier_name not in", values, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameBetween(String value1, String value2) {
            addCriterion("carrier_name between", value1, value2, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameNotBetween(String value1, String value2) {
            addCriterion("carrier_name not between", value1, value2, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierPhoneIsNull() {
            addCriterion("carrier_phone is null");
            return (Criteria) this;
        }

        public Criteria andCarrierPhoneIsNotNull() {
            addCriterion("carrier_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCarrierPhoneEqualTo(String value) {
            addCriterion("carrier_phone =", value, "carrierPhone");
            return (Criteria) this;
        }

        public Criteria andCarrierPhoneNotEqualTo(String value) {
            addCriterion("carrier_phone <>", value, "carrierPhone");
            return (Criteria) this;
        }

        public Criteria andCarrierPhoneGreaterThan(String value) {
            addCriterion("carrier_phone >", value, "carrierPhone");
            return (Criteria) this;
        }

        public Criteria andCarrierPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("carrier_phone >=", value, "carrierPhone");
            return (Criteria) this;
        }

        public Criteria andCarrierPhoneLessThan(String value) {
            addCriterion("carrier_phone <", value, "carrierPhone");
            return (Criteria) this;
        }

        public Criteria andCarrierPhoneLessThanOrEqualTo(String value) {
            addCriterion("carrier_phone <=", value, "carrierPhone");
            return (Criteria) this;
        }

        public Criteria andCarrierPhoneLike(String value) {
            addCriterion("carrier_phone like", value, "carrierPhone");
            return (Criteria) this;
        }

        public Criteria andCarrierPhoneNotLike(String value) {
            addCriterion("carrier_phone not like", value, "carrierPhone");
            return (Criteria) this;
        }

        public Criteria andCarrierPhoneIn(List<String> values) {
            addCriterion("carrier_phone in", values, "carrierPhone");
            return (Criteria) this;
        }

        public Criteria andCarrierPhoneNotIn(List<String> values) {
            addCriterion("carrier_phone not in", values, "carrierPhone");
            return (Criteria) this;
        }

        public Criteria andCarrierPhoneBetween(String value1, String value2) {
            addCriterion("carrier_phone between", value1, value2, "carrierPhone");
            return (Criteria) this;
        }

        public Criteria andCarrierPhoneNotBetween(String value1, String value2) {
            addCriterion("carrier_phone not between", value1, value2, "carrierPhone");
            return (Criteria) this;
        }

        public Criteria andReleaseEndTimeIsNull() {
            addCriterion("release_end_time is null");
            return (Criteria) this;
        }

        public Criteria andReleaseEndTimeIsNotNull() {
            addCriterion("release_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseEndTimeEqualTo(Date value) {
            addCriterion("release_end_time =", value, "releaseEndTime");
            return (Criteria) this;
        }

        public Criteria andReleaseEndTimeNotEqualTo(Date value) {
            addCriterion("release_end_time <>", value, "releaseEndTime");
            return (Criteria) this;
        }

        public Criteria andReleaseEndTimeGreaterThan(Date value) {
            addCriterion("release_end_time >", value, "releaseEndTime");
            return (Criteria) this;
        }

        public Criteria andReleaseEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("release_end_time >=", value, "releaseEndTime");
            return (Criteria) this;
        }

        public Criteria andReleaseEndTimeLessThan(Date value) {
            addCriterion("release_end_time <", value, "releaseEndTime");
            return (Criteria) this;
        }

        public Criteria andReleaseEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("release_end_time <=", value, "releaseEndTime");
            return (Criteria) this;
        }

        public Criteria andReleaseEndTimeIn(List<Date> values) {
            addCriterion("release_end_time in", values, "releaseEndTime");
            return (Criteria) this;
        }

        public Criteria andReleaseEndTimeNotIn(List<Date> values) {
            addCriterion("release_end_time not in", values, "releaseEndTime");
            return (Criteria) this;
        }

        public Criteria andReleaseEndTimeBetween(Date value1, Date value2) {
            addCriterion("release_end_time between", value1, value2, "releaseEndTime");
            return (Criteria) this;
        }

        public Criteria andReleaseEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("release_end_time not between", value1, value2, "releaseEndTime");
            return (Criteria) this;
        }

        public Criteria andReleaseStartTimeIsNull() {
            addCriterion("release_start_time is null");
            return (Criteria) this;
        }

        public Criteria andReleaseStartTimeIsNotNull() {
            addCriterion("release_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseStartTimeEqualTo(Date value) {
            addCriterion("release_start_time =", value, "releaseStartTime");
            return (Criteria) this;
        }

        public Criteria andReleaseStartTimeNotEqualTo(Date value) {
            addCriterion("release_start_time <>", value, "releaseStartTime");
            return (Criteria) this;
        }

        public Criteria andReleaseStartTimeGreaterThan(Date value) {
            addCriterion("release_start_time >", value, "releaseStartTime");
            return (Criteria) this;
        }

        public Criteria andReleaseStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("release_start_time >=", value, "releaseStartTime");
            return (Criteria) this;
        }

        public Criteria andReleaseStartTimeLessThan(Date value) {
            addCriterion("release_start_time <", value, "releaseStartTime");
            return (Criteria) this;
        }

        public Criteria andReleaseStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("release_start_time <=", value, "releaseStartTime");
            return (Criteria) this;
        }

        public Criteria andReleaseStartTimeIn(List<Date> values) {
            addCriterion("release_start_time in", values, "releaseStartTime");
            return (Criteria) this;
        }

        public Criteria andReleaseStartTimeNotIn(List<Date> values) {
            addCriterion("release_start_time not in", values, "releaseStartTime");
            return (Criteria) this;
        }

        public Criteria andReleaseStartTimeBetween(Date value1, Date value2) {
            addCriterion("release_start_time between", value1, value2, "releaseStartTime");
            return (Criteria) this;
        }

        public Criteria andReleaseStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("release_start_time not between", value1, value2, "releaseStartTime");
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

        public Criteria andAuditUidIsNull() {
            addCriterion("audit_uid is null");
            return (Criteria) this;
        }

        public Criteria andAuditUidIsNotNull() {
            addCriterion("audit_uid is not null");
            return (Criteria) this;
        }

        public Criteria andAuditUidEqualTo(Long value) {
            addCriterion("audit_uid =", value, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditUidNotEqualTo(Long value) {
            addCriterion("audit_uid <>", value, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditUidGreaterThan(Long value) {
            addCriterion("audit_uid >", value, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditUidGreaterThanOrEqualTo(Long value) {
            addCriterion("audit_uid >=", value, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditUidLessThan(Long value) {
            addCriterion("audit_uid <", value, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditUidLessThanOrEqualTo(Long value) {
            addCriterion("audit_uid <=", value, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditUidIn(List<Long> values) {
            addCriterion("audit_uid in", values, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditUidNotIn(List<Long> values) {
            addCriterion("audit_uid not in", values, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditUidBetween(Long value1, Long value2) {
            addCriterion("audit_uid between", value1, value2, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditUidNotBetween(Long value1, Long value2) {
            addCriterion("audit_uid not between", value1, value2, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditContentIsNull() {
            addCriterion("audit_content is null");
            return (Criteria) this;
        }

        public Criteria andAuditContentIsNotNull() {
            addCriterion("audit_content is not null");
            return (Criteria) this;
        }

        public Criteria andAuditContentEqualTo(String value) {
            addCriterion("audit_content =", value, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentNotEqualTo(String value) {
            addCriterion("audit_content <>", value, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentGreaterThan(String value) {
            addCriterion("audit_content >", value, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentGreaterThanOrEqualTo(String value) {
            addCriterion("audit_content >=", value, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentLessThan(String value) {
            addCriterion("audit_content <", value, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentLessThanOrEqualTo(String value) {
            addCriterion("audit_content <=", value, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentLike(String value) {
            addCriterion("audit_content like", value, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentNotLike(String value) {
            addCriterion("audit_content not like", value, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentIn(List<String> values) {
            addCriterion("audit_content in", values, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentNotIn(List<String> values) {
            addCriterion("audit_content not in", values, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentBetween(String value1, String value2) {
            addCriterion("audit_content between", value1, value2, "auditContent");
            return (Criteria) this;
        }

        public Criteria andAuditContentNotBetween(String value1, String value2) {
            addCriterion("audit_content not between", value1, value2, "auditContent");
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

        public Criteria andExePhoneIsNull() {
            addCriterion("exe_phone is null");
            return (Criteria) this;
        }

        public Criteria andExePhoneIsNotNull() {
            addCriterion("exe_phone is not null");
            return (Criteria) this;
        }

        public Criteria andExePhoneEqualTo(String value) {
            addCriterion("exe_phone =", value, "exePhone");
            return (Criteria) this;
        }

        public Criteria andExePhoneNotEqualTo(String value) {
            addCriterion("exe_phone <>", value, "exePhone");
            return (Criteria) this;
        }

        public Criteria andExePhoneGreaterThan(String value) {
            addCriterion("exe_phone >", value, "exePhone");
            return (Criteria) this;
        }

        public Criteria andExePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("exe_phone >=", value, "exePhone");
            return (Criteria) this;
        }

        public Criteria andExePhoneLessThan(String value) {
            addCriterion("exe_phone <", value, "exePhone");
            return (Criteria) this;
        }

        public Criteria andExePhoneLessThanOrEqualTo(String value) {
            addCriterion("exe_phone <=", value, "exePhone");
            return (Criteria) this;
        }

        public Criteria andExePhoneLike(String value) {
            addCriterion("exe_phone like", value, "exePhone");
            return (Criteria) this;
        }

        public Criteria andExePhoneNotLike(String value) {
            addCriterion("exe_phone not like", value, "exePhone");
            return (Criteria) this;
        }

        public Criteria andExePhoneIn(List<String> values) {
            addCriterion("exe_phone in", values, "exePhone");
            return (Criteria) this;
        }

        public Criteria andExePhoneNotIn(List<String> values) {
            addCriterion("exe_phone not in", values, "exePhone");
            return (Criteria) this;
        }

        public Criteria andExePhoneBetween(String value1, String value2) {
            addCriterion("exe_phone between", value1, value2, "exePhone");
            return (Criteria) this;
        }

        public Criteria andExePhoneNotBetween(String value1, String value2) {
            addCriterion("exe_phone not between", value1, value2, "exePhone");
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