package com.yeelee.TD.service.adminService;

import com.yeelee.TD.entity.adminEntity.TRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author wzw
 * @since 2019-12-24
 */
public interface ITRoleService extends IService<TRole> {

    List<TRole> findUserRole(String username);
}
