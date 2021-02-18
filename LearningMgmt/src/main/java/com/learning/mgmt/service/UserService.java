package com.learning.mgmt.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.mgmt.entity.User;
import com.learning.mgmt.repository.UserRepository;

@Service
public class UserService {

	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepository userRepository;

	public String registerUser(User user) {
		String emailId = user.getEmailId();
		User dbUser = userRepository.findByEmailId(emailId);
		if (dbUser != null) {
			return "User is already registered!";
		}
		List<User> userList = userRepository.findAll();
		if (!userList.isEmpty()) {
			for (User userDb : userList) {
				if (userDb.getUserName().equals(user.getUserName())) {
					return "User name is already taken!";
				} else if (userDb.getPassword().equals(user.getPassword())) {
					return "Password is already taken!";
				}
			}
		}
		User newUser = new User();
		newUser.setEmailId(user.getEmailId());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(user.getPassword());
		newUser.setUserName(user.getUserName());
		userRepository.save(newUser);
		return "User Registered Successfully!";

	}

	public String userLogin(String userName, String password) {
		User user = userRepository.findByUserName(userName);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return "User Login Success!";
			}
			return "Check Password!";
		}
		return "Check User Name Or User is not registered";

	}

}
