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

public interface ICompanyMapper {
	
	public AppRoleDTO appRoleConvertToAppRoleDTO(AppRole appRole);
	public AppUserDTO appUserConvertToAppUserDTO(AppUser appUser);
	public CompanyDTO companyConvertToCompanyDTO(Company company);
	public TownDTO townConvertToTownDTO(Town town);
	public ConfigurationDTO configurationConvertToConfigurationDTO(Configuration Configuration);
	public SocialLinkDTO socialLinkConvertToSocialLinkDTO(SocialLink socialLink);
	public MotificationDTO motificationConvertToMotificationDTO(Motification motification);
	public ActionnaireDTO actionnaireConvertToActionnaireDTO(Actionnaire actionnaire);
	public EmployeDTO employeConvertToEmployeDTO(Employe employe);
	public ClientDTO clientConvertToClientDTO(Client client);
	public PaidDTO PaidConvertToPaidDTO(Paid paid);
	public DividendDTO dividendConvertToDividendDTO(Dividend dividend);
	public AppRole appRoleDTOConvertToAppRole(AppRoleDTO appRoleDTO);
	public AppUser appUserDTOConvertToAppUser(SaveAppUserDTO appUserDTO);
	public Company companyDTOConvertToCompany(CompanyDTO company);
	public Town townDTOConvertToTown(TownDTO townDTO);
	public Configuration configurationDTOConvertToConfiguration(ConfigurationDTO ConfigurationDTO);
	public SocialLink socialLinkDTOConvertToSocialLink(SocialLinkDTO socialLinkDTO);
	public Motification motificationDTOConvertToMotification(MotificationDTO motificationDTO);
	public Actionnaire actionnaireDTOConvertToActionnaire(ActionnaireDTO actionnaireDTO);
	public Employe employeDTOConvertToEmploye(EmployeDTO employeDTO);
	public Client clientDTOConvertToClient(ClientDTO clientDTO);
	public Paid PaidDTOConvertToPaid(PaidDTO paidDTO);
	public Dividend dividendDTOConvertToDividend(DividendDTO dividendDTO);

}
