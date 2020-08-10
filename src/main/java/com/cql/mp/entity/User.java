package com.cql.mp.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;


/***
 * 用户表实体类
 * @author cql
 */
@Data
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Long managerId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    @Version
    private Integer version;
    @TableLogic
    private Integer deleted;
}
