//package com.cql.mp.controller;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.cql.mp.dao.UserMapper;
//import com.cql.mp.entity.User;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///**
// * 用户控制层
// * @author cql
// * @date 2020/8/10
//*/
//@RestController
//@RequestMapping("condition")
//public class ConditionController {
//
//    @Resource
//    UserMapper userMapper;
//
//    /**
//     * 获取用户列表
//     * @return
//     * @author cql
//     * @date 2020/8/10
//     */
//    @PostMapping("select")
//    @ResponseBody
//    public void select(){
//
//        select0("雨");
//        select0("");
//        //TODO Condition判断
//        select1("雨");
//
//    }
//
//    private void select0(String name) {
//        QueryWrapper<User> userQueryWrapper;
//        userQueryWrapper = new QueryWrapper<>();
//        userQueryWrapper
//                .between("age", 20, 40)
//                .isNotNull("email");
//        if(StringUtils.isNotEmpty(name)){
//            userQueryWrapper
//                    .like("name", name);
//        }
//        List<User> users1 = userMapper.selectList(userQueryWrapper);
//        users1.forEach(System.err::println);
//    }
//
//    private void select1(String name) {
//        QueryWrapper<User> userQueryWrapper;
//        userQueryWrapper = new QueryWrapper<>();
//        userQueryWrapper
//                //判断条件放condition里，为true则拼接
//                .like(StringUtils.isNotEmpty(name),"name", name)
//                .between("age", 20, 40)
//                .isNotNull("email");
//        List<User> users1 = userMapper.selectList(userQueryWrapper);
//        users1.forEach(System.err::println);
//    }
//
//
//}
