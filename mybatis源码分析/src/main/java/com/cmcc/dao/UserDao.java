package com.cmcc.dao;

import java.util.List;

import com.cmcc.entity.User;

public interface UserDao {
    public void insert(User user);

    public User findUserById(int userId);

    public List<User> findAllUsers();
}
