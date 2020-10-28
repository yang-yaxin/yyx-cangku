package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(value="com.jk.mapper")
@RefreshScope
public class ProjectProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectProviderApplication.class, args);
		System.out.println("provider生产者启动了");
	}

}
