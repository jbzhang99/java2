package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenStoreServiceTempleteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenStoreServiceTempleteExample() {
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

        public Criteria andExpressMoneyIsNull() {
            addCriterion("express_money is null");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyIsNotNull() {
            addCriterion("express_money is not null");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyEqualTo(BigDecimal value) {
            addCriterion("express_money =", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyNotEqualTo(BigDecimal value) {
            addCriterion("express_money <>", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyGreaterThan(BigDecimal value) {
            addCriterion("express_money >", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("express_money >=", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyLessThan(BigDecimal value) {
            addCriterion("express_money <", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("express_money <=", value, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyIn(List<BigDecimal> values) {
            addCriterion("express_money in", values, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyNotIn(List<BigDecimal> values) {
            addCriterion("express_money not in", values, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("express_money between", value1, value2, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andExpressMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("express_money not between", value1, value2, "expressMoney");
            return (Criteria) this;
        }

        public Criteria andFlagshipIsNull() {
            addCriterion("flagship is null");
            return (Criteria) this;
        }

        public Criteria andFlagshipIsNotNull() {
            addCriterion("flagship is not null");
            return (Criteria) this;
        }

        public Criteria andFlagshipEqualTo(Integer value) {
            addCriterion("flagship =", value, "flagship");
            return (Criteria) this;
        }

        public Criteria andFlagshipNotEqualTo(Integer value) {
            addCriterion("flagship <>", value, "flagship");
            return (Criteria) this;
        }

        public Criteria andFlagshipGreaterThan(Integer value) {
            addCriterion("flagship >", value, "flagship");
            return (Criteria) this;
        }

        public Criteria andFlagshipGreaterThanOrEqualTo(Integer value) {
            addCriterion("flagship >=", value, "flagship");
            return (Criteria) this;
        }

        public Criteria andFlagshipLessThan(Integer value) {
            addCriterion("flagship <", value, "flagship");
            return (Criteria) this;
        }

        public Criteria andFlagshipLessThanOrEqualTo(Integer value) {
            addCriterion("flagship <=", value, "flagship");
            return (Criteria) this;
        }

        public Criteria andFlagshipIn(List<Integer> values) {
            addCriterion("flagship in", values, "flagship");
            return (Criteria) this;
        }

        public Criteria andFlagshipNotIn(List<Integer> values) {
            addCriterion("flagship not in", values, "flagship");
            return (Criteria) this;
        }

        public Criteria andFlagshipBetween(Integer value1, Integer value2) {
            addCriterion("flagship between", value1, value2, "flagship");
            return (Criteria) this;
        }

        public Criteria andFlagshipNotBetween(Integer value1, Integer value2) {
            addCriterion("flagship not between", value1, value2, "flagship");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andBannerUrlIsNull() {
            addCriterion("banner_url is null");
            return (Criteria) this;
        }

        public Criteria andBannerUrlIsNotNull() {
            addCriterion("banner_url is not null");
            return (Criteria) this;
        }

        public Criteria andBannerUrlEqualTo(String value) {
            addCriterion("banner_url =", value, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlNotEqualTo(String value) {
            addCriterion("banner_url <>", value, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlGreaterThan(String value) {
            addCriterion("banner_url >", value, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlGreaterThanOrEqualTo(String value) {
            addCriterion("banner_url >=", value, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlLessThan(String value) {
            addCriterion("banner_url <", value, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlLessThanOrEqualTo(String value) {
            addCriterion("banner_url <=", value, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlLike(String value) {
            addCriterion("banner_url like", value, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlNotLike(String value) {
            addCriterion("banner_url not like", value, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlIn(List<String> values) {
            addCriterion("banner_url in", values, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlNotIn(List<String> values) {
            addCriterion("banner_url not in", values, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlBetween(String value1, String value2) {
            addCriterion("banner_url between", value1, value2, "bannerUrl");
            return (Criteria) this;
        }

        public Criteria andBannerUrlNotBetween(String value1, String value2) {
            addCriterion("banner_url not between", value1, value2, "bannerUrl");
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

        public Criteria andAddressProvinceIsNull() {
            addCriterion("address_province is null");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceIsNotNull() {
            addCriterion("address_province is not null");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceEqualTo(Integer value) {
            addCriterion("address_province =", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceNotEqualTo(Integer value) {
            addCriterion("address_province <>", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceGreaterThan(Integer value) {
            addCriterion("address_province >", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceGreaterThanOrEqualTo(Integer value) {
            addCriterion("address_province >=", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceLessThan(Integer value) {
            addCriterion("address_province <", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceLessThanOrEqualTo(Integer value) {
            addCriterion("address_province <=", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceIn(List<Integer> values) {
            addCriterion("address_province in", values, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceNotIn(List<Integer> values) {
            addCriterion("address_province not in", values, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceBetween(Integer value1, Integer value2) {
            addCriterion("address_province between", value1, value2, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceNotBetween(Integer value1, Integer value2) {
            addCriterion("address_province not between", value1, value2, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressCityIsNull() {
            addCriterion("address_city is null");
            return (Criteria) this;
        }

        public Criteria andAddressCityIsNotNull() {
            addCriterion("address_city is not null");
            return (Criteria) this;
        }

        public Criteria andAddressCityEqualTo(Integer value) {
            addCriterion("address_city =", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotEqualTo(Integer value) {
            addCriterion("address_city <>", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityGreaterThan(Integer value) {
            addCriterion("address_city >", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityGreaterThanOrEqualTo(Integer value) {
            addCriterion("address_city >=", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityLessThan(Integer value) {
            addCriterion("address_city <", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityLessThanOrEqualTo(Integer value) {
            addCriterion("address_city <=", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityIn(List<Integer> values) {
            addCriterion("address_city in", values, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotIn(List<Integer> values) {
            addCriterion("address_city not in", values, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityBetween(Integer value1, Integer value2) {
            addCriterion("address_city between", value1, value2, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotBetween(Integer value1, Integer value2) {
            addCriterion("address_city not between", value1, value2, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressAreaIsNull() {
            addCriterion("address_area is null");
            return (Criteria) this;
        }

        public Criteria andAddressAreaIsNotNull() {
            addCriterion("address_area is not null");
            return (Criteria) this;
        }

        public Criteria andAddressAreaEqualTo(Integer value) {
            addCriterion("address_area =", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaNotEqualTo(Integer value) {
            addCriterion("address_area <>", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaGreaterThan(Integer value) {
            addCriterion("address_area >", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("address_area >=", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaLessThan(Integer value) {
            addCriterion("address_area <", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaLessThanOrEqualTo(Integer value) {
            addCriterion("address_area <=", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaIn(List<Integer> values) {
            addCriterion("address_area in", values, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaNotIn(List<Integer> values) {
            addCriterion("address_area not in", values, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaBetween(Integer value1, Integer value2) {
            addCriterion("address_area between", value1, value2, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("address_area not between", value1, value2, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressInfoIsNull() {
            addCriterion("address_info is null");
            return (Criteria) this;
        }

        public Criteria andAddressInfoIsNotNull() {
            addCriterion("address_info is not null");
            return (Criteria) this;
        }

        public Criteria andAddressInfoEqualTo(String value) {
            addCriterion("address_info =", value, "addressInfo");
            return (Criteria) this;
        }

        public Criteria andAddressInfoNotEqualTo(String value) {
            addCriterion("address_info <>", value, "addressInfo");
            return (Criteria) this;
        }

        public Criteria andAddressInfoGreaterThan(String value) {
            addCriterion("address_info >", value, "addressInfo");
            return (Criteria) this;
        }

        public Criteria andAddressInfoGreaterThanOrEqualTo(String value) {
            addCriterion("address_info >=", value, "addressInfo");
            return (Criteria) this;
        }

        public Criteria andAddressInfoLessThan(String value) {
            addCriterion("address_info <", value, "addressInfo");
            return (Criteria) this;
        }

        public Criteria andAddressInfoLessThanOrEqualTo(String value) {
            addCriterion("address_info <=", value, "addressInfo");
            return (Criteria) this;
        }

        public Criteria andAddressInfoLike(String value) {
            addCriterion("address_info like", value, "addressInfo");
            return (Criteria) this;
        }

        public Criteria andAddressInfoNotLike(String value) {
            addCriterion("address_info not like", value, "addressInfo");
            return (Criteria) this;
        }

        public Criteria andAddressInfoIn(List<String> values) {
            addCriterion("address_info in", values, "addressInfo");
            return (Criteria) this;
        }

        public Criteria andAddressInfoNotIn(List<String> values) {
            addCriterion("address_info not in", values, "addressInfo");
            return (Criteria) this;
        }

        public Criteria andAddressInfoBetween(String value1, String value2) {
            addCriterion("address_info between", value1, value2, "addressInfo");
            return (Criteria) this;
        }

        public Criteria andAddressInfoNotBetween(String value1, String value2) {
            addCriterion("address_info not between", value1, value2, "addressInfo");
            return (Criteria) this;
        }

        public Criteria andStorePicIsNull() {
            addCriterion("store_pic is null");
            return (Criteria) this;
        }

        public Criteria andStorePicIsNotNull() {
            addCriterion("store_pic is not null");
            return (Criteria) this;
        }

        public Criteria andStorePicEqualTo(String value) {
            addCriterion("store_pic =", value, "storePic");
            return (Criteria) this;
        }

        public Criteria andStorePicNotEqualTo(String value) {
            addCriterion("store_pic <>", value, "storePic");
            return (Criteria) this;
        }

        public Criteria andStorePicGreaterThan(String value) {
            addCriterion("store_pic >", value, "storePic");
            return (Criteria) this;
        }

        public Criteria andStorePicGreaterThanOrEqualTo(String value) {
            addCriterion("store_pic >=", value, "storePic");
            return (Criteria) this;
        }

        public Criteria andStorePicLessThan(String value) {
            addCriterion("store_pic <", value, "storePic");
            return (Criteria) this;
        }

        public Criteria andStorePicLessThanOrEqualTo(String value) {
            addCriterion("store_pic <=", value, "storePic");
            return (Criteria) this;
        }

        public Criteria andStorePicLike(String value) {
            addCriterion("store_pic like", value, "storePic");
            return (Criteria) this;
        }

        public Criteria andStorePicNotLike(String value) {
            addCriterion("store_pic not like", value, "storePic");
            return (Criteria) this;
        }

        public Criteria andStorePicIn(List<String> values) {
            addCriterion("store_pic in", values, "storePic");
            return (Criteria) this;
        }

        public Criteria andStorePicNotIn(List<String> values) {
            addCriterion("store_pic not in", values, "storePic");
            return (Criteria) this;
        }

        public Criteria andStorePicBetween(String value1, String value2) {
            addCriterion("store_pic between", value1, value2, "storePic");
            return (Criteria) this;
        }

        public Criteria andStorePicNotBetween(String value1, String value2) {
            addCriterion("store_pic not between", value1, value2, "storePic");
            return (Criteria) this;
        }

        public Criteria andAddressAllInfoIsNull() {
            addCriterion("address_all_info is null");
            return (Criteria) this;
        }

        public Criteria andAddressAllInfoIsNotNull() {
            addCriterion("address_all_info is not null");
            return (Criteria) this;
        }

        public Criteria andAddressAllInfoEqualTo(String value) {
            addCriterion("address_all_info =", value, "addressAllInfo");
            return (Criteria) this;
        }

        public Criteria andAddressAllInfoNotEqualTo(String value) {
            addCriterion("address_all_info <>", value, "addressAllInfo");
            return (Criteria) this;
        }

        public Criteria andAddressAllInfoGreaterThan(String value) {
            addCriterion("address_all_info >", value, "addressAllInfo");
            return (Criteria) this;
        }

        public Criteria andAddressAllInfoGreaterThanOrEqualTo(String value) {
            addCriterion("address_all_info >=", value, "addressAllInfo");
            return (Criteria) this;
        }

        public Criteria andAddressAllInfoLessThan(String value) {
            addCriterion("address_all_info <", value, "addressAllInfo");
            return (Criteria) this;
        }

        public Criteria andAddressAllInfoLessThanOrEqualTo(String value) {
            addCriterion("address_all_info <=", value, "addressAllInfo");
            return (Criteria) this;
        }

        public Criteria andAddressAllInfoLike(String value) {
            addCriterion("address_all_info like", value, "addressAllInfo");
            return (Criteria) this;
        }

        public Criteria andAddressAllInfoNotLike(String value) {
            addCriterion("address_all_info not like", value, "addressAllInfo");
            return (Criteria) this;
        }

        public Criteria andAddressAllInfoIn(List<String> values) {
            addCriterion("address_all_info in", values, "addressAllInfo");
            return (Criteria) this;
        }

        public Criteria andAddressAllInfoNotIn(List<String> values) {
            addCriterion("address_all_info not in", values, "addressAllInfo");
            return (Criteria) this;
        }

        public Criteria andAddressAllInfoBetween(String value1, String value2) {
            addCriterion("address_all_info between", value1, value2, "addressAllInfo");
            return (Criteria) this;
        }

        public Criteria andAddressAllInfoNotBetween(String value1, String value2) {
            addCriterion("address_all_info not between", value1, value2, "addressAllInfo");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNull() {
            addCriterion("open_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNotNull() {
            addCriterion("open_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeEqualTo(String value) {
            addCriterion("open_time =", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotEqualTo(String value) {
            addCriterion("open_time <>", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThan(String value) {
            addCriterion("open_time >", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThanOrEqualTo(String value) {
            addCriterion("open_time >=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThan(String value) {
            addCriterion("open_time <", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThanOrEqualTo(String value) {
            addCriterion("open_time <=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLike(String value) {
            addCriterion("open_time like", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotLike(String value) {
            addCriterion("open_time not like", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIn(List<String> values) {
            addCriterion("open_time in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotIn(List<String> values) {
            addCriterion("open_time not in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeBetween(String value1, String value2) {
            addCriterion("open_time between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotBetween(String value1, String value2) {
            addCriterion("open_time not between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNull() {
            addCriterion("close_time is null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNotNull() {
            addCriterion("close_time is not null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeEqualTo(String value) {
            addCriterion("close_time =", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotEqualTo(String value) {
            addCriterion("close_time <>", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThan(String value) {
            addCriterion("close_time >", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThanOrEqualTo(String value) {
            addCriterion("close_time >=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThan(String value) {
            addCriterion("close_time <", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThanOrEqualTo(String value) {
            addCriterion("close_time <=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLike(String value) {
            addCriterion("close_time like", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotLike(String value) {
            addCriterion("close_time not like", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIn(List<String> values) {
            addCriterion("close_time in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotIn(List<String> values) {
            addCriterion("close_time not in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeBetween(String value1, String value2) {
            addCriterion("close_time between", value1, value2, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotBetween(String value1, String value2) {
            addCriterion("close_time not between", value1, value2, "closeTime");
            return (Criteria) this;
        }

        public Criteria andPremiumNumIsNull() {
            addCriterion("premium_num is null");
            return (Criteria) this;
        }

        public Criteria andPremiumNumIsNotNull() {
            addCriterion("premium_num is not null");
            return (Criteria) this;
        }

        public Criteria andPremiumNumEqualTo(Integer value) {
            addCriterion("premium_num =", value, "premiumNum");
            return (Criteria) this;
        }

        public Criteria andPremiumNumNotEqualTo(Integer value) {
            addCriterion("premium_num <>", value, "premiumNum");
            return (Criteria) this;
        }

        public Criteria andPremiumNumGreaterThan(Integer value) {
            addCriterion("premium_num >", value, "premiumNum");
            return (Criteria) this;
        }

        public Criteria andPremiumNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("premium_num >=", value, "premiumNum");
            return (Criteria) this;
        }

        public Criteria andPremiumNumLessThan(Integer value) {
            addCriterion("premium_num <", value, "premiumNum");
            return (Criteria) this;
        }

        public Criteria andPremiumNumLessThanOrEqualTo(Integer value) {
            addCriterion("premium_num <=", value, "premiumNum");
            return (Criteria) this;
        }

        public Criteria andPremiumNumIn(List<Integer> values) {
            addCriterion("premium_num in", values, "premiumNum");
            return (Criteria) this;
        }

        public Criteria andPremiumNumNotIn(List<Integer> values) {
            addCriterion("premium_num not in", values, "premiumNum");
            return (Criteria) this;
        }

        public Criteria andPremiumNumBetween(Integer value1, Integer value2) {
            addCriterion("premium_num between", value1, value2, "premiumNum");
            return (Criteria) this;
        }

        public Criteria andPremiumNumNotBetween(Integer value1, Integer value2) {
            addCriterion("premium_num not between", value1, value2, "premiumNum");
            return (Criteria) this;
        }

        public Criteria andScanStatusIsNull() {
            addCriterion("scan_status is null");
            return (Criteria) this;
        }

        public Criteria andScanStatusIsNotNull() {
            addCriterion("scan_status is not null");
            return (Criteria) this;
        }

        public Criteria andScanStatusEqualTo(Integer value) {
            addCriterion("scan_status =", value, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andScanStatusNotEqualTo(Integer value) {
            addCriterion("scan_status <>", value, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andScanStatusGreaterThan(Integer value) {
            addCriterion("scan_status >", value, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andScanStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("scan_status >=", value, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andScanStatusLessThan(Integer value) {
            addCriterion("scan_status <", value, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andScanStatusLessThanOrEqualTo(Integer value) {
            addCriterion("scan_status <=", value, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andScanStatusIn(List<Integer> values) {
            addCriterion("scan_status in", values, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andScanStatusNotIn(List<Integer> values) {
            addCriterion("scan_status not in", values, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andScanStatusBetween(Integer value1, Integer value2) {
            addCriterion("scan_status between", value1, value2, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andScanStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("scan_status not between", value1, value2, "scanStatus");
            return (Criteria) this;
        }

        public Criteria andQuickPayIsNull() {
            addCriterion("quick_pay is null");
            return (Criteria) this;
        }

        public Criteria andQuickPayIsNotNull() {
            addCriterion("quick_pay is not null");
            return (Criteria) this;
        }

        public Criteria andQuickPayEqualTo(Integer value) {
            addCriterion("quick_pay =", value, "quickPay");
            return (Criteria) this;
        }

        public Criteria andQuickPayNotEqualTo(Integer value) {
            addCriterion("quick_pay <>", value, "quickPay");
            return (Criteria) this;
        }

        public Criteria andQuickPayGreaterThan(Integer value) {
            addCriterion("quick_pay >", value, "quickPay");
            return (Criteria) this;
        }

        public Criteria andQuickPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("quick_pay >=", value, "quickPay");
            return (Criteria) this;
        }

        public Criteria andQuickPayLessThan(Integer value) {
            addCriterion("quick_pay <", value, "quickPay");
            return (Criteria) this;
        }

        public Criteria andQuickPayLessThanOrEqualTo(Integer value) {
            addCriterion("quick_pay <=", value, "quickPay");
            return (Criteria) this;
        }

        public Criteria andQuickPayIn(List<Integer> values) {
            addCriterion("quick_pay in", values, "quickPay");
            return (Criteria) this;
        }

        public Criteria andQuickPayNotIn(List<Integer> values) {
            addCriterion("quick_pay not in", values, "quickPay");
            return (Criteria) this;
        }

        public Criteria andQuickPayBetween(Integer value1, Integer value2) {
            addCriterion("quick_pay between", value1, value2, "quickPay");
            return (Criteria) this;
        }

        public Criteria andQuickPayNotBetween(Integer value1, Integer value2) {
            addCriterion("quick_pay not between", value1, value2, "quickPay");
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