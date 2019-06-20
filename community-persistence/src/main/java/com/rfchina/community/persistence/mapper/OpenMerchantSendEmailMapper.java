package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenMerchantSendEmail;
import com.rfchina.community.persistence.model.OpenMerchantSendEmailExample;
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

public interface OpenMerchantSendEmailMapper extends Serializable {
    @SelectProvider(type=OpenMerchantSendEmailSqlProvider.class, method="countByExample")
    long countByExample(OpenMerchantSendEmailExample example);

    @DeleteProvider(type=OpenMerchantSendEmailSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenMerchantSendEmailExample example);

    @Delete({
        "delete from open_merchant_send_email",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_merchant_send_email (email, type, ",
        "parameter, create_time, ",
        "status, send_email_time, ",
        "uuid)",
        "values (#{email,jdbcType=VARCHAR}, #{type,jdbcType=INTEGER}, ",
        "#{parameter,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=INTEGER}, #{sendEmailTime,jdbcType=TIMESTAMP}, ",
        "#{uuid,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenMerchantSendEmail record);

    @InsertProvider(type=OpenMerchantSendEmailSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenMerchantSendEmail record);

    @SelectProvider(type=OpenMerchantSendEmailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="parameter", property="parameter", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="send_email_time", property="sendEmailTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR)
    })
    List<OpenMerchantSendEmail> selectByExample(OpenMerchantSendEmailExample example);

    @Select({
        "select",
        "id, email, type, parameter, create_time, status, send_email_time, uuid",
        "from open_merchant_send_email",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="parameter", property="parameter", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="send_email_time", property="sendEmailTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR)
    })
    OpenMerchantSendEmail selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenMerchantSendEmailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenMerchantSendEmail record, @Param("example") OpenMerchantSendEmailExample example);

    @UpdateProvider(type=OpenMerchantSendEmailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenMerchantSendEmail record, @Param("example") OpenMerchantSendEmailExample example);

    @UpdateProvider(type=OpenMerchantSendEmailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenMerchantSendEmail record);

    @Update({
        "update open_merchant_send_email",
        "set email = #{email,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "parameter = #{parameter,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "send_email_time = #{sendEmailTime,jdbcType=TIMESTAMP},",
          "uuid = #{uuid,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenMerchantSendEmail record);
}