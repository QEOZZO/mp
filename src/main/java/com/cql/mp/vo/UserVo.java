package com.cql.mp.vo;

import com.cql.mp.entity.User;
import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * 用户表Vo
 * @author cql
 * @date 2020/8/10 18:08
*/
@Data
public class UserVo {
    private int age;
    private Date time;
    private Double money;
    private String[] array;
    private User[] usersArray;
    private User users;
    private List<UserVo> userVos;
    private UserVo userVo;
    private List<User> usersList;
}
