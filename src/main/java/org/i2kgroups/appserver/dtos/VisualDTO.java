package org.i2kgroups.appserver.dtos;

import org.i2kgroups.appserver.enums.EnumVisualType;

import lombok.Data;

@Data
public class VisualDTO {

	private Long id;
	private String name;
	private String visualName;
	private EnumVisualType visual;
}

