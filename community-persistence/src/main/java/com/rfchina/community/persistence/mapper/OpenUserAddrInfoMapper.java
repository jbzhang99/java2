package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenUserAddrInfo;
import com.rfchina.community.persistence.model.OpenUserAddrInfoExample;
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

public interface OpenUserAddrInfoMapper extends Serializable {
    @SelectProvider(type=OpenUserAddrInfoSqlProvider.class, method="countByExample")
    long countByExample(OpenUserAddrInfoExample example);

    @DeleteProvider(type=OpenUserAddrInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenUserAddrInfoExample example);

    @Delete({
        "delete from open_user_addr_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into open_user_addr_info (user_id, user_name, ",
        "mobile, detail_addr, ",
        "is_default, valid_status, ",
        "create_time, province_area_id, ",
        "city_area_id, area_id, ",
        "area_info)",
        "values (#{userId,jdbcType=BIGINT}, #{userName,jdbcType=VARCHAR}, ",
        "#{mobile,jdbcType=VARCHAR}, #{detailAddr,jdbcType=VARCHAR}, ",
        "#{isDefault,jdbcType=INTEGER}, #{validStatus,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{provinceAreaId,jdbcType=VARCHAR}, ",
        "#{cityAreaId,jdbcType=VARCHAR}, #{areaId,jdbcType=VARCHAR}, ",
        "#{areaInfo,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(OpenUserAddrInfo record);

    @InsertProvider(type=OpenUserAddrInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(OpenUserAddrInfo record);

    @SelectProvider(type=OpenUserAddrInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail_addr", property="detailAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_default", property="isDefault", jdbcType=JdbcType.INTEGER),
        @Result(column="valid_status", property="validStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="province_area_id", property="provinceAreaId", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_area_id", property="cityAreaId", jdbcType=JdbcType.VARCHAR),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.VARCHAR),
        @Result(column="area_info", property="areaInfo", jdbcType=JdbcType.VARCHAR)
    })
    List<OpenUserAddrInfo> selectByExample(OpenUserAddrInfoExample example);

    @Select({
        "select",
        "id, user_id, user_name, mobile, detail_addr, is_default, valid_status, create_time, ",
        "province_area_id, city_area_id, area_id, area_info",
        "from open_user_addr_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail_addr", property="detailAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_default", property="isDefault", jdbcType=JdbcType.INTEGER),
        @Result(column="valid_status", property="validStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="province_area_id", property="provinceAreaId", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_area_id", property="cityAreaId", jdbcType=JdbcType.VARCHAR),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.VARCHAR),
        @Result(column="area_info", property="areaInfo", jdbcType=JdbcType.VARCHAR)
    })
    OpenUserAddrInfo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpenUserAddrInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenUserAddrInfo record, @Param("example") OpenUserAddrInfoExample example);

    @UpdateProvider(type=OpenUserAddrInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenUserAddrInfo record, @Param("example") OpenUserAddrInfoExample example);

    @UpdateProvider(type=OpenUserAddrInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenUserAddrInfo record);

    @Update({
        "update open_user_addr_info",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "detail_addr = #{detailAddr,jdbcType=VARCHAR},",
          "is_default = #{isDefault,jdbcType=INTEGER},",
          "valid_status = #{validStatus,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "province_area_id = #{provinceAreaId,jdbcType=VARCHAR},",
          "city_area_id = #{cityAreaId,jdbcType=VARCHAR},",
          "area_id = #{areaId,jdbcType=VARCHAR},",
          "area_info = #{areaInfo,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenUserAddrInfo record);
}