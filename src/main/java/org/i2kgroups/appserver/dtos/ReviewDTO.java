package org.i2kgroups.appserver.dtos;

import java.util.Date;
import java.util.List;



import lombok.Data;

@Data
public class ReviewDTO {

	private Long id;
	private Long companyId;
	private Date reviewDate;
	private List<AccountingReviewDTO> accountingReviewDTO;
	private double result;
	private double netSituation;
	private boolean last;
	private double activeTotaux;
	private double passiveTotaux;
	private double capital;
	private double dette;
}
