package com.cql.mp.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单表实体类
 * @author cql
 * @date 2020/8/10 17:08
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "订单实体类")
public class Orders extends Model<Orders>  implements Serializable {

    private static final long serialVersionUID = 493083738120393040L;

    /**
     * id 当id与数据库主键对不上时，需要指定主键id(AUTO代表数据库自增)
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键ID", example = "1")
    private Long id;

    /**
     * 商品id
     * 当productId与数据库字段对不上的时候，需要指定映射关系
     * condition = SqlCondition.LIKE，当去匹配的时候采用 like匹配方式
     * condition也可以写自定义字符串：condition = "%s LIKE CONCAT(#{%s},'%%"
     */
    @ApiModelProperty(value = "商品id", example = "123456")
    private Long productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 数量
     */
    private BigDecimal amount;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 创建时间（新增时自动填充）
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 修改时间（修改时自动填充）
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 版本号（@Version 开启版本号控制  默认：1）
     */
    @Version
    private Integer version;

    /**
     * 是否删除（1：删除  0：未删除）
     *  @TableLogic 条件中过滤deleted 字段
     *  @TableField(select = false) 查询时查询字段中不显示deleted字段
     */
    @TableLogic
    @TableField(select = false)
    private Integer deleted;

}
