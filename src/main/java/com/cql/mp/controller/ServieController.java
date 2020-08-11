package com.cql.mp.controller;

import cn.icasc.cloud.common.http.RestResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cql.mp.entity.User;
import com.cql.mp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

/**
 * 用户控制层
 * @author cql
 * @date 2020/8/10
*/
@RestController
@RequestMapping("service")
public class ServieController {

    @Autowired
    UserService userService;

    /**
     * 获取用户列表
     * @return
     * @author cql
     * @date 2020/8/10
     */
    @PostMapping("select")
    public void select(){
        //第二个参数默认为true，若查出来多个则报错，当他为false时，查出来多个则取第一个
        User age = userService.getOne(new QueryWrapper<User>().gt("age", 18), false);
        System.err.println(age);
    }

    @PostMapping("insert")
    public void insert() {
        User user = new User();
        user.setName("13");
        user.setAge(11);
        User user2 = new User();
        user2.setName("1322");
        user2.setAge(11);

        List<User> users = Arrays.asList(user, user2);
//        userService.saveBatch(users);
        //批量插入，每次插入1000条
//        userService.saveBatch(users, 1000);
//        userService.saveOrUpdateBatch(users, 1000);
    }


    @PostMapping("chain")
    public void chain() {
        List<User> age = userService.lambdaQuery().gt(User::getAge, 23).list();

        //将25岁的改为23岁
        boolean update = userService.lambdaUpdate().eq(User::getAge, 25).set(User::getName, 23).update();

        //删除
        boolean remove = userService.lambdaUpdate().eq(User::getAge, 25).set(User::getName, 23).remove();

    }




}
