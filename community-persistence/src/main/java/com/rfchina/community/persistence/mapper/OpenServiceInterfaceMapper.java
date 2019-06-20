package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenServiceInterface;
import com.rfchina.community.persistence.model.OpenServiceInterfaceExample;
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

public interface OpenServiceInterfaceMapper extends Serializable {
    @SelectProvider(type=OpenServiceInterfaceSqlProvider.class, method="countByExample")
    long countByExample(OpenServiceInterfaceExample example);

    @DeleteProvider(type=OpenServiceInterfaceSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenServiceInterfaceExample example);

    @Delete({
        "delete from open_service_interface",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into open_service_interface (service_id, interface_id, ",
        "create_time, audit_status, ",
        "audit_comment, status)",
        "values (#{serviceId,jdbcType=INTEGER}, #{interfaceId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{auditStatus,jdbcType=INTEGER}, ",
        "#{auditComment,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(OpenServiceInterface record);

    @InsertProvider(type=OpenServiceInterfaceSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(OpenServiceInterface record);

    @SelectProvider(type=OpenServiceInterfaceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="interface_id", property="interfaceId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_comment", property="auditComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<OpenServiceInterface> selectByExample(OpenServiceInterfaceExample example);

    @Select({
        "select",
        "id, service_id, interface_id, create_time, audit_status, audit_comment, status",
        "from open_service_interface",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="interface_id", property="interfaceId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_comment", property="auditComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    OpenServiceInterface selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpenServiceInterfaceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenServiceInterface record, @Param("example") OpenServiceInterfaceExample example);

    @UpdateProvider(type=OpenServiceInterfaceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenServiceInterface record, @Param("example") OpenServiceInterfaceExample example);

    @UpdateProvider(type=OpenServiceInterfaceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenServiceInterface record);

    @Update({
        "update open_service_interface",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "interface_id = #{interfaceId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "audit_status = #{auditStatus,jdbcType=INTEGER},",
          "audit_comment = #{auditComment,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenServiceInterface record);
}