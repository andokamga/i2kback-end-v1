package org.i2kgroups.appserver.entities;

import java.util.Date;

import org.i2kgroups.appserver.enums.EnumModificationType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Motification {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long emetorId;
	private Long modificationId;
	private Date date;
	@Column(length =100)
	private String description;
	private boolean view;
	private EnumModificationType type;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private AppUser user;
}
