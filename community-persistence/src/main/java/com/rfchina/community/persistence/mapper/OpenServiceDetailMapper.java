package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenServiceDetail;
import com.rfchina.community.persistence.model.OpenServiceDetailExample;
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

public interface OpenServiceDetailMapper extends Serializable {
    @SelectProvider(type=OpenServiceDetailSqlProvider.class, method="countByExample")
    long countByExample(OpenServiceDetailExample example);

    @DeleteProvider(type=OpenServiceDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenServiceDetailExample example);

    @Delete({
        "delete from open_service_detail",
        "where service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer serviceId);

    @Insert({
        "insert into open_service_detail (service_id, develop_type, ",
        "templete_name, templete_status, ",
        "app_index_sort, app_cat_sort, ",
        "rfchina_code, caution_refund_status, ",
        "caution_refund_reason, xfsj_status, ",
        "category_second_type, protocol_url, ",
        "verify_role)",
        "values (#{serviceId,jdbcType=INTEGER}, #{developType,jdbcType=VARCHAR}, ",
        "#{templeteName,jdbcType=VARCHAR}, #{templeteStatus,jdbcType=INTEGER}, ",
        "#{appIndexSort,jdbcType=INTEGER}, #{appCatSort,jdbcType=INTEGER}, ",
        "#{rfchinaCode,jdbcType=INTEGER}, #{cautionRefundStatus,jdbcType=INTEGER}, ",
        "#{cautionRefundReason,jdbcType=VARCHAR}, #{xfsjStatus,jdbcType=INTEGER}, ",
        "#{categorySecondType,jdbcType=INTEGER}, #{protocolUrl,jdbcType=VARCHAR}, ",
        "#{verifyRole,jdbcType=CHAR})"
    })
    int insert(OpenServiceDetail record);

    @InsertProvider(type=OpenServiceDetailSqlProvider.class, method="insertSelective")
    int insertSelective(OpenServiceDetail record);

    @SelectProvider(type=OpenServiceDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="develop_type", property="developType", jdbcType=JdbcType.VARCHAR),
        @Result(column="templete_name", property="templeteName", jdbcType=JdbcType.VARCHAR),
        @Result(column="templete_status", property="templeteStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="app_index_sort", property="appIndexSort", jdbcType=JdbcType.INTEGER),
        @Result(column="app_cat_sort", property="appCatSort", jdbcType=JdbcType.INTEGER),
        @Result(column="rfchina_code", property="rfchinaCode", jdbcType=JdbcType.INTEGER),
        @Result(column="caution_refund_status", property="cautionRefundStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="caution_refund_reason", property="cautionRefundReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="xfsj_status", property="xfsjStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="category_second_type", property="categorySecondType", jdbcType=JdbcType.INTEGER),
        @Result(column="protocol_url", property="protocolUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="verify_role", property="verifyRole", jdbcType=JdbcType.CHAR)
    })
    List<OpenServiceDetail> selectByExample(OpenServiceDetailExample example);

    @Select({
        "select",
        "service_id, develop_type, templete_name, templete_status, app_index_sort, app_cat_sort, ",
        "rfchina_code, caution_refund_status, caution_refund_reason, xfsj_status, category_second_type, ",
        "protocol_url, verify_role",
        "from open_service_detail",
        "where service_id = #{serviceId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="develop_type", property="developType", jdbcType=JdbcType.VARCHAR),
        @Result(column="templete_name", property="templeteName", jdbcType=JdbcType.VARCHAR),
        @Result(column="templete_status", property="templeteStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="app_index_sort", property="appIndexSort", jdbcType=JdbcType.INTEGER),
        @Result(column="app_cat_sort", property="appCatSort", jdbcType=JdbcType.INTEGER),
        @Result(column="rfchina_code", property="rfchinaCode", jdbcType=JdbcType.INTEGER),
        @Result(column="caution_refund_status", property="cautionRefundStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="caution_refund_reason", property="cautionRefundReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="xfsj_status", property="xfsjStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="category_second_type", property="categorySecondType", jdbcType=JdbcType.INTEGER),
        @Result(column="protocol_url", property="protocolUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="verify_role", property="verifyRole", jdbcType=JdbcType.CHAR)
    })
    OpenServiceDetail selectByPrimaryKey(Integer serviceId);

    @UpdateProvider(type=OpenServiceDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenServiceDetail record, @Param("example") OpenServiceDetailExample example);

    @UpdateProvider(type=OpenServiceDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenServiceDetail record, @Param("example") OpenServiceDetailExample example);

    @UpdateProvider(type=OpenServiceDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenServiceDetail record);

    @Update({
        "update open_service_detail",
        "set develop_type = #{developType,jdbcType=VARCHAR},",
          "templete_name = #{templeteName,jdbcType=VARCHAR},",
          "templete_status = #{templeteStatus,jdbcType=INTEGER},",
          "app_index_sort = #{appIndexSort,jdbcType=INTEGER},",
          "app_cat_sort = #{appCatSort,jdbcType=INTEGER},",
          "rfchina_code = #{rfchinaCode,jdbcType=INTEGER},",
          "caution_refund_status = #{cautionRefundStatus,jdbcType=INTEGER},",
          "caution_refund_reason = #{cautionRefundReason,jdbcType=VARCHAR},",
          "xfsj_status = #{xfsjStatus,jdbcType=INTEGER},",
          "category_second_type = #{categorySecondType,jdbcType=INTEGER},",
          "protocol_url = #{protocolUrl,jdbcType=VARCHAR},",
          "verify_role = #{verifyRole,jdbcType=CHAR}",
        "where service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenServiceDetail record);
}