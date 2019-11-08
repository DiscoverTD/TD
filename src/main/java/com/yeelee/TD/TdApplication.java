package com.yeelee.TD;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.yeelee.TD.mapper")
@EnableTransactionManagement //开启事物
@EnableScheduling
public class TdApplication {
	private static Logger logger = LoggerFactory.getLogger(TdApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TdApplication.class, args);
		logger.info("========================启动成功==============================");
	}

}
