package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VisitVisitorBlack;
import com.rfchina.community.persistence.model.VisitVisitorBlackExample;
import com.rfchina.community.persistence.model.VisitVisitorBlackKey;
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

public interface VisitVisitorBlackMapper extends Serializable {
    @SelectProvider(type=VisitVisitorBlackSqlProvider.class, method="countByExample")
    long countByExample(VisitVisitorBlackExample example);

    @DeleteProvider(type=VisitVisitorBlackSqlProvider.class, method="deleteByExample")
    int deleteByExample(VisitVisitorBlackExample example);

    @Delete({
        "delete from visit_visitor_black",
        "where community_id = #{communityId,jdbcType=INTEGER}",
          "and phone = #{phone,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(VisitVisitorBlackKey key);

    @Insert({
        "insert into visit_visitor_black (community_id, phone, ",
        "status)",
        "values (#{communityId,jdbcType=INTEGER}, #{phone,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER})"
    })
    int insert(VisitVisitorBlack record);

    @InsertProvider(type=VisitVisitorBlackSqlProvider.class, method="insertSelective")
    int insertSelective(VisitVisitorBlack record);

    @SelectProvider(type=VisitVisitorBlackSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<VisitVisitorBlack> selectByExample(VisitVisitorBlackExample example);

    @Select({
        "select",
        "community_id, phone, status",
        "from visit_visitor_black",
        "where community_id = #{communityId,jdbcType=INTEGER}",
          "and phone = #{phone,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    VisitVisitorBlack selectByPrimaryKey(VisitVisitorBlackKey key);

    @UpdateProvider(type=VisitVisitorBlackSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VisitVisitorBlack record, @Param("example") VisitVisitorBlackExample example);

    @UpdateProvider(type=VisitVisitorBlackSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VisitVisitorBlack record, @Param("example") VisitVisitorBlackExample example);

    @UpdateProvider(type=VisitVisitorBlackSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VisitVisitorBlack record);

    @Update({
        "update visit_visitor_black",
        "set status = #{status,jdbcType=INTEGER}",
        "where community_id = #{communityId,jdbcType=INTEGER}",
          "and phone = #{phone,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(VisitVisitorBlack record);
}