package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenAppServiceRela;
import com.rfchina.community.persistence.model.OpenAppServiceRelaExample;
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

public interface OpenAppServiceRelaMapper extends Serializable {
    @SelectProvider(type=OpenAppServiceRelaSqlProvider.class, method="countByExample")
    long countByExample(OpenAppServiceRelaExample example);

    @DeleteProvider(type=OpenAppServiceRelaSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenAppServiceRelaExample example);

    @Delete({
        "delete from open_app_service_rela",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_app_service_rela (app_id, service_id, ",
        "create_time, status, ",
        "audit_time, audit_comment, ",
        "level_id, update_time)",
        "values (#{appId,jdbcType=BIGINT}, #{serviceId,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER}, ",
        "#{auditTime,jdbcType=TIMESTAMP}, #{auditComment,jdbcType=VARCHAR}, ",
        "#{levelId,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenAppServiceRela record);

    @InsertProvider(type=OpenAppServiceRelaSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenAppServiceRela record);

    @SelectProvider(type=OpenAppServiceRelaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.BIGINT),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_comment", property="auditComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="level_id", property="levelId", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenAppServiceRela> selectByExample(OpenAppServiceRelaExample example);

    @Select({
        "select",
        "id, app_id, service_id, create_time, status, audit_time, audit_comment, level_id, ",
        "update_time",
        "from open_app_service_rela",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.BIGINT),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_comment", property="auditComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="level_id", property="levelId", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenAppServiceRela selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenAppServiceRelaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenAppServiceRela record, @Param("example") OpenAppServiceRelaExample example);

    @UpdateProvider(type=OpenAppServiceRelaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenAppServiceRela record, @Param("example") OpenAppServiceRelaExample example);

    @UpdateProvider(type=OpenAppServiceRelaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenAppServiceRela record);

    @Update({
        "update open_app_service_rela",
        "set app_id = #{appId,jdbcType=BIGINT},",
          "service_id = #{serviceId,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "audit_time = #{auditTime,jdbcType=TIMESTAMP},",
          "audit_comment = #{auditComment,jdbcType=VARCHAR},",
          "level_id = #{levelId,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenAppServiceRela record);
}