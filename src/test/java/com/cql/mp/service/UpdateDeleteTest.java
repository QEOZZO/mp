package com.cql.mp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.cql.mp.dao.UserMapper;
import com.cql.mp.entity.User;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author cql
 * @date 2020/8/11 08:08
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class UpdateDeleteTest {

    @Resource
    UserMapper userMapper;

    /**
     * 全查:按条件
     */
    @Test
    public void udpate() {
        User user = new User();
        user.setId(1281108939232022530L);
        user.setName("luofeng");
        user.setAge(25);
        int i = userMapper.updateById(user);
        System.err.println(i);
    }

    @Test
    public void udpateByWrapper() {
        //更新的内容
        User user = new User();
        user.setName("luofeng333");
        user.setAge(25);
        //条件
        LambdaUpdateWrapper<User> userUpdateWrapper = new LambdaUpdateWrapper<>();
        userUpdateWrapper.eq(User::getName, "luofeng");
        int i = userMapper.update(user,userUpdateWrapper);
        System.err.println(i);
    }

    @Test
    public void udpateByWrapper2() {
        //条件 - 通过set修改
        LambdaUpdateWrapper<User> userUpdateWrapper = new LambdaUpdateWrapper<>();
        userUpdateWrapper.eq(User::getName, "luofeng333").set(User::getName, "luofeng22");
        int i = userMapper.update(null,userUpdateWrapper);
        System.err.println(i);
    }
    @Test
    public void udpateByWrapper3() {
        //条件 - 通过set修改 大于0 true
        LambdaUpdateChainWrapper<User> userUpdateWrapper = new LambdaUpdateChainWrapper<>(userMapper);
        boolean i = userUpdateWrapper.eq(User::getName, "luofeng333").set(User::getName, "luofeng22").update();
        System.err.println(i);
    }

    @Test
    public void deleteById() {
        int i = userMapper.deleteById(1L);
        System.err.println(i);
    }
    @Test
    public void deleteByBatchIds() {
        int i = userMapper.deleteBatchIds(Arrays.asList(1L,2L));
        System.err.println(i);
    }
    @Test
    public void deleteMaps() {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("name", "luofeng");
        int i = userMapper.deleteByMap(objectObjectHashMap);
        System.err.println(i);
    }
    @Test
    public void deleteWrapper() {
        User user = new User();
        user.setName("luofeng");
        user.setAge(18);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>(user);
        userQueryWrapper
                .like("name", "雨")
                .lt("age", 40);
        int users = userMapper.delete(userQueryWrapper);
    }




}
