package com.cql.mp.controller;

import cn.icasc.cloud.common.http.RestResponse;
import com.alibaba.fastjson.JSONObject;
import com.cql.mp.dao.CascadeQueryMapper;
import com.cql.mp.entity.Test1;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "级联查询测试", tags="级联查询测试")
@RestController
@RequestMapping("cascadeQuery")
public class CascadeQueryController {

    @Resource
    CascadeQueryMapper cascadeQueryMapper;

    @ApiOperation(value="测试查询", notes="测试查询", produces="application/json")
    @PostMapping("select")
    public RestResponse select(){
        System.out.println("cql测试分支");

        List<Test1> page = cascadeQueryMapper.select();
        return RestResponse.success().setData(JSONObject.toJSON(page));
    }


}
