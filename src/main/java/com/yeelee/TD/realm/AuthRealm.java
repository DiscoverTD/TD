package com.yeelee.TD.realm;

import com.yeelee.TD.entity.adminEntity.TMenu;
import com.yeelee.TD.entity.adminEntity.TRole;
import com.yeelee.TD.service.adminService.ITMenuService;
import com.yeelee.TD.service.adminService.ITRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yeelee.TD.entity.TUserLogin;
import com.yeelee.TD.service.impl.TUserLoginServiceImpl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wzw
 * @date 2019-12-11
 */
@Component
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private TUserLoginServiceImpl userService;

    @Autowired
    private ITRoleService roleService;

    @Autowired
    private ITMenuService menuService;

    /**
     * 权限认证
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /**
         * 1. 获取当前登录用户信息
         * 2. 获取当前用户关联的角色、权限等
         * 3. 将角色、权限封装到AuthorizationInfo对象中并返回
         */
         TUserLogin user = (TUserLogin) SecurityUtils.getSubject().getPrincipal();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        //获取用户角色
        List<TRole> roleList = roleService.findUserRole(user.getUsername());
        Set<String> roleSet = roleList.stream().map(TRole::getName).collect(Collectors.toSet());
        simpleAuthorizationInfo.setRoles(roleSet);

        //获取用户权限
        List<TMenu> menuList = menuService.findUserPermissions(user.getUsername());
        Set<String> permSet = menuList.stream().map(TMenu::getPerms).collect(Collectors.toSet());
        simpleAuthorizationInfo.setStringPermissions(permSet);

        return simpleAuthorizationInfo;
    }

    /**
     * 身份校验
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /**
         * 1. 从token中获取输入的用户名
         * 2. 通过username查询数据库得到用户对象
         * 3. 调用Authenticator进行密码校验
         */
    	//1.把AuthenticationToken转换为UsernamePasswordToken
    	UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
    	
    	//2.从UsernamePasswordToken中获取username
    	String username = userToken.getUsername();
    	
        QueryWrapper<TUserLogin> queryWrapper = new QueryWrapper<>(new TUserLogin());
        queryWrapper.eq("username",username);
        TUserLogin user = userService.getOne(queryWrapper);

        if (user == null) {
            throw new UnknownAccountException("用户不存在");
        }
        /**
         * 交给Shiro进行密码的解密校验
         * 调用SecurityUtils.getSubject().getPrincipal() 遇到类型转换问题，报错 String !=> User
         * 请参考这篇文章：{@link https://blog.csdn.net/qq_35981283/article/details/78634575}
         */
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                credentialsSalt,
                getName()
        );
        return authenticationInfo;
    }

}
