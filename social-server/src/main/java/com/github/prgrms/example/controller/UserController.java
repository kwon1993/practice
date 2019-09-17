package com.github.prgrms.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.prgrms.example.model.User;
import com.github.prgrms.example.service.UserService;

@RestController
public class UserController {

	@Autowired
	public UserService userService;

//	@RequestMapping(value = "/json", method = RequestMethod.POST)
//	@ResponseBody
//	public void jsonTest(@RequestBody Map<String, Object> human) {
//		logger.info(human.toString());
//	}
	
//	@GetMapping("join")
//	public UserVO getArgs(
//	        @RequestParam(value = "principal")String email,
//	        @RequestParam(value = "credentials")String password) {
//	    UserVO user = new UserVO(email, password);
//	    user.setEmail(email);
//
//	    return user;
//	}
	
	@ResponseBody
	@PostMapping("/api/user/join")
	public Map<String, String> Post(@RequestBody User user) {
		System.out.println("\n\nClass: UserController\nMethod: post\n");
		return userService.join(user);
	}
	
	@GetMapping("/api/user")
	public Map<String, String> Get(){
		return userService.allList();
	}
}
