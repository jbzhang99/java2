package com.rfchina.community.openstore.mapper.ext;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.openstore.service.OpenRefundService;
import com.rfchina.community.persistence.mapper.OpenStoreGoodSqlProvider;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 */
public class ExtOpenStoreGoodSqlProvider extends OpenStoreGoodSqlProvider {


	private static Logger logger = LoggerFactory.getLogger(OpenRefundService.class);
	public String pageByCondition(Map<String, Object> param) {
		StringBuilder sb = new StringBuilder(
				"select osg.total_sale_amount,osg.id,osg.service_id, osg.code, osg.name, osg.pre_price, osg.price, osg.status, osg.create_time, osg.pic_url, osg.stock, osst.premium_num from open_store_good osg "
						+ " left join open_store_service_templete osst on osst.service_id = osg.service_id "
                        +" LEFT JOIN open_store_good_group_info _group_info ON (_group_info.good_id = osg.id and _group_info. STATUS = 1 AND _group_info.end_time > now() and _group_info.start_time < now()) "
						+ " where 1=1 ");
		if (param.get("serviceId") != null) {
			sb.append(" and osg.service_id = #{serviceId}");
		}
		if (param.get("keyword") != null) {
			sb.append(" and osg.name like  #{keyword, jdbcType=VARCHAR} ");
		}
		if(param.get("showCategoryId") != null){
			sb.append(" and osg.id  in(select good_id from open_category_good_rel where show_category_id=#{showCategoryId})");
		}
		sb.append(" and osg.status = 1");// 上架的

		//排序
		String type = (String)param.get("type");
		sb.append(" order by _group_info.id desc, ");
		if(OpenConstant.OpenStoreGoodSortType.GENERAL.getCode().equals(type)){
			sb.append( "  osg.sorting,osg.total_sale_amount desc");
		}else if(OpenConstant.OpenStoreGoodSortType.FRESH.getCode().equals(type)){
			sb.append( " osg.update_time desc,osg.total_sale_amount desc");
		}else if(OpenConstant.OpenStoreGoodSortType.PRICE.getCode().equals(type)){
			sb.append( "  osg.price");
			String sort = (String)param.get("sort");
			if(OpenConstant.OpenStoreGoodSort.down.equals(sort)){
				sb.append(" desc");
			}
			sb.append(" ,osg.total_sale_amount desc");
		}else{
			sb.append(" osg.total_sale_amount desc");
		}


		return sb.toString();
	}

	public String reduceGoodStock(Map<String, Object> param) {
		StringBuilder sb = new StringBuilder("update open_store_good set stock=stock-#{decNum}");
		sb.append(" where id=#{id}");
		sb.append(" and stock >= #{decNum}");
		return sb.toString();
	}

	public String reduceGroupStock(Map<String, Object> param) {
		StringBuilder sb = new StringBuilder("update open_store_good_group_info set stock=stock-#{decNum}");
		sb.append(" where id=#{groupInfoId}");
		sb.append(" and stock >= #{decNum}");
		return sb.toString();
	}

