package org.i2kgroups.appserver.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@Entity
@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class Review {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Long companyId;
	private Date reviewDate;
	@Default
	@OneToMany(mappedBy = "review",cascade = CascadeType.REMOVE)
	private List<AccountingReview> accountingReview = new ArrayList<>();
	private double result;
	private double netSituation;
	private boolean last;
	private double activeTotaux;
	private double passiveTotaux;
	private double capital;
	private double dette;
}
