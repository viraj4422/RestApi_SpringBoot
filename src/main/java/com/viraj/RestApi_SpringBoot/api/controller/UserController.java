package com.viraj.RestApi_SpringBoot.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viraj.RestApi_SpringBoot.api.entity.User;
import com.viraj.RestApi_SpringBoot.api.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/users")
@Api(tags = "users")
public class UserController {
	private UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Find All Users", notes = "Return List of all users in the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public List<User> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{userId}")
	@ApiOperation(value = "Find User", notes = "Find User with given UserId")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "User Not Found") })

	public User findOne(@PathVariable("userId") String userId) {
		return service.findOne(userId);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Create User", notes = "Create User with given User body")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public void create(@RequestBody User user) {
		 service.create(user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{userId}")
	@ApiOperation(value = "Delete User", notes = "Delete User with given UserId")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "User Not Found") })
	public void delete(@PathVariable("userId") String userId) {
		service.delete(userId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{userId}")
	@ApiOperation(value = "Update User", notes = "Update User with given UserId and UserBody")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "User Not Found") })
	public void update(@PathVariable("userId") String userId, @RequestBody User user) {
		 service.update(userId, user);
	}
}
