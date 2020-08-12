package com.cql.mp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cql.mp.entity.Test1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CascadeQueryMapper extends BaseMapper<Test1> {


    List<Test1> select();

}
