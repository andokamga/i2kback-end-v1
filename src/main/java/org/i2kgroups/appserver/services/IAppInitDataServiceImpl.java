package org.i2kgroups.appserver.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

import org.i2kgroups.appserver.entities.Accounting;
import org.i2kgroups.appserver.entities.AccountingBalance;
import org.i2kgroups.appserver.entities.AccountingOperation;
import org.i2kgroups.appserver.entities.AccountingReview;
import org.i2kgroups.appserver.entities.Actionnaire;
import org.i2kgroups.appserver.entities.AppRole;
import org.i2kgroups.appserver.entities.AppUser;
import org.i2kgroups.appserver.entities.Balance;
import org.i2kgroups.appserver.entities.Category;
import org.i2kgroups.appserver.entities.Client;
import org.i2kgroups.appserver.entities.ClientBill;
import org.i2kgroups.appserver.entities.Company;
import org.i2kgroups.appserver.entities.DailyReport;
import org.i2kgroups.appserver.entities.Dividend;
import org.i2kgroups.appserver.entities.Employe;
import org.i2kgroups.appserver.entities.ItemProduct;
import org.i2kgroups.appserver.entities.Motification;
import org.i2kgroups.appserver.entities.Operation;
import org.i2kgroups.appserver.entities.Paid;
import org.i2kgroups.appserver.entities.Paragraph;
import org.i2kgroups.appserver.entities.Product;
import org.i2kgroups.appserver.entities.Review;
import org.i2kgroups.appserver.entities.Text;
import org.i2kgroups.appserver.entities.Town;
import org.i2kgroups.appserver.entities.Visual;
import org.i2kgroups.appserver.entities.paragraphList;
import org.i2kgroups.appserver.enums.EnumAccounting;
import org.i2kgroups.appserver.enums.EnumBillStatus;
import org.i2kgroups.appserver.enums.EnumDevise;
import org.i2kgroups.appserver.enums.EnumDivident;
import org.i2kgroups.appserver.enums.EnumFinancialMovement;
import org.i2kgroups.appserver.enums.EnumHeritage;
import org.i2kgroups.appserver.enums.EnumModificationType;
import org.i2kgroups.appserver.enums.EnumParagraph;
import org.i2kgroups.appserver.enums.EnumRole;
import org.i2kgroups.appserver.enums.EnumTypeProduct;
import org.i2kgroups.appserver.enums.EnumVisualType;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class IAppInitDataServiceImpl implements IAppInitDataService {
	
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
	@Override
	public void initTown() {
		Stream.of("yaounde","douala").forEach(townName->{
			Town town = new Town();
			town.setLevel(0);
			town.setName(townName);
			townRepository.save(town);
		});
		List<Town> towns = townRepository.findByLevel(0);
		towns.forEach(town->{
			for(int i=0; i<2; i++) {
				Town town1 = new Town();
				town1.setLevel(town.getLevel()+1);
				town1.setName(town.getName()+" "+i);
				town1.setTown(town);
				townRepository.save(town1);
			}	
		});
	}

	@Override
	public void initCompany() {
		List<Town> towns = townRepository.findByLevel(0);
		EnumVisualType[] enumVisualTypes = EnumVisualType.values();
		towns.forEach(town->{
			Stream.of("printer","tech").forEach(name->{
				Company company = new Company();
				company.setName(town.getName()+" "+name);
				company.setTown(town);
				company.setDevise(EnumDevise.XAF);
				company.setMaxAtion(100);
				company.setActionPrix(10000);
				company.setUnderTownId(town.getUnderTowns().get(new Random().nextInt(town.getUnderTowns().size())).getId());
				company = companyRepository.save(company);
				paragraphList paragraphs = new paragraphList();
				paragraphs.setTitle("Paragraphe "+0);
				paragraphs.setCompanyId(company.getId());
				paragraphs.setLevel(0);
				paragraphs.setCompany(company);
				company.setParagraph(paragraphs);
				for(int y=0; y<4; y++) {
					Text text1 = new Text();
					text1.setLevel(paragraphs.getLevel()+1);
					Visual visual = new Visual();
					visual.setName("visual "+y);
					visual.setVisual(enumVisualTypes[new Random().nextInt(enumVisualTypes.length)]);
					visual.setVisualName("product"+visual.getId());
					visual=visualRepository.save(visual);
					text1.getVisuals().add(visual);
					text1.setCompanyId(company.getId());
					text1.setDescription("In marketing, a product is an object, or system, or service made available for consumer use as of the consumer demand; it is anything that can be offered to a market to satisfy the desire or need of a customer.");
					text1.setParagraph(paragraphs);
					text1.setCompany(company);
					text1=paragraphRepository.save(text1);
					visual.setText(text1);
					visualRepository.save(visual);
					paragraphs.getParagraphs().add(text1);
					paragraphRepository.save(paragraphs);
				}
				
			});
		});
		
	}

	@Override
	public void initRole() {
		EnumRole[] roles = EnumRole.values();
		for(EnumRole role:roles) {
			AppRole appRole = new AppRole();
			appRole.setActive(true);
			appRole.setName(role);
			appRoleRepository.save(appRole);
		}
	}

	@Override
	public void initUser() {
		Stream.of("kamga","sado","andre","delon").forEach(name->{
			AppUser user = new AppUser();
			user.setFirstName(name);
			user.setLastName(name);
			user.setActive(true);
			if(name.compareTo("kamga")==0) {
				user.setUsername("admin");
				user.setPassword("admin");
				for(int y=0; y<4; y++) {
					AppRole role = appRoleRepository.findById((long) (y+1)).get();
					Company company = companyRepository.findById((long) (y+1)).get();
					company.getUsers().add(user);
					user.getCompany().add(company);
					user.getRoles().add(role);
					role.getUsers().add(user);
				}
				appUserRepository.save(user);	
			}else if(name.compareTo("sado")==0) {
				user.setPassword("accountant");
				user.setUsername("accountant");
				for(int y=0; y<4; y++) {
					AppRole role = appRoleRepository.findById((long) (y+1)).get();
					if(role.getName()!=EnumRole.ADMIN) {
						Company company = companyRepository.findById((long) (y+1)).get();
						company.getUsers().add(user);
						user.getCompany().add(company);
						user.getRoles().add(role);
						role.getUsers().add(user);
					}

				}
				appUserRepository.save(user);
			}else if(name.compareTo("andre")==0){
				user.setPassword("secretary");
				user.setUsername("secretary");
				for(int y=0; y<4; y++) {
					AppRole role = appRoleRepository.findById((long) (y+1)).get();
					if(role.getName()!=EnumRole.ADMIN||role.getName()!=EnumRole.ACCOUNTANT) {
						user.getRoles().add(role);
						role.getUsers().add(user);
					}

				}
				appUserRepository.save(user);
			}else {
				user.setPassword("user");
				user.setUsername("user");
				for(int y=0; y<4; y++) {
					AppRole role = appRoleRepository.findById((long) (y+1)).get();
					if(role.getName()==EnumRole.USER) {
						user.getRoles().add(role);
						role.getUsers().add(user);
					}

				}
				appUserRepository.save(user);
				
			}
			
		});
		
	}

	@Override
	public void initCategory() {
		
		Stream.of("Bureautique","Homme","Femme","Enfant").forEach(name->{
			Category category = new Category();
			category.setName(name);
			categoryRepository.save(category);
		});
		
	}

	@Override
	public void initProduct() {
		double[] prices = new double[] {1000,2500,7550,800,400};
		EnumTypeProduct[] enumTypeProducts = EnumTypeProduct.values();
		EnumVisualType[] enumVisualTypes = EnumVisualType.values();
		List<Company> companies = companyRepository.findAll();
		companies.forEach(company->{
			double price=prices[new Random().nextInt(prices.length)];
			Stream.of("product 1","product 2","product 3","product 4",
					"product 5","product 6","product 7","product 8","product 9","product 10",
					"product 11","product 12").forEach(name->{
						List<Category> category=categoryRepository.findAll();
						Product product=new Product();
						product.setName(name);
						product.setCompanyId(company.getId());
						product.setMinPrice(price);
						product.setMaxPrice(price+200);
						product.setActive(true);
						product.setPubActive(true);
						product.setDevise(EnumDevise.XAF);
						product.setType(enumTypeProducts[new Random().nextInt(enumTypeProducts.length)]);
						product.setQuantity(13);
						product.setPubActive(true);
						product.setCategory(category.get(new Random().nextInt(category.size())));
						product = productRepository.save(product);
						for(int i=0; i<1; i++) {
							paragraphList paragraphs = new paragraphList();
							paragraphs.setTitle("Paragraphe "+i);
							paragraphs.setProductId(product.getId());
							paragraphs.setProductId(product.getId());
							paragraphs.setLevel(0);
							paragraphs = paragraphRepository.save(paragraphs);
							product.setParagraph(paragraphs);
							productRepository.save(product);
							for(int y=0; y<4; y++) {
								Text text1 = new Text();
								text1.setLevel(paragraphs.getLevel()+1);
								Visual visual = new Visual();
								visual.setName("visual "+i);
								visual.setVisual(enumVisualTypes[new Random().nextInt(enumVisualTypes.length)]);
								visual.setVisualName("product"+visual.getId());
								visual=visualRepository.save(visual);
								text1.getVisuals().add(visual);
								text1.setProductId(product.getId());
								text1.setDescription("In marketing, a product is an object, or system, or service made available for consumer use as of the consumer demand; it is anything that can be offered to a market to satisfy the desire or need of a customer.");
								text1.setParagraph(paragraphs);
								text1=paragraphRepository.save(text1);
								visual.setText(text1);
								visualRepository.save(visual);
								paragraphs.getParagraphs().add(text1);
								paragraphRepository.save(paragraphs);
								if(y==3) {
									paragraphList paragraph = new paragraphList();
									paragraph.setTitle("Paragraphe "+i);
									paragraph.setProductId(product.getId());
									paragraph.setParagraph(paragraphs);
									paragraph.setLevel(paragraphs.getLevel()+1);
									paragraph = paragraphRepository.save(paragraph);
									for(int k=0; k<4; k++) {
										Text text = new Text();
										text.setLevel(paragraph.getLevel()+1);
										text.setDescription("In marketing, a product is an object, or system, or service made available for consumer use as of the consumer demand; it is anything that can be offered to a market to satisfy the desire or need of a customer.");
										text.setType(EnumParagraph.INTRODUCTION);
										text.setProductId(product.getId());
										text.setParagraph(paragraph);
										Visual visual1 = new Visual();
										visual1.setName("visual "+i);
										visual1.setVisual(enumVisualTypes[new Random().nextInt(enumVisualTypes.length)]);
										visual1.setVisualName("product"+visual.getId());
										visual1=visualRepository.save(visual1);
										text1.getVisuals().add(visual1);
										visual1.setText(text);
										visualRepository.save(visual1);
										paragraphRepository.save(text);
									}
								}

							}


						}

			});
		});
		
	}

	@Override
	public void initDailyReport() {
		List<Company> companies = companyRepository.findAll();
		List<Product> products = productRepository.findAll();
		PageRequest pageRequest = PageRequest.of( 1,20 , Sort.by(Direction.ASC ,"createAt"));
		companies.forEach(company->{
			for(int y=0;y<4;y++) {
				DailyReport dailyReport = new DailyReport();
				dailyReport.setCompanyId(company.getId());
				dailyReport.setCreateAt(new Date());
				dailyReport.setCreance(19000);
				dailyReport.setTotaux(50000);
				dailyReport.setSendReport(false);
				dailyReport=dailyReportRepository.save(dailyReport);
				for(int i=0;i<20;i++) {
					Product product = products.get(new Random().nextInt(products.size()));
					ItemProduct itemProduct = new ItemProduct();
					itemProduct.setProduct(product);
					itemProduct.setQuatity(15);
					itemProduct.setBilling(false);
					itemProduct.setTotal(50000);
					itemProduct.setDailyReport(dailyReport);
					itemProductRepository.save(itemProduct);
					if(i%2==0) {
						Client client = new Client();
						client.setCompanyId(company.getId());
						client.setLastName("kamga");
						client.setFirstName("sado");
						client.setPhoneNumber("693266410");
						client = partnerRepository.save(client);
						itemProduct.setBilling(true);
						ClientBill clientBill = new ClientBill();
						clientBill.setCompany("i2k group");
						clientBill.setDailyReport(dailyReport);
						clientBill.setClient(client);
						clientBill=clientBillRepository.save(clientBill);
						itemProduct.setClientBill(clientBill);
						itemProductRepository.save(itemProduct);
					}
				}
			}

		});
	}


	@Override
	public void initBalance() {
		List<Company> companies = companyRepository.findAll();
		companies.forEach(company->{
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
				//accountingBalance = accountingBalanceRepository.save(accountingBalance);
				//System.out.print(operation1.getAccountingOperation().get(i).getMovement()+" ");
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
						//accountingBalanceRepository.save(accountingBalance);
						//companyBalance.get(0).getAccountingBalance().add(accountingBalance);
						accountingBalance.setBalance(balance);
						accountingBalanceRepository.save(accountingBalance);
					}
				}
				for(int y=i+1;y<operation1.getAccountingOperation().size();y++) {
					if(operation1.getAccountingOperation().get(i).getAccounting().getAccountingNumber()==operation1.getAccountingOperation().get(y).getAccounting().getAccountingNumber() ) {
						if(operation1.getAccountingOperation().get(i).getMovement()==EnumFinancialMovement.CREDIT) {
							accountingBalance.setCredit(accountingBalance.getCredit()+operation1.getAccountingOperation().get(y).getPrice());
							//accountingBalance.setCreditSolde(accountingBalance.getCredit()+operation1.getAccountingOperation().get(i).getPrice());
						}else {
							accountingBalance.setDebit(accountingBalance.getDebit()+operation1.getAccountingOperation().get(y).getPrice());
							//accountingBalance.setDebitSolde(accountingBalance.getCredit()+operation1.getAccountingOperation().get(i).getPrice());
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
							
							balanceRepository.save(companyBalance.get(0));
							
						}else {
							//accountingBalanceRepository.save(accountingBalance);
							//companyBalance.get(0).getAccountingBalance().add(accountingBalance);
							accountingBalance.setBalance(balance);
							accountingBalanceRepository.save(accountingBalance);
						}
						
					}

				}
			}

		});
	}

	@Override
	public void initReview() {
		EnumHeritage[] enumHeritages = EnumHeritage.values();
		List<Company> companies = companyRepository.findAll();
		List<Accounting> Accountings = accountingRepository.findAll();
		companies.forEach(company->{
			Review review = new Review();
			review.setCompanyId(company.getId());
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
		});
	}

	@Override
	public void initAccounting() {
		EnumAccounting[] enumAccountings = EnumAccounting.values();
		Stream.of("57.Caisse", "56.Banques", "20.Charges immobilisées",
				"21.Immobilisations incorporelles","244.Matériel et mobilier","401.Fournisseurs et dettes en compte ",
				"414.Créances client", "16.Emprunts et dettes assimilées","36.Produits finis","32.Matières premières",
				"103.Capital personnel","101.Capital social","44.État et collectivités publiques", "64.Impôts et taxes", "605.Autres achats",
				"604.Achats stockés de matières", "13.Résultat", "66.Charges de personnel",
				"702.Ventes de produits finis", "706.Services vendus","14.Subventions d’investissement","22.Terrains",
				"28.Amortissements","62.Services extérieurs","61.Transports","71.Subventions d’exploitation").forEach(name->{
			Accounting accounting = new Accounting();
			accounting.setAccountingNumber(Integer.valueOf(name.substring(0,name.indexOf("."))));
			accounting.setName(name.substring(name.indexOf(".")+1));
			accounting.setGrouping(enumAccountings[new Random().nextInt(enumAccountings.length)]);
			accountingRepository.save(accounting);
		});
		
	}

	@Override
	public void initOpration() {
		List<Company> companies = companyRepository.findAll();
		List<AppUser> appUsers = appUserRepository.findAll();
		companies.forEach(company->{
			List<DailyReport> dailyReports = dailyReportRepository.findByCompanyIdAndSendReport(company.getId(), false);
			if(dailyReports.size()!=0) {
				dailyReports.forEach(dailyReport->{
					dailyReport.setSendReport(true);
					dailyReportRepository.save(dailyReport);
					Operation operation = new Operation();
					operation.setCompanyId(company.getId());
					operation.setUserId(appUsers.get(new Random().nextInt(appUsers.size())).getId());
					operation.setOperationDate(new Date());
					operation = operationRepository.save(operation);
					AccountingOperation accountingOperation = new AccountingOperation();
					AccountingOperation accountingOperation1 = new AccountingOperation();
					AccountingOperation accountingOperation2 = new AccountingOperation();
					AccountingOperation accountingOperation3 = new AccountingOperation();
					for(ItemProduct itemProducts:dailyReport.getItemProducts()) {
						if(itemProducts.getProduct().getType()==EnumTypeProduct.BIEN) {
							accountingOperation.setAccounting(accountingRepository.findByAccountingNumber(702));
							accountingOperation.setOperation(operation);
							accountingOperation.setMovement(EnumFinancialMovement.DEBIT);
							accountingOperation.setHeritage(EnumHeritage.PASSIVE);
							accountingOperation.setPrice(accountingOperation.getPrice()+itemProducts.getTotal());
						}
						if(itemProducts.getProduct().getType()==EnumTypeProduct.SERVICE) {
							accountingOperation1.setAccounting(accountingRepository.findByAccountingNumber(706));
							accountingOperation1.setOperation(operation);
							accountingOperation1.setMovement(EnumFinancialMovement.DEBIT);
							accountingOperation1.setHeritage(EnumHeritage.PASSIVE);
							accountingOperation1.setPrice(accountingOperation.getPrice()+itemProducts.getTotal());
						}
			
					}
					boolean find=false;
					for(ClientBill clientBill:dailyReport.getClientBills()) {
						if(clientBill.getStatus()==EnumBillStatus.NOPAID) {
							find=true;
							accountingOperation2.setAccounting(accountingRepository.findByAccountingNumber(414));
							accountingOperation2.setOperation(operation);
							accountingOperation2.setMovement(EnumFinancialMovement.DEBIT);
							accountingOperation2.setHeritage(EnumHeritage.ACTIVE);
							accountingOperation2.setPrice(accountingOperation.getPrice()+clientBill.getPrice());
						}
					}
					accountingOperation3.setAccounting(accountingRepository.findByAccountingNumber(57));
					accountingOperation3.setOperation(operation);
					accountingOperation3.setMovement(EnumFinancialMovement.CREDIT);
					accountingOperation3.setHeritage(EnumHeritage.ACTIVE);
					accountingOperation3.setPrice(accountingOperation.getPrice()+accountingOperation1.getPrice());
					accountingOperationRepository.save(accountingOperation);
					accountingOperationRepository.save(accountingOperation1);
					if(find) {
						accountingOperationRepository.save(accountingOperation2);
					}
					accountingOperationRepository.save(accountingOperation3);

				});
			}
		});

	}

	@Override
	public void initUpateReview() {
		EnumHeritage[] enumHeritages = EnumHeritage.values();
		List<Company> companies = companyRepository.findAll();
		companies.forEach(company->{
			List<Review>reviews =reviewRepository.findByCompanyIdAndLast(company.getId(), true);
			reviews.get(0).setLast(false);
			reviewRepository.save(reviews.get(0));
			Review review = new Review();
			review.setLast(true);
			review.setCompanyId(company.getId());
			review.setReviewDate(new Date());
			review.getAccountingReview().addAll(reviews.get(0).getAccountingReview());
			review.setActiveTotaux(reviews.get(0).getActiveTotaux());
			review = reviewRepository.save(review);
			List<Balance> balances=balanceRepository.findByCompanyIdAndSendReview(company.getId(), false);
			if(balances.size()!=0) {
				for(Balance balance:balances) {
					balance.setSendReview(true);
					balanceRepository.save(balance);
					for(AccountingBalance accountingBalance:balance.getAccountingBalance()) {
						String pn =accountingBalance.getAccounting().getAccountingNumber()+ "";
						if(0<Integer.valueOf(pn.substring(0,1))&&Integer.valueOf(pn.substring(0,1))<6) {
							for(int i=0;i<review.getAccountingReview().size();i++) {
								AccountingReview accountingReview = review.getAccountingReview().get(i);
								if(accountingBalance.getAccounting().getAccountingNumber()==accountingReview.getAccounting().getAccountingNumber()) {
									if(0<Integer.valueOf(pn.substring(0,1))&&Integer.valueOf(pn.substring(0,1))<4) {
										if(accountingBalance.getDebitSolde()>0) {
											review.getAccountingReview().get(i).setSolde(review.getAccountingReview().get(i).getSolde()+accountingBalance.getDebitSolde());
										}else {
											review.getAccountingReview().get(i).setSolde(review.getAccountingReview().get(i).getSolde()-accountingBalance.getCreditSolde());
										}
									}else {
										if(accountingBalance.getCredit()>0) {
											review.getAccountingReview().get(i).setSolde(review.getAccountingReview().get(i).getSolde()+accountingBalance.getCreditSolde());
										}else {
											review.getAccountingReview().get(i).setSolde(review.getAccountingReview().get(i).getSolde()-accountingBalance.getDebitSolde());
										}
									}
								}else {
									AccountingReview accountingReview1 = new AccountingReview();
									accountingReview1.setAccounting(accountingBalance.getAccounting());
									accountingReview1.setPatrimoine(enumHeritages[new Random().nextInt(enumHeritages.length)]);
									accountingReview1.setReview(review);
									accountingReview1 = accountingReviewRepository.save(accountingReview1);
									if(0<Integer.valueOf(pn.substring(0,1))&&Integer.valueOf(pn.substring(0,1))<4) {
										if(accountingBalance.getDebitSolde()>0) {
											accountingReview1.setSolde(accountingBalance.getDebitSolde());
										}else {
											accountingReview1.setSolde(-accountingBalance.getCreditSolde());;
										}
									}else {
										if(accountingBalance.getCredit()>0) {
											accountingReview1.setSolde(accountingBalance.getCreditSolde());
										}else {
											accountingReview1.setSolde(accountingBalance.getDebitSolde());
										}
									}
									accountingReviewRepository.save(accountingReview1);

								}
							}

						}
					}
					double active =0;
					double pasive =0;
					for(AccountingReview accountingReview3: review.getAccountingReview()) {
						if(accountingReview3.getPatrimoine()==EnumHeritage.ACTIVE) {
							System.out.print(accountingReview3.getSolde());
							active =active+accountingReview3.getSolde();
						}else {
							pasive =pasive+accountingReview3.getSolde();
						}
					}
					if(active>pasive) {
						review.setActiveTotaux(review.getActiveTotaux()+active);
						review.setResult(active-pasive);
						reviewRepository.save(review);
					}else {
						review.setPassiveTotaux(review.getPassiveTotaux()+pasive);
						review.setResult(active-pasive);
						reviewRepository.save(review);
					}

				}
			}

		});
		
	}

	@Override
	public void initActionnaire() {
		double[] prices = new double[] {1000,2500,7550,800,400};
		EnumDivident[] enumDividents = EnumDivident.values();
		List<Company> companies = companyRepository.findAll();
		companies.forEach(company->{
			for(int i=0;i<10;i++) {
				Actionnaire actionnaire=new Actionnaire();
				actionnaire.setCompanyId(company.getId());
				actionnaire.setLastName("kamga");
				actionnaire.setFirstName("sado");
				actionnaire.setPhoneNumber("693266410");
				actionnaire.setActionNb(12);
				actionnaire.setReinvestment(1000);
				actionnaire = partnerRepository.save(actionnaire);
				if(i%2==0) {
					Dividend dividend = new Dividend();
					dividend.setActionnaire(actionnaire);
					dividend.setCreateAt(new Date());
					dividend.setTotalAmount(prices[new Random().nextInt(prices.length)]);
					dividend.setStatus(enumDividents[new Random().nextInt(enumDividents.length)]);
					dividendRepository.save(dividend);
				}
				
				partnerRepository.save(actionnaire);
			}
		});
	}

	@Override
	public void initEmploye() {
		double[] prices = new double[] {1000,2500,7550,800,400};
		List<Company> companies = companyRepository.findAll();
		companies.forEach(company->{
			for(int i=0;i<10;i++) {
				Employe employe=new Employe();
				employe.setCompanyId(company.getId());
				employe.setLastName("kamga");
				employe.setFirstName("sado");
				employe.setPhoneNumber("693266410");
				employe.setSalary(10000);
				employe.setWork("RH");
				employe = partnerRepository.save(employe);
				if(i%2==0) {
					Paid paid = new Paid();
					paid.setWorkDescription("developpeur");
					paid.setEmploye(employe);
					paid.setCreateAt(new Date());
					paid.setMotivatePayment("payer pour les developement");
					paid.setAmount(prices[new Random().nextInt(prices.length)]);
					paidRepository.save(paid);
				}
				
				partnerRepository.save(employe);
			}
		});
		
	}

	@Override
	public void initModification() {
		List<AppUser> appUsers = appUserRepository.findAll();
		EnumModificationType [] enumModificationTypes = EnumModificationType.values();
		List<Company> companies = companyRepository.findAll();
		companies.forEach(company->{
			for(int i=0;i<10;i++) {
				AppUser UserSend = appUsers.get(new Random().nextInt(appUsers.size()));
				AppUser User = appUsers.get(new Random().nextInt(appUsers.size()));
				Motification motification = new Motification();
				motification.setDate(new Date());
				motification.setEmetorId(UserSend.getId());
				motification.setUser(User);
				motification.setView(false);
				motification.setType(enumModificationTypes[new Random().nextInt(enumModificationTypes.length)]);
				motification.setDescription("ajour de new user");
				motification.setModificationId(UserSend.getId());
				motificationRepository.save(motification);
			}
		});
	}

}
