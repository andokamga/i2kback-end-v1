package org.i2kgroups.appserver.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class Configuration {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date createAt;
	private boolean activeVersion;
	private Date updateLine;
	private String version;
	private String userDataLink;
	private String productDataLink;
	private String companyDataLink;

}
