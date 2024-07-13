package org.i2kgroups.appserver.dtos;

import org.i2kgroups.appserver.enums.EnumRole;

import lombok.Data;

@Data 
public class AppRoleDTO {

	private Long id;
	private EnumRole name;
}
