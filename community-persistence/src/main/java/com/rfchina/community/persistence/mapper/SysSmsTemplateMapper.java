package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysSmsTemplate;
import com.rfchina.community.persistence.model.SysSmsTemplateExample;
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

public interface SysSmsTemplateMapper extends Serializable {
    @SelectProvider(type=SysSmsTemplateSqlProvider.class, method="countByExample")
    long countByExample(SysSmsTemplateExample example);

    @DeleteProvider(type=SysSmsTemplateSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysSmsTemplateExample example);

    @Delete({
        "delete from sys_sms_template",
        "where sms_type = #{smsType,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String smsType);

    @Insert({
        "insert into sys_sms_template (sms_type, sms_temp, ",
        "appid)",
        "values (#{smsType,jdbcType=VARCHAR}, #{smsTemp,jdbcType=VARCHAR}, ",
        "#{appid,jdbcType=INTEGER})"
    })
    int insert(SysSmsTemplate record);

    @InsertProvider(type=SysSmsTemplateSqlProvider.class, method="insertSelective")
    int insertSelective(SysSmsTemplate record);

    @SelectProvider(type=SysSmsTemplateSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="sms_type", property="smsType", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="sms_temp", property="smsTemp", jdbcType=JdbcType.VARCHAR),
        @Result(column="appid", property="appid", jdbcType=JdbcType.INTEGER)
    })
    List<SysSmsTemplate> selectByExample(SysSmsTemplateExample example);

    @Select({
        "select",
        "sms_type, sms_temp, appid",
        "from sys_sms_template",
        "where sms_type = #{smsType,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="sms_type", property="smsType", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="sms_temp", property="smsTemp", jdbcType=JdbcType.VARCHAR),
        @Result(column="appid", property="appid", jdbcType=JdbcType.INTEGER)
    })
    SysSmsTemplate selectByPrimaryKey(String smsType);

    @UpdateProvider(type=SysSmsTemplateSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysSmsTemplate record, @Param("example") SysSmsTemplateExample example);

    @UpdateProvider(type=SysSmsTemplateSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysSmsTemplate record, @Param("example") SysSmsTemplateExample example);

    @UpdateProvider(type=SysSmsTemplateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysSmsTemplate record);

    @Update({
        "update sys_sms_template",
        "set sms_temp = #{smsTemp,jdbcType=VARCHAR},",
          "appid = #{appid,jdbcType=INTEGER}",
        "where sms_type = #{smsType,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysSmsTemplate record);
}