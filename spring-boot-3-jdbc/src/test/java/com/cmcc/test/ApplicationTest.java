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
		userService.deleteAllUsers(); // ׼���������������
	}

	@Test
	public void testUserService() throws Exception {
		// ����5���û�
		userService.create("a", 1);
		userService.create("b", 2);
		userService.create("c", 3);
		userService.create("d", 4);
		userService.create("e", 5);

		//
		Assert.assertEquals(5, userService.getAllUsers().intValue());

		// ɾ�������û�
		userService.deleteByName("a");
		userService.deleteByName("e");
		
		// �����ݿ⣬Ӧ����5���û�
		Assert.assertEquals(3, userService.getAllUsers().intValue());

	}
}
