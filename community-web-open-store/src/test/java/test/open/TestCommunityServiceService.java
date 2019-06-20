package test.open;

import com.rfchina.community.openstore.service.CommunityServiceService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestCommunityServiceService extends TestBase {
    @Autowired
    public CommunityServiceService communityServiceService;
    @Test
    public void getCommunityServiceTempList (){
        System.out.println(communityServiceService.getCommunityServiceTempList(4));}

    @Test
    public void getCommunityServiceTempByPrimaryKey(){
        System.out.println(communityServiceService.getCommunityServiceTempByPrimaryKey(1));}

    @Test
    public void getCommunityServiceByPrimaryKey(){
        System.out.println(communityServiceService.getCommunityServiceByPrimaryKey(1));}

    @Test
    public void getCommunityServiceTemp(){
        System.out.println(communityServiceService.getCommunityServiceTemp("邀请来访"));}

    @Test
    public void getCommunityServiceTempCount(){
        System.out.println(communityServiceService.getCommunityServiceTempCount(4l));}

    @Test
    public void getCommunityServiceTempInfo(){
        System.out.println(communityServiceService.getCommunityServiceTempInfo(1));}

    @Test
    public void hadPutOnSale(){
        System.out.println(communityServiceService.hadPutOnSale(1));}



}
