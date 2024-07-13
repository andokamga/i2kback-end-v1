package org.i2kgroups.appserver.entities;

import java.util.Date;

import org.i2kgroups.appserver.enums.EnumDivident;

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
public class Dividend {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double amountByDividend;
	private Date createAt;
	private EnumDivident status;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Actionnaire Actionnaire;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Company company;
}
