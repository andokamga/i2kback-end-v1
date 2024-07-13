package org.i2kgroups.appserver.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;


import org.i2kgroups.appserver.enums.EnumRole;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity 
@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class AppRole {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, length =20,nullable = false)
    @Enumerated(EnumType.STRING)
	private EnumRole name;
	private boolean active;
	@ManyToMany(fetch = FetchType.EAGER)
	@Default
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<AppUser> users = new ArrayList<>();

}
