package com.cmcc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	/*
	 * 启动主程序，打开浏览器http://localhost:8080/hello即可访问该接口
	 */
	@RequestMapping("/hello")
	public String index(){
		return "hello world";
	}
}
