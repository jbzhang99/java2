package test;

import com.google.common.collect.Maps;
import com.rfchina.community.base.StatusCode;
import com.rfchina.community.base.SysConstant;
import com.rfchina.community.open.bridge.RfCommunityOpenBridgeApiApplication;
import com.rfchina.community.open.bridge.service.CommunityAroundManageBridgeService;
import com.rfchina.community.persistence.model.CommunityAroundPoiType;
import com.rfchina.community.service.openser.CommunityAroundPoiTypeService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName CommunityAroundService
 * @Description 导入社区周边分类
 * @Author wlrllr
 * @Date 2019/4/23 10:23
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RfCommunityOpenBridgeApiApplication.class},webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CommunityAroundInterfaceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testPoiPage(){
        Map<String,Object> param = Maps.newHashMap();
        param.put("firstType","100001");
        String response = restTemplate.postForObject("/api/community/open/bridgeapi/poi/pageCommunityAroundPoiList",param,String.class);
        System.out.print(response);
    }

}
