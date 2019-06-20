package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysDataUpload;
import com.rfchina.community.persistence.model.SysDataUploadExample.Criteria;
import com.rfchina.community.persistence.model.SysDataUploadExample.Criterion;
import com.rfchina.community.persistence.model.SysDataUploadExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysDataUploadSqlProvider {

    public String countByExample(SysDataUploadExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_data_upload");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysDataUploadExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_data_upload");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysDataUpload record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_data_upload");
        
        if (record.getSrcLink() != null) {
            sql.VALUES("src_link", "#{srcLink,jdbcType=VARCHAR}");
        }
        
        if (record.getDownLink() != null) {
            sql.VALUES("down_link", "#{downLink,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUid() != null) {
            sql.VALUES("create_uid", "#{createUid,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getMasterId() != null) {
            sql.VALUES("master_id", "#{masterId,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getXlsxIndex() != null) {
            sql.VALUES("xlsx_index", "#{xlsxIndex,jdbcType=INTEGER}");
        }
        
        if (record.getUserPath() != null) {
            sql.VALUES("user_path", "#{userPath,jdbcType=VARCHAR}");
        }
        
        if (record.getFileName() != null) {
            sql.VALUES("file_name", "#{fileName,jdbcType=VARCHAR}");
        }
        
        if (record.getTestRun() != null) {
            sql.VALUES("test_run", "#{testRun,jdbcType=INTEGER}");
        }
        
        if (record.getError() != null) {
            sql.VALUES("error", "#{error,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(SysDataUploadExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("src_link");
        sql.SELECT("down_link");
        sql.SELECT("create_time");
        sql.SELECT("create_uid");
        sql.SELECT("community_id");
        sql.SELECT("master_id");
        sql.SELECT("status");
        sql.SELECT("xlsx_index");
        sql.SELECT("user_path");
        sql.SELECT("file_name");
        sql.SELECT("test_run");
        sql.SELECT("error");
        sql.FROM("sys_data_upload");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(SysDataUploadExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("src_link");
        sql.SELECT("down_link");
        sql.SELECT("create_time");
        sql.SELECT("create_uid");
        sql.SELECT("community_id");
        sql.SELECT("master_id");
        sql.SELECT("status");
        sql.SELECT("xlsx_index");
        sql.SELECT("user_path");
        sql.SELECT("file_name");
        sql.SELECT("test_run");
        sql.FROM("sys_data_upload");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysDataUpload record = (SysDataUpload) parameter.get("record");
        SysDataUploadExample example = (SysDataUploadExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_data_upload");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getSrcLink() != null) {
            sql.SET("src_link = #{record.srcLink,jdbcType=VARCHAR}");
        }
        
        if (record.getDownLink() != null) {
            sql.SET("down_link = #{record.downLink,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getMasterId() != null) {
            sql.SET("master_id = #{record.masterId,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getXlsxIndex() != null) {
            sql.SET("xlsx_index = #{record.xlsxIndex,jdbcType=INTEGER}");
        }
        
        if (record.getUserPath() != null) {
            sql.SET("user_path = #{record.userPath,jdbcType=VARCHAR}");
        }
        
        if (record.getFileName() != null) {
            sql.SET("file_name = #{record.fileName,jdbcType=VARCHAR}");
        }
        
        if (record.getTestRun() != null) {
            sql.SET("test_run = #{record.testRun,jdbcType=INTEGER}");
        }
        
        if (record.getError() != null) {
            sql.SET("error = #{record.error,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_data_upload");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("src_link = #{record.srcLink,jdbcType=VARCHAR}");
        sql.SET("down_link = #{record.downLink,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("master_id = #{record.masterId,jdbcType=BIGINT}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("xlsx_index = #{record.xlsxIndex,jdbcType=INTEGER}");
        sql.SET("user_path = #{record.userPath,jdbcType=VARCHAR}");
        sql.SET("file_name = #{record.fileName,jdbcType=VARCHAR}");
        sql.SET("test_run = #{record.testRun,jdbcType=INTEGER}");
        sql.SET("error = #{record.error,jdbcType=LONGVARCHAR}");
        
        SysDataUploadExample example = (SysDataUploadExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_data_upload");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("src_link = #{record.srcLink,jdbcType=VARCHAR}");
        sql.SET("down_link = #{record.downLink,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("master_id = #{record.masterId,jdbcType=BIGINT}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("xlsx_index = #{record.xlsxIndex,jdbcType=INTEGER}");
        sql.SET("user_path = #{record.userPath,jdbcType=VARCHAR}");
        sql.SET("file_name = #{record.fileName,jdbcType=VARCHAR}");
        sql.SET("test_run = #{record.testRun,jdbcType=INTEGER}");
        
        SysDataUploadExample example = (SysDataUploadExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysDataUpload record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_data_upload");
        
        if (record.getSrcLink() != null) {
            sql.SET("src_link = #{srcLink,jdbcType=VARCHAR}");
        }
        
        if (record.getDownLink() != null) {
            sql.SET("down_link = #{downLink,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{createUid,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getMasterId() != null) {
            sql.SET("master_id = #{masterId,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getXlsxIndex() != null) {
            sql.SET("xlsx_index = #{xlsxIndex,jdbcType=INTEGER}");
        }
        
        if (record.getUserPath() != null) {
            sql.SET("user_path = #{userPath,jdbcType=VARCHAR}");
        }
        
        if (record.getFileName() != null) {
            sql.SET("file_name = #{fileName,jdbcType=VARCHAR}");
        }
        
        if (record.getTestRun() != null) {
            sql.SET("test_run = #{testRun,jdbcType=INTEGER}");
        }
        
        if (record.getError() != null) {
            sql.SET("error = #{error,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysDataUploadExample example, boolean includeExamplePhrase) {
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