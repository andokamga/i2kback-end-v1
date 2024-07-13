package org.i2kgroups.appserver.dtos;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class TownDTO {

	private Long id;
	@NotBlank(message = "Town level shouldn't be blank")
	private Long level;
	private String name;
	private List<TownDTO> underTownsDTO=new ArrayList<>();
}
