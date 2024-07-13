package org.i2kgroups.appserver.dtos;

import org.i2kgroups.appserver.enums.EnumAction;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class AddRemoveCompanyDTO {
	
	@Enumerated(EnumType.STRING)
	private EnumAction action;
	private Long companyId;
	private Long userId;
}
