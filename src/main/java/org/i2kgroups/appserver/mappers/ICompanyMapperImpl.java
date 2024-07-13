package org.i2kgroups.appserver.mappers;
import org.i2kgroups.appserver.dtos.ActionnaireDTO;
import org.i2kgroups.appserver.dtos.AppRoleDTO;
import org.i2kgroups.appserver.dtos.AppUserDTO;
import org.i2kgroups.appserver.dtos.ClientDTO;
import org.i2kgroups.appserver.dtos.CompanyDTO;
import org.i2kgroups.appserver.dtos.ConfigurationDTO;
import org.i2kgroups.appserver.dtos.DividendDTO;
import org.i2kgroups.appserver.dtos.EmployeDTO;
import org.i2kgroups.appserver.dtos.MotificationDTO;
import org.i2kgroups.appserver.dtos.PaidDTO;
import org.i2kgroups.appserver.dtos.SaveAppUserDTO;
import org.i2kgroups.appserver.dtos.SocialLinkDTO;
import org.i2kgroups.appserver.dtos.TownDTO;
import org.i2kgroups.appserver.entities.Actionnaire;
import org.i2kgroups.appserver.entities.AppRole;
import org.i2kgroups.appserver.entities.AppUser;
import org.i2kgroups.appserver.entities.Client;
import org.i2kgroups.appserver.entities.Company;
import org.i2kgroups.appserver.entities.Configuration;
import org.i2kgroups.appserver.entities.Dividend;
import org.i2kgroups.appserver.entities.Employe;
import org.i2kgroups.appserver.entities.Motification;
import org.i2kgroups.appserver.entities.Paid;
import org.i2kgroups.appserver.entities.SocialLink;
import org.i2kgroups.appserver.entities.Town;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ICompanyMapperImpl implements ICompanyMapper {

	
	@Autowired
	public ModelMapper modelMapper;
	
	@Override
	public AppRoleDTO appRoleConvertToAppRoleDTO(AppRole appRole) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		AppRoleDTO appRoleDTO = new AppRoleDTO();
		appRoleDTO = modelMapper.map(appRole, AppRoleDTO.class);
		return appRoleDTO;
	}

	@Override
	public AppUserDTO appUserConvertToAppUserDTO(AppUser appUser) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		AppUserDTO appUserDTO = new AppUserDTO();
		appUserDTO = modelMapper.map(appUser, AppUserDTO.class);
		return appUserDTO;
	}

	@Override
	public CompanyDTO companyConvertToCompanyDTO(Company company) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO = modelMapper.map(company, CompanyDTO.class);
		return companyDTO;
	}

	@Override
	public TownDTO townConvertToTownDTO(Town town) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		TownDTO townDTO = new TownDTO();
		townDTO = modelMapper.map(town, TownDTO.class);
		return townDTO;
	}

	@Override
	public AppRole appRoleDTOConvertToAppRole(AppRoleDTO appRoleDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		AppRole appRole = new AppRole();
		appRole = modelMapper.map(appRoleDTO, AppRole.class);
		return appRole;
	}

	@Override
	public AppUser appUserDTOConvertToAppUser(SaveAppUserDTO appUserDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		AppUser appUser = new AppUser();
		appUser = modelMapper.map(appUserDTO, AppUser.class);
		return appUser;
	}

	@Override
	public Company companyDTOConvertToCompany(CompanyDTO companyDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Company company = new Company();
		company = modelMapper.map(companyDTO, Company.class);
		return company;
	}

	@Override
	public Town townDTOConvertToTown(TownDTO townDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Town town = new Town();
		town = modelMapper.map(townDTO, Town.class);
		return town;
	}

	@Override
	public ConfigurationDTO configurationConvertToConfigurationDTO(Configuration configuration) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ConfigurationDTO configurationDTO = new ConfigurationDTO();
		configurationDTO = modelMapper.map(configuration, ConfigurationDTO.class);
		return configurationDTO;
	}

	@Override
	public Configuration configurationDTOConvertToConfiguration(ConfigurationDTO configurationDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Configuration configuration = new Configuration();
		configuration = modelMapper.map(configurationDTO, Configuration.class);
		return configuration;
	}

	@Override
	public SocialLinkDTO socialLinkConvertToSocialLinkDTO(SocialLink socialLink) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		SocialLinkDTO socialLinkDTO = new SocialLinkDTO();
		socialLinkDTO = modelMapper.map(socialLink, SocialLinkDTO.class);
		return socialLinkDTO;
	}

	@Override
	public MotificationDTO motificationConvertToMotificationDTO(Motification motification) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		MotificationDTO motificationDTO = new MotificationDTO();
		motificationDTO = modelMapper.map(motification, MotificationDTO.class);
		return motificationDTO;
	}

	@Override
	public ActionnaireDTO actionnaireConvertToActionnaireDTO(Actionnaire actionnaire) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ActionnaireDTO actionnaireDTO = new ActionnaireDTO();
		actionnaireDTO = modelMapper.map(actionnaire, ActionnaireDTO.class);
		return actionnaireDTO;
	}

	@Override
	public EmployeDTO employeConvertToEmployeDTO(Employe employe) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		EmployeDTO employeDTO = new EmployeDTO();
		employeDTO = modelMapper.map(employe, EmployeDTO.class);
		return employeDTO;
	}

	@Override
	public ClientDTO clientConvertToClientDTO(Client client) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ClientDTO clientDTO = new ClientDTO();
		clientDTO = modelMapper.map(client, ClientDTO.class);
		return clientDTO;
	}

	@Override
	public PaidDTO PaidConvertToPaidDTO(Paid paid) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		PaidDTO paidDTO = new PaidDTO();
		paidDTO = modelMapper.map(paid, PaidDTO.class);
		return paidDTO;
	}

	@Override
	public DividendDTO dividendConvertToDividendDTO(Dividend dividend) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		DividendDTO dividendDTO = new DividendDTO();
		dividendDTO = modelMapper.map(dividend, DividendDTO.class);
		return dividendDTO;
	}

	@Override
	public SocialLink socialLinkDTOConvertToSocialLink(SocialLinkDTO socialLinkDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		SocialLink socialLink = new SocialLink();
		socialLink = modelMapper.map(socialLinkDTO, SocialLink.class);
		return socialLink;
	}

	@Override
	public Motification motificationDTOConvertToMotification(MotificationDTO motificationDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Motification motification = new Motification();
		motification = modelMapper.map(motificationDTO, Motification.class);
		return motification;
	}

	@Override
	public Actionnaire actionnaireDTOConvertToActionnaire(ActionnaireDTO actionnaireDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Actionnaire actionnaire = new Actionnaire();
		actionnaire = modelMapper.map(actionnaireDTO, Actionnaire.class);
		return actionnaire;
	}

	@Override
	public Employe employeDTOConvertToEmploye(EmployeDTO employeDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Employe employe = new Employe();
		employe = modelMapper.map(employeDTO, Employe.class);
		return employe;
	}

	@Override
	public Client clientDTOConvertToClient(ClientDTO clientDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Client client = new Client();
		client = modelMapper.map(clientDTO, Client.class);
		return client;
	}

	@Override
	public Paid PaidDTOConvertToPaid(PaidDTO paidDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Paid paid = new Paid();
		paid = modelMapper.map(paidDTO, Paid.class);
		return paid;
	}

	@Override
	public Dividend dividendDTOConvertToDividend(DividendDTO dividendDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Dividend dividend = new Dividend();
		dividend = modelMapper.map(dividendDTO, Dividend.class);
		return dividend;
	}

}
