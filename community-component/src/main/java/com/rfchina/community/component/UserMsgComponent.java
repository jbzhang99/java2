package com.rfchina.community.component;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;

import com.rfchina.community.base.Constant;
import com.rfchina.community.persistence.mapper.UserMsgMapper;
import com.rfchina.community.persistence.mapper.UserMsgReadMapper;
import com.rfchina.community.persistence.model.UserMsg;

/**
 */
@Component
public class UserMsgComponent {

	@Autowired
	private UserMsgMapper userMsgMapper;

	@Autowired
	private UserMsgReadMapper readMapper;

	public int add(UserMsg record) {
		record.setCreateTime(new Date());
		record.setIsRead(Constant.user_msg.is_read.unread);
		return userMsgMapper.insertSelective(record);
	}

	public void adds(List<UserMsg> list) {
		if (list == null)
			return;
		for (UserMsg record : list) {
			add(record);
		}
	}
	
	 public void addCommunityMsg(int community_id, Long oid, int type, String title, String content, Long touid, int msgType) {
	        addCommunityMsg(community_id, oid, type, title, content, touid, 0L, "", msgType);
	    }

	    public void addCommunityMsg(int community_id, Long oid, int type, String title, String content, long touid, long fromuid, String token, int msgType) {
	        UserMsg rc = new UserMsg();
	        rc.setCommunityId(community_id);
	        rc.setContent(content);
	        rc.setTitle(title);
	        rc.setCreateTime(new Date());
	        rc.setObjectId(oid);
	        rc.setObjectType(type);
	        rc.setFromUid(fromuid);
	        rc.setToken(token);
	        rc.setToUid(touid);
	        rc.setStatus(1);
	        rc.setIsRead(1);
	        rc.setMsgType(msgType);	//'1社区,2公告， 3系统消息'
	        userMsgMapper.insertSelective(rc);
	    }
	    
	    // type 0表示无对象,1预约,2邀约,3社区,4卡片,5 报修
	    ///msgType '1社区,2公告， 3系统消息'
	    public void addMsg(int type, String title, String content, long uid, int msgType) {
	    	this.addCommunityMsg(0, 0L, type, title, content, uid, msgType);
	    }


}
