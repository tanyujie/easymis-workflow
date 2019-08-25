package org.easymis.workflow.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan(basePackages = "org.easymis.workflow.app")
@ServletComponentScan
@MapperScan("org.easymis.workflow.app.mapper")
@EnableHystrix
@EnableFeignClients(basePackages = "org.easymis.workflow.app")
@EnableDiscoveryClient
public class AppWebApplication {

	public static void main(String[] args) {

		SpringApplication.run(AppWebApplication.class, args);
	}

}