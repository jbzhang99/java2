package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.Visit4Info;
import com.rfchina.community.persistence.model.Visit4InfoExample;
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
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Visit4InfoMapper extends Serializable {
    @SelectProvider(type=Visit4InfoSqlProvider.class, method="countByExample")
    long countByExample(Visit4InfoExample example);

    @DeleteProvider(type=Visit4InfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(Visit4InfoExample example);

    @Delete({
        "delete from visit4_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into visit4_info (create_uid, create_date, ",
        "community_id, child_id, ",
        "master_id, type, visit_date, ",
        "status, visit_count)",
        "values (#{createUid,jdbcType=BIGINT}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{communityId,jdbcType=INTEGER}, #{childId,jdbcType=BIGINT}, ",
        "#{masterId,jdbcType=BIGINT}, #{type,jdbcType=INTEGER}, #{visitDate,jdbcType=DATE}, ",
        "#{status,jdbcType=INTEGER}, #{visitCount,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Visit4Info record);

    @InsertProvider(type=Visit4InfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(Visit4Info record);

    @SelectProvider(type=Visit4InfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="child_id", property="childId", jdbcType=JdbcType.BIGINT),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="visit_date", property="visitDate", jdbcType=JdbcType.DATE),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="visit_count", property="visitCount", jdbcType=JdbcType.INTEGER)
    })
    List<Visit4Info> selectByExample(Visit4InfoExample example);

    @Select({
        "select",
        "id, create_uid, create_date, community_id, child_id, master_id, type, visit_date, ",
        "status, visit_count",
        "from visit4_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="child_id", property="childId", jdbcType=JdbcType.BIGINT),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="visit_date", property="visitDate", jdbcType=JdbcType.DATE),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="visit_count", property="visitCount", jdbcType=JdbcType.INTEGER)
    })
    Visit4Info selectByPrimaryKey(Long id);

    @UpdateProvider(type=Visit4InfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Visit4Info record, @Param("example") Visit4InfoExample example);

    @UpdateProvider(type=Visit4InfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Visit4Info record, @Param("example") Visit4InfoExample example);

    @UpdateProvider(type=Visit4InfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Visit4Info record);

    @Update({
        "update visit4_info",
        "set create_uid = #{createUid,jdbcType=BIGINT},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "child_id = #{childId,jdbcType=BIGINT},",
          "master_id = #{masterId,jdbcType=BIGINT},",
          "type = #{type,jdbcType=INTEGER},",
          "visit_date = #{visitDate,jdbcType=DATE},",
          "status = #{status,jdbcType=INTEGER},",
          "visit_count = #{visitCount,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Visit4Info record);
}