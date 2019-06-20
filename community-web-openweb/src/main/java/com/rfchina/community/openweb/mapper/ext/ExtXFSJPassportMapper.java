//package com.rfchina.community.openweb.mapper.ext;
//
//import java.io.Serializable;
//
//import org.apache.ibatis.annotations.Result;
//import org.apache.ibatis.annotations.Results;
//import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.UpdateProvider;
//import org.apache.ibatis.type.JdbcType;
//
//import com.rfchina.community.persistence.model.Passport;
//
//public interface ExtXFSJPassportMapper extends Serializable{
//
//	@UpdateProvider(type=ExtXFSJPassportSqlProvider.class, method="updateByUserName")
//	int updateByUserName(Passport passprot);
//
//	@UpdateProvider(type=ExtXFSJPassportSqlProvider.class, method="updateByPrimaryKeySelective")
//	int updateByPrimaryKeySelective(Passport passprot);
//
//	@Select({
//		"select",
//		"id, password",
//		"from rf_passport",
//		"where username = #{username,jdbcType=VARCHAR} and app_id = #{appId,jdbcType=VARCHAR} and status = 1"
//	})
//	@Results({
//		@Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
//		@Result(column="password", property="password", jdbcType=JdbcType.VARCHAR)
//	})
//	Passport queryOldPasswd(Passport passprot);
//}
