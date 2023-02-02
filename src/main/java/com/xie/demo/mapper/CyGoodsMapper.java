package com.xie.demo.mapper;

import com.xie.demo.model.CyGoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author xiexie
* @since 2023-02-02
*/
    @Repository
    public interface CyGoodsMapper extends BaseMapper<CyGoods> {
    @Select("select g.* from cy_goods g \n" +
            "inner join cy_goods_sku k on g.id=k.goods_id \n" +
            "left join cy_city_categories cc on cc.categories_id = g.cate_id\n" +
            "where cc.city_id = #{cityID}\n" +
            "order by cc.level\n" +
            "limit #{limit},#{size}")
    List<CyGoods> getGoods(@Param("cityID") Integer cityID, @Param("limit") Integer limit, @Param("size") Integer size);
    }
