package org.i2kgroups.appserver.dtos;

import lombok.Data;

@Data
public class UserPaidDTO {
	private Long employeId;
	private PaidDTO paid;
}
