package com.cmcc.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect		//该注解将一个java类定义为切面类
@Component
public class WebLogAspect {

	private Logger logger = Logger.getLogger(WebLogAspect.class);
	
	//为了防止多线程间的冲突，使用ThreadLocal来记录时间
	private ThreadLocal<Long> startTime = new ThreadLocal<Long>();
	
	@Pointcut("execution(* com.cmcc.controller..*.*(..))")
	public void webLog(){}
	
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint){
		//获取请求的方法
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		//记录开始时间
		startTime.set(System.currentTimeMillis());
	}
	
	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret){
		//处理完请求，返回内容
		logger.info("RESPONSE: " + ret);
		
		//
		logger.info("SPEND TIME: " + (System.currentTimeMillis() - startTime.get()));
	}
}
