package org.i2kgroups.appserver.dtos;


import org.i2kgroups.appserver.enums.EnumParagraphType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class ParagraphDTO {

	protected Long id;
	@Enumerated(EnumType.STRING)
	protected EnumParagraphType typep;
	protected int level; 
	protected String title;
	//private ParagraphDTO paragraphDTO;

}
