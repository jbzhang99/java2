package com.rfchina.community.openstore.mapper.ext;

import java.util.Map;

import com.rfchina.community.persistence.mapper.OpenStoreShoppingCartSqlProvider;

/**
 */
public class ExtOpenStoreShoppingCartSqlProvider extends OpenStoreShoppingCartSqlProvider {
	
	/**
	 * @author:fukangwen
	 * @Description:获取购物车列表
	 * @return String
	 * @throws
	 */
	public String getOpenStoreCartList(Map<String, Object> param) {
        StringBuilder sqlBuilder = new StringBuilder("select * from open_store_shopping_cart _cart LEFT JOIN open_store_good _good on _good.id=_cart.good_id"
        		+ "	where user_id=#{userId, jdbcType=VARCHAR} and _cart.valid_status=1 and _good.status=1 and stock > 0");
        return sqlBuilder.toString();
    }
	
	/**
	 * @author:fukangwen
	 * @Description:获取购物车数量
	 * @return String
	 * @throws
	 */
	public String getCartNum(Map<String, Object> param) {
		StringBuilder sqlBuilder = new StringBuilder("select count(*) from open_store_shopping_cart _cart LEFT JOIN open_store_good _good on _good.id=_cart.good_id"
				+ "	where user_id=#{userId, jdbcType=VARCHAR} and _cart.valid_status=1 and _good.status=1 and stock > 0");
		return sqlBuilder.toString();
	}
}
