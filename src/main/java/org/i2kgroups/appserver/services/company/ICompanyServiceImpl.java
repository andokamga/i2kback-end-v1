package org.i2kgroups.appserver.services.company;

import java.util.ArrayList;
import java.util.List;

import org.i2kgroups.appserver.dtos.AddRemoveCompanyDTO;
import org.i2kgroups.appserver.dtos.AddRemoveParagraphDTO;
import org.i2kgroups.appserver.dtos.AddRemoveRoleDTO;
import org.i2kgroups.appserver.dtos.AddRemoveUnderTown;
import org.i2kgroups.appserver.dtos.AppRoleDTO;
import org.i2kgroups.appserver.dtos.AppUserDTO;
import org.i2kgroups.appserver.dtos.CompanyDTO;
import org.i2kgroups.appserver.dtos.ParagraphDTO;
import org.i2kgroups.appserver.dtos.ParagraphListDTO;
import org.i2kgroups.appserver.dtos.SaveAppUserDTO;
import org.i2kgroups.appserver.dtos.TextDTO;
import org.i2kgroups.appserver.dtos.TownDTO;
import org.i2kgroups.appserver.entities.AppRole;
import org.i2kgroups.appserver.entities.AppUser;
import org.i2kgroups.appserver.entities.Company;
import org.i2kgroups.appserver.entities.Paragraph;
import org.i2kgroups.appserver.entities.Product;
import org.i2kgroups.appserver.entities.Text;
import org.i2kgroups.appserver.entities.Town;
import org.i2kgroups.appserver.entities.paragraphList;
import org.i2kgroups.appserver.enums.EnumAction;
import org.i2kgroups.appserver.enums.EnumParagraphType;
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
import org.i2kgroups.appserver.services.production.ParagraphToTree;
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
public class ICompanyServiceImpl implements ICompanyService{
	
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
	@Autowired
	public ParagraphToTree paragraphToTree;
	@Override
	public TownDTO addUpdateTown(TownDTO townDTO) {
		Town town = iCompanyMapper.townDTOConvertToTown(townDTO);
		town = townRepository.save(town);
		return iCompanyMapper.townConvertToTownDTO(town);
	}

	@Override
	public TownDTO addRemoveUnderTown(AddRemoveUnderTown underTown) {
		Town town = townRepository.findById(underTown.getTownId()).orElse(null);
		if(town!=null) {
			if(underTown.getAction()==EnumAction.ADDS) {
				for(TownDTO townDTO:underTown.getTownsDTO()) {
					Town ctown = iCompanyMapper.townDTOConvertToTown(townDTO);
					town = townRepository.save(ctown);
					town.getUnderTowns().add(ctown);
				}
			}
			if(underTown.getAction()==EnumAction.REMOVES) {
				for(TownDTO townDTO:underTown.getTownsDTO()) {
					for(int i=0;i<town.getUnderTowns().size();i++) {
						if(town.getUnderTowns().get(i).getId()==townDTO.getId()) {
							Town ctown = iCompanyMapper.townDTOConvertToTown(townDTO);
							town.getUnderTowns().remove(ctown);
						}
					}

				}
			}
		}
		town = townRepository.save(town);
		return iCompanyMapper.townConvertToTownDTO(town);
	}

	@Override
	public CompanyDTO addUpdateCompany(CompanyDTO company) {
		Company c = iCompanyMapper.companyDTOConvertToCompany(company);
		c = companyRepository.save(c);
		return iCompanyMapper.companyConvertToCompanyDTO(c);
	}

