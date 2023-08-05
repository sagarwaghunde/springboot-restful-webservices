package org.saga.springbootrestfulwebservices.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.saga.springbootrestfulwebservices.dto.UserDto;
import org.saga.springbootrestfulwebservices.entity.User;

@Mapper
public interface AutoUserMapper {
	
	// entrypoint
	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
	
	
	// Source and target objects should have same filed names for default implementation
	// if field names are not same, mapping can be used
	@Mapping(source = "email", target = "email")
	UserDto mapToUserDto(User user);
	
	User mapToUser(UserDto userDto);
}
