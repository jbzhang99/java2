package test;

import com.rfchina.community.brothers.CommunityBrothersApplication;
import com.rfchina.community.brothers.service.CommunityAroundManageBrotherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CommunityBrothersApplication.class})
public class CommunityAroundTest {

    @Autowired
    private CommunityAroundManageBrotherService communityAroundManageBrotherService;

    @Test
    public void executeUpdatePlan() {
        communityAroundManageBrotherService.executeUpdatePlan();
        while (true) {
        }
    }


    @Test
    public void uploadPoiPic() {
        communityAroundManageBrotherService.uploadPoiPic();
        while (true) {
        }
    }

    @Test
    public void syncCommunityInfo() {
        communityAroundManageBrotherService.syncCommunityInfo();
    }

    @Test
    public void parsePoiData() {
        while (true) {
            try {
                communityAroundManageBrotherService.parsePoiData();
                Thread.sleep(80000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void syncPoiExtInfoTask() {
        communityAroundManageBrotherService.syncPoiExtInfoTask();
        while (true){

        }
    }

    @Test
    public void convertLocation() {
        communityAroundManageBrotherService.convertLocation();
        while (true) {
        }
    }

    @Test
    public void syncPoiComment() {
        communityAroundManageBrotherService.syncPoiComment();
        while (true) {
        }
    }

}