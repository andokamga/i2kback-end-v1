package org.i2kgroups.appserver.services.company;

import org.i2kgroups.appserver.dtos.AddRemoveCompanyDTO;
import org.i2kgroups.appserver.dtos.AddRemoveParagraphDTO;
import org.i2kgroups.appserver.dtos.AddRemoveRoleDTO;
import org.i2kgroups.appserver.dtos.AddRemoveUnderTown;
import org.i2kgroups.appserver.dtos.AppRoleDTO;
import org.i2kgroups.appserver.dtos.AppUserDTO;
import org.i2kgroups.appserver.dtos.CompanyDTO;
import org.i2kgroups.appserver.dtos.SaveAppUserDTO;
import org.i2kgroups.appserver.dtos.TownDTO;
import org.i2kgroups.appserver.enums.EnumVisualType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

public interface ICompanyService {

	public TownDTO addUpdateTown(TownDTO town);
	public TownDTO addRemoveUnderTown(AddRemoveUnderTown underTown);
	public CompanyDTO addUpdateCompany(CompanyDTO company);
	public CompanyDTO addRemoveParagraphCompany(AddRemoveParagraphDTO paragraph);
	public AppUserDTO addRemoveRoleToUser(AddRemoveRoleDTO userRole);
	public AppUserDTO addRemoveCompanyToUser(AddRemoveCompanyDTO userCompany);
	public AppUserDTO addUpdateUser(SaveAppUserDTO user);
	public AppUserDTO findAppUser(String username);
	public Page<TownDTO> allTown(PageRequest page);
	public Page<CompanyDTO> allCompany(PageRequest page);
	public Page<AppUserDTO> allUser(PageRequest page);
	public Page<AppRoleDTO> allRole(PageRequest page);
	public Page<TownDTO> findTown(String town, PageRequest page);
	public Page<CompanyDTO> findCompany(String company, PageRequest page);
	public Page<AppUserDTO> findUser(String name,PageRequest page);
	public Page<AppRoleDTO> findRole(String name, PageRequest page);
	public boolean deleteTown(Long townId);
	public boolean CompanyTown(Long companyId);
	
}
