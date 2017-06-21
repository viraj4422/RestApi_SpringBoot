package com.viraj.RestApi_SpringBoot.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.viraj.RestApi_SpringBoot.api.entity.User;

public interface UserRepository extends Repository<User, String>{

	public List<User> findAll();
	
	public Page<User>findAll(Pageable pageable);
	
	public User findOne(String userId);
	
	public void save(User user);//update and insert
	
	public void delete(User user);
	
	public List<User> findByEmail(String email);
}
