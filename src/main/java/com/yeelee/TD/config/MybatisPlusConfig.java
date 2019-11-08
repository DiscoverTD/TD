package com.yeelee.TD.config;

import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @ Author     ：liye
 * @ Date       ：Created in 16:20 2019/8/11
 * @ Description：MybatisPlus的一些配置
 * @ Modified By：liye
 * @Version: V1.0
 */
@Configuration
@MapperScan("***.******.mapper*")
public class MybatisPlusConfig {
    /*
     * 分页插件，自动识别数据库类型
     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        PaginationInterceptor page = new PaginationInterceptor();
//        page.setDialectType("mysql");
//        return page;
//    }
    /**
     * SQL执行效率插件
     */
    @Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启 此配置在application.yml中配置
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }
}