	public String searchGood(Map<String, Object> param) {

		StringBuilder sqlBuilder = new StringBuilder(" SELECT");
		sqlBuilder.append(
				" _good.total_sale_amount, _service.id service_id, _service.title service_title, _good.id good_id, _good.name, _good.short_detail, _good.pre_price, _good.price, _good.pic_url,_good.category_id ");
		sqlBuilder.append(" FROM ");
		sqlBuilder.append(" open_store_good _good LEFT JOIN community_service _service on _service.id = _good.service_id ");
		sqlBuilder.append(" LEFT JOIN open_store_service_templete _temp on _temp.service_id=_service.id ");
		sqlBuilder.append(" LEFT JOIN open_store_service_discount _dis on _dis.service_id=_service.id ");
        sqlBuilder.append(" LEFT JOIN open_store_good_group_info _group_info ON (_group_info.good_id = _good.id and _group_info. STATUS = 1 AND _group_info.end_time > now() and _group_info.start_time < now()) ");
        sqlBuilder.append(" WHERE ");
		sqlBuilder.append(" _service.status=1 ");
		sqlBuilder.append(" and _good.status=1 ");

		if (StringUtils.isNotBlank(MapUtils.getString(param, "likeKeyWords", ""))) {
			sqlBuilder.append(" and _good.name like #{likeKeyWords, jdbcType=VARCHAR} ");
		}

		Integer category_id = MapUtils.getInteger(param, "category_id", 0);
		if (category_id > 0) {
			sqlBuilder.append(" and _good.category_id = #{category_id} ");
		}

		//满减搜索
		String discountType = MapUtils.getString(param, "discountType", "");
		if(StringUtils.isNotBlank(discountType)){
			if(OpenConstant.OpenStoreDiscountType.FULL_DISCOUNT.getCode().equals(discountType)){
				sqlBuilder.append(" and _dis.valid_status=1 and _dis.discount_money > 0 ");
			}
		}

		//店铺分类
		String openStoreType = MapUtils.getString(param, "openStoreType", "");
		if(StringUtils.isNotBlank(openStoreType)){
			if(OpenConstant.OpenStoreType.FLAG_SHIP.getCode().equals(openStoreType)){
				sqlBuilder.append(" and _temp.flagship=1 ");
			}
		}

		//邮费分类
		String postage = MapUtils.getString(param, "postage", "");
		if(StringUtils.isNotBlank(postage)){
			if(OpenConstant.OpenStorePostage.NO_POSTAGE.getCode().equals(postage)){
				sqlBuilder.append(" and _temp.express_money=0");
			}
		}

		//排序
		String type = (String)param.get("type");
        sqlBuilder.append(" order by _group_info.id desc, ");
		if(OpenConstant.OpenStoreGoodSortType.GENERAL.getCode().equals(type)){
			sqlBuilder.append( "  _good.sorting,_good.total_sale_amount desc");
		}else if(OpenConstant.OpenStoreGoodSortType.FRESH.getCode().equals(type)){
			sqlBuilder.append( "  _good.update_time desc,_good.total_sale_amount desc");
		}else if(OpenConstant.OpenStoreGoodSortType.PRICE.getCode().equals(type)){
			sqlBuilder.append( "  _good.price");
			String sort = (String)param.get("sort");
			if(OpenConstant.OpenStoreGoodSort.down.equals(sort)){
				sqlBuilder.append(" desc");
			}
			sqlBuilder.append(" ,_good.total_sale_amount desc");
		}else{
			sqlBuilder.append("  _good.total_sale_amount desc");
		}


		logger.info(sqlBuilder.toString());
		return sqlBuilder.toString();
	}


	/**
	 * @Author wlrllr
	 * @Description //TODO
	 * @Date 2019/5/30
	 * @Param select _good.id,_good.service_id,_good.code,_good.name,_good.pre_price,_good.price, _good.status,_re.create_time,_good.pic_url,_re.remark,
	 * _re.show_pic,_re.is_use_main_pic,_good.total_sale_amount,_good.stock,_group.status groupStatus,_group.group_price
	 * from open_store_good_recommend _re LEFT JOIN open_store_good _good on _good.id=_re.good_id LEFT JOIN open_store_good_group_info _group ON (_group.good_id = _re.good_id AND _group.STATUS =1 AND start_time<=NOW() AND end_time>Now())
	 * where _re.service_id=413 and _good.status=1 and _re.status=1 GROUP BY _good.id order by _re.sorting,_good.total_sale_amount desc;
	 **/
	public String listRecommendGood() {
		//StringBuilder sb = new StringBuilder("select  *from (select  *from open_store_good_recommend  where service_id=#{serviceId}) _re LEFT JOIN open_store_good _good on _good.id=_re.good_id");
		//sb.append(" where _good.status=1 and _re.status=1 order by _re.sorting,_good.total_sale_amount desc");
		SQL sql = new SQL();
		sql.SELECT("_good.id,_good.service_id,_good.code,_good.name,_good.pre_price,_good.price, _good.status,_good.total_sale_amount,_good.stock,_good.pic_url");
		sql.SELECT("_re.create_time,_re.remark,_re.show_pic,_re.is_use_main_pic");
		sql.SELECT("_group.status groupStatus,_group.group_price");
		sql.FROM("open_store_good_recommend _re");
		sql.LEFT_OUTER_JOIN("open_store_good _good on _good.id=_re.good_id");
		sql.LEFT_OUTER_JOIN("open_store_good_group_info _group ON (_group.good_id = _re.good_id AND _group.STATUS =1 AND start_time<=NOW() AND end_time>Now())");
		sql.WHERE("_re.service_id=#{serviceId} and _good.status=1 and _re.status=1");
		sql.GROUP_BY("_good.id");
		sql.ORDER_BY(" _re.sorting,_good.total_sale_amount desc");
		return sql.toString();
	}

}
