package com.cmcc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController		//@RestController返回的数据是json数据; @Controller返回的数据是常规数据
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(){
		return "hello world";
	}
}
