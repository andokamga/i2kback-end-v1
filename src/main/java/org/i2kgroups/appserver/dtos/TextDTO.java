package org.i2kgroups.appserver.dtos;

import java.util.ArrayList;
import java.util.List;
import org.i2kgroups.appserver.enums.EnumParagraph;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class TextDTO extends ParagraphDTO{
	private String description;
	private EnumParagraph type;
	private List<VisualDTO> visualsDTO = new ArrayList<>();
}
