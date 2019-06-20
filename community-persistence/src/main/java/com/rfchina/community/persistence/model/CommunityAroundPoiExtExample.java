package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.List;

public class CommunityAroundPoiExtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommunityAroundPoiExtExample() {
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

        public Criteria andPoiIdIsNull() {
            addCriterion("poi_id is null");
            return (Criteria) this;
        }

        public Criteria andPoiIdIsNotNull() {
            addCriterion("poi_id is not null");
            return (Criteria) this;
        }

        public Criteria andPoiIdEqualTo(Long value) {
            addCriterion("poi_id =", value, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiIdNotEqualTo(Long value) {
            addCriterion("poi_id <>", value, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiIdGreaterThan(Long value) {
            addCriterion("poi_id >", value, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiIdGreaterThanOrEqualTo(Long value) {
            addCriterion("poi_id >=", value, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiIdLessThan(Long value) {
            addCriterion("poi_id <", value, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiIdLessThanOrEqualTo(Long value) {
            addCriterion("poi_id <=", value, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiIdIn(List<Long> values) {
            addCriterion("poi_id in", values, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiIdNotIn(List<Long> values) {
            addCriterion("poi_id not in", values, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiIdBetween(Long value1, Long value2) {
            addCriterion("poi_id between", value1, value2, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiIdNotBetween(Long value1, Long value2) {
            addCriterion("poi_id not between", value1, value2, "poiId");
            return (Criteria) this;
        }

        public Criteria andRatingIsNull() {
            addCriterion("rating is null");
            return (Criteria) this;
        }

        public Criteria andRatingIsNotNull() {
            addCriterion("rating is not null");
            return (Criteria) this;
        }

        public Criteria andRatingEqualTo(Double value) {
            addCriterion("rating =", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotEqualTo(Double value) {
            addCriterion("rating <>", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingGreaterThan(Double value) {
            addCriterion("rating >", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingGreaterThanOrEqualTo(Double value) {
            addCriterion("rating >=", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLessThan(Double value) {
            addCriterion("rating <", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLessThanOrEqualTo(Double value) {
            addCriterion("rating <=", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingIn(List<Double> values) {
            addCriterion("rating in", values, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotIn(List<Double> values) {
            addCriterion("rating not in", values, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingBetween(Double value1, Double value2) {
            addCriterion("rating between", value1, value2, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotBetween(Double value1, Double value2) {
            addCriterion("rating not between", value1, value2, "rating");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(Double value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(Double value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(Double value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(Double value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(Double value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(Double value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<Double> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<Double> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(Double value1, Double value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(Double value1, Double value2) {
            addCriterion("cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andNativeRatingIsNull() {
            addCriterion("native_rating is null");
            return (Criteria) this;
        }

        public Criteria andNativeRatingIsNotNull() {
            addCriterion("native_rating is not null");
            return (Criteria) this;
        }

        public Criteria andNativeRatingEqualTo(Double value) {
            addCriterion("native_rating =", value, "nativeRating");
            return (Criteria) this;
        }

        public Criteria andNativeRatingNotEqualTo(Double value) {
            addCriterion("native_rating <>", value, "nativeRating");
            return (Criteria) this;
        }

        public Criteria andNativeRatingGreaterThan(Double value) {
            addCriterion("native_rating >", value, "nativeRating");
            return (Criteria) this;
        }

        public Criteria andNativeRatingGreaterThanOrEqualTo(Double value) {
            addCriterion("native_rating >=", value, "nativeRating");
            return (Criteria) this;
        }

        public Criteria andNativeRatingLessThan(Double value) {
            addCriterion("native_rating <", value, "nativeRating");
            return (Criteria) this;
        }

        public Criteria andNativeRatingLessThanOrEqualTo(Double value) {
            addCriterion("native_rating <=", value, "nativeRating");
            return (Criteria) this;
        }

        public Criteria andNativeRatingIn(List<Double> values) {
            addCriterion("native_rating in", values, "nativeRating");
            return (Criteria) this;
        }

        public Criteria andNativeRatingNotIn(List<Double> values) {
            addCriterion("native_rating not in", values, "nativeRating");
            return (Criteria) this;
        }

        public Criteria andNativeRatingBetween(Double value1, Double value2) {
            addCriterion("native_rating between", value1, value2, "nativeRating");
            return (Criteria) this;
        }

        public Criteria andNativeRatingNotBetween(Double value1, Double value2) {
            addCriterion("native_rating not between", value1, value2, "nativeRating");
            return (Criteria) this;
        }

        public Criteria andShopHoursIsNull() {
            addCriterion("shop_hours is null");
            return (Criteria) this;
        }

        public Criteria andShopHoursIsNotNull() {
            addCriterion("shop_hours is not null");
            return (Criteria) this;
        }

        public Criteria andShopHoursEqualTo(String value) {
            addCriterion("shop_hours =", value, "shopHours");
            return (Criteria) this;
        }

        public Criteria andShopHoursNotEqualTo(String value) {
            addCriterion("shop_hours <>", value, "shopHours");
            return (Criteria) this;
        }

        public Criteria andShopHoursGreaterThan(String value) {
            addCriterion("shop_hours >", value, "shopHours");
            return (Criteria) this;
        }

        public Criteria andShopHoursGreaterThanOrEqualTo(String value) {
            addCriterion("shop_hours >=", value, "shopHours");
            return (Criteria) this;
        }

        public Criteria andShopHoursLessThan(String value) {
            addCriterion("shop_hours <", value, "shopHours");
            return (Criteria) this;
        }

        public Criteria andShopHoursLessThanOrEqualTo(String value) {
            addCriterion("shop_hours <=", value, "shopHours");
            return (Criteria) this;
        }

        public Criteria andShopHoursLike(String value) {
            addCriterion("shop_hours like", value, "shopHours");
            return (Criteria) this;
        }

        public Criteria andShopHoursNotLike(String value) {
            addCriterion("shop_hours not like", value, "shopHours");
            return (Criteria) this;
        }

        public Criteria andShopHoursIn(List<String> values) {
            addCriterion("shop_hours in", values, "shopHours");
            return (Criteria) this;
        }

        public Criteria andShopHoursNotIn(List<String> values) {
            addCriterion("shop_hours not in", values, "shopHours");
            return (Criteria) this;
        }

        public Criteria andShopHoursBetween(String value1, String value2) {
            addCriterion("shop_hours between", value1, value2, "shopHours");
            return (Criteria) this;
        }

        public Criteria andShopHoursNotBetween(String value1, String value2) {
            addCriterion("shop_hours not between", value1, value2, "shopHours");
            return (Criteria) this;
        }

        public Criteria andBaiduDetailUrlIsNull() {
            addCriterion("baidu_detail_url is null");
            return (Criteria) this;
        }

        public Criteria andBaiduDetailUrlIsNotNull() {
            addCriterion("baidu_detail_url is not null");
            return (Criteria) this;
        }

        public Criteria andBaiduDetailUrlEqualTo(String value) {
            addCriterion("baidu_detail_url =", value, "baiduDetailUrl");
            return (Criteria) this;
        }

        public Criteria andBaiduDetailUrlNotEqualTo(String value) {
            addCriterion("baidu_detail_url <>", value, "baiduDetailUrl");
            return (Criteria) this;
        }

        public Criteria andBaiduDetailUrlGreaterThan(String value) {
            addCriterion("baidu_detail_url >", value, "baiduDetailUrl");
            return (Criteria) this;
        }

        public Criteria andBaiduDetailUrlGreaterThanOrEqualTo(String value) {
            addCriterion("baidu_detail_url >=", value, "baiduDetailUrl");
            return (Criteria) this;
        }

        public Criteria andBaiduDetailUrlLessThan(String value) {
            addCriterion("baidu_detail_url <", value, "baiduDetailUrl");
            return (Criteria) this;
        }

        public Criteria andBaiduDetailUrlLessThanOrEqualTo(String value) {
            addCriterion("baidu_detail_url <=", value, "baiduDetailUrl");
            return (Criteria) this;
        }

        public Criteria andBaiduDetailUrlLike(String value) {
            addCriterion("baidu_detail_url like", value, "baiduDetailUrl");
            return (Criteria) this;
        }

        public Criteria andBaiduDetailUrlNotLike(String value) {
            addCriterion("baidu_detail_url not like", value, "baiduDetailUrl");
            return (Criteria) this;
        }

        public Criteria andBaiduDetailUrlIn(List<String> values) {
            addCriterion("baidu_detail_url in", values, "baiduDetailUrl");
            return (Criteria) this;
        }

        public Criteria andBaiduDetailUrlNotIn(List<String> values) {
            addCriterion("baidu_detail_url not in", values, "baiduDetailUrl");
            return (Criteria) this;
        }

        public Criteria andBaiduDetailUrlBetween(String value1, String value2) {
            addCriterion("baidu_detail_url between", value1, value2, "baiduDetailUrl");
            return (Criteria) this;
        }

        public Criteria andBaiduDetailUrlNotBetween(String value1, String value2) {
            addCriterion("baidu_detail_url not between", value1, value2, "baiduDetailUrl");
            return (Criteria) this;
        }

        public Criteria andFeaturedServiceIsNull() {
            addCriterion("featured_service is null");
            return (Criteria) this;
        }

        public Criteria andFeaturedServiceIsNotNull() {
            addCriterion("featured_service is not null");
            return (Criteria) this;
        }

        public Criteria andFeaturedServiceEqualTo(String value) {
            addCriterion("featured_service =", value, "featuredService");
            return (Criteria) this;
        }

        public Criteria andFeaturedServiceNotEqualTo(String value) {
            addCriterion("featured_service <>", value, "featuredService");
            return (Criteria) this;
        }

        public Criteria andFeaturedServiceGreaterThan(String value) {
            addCriterion("featured_service >", value, "featuredService");
            return (Criteria) this;
        }

        public Criteria andFeaturedServiceGreaterThanOrEqualTo(String value) {
            addCriterion("featured_service >=", value, "featuredService");
            return (Criteria) this;
        }

        public Criteria andFeaturedServiceLessThan(String value) {
            addCriterion("featured_service <", value, "featuredService");
            return (Criteria) this;
        }

        public Criteria andFeaturedServiceLessThanOrEqualTo(String value) {
            addCriterion("featured_service <=", value, "featuredService");
            return (Criteria) this;
        }

        public Criteria andFeaturedServiceLike(String value) {
            addCriterion("featured_service like", value, "featuredService");
            return (Criteria) this;
        }

        public Criteria andFeaturedServiceNotLike(String value) {
            addCriterion("featured_service not like", value, "featuredService");
            return (Criteria) this;
        }

        public Criteria andFeaturedServiceIn(List<String> values) {
            addCriterion("featured_service in", values, "featuredService");
            return (Criteria) this;
        }

        public Criteria andFeaturedServiceNotIn(List<String> values) {
            addCriterion("featured_service not in", values, "featuredService");
            return (Criteria) this;
        }

        public Criteria andFeaturedServiceBetween(String value1, String value2) {
            addCriterion("featured_service between", value1, value2, "featuredService");
            return (Criteria) this;
        }

        public Criteria andFeaturedServiceNotBetween(String value1, String value2) {
            addCriterion("featured_service not between", value1, value2, "featuredService");
            return (Criteria) this;
        }

        public Criteria andSyncStatusIsNull() {
            addCriterion("sync_status is null");
            return (Criteria) this;
        }

        public Criteria andSyncStatusIsNotNull() {
            addCriterion("sync_status is not null");
            return (Criteria) this;
        }

        public Criteria andSyncStatusEqualTo(Integer value) {
            addCriterion("sync_status =", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusNotEqualTo(Integer value) {
            addCriterion("sync_status <>", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusGreaterThan(Integer value) {
            addCriterion("sync_status >", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("sync_status >=", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusLessThan(Integer value) {
            addCriterion("sync_status <", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusLessThanOrEqualTo(Integer value) {
            addCriterion("sync_status <=", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusIn(List<Integer> values) {
            addCriterion("sync_status in", values, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusNotIn(List<Integer> values) {
            addCriterion("sync_status not in", values, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusBetween(Integer value1, Integer value2) {
            addCriterion("sync_status between", value1, value2, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("sync_status not between", value1, value2, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andBaiduUidIsNull() {
            addCriterion("baidu_uid is null");
            return (Criteria) this;
        }

        public Criteria andBaiduUidIsNotNull() {
            addCriterion("baidu_uid is not null");
            return (Criteria) this;
        }

        public Criteria andBaiduUidEqualTo(String value) {
            addCriterion("baidu_uid =", value, "baiduUid");
            return (Criteria) this;
        }

        public Criteria andBaiduUidNotEqualTo(String value) {
            addCriterion("baidu_uid <>", value, "baiduUid");
            return (Criteria) this;
        }

        public Criteria andBaiduUidGreaterThan(String value) {
            addCriterion("baidu_uid >", value, "baiduUid");
            return (Criteria) this;
        }

        public Criteria andBaiduUidGreaterThanOrEqualTo(String value) {
            addCriterion("baidu_uid >=", value, "baiduUid");
            return (Criteria) this;
        }

        public Criteria andBaiduUidLessThan(String value) {
            addCriterion("baidu_uid <", value, "baiduUid");
            return (Criteria) this;
        }

        public Criteria andBaiduUidLessThanOrEqualTo(String value) {
            addCriterion("baidu_uid <=", value, "baiduUid");
            return (Criteria) this;
        }

        public Criteria andBaiduUidLike(String value) {
            addCriterion("baidu_uid like", value, "baiduUid");
            return (Criteria) this;
        }

        public Criteria andBaiduUidNotLike(String value) {
            addCriterion("baidu_uid not like", value, "baiduUid");
            return (Criteria) this;
        }

        public Criteria andBaiduUidIn(List<String> values) {
            addCriterion("baidu_uid in", values, "baiduUid");
            return (Criteria) this;
        }

        public Criteria andBaiduUidNotIn(List<String> values) {
            addCriterion("baidu_uid not in", values, "baiduUid");
            return (Criteria) this;
        }

        public Criteria andBaiduUidBetween(String value1, String value2) {
            addCriterion("baidu_uid between", value1, value2, "baiduUid");
            return (Criteria) this;
        }

        public Criteria andBaiduUidNotBetween(String value1, String value2) {
            addCriterion("baidu_uid not between", value1, value2, "baiduUid");
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