package com.spring.service;

import java.util.List;

import com.spring.entity.User;

public interface UserService {

	List<User> findAllUser();

	public void addUser(User user);

	public User findOneUser(long personId);

	public void deleteOneUser(long personId);

}
