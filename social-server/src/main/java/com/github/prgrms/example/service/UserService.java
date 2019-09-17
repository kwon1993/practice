package com.github.prgrms.example.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.prgrms.example.model.UserVO;
import com.github.prgrms.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public Map<String, String> join(UserVO user) {
		return userRepository.join(user);
	}

	//TODO UserVO 라는 유의미한 객체가 있는데 MAP으로 객체를 주고받는건 잘못됌.
	public Map<String, String> allList(){
		Iterator<UserVO> userList = userRepository.loadAll().iterator();
		Map<String, String> map = new HashMap<String, String>();
		UserVO user = new UserVO();
		//TODO 무의미한 객체 생성은 퍼포먼스 저하.
		//TODO JDK8 이후로 나온 Optional의 사용을 시도해야함.
		//TODO (Optional)+Lamda 사용 시도.
		
		while(userList.hasNext()) {
			user = userList.next();
			map.put(user.getPrincipal(), user.getCredentials());
		}
		
		return map;
	}
}
