package com.cmcc.task;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/*
 * 任务类
 */
@Component
public class Task {

	@Async
	public Future<String> doTask1() throws InterruptedException{
		System.out.println("任务一启动");
		long start = System.currentTimeMillis();
		TimeUnit.MILLISECONDS.sleep(3000);
		long end = System.currentTimeMillis();
		System.out.println("任务一耗时：" + (end - start) + "ms");
		return new AsyncResult<String>("任务一完成");
	}
	
	@Async
	public Future<String> doTask2() throws InterruptedException{
		System.out.println("任务二启动");
		long start = System.currentTimeMillis();
		TimeUnit.MILLISECONDS.sleep(3000);
		long end = System.currentTimeMillis();
		System.out.println("任务二耗时：" + (end - start) + "ms");
		return new AsyncResult<String>("任务二完成");
	}
	
	@Async
	public Future<String> doTask3() throws InterruptedException{
		System.out.println("任务三启动");
		long start = System.currentTimeMillis();
		TimeUnit.MILLISECONDS.sleep(3000);
		long end = System.currentTimeMillis();
		System.out.println("任务三耗时：" + (end - start) + "ms");
		return new AsyncResult<String>("任务三完成");
	}
}
