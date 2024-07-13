package org.i2kgroups.appserver.dtos;

import org.i2kgroups.appserver.enums.EnumFinancialMovement;
import org.i2kgroups.appserver.enums.EnumHeritage;

import lombok.Data;

@Data
public class AccountingOperationDTO {
	
	private Long id;
	private AccountingDTO accountingDTO;
	private double price;
	private EnumFinancialMovement movement;
	private EnumHeritage heritage;
}
