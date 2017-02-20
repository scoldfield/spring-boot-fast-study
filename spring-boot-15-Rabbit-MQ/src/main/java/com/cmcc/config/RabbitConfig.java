package com.cmcc.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {	//创建RabbitMQ配置类，用来配置队列、交换器、路由等高级信息。这里只是简单进行了自定义配置来完成基本生产消费过程

	@Bean
	public Queue helloQueue(){
		return new Queue("queue1");	//创建一个队列queue1
	}
}
