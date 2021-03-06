package com.cql.mp.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户表实体类
 * @author cql
 * @date 2020/8/10 17:08
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "用户实体类")
public class User extends Model<User>  implements Serializable {

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
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 上级id
     */
    private Long managerId;
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

    /**
     * 当前字段非数据库中的映射字段，若不加关键字，则会报错
     * transient修饰的变量不参与序列化过程
     * 缺点，若项目中有序列化需求，则此字段不能再使用
     */
    private transient String remark1;
    /**
     * 使用static 在插表时不加入
     * 缺点：lombok不会为静态变量生成get，set
     * 本该要求是每个对象都有一个这样的属性，但是使用静态变量，则变成类的属性，不合要求
     */
    private static String remark2;
    /**
     * 使用注解标识 该字段不在数据库表中 在插表时不加入
     */
    @TableField(exist = false)
    private String remark3;

    public static String getRemark2() {
        return remark2;
    }

    public static void setRemark2(String remark2) {
        User.remark2 = remark2;
    }
}
