package test.open.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.alibaba.fastjson.JSON;
import com.rfchina.community.openstore.service.UserSearchLogService;
import com.rfchina.community.persistence.model.UserSearchLog;

import test.open.TestBase;

public class UserSearchLogServiceTC extends TestBase {
	@Autowired
	public UserSearchLogService userSearchLogService;

	
	
	@Test
	public void addLog() {

		for (int i = 0; i < 22; i++) {

			userSearchLogService.addLog(1001L, "ssss" + i);
		}
		userSearchLogService.addLog(1001L, "ssss");
		userSearchLogService.addLog(1001L, "ssss");
		userSearchLogService.addLog(1001L, "ssss");
		userSearchLogService.addLog(1001L, "ssss");
	}

	@Test
	public void list() {

		List<UserSearchLog> data = userSearchLogService.list(1001L);
		System.out.println(JSON.toJSONString(data));

	}

	@Test
	public void list2() throws InterruptedException {
		for (int i = 0; i < 22; i++) {
			userSearchLogService.addLog(1001L, "ssss" + i);
			Thread.sleep(2000L);
			List<UserSearchLog> data = userSearchLogService.list(1001L);
			System.out.println(JSON.toJSONString(data));
		}

	}
	@Test
	@Rollback(false)
	public void addLogSysn() throws InterruptedException {
		for (int i = 0; i < 22; i++) {
			userSearchLogService.addLogSysn(1001L, "ssss" + i);
			 
		}
		
		
		Thread.sleep(2000L);

	}

}
