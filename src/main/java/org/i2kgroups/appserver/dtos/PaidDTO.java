package org.i2kgroups.appserver.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class PaidDTO {
	private Long id;
	private double amount;
	private Date createAt;
	private String motivatePayment;
	private String workDescription;
	private boolean valide;
}
