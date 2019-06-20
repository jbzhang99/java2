package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.Visit4Visitor;
import com.rfchina.community.persistence.model.Visit4VisitorExample;
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

public interface Visit4VisitorMapper extends Serializable {
    @SelectProvider(type=Visit4VisitorSqlProvider.class, method="countByExample")
    long countByExample(Visit4VisitorExample example);

    @DeleteProvider(type=Visit4VisitorSqlProvider.class, method="deleteByExample")
    int deleteByExample(Visit4VisitorExample example);

    @Delete({
        "delete from visit4_visitor",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into visit4_visitor (visit_id, name, ",
        "uid, phone, idcard, ",
        "qrcode_id, qrcode_uuid, ",
        "status)",
        "values (#{visitId,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{uid,jdbcType=BIGINT}, #{phone,jdbcType=VARCHAR}, #{idcard,jdbcType=VARCHAR}, ",
        "#{qrcodeId,jdbcType=BIGINT}, #{qrcodeUuid,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Visit4Visitor record);

    @InsertProvider(type=Visit4VisitorSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(Visit4Visitor record);

    @SelectProvider(type=Visit4VisitorSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="visit_id", property="visitId", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="idcard", property="idcard", jdbcType=JdbcType.VARCHAR),
        @Result(column="qrcode_id", property="qrcodeId", jdbcType=JdbcType.BIGINT),
        @Result(column="qrcode_uuid", property="qrcodeUuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<Visit4Visitor> selectByExample(Visit4VisitorExample example);

    @Select({
        "select",
        "id, visit_id, name, uid, phone, idcard, qrcode_id, qrcode_uuid, status",
        "from visit4_visitor",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="visit_id", property="visitId", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="idcard", property="idcard", jdbcType=JdbcType.VARCHAR),
        @Result(column="qrcode_id", property="qrcodeId", jdbcType=JdbcType.BIGINT),
        @Result(column="qrcode_uuid", property="qrcodeUuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    Visit4Visitor selectByPrimaryKey(Long id);

    @UpdateProvider(type=Visit4VisitorSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Visit4Visitor record, @Param("example") Visit4VisitorExample example);

    @UpdateProvider(type=Visit4VisitorSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Visit4Visitor record, @Param("example") Visit4VisitorExample example);

    @UpdateProvider(type=Visit4VisitorSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Visit4Visitor record);

    @Update({
        "update visit4_visitor",
        "set visit_id = #{visitId,jdbcType=BIGINT},",
          "name = #{name,jdbcType=VARCHAR},",
          "uid = #{uid,jdbcType=BIGINT},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "idcard = #{idcard,jdbcType=VARCHAR},",
          "qrcode_id = #{qrcodeId,jdbcType=BIGINT},",
          "qrcode_uuid = #{qrcodeUuid,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Visit4Visitor record);
}