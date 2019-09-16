package com.github.prgrms.example.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.prgrms.example.model.User;
import com.github.prgrms.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public Map<String, String> join(User user) {
		return userRepository.join(user);
	}
}
