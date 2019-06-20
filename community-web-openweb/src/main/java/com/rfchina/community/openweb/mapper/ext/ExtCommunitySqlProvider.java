package com.rfchina.community.openweb.mapper.ext;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.rfchina.community.persistence.mapper.CommunitySqlProvider;
import com.rfchina.community.persistence.model.CommunityExample;

/**
 */
public class ExtCommunitySqlProvider extends CommunitySqlProvider {

    public String pageByExample(Map<String, Object> param) {
        CommunityExample example = (CommunityExample)param.get("example");
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("name");
        sql.SELECT("phone");
        sql.SELECT("tel");
        sql.SELECT("area_id");
        sql.SELECT("address");
        sql.SELECT("intro");
        sql.SELECT("status");
        sql.SELECT("qrcode_url");
        sql.SELECT("longitude");
        sql.SELECT("latitude");
        sql.SELECT("admin_id");
        sql.SELECT("type");
        sql.SELECT("logo_url");
        sql.SELECT("background_url");
        sql.SELECT("topic_audit");
        sql.SELECT("create_time");
        sql.SELECT("cid");
        sql.FROM("community");
        applyWhere(sql, example, true);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }
    
    
    
    public String pageByCondition(Map<String, Object> param){
    	StringBuffer sb = new StringBuffer("select t.* from community t left join (select d.*,a.username from community_admin d join rf_passport a on d.passport_id=a.id) b on t.admin_id=b.id where 1=1 ");
    	
    	if(param.get("id") != null){
    		sb.append(" and t.admin_id = #{id,jdbcType=BIGINT}");
    	}
    	
    	if(param.get("communityName") != null){
    		sb.append(" and t.name like #{communityName,jdbcType=VARCHAR}");
    	}
    	
    	if(param.get("phone") != null){
    		sb.append(" and b.phone like #{phone , jdbcType=VARCHAR}");
    	}
    	
    	if(param.get("username") != null){
    		sb.append(" and b.username like #{username , jdbcType=VARCHAR}");
    	}
    	
    	return sb.toString();
    }

}
