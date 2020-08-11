package com.cql.mp.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cql.mp.entity.User;
import com.cql.mp.vo.MultiCheckVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user ${ew.customSqlSegment}")
    List<User> selectAll(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

    List<User> selectAll2(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

    @Select("select * from user ${ew.customSqlSegment}")
    IPage<User> selectUsersPages(Page<User> userPage, @Param(Constants.WRAPPER) Wrapper<User> wrapper);

    @Select("select id as userId,manager_id as userIds from user ")
    IPage<MultiCheckVo> selectUsersPagesTest(Page<User> userPage);

    @Select("select t.id as userId,g.id as orderIds from `user` t ,orders g where t.id=g.create_user ")
    IPage<MultiCheckVo> selectUsersPagesTest2(Page<User> userPage);

    @Select("select t.id as userId,g.id as orderIds from `user` t ,orders g where t.id=g.create_user and t.id =#{userId}")
    IPage<MultiCheckVo> selectUsersPagesTest3(Page<User> userPage,@Param("userId") String userId);

}
