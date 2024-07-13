package org.i2kgroups.appserver.dtos;


import lombok.Data;

@Data 
public class AccountingBalanceDTO {
	
	private Long id;
	private AccountingDTO accountingDTO;
	private double debit;
	private double credit;
	private double debitSolde;
	private double creditSolde;
}
