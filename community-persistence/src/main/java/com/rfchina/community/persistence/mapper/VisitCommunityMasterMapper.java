package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VisitCommunityMaster;
import com.rfchina.community.persistence.model.VisitCommunityMasterExample;
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

public interface VisitCommunityMasterMapper extends Serializable {
    @SelectProvider(type=VisitCommunityMasterSqlProvider.class, method="countByExample")
    long countByExample(VisitCommunityMasterExample example);

    @DeleteProvider(type=VisitCommunityMasterSqlProvider.class, method="deleteByExample")
    int deleteByExample(VisitCommunityMasterExample example);

    @Delete({
        "delete from visit_community_master",
        "where master_id = #{masterId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long masterId);

    @Insert({
        "insert into visit_community_master (master_id, role_count, ",
        "can_visit)",
        "values (#{masterId,jdbcType=BIGINT}, #{roleCount,jdbcType=INTEGER}, ",
        "#{canVisit,jdbcType=INTEGER})"
    })
    int insert(VisitCommunityMaster record);

    @InsertProvider(type=VisitCommunityMasterSqlProvider.class, method="insertSelective")
    int insertSelective(VisitCommunityMaster record);

    @SelectProvider(type=VisitCommunityMasterSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_count", property="roleCount", jdbcType=JdbcType.INTEGER),
        @Result(column="can_visit", property="canVisit", jdbcType=JdbcType.INTEGER)
    })
    List<VisitCommunityMaster> selectByExample(VisitCommunityMasterExample example);

    @Select({
        "select",
        "master_id, role_count, can_visit",
        "from visit_community_master",
        "where master_id = #{masterId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_count", property="roleCount", jdbcType=JdbcType.INTEGER),
        @Result(column="can_visit", property="canVisit", jdbcType=JdbcType.INTEGER)
    })
    VisitCommunityMaster selectByPrimaryKey(Long masterId);

    @UpdateProvider(type=VisitCommunityMasterSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VisitCommunityMaster record, @Param("example") VisitCommunityMasterExample example);

    @UpdateProvider(type=VisitCommunityMasterSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VisitCommunityMaster record, @Param("example") VisitCommunityMasterExample example);

    @UpdateProvider(type=VisitCommunityMasterSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VisitCommunityMaster record);

    @Update({
        "update visit_community_master",
        "set role_count = #{roleCount,jdbcType=INTEGER},",
          "can_visit = #{canVisit,jdbcType=INTEGER}",
        "where master_id = #{masterId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(VisitCommunityMaster record);
}