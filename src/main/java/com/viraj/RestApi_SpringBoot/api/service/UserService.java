package com.viraj.RestApi_SpringBoot.api.service;


import java.util.List;
import java.util.Optional;

import com.viraj.RestApi_SpringBoot.api.entity.User;

public interface UserService {
	
	public List<User> findAll();

	public User findOne(String userId);

	public void create(User user);

	public void delete(String userId);

	public void update(String userId, User user);

}
