package org.i2kgroups.appserver.dtos;

import java.util.List;

import lombok.Data;

@Data
public class SaveOperationDTO {

	private Long userId;
	private Long companyId;
	private List<ItemProductDTO> ItemProductDTO;

}
