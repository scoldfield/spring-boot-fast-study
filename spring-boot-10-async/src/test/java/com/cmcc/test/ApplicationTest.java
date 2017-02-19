package com.cmcc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cmcc.Application;
import com.cmcc.task.Task;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)	//普通应该中的@SpringApplicationConfiguration应该注入Application.class
public class ApplicationTest {

	@Autowired
	private Task task;
	
	@Test
	public void test() throws InterruptedException{
		long start = System.currentTimeMillis();
		
		Future<String> f1 = task.doTask1();
		Future<String> f2 = task.doTask2();
		Future<String> f3 = task.doTask3();
		
		while(true){
			if(f1.isDone() && f2.isDone() && f3.isDone()){
				break;
			}
			
			//每隔500ms检查一次
			TimeUnit.MILLISECONDS.sleep(500);
		}
		
		long end = System.currentTimeMillis();
		System.out.println("任务全部完成，总耗时：" + (end - start) + "ms");
	}
}
