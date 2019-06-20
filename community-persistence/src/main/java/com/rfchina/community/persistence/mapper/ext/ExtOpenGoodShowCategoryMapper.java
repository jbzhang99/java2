package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.entity.ServiceCategory;
import com.rfchina.community.persistence.model.OpenGoodShowCategory;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.List;
import java.util.Map;

/**
 */
public interface ExtOpenGoodShowCategoryMapper {

    @SelectProvider(type=ExtOpenGoodShowCategorySqlProvider.class, method="pageByCondition")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
            @Result(column="category_name", property="categoryName", jdbcType=JdbcType.VARCHAR),
            @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
            @Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
            @Result(column="is_show", property="isShow", jdbcType=JdbcType.INTEGER),
            @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
	public PageList<OpenGoodShowCategory> pageByCondition(Map<String, Object> param, PageBounds pageBounds);

    @Select({
            " select _c.id, _c.category_name name from open_category_good_rel _r , open_good_show_category _c   ",
            " where _c.id=_r.show_category_id  and _r.good_id= #{goodId, jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    public PageList<ServiceCategory> getGoodCategoryList(@Param("goodId") Integer goodId);


    @Select({
            " select _c.id from open_category_good_rel _r , open_good_show_category _c ",
            " where  _c.id=_r.show_category_id and _r.good_id= #{goodId, jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true)
    })
    public List<Long> getGoodCategoryIdList(@Param("goodId") Integer goodId);
}
