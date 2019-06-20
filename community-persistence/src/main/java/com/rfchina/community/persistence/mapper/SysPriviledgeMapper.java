package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysPriviledgeExample;
import com.rfchina.community.persistence.model.SysPriviledgeKey;
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

public interface SysPriviledgeMapper extends Serializable {
    @SelectProvider(type=SysPriviledgeSqlProvider.class, method="countByExample")
    long countByExample(SysPriviledgeExample example);

    @DeleteProvider(type=SysPriviledgeSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysPriviledgeExample example);

    @Delete({
        "delete from sys_priviledge",
        "where role_id = #{roleId,jdbcType=INTEGER}",
          "and resource_id = #{resourceId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(SysPriviledgeKey key);

    @Insert({
        "insert into sys_priviledge (role_id, resource_id)",
        "values (#{roleId,jdbcType=INTEGER}, #{resourceId,jdbcType=INTEGER})"
    })
    int insert(SysPriviledgeKey record);

    @InsertProvider(type=SysPriviledgeSqlProvider.class, method="insertSelective")
    int insertSelective(SysPriviledgeKey record);

    @SelectProvider(type=SysPriviledgeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="resource_id", property="resourceId", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<SysPriviledgeKey> selectByExample(SysPriviledgeExample example);

    @UpdateProvider(type=SysPriviledgeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysPriviledgeKey record, @Param("example") SysPriviledgeExample example);

    @UpdateProvider(type=SysPriviledgeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysPriviledgeKey record, @Param("example") SysPriviledgeExample example);
}