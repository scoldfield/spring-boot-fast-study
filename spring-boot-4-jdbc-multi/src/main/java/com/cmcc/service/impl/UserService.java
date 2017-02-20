package com.cmcc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cmcc.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;	//spring-boot�е�JdbcTemplate���Զ����õģ�����ֱ��ע�뼴��
	
	public void create(String name, Integer age) {
		jdbcTemplate.update("insert into user(name, age) values(?,?)", name, age);
	}

	public void deleteByName(String name) {
		jdbcTemplate.update("delete from user where name = ?", name);
	}

	public Integer getAllUsers() {
		return jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
	}

	public void deleteAllUsers() {
		jdbcTemplate.update("delete from user");
	}

}
