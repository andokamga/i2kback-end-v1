package org.i2kgroups.appserver.entities;

import java.util.ArrayList;
import java.util.List;

import org.i2kgroups.appserver.enums.EnumDevise;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Company {
  
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long underTownId;
	@Column(unique = true, length =50,nullable = false)
	private String name;
	private double longitude, latitude,attitude;
	private double actionPrix;
	private int maxAtion;
    @Enumerated(EnumType.STRING)
	private EnumDevise devise;
	@Column(length =10)
	private String logolink;
	@Column(unique = true, length =20)
	private String phoneNumber;
	@Column(unique = true, length =50)
	private String email;
	private boolean active;
	private boolean pubActive;
	@ManyToOne
	private Town town;
	@OneToOne(mappedBy = "company")
	private Visual visual;
	@Default
	@ManyToMany(fetch = FetchType.EAGER)
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<AppUser> users=new ArrayList<>();
	@OneToOne(cascade = CascadeType.REMOVE)
	private Paragraph paragraph;
	@Default
	@OneToMany(mappedBy = "company",cascade = CascadeType.REMOVE)
	private List<SocialLink> socialLinks  = new ArrayList<>();
	@Default
	@OneToMany(mappedBy = "company",cascade = CascadeType.REMOVE)
	private List<Dividend> dividends = new ArrayList<>();
}
