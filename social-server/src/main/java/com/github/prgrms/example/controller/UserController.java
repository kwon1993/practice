package com.github.prgrms.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.github.prgrms.example.service.UserService;

@Controller
public class UserController {

	@Autowired
	public UserService userService;
	
}
