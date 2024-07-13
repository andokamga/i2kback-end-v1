package org.i2kgroups.appserver.dtos;

import org.i2kgroups.appserver.enums.EnumAction;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddRemoveRoleDTO {
	@NotBlank(message = "role Id shouldn't be blank")
	@Min(value = 0,message = "role Id must be positive")
	@NotNull(message = "role Id shouldn't be null")
	private Long roleId;
	@Enumerated(EnumType.STRING)
	private EnumAction action;
	@NotBlank(message = "role Id shouldn't be blank")
	@Min(value = 0,message = "user Id must be positive")
	@NotNull(message = "user Id shouldn't be null")
	private Long userId;
}
