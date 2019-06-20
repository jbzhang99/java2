package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.ExpressCompanyUsageMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface ExtExpressCompanyUsageMapper extends ExpressCompanyUsageMapper {

    @Update({
            "update express_company_usage set",
            "usage_count = usage_count + #{usageCount,jdbcType=INTEGER}",
            "where com_code = #{companyCode,jdbcType=VARCHAR} and service_id = #{serviceId,jdbcType=BIGINT}"
    })
    int addUsage(@Param("serviceId")Long serviceId, @Param("companyCode")String companyCode, @Param("usageCount")Integer usageCount);
}