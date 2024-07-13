package org.i2kgroups.appserver.services.production;

import java.util.ArrayList;
import java.util.List;

import org.i2kgroups.appserver.dtos.ActionnaireDTO;
import org.i2kgroups.appserver.dtos.AddRemoveItemDailyWorkDTO;
import org.i2kgroups.appserver.dtos.AddRemovePaidUser;
import org.i2kgroups.appserver.dtos.AddRemoveParagraphDTO;
import org.i2kgroups.appserver.dtos.CategoryDTO;
import org.i2kgroups.appserver.dtos.ClientDTO;
import org.i2kgroups.appserver.dtos.DailyReportDTO;
import org.i2kgroups.appserver.dtos.DividendDTO;
import org.i2kgroups.appserver.dtos.EmployeDTO;
import org.i2kgroups.appserver.dtos.PaidDTO;
import org.i2kgroups.appserver.dtos.ParagraphDTO;
import org.i2kgroups.appserver.dtos.ParagraphListDTO;
import org.i2kgroups.appserver.dtos.ProductDTO;
import org.i2kgroups.appserver.dtos.TextDTO;
import org.i2kgroups.appserver.entities.Actionnaire;
import org.i2kgroups.appserver.entities.Category;
import org.i2kgroups.appserver.entities.Client;
import org.i2kgroups.appserver.entities.DailyReport;
import org.i2kgroups.appserver.entities.Dividend;
import org.i2kgroups.appserver.entities.Employe;
import org.i2kgroups.appserver.entities.Paragraph;
import org.i2kgroups.appserver.entities.Partner;
import org.i2kgroups.appserver.entities.Product;
import org.i2kgroups.appserver.entities.Text;
import org.i2kgroups.appserver.entities.paragraphList;
import org.i2kgroups.appserver.enums.EnumParagraphType;
import org.i2kgroups.appserver.enums.EnumTypeProduct;
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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class IProductionServiceImpl implements IProductionService {
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
	public IAccountingMapper iAccountingMapper;
	@Autowired
	public ICompanyMapper iCompanyMapper;
	@Autowired
	public IProductionMapper iProductionMapper;

	@Override
	public ProductDTO addUpdateProduct(ProductDTO productDTO) {
		Product product = iProductionMapper.productDTOConvertToProduct(productDTO);
		product = productRepository.save(product);
		return iProductionMapper.productConvertToProductDTO(product);
	}

	@Override
	public CategoryDTO addUpdateCategory(CategoryDTO categoryDTO) {
		Category category = iProductionMapper.categoryDTOConvertToCategory(categoryDTO);
		category = categoryRepository.save(category);
		return iProductionMapper.categoryConvertToCategoryDTO(category);
	}

	@Override
	public Page<ProductDTO> allCompanyProduct(Long companyId, PageRequest page) {
		List<Product> products = productRepository.findByCompanyIdAndType(companyId, EnumTypeProduct.BIEN);
		List<ProductDTO> productsDTO=new ArrayList<>();
		for(Product product:products) {
			ProductDTO productDTO = new ProductDTO();
			List<Paragraph> paragraphs=paragraphRepository.findByProductId(product.getId());
			productDTO = iProductionMapper.productConvertToProductDTO(product);
			productDTO.setParagraphDTO( paragraphToparagraphTreeDTO(paragraphs));
			productsDTO.add(productDTO);
		}
		return new PageImpl<>(productsDTO, page, productsDTO.size());
	}

	@Override
	public Page<ProductDTO> allCompanyService(Long companyId, PageRequest page) {
		List<Product> products = productRepository.findByCompanyIdAndType(companyId, EnumTypeProduct.SERVICE);
		List<ProductDTO> productsDTO=new ArrayList<>();
		for(Product product:products) {
			ProductDTO productDTO = new ProductDTO();
			List<Paragraph> paragraphs=paragraphRepository.findByProductId(product.getId());
			productDTO = iProductionMapper.productConvertToProductDTO(product);
			productDTO.setParagraphDTO( paragraphToparagraphTreeDTO(paragraphs));
			productsDTO.add(productDTO);
		}
		return new PageImpl<>(productsDTO, page, productsDTO.size());
	}

	@Override
	public Page<CategoryDTO> allCategory(PageRequest page) {
		List<Category> categories= categoryRepository.findAll();
		List<CategoryDTO> categoryDTO=new ArrayList<>();
		for(Category category:categories) {
			categoryDTO.add(iProductionMapper.categoryConvertToCategoryDTO(category));
		}
		return new PageImpl<>(categoryDTO, page, categoryDTO.size());
	}
	public void addParagraphToTreeDTO(List<Paragraph> ps,int hauteur,ParagraphListDTO paragraph,int niveau) {
		if(hauteur>niveau) {
			for(Paragraph p:ps) {
				if(p.getLevel()!=0) {
					if(paragraph.getId()==p.getParagraph().getId()) {
						if(p instanceof paragraphList) {
							ParagraphListDTO pa= new ParagraphListDTO();
							pa.setId(p.getId());
							pa.setTypep(EnumParagraphType.PARAGRAPH);
							ParagraphListDTO pc = (ParagraphListDTO) paragraph.addChild(pa);
							addParagraphToTreeDTO(ps,hauteur, pc,niveau-1);
						}else {
							TextDTO t1 =iProductionMapper.textConvertToTextDTO((Text) p);
							TextDTO t = new TextDTO();
							t.setId(t1.getId());
							t.setLevel(t1.getLevel());
							t1.setTypep(EnumParagraphType.TEXT);
							paragraph.addChild(t1);

						}
					}
				}

			}
		
		}
		
	}
	public ParagraphDTO paragraphToparagraphTreeDTO(List<Paragraph> ps) {
		int hauteur=0;
		ParagraphListDTO paragraph= new ParagraphListDTO();
		for(Paragraph p:ps) {
			if(p.getLevel()>hauteur) {
				hauteur=p.getLevel();
			}
			if(p.getLevel()==0) { 
				paragraph.setLevel(0);
				paragraph.setId(p.getId());

			}
		}
		addParagraphToTreeDTO(ps,hauteur,paragraph,1);
		return paragraph;
	}
	@Override
	public Page<ProductDTO> findCompanyProduct(Long companyId, String name, PageRequest page) {
		List<Product> products = productRepository.findByCompanyIdAndNameContains(companyId, name);
		List<ProductDTO> productsDTO = new ArrayList<>();
		if(!products.isEmpty()) {
			for(Product product:products) {
				ProductDTO productDTO = new ProductDTO();
				List<Paragraph> paragraphs=paragraphRepository.findByProductId(product.getId());
				productDTO = iProductionMapper.productConvertToProductDTO(product);
				productDTO.setParagraphDTO(paragraphToparagraphTreeDTO(paragraphs));
				productsDTO.add(productDTO);
			}
		}
		
		return new PageImpl<>(productsDTO, page, productsDTO.size());
	}

	@Override
	public Page<CategoryDTO> findCompanyCategory(String name,PageRequest page) {
		List<Category> categories = categoryRepository.findByNameContains(name);
		List<CategoryDTO> categoriesDTO = new ArrayList<>();
		if(!categories.isEmpty()) {
			for(Category category:categories) {
				categoriesDTO.add(iProductionMapper.categoryConvertToCategoryDTO(category));
			}
		}
		
		return new PageImpl<>(categoriesDTO, page, categoriesDTO.size());
	}

	@Override
	public boolean deleteProduct(Long productId) {
		if(productRepository.existsById(productId)) {
			List<Paragraph> paragraphs = paragraphRepository.findByProductId(productId);
			for(Paragraph paragraph:paragraphs) {
				paragraphRepository.delete(paragraph);
			}
			productRepository.deleteById(productId);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteCategory(Long categoryId) {
		if(categoryRepository.existsById(categoryId)) {
			categoryRepository.deleteById(categoryId);
			return true;
		}
		return false;
	}

	@Override
	public ClientDTO addUpdateClient(ClientDTO clientDTO) {
		Client client = iCompanyMapper.clientDTOConvertToClient(clientDTO);
		client = partnerRepository.save(client);
		return iCompanyMapper.clientConvertToClientDTO(client);
	}

	@Override
	public EmployeDTO addUpdateEmploye(EmployeDTO employeDTO) {
		Employe employe = iCompanyMapper.employeDTOConvertToEmploye(employeDTO);
		employe = partnerRepository.save(employe);
		return iCompanyMapper.employeConvertToEmployeDTO(employe);
	}

	@Override
	public ActionnaireDTO addUpdateActionnaire(ActionnaireDTO actionnaireDTO) {
		Actionnaire actionnaire = iCompanyMapper.actionnaireDTOConvertToActionnaire(actionnaireDTO);
		actionnaire = partnerRepository.save(actionnaire);
		return iCompanyMapper.actionnaireConvertToActionnaireDTO(actionnaire);
	}

	@Override
	public DailyReportDTO addUpdateCompanyDailyReport(DailyReportDTO dailyWorkDTO) {
		DailyReport dailyReport = iProductionMapper.dailyReportDTOConvertToDailyReport(dailyWorkDTO);
		dailyReport = dailyReportRepository.save(dailyReport);
		return iProductionMapper.dailyReportConvertToDailyReportDTO(dailyReport);
	}

	@Override
	public DailyReportDTO addRemoveItemToDailyReport(AddRemoveItemDailyWorkDTO dailyWorkDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<PaidDTO> addRemoveCompanyPaid(AddRemovePaidUser paidUser, PageRequest page) {
		List<Category> categories= categoryRepository.findAll();
		List<CategoryDTO> categoryDTO=new ArrayList<>();
		for(Category category:categories) {
			categoryDTO.add(iProductionMapper.categoryConvertToCategoryDTO(category));
		}
		return new PageImpl<>(categoryDTO, page, categoryDTO.size());
	}

	@Override
	public DividendDTO addUpdateDividend(DividendDTO dividendDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<DividendDTO> allCompanyDividend(Long companyId, PageRequest page) {
		List<Dividend> dividend= categoryRepository.findAll();
		List<CategoryDTO> categoryDTO=new ArrayList<>();
		for(Category category:categories) {
			categoryDTO.add(iProductionMapper.categoryConvertToCategoryDTO(category));
		}
		return new PageImpl<>(categoryDTO, page, categoryDTO.size());
	}

	@Override
	public Page<ClientDTO> allCompanyClient(Long companyId, PageRequest page) {
		List<Partner> partners = partnerRepository.findByCompanyId(companyId);
		List<ClientDTO> clientsDTO=new ArrayList<>();
		for(Partner partner:partners) {
			if(partner instanceof Client) {
				clientsDTO.add(iCompanyMapper.clientConvertToClientDTO((Client) partner));
			}
		}
		return new PageImpl<>(clientsDTO, page, clientsDTO.size());
	}

	@Override
	public Page<EmployeDTO> allCompanyEmploye(Long companyId, PageRequest page) {
		List<Partner> partners = partnerRepository.findByCompanyId(companyId);
		List<EmployeDTO> employesDTO=new ArrayList<>();
		for(Partner partner:partners) {
			if(partner instanceof Employe) {
				employesDTO.add(iCompanyMapper.employeConvertToEmployeDTO((Employe) partner));
			}
		}
		return new PageImpl<>(employesDTO, page, employesDTO.size());
	}

	@Override
	public Page<ActionnaireDTO> allCompanyActionnaire(Long companyId, PageRequest page) {
		List<Partner> partners = partnerRepository.findByCompanyId(companyId);
		List<ActionnaireDTO> actionnaireDTO=new ArrayList<>();
		for(Partner partner:partners) {
			if(partner instanceof Actionnaire) {
				actionnaireDTO.add(iCompanyMapper.actionnaireConvertToActionnaireDTO((Actionnaire) partner));
			}
		}
		return new PageImpl<>(actionnaireDTO, page, actionnaireDTO.size());
	}

	@Override
	public Page<DailyReportDTO> allCompanyCompanyDailyReport(Long companyId, PageRequest page) {
		List<DailyReport> dailyReports= dailyReportRepository.findByCompanyId(companyId);
		List<DailyReportDTO> dailyReportsDTO=new ArrayList<>();
		for(DailyReport dailyReport:dailyReports) {
			dailyReportsDTO.add(iProductionMapper.dailyReportConvertToDailyReportDTO(dailyReport));
		}
		return new PageImpl<>(dailyReportsDTO, page, dailyReportsDTO.size());
	}

	@Override
	public boolean deleteDividend(Long dividendtId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteClient(Long clientId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmploye(Long employeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteActionnaire(Long actionnaireId) {
		// TODO Auto-generated method stub
		return false;
	}

}
