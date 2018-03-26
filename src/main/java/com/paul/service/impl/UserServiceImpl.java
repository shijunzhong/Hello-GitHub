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

	@Override
	public User get(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public Integer save(User user) {
		int i = userMapper.insertSelective(user);
		if(i <= 0) {
			throw new RuntimeException("新增用户失败");
		}
		return user.getUserId();
	}
	
}
