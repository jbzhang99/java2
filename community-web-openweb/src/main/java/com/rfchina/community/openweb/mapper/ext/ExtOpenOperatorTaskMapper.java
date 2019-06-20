package com.rfchina.community.openweb.mapper.ext;

import com.rfchina.community.persistence.model.ext.ExtOperator;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.math.BigDecimal;
import java.util.Map;

/**
 */
public interface ExtOpenOperatorTaskMapper {

	 	@SelectProvider(type=ExtOpenOperatorTaskSqlProvider.class, method="operatorList")
	 	@Results({
				@Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
				@Result(column="emp_guid", property="empGuid", jdbcType=JdbcType.VARCHAR),
				@Result(column="emp_phone", property="empPhone", jdbcType=JdbcType.VARCHAR),
				@Result(column="emp_name", property="empName", jdbcType=JdbcType.VARCHAR),
				@Result(column="task_id", property="taskId", jdbcType=JdbcType.BIGINT),
				@Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
				@Result(column="invalid_time", property="invalidTime", jdbcType=JdbcType.TIMESTAMP),
				@Result(column="valid_status", property="validStatus", jdbcType=JdbcType.INTEGER),
				@Result(column="act_titile", property="actTitile", jdbcType=JdbcType.VARCHAR),
				@Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT),
				@Result(column="release_status", property="releaseStatus", jdbcType=JdbcType.BIGINT),
				@Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
				@Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
				@Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER)
 	    })
	 	public PageList<ExtOperator> operatorList(Map<String, Object> param, PageBounds pageBounds);

		@SelectProvider(type=ExtOpenOperatorTaskSqlProvider.class, method="sumAmount")
		public BigDecimal sumAmount(Map<String, Object> param);

}
