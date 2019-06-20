package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VisitVisitorInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VisitVisitorInfoExample() {
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

        public Criteria andAidIsNull() {
            addCriterion("aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Long value) {
            addCriterion("aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Long value) {
            addCriterion("aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Long value) {
            addCriterion("aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Long value) {
            addCriterion("aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Long value) {
            addCriterion("aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Long value) {
            addCriterion("aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Long> values) {
            addCriterion("aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Long> values) {
            addCriterion("aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Long value1, Long value2) {
            addCriterion("aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Long value1, Long value2) {
            addCriterion("aid not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAppointmentIsNull() {
            addCriterion("appointment is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentIsNotNull() {
            addCriterion("appointment is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentEqualTo(String value) {
            addCriterion("appointment =", value, "appointment");
            return (Criteria) this;
        }

        public Criteria andAppointmentNotEqualTo(String value) {
            addCriterion("appointment <>", value, "appointment");
            return (Criteria) this;
        }

        public Criteria andAppointmentGreaterThan(String value) {
            addCriterion("appointment >", value, "appointment");
            return (Criteria) this;
        }

        public Criteria andAppointmentGreaterThanOrEqualTo(String value) {
            addCriterion("appointment >=", value, "appointment");
            return (Criteria) this;
        }

        public Criteria andAppointmentLessThan(String value) {
            addCriterion("appointment <", value, "appointment");
            return (Criteria) this;
        }

        public Criteria andAppointmentLessThanOrEqualTo(String value) {
            addCriterion("appointment <=", value, "appointment");
            return (Criteria) this;
        }

        public Criteria andAppointmentLike(String value) {
            addCriterion("appointment like", value, "appointment");
            return (Criteria) this;
        }

        public Criteria andAppointmentNotLike(String value) {
            addCriterion("appointment not like", value, "appointment");
            return (Criteria) this;
        }

        public Criteria andAppointmentIn(List<String> values) {
            addCriterion("appointment in", values, "appointment");
            return (Criteria) this;
        }

        public Criteria andAppointmentNotIn(List<String> values) {
            addCriterion("appointment not in", values, "appointment");
            return (Criteria) this;
        }

        public Criteria andAppointmentBetween(String value1, String value2) {
            addCriterion("appointment between", value1, value2, "appointment");
            return (Criteria) this;
        }

        public Criteria andAppointmentNotBetween(String value1, String value2) {
            addCriterion("appointment not between", value1, value2, "appointment");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneIsNull() {
            addCriterion("appointment_phone is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneIsNotNull() {
            addCriterion("appointment_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneEqualTo(String value) {
            addCriterion("appointment_phone =", value, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneNotEqualTo(String value) {
            addCriterion("appointment_phone <>", value, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneGreaterThan(String value) {
            addCriterion("appointment_phone >", value, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("appointment_phone >=", value, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneLessThan(String value) {
            addCriterion("appointment_phone <", value, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneLessThanOrEqualTo(String value) {
            addCriterion("appointment_phone <=", value, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneLike(String value) {
            addCriterion("appointment_phone like", value, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneNotLike(String value) {
            addCriterion("appointment_phone not like", value, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneIn(List<String> values) {
            addCriterion("appointment_phone in", values, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneNotIn(List<String> values) {
            addCriterion("appointment_phone not in", values, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneBetween(String value1, String value2) {
            addCriterion("appointment_phone between", value1, value2, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneNotBetween(String value1, String value2) {
            addCriterion("appointment_phone not between", value1, value2, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentUidIsNull() {
            addCriterion("appointment_uid is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentUidIsNotNull() {
            addCriterion("appointment_uid is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentUidEqualTo(Long value) {
            addCriterion("appointment_uid =", value, "appointmentUid");
            return (Criteria) this;
        }

        public Criteria andAppointmentUidNotEqualTo(Long value) {
            addCriterion("appointment_uid <>", value, "appointmentUid");
            return (Criteria) this;
        }

        public Criteria andAppointmentUidGreaterThan(Long value) {
            addCriterion("appointment_uid >", value, "appointmentUid");
            return (Criteria) this;
        }

        public Criteria andAppointmentUidGreaterThanOrEqualTo(Long value) {
            addCriterion("appointment_uid >=", value, "appointmentUid");
            return (Criteria) this;
        }

        public Criteria andAppointmentUidLessThan(Long value) {
            addCriterion("appointment_uid <", value, "appointmentUid");
            return (Criteria) this;
        }

        public Criteria andAppointmentUidLessThanOrEqualTo(Long value) {
            addCriterion("appointment_uid <=", value, "appointmentUid");
            return (Criteria) this;
        }

        public Criteria andAppointmentUidIn(List<Long> values) {
            addCriterion("appointment_uid in", values, "appointmentUid");
            return (Criteria) this;
        }

        public Criteria andAppointmentUidNotIn(List<Long> values) {
            addCriterion("appointment_uid not in", values, "appointmentUid");
            return (Criteria) this;
        }

        public Criteria andAppointmentUidBetween(Long value1, Long value2) {
            addCriterion("appointment_uid between", value1, value2, "appointmentUid");
            return (Criteria) this;
        }

        public Criteria andAppointmentUidNotBetween(Long value1, Long value2) {
            addCriterion("appointment_uid not between", value1, value2, "appointmentUid");
            return (Criteria) this;
        }

        public Criteria andAppointmentReadStatusIsNull() {
            addCriterion("appointment_read_status is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentReadStatusIsNotNull() {
            addCriterion("appointment_read_status is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentReadStatusEqualTo(Integer value) {
            addCriterion("appointment_read_status =", value, "appointmentReadStatus");
            return (Criteria) this;
        }

        public Criteria andAppointmentReadStatusNotEqualTo(Integer value) {
            addCriterion("appointment_read_status <>", value, "appointmentReadStatus");
            return (Criteria) this;
        }

        public Criteria andAppointmentReadStatusGreaterThan(Integer value) {
            addCriterion("appointment_read_status >", value, "appointmentReadStatus");
            return (Criteria) this;
        }

        public Criteria andAppointmentReadStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("appointment_read_status >=", value, "appointmentReadStatus");
            return (Criteria) this;
        }

        public Criteria andAppointmentReadStatusLessThan(Integer value) {
            addCriterion("appointment_read_status <", value, "appointmentReadStatus");
            return (Criteria) this;
        }

        public Criteria andAppointmentReadStatusLessThanOrEqualTo(Integer value) {
            addCriterion("appointment_read_status <=", value, "appointmentReadStatus");
            return (Criteria) this;
        }

        public Criteria andAppointmentReadStatusIn(List<Integer> values) {
            addCriterion("appointment_read_status in", values, "appointmentReadStatus");
            return (Criteria) this;
        }

        public Criteria andAppointmentReadStatusNotIn(List<Integer> values) {
            addCriterion("appointment_read_status not in", values, "appointmentReadStatus");
            return (Criteria) this;
        }

        public Criteria andAppointmentReadStatusBetween(Integer value1, Integer value2) {
            addCriterion("appointment_read_status between", value1, value2, "appointmentReadStatus");
            return (Criteria) this;
        }

        public Criteria andAppointmentReadStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("appointment_read_status not between", value1, value2, "appointmentReadStatus");
            return (Criteria) this;
        }

        public Criteria andIsMasterIsNull() {
            addCriterion("is_master is null");
            return (Criteria) this;
        }

        public Criteria andIsMasterIsNotNull() {
            addCriterion("is_master is not null");
            return (Criteria) this;
        }

        public Criteria andIsMasterEqualTo(Integer value) {
            addCriterion("is_master =", value, "isMaster");
            return (Criteria) this;
        }

        public Criteria andIsMasterNotEqualTo(Integer value) {
            addCriterion("is_master <>", value, "isMaster");
            return (Criteria) this;
        }

        public Criteria andIsMasterGreaterThan(Integer value) {
            addCriterion("is_master >", value, "isMaster");
            return (Criteria) this;
        }

        public Criteria andIsMasterGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_master >=", value, "isMaster");
            return (Criteria) this;
        }

        public Criteria andIsMasterLessThan(Integer value) {
            addCriterion("is_master <", value, "isMaster");
            return (Criteria) this;
        }

        public Criteria andIsMasterLessThanOrEqualTo(Integer value) {
            addCriterion("is_master <=", value, "isMaster");
            return (Criteria) this;
        }

        public Criteria andIsMasterIn(List<Integer> values) {
            addCriterion("is_master in", values, "isMaster");
            return (Criteria) this;
        }

        public Criteria andIsMasterNotIn(List<Integer> values) {
            addCriterion("is_master not in", values, "isMaster");
            return (Criteria) this;
        }

        public Criteria andIsMasterBetween(Integer value1, Integer value2) {
            addCriterion("is_master between", value1, value2, "isMaster");
            return (Criteria) this;
        }

        public Criteria andIsMasterNotBetween(Integer value1, Integer value2) {
            addCriterion("is_master not between", value1, value2, "isMaster");
            return (Criteria) this;
        }

        public Criteria andQrcodeCreateTimeIsNull() {
            addCriterion("qrcode_create_time is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeCreateTimeIsNotNull() {
            addCriterion("qrcode_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeCreateTimeEqualTo(Date value) {
            addCriterion("qrcode_create_time =", value, "qrcodeCreateTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeCreateTimeNotEqualTo(Date value) {
            addCriterion("qrcode_create_time <>", value, "qrcodeCreateTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeCreateTimeGreaterThan(Date value) {
            addCriterion("qrcode_create_time >", value, "qrcodeCreateTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("qrcode_create_time >=", value, "qrcodeCreateTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeCreateTimeLessThan(Date value) {
            addCriterion("qrcode_create_time <", value, "qrcodeCreateTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("qrcode_create_time <=", value, "qrcodeCreateTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeCreateTimeIn(List<Date> values) {
            addCriterion("qrcode_create_time in", values, "qrcodeCreateTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeCreateTimeNotIn(List<Date> values) {
            addCriterion("qrcode_create_time not in", values, "qrcodeCreateTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeCreateTimeBetween(Date value1, Date value2) {
            addCriterion("qrcode_create_time between", value1, value2, "qrcodeCreateTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("qrcode_create_time not between", value1, value2, "qrcodeCreateTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeExpireTimeIsNull() {
            addCriterion("qrcode_expire_time is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeExpireTimeIsNotNull() {
            addCriterion("qrcode_expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeExpireTimeEqualTo(Date value) {
            addCriterion("qrcode_expire_time =", value, "qrcodeExpireTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeExpireTimeNotEqualTo(Date value) {
            addCriterion("qrcode_expire_time <>", value, "qrcodeExpireTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeExpireTimeGreaterThan(Date value) {
            addCriterion("qrcode_expire_time >", value, "qrcodeExpireTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("qrcode_expire_time >=", value, "qrcodeExpireTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeExpireTimeLessThan(Date value) {
            addCriterion("qrcode_expire_time <", value, "qrcodeExpireTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeExpireTimeLessThanOrEqualTo(Date value) {
            addCriterion("qrcode_expire_time <=", value, "qrcodeExpireTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeExpireTimeIn(List<Date> values) {
            addCriterion("qrcode_expire_time in", values, "qrcodeExpireTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeExpireTimeNotIn(List<Date> values) {
            addCriterion("qrcode_expire_time not in", values, "qrcodeExpireTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeExpireTimeBetween(Date value1, Date value2) {
            addCriterion("qrcode_expire_time between", value1, value2, "qrcodeExpireTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeExpireTimeNotBetween(Date value1, Date value2) {
            addCriterion("qrcode_expire_time not between", value1, value2, "qrcodeExpireTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeLastUseTimeIsNull() {
            addCriterion("qrcode_last_use_time is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeLastUseTimeIsNotNull() {
            addCriterion("qrcode_last_use_time is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeLastUseTimeEqualTo(Date value) {
            addCriterion("qrcode_last_use_time =", value, "qrcodeLastUseTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeLastUseTimeNotEqualTo(Date value) {
            addCriterion("qrcode_last_use_time <>", value, "qrcodeLastUseTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeLastUseTimeGreaterThan(Date value) {
            addCriterion("qrcode_last_use_time >", value, "qrcodeLastUseTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeLastUseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("qrcode_last_use_time >=", value, "qrcodeLastUseTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeLastUseTimeLessThan(Date value) {
            addCriterion("qrcode_last_use_time <", value, "qrcodeLastUseTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeLastUseTimeLessThanOrEqualTo(Date value) {
            addCriterion("qrcode_last_use_time <=", value, "qrcodeLastUseTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeLastUseTimeIn(List<Date> values) {
            addCriterion("qrcode_last_use_time in", values, "qrcodeLastUseTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeLastUseTimeNotIn(List<Date> values) {
            addCriterion("qrcode_last_use_time not in", values, "qrcodeLastUseTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeLastUseTimeBetween(Date value1, Date value2) {
            addCriterion("qrcode_last_use_time between", value1, value2, "qrcodeLastUseTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeLastUseTimeNotBetween(Date value1, Date value2) {
            addCriterion("qrcode_last_use_time not between", value1, value2, "qrcodeLastUseTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryUseTimesIsNull() {
            addCriterion("qrcode_entry_use_times is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryUseTimesIsNotNull() {
            addCriterion("qrcode_entry_use_times is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryUseTimesEqualTo(Integer value) {
            addCriterion("qrcode_entry_use_times =", value, "qrcodeEntryUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryUseTimesNotEqualTo(Integer value) {
            addCriterion("qrcode_entry_use_times <>", value, "qrcodeEntryUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryUseTimesGreaterThan(Integer value) {
            addCriterion("qrcode_entry_use_times >", value, "qrcodeEntryUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryUseTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("qrcode_entry_use_times >=", value, "qrcodeEntryUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryUseTimesLessThan(Integer value) {
            addCriterion("qrcode_entry_use_times <", value, "qrcodeEntryUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryUseTimesLessThanOrEqualTo(Integer value) {
            addCriterion("qrcode_entry_use_times <=", value, "qrcodeEntryUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryUseTimesIn(List<Integer> values) {
            addCriterion("qrcode_entry_use_times in", values, "qrcodeEntryUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryUseTimesNotIn(List<Integer> values) {
            addCriterion("qrcode_entry_use_times not in", values, "qrcodeEntryUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryUseTimesBetween(Integer value1, Integer value2) {
            addCriterion("qrcode_entry_use_times between", value1, value2, "qrcodeEntryUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryUseTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("qrcode_entry_use_times not between", value1, value2, "qrcodeEntryUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitUseTimesIsNull() {
            addCriterion("qrcode_exit_use_times is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitUseTimesIsNotNull() {
            addCriterion("qrcode_exit_use_times is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitUseTimesEqualTo(Integer value) {
            addCriterion("qrcode_exit_use_times =", value, "qrcodeExitUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitUseTimesNotEqualTo(Integer value) {
            addCriterion("qrcode_exit_use_times <>", value, "qrcodeExitUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitUseTimesGreaterThan(Integer value) {
            addCriterion("qrcode_exit_use_times >", value, "qrcodeExitUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitUseTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("qrcode_exit_use_times >=", value, "qrcodeExitUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitUseTimesLessThan(Integer value) {
            addCriterion("qrcode_exit_use_times <", value, "qrcodeExitUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitUseTimesLessThanOrEqualTo(Integer value) {
            addCriterion("qrcode_exit_use_times <=", value, "qrcodeExitUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitUseTimesIn(List<Integer> values) {
            addCriterion("qrcode_exit_use_times in", values, "qrcodeExitUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitUseTimesNotIn(List<Integer> values) {
            addCriterion("qrcode_exit_use_times not in", values, "qrcodeExitUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitUseTimesBetween(Integer value1, Integer value2) {
            addCriterion("qrcode_exit_use_times between", value1, value2, "qrcodeExitUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitUseTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("qrcode_exit_use_times not between", value1, value2, "qrcodeExitUseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryElapseTimesIsNull() {
            addCriterion("qrcode_entry_elapse_times is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryElapseTimesIsNotNull() {
            addCriterion("qrcode_entry_elapse_times is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryElapseTimesEqualTo(Integer value) {
            addCriterion("qrcode_entry_elapse_times =", value, "qrcodeEntryElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryElapseTimesNotEqualTo(Integer value) {
            addCriterion("qrcode_entry_elapse_times <>", value, "qrcodeEntryElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryElapseTimesGreaterThan(Integer value) {
            addCriterion("qrcode_entry_elapse_times >", value, "qrcodeEntryElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryElapseTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("qrcode_entry_elapse_times >=", value, "qrcodeEntryElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryElapseTimesLessThan(Integer value) {
            addCriterion("qrcode_entry_elapse_times <", value, "qrcodeEntryElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryElapseTimesLessThanOrEqualTo(Integer value) {
            addCriterion("qrcode_entry_elapse_times <=", value, "qrcodeEntryElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryElapseTimesIn(List<Integer> values) {
            addCriterion("qrcode_entry_elapse_times in", values, "qrcodeEntryElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryElapseTimesNotIn(List<Integer> values) {
            addCriterion("qrcode_entry_elapse_times not in", values, "qrcodeEntryElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryElapseTimesBetween(Integer value1, Integer value2) {
            addCriterion("qrcode_entry_elapse_times between", value1, value2, "qrcodeEntryElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeEntryElapseTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("qrcode_entry_elapse_times not between", value1, value2, "qrcodeEntryElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitElapseTimesIsNull() {
            addCriterion("qrcode_exit_elapse_times is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitElapseTimesIsNotNull() {
            addCriterion("qrcode_exit_elapse_times is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitElapseTimesEqualTo(Integer value) {
            addCriterion("qrcode_exit_elapse_times =", value, "qrcodeExitElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitElapseTimesNotEqualTo(Integer value) {
            addCriterion("qrcode_exit_elapse_times <>", value, "qrcodeExitElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitElapseTimesGreaterThan(Integer value) {
            addCriterion("qrcode_exit_elapse_times >", value, "qrcodeExitElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitElapseTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("qrcode_exit_elapse_times >=", value, "qrcodeExitElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitElapseTimesLessThan(Integer value) {
            addCriterion("qrcode_exit_elapse_times <", value, "qrcodeExitElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitElapseTimesLessThanOrEqualTo(Integer value) {
            addCriterion("qrcode_exit_elapse_times <=", value, "qrcodeExitElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitElapseTimesIn(List<Integer> values) {
            addCriterion("qrcode_exit_elapse_times in", values, "qrcodeExitElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitElapseTimesNotIn(List<Integer> values) {
            addCriterion("qrcode_exit_elapse_times not in", values, "qrcodeExitElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitElapseTimesBetween(Integer value1, Integer value2) {
            addCriterion("qrcode_exit_elapse_times between", value1, value2, "qrcodeExitElapseTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeExitElapseTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("qrcode_exit_elapse_times not between", value1, value2, "qrcodeExitElapseTimes");
            return (Criteria) this;
        }

        public Criteria andApplyRenewTimesIsNull() {
            addCriterion("apply_renew_times is null");
            return (Criteria) this;
        }

        public Criteria andApplyRenewTimesIsNotNull() {
            addCriterion("apply_renew_times is not null");
            return (Criteria) this;
        }

        public Criteria andApplyRenewTimesEqualTo(Integer value) {
            addCriterion("apply_renew_times =", value, "applyRenewTimes");
            return (Criteria) this;
        }

        public Criteria andApplyRenewTimesNotEqualTo(Integer value) {
            addCriterion("apply_renew_times <>", value, "applyRenewTimes");
            return (Criteria) this;
        }

        public Criteria andApplyRenewTimesGreaterThan(Integer value) {
            addCriterion("apply_renew_times >", value, "applyRenewTimes");
            return (Criteria) this;
        }

        public Criteria andApplyRenewTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_renew_times >=", value, "applyRenewTimes");
            return (Criteria) this;
        }

        public Criteria andApplyRenewTimesLessThan(Integer value) {
            addCriterion("apply_renew_times <", value, "applyRenewTimes");
            return (Criteria) this;
        }

        public Criteria andApplyRenewTimesLessThanOrEqualTo(Integer value) {
            addCriterion("apply_renew_times <=", value, "applyRenewTimes");
            return (Criteria) this;
        }

        public Criteria andApplyRenewTimesIn(List<Integer> values) {
            addCriterion("apply_renew_times in", values, "applyRenewTimes");
            return (Criteria) this;
        }

        public Criteria andApplyRenewTimesNotIn(List<Integer> values) {
            addCriterion("apply_renew_times not in", values, "applyRenewTimes");
            return (Criteria) this;
        }

        public Criteria andApplyRenewTimesBetween(Integer value1, Integer value2) {
            addCriterion("apply_renew_times between", value1, value2, "applyRenewTimes");
            return (Criteria) this;
        }

        public Criteria andApplyRenewTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_renew_times not between", value1, value2, "applyRenewTimes");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenIsNull() {
            addCriterion("qrcode_token is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenIsNotNull() {
            addCriterion("qrcode_token is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenEqualTo(String value) {
            addCriterion("qrcode_token =", value, "qrcodeToken");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenNotEqualTo(String value) {
            addCriterion("qrcode_token <>", value, "qrcodeToken");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenGreaterThan(String value) {
            addCriterion("qrcode_token >", value, "qrcodeToken");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenGreaterThanOrEqualTo(String value) {
            addCriterion("qrcode_token >=", value, "qrcodeToken");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenLessThan(String value) {
            addCriterion("qrcode_token <", value, "qrcodeToken");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenLessThanOrEqualTo(String value) {
            addCriterion("qrcode_token <=", value, "qrcodeToken");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenLike(String value) {
            addCriterion("qrcode_token like", value, "qrcodeToken");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenNotLike(String value) {
            addCriterion("qrcode_token not like", value, "qrcodeToken");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenIn(List<String> values) {
            addCriterion("qrcode_token in", values, "qrcodeToken");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenNotIn(List<String> values) {
            addCriterion("qrcode_token not in", values, "qrcodeToken");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenBetween(String value1, String value2) {
            addCriterion("qrcode_token between", value1, value2, "qrcodeToken");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenNotBetween(String value1, String value2) {
            addCriterion("qrcode_token not between", value1, value2, "qrcodeToken");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenTimeIsNull() {
            addCriterion("qrcode_token_time is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenTimeIsNotNull() {
            addCriterion("qrcode_token_time is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenTimeEqualTo(Date value) {
            addCriterion("qrcode_token_time =", value, "qrcodeTokenTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenTimeNotEqualTo(Date value) {
            addCriterion("qrcode_token_time <>", value, "qrcodeTokenTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenTimeGreaterThan(Date value) {
            addCriterion("qrcode_token_time >", value, "qrcodeTokenTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("qrcode_token_time >=", value, "qrcodeTokenTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenTimeLessThan(Date value) {
            addCriterion("qrcode_token_time <", value, "qrcodeTokenTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenTimeLessThanOrEqualTo(Date value) {
            addCriterion("qrcode_token_time <=", value, "qrcodeTokenTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenTimeIn(List<Date> values) {
            addCriterion("qrcode_token_time in", values, "qrcodeTokenTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenTimeNotIn(List<Date> values) {
            addCriterion("qrcode_token_time not in", values, "qrcodeTokenTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenTimeBetween(Date value1, Date value2) {
            addCriterion("qrcode_token_time between", value1, value2, "qrcodeTokenTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenTimeNotBetween(Date value1, Date value2) {
            addCriterion("qrcode_token_time not between", value1, value2, "qrcodeTokenTime");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenIpIsNull() {
            addCriterion("qrcode_token_ip is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenIpIsNotNull() {
            addCriterion("qrcode_token_ip is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenIpEqualTo(String value) {
            addCriterion("qrcode_token_ip =", value, "qrcodeTokenIp");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenIpNotEqualTo(String value) {
            addCriterion("qrcode_token_ip <>", value, "qrcodeTokenIp");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenIpGreaterThan(String value) {
            addCriterion("qrcode_token_ip >", value, "qrcodeTokenIp");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenIpGreaterThanOrEqualTo(String value) {
            addCriterion("qrcode_token_ip >=", value, "qrcodeTokenIp");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenIpLessThan(String value) {
            addCriterion("qrcode_token_ip <", value, "qrcodeTokenIp");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenIpLessThanOrEqualTo(String value) {
            addCriterion("qrcode_token_ip <=", value, "qrcodeTokenIp");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenIpLike(String value) {
            addCriterion("qrcode_token_ip like", value, "qrcodeTokenIp");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenIpNotLike(String value) {
            addCriterion("qrcode_token_ip not like", value, "qrcodeTokenIp");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenIpIn(List<String> values) {
            addCriterion("qrcode_token_ip in", values, "qrcodeTokenIp");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenIpNotIn(List<String> values) {
            addCriterion("qrcode_token_ip not in", values, "qrcodeTokenIp");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenIpBetween(String value1, String value2) {
            addCriterion("qrcode_token_ip between", value1, value2, "qrcodeTokenIp");
            return (Criteria) this;
        }

        public Criteria andQrcodeTokenIpNotBetween(String value1, String value2) {
            addCriterion("qrcode_token_ip not between", value1, value2, "qrcodeTokenIp");
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