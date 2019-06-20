package com.rfchina.community.openweb.mapper.ext;

import com.rfchina.community.persistence.mapper.OpenStoreGoodSqlProvider;

import java.util.Map;

/**
 */
public class ExtOpenStoreGoodSqlProvider extends OpenStoreGoodSqlProvider {
	public String pageByCondition(Map<String, Object> param){
		StringBuffer sb = new StringBuffer("select IFNULL(_re.status,0) recommend, osg.sorting,osg.id,osg.service_id, osg.code, osg.name, osg.pre_price, osg.price, osg.status, osg.create_time, osg.pic_url, osg.stock, osg.sale_amount, osst.premium_num from open_store_good osg "+
				" left join open_store_service_templete osst on osst.service_id = osg.service_id "
				+ " left join open_store_good_recommend _re on osg.id=_re.good_id"
				+" where 1=1 ");
		if(param.get("serviceId") != null){
			sb.append(" and osg.service_id = #{serviceId}");
		}
		if(param.get("startCreateDate") != null){
			sb.append(" and osg.create_time >= #{startCreateDate}");
		}
		
		if(param.get("endCreateDate") != null){
			sb.append(" and osg.create_time <= #{endCreateDate}");
		}
		
		if(param.get("status") != null){
			sb.append(" and osg.status = #{status}");
		}else {
			sb.append(" and osg.status <> 3");//除了删除的
		}
		
		if(param.get("name") != null){
			sb.append(" and osg.name like #{name}");
		}
		if(param.get("code") != null){
			sb.append(" and osg.code like #{code}");
		}

		Integer recommendStatus = (Integer)param.get("recommendStatus");
		if(recommendStatus != null){
			if(recommendStatus == 1){
				sb.append(" and _re.status = 1");
			}else{
				sb.append(" and (_re.status = 0 or _re.status is null)");
			}

		}

		if(param.get("showCategoryId") != null){
			sb.append(" and osg.id in (select good_id from open_category_good_rel where show_category_id=#{showCategoryId})");
		}
		
		sb.append(" order by osg.id desc");
		
		return sb.toString();
	}
}
