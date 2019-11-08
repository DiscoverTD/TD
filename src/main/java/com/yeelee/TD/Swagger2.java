package com.yeelee.TD;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ Author     ：liye
 * @ Date       ：Created in 11:29 2019/8/10
 * @ Description：前后端分离动态API文档配置
 * @ Modified By：liye
 * @Version: V1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    //配置文档扫描的包
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.yeelee.TD.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    //构建API文档的详细信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("记录美好生活 RESTful API")
                //创建人
                .contact(new Contact("yeeLee","https://www.baidu.com","857915060@qq.com"))
                //版本号
                .version("1.0")
                //描述
                .description("记录美好生活 API 描述")
                .build();
    }
}
