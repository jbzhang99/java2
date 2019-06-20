package test.open;
import com.rfchina.community.openstore.service.AreaService;
import org.junit.Test;
import java.math.BigDecimal;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
public class TestAreaService  extends TestBase {
    @Autowired
    public AreaService areaService;
    @Test
    public void getArea(){System.out.println(areaService.getArea(100000));}
}
