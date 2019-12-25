package com.yeelee.TD.service.adminService;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yeelee.TD.entity.TUserLogin;

import java.util.List;

/**
 * <p>
 * 用户登录表 服务类
 * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 */
public interface IAdminUserLoginService extends IService<TUserLogin> {
        List<TUserLogin> getAll();
}
