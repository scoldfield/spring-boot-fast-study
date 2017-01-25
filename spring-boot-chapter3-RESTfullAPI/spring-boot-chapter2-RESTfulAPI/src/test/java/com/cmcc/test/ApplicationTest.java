package com.cmcc.test;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cmcc.web.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ApplicationTest {

	private MockMvc mvc;
	
	@Before
	public void setUp(){
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}
	
	@Test
	public void testUserController() throws Exception{
		//测试UserController
		RequestBuilder request = null;
		
		//1、get查一下user列表，应该为空
		request = MockMvcRequestBuilders.get("/users/");
		mvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("[]")));
		
		//2、post提交一个user
		request = MockMvcRequestBuilders.post("/users/")
											.param("id", "1")
											.param("name", "张三")
											.param("age", "20");
		mvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("success")));
		
		//3、get获取user列表，应该有刚才插入的数据
		request = MockMvcRequestBuilders.get("/users/");
		mvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("[{\"id\":1,\"name\":\"张三\",\"age\":20}]")));
		
		//4、put修改id为1的user
		request = MockMvcRequestBuilders.put("/users/1")
											.param("name", "李四")
											.param("age", "30");
		mvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("success")));
		
		//5、get一个id为1的user
		request = MockMvcRequestBuilders.get("/users/1");
		mvc.perform(request)
				.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("{\"id\":1,\"name\":\"李四\",\"age\":30}")));
		
		//6、del删除id为1的user
		request = MockMvcRequestBuilders.delete("/users/1");
		mvc.perform(request)
				.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("success")));
		
		//7、get查一下user列表，应该为空
		request = MockMvcRequestBuilders.get("/users/");
		mvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("[]")));
	}
	
}
