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
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class IAccountingMapperImpl implements IAccountingMapper{

	@Autowired
	public ModelMapper modelMapper;
	
	@Override
	public AccountingDTO accountingConvertToAccountingDTO(Accounting accounting) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		AccountingDTO accountingDTO = new AccountingDTO();
		accountingDTO = modelMapper.map(accounting, AccountingDTO.class);
		return accountingDTO;
	}

	@Override
	public AccountingOperationDTO accountingOperationConvertToAccountingOperationDTO(AccountingOperation accounting) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		AccountingOperationDTO accountingOperationDTO = new AccountingOperationDTO();
		accountingOperationDTO = modelMapper.map(accounting, AccountingOperationDTO.class);
		return accountingOperationDTO;
	}

	@Override
	public AccountingReviewDTO accountingReviewConvertToAccountingReviewDTO(AccountingReview accounting) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		AccountingReviewDTO accountingReviewDTO = new AccountingReviewDTO();
		accountingReviewDTO = modelMapper.map(accounting, AccountingReviewDTO.class);
		return accountingReviewDTO;
	}

	@Override
	public OperationDTO operationConvertToOperationDTO(Operation operation) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		OperationDTO operationDTO = new OperationDTO();
		operationDTO = modelMapper.map(operation, OperationDTO.class);
		return operationDTO;
	}

	@Override
	public ReviewDTO reviewConvertToReviewDTO(Review review) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO = modelMapper.map(review, ReviewDTO.class);
		return reviewDTO;
	}

	@Override
	public BalanceDTO balanceConvertToBalanceDTO(Balance balance) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		BalanceDTO balanceDTO = new BalanceDTO();
		balanceDTO = modelMapper.map(balance, BalanceDTO.class);
		return balanceDTO;
	}

	@Override
	public Accounting accountingDTOConvertToAccounting(AccountingDTO accountingDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Accounting accounting = new Accounting();
		accounting = modelMapper.map(accountingDTO , Accounting.class);
		return accounting;
	}

	@Override
	public AccountingOperation accountingOperationDTOConvertToAccountingOperation(AccountingOperationDTO accountingDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		AccountingOperation accountingOperation = new AccountingOperation();
		accountingOperation = modelMapper.map(accountingDTO, AccountingOperation.class);
		return accountingOperation;

	}

	@Override
	public AccountingReview accountingReviewDTOConvertToAccountingReview(AccountingReviewDTO accountingDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		AccountingReview accountingReview = new AccountingReview();
		accountingReview = modelMapper.map(accountingDTO, AccountingReview.class);
		return accountingReview;
	}

	@Override
	public Operation operationDTOConvertToOperation(OperationDTO operationDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Operation operation = new Operation();
		operation = modelMapper.map(operationDTO, Operation.class);
		return operation;
	}

	@Override
	public Review reviewDTOConvertToReview(ReviewDTO reviewDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Review review = new Review();
		review = modelMapper.map(reviewDTO, Review.class);
		return review;
	}

	@Override
	public Balance balanceConvertToBalanceDTO(BalanceDTO balanceDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Balance balance = new Balance();
		balance = modelMapper.map(balanceDTO, Balance.class);
		return balance;
	}

	@Override
	public AccountingBalanceDTO accountingBalanceConvertToAccountingBalanceDTO(AccountingBalance accounting) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		AccountingBalanceDTO accountingBalanceDTO = new AccountingBalanceDTO();
		accountingBalanceDTO = modelMapper.map(accounting, AccountingBalanceDTO.class);
		return accountingBalanceDTO;
	}

	@Override
	public AccountingBalance accountingBalanceDTOConvertToAccountingBalance(AccountingBalanceDTO accountingDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		AccountingBalance accountingBalance = new AccountingBalance();
		accountingBalance = modelMapper.map(accountingDTO, AccountingBalance.class);
		return accountingBalance;
	}

}
