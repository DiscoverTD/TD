package com.yeelee.TD.controller;

import com.alibaba.fastjson.JSONObject;
import com.yeelee.TD.utils.ResponseObj;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


/**
 * @ Author     ：liye
 * @ Date       ：Created in 19:35 2019/12/3
 * @ Description：登录的controller
 * @ Modified By：liye
 * @Version: V1.0
 */
@Api(tags = {"登录"})
@RestController
@RequestMapping("/login")
public class LoginController {

    @Value("${weixin.appid}")
    private  String appid;

    @Value("${weixin.secret}")
    private  String secret;

    @Value("${weixin.access-token-base-url}")
    private  String wxAccessTokenBaseUrl;

    @Autowired
    RestTemplate restTemplate;


    /**
     *
     * @param code
     * @return
     */
    @GetMapping(value = "/wxLogin")
    public ResponseObj<Object> wxLogin(String code,String nickName,String avatarUrl){
        String url = wxAccessTokenBaseUrl+"appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
        ResponseEntity forEntity1 = restTemplate.getForEntity(url, String.class);
        Object parse = JSONObject.parse(forEntity1.getBody().toString());
        System.out.println(forEntity1.getBody());
//        System.out.println("openid:"+forEntity1.getBody().get("openid"));
//        System.out.println("errcode"+forEntity1.getBody().get("errcode"));
//        System.out.println("errmsg"+forEntity1.getBody().get("errmsg"));

        return ResponseObj.ok(parse);
    }
}