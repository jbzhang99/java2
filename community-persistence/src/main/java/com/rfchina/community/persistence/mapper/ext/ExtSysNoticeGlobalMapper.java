package com.rfchina.community.persistence.mapper.ext;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.rfchina.community.persistence.model.SysNotice;

public interface ExtSysNoticeGlobalMapper extends Serializable {

	@Select({"<script><![CDATA[ select * from sys_notice n left join sys_notice_read r on n.id=r.notice_id where 1=1 ${sql} ]]>",
			"<if test=\"createTime != null \"><![CDATA[ and n.create_time >= #{createTime} ]]></if> ",
			"<![CDATA[ order by n.id desc limit #{limit} , #{offset} ]]></script>"})
	@Results({@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "create_platform", property = "createPlatform", jdbcType = JdbcType.INTEGER),
			@Result(column = "create_comm", property = "createComm", jdbcType = JdbcType.INTEGER),
			@Result(column = "create_id", property = "createId", jdbcType = JdbcType.BIGINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
			@Result(column = "platform_uid", property = "platformUid", jdbcType = JdbcType.BIGINT),
			@Result(column = "comm_uid", property = "commUid", jdbcType = JdbcType.BIGINT),
			@Result(column = "master_uid", property = "masterUid", jdbcType = JdbcType.BIGINT),
			@Result(column = "seller_uid", property = "sellerUid", jdbcType = JdbcType.BIGINT),
			@Result(column = "content", property = "content", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "read_time", property = "readTime", jdbcType = JdbcType.TIMESTAMP)})
	SysNotice selectByPrimaryKey(@Param("sql") String sql, @Param("createTime") Date createTime, @Param("limit") int limit, @Param("offset") int offset);

	@Select({
			"select count(*) from sys_notice n left join sys_notice_read r on n.id=r.notice_id and r.admin_uid=${uid} where n.create_time>=#{createTime,jdbcType=TIMESTAMP} and n.status=1 and r.admin_uid is null ${sql}"})
	Long unReadSysNoticeCount(@Param("uid") Long uid,@Param("createTime") Date createTime,@Param("sql") String sql);
}