package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VisitQrcodeLog;
import com.rfchina.community.persistence.model.VisitQrcodeLogExample;
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

public interface VisitQrcodeLogMapper extends Serializable {
    @SelectProvider(type=VisitQrcodeLogSqlProvider.class, method="countByExample")
    long countByExample(VisitQrcodeLogExample example);

    @DeleteProvider(type=VisitQrcodeLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(VisitQrcodeLogExample example);

    @Delete({
        "delete from visit_qrcode_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into visit_qrcode_log (content, item_id, ",
        "community_id, type, ",
        "create_time, create_ip, ",
        "uid, decode_content, ",
        "phone, qr_type, qr_id)",
        "values (#{content,jdbcType=VARCHAR}, #{itemId,jdbcType=VARCHAR}, ",
        "#{communityId,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{createIp,jdbcType=VARCHAR}, ",
        "#{uid,jdbcType=BIGINT}, #{decodeContent,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{qrType,jdbcType=INTEGER}, #{qrId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(VisitQrcodeLog record);

    @InsertProvider(type=VisitQrcodeLogSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(VisitQrcodeLog record);

    @SelectProvider(type=VisitQrcodeLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_ip", property="createIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="decode_content", property="decodeContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="qr_type", property="qrType", jdbcType=JdbcType.INTEGER),
        @Result(column="qr_id", property="qrId", jdbcType=JdbcType.BIGINT)
    })
    List<VisitQrcodeLog> selectByExample(VisitQrcodeLogExample example);

    @Select({
        "select",
        "id, content, item_id, community_id, type, create_time, create_ip, uid, decode_content, ",
        "phone, qr_type, qr_id",
        "from visit_qrcode_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_ip", property="createIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="decode_content", property="decodeContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="qr_type", property="qrType", jdbcType=JdbcType.INTEGER),
        @Result(column="qr_id", property="qrId", jdbcType=JdbcType.BIGINT)
    })
    VisitQrcodeLog selectByPrimaryKey(Long id);

    @UpdateProvider(type=VisitQrcodeLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VisitQrcodeLog record, @Param("example") VisitQrcodeLogExample example);

    @UpdateProvider(type=VisitQrcodeLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VisitQrcodeLog record, @Param("example") VisitQrcodeLogExample example);

    @UpdateProvider(type=VisitQrcodeLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VisitQrcodeLog record);

    @Update({
        "update visit_qrcode_log",
        "set content = #{content,jdbcType=VARCHAR},",
          "item_id = #{itemId,jdbcType=VARCHAR},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_ip = #{createIp,jdbcType=VARCHAR},",
          "uid = #{uid,jdbcType=BIGINT},",
          "decode_content = #{decodeContent,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "qr_type = #{qrType,jdbcType=INTEGER},",
          "qr_id = #{qrId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(VisitQrcodeLog record);
}