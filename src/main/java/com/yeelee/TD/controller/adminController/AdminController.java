package com.yeelee.TD.controller.adminController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yeelee.TD.utils.ResponseObj;
@RestController
@RequestMapping("/admin")
public class AdminController {
	/**
	    *     管理端登录
	* @param account 账户
	* @param password 密码
	* @param code 验证码
	* @return
	*/
	@RequestMapping("/tdlogin")
	public String tdLogin(String account,String password,String code){
		return "login";
	}
	@RequestMapping("/list")
	public Map<String, Object> list(){
		Map<String, Object> map = new HashMap();
		return map;
	}
	
}
