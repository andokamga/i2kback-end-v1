package org.i2kgroups.appserver.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Operation {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Long companyId;
	@Column(nullable = false)
	private Long userId;
	private Date operationDate;
	private boolean sendOperation;
	@Default
	@OneToMany(mappedBy = "operation",cascade = CascadeType.REMOVE)
	private List<AccountingOperation> accountingOperation = new ArrayList<>();
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Balance balance;
	

}
