package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenStoreGoodExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenStoreGoodExample() {
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
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

        public Criteria andShortDetailIsNull() {
            addCriterion("short_detail is null");
            return (Criteria) this;
        }

        public Criteria andShortDetailIsNotNull() {
            addCriterion("short_detail is not null");
            return (Criteria) this;
        }

        public Criteria andShortDetailEqualTo(String value) {
            addCriterion("short_detail =", value, "shortDetail");
            return (Criteria) this;
        }

        public Criteria andShortDetailNotEqualTo(String value) {
            addCriterion("short_detail <>", value, "shortDetail");
            return (Criteria) this;
        }

        public Criteria andShortDetailGreaterThan(String value) {
            addCriterion("short_detail >", value, "shortDetail");
            return (Criteria) this;
        }

        public Criteria andShortDetailGreaterThanOrEqualTo(String value) {
            addCriterion("short_detail >=", value, "shortDetail");
            return (Criteria) this;
        }

        public Criteria andShortDetailLessThan(String value) {
            addCriterion("short_detail <", value, "shortDetail");
            return (Criteria) this;
        }

        public Criteria andShortDetailLessThanOrEqualTo(String value) {
            addCriterion("short_detail <=", value, "shortDetail");
            return (Criteria) this;
        }

        public Criteria andShortDetailLike(String value) {
            addCriterion("short_detail like", value, "shortDetail");
            return (Criteria) this;
        }

        public Criteria andShortDetailNotLike(String value) {
            addCriterion("short_detail not like", value, "shortDetail");
            return (Criteria) this;
        }

        public Criteria andShortDetailIn(List<String> values) {
            addCriterion("short_detail in", values, "shortDetail");
            return (Criteria) this;
        }

        public Criteria andShortDetailNotIn(List<String> values) {
            addCriterion("short_detail not in", values, "shortDetail");
            return (Criteria) this;
        }

        public Criteria andShortDetailBetween(String value1, String value2) {
            addCriterion("short_detail between", value1, value2, "shortDetail");
            return (Criteria) this;
        }

        public Criteria andShortDetailNotBetween(String value1, String value2) {
            addCriterion("short_detail not between", value1, value2, "shortDetail");
            return (Criteria) this;
        }

        public Criteria andPrePriceIsNull() {
            addCriterion("pre_price is null");
            return (Criteria) this;
        }

        public Criteria andPrePriceIsNotNull() {
            addCriterion("pre_price is not null");
            return (Criteria) this;
        }

        public Criteria andPrePriceEqualTo(BigDecimal value) {
            addCriterion("pre_price =", value, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPrePriceNotEqualTo(BigDecimal value) {
            addCriterion("pre_price <>", value, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPrePriceGreaterThan(BigDecimal value) {
            addCriterion("pre_price >", value, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPrePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pre_price >=", value, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPrePriceLessThan(BigDecimal value) {
            addCriterion("pre_price <", value, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPrePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pre_price <=", value, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPrePriceIn(List<BigDecimal> values) {
            addCriterion("pre_price in", values, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPrePriceNotIn(List<BigDecimal> values) {
            addCriterion("pre_price not in", values, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPrePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pre_price between", value1, value2, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPrePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pre_price not between", value1, value2, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Integer value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Integer value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Integer value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Integer value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Integer value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Integer> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Integer> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Integer value1, Integer value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Integer value1, Integer value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andSaleAmountIsNull() {
            addCriterion("sale_amount is null");
            return (Criteria) this;
        }

        public Criteria andSaleAmountIsNotNull() {
            addCriterion("sale_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSaleAmountEqualTo(Integer value) {
            addCriterion("sale_amount =", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountNotEqualTo(Integer value) {
            addCriterion("sale_amount <>", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountGreaterThan(Integer value) {
            addCriterion("sale_amount >", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_amount >=", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountLessThan(Integer value) {
            addCriterion("sale_amount <", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountLessThanOrEqualTo(Integer value) {
            addCriterion("sale_amount <=", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountIn(List<Integer> values) {
            addCriterion("sale_amount in", values, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountNotIn(List<Integer> values) {
            addCriterion("sale_amount not in", values, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountBetween(Integer value1, Integer value2) {
            addCriterion("sale_amount between", value1, value2, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_amount not between", value1, value2, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andVirtualSaleAmountIsNull() {
            addCriterion("virtual_sale_amount is null");
            return (Criteria) this;
        }

        public Criteria andVirtualSaleAmountIsNotNull() {
            addCriterion("virtual_sale_amount is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualSaleAmountEqualTo(Integer value) {
            addCriterion("virtual_sale_amount =", value, "virtualSaleAmount");
            return (Criteria) this;
        }

        public Criteria andVirtualSaleAmountNotEqualTo(Integer value) {
            addCriterion("virtual_sale_amount <>", value, "virtualSaleAmount");
            return (Criteria) this;
        }

        public Criteria andVirtualSaleAmountGreaterThan(Integer value) {
            addCriterion("virtual_sale_amount >", value, "virtualSaleAmount");
            return (Criteria) this;
        }

        public Criteria andVirtualSaleAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("virtual_sale_amount >=", value, "virtualSaleAmount");
            return (Criteria) this;
        }

        public Criteria andVirtualSaleAmountLessThan(Integer value) {
            addCriterion("virtual_sale_amount <", value, "virtualSaleAmount");
            return (Criteria) this;
        }

        public Criteria andVirtualSaleAmountLessThanOrEqualTo(Integer value) {
            addCriterion("virtual_sale_amount <=", value, "virtualSaleAmount");
            return (Criteria) this;
        }

        public Criteria andVirtualSaleAmountIn(List<Integer> values) {
            addCriterion("virtual_sale_amount in", values, "virtualSaleAmount");
            return (Criteria) this;
        }

        public Criteria andVirtualSaleAmountNotIn(List<Integer> values) {
            addCriterion("virtual_sale_amount not in", values, "virtualSaleAmount");
            return (Criteria) this;
        }

        public Criteria andVirtualSaleAmountBetween(Integer value1, Integer value2) {
            addCriterion("virtual_sale_amount between", value1, value2, "virtualSaleAmount");
            return (Criteria) this;
        }

        public Criteria andVirtualSaleAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("virtual_sale_amount not between", value1, value2, "virtualSaleAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSaleAmountIsNull() {
            addCriterion("total_sale_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalSaleAmountIsNotNull() {
            addCriterion("total_sale_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSaleAmountEqualTo(Integer value) {
            addCriterion("total_sale_amount =", value, "totalSaleAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSaleAmountNotEqualTo(Integer value) {
            addCriterion("total_sale_amount <>", value, "totalSaleAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSaleAmountGreaterThan(Integer value) {
            addCriterion("total_sale_amount >", value, "totalSaleAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSaleAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_sale_amount >=", value, "totalSaleAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSaleAmountLessThan(Integer value) {
            addCriterion("total_sale_amount <", value, "totalSaleAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSaleAmountLessThanOrEqualTo(Integer value) {
            addCriterion("total_sale_amount <=", value, "totalSaleAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSaleAmountIn(List<Integer> values) {
            addCriterion("total_sale_amount in", values, "totalSaleAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSaleAmountNotIn(List<Integer> values) {
            addCriterion("total_sale_amount not in", values, "totalSaleAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSaleAmountBetween(Integer value1, Integer value2) {
            addCriterion("total_sale_amount between", value1, value2, "totalSaleAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSaleAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_sale_amount not between", value1, value2, "totalSaleAmount");
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

        public Criteria andVerifyTimesIsNull() {
            addCriterion("verify_times is null");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesIsNotNull() {
            addCriterion("verify_times is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesEqualTo(Integer value) {
            addCriterion("verify_times =", value, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesNotEqualTo(Integer value) {
            addCriterion("verify_times <>", value, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesGreaterThan(Integer value) {
            addCriterion("verify_times >", value, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("verify_times >=", value, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesLessThan(Integer value) {
            addCriterion("verify_times <", value, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesLessThanOrEqualTo(Integer value) {
            addCriterion("verify_times <=", value, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesIn(List<Integer> values) {
            addCriterion("verify_times in", values, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesNotIn(List<Integer> values) {
            addCriterion("verify_times not in", values, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesBetween(Integer value1, Integer value2) {
            addCriterion("verify_times between", value1, value2, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("verify_times not between", value1, value2, "verifyTimes");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeIsNull() {
            addCriterion("verify_start_time is null");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeIsNotNull() {
            addCriterion("verify_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeEqualTo(Date value) {
            addCriterion("verify_start_time =", value, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeNotEqualTo(Date value) {
            addCriterion("verify_start_time <>", value, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeGreaterThan(Date value) {
            addCriterion("verify_start_time >", value, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("verify_start_time >=", value, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeLessThan(Date value) {
            addCriterion("verify_start_time <", value, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("verify_start_time <=", value, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeIn(List<Date> values) {
            addCriterion("verify_start_time in", values, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeNotIn(List<Date> values) {
            addCriterion("verify_start_time not in", values, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeBetween(Date value1, Date value2) {
            addCriterion("verify_start_time between", value1, value2, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("verify_start_time not between", value1, value2, "verifyStartTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeIsNull() {
            addCriterion("verify_end_time is null");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeIsNotNull() {
            addCriterion("verify_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeEqualTo(Date value) {
            addCriterion("verify_end_time =", value, "verifyEndTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeNotEqualTo(Date value) {
            addCriterion("verify_end_time <>", value, "verifyEndTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeGreaterThan(Date value) {
            addCriterion("verify_end_time >", value, "verifyEndTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("verify_end_time >=", value, "verifyEndTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeLessThan(Date value) {
            addCriterion("verify_end_time <", value, "verifyEndTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("verify_end_time <=", value, "verifyEndTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeIn(List<Date> values) {
            addCriterion("verify_end_time in", values, "verifyEndTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeNotIn(List<Date> values) {
            addCriterion("verify_end_time not in", values, "verifyEndTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeBetween(Date value1, Date value2) {
            addCriterion("verify_end_time between", value1, value2, "verifyEndTime");
            return (Criteria) this;
        }

        public Criteria andVerifyEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("verify_end_time not between", value1, value2, "verifyEndTime");
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

        public Criteria andLikeSortingIsNull() {
            addCriterion("like_sorting is null");
            return (Criteria) this;
        }

        public Criteria andLikeSortingIsNotNull() {
            addCriterion("like_sorting is not null");
            return (Criteria) this;
        }

        public Criteria andLikeSortingEqualTo(Integer value) {
            addCriterion("like_sorting =", value, "likeSorting");
            return (Criteria) this;
        }

        public Criteria andLikeSortingNotEqualTo(Integer value) {
            addCriterion("like_sorting <>", value, "likeSorting");
            return (Criteria) this;
        }

        public Criteria andLikeSortingGreaterThan(Integer value) {
            addCriterion("like_sorting >", value, "likeSorting");
            return (Criteria) this;
        }

        public Criteria andLikeSortingGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_sorting >=", value, "likeSorting");
            return (Criteria) this;
        }

        public Criteria andLikeSortingLessThan(Integer value) {
            addCriterion("like_sorting <", value, "likeSorting");
            return (Criteria) this;
        }

        public Criteria andLikeSortingLessThanOrEqualTo(Integer value) {
            addCriterion("like_sorting <=", value, "likeSorting");
            return (Criteria) this;
        }

        public Criteria andLikeSortingIn(List<Integer> values) {
            addCriterion("like_sorting in", values, "likeSorting");
            return (Criteria) this;
        }

        public Criteria andLikeSortingNotIn(List<Integer> values) {
            addCriterion("like_sorting not in", values, "likeSorting");
            return (Criteria) this;
        }

        public Criteria andLikeSortingBetween(Integer value1, Integer value2) {
            addCriterion("like_sorting between", value1, value2, "likeSorting");
            return (Criteria) this;
        }

        public Criteria andLikeSortingNotBetween(Integer value1, Integer value2) {
            addCriterion("like_sorting not between", value1, value2, "likeSorting");
            return (Criteria) this;
        }

        public Criteria andLimitTimesIsNull() {
            addCriterion("limit_times is null");
            return (Criteria) this;
        }

        public Criteria andLimitTimesIsNotNull() {
            addCriterion("limit_times is not null");
            return (Criteria) this;
        }

        public Criteria andLimitTimesEqualTo(Integer value) {
            addCriterion("limit_times =", value, "limitTimes");
            return (Criteria) this;
        }

        public Criteria andLimitTimesNotEqualTo(Integer value) {
            addCriterion("limit_times <>", value, "limitTimes");
            return (Criteria) this;
        }

        public Criteria andLimitTimesGreaterThan(Integer value) {
            addCriterion("limit_times >", value, "limitTimes");
            return (Criteria) this;
        }

        public Criteria andLimitTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_times >=", value, "limitTimes");
            return (Criteria) this;
        }

        public Criteria andLimitTimesLessThan(Integer value) {
            addCriterion("limit_times <", value, "limitTimes");
            return (Criteria) this;
        }

        public Criteria andLimitTimesLessThanOrEqualTo(Integer value) {
            addCriterion("limit_times <=", value, "limitTimes");
            return (Criteria) this;
        }

        public Criteria andLimitTimesIn(List<Integer> values) {
            addCriterion("limit_times in", values, "limitTimes");
            return (Criteria) this;
        }

        public Criteria andLimitTimesNotIn(List<Integer> values) {
            addCriterion("limit_times not in", values, "limitTimes");
            return (Criteria) this;
        }

        public Criteria andLimitTimesBetween(Integer value1, Integer value2) {
            addCriterion("limit_times between", value1, value2, "limitTimes");
            return (Criteria) this;
        }

        public Criteria andLimitTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_times not between", value1, value2, "limitTimes");
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