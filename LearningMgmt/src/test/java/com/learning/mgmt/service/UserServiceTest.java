package com.learning.mgmt.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.learning.mgmt.entity.User;
import com.learning.mgmt.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {

	@InjectMocks
	UserService userService;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	User user;
	
	@Test
	public void testRegisterUserSuccess() {
		String result=userService.registerUser(user);
		assertEquals("User Registered Successfully!", result);	
	}
	
	@Test
	public void testRegisterUserforAlreadyRegistered() {
		String emailId="abc@gmail.com";
		when(user.getEmailId()).thenReturn(emailId);
		User user=mock(User.class);
		when(userRepository.findByEmailId(emailId)).thenReturn(user);
		String result=userService.registerUser(user);
		assertEquals("User is already registered!", result);
	}
	
	@Test
	public void testRegisterUserforUserNameCheck () {
		List<User> userList=List.of(mock(User.class));
		when(userList.get(0).getUserName()).thenReturn("userName");
		when(user.getUserName()).thenReturn("userName");
		when(userRepository.findAll()).thenReturn(userList);
		String result=userService.registerUser(user);
		assertEquals("User name is already taken!", result);
	}
	
	@Test
	public void testRegisterUserforPasswordCheck () {
		List<User> userList=List.of(mock(User.class));
		when(userList.get(0).getUserName()).thenReturn("userName");
		when(user.getUserName()).thenReturn("UserName");
		when(userList.get(0).getPassword()).thenReturn("Password");
		when(user.getPassword()).thenReturn("Password");
		when(userRepository.findAll()).thenReturn(userList);
		String result=userService.registerUser(user);
		assertEquals("Password is already taken!", result);
	}
	
	@Test
	public void testUserLoginSuccess() {
		String userName="userName";
		String password="Password";
		User user=mock(User.class);
		when(userRepository.findByUserName(userName)).thenReturn(user);
		when(user.getPassword()).thenReturn(password);
		String result=userService.userLogin(userName, password);
		assertEquals("User Login Success!", result);
	}
	
	@Test
	public void testUserLoginforUserName() {
		String userName="userName";
		String password="Password";
		when(userRepository.findByUserName(userName)).thenReturn(null);
		String result=userService.userLogin(userName, password);
		assertEquals("Check User Name Or User is not registered", result);
	}
	
	@Test
	public void testUserLoginFailure() {
		String userName="userName";
		String password="Password";
		User user=mock(User.class);
		when(userRepository.findByUserName(userName)).thenReturn(user);
		when(user.getPassword()).thenReturn("pass");
		String result=userService.userLogin(userName, password);
		assertEquals("Check Password!", result);
	}
	
	
	
	
}
