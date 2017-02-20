package com.cmcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling	//启动定时任务的配置
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
