package com.yeelee.TD.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeelee.TD.service.ITReplyService;
import com.yeelee.TD.entity.TReply;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yeelee.TD.utils.ResponseObj;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
    * 回复表 前端控制器
    * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 * @version v1.0
 */
@Api(tags = {"回复表"})
@RestController
@RequestMapping("/TD/t-reply")
public class TReplyController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ITReplyService tReplyService;

    /**
     * 条件分页查询
     * @param pageNum 当前页码
     * @param pageSize 每页条数
     * @param tReply 查询对象
     * @return
     */
    @ApiOperation(value = "条件分页查询")
    @PostMapping(value = "/list")
    public ResponseObj listPageByCondition(@RequestParam("pageNum") Long pageNum, @RequestParam("pageSize") Long pageSize,@RequestBody TReply tReply){
        IPage<TReply> page = tReplyService.page(new Page<>(pageNum, pageSize), new QueryWrapper<>(tReply));
            return ResponseObj.ok("成功",page);
    }

    /**
     * 根据id查询
     */
    @ApiOperation(value = "根据id查询数据")
    @GetMapping(value = "/get")
    public ResponseObj getById(@RequestParam("id") String id){
    TReply tReply = tReplyService.getById(id);
        return ResponseObj.ok("成功",tReply);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增数据")
    @PostMapping(value = "/add")
    public ResponseObj add(@RequestBody TReply tReply){
        boolean b =tReplyService.save(tReply);
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
        boolean b =tReplyService.removeById(id);
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
    public ResponseObj update(@RequestBody TReply tReply){
        boolean b =tReplyService.updateById(tReply);
        if(b){
            return ResponseObj.ok("保存成功");
        }else{
            return ResponseObj.fail("保存失败");
        }
    }
}
