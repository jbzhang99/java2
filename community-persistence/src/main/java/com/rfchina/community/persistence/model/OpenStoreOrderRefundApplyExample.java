package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenStoreOrderRefundApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenStoreOrderRefundApplyExample() {
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

        public Criteria andRefundSourceIsNull() {
            addCriterion("refund_source is null");
            return (Criteria) this;
        }

        public Criteria andRefundSourceIsNotNull() {
            addCriterion("refund_source is not null");
            return (Criteria) this;
        }

        public Criteria andRefundSourceEqualTo(String value) {
            addCriterion("refund_source =", value, "refundSource");
            return (Criteria) this;
        }

        public Criteria andRefundSourceNotEqualTo(String value) {
            addCriterion("refund_source <>", value, "refundSource");
            return (Criteria) this;
        }

        public Criteria andRefundSourceGreaterThan(String value) {
            addCriterion("refund_source >", value, "refundSource");
            return (Criteria) this;
        }

        public Criteria andRefundSourceGreaterThanOrEqualTo(String value) {
            addCriterion("refund_source >=", value, "refundSource");
            return (Criteria) this;
        }

        public Criteria andRefundSourceLessThan(String value) {
            addCriterion("refund_source <", value, "refundSource");
            return (Criteria) this;
        }

        public Criteria andRefundSourceLessThanOrEqualTo(String value) {
            addCriterion("refund_source <=", value, "refundSource");
            return (Criteria) this;
        }

        public Criteria andRefundSourceLike(String value) {
            addCriterion("refund_source like", value, "refundSource");
            return (Criteria) this;
        }

        public Criteria andRefundSourceNotLike(String value) {
            addCriterion("refund_source not like", value, "refundSource");
            return (Criteria) this;
        }

        public Criteria andRefundSourceIn(List<String> values) {
            addCriterion("refund_source in", values, "refundSource");
            return (Criteria) this;
        }

        public Criteria andRefundSourceNotIn(List<String> values) {
            addCriterion("refund_source not in", values, "refundSource");
            return (Criteria) this;
        }

        public Criteria andRefundSourceBetween(String value1, String value2) {
            addCriterion("refund_source between", value1, value2, "refundSource");
            return (Criteria) this;
        }

        public Criteria andRefundSourceNotBetween(String value1, String value2) {
            addCriterion("refund_source not between", value1, value2, "refundSource");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdIsNull() {
            addCriterion("store_order_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdIsNotNull() {
            addCriterion("store_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdEqualTo(Integer value) {
            addCriterion("store_order_id =", value, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdNotEqualTo(Integer value) {
            addCriterion("store_order_id <>", value, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdGreaterThan(Integer value) {
            addCriterion("store_order_id >", value, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_order_id >=", value, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdLessThan(Integer value) {
            addCriterion("store_order_id <", value, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_order_id <=", value, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdIn(List<Integer> values) {
            addCriterion("store_order_id in", values, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdNotIn(List<Integer> values) {
            addCriterion("store_order_id not in", values, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("store_order_id between", value1, value2, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_order_id not between", value1, value2, "storeOrderId");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNull() {
            addCriterion("bill_id is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(String value) {
            addCriterion("bill_id =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(String value) {
            addCriterion("bill_id <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(String value) {
            addCriterion("bill_id >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("bill_id >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(String value) {
            addCriterion("bill_id <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(String value) {
            addCriterion("bill_id <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLike(String value) {
            addCriterion("bill_id like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotLike(String value) {
            addCriterion("bill_id not like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<String> values) {
            addCriterion("bill_id in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<String> values) {
            addCriterion("bill_id not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(String value1, String value2) {
            addCriterion("bill_id between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(String value1, String value2) {
            addCriterion("bill_id not between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andReasonCertificateIsNull() {
            addCriterion("reason_certificate is null");
            return (Criteria) this;
        }

        public Criteria andReasonCertificateIsNotNull() {
            addCriterion("reason_certificate is not null");
            return (Criteria) this;
        }

        public Criteria andReasonCertificateEqualTo(String value) {
            addCriterion("reason_certificate =", value, "reasonCertificate");
            return (Criteria) this;
        }

        public Criteria andReasonCertificateNotEqualTo(String value) {
            addCriterion("reason_certificate <>", value, "reasonCertificate");
            return (Criteria) this;
        }

        public Criteria andReasonCertificateGreaterThan(String value) {
            addCriterion("reason_certificate >", value, "reasonCertificate");
            return (Criteria) this;
        }

        public Criteria andReasonCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("reason_certificate >=", value, "reasonCertificate");
            return (Criteria) this;
        }

        public Criteria andReasonCertificateLessThan(String value) {
            addCriterion("reason_certificate <", value, "reasonCertificate");
            return (Criteria) this;
        }

        public Criteria andReasonCertificateLessThanOrEqualTo(String value) {
            addCriterion("reason_certificate <=", value, "reasonCertificate");
            return (Criteria) this;
        }

        public Criteria andReasonCertificateLike(String value) {
            addCriterion("reason_certificate like", value, "reasonCertificate");
            return (Criteria) this;
        }

        public Criteria andReasonCertificateNotLike(String value) {
            addCriterion("reason_certificate not like", value, "reasonCertificate");
            return (Criteria) this;
        }

        public Criteria andReasonCertificateIn(List<String> values) {
            addCriterion("reason_certificate in", values, "reasonCertificate");
            return (Criteria) this;
        }

        public Criteria andReasonCertificateNotIn(List<String> values) {
            addCriterion("reason_certificate not in", values, "reasonCertificate");
            return (Criteria) this;
        }

        public Criteria andReasonCertificateBetween(String value1, String value2) {
            addCriterion("reason_certificate between", value1, value2, "reasonCertificate");
            return (Criteria) this;
        }

        public Criteria andReasonCertificateNotBetween(String value1, String value2) {
            addCriterion("reason_certificate not between", value1, value2, "reasonCertificate");
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

        public Criteria andAccountTypeIsNull() {
            addCriterion("account_type is null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNotNull() {
            addCriterion("account_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeEqualTo(Integer value) {
            addCriterion("account_type =", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotEqualTo(Integer value) {
            addCriterion("account_type <>", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThan(Integer value) {
            addCriterion("account_type >", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_type >=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThan(Integer value) {
            addCriterion("account_type <", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            addCriterion("account_type <=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIn(List<Integer> values) {
            addCriterion("account_type in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotIn(List<Integer> values) {
            addCriterion("account_type not in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            addCriterion("account_type between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("account_type not between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountNoIsNull() {
            addCriterion("account_no is null");
            return (Criteria) this;
        }

        public Criteria andAccountNoIsNotNull() {
            addCriterion("account_no is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNoEqualTo(String value) {
            addCriterion("account_no =", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotEqualTo(String value) {
            addCriterion("account_no <>", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoGreaterThan(String value) {
            addCriterion("account_no >", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("account_no >=", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLessThan(String value) {
            addCriterion("account_no <", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLessThanOrEqualTo(String value) {
            addCriterion("account_no <=", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLike(String value) {
            addCriterion("account_no like", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotLike(String value) {
            addCriterion("account_no not like", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoIn(List<String> values) {
            addCriterion("account_no in", values, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotIn(List<String> values) {
            addCriterion("account_no not in", values, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoBetween(String value1, String value2) {
            addCriterion("account_no between", value1, value2, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotBetween(String value1, String value2) {
            addCriterion("account_no not between", value1, value2, "accountNo");
            return (Criteria) this;
        }

        public Criteria andDepositBankIsNull() {
            addCriterion("deposit_bank is null");
            return (Criteria) this;
        }

        public Criteria andDepositBankIsNotNull() {
            addCriterion("deposit_bank is not null");
            return (Criteria) this;
        }

        public Criteria andDepositBankEqualTo(String value) {
            addCriterion("deposit_bank =", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotEqualTo(String value) {
            addCriterion("deposit_bank <>", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankGreaterThan(String value) {
            addCriterion("deposit_bank >", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankGreaterThanOrEqualTo(String value) {
            addCriterion("deposit_bank >=", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankLessThan(String value) {
            addCriterion("deposit_bank <", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankLessThanOrEqualTo(String value) {
            addCriterion("deposit_bank <=", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankLike(String value) {
            addCriterion("deposit_bank like", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotLike(String value) {
            addCriterion("deposit_bank not like", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankIn(List<String> values) {
            addCriterion("deposit_bank in", values, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotIn(List<String> values) {
            addCriterion("deposit_bank not in", values, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankBetween(String value1, String value2) {
            addCriterion("deposit_bank between", value1, value2, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotBetween(String value1, String value2) {
            addCriterion("deposit_bank not between", value1, value2, "depositBank");
            return (Criteria) this;
        }

        public Criteria andConfirmLetterIsNull() {
            addCriterion("confirm_letter is null");
            return (Criteria) this;
        }

        public Criteria andConfirmLetterIsNotNull() {
            addCriterion("confirm_letter is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmLetterEqualTo(String value) {
            addCriterion("confirm_letter =", value, "confirmLetter");
            return (Criteria) this;
        }

        public Criteria andConfirmLetterNotEqualTo(String value) {
            addCriterion("confirm_letter <>", value, "confirmLetter");
            return (Criteria) this;
        }

        public Criteria andConfirmLetterGreaterThan(String value) {
            addCriterion("confirm_letter >", value, "confirmLetter");
            return (Criteria) this;
        }

        public Criteria andConfirmLetterGreaterThanOrEqualTo(String value) {
            addCriterion("confirm_letter >=", value, "confirmLetter");
            return (Criteria) this;
        }

        public Criteria andConfirmLetterLessThan(String value) {
            addCriterion("confirm_letter <", value, "confirmLetter");
            return (Criteria) this;
        }

        public Criteria andConfirmLetterLessThanOrEqualTo(String value) {
            addCriterion("confirm_letter <=", value, "confirmLetter");
            return (Criteria) this;
        }

        public Criteria andConfirmLetterLike(String value) {
            addCriterion("confirm_letter like", value, "confirmLetter");
            return (Criteria) this;
        }

        public Criteria andConfirmLetterNotLike(String value) {
            addCriterion("confirm_letter not like", value, "confirmLetter");
            return (Criteria) this;
        }

        public Criteria andConfirmLetterIn(List<String> values) {
            addCriterion("confirm_letter in", values, "confirmLetter");
            return (Criteria) this;
        }

        public Criteria andConfirmLetterNotIn(List<String> values) {
            addCriterion("confirm_letter not in", values, "confirmLetter");
            return (Criteria) this;
        }

        public Criteria andConfirmLetterBetween(String value1, String value2) {
            addCriterion("confirm_letter between", value1, value2, "confirmLetter");
            return (Criteria) this;
        }

        public Criteria andConfirmLetterNotBetween(String value1, String value2) {
            addCriterion("confirm_letter not between", value1, value2, "confirmLetter");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontIsNull() {
            addCriterion("id_card_front is null");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontIsNotNull() {
            addCriterion("id_card_front is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontEqualTo(String value) {
            addCriterion("id_card_front =", value, "idCardFront");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontNotEqualTo(String value) {
            addCriterion("id_card_front <>", value, "idCardFront");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontGreaterThan(String value) {
            addCriterion("id_card_front >", value, "idCardFront");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_front >=", value, "idCardFront");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontLessThan(String value) {
            addCriterion("id_card_front <", value, "idCardFront");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontLessThanOrEqualTo(String value) {
            addCriterion("id_card_front <=", value, "idCardFront");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontLike(String value) {
            addCriterion("id_card_front like", value, "idCardFront");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontNotLike(String value) {
            addCriterion("id_card_front not like", value, "idCardFront");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontIn(List<String> values) {
            addCriterion("id_card_front in", values, "idCardFront");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontNotIn(List<String> values) {
            addCriterion("id_card_front not in", values, "idCardFront");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontBetween(String value1, String value2) {
            addCriterion("id_card_front between", value1, value2, "idCardFront");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontNotBetween(String value1, String value2) {
            addCriterion("id_card_front not between", value1, value2, "idCardFront");
            return (Criteria) this;
        }

        public Criteria andIdCardRearIsNull() {
            addCriterion("id_card_rear is null");
            return (Criteria) this;
        }

        public Criteria andIdCardRearIsNotNull() {
            addCriterion("id_card_rear is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardRearEqualTo(String value) {
            addCriterion("id_card_rear =", value, "idCardRear");
            return (Criteria) this;
        }

        public Criteria andIdCardRearNotEqualTo(String value) {
            addCriterion("id_card_rear <>", value, "idCardRear");
            return (Criteria) this;
        }

        public Criteria andIdCardRearGreaterThan(String value) {
            addCriterion("id_card_rear >", value, "idCardRear");
            return (Criteria) this;
        }

        public Criteria andIdCardRearGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_rear >=", value, "idCardRear");
            return (Criteria) this;
        }

        public Criteria andIdCardRearLessThan(String value) {
            addCriterion("id_card_rear <", value, "idCardRear");
            return (Criteria) this;
        }

        public Criteria andIdCardRearLessThanOrEqualTo(String value) {
            addCriterion("id_card_rear <=", value, "idCardRear");
            return (Criteria) this;
        }

        public Criteria andIdCardRearLike(String value) {
            addCriterion("id_card_rear like", value, "idCardRear");
            return (Criteria) this;
        }

        public Criteria andIdCardRearNotLike(String value) {
            addCriterion("id_card_rear not like", value, "idCardRear");
            return (Criteria) this;
        }

        public Criteria andIdCardRearIn(List<String> values) {
            addCriterion("id_card_rear in", values, "idCardRear");
            return (Criteria) this;
        }

        public Criteria andIdCardRearNotIn(List<String> values) {
            addCriterion("id_card_rear not in", values, "idCardRear");
            return (Criteria) this;
        }

        public Criteria andIdCardRearBetween(String value1, String value2) {
            addCriterion("id_card_rear between", value1, value2, "idCardRear");
            return (Criteria) this;
        }

        public Criteria andIdCardRearNotBetween(String value1, String value2) {
            addCriterion("id_card_rear not between", value1, value2, "idCardRear");
            return (Criteria) this;
        }

        public Criteria andAccountPicIsNull() {
            addCriterion("account_pic is null");
            return (Criteria) this;
        }

        public Criteria andAccountPicIsNotNull() {
            addCriterion("account_pic is not null");
            return (Criteria) this;
        }

        public Criteria andAccountPicEqualTo(String value) {
            addCriterion("account_pic =", value, "accountPic");
            return (Criteria) this;
        }

        public Criteria andAccountPicNotEqualTo(String value) {
            addCriterion("account_pic <>", value, "accountPic");
            return (Criteria) this;
        }

        public Criteria andAccountPicGreaterThan(String value) {
            addCriterion("account_pic >", value, "accountPic");
            return (Criteria) this;
        }

        public Criteria andAccountPicGreaterThanOrEqualTo(String value) {
            addCriterion("account_pic >=", value, "accountPic");
            return (Criteria) this;
        }

        public Criteria andAccountPicLessThan(String value) {
            addCriterion("account_pic <", value, "accountPic");
            return (Criteria) this;
        }

        public Criteria andAccountPicLessThanOrEqualTo(String value) {
            addCriterion("account_pic <=", value, "accountPic");
            return (Criteria) this;
        }

        public Criteria andAccountPicLike(String value) {
            addCriterion("account_pic like", value, "accountPic");
            return (Criteria) this;
        }

        public Criteria andAccountPicNotLike(String value) {
            addCriterion("account_pic not like", value, "accountPic");
            return (Criteria) this;
        }

        public Criteria andAccountPicIn(List<String> values) {
            addCriterion("account_pic in", values, "accountPic");
            return (Criteria) this;
        }

        public Criteria andAccountPicNotIn(List<String> values) {
            addCriterion("account_pic not in", values, "accountPic");
            return (Criteria) this;
        }

        public Criteria andAccountPicBetween(String value1, String value2) {
            addCriterion("account_pic between", value1, value2, "accountPic");
            return (Criteria) this;
        }

        public Criteria andAccountPicNotBetween(String value1, String value2) {
            addCriterion("account_pic not between", value1, value2, "accountPic");
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