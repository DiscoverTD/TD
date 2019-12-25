package com.yeelee.TD.controller.adminController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yeelee.TD.service.adminService.ITUserRoleService;
import com.yeelee.TD.service.adminService.impl.TUserRoleServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeelee.TD.entity.adminEntity.TUserRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yeelee.TD.utils.ResponseObj;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
    * 用户角色关联表 前端控制器
    * </p>
 *
 * @author wzw
 * @since 2019-12-24
 * @version v1.0
 */
@Api(tags = {"用户角色关联表"})
@RestController
@RequestMapping("/TD/t-user-role")
public class TUserRoleController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ITUserRoleService tUserRoleService;

    /**
     * 条件分页查询
     * @param pageNum 当前页码
     * @param pageSize 每页条数
     * @param tUserRole 查询对象
     * @return
     */
    @ApiOperation(value = "条件分页查询")
    @PostMapping(value = "/list")
    public ResponseObj listPageByCondition(@RequestParam("pageNum") Long pageNum, @RequestParam("pageSize") Long pageSize,@RequestBody TUserRole tUserRole){
        IPage<TUserRole> page = tUserRoleService.page(new Page<>(pageNum, pageSize), new QueryWrapper<>(tUserRole));
            return ResponseObj.ok("成功",page);
    }

    /**
     * 根据id查询
     */
    @ApiOperation(value = "根据id查询数据")
    @GetMapping(value = "/get")
    public ResponseObj getById(@RequestParam("id") String id){
    TUserRole tUserRole = tUserRoleService.getById(id);
        return ResponseObj.ok("成功",tUserRole);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增数据")
    @PostMapping(value = "/add")
    public ResponseObj add(@RequestBody TUserRole tUserRole){
        boolean b =tUserRoleService.save(tUserRole);
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
        boolean b =tUserRoleService.removeById(id);
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
    public ResponseObj update(@RequestBody TUserRole tUserRole){
        boolean b =tUserRoleService.updateById(tUserRole);
        if(b){
            return ResponseObj.ok("保存成功");
        }else{
            return ResponseObj.fail("保存失败");
        }
    }
}
