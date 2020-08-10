package com.cql.mp.dao;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cql.mp.entity.Orders;
import com.cql.mp.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 * @author cql
 * @date 2020/8/10 18:08
*/
public interface OrdersMapper extends CommonMapper<Orders> {

    /**
     * SqlParser(filter = true) 表示不增加租户信息
     * 若版本在3.1.1之前，则需要做全局配置
     * @param wrapper
     * @return
     */
    @SqlParser(filter = true)
    @Select("select * from orders ${ew.customSqlSegment}")
    List<Orders> selectAll(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

    @Select("select * from orders ${ew.customSqlSegment}")
    IPage<Orders> selectUsersPages(Page<Orders> orderPage, @Param(Constants.WRAPPER) Wrapper<Orders> wrapper);

}
