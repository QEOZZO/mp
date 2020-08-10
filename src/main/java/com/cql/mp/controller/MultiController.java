package com.cql.mp.controller;

import cn.icasc.cloud.common.http.RestResponse;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cql.mp.dao.UserMapper;
import com.cql.mp.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cql.mp.vo.MultiCheckVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * 用户控制层
 * @author cql
 * @date 2020/8/10
*/
@RestController
@RequestMapping("user")
public class MultiController {

    @Resource
    UserMapper userMapper;

    /**
     * 获取用户列表
     * @return
     * @author cql
     * @date 2020/8/10
     */
    @PostMapping("list")
    @ResponseBody
    public RestResponse getUserList(){
        LambdaQueryWrapper<User> lambda = Wrappers.<User>lambdaQuery().lt(User::getAge, "50");
        Page<User> userPage = new Page<>(1, 2);
        IPage<User> userIPage = userMapper.selectPage(userPage, lambda);
        return RestResponse.success().setData(JSONObject.toJSON(userIPage));
    }

    @PostMapping("selectUsersPagesTest")
    @ResponseBody
    public void selectUsersPagesTest() {
        //不要总数，只要记录 ,第三个参数为false
//        Page<User> userPage = new Page<>(1, 2, false);
        //自定义分页
        Page<User> userPage = new Page<>(1, 2);
        IPage<MultiCheckVo> mapIPage2 = userMapper.selectUsersPagesTest(userPage);
        System.err.println(mapIPage2.getCurrent());
        System.err.println(mapIPage2.getPages());
        System.err.println(mapIPage2.getSize());
        System.err.println(mapIPage2.getTotal());
        System.err.println(mapIPage2.getRecords().toString());
    }


    @PostMapping("selectUsersPagesTest2")
    @ResponseBody
    public void selectUsersPagesTest2() {
        //不要总数，只要记录 ,第三个参数为false
//        Page<User> userPage = new Page<>(1, 2, false);
        //自定义分页
        Page<User> userPage = new Page<>(1, 2);
        IPage<MultiCheckVo> mapIPage2 = userMapper.selectUsersPagesTest2(userPage);
        System.err.println(mapIPage2.getCurrent());
        System.err.println(mapIPage2.getPages());
        System.err.println(mapIPage2.getSize());
        System.err.println(mapIPage2.getTotal());
        System.err.println(mapIPage2.getRecords().toString());
    }

    @PostMapping("selectUsersPagesTest3")
    @ResponseBody
    public void selectUsersPagesTest3() {
        //不要总数，只要记录 ,第三个参数为false
//        Page<User> userPage = new Page<>(1, 2, false);
        //自定义分页
        Page<User> userPage = new Page<>(1, 2);
        IPage<MultiCheckVo> mapIPage2 = userMapper.selectUsersPagesTest3(userPage,"1281184543193223169");
        System.err.println(mapIPage2.getCurrent());
        System.err.println(mapIPage2.getPages());
        System.err.println(mapIPage2.getSize());
        System.err.println(mapIPage2.getTotal());
        System.err.println(mapIPage2.getRecords().toString());
    }



}
