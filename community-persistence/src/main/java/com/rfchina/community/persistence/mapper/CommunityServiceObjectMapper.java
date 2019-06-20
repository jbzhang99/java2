package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityServiceObject;
import com.rfchina.community.persistence.model.CommunityServiceObjectExample;
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

public interface CommunityServiceObjectMapper extends Serializable {
    @SelectProvider(type=CommunityServiceObjectSqlProvider.class, method="countByExample")
    long countByExample(CommunityServiceObjectExample example);

    @DeleteProvider(type=CommunityServiceObjectSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityServiceObjectExample example);

    @Delete({
        "delete from community_service_object",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into community_service_object (service_id, target_object)",
        "values (#{serviceId,jdbcType=INTEGER}, #{targetObject,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CommunityServiceObject record);

    @InsertProvider(type=CommunityServiceObjectSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(CommunityServiceObject record);

    @SelectProvider(type=CommunityServiceObjectSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="target_object", property="targetObject", jdbcType=JdbcType.TINYINT)
    })
    List<CommunityServiceObject> selectByExample(CommunityServiceObjectExample example);

    @Select({
        "select",
        "id, service_id, target_object",
        "from community_service_object",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="target_object", property="targetObject", jdbcType=JdbcType.TINYINT)
    })
    CommunityServiceObject selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CommunityServiceObjectSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityServiceObject record, @Param("example") CommunityServiceObjectExample example);

    @UpdateProvider(type=CommunityServiceObjectSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityServiceObject record, @Param("example") CommunityServiceObjectExample example);

    @UpdateProvider(type=CommunityServiceObjectSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityServiceObject record);

    @Update({
        "update community_service_object",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "target_object = #{targetObject,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommunityServiceObject record);
}