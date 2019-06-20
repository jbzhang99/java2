package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenMiniAdTab;
import com.rfchina.community.persistence.model.OpenMiniAdTabExample;
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

public interface OpenMiniAdTabMapper extends Serializable {
    @SelectProvider(type=OpenMiniAdTabSqlProvider.class, method="countByExample")
    long countByExample(OpenMiniAdTabExample example);

    @DeleteProvider(type=OpenMiniAdTabSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenMiniAdTabExample example);

    @Delete({
        "delete from open_mini_ad_tab",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_mini_ad_tab (mini_ad_info_id, serial_number, ",
        "type, target_id, ",
        "pic_url, create_time, ",
        "update_time)",
        "values (#{miniAdInfoId,jdbcType=BIGINT}, #{serialNumber,jdbcType=INTEGER}, ",
        "#{type,jdbcType=VARCHAR}, #{targetId,jdbcType=INTEGER}, ",
        "#{picUrl,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenMiniAdTab record);

    @InsertProvider(type=OpenMiniAdTabSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenMiniAdTab record);

    @SelectProvider(type=OpenMiniAdTabSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="mini_ad_info_id", property="miniAdInfoId", jdbcType=JdbcType.BIGINT),
        @Result(column="serial_number", property="serialNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="target_id", property="targetId", jdbcType=JdbcType.INTEGER),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenMiniAdTab> selectByExample(OpenMiniAdTabExample example);

    @Select({
        "select",
        "id, mini_ad_info_id, serial_number, type, target_id, pic_url, create_time, update_time",
        "from open_mini_ad_tab",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="mini_ad_info_id", property="miniAdInfoId", jdbcType=JdbcType.BIGINT),
        @Result(column="serial_number", property="serialNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="target_id", property="targetId", jdbcType=JdbcType.INTEGER),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenMiniAdTab selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenMiniAdTabSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenMiniAdTab record, @Param("example") OpenMiniAdTabExample example);

    @UpdateProvider(type=OpenMiniAdTabSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenMiniAdTab record, @Param("example") OpenMiniAdTabExample example);

    @UpdateProvider(type=OpenMiniAdTabSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenMiniAdTab record);

    @Update({
        "update open_mini_ad_tab",
        "set mini_ad_info_id = #{miniAdInfoId,jdbcType=BIGINT},",
          "serial_number = #{serialNumber,jdbcType=INTEGER},",
          "type = #{type,jdbcType=VARCHAR},",
          "target_id = #{targetId,jdbcType=INTEGER},",
          "pic_url = #{picUrl,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenMiniAdTab record);
}