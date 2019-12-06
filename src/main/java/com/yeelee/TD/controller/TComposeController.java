package com.yeelee.TD.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeelee.TD.service.ITComposeService;
import com.yeelee.TD.entity.TCompose;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yeelee.TD.utils.ResponseObj;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
    * 日记表(作品) 前端控制器
    * </p>
 *
 * @author yeeLee
 * @since 2019-12-01
 * @version v1.0
 */
@Api(tags = {"日记表(作品)"})
@RestController
@RequestMapping("/TD/t-compose")
public class TComposeController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ITComposeService tComposeService;

    /**
     * 条件分页查询
     * @param pageNum 当前页码
     * @param pageSize 每页条数
     * @param tCompose 查询对象
     * @return
     */
    @ApiOperation(value = "条件分页查询")
    @PostMapping(value = "/list")
    public ResponseObj listPageByCondition(@RequestParam("pageNum") Long pageNum, @RequestParam("pageSize") Long pageSize,@RequestBody TCompose tCompose){
        IPage<TCompose> page = tComposeService.page(new Page<>(pageNum, pageSize), new QueryWrapper<>(tCompose));
            return ResponseObj.ok("成功",page);
    }

    /**
     * 根据id查询
     */
    @ApiOperation(value = "根据id查询数据")
    @GetMapping(value = "/get")
    public ResponseObj getById(@RequestParam("id") String id){
    TCompose tCompose = tComposeService.getById(id);
        return ResponseObj.ok("成功",tCompose);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增数据")
    @PostMapping(value = "/add")
    public ResponseObj add(@RequestBody TCompose tCompose){
        boolean b =tComposeService.save(tCompose);
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
        boolean b =tComposeService.removeById(id);
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
    public ResponseObj update(@RequestBody TCompose tCompose){
        boolean b =tComposeService.updateById(tCompose);
        if(b){
            return ResponseObj.ok("保存成功");
        }else{
            return ResponseObj.fail("保存失败");
        }
    }
}
