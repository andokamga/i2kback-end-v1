package org.i2kgroups.appserver.services.accounting;

import org.i2kgroups.appserver.dtos.AccountingDTO;
import org.i2kgroups.appserver.dtos.AddRemoveOperationDTO;
import org.i2kgroups.appserver.dtos.BalanceDTO;
import org.i2kgroups.appserver.dtos.OperationDTO;
import org.i2kgroups.appserver.dtos.ReviewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IAccountingService {
	
	public AccountingDTO addUpdateAccounting(AccountingDTO Accounting);
	public OperationDTO addUpdateOperation(AddRemoveOperationDTO operationItem);
	public BalanceDTO makeCompanyBalance(Long companyId);
	public ReviewDTO makeCompanyReview(Long companyId);
	public Page<AccountingDTO> allAccounting(PageRequest page);
	public Page<OperationDTO> allCompayOperation(Long companyId, PageRequest page);
	public Page<BalanceDTO> allCompayBalance(Long companyId, PageRequest page);
	public Page<ReviewDTO> allCompayReview(Long companyId, PageRequest page);
	public boolean deleteAccounting(Long accountingId);
	public boolean deleteOperation(Long operationId);
	public boolean deleteBalance(Long balanceId);
	public boolean deleteReview(Long reviewId);
}
