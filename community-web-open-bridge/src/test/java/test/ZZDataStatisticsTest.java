package test;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * @ClassName ZZDataStatisticsTest
 * @Description TODO
 * @Author wlrllr
 * @Date 2019/6/12 10:44
 * @Version 1.0
 **/
public class ZZDataStatisticsTest extends BaseTest {

    @Test
    public void testGetZZServiceData(){
        String response = restTemplate.getForObject("/api/stats/open/bridgeapi/zizai_wufu_data_order",String.class);
        System.out.print(response);
    }
}
