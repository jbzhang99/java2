package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenServiceArea;
import com.rfchina.community.persistence.model.OpenServiceAreaExample;
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

public interface OpenServiceAreaMapper extends Serializable {
    @SelectProvider(type=OpenServiceAreaSqlProvider.class, method="countByExample")
    long countByExample(OpenServiceAreaExample example);

    @DeleteProvider(type=OpenServiceAreaSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenServiceAreaExample example);

    @Delete({
        "delete from open_service_area",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into open_service_area (service_id, area_id)",
        "values (#{serviceId,jdbcType=INTEGER}, #{areaId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(OpenServiceArea record);

    @InsertProvider(type=OpenServiceAreaSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(OpenServiceArea record);

    @SelectProvider(type=OpenServiceAreaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER)
    })
    List<OpenServiceArea> selectByExample(OpenServiceAreaExample example);

    @Select({
        "select",
        "id, service_id, area_id",
        "from open_service_area",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER)
    })
    OpenServiceArea selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpenServiceAreaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenServiceArea record, @Param("example") OpenServiceAreaExample example);

    @UpdateProvider(type=OpenServiceAreaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenServiceArea record, @Param("example") OpenServiceAreaExample example);

    @UpdateProvider(type=OpenServiceAreaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenServiceArea record);

    @Update({
        "update open_service_area",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "area_id = #{areaId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenServiceArea record);
}