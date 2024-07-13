package org.i2kgroups.appserver.dtos;

import lombok.Data;

@Data
public class RequestBodyDTO {
	private Long companyId;
	private int page;
	private int size;
	private String search;
}
