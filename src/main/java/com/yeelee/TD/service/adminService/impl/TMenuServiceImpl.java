package com.yeelee.TD.service.adminService.impl;

import com.yeelee.TD.entity.adminEntity.TMenu;
import com.yeelee.TD.mapper.adminMapper.TMenuMapper;
import com.yeelee.TD.service.adminService.ITMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author wzw
 * @since 2019-12-24
 */
@Service
public class TMenuServiceImpl extends ServiceImpl<TMenuMapper, TMenu> implements ITMenuService {
    @Autowired
    TMenuMapper tMenuMapper;

    @Override
    public List<TMenu> findUserPermissions(String username) {
        return tMenuMapper.findUserPermissions(username);
    }
}
