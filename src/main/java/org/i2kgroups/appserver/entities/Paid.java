package org.i2kgroups.appserver.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
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
public class Paid {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double amount;
	private Date createAt;
	@Column(length =100)
	private String motivatePayment;
	@Column(length =100)
	private String workDescription;
	private boolean valide;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Employe employe;
}
