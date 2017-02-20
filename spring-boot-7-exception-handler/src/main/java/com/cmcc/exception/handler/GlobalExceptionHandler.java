package com.cmcc.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cmcc.exception.MyException;

/*
 * 统一的异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultExceptionHandle(HttpServletRequest request, Exception e){	//方法中的参数可以自动注入，这是通过@ExceptionHandler实现的
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", request.getRequestURL());
		mav.setViewName("error");
		return mav;
	}
	
	@ExceptionHandler(value = MyException.class)
	@ResponseBody
	public MyException jsonExceptionHandle(HttpServletRequest request, Exception e){
		MyException myException = null;
		if(e instanceof MyException){
			myException = (MyException)e;
		}
		
		return myException;	//这里也可以自定义一个异常信息对象，用来存储myException中的相应信息，并返回
	}
}
