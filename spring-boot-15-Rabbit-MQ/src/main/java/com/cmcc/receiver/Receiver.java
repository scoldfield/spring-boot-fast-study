package com.cmcc.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queue1")	//@RabbitListener注解用于对queue1队列进行监听
public class Receiver {

	@RabbitHandler		//使用@RabbitHandler注解来指定处理消息的方法
	public void process(String msg){
		System.out.println("Receiver: " + msg);
	}
}
