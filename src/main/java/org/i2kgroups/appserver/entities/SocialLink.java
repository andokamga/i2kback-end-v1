package org.i2kgroups.appserver.entities;

import org.i2kgroups.appserver.enums.EnumSocialLink;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class SocialLink {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Enumerated(EnumType.STRING)
	private EnumSocialLink name;
	@Column(unique = true, length =150,nullable = false)
	private String link;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Company company;

}
