package com.cql.mp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cql.mp.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
