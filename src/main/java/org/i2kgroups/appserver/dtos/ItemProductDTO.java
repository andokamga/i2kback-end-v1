package org.i2kgroups.appserver.dtos;

import java.util.Date;

import org.i2kgroups.appserver.enums.EnumDiscount;

import lombok.Data;

@Data 
public class ItemProductDTO {

	private Long id;
	private double reductionPrice;
	private Date createAt;
	private ProductDTO productDTO;
	private EnumDiscount reduction;
	private int quatity;
	private boolean billing;
	private double total;
}
