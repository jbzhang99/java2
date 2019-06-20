package com.rfchina.community.open.bridge.mapper.ext;

import com.rfchina.community.open.bridge.entity.ExtOpenStoreGood;
import com.rfchina.community.open.bridge.entity.SimOpenStoreGood;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.Map;

/**
 */
public interface ExtOpenStoreGoodMapper {

	 	@SelectProvider(type=ExtOpenStoreGoodSqlProvider.class, method="pageByCondition")
	    @Results({
	        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
	        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
	        @Result(column="category_name", property="categoryName", jdbcType=JdbcType.VARCHAR),
	        @Result(column="store_name", property="storeName", jdbcType=JdbcType.VARCHAR),
	        @Result(column="merchant_name", property="merchantName", jdbcType=JdbcType.VARCHAR),
	        @Result(column="pre_price", property="prePrice", jdbcType=JdbcType.DECIMAL),
	        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
	        @Result(column="sale_amount", property="saleAmount", jdbcType=JdbcType.INTEGER),
			@Result(column="virtual_sale_amount", property="virtualSaleAmount", jdbcType=JdbcType.INTEGER),
			@Result(column="total_sale_amount", property="totalSaleAmount", jdbcType=JdbcType.INTEGER),
	        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
	        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.LONGVARCHAR),
			@Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),

			@Result(column="commentNum", property="commentNum", jdbcType=JdbcType.INTEGER),
			@Result(column="goodCommentNum", property="goodCommentNum", jdbcType=JdbcType.INTEGER),
			@Result(column="middleCommentNum", property="middleCommentNum", jdbcType=JdbcType.INTEGER),
			@Result(column="badCommentNum", property="badCommentNum", jdbcType=JdbcType.INTEGER),
			@Result(column="like_sorting", property="likeSorting", jdbcType=JdbcType.INTEGER),
			@Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER)

	    })
	 	public PageList<ExtOpenStoreGood> pageByCondition(Map<String, Object> param, PageBounds pageBounds);

	 	
	 	@SelectProvider(type=ExtOpenStoreGoodSqlProvider.class, method="listStoreGoodByCondition")
	    @Results({
	        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
	        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
	        @Result(column="sale_amount", property="saleAmount", jdbcType=JdbcType.INTEGER),
	        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
	    })
		public PageList<SimOpenStoreGood> listStoreGoodByCondition(Map<String, Object> param, PageBounds pageBounds);
}
