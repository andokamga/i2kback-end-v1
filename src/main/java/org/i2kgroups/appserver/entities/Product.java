package org.i2kgroups.appserver.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.i2kgroups.appserver.enums.EnumDevise;
import org.i2kgroups.appserver.enums.EnumTypeProduct;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Long companyId;
	@Column(length =100)
	private String name;
	private int quantity;
	private int remise;
	private int ristoune;
	private int rabais;
	private double minPrice;
	private double maxPrice;
	private Date createAt;
	private boolean reduction;
	private boolean active;
	private boolean pubActive;
    @Enumerated(EnumType.STRING)
	private EnumTypeProduct type;
    @Enumerated(EnumType.STRING)
	private EnumDevise devise;
	@ManyToOne
	private Category category;
	@OneToOne(cascade = CascadeType.REMOVE)
	private Paragraph paragraph;
	@Default
	@OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
	@JsonProperty(access = Access.WRITE_ONLY)
	private List< ItemProduct> itemProducts  = new ArrayList<>();
	@Default
	@OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
	private List<Visual> visuals  = new ArrayList<>();

}
