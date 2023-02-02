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
@TableName("cy_goods")
public class CyGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名称
     */
    @TableField("goods_name")
    private String goodsName;

    /**
     * 分类ID
     */
    @TableField("cate_id")
    private Integer cateId;

    @TableField("price")
    private Long price;

    /**
     * 商品原价
     */
    @TableField("original")
    private Long original;

    /**
     * 商品标签
     */
    @TableField("tags")
    private String tags;

    /**
     * 商品内容
     */
    @TableField("content")
    private String content;

    /**
     * 商品描述
     */
    @TableField("summary")
    private String summary;

    /**
     * 上架状态: 1是0是
     */
    @TableField("is_sale")
    private Integer isSale;

    @TableField("created_at")
    private LocalDateTime createdAt;

    @TableField("updated_at")
    private LocalDateTime updatedAt;


}
