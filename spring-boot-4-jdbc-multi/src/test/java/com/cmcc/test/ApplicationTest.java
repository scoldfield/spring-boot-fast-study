package com.cmcc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
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
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate primaryJdbcTemplate;

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate secondaryJdbcTemplate;

	@Before
	public void setUp() {
		primaryJdbcTemplate.update("delete from user");
		secondaryJdbcTemplate.update("delete from user");
	}

	@Test
	public void testUserService() throws Exception {
		// ����һ������Դ�в�����������
		primaryJdbcTemplate.update("insert into user(id,name,age) values(?, ?, ?)", 1, "aaa", 20);
		primaryJdbcTemplate.update("insert into user(id,name,age) values(?, ?, ?)", 2, "bbb", 30);
		
		// ���ڶ�������Դ�в���һ�����ݣ���������ǵ�һ������Դ�����������ͻ����
		secondaryJdbcTemplate.update("insert into user(id,name,age) values(?, ?, ?)", 1, "aaa", 20);
		
		// ��һ�µ�һ������Դ���Ƿ����������ݣ���֤�����Ƿ�ɹ�
		Assert.assertEquals("2", primaryJdbcTemplate.queryForObject("select count(1) from user", String.class));
		
		// ��һ�µ�һ������Դ���Ƿ����������ݣ���֤�����Ƿ�ɹ�
		Assert.assertEquals("1", secondaryJdbcTemplate.queryForObject("select count(1) from user", String.class));
	}
}
