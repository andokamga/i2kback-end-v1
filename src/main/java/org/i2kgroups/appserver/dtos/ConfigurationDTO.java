package org.i2kgroups.appserver.dtos;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ConfigurationDTO {
	private Long id;
	private Date createAt;
	private boolean activeVersion;
	private Date updateLine;
	@NotBlank(message = "company Id shouldn't be blank")
	@Min(value = 0,message = "company Id must be positive")
	@NotNull(message = "company Id shouldn't be null")
	private String version;
	private String userDataLink;
	private String productDataLink;
	private String companyDataLink;
}
