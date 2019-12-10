package com.yeelee.TD.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeelee.TD.service.ITCommentService;
import com.yeelee.TD.entity.TComment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yeelee.TD.utils.ResponseObj;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
    * 评论表 前端控制器
    * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 * @version v1.0
 */
@Api(tags = {"评论表"})
@RestController
@RequestMapping("/TD/t-comment")
public class TCommentController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ITCommentService tCommentService;

    /**
     * 条件分页查询
     * @param orderNo 当前查询出的最小排序号
     * @param composeId 作品(日记)id
     * @return
     */
    @ApiOperation(value = "条件分页查询")
    @PostMapping(value = "/list")
    public ResponseObj listPageByCondition(@RequestParam("orderNo") Long orderNo ,@RequestParam("composeId") String composeId){
        List<TComment> commentList = null;
        try {
            if (orderNo==0L){
                // 第一次统一传0
                orderNo =null;
            }
            commentList = tCommentService.getCommentList(composeId, orderNo);
        } catch (Exception e) {
            logger.error("查询作品【"+composeId+"】评论异常"+e);
            return ResponseObj.servererror("服务异常");
        }
        return ResponseObj.ok("成功",commentList);
    }

    /**
     * 根据id查询
     */
    @ApiOperation(value = "根据id查询数据")
    @GetMapping(value = "/get")
    public ResponseObj getById(@RequestParam("id") String id){
    TComment tComment = tCommentService.getById(id);
        return ResponseObj.ok("成功",tComment);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增数据")
    @PostMapping(value = "/add")
    public ResponseObj add(@RequestBody TComment tComment){
        boolean b =tCommentService.save(tComment);
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
        boolean b =tCommentService.removeById(id);
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
    public ResponseObj update(@RequestBody TComment tComment){
        boolean b =tCommentService.updateById(tComment);
        if(b){
            return ResponseObj.ok("保存成功");
        }else{
            return ResponseObj.fail("保存失败");
        }
    }
}
