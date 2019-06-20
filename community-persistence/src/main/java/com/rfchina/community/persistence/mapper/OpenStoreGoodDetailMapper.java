package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreGoodDetail;
import com.rfchina.community.persistence.model.OpenStoreGoodDetailExample;
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

public interface OpenStoreGoodDetailMapper extends Serializable {
    @SelectProvider(type=OpenStoreGoodDetailSqlProvider.class, method="countByExample")
    long countByExample(OpenStoreGoodDetailExample example);

    @DeleteProvider(type=OpenStoreGoodDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenStoreGoodDetailExample example);

    @Delete({
        "delete from open_store_good_detail",
        "where good_id = #{goodId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer goodId);

    @Insert({
        "insert into open_store_good_detail (good_id, detail)",
        "values (#{goodId,jdbcType=INTEGER}, #{detail,jdbcType=LONGVARCHAR})"
    })
    int insert(OpenStoreGoodDetail record);

    @InsertProvider(type=OpenStoreGoodDetailSqlProvider.class, method="insertSelective")
    int insertSelective(OpenStoreGoodDetail record);

    @SelectProvider(type=OpenStoreGoodDetailSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="detail", property="detail", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<OpenStoreGoodDetail> selectByExampleWithBLOBs(OpenStoreGoodDetailExample example);

    @SelectProvider(type=OpenStoreGoodDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<OpenStoreGoodDetail> selectByExample(OpenStoreGoodDetailExample example);

    @Select({
        "select",
        "good_id, detail",
        "from open_store_good_detail",
        "where good_id = #{goodId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="detail", property="detail", jdbcType=JdbcType.LONGVARCHAR)
    })
    OpenStoreGoodDetail selectByPrimaryKey(Integer goodId);

    @UpdateProvider(type=OpenStoreGoodDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenStoreGoodDetail record, @Param("example") OpenStoreGoodDetailExample example);

    @UpdateProvider(type=OpenStoreGoodDetailSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") OpenStoreGoodDetail record, @Param("example") OpenStoreGoodDetailExample example);

    @UpdateProvider(type=OpenStoreGoodDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenStoreGoodDetail record, @Param("example") OpenStoreGoodDetailExample example);

    @UpdateProvider(type=OpenStoreGoodDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenStoreGoodDetail record);

    @Update({
        "update open_store_good_detail",
        "set detail = #{detail,jdbcType=LONGVARCHAR}",
        "where good_id = #{goodId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(OpenStoreGoodDetail record);
}