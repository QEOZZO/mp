package com.cql.mp.service;

import com.cql.mp.dao.OrdersMapper;
import com.cql.mp.entity.Orders;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 *
 * @author cql
 * @date 2020/8/11 08:08
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class InjectorTest {

    @Resource
    OrdersMapper ordersMapper;

    /**
     * 逻辑删除：
     * Consume Time：42 ms 2020-07-10 14:18:43
     * Execute SQL：delete from users
     * org.springframework.dao.DataIntegrityViolationException:
     * ### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException:
     * Cannot delete or update a parent row: a foreign key constraint fails (`mp`.`users`, CONSTRAINT `manager_fks` FOREIGN KEY (`manager_id`) REFERENCES `users` (`id`)
     * 当因为外键发生报错时：
     * 问题主要是删除记录的时候删不了，最后发现是中间表的外键默认删除时是RESTRICT，
     *   当取值为No Action或者Restrict时，则当在父表（即外键的来源表）中删除对应记录时，首先检查该记录是否有对应外键，如果有则不允许删除。
     *   当取值为Cascade时，则当在父表（即外键的来源表）中删除对应记录时，首先检查该记录是否有对应外键，如果有则也删除外键在子表（即包含外键的表）中的记录。
     *   当取值为Set Null时，则当在父表（即外键的来源表）中删除对应记录时，首先检查该记录是否有对应外键，如果有则设置子表中该外键值为null（不过这就要求该外键允许取null）。
     *   解决:  把外键字段原来默认的Restrict改成CASCADE即可
     */
    @Test
    public void deleteAll() {
        int i = ordersMapper.deleteAll();
        System.err.println(i);
    }

    /**
     * 批量插入
     */
    @Test
    public void insertBatch() {
        ArrayList<Orders> objects = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Orders orders = new Orders();
            orders.setProductName("luofengddd"+i);
            objects.add(orders);
        }
        ordersMapper.insertBatchSomeColumn(objects);
    }
    /**
     * 根据 id 逻辑删除数据,并带字段填充功能
     */
    @Test
    public void deleteByIdWithFill() {
        //逻辑删除时，同时修改其他字段
        Orders orders = new Orders();
        //修改时自动填充
        orders.setProductName("hhhh");
        orders.setId(1281482044978774017L);
        ordersMapper.deleteByIdWithFill(orders);
    }
    /**
     * 根据 id 更新部分字段：
     * name不更新：且不包含逻辑删除
     *  Execute SQL：UPDATE users SET age=NULL, email=NULL, manager_id=NULL, create_time=NULL,
     *  update_time='2020-07-10T15:34:00.151+0800', version=NULL WHERE id=1281482044978774017 AND deleted=0
     */
    @Test
    public void alwaysUpdateSomeColumnById() {
        //逻辑删除时，同时修改其他字段
        Orders orders = new Orders();
        //修改时自动填充
        orders.setProductName("hhhh");
        orders.setId(1281482044978774017L);
        ordersMapper.alwaysUpdateSomeColumnById(orders);
    }
}
