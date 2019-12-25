package com.yeelee.TD.config;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ShiroFilter  extends FormAuthenticationFilter {
    private static final Logger logger = LoggerFactory.getLogger(ShiroFilter.class);


    public ShiroFilter() {
        super();
    }

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //Always return true if the request's method is OPTIONS
        if (request instanceof HttpServletRequest) {
            if (((HttpServletRequest) request).getMethod().toUpperCase().equals("OPTIONS")) {
                return true;
            }
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
       
        HttpServletResponse res = (HttpServletResponse)response;
//        HttpServletRequest req = (HttpServletRequest)request;
//        String encodedAuth = req.getHeader("Authorization");
//        //要求客户端发送身份认证信息,并且只能是BEARER认证方式中
//        if( null !=  encodedAuth ) {
//            //当用户单击登录框中的“取消”按钮时，将输出下面的内容
//            if (encodedAuth.toUpperCase().startsWith("BEARER")){
//                System.out.println("有Authorization!");
//                return true;
//            }else{
//                return false;
//            }
//        }
        logger.info("SHIROFILTER authc拦截");

        res.setHeader("Access-Control-Allow-Origin", "true");
        res.setContentType("application/json; charset=utf-8");
        res.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = res.getWriter();
        Map<String, Object> map= new HashMap<>();
        map.put("code", 401);
        map.put("msg", "未登录");
        writer.write(JSON.toJSONString(map));
        writer.close();
        //return false 拦截， true 放行
        return false;
    }
}
