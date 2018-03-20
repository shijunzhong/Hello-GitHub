package com.paul.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paul.entity.User;
import com.paul.service.UserService;

@RestController
public class TestController {
	@Autowired
	private User user;
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/test")
	public String test() {
		return "number: " + user.getUserId() + ", name: " + user.getName() + ", age: " + user.getAge();
	}
	
	@RequestMapping(value = "/find")
	public List<User> find() {
		return userService.find();
	}
}
