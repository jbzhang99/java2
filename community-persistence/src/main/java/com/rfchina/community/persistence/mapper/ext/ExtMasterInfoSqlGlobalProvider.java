package com.rfchina.community.persistence.mapper.ext;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.rfchina.community.persistence.mapper.MasterInfoSqlProvider;
import com.rfchina.community.persistence.model.MasterInfoExample;

public class ExtMasterInfoSqlGlobalProvider extends MasterInfoSqlProvider {

	public String selectByExampleSelective(MasterInfoExample example) {
		SQL sql = new SQL();
		sql.SELECT("id");
		sql.SELECT("area_id");
		sql.SELECT("community_id");
		sql.SELECT("floor");
		sql.SELECT("room");
		sql.SELECT("title");
		sql.SELECT("address");
		sql.SELECT("tel");
		sql.SELECT("status");
		sql.SELECT("charge_name");
		sql.SELECT("charge_phone");

		sql.FROM("master_info");
		// applyWhere(sql, example, false);

		if (example != null && example.getOrderByClause() != null) {
			sql.ORDER_BY(example.getOrderByClause());
		}

		return sql.toString();
	}

	public String pageByExample(Map<String, Object> param) {

		MasterInfoExample example = (MasterInfoExample) param.get("example");
		SQL sql = new SQL();
		if (example != null && example.isDistinct()) {
			sql.SELECT_DISTINCT("id");
		} else {
			sql.SELECT("id");
		}
		sql.SELECT("area_id");
		sql.SELECT("community_id");
		sql.SELECT("floor");
		sql.SELECT("room");
		sql.SELECT("title");
		sql.SELECT("address");
		sql.SELECT("tel");
		sql.SELECT("status");
		sql.SELECT("charge_name");
		sql.SELECT("charge_phone");
		sql.FROM("master_info");
		applyWhere(sql, example, true);

		if (example != null && example.getOrderByClause() != null) {
			sql.ORDER_BY(example.getOrderByClause());
		}

		return sql.toString();
	}

	/**
	 * app-api显示的有效的主信息
	 * 
	 * @param param
	 * @return
	 */
	public String pageByMasterInfoValid(Map<String, Object> param) {

		String sql = "SELECT 	m.* FROM master_info m LEFT JOIN visit_community_master v ON m.id = v.master_id WHERE  v.can_visit=1 ";

		if (param.get("title") != null && StringUtils.isNotBlank(param.get("title").toString())) {
			sql += " and m.title like #{title, jdbcType=VARCHAR}";
		}


		if (param.get("status") != null  ) {
			sql += " and m.status = #{status, jdbcType=TINYINT}";
		}
		if (param.get("community_id") != null  ) {
			sql += " and m.community_id = #{community_id, jdbcType=INTEGER}";
		}
		return sql;
	}

	public String selectByCondition(Map<String, Object> param) {
		StringBuilder sqlBuilder = new StringBuilder(" select a.id, a.community_id, a.room, a.loudong, a.floor, a.type, a.title, "
				+ " b.phone as charge_phone, b.name as charge_name, c.name as community_name "
				+ " from master_info a join master_child b on a.id = b.master_id "
				+ " join community c on a.community_id = c.id "
				+ " join community_service_rela r on c.id=r.community_id and r.service_id=#{serviceId, jdbcType=INTEGER} where 1=1 ");
		sqlBuilder.append(" and b.uid = #{uid, jdbcType=BIGINT} ");
		sqlBuilder.append(" and a.status = #{infoStatus, jdbcType=INTEGER} ");
		sqlBuilder.append(" and b.status = #{childStatus, jdbcType=INTEGER} ");
		sqlBuilder.append(" and c.status = #{communityStatus, jdbcType=INTEGER} ");
		Integer communityId = MapUtils.getInteger(param, "communityId", 0);
		if(null!= communityId & 0 != communityId) {
			sqlBuilder.append(" and a.community_id = #{communityId, jdbcType=INTEGER} ");
		}
		return sqlBuilder.toString();
	}

	public String selectPropAddrCertRoomList(Map<String, Object> param) {
		StringBuilder sqlBuilder = new StringBuilder(" select a.id, a.community_id, a.room, a.loudong, a.floor, a.type, "
				+ " c.name as community_name "
				+ " from master_info a "
				+ " join master_child b on a.id = b.master_id "
				+ " AND a.community_id = b.community_id "
				+ " join community c on a.community_id = c.id where 1=1 ");
		sqlBuilder.append(" and b.uid = #{uid, jdbcType=BIGINT} ");
		sqlBuilder.append(" and a.status = #{infoStatus, jdbcType=INTEGER} ");
		sqlBuilder.append(" and b.status = #{childStatus, jdbcType=INTEGER} ");
		sqlBuilder.append(" and c.status = #{communityStatus, jdbcType=INTEGER} ");
		Integer[] communityIds = (Integer[])MapUtils.getObject(param, "communityIds", 0);
		if(null != communityIds && 0 != communityIds.length) {
			sqlBuilder.append(" and a.community_id in (" + StringUtils.join(communityIds, ",") + ") ");
		}
		return sqlBuilder.toString();
	}

	public String selectPropAddrBindRoomList(Map<String, Object> param) {
		StringBuilder sqlBuilder = new StringBuilder(" select a.id, a.community_id, a.room, a.loudong, a.floor, a.type, "
				+ " c.name as community_name "
				+ " from master_info a "
				+ " join master_child b on a.id = b.master_id "
				+ " AND a.community_id = b.community_id "
				+ " join prop_addr_bind m on a.id = m.master_id "
				+ " and a.community_id = m.community_id "
				+ " join community c on a.community_id = c.id where 1=1 ");
		sqlBuilder.append(" and b.uid = #{uid, jdbcType=BIGINT} ");
		sqlBuilder.append(" and a.status = #{infoStatus, jdbcType=INTEGER} ");
		sqlBuilder.append(" and b.status = #{childStatus, jdbcType=INTEGER} ");
		sqlBuilder.append(" and c.status = #{communityStatus, jdbcType=INTEGER} ");
		Integer[] communityIds = (Integer[])MapUtils.getObject(param, "communityIds", 0);
		if(null != communityIds && 0 != communityIds.length) {
			sqlBuilder.append(" and a.community_id in (" + StringUtils.join(communityIds, ",") + ") ");
		}
		return sqlBuilder.toString();
	}
}