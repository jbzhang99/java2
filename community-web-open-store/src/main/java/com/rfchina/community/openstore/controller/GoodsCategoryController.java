package com.rfchina.community.openstore.controller;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.persistence.mapper.CommunityServiceCategoryMapper;
import com.rfchina.community.persistence.model.CommunityServiceCategory;
import com.rfchina.community.persistence.model.CommunityServiceCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 
 */
@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENSTORE)
public class GoodsCategoryController extends BaseController {
	@Autowired
	private CommunityServiceCategoryMapper communityServiceCategoryMapper;

	@RequestMapping("/listGoodsCategory")
	public Result<?> listGoodsCategory() {

		CommunityServiceCategoryExample example = new CommunityServiceCategoryExample();
		example.createCriteria().andTypeEqualTo(5).
			andValidStatusEqualTo(OpenConstant.CategoryStatus.valid_status)
			.andExposureEqualTo(1);
		example.setOrderByClause("sort");
		List<CommunityServiceCategory> list = communityServiceCategoryMapper.selectByExample(example);
		return Result.successData(list);
	}

}
