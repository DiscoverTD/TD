package com.yeelee.TD.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yeelee.TD.entity.TEnshrine;
import com.yeelee.TD.service.ITEnshrineService;
import com.yeelee.TD.utils.ResponseObj;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
    * 收藏表 前端控制器
    * </p>
 *
 * @author yeeLee
 * @since 2019-12-01
 * @version v1.0
 */
@Api(tags = {""})
@RestController
@RequestMapping("/TD/t-enshrine")
public class TEnshrineController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ITEnshrineService tEnshrineService;

    /**
     * 条件分页查询
     * @param pageNum 当前页码
     * @param pageSize 每页条数
     * @param tEnshrine 查询对象
     * @return
     */
    @ApiOperation(value = "条件分页查询")
    @PostMapping(value = "/list")
    public ResponseObj listPageByCondition(@RequestParam("pageNum") Long pageNum, @RequestParam("pageSize") Long pageSize,@RequestBody TEnshrine tEnshrine){
        IPage<TEnshrine> page = tEnshrineService.page(new Page<>(pageNum, pageSize), new QueryWrapper<>(tEnshrine));
            return ResponseObj.ok("成功",page);
    }

    /**
     * 根据id查询
     */
    @ApiOperation(value = "根据id查询数据")
    @GetMapping(value = "/get")
    public ResponseObj getById(@RequestParam("id") String id){
    TEnshrine tEnshrine = tEnshrineService.getById(id);
        return ResponseObj.ok("成功",tEnshrine);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增数据")
    @PostMapping(value = "/add")
    public ResponseObj add(@RequestBody TEnshrine tEnshrine){
        boolean b =tEnshrineService.save(tEnshrine);
       if(b){
            return ResponseObj.ok("成功");
        }else{
            return ResponseObj.fail("失败");
        }
    }
    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @DeleteMapping(value = "/del")
    public ResponseObj delete(@RequestParam("id") String id){
        boolean b =tEnshrineService.removeById(id);
       if(b){
            return ResponseObj.ok("成功");
        }else{
            return ResponseObj.fail("失败");
        }
    }

    /**
     * 更新通过主键
     */
    @ApiOperation(value = "更新数据")
    @PutMapping(value = "/update")
    public ResponseObj update(@RequestBody TEnshrine tEnshrine){
        boolean b =tEnshrineService.updateById(tEnshrine);
        if(b){
            return ResponseObj.ok("保存成功");
        }else{
            return ResponseObj.fail("保存失败");
        }
    }
}
