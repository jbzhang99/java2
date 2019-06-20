package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenMerchantInfo;
import com.rfchina.community.persistence.model.OpenMerchantInfoExample.Criteria;
import com.rfchina.community.persistence.model.OpenMerchantInfoExample.Criterion;
import com.rfchina.community.persistence.model.OpenMerchantInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenMerchantInfoSqlProvider {

    public String countByExample(OpenMerchantInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_merchant_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenMerchantInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_merchant_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenMerchantInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_merchant_info");
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getTitleSimple() != null) {
            sql.VALUES("title_simple", "#{titleSimple,jdbcType=VARCHAR}");
        }
        
        if (record.getIntroduction() != null) {
            sql.VALUES("introduction", "#{introduction,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessScope() != null) {
            sql.VALUES("business_scope", "#{businessScope,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRegistrationNumber() != null) {
            sql.VALUES("registration_number", "#{registrationNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getOrganizationCode() != null) {
            sql.VALUES("organization_code", "#{organizationCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTexRegistrationNo() != null) {
            sql.VALUES("tex_registration_no", "#{texRegistrationNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessLicense() != null) {
            sql.VALUES("business_license", "#{businessLicense,jdbcType=VARCHAR}");
        }
        
        if (record.getIsOtherLicense() != null) {
            sql.VALUES("is_other_license", "#{isOtherLicense,jdbcType=INTEGER}");
        }
        
        if (record.getOtherLicense() != null) {
            sql.VALUES("other_license", "#{otherLicense,jdbcType=VARCHAR}");
        }
        
        if (record.getTargetMonthTurnover() != null) {
            sql.VALUES("target_month_turnover", "#{targetMonthTurnover,jdbcType=BIGINT}");
        }
        
        if (record.getContactPerson() != null) {
            sql.VALUES("contact_person", "#{contactPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getContactPhone() != null) {
            sql.VALUES("contact_phone", "#{contactPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceAreaId() != null) {
            sql.VALUES("province_area_id", "#{provinceAreaId,jdbcType=INTEGER}");
        }
        
        if (record.getCityAreaId() != null) {
            sql.VALUES("city_area_id", "#{cityAreaId,jdbcType=INTEGER}");
        }
        
        if (record.getAreaId() != null) {
            sql.VALUES("area_id", "#{areaId,jdbcType=INTEGER}");
        }
        
        if (record.getAreaInfo() != null) {
            sql.VALUES("area_info", "#{areaInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getStatusContent() != null) {
            sql.VALUES("status_content", "#{statusContent,jdbcType=VARCHAR}");
        }
        
        if (record.getBankTitle() != null) {
            sql.VALUES("bank_title", "#{bankTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getBankAccountName() != null) {
            sql.VALUES("bank_account_name", "#{bankAccountName,jdbcType=VARCHAR}");
        }
        
        if (record.getBankAccount() != null) {
            sql.VALUES("bank_account", "#{bankAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getIdNumber() != null) {
            sql.VALUES("id_number", "#{idNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getIdPositive() != null) {
            sql.VALUES("id_positive", "#{idPositive,jdbcType=VARCHAR}");
        }
        
        if (record.getIdObverse() != null) {
            sql.VALUES("id_obverse", "#{idObverse,jdbcType=VARCHAR}");
        }
        
        if (record.getMchId() != null) {
            sql.VALUES("mch_id", "#{mchId,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            sql.VALUES("account_id", "#{accountId,jdbcType=BIGINT}");
        }
        
        if (record.getXfsjStatus() != null) {
            sql.VALUES("xfsj_status", "#{xfsjStatus,jdbcType=INTEGER}");
        }
        
        if (record.getLegalName() != null) {
            sql.VALUES("legal_name", "#{legalName,jdbcType=VARCHAR}");
        }
        
        if (record.getLegalIdCard() != null) {
            sql.VALUES("legal_id_card", "#{legalIdCard,jdbcType=VARCHAR}");
        }
        
        if (record.getLegalIdPositive() != null) {
            sql.VALUES("legal_id_positive", "#{legalIdPositive,jdbcType=VARCHAR}");
        }
        
        if (record.getLegalIdBack() != null) {
            sql.VALUES("legal_id_back", "#{legalIdBack,jdbcType=VARCHAR}");
        }
        
        if (record.getSrcBusiness() != null) {
            sql.VALUES("src_business", "#{srcBusiness,jdbcType=VARCHAR}");
        }
        
        if (record.getSrcCity() != null) {
            sql.VALUES("src_city", "#{srcCity,jdbcType=INTEGER}");
        }
        
        if (record.getIsMandatary() != null) {
            sql.VALUES("is_mandatary", "#{isMandatary,jdbcType=INTEGER}");
        }
        
        if (record.getMandataryName() != null) {
            sql.VALUES("mandatary_name", "#{mandataryName,jdbcType=VARCHAR}");
        }
        
        if (record.getMandataryIdCard() != null) {
            sql.VALUES("mandatary_id_card", "#{mandataryIdCard,jdbcType=VARCHAR}");
        }
        
        if (record.getMandataryIdPositive() != null) {
            sql.VALUES("mandatary_id_positive", "#{mandataryIdPositive,jdbcType=VARCHAR}");
        }
        
        if (record.getMandataryIdBack() != null) {
            sql.VALUES("mandatary_id_back", "#{mandataryIdBack,jdbcType=VARCHAR}");
        }
        
        if (record.getMandataryOther() != null) {
            sql.VALUES("mandatary_other", "#{mandataryOther,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.VALUES("tel", "#{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.VALUES("audit_status", "#{auditStatus,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenMerchantInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("email");
        sql.SELECT("type");
        sql.SELECT("title");
        sql.SELECT("title_simple");
        sql.SELECT("introduction");
        sql.SELECT("business_scope");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("registration_number");
        sql.SELECT("organization_code");
        sql.SELECT("tex_registration_no");
        sql.SELECT("business_license");
        sql.SELECT("is_other_license");
        sql.SELECT("other_license");
        sql.SELECT("target_month_turnover");
        sql.SELECT("contact_person");
        sql.SELECT("contact_phone");
        sql.SELECT("province_area_id");
        sql.SELECT("city_area_id");
        sql.SELECT("area_id");
        sql.SELECT("area_info");
        sql.SELECT("status");
        sql.SELECT("status_content");
        sql.SELECT("bank_title");
        sql.SELECT("bank_account_name");
        sql.SELECT("bank_account");
        sql.SELECT("id_number");
        sql.SELECT("id_positive");
        sql.SELECT("id_obverse");
        sql.SELECT("mch_id");
        sql.SELECT("account_id");
        sql.SELECT("xfsj_status");
        sql.SELECT("legal_name");
        sql.SELECT("legal_id_card");
        sql.SELECT("legal_id_positive");
        sql.SELECT("legal_id_back");
        sql.SELECT("src_business");
        sql.SELECT("src_city");
        sql.SELECT("is_mandatary");
        sql.SELECT("mandatary_name");
        sql.SELECT("mandatary_id_card");
        sql.SELECT("mandatary_id_positive");
        sql.SELECT("mandatary_id_back");
        sql.SELECT("mandatary_other");
        sql.SELECT("user_name");
        sql.SELECT("tel");
        sql.SELECT("audit_status");
        sql.FROM("open_merchant_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenMerchantInfo record = (OpenMerchantInfo) parameter.get("record");
        OpenMerchantInfoExample example = (OpenMerchantInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_merchant_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getTitleSimple() != null) {
            sql.SET("title_simple = #{record.titleSimple,jdbcType=VARCHAR}");
        }
        
        if (record.getIntroduction() != null) {
            sql.SET("introduction = #{record.introduction,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessScope() != null) {
            sql.SET("business_scope = #{record.businessScope,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRegistrationNumber() != null) {
            sql.SET("registration_number = #{record.registrationNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getOrganizationCode() != null) {
            sql.SET("organization_code = #{record.organizationCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTexRegistrationNo() != null) {
            sql.SET("tex_registration_no = #{record.texRegistrationNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessLicense() != null) {
            sql.SET("business_license = #{record.businessLicense,jdbcType=VARCHAR}");
        }
        
        if (record.getIsOtherLicense() != null) {
            sql.SET("is_other_license = #{record.isOtherLicense,jdbcType=INTEGER}");
        }
        
        if (record.getOtherLicense() != null) {
            sql.SET("other_license = #{record.otherLicense,jdbcType=VARCHAR}");
        }
        
        if (record.getTargetMonthTurnover() != null) {
            sql.SET("target_month_turnover = #{record.targetMonthTurnover,jdbcType=BIGINT}");
        }
        
        if (record.getContactPerson() != null) {
            sql.SET("contact_person = #{record.contactPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getContactPhone() != null) {
            sql.SET("contact_phone = #{record.contactPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceAreaId() != null) {
            sql.SET("province_area_id = #{record.provinceAreaId,jdbcType=INTEGER}");
        }
        
        if (record.getCityAreaId() != null) {
            sql.SET("city_area_id = #{record.cityAreaId,jdbcType=INTEGER}");
        }
        
        if (record.getAreaId() != null) {
            sql.SET("area_id = #{record.areaId,jdbcType=INTEGER}");
        }
        
        if (record.getAreaInfo() != null) {
            sql.SET("area_info = #{record.areaInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getStatusContent() != null) {
            sql.SET("status_content = #{record.statusContent,jdbcType=VARCHAR}");
        }
        
        if (record.getBankTitle() != null) {
            sql.SET("bank_title = #{record.bankTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getBankAccountName() != null) {
            sql.SET("bank_account_name = #{record.bankAccountName,jdbcType=VARCHAR}");
        }
        
        if (record.getBankAccount() != null) {
            sql.SET("bank_account = #{record.bankAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getIdNumber() != null) {
            sql.SET("id_number = #{record.idNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getIdPositive() != null) {
            sql.SET("id_positive = #{record.idPositive,jdbcType=VARCHAR}");
        }
        
        if (record.getIdObverse() != null) {
            sql.SET("id_obverse = #{record.idObverse,jdbcType=VARCHAR}");
        }
        
        if (record.getMchId() != null) {
            sql.SET("mch_id = #{record.mchId,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            sql.SET("account_id = #{record.accountId,jdbcType=BIGINT}");
        }
        
        if (record.getXfsjStatus() != null) {
            sql.SET("xfsj_status = #{record.xfsjStatus,jdbcType=INTEGER}");
        }
        
        if (record.getLegalName() != null) {
            sql.SET("legal_name = #{record.legalName,jdbcType=VARCHAR}");
        }
        
        if (record.getLegalIdCard() != null) {
            sql.SET("legal_id_card = #{record.legalIdCard,jdbcType=VARCHAR}");
        }
        
        if (record.getLegalIdPositive() != null) {
            sql.SET("legal_id_positive = #{record.legalIdPositive,jdbcType=VARCHAR}");
        }
        
        if (record.getLegalIdBack() != null) {
            sql.SET("legal_id_back = #{record.legalIdBack,jdbcType=VARCHAR}");
        }
        
        if (record.getSrcBusiness() != null) {
            sql.SET("src_business = #{record.srcBusiness,jdbcType=VARCHAR}");
        }
        
        if (record.getSrcCity() != null) {
            sql.SET("src_city = #{record.srcCity,jdbcType=INTEGER}");
        }
        
        if (record.getIsMandatary() != null) {
            sql.SET("is_mandatary = #{record.isMandatary,jdbcType=INTEGER}");
        }
        
        if (record.getMandataryName() != null) {
            sql.SET("mandatary_name = #{record.mandataryName,jdbcType=VARCHAR}");
        }
        
        if (record.getMandataryIdCard() != null) {
            sql.SET("mandatary_id_card = #{record.mandataryIdCard,jdbcType=VARCHAR}");
        }
        
        if (record.getMandataryIdPositive() != null) {
            sql.SET("mandatary_id_positive = #{record.mandataryIdPositive,jdbcType=VARCHAR}");
        }
        
        if (record.getMandataryIdBack() != null) {
            sql.SET("mandatary_id_back = #{record.mandataryIdBack,jdbcType=VARCHAR}");
        }
        
        if (record.getMandataryOther() != null) {
            sql.SET("mandatary_other = #{record.mandataryOther,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{record.tel,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.SET("audit_status = #{record.auditStatus,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_merchant_info");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("title_simple = #{record.titleSimple,jdbcType=VARCHAR}");
        sql.SET("introduction = #{record.introduction,jdbcType=VARCHAR}");
        sql.SET("business_scope = #{record.businessScope,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("registration_number = #{record.registrationNumber,jdbcType=VARCHAR}");
        sql.SET("organization_code = #{record.organizationCode,jdbcType=VARCHAR}");
        sql.SET("tex_registration_no = #{record.texRegistrationNo,jdbcType=VARCHAR}");
        sql.SET("business_license = #{record.businessLicense,jdbcType=VARCHAR}");
        sql.SET("is_other_license = #{record.isOtherLicense,jdbcType=INTEGER}");
        sql.SET("other_license = #{record.otherLicense,jdbcType=VARCHAR}");
        sql.SET("target_month_turnover = #{record.targetMonthTurnover,jdbcType=BIGINT}");
        sql.SET("contact_person = #{record.contactPerson,jdbcType=VARCHAR}");
        sql.SET("contact_phone = #{record.contactPhone,jdbcType=VARCHAR}");
        sql.SET("province_area_id = #{record.provinceAreaId,jdbcType=INTEGER}");
        sql.SET("city_area_id = #{record.cityAreaId,jdbcType=INTEGER}");
        sql.SET("area_id = #{record.areaId,jdbcType=INTEGER}");
        sql.SET("area_info = #{record.areaInfo,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("status_content = #{record.statusContent,jdbcType=VARCHAR}");
        sql.SET("bank_title = #{record.bankTitle,jdbcType=VARCHAR}");
        sql.SET("bank_account_name = #{record.bankAccountName,jdbcType=VARCHAR}");
        sql.SET("bank_account = #{record.bankAccount,jdbcType=VARCHAR}");
        sql.SET("id_number = #{record.idNumber,jdbcType=VARCHAR}");
        sql.SET("id_positive = #{record.idPositive,jdbcType=VARCHAR}");
        sql.SET("id_obverse = #{record.idObverse,jdbcType=VARCHAR}");
        sql.SET("mch_id = #{record.mchId,jdbcType=VARCHAR}");
        sql.SET("account_id = #{record.accountId,jdbcType=BIGINT}");
        sql.SET("xfsj_status = #{record.xfsjStatus,jdbcType=INTEGER}");
        sql.SET("legal_name = #{record.legalName,jdbcType=VARCHAR}");
        sql.SET("legal_id_card = #{record.legalIdCard,jdbcType=VARCHAR}");
        sql.SET("legal_id_positive = #{record.legalIdPositive,jdbcType=VARCHAR}");
        sql.SET("legal_id_back = #{record.legalIdBack,jdbcType=VARCHAR}");
        sql.SET("src_business = #{record.srcBusiness,jdbcType=VARCHAR}");
        sql.SET("src_city = #{record.srcCity,jdbcType=INTEGER}");
        sql.SET("is_mandatary = #{record.isMandatary,jdbcType=INTEGER}");
        sql.SET("mandatary_name = #{record.mandataryName,jdbcType=VARCHAR}");
        sql.SET("mandatary_id_card = #{record.mandataryIdCard,jdbcType=VARCHAR}");
        sql.SET("mandatary_id_positive = #{record.mandataryIdPositive,jdbcType=VARCHAR}");
        sql.SET("mandatary_id_back = #{record.mandataryIdBack,jdbcType=VARCHAR}");
        sql.SET("mandatary_other = #{record.mandataryOther,jdbcType=VARCHAR}");
        sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        sql.SET("tel = #{record.tel,jdbcType=VARCHAR}");
        sql.SET("audit_status = #{record.auditStatus,jdbcType=VARCHAR}");
        
        OpenMerchantInfoExample example = (OpenMerchantInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenMerchantInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("open_merchant_info");
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getTitleSimple() != null) {
            sql.SET("title_simple = #{titleSimple,jdbcType=VARCHAR}");
        }
        
        if (record.getIntroduction() != null) {
            sql.SET("introduction = #{introduction,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessScope() != null) {
            sql.SET("business_scope = #{businessScope,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRegistrationNumber() != null) {
            sql.SET("registration_number = #{registrationNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getOrganizationCode() != null) {
            sql.SET("organization_code = #{organizationCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTexRegistrationNo() != null) {
            sql.SET("tex_registration_no = #{texRegistrationNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBusinessLicense() != null) {
            sql.SET("business_license = #{businessLicense,jdbcType=VARCHAR}");
        }
        
        if (record.getIsOtherLicense() != null) {
            sql.SET("is_other_license = #{isOtherLicense,jdbcType=INTEGER}");
        }
        
        if (record.getOtherLicense() != null) {
            sql.SET("other_license = #{otherLicense,jdbcType=VARCHAR}");
        }
        
        if (record.getTargetMonthTurnover() != null) {
            sql.SET("target_month_turnover = #{targetMonthTurnover,jdbcType=BIGINT}");
        }
        
        if (record.getContactPerson() != null) {
            sql.SET("contact_person = #{contactPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getContactPhone() != null) {
            sql.SET("contact_phone = #{contactPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceAreaId() != null) {
            sql.SET("province_area_id = #{provinceAreaId,jdbcType=INTEGER}");
        }
        
        if (record.getCityAreaId() != null) {
            sql.SET("city_area_id = #{cityAreaId,jdbcType=INTEGER}");
        }
        
        if (record.getAreaId() != null) {
            sql.SET("area_id = #{areaId,jdbcType=INTEGER}");
        }
        
        if (record.getAreaInfo() != null) {
            sql.SET("area_info = #{areaInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getStatusContent() != null) {
            sql.SET("status_content = #{statusContent,jdbcType=VARCHAR}");
        }
        
        if (record.getBankTitle() != null) {
            sql.SET("bank_title = #{bankTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getBankAccountName() != null) {
            sql.SET("bank_account_name = #{bankAccountName,jdbcType=VARCHAR}");
        }
        
        if (record.getBankAccount() != null) {
            sql.SET("bank_account = #{bankAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getIdNumber() != null) {
            sql.SET("id_number = #{idNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getIdPositive() != null) {
            sql.SET("id_positive = #{idPositive,jdbcType=VARCHAR}");
        }
        
        if (record.getIdObverse() != null) {
            sql.SET("id_obverse = #{idObverse,jdbcType=VARCHAR}");
        }
        
        if (record.getMchId() != null) {
            sql.SET("mch_id = #{mchId,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            sql.SET("account_id = #{accountId,jdbcType=BIGINT}");
        }
        
        if (record.getXfsjStatus() != null) {
            sql.SET("xfsj_status = #{xfsjStatus,jdbcType=INTEGER}");
        }
        
        if (record.getLegalName() != null) {
            sql.SET("legal_name = #{legalName,jdbcType=VARCHAR}");
        }
        
        if (record.getLegalIdCard() != null) {
            sql.SET("legal_id_card = #{legalIdCard,jdbcType=VARCHAR}");
        }
        
        if (record.getLegalIdPositive() != null) {
            sql.SET("legal_id_positive = #{legalIdPositive,jdbcType=VARCHAR}");
        }
        
        if (record.getLegalIdBack() != null) {
            sql.SET("legal_id_back = #{legalIdBack,jdbcType=VARCHAR}");
        }
        
        if (record.getSrcBusiness() != null) {
            sql.SET("src_business = #{srcBusiness,jdbcType=VARCHAR}");
        }
        
        if (record.getSrcCity() != null) {
            sql.SET("src_city = #{srcCity,jdbcType=INTEGER}");
        }
        
        if (record.getIsMandatary() != null) {
            sql.SET("is_mandatary = #{isMandatary,jdbcType=INTEGER}");
        }
        
        if (record.getMandataryName() != null) {
            sql.SET("mandatary_name = #{mandataryName,jdbcType=VARCHAR}");
        }
        
        if (record.getMandataryIdCard() != null) {
            sql.SET("mandatary_id_card = #{mandataryIdCard,jdbcType=VARCHAR}");
        }
        
        if (record.getMandataryIdPositive() != null) {
            sql.SET("mandatary_id_positive = #{mandataryIdPositive,jdbcType=VARCHAR}");
        }
        
        if (record.getMandataryIdBack() != null) {
            sql.SET("mandatary_id_back = #{mandataryIdBack,jdbcType=VARCHAR}");
        }
        
        if (record.getMandataryOther() != null) {
            sql.SET("mandatary_other = #{mandataryOther,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.SET("audit_status = #{auditStatus,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenMerchantInfoExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }


    public String pageByExample(Map<String, Object> param) {
        OpenMerchantInfoExample example = (OpenMerchantInfoExample) param.get("example");
        SQL sql = new SQL();
        sql.SELECT(" * ");
        sql.FROM("open_merchant_info");
        applyWhere(sql, example, true);
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        return sql.toString();
    }
}