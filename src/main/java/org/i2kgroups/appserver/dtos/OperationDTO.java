package org.i2kgroups.appserver.dtos;

import java.util.Date;
import java.util.List;


import lombok.Data;

@Data 
public class OperationDTO {

	private Long id;
	private Long companyId;
	private Long userId;
	private Date operationDate;
	private boolean sendOperation;
	private List<AccountingOperationDTO> accountingOperationDTO;
}
