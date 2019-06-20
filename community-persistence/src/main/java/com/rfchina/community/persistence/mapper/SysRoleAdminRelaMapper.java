package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysRoleAdminRelaExample;
import com.rfchina.community.persistence.model.SysRoleAdminRelaKey;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SysRoleAdminRelaMapper extends Serializable {
    @SelectProvider(type=SysRoleAdminRelaSqlProvider.class, method="countByExample")
    long countByExample(SysRoleAdminRelaExample example);

    @DeleteProvider(type=SysRoleAdminRelaSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysRoleAdminRelaExample example);

    @Delete({
        "delete from sys_role_admin_rela",
        "where role_id = #{roleId,jdbcType=INTEGER}",
          "and admin_id = #{adminId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(SysRoleAdminRelaKey key);

    @Insert({
        "insert into sys_role_admin_rela (role_id, admin_id)",
        "values (#{roleId,jdbcType=INTEGER}, #{adminId,jdbcType=BIGINT})"
    })
    int insert(SysRoleAdminRelaKey record);

    @InsertProvider(type=SysRoleAdminRelaSqlProvider.class, method="insertSelective")
    int insertSelective(SysRoleAdminRelaKey record);

    @SelectProvider(type=SysRoleAdminRelaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.BIGINT, id=true)
    })
    List<SysRoleAdminRelaKey> selectByExample(SysRoleAdminRelaExample example);

    @UpdateProvider(type=SysRoleAdminRelaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysRoleAdminRelaKey record, @Param("example") SysRoleAdminRelaExample example);

    @UpdateProvider(type=SysRoleAdminRelaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysRoleAdminRelaKey record, @Param("example") SysRoleAdminRelaExample example);
}