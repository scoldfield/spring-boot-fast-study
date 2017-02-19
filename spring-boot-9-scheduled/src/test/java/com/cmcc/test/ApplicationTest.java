package com.cmcc.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cmcc.Application;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)	//普通应该中的@SpringApplicationConfiguration应该注入Application.class
public class ApplicationTest {

	@Value("${com.cmcc.name}")
	private String name;
	
	@Value("${com.cmcc.desc}")
	private String desc;
	
	@Value("${random.value}")
	private String value;

	@Value("${random.num}")
	private String intNum;	//必须都用String来接收数据
	
	@Value("${random.num10}")
	private String num10;
	
	@Value("${com.cmcc.profile}")
	private String profile;
	
	@Test
	public void testProperties() throws Exception{
//		Assert.assertEquals("scoldfield", name);
//		Assert.assertEquals("scoldfield在干嘛？", desc);
//		System.out.println("random.value = " + value);
//		System.out.println("random.intNum = " + intNum);
//		System.out.println("random.num10 = " + num10);
		
		Assert.assertEquals("呵呵", profile);
	}
}
