package org.i2kgroups.appserver.entities;

import org.i2kgroups.appserver.enums.EnumVisualType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class Visual {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length =50)
	private String name;
	@Column(length =50)
	private String visualName;
    @Enumerated(EnumType.STRING)
	private EnumVisualType visual;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Text text;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Product product;
	@OneToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Company company;
}
