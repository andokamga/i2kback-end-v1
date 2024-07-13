package org.i2kgroups.appserver.dtos;

import java.util.Date;
import java.util.List;


import lombok.Data;

@Data 
public class BalanceDTO {

	private Long id;
	private Long companyId;
	private Date BilanDate;
	private List<AccountingBalanceDTO> accountingBalanceDTO;
	private double totaux;
}
