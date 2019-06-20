package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenTempletInfo;
import com.rfchina.community.persistence.model.OpenTempletInfoExample;
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

public interface OpenTempletInfoMapper extends Serializable {
    @SelectProvider(type=OpenTempletInfoSqlProvider.class, method="countByExample")
    long countByExample(OpenTempletInfoExample example);

    @DeleteProvider(type=OpenTempletInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenTempletInfoExample example);

    @Delete({
        "delete from open_templet_info",
        "where templete_name = #{templeteName,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String templeteName);

    @Insert({
        "insert into open_templet_info (templete_name, title, ",
        "orderby, remarks, ",
        "install_bank, status, ",
        "pic, qrcod_pic, tags)",
        "values (#{templeteName,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR}, ",
        "#{orderby,jdbcType=INTEGER}, #{remarks,jdbcType=VARCHAR}, ",
        "#{installBank,jdbcType=CHAR}, #{status,jdbcType=INTEGER}, ",
        "#{pic,jdbcType=VARCHAR}, #{qrcodPic,jdbcType=VARCHAR}, #{tags,jdbcType=VARCHAR})"
    })
    int insert(OpenTempletInfo record);

    @InsertProvider(type=OpenTempletInfoSqlProvider.class, method="insertSelective")
    int insertSelective(OpenTempletInfo record);

    @SelectProvider(type=OpenTempletInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="templete_name", property="templeteName", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="orderby", property="orderby", jdbcType=JdbcType.INTEGER),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR),
        @Result(column="install_bank", property="installBank", jdbcType=JdbcType.CHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
        @Result(column="qrcod_pic", property="qrcodPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="tags", property="tags", jdbcType=JdbcType.VARCHAR)
    })
    List<OpenTempletInfo> selectByExample(OpenTempletInfoExample example);

    @Select({
        "select",
        "templete_name, title, orderby, remarks, install_bank, status, pic, qrcod_pic, ",
        "tags",
        "from open_templet_info",
        "where templete_name = #{templeteName,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="templete_name", property="templeteName", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="orderby", property="orderby", jdbcType=JdbcType.INTEGER),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR),
        @Result(column="install_bank", property="installBank", jdbcType=JdbcType.CHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
        @Result(column="qrcod_pic", property="qrcodPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="tags", property="tags", jdbcType=JdbcType.VARCHAR)
    })
    OpenTempletInfo selectByPrimaryKey(String templeteName);

    @UpdateProvider(type=OpenTempletInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenTempletInfo record, @Param("example") OpenTempletInfoExample example);

    @UpdateProvider(type=OpenTempletInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenTempletInfo record, @Param("example") OpenTempletInfoExample example);

    @UpdateProvider(type=OpenTempletInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenTempletInfo record);

    @Update({
        "update open_templet_info",
        "set title = #{title,jdbcType=VARCHAR},",
          "orderby = #{orderby,jdbcType=INTEGER},",
          "remarks = #{remarks,jdbcType=VARCHAR},",
          "install_bank = #{installBank,jdbcType=CHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "pic = #{pic,jdbcType=VARCHAR},",
          "qrcod_pic = #{qrcodPic,jdbcType=VARCHAR},",
          "tags = #{tags,jdbcType=VARCHAR}",
        "where templete_name = #{templeteName,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(OpenTempletInfo record);
}