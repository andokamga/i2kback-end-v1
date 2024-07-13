package org.i2kgroups.appserver.dtos;

import java.util.List;

import lombok.Data;

@Data
public class AddRemoveDividendDTO {
	List<ActionnaireDTO> actionnairesDTO;
	List<DividendDTO> DividendsDTO;
}
