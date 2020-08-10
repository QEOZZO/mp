package com.cql.mp;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cql.mp.dao.UserMapper;
import com.cql.mp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class ListTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void mpList(){
        User user=new User();
        user.setEmail("222");
//        userMapper.insert(user);

//        List<User> userList = userMapper.selectList(Wrappers.<User>lambdaQuery().eq(User::getAge, 1));
        int update = userMapper.update(user, Wrappers.<User>lambdaUpdate().like(User::getEmail, "11"));
        System.out.println(update);

    }
}
