package com.cql.mp.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cql.mp.dao.OrdersMapper;
import com.cql.mp.entity.Orders;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2020/7/9 11:47
 * @Description : 自定义sql测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class DeleteTest {

    @Resource
    OrdersMapper ordersMapper;

    @Value("${spring.profiles.active}")
    String env;

    /**
     * 逻辑删除：
     * UPDATE users SET deleted=1 WHERE id=? AND deleted=0
     * 1087982257332887553(Long)
     */
    @Test
    public void deleteById() {
        int i = ordersMapper.deleteById(1087982257332887553L);
        System.err.println(i);
    }

    /**
     * 被逻辑删除的 ，将无法再次被查询出来
     */
    @Test
    public void selectList() {
        System.err.println("当前环境："+ env);
        List<Orders> list = ordersMapper.selectList(null);
        list.forEach(System.err::println);
    }
    /**
     * 被逻辑删除的 ，将无法被更新
     */
    @Test
    public void update() {
        Orders orders = new Orders();
        orders.setId(1087982257332887553L);
        orders.setProductName("西瓜");
        ordersMapper.updateById(orders);
    }

    /**
     * 自定义查询：会查出所有的数据，包含delete == 1的数据
     */
    @Test
    public void upselectCustom() {
        LambdaQueryWrapper<Orders> lambda = new LambdaQueryWrapper<>();
        lambda.like(Orders::getAmount, "111")
                .lt(Orders::getProductId, 12345);
        //注解
        List<Orders> users = ordersMapper.selectAll(lambda);
        users.forEach(System.err::println);

    }



}
