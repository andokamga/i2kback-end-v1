package org.i2kgroups.appserver.dtos;

import java.util.Date;

import org.i2kgroups.appserver.enums.EnumDivident;

import lombok.Data;

@Data
public class DividendDTO {
	private Long id;
	private double amountByDividend;
	private Date createAt;
	private EnumDivident status;
}
