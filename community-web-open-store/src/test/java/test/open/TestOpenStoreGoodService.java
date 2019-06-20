package test.open;

import com.rfchina.community.openstore.service.OpenGoodShowCategoryService;
import com.rfchina.community.openstore.service.OpenStoreGoodService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
public class TestOpenStoreGoodService extends TestBase {
    @Autowired
    public OpenStoreGoodService openStoreGoodService;
    @Autowired
    public OpenGoodShowCategoryService openGoodShowCategoryService;
    @Test
    public void getSimpleGoodDetail(){System.out.println(openStoreGoodService.getSimpleGoodDetail(1));}
    @Test
    public void pageQuery(){System.out.println(openStoreGoodService.pageQuery(59,"","","",1L,1,5));}



}
