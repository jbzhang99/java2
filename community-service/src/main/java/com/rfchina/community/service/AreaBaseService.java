package com.rfchina.community.service;

import com.rfchina.community.persistence.mapper.BaseMapper;
import com.rfchina.community.persistence.mapper.ext.ExtAreaMapper;
import com.rfchina.community.persistence.model.Area;
import com.rfchina.community.persistence.model.AreaExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AreaBaseService extends AbstractService<Area, AreaExample,Integer>{

    @Autowired
    private ExtAreaMapper extAreaMapper;

    @Override
    public BaseMapper<Area, AreaExample, Integer> getMapper() {
        return extAreaMapper;
    }

    /**
     * @Author wlrllr
     * @Description //获取含有社区的城市
     * @Date 2019/4/3
     * @Param []
     * @return java.util.List<com.rfchina.community.persistence.model.Area>
     **/
    public List<Area> getCityHasCommunity(){
        return extAreaMapper.getCityHasCommunity();
    }

    /**
     * @Author wlrllr
     * @Description // 查询城市，按城市首字母分支
     * @Date 2019/4/3
     * @Param []
     * @return java.util.Map<java.lang.String,java.util.List<com.rfchina.community.persistence.model.Area>>
     **/
    public List<Map<String,Object>> groupCityHasCommunity(){
        List<Area> list = getCityHasCommunity();
        if(list != null){
            return list.stream().map(area -> {
                String py = area.getPinyin();
                if(StringUtils.isNotBlank(py)){
                    area.setPinyin(py.substring(0,1).toUpperCase());
                }
                return area;
            }).collect(Collectors.groupingBy(Area::getPinyin)).entrySet().stream().map(entry -> {
                Map<String,Object> map = new HashMap<>();
                map.put("initial",entry.getKey());
                map.put("cityList",entry.getValue());
                return map;
            }).sorted(Comparator.comparing(map -> map.get("initial").toString())).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
