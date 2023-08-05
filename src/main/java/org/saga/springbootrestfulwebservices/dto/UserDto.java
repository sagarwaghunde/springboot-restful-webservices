package org.saga.springbootrestfulwebservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

// records don't work well with ModelMapper
//public record UserDto(Long id, String firstName, String lastName, String email) {
//
//}

@Schema(
		description = "UserDto model information"
)
public class UserDto {
	
	Long id;
	
	@Schema(
		description = "User firstname"
	)
	// User firstname should not be null or empty
	@NotBlank(message = "User firstname should not be blank")
	String firstName;
	
	// User lastName should not be null or empty
	@NotEmpty(message = "User lastName should not be empty")
	String lastName;
	
	// User email should not be null or empty
	@NotEmpty(message = "User email should not be empty")
	// Email adress should be valid
	@Email(message = "Email address should be valid")
	String email;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public UserDto(Long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	public UserDto() {
		
	}
}