	@Override
	public CompanyDTO addRemoveParagraphCompany(AddRemoveParagraphDTO paragraph) {
		Paragraph p = paragraphRepository.findById(paragraph.getParagraphId()).orElse(null);
		if(p!=null&&!paragraph.getParagraphsDTO().isEmpty()) {
			if(paragraph.getAction()==EnumAction.ADDS) {
				for(ParagraphDTO cp:paragraph.getParagraphsDTO()) {
					Paragraph np = iProductionMapper.paragraphDTOConvertToParagraph(cp);
					np.setParagraph(p);
					paragraphRepository.save(np);
					Company company = companyRepository.findById(paragraph.getCompanyId()).orElse(null);
					if(company!=null) {
						return iCompanyMapper.companyConvertToCompanyDTO(company);
					}
				}
			}
			if(paragraph.getAction()==EnumAction.REMOVES) {
				for(ParagraphDTO cp:paragraph.getParagraphsDTO()) {
					Paragraph np = iProductionMapper.paragraphDTOConvertToParagraph(cp);
					paragraphRepository.delete(np);
					Company company = companyRepository.findById(paragraph.getCompanyId()).orElse(null);
					if(company!=null) {
						return iCompanyMapper.companyConvertToCompanyDTO(company);
					}
				}
			}
		}
		if(p!=null&&!paragraph.getTextsDTO().isEmpty()) {
			if(paragraph.getAction()==EnumAction.ADDS) {
				for(ParagraphDTO ct:paragraph.getTextsDTO()) {
					Text nt = iProductionMapper.textDTOConvertToText((TextDTO) ct);
					nt.setParagraph(p);
					paragraphRepository.save(nt);
					Company company = companyRepository.findById(paragraph.getCompanyId()).orElse(null);
					if(company!=null) {
						return iCompanyMapper.companyConvertToCompanyDTO(company);
					}
				}
			}
			if(paragraph.getAction()==EnumAction.REMOVES) {
				for(ParagraphDTO ct:paragraph.getParagraphsDTO()) {
					Text nt = iProductionMapper.textDTOConvertToText((TextDTO) ct);
					paragraphRepository.delete(nt);
					Company company = companyRepository.findById(paragraph.getCompanyId()).orElse(null);
					if(company!=null) {
						return iCompanyMapper.companyConvertToCompanyDTO(company);
					}
				}
			}
		}
		return null;
	}

	@Override
	public AppUserDTO addRemoveRoleToUser(AddRemoveRoleDTO userRole) {
		AppUser appUser = appUserRepository.findById(userRole.getUserId()).orElse(null);
		AppRole appRole	= appRoleRepository.findById(userRole.getUserId()).orElse(null);
		if(appUser!=null&&appRole!=null) {
			if(userRole.getAction()==EnumAction.ADDS) {
				appUser.getRoles().add(appRole);
				appRole.getUsers().add(appUser);
				appRoleRepository.save(appRole);
				appUser = appUserRepository.save(appUser);
				return iCompanyMapper.appUserConvertToAppUserDTO(appUser);
			}
			if(userRole.getAction()==EnumAction.REMOVES) {
				appUser.getRoles().remove(appRole);
				appRole.getUsers().remove(appUser);
				appRoleRepository.save(appRole);
				appUser = appUserRepository.save(appUser);
				return iCompanyMapper.appUserConvertToAppUserDTO(appUser);
			}
		}
		return null;
	}

	@Override
	public AppUserDTO addRemoveCompanyToUser(AddRemoveCompanyDTO userCompany) {
		AppUser appUser = appUserRepository.findById(userCompany.getUserId()).orElse(null);
		Company company	= companyRepository.findById(userCompany.getCompanyId()).orElse(null);
		if(appUser!=null&&company!=null) {
			if(userCompany.getAction()==EnumAction.ADDS) {
				appUser.getCompany().add(company);
				company.getUsers().add(appUser);
				companyRepository.save(company);
				appUser = appUserRepository.save(appUser);
				return iCompanyMapper.appUserConvertToAppUserDTO(appUser);
			}
			if(userCompany.getAction()==EnumAction.REMOVES) {
				appUser.getCompany().remove(company);
				company.getUsers().remove(appUser);
				companyRepository.save(company);
				appUser = appUserRepository.save(appUser);
				return iCompanyMapper.appUserConvertToAppUserDTO(appUser);
			}
		}
		return null;
	}

	@Override
	public AppUserDTO addUpdateUser(SaveAppUserDTO user) {
		AppUser appUser = iCompanyMapper.appUserDTOConvertToAppUser(user);
		appUser = appUserRepository.save(appUser);
		return iCompanyMapper.appUserConvertToAppUserDTO(appUser);
	}

	@Override
	public AppUserDTO findAppUser(String username) {
		
		AppUser appUser = appUserRepository.findByPhoneNumber(username);
		if(appUser==null) {
			appUser = appUserRepository.findByEmail(username);
		}
		if(appUser==null) {
			appUser = appUserRepository.findByUsername(username);
		}
		if(appUser!=null) {
			return iCompanyMapper.appUserConvertToAppUserDTO(appUser);
		}
		return null;
	}

	@Override
	public Page<TownDTO> allTown(PageRequest page) {
		List<Town> towns = townRepository.findAll();
		List<TownDTO> townDTO = new ArrayList<>();
		for(Town town:towns) {
			townDTO.add(iCompanyMapper.townConvertToTownDTO(town));
		}
		return new PageImpl<>(townDTO, page, townDTO.size());

	}

