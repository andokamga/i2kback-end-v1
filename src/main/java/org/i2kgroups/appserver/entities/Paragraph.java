package org.i2kgroups.appserver.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPEP",length = 16)
public class Paragraph {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long productId;
	private Long companyId;
	private int level; 
	@Column(length =20)
	private String title;
	@OneToOne(mappedBy = "paragraph")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Product product;
	@OneToOne(mappedBy = "paragraph")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Company company;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	Paragraph paragraph;

}
