package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.UserDefaultHeadImg;
import com.rfchina.community.persistence.model.UserDefaultHeadImgExample;
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

public interface UserDefaultHeadImgMapper extends Serializable {
    @SelectProvider(type=UserDefaultHeadImgSqlProvider.class, method="countByExample")
    long countByExample(UserDefaultHeadImgExample example);

    @DeleteProvider(type=UserDefaultHeadImgSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserDefaultHeadImgExample example);

    @Delete({
        "delete from user_default_head_img",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user_default_head_img (user_head_img_url, create_time)",
        "values (#{userHeadImgUrl,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(UserDefaultHeadImg record);

    @InsertProvider(type=UserDefaultHeadImgSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(UserDefaultHeadImg record);

    @SelectProvider(type=UserDefaultHeadImgSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_head_img_url", property="userHeadImgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserDefaultHeadImg> selectByExample(UserDefaultHeadImgExample example);

    @Select({
        "select",
        "id, user_head_img_url, create_time",
        "from user_default_head_img",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_head_img_url", property="userHeadImgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    UserDefaultHeadImg selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserDefaultHeadImgSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserDefaultHeadImg record, @Param("example") UserDefaultHeadImgExample example);

    @UpdateProvider(type=UserDefaultHeadImgSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserDefaultHeadImg record, @Param("example") UserDefaultHeadImgExample example);

    @UpdateProvider(type=UserDefaultHeadImgSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserDefaultHeadImg record);

    @Update({
        "update user_default_head_img",
        "set user_head_img_url = #{userHeadImgUrl,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserDefaultHeadImg record);
}