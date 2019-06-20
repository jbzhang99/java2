package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.OpenMiniAdInfoSqlProvider;

import java.util.Map;

public class ExtOpenMiniAdInfoSqlProvider extends OpenMiniAdInfoSqlProvider {

	public String pageByCondition(Map<String, Object> param){
        StringBuffer sql = new StringBuffer(" select * from open_mini_ad_info where 1=1");
        if(param.get("title") != null) {
            sql.append(" and title like #{title} ");
        }
        if(param.get("status") != null) {
            sql.append(" and status = #{status} ");
        }
        if(param.get("style") != null) {
            sql.append(" and style = #{style} ");
        }
        if(param.get("communityId") != null) {
            sql.append(" and id in(select ad_id from open_mini_ad_community_rela where community_id=#{communityId} ) ");
        }
        sql.append(" order by id desc");
        
        return sql.toString();
	}

    public String getCommunityList(Map<String, Object> param){
        StringBuffer sql = new StringBuffer(" select id, name from open_mini_ad_community_rela rela, community c where rela.community_id=c.id and rela.ad_id=#{infoId,jdbcType=BIGINT} ");
        return sql.toString();
    }

    public String getMiniInfoListByCommunity(Map<String, Object> param){
        StringBuffer sql = new StringBuffer(" select c.* from open_mini_ad_community_rela rela, open_mini_ad_info c where rela.ad_id=c.id and rela.community_id=#{communityId} order by c.sorting, c.id desc ");
        return sql.toString();
    }

    public String getRecentlyCommunity(Map<String, Object> param){
        StringBuffer sql = new StringBuffer(" select  id, name, city_id, city_name, ");
        sql.append("  ROUND(6378.138*2*ASIN(SQRT(POW(SIN((#{latitude,jdbcType=DOUBLE} *PI()/180-c.latitude*PI()/180)/2),2)+COS(#{latitude,jdbcType=DOUBLE} *PI()/180)*COS(c.latitude*PI()/180)*POW(SIN((#{longitude,jdbcType=DOUBLE} *PI()/180-c.longitude*PI()/180)/2),2)))*1000) AS distance ");
        sql.append(" FROM community as c WHERE c.status = 1 and c.category=1 order by distance limit 1");
        return sql.toString();
    }

}
