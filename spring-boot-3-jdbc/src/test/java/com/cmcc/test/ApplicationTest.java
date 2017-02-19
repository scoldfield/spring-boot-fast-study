package com.cmcc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cmcc.Application;
import com.cmcc.service.IUserService;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {

	@Autowired
	private IUserService userService;

	@Before
	public void setUp() {
		userService.deleteAllUsers(); // 准备，情况所有数据
	}

	@Test
	public void testUserService() throws Exception {
		// 插入5个用户
		userService.create("a", 1);
		userService.create("b", 2);
		userService.create("c", 3);
		userService.create("d", 4);
		userService.create("e", 5);

		//
		Assert.assertEquals(5, userService.getAllUsers().intValue());

		// 删除两个用户
		userService.deleteByName("a");
		userService.deleteByName("e");
		
		// 查数据库，应该有5个用户
		Assert.assertEquals(3, userService.getAllUsers().intValue());

	}
}
