package test;

import com.rfchina.community.open.bridge.RfCommunityOpenBridgeApiApplication;
import com.rfchina.community.open.bridge.entity.BridgeCommunityAroundPoi;
import com.rfchina.community.open.bridge.service.CommunityAroundManageBridgeService;
import com.rfchina.community.persistence.model.CommunityAroundPoi;
import com.rfchina.community.persistence.model.CommunityAroundPoiType;
import com.rfchina.community.service.openser.CommunityAroundPoiService;
import com.rfchina.community.service.openser.CommunityAroundPoiTypeService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

/**
 * @ClassName CommunityAroundService
 * @Description 导入社区周边分类
 * @Author wlrllr
 * @Date 2019/4/23 10:23
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RfCommunityOpenBridgeApiApplication.class})
public class CommunityAroundTest {

    @Autowired
    private CommunityAroundPoiTypeService communityAroundPoiTypeService;
    @Value("${gaode.api.url.place_around}")
    private String placeAroundUrl;
    @Value("${baidu.api.url.poi_query}")
    private String baiduPoiQueryUrl;
    @Value("${baidu.api.url.poi_detail}")
    private String baiduPoiDetailUrl;
    @Value("${gaode.api.url.coordinate_convert}")
    private String gaodeCoordinateConvertUrl;
    @Autowired
    private CommunityAroundManageBridgeService communityAroundManageBridgeService;

    /**
     * @Author wlrllr
     * @Description //拉取分类
     * @Date 2019/4/25
     * @Param []
     * @return void
     **/
    @Test
    //@Transactional
    public void testImportType() {
        try {
            File file = new File("C:\\Users\\zhanglong15\\Desktop\\wb\\工作量评估\\自在生活v4.9\\111.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet sheet = workbook.getSheetAt(1);
            int rowNum = 1;
            String firstCategoryId = null;
            String secondCategoryId = null;
            while (true) {
                XSSFRow row = sheet.getRow(rowNum++);
                if (row == null) {
                    break;
                }
                //第一大类
                String cellValue = row.getCell(1).getStringCellValue();
                if (StringUtils.isNotBlank(cellValue)) {
                    String temp = addFirstCategory(cellValue);
                    if(temp != null){
                        firstCategoryId = temp;
                    }
                }

                //第二大类
                String cellValue2 = row.getCell(2).getStringCellValue();
                if (StringUtils.isNotBlank(cellValue2)) {
                    String temp = addSecondCategory(cellValue2,firstCategoryId);
                    if(temp != null){
                        secondCategoryId = temp;
                    }
                }

                //第三大类
                String cellValue3 =  row.getCell(3).getStringCellValue();
                XSSFCell cell = row.getCell(4);
                String code =  null;
                try{
                    code =  cell.getStringCellValue();
                }catch (Exception e){
                    Double val = cell.getNumericCellValue();
                    code = String.valueOf(val.intValue());
                }

                addThirdCategory(cellValue3,secondCategoryId,code);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String addFirstCategory(String title){
        if(!communityAroundPoiTypeService.isExitName(title,1)){
            CommunityAroundPoiType type = new CommunityAroundPoiType();
            type.setLevel(1);
            type.setCreateTime(new Date());
            type.setStatus(1);
            type.setName(title);
            type.setSort(0);
            type.setType(buildType(1));
            communityAroundPoiTypeService.insert(type);
            return type.getType();
        }else{
            CommunityAroundPoiType type = communityAroundPoiTypeService.getByName(title,1);
            if(type != null){
                return type.getType();
            }
        }
        return null;
    }

    private String addSecondCategory(String title,String parentType){
        if(!communityAroundPoiTypeService.isExitName(title,2)){
            CommunityAroundPoiType type = new CommunityAroundPoiType();
            type.setLevel(2);
            type.setCreateTime(new Date());
            type.setStatus(1);
            type.setSort(0);
            type.setName(title);
            type.setParentType(parentType);
            type.setType(buildType(2));
            communityAroundPoiTypeService.insert(type);
            return type.getType();
        }else{
            CommunityAroundPoiType type = communityAroundPoiTypeService.getByName(title,2);
            if(type != null){
                return type.getType();
            }
        }
        return null;
    }

    private Long addThirdCategory(String title,String parentType,String t){
        if(!communityAroundPoiTypeService.isExitName(title,3)){
            CommunityAroundPoiType type = new CommunityAroundPoiType();
            type.setLevel(3);
            type.setCreateTime(new Date());
            type.setStatus(1);
            type.setSort(0);
            type.setName(title);
            type.setParentType(parentType);
            type.setType(t);
            communityAroundPoiTypeService.insert(type);
            return type.getId();
        }
        return null;
    }

    private static volatile Integer firstCategoryBaseNum = 100000;
    private static volatile Integer secondCategoryBaseNum = 200000;
    private static volatile Integer thirdCategoryBaseNum = 300000;
    private String buildType(Integer level){
        if(level == 1){
            return (++firstCategoryBaseNum).toString();
        }else if(level ==2){
            return (++secondCategoryBaseNum).toString();
        }else if(level ==3){
            return (++thirdCategoryBaseNum).toString();
        }
        return null;
    }

    @Autowired
    private CommunityAroundPoiService communityAroundPoiService;
    @Test
    public void savePoi() {
        BridgeCommunityAroundPoi bridgePoi = new BridgeCommunityAroundPoi();
        bridgePoi.setLatitude("123");
        bridgePoi.setLongitude("32");
        bridgePoi.setId(24210L);
        Long poiId = bridgePoi.getId();
        CommunityAroundPoi poi = new CommunityAroundPoi();
        if (poiId != null) {
            poi = communityAroundPoiService.selectByPrimaryKey(bridgePoi.getId());
        }
        BeanUtils.copyProperties(bridgePoi, poi);
        String picUrl = bridgePoi.getPicUrl();
        if (picUrl != null) {
            poi.setPicUrl((picUrl.split(","))[0]);
        }
    }
}
