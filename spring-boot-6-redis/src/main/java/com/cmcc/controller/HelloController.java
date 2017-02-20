package com.cmcc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController		//@RestController���ص�������json����; @Controller���ص������ǳ�������
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(){
		return "hello world";
	}
}
