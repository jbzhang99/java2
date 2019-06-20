package com.rfchina.community.service;

import com.rfchina.community.base.exception.WorkRunTimeException;
import com.rfchina.community.persistence.mapper.BaseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

/**
 */
public abstract class AbstractService<T,TE,ID extends Serializable> {

	public abstract BaseMapper<T,TE, ID> getMapper() ;

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public static void error(String msg) {
		throw new WorkRunTimeException(msg);
	}

	protected void error(Exception e) {
		throw new RuntimeException(e);
	}

	protected void validator(boolean fag, String msg) {
		if (fag) {
			error(msg);
		}
	}

	public long countByExample(TE example){
		return getMapper().countByExample(example);
	}

	public int deleteByExample(TE example){
		return getMapper().deleteByExample(example);
	}

	public int deleteByPrimaryKey(ID id){
		return getMapper().deleteByPrimaryKey(id);
	}

	public int insert(T record){
		return getMapper().insert(record);
	}

	public int insertSelective(T record) {
		return getMapper().insertSelective(record);
	}

	public List<T> selectByExample(TE example){
		return getMapper().selectByExample(example);
	}

	public T selectByPrimaryKey(ID id){
		return getMapper().selectByPrimaryKey(id);
	}
	public int updateByPrimaryKeySelective(T record) {
		return getMapper().updateByPrimaryKeySelective(record);
	}
	public int updateByExampleSelective(T record, TE example){
		return getMapper().updateByExampleSelective(record,example);
	}

	public int updateByExample(T record, TE example){
		return getMapper().updateByExample(record,example);
	}

	public int updateByPrimaryKey(T record) {
		return getMapper().updateByPrimaryKey(record);
	}

}
