package com.viraj.RestApi_SpringBoot.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viraj.RestApi_SpringBoot.api.entity.User;
import com.viraj.RestApi_SpringBoot.api.exception.BadRequestException;
import com.viraj.RestApi_SpringBoot.api.exception.NotFoundException;
import com.viraj.RestApi_SpringBoot.api.repository.UserRepository;
import com.viraj.RestApi_SpringBoot.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository repository;

	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override

	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(String userId) {
		User user = repository.findOne(userId);
		if (user == null) {
			throw new NotFoundException("User with id " + userId + " not found..");
		}
		return user;
	}

	@Override
	public void create(User user) {
		List<User> usr = repository.findByEmail(user.getEmail());

	/*	if (usr != null) {
			throw new BadRequestException("User with email-id " + user.getEmail() + " already exist..");
		}
*/
		 repository.save(user);
	}

	@Override
	public void delete(String userId) {
		User usr = findOne(userId);
		if (usr == null) {
			throw new NotFoundException("User with id " + userId + " not found");

		}
		repository.delete(usr);
	}

	@Override
	public void update(String userId, User user) {
		User usr = repository.findOne(userId);
		if (usr == null) {
			throw new NotFoundException("User with id " + userId + " not found..");
		}
		 repository.save(user);
	}

}
