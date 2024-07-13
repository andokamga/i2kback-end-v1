package org.i2kgroups.appserver.dtos;

import java.util.List;

import lombok.Data;

@Data
public class AppUserDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String phoneNumber;
	private String providerLink;
	private String email;
	private String countyCode;
	private String imageName;
	private String imageLink;
	private boolean active;
	private List<AppRoleDTO> RolesDTO;
	private List<CompanyDTO> companyDTO;
	private List<MotificationDTO> motificationsDTO;
}
