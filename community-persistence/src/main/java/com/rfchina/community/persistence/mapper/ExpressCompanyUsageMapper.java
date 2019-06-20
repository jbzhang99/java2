package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ExpressCompanyUsage;
import com.rfchina.community.persistence.model.ExpressCompanyUsageExample;
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

public interface ExpressCompanyUsageMapper extends BaseMapper {
    @SelectProvider(type=ExpressCompanyUsageSqlProvider.class, method="countByExample")
    long countByExample(ExpressCompanyUsageExample example);

    @DeleteProvider(type=ExpressCompanyUsageSqlProvider.class, method="deleteByExample")
    int deleteByExample(ExpressCompanyUsageExample example);

    @Delete({
        "delete from express_company_usage",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into express_company_usage (status, service_id, ",
        "com_code, com_name, ",
        "usage_count, create_time)",
        "values (#{status,jdbcType=VARCHAR}, #{serviceId,jdbcType=BIGINT}, ",
        "#{comCode,jdbcType=VARCHAR}, #{comName,jdbcType=VARCHAR}, ",
        "#{usageCount,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ExpressCompanyUsage record);

    @InsertProvider(type=ExpressCompanyUsageSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ExpressCompanyUsage record);

    @SelectProvider(type=ExpressCompanyUsageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.BIGINT),
        @Result(column="com_code", property="comCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="com_name", property="comName", jdbcType=JdbcType.VARCHAR),
        @Result(column="usage_count", property="usageCount", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ExpressCompanyUsage> selectByExample(ExpressCompanyUsageExample example);

    @Select({
        "select",
        "id, status, service_id, com_code, com_name, usage_count, create_time",
        "from express_company_usage",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.BIGINT),
        @Result(column="com_code", property="comCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="com_name", property="comName", jdbcType=JdbcType.VARCHAR),
        @Result(column="usage_count", property="usageCount", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ExpressCompanyUsage selectByPrimaryKey(Long id);

    @UpdateProvider(type=ExpressCompanyUsageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ExpressCompanyUsage record, @Param("example") ExpressCompanyUsageExample example);

    @UpdateProvider(type=ExpressCompanyUsageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ExpressCompanyUsage record, @Param("example") ExpressCompanyUsageExample example);

    @UpdateProvider(type=ExpressCompanyUsageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ExpressCompanyUsage record);

    @Update({
        "update express_company_usage",
        "set status = #{status,jdbcType=VARCHAR},",
          "service_id = #{serviceId,jdbcType=BIGINT},",
          "com_code = #{comCode,jdbcType=VARCHAR},",
          "com_name = #{comName,jdbcType=VARCHAR},",
          "usage_count = #{usageCount,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ExpressCompanyUsage record);
}