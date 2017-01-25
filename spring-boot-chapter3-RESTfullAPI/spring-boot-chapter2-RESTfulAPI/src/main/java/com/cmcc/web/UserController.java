package com.cmcc.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmcc.domain.User;

@RestController		//与@Controller的区别是：@RestController不仅包含了@Controller，而且包含了@ResponseBody，即默认返回值为json格式
@RequestMapping(value = "/users")
public class UserController {

	//创建线程安全的Map
	private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getUserList(){
		List<User> r = new ArrayList<User>(users.values());
		return r;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postUser(@ModelAttribute User user){	//除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
		users.put(user.getId(), user);
		return "success";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long id){		//url中的{id}可通过@PathVariable绑定到函数的参数中 
		return users.get(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putUser(@PathVariable Long id, @ModelAttribute User user){
		User u = users.get(id);
		u.setName(user.getName());
		u.setAge(user.getAge());
		users.put(id, u);
		return "success";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id){
		users.remove(id);
		return "success";
	}
}
