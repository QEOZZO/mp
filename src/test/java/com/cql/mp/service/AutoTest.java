package com.cql.mp.service;

import com.cql.mp.dao.OrdersMapper;
import com.cql.mp.entity.Orders;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 *
 * @author cql
 * @date 2020/8/11 08:08
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class AutoTest {

    @Resource
    OrdersMapper ordersMapper;

    @Test
    public void insert() {
        Orders orders = new Orders();
        orders.setAmount(new BigDecimal("111"));
        orders.setProductId(123456L);
        int insert = ordersMapper.insert(orders);
        System.err.println(insert);
    }

    @Test
    public void update() {
        Orders orders = new Orders();
        orders.setAmount(new BigDecimal("111"));
        orders.setProductId(123456L);
        orders.setId(1281405541339430914L);
        int insert = ordersMapper.updateById(orders);
        System.err.println(insert);

    }

}
