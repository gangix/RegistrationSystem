package com.registration.mongodb.service;

import java.util.List;

import com.registration.mongodb.model.User;

public interface UserService {
	public User createUser(User user);
	public List<User> listAll();
	public void deleteUser(String id);
	public User updateUser(User user);
}
