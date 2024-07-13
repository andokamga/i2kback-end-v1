package org.i2kgroups.appserver.dtos;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data 
public class DailyReportDTO {

	private Long id;
	private Long companyId;
	private Long userId;
	private Date createAt;
	private boolean sendReport;
	private double totaux;
	private double creance;
	private List<ItemProductDTO> itemProductsDTO;
	private List< ClientBillDTO> clientBillsDTO;
}
