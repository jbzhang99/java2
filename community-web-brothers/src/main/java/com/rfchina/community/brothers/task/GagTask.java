package com.rfchina.community.brothers.task;

import com.rfchina.community.persistence.mapper.GagInfoMapper;
import com.rfchina.community.persistence.model.GagInfo;
import com.rfchina.community.persistence.model.GagInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 */
//@Component
public class GagTask {

	@Autowired
	private GagInfoMapper gagInfoMapper;
	
	private void endGagStatus(){
		GagInfoExample gagInfoExample = new GagInfoExample();
		gagInfoExample.createCriteria().andEndTimeLessThan(new Date());
		
		List<GagInfo> list = gagInfoMapper.selectByExample(gagInfoExample);
		if(list != null && list.size() > 0){
			List<Long> uidList = new ArrayList<>();
			for(GagInfo gagInfo : list){
				uidList.add(gagInfo.getUid());
			}
			
			//删除记录
			gagInfoExample.clear();
			gagInfoExample.createCriteria().andUidIn(uidList);
			gagInfoMapper.deleteByExample(gagInfoExample);
		}
	}
	
	@Scheduled(cron = "0 0/10 * * * ?")
	public void runTask(){
		endGagStatus();
	}
	
}
