package com.rfchina.community.persistence.mapper.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 */
public interface ExtSysRoleGlobalMapper {

	/**
	 * 通过资源id找到有效的用户id
	 * 
	 * @param resource_id
	 * @return
	 */
	@Select({" select p.id from rf_passport p left JOIN sys_role_admin_rela r on p.id=r.admin_id  ", " LEFT JOIN community_admin a ON a.passport_id=p.id ",
			" LEFT JOIN sys_priviledge e ON r.role_id=e.role_id ",
			" where p.`status`=1 and e.resource_id=#{resource_id, jdbcType=INTEGER} and a.community_id =#{comid, jdbcType=INTEGER} ",})
	public List<Long> findCommunityAdminUidByresourceid(@Param("comid") Integer comid, @Param("resource_id") Integer resource_id);
}
