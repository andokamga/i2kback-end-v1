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
public class Balance {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Long companyId;
	private Date BilanDate;
	private boolean sendReview;
	@Default
	@OneToMany(mappedBy = "balance",cascade = CascadeType.REMOVE)
	private List<AccountingBalance> accountingBalance = new ArrayList<>();
	private double totaux;

}
