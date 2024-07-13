package org.i2kgroups.appserver.dtos;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ClientDTO extends PartnerDTO {
	private Long id;
	@NotBlank(message = "company Id shouldn't be blank")
	@Min(value = 0,message = "company Id must be positive")
	@NotNull(message = "company Id shouldn't be null")
	private Long companyId;
	private boolean loyal; 
	@Size(min=3, max=20, message = "County Code must between 2 and 50 caracters")
	private String countyCode;
	@NotBlank(message = "phone Number shouldn't be blank")
	@Size(min=3, max=20, message = "County Code must between 2 and 50 caracters")
	@NotNull(message = "phone Number shouldn't be null")
	private String phoneNumber;
	@Email(message = "invalid email")
	@Size(min=3, max=100, message = "County Code must between 2 and 50 caracters")
    private String email;
	@Size(min=3, max=20, message = "County Code must between 2 and 50 caracters")
	private String firstName;
	@Size(min=3, max=20, message = "County Code must between 2 and 50 caracters")
	private String lastName;
	private boolean active;
	private List<ClientBillDTO> ClientBillsDTO;
}
