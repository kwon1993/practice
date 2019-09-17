package com.github.prgrms.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.github.prgrms.example.model.UserVO;
import com.github.prgrms.example.service.UserService;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api")
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
	@PostMapping("user/join")
	public Map<String, String> Post(@RequestBody UserVO user) {
		//TODO 구현함에 있어서 System.out.print문은 사용 안하도록 해야함.
		System.out.println("\n\nClass: UserController\nMethod: post\n");
		return userService.join(user);
	}
	
	@GetMapping("/api/user")//TODO 컨트롤러 메서드의 이름이 명확하지 않음.
	public Map<String, String> Get(){
		return userService.allList();
	}
}
