package org.i2kgroups.appserver.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SaveAppUserDTO {
	Long id;
	@NotNull(message = "First Name shouldn't be null")
	@NotBlank(message = "First Name shouldn't be blank")
	@Size(min=3, max=10, message = "County Code must between 2 and 50 caracters")
	private String firstName;
	@Size(min=3, max=10, message = "County Code must between 2 and 50 caracters")
	private String lastName;
	private String username;
	@NotBlank(message = "phone Number shouldn't be blank")
	@Size(min=3, max=20, message = "County Code must between 2 and 50 caracters")
	@NotNull(message = "phone Number shouldn't be null")
	private String phoneNumber;
	@Size(min=3, max=100, message = "County Code must between 2 and 50 caracters")
	private String providerLink;
	@Email(message = "invalid email")
	@Size(min=3, max=100, message = "County Code must between 2 and 50 caracters")
	private String email;
	@Size(min=3, max=100, message = "County Code must between 2 and 50 caracters")
	private String password;
	@Size(min=3, max=100, message = "County Code must between 2 and 50 caracters")
	private String countyCode;
	@Size(min=3, max=100, message = "County Code must between 2 and 50 caracters")
	private String imageName;
	@Size(min=3, max=100, message = "County Code must between 2 and 50 caracters")
	private String imageLink;
	
}
