package com.yeelee.TD.service.adminService.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeelee.TD.entity.TUserLogin;
import com.yeelee.TD.mapper.TUserLoginMapper;
import com.yeelee.TD.mapper.adminMapper.AdminUserLoginMapper;
import com.yeelee.TD.service.adminService.IAdminUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户登录表 服务实现类
 * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 */
@Service
public class AdminUserLoginServiceImpl extends ServiceImpl<TUserLoginMapper, TUserLogin> implements IAdminUserLoginService {
    @Autowired
    AdminUserLoginMapper adminUserLoginMapper;

    /**
     * 获取所有用户
     * @return
     */
    @Override
    public List<TUserLogin> getAll(){
        List<TUserLogin> users = adminUserLoginMapper.selectUserList();
        return  users;
    }

}
