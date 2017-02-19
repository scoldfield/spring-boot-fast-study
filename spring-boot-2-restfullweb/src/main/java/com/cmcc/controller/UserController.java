package com.cmcc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmcc.domain.User;

@RestController
@RequestMapping("/users")
public class UserController {

	private static Map<Long, User> users = new ConcurrentHashMap<Long, User>();
	
	@RequestMapping("/")
	public List<User> getUsers(){	//可以通过@RequestParam和@ModelAttribute从页面中传递参数来进行查询条件或翻页信息的传递
		List<User> us = new ArrayList<User>(users.values());
		return us;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createUser(@ModelAttribute User user){
		users.put(user.getId(), user);
		return "success";
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public User get(@PathVariable Long id){
		return users.get(id);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable Long id, @ModelAttribute User user){
		User u = users.get(id);
		u.setName(user.getName());
		u.setAge(user.getAge());
		u.setId(user.getId());
		users.put(id, u);
		return "success";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id){
		users.remove(id);
		return "success";
	}
}
