package com.nokia.application.ossuamws.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokia.application.ossuamws.model.Request.UserRequest;
import com.nokia.application.ossuamws.model.entity.User;
import com.nokia.application.ossuamws.repository.UserRepository;
import com.nokia.application.ossuamws.service.UserService;
import com.nokia.application.ossuamws.shared.Dto.UserDto;
import com.nokia.application.ossuamws.shared.utility.ResponseCode;
import com.nokia.application.ossuamws.shared.utility.Utils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired	Utils utils;

	@Autowired	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {

		User userEntity = new User();
		UserDto userResponse = new UserDto();
		
		BeanUtils.copyProperties(userDto, userEntity);
		
		userEntity.setIsActive(1);
		userEntity.setExpiryDate(utils.getExpiryDate());

		User saveUserDetails = userRepository.save(userEntity);

		BeanUtils.copyProperties(saveUserDetails, userResponse);
		
		return userResponse;

	}

	@Override
	public ResponseCode findByUserName(String userName) {
		ResponseCode respCode = new ResponseCode();

		Optional<User> getUserFromDB = userRepository.findByUserName(userName);
		if (getUserFromDB.isPresent()) {
			respCode.setResponseCode(1);
			respCode.setMessage("username already exists");
			respCode.setTimestamp(utils.getCurrentLocalDateTime());
			respCode.setObj(getUserFromDB);
		} else {
			respCode.setResponseCode(0);
			respCode.setMessage("username available");
			respCode.setTimestamp(utils.getCurrentLocalDateTime());
		}
		return respCode;
	}

	@Override
	public UserDto getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseCode deleteUser(Integer id) {
		ResponseCode respCode = new ResponseCode();

		Optional<User> getUserIdFromDB = userRepository.findByuserId(id);
		if (!getUserIdFromDB.isPresent()) 
		{
			respCode.setResponseCode(0);
			respCode.setMessage("user not found");
			respCode.setTimestamp(utils.getCurrentLocalDateTime());
			respCode.setAction("user deletion failed");
		} else 
		{
			Integer status=getUserIdFromDB.get().getIsActive();
			if(status==1) 
			{	
				int s=0;
				LocalDateTime deletedTs=utils.getCurrentLocalDateTime();
				Integer deluser= userRepository.softDelete(s,deletedTs,id);
				
				if(deluser!=0)
				{
					respCode.setMessage("user deleted successfully");
					respCode.setAction("user deactivated ");
					respCode.setResponseCode(1);
					respCode.setTimestamp(utils.getCurrentLocalDateTime());
					respCode.setObj(getUserIdFromDB);
					//Optional<User> getUserAfterDeleted = userRepository.findByuserId(id);
					//respCode.setObj(getUserAfterDeleted);
				}
			}
			else
			{
				respCode.setResponseCode(0);
				respCode.setMessage("user already inactive");
				respCode.setTimestamp(utils.getCurrentLocalDateTime());
				respCode.setAction("user deletion failed ");
				respCode.setObj(getUserIdFromDB);
			}
		}
		return respCode;
	}

	@Override
	public ResponseCode findByuserId(Integer id) {
	
		return null;
	}

	@Override
	public User checkUserIspresent(String userName) {
		Optional<User> getMgrFromDB = userRepository.findByUserName(userName);
	       return getMgrFromDB.get();
	}

	@Override
	public UserDto updateUser(User user, UserRequest userReq) {

		UserDto userDto =new UserDto();

		user.setUserName(userReq.getUserName());
		user.setFirstName(userReq.getFirstName());
		user.setLastName(userReq.getLastName());
		user.setIsAdmin(userReq.getIsAdmin());
		user.setModifyTimestamp(utils.getCurrentLocalDateTime());
	      
		User updateUserDetails=userRepository.save(user);
	  
		BeanUtils.copyProperties(updateUserDetails, userDto);
		
		return userDto;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<User> getAllActiveUsers() {
		int status=1;
		List<User> activeUsers= userRepository.getActiveUsers(status);
		return activeUsers;
	}

}
