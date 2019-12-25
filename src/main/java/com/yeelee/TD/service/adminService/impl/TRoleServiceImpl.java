package com.yeelee.TD.service.adminService.impl;

import com.yeelee.TD.entity.adminEntity.TRole;
import com.yeelee.TD.mapper.adminMapper.TRoleMapper;
import com.yeelee.TD.service.adminService.ITRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author wzw
 * @since 2019-12-24
 */
@Service
public class TRoleServiceImpl extends ServiceImpl<TRoleMapper, TRole> implements ITRoleService {
    @Autowired
    TRoleMapper tRoleMapper;

    @Override
    public List<TRole> findUserRole(String username) {
        return tRoleMapper.findUserRole(username);
    }
}
