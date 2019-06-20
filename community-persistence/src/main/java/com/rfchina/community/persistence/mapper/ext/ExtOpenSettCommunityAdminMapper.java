package com.rfchina.community.persistence.mapper.ext;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

public interface ExtOpenSettCommunityAdminMapper extends Serializable {

	// (`id`, `community_id`, `start_time`, `end_time`, `mch_id`, `account_id`,
	// `status`, `pf_status`, `title`, `create_time`, `amount`, `audit_comment`,
	// `set_id`)
	// 收款账户ID：/支付中心结算单号：/社区/结算状态：/申请日期：
	@Select("<script>select * from open_sett_community where 1=1 "
			+ "<if test=\"account_id != null \"> and  account_id = #{account_id} </if> "
			+ "<if test=\"pf_status != null \"> and  pf_status = #{pf_status} </if> "
			+ "<if test=\"set_id != null \"> and  set_id = #{set_id} </if> "
			+ "<if test=\"title != null \"> and  title like #{title} </if> "
			+ "<if test=\"community_id != null \"> and  community_id = #{community_id} </if> "
			+ "<if test=\"begin_create_time != null \"> and  create_time &gt;= #{begin_create_time} </if> "
			+ "<if test=\"end_create_time != null \"> and  create_time &lt;= #{end_create_time} </if> "
			// 成功发起的结算
			+ "<if test=\"effective_settlement != null \"> and  pf_status > 0 </if> "
			// 排序
			+ " order by id desc </script>")
	PageList<Map<String, Object>> selectByExample(@Param("community_id") Integer community_id,
			@Param("pf_status") Integer pf_status, @Param("set_id") String set_id,
			@Param("begin_create_time") Date begin_create_time, @Param("end_create_time") Date end_create_time,
			@Param("title") String title, @Param("account_id") String account_id,
			@Param("effective_settlement") Boolean effective_settlement, PageBounds pageBounds);

}