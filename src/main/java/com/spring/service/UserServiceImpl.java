package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.UserDao;
import com.spring.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public List<User> findAllUser() {
		return this.userDao.findAllUser();
	}

	public void addUser(User user) {

		this.userDao.addUser(user);
	}


	public User findOneUser(long personId) {
		User oneCustomer = this.userDao.findOneUser(personId);
		return oneCustomer;
	}

	public void deleteOneUser(long personId) {
		this.userDao.deleteOneUser(personId);		
	}

	
}
