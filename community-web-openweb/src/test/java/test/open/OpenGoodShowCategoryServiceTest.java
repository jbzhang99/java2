package test.open;

import com.rfchina.community.openweb.CommunityOpenWebApplication;
import com.rfchina.community.openweb.service.OpenGoodShowCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CommunityOpenWebApplication.class})
public class OpenGoodShowCategoryServiceTest                     {
	@Autowired
	private OpenGoodShowCategoryService openGoodShowCategoryService;

	@Test
	public void insert() {
		openGoodShowCategoryService.insert(413, "测试1", 1,
				"http://192.168.197.28:10086/G1/M00/00/28/wKjFHFnDe3iAbnwJAAl5WLU-YRY994.jpg"
		,1);
	}

	@Test
	public void update() {
		openGoodShowCategoryService.update(413, 2, "测试2",
				1,"http://fts.test.p.thinkinpower.net/_f/bucket-test/ab1316de-f393-4f7b-9cb3-0d6492df2f7a.png", 0);
	}


	@Test
	public void categoryList() {
		System.out.print(openGoodShowCategoryService.categoryList(413));
	}

	@Test
	public void pageQuery() {
		System.out.print(openGoodShowCategoryService.pageQuery(413, 1, 10));
	}

	@Test
	public void delete() {
		openGoodShowCategoryService.delete(1);
	}

	@Test
	public void getGoodCategoryList() {
		openGoodShowCategoryService.getGoodCategoryList(1);
	}

	@Test
	public void insertOrDeleteCategoryGoodRel() {
		List<Long> list = new ArrayList<>();
		list.add(1L);
		openGoodShowCategoryService.insertOrDeleteCategoryGoodRel(1, list);
	}

	@Test
	public void deleteByGoodId() {
		openGoodShowCategoryService.deleteByGoodId(1);
	}
}