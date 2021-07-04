package com.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.User;
import com.spring.service.UserService;

@RestController
public class UserController {

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public List<User> userForm() {
		List<User> allUser = this.userService.findAllUser();
		System.out.println(allUser + "----------------------------------------");
		return allUser;
	}

	@PostMapping("/user")
	public void addUser(@RequestBody User user) {
		this.userService.addUser(user);
	}

	@GetMapping("/user/{id}")
	public User oneUser(@PathVariable("id") long id) {
		User oneUser = this.userService.findOneUser(id);
		return oneUser;
	}

	@DeleteMapping("/user/{id}")
	public List<User> deleteOneUser(@PathVariable("id") long id) {

		this.userService.deleteOneUser(id);
		List<User> findAllCustomer = this.userService.findAllUser();
		return findAllCustomer;
	}

	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable("id") long id,@RequestBody User user) {
		User oneUser = this.userService.findOneUser(id);
		oneUser.setFirstName(user.getFirstName());
		oneUser.setLastName(user.getLastName());
		oneUser.setAge(user.getAge());
		this.userService.addUser(user);
		return oneUser;
	}

}
