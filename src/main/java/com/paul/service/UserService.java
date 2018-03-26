package com.paul.service;

import java.util.List;

import com.paul.entity.User;

public interface UserService {

	List<User> find();

	User get(Integer userId);

	Integer save(User user);

}
