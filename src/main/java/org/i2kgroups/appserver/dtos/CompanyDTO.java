package org.i2kgroups.appserver.dtos;


import java.util.List;

import org.i2kgroups.appserver.enums.EnumDevise;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CompanyDTO {

	private Long id;
	private Long underTownId;
	@NotBlank(message = "Accounting name shouldn't be blank")
	@NotNull(message = "Accounting name shouldn't be null")
	@Size(min=3, max=50, message = "Accounting name must between 2 and 50 caracters")
	private String name;
	private double longitude, latitude,attitude;
	private double actionPrix;
	private int maxAtion;
	private EnumDevise devise;
	@Size(min=3, max=50, message = "Accounting name must between 2 and 50 caracters")
	private String logolink;
	@Size(min=3, max=50, message = "Accounting name must between 2 and 50 caracters")
	private String phoneNumber;
	@Email(message = "invalid email")
	@Size(min=3, max=100, message = "County Code must between 2 and 50 caracters")
	private String email;
	private boolean active;
	private boolean pubActive;
	private TownDTO townDTO;
	private VisualDTO visualDTO;
	private ParagraphDTO paragraphDTO;
	private List<SocialLinkDTO> socialLinksDTO;
	private List<DividendDTO> DividendsDTO;
	
}
