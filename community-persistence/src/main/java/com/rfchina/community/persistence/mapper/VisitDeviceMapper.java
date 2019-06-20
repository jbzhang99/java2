package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VisitDevice;
import com.rfchina.community.persistence.model.VisitDeviceExample;
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

public interface VisitDeviceMapper extends Serializable {
    @SelectProvider(type=VisitDeviceSqlProvider.class, method="countByExample")
    long countByExample(VisitDeviceExample example);

    @DeleteProvider(type=VisitDeviceSqlProvider.class, method="deleteByExample")
    int deleteByExample(VisitDeviceExample example);

    @Delete({
        "delete from visit_device",
        "where item_id = #{itemId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String itemId);

    @Insert({
        "insert into visit_device (item_id, community_id, ",
        "title)",
        "values (#{itemId,jdbcType=VARCHAR}, #{communityId,jdbcType=INTEGER}, ",
        "#{title,jdbcType=VARCHAR})"
    })
    int insert(VisitDevice record);

    @InsertProvider(type=VisitDeviceSqlProvider.class, method="insertSelective")
    int insertSelective(VisitDevice record);

    @SelectProvider(type=VisitDeviceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR)
    })
    List<VisitDevice> selectByExample(VisitDeviceExample example);

    @Select({
        "select",
        "item_id, community_id, title",
        "from visit_device",
        "where item_id = #{itemId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR)
    })
    VisitDevice selectByPrimaryKey(String itemId);

    @UpdateProvider(type=VisitDeviceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VisitDevice record, @Param("example") VisitDeviceExample example);

    @UpdateProvider(type=VisitDeviceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VisitDevice record, @Param("example") VisitDeviceExample example);

    @UpdateProvider(type=VisitDeviceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VisitDevice record);

    @Update({
        "update visit_device",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR}",
        "where item_id = #{itemId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(VisitDevice record);
}