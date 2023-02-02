package com.xie.demo;

import com.xie.demo.mapper.CyGoodsMapper;
import com.xie.demo.model.CyGoods;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.xie.demo.mapper")
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    CyGoodsMapper goodsMapper;
    @Test
    void getGoods(){
        Integer limit = 0;
        Integer size =20;
        List<CyGoods> goods = goodsMapper.getGoods(360000,limit,size);
        System.out.println(goods);
    }

}
