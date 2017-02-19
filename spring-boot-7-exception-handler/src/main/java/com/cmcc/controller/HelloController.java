package com.cmcc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmcc.exception.MyException;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello(HttpServletRequest request) throws MyException {
//		throw new Exception("出错啦");
		throw new MyException(request.getRequestURL().toString(), "出错啦");
	}
}
