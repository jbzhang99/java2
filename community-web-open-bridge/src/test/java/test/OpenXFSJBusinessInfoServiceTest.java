package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rfchina.community.component.OpenAuditInfoComponent.ObjectType;
import com.rfchina.community.open.bridge.RfCommunityOpenBridgeApiApplication;
import com.rfchina.community.open.bridge.entity.ExtOpenXFSJAreaConfig;
import com.rfchina.community.open.bridge.service.CommunityServiceInfoService;
import com.rfchina.community.open.bridge.service.IOpenAuditTypeReturn;
import com.rfchina.community.open.bridge.service.OpenXFSJAreaConfigService;
import com.rfchina.community.open.bridge.service.OpenXFSJBusinessInfoService;
import com.rfchina.community.open.bridge.service.OpenXFSJGroupConfigService;
import com.rfchina.community.persistence.model.OpenXFSJAreaConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RfCommunityOpenBridgeApiApplication.class})
public class OpenXFSJBusinessInfoServiceTest {
	@Autowired
	private OpenXFSJBusinessInfoService openXFSJBusinessInfoService;
	@Autowired
	private OpenXFSJGroupConfigService openXFSJGroupConfigService;
	@Autowired
	private OpenXFSJAreaConfigService openXFSJAreaConfigService;
	@Autowired
	private CommunityServiceInfoService communityServiceInfoService;
	
	@Test
	@Ignore
	public void updateXFSJSignUpStatus() {
		System.out.println(openXFSJBusinessInfoService.updateXFSJSignUpStatus(4L,2));
	}
	@Test
	@Ignore
	public void getOpenXFSJBusinessInfo() {
		System.out.println(openXFSJBusinessInfoService.getOpenXFSJBusinessInfo(4L));
	}
	
	@Test
	@Ignore
	public void getSignUpList() {
		System.out.println(openXFSJBusinessInfoService.getSignUpList(4L));
	}
	
	@Test
	@Ignore
	public void deleteSignUpUser() {
		openXFSJBusinessInfoService.deleteSignUpUser(4L);
	}
	
	
	@Test
	@Ignore
	public void testGroupConfig() {
		openXFSJGroupConfigService.insertGroupConfig("112");
		System.out.println(openXFSJGroupConfigService.listGroupConfig());
		openXFSJGroupConfigService.updateGroupConfig(1L, "113");
	}
	
	@Test
	@Ignore
	public void testAreaConfig() {
//		openXFSJAreaConfigService.insertAreaConfig(330483, 1, "天天都有新鲜");
//		System.out.println(openXFSJAreaConfigService.listAreaConfig(330483, 1));
//		openXFSJAreaConfigService.updateAreaConfig(1L, "天天都有新鲜呀");
		List<OpenXFSJAreaConfig> list = openXFSJAreaConfigService.listAreaConfig(330483, 1);
		List<ExtOpenXFSJAreaConfig> extList = openXFSJAreaConfigService.areaConfigList2ExtList(list);
		System.out.println(extList);
	}
	
	@Test
	@Ignore
	public void audit() throws Exception {
		int status = 1;
		IOpenAuditTypeReturn ret = openXFSJBusinessInfoService.audit(ObjectType.xfsj_sign_up_apply);
		if (ret != null) {
			if (status == 1) {
				Map<String, String> parameter = new HashMap<String, String>();
				ret.passAudit(593L, "4", parameter);
			} else {
				ret.unpassAudit(593L, "4", "haha ");
			}
		}
	}
	
	@Test
	public void listStore() {
		System.out.println(communityServiceInfoService.listStore("场地",0, 1, 10));
	}
}