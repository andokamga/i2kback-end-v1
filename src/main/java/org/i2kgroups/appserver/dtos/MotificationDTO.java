package org.i2kgroups.appserver.dtos;

import java.util.Date;

import org.i2kgroups.appserver.enums.EnumModificationType;

import lombok.Data;

@Data
public class MotificationDTO {
	private Long id;
	private Long emetorId;
	private Long modificationId;
	private Date date;
	private String description;
	private boolean view;
	private EnumModificationType type;
}
