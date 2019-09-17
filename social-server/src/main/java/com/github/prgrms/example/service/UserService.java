package com.github.prgrms.example.service;

import java.util.HashMap;
import java.util.Iterator;
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
	
	public Map<String, String> allList(){
		Iterator<User> userList = userRepository.loadAll().iterator();
		Map<String, String> map = new HashMap<String, String>();
		User user = new User();
		
		while(userList.hasNext()) {
			user = userList.next();
			map.put(user.getPrincipal(), user.getCredentials());
		}
		
		return map;
	}
}
