package com.paul.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paul.entity.User;
import com.paul.service.UserService;
import com.paul.util.result.JsonResult;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/v1")
public class TestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private User user;
	@Autowired
	private UserService userService;
	
	@ApiOperation(httpMethod = "GET", response = String.class, notes = "测试自定义属性配置", value = "测试自定义属性配置")
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "number: " + user.getUserId() + ", name: " + user.getName() + ", age: " + user.getAge() + "hello";
	}
	
	@ApiOperation(httpMethod = "GET", response = JsonResult.class, notes = "测试集成MyBatis", value = "测试集成MyBatis")
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public JsonResult find() {
		JsonResult jr = null;
		try {
			List<User> userList = userService.find();
			jr = JsonResult.success(userList);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			jr = JsonResult.failed(e);
		}
		
		return jr;
	}
	
	@ApiOperation(httpMethod = "GET", response = JsonResult.class, notes = "测试Swagger注解", value = "测试Swagger注解")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public JsonResult get(
			@ApiParam(required = true, value = "userId") @RequestParam(value = "userId") Integer userId) {
		JsonResult jr = null;
		try {
			User user = userService.get(userId);
			jr = JsonResult.success(user);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			jr = JsonResult.failed(e);
		}
		return jr;
	}
	
	@ApiOperation(httpMethod = "POST", response = JsonResult.class, notes = "添加用户", value = "添加用户")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JsonResult save(
			@RequestBody User user) {
		JsonResult jr = null;
		try {
			Integer userId = userService.save(user);
			jr = JsonResult.success(userId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			jr = JsonResult.failed("新增用户失败");
		}
		return jr;
	}
}
