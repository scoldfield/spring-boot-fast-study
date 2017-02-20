package com.cmcc.test;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cmcc.controller.UserController;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletConfig.class)
@WebAppConfiguration
public class ApplicationTest {

	private MockMvc mvc; //鍗曡瘝mock锛氳櫄鎷熺殑

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}

	@Test
	public void testUserController() throws Exception {
		// 锟斤拷锟斤拷UserController
		RequestBuilder request = null;

		// 1锟斤拷get锟斤拷一锟斤拷user锟叫憋拷应锟斤拷为锟斤拷
		request = MockMvcRequestBuilders.get("/users/");
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("[]")));

		// 2锟斤拷post锟结交一锟斤拷user
		request = MockMvcRequestBuilders.post("/users/create").param("id", "1").param("name", "锟斤拷锟皆达拷师").param("age", "20");
		mvc.perform(request).andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("success")));

		// 3锟斤拷get锟斤拷取user锟叫憋拷应锟斤拷锟叫刚才诧拷锟斤拷锟斤拷锟斤拷锟�
		request = MockMvcRequestBuilders.get("/users/");
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("[{\"id\":1,\"name\":\"锟斤拷锟皆达拷师\",\"age\":20}]")));

		// 4锟斤拷put锟睫革拷id为1锟斤拷user
		request = MockMvcRequestBuilders.post("/users/update/1").param("name", "锟斤拷锟斤拷锟秸硷拷锟斤拷师").param("age", "30");
		mvc.perform(request).andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("success")));

		// 5锟斤拷get一锟斤拷id为1锟斤拷user
		request = MockMvcRequestBuilders.get("/users/get/1");
		mvc.perform(request).andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("{\"id\":1,\"name\":\"锟斤拷锟斤拷锟秸硷拷锟斤拷师\",\"age\":30}")));

		// 6锟斤拷del删锟斤拷id为1锟斤拷user
		request = MockMvcRequestBuilders.get("/users/delete/1");
		mvc.perform(request).andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("success")));

		// 7锟斤拷get锟斤拷一锟斤拷user锟叫憋拷应锟斤拷为锟斤拷
		request = MockMvcRequestBuilders.get("/users/");
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("[]")));

	}
}
