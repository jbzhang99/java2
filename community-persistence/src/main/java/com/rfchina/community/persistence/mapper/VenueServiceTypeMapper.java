package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VenueServiceType;
import com.rfchina.community.persistence.model.VenueServiceTypeExample;
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

public interface VenueServiceTypeMapper extends Serializable {
    @SelectProvider(type=VenueServiceTypeSqlProvider.class, method="countByExample")
    long countByExample(VenueServiceTypeExample example);

    @DeleteProvider(type=VenueServiceTypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(VenueServiceTypeExample example);

    @Delete({
        "delete from venue_service_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into venue_service_type (community_id, title)",
        "values (#{communityId,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(VenueServiceType record);

    @InsertProvider(type=VenueServiceTypeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(VenueServiceType record);

    @SelectProvider(type=VenueServiceTypeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR)
    })
    List<VenueServiceType> selectByExample(VenueServiceTypeExample example);

    @Select({
        "select",
        "id, community_id, title",
        "from venue_service_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR)
    })
    VenueServiceType selectByPrimaryKey(Integer id);

    @UpdateProvider(type=VenueServiceTypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VenueServiceType record, @Param("example") VenueServiceTypeExample example);

    @UpdateProvider(type=VenueServiceTypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VenueServiceType record, @Param("example") VenueServiceTypeExample example);

    @UpdateProvider(type=VenueServiceTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VenueServiceType record);

    @Update({
        "update venue_service_type",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(VenueServiceType record);
}