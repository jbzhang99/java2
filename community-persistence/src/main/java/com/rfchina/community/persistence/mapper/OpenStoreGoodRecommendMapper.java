package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreGoodRecommend;
import com.rfchina.community.persistence.model.OpenStoreGoodRecommendExample;
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

public interface OpenStoreGoodRecommendMapper extends Serializable {
    @SelectProvider(type=OpenStoreGoodRecommendSqlProvider.class, method="countByExample")
    long countByExample(OpenStoreGoodRecommendExample example);

    @DeleteProvider(type=OpenStoreGoodRecommendSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenStoreGoodRecommendExample example);

    @Delete({
        "delete from open_store_good_recommend",
        "where good_id = #{goodId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer goodId);

    @Insert({
        "insert into open_store_good_recommend (good_id, service_id, ",
        "status, is_use_main_pic, ",
        "show_pic, remark, ",
        "sorting, create_time, ",
        "update_time)",
        "values (#{goodId,jdbcType=INTEGER}, #{serviceId,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{isUseMainPic,jdbcType=INTEGER}, ",
        "#{showPic,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{sorting,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(OpenStoreGoodRecommend record);

    @InsertProvider(type=OpenStoreGoodRecommendSqlProvider.class, method="insertSelective")
    int insertSelective(OpenStoreGoodRecommend record);

    @SelectProvider(type=OpenStoreGoodRecommendSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="is_use_main_pic", property="isUseMainPic", jdbcType=JdbcType.INTEGER),
        @Result(column="show_pic", property="showPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenStoreGoodRecommend> selectByExample(OpenStoreGoodRecommendExample example);

    @Select({
        "select",
        "good_id, service_id, status, is_use_main_pic, show_pic, remark, sorting, create_time, ",
        "update_time",
        "from open_store_good_recommend",
        "where good_id = #{goodId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="is_use_main_pic", property="isUseMainPic", jdbcType=JdbcType.INTEGER),
        @Result(column="show_pic", property="showPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenStoreGoodRecommend selectByPrimaryKey(Integer goodId);

    @UpdateProvider(type=OpenStoreGoodRecommendSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenStoreGoodRecommend record, @Param("example") OpenStoreGoodRecommendExample example);

    @UpdateProvider(type=OpenStoreGoodRecommendSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenStoreGoodRecommend record, @Param("example") OpenStoreGoodRecommendExample example);

    @UpdateProvider(type=OpenStoreGoodRecommendSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenStoreGoodRecommend record);

    @Update({
        "update open_store_good_recommend",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "is_use_main_pic = #{isUseMainPic,jdbcType=INTEGER},",
          "show_pic = #{showPic,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "sorting = #{sorting,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where good_id = #{goodId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenStoreGoodRecommend record);
}