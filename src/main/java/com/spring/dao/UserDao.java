package com.spring.dao;

import java.util.List;

import com.spring.entity.User;

public interface UserDao {

	public List<User> findAllUser();

	public void addUser(User user);

	public User findOneUser(long personId);

	public void deleteOneUser(long personId);

}
