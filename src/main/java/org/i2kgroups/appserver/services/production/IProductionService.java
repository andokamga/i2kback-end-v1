package org.i2kgroups.appserver.services.production;

import org.i2kgroups.appserver.dtos.ActionnaireDTO;
import org.i2kgroups.appserver.dtos.AddRemoveItemDailyWorkDTO;
import org.i2kgroups.appserver.dtos.AddRemovePaidUser;
import org.i2kgroups.appserver.dtos.CategoryDTO;
import org.i2kgroups.appserver.dtos.ClientDTO;
import org.i2kgroups.appserver.dtos.DailyReportDTO;
import org.i2kgroups.appserver.dtos.DividendDTO;
import org.i2kgroups.appserver.dtos.EmployeDTO;
import org.i2kgroups.appserver.dtos.PaidDTO;
import org.i2kgroups.appserver.dtos.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IProductionService {
	
	public ProductDTO addUpdateProduct(ProductDTO product);
	public CategoryDTO addUpdateCategory(CategoryDTO category);
	public Page<ProductDTO> allCompanyProduct(Long companyId, PageRequest page);
	public Page<ProductDTO> allCompanyService(Long companyId, PageRequest page);
	public Page<CategoryDTO> allCategory(PageRequest page);
	public Page<ProductDTO> findCompanyProduct(Long companyId, String name, PageRequest page);
	public Page<CategoryDTO> findCompanyCategory(String name, PageRequest page);
	public boolean deleteProduct(Long productId);
	public boolean deleteCategory(Long category);	
	public ClientDTO addUpdateClient(ClientDTO clientDTO);
	public EmployeDTO addUpdateEmploye(EmployeDTO employeDTO);
	public ActionnaireDTO addUpdateActionnaire(ActionnaireDTO actionnaireDTO);
	public DailyReportDTO addUpdateCompanyDailyReport(DailyReportDTO dailyWorkDTO);
	public DailyReportDTO addRemoveItemToDailyReport(AddRemoveItemDailyWorkDTO dailyWorkDTO);
	public Page<PaidDTO> addRemoveCompanyPaid(AddRemovePaidUser paidUser,PageRequest page);
	public DividendDTO addUpdateDividend(DividendDTO dividendDTO);
	public Page<DividendDTO> allCompanyDividend(Long companyId, PageRequest page);
	public Page<ClientDTO> allCompanyClient(Long companyId, PageRequest page);
	public Page<EmployeDTO> allCompanyEmploye(Long companyId, PageRequest page);
	public Page<ActionnaireDTO> allCompanyActionnaire(Long companyId, PageRequest page);
	public Page<DailyReportDTO> allCompanyCompanyDailyReport(Long companyId,PageRequest page);
	public boolean deleteDividend(Long dividendtId);
	public boolean deleteClient(Long clientId);
	public boolean deleteEmploye(Long employeId);
	public boolean deleteActionnaire(Long actionnaireId);

}
