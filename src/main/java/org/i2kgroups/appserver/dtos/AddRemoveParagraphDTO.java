package org.i2kgroups.appserver.dtos;

import java.util.List;

import org.i2kgroups.appserver.enums.EnumAction;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class AddRemoveParagraphDTO {
	private Long productId;
	private Long companyId;
	private Long paragraphId;
	@Enumerated(EnumType.STRING)
	private EnumAction action;
	private List<ParagraphDTO> ParagraphsDTO;
	private List<TextDTO> textsDTO;
	private List<VisualDTO> visualsDTO;
}
