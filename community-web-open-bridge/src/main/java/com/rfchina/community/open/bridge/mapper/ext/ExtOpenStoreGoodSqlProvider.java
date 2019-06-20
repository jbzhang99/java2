package com.rfchina.community.open.bridge.mapper.ext;

import com.rfchina.community.persistence.mapper.OpenStoreGoodSqlProvider;

import java.util.Map;

/**
 */
public class ExtOpenStoreGoodSqlProvider extends OpenStoreGoodSqlProvider {
	public String pageByCondition(Map<String, Object> param){
		StringBuffer sb = new StringBuffer(""
				+" SELECT _good.id,_service.id service_id , _good.NAME,_service.title store_name,_info.title merchant_name,_good.pre_price,"
				+" _category.name category_name, _good.price,_good.sale_amount,_good.create_time,_good.status , _good.category_id, _good.sorting, "
				+"  sum(CASE WHEN _comment.id is null THEN 0 ELSE 1 END) as commentNum, "
				+"  sum(CASE WHEN _comment.goods_grade =4 or goods_grade=5 THEN 1 ELSE 0 END) as goodCommentNum,"
				+"  sum(CASE WHEN _comment.goods_grade =3 THEN 1 ELSE 0 END) as middleCommentNum,"
				+"  sum(CASE WHEN _comment.goods_grade =1 or goods_grade=2 THEN 1 ELSE 0 END) as badCommentNum,"
				+" _good.virtual_sale_amount, _good.total_sale_amount, _good.like_sorting "
				+" FROM open_store_good _good LEFT JOIN community_service _service ON _service.id = _good.service_id "
				+" LEFT JOIN open_merchant_info _info ON _info.id = _service.merchant_id LEFT JOIN community_service_category _category on _category.id=_good.category_id "
				+" LEFT JOIN user_comment _comment ON (_good.id = _comment.comment_target and _comment.status <> '-1')"
				+" WHERE 1=1");
		
		if(param.get("name") != null){
			sb.append(" and _good.name like #{name}");
		}
		if(param.get("storeName") != null){
			sb.append(" and _service.title like #{storeName}");
		}
		if(param.get("merchantName") != null){
			sb.append(" and _info.title like #{merchantName}");
		}
		
		if(param.get("categoryId") != null){
			sb.append(" and _good.category_id = #{categoryId}");
		}
		
		if(param.get("status") != null){
			sb.append(" and _good.status = #{status}");
		}else {
			sb.append(" and _good.status <> 3");//除了删除的
		}
		
		sb.append(" GROUP BY _good.id order by _good.id desc ");
		
		return sb.toString();
	}
	
	public String listStoreGoodByCondition(Map<String, Object> param){
		StringBuffer sb = new StringBuffer("select _good.id, _good.service_id, _good.name,_good.price, _good.sale_amount,_good.sorting from open_store_good _good LEFT JOIN community_service _service "
				+ "	on _good.service_id=_service.id where _good.status=1 and _service.status=1");
		
		if(param.get("goodName") != null){
			sb.append(" and _good.name like #{goodName}");
		}
		if(param.get("serviceId") != null){
			sb.append(" and _good.service_id= #{serviceId}");
		}
	
		sb.append(" order by _good.id desc");
		
		return sb.toString();
	}
}
