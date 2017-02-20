package com.cmcc.sender;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private AmqpTemplate rabbitTemplate;	//通过AmqpTemplate接口来进行消息的发送
	
	public void send(){
		String context = "hello: " + new Date();
		System.out.println("sender: " + context);
		this.rabbitTemplate.convertAndSend("queue1", context);	//产生一个字符串，并发送到名为queue1的队列中
	}
}
