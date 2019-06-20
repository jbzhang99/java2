package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysDeptAdminRelaExample;
import com.rfchina.community.persistence.model.SysDeptAdminRelaKey;
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

public interface SysDeptAdminRelaMapper extends Serializable {
    @SelectProvider(type=SysDeptAdminRelaSqlProvider.class, method="countByExample")
    long countByExample(SysDeptAdminRelaExample example);

    @DeleteProvider(type=SysDeptAdminRelaSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysDeptAdminRelaExample example);

    @Delete({
        "delete from sys_dept_admin_rela",
        "where dept_id = #{deptId,jdbcType=INTEGER}",
          "and admin_id = #{adminId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(SysDeptAdminRelaKey key);

    @Insert({
        "insert into sys_dept_admin_rela (dept_id, admin_id)",
        "values (#{deptId,jdbcType=INTEGER}, #{adminId,jdbcType=BIGINT})"
    })
    int insert(SysDeptAdminRelaKey record);

    @InsertProvider(type=SysDeptAdminRelaSqlProvider.class, method="insertSelective")
    int insertSelective(SysDeptAdminRelaKey record);

    @SelectProvider(type=SysDeptAdminRelaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="dept_id", property="deptId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.BIGINT, id=true)
    })
    List<SysDeptAdminRelaKey> selectByExample(SysDeptAdminRelaExample example);

    @UpdateProvider(type=SysDeptAdminRelaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysDeptAdminRelaKey record, @Param("example") SysDeptAdminRelaExample example);

    @UpdateProvider(type=SysDeptAdminRelaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysDeptAdminRelaKey record, @Param("example") SysDeptAdminRelaExample example);
}