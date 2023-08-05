package org.saga.springbootrestfulwebservices.service;

import java.util.List;

import org.saga.springbootrestfulwebservices.dto.UserDto;

public interface UserService {
	UserDto createUser(UserDto user);
	
	UserDto getUser(Long id);
	
	List<UserDto> getAllUsers();
	
	UserDto updateUser(Long userId, UserDto userDto);
	
	void deleteUser(Long id);
}
