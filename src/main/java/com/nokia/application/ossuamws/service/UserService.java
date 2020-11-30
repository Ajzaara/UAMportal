package com.nokia.application.ossuamws.service;

import java.util.List;

import com.nokia.application.ossuamws.model.Request.UserRequest;
import com.nokia.application.ossuamws.model.entity.User;
import com.nokia.application.ossuamws.shared.Dto.UserDto;
import com.nokia.application.ossuamws.shared.utility.ResponseCode;

public interface UserService {

		public UserDto createUser(UserDto userDto); 
		public UserDto getUser(String username);
		ResponseCode findByUserName(String userName);
		public ResponseCode findByuserId(Integer id);
		public ResponseCode deleteUser(Integer id);
		public User checkUserIspresent(String userName);
		public UserDto updateUser(User user, UserRequest userReq);
		public List<User> getAllUsers();
		public List<User> getAllActiveUsers();
		
		
	}