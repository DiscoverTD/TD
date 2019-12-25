package com.yeelee.TD.service.adminService;

import com.yeelee.TD.entity.adminEntity.TMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author wzw
 * @since 2019-12-24
 */
public interface ITMenuService extends IService<TMenu> {

    List<TMenu> findUserPermissions(String username);
}
