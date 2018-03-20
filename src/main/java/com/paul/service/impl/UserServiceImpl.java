package com.paul.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paul.dao.UserMapper;
import com.paul.entity.User;
import com.paul.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> find() {
		return userMapper.find();
	}
	
}
