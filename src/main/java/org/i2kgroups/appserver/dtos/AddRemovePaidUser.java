package org.i2kgroups.appserver.dtos;

import java.util.List;

import org.i2kgroups.appserver.enums.EnumAction;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class AddRemovePaidUser {
	private Long companyId;
	@Enumerated(EnumType.STRING)
	private EnumAction action;
	List<UserPaidDTO> userPaidsDTO;
}
