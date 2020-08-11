package com.cql.mp.controller;

import com.cql.mp.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户控制层
 * @author cql
 * @date 2020/8/10
*/
@RestController
@RequestMapping("ar")
public class ArController {

    @PostMapping("insert")
    public void insert() {
        User user = new User();
        user.setName("luofeng2");
        user.setAge(18);
        user.setEmail("xxx@qq.com");
        user.setManagerId(1088248166370832385L);
        user.setCreateTime(LocalDateTime.now());
        User.setRemark2("beihzhu2");
        boolean insert = user.insert();
        System.err.println(user.getId());
//        boolean insert2 = user.insertOrUpdate();
    }


    @PostMapping("selectAll")
    @ResponseBody
    public void selectAll() {
        List<User> users = new User().selectAll();
    }

    @PostMapping("selectById")
    @ResponseBody
    public  void selectById() {
        User users = new User().selectById(1L);
        User user = new User();
        user.setId(1L);
        User user1 = user.selectById();
    }



}
