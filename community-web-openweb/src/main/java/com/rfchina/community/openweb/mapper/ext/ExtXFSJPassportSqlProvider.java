//package com.rfchina.community.openweb.mapper.ext;
//
//import org.apache.ibatis.jdbc.SQL;
//
//import com.rfchina.community.persistence.mapper.PassportSqlProvider;
//import com.rfchina.community.persistence.model.Passport;
//
//public class ExtXFSJPassportSqlProvider extends PassportSqlProvider {
//
//	public String updateByUserName(Passport passport) {
//		SQL sql = new SQL();
//        sql.UPDATE("rf_passport");
//
//        if (passport.getPassword() != null) {
//            sql.SET("password = #{password,jdbcType=VARCHAR}");
//        }
//
//        if (passport.getUpdateTime() != null) {
//            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
//        }
//        //状态1为启用
//        sql.WHERE("username = #{username,jdbcType=VARCHAR} and app_id = #{appId,jdbcType=VARCHAR} and status = 1");
//
//        return sql.toString();
//	}
//}
