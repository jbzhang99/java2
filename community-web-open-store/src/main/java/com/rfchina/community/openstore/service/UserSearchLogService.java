package com.rfchina.community.openstore.service;

import com.rfchina.community.openstore.task.NoticeExecutor;
import com.rfchina.community.persistence.mapper.UserSearchLogMapper;
import com.rfchina.community.persistence.model.UserSearchLog;
import com.rfchina.community.persistence.model.UserSearchLogExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserSearchLogService extends BaseService {

	@Autowired
	private UserSearchLogMapper userSearchLogMapper;

	public void addLogSysn(Long uid, String title) {
		NoticeExecutor.getExecutor().execute(() -> addLog(uid, title));
	}

	public int addLog(Long uid, String title) {
		title = StringUtils.trimToEmpty(title);
		if (title.length() == 0) {
			return 0;
		}

		if (StringUtils.length(title) > 10) {
			title = title.substring(0, 10);
		}

		UserSearchLogExample example = new UserSearchLogExample();
		example.createCriteria().andUidEqualTo(uid).andTitleEqualTo(title);
		UserSearchLog updateDate = new UserSearchLog();
		updateDate.setUpdateTime(new Date());

		if (userSearchLogMapper.updateByExampleSelective(updateDate, example) == 0) {
			UserSearchLog record = new UserSearchLog();
			record.setCreateTime(new Date());
			record.setUpdateTime(new Date());
			record.setTitle(title);
			record.setUid(uid);
			return userSearchLogMapper.insertSelective(record);
		}

		return 0;
	}

	public List<UserSearchLog> list(Long uid) {
		UserSearchLogExample example = new UserSearchLogExample();
		example.createCriteria().andUidEqualTo(uid);
		example.setOrderByClause("update_time desc,id desc");
		List<UserSearchLog> list = userSearchLogMapper.selectByExample(example);

		if (list.size() > 10) {
			List<UserSearchLog> list1 = list.subList(10, list.size());
			for (UserSearchLog userSearchLog : list1) {
				userSearchLogMapper.deleteByPrimaryKey(userSearchLog.getId());
			}
			list = list.subList(0,9);
		}

		return list;
	}

	public int delete(Long uid, String words) {
		UserSearchLogExample example = new UserSearchLogExample();
		example.createCriteria().andUidEqualTo(uid).andTitleEqualTo(words);
		return userSearchLogMapper.deleteByExample(example);
	}

}
