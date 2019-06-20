package test.open.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.rfchina.community.openstore.service.OpenOrderWSService;
import com.rfchina.community.openstore.service.UserSearchLogService;
import com.rfchina.community.persistence.model.UserSearchLog;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import test.open.TestBase;

import java.util.List;

public class OpenOrderWSServiceTC extends TestBase {
	@Autowired
	public OpenOrderWSService openOrderWSService;

	
	
	@Test
	public void listOrderThreeByUidTest() {
		Long uid=10182L;
		PageInfo<?> page = openOrderWSService.listOrderThreeByUid(uid, 1, 10);
		System.out.println(JSON.toJSONString(page));
	}

}
