package com.learning.mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.mgmt.entity.User;
import com.learning.mgmt.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		return userService.registerUser(user);
		
	}
	
	@PostMapping("/login")
	public String userLogin(@RequestParam String userName, @RequestParam String password) {
		return userService.userLogin(userName,password);
	}
}
