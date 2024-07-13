package org.i2kgroups.appserver.dtos;

import java.util.List;

import lombok.Data;

@Data
public class AddRemoveBill {
	private Long userId;
	private Long companyId;
	private Long dailyWorkId;
	private List<ClientBillDTO> clientBillsDTO;
}
