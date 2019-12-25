package com.yeelee.TD.controller.adminController;

import com.yeelee.TD.entity.TUserLogin;
import com.yeelee.TD.service.adminService.IAdminUserLoginService;
import com.yeelee.TD.service.adminService.impl.AdminUserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class AdminUserController {
	
    @Autowired
    IAdminUserLoginService adminUserLoginServiceImpl;

    /**
     * 获取所有用户
     * @return
     */
    @RequestMapping("/list")
    public List<TUserLogin> getAll(){
        List<TUserLogin> users = adminUserLoginServiceImpl.getAll();
        return users;
    }
}
