package org.i2kgroups.appserver.entities;

import java.util.Date;

import org.i2kgroups.appserver.enums.EnumDiscount;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class ItemProduct {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double reductionPrice;
	private Date createAt;
	@ManyToOne
	private Product product;
	private EnumDiscount reduction;
	private int quatity;
	private boolean billing;
	private double total;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private ClientBill clientBill;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private DailyReport dailyReport;
	
}
