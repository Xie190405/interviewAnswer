package com.xie.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiexie
 * @since 2023-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cy_goods_sku")
public class CyGoodsSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品ID
     */
    @TableField("goods_id")
    private Integer goodsId;

    /**
     * 规格名称
     */
    @TableField("title")
    private String title;

    /**
     * SKU库存
     */
    @TableField("num")
    private Integer num;

    /**
     * 商品售价
     */
    @TableField("price")
    private Long price;

    /**
     * 商品属性，以逗号分隔
     */
    @TableField("properties")
    private String properties;

    /**
     * 条码
     */
    @TableField("bar_code")
    private String barCode;

    /**
     * 商品码
     */
    @TableField("goods_code")
    private String goodsCode;

    /**
     * 状态:1启用,0禁用
     */
    @TableField("status")
    private Integer status;

    @TableField("created_at")
    private LocalDateTime createdAt;

    @TableField("updated_at")
    private LocalDateTime updatedAt;


}
