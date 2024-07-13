package org.i2kgroups.appserver.dtos;

import org.i2kgroups.appserver.enums.EnumHeritage;

import lombok.Data;

@Data
public class AccountingReviewDTO {

	private Long id;
	private AccountingDTO accountingDTO;
	private double solde;
	private EnumHeritage Patrimoine ;

}
