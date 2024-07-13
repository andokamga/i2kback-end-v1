package org.i2kgroups.appserver.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;;

@Entity 
@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class Town {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int level;
	@Column(unique = true, length =50,nullable = false)
	private String name;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Town town;
	@Default
	@OneToMany(mappedBy = "town",cascade = CascadeType.REMOVE)
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Town> underTowns  = new ArrayList<>();
	@Default
	@ManyToMany(mappedBy = "town",fetch = FetchType.EAGER)
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Company> Company=new ArrayList<>();

}
