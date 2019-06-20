package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenServiceEvaluateRecord;
import com.rfchina.community.persistence.model.OpenServiceEvaluateRecordExample;
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

public interface OpenServiceEvaluateRecordMapper extends Serializable {
    @SelectProvider(type=OpenServiceEvaluateRecordSqlProvider.class, method="countByExample")
    long countByExample(OpenServiceEvaluateRecordExample example);

    @DeleteProvider(type=OpenServiceEvaluateRecordSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenServiceEvaluateRecordExample example);

    @Delete({
        "delete from open_service_evaluate_record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into open_service_evaluate_record (uid, service_id, ",
        "create_time, update_time, ",
        "type)",
        "values (#{uid,jdbcType=INTEGER}, #{serviceId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{type,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(OpenServiceEvaluateRecord record);

    @InsertProvider(type=OpenServiceEvaluateRecordSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(OpenServiceEvaluateRecord record);

    @SelectProvider(type=OpenServiceEvaluateRecordSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER)
    })
    List<OpenServiceEvaluateRecord> selectByExample(OpenServiceEvaluateRecordExample example);

    @Select({
        "select",
        "id, uid, service_id, create_time, update_time, type",
        "from open_service_evaluate_record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER)
    })
    OpenServiceEvaluateRecord selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpenServiceEvaluateRecordSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenServiceEvaluateRecord record, @Param("example") OpenServiceEvaluateRecordExample example);

    @UpdateProvider(type=OpenServiceEvaluateRecordSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenServiceEvaluateRecord record, @Param("example") OpenServiceEvaluateRecordExample example);

    @UpdateProvider(type=OpenServiceEvaluateRecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenServiceEvaluateRecord record);

    @Update({
        "update open_service_evaluate_record",
        "set uid = #{uid,jdbcType=INTEGER},",
          "service_id = #{serviceId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "type = #{type,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenServiceEvaluateRecord record);
}