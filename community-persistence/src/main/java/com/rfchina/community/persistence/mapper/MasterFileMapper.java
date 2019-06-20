package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.MasterFile;
import com.rfchina.community.persistence.model.MasterFileExample;
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

public interface MasterFileMapper extends Serializable {
    @SelectProvider(type=MasterFileSqlProvider.class, method="countByExample")
    long countByExample(MasterFileExample example);

    @DeleteProvider(type=MasterFileSqlProvider.class, method="deleteByExample")
    int deleteByExample(MasterFileExample example);

    @Delete({
        "delete from master_file",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into master_file (master_id, file_url, ",
        "name)",
        "values (#{masterId,jdbcType=BIGINT}, #{fileUrl,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(MasterFile record);

    @InsertProvider(type=MasterFileSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(MasterFile record);

    @SelectProvider(type=MasterFileSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="file_url", property="fileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<MasterFile> selectByExample(MasterFileExample example);

    @Select({
        "select",
        "id, master_id, file_url, name",
        "from master_file",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="file_url", property="fileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    MasterFile selectByPrimaryKey(Long id);

    @UpdateProvider(type=MasterFileSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MasterFile record, @Param("example") MasterFileExample example);

    @UpdateProvider(type=MasterFileSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MasterFile record, @Param("example") MasterFileExample example);

    @UpdateProvider(type=MasterFileSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MasterFile record);

    @Update({
        "update master_file",
        "set master_id = #{masterId,jdbcType=BIGINT},",
          "file_url = #{fileUrl,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MasterFile record);
}