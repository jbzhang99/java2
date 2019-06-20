package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenServicePay;
import com.rfchina.community.persistence.model.OpenServicePayExample;
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

public interface OpenServicePayMapper extends Serializable {
    @SelectProvider(type=OpenServicePaySqlProvider.class, method="countByExample")
    long countByExample(OpenServicePayExample example);

    @DeleteProvider(type=OpenServicePaySqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenServicePayExample example);

    @Delete({
        "delete from open_service_pay",
        "where service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer serviceId);

    @Insert({
        "insert into open_service_pay (service_id, platform_fee, ",
        "think_rate, community_rate)",
        "values (#{serviceId,jdbcType=INTEGER}, #{platformFee,jdbcType=DECIMAL}, ",
        "#{thinkRate,jdbcType=DECIMAL}, #{communityRate,jdbcType=DECIMAL})"
    })
    int insert(OpenServicePay record);

    @InsertProvider(type=OpenServicePaySqlProvider.class, method="insertSelective")
    int insertSelective(OpenServicePay record);

    @SelectProvider(type=OpenServicePaySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="platform_fee", property="platformFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="think_rate", property="thinkRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="community_rate", property="communityRate", jdbcType=JdbcType.DECIMAL)
    })
    List<OpenServicePay> selectByExample(OpenServicePayExample example);

    @Select({
        "select",
        "service_id, platform_fee, think_rate, community_rate",
        "from open_service_pay",
        "where service_id = #{serviceId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="platform_fee", property="platformFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="think_rate", property="thinkRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="community_rate", property="communityRate", jdbcType=JdbcType.DECIMAL)
    })
    OpenServicePay selectByPrimaryKey(Integer serviceId);

    @UpdateProvider(type=OpenServicePaySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenServicePay record, @Param("example") OpenServicePayExample example);

    @UpdateProvider(type=OpenServicePaySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenServicePay record, @Param("example") OpenServicePayExample example);

    @UpdateProvider(type=OpenServicePaySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenServicePay record);

    @Update({
        "update open_service_pay",
        "set platform_fee = #{platformFee,jdbcType=DECIMAL},",
          "think_rate = #{thinkRate,jdbcType=DECIMAL},",
          "community_rate = #{communityRate,jdbcType=DECIMAL}",
        "where service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenServicePay record);
}