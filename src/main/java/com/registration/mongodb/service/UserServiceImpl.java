package com.registration.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.mongodb.model.User;
import com.registration.mongodb.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> listAll() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}
	
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

}
