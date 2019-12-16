package com.yeelee.TD.service.impl;

import com.yeelee.TD.entity.TUserLogin;
import com.yeelee.TD.mapper.TUserLoginMapper;
import com.yeelee.TD.service.ITUserLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeelee.TD.utils.ResponseObj;
import com.yeelee.TD.utils.ShiroUtil;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户登录表 服务实现类
 * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 */
@Service
public class TUserLoginServiceImpl extends ServiceImpl<TUserLoginMapper, TUserLogin> implements ITUserLoginService {

    @Autowired
    TUserLoginMapper tUserLoginMapper;
    /**
     *  管理端登录
     * @param tUserLogin
     */
    public ResponseObj login(TUserLogin tUserLogin, HttpServletResponse resp) {
        Map<String, Object> map = new HashMap<>();
        UsernamePasswordToken token = new UsernamePasswordToken(tUserLogin.getUsername(), tUserLogin.getPassword());
        Subject subject = ShiroUtil.getSubject();
        if (subject != null) {
            subject.logout();
        }
        ShiroUtil.login(token);
        Map<String, Object> m = ShiroUtil.getToken();
        resp.setHeader("Authorization", m.get("token").toString());
        TUserLogin u = tUserLoginMapper.selectUserone(tUserLogin.getUsername());
        map.put("user",u);
        return ResponseObj.ok("success",map);

    }
}
