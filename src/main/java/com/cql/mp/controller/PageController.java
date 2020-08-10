package com.cql.mp.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cql.mp.dao.UserMapper;
import com.cql.mp.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 用户控制层
 * @author cql
 * @date 2020/8/10
*/
@RestController
@RequestMapping("page")
public class PageController {

    @Resource
    UserMapper userMapper;

    /**
     * 获取用户列表
     * @return
     * @author cql
     * @date 2020/8/10
     */
    @PostMapping("select")
    public void select(){
        LambdaQueryWrapper<User> lambda = new LambdaQueryWrapper<>();
        lambda.lt(User::getAge, "50");
        //不要总数，只要记录 ,第三个参数为false
//        Page<User> userPage = new Page<>(1, 2, false);
        Page<User> userPage = new Page<>(1, 2);
        IPage<User> userIPage = userMapper.selectPage(userPage, lambda);
        System.err.println(userIPage.getCurrent());
        System.err.println(userIPage.getPages());
        System.err.println(userIPage.getSize());
        System.err.println(userIPage.getTotal());
        System.err.println(userIPage.getRecords().toString());

//        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(userPage, lambda);
//        System.err.println(mapIPage.getCurrent());
//        System.err.println(mapIPage.getPages());
//        System.err.println(mapIPage.getSize());
//        System.err.println(mapIPage.getTotal());
//        System.err.println(mapIPage.getRecords().toString());

        //自定义分页
        IPage<User> mapIPage2 = userMapper.selectUsersPages(userPage, lambda);
        System.err.println(mapIPage2.getCurrent());
        System.err.println(mapIPage2.getPages());
        System.err.println(mapIPage2.getSize());
        System.err.println(mapIPage2.getTotal());
        System.err.println(mapIPage2.getRecords().toString());
    }


}
