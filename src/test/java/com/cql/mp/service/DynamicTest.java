package com.cql.mp.service;

import com.cql.mp.conf.MybatisPlusConf;
import com.cql.mp.dao.OrdersMapper;
import com.cql.mp.entity.Orders;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author cql
 * @date 2020/8/11 08:08
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class DynamicTest {

    @Resource
    OrdersMapper ordersMapper;

    /**
     * 动态表名操作
     * SELECT  id,name,age,email,manager_id,create_time,update_time,version  FROM user_2019   WHERE deleted=0
     * ### Cause: java.sql.SQLSyntaxErrorException: Table 'mp.user_2019' doesn't exist
     */
    @Test
    public void select() {
        MybatisPlusConf.myTableName.set("user_2019");
        List<Orders> list = ordersMapper.selectList(null);
        list.forEach(System.err::println);
    }


}
