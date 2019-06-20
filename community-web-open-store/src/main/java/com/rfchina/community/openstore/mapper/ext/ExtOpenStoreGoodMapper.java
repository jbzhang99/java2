package com.rfchina.community.openstore.mapper.ext;

import com.rfchina.community.openstore.entity.SearchGoodBean;
import com.rfchina.community.openstore.entity.ext.ExtOpenStoreGood;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

/**
 */
public interface ExtOpenStoreGoodMapper {

	@SelectProvider(type = ExtOpenStoreGoodSqlProvider.class, method = "pageByCondition")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "service_id", property = "serviceId", jdbcType = JdbcType.INTEGER),
			@Result(column = "code", property = "code", jdbcType = JdbcType.VARCHAR),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "pre_price", property = "prePrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "price", property = "price", jdbcType = JdbcType.DECIMAL),
			@Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "pic_url", property = "picUrl", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "stock", property = "stock", jdbcType = JdbcType.INTEGER),
			@Result(column = "sale_amount", property = "saleAmount", jdbcType = JdbcType.INTEGER),
			@Result(column = "total_sale_amount", property = "totalSaleAmount", jdbcType = JdbcType.INTEGER),
			@Result(column = "premium_num", property = "premiumNum", jdbcType = JdbcType.INTEGER) })
	public List<ExtOpenStoreGood> pageByCondition(Map<String, Object> param);

	@UpdateProvider(type = ExtOpenStoreGoodSqlProvider.class, method = "reduceGoodStock")
	public int reduceGoodStock(Map<String, Object> param);

	@UpdateProvider(type = ExtOpenStoreGoodSqlProvider.class, method = "reduceGroupStock")
	public int reduceGroupStock(Map<String, Object> param);

	@SelectProvider(type = ExtOpenStoreGoodSqlProvider.class, method = "searchGood")
	@Results({ @Result(column = "good_id", property = "goodId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "service_id", property = "serviceId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "service_title", property = "serviceTitle", jdbcType = JdbcType.VARCHAR),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "short_detail", property = "shortDetail", jdbcType = JdbcType.VARCHAR),
			@Result(column = "price", property = "price", jdbcType = JdbcType.DECIMAL),
			@Result(column = "pre_price", property = "prePrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "pic_url", property = "picUrl", jdbcType = JdbcType.VARCHAR),
			@Result(column = "total_sale_amount", property = "totalSaleAmount", jdbcType = JdbcType.INTEGER),
			@Result(column = "category_id", property = "categoryId", jdbcType = JdbcType.INTEGER),
	})
	public List<SearchGoodBean> searchGood(Map<String, Object> param);


	@SelectProvider(type = ExtOpenStoreGoodSqlProvider.class, method = "listRecommendGood")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "service_id", property = "serviceId", jdbcType = JdbcType.INTEGER),
			@Result(column = "code", property = "code", jdbcType = JdbcType.VARCHAR),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "pre_price", property = "prePrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "price", property = "price", jdbcType = JdbcType.DECIMAL),
			@Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "pic_url", property = "picUrl", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "show_pic", property = "showUrl", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "is_use_main_pic", property = "isUseMainPic", jdbcType = JdbcType.INTEGER),
			@Result(column = "total_sale_amount", property = "totalSaleAmount", jdbcType = JdbcType.INTEGER),
			@Result(column = "stock", property = "stock", jdbcType = JdbcType.INTEGER),
			@Result(column = "groupStatus", property = "groupStatus", jdbcType = JdbcType.INTEGER),
	        @Result(column = "group_price", property = "groupPrice", jdbcType = JdbcType.INTEGER) })
	public List<ExtOpenStoreGood> listRecommendGood(Map<String, Object> param);
}
