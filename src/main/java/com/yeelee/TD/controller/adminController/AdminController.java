package com.yeelee.TD.controller.adminController;

import com.alibaba.druid.util.StringUtils;
import com.yeelee.TD.entity.TUserLogin;
import com.yeelee.TD.enums.StatusEnums;
import com.yeelee.TD.service.ITUserLoginService;
import com.yeelee.TD.service.impl.TUserLoginServiceImpl;
import com.yeelee.TD.utils.Captcha;
import com.yeelee.TD.utils.GifCaptcha;
import com.yeelee.TD.utils.ResponseObj;
import com.yeelee.TD.utils.ShiroUtil;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	TUserLoginServiceImpl tUserLoginService;
	/**
	    *     管理端登录
	* @param tUserLogin
	* @return
	*/
	@RequestMapping("/tdlogin")
	public ResponseObj tdLogin(@RequestBody TUserLogin tUserLogin,HttpServletResponse res){
		if(StringUtils.isEmpty(tUserLogin.getUsername())){
			return ResponseObj.ok("massage","请填写用户名");
		}
		if(StringUtils.isEmpty(tUserLogin.getPassword())){
			return ResponseObj.ok("massage","请填写密码");
		}
		ResponseObj login = tUserLoginService.login(tUserLogin, res);
		return login;
	}
	@RequestMapping("/list")
	public Map<String, Object> list(){
		Map<String, Object> map = new HashMap();
		return map;
	}

	@GetMapping("/gifCode")
	public String getCode(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Expires", "0");
			response.setContentType("image/gif");
			Captcha captcha = new GifCaptcha(146, 33, 4);
			captcha.out(response.getOutputStream());
			HttpSession session = request.getSession(true);
			session.removeAttribute("gifCode");
			session.setAttribute("gifCode", captcha.text().toLowerCase());
			return captcha.text().toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}


	/**
	 * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
	 * @return
	 */
	@RequestMapping(value = "/unauth")
	@ResponseBody
	public Object unauth() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "401");
		map.put("msg", "未登录");
		return map;
	}
	
}
