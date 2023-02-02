package com.xie.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("cy_city_categories")
public class CyCityCategories implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 城市ID
     */
    @TableField("city_id")
    private Integer cityId;

    /**
     * 商品分类ID
     */
    @TableField("categories_id")
    private Integer categoriesId;

    /**
     * 特征级别，数字越小级别越大
     */
    @TableField("level")
    private Integer level;

    /**
     * 特征描述
     */
    @TableField("desc")
    private String desc;


}
