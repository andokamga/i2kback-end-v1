package org.i2kgroups.appserver.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ParagraphListDTO extends ParagraphDTO{
	public List<ParagraphDTO> paragraphsDTO=new ArrayList<>();
	public ParagraphDTO addChild(ParagraphDTO paragraph){
		this.paragraphsDTO.add(paragraph);
		return paragraph;
	}
}
