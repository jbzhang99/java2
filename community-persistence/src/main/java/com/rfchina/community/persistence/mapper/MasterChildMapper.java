package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.MasterChild;
import com.rfchina.community.persistence.model.MasterChildExample;
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

public interface MasterChildMapper extends Serializable {
    @SelectProvider(type=MasterChildSqlProvider.class, method="countByExample")
    long countByExample(MasterChildExample example);

    @DeleteProvider(type=MasterChildSqlProvider.class, method="deleteByExample")
    int deleteByExample(MasterChildExample example);

    @Delete({
        "delete from master_child",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into master_child (community_id, uid, ",
        "phone, master_id, ",
        "name, sex, pic, ",
        "tel, type, staff_type, ",
        "status, dept_name, ",
        "create_time, comment, ",
        "parking_number, plate_number, ",
        "parking_type, store_name, ",
        "store_number, store_type, ",
        "update_time, first_name, ",
        "first_phone, email)",
        "values (#{communityId,jdbcType=INTEGER}, #{uid,jdbcType=BIGINT}, ",
        "#{phone,jdbcType=VARCHAR}, #{masterId,jdbcType=BIGINT}, ",
        "#{name,jdbcType=VARCHAR}, #{sex,jdbcType=TINYINT}, #{pic,jdbcType=VARCHAR}, ",
        "#{tel,jdbcType=VARCHAR}, #{type,jdbcType=INTEGER}, #{staffType,jdbcType=INTEGER}, ",
        "#{status,jdbcType=TINYINT}, #{deptName,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{comment,jdbcType=VARCHAR}, ",
        "#{parkingNumber,jdbcType=VARCHAR}, #{plateNumber,jdbcType=VARCHAR}, ",
        "#{parkingType,jdbcType=INTEGER}, #{storeName,jdbcType=VARCHAR}, ",
        "#{storeNumber,jdbcType=VARCHAR}, #{storeType,jdbcType=INTEGER}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{firstName,jdbcType=VARCHAR}, ",
        "#{firstPhone,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(MasterChild record);

    @InsertProvider(type=MasterChildSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(MasterChild record);

    @SelectProvider(type=MasterChildSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="staff_type", property="staffType", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="dept_name", property="deptName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="parking_number", property="parkingNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="plate_number", property="plateNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="parking_type", property="parkingType", jdbcType=JdbcType.INTEGER),
        @Result(column="store_name", property="storeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_number", property="storeNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_type", property="storeType", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="first_name", property="firstName", jdbcType=JdbcType.VARCHAR),
        @Result(column="first_phone", property="firstPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR)
    })
    List<MasterChild> selectByExample(MasterChildExample example);

    @Select({
        "select",
        "id, community_id, uid, phone, master_id, name, sex, pic, tel, type, staff_type, ",
        "status, dept_name, create_time, comment, parking_number, plate_number, parking_type, ",
        "store_name, store_number, store_type, update_time, first_name, first_phone, ",
        "email",
        "from master_child",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="staff_type", property="staffType", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="dept_name", property="deptName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="parking_number", property="parkingNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="plate_number", property="plateNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="parking_type", property="parkingType", jdbcType=JdbcType.INTEGER),
        @Result(column="store_name", property="storeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_number", property="storeNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_type", property="storeType", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="first_name", property="firstName", jdbcType=JdbcType.VARCHAR),
        @Result(column="first_phone", property="firstPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR)
    })
    MasterChild selectByPrimaryKey(Long id);

    @UpdateProvider(type=MasterChildSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MasterChild record, @Param("example") MasterChildExample example);

    @UpdateProvider(type=MasterChildSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MasterChild record, @Param("example") MasterChildExample example);

    @UpdateProvider(type=MasterChildSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MasterChild record);

    @Update({
        "update master_child",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "uid = #{uid,jdbcType=BIGINT},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "master_id = #{masterId,jdbcType=BIGINT},",
          "name = #{name,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=TINYINT},",
          "pic = #{pic,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "staff_type = #{staffType,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT},",
          "dept_name = #{deptName,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "comment = #{comment,jdbcType=VARCHAR},",
          "parking_number = #{parkingNumber,jdbcType=VARCHAR},",
          "plate_number = #{plateNumber,jdbcType=VARCHAR},",
          "parking_type = #{parkingType,jdbcType=INTEGER},",
          "store_name = #{storeName,jdbcType=VARCHAR},",
          "store_number = #{storeNumber,jdbcType=VARCHAR},",
          "store_type = #{storeType,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "first_name = #{firstName,jdbcType=VARCHAR},",
          "first_phone = #{firstPhone,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MasterChild record);
}