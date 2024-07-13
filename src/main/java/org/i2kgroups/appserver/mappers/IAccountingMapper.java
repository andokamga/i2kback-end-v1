package org.i2kgroups.appserver.mappers;

import org.i2kgroups.appserver.dtos.AccountingBalanceDTO;
import org.i2kgroups.appserver.dtos.AccountingDTO;
import org.i2kgroups.appserver.dtos.AccountingOperationDTO;
import org.i2kgroups.appserver.dtos.AccountingReviewDTO;
import org.i2kgroups.appserver.dtos.BalanceDTO;
import org.i2kgroups.appserver.dtos.OperationDTO;
import org.i2kgroups.appserver.dtos.ReviewDTO;
import org.i2kgroups.appserver.entities.Accounting;
import org.i2kgroups.appserver.entities.AccountingBalance;
import org.i2kgroups.appserver.entities.AccountingOperation;
import org.i2kgroups.appserver.entities.AccountingReview;
import org.i2kgroups.appserver.entities.Balance;
import org.i2kgroups.appserver.entities.Operation;
import org.i2kgroups.appserver.entities.Review;

public interface IAccountingMapper {

	public AccountingDTO accountingConvertToAccountingDTO(Accounting accounting);
	public AccountingOperationDTO accountingOperationConvertToAccountingOperationDTO(AccountingOperation accounting);
	public AccountingReviewDTO accountingReviewConvertToAccountingReviewDTO(AccountingReview accounting);
	public AccountingBalanceDTO accountingBalanceConvertToAccountingBalanceDTO(AccountingBalance accounting);
	public OperationDTO operationConvertToOperationDTO(Operation operation);
	public ReviewDTO reviewConvertToReviewDTO(Review review);
	public BalanceDTO balanceConvertToBalanceDTO(Balance balance);
	public Accounting accountingDTOConvertToAccounting(AccountingDTO accountingDTO);
	public AccountingOperation accountingOperationDTOConvertToAccountingOperation(AccountingOperationDTO accountingDTO);
	public AccountingReview accountingReviewDTOConvertToAccountingReview(AccountingReviewDTO accountingDTO);
	public AccountingBalance accountingBalanceDTOConvertToAccountingBalance(AccountingBalanceDTO accountingDTO);
	public Operation operationDTOConvertToOperation(OperationDTO operationDTO);
	public Review reviewDTOConvertToReview(ReviewDTO reviewDTO);
	public Balance balanceConvertToBalanceDTO(BalanceDTO balanceDTO);
	
}
