package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenMerchantInfo;
import com.rfchina.community.persistence.model.OpenMerchantInfoExample;
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
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

public interface OpenMerchantInfoMapper extends BaseMapper<OpenMerchantInfo,OpenMerchantInfoExample,Long> {
    @SelectProvider(type=OpenMerchantInfoSqlProvider.class, method="countByExample")
    long countByExample(OpenMerchantInfoExample example);

    @DeleteProvider(type=OpenMerchantInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenMerchantInfoExample example);

    @Delete({
        "delete from open_merchant_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_merchant_info (email, type, ",
        "title, title_simple, ",
        "introduction, business_scope, ",
        "create_time, update_time, ",
        "registration_number, organization_code, ",
        "tex_registration_no, business_license, ",
        "is_other_license, other_license, ",
        "target_month_turnover, contact_person, ",
        "contact_phone, province_area_id, ",
        "city_area_id, area_id, ",
        "area_info, status, ",
        "status_content, bank_title, ",
        "bank_account_name, bank_account, ",
        "id_number, id_positive, ",
        "id_obverse, mch_id, ",
        "account_id, xfsj_status, ",
        "legal_name, legal_id_card, ",
        "legal_id_positive, legal_id_back, ",
        "src_business, src_city, ",
        "is_mandatary, mandatary_name, ",
        "mandatary_id_card, mandatary_id_positive, ",
        "mandatary_id_back, mandatary_other, ",
        "user_name, tel, audit_status)",
        "values (#{email,jdbcType=VARCHAR}, #{type,jdbcType=INTEGER}, ",
        "#{title,jdbcType=VARCHAR}, #{titleSimple,jdbcType=VARCHAR}, ",
        "#{introduction,jdbcType=VARCHAR}, #{businessScope,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{registrationNumber,jdbcType=VARCHAR}, #{organizationCode,jdbcType=VARCHAR}, ",
        "#{texRegistrationNo,jdbcType=VARCHAR}, #{businessLicense,jdbcType=VARCHAR}, ",
        "#{isOtherLicense,jdbcType=INTEGER}, #{otherLicense,jdbcType=VARCHAR}, ",
        "#{targetMonthTurnover,jdbcType=BIGINT}, #{contactPerson,jdbcType=VARCHAR}, ",
        "#{contactPhone,jdbcType=VARCHAR}, #{provinceAreaId,jdbcType=INTEGER}, ",
        "#{cityAreaId,jdbcType=INTEGER}, #{areaId,jdbcType=INTEGER}, ",
        "#{areaInfo,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{statusContent,jdbcType=VARCHAR}, #{bankTitle,jdbcType=VARCHAR}, ",
        "#{bankAccountName,jdbcType=VARCHAR}, #{bankAccount,jdbcType=VARCHAR}, ",
        "#{idNumber,jdbcType=VARCHAR}, #{idPositive,jdbcType=VARCHAR}, ",
        "#{idObverse,jdbcType=VARCHAR}, #{mchId,jdbcType=VARCHAR}, ",
        "#{accountId,jdbcType=BIGINT}, #{xfsjStatus,jdbcType=INTEGER}, ",
        "#{legalName,jdbcType=VARCHAR}, #{legalIdCard,jdbcType=VARCHAR}, ",
        "#{legalIdPositive,jdbcType=VARCHAR}, #{legalIdBack,jdbcType=VARCHAR}, ",
        "#{srcBusiness,jdbcType=VARCHAR}, #{srcCity,jdbcType=INTEGER}, ",
        "#{isMandatary,jdbcType=INTEGER}, #{mandataryName,jdbcType=VARCHAR}, ",
        "#{mandataryIdCard,jdbcType=VARCHAR}, #{mandataryIdPositive,jdbcType=VARCHAR}, ",
        "#{mandataryIdBack,jdbcType=VARCHAR}, #{mandataryOther,jdbcType=VARCHAR}, ",
        "#{userName,jdbcType=VARCHAR}, #{tel,jdbcType=VARCHAR}, #{auditStatus,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenMerchantInfo record);

    @InsertProvider(type=OpenMerchantInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenMerchantInfo record);

    @SelectProvider(type=OpenMerchantInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="title_simple", property="titleSimple", jdbcType=JdbcType.VARCHAR),
        @Result(column="introduction", property="introduction", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_scope", property="businessScope", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="registration_number", property="registrationNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="organization_code", property="organizationCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="tex_registration_no", property="texRegistrationNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_license", property="businessLicense", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_other_license", property="isOtherLicense", jdbcType=JdbcType.INTEGER),
        @Result(column="other_license", property="otherLicense", jdbcType=JdbcType.VARCHAR),
        @Result(column="target_month_turnover", property="targetMonthTurnover", jdbcType=JdbcType.BIGINT),
        @Result(column="contact_person", property="contactPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="province_area_id", property="provinceAreaId", jdbcType=JdbcType.INTEGER),
        @Result(column="city_area_id", property="cityAreaId", jdbcType=JdbcType.INTEGER),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="area_info", property="areaInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="status_content", property="statusContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_title", property="bankTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_account_name", property="bankAccountName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_account", property="bankAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_number", property="idNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_positive", property="idPositive", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_obverse", property="idObverse", jdbcType=JdbcType.VARCHAR),
        @Result(column="mch_id", property="mchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.BIGINT),
        @Result(column="xfsj_status", property="xfsjStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="legal_name", property="legalName", jdbcType=JdbcType.VARCHAR),
        @Result(column="legal_id_card", property="legalIdCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="legal_id_positive", property="legalIdPositive", jdbcType=JdbcType.VARCHAR),
        @Result(column="legal_id_back", property="legalIdBack", jdbcType=JdbcType.VARCHAR),
        @Result(column="src_business", property="srcBusiness", jdbcType=JdbcType.VARCHAR),
        @Result(column="src_city", property="srcCity", jdbcType=JdbcType.INTEGER),
        @Result(column="is_mandatary", property="isMandatary", jdbcType=JdbcType.INTEGER),
        @Result(column="mandatary_name", property="mandataryName", jdbcType=JdbcType.VARCHAR),
        @Result(column="mandatary_id_card", property="mandataryIdCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="mandatary_id_positive", property="mandataryIdPositive", jdbcType=JdbcType.VARCHAR),
        @Result(column="mandatary_id_back", property="mandataryIdBack", jdbcType=JdbcType.VARCHAR),
        @Result(column="mandatary_other", property="mandataryOther", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.VARCHAR)
    })
    List<OpenMerchantInfo> selectByExample(OpenMerchantInfoExample example);

    @Select({
        "select",
        "id, email, type, title, title_simple, introduction, business_scope, create_time, ",
        "update_time, registration_number, organization_code, tex_registration_no, business_license, ",
        "is_other_license, other_license, target_month_turnover, contact_person, contact_phone, ",
        "province_area_id, city_area_id, area_id, area_info, status, status_content, ",
        "bank_title, bank_account_name, bank_account, id_number, id_positive, id_obverse, ",
        "mch_id, account_id, xfsj_status, legal_name, legal_id_card, legal_id_positive, ",
        "legal_id_back, src_business, src_city, is_mandatary, mandatary_name, mandatary_id_card, ",
        "mandatary_id_positive, mandatary_id_back, mandatary_other, user_name, tel, audit_status",
        "from open_merchant_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="title_simple", property="titleSimple", jdbcType=JdbcType.VARCHAR),
        @Result(column="introduction", property="introduction", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_scope", property="businessScope", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="registration_number", property="registrationNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="organization_code", property="organizationCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="tex_registration_no", property="texRegistrationNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_license", property="businessLicense", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_other_license", property="isOtherLicense", jdbcType=JdbcType.INTEGER),
        @Result(column="other_license", property="otherLicense", jdbcType=JdbcType.VARCHAR),
        @Result(column="target_month_turnover", property="targetMonthTurnover", jdbcType=JdbcType.BIGINT),
        @Result(column="contact_person", property="contactPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="province_area_id", property="provinceAreaId", jdbcType=JdbcType.INTEGER),
        @Result(column="city_area_id", property="cityAreaId", jdbcType=JdbcType.INTEGER),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="area_info", property="areaInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="status_content", property="statusContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_title", property="bankTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_account_name", property="bankAccountName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_account", property="bankAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_number", property="idNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_positive", property="idPositive", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_obverse", property="idObverse", jdbcType=JdbcType.VARCHAR),
        @Result(column="mch_id", property="mchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.BIGINT),
        @Result(column="xfsj_status", property="xfsjStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="legal_name", property="legalName", jdbcType=JdbcType.VARCHAR),
        @Result(column="legal_id_card", property="legalIdCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="legal_id_positive", property="legalIdPositive", jdbcType=JdbcType.VARCHAR),
        @Result(column="legal_id_back", property="legalIdBack", jdbcType=JdbcType.VARCHAR),
        @Result(column="src_business", property="srcBusiness", jdbcType=JdbcType.VARCHAR),
        @Result(column="src_city", property="srcCity", jdbcType=JdbcType.INTEGER),
        @Result(column="is_mandatary", property="isMandatary", jdbcType=JdbcType.INTEGER),
        @Result(column="mandatary_name", property="mandataryName", jdbcType=JdbcType.VARCHAR),
        @Result(column="mandatary_id_card", property="mandataryIdCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="mandatary_id_positive", property="mandataryIdPositive", jdbcType=JdbcType.VARCHAR),
        @Result(column="mandatary_id_back", property="mandataryIdBack", jdbcType=JdbcType.VARCHAR),
        @Result(column="mandatary_other", property="mandataryOther", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.VARCHAR)
    })
    OpenMerchantInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenMerchantInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenMerchantInfo record, @Param("example") OpenMerchantInfoExample example);

    @UpdateProvider(type=OpenMerchantInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenMerchantInfo record, @Param("example") OpenMerchantInfoExample example);

    @UpdateProvider(type=OpenMerchantInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenMerchantInfo record);

    @Update({
        "update open_merchant_info",
        "set email = #{email,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "title_simple = #{titleSimple,jdbcType=VARCHAR},",
          "introduction = #{introduction,jdbcType=VARCHAR},",
          "business_scope = #{businessScope,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "registration_number = #{registrationNumber,jdbcType=VARCHAR},",
          "organization_code = #{organizationCode,jdbcType=VARCHAR},",
          "tex_registration_no = #{texRegistrationNo,jdbcType=VARCHAR},",
          "business_license = #{businessLicense,jdbcType=VARCHAR},",
          "is_other_license = #{isOtherLicense,jdbcType=INTEGER},",
          "other_license = #{otherLicense,jdbcType=VARCHAR},",
          "target_month_turnover = #{targetMonthTurnover,jdbcType=BIGINT},",
          "contact_person = #{contactPerson,jdbcType=VARCHAR},",
          "contact_phone = #{contactPhone,jdbcType=VARCHAR},",
          "province_area_id = #{provinceAreaId,jdbcType=INTEGER},",
          "city_area_id = #{cityAreaId,jdbcType=INTEGER},",
          "area_id = #{areaId,jdbcType=INTEGER},",
          "area_info = #{areaInfo,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "status_content = #{statusContent,jdbcType=VARCHAR},",
          "bank_title = #{bankTitle,jdbcType=VARCHAR},",
          "bank_account_name = #{bankAccountName,jdbcType=VARCHAR},",
          "bank_account = #{bankAccount,jdbcType=VARCHAR},",
          "id_number = #{idNumber,jdbcType=VARCHAR},",
          "id_positive = #{idPositive,jdbcType=VARCHAR},",
          "id_obverse = #{idObverse,jdbcType=VARCHAR},",
          "mch_id = #{mchId,jdbcType=VARCHAR},",
          "account_id = #{accountId,jdbcType=BIGINT},",
          "xfsj_status = #{xfsjStatus,jdbcType=INTEGER},",
          "legal_name = #{legalName,jdbcType=VARCHAR},",
          "legal_id_card = #{legalIdCard,jdbcType=VARCHAR},",
          "legal_id_positive = #{legalIdPositive,jdbcType=VARCHAR},",
          "legal_id_back = #{legalIdBack,jdbcType=VARCHAR},",
          "src_business = #{srcBusiness,jdbcType=VARCHAR},",
          "src_city = #{srcCity,jdbcType=INTEGER},",
          "is_mandatary = #{isMandatary,jdbcType=INTEGER},",
          "mandatary_name = #{mandataryName,jdbcType=VARCHAR},",
          "mandatary_id_card = #{mandataryIdCard,jdbcType=VARCHAR},",
          "mandatary_id_positive = #{mandataryIdPositive,jdbcType=VARCHAR},",
          "mandatary_id_back = #{mandataryIdBack,jdbcType=VARCHAR},",
          "mandatary_other = #{mandataryOther,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "audit_status = #{auditStatus,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenMerchantInfo record);

    @SelectProvider(type = OpenMerchantInfoSqlProvider.class, method = "pageByExample")
    @Results({@Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="title_simple", property="titleSimple", jdbcType=JdbcType.VARCHAR),
            @Result(column="introduction", property="introduction", jdbcType=JdbcType.VARCHAR),
            @Result(column="business_scope", property="businessScope", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="registration_number", property="registrationNumber", jdbcType=JdbcType.VARCHAR),
            @Result(column="organization_code", property="organizationCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="tex_registration_no", property="texRegistrationNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="business_license", property="businessLicense", jdbcType=JdbcType.VARCHAR),
            @Result(column="is_other_license", property="isOtherLicense", jdbcType=JdbcType.INTEGER),
            @Result(column="other_license", property="otherLicense", jdbcType=JdbcType.VARCHAR),
            @Result(column="target_month_turnover", property="targetMonthTurnover", jdbcType=JdbcType.BIGINT),
            @Result(column="contact_person", property="contactPerson", jdbcType=JdbcType.VARCHAR),
            @Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
            @Result(column="province_area_id", property="provinceAreaId", jdbcType=JdbcType.INTEGER),
            @Result(column="city_area_id", property="cityAreaId", jdbcType=JdbcType.INTEGER),
            @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
            @Result(column="area_info", property="areaInfo", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
            @Result(column="status_content", property="statusContent", jdbcType=JdbcType.VARCHAR),
            @Result(column="bank_title", property="bankTitle", jdbcType=JdbcType.VARCHAR),
            @Result(column="bank_account_name", property="bankAccountName", jdbcType=JdbcType.VARCHAR),
            @Result(column="bank_account", property="bankAccount", jdbcType=JdbcType.VARCHAR),
            @Result(column="id_number", property="idNumber", jdbcType=JdbcType.VARCHAR),
            @Result(column="id_positive", property="idPositive", jdbcType=JdbcType.VARCHAR),
            @Result(column="id_obverse", property="idObverse", jdbcType=JdbcType.VARCHAR),
            @Result(column="mch_id", property="mchId", jdbcType=JdbcType.VARCHAR),
            @Result(column="account_id", property="accountId", jdbcType=JdbcType.BIGINT),
            @Result(column="xfsj_status", property="xfsjStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="legal_name", property="legalName", jdbcType=JdbcType.VARCHAR),
            @Result(column="legal_id_card", property="legalIdCard", jdbcType=JdbcType.VARCHAR),
            @Result(column="legal_id_positive", property="legalIdPositive", jdbcType=JdbcType.VARCHAR),
            @Result(column="legal_id_back", property="legalIdBack", jdbcType=JdbcType.VARCHAR),
            @Result(column="src_business", property="srcBusiness", jdbcType=JdbcType.VARCHAR),
            @Result(column="src_city", property="srcCity", jdbcType=JdbcType.INTEGER),
            @Result(column="is_mandatary", property="isMandatary", jdbcType=JdbcType.INTEGER),
            @Result(column="mandatary_name", property="mandataryName", jdbcType=JdbcType.VARCHAR),
            @Result(column="mandatary_id_card", property="mandataryIdCard", jdbcType=JdbcType.VARCHAR),
            @Result(column="mandatary_id_positive", property="mandataryIdPositive", jdbcType=JdbcType.VARCHAR),
            @Result(column="mandatary_id_back", property="mandataryIdBack", jdbcType=JdbcType.VARCHAR),
            @Result(column="mandatary_other", property="mandataryOther", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
            @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.VARCHAR)})
    PageList<OpenMerchantInfo> pageByExample(@Param("example") OpenMerchantInfoExample example, PageBounds pageBounds);
}