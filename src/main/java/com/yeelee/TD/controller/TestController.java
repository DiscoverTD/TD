package com.yeelee.TD.controller;

import com.yeelee.TD.entity.TCompose;
import com.yeelee.TD.mapper.TPraiseMapper;
import com.yeelee.TD.service.ITComposeService;
import com.yeelee.TD.utils.ResponseObj;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"测试控制器"})
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TPraiseMapper praiseMapper;

    @Autowired
    ITComposeService composeService;

    @ApiOperation(value = "条件分页查询")
    @PostMapping(value = "/getNum")
    public ResponseObj listPageByCondition(){
        List<TCompose> composeList = composeService.getComposeList(1L, 3L, null);
        return ResponseObj.ok(composeList);
    }

}
