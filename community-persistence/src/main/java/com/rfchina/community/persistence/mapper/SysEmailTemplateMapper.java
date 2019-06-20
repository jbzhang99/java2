package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysEmailTemplate;
import com.rfchina.community.persistence.model.SysEmailTemplateExample;
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

public interface SysEmailTemplateMapper extends Serializable {
    @SelectProvider(type=SysEmailTemplateSqlProvider.class, method="countByExample")
    long countByExample(SysEmailTemplateExample example);

    @DeleteProvider(type=SysEmailTemplateSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysEmailTemplateExample example);

    @Delete({
        "delete from sys_email_template",
        "where email_type = #{emailType,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String emailType);

    @Insert({
        "insert into sys_email_template (email_type, email_subject, ",
        "email_template)",
        "values (#{emailType,jdbcType=VARCHAR}, #{emailSubject,jdbcType=VARCHAR}, ",
        "#{emailTemplate,jdbcType=VARCHAR})"
    })
    int insert(SysEmailTemplate record);

    @InsertProvider(type=SysEmailTemplateSqlProvider.class, method="insertSelective")
    int insertSelective(SysEmailTemplate record);

    @SelectProvider(type=SysEmailTemplateSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="email_type", property="emailType", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="email_subject", property="emailSubject", jdbcType=JdbcType.VARCHAR),
        @Result(column="email_template", property="emailTemplate", jdbcType=JdbcType.VARCHAR)
    })
    List<SysEmailTemplate> selectByExample(SysEmailTemplateExample example);

    @Select({
        "select",
        "email_type, email_subject, email_template",
        "from sys_email_template",
        "where email_type = #{emailType,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="email_type", property="emailType", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="email_subject", property="emailSubject", jdbcType=JdbcType.VARCHAR),
        @Result(column="email_template", property="emailTemplate", jdbcType=JdbcType.VARCHAR)
    })
    SysEmailTemplate selectByPrimaryKey(String emailType);

    @UpdateProvider(type=SysEmailTemplateSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysEmailTemplate record, @Param("example") SysEmailTemplateExample example);

    @UpdateProvider(type=SysEmailTemplateSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysEmailTemplate record, @Param("example") SysEmailTemplateExample example);

    @UpdateProvider(type=SysEmailTemplateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysEmailTemplate record);

    @Update({
        "update sys_email_template",
        "set email_subject = #{emailSubject,jdbcType=VARCHAR},",
          "email_template = #{emailTemplate,jdbcType=VARCHAR}",
        "where email_type = #{emailType,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysEmailTemplate record);
}