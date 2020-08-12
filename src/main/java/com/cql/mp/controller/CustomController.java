package com.cql.mp.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cql.mp.dao.UserMapper;
import com.cql.mp.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户控制层
 * @author cql
 * @date 2020/8/10
*/
@RestController
@RequestMapping("custom")
public class CustomController {

    @Resource
    UserMapper userMapper;

    /**
     * 获取用户列表
     * @return
     * @author cql
     * @date 2020/8/10
     */
    @PostMapping("select")
    @ResponseBody
    public void select(){

        LambdaQueryWrapper<User> lambda = new LambdaQueryWrapper<>();
        lambda.like(User::getName, "雨")
                .lt(User::getAge, "50");
        //注解
//        List<User> users = userMapper.selectAll(lambda);
//        users.forEach(System.err::println);

        //XML
        List<User> users2 = userMapper.selectAll2(lambda);
        users2.forEach(System.err::println);

    }


}
