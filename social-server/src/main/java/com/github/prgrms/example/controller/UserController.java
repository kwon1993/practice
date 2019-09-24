package com.github.prgrms.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.prgrms.example.model.RequestDto;
import com.github.prgrms.example.model.ResponseDto;
import com.github.prgrms.example.model.UserVO;
import com.github.prgrms.example.service.UserService;

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
	@PostMapping("/user/join")
	public ResponseDto userJoin(@RequestBody RequestDto requestDto) {
		//TODO 구현함에 있어서 System.out.print문은 사용 안하도록 해야함.
		return userService.join(requestDto);
	}
	
	@GetMapping("/user")//TODO 컨트롤러 메서드의 이름이 명확하지 않음.
	public List<UserVO> AllList(){
		return userService.allList();
	}
	
	@GetMapping("/user/modify/{email}/{password}")
	public UserVO userModify() {
		return null;
	}
	
	@GetMapping("user/secession/{email}/{password}")
	public Map<String, String> userSecession(){
		return null;
	}
	
	@GetMapping("/user/{email}")
	public UserVO userInfo(@PathVariable("email") String email) {
		return null;
	}
	
	@GetMapping("/user/email/{email}")
	public Map<String, String> EmailCheck(){
		return null;
	}
	
}
