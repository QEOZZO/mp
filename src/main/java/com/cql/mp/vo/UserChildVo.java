package com.cql.mp.vo;

import com.cql.mp.entity.User;
import lombok.Data;
import java.util.List;

/**
 * 子用户查询Vo
 * @author cql
 * @date 2020/8/10 18:08
*/
@Data
public class UserChildVo {
    private long id;
    private int age;
    private String name;
    private String[] names;
    private List<User> usersList;
}
