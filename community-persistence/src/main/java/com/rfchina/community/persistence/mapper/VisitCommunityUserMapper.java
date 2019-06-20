package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VisitCommunityUser;
import com.rfchina.community.persistence.model.VisitCommunityUserExample;
import com.rfchina.community.persistence.model.VisitCommunityUserKey;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface VisitCommunityUserMapper extends Serializable {
    @SelectProvider(type=VisitCommunityUserSqlProvider.class, method="countByExample")
    long countByExample(VisitCommunityUserExample example);

    @DeleteProvider(type=VisitCommunityUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(VisitCommunityUserExample example);

    @Delete({
        "delete from visit_community_user",
        "where master_id = #{masterId,jdbcType=BIGINT}",
          "and phone = #{phone,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(VisitCommunityUserKey key);

    @Insert({
        "insert into visit_community_user (master_id, phone, ",
        "role_id, agent_phone)",
        "values (#{masterId,jdbcType=BIGINT}, #{phone,jdbcType=VARCHAR}, ",
        "#{roleId,jdbcType=INTEGER}, #{agentPhone,jdbcType=VARCHAR})"
    })
    int insert(VisitCommunityUser record);

    @InsertProvider(type=VisitCommunityUserSqlProvider.class, method="insertSelective")
    int insertSelective(VisitCommunityUser record);

    @SelectProvider(type=VisitCommunityUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="agent_phone", property="agentPhone", jdbcType=JdbcType.VARCHAR)
    })
    List<VisitCommunityUser> selectByExample(VisitCommunityUserExample example);

    @Select({
        "select",
        "master_id, phone, role_id, agent_phone",
        "from visit_community_user",
        "where master_id = #{masterId,jdbcType=BIGINT}",
          "and phone = #{phone,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="agent_phone", property="agentPhone", jdbcType=JdbcType.VARCHAR)
    })
    VisitCommunityUser selectByPrimaryKey(VisitCommunityUserKey key);

    @UpdateProvider(type=VisitCommunityUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VisitCommunityUser record, @Param("example") VisitCommunityUserExample example);

    @UpdateProvider(type=VisitCommunityUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VisitCommunityUser record, @Param("example") VisitCommunityUserExample example);

    @UpdateProvider(type=VisitCommunityUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VisitCommunityUser record);

    @Update({
        "update visit_community_user",
        "set role_id = #{roleId,jdbcType=INTEGER},",
          "agent_phone = #{agentPhone,jdbcType=VARCHAR}",
        "where master_id = #{masterId,jdbcType=BIGINT}",
          "and phone = #{phone,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(VisitCommunityUser record);
}