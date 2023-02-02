# interviewAnswer
这是一个关于面试回答的项目实现，本次只实现了查询mapper,前后端交互并没有实现。

场景:业务背景：电商实际业务中，不同的商品，适合在不同的区域售卖，
比如空气净化器，优先适合在空气质量不好的城市售卖，雪地靴，优先适合在北方天气冷的地区售卖，即每个城市适合按当地用户喜好，优先展示不同的商品。

问题:
1.如何让返回给前端的商品列表，区域(即城市)动态变化。
2.假定上述效果已经完成实现，如何扩展现有系统，在不影响现有版本(无区域化差异)的情况下，做对比测试？
给出大致设计思路和实现？

## 问题一的回答:
首先先设计数据库，在我这次实现中就简单考虑了城市和区域特征的关系，于是就设计了城市表和城市特征分类表，因为考虑到一个城市可能有多个特征，
比如A城市可能干燥，寒冷，空气不好等多个特征，给每个特征加了一个level(这个值越小，该地区的特征表现越明显，就需要优先展示该需求的产品)。

然后就是mapper中的设计如下:

@Select("select g.* from cy_goods g \n" +
            "inner join cy_goods_sku k on g.id=k.goods_id \n" +
            "left join cy_city_categories cc on cc.categories_id = g.cate_id\n" +
            "where cc.city_id = #{cityId}\n" +
            "order by cc.level\n" +
            "limit #{limit},#{size}")
            
List<CyGoods> getGoods(@Param("cityID") Integer cityId, @Param("limit") Integer limit, @Param("size") Integer size);

然后前端发送请求:
先通过腾讯地图相关定位组件获取用户当前位置定位，再将得到的定位信息中的行政区号拿到

var cityId = currentPosition.adcode;
axios.get("/v1/cyGoods/getGoods?cityId=cityId").then(function (response) { list = response.data })

## 问题二的回答:
可以新建一个CyGoodsControllerV2,然后在这里实现拓展功能，然后修改相关请求地址"/v2/cyGoods/getGoods?cityId=cityId",
这样子在同步测试的时候就可以向不同的地址发送不同的请求然后得到对应结果，这样子就更好的进行对照。
