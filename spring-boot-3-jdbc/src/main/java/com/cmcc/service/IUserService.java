package com.cmcc.service;

public interface IUserService {
	public void create(String name, Integer age);

	public void deleteByName(String name);

	public Integer getAllUsers();

	public void deleteAllUsers();
}
