package com.rfchina.community.brothers.mapper.ext;

import com.rfchina.community.persistence.model.PayConfirmRecord;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 */
public interface ExtPayConfirmRecordMapper {

	@Select("select * from pay_confirm_record where scan_status = 0 and type=1 limit #{limit}")
	@Results({
			@Result(column="bill_id", property="billId", jdbcType= JdbcType.VARCHAR, id=true),
			@Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
			@Result(column="scan_status", property="scanStatus", jdbcType=JdbcType.INTEGER),
			@Result(column="result_status", property="resultStatus", jdbcType=JdbcType.INTEGER),
			@Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
			@Result(column="scan_time", property="scanTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
	})
	List<PayConfirmRecord> getPayConfirmRecordList(int limit);
}
