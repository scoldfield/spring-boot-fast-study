package com.cmcc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cmcc.Application;
import com.cmcc.mapper.UserMapper;
import com.cmcc.model.User;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)	//web应用测试的时候@SpringApplicationConfiguration注入的都是MockServletConfig.class；普通应用测试的时候@SpringApplicationConfiguration注入的都是Application.class
public class ApplicationTest {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	@Transactional
	public void test(){
		int num = userMapper.insert("李四", 20);
		User user = userMapper.findByUsername("李四");
		Assert.assertEquals(20, user.getAge().intValue());
	}
}