	@Override
	public Page<CompanyDTO> allCompany(PageRequest page) {
		List<Company> companies = companyRepository.findAll();
		List<CompanyDTO> companiesDTO = new ArrayList<>();
		for(Company company:companies) {
			List<Paragraph> paragraphs = paragraphRepository.findByCompanyId(company.getId());
			CompanyDTO companyDTO= iCompanyMapper.companyConvertToCompanyDTO(company);
			companyDTO.setParagraphDTO(paragraphToTree.paragraphToparagraphTreeDTO(paragraphs));
			companiesDTO.add(companyDTO);
		}
		return new PageImpl<>(companiesDTO, page, companiesDTO.size());
	}

	@Override
	public Page<AppUserDTO> allUser(PageRequest page) {
		List<AppUser> appUsers = appUserRepository.findAll();
		List<AppUserDTO> appUsersDTO = new ArrayList<>();
		for(AppUser appUser:appUsers) {
			appUsersDTO.add(iCompanyMapper.appUserConvertToAppUserDTO(appUser));
		}
		return new PageImpl<>(appUsersDTO, page, appUsersDTO.size());
	}

	@Override
	public Page<AppRoleDTO> allRole(PageRequest page) {
		List<AppRole> appRoles = appRoleRepository.findAll();
		List<AppRoleDTO> appRolesDTO = new ArrayList<>();
		for(AppRole appRole:appRoles) {
			appRolesDTO.add(iCompanyMapper.appRoleConvertToAppRoleDTO(appRole));
		}
		return new PageImpl<>(appRolesDTO, page, appRolesDTO.size());
	}

	@Override
	public Page<TownDTO> findTown(String name, PageRequest page) {
		List<Town> towns = townRepository.findByNameContains(name);
		List<TownDTO> townDTO = new ArrayList<>();
		for(Town town:towns) {
			townDTO.add(iCompanyMapper.townConvertToTownDTO(town));
		}
		return new PageImpl<>(townDTO, page, townDTO.size());
	}

	@Override
	public Page<CompanyDTO> findCompany(String name, PageRequest page) {
		List<Company> companies = companyRepository.findByNameContains(name);
		List<CompanyDTO> companiesDTO = new ArrayList<>();
		for(Company company:companies) {
			List<Paragraph> paragraphs = paragraphRepository.findByCompanyId(company.getId());
			CompanyDTO companyDTO= iCompanyMapper.companyConvertToCompanyDTO(company);
			companyDTO.setParagraphDTO(paragraphToTree.paragraphToparagraphTreeDTO(paragraphs));
			companiesDTO.add(companyDTO);
		}
		return new PageImpl<>(companiesDTO, page, companiesDTO.size());
	}

	@Override
	public Page<AppUserDTO> findUser(String name, PageRequest page) {
		List<AppUser> appUsers = appUserRepository.findByUsernameContainsOrEmailContainsOrPhoneNumberContains(name, name, name, page);
		List<AppUserDTO> appUsersDTO = new ArrayList<>();
		for(AppUser appUser:appUsers) {
			appUsersDTO.add(iCompanyMapper.appUserConvertToAppUserDTO(appUser));
		}
		return new PageImpl<>(appUsersDTO, page, appUsersDTO.size());
	}

	@Override
	public Page<AppRoleDTO> findRole(String name, PageRequest page) {
		List<AppRole> appRoles = appRoleRepository.findByNameContains(name);
		List<AppRoleDTO> appRolesDTO = new ArrayList<>();
		for(AppRole appRole:appRoles) {
			appRolesDTO.add(iCompanyMapper.appRoleConvertToAppRoleDTO(appRole));
		}
		return new PageImpl<>(appRolesDTO, page, appRolesDTO.size());
	}

	@Override
	public boolean deleteTown(Long townId) {
		if(townRepository.existsById(townId)) {
			townRepository.deleteById(townId);
			return true;
		}
		return false;
	}

	@Override
	public boolean CompanyTown(Long companyId) {
		if(companyRepository.existsById(companyId)) {
			List<Paragraph> paragraphs = paragraphRepository.findByCompanyId(companyId);
			for(Paragraph paragraph:paragraphs) {
				paragraphRepository.delete(paragraph);
			}
			companyRepository.deleteById(companyId);
			return true;
		}
		return false;
	}

}
