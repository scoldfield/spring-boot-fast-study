package com.cmcc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cmcc.Application;
import com.cmcc.sender.Sender;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)	//web应用测试的时候@SpringApplicationConfiguration注入的都是MockServletConfig.class；普通应用测试的时候@SpringApplicationConfiguration注入的都是Application.class
public class ApplicationTest {

	@Autowired
	private Sender sender;
	
	@Test
	public void hello(){
		sender.send();
	}
}
