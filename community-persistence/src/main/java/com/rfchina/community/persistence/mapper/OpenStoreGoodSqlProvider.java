package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreGood;
import com.rfchina.community.persistence.model.OpenStoreGoodExample.Criteria;
import com.rfchina.community.persistence.model.OpenStoreGoodExample.Criterion;
import com.rfchina.community.persistence.model.OpenStoreGoodExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenStoreGoodSqlProvider {

    public String countByExample(OpenStoreGoodExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_store_good");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenStoreGoodExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_store_good");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenStoreGood record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_store_good");
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getShortDetail() != null) {
            sql.VALUES("short_detail", "#{shortDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getPrePrice() != null) {
            sql.VALUES("pre_price", "#{prePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStock() != null) {
            sql.VALUES("stock", "#{stock,jdbcType=INTEGER}");
        }
        
        if (record.getSaleAmount() != null) {
            sql.VALUES("sale_amount", "#{saleAmount,jdbcType=INTEGER}");
        }
        
        if (record.getVirtualSaleAmount() != null) {
            sql.VALUES("virtual_sale_amount", "#{virtualSaleAmount,jdbcType=INTEGER}");
        }
        
        if (record.getTotalSaleAmount() != null) {
            sql.VALUES("total_sale_amount", "#{totalSaleAmount,jdbcType=INTEGER}");
        }
        
        if (record.getCategoryId() != null) {
            sql.VALUES("category_id", "#{categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getVerifyTimes() != null) {
            sql.VALUES("verify_times", "#{verifyTimes,jdbcType=INTEGER}");
        }
        
        if (record.getVerifyStartTime() != null) {
            sql.VALUES("verify_start_time", "#{verifyStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyEndTime() != null) {
            sql.VALUES("verify_end_time", "#{verifyEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSorting() != null) {
            sql.VALUES("sorting", "#{sorting,jdbcType=INTEGER}");
        }
        
        if (record.getLikeSorting() != null) {
            sql.VALUES("like_sorting", "#{likeSorting,jdbcType=INTEGER}");
        }
        
        if (record.getLimitTimes() != null) {
            sql.VALUES("limit_times", "#{limitTimes,jdbcType=INTEGER}");
        }
        
        if (record.getPicUrl() != null) {
            sql.VALUES("pic_url", "#{picUrl,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(OpenStoreGoodExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("service_id");
        sql.SELECT("code");
        sql.SELECT("name");
        sql.SELECT("short_detail");
        sql.SELECT("pre_price");
        sql.SELECT("price");
        sql.SELECT("status");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("stock");
        sql.SELECT("sale_amount");
        sql.SELECT("virtual_sale_amount");
        sql.SELECT("total_sale_amount");
        sql.SELECT("category_id");
        sql.SELECT("verify_times");
        sql.SELECT("verify_start_time");
        sql.SELECT("verify_end_time");
        sql.SELECT("sorting");
        sql.SELECT("like_sorting");
        sql.SELECT("limit_times");
        sql.SELECT("pic_url");
        sql.FROM("open_store_good");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenStoreGoodExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("service_id");
        sql.SELECT("code");
        sql.SELECT("name");
        sql.SELECT("short_detail");
        sql.SELECT("pre_price");
        sql.SELECT("price");
        sql.SELECT("status");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("stock");
        sql.SELECT("sale_amount");
        sql.SELECT("virtual_sale_amount");
        sql.SELECT("total_sale_amount");
        sql.SELECT("category_id");
        sql.SELECT("verify_times");
        sql.SELECT("verify_start_time");
        sql.SELECT("verify_end_time");
        sql.SELECT("sorting");
        sql.SELECT("like_sorting");
        sql.SELECT("limit_times");
        sql.FROM("open_store_good");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenStoreGood record = (OpenStoreGood) parameter.get("record");
        OpenStoreGoodExample example = (OpenStoreGoodExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_store_good");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getShortDetail() != null) {
            sql.SET("short_detail = #{record.shortDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getPrePrice() != null) {
            sql.SET("pre_price = #{record.prePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{record.price,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStock() != null) {
            sql.SET("stock = #{record.stock,jdbcType=INTEGER}");
        }
        
        if (record.getSaleAmount() != null) {
            sql.SET("sale_amount = #{record.saleAmount,jdbcType=INTEGER}");
        }
        
        if (record.getVirtualSaleAmount() != null) {
            sql.SET("virtual_sale_amount = #{record.virtualSaleAmount,jdbcType=INTEGER}");
        }
        
        if (record.getTotalSaleAmount() != null) {
            sql.SET("total_sale_amount = #{record.totalSaleAmount,jdbcType=INTEGER}");
        }
        
        if (record.getCategoryId() != null) {
            sql.SET("category_id = #{record.categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getVerifyTimes() != null) {
            sql.SET("verify_times = #{record.verifyTimes,jdbcType=INTEGER}");
        }
        
        if (record.getVerifyStartTime() != null) {
            sql.SET("verify_start_time = #{record.verifyStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyEndTime() != null) {
            sql.SET("verify_end_time = #{record.verifyEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSorting() != null) {
            sql.SET("sorting = #{record.sorting,jdbcType=INTEGER}");
        }
        
        if (record.getLikeSorting() != null) {
            sql.SET("like_sorting = #{record.likeSorting,jdbcType=INTEGER}");
        }
        
        if (record.getLimitTimes() != null) {
            sql.SET("limit_times = #{record.limitTimes,jdbcType=INTEGER}");
        }
        
        if (record.getPicUrl() != null) {
            sql.SET("pic_url = #{record.picUrl,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_good");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("code = #{record.code,jdbcType=VARCHAR}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("short_detail = #{record.shortDetail,jdbcType=VARCHAR}");
        sql.SET("pre_price = #{record.prePrice,jdbcType=DECIMAL}");
        sql.SET("price = #{record.price,jdbcType=DECIMAL}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("stock = #{record.stock,jdbcType=INTEGER}");
        sql.SET("sale_amount = #{record.saleAmount,jdbcType=INTEGER}");
        sql.SET("virtual_sale_amount = #{record.virtualSaleAmount,jdbcType=INTEGER}");
        sql.SET("total_sale_amount = #{record.totalSaleAmount,jdbcType=INTEGER}");
        sql.SET("category_id = #{record.categoryId,jdbcType=INTEGER}");
        sql.SET("verify_times = #{record.verifyTimes,jdbcType=INTEGER}");
        sql.SET("verify_start_time = #{record.verifyStartTime,jdbcType=TIMESTAMP}");
        sql.SET("verify_end_time = #{record.verifyEndTime,jdbcType=TIMESTAMP}");
        sql.SET("sorting = #{record.sorting,jdbcType=INTEGER}");
        sql.SET("like_sorting = #{record.likeSorting,jdbcType=INTEGER}");
        sql.SET("limit_times = #{record.limitTimes,jdbcType=INTEGER}");
        sql.SET("pic_url = #{record.picUrl,jdbcType=LONGVARCHAR}");
        
        OpenStoreGoodExample example = (OpenStoreGoodExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_good");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("code = #{record.code,jdbcType=VARCHAR}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("short_detail = #{record.shortDetail,jdbcType=VARCHAR}");
        sql.SET("pre_price = #{record.prePrice,jdbcType=DECIMAL}");
        sql.SET("price = #{record.price,jdbcType=DECIMAL}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("stock = #{record.stock,jdbcType=INTEGER}");
        sql.SET("sale_amount = #{record.saleAmount,jdbcType=INTEGER}");
        sql.SET("virtual_sale_amount = #{record.virtualSaleAmount,jdbcType=INTEGER}");
        sql.SET("total_sale_amount = #{record.totalSaleAmount,jdbcType=INTEGER}");
        sql.SET("category_id = #{record.categoryId,jdbcType=INTEGER}");
        sql.SET("verify_times = #{record.verifyTimes,jdbcType=INTEGER}");
        sql.SET("verify_start_time = #{record.verifyStartTime,jdbcType=TIMESTAMP}");
        sql.SET("verify_end_time = #{record.verifyEndTime,jdbcType=TIMESTAMP}");
        sql.SET("sorting = #{record.sorting,jdbcType=INTEGER}");
        sql.SET("like_sorting = #{record.likeSorting,jdbcType=INTEGER}");
        sql.SET("limit_times = #{record.limitTimes,jdbcType=INTEGER}");
        
        OpenStoreGoodExample example = (OpenStoreGoodExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenStoreGood record) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_good");
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getShortDetail() != null) {
            sql.SET("short_detail = #{shortDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getPrePrice() != null) {
            sql.SET("pre_price = #{prePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStock() != null) {
            sql.SET("stock = #{stock,jdbcType=INTEGER}");
        }
        
        if (record.getSaleAmount() != null) {
            sql.SET("sale_amount = #{saleAmount,jdbcType=INTEGER}");
        }
        
        if (record.getVirtualSaleAmount() != null) {
            sql.SET("virtual_sale_amount = #{virtualSaleAmount,jdbcType=INTEGER}");
        }
        
        if (record.getTotalSaleAmount() != null) {
            sql.SET("total_sale_amount = #{totalSaleAmount,jdbcType=INTEGER}");
        }
        
        if (record.getCategoryId() != null) {
            sql.SET("category_id = #{categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getVerifyTimes() != null) {
            sql.SET("verify_times = #{verifyTimes,jdbcType=INTEGER}");
        }
        
        if (record.getVerifyStartTime() != null) {
            sql.SET("verify_start_time = #{verifyStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyEndTime() != null) {
            sql.SET("verify_end_time = #{verifyEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSorting() != null) {
            sql.SET("sorting = #{sorting,jdbcType=INTEGER}");
        }
        
        if (record.getLikeSorting() != null) {
            sql.SET("like_sorting = #{likeSorting,jdbcType=INTEGER}");
        }
        
        if (record.getLimitTimes() != null) {
            sql.SET("limit_times = #{limitTimes,jdbcType=INTEGER}");
        }
        
        if (record.getPicUrl() != null) {
            sql.SET("pic_url = #{picUrl,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenStoreGoodExample example, boolean includeExamplePhrase) {
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