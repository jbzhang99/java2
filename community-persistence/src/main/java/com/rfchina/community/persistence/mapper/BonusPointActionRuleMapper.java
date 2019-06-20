package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.BonusPointActionRule;
import com.rfchina.community.persistence.model.BonusPointActionRuleExample;
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

public interface BonusPointActionRuleMapper extends Serializable {
    @SelectProvider(type=BonusPointActionRuleSqlProvider.class, method="countByExample")
    long countByExample(BonusPointActionRuleExample example);

    @DeleteProvider(type=BonusPointActionRuleSqlProvider.class, method="deleteByExample")
    int deleteByExample(BonusPointActionRuleExample example);

    @Delete({
        "delete from bonus_point_action_rule",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into bonus_point_action_rule (action, bp_rule, ",
        "bp_value, bp_rule_desc, ",
        "reward_rule, reward_value, ",
        "start_active_time, end_active_time, ",
        "active)",
        "values (#{action,jdbcType=VARCHAR}, #{bpRule,jdbcType=VARCHAR}, ",
        "#{bpValue,jdbcType=INTEGER}, #{bpRuleDesc,jdbcType=VARCHAR}, ",
        "#{rewardRule,jdbcType=VARCHAR}, #{rewardValue,jdbcType=INTEGER}, ",
        "#{startActiveTime,jdbcType=TIMESTAMP}, #{endActiveTime,jdbcType=TIMESTAMP}, ",
        "#{active,jdbcType=BIT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(BonusPointActionRule record);

    @InsertProvider(type=BonusPointActionRuleSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(BonusPointActionRule record);

    @SelectProvider(type=BonusPointActionRuleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="bp_rule", property="bpRule", jdbcType=JdbcType.VARCHAR),
        @Result(column="bp_value", property="bpValue", jdbcType=JdbcType.INTEGER),
        @Result(column="bp_rule_desc", property="bpRuleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="reward_rule", property="rewardRule", jdbcType=JdbcType.VARCHAR),
        @Result(column="reward_value", property="rewardValue", jdbcType=JdbcType.INTEGER),
        @Result(column="start_active_time", property="startActiveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_active_time", property="endActiveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="active", property="active", jdbcType=JdbcType.BIT)
    })
    List<BonusPointActionRule> selectByExample(BonusPointActionRuleExample example);

    @Select({
        "select",
        "id, action, bp_rule, bp_value, bp_rule_desc, reward_rule, reward_value, start_active_time, ",
        "end_active_time, active",
        "from bonus_point_action_rule",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="bp_rule", property="bpRule", jdbcType=JdbcType.VARCHAR),
        @Result(column="bp_value", property="bpValue", jdbcType=JdbcType.INTEGER),
        @Result(column="bp_rule_desc", property="bpRuleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="reward_rule", property="rewardRule", jdbcType=JdbcType.VARCHAR),
        @Result(column="reward_value", property="rewardValue", jdbcType=JdbcType.INTEGER),
        @Result(column="start_active_time", property="startActiveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_active_time", property="endActiveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="active", property="active", jdbcType=JdbcType.BIT)
    })
    BonusPointActionRule selectByPrimaryKey(Integer id);

    @UpdateProvider(type=BonusPointActionRuleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BonusPointActionRule record, @Param("example") BonusPointActionRuleExample example);

    @UpdateProvider(type=BonusPointActionRuleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BonusPointActionRule record, @Param("example") BonusPointActionRuleExample example);

    @UpdateProvider(type=BonusPointActionRuleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BonusPointActionRule record);

    @Update({
        "update bonus_point_action_rule",
        "set action = #{action,jdbcType=VARCHAR},",
          "bp_rule = #{bpRule,jdbcType=VARCHAR},",
          "bp_value = #{bpValue,jdbcType=INTEGER},",
          "bp_rule_desc = #{bpRuleDesc,jdbcType=VARCHAR},",
          "reward_rule = #{rewardRule,jdbcType=VARCHAR},",
          "reward_value = #{rewardValue,jdbcType=INTEGER},",
          "start_active_time = #{startActiveTime,jdbcType=TIMESTAMP},",
          "end_active_time = #{endActiveTime,jdbcType=TIMESTAMP},",
          "active = #{active,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BonusPointActionRule record);
}