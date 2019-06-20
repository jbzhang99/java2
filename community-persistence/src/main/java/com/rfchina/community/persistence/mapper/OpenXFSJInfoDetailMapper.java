package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenXFSJInfoDetail;
import com.rfchina.community.persistence.model.OpenXFSJInfoDetailExample;
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

public interface OpenXFSJInfoDetailMapper extends Serializable {
    @SelectProvider(type=OpenXFSJInfoDetailSqlProvider.class, method="countByExample")
    long countByExample(OpenXFSJInfoDetailExample example);

    @DeleteProvider(type=OpenXFSJInfoDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenXFSJInfoDetailExample example);

    @Delete({
        "delete from open_xfsj_info_detail",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_xfsj_info_detail (id, detail)",
        "values (#{id,jdbcType=BIGINT}, #{detail,jdbcType=LONGVARCHAR})"
    })
    int insert(OpenXFSJInfoDetail record);

    @InsertProvider(type=OpenXFSJInfoDetailSqlProvider.class, method="insertSelective")
    int insertSelective(OpenXFSJInfoDetail record);

    @SelectProvider(type=OpenXFSJInfoDetailSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="detail", property="detail", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<OpenXFSJInfoDetail> selectByExampleWithBLOBs(OpenXFSJInfoDetailExample example);

    @SelectProvider(type=OpenXFSJInfoDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true)
    })
    List<OpenXFSJInfoDetail> selectByExample(OpenXFSJInfoDetailExample example);

    @Select({
        "select",
        "id, detail",
        "from open_xfsj_info_detail",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="detail", property="detail", jdbcType=JdbcType.LONGVARCHAR)
    })
    OpenXFSJInfoDetail selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenXFSJInfoDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenXFSJInfoDetail record, @Param("example") OpenXFSJInfoDetailExample example);

    @UpdateProvider(type=OpenXFSJInfoDetailSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") OpenXFSJInfoDetail record, @Param("example") OpenXFSJInfoDetailExample example);

    @UpdateProvider(type=OpenXFSJInfoDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenXFSJInfoDetail record, @Param("example") OpenXFSJInfoDetailExample example);

    @UpdateProvider(type=OpenXFSJInfoDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenXFSJInfoDetail record);

    @Update({
        "update open_xfsj_info_detail",
        "set detail = #{detail,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(OpenXFSJInfoDetail record);
}