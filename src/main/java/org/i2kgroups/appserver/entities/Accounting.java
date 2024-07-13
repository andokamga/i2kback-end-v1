package org.i2kgroups.appserver.entities;

import java.util.ArrayList;
import java.util.List;

import org.i2kgroups.appserver.enums.EnumAccounting;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Accounting {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private int accountingNumber;
	@Column(length =50,nullable = true)
	private String name;
    @Enumerated(EnumType.STRING)
	private EnumAccounting grouping;
	@OneToMany(mappedBy = "accounting")
	@Default
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<AccountingReview> accountingReview = new ArrayList<>();
	@OneToMany(mappedBy = "accounting")
	@Default
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<AccountingOperation> accountingOperation = new ArrayList<>();
	@Default
	@OneToMany(mappedBy = "accounting")
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<AccountingBalance> accountingBalance = new ArrayList<>();

}
