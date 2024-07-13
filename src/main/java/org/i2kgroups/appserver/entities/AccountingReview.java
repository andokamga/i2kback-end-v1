package org.i2kgroups.appserver.entities;

import org.i2kgroups.appserver.enums.EnumHeritage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class AccountingReview {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Accounting accounting;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Review review;
	private double solde;
    @Enumerated(EnumType.STRING)
	private EnumHeritage Patrimoine ;

}
