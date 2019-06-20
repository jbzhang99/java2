package com.rfchina.community.persistence.mapper.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.rfchina.community.persistence.mapper.SysMsgInfoMapper;
import com.rfchina.community.persistence.model.ext.ExtSysMsgInfo;

public interface ExtSysMsgInfoGlobalMapper {

	@Select({
			"select m.*,r.is_read,r.admin_uid from sys_msg_info m LEFT JOIN sys_msg_read r on m.id=r.msg_id where r.admin_uid=#{adminUid,jdbcType=BIGINT}  order by m.id desc limit #{limit} , #{offset} "})
	@Results({@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
			@Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
			@Result(column = "object_key", property = "objectKey", jdbcType = JdbcType.VARCHAR),
			@Result(column = "object_type", property = "objectType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "msg_source_type", property = "msgSourceType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "is_read", property = "isRead", jdbcType = JdbcType.INTEGER),
			@Result(column = "admin_uid", property = "adminUid", jdbcType = JdbcType.INTEGER)})

	List<ExtSysMsgInfo> indexList(@Param("adminUid") Long adminUid, @Param("limit") int limit, @Param("offset") int offset);

	@Select({"select count(*) from sys_msg_info m LEFT JOIN sys_msg_read r on m.id=r.msg_id where r.admin_uid=#{adminUid,jdbcType=BIGINT} "})
	Long indexListcount(@Param("adminUid") Long adminUid);

	@Select({"select count(*) from sys_msg_info m LEFT JOIN sys_msg_read r on m.id=r.msg_id where r.is_read=1 and r.admin_uid=#{adminUid,jdbcType=BIGINT} "})
	Long indexListcountUnReadTotal(@Param("adminUid") Long adminUid);

	@Update({"${sql}"})
	void executeDDL(@Param("sql") String sql);

	@Select({"${sql}"})
	Object[] executeQuery(@Param("sql") String sql);
}