package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysDataUpload;
import com.rfchina.community.persistence.model.SysDataUploadExample;
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

public interface SysDataUploadMapper extends Serializable {
    @SelectProvider(type=SysDataUploadSqlProvider.class, method="countByExample")
    long countByExample(SysDataUploadExample example);

    @DeleteProvider(type=SysDataUploadSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysDataUploadExample example);

    @Delete({
        "delete from sys_data_upload",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_data_upload (src_link, down_link, ",
        "create_time, create_uid, ",
        "community_id, master_id, ",
        "status, xlsx_index, ",
        "user_path, file_name, ",
        "test_run, error)",
        "values (#{srcLink,jdbcType=VARCHAR}, #{downLink,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{createUid,jdbcType=BIGINT}, ",
        "#{communityId,jdbcType=INTEGER}, #{masterId,jdbcType=BIGINT}, ",
        "#{status,jdbcType=INTEGER}, #{xlsxIndex,jdbcType=INTEGER}, ",
        "#{userPath,jdbcType=VARCHAR}, #{fileName,jdbcType=VARCHAR}, ",
        "#{testRun,jdbcType=INTEGER}, #{error,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SysDataUpload record);

    @InsertProvider(type=SysDataUploadSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(SysDataUpload record);

    @SelectProvider(type=SysDataUploadSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="src_link", property="srcLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="down_link", property="downLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="xlsx_index", property="xlsxIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="user_path", property="userPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_name", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_run", property="testRun", jdbcType=JdbcType.INTEGER),
        @Result(column="error", property="error", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<SysDataUpload> selectByExampleWithBLOBs(SysDataUploadExample example);

    @SelectProvider(type=SysDataUploadSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="src_link", property="srcLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="down_link", property="downLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="xlsx_index", property="xlsxIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="user_path", property="userPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_name", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_run", property="testRun", jdbcType=JdbcType.INTEGER)
    })
    List<SysDataUpload> selectByExample(SysDataUploadExample example);

    @Select({
        "select",
        "id, src_link, down_link, create_time, create_uid, community_id, master_id, status, ",
        "xlsx_index, user_path, file_name, test_run, error",
        "from sys_data_upload",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="src_link", property="srcLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="down_link", property="downLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="xlsx_index", property="xlsxIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="user_path", property="userPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_name", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_run", property="testRun", jdbcType=JdbcType.INTEGER),
        @Result(column="error", property="error", jdbcType=JdbcType.LONGVARCHAR)
    })
    SysDataUpload selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysDataUploadSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysDataUpload record, @Param("example") SysDataUploadExample example);

    @UpdateProvider(type=SysDataUploadSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") SysDataUpload record, @Param("example") SysDataUploadExample example);

    @UpdateProvider(type=SysDataUploadSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysDataUpload record, @Param("example") SysDataUploadExample example);

    @UpdateProvider(type=SysDataUploadSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysDataUpload record);

    @Update({
        "update sys_data_upload",
        "set src_link = #{srcLink,jdbcType=VARCHAR},",
          "down_link = #{downLink,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_uid = #{createUid,jdbcType=BIGINT},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "master_id = #{masterId,jdbcType=BIGINT},",
          "status = #{status,jdbcType=INTEGER},",
          "xlsx_index = #{xlsxIndex,jdbcType=INTEGER},",
          "user_path = #{userPath,jdbcType=VARCHAR},",
          "file_name = #{fileName,jdbcType=VARCHAR},",
          "test_run = #{testRun,jdbcType=INTEGER},",
          "error = #{error,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(SysDataUpload record);

    @Update({
        "update sys_data_upload",
        "set src_link = #{srcLink,jdbcType=VARCHAR},",
          "down_link = #{downLink,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_uid = #{createUid,jdbcType=BIGINT},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "master_id = #{masterId,jdbcType=BIGINT},",
          "status = #{status,jdbcType=INTEGER},",
          "xlsx_index = #{xlsxIndex,jdbcType=INTEGER},",
          "user_path = #{userPath,jdbcType=VARCHAR},",
          "file_name = #{fileName,jdbcType=VARCHAR},",
          "test_run = #{testRun,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysDataUpload record);
}