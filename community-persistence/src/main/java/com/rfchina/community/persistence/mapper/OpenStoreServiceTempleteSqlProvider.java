package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreServiceTemplete;
import com.rfchina.community.persistence.model.OpenStoreServiceTempleteExample.Criteria;
import com.rfchina.community.persistence.model.OpenStoreServiceTempleteExample.Criterion;
import com.rfchina.community.persistence.model.OpenStoreServiceTempleteExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenStoreServiceTempleteSqlProvider {

    public String countByExample(OpenStoreServiceTempleteExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_store_service_templete");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenStoreServiceTempleteExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_store_service_templete");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenStoreServiceTemplete record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_store_service_templete");
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getExpressMoney() != null) {
            sql.VALUES("express_money", "#{expressMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getFlagship() != null) {
            sql.VALUES("flagship", "#{flagship,jdbcType=INTEGER}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getBannerUrl() != null) {
            sql.VALUES("banner_url", "#{bannerUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAddressProvince() != null) {
            sql.VALUES("address_province", "#{addressProvince,jdbcType=INTEGER}");
        }
        
        if (record.getAddressCity() != null) {
            sql.VALUES("address_city", "#{addressCity,jdbcType=INTEGER}");
        }
        
        if (record.getAddressArea() != null) {
            sql.VALUES("address_area", "#{addressArea,jdbcType=INTEGER}");
        }
        
        if (record.getAddressInfo() != null) {
            sql.VALUES("address_info", "#{addressInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getStorePic() != null) {
            sql.VALUES("store_pic", "#{storePic,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressAllInfo() != null) {
            sql.VALUES("address_all_info", "#{addressAllInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenTime() != null) {
            sql.VALUES("open_time", "#{openTime,jdbcType=VARCHAR}");
        }
        
        if (record.getCloseTime() != null) {
            sql.VALUES("close_time", "#{closeTime,jdbcType=VARCHAR}");
        }
        
        if (record.getPremiumNum() != null) {
            sql.VALUES("premium_num", "#{premiumNum,jdbcType=INTEGER}");
        }
        
        if (record.getScanStatus() != null) {
            sql.VALUES("scan_status", "#{scanStatus,jdbcType=INTEGER}");
        }
        
        if (record.getQuickPay() != null) {
            sql.VALUES("quick_pay", "#{quickPay,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenStoreServiceTempleteExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("service_id");
        } else {
            sql.SELECT("service_id");
        }
        sql.SELECT("express_money");
        sql.SELECT("flagship");
        sql.SELECT("phone");
        sql.SELECT("banner_url");
        sql.SELECT("create_time");
        sql.SELECT("address_province");
        sql.SELECT("address_city");
        sql.SELECT("address_area");
        sql.SELECT("address_info");
        sql.SELECT("store_pic");
        sql.SELECT("address_all_info");
        sql.SELECT("open_time");
        sql.SELECT("close_time");
        sql.SELECT("premium_num");
        sql.SELECT("scan_status");
        sql.SELECT("quick_pay");
        sql.FROM("open_store_service_templete");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenStoreServiceTemplete record = (OpenStoreServiceTemplete) parameter.get("record");
        OpenStoreServiceTempleteExample example = (OpenStoreServiceTempleteExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_store_service_templete");
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getExpressMoney() != null) {
            sql.SET("express_money = #{record.expressMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getFlagship() != null) {
            sql.SET("flagship = #{record.flagship,jdbcType=INTEGER}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getBannerUrl() != null) {
            sql.SET("banner_url = #{record.bannerUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAddressProvince() != null) {
            sql.SET("address_province = #{record.addressProvince,jdbcType=INTEGER}");
        }
        
        if (record.getAddressCity() != null) {
            sql.SET("address_city = #{record.addressCity,jdbcType=INTEGER}");
        }
        
        if (record.getAddressArea() != null) {
            sql.SET("address_area = #{record.addressArea,jdbcType=INTEGER}");
        }
        
        if (record.getAddressInfo() != null) {
            sql.SET("address_info = #{record.addressInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getStorePic() != null) {
            sql.SET("store_pic = #{record.storePic,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressAllInfo() != null) {
            sql.SET("address_all_info = #{record.addressAllInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenTime() != null) {
            sql.SET("open_time = #{record.openTime,jdbcType=VARCHAR}");
        }
        
        if (record.getCloseTime() != null) {
            sql.SET("close_time = #{record.closeTime,jdbcType=VARCHAR}");
        }
        
        if (record.getPremiumNum() != null) {
            sql.SET("premium_num = #{record.premiumNum,jdbcType=INTEGER}");
        }
        
        if (record.getScanStatus() != null) {
            sql.SET("scan_status = #{record.scanStatus,jdbcType=INTEGER}");
        }
        
        if (record.getQuickPay() != null) {
            sql.SET("quick_pay = #{record.quickPay,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_service_templete");
        
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("express_money = #{record.expressMoney,jdbcType=DECIMAL}");
        sql.SET("flagship = #{record.flagship,jdbcType=INTEGER}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        sql.SET("banner_url = #{record.bannerUrl,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("address_province = #{record.addressProvince,jdbcType=INTEGER}");
        sql.SET("address_city = #{record.addressCity,jdbcType=INTEGER}");
        sql.SET("address_area = #{record.addressArea,jdbcType=INTEGER}");
        sql.SET("address_info = #{record.addressInfo,jdbcType=VARCHAR}");
        sql.SET("store_pic = #{record.storePic,jdbcType=VARCHAR}");
        sql.SET("address_all_info = #{record.addressAllInfo,jdbcType=VARCHAR}");
        sql.SET("open_time = #{record.openTime,jdbcType=VARCHAR}");
        sql.SET("close_time = #{record.closeTime,jdbcType=VARCHAR}");
        sql.SET("premium_num = #{record.premiumNum,jdbcType=INTEGER}");
        sql.SET("scan_status = #{record.scanStatus,jdbcType=INTEGER}");
        sql.SET("quick_pay = #{record.quickPay,jdbcType=INTEGER}");
        
        OpenStoreServiceTempleteExample example = (OpenStoreServiceTempleteExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenStoreServiceTemplete record) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_service_templete");
        
        if (record.getExpressMoney() != null) {
            sql.SET("express_money = #{expressMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getFlagship() != null) {
            sql.SET("flagship = #{flagship,jdbcType=INTEGER}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getBannerUrl() != null) {
            sql.SET("banner_url = #{bannerUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAddressProvince() != null) {
            sql.SET("address_province = #{addressProvince,jdbcType=INTEGER}");
        }
        
        if (record.getAddressCity() != null) {
            sql.SET("address_city = #{addressCity,jdbcType=INTEGER}");
        }
        
        if (record.getAddressArea() != null) {
            sql.SET("address_area = #{addressArea,jdbcType=INTEGER}");
        }
        
        if (record.getAddressInfo() != null) {
            sql.SET("address_info = #{addressInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getStorePic() != null) {
            sql.SET("store_pic = #{storePic,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressAllInfo() != null) {
            sql.SET("address_all_info = #{addressAllInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenTime() != null) {
            sql.SET("open_time = #{openTime,jdbcType=VARCHAR}");
        }
        
        if (record.getCloseTime() != null) {
            sql.SET("close_time = #{closeTime,jdbcType=VARCHAR}");
        }
        
        if (record.getPremiumNum() != null) {
            sql.SET("premium_num = #{premiumNum,jdbcType=INTEGER}");
        }
        
        if (record.getScanStatus() != null) {
            sql.SET("scan_status = #{scanStatus,jdbcType=INTEGER}");
        }
        
        if (record.getQuickPay() != null) {
            sql.SET("quick_pay = #{quickPay,jdbcType=INTEGER}");
        }
        
        sql.WHERE("service_id = #{serviceId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenStoreServiceTempleteExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}