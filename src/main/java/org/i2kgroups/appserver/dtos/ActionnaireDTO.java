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
public class ActionnaireDTO extends PartnerDTO {

	private Long id;
	@NotBlank(message = "company Id shouldn't be blank")
	@Min(value = 0,message = "company Id must be positive")
	@NotNull(message = "company Id shouldn't be null")
	private Long companyId;
	@Size(min=3, max=10, message = "County Code must between 2 and 50 caracters")
	private String countyCode;
	@Size(min=3, max=50, message = "Phone Number must between 2 and 50 caracters")
	private String phoneNumber;
	@Email(message = "invalid email")
    private String email;
	@Size(min=3, max=50, message = "First Name must between 2 and 50 caracters")
	private String firstName;
	@Size(min=3, max=50, message = "Last Name must between 2 and 50 caracters")
	private String lastName;
	private boolean active;
	private int actionNb;
	private double TotalAmount;
	List<DividendDTO> DividendsDTO;
}
