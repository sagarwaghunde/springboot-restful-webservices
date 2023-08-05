package org.saga.springbootrestfulwebservices.controller;

import java.util.List;

import org.saga.springbootrestfulwebservices.dto.UserDto;
import org.saga.springbootrestfulwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(
	name = "CRUD Rest APIs for User Resources",
	description = "CRUD Rest APIs for User Resources Description"
)
@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Operation(
		summary = "Create user Rest API",
		description = "Create User Rest API"
	)
	@ApiResponse(
		responseCode = "201",
		description = "HTTP Status 201 created"
	)
	// build create user rest API
	@PostMapping
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
		UserDto savedUser = this.userService.createUser(user);
		return new ResponseEntity<UserDto>(savedUser, HttpStatus.CREATED);
	}
	
	@Operation(
		summary = "Get user Rest API by ID",
		description = "Get user Rest API by ID Descript"
	)
	@ApiResponse(
		responseCode = "200",
		description = "HTTP Status 201 success"
	)
	@Parameter(
		name = "id",
		description = "User ID"
	)
	// build get user by ID rest API
	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable("id") Long userId) {
		UserDto user = this.userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	// build get all users rest api
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	// build update user rest api
	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,@Valid @RequestBody UserDto user) {
		return ResponseEntity.ok(this.userService.updateUser(userId, user));
	}
	
	// build delete user by id rest api
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
		this.userService.deleteUser(userId);
		return ResponseEntity.ok("successfully deleted");
	}
}
