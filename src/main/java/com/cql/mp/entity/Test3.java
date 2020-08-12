package com.cql.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户表实体类
 * @author cql
 * @date 2020/8/10 17:08
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "测试3实体类")
public class Test3 extends Model<Test3>  implements Serializable {

    private static final long serialVersionUID = 493083738120393040L;

    /**
     * id 当id与数据库主键对不上时，需要指定主键id(AUTO代表数据库自增)
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键ID", example = "1")
    private Long id;

    /**
     * 姓名
     * 当name与数据库字段对不上的时候，需要指定映射关系
     * condition = SqlCondition.LIKE，当去匹配的时候采用 like匹配方式
     * condition也可以写自定义字符串：condition = "%s LIKE CONCAT(#{%s},'%%"
     */
    @TableField(value = "name",condition = SqlCondition.LIKE)
    @ApiModelProperty(value = "姓名", example = "张三")
    private String name;


    @ApiModelProperty(value = "test2表主键ID", example = "2")
    private Long test2Id;


}
