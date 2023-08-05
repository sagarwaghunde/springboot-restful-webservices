package org.saga.springbootrestfulwebservices.mapper;

import org.saga.springbootrestfulwebservices.dto.UserDto;
import org.saga.springbootrestfulwebservices.entity.User;

public class UserMapper {
	// convert user JPA entity to userdto
	public static UserDto mapUserEntityToUserDto(User user) {
		return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
	}

	// convert userDto to JPA entity
	public static User mapUserDtoToUserEnity(UserDto user) {
		return new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
	}
}
