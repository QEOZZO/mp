package com.cql.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cql.mp.dao.UserMapper;
import com.cql.mp.entity.User;
import com.cql.mp.service.UserService;
import org.springframework.stereotype.Service;

/**
 *
 * @author cql
 * @date 2020/8/11 08:08
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
