package com.cmcc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cmcc.model.User;

@Mapper
public interface UserMapper {

	@Select(value = "select * from user where username = #{username}")
	public User findByUsername(@Param("username") String username);
	
	@Insert(value = "insert into user(username, age) values(#{username}, #{age})")
	public int insert(@Param("username") String username, @Param("age") Integer age);
}
