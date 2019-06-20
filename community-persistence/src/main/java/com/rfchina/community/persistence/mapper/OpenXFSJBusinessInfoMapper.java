package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenXFSJBusinessInfo;
import com.rfchina.community.persistence.model.OpenXFSJBusinessInfoExample;
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

public interface OpenXFSJBusinessInfoMapper extends Serializable {
    @SelectProvider(type=OpenXFSJBusinessInfoSqlProvider.class, method="countByExample")
    long countByExample(OpenXFSJBusinessInfoExample example);

    @DeleteProvider(type=OpenXFSJBusinessInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenXFSJBusinessInfoExample example);

    @Delete({
        "delete from open_xfsj_business_info",
        "where xfsj_id = #{xfsjId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long xfsjId);

    @Insert({
        "insert into open_xfsj_business_info (xfsj_id, amount, ",
        "service_fee, type, ",
        "contact_phone, sign_up_end_time, ",
        "sign_up_status, locale_detail, ",
        "locale_img)",
        "values (#{xfsjId,jdbcType=BIGINT}, #{amount,jdbcType=INTEGER}, ",
        "#{serviceFee,jdbcType=DECIMAL}, #{type,jdbcType=VARCHAR}, ",
        "#{contactPhone,jdbcType=VARCHAR}, #{signUpEndTime,jdbcType=TIMESTAMP}, ",
        "#{signUpStatus,jdbcType=INTEGER}, #{localeDetail,jdbcType=VARCHAR}, ",
        "#{localeImg,jdbcType=LONGVARCHAR})"
    })
    int insert(OpenXFSJBusinessInfo record);

    @InsertProvider(type=OpenXFSJBusinessInfoSqlProvider.class, method="insertSelective")
    int insertSelective(OpenXFSJBusinessInfo record);

    @SelectProvider(type=OpenXFSJBusinessInfoSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="service_fee", property="serviceFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign_up_end_time", property="signUpEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sign_up_status", property="signUpStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="locale_detail", property="localeDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="locale_img", property="localeImg", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<OpenXFSJBusinessInfo> selectByExampleWithBLOBs(OpenXFSJBusinessInfoExample example);

    @SelectProvider(type=OpenXFSJBusinessInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="service_fee", property="serviceFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign_up_end_time", property="signUpEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sign_up_status", property="signUpStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="locale_detail", property="localeDetail", jdbcType=JdbcType.VARCHAR)
    })
    List<OpenXFSJBusinessInfo> selectByExample(OpenXFSJBusinessInfoExample example);

    @Select({
        "select",
        "xfsj_id, amount, service_fee, type, contact_phone, sign_up_end_time, sign_up_status, ",
        "locale_detail, locale_img",
        "from open_xfsj_business_info",
        "where xfsj_id = #{xfsjId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="service_fee", property="serviceFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign_up_end_time", property="signUpEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sign_up_status", property="signUpStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="locale_detail", property="localeDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="locale_img", property="localeImg", jdbcType=JdbcType.LONGVARCHAR)
    })
    OpenXFSJBusinessInfo selectByPrimaryKey(Long xfsjId);

    @UpdateProvider(type=OpenXFSJBusinessInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenXFSJBusinessInfo record, @Param("example") OpenXFSJBusinessInfoExample example);

    @UpdateProvider(type=OpenXFSJBusinessInfoSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") OpenXFSJBusinessInfo record, @Param("example") OpenXFSJBusinessInfoExample example);

    @UpdateProvider(type=OpenXFSJBusinessInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenXFSJBusinessInfo record, @Param("example") OpenXFSJBusinessInfoExample example);

    @UpdateProvider(type=OpenXFSJBusinessInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenXFSJBusinessInfo record);

    @Update({
        "update open_xfsj_business_info",
        "set amount = #{amount,jdbcType=INTEGER},",
          "service_fee = #{serviceFee,jdbcType=DECIMAL},",
          "type = #{type,jdbcType=VARCHAR},",
          "contact_phone = #{contactPhone,jdbcType=VARCHAR},",
          "sign_up_end_time = #{signUpEndTime,jdbcType=TIMESTAMP},",
          "sign_up_status = #{signUpStatus,jdbcType=INTEGER},",
          "locale_detail = #{localeDetail,jdbcType=VARCHAR},",
          "locale_img = #{localeImg,jdbcType=LONGVARCHAR}",
        "where xfsj_id = #{xfsjId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(OpenXFSJBusinessInfo record);

    @Update({
        "update open_xfsj_business_info",
        "set amount = #{amount,jdbcType=INTEGER},",
          "service_fee = #{serviceFee,jdbcType=DECIMAL},",
          "type = #{type,jdbcType=VARCHAR},",
          "contact_phone = #{contactPhone,jdbcType=VARCHAR},",
          "sign_up_end_time = #{signUpEndTime,jdbcType=TIMESTAMP},",
          "sign_up_status = #{signUpStatus,jdbcType=INTEGER},",
          "locale_detail = #{localeDetail,jdbcType=VARCHAR}",
        "where xfsj_id = #{xfsjId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenXFSJBusinessInfo record);
}