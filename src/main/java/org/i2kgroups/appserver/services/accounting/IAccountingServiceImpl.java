package org.i2kgroups.appserver.services.accounting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.i2kgroups.appserver.dtos.AccountingDTO;
import org.i2kgroups.appserver.dtos.AccountingOperationDTO;
import org.i2kgroups.appserver.dtos.AddRemoveOperationDTO;
import org.i2kgroups.appserver.dtos.BalanceDTO;
import org.i2kgroups.appserver.dtos.CompanyDTO;
import org.i2kgroups.appserver.dtos.OperationDTO;
import org.i2kgroups.appserver.dtos.ReviewDTO;
import org.i2kgroups.appserver.dtos.TownDTO;
import org.i2kgroups.appserver.entities.Accounting;
import org.i2kgroups.appserver.entities.AccountingBalance;
import org.i2kgroups.appserver.entities.AccountingOperation;
import org.i2kgroups.appserver.entities.AccountingReview;
import org.i2kgroups.appserver.entities.AppUser;
import org.i2kgroups.appserver.entities.Balance;
import org.i2kgroups.appserver.entities.Company;
import org.i2kgroups.appserver.entities.Operation;
import org.i2kgroups.appserver.entities.Paragraph;
import org.i2kgroups.appserver.entities.Review;
import org.i2kgroups.appserver.entities.Town;
import org.i2kgroups.appserver.enums.EnumAction;
import org.i2kgroups.appserver.enums.EnumFinancialMovement;
import org.i2kgroups.appserver.enums.EnumHeritage;
import org.i2kgroups.appserver.mappers.IAccountingMapper;
import org.i2kgroups.appserver.mappers.ICompanyMapper;
import org.i2kgroups.appserver.mappers.IProductionMapper;
import org.i2kgroups.appserver.repository.AccountingBalanceRepository;
import org.i2kgroups.appserver.repository.AccountingOperationRepository;
import org.i2kgroups.appserver.repository.AccountingRepository;
import org.i2kgroups.appserver.repository.AccountingReviewRepository;
import org.i2kgroups.appserver.repository.AppRoleRepository;
import org.i2kgroups.appserver.repository.AppUserRepository;
import org.i2kgroups.appserver.repository.BalanceRepository;
import org.i2kgroups.appserver.repository.CategoryRepository;
import org.i2kgroups.appserver.repository.ClientBillRepository;
import org.i2kgroups.appserver.repository.CompanyRepository;
import org.i2kgroups.appserver.repository.DailyReportRepository;
import org.i2kgroups.appserver.repository.DividendRepository;
import org.i2kgroups.appserver.repository.ItemProductRepository;
import org.i2kgroups.appserver.repository.MotificationRepository;
import org.i2kgroups.appserver.repository.OperationRepository;
import org.i2kgroups.appserver.repository.PaidRepository;
import org.i2kgroups.appserver.repository.ParagraphRepository;
import org.i2kgroups.appserver.repository.PartnerRepository;
import org.i2kgroups.appserver.repository.ProductRepository;
import org.i2kgroups.appserver.repository.ReviewRepository;
import org.i2kgroups.appserver.repository.TownRepository;
import org.i2kgroups.appserver.repository.VisualRepository;
import org.i2kgroups.appserver.services.storage.IStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class IAccountingServiceImpl implements IAccountingService{
	
	@Autowired
	public AccountingOperationRepository accountingOperationRepository;
	@Autowired
	public AccountingRepository accountingRepository;
	@Autowired
	public AccountingReviewRepository accountingReviewRepository;
	@Autowired
	public AppRoleRepository appRoleRepository;
	@Autowired
	public AppUserRepository appUserRepository;
	@Autowired
	public BalanceRepository balanceRepository;
	@Autowired
	public CategoryRepository categoryRepository;
	@Autowired
	public ClientBillRepository clientBillRepository;
	@Autowired
	public CompanyRepository companyRepository;
	@Autowired
	public DailyReportRepository dailyReportRepository;
	@Autowired
	public ItemProductRepository itemProductRepository;
	@Autowired
	public OperationRepository operationRepository;
	@Autowired
	public ParagraphRepository paragraphRepository;
	@Autowired
	public ProductRepository productRepository;
	@Autowired
	public ReviewRepository reviewRepository;
	@Autowired
	public TownRepository townRepository;
	@Autowired
	public VisualRepository visualRepository;
	@Autowired
	public AccountingBalanceRepository accountingBalanceRepository;
	@Autowired
	public PartnerRepository partnerRepository;
	@Autowired
	public DividendRepository dividendRepository;
	@Autowired
	public PaidRepository paidRepository;
	@Autowired
	public MotificationRepository motificationRepository;
	@Autowired
	public ICompanyMapper iCompanyMapper;
	@Autowired
	public IAccountingMapper iAccountingMapper;
	@Autowired
	public IProductionMapper iProductionMapper;
	@Autowired
	@Qualifier("VLS")
	private IStorage IStorage;

	@Override
	public AccountingDTO addUpdateAccounting(AccountingDTO Account) {
		Accounting accounting = iAccountingMapper.accountingDTOConvertToAccounting(Account);
		accounting  = accountingRepository.save(accounting);
		return iAccountingMapper.accountingConvertToAccountingDTO(accounting);
	}

	@Override
	public OperationDTO addUpdateOperation(AddRemoveOperationDTO operationItem) {
		Company company = companyRepository.findById(operationItem.getCompanyId()).orElse(null);
		AppUser appUser = appUserRepository.findById(operationItem.getUserId()).orElse(null);
		if(company!=null&&appUser!=null) {
			if(operationItem.getAction()==EnumAction.ADDS) {
				Operation operation = new Operation();
				operation.setCompanyId(company.getId());
				operation.setUserId(appUser.getId());
				for(AccountingOperationDTO accountingOperationDTO :operationItem.getAccountingOperationsDTO()) {
					AccountingOperation accountingOperation = iAccountingMapper.accountingOperationDTOConvertToAccountingOperation(accountingOperationDTO);
					accountingOperation = accountingOperationRepository.save(accountingOperation);
					operation.getAccountingOperation().add(accountingOperation);
				}
				operation = operationRepository.save(operation);
				return iAccountingMapper.operationConvertToOperationDTO(operation);
			}
			if(operationItem.getAction()==EnumAction.REMOVES) {
				Operation operation = operationRepository.findById(operationItem.getOperationId()).orElse(null);
				if(operation!=null) {
					for(AccountingOperation oi:operation.getAccountingOperation()) {
						for(int i=0;i<operationItem.getAccountingOperationsDTO().size();i++) {
							if(operationItem.getAccountingOperationsDTO().get(i).getId()==oi.getId()) {
								operation.getAccountingOperation().remove(oi);
							}
						}

					}
				}
				operation = operationRepository.save(operation);
				return iAccountingMapper.operationConvertToOperationDTO(operation);
			}
		}
		return null;
	}

	@Override
	public BalanceDTO makeCompanyBalance(Long companyId) {
		Company company = companyRepository.findById(companyId).orElse(null);
		if(company!=null) {
			List<Balance> companyBalance = balanceRepository.findByCompanyIdAndSendReview(company.getId(), false);
			List<Operation> operations = operationRepository.findByCompanyIdAndSendOperation(company.getId(), false);
			Balance balance = new Balance();
			balance.setSendReview(false);
			balance.setCompanyId(company.getId());
			balance.setBilanDate(new Date());
			balance=balanceRepository.save(balance);
			Operation operation1= new Operation();
			for(Operation operation:operations) {
				operation.setSendOperation(true);
				if(companyBalance.size()!=0) {
					operation.setBalance(companyBalance.get(0));
				}else {
					operation.setBalance(balance);
				}
				operation1.getAccountingOperation().addAll(operation.getAccountingOperation());
			};
			for(int i=0;i<operation1.getAccountingOperation().size();i++) {
				AccountingBalance accountingBalance = new AccountingBalance();
				if(operation1.getAccountingOperation().get(i).getMovement()==EnumFinancialMovement.CREDIT) {
					accountingBalance.setAccounting(accountingRepository.findByAccountingNumber(operation1.getAccountingOperation().get(i).getAccounting().getAccountingNumber()));
					accountingBalance.setCredit(operation1.getAccountingOperation().get(i).getPrice());
				}else {
					accountingBalance.setAccounting(accountingRepository.findByAccountingNumber(operation1.getAccountingOperation().get(i).getAccounting().getAccountingNumber()));
					accountingBalance.setDebit(operation1.getAccountingOperation().get(i).getPrice());
				}
				if(i==operation1.getAccountingOperation().size()-1) {
					if(accountingBalance.getCredit()>accountingBalance.getDebit()) {
						accountingBalance.setCreditSolde(accountingBalance.getCredit()-accountingBalance.getDebit());
					}else {
						accountingBalance.setDebitSolde(accountingBalance.getDebit()-accountingBalance.getCredit());
					}
					if(companyBalance.size()!=0) {
						boolean find=false;
						for(int k=0;k<companyBalance.get(0).getAccountingBalance().size();k++) {
							if(companyBalance.get(0).getAccountingBalance().get(k).getAccounting().getAccountingNumber()==accountingBalance.getAccounting().getAccountingNumber()) {
								find=true;
								companyBalance.get(0).getAccountingBalance().get(k).setCredit(companyBalance.get(0).getAccountingBalance().get(i).getCredit()+ accountingBalance.getCredit());
								companyBalance.get(0).getAccountingBalance().get(k).setDebit(companyBalance.get(0).getAccountingBalance().get(i).getDebit()+ accountingBalance.getDebit());
								
								if(companyBalance.get(0).getAccountingBalance().get(k).getCredit()>companyBalance.get(0).getAccountingBalance().get(i).getDebit()) {
									companyBalance.get(0).getAccountingBalance().get(k).setCreditSolde(companyBalance.get(0).getAccountingBalance().get(i).getCredit()-companyBalance.get(0).getAccountingBalance().get(i).getDebit());
								}else {
									companyBalance.get(0).getAccountingBalance().get(k).setCreditSolde(companyBalance.get(0).getAccountingBalance().get(i).getDebit()-companyBalance.get(0).getAccountingBalance().get(i).getCredit());
								}

							}
		
						}
						if(!find) {
							accountingBalance.setBalance(companyBalance.get(0));
							accountingBalanceRepository.save(accountingBalance);
						}
						
						balanceRepository.save(companyBalance.get(0));
						
					}else {
						accountingBalance.setBalance(balance);
						accountingBalanceRepository.save(accountingBalance);
					}
				}
				for(int y=i+1;y<operation1.getAccountingOperation().size();y++) {
					if(operation1.getAccountingOperation().get(i).getAccounting().getAccountingNumber()==operation1.getAccountingOperation().get(y).getAccounting().getAccountingNumber() ) {
						if(operation1.getAccountingOperation().get(i).getMovement()==EnumFinancialMovement.CREDIT) {
							accountingBalance.setCredit(accountingBalance.getCredit()+operation1.getAccountingOperation().get(y).getPrice());
						}else {
							accountingBalance.setDebit(accountingBalance.getDebit()+operation1.getAccountingOperation().get(y).getPrice());
						}
						operation1.getAccountingOperation().remove(y);
					}
					if(y==operation1.getAccountingOperation().size()-1) {
						if(accountingBalance.getCredit()>accountingBalance.getDebit()) {
							accountingBalance.setCreditSolde(accountingBalance.getCredit()-accountingBalance.getDebit());
						}else {
							accountingBalance.setDebitSolde(accountingBalance.getDebit()-accountingBalance.getCredit());
						}
						if(companyBalance.size()!=0) {
							boolean find=false;
							for(int k=0;k<companyBalance.get(0).getAccountingBalance().size();k++) {
								if(companyBalance.get(0).getAccountingBalance().get(k).getAccounting().getAccountingNumber()==accountingBalance.getAccounting().getAccountingNumber()) {
									find=true;
									companyBalance.get(0).getAccountingBalance().get(k).setCredit(companyBalance.get(0).getAccountingBalance().get(i).getCredit()+ accountingBalance.getCredit());
									companyBalance.get(0).getAccountingBalance().get(k).setDebit(companyBalance.get(0).getAccountingBalance().get(i).getDebit()+ accountingBalance.getDebit());
									
									if(companyBalance.get(0).getAccountingBalance().get(k).getCredit()>companyBalance.get(0).getAccountingBalance().get(i).getDebit()) {
										companyBalance.get(0).getAccountingBalance().get(k).setCreditSolde(companyBalance.get(0).getAccountingBalance().get(i).getCredit()-companyBalance.get(0).getAccountingBalance().get(i).getDebit());
									}else {
										companyBalance.get(0).getAccountingBalance().get(k).setCreditSolde(companyBalance.get(0).getAccountingBalance().get(i).getDebit()-companyBalance.get(0).getAccountingBalance().get(i).getCredit());
									}

								}
			
							}
							if(!find) {
								accountingBalance.setBalance(companyBalance.get(0));
								accountingBalanceRepository.save(accountingBalance);
							}
							
							balance = balanceRepository.save(companyBalance.get(0));
							return iAccountingMapper.balanceConvertToBalanceDTO(balance);
							
						}else {
							accountingBalance.setBalance(balance);
							accountingBalanceRepository.save(accountingBalance);
							balance = balanceRepository.save(balance);
							return iAccountingMapper.balanceConvertToBalanceDTO(balance);
						}
						
					}

				}
			}
			
		}
		return null;
	}

	@Override
	public ReviewDTO makeCompanyReview(Long companyId) {
		EnumHeritage[] enumHeritages = EnumHeritage.values();
		List<Accounting> Accountings = accountingRepository.findAll();
		Review review = new Review();
		review.setCompanyId(companyId);
		review.setReviewDate(new Date());
		review.setLast(true);
		review.getAccountingReview();
		review = reviewRepository.save(review);
		for(int i=0;i<15;i++) {
			Accounting accounting = Accountings.get(new Random().nextInt(Accountings.size()));
			String pn = accounting.getAccountingNumber()+ "";
			if(0<Integer.valueOf(pn.substring(0,1))&&Integer.valueOf(pn.substring(0,1))<6) {
				if(!review.getAccountingReview().isEmpty()) {
					boolean find =false;
					for(AccountingReview accountingReview1:review.getAccountingReview()) {
						if(accountingReview1.getAccounting().getAccountingNumber()==accounting.getAccountingNumber()) {
							find =true;
						}
					}
					if(!find&& accounting.getAccountingNumber()!=13) {
						AccountingReview accountingReview = new AccountingReview();
						accountingReview.setAccounting(accounting);
						accountingReview.setSolde(20000);
						accountingReview.setPatrimoine(enumHeritages[new Random().nextInt(enumHeritages.length)]);
						accountingReview.setReview(review);
						review.getAccountingReview().add(accountingReview);
						accountingReviewRepository.save(accountingReview);
					}
				}
				if(review.getAccountingReview().isEmpty()) {
					AccountingReview accountingReview = new AccountingReview();
					accountingReview.setAccounting(accountingRepository.findByAccountingNumber(103));
					accountingReview.setSolde(200000);
					accountingReview.setPatrimoine(enumHeritages[new Random().nextInt(enumHeritages.length)]);
					review.setCapital(accountingReview.getSolde());
					accountingReview.setReview(review);
					review.getAccountingReview().add(accountingReview);
					accountingReviewRepository.save(accountingReview);
					
				}
			}

		}
		for(AccountingReview accountingReview1:review.getAccountingReview()) {
			if(accountingReview1.getPatrimoine()==EnumHeritage.ACTIVE){
				review.setActiveTotaux(review.getActiveTotaux()+accountingReview1.getSolde());
			}else {
				review.setPassiveTotaux(review.getPassiveTotaux()+accountingReview1.getSolde());
			}
		}
		review.setResult(review.getActiveTotaux()-review.getPassiveTotaux());
		review.setNetSituation(review.getCapital()+review.getResult());
		if(review.getActiveTotaux()>review.getPassiveTotaux()) {
			review.setPassiveTotaux(review.getPassiveTotaux()+Math.abs(review.getResult()));
		}else {
			review.setActiveTotaux(review.getActiveTotaux()+Math.abs(review.getResult()));
		}
		review.setDette(review.getActiveTotaux()-review.getNetSituation());
		review = reviewRepository.save(review);
		return iAccountingMapper.reviewConvertToReviewDTO(review);
	}

	@Override
	public Page<AccountingDTO> allAccounting(PageRequest page) {
		List<Accounting> accountings = accountingRepository.findAll();
		List<AccountingDTO> accountingsDTO = new ArrayList<>();
		for(Accounting accounting:accountings) {
			AccountingDTO accountingDTO= iAccountingMapper.accountingConvertToAccountingDTO(accounting);
			accountingsDTO.add(accountingDTO);
		}
		return new PageImpl<>(accountingsDTO, page, accountingsDTO.size());
	}

	@Override
	public Page<OperationDTO> allCompayOperation(Long companyId, PageRequest page) {
		List<Operation> operations = operationRepository.findByCompanyId(companyId);
		List<OperationDTO> operationsDTO = new ArrayList<>();
		for(Operation operation:operations) {
			operationsDTO.add(iAccountingMapper.operationConvertToOperationDTO(operation));
		}
		return new PageImpl<>(operationsDTO, page, operationsDTO.size());
	}

	@Override
	public Page<BalanceDTO> allCompayBalance(Long companyId, PageRequest page) {
		List<Balance> balances = balanceRepository.findByCompanyId(companyId);
		List<BalanceDTO> balancesDTO = new ArrayList<>();
		for(Balance balance:balances) {
			balancesDTO.add(iAccountingMapper.balanceConvertToBalanceDTO(balance));
		}
		return new PageImpl<>(balancesDTO, page, balancesDTO.size());
	}

	@Override
	public Page<ReviewDTO> allCompayReview(Long companyId, PageRequest page) {
		List<Review> reviews = reviewRepository.findByCompanyId(companyId);
		List<ReviewDTO> reviewsDTO = new ArrayList<>();
		for(Review review:reviews) {
			reviewsDTO.add(iAccountingMapper.reviewConvertToReviewDTO(review));
		}
		return new PageImpl<>(reviewsDTO, page, reviewsDTO.size());
	}

	@Override
	public boolean deleteAccounting(Long accountingId) {
		if(accountingRepository.existsById(accountingId)) {
			accountingRepository.deleteById(accountingId);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteOperation(Long operationId) {
		if(operationRepository.existsById(operationId)) {
			operationRepository.deleteById(operationId);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBalance(Long balanceId) {
		if(balanceRepository.existsById(balanceId)) {
			balanceRepository.deleteById(balanceId);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteReview(Long reviewId) {
		if(reviewRepository.existsById(reviewId)) {
			reviewRepository.deleteById(reviewId);
			return true;
		}
		return false;
	}

}
