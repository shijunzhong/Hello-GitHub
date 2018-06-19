package com.paul.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.paul.dao.UserHelperMapper;
import com.paul.entity.User;
import com.paul.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserHelperMapper userHelperMapper;

	@Override
	public List<User> find() {
		PageHelper.startPage(1, 10);
		return userHelperMapper.selectAll();
	}

	@Override
	public User get(Integer userId) {
		return userHelperMapper.selectByPrimaryKey(userId);
	}

	@Override
	public Integer save(User user) {
		for (int j = 0; j < 100; j++) {
			user = new User();
			user.setAge(100 + j);
			user.setName("solider: " + j);
			user.setNumber(100 + j);
			int i = userHelperMapper.insertSelective(user);
			if(i <= 0) {
				throw new RuntimeException("新增用户失败");
			}
		}
		return user.getUserId();
	}
	
}
