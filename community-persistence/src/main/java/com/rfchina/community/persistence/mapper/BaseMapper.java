package com.rfchina.community.persistence.mapper;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName BaseMapper
 * @Description TODO
 * @Author wlrllr
 * @Date 2018/12/24 11:44
 * @Version 1.0
 **/
public interface BaseMapper<T,TE,ID> extends Serializable{

    long countByExample(TE example);

    int deleteByExample(TE example);

    int deleteByPrimaryKey(ID id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(TE example);

    T selectByPrimaryKey(ID id);

    int updateByExampleSelective(@Param("record") T record, @Param("example") TE example);

    int updateByExample(@Param("record") T record, @Param("example") TE example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
