package com.rfchina.community.component;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.rfchina.community.persistence.mapper.AreaMapper;
import com.rfchina.community.persistence.model.Area;
import com.rfchina.community.persistence.model.AreaExample;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 */
@Component
public class AreaComponent {

	Cache<String, Object> AREA_CACHE = CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES).build();

	public static final String ID_PREFIX = "area_id_";

	public static final String PARENT_ID_PREFIX = "area_parent_id";

	@Autowired
	private AreaMapper areaMapper;

	public Area getArea(Integer id) {
		if (null == id) {
			return null;
		}
		String cacheKey = ID_PREFIX + id;
		Area cacheVal = (Area) AREA_CACHE.getIfPresent(cacheKey);
		if (null == cacheVal) {
			Area record = areaMapper.selectByPrimaryKey(id);
			if (null != record) {
				cacheVal = record;
				AREA_CACHE.put(cacheKey, record);
				return cacheVal;
			}
		}
		return cacheVal;
	}

	public String getAreaName(Integer id) {
		Area area = getArea(id);
		if (null != area) {
			return area.getName();
		}
		return null;
	}

	public Area getCityArea(Integer id) {
		Area area = getArea(id);
		if(null != area) {
			if(2 == area.getLevelType()) {
				return area;
			} else if(3 == area.getLevelType()) {
				Area parentArea = getArea(area.getParentId());
				if("直辖县级".equals(parentArea.getName())) {		//FIXME 还有这等恶心
					return area;
				}
				return parentArea;
			}
		}
		return null;
	}

	public String getCityAreaName(Integer id) {
		Area area = getCityArea(id);
		return null!=area? area.getShortName():null;
	}

	public String getMergerName(Integer id) {
		Area area = getArea(id);
		if (null != area) {
			return area.getMergerName();
		}
		return null;
	}

	public List<Area> getAreaList(Integer parentId) {
		if (null == parentId)
			return null;
		String cacheKey = PARENT_ID_PREFIX + parentId;
		List<Area> cacheVal = (List<Area>) AREA_CACHE.getIfPresent(cacheKey);
		if (null == cacheVal) {
			AreaExample example = new AreaExample();
			example.createCriteria().andParentIdEqualTo(parentId);
			List<Area> list = areaMapper.selectByExample(example);
			if (CollectionUtils.isNotEmpty(list)) {
				cacheVal = list;
				AREA_CACHE.put(cacheKey, list);
				return cacheVal;
			}
		}
		return cacheVal;
	}

	 public String getAreaShortName(Integer id) {
        Area area = getArea(id);
        if (null != area) {
            return area.getShortName();
        }
        return null;
    }

	public String getMergerName(int provinceId, int cityId, int areaId) {
		Area provinceArea = getArea(provinceId);
		Area cityIdArea = getArea(cityId);
		Area areaIdArea = getArea(areaId);
		StringBuffer sb = new StringBuffer();
		sb.append(provinceArea == null ? "" : provinceArea.getName());
		sb.append(" ");
		sb.append(cityIdArea == null ? "" : cityIdArea.getName());
		sb.append(" ");
		sb.append(areaIdArea == null ? "" : areaIdArea.getName());
		return sb.toString();
	}
}
