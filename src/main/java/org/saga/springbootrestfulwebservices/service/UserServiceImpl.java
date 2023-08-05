package org.saga.springbootrestfulwebservices.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.saga.springbootrestfulwebservices.dto.UserDto;
import org.saga.springbootrestfulwebservices.entity.User;
import org.saga.springbootrestfulwebservices.exception.EmailAlreadyExistsException;
import org.saga.springbootrestfulwebservices.exception.ResourceNotFoundException;
import org.saga.springbootrestfulwebservices.mapper.AutoUserMapper;
import org.saga.springbootrestfulwebservices.mapper.UserMapper;
import org.saga.springbootrestfulwebservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		// convert User Dto to User JPA Entity
		/**
		User user = UserMapper.mapUserDtoToUserEnity(userDto);
		User user = this.modelMapper.map(userDto, User.class);
		*/
		Optional<User> userWithEmail = userRepository.findByEmail(userDto.getEmail());
		userWithEmail.ifPresent(user -> {
			throw new EmailAlreadyExistsException(String.format("User with '%s' email address already exists", user.getEmail()));
		});
		User user = AutoUserMapper.MAPPER.mapToUser(userDto);
		User savedUser = this.userRepository.save(user);

		// convert User JPA entity to UserDto
//		return UserMapper.mapUserEntityToUserDto(savedUser);
		return this.modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto getUser(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		User user = optionalUser.orElseThrow(
				() -> new ResourceNotFoundException("User", "id", id.toString())
		);
//		return UserMapper.mapUserEntityToUserDto(optionalUser.orElseThrow());
		return AutoUserMapper.MAPPER.mapToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		return userRepository.findAll().parallelStream().map(AutoUserMapper.MAPPER::mapToUserDto).toList();
	}

	@Override
	public UserDto updateUser(Long userId, UserDto userDto) {
		User existingUser = this.userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User", "id", userId.toString())	
		);

		existingUser.setFirstName(userDto.getFirstName());
		existingUser.setLastName(userDto.getLastName());
		existingUser.setEmail(userDto.getEmail());

		User savedUser = this.userRepository.save(existingUser);

		// convert User JPA entity to UserDto
		return UserMapper.mapUserEntityToUserDto(savedUser);
	}

	@Override
	public void deleteUser(Long id) {
		User existingUser = this.userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User", "id", id.toString())	
		);
		this.userRepository.deleteById(existingUser.getId());
	}

}
