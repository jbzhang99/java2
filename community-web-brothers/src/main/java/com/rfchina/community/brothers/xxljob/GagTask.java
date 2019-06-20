package com.rfchina.community.brothers.xxljob;

import com.rfchina.community.persistence.mapper.GagInfoMapper;
import com.rfchina.community.persistence.model.GagInfo;
import com.rfchina.community.persistence.model.GagInfoExample;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 */
@JobHandler(value = "brothers-GagTask")
@Component
public class GagTask extends IJobHandler{

	@Autowired
	private GagInfoMapper gagInfoMapper;
	private final Logger logger = LoggerFactory.getLogger(getClass());

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
	
	public void runGagTask(){
		logger.debug("Begin to run [runGagTask]");
		endGagStatus();
		logger.debug("Finish [runGagTask]");

	}

	@Override
	public ReturnT<String> execute(String s) throws Exception {
		this.runGagTask();
		return ReturnT.SUCCESS;
	}
}